package com.trilead.ssh2;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.crypto.Base64;
import com.trilead.ssh2.crypto.keys.Ed25519PublicKey;
import com.trilead.ssh2.signature.DSASHA1Verify;
import com.trilead.ssh2.signature.ECDSASHA2Verify;
import com.trilead.ssh2.signature.Ed25519Verify;
import com.trilead.ssh2.signature.RSASHA1Verify;
import com.trilead.ssh2.signature.RSASHA256Verify;
import com.trilead.ssh2.signature.RSASHA512Verify;
import com.trilead.ssh2.signature.SSHSignature;
import com.trilead.ssh2.transport.KexManager;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class KnownHosts {
    public static final int HOSTKEY_HAS_CHANGED = 2;
    public static final int HOSTKEY_IS_NEW = 1;
    public static final int HOSTKEY_IS_OK = 0;
    protected final LinkedList<KnownHostsEntry> publicKeys = new LinkedList<>();
    private final String[] ALGOS_FOR_RSA = {RSASHA512Verify.ID_RSA_SHA_2_512, RSASHA256Verify.ID_RSA_SHA_2_256, RSASHA1Verify.ID_SSH_RSA};
    private final String ALGO_FOR_DSS = DSASHA1Verify.ID_SSH_DSS;
    private final String ALGO_FOR_EDDSA = Ed25519Verify.ED25519_ID;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class KnownHostsEntry {
        PublicKey key;
        String[] patterns;

        public KnownHostsEntry(String[] strArr, PublicKey publicKey) {
            this.patterns = strArr;
            this.key = publicKey;
        }

        public String toString() {
            return "KnownHostsEntry{keyType=" + this.key.getAlgorithm() + "}";
        }
    }

    public KnownHosts() {
    }

    public KnownHosts(File file) throws IOException {
        initialize(file);
    }

    public KnownHosts(char[] cArr) throws IOException {
        initialize(cArr);
    }

    public static final void addHostkeyToFile(File file, String[] strArr, String str, byte[] bArr) throws IOException {
        if (strArr == null || strArr.length == 0) {
            d.AnonymousClass0.m$2("Need at least one hostname specification");
            return;
        }
        if (str == null || bArr == null) {
            throw new IllegalArgumentException();
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                charArrayWriter.write(44);
            }
            charArrayWriter.write(strArr[i]);
        }
        charArrayWriter.write(32);
        charArrayWriter.write(str);
        charArrayWriter.write(32);
        charArrayWriter.write(Base64.encode(bArr));
        charArrayWriter.write("\n");
        char[] charArray = charArrayWriter.toCharArray();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        long length = randomAccessFile.length();
        if (length > 0) {
            randomAccessFile.seek(length - 1);
            if (randomAccessFile.read() != 10) {
                randomAccessFile.write(10);
            }
        }
        try {
            randomAccessFile.write(new String(charArray).getBytes(InternalZipConstants.AES_HASH_CHARSET));
        } catch (UnsupportedEncodingException unused) {
            randomAccessFile.write(new String(charArray).getBytes());
        }
        randomAccessFile.close();
    }

    private final boolean checkHashed(String str, String str2) {
        int iIndexOf;
        if (str.startsWith("|1|") && (iIndexOf = str.indexOf(R.styleable.AppCompatTheme_windowMinWidthMajor, 3)) != -1) {
            String strSubstring = str.substring(3, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            try {
                byte[] bArrDecode = Base64.decode(strSubstring.toCharArray());
                byte[] bArrDecode2 = Base64.decode(strSubstring2.toCharArray());
                try {
                    if (bArrDecode.length == MessageDigest.getInstance("SHA1").getDigestLength()) {
                        byte[] bArrHmacSha1Hash = hmacSha1Hash(bArrDecode, str2);
                        for (int i = 0; i < bArrHmacSha1Hash.length; i++) {
                            if (bArrHmacSha1Hash[i] == bArrDecode2[i]) {
                            }
                        }
                        return true;
                    }
                } catch (NoSuchAlgorithmException e) {
                    d.AnonymousClass0.m$1("VM does not support SHA1", (Throwable) e);
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private int checkKey(String str, PublicKey publicKey) {
        synchronized (this.publicKeys) {
            try {
                int i = 1;
                for (KnownHostsEntry knownHostsEntry : this.publicKeys) {
                    if (hostnameMatches(knownHostsEntry.patterns, str)) {
                        if (matchKeys(knownHostsEntry.key, publicKey)) {
                            return 0;
                        }
                        i = 2;
                    }
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final String createBubblebabbleFingerprint(String str, byte[] bArr) {
        return rawToBubblebabbleFingerprint(rawFingerPrint("sha1", str, bArr));
    }

    public static final String createHashedHostname(String str) {
        try {
            byte[] bArr = new byte[MessageDigest.getInstance("SHA1").getDigestLength()];
            new SecureRandom().nextBytes(bArr);
            byte[] bArrHmacSha1Hash = hmacSha1Hash(bArr, str);
            return new String("|1|" + new String(Base64.encode(bArr)) + "|" + new String(Base64.encode(bArrHmacSha1Hash)));
        } catch (NoSuchAlgorithmException e) {
            d.AnonymousClass0.m$1("VM doesn't support SHA1", (Throwable) e);
            return null;
        }
    }

    public static final String createHexFingerprint(String str, byte[] bArr) {
        return rawToHexFingerprint(rawFingerPrint("md5", str, bArr));
    }

    private List<PublicKey> getAllKeys(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.publicKeys) {
            try {
                for (KnownHostsEntry knownHostsEntry : this.publicKeys) {
                    if (hostnameMatches(knownHostsEntry.patterns, str)) {
                        arrayList.add(knownHostsEntry.key);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private static final byte[] hmacSha1Hash(byte[] bArr, String str) {
        String str2;
        try {
            Mac mac = Mac.getInstance(InternalZipConstants.AES_MAC_ALGORITHM);
            if (bArr.length == mac.getMacLength()) {
                mac.init(new SecretKeySpec(bArr, InternalZipConstants.AES_MAC_ALGORITHM));
                try {
                    mac.update(str.getBytes(InternalZipConstants.AES_HASH_CHARSET));
                } catch (UnsupportedEncodingException unused) {
                    mac.update(str.getBytes());
                }
                return mac.doFinal();
            }
            throw new IllegalArgumentException("Salt has wrong length (" + bArr.length + ")");
        } catch (InvalidKeyException e) {
            e = e;
            str2 = "Unable to create SecretKey";
            d.AnonymousClass0.m$1(str2, e);
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str2 = "Unable to HMAC-SHA1";
            d.AnonymousClass0.m$1(str2, e);
            return null;
        }
    }

    private final boolean hostnameMatches(String[] strArr, String str) {
        String strSubstring;
        boolean z;
        String lowerCase = str.toLowerCase(Locale.US);
        boolean z2 = false;
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str2 != null) {
                if (str2.length() <= 0 || strArr[i].charAt(0) != '!') {
                    strSubstring = strArr[i];
                    z = false;
                } else {
                    strSubstring = strArr[i].substring(1);
                    z = true;
                }
                if (!z2 || z) {
                    if (strSubstring.charAt(0) != '|') {
                        String lowerCase2 = strSubstring.toLowerCase(Locale.US);
                        if (lowerCase2.indexOf(63) == -1 && lowerCase2.indexOf(42) == -1) {
                            if (lowerCase2.compareTo(lowerCase) != 0) {
                                continue;
                            } else {
                                if (z) {
                                    return false;
                                }
                                z2 = true;
                            }
                        } else if (pseudoRegex(lowerCase2.toCharArray(), 0, lowerCase.toCharArray(), 0)) {
                            if (z) {
                                return false;
                            }
                            z2 = true;
                        } else {
                            continue;
                        }
                    } else if (checkHashed(strSubstring, lowerCase)) {
                        if (z) {
                            return false;
                        }
                        z2 = true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return z2;
    }

    private void initialize(File file) throws IOException {
        char[] cArr = new char[512];
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        file.createNewFile();
        FileReader fileReader = new FileReader(file);
        while (true) {
            int i = fileReader.read(cArr);
            if (i < 0) {
                fileReader.close();
                initialize(charArrayWriter.toCharArray());
                return;
            }
            charArrayWriter.write(cArr, 0, i);
        }
    }

    private void initialize(char[] cArr) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(cArr));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.trim();
            if (!strTrim.startsWith("#")) {
                String[] strArrSplit = strTrim.split(" ");
                if (strArrSplit.length >= 3) {
                    addHostkey(strArrSplit[0].split(","), strArrSplit[1], Base64.decode(strArrSplit[2].toCharArray()));
                }
            }
        }
    }

    private final boolean matchKeys(PublicKey publicKey, PublicKey publicKey2) {
        return publicKey.equals(publicKey2);
    }

    private final boolean pseudoRegex(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr.length != i) {
            char c = cArr[i];
            if (c == '*') {
                int i3 = i + 1;
                if (cArr.length == i3) {
                    return true;
                }
                char c2 = cArr[i3];
                if (c2 == '*' || c2 == '?') {
                    while (!pseudoRegex(cArr, i3, cArr2, i2)) {
                        i2++;
                        if (cArr2.length == i2) {
                            return false;
                        }
                    }
                    return true;
                }
                do {
                    if (cArr[i3] == cArr2[i2] && pseudoRegex(cArr, i + 2, cArr2, i2 + 1)) {
                        return true;
                    }
                    i2++;
                } while (cArr2.length != i2);
                return false;
            }
            if (cArr2.length == i2) {
                return false;
            }
            if (c != '?' && c != cArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return cArr2.length == i2;
    }

    private static byte[] rawFingerPrint(String str, String str2, byte[] bArr) {
        String str3;
        try {
            if ("md5".equals(str)) {
                str3 = "MD5";
            } else {
                if (!"sha1".equals(str)) {
                    throw new IllegalArgumentException("Unknown hash type " + str);
                }
                str3 = "SHA1";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str3);
            if (!Ed25519Verify.ED25519_ID.equals(str2) && !str2.startsWith(ECDSASHA2Verify.ECDSA_SHA2_PREFIX) && !RSASHA1Verify.ID_SSH_RSA.equals(str2) && !DSASHA1Verify.ID_SSH_DSS.equals(str2) && !RSASHA256Verify.ID_RSA_SHA_2_256.equals(str2) && !RSASHA512Verify.ID_RSA_SHA_2_512.equals(str2)) {
                throw new IllegalArgumentException("Unknown key type ".concat(str2));
            }
            if (bArr != null) {
                messageDigest.update(bArr);
                return messageDigest.digest();
            }
            d.AnonymousClass0.m$2("hostkey is null");
            return null;
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalArgumentException(ak.m("Unknown hash type ", str));
        }
    }

    private static final String rawToBubblebabbleFingerprint(byte[] bArr) {
        char[] charArray = "aeiouy".toCharArray();
        char[] charArray2 = "bcdfghklmnprstvzx".toCharArray();
        StringBuilder sb = new StringBuilder("x");
        int i = 1;
        int length = (bArr.length / 2) + 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 < length || bArr.length % 2 != 0) {
                int i4 = i2 * 2;
                sb.append(charArray[(((bArr[i4] >> 6) & 3) + i) % 6]);
                sb.append(charArray2[(bArr[i4] >> 2) & 15]);
                sb.append(charArray[((i / 6) + (bArr[i4] & 3)) % 6]);
                if (i3 < length) {
                    int i5 = i4 + 1;
                    sb.append(charArray2[(bArr[i5] >> 4) & 15]);
                    sb.append('-');
                    sb.append(charArray2[bArr[i5] & 15]);
                    i = ((((bArr[i4] & GZIPHeader.OS_UNKNOWN) * 7) + (bArr[i5] & GZIPHeader.OS_UNKNOWN)) + (i * 5)) % 36;
                }
            } else {
                sb.append(charArray[i % 6]);
                sb.append('x');
                sb.append(charArray[i / 6]);
            }
            i2 = i3;
        }
        sb.append('x');
        return sb.toString();
    }

    private static String rawToHexFingerprint(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                sb.append(':');
            }
            byte b = bArr[i];
            sb.append(charArray[(b & GZIPHeader.OS_UNKNOWN) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString();
    }

    private String[] recommendHostkeyAlgorithms(String str) {
        String sshKeyType;
        ArrayList arrayList = new ArrayList();
        for (PublicKey publicKey : getAllKeys(str)) {
            if (publicKey instanceof RSAPublicKey) {
                arrayList.addAll(Arrays.asList(this.ALGOS_FOR_RSA));
            } else {
                if (publicKey instanceof DSAPublicKey) {
                    sshKeyType = DSASHA1Verify.ID_SSH_DSS;
                } else if (publicKey instanceof Ed25519PublicKey) {
                    sshKeyType = Ed25519Verify.ED25519_ID;
                } else if (publicKey instanceof ECPublicKey) {
                    sshKeyType = ECDSASHA2Verify.getSshKeyType((ECPublicKey) publicKey);
                }
                arrayList.add(sshKeyType);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : KexManager.getDefaultServerHostkeyAlgorithmList()) {
            if (arrayList.contains(str2)) {
                arrayList2.add(str2);
            } else {
                arrayList3.add(str2);
            }
        }
        arrayList2.addAll(arrayList3);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public void addHostkey(String[] strArr, String str, byte[] bArr) throws IOException {
        if (strArr == null) {
            d.AnonymousClass0.m$2("hostnames may not be null");
            return;
        }
        if (RSASHA1Verify.ID_SSH_RSA.equals(str) || RSASHA512Verify.ID_RSA_SHA_2_512.equals(str) || RSASHA256Verify.ID_RSA_SHA_2_256.equals(str)) {
            PublicKey publicKeyDecodePublicKey = RSASHA1Verify.get().decodePublicKey(bArr);
            synchronized (this.publicKeys) {
                this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey));
            }
            return;
        }
        if (str.equals(DSASHA1Verify.ID_SSH_DSS)) {
            PublicKey publicKeyDecodePublicKey2 = DSASHA1Verify.get().decodePublicKey(bArr);
            synchronized (this.publicKeys) {
                this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey2));
            }
            return;
        }
        if (str.equals(ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().getKeyFormat())) {
            PublicKey publicKeyDecodePublicKey3 = ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().decodePublicKey(bArr);
            synchronized (this.publicKeys) {
                this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey3));
            }
            return;
        }
        if (str.equals(ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().getKeyFormat())) {
            PublicKey publicKeyDecodePublicKey4 = ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().decodePublicKey(bArr);
            synchronized (this.publicKeys) {
                this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey4));
            }
            return;
        }
        if (str.equals(ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().getKeyFormat())) {
            PublicKey publicKeyDecodePublicKey5 = ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().decodePublicKey(bArr);
            synchronized (this.publicKeys) {
                this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey5));
            }
            return;
        }
        if (!Ed25519Verify.ED25519_ID.equals(str)) {
            throw new IOException(e.n("Unknown host key type (", str, ")"));
        }
        PublicKey publicKeyDecodePublicKey6 = Ed25519Verify.get().decodePublicKey(bArr);
        synchronized (this.publicKeys) {
            this.publicKeys.add(new KnownHostsEntry(strArr, publicKeyDecodePublicKey6));
        }
    }

    public void addHostkeys(File file) throws IOException {
        initialize(file);
    }

    public void addHostkeys(char[] cArr) throws IOException {
        initialize(cArr);
    }

    public String[] getPreferredServerHostkeyAlgorithmOrder(String str) {
        String[] strArrRecommendHostkeyAlgorithms = recommendHostkeyAlgorithms(str);
        if (strArrRecommendHostkeyAlgorithms != null) {
            return strArrRecommendHostkeyAlgorithms;
        }
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                String[] strArrRecommendHostkeyAlgorithms2 = recommendHostkeyAlgorithms(inetAddress.getHostAddress());
                if (strArrRecommendHostkeyAlgorithms2 != null) {
                    return strArrRecommendHostkeyAlgorithms2;
                }
            }
        } catch (UnknownHostException unused) {
        }
        return null;
    }

    public int verifyHostkey(String str, String str2, byte[] bArr) throws IOException {
        PublicKey publicKeyDecodePublicKey;
        SSHSignature sSHSignature;
        if (RSASHA1Verify.ID_SSH_RSA.equals(str2) || RSASHA256Verify.ID_RSA_SHA_2_256.equals(str2) || RSASHA512Verify.ID_RSA_SHA_2_512.equals(str2)) {
            publicKeyDecodePublicKey = RSASHA1Verify.get().decodePublicKey(bArr);
        } else if (DSASHA1Verify.ID_SSH_DSS.equals(str2)) {
            publicKeyDecodePublicKey = DSASHA1Verify.get().decodePublicKey(bArr);
        } else {
            if (ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().getKeyFormat().equals(str2)) {
                sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get();
            } else if (ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().getKeyFormat().equals(str2)) {
                sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get();
            } else if (ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().getKeyFormat().equals(str2)) {
                sSHSignature = ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get();
            } else {
                if (!Ed25519Verify.ED25519_ID.equals(str2)) {
                    throw new IllegalArgumentException(ak.m("Unknown hostkey type ", str2));
                }
                publicKeyDecodePublicKey = Ed25519Verify.get().decodePublicKey(bArr);
            }
            publicKeyDecodePublicKey = sSHSignature.decodePublicKey(bArr);
        }
        int iCheckKey = checkKey(str, publicKeyDecodePublicKey);
        if (iCheckKey == 0) {
            return iCheckKey;
        }
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                int iCheckKey2 = checkKey(inetAddress.getHostAddress(), publicKeyDecodePublicKey);
                if (iCheckKey2 == 0) {
                    return iCheckKey2;
                }
                if (iCheckKey2 == 2) {
                    iCheckKey = 2;
                }
            }
        } catch (UnknownHostException unused) {
        }
        return iCheckKey;
    }
}
