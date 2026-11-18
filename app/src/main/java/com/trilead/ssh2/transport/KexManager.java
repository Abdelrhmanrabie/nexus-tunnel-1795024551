package com.trilead.ssh2.transport;

import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.DHGexParameters;
import com.trilead.ssh2.ExtendedServerHostKeyVerifier;
import com.trilead.ssh2.ServerHostKeyVerifier;
import com.trilead.ssh2.auth.SignatureProxy;
import com.trilead.ssh2.compression.CompressionFactory;
import com.trilead.ssh2.compression.ICompressor;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.KeyMaterial;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.dh.Curve25519Exchange;
import com.trilead.ssh2.crypto.dh.DhGroupExchange;
import com.trilead.ssh2.crypto.dh.GenericDhExchange;
import com.trilead.ssh2.crypto.digest.HMAC;
import com.trilead.ssh2.crypto.digest.MACs;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketKexDHInit;
import com.trilead.ssh2.packets.PacketKexDHReply;
import com.trilead.ssh2.packets.PacketKexDhGexGroup;
import com.trilead.ssh2.packets.PacketKexDhGexInit;
import com.trilead.ssh2.packets.PacketKexDhGexReply;
import com.trilead.ssh2.packets.PacketKexDhGexRequest;
import com.trilead.ssh2.packets.PacketKexDhGexRequestOld;
import com.trilead.ssh2.packets.PacketKexInit;
import com.trilead.ssh2.packets.PacketNewKeys;
import com.trilead.ssh2.signature.DSASHA1Verify;
import com.trilead.ssh2.signature.ECDSASHA2Verify;
import com.trilead.ssh2.signature.Ed25519Verify;
import com.trilead.ssh2.signature.RSASHA1Verify;
import com.trilead.ssh2.signature.RSASHA256Verify;
import com.trilead.ssh2.signature.RSASHA512Verify;
import com.trilead.ssh2.signature.SSHSignature;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import defpackage.fb$1;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class KexManager {
    private static final Set<String> HOSTKEY_ALGS;
    private static final Set<String> KEX_ALGS;
    private static final Logger log = Logger.getLogger(KexManager.class);
    private static final boolean supportsEc;
    private ClientServerHello csh;
    private final String hostname;
    private KeyMaterial km;
    private KexState kxs;
    private CryptoWishList nextKEXcryptoWishList;
    private final int port;
    private final SecureRandom rnd;
    byte[] sessionId;
    private final TransportManager tm;
    private ServerHostKeyVerifier verifier;
    private int kexCount = 0;
    private final Object accessLock = new Object();
    private ConnectionInfo lastConnInfo = null;
    private boolean connectionClosed = false;
    private boolean ignore_next_kex_packet = false;
    private DHGexParameters nextKEXdhgexParameters = new DHGexParameters();

    static {
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("EC");
        } catch (NoSuchAlgorithmException unused) {
            log.log(10, "Disabling EC support due to lack of KeyFactory");
            keyFactory = null;
        }
        boolean z = keyFactory != null;
        supportsEc = z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HOSTKEY_ALGS = linkedHashSet;
        linkedHashSet.add(Ed25519Verify.ED25519_ID);
        if (z) {
            linkedHashSet.add("ecdsa-sha2-nistp256");
            linkedHashSet.add("ecdsa-sha2-nistp384");
            linkedHashSet.add("ecdsa-sha2-nistp521");
        }
        linkedHashSet.add(RSASHA512Verify.ID_RSA_SHA_2_512);
        linkedHashSet.add(RSASHA256Verify.ID_RSA_SHA_2_256);
        linkedHashSet.add(RSASHA1Verify.ID_SSH_RSA);
        linkedHashSet.add(DSASHA1Verify.ID_SSH_DSS);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        KEX_ALGS = linkedHashSet2;
        linkedHashSet2.add(Curve25519Exchange.NAME);
        linkedHashSet2.add(Curve25519Exchange.ALT_NAME);
        if (z) {
            linkedHashSet2.add("ecdh-sha2-nistp256");
            linkedHashSet2.add("ecdh-sha2-nistp384");
            linkedHashSet2.add("ecdh-sha2-nistp521");
        }
        linkedHashSet2.add("diffie-hellman-group18-sha512");
        linkedHashSet2.add("diffie-hellman-group16-sha512");
        linkedHashSet2.add("diffie-hellman-group-exchange-sha256");
        linkedHashSet2.add("diffie-hellman-group14-sha256");
        linkedHashSet2.add("diffie-hellman-group-exchange-sha1");
        linkedHashSet2.add("diffie-hellman-group14-sha1");
        linkedHashSet2.add("diffie-hellman-group1-sha1");
        linkedHashSet2.add("ext-info-c");
    }

    public KexManager(TransportManager transportManager, ClientServerHello clientServerHello, CryptoWishList cryptoWishList, String str, int i, ServerHostKeyVerifier serverHostKeyVerifier, SecureRandom secureRandom) {
        this.tm = transportManager;
        this.csh = clientServerHello;
        this.nextKEXcryptoWishList = cryptoWishList;
        this.hostname = str;
        this.port = i;
        this.verifier = serverHostKeyVerifier;
        this.rnd = secureRandom;
    }

    public static void checkKexAlgorithmList(String[] strArr) {
        for (String str : strArr) {
            if (!KEX_ALGS.contains(str)) {
                throw new IllegalArgumentException(e.n("Unknown kex algorithm '", str, "'"));
            }
        }
    }

    public static void checkServerHostkeyAlgorithmsList(String[] strArr) {
        for (String str : strArr) {
            if (!HOSTKEY_ALGS.contains(str)) {
                throw new IllegalArgumentException(e.n("Unknown server host key algorithm '", str, "'"));
            }
        }
    }

    private boolean compareFirstOfNameList(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException();
        }
        if (strArr.length == 0 && strArr2.length == 0) {
            return true;
        }
        if (strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        return strArr[0].equals(strArr2[0]);
    }

    private void establishKeyMaterial() throws IOException {
        try {
            int keyLen = MACs.getKeyLen(this.kxs.np.mac_algo_client_to_server);
            int keySize = BlockCipherFactory.getKeySize(this.kxs.np.enc_algo_client_to_server);
            int blockSize = BlockCipherFactory.getBlockSize(this.kxs.np.enc_algo_client_to_server);
            int keyLen2 = MACs.getKeyLen(this.kxs.np.mac_algo_server_to_client);
            int keySize2 = BlockCipherFactory.getKeySize(this.kxs.np.enc_algo_server_to_client);
            int blockSize2 = BlockCipherFactory.getBlockSize(this.kxs.np.enc_algo_server_to_client);
            KexState kexState = this.kxs;
            this.km = KeyMaterial.create(kexState.hashAlgo, kexState.H, kexState.K, this.sessionId, keySize, blockSize, keyLen, keySize2, blockSize2, keyLen2);
        } catch (IllegalArgumentException e) {
            throw new IOException(ak.AnonymousClass0.m("Could not establish key material: ", e.getMessage()));
        }
    }

    private void filterHostKeyTypes(CryptoWishList cryptoWishList) {
        List<String> knownKeyAlgorithmsForHost;
        ServerHostKeyVerifier serverHostKeyVerifier = this.verifier;
        if (!(serverHostKeyVerifier instanceof ExtendedServerHostKeyVerifier) || (knownKeyAlgorithmsForHost = ((ExtendedServerHostKeyVerifier) serverHostKeyVerifier).getKnownKeyAlgorithmsForHost(this.hostname, this.port)) == null || knownKeyAlgorithmsForHost.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(knownKeyAlgorithmsForHost.size());
        for (String str : cryptoWishList.serverHostKeyAlgorithms) {
            for (String str2 : knownKeyAlgorithmsForHost) {
                if (str.equals(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() > 0) {
            cryptoWishList.serverHostKeyAlgorithms = (String[]) arrayList.toArray(new String[0]);
        }
    }

    private void finishKex() throws IOException {
        if (this.sessionId == null) {
            this.sessionId = this.kxs.H;
        }
        establishKeyMaterial();
        this.tm.sendKexMessage(new PacketNewKeys().getPayload());
        try {
            String str = this.kxs.np.enc_algo_client_to_server;
            KeyMaterial keyMaterial = this.km;
            BlockCipher blockCipherCreateCipher = BlockCipherFactory.createCipher(str, true, keyMaterial.enc_key_client_to_server, keyMaterial.initial_iv_client_to_server);
            HMAC hmac = new HMAC(this.kxs.np.mac_algo_client_to_server, this.km.integrity_key_client_to_server);
            ICompressor iCompressorCreateCompressor = CompressionFactory.createCompressor(this.kxs.np.comp_algo_client_to_server);
            this.tm.changeSendCipher(blockCipherCreateCipher, hmac);
            this.tm.changeSendCompression(iCompressorCreateCompressor);
            this.tm.kexFinished();
        } catch (IllegalArgumentException unused) {
            d.AnonymousClass0.m$6("Fatal error during MAC startup!");
        }
    }

    public static String[] getDefaultKexAlgorithmList() {
        return (String[]) KEX_ALGS.toArray(new String[0]);
    }

    public static String[] getDefaultServerHostkeyAlgorithmList() {
        return (String[]) HOSTKEY_ALGS.toArray(new String[0]);
    }

    private String getFirstMatch(String[] strArr, String[] strArr2) throws NegotiateException {
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException();
        }
        if (strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (str.equals(str2)) {
                    return str;
                }
            }
        }
        throw new NegotiateException();
    }

    private boolean isGuessOK(KexParameters kexParameters, KexParameters kexParameters2) {
        if (kexParameters == null || kexParameters2 == null) {
            throw new IllegalArgumentException();
        }
        if (compareFirstOfNameList(kexParameters.kex_algorithms, kexParameters2.kex_algorithms)) {
            return compareFirstOfNameList(kexParameters.server_host_key_algorithms, kexParameters2.server_host_key_algorithms);
        }
        return false;
    }

    private NegotiatedParameters mergeKexParameters(KexParameters kexParameters, KexParameters kexParameters2) {
        NegotiatedParameters negotiatedParameters = new NegotiatedParameters();
        try {
            negotiatedParameters.kex_algo = getFirstMatch(kexParameters.kex_algorithms, kexParameters2.kex_algorithms);
            Logger logger = log;
            logger.log(20, "kex_algo=" + negotiatedParameters.kex_algo);
            negotiatedParameters.server_host_key_algo = getFirstMatch(kexParameters.server_host_key_algorithms, kexParameters2.server_host_key_algorithms);
            logger.log(20, "server_host_key_algo=" + negotiatedParameters.server_host_key_algo);
            negotiatedParameters.enc_algo_client_to_server = getFirstMatch(kexParameters.encryption_algorithms_client_to_server, kexParameters2.encryption_algorithms_client_to_server);
            negotiatedParameters.enc_algo_server_to_client = getFirstMatch(kexParameters.encryption_algorithms_server_to_client, kexParameters2.encryption_algorithms_server_to_client);
            logger.log(20, "enc_algo_client_to_server=" + negotiatedParameters.enc_algo_client_to_server);
            logger.log(20, "enc_algo_server_to_client=" + negotiatedParameters.enc_algo_server_to_client);
            negotiatedParameters.mac_algo_client_to_server = getFirstMatch(kexParameters.mac_algorithms_client_to_server, kexParameters2.mac_algorithms_client_to_server);
            negotiatedParameters.mac_algo_server_to_client = getFirstMatch(kexParameters.mac_algorithms_server_to_client, kexParameters2.mac_algorithms_server_to_client);
            logger.log(20, "mac_algo_client_to_server=" + negotiatedParameters.mac_algo_client_to_server);
            logger.log(20, "mac_algo_server_to_client=" + negotiatedParameters.mac_algo_server_to_client);
            negotiatedParameters.comp_algo_client_to_server = getFirstMatch(kexParameters.compression_algorithms_client_to_server, kexParameters2.compression_algorithms_client_to_server);
            negotiatedParameters.comp_algo_server_to_client = getFirstMatch(kexParameters.compression_algorithms_server_to_client, kexParameters2.compression_algorithms_server_to_client);
            logger.log(20, "comp_algo_client_to_server=" + negotiatedParameters.comp_algo_client_to_server);
            logger.log(20, "comp_algo_server_to_client=" + negotiatedParameters.comp_algo_server_to_client);
            try {
                negotiatedParameters.lang_client_to_server = getFirstMatch(kexParameters.languages_client_to_server, kexParameters2.languages_client_to_server);
            } catch (NegotiateException unused) {
                negotiatedParameters.lang_client_to_server = null;
            }
            try {
                negotiatedParameters.lang_server_to_client = getFirstMatch(kexParameters.languages_server_to_client, kexParameters2.languages_server_to_client);
            } catch (NegotiateException unused2) {
                negotiatedParameters.lang_server_to_client = null;
            }
            if (isGuessOK(kexParameters, kexParameters2)) {
                negotiatedParameters.guessOK = true;
            }
            return negotiatedParameters;
        } catch (NegotiateException unused3) {
            return null;
        }
    }

    private boolean verifySignature(byte[] bArr, byte[] bArr2) throws IOException {
        SSHSignature sSHSignature;
        if (this.kxs.np.server_host_key_algo.equals(Ed25519Verify.get().getKeyFormat())) {
            sSHSignature = Ed25519Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().getKeyFormat())) {
            sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().getKeyFormat())) {
            sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().getKeyFormat())) {
            sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(RSASHA512Verify.get().getKeyFormat())) {
            sSHSignature = RSASHA512Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(RSASHA256Verify.get().getKeyFormat())) {
            sSHSignature = RSASHA256Verify.get();
        } else if (this.kxs.np.server_host_key_algo.equals(RSASHA1Verify.get().getKeyFormat())) {
            sSHSignature = RSASHA1Verify.get();
        } else {
            if (!this.kxs.np.server_host_key_algo.equals(DSASHA1Verify.get().getKeyFormat())) {
                throw new IOException(fb$1.m(new StringBuilder("Unknown server host key algorithm '"), this.kxs.np.server_host_key_algo, "'"));
            }
            sSHSignature = DSASHA1Verify.get();
        }
        PublicKey publicKeyDecodePublicKey = sSHSignature.decodePublicKey(bArr2);
        log.log(50, "Verifying " + sSHSignature.getKeyFormat() + " signature");
        return sSHSignature.verifySignature(this.kxs.H, bArr, publicKeyDecodePublicKey);
    }

    public ConnectionInfo getOrWaitForConnectionInfo(int i) {
        ConnectionInfo connectionInfo;
        synchronized (this.accessLock) {
            while (true) {
                try {
                    connectionInfo = this.lastConnInfo;
                    if (connectionInfo == null || connectionInfo.keyExchangeCounter < i) {
                        if (this.connectionClosed) {
                            throw new IOException("Key exchange was not finished, connection is closed.", this.tm.getReasonClosedCause());
                        }
                        try {
                            this.accessLock.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return connectionInfo;
    }

    public synchronized void handleMessage(byte[] bArr, int i) {
        try {
            if (bArr == null) {
                synchronized (this.accessLock) {
                    this.connectionClosed = true;
                    this.accessLock.notifyAll();
                }
                return;
            }
            KexState kexState = this.kxs;
            if (kexState == null && bArr[0] != 20) {
                throw new IOException("Unexpected KEX message (type " + ((int) bArr[0]) + ")");
            }
            if (this.ignore_next_kex_packet) {
                this.ignore_next_kex_packet = false;
                return;
            }
            byte b = bArr[0];
            if (b == 20) {
                if (kexState != null && kexState.state != 0) {
                    throw new IOException("Unexpected SSH_MSG_KEXINIT message during on-going kex exchange!");
                }
                if (kexState == null) {
                    KexState kexState2 = new KexState();
                    this.kxs = kexState2;
                    kexState2.dhgexParameters = this.nextKEXdhgexParameters;
                    PacketKexInit packetKexInit = new PacketKexInit(this.nextKEXcryptoWishList);
                    this.kxs.localKEX = packetKexInit;
                    this.tm.sendKexMessage(packetKexInit.getPayload());
                }
                PacketKexInit packetKexInit2 = new PacketKexInit(bArr, 0, i);
                KexState kexState3 = this.kxs;
                kexState3.remoteKEX = packetKexInit2;
                kexState3.np = mergeKexParameters(kexState3.localKEX.getKexParameters(), this.kxs.remoteKEX.getKexParameters());
                KexState kexState4 = this.kxs;
                if (kexState4.np == null) {
                    throw new IOException("Cannot negotiate, proposals do not match.");
                }
                if (kexState4.remoteKEX.isFirst_kex_packet_follows() && !this.kxs.np.guessOK) {
                    this.ignore_next_kex_packet = true;
                }
                if (!this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha256")) {
                    if (!this.kxs.np.kex_algo.equals(Curve25519Exchange.NAME) && !this.kxs.np.kex_algo.equals(Curve25519Exchange.ALT_NAME) && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp521") && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp384") && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp256") && !this.kxs.np.kex_algo.equals("diffie-hellman-group18-sha512") && !this.kxs.np.kex_algo.equals("diffie-hellman-group16-sha512") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha256") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group1-sha1")) {
                        throw new IllegalStateException("Unknown KEX method!");
                    }
                    KexState kexState5 = this.kxs;
                    kexState5.dhx = GenericDhExchange.getInstance(kexState5.np.kex_algo);
                    KexState kexState6 = this.kxs;
                    kexState6.dhx.init(kexState6.np.kex_algo);
                    KexState kexState7 = this.kxs;
                    kexState7.hashAlgo = kexState7.dhx.getHashAlgo();
                    this.tm.sendKexMessage(new PacketKexDHInit(this.kxs.dhx.getE()).getPayload());
                    this.kxs.state = 1;
                    return;
                }
                if (this.kxs.dhgexParameters.getMin_group_len() == 0 || this.csh.server_versioncomment.matches("OpenSSH_2\\.([0-4]\\.|5\\.[0-2]).*")) {
                    this.tm.sendKexMessage(new PacketKexDhGexRequestOld(this.kxs.dhgexParameters).getPayload());
                } else {
                    this.tm.sendKexMessage(new PacketKexDhGexRequest(this.kxs.dhgexParameters).getPayload());
                }
                boolean zEndsWith = this.kxs.np.kex_algo.endsWith("sha1");
                KexState kexState8 = this.kxs;
                kexState8.hashAlgo = zEndsWith ? "SHA1" : SignatureProxy.SHA256;
                kexState8.state = 1;
                return;
            }
            if (b == 21) {
                KeyMaterial keyMaterial = this.km;
                if (keyMaterial == null) {
                    throw new IOException("Peer sent SSH_MSG_NEWKEYS, but I have no key material ready!");
                }
                try {
                    BlockCipher blockCipherCreateCipher = BlockCipherFactory.createCipher(kexState.np.enc_algo_server_to_client, false, keyMaterial.enc_key_server_to_client, keyMaterial.initial_iv_server_to_client);
                    HMAC hmac = new HMAC(this.kxs.np.mac_algo_server_to_client, this.km.integrity_key_server_to_client);
                    ICompressor iCompressorCreateCompressor = CompressionFactory.createCompressor(this.kxs.np.comp_algo_server_to_client);
                    this.tm.changeRecvCipher(blockCipherCreateCipher, hmac);
                    this.tm.changeRecvCompression(iCompressorCreateCompressor);
                    ConnectionInfo connectionInfo = new ConnectionInfo();
                    int i2 = this.kexCount + 1;
                    this.kexCount = i2;
                    KexState kexState9 = this.kxs;
                    NegotiatedParameters negotiatedParameters = kexState9.np;
                    connectionInfo.keyExchangeAlgorithm = negotiatedParameters.kex_algo;
                    connectionInfo.keyExchangeCounter = i2;
                    connectionInfo.clientToServerCryptoAlgorithm = negotiatedParameters.enc_algo_client_to_server;
                    connectionInfo.serverToClientCryptoAlgorithm = negotiatedParameters.enc_algo_server_to_client;
                    connectionInfo.clientToServerMACAlgorithm = negotiatedParameters.mac_algo_client_to_server;
                    connectionInfo.serverToClientMACAlgorithm = negotiatedParameters.mac_algo_server_to_client;
                    connectionInfo.serverHostKeyAlgorithm = negotiatedParameters.server_host_key_algo;
                    connectionInfo.serverHostKey = kexState9.hostkey;
                    connectionInfo.clientToServerCompressionAlgorithm = negotiatedParameters.comp_algo_client_to_server;
                    connectionInfo.serverToClientCompressionAlgorithm = negotiatedParameters.comp_algo_server_to_client;
                    synchronized (this.accessLock) {
                        this.lastConnInfo = connectionInfo;
                        this.accessLock.notifyAll();
                    }
                    this.kxs = null;
                    return;
                } catch (IllegalArgumentException e) {
                    throw new IOException("Fatal error during MAC startup: " + e.getMessage());
                }
            }
            if (kexState == null || kexState.state == 0) {
                throw new IOException("Unexpected Kex submessage!");
            }
            if (kexState.np.kex_algo.equals("diffie-hellman-group-exchange-sha1") || this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha256")) {
                int i3 = this.kxs.state;
                if (i3 == 1) {
                    PacketKexDhGexGroup packetKexDhGexGroup = new PacketKexDhGexGroup(bArr, 0, i);
                    this.kxs.dhgx = new DhGroupExchange(packetKexDhGexGroup.getP(), packetKexDhGexGroup.getG());
                    this.kxs.dhgx.init(this.rnd);
                    this.tm.sendKexMessage(new PacketKexDhGexInit(this.kxs.dhgx.getE()).getPayload());
                    this.kxs.state = 2;
                    return;
                }
                if (i3 != 2) {
                    throw new IllegalStateException("Illegal State in KEX Exchange!");
                }
                PacketKexDhGexReply packetKexDhGexReply = new PacketKexDhGexReply(bArr, 0, i);
                this.kxs.hostkey = packetKexDhGexReply.getHostKey();
                ServerHostKeyVerifier serverHostKeyVerifier = this.verifier;
                if (serverHostKeyVerifier != null) {
                    try {
                        String str = this.hostname;
                        int i4 = this.port;
                        KexState kexState10 = this.kxs;
                        if (!serverHostKeyVerifier.verifyServerHostKey(str, i4, kexState10.np.server_host_key_algo, kexState10.hostkey)) {
                            throw new IOException("The server hostkey was not accepted by the verifier callback");
                        }
                    } catch (Exception e2) {
                        throw new IOException("The server hostkey was not accepted by the verifier callback.", e2);
                    }
                }
                this.kxs.dhgx.setF(packetKexDhGexReply.getF());
                try {
                    KexState kexState11 = this.kxs;
                    kexState11.H = kexState11.dhgx.calculateH(kexState11.hashAlgo, this.csh.getClientString(), this.csh.getServerString(), this.kxs.localKEX.getPayload(), this.kxs.remoteKEX.getPayload(), packetKexDhGexReply.getHostKey(), this.kxs.dhgexParameters);
                    if (!verifySignature(packetKexDhGexReply.getSignature(), this.kxs.hostkey)) {
                        throw new IOException("Hostkey signature sent by remote is wrong!");
                    }
                    KexState kexState12 = this.kxs;
                    kexState12.K = kexState12.dhgx.getK();
                    finishKex();
                    this.kxs.state = -1;
                    return;
                } catch (IllegalArgumentException e3) {
                    throw new IOException("KEX error.", e3);
                }
            }
            if ((!this.kxs.np.kex_algo.equals("diffie-hellman-group1-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha256") && !this.kxs.np.kex_algo.equals("diffie-hellman-group16-sha512") && !this.kxs.np.kex_algo.equals("diffie-hellman-group18-sha512") && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp256") && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp384") && !this.kxs.np.kex_algo.equals("ecdh-sha2-nistp521") && !this.kxs.np.kex_algo.equals(Curve25519Exchange.NAME) && !this.kxs.np.kex_algo.equals(Curve25519Exchange.ALT_NAME)) || this.kxs.state != 1) {
                throw new IllegalStateException("Unkown KEX method! (" + this.kxs.np.kex_algo + ")");
            }
            PacketKexDHReply packetKexDHReply = new PacketKexDHReply(bArr, 0, i);
            this.kxs.hostkey = packetKexDHReply.getHostKey();
            ServerHostKeyVerifier serverHostKeyVerifier2 = this.verifier;
            if (serverHostKeyVerifier2 != null) {
                try {
                    String str2 = this.hostname;
                    int i5 = this.port;
                    KexState kexState13 = this.kxs;
                    if (!serverHostKeyVerifier2.verifyServerHostKey(str2, i5, kexState13.np.server_host_key_algo, kexState13.hostkey)) {
                        throw new IOException("The server hostkey was not accepted by the verifier callback");
                    }
                } catch (Exception e4) {
                    throw new IOException("The server hostkey was not accepted by the verifier callback.", e4);
                }
            }
            this.kxs.dhx.setF(packetKexDHReply.getF());
            try {
                KexState kexState14 = this.kxs;
                kexState14.H = kexState14.dhx.calculateH(this.csh.getClientString(), this.csh.getServerString(), this.kxs.localKEX.getPayload(), this.kxs.remoteKEX.getPayload(), packetKexDHReply.getHostKey());
                if (!verifySignature(packetKexDHReply.getSignature(), this.kxs.hostkey)) {
                    throw new IOException("Hostkey signature sent by remote is wrong!");
                }
                KexState kexState15 = this.kxs;
                kexState15.K = kexState15.dhx.getK();
                finishKex();
                this.kxs.state = -1;
                return;
            } catch (IllegalArgumentException e5) {
                throw new IOException("KEX error.", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    public synchronized void initiateKEX(CryptoWishList cryptoWishList, DHGexParameters dHGexParameters) {
        this.nextKEXcryptoWishList = cryptoWishList;
        filterHostKeyTypes(cryptoWishList);
        this.nextKEXdhgexParameters = dHGexParameters;
        if (this.kxs == null) {
            KexState kexState = new KexState();
            this.kxs = kexState;
            kexState.dhgexParameters = this.nextKEXdhgexParameters;
            PacketKexInit packetKexInit = new PacketKexInit(this.nextKEXcryptoWishList);
            this.kxs.localKEX = packetKexInit;
            this.tm.sendKexMessage(packetKexInit.getPayload());
        }
    }
}
