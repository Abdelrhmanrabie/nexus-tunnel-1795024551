package com.trilead.ssh2.channel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class StreamForwarder extends Thread {
    final byte[] buffer = new byte[30000];
    final Channel c;
    final InputStream is;
    final String mode;
    final OutputStream os;
    final Socket s;
    final StreamForwarder sibling;

    public StreamForwarder(Channel channel, StreamForwarder streamForwarder, Socket socket, InputStream inputStream, OutputStream outputStream, String str) {
        this.is = inputStream;
        this.os = outputStream;
        this.mode = str;
        this.c = channel;
        this.sibling = streamForwarder;
        this.s = socket;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Socket socket;
        OutputStream outputStream;
        while (true) {
            try {
                try {
                    int i = this.is.read(this.buffer);
                    outputStream = this.os;
                    if (i <= 0) {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    } else {
                        outputStream.write(this.buffer, 0, i);
                        this.os.flush();
                    }
                } catch (IOException e) {
                    try {
                        Channel channel = this.c;
                        channel.cm.closeChannel(channel, "Closed due to exception in StreamForwarder (" + this.mode + "): " + e.getMessage(), true);
                    } catch (IOException unused2) {
                    }
                    try {
                        this.os.close();
                    } catch (IOException unused3) {
                    }
                    try {
                        this.is.close();
                    } catch (IOException unused4) {
                    }
                    if (this.sibling != null) {
                        while (this.sibling.isAlive()) {
                            try {
                                this.sibling.join();
                            } catch (InterruptedException unused5) {
                            }
                        }
                        try {
                            Channel channel2 = this.c;
                            channel2.cm.closeChannel(channel2, "StreamForwarder (" + this.mode + ") is cleaning up the connection", true);
                        } catch (IOException unused6) {
                        }
                    }
                    socket = this.s;
                    if (socket == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    this.os.close();
                } catch (IOException unused7) {
                }
                try {
                    this.is.close();
                } catch (IOException unused8) {
                }
                if (this.sibling != null) {
                    while (this.sibling.isAlive()) {
                        try {
                            this.sibling.join();
                        } catch (InterruptedException unused9) {
                        }
                    }
                    try {
                        Channel channel3 = this.c;
                        channel3.cm.closeChannel(channel3, "StreamForwarder (" + this.mode + ") is cleaning up the connection", true);
                    } catch (IOException unused10) {
                    }
                }
                Socket socket2 = this.s;
                if (socket2 == null) {
                    throw th;
                }
                try {
                    socket2.close();
                    throw th;
                } catch (IOException unused11) {
                    throw th;
                }
            }
        }
        outputStream.close();
        try {
            this.is.close();
        } catch (IOException unused12) {
        }
        if (this.sibling != null) {
            while (this.sibling.isAlive()) {
                try {
                    this.sibling.join();
                } catch (InterruptedException unused13) {
                }
            }
            try {
                Channel channel4 = this.c;
                channel4.cm.closeChannel(channel4, "StreamForwarder (" + this.mode + ") is cleaning up the connection", true);
            } catch (IOException unused14) {
            }
        }
        socket = this.s;
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException unused15) {
        }
    }
}
