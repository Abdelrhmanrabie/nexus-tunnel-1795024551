package com.trilead.ssh2.crypto;

import com.trilead.ssh2.auth.SignatureProxy;
import com.trilead.ssh2.crypto.cipher.AES;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.cipher.DES;
import com.trilead.ssh2.crypto.cipher.DESede;
import com.trilead.ssh2.crypto.keys.Ed25519PrivateKey;
import com.trilead.ssh2.crypto.keys.Ed25519PublicKey;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.signature.DSASHA1Verify;
import com.trilead.ssh2.signature.ECDSASHA2Verify;
import com.trilead.ssh2.signature.Ed25519Verify;
import com.trilead.ssh2.signature.RSASHA1Verify;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import defpackage.fb$1;
import defpackage.g;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.DigestException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Locale;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PEMDecoder {
    private static final byte[] OPENSSH_V1_MAGIC = {111, 112, 101, 110, 115, 115, 104, 45, 107, 101, 121, 45, 118, 49, 0};
    public static final int PEM_DSA_PRIVATE_KEY = 2;
    public static final int PEM_EC_PRIVATE_KEY = 3;
    public static final int PEM_OPENSSH_PRIVATE_KEY = 4;
    public static final int PEM_RSA_PRIVATE_KEY = 1;

    public static KeyPair decode(PEMStructure pEMStructure, String str) throws IOException {
        String str2;
        KeyPair keyPairGenerateKeyPair;
        KeySpec rSAPrivateKeySpec;
        ECDSASHA2Verify eCDSASHA2Verify;
        byte[] bytes;
        if (isPEMEncrypted(pEMStructure) && pEMStructure.pemType != 4) {
            if (str == null) {
                d.AnonymousClass0.m$6("PEM is encrypted, but no password was specified");
                return null;
            }
            try {
                decryptPEM(pEMStructure, str.getBytes(InternalZipConstants.AES_HASH_CHARSET));
            } catch (UnsupportedEncodingException unused) {
                decryptPEM(pEMStructure, str.getBytes(InternalZipConstants.AES_HASH_CHARSET));
            }
        }
        int i = pEMStructure.pemType;
        if (i == 2) {
            SimpleDERReader simpleDERReader = new SimpleDERReader(pEMStructure.data);
            byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
            if (simpleDERReader.available() != 0) {
                d.AnonymousClass0.m$6("Padding in DSA PRIVATE KEY DER stream.");
                return null;
            }
            simpleDERReader.resetInput(sequenceAsByteArray);
            BigInteger bigInteger = simpleDERReader.readInt();
            if (bigInteger.compareTo(BigInteger.ZERO) != 0) {
                throw new IOException("Wrong version (" + bigInteger + ") in DSA PRIVATE KEY DER stream.");
            }
            BigInteger bigInteger2 = simpleDERReader.readInt();
            BigInteger bigInteger3 = simpleDERReader.readInt();
            BigInteger bigInteger4 = simpleDERReader.readInt();
            BigInteger bigInteger5 = simpleDERReader.readInt();
            BigInteger bigInteger6 = simpleDERReader.readInt();
            if (simpleDERReader.available() == 0) {
                return generateKeyPair("DSA", new DSAPrivateKeySpec(bigInteger6, bigInteger2, bigInteger3, bigInteger4), new DSAPublicKeySpec(bigInteger5, bigInteger2, bigInteger3, bigInteger4));
            }
            d.AnonymousClass0.m$6("Padding in DSA PRIVATE KEY DER stream.");
            return null;
        }
        if (i == 1) {
            SimpleDERReader simpleDERReader2 = new SimpleDERReader(pEMStructure.data);
            byte[] sequenceAsByteArray2 = simpleDERReader2.readSequenceAsByteArray();
            if (simpleDERReader2.available() == 0) {
                simpleDERReader2.resetInput(sequenceAsByteArray2);
                BigInteger bigInteger7 = simpleDERReader2.readInt();
                if (bigInteger7.compareTo(BigInteger.ZERO) == 0 || bigInteger7.compareTo(BigInteger.ONE) == 0) {
                    BigInteger bigInteger8 = simpleDERReader2.readInt();
                    BigInteger bigInteger9 = simpleDERReader2.readInt();
                    return generateKeyPair("RSA", new RSAPrivateCrtKeySpec(bigInteger8, bigInteger9, simpleDERReader2.readInt(), simpleDERReader2.readInt(), simpleDERReader2.readInt(), simpleDERReader2.readInt(), simpleDERReader2.readInt(), simpleDERReader2.readInt()), new RSAPublicKeySpec(bigInteger8, bigInteger9));
                }
                throw new IOException("Wrong version (" + bigInteger7 + ") in RSA PRIVATE KEY DER stream.");
            }
            str2 = "Padding in RSA PRIVATE KEY DER stream.";
        } else if (i == 3) {
            SimpleDERReader simpleDERReader3 = new SimpleDERReader(pEMStructure.data);
            byte[] sequenceAsByteArray3 = simpleDERReader3.readSequenceAsByteArray();
            if (simpleDERReader3.available() == 0) {
                simpleDERReader3.resetInput(sequenceAsByteArray3);
                BigInteger bigInteger10 = simpleDERReader3.readInt();
                if (bigInteger10.compareTo(BigInteger.ONE) != 0) {
                    throw new IOException("Wrong version (" + bigInteger10 + ") in EC PRIVATE KEY DER stream.");
                }
                byte[] octetString = simpleDERReader3.readOctetString();
                String oid = null;
                byte[] octetString2 = null;
                while (simpleDERReader3.available() > 0) {
                    int constructedType = simpleDERReader3.readConstructedType();
                    SimpleDERReader constructed = simpleDERReader3.readConstructed();
                    if (constructedType == 0) {
                        oid = constructed.readOid();
                    } else if (constructedType == 1) {
                        octetString2 = constructed.readOctetString();
                    }
                }
                ECDSASHA2Verify verifierForOID = ECDSASHA2Verify.getVerifierForOID(oid);
                if (verifierForOID != null) {
                    BigInteger bigInteger11 = new BigInteger(1, octetString);
                    int length = octetString2.length - 1;
                    byte[] bArr = new byte[length];
                    System.arraycopy(octetString2, 1, bArr, 0, length);
                    ECParameterSpec parameterSpec = verifierForOID.getParameterSpec();
                    return generateKeyPair("EC", new ECPrivateKeySpec(bigInteger11, parameterSpec), new ECPublicKeySpec(verifierForOID.decodeECPoint(bArr), parameterSpec));
                }
                str2 = "invalid OID";
            } else {
                str2 = "Padding in EC PRIVATE KEY DER stream.";
            }
        } else if (i == 4) {
            TypesReader typesReader = new TypesReader(pEMStructure.data);
            byte[] bArr2 = OPENSSH_V1_MAGIC;
            byte[] bytes2 = typesReader.readBytes(bArr2.length);
            if (!Arrays.equals(bArr2, bytes2)) {
                throw new IOException("Could not find OPENSSH key magic: ".concat(new String(bytes2)));
            }
            String string = typesReader.readString();
            String string2 = typesReader.readString();
            byte[] byteString = typesReader.readByteString();
            int uint32 = typesReader.readUINT32();
            if (uint32 != 1) {
                throw new IOException(ak.h(uint32, "Only one key supported, but encountered bundle of "));
            }
            typesReader.readByteString();
            byte[] byteString2 = typesReader.readByteString();
            if ("bcrypt".equals(string2)) {
                if (str == null) {
                    d.AnonymousClass0.m$6("PEM is encrypted, but no password was specified");
                    return null;
                }
                TypesReader typesReader2 = new TypesReader(byteString);
                byte[] byteString3 = typesReader2.readByteString();
                int uint33 = typesReader2.readUINT32();
                try {
                    bytes = str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException unused2) {
                    bytes = str.getBytes();
                }
                byteString2 = decryptData(byteString2, bytes, byteString3, uint33, string);
            } else if (!"none".equals(string) || !"none".equals(string2)) {
                str2 = "encryption not supported";
            }
            TypesReader typesReader3 = new TypesReader(byteString2);
            if (typesReader3.readUINT32() == typesReader3.readUINT32()) {
                String string3 = typesReader3.readString();
                if (Ed25519Verify.ED25519_ID.equals(string3)) {
                    keyPairGenerateKeyPair = new KeyPair(new Ed25519PublicKey(typesReader3.readByteString()), new Ed25519PrivateKey(Arrays.copyOfRange(typesReader3.readByteString(), 0, 32)));
                } else if (string3.startsWith(ECDSASHA2Verify.ECDSA_SHA2_PREFIX)) {
                    String string4 = typesReader3.readString();
                    byte[] byteString4 = typesReader3.readByteString();
                    BigInteger mpint = typesReader3.readMPINT();
                    if (string4.equals(ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().getCurveName())) {
                        eCDSASHA2Verify = ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get();
                    } else if (string4.equals(ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().getCurveName())) {
                        eCDSASHA2Verify = ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get();
                    } else if (string4.equals(ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().getCurveName())) {
                        eCDSASHA2Verify = ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get();
                    } else {
                        str2 = "Invalid ECDSA group";
                    }
                    ECParameterSpec parameterSpec2 = eCDSASHA2Verify.getParameterSpec();
                    keyPairGenerateKeyPair = generateKeyPair("EC", new ECPrivateKeySpec(mpint, parameterSpec2), new ECPublicKeySpec(eCDSASHA2Verify.decodeECPoint(byteString4), parameterSpec2));
                } else if (RSASHA1Verify.get().getKeyFormat().equals(string3)) {
                    BigInteger mpint2 = typesReader3.readMPINT();
                    BigInteger mpint3 = typesReader3.readMPINT();
                    BigInteger mpint4 = typesReader3.readMPINT();
                    BigInteger mpint5 = typesReader3.readMPINT();
                    BigInteger mpint6 = typesReader3.readMPINT();
                    if (mpint6 == null || mpint5 == null) {
                        rSAPrivateKeySpec = new RSAPrivateKeySpec(mpint2, mpint4);
                    } else {
                        BigInteger bigIntegerModInverse = mpint5.modInverse(mpint6);
                        BigInteger bigInteger12 = BigInteger.ONE;
                        rSAPrivateKeySpec = new RSAPrivateCrtKeySpec(mpint2, mpint3, mpint4, mpint6, bigIntegerModInverse, mpint4.mod(mpint6.subtract(bigInteger12)), mpint4.mod(bigIntegerModInverse.subtract(bigInteger12)), mpint5);
                    }
                    keyPairGenerateKeyPair = generateKeyPair("RSA", rSAPrivateKeySpec, new RSAPublicKeySpec(mpint2, mpint3));
                } else {
                    if (!DSASHA1Verify.get().getKeyFormat().equals(string3)) {
                        throw new IOException("Unknown key type ".concat(string3));
                    }
                    BigInteger mpint7 = typesReader3.readMPINT();
                    BigInteger mpint8 = typesReader3.readMPINT();
                    BigInteger mpint9 = typesReader3.readMPINT();
                    keyPairGenerateKeyPair = generateKeyPair("DSA", new DSAPrivateKeySpec(typesReader3.readMPINT(), mpint7, mpint8, mpint9), new DSAPublicKeySpec(typesReader3.readMPINT(), mpint7, mpint8, mpint9));
                }
                typesReader3.readByteString();
                int iRemain = typesReader.remain();
                for (int i2 = 1; i2 <= iRemain; i2++) {
                    if (i2 != typesReader.readByte()) {
                        str2 = "Bad padding value on decrypted private keys";
                    }
                }
                return keyPairGenerateKeyPair;
            }
            str2 = "Decryption failed when trying to read private keys";
        } else {
            str2 = "PEM problem: it is of unknown type";
        }
        d.AnonymousClass0.m$6(str2);
        return null;
    }

    public static KeyPair decode(char[] cArr, String str) {
        return decode(parsePEM(cArr), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.trilead.ssh2.crypto.cipher.BlockCipher] */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.trilead.ssh2.crypto.cipher.BlockCipher] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r5v35, types: [int] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [int] */
    /* JADX WARN: Type inference failed for: r6v33 */
    private static byte[] decryptData(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, String str) throws IOException {
        BlockCipher cbc;
        BlockCipher cbc2;
        BlockCipher cbc3;
        ?? r4;
        ?? r2;
        byte[] bArr4 = bArr3;
        String lowerCase = str.toLowerCase(Locale.US);
        int i2 = 24;
        if (lowerCase.equals("des-ede3-cbc")) {
            cbc3 = new DESede.CBC();
        } else if (lowerCase.equals("des-cbc")) {
            i2 = 8;
            cbc3 = new DES.CBC();
        } else {
            if (lowerCase.equals("aes-128-cbc") || lowerCase.equals("aes128-cbc")) {
                cbc = new AES.CBC();
            } else if (lowerCase.equals("aes-192-cbc") || lowerCase.equals("aes192-cbc")) {
                cbc3 = new AES.CBC();
            } else {
                if (lowerCase.equals("aes-256-cbc") || lowerCase.equals("aes256-cbc")) {
                    cbc2 = new AES.CBC();
                } else if (lowerCase.equals("aes-128-ctr") || lowerCase.equals("aes128-ctr")) {
                    cbc = new AES.CTR();
                } else if (lowerCase.equals("aes-192-ctr") || lowerCase.equals("aes192-ctr")) {
                    cbc3 = new AES.CTR();
                } else {
                    if (!lowerCase.equals("aes-256-ctr") && !lowerCase.equals("aes256-ctr")) {
                        throw new IOException("Cannot decrypt PEM structure, unknown cipher ".concat(str));
                    }
                    cbc2 = new AES.CTR();
                }
                i2 = 32;
                cbc3 = cbc2;
            }
            i2 = 16;
            cbc3 = cbc;
        }
        if (i == -1) {
            cbc3.init(false, generateKeyFromPasswordSaltWithMD5(bArr2, bArr4, i2), bArr4);
            r2 = 0;
            r4 = cbc3;
        } else {
            byte[] bArr5 = new byte[i2];
            int blockSize = cbc3.getBlockSize();
            byte[] bArr6 = new byte[blockSize];
            int i3 = i2 + blockSize;
            byte[] bArr7 = new byte[i3];
            g gVar = new g(19);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(SignatureProxy.SHA512);
                int i4 = (i3 + 31) / 32;
                byte[] bArrDigest = messageDigest.digest(bArr2);
                int i5 = 0;
                byte[] bArr8 = new byte[64];
                byte[] bArr9 = new byte[32];
                BlockCipher blockCipher = cbc3;
                byte[] bArr10 = new byte[32];
                int i6 = 1;
                while (i6 <= i4) {
                    int i7 = i4;
                    byte[] bArr11 = new byte[4];
                    bArr11[i5] = (byte) ((i6 >> 24) & 255);
                    bArr11[1] = (byte) ((i6 >> 16) & 255);
                    bArr11[2] = (byte) ((i6 >> 8) & 255);
                    bArr11[3] = (byte) (i6 & 255);
                    messageDigest.reset();
                    messageDigest.update(bArr4);
                    messageDigest.update(bArr11);
                    int i8 = i5;
                    messageDigest.digest(bArr8, i8, 64);
                    gVar.hash(bArrDigest, bArr8, bArr9);
                    System.arraycopy(bArr9, i8, bArr10, i8, 32);
                    int i9 = 1;
                    while (i9 < i) {
                        messageDigest.reset();
                        messageDigest.update(bArr10);
                        int i10 = i9;
                        messageDigest.digest(bArr8, i8, 64);
                        gVar.hash(bArrDigest, bArr8, bArr10);
                        for (int i11 = 0; i11 < 32; i11++) {
                            bArr9[i11] = (byte) (bArr9[i11] ^ bArr10[i11]);
                        }
                        i9 = i10 + 1;
                        i8 = 0;
                    }
                    for (int i12 = 0; i12 < 32; i12++) {
                        int i13 = (i6 - 1) + (i12 * i7);
                        if (i13 < i3) {
                            bArr7[i13] = bArr9[i12];
                        }
                    }
                    i6++;
                    bArr4 = bArr3;
                    i4 = i7;
                    i5 = 0;
                }
                ?? r3 = i5;
                System.arraycopy(bArr7, r3 == true ? 1 : 0, bArr5, r3 == true ? 1 : 0, i2);
                System.arraycopy(bArr7, i2, bArr6, r3 == true ? 1 : 0, blockSize);
                ?? r5 = blockCipher;
                r5.init(r3, bArr5, bArr6);
                r2 = r3;
                r4 = r5;
            } catch (DigestException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        if (bArr.length % r4.getBlockSize() != 0) {
            throw new IOException("Invalid PEM structure, size of encrypted block is not a multiple of " + r4.getBlockSize());
        }
        byte[] bArr12 = new byte[bArr.length];
        for (?? r6 = r2; r6 < bArr.length / r4.getBlockSize(); r6++) {
            r4.transformBlock(bArr, r4.getBlockSize() * r6, bArr12, r4.getBlockSize() * r6);
        }
        return i == -1 ? removePadding(bArr12, r4.getBlockSize()) : bArr12;
    }

    private static void decryptPEM(PEMStructure pEMStructure, byte[] bArr) throws IOException {
        String[] strArr = pEMStructure.dekInfo;
        if (strArr == null) {
            d.AnonymousClass0.m$6("Broken PEM, no mode and salt given, but encryption enabled");
            return;
        }
        if (strArr.length != 2) {
            d.AnonymousClass0.m$6("Broken PEM, DEK-Info is incomplete!");
            return;
        }
        String str = strArr[0];
        pEMStructure.data = decryptData(pEMStructure.data, bArr, hexToByteArray(strArr[1]), -1, str);
        pEMStructure.dekInfo = null;
        pEMStructure.procType = null;
    }

    private static byte[] generateKeyFromPasswordSaltWithMD5(byte[] bArr, byte[] bArr2, int i) throws IOException {
        if (bArr2.length < 8) {
            d.AnonymousClass0.m$2("Salt needs to be at least 8 bytes for key generation.");
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr3 = new byte[i];
            int digestLength = messageDigest.getDigestLength();
            byte[] bArr4 = new byte[digestLength];
            int i2 = i;
            while (true) {
                messageDigest.update(bArr, 0, bArr.length);
                messageDigest.update(bArr2, 0, 8);
                int i3 = i2 < digestLength ? i2 : digestLength;
                try {
                    messageDigest.digest(bArr4, 0, digestLength);
                    System.arraycopy(bArr4, 0, bArr3, i - i2, i3);
                    i2 -= i3;
                    if (i2 == 0) {
                        return bArr3;
                    }
                    messageDigest.update(bArr4, 0, digestLength);
                } catch (DigestException e) {
                    d.AnonymousClass0.m("could not digest password", (Throwable) e);
                    return null;
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException("VM does not support MD5", e2);
        }
    }

    private static KeyPair generateKeyPair(String str, KeySpec keySpec, KeySpec keySpec2) throws IOException {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(str);
            return new KeyPair(keyFactory.generatePublic(keySpec2), keyFactory.generatePrivate(keySpec));
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        } catch (InvalidKeySpecException e2) {
            d.AnonymousClass0.m("invalid keyspec", (Throwable) e2);
            return null;
        }
    }

    private static byte[] hexToByteArray(String str) {
        String str2;
        if (str == null) {
            str2 = "null argument";
        } else {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((hexToInt(str.charAt(i2)) * 16) + hexToInt(str.charAt(i2 + 1)));
                }
                return bArr;
            }
            str2 = "Uneven string length in hex encoding.";
        }
        d.AnonymousClass0.m$2(str2);
        return null;
    }

    private static int hexToInt(char c) {
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                if (c >= '0' && c <= '9') {
                    return c - '0';
                }
                d.AnonymousClass0.m$2("Need hex char");
                return 0;
            }
        }
        return (c - c2) + 10;
    }

    public static final boolean isPEMEncrypted(PEMStructure pEMStructure) throws IOException {
        if (pEMStructure.pemType == 4) {
            TypesReader typesReader = new TypesReader(pEMStructure.data);
            byte[] bArr = OPENSSH_V1_MAGIC;
            byte[] bytes = typesReader.readBytes(bArr.length);
            if (!Arrays.equals(bArr, bytes)) {
                throw new IOException("Could not find OPENSSH key magic: ".concat(new String(bytes)));
            }
            typesReader.readString();
            return !"none".equals(typesReader.readString());
        }
        String[] strArr = pEMStructure.procType;
        if (strArr == null) {
            return false;
        }
        if (strArr.length != 2) {
            d.AnonymousClass0.m$6("Unknown Proc-Type field.");
            return false;
        }
        if ("4".equals(strArr[0])) {
            return "ENCRYPTED".equals(pEMStructure.procType[1]);
        }
        throw new IOException(fb$1.m(new StringBuilder("Unknown Proc-Type field ("), pEMStructure.procType[0], ")"));
    }

    public static final PEMStructure parsePEM(char[] cArr) throws IOException {
        String str;
        String str2;
        PEMStructure pEMStructure = new PEMStructure();
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(cArr));
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String strTrim = line.trim();
                if (strTrim.startsWith("-----BEGIN DSA PRIVATE KEY-----")) {
                    pEMStructure.pemType = 2;
                    str2 = "-----END DSA PRIVATE KEY-----";
                    break;
                }
                if (strTrim.startsWith("-----BEGIN RSA PRIVATE KEY-----")) {
                    pEMStructure.pemType = 1;
                    str2 = "-----END RSA PRIVATE KEY-----";
                    break;
                }
                if (strTrim.startsWith("-----BEGIN EC PRIVATE KEY-----")) {
                    pEMStructure.pemType = 3;
                    str2 = "-----END EC PRIVATE KEY-----";
                    break;
                }
                if (strTrim.startsWith("-----BEGIN OPENSSH PRIVATE KEY-----")) {
                    pEMStructure.pemType = 4;
                    str2 = "-----END OPENSSH PRIVATE KEY-----";
                    break;
                }
            } else {
                str = "Invalid PEM structure, '-----BEGIN...' missing";
            }
            d.AnonymousClass0.m$6(str);
            return null;
        }
        while (true) {
            String line2 = bufferedReader.readLine();
            if (line2 == null) {
                throw new IOException(e.n("Invalid PEM structure, ", str2, " missing"));
            }
            String strTrim2 = line2.trim();
            int iIndexOf = strTrim2.indexOf(58);
            if (iIndexOf == -1) {
                StringBuffer stringBuffer = new StringBuffer();
                while (strTrim2 != null) {
                    String strTrim3 = strTrim2.trim();
                    if (strTrim3.startsWith(str2)) {
                        int length = stringBuffer.length();
                        char[] cArr2 = new char[length];
                        stringBuffer.getChars(0, length, cArr2, 0);
                        byte[] bArrDecode = Base64.decode(cArr2);
                        pEMStructure.data = bArrDecode;
                        if (bArrDecode.length != 0) {
                            return pEMStructure;
                        }
                        str = "Invalid PEM structure, no data available";
                        d.AnonymousClass0.m$6(str);
                        return null;
                    }
                    stringBuffer.append(strTrim3);
                    strTrim2 = bufferedReader.readLine();
                }
                throw new IOException(e.n("Invalid PEM structure, ", str2, " missing"));
            }
            int i = iIndexOf + 1;
            String strSubstring = strTrim2.substring(0, i);
            String[] strArrSplit = strTrim2.substring(i).split(",");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                strArrSplit[i2] = strArrSplit[i2].trim();
            }
            if ("Proc-Type:".equals(strSubstring)) {
                pEMStructure.procType = strArrSplit;
            } else if ("DEK-Info:".equals(strSubstring)) {
                pEMStructure.dekInfo = strArrSplit;
            }
        }
    }

    private static byte[] removePadding(byte[] bArr, int i) throws IOException {
        int i2 = bArr[bArr.length - 1] & 255;
        if (i2 >= 1 && i2 <= i) {
            for (int i3 = 2; i3 <= i2; i3++) {
                if (bArr[bArr.length - i3] == i2) {
                }
            }
            byte[] bArr2 = new byte[bArr.length - i2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length - i2);
            return bArr2;
        }
        d.AnonymousClass0.m$6("Decrypted PEM has wrong padding, did you specify the correct password?");
        return null;
    }
}
