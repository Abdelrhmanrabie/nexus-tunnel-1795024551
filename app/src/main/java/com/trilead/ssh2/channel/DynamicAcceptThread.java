package com.trilead.ssh2.channel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.connectbot.simplesocks.Socks5Server;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DynamicAcceptThread extends Thread implements IChannelWorkerThread {
    private ChannelManager cm;
    private ServerSocket ss;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class DynamicAcceptRunnable implements Runnable {
        private static final int idleTimeout = 180000;
        private InputStream in;
        private OutputStream out;
        private Socket sock;

        public DynamicAcceptRunnable(Socket socket) {
            this.sock = socket;
            DynamicAcceptThread.this.setName("DynamicAcceptRunnable");
        }

        private void onConnect(Socks5Server socks5Server) throws IOException {
            String hostName = socks5Server.getHostName();
            if (hostName == null) {
                hostName = socks5Server.getAddress().getHostAddress();
            }
            try {
                try {
                    Channel channelOpenDirectTCPIPChannel = DynamicAcceptThread.this.cm.openDirectTCPIPChannel(hostName, socks5Server.getPort(), AppConfig.LOOPBACK, 0);
                    socks5Server.sendReply(Socks5Server.ResponseCode.SUCCESS);
                    StreamForwarder streamForwarder = new StreamForwarder(channelOpenDirectTCPIPChannel, null, this.sock, channelOpenDirectTCPIPChannel.stdoutStream, this.out, "RemoteToLocal");
                    StreamForwarder streamForwarder2 = new StreamForwarder(channelOpenDirectTCPIPChannel, streamForwarder, this.sock, this.in, channelOpenDirectTCPIPChannel.stdinStream, "LocalToRemote");
                    streamForwarder.setDaemon(true);
                    streamForwarder2.setDaemon(true);
                    streamForwarder.start();
                    streamForwarder2.start();
                } catch (IOException unused) {
                    try {
                        this.sock.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException unused3) {
                socks5Server.sendReply(Socks5Server.ResponseCode.GENERAL_FAILURE);
                this.sock.close();
            }
        }

        private void startSession() throws IOException {
            Socks5Server.ResponseCode responseCode;
            this.sock.setSoTimeout(idleTimeout);
            this.in = this.sock.getInputStream();
            OutputStream outputStream = this.sock.getOutputStream();
            this.out = outputStream;
            Socks5Server socks5Server = new Socks5Server(this.in, outputStream);
            try {
                if (!socks5Server.acceptAuthentication() || !socks5Server.readRequest()) {
                    System.out.println("Could not start SOCKS session");
                    return;
                } else {
                    if (socks5Server.getCommand() == Socks5Server.Command.CONNECT) {
                        onConnect(socks5Server);
                        return;
                    }
                    responseCode = Socks5Server.ResponseCode.COMMAND_NOT_SUPPORTED;
                }
            } catch (IOException unused) {
                responseCode = Socks5Server.ResponseCode.GENERAL_FAILURE;
            }
            socks5Server.sendReply(responseCode);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    startSession();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                this.sock.close();
            }
        }
    }

    public DynamicAcceptThread(ChannelManager channelManager, int i) {
        this.cm = channelManager;
        setName("DynamicAcceptThread");
        this.ss = new ServerSocket(i);
    }

    public DynamicAcceptThread(ChannelManager channelManager, InetSocketAddress inetSocketAddress) throws IOException {
        this.cm = channelManager;
        ServerSocket serverSocket = new ServerSocket();
        this.ss = serverSocket;
        serverSocket.bind(inetSocketAddress);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.cm.registerThread(this);
            while (true) {
                try {
                    Thread thread = new Thread(new DynamicAcceptRunnable(this.ss.accept()));
                    thread.setDaemon(true);
                    thread.start();
                } catch (IOException unused) {
                    stopWorking();
                    return;
                }
            }
        } catch (IOException unused2) {
            stopWorking();
        }
    }

    @Override // com.trilead.ssh2.channel.IChannelWorkerThread
    public void stopWorking() {
        try {
            this.ss.close();
        } catch (IOException unused) {
        }
    }
}
