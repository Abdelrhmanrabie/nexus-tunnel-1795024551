package com.trilead.ssh2;

import com.trilead.ssh2.auth.AuthenticationManager;
import com.trilead.ssh2.auth.SignatureProxy;
import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.digest.MACs;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketIgnore;
import com.trilead.ssh2.transport.KexManager;
import com.trilead.ssh2.transport.TransportManager;
import com.trilead.ssh2.util.TimeoutService;
import defpackage.d;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.Vector;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Connection implements AutoCloseable {
    public static final String identification = "TrileadSSH2Java_213";
    private AuthenticationManager am;
    private boolean authenticated;
    private ChannelManager cm;
    private boolean compression;
    private Vector<ConnectionMonitor> connectionMonitors;
    private CryptoWishList cryptoWishList;
    private DHGexParameters dhgexpara;
    private SecureRandom generator;
    private final String hostname;
    private final int port;
    private ProxyData proxyData;
    private TransportManager tm;

    /* JADX INFO: renamed from: com.trilead.ssh2.Connection$1TimeoutState, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class C1TimeoutState {
        boolean isCancelled = false;
        boolean timeoutSocketClosed = false;

        public C1TimeoutState() {
        }
    }

    public Connection(String str) {
        this(str, 22);
    }

    public Connection(String str, int i) {
        this.authenticated = false;
        this.compression = false;
        this.cryptoWishList = new CryptoWishList();
        this.dhgexpara = new DHGexParameters();
        this.proxyData = null;
        this.connectionMonitors = new Vector<>();
        this.hostname = str;
        this.port = i;
    }

    private void checkRequirements(String str) {
        TransportManager transportManager = this.tm;
        if (transportManager == null) {
            d.AnonymousClass0.m("Connection is not established!");
            return;
        }
        if (this.authenticated) {
            d.AnonymousClass0.m("Connection is already authenticated!");
            return;
        }
        if (this.am == null) {
            this.am = new AuthenticationManager(transportManager);
        }
        if (this.cm == null) {
            this.cm = new ChannelManager(this.tm);
        }
        if (str != null) {
            return;
        }
        d.AnonymousClass0.m$2("user argument is null");
    }

    private void close(Throwable th, boolean z) {
        ChannelManager channelManager = this.cm;
        if (channelManager != null) {
            channelManager.closeAllChannels();
        }
        TransportManager transportManager = this.tm;
        if (transportManager != null) {
            transportManager.close(th, !z);
            this.tm = null;
        }
        this.am = null;
        this.cm = null;
        this.authenticated = false;
    }

    public static synchronized String[] getAvailableCiphers() {
        return BlockCipherFactory.getDefaultCipherList();
    }

    public static synchronized String[] getAvailableMACs() {
        return MACs.getMacList();
    }

    public static synchronized String[] getAvailableServerHostKeyAlgorithms() {
        return KexManager.getDefaultServerHostkeyAlgorithmList();
    }

    private final SecureRandom getOrCreateSecureRND() {
        if (this.generator == null) {
            this.generator = new SecureRandom();
        }
        return this.generator;
    }

    private String[] removeDuplicates(String[] strArr) {
        if (strArr == 0 || strArr.length < 2) {
            return strArr;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    strArr2[i] = strArr[i2];
                    i++;
                    break;
                }
                if (str == null) {
                    if (strArr2[i3] == null) {
                        break;
                    }
                    i3++;
                } else {
                    if (str.equals(strArr2[i3])) {
                        break;
                    }
                    i3++;
                }
            }
        }
        if (i == length) {
            return strArr2;
        }
        String[] strArr3 = new String[i];
        System.arraycopy(strArr2, 0, strArr3, 0, i);
        return strArr3;
    }

    public synchronized void addConnectionMonitor(ConnectionMonitor connectionMonitor) {
        try {
            if (connectionMonitor == null) {
                throw new IllegalArgumentException("cmon argument is null");
            }
            this.connectionMonitors.addElement(connectionMonitor);
            TransportManager transportManager = this.tm;
            if (transportManager != null) {
                transportManager.setConnectionMonitors(this.connectionMonitors);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean authenticateWithKeyboardInteractive(String str, InteractiveCallback interactiveCallback) {
        return authenticateWithKeyboardInteractive(str, null, interactiveCallback);
    }

    public synchronized boolean authenticateWithKeyboardInteractive(String str, String[] strArr, InteractiveCallback interactiveCallback) {
        boolean zAuthenticateInteractive;
        try {
            if (interactiveCallback == null) {
                throw new IllegalArgumentException("Callback may not ne NULL!");
            }
            checkRequirements(str);
            zAuthenticateInteractive = this.am.authenticateInteractive(str, strArr, interactiveCallback);
            this.authenticated = zAuthenticateInteractive;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticateInteractive;
    }

    public synchronized boolean authenticateWithNone(String str) {
        boolean zAuthenticateNone;
        checkRequirements(str);
        zAuthenticateNone = this.am.authenticateNone(str);
        this.authenticated = zAuthenticateNone;
        return zAuthenticateNone;
    }

    public synchronized boolean authenticateWithPassword(String str, String str2) {
        boolean zAuthenticatePassword;
        try {
            if (str2 == null) {
                throw new IllegalArgumentException("password argument is null");
            }
            checkRequirements(str);
            zAuthenticatePassword = this.am.authenticatePassword(str, str2);
            this.authenticated = zAuthenticatePassword;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePassword;
    }

    public synchronized boolean authenticateWithPublicKey(String str, SignatureProxy signatureProxy) {
        boolean zAuthenticatePublicKey;
        checkRequirements(str);
        if (signatureProxy.getPublicKey() == null) {
            throw new IllegalArgumentException("Signature manager does not contain a public key.");
        }
        zAuthenticatePublicKey = this.am.authenticatePublicKey(str, signatureProxy);
        this.authenticated = zAuthenticatePublicKey;
        return zAuthenticatePublicKey;
    }

    public synchronized boolean authenticateWithPublicKey(String str, File file, String str2) {
        CharArrayWriter charArrayWriter;
        try {
            if (file == null) {
                throw new IllegalArgumentException("pemFile argument is null");
            }
            char[] cArr = new char[256];
            charArrayWriter = new CharArrayWriter();
            FileReader fileReader = new FileReader(file);
            while (true) {
                int i = fileReader.read(cArr);
                if (i < 0) {
                    fileReader.close();
                } else {
                    charArrayWriter.write(cArr, 0, i);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return authenticateWithPublicKey(str, charArrayWriter.toCharArray(), str2);
    }

    public synchronized boolean authenticateWithPublicKey(String str, KeyPair keyPair) {
        boolean zAuthenticatePublicKey;
        try {
            if (keyPair == null) {
                throw new IllegalArgumentException("Key pair argument is null");
            }
            checkRequirements(str);
            zAuthenticatePublicKey = this.am.authenticatePublicKey(str, keyPair, getOrCreateSecureRND());
            this.authenticated = zAuthenticatePublicKey;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePublicKey;
    }

    public synchronized boolean authenticateWithPublicKey(String str, char[] cArr, String str2) {
        boolean zAuthenticatePublicKey;
        try {
            if (cArr == null) {
                throw new IllegalArgumentException("pemPrivateKey argument is null");
            }
            checkRequirements(str);
            zAuthenticatePublicKey = this.am.authenticatePublicKey(str, cArr, str2, getOrCreateSecureRND());
            this.authenticated = zAuthenticatePublicKey;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePublicKey;
    }

    public synchronized void cancelRemotePortForwarding(int i) {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        this.cm.requestCancelGlobalForward(i);
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        try {
            ProxyData proxyData = this.proxyData;
            if (proxyData != null) {
                proxyData.close();
            }
            close(new Throwable("Closed due to user request."), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ConnectionInfo connect() {
        return connect(null, 0, 0);
    }

    public synchronized ConnectionInfo connect(ServerHostKeyVerifier serverHostKeyVerifier) {
        return connect(serverHostKeyVerifier, 0, 0);
    }

    public synchronized ConnectionInfo connect(ServerHostKeyVerifier serverHostKeyVerifier, int i, int i2) {
        TimeoutService.TimeoutToken timeoutTokenAddTimeoutHandler;
        ConnectionInfo connectionInfo;
        try {
            if (this.tm != null) {
                throw new IOException("Connection to " + this.hostname + " is already in connected state!");
            }
            if (i < 0) {
                throw new IllegalArgumentException("connectTimeout must be non-negative!");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("kexTimeout must be non-negative!");
            }
            final C1TimeoutState c1TimeoutState = new C1TimeoutState();
            TransportManager transportManager = new TransportManager(this.hostname, this.port);
            this.tm = transportManager;
            transportManager.setConnectionMonitors(this.connectionMonitors);
            if (!this.compression) {
                CryptoWishList cryptoWishList = this.cryptoWishList;
                cryptoWishList.c2s_comp_algos = new String[]{"none"};
                cryptoWishList.s2c_comp_algos = new String[]{"none"};
            }
            synchronized (this.tm) {
            }
            if (i2 > 0) {
                try {
                    try {
                        timeoutTokenAddTimeoutHandler = TimeoutService.addTimeoutHandler(System.currentTimeMillis() + ((long) i2), new Runnable() { // from class: com.trilead.ssh2.Connection.1
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (c1TimeoutState) {
                                    C1TimeoutState c1TimeoutState2 = c1TimeoutState;
                                    if (!c1TimeoutState2.isCancelled) {
                                        c1TimeoutState2.timeoutSocketClosed = true;
                                        Connection.this.tm.close(new SocketTimeoutException("The connect timeout expired"), false);
                                    }
                                }
                            }
                        });
                    } catch (IOException e) {
                        close(new Throwable("There was a problem during connect."), false);
                        synchronized (c1TimeoutState) {
                            if (c1TimeoutState.timeoutSocketClosed) {
                                throw new SocketTimeoutException("The kexTimeout (" + i2 + " ms) expired.");
                            }
                            if (e instanceof HTTPProxyException) {
                                throw e;
                            }
                            throw new IOException("There was a problem while connecting to " + this.hostname + ":" + this.port, e);
                        }
                    }
                } catch (SocketTimeoutException e2) {
                    throw e2;
                }
            } else {
                timeoutTokenAddTimeoutHandler = null;
            }
            try {
                this.tm.initialize(this.cryptoWishList, serverHostKeyVerifier, this.dhgexpara, i, getOrCreateSecureRND(), this.proxyData);
                connectionInfo = this.tm.getConnectionInfo(1);
                if (timeoutTokenAddTimeoutHandler != null) {
                    TimeoutService.cancelTimeoutHandler(timeoutTokenAddTimeoutHandler);
                    synchronized (c1TimeoutState) {
                        try {
                            if (c1TimeoutState.timeoutSocketClosed) {
                                throw new IOException("This exception will be replaced by the one below =)");
                            }
                            c1TimeoutState.isCancelled = true;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (SocketTimeoutException e3) {
                throw ((SocketTimeoutException) new SocketTimeoutException("The connect() operation on the socket timed out.").initCause(e3));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return connectionInfo;
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(int i) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new DynamicPortForwarder(this.cm, i);
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(InetSocketAddress inetSocketAddress) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new DynamicPortForwarder(this.cm, inetSocketAddress);
    }

    public synchronized LocalPortForwarder createLocalPortForwarder(int i, String str, int i2) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new LocalPortForwarder(this.cm, i, str, i2);
    }

    public synchronized LocalPortForwarder createLocalPortForwarder(InetSocketAddress inetSocketAddress, String str, int i) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new LocalPortForwarder(this.cm, inetSocketAddress, str, i);
    }

    public synchronized LocalStreamForwarder createLocalStreamForwarder(String str, int i) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward, connection is not authenticated.");
        }
        return new LocalStreamForwarder(this.cm, str, i);
    }

    public synchronized SCPClient createSCPClient() {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot create SCP client, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot create SCP client, connection is not authenticated.");
        }
        return new SCPClient(this);
    }

    public synchronized void enableDebugging(boolean z, DebugLogger debugLogger) {
        try {
            Logger.enabled = z;
            if (z) {
                if (debugLogger == null) {
                    debugLogger = new DebugLogger() { // from class: com.trilead.ssh2.Connection.2
                        @Override // com.trilead.ssh2.DebugLogger
                        public void log(int i, String str, String str2) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            System.err.println(jCurrentTimeMillis + " : " + str + ": " + str2);
                        }
                    };
                }
                Logger.logger = debugLogger;
            } else {
                Logger.logger = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void forceKeyExchange() {
        TransportManager transportManager = this.tm;
        if (transportManager == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        transportManager.forceKeyExchange(this.cryptoWishList, this.dhgexpara);
    }

    public synchronized ConnectionInfo getConnectionInfo() {
        TransportManager transportManager;
        transportManager = this.tm;
        if (transportManager == null) {
            throw new IllegalStateException("Cannot get details of connection, you need to establish a connection first.");
        }
        return transportManager.getConnectionInfo(1);
    }

    public synchronized String getHostname() {
        return this.hostname;
    }

    public synchronized int getPort() {
        return this.port;
    }

    public synchronized String[] getRemainingAuthMethods(String str) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("user argument may not be NULL!");
            }
            TransportManager transportManager = this.tm;
            if (transportManager == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                this.am = new AuthenticationManager(transportManager);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.am.getRemainingMethods(str);
    }

    public synchronized boolean isAuthMethodAvailable(String str, String str2) {
        try {
            if (str2 == null) {
                throw new IllegalArgumentException("method argument may not be NULL!");
            }
            for (String str3 : getRemainingAuthMethods(str)) {
                if (str3.compareTo(str2) == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isAuthenticationComplete() {
        return this.authenticated;
    }

    public synchronized boolean isAuthenticationPartialSuccess() {
        AuthenticationManager authenticationManager = this.am;
        if (authenticationManager == null) {
            return false;
        }
        return authenticationManager.getPartialSuccess();
    }

    public synchronized Session openSession() {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot open session, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot open session, connection is not authenticated.");
        }
        return new Session(this.cm, getOrCreateSecureRND());
    }

    public synchronized void ping() {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        this.cm.requestGlobalTrileadPing();
    }

    public synchronized void requestRemotePortForwarding(String str, int i, String str2, int i2) {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        if (str == null || str2 == null || i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.cm.requestGlobalForward(str, i, str2, i2);
    }

    public synchronized void sendIgnorePacket() {
        SecureRandom orCreateSecureRND = getOrCreateSecureRND();
        byte[] bArr = new byte[orCreateSecureRND.nextInt(16)];
        orCreateSecureRND.nextBytes(bArr);
        sendIgnorePacket(bArr);
    }

    public synchronized void sendIgnorePacket(byte[] bArr) {
        try {
            if (bArr == null) {
                throw new IllegalArgumentException("data argument must not be null.");
            }
            if (this.tm == null) {
                throw new IllegalStateException("Cannot send SSH_MSG_IGNORE packet, you need to establish a connection first.");
            }
            PacketIgnore packetIgnore = new PacketIgnore();
            packetIgnore.setData(bArr);
            this.tm.sendMessage(packetIgnore.getPayload());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setClient2ServerCiphers(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                BlockCipherFactory.checkCipherList(strArrRemoveDuplicates);
                this.cryptoWishList.c2s_enc_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setClient2ServerMACs(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                MACs.checkMacList(strArrRemoveDuplicates);
                this.cryptoWishList.c2s_mac_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setCompression(boolean z) {
        if (this.tm != null) {
            throw new IOException("Connection to " + this.hostname + " is already in connected state!");
        }
        this.compression = z;
    }

    public synchronized void setDHGexParameters(DHGexParameters dHGexParameters) {
        try {
            if (dHGexParameters == null) {
                throw new IllegalArgumentException();
            }
            this.dhgexpara = dHGexParameters;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setKeyExchangeAlgorithms(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                KexManager.checkKexAlgorithmList(strArrRemoveDuplicates);
                this.cryptoWishList.kexAlgorithms = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setProxyData(ProxyData proxyData) {
        this.proxyData = proxyData;
    }

    public synchronized void setSecureRandom(SecureRandom secureRandom) {
        try {
            if (secureRandom == null) {
                throw new IllegalArgumentException();
            }
            this.generator = secureRandom;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setServer2ClientCiphers(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                BlockCipherFactory.checkCipherList(strArrRemoveDuplicates);
                this.cryptoWishList.s2c_enc_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setServer2ClientMACs(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                MACs.checkMacList(strArrRemoveDuplicates);
                this.cryptoWishList.s2c_mac_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setServerHostKeyAlgorithms(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                KexManager.checkServerHostkeyAlgorithmsList(strArrRemoveDuplicates);
                this.cryptoWishList.serverHostKeyAlgorithms = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }
}
