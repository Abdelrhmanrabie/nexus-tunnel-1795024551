package com.trilead.ssh2.transport;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.ConnectionMonitor;
import com.trilead.ssh2.DHGexParameters;
import com.trilead.ssh2.ExtensionInfo;
import com.trilead.ssh2.ProxyData;
import com.trilead.ssh2.ServerHostKeyVerifier;
import com.trilead.ssh2.compression.ICompressor;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.digest.MAC;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketDisconnect;
import com.trilead.ssh2.packets.PacketExtInfo;
import com.trilead.ssh2.packets.TypesReader;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Vector;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TransportManager {
    private static final Logger log = Logger.getLogger(TransportManager.class);
    String hostname;
    KexManager km;
    int port;
    Thread receiveThread;
    Socket sock;
    TransportConnection tc;
    private final Vector<byte[]> asynchronousQueue = new Vector<>();
    private Thread asynchronousThread = null;
    Object connectionSemaphore = new Object();
    boolean flagKexOngoing = false;
    boolean connectionClosed = false;
    Throwable reasonClosedCause = null;
    Vector<HandlerEntry> messageHandlers = new Vector<>();
    Vector connectionMonitors = new Vector();
    boolean monitorsWereInformed = false;
    private volatile ExtensionInfo extensionInfo = ExtensionInfo.noExtInfoSeen();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AsynchronousWorker extends Thread {
        public AsynchronousWorker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            while (true) {
                synchronized (TransportManager.this.asynchronousQueue) {
                    if (TransportManager.this.asynchronousQueue.size() == 0) {
                        try {
                            TransportManager.this.asynchronousQueue.wait(2000L);
                        } catch (InterruptedException unused) {
                        }
                        if (TransportManager.this.asynchronousQueue.size() == 0) {
                            TransportManager.this.asynchronousThread = null;
                            return;
                        }
                    }
                    bArr = (byte[]) TransportManager.this.asynchronousQueue.remove(0);
                }
                try {
                    TransportManager.this.sendMessage(bArr);
                } catch (IOException unused2) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class HandlerEntry {
        int high;
        int low;
        MessageHandler mh;

        public HandlerEntry() {
        }
    }

    public TransportManager(String str, int i) {
        this.hostname = str;
        this.port = i;
    }

    private static Socket connectDirect(String str, int i, int i2) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getByName(str), i), i2);
        socket.setSoTimeout(0);
        return socket;
    }

    private void establishConnection(ProxyData proxyData, int i) {
        String str = this.hostname;
        int i2 = this.port;
        this.sock = proxyData == null ? connectDirect(str, i2, i) : proxyData.openConnection(str, i2, i);
    }

    public void changeRecvCipher(BlockCipher blockCipher, MAC mac) {
        this.tc.changeRecvCipher(blockCipher, mac);
    }

    public void changeRecvCompression(ICompressor iCompressor) {
        this.tc.changeRecvCompression(iCompressor);
    }

    public void changeSendCipher(BlockCipher blockCipher, MAC mac) {
        this.tc.changeSendCipher(blockCipher, mac);
    }

    public void changeSendCompression(ICompressor iCompressor) {
        this.tc.changeSendCompression(iCompressor);
    }

    public void close(Throwable th, boolean z) {
        Vector vector;
        if (!z) {
            try {
                Socket socket = this.sock;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException unused) {
            }
        }
        synchronized (this.connectionSemaphore) {
            if (!this.connectionClosed) {
                if (z) {
                    try {
                        byte[] payload = new PacketDisconnect(11, th.getMessage(), AppConfig.CUSTOM).getPayload();
                        TransportConnection transportConnection = this.tc;
                        if (transportConnection != null) {
                            transportConnection.sendMessage(payload);
                        }
                    } catch (IOException unused2) {
                    }
                    try {
                        Socket socket2 = this.sock;
                        if (socket2 != null) {
                            socket2.close();
                        }
                    } catch (IOException unused3) {
                    }
                }
                this.connectionClosed = true;
                this.reasonClosedCause = th;
            }
            this.connectionSemaphore.notifyAll();
        }
        synchronized (this) {
            try {
                if (this.monitorsWereInformed) {
                    vector = null;
                } else {
                    this.monitorsWereInformed = true;
                    vector = (Vector) this.connectionMonitors.clone();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                try {
                    ((ConnectionMonitor) vector.elementAt(i)).connectionLost(this.reasonClosedCause);
                } catch (Exception unused4) {
                }
            }
        }
    }

    public void forceKeyExchange(CryptoWishList cryptoWishList, DHGexParameters dHGexParameters) {
        this.km.initiateKEX(cryptoWishList, dHGexParameters);
    }

    public ConnectionInfo getConnectionInfo(int i) {
        return this.km.getOrWaitForConnectionInfo(i);
    }

    public ExtensionInfo getExtensionInfo() {
        return this.extensionInfo;
    }

    public int getPacketOverheadEstimate() {
        return this.tc.getPacketOverheadEstimate();
    }

    public Throwable getReasonClosedCause() {
        Throwable th;
        synchronized (this.connectionSemaphore) {
            th = this.reasonClosedCause;
        }
        return th;
    }

    public byte[] getSessionIdentifier() {
        return this.km.sessionId;
    }

    public void initialize(CryptoWishList cryptoWishList, ServerHostKeyVerifier serverHostKeyVerifier, DHGexParameters dHGexParameters, int i, SecureRandom secureRandom, ProxyData proxyData) {
        establishConnection(proxyData, i);
        ClientServerHello clientServerHello = new ClientServerHello(this.sock.getInputStream(), this.sock.getOutputStream());
        this.tc = new TransportConnection(this.sock.getInputStream(), this.sock.getOutputStream(), secureRandom);
        KexManager kexManager = new KexManager(this, clientServerHello, cryptoWishList, this.hostname, this.port, serverHostKeyVerifier, secureRandom);
        this.km = kexManager;
        kexManager.initiateKEX(cryptoWishList, dHGexParameters);
        Thread thread = new Thread(new Runnable() { // from class: com.trilead.ssh2.transport.TransportManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TransportManager.this.receiveLoop();
                } catch (IOException e) {
                    TransportManager.this.close(e, false);
                    if (TransportManager.log.isEnabled()) {
                        TransportManager.log.log(10, "Receive thread: error in receiveLoop: " + e.getMessage());
                    }
                }
                if (TransportManager.log.isEnabled()) {
                    TransportManager.log.log(50, "Receive thread: back from receiveLoop");
                }
                KexManager kexManager2 = TransportManager.this.km;
                if (kexManager2 != null) {
                    try {
                        kexManager2.handleMessage(null, 0);
                    } catch (IOException unused) {
                    }
                }
                for (int i2 = 0; i2 < TransportManager.this.messageHandlers.size(); i2++) {
                    try {
                        TransportManager.this.messageHandlers.elementAt(i2).mh.handleMessage(null, 0);
                    } catch (Exception unused2) {
                    }
                }
            }
        });
        this.receiveThread = thread;
        thread.setDaemon(true);
        this.receiveThread.start();
    }

    public void kexFinished() {
        synchronized (this.connectionSemaphore) {
            this.flagKexOngoing = false;
            this.connectionSemaphore.notifyAll();
        }
    }

    public void receiveLoop() throws IOException {
        MessageHandler messageHandler;
        byte[] bArr = new byte[35004];
        while (true) {
            int i = 0;
            int iReceiveMessage = this.tc.receiveMessage(bArr, 0, 35004);
            int i2 = bArr[0] & GZIPHeader.OS_UNKNOWN;
            if (i2 != 2) {
                if (i2 == 4) {
                    if (log.isEnabled()) {
                        TypesReader typesReader = new TypesReader(bArr, 0, iReceiveMessage);
                        typesReader.readByte();
                        typesReader.readBoolean();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(typesReader.readString("UTF-8"));
                        while (i < stringBuffer.length()) {
                            char cCharAt = stringBuffer.charAt(i);
                            if (cCharAt < ' ' || cCharAt > '~') {
                                stringBuffer.setCharAt(i, (char) 65533);
                            }
                            i++;
                        }
                        log.log(50, "DEBUG Message from remote: '" + stringBuffer.toString() + "'");
                    }
                } else {
                    if (i2 == 3) {
                        throw new IOException("Peer sent UNIMPLEMENTED message, that should not happen.");
                    }
                    if (i2 == 1) {
                        TypesReader typesReader2 = new TypesReader(bArr, 0, iReceiveMessage);
                        typesReader2.readByte();
                        int uint32 = typesReader2.readUINT32();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(typesReader2.readString("UTF-8"));
                        if (stringBuffer2.length() > 255) {
                            stringBuffer2.setLength(255);
                            stringBuffer2.setCharAt(254, '.');
                            stringBuffer2.setCharAt(253, '.');
                            stringBuffer2.setCharAt(252, '.');
                        }
                        while (i < stringBuffer2.length()) {
                            char cCharAt2 = stringBuffer2.charAt(i);
                            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                                stringBuffer2.setCharAt(i, (char) 65533);
                            }
                            i++;
                        }
                        StringBuilder sbN = ak.n(uint32, "Peer sent DISCONNECT message (reason code ", "): ");
                        sbN.append(stringBuffer2.toString());
                        throw new IOException(sbN.toString());
                    }
                    if (i2 == 20 || i2 == 21 || (i2 >= 30 && i2 <= 49)) {
                        this.km.handleMessage(bArr, iReceiveMessage);
                    } else {
                        if (i2 == 52) {
                            this.tc.startCompression();
                        }
                        if (i2 == 7) {
                            this.extensionInfo = ExtensionInfo.fromPacketExtInfo(new PacketExtInfo(bArr, 0, iReceiveMessage));
                        } else {
                            while (true) {
                                if (i >= this.messageHandlers.size()) {
                                    messageHandler = null;
                                    break;
                                }
                                HandlerEntry handlerEntryElementAt = this.messageHandlers.elementAt(i);
                                if (handlerEntryElementAt.low <= i2 && i2 <= handlerEntryElementAt.high) {
                                    messageHandler = handlerEntryElementAt.mh;
                                    break;
                                }
                                i++;
                            }
                            if (messageHandler == null) {
                                throw new IOException(e.i(i2, "Unexpected SSH message (type ", ")"));
                            }
                            messageHandler.handleMessage(bArr, iReceiveMessage);
                        }
                    }
                }
            }
        }
    }

    public void registerMessageHandler(MessageHandler messageHandler, int i, int i2) {
        HandlerEntry handlerEntry = new HandlerEntry();
        handlerEntry.mh = messageHandler;
        handlerEntry.low = i;
        handlerEntry.high = i2;
        synchronized (this.messageHandlers) {
            this.messageHandlers.addElement(handlerEntry);
        }
    }

    public void removeMessageHandler(MessageHandler messageHandler, int i, int i2) {
        synchronized (this.messageHandlers) {
            for (int i3 = 0; i3 < this.messageHandlers.size(); i3++) {
                try {
                    HandlerEntry handlerEntryElementAt = this.messageHandlers.elementAt(i3);
                    if (handlerEntryElementAt.mh == messageHandler && handlerEntryElementAt.low == i && handlerEntryElementAt.high == i2) {
                        this.messageHandlers.removeElementAt(i3);
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void sendAsynchronousMessage(byte[] bArr) {
        synchronized (this.asynchronousQueue) {
            try {
                this.asynchronousQueue.addElement(bArr);
                if (this.asynchronousQueue.size() > 100) {
                    throw new IOException("Error: the peer is not consuming our asynchronous replies.");
                }
                if (this.asynchronousThread == null) {
                    AsynchronousWorker asynchronousWorker = new AsynchronousWorker();
                    this.asynchronousThread = asynchronousWorker;
                    asynchronousWorker.setDaemon(true);
                    this.asynchronousThread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendKexMessage(byte[] bArr) {
        synchronized (this.connectionSemaphore) {
            try {
                if (this.connectionClosed) {
                    throw new IOException("Sorry, this connection is closed.", this.reasonClosedCause);
                }
                this.flagKexOngoing = true;
                try {
                    this.tc.sendMessage(bArr);
                } catch (IOException e) {
                    close(e, false);
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendMessage(byte[] bArr) {
        if (Thread.currentThread() == this.receiveThread) {
            d.AnonymousClass0.m$6("Assertion error: sendMessage may never be invoked by the receiver thread!");
            return;
        }
        synchronized (this.connectionSemaphore) {
            while (!this.connectionClosed) {
                try {
                    if (this.flagKexOngoing) {
                        try {
                            this.connectionSemaphore.wait();
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        try {
                            this.tc.sendMessage(bArr);
                        } catch (IOException e) {
                            close(e, false);
                            throw e;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IOException("Sorry, this connection is closed.", this.reasonClosedCause);
        }
    }

    public void setConnectionMonitors(Vector vector) {
        synchronized (this) {
            this.connectionMonitors = (Vector) vector.clone();
        }
    }

    public void startCompression() {
        this.tc.startCompression();
    }
}
