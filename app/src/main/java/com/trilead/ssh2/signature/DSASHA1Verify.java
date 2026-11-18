package com.trilead.ssh2.signature;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import defpackage.d;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DSASHA1Verify implements SSHSignature {
    public static final String ID_SSH_DSS = "ssh-dss";
    private static final Logger log = Logger.getLogger(DSASHA1Verify.class);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class InstanceHolder {
        private static DSASHA1Verify sInstance = new DSASHA1Verify();

        private InstanceHolder() {
        }
    }

    private DSASHA1Verify() {
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[PHI: r12
      0x0024: PHI (r12v1 byte[] A[IMMUTABLE_TYPE]) = (r12v0 byte[]), (r12v10 byte[]) binds: [B:3:0x0003, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0077  */
    /* JADX WARN: Code duplicated, block: B:21:0x0079  */
    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    private byte[] decodeSignature(byte[] bArr) throws IOException {
        byte b;
        int i;
        byte b2;
        byte[] bArr2;
        byte b3;
        byte b4;
        String str;
        if (bArr.length == 40) {
            b = bArr[0];
            if (b == 0 && (b3 = bArr[1]) == 0 && (b4 = bArr[2]) == 0) {
                int i2 = ((b << 24) & (-16777216)) | ((b3 << 16) & 16711680) | ((b4 << 8) & 65280) | (bArr[3] & GZIPHeader.OS_UNKNOWN);
                int i3 = ((bArr[i2 + 4] << 24) & (-16777216)) | (16711680 & (bArr[i2 + 5] << 16)) | (65280 & (bArr[i2 + 6] << 8)) | (bArr[i2 + 7] & 255);
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr, i2 + 8, bArr3, 0, i3);
                bArr = bArr3;
            }
            if ((bArr[0] & 128) != 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((bArr[20] & 128) != 0) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            bArr2 = new byte[bArr.length + 6 + i + b2];
            bArr2[0] = 48;
            if (bArr.length == 40) {
                bArr2[1] = 44;
                byte b5 = (byte) (i + 44);
                bArr2[1] = b5;
                bArr2[1] = (byte) (b5 + b2);
                bArr2[2] = 2;
                bArr2[3] = 20;
                bArr2[3] = (byte) (i + 20);
                System.arraycopy(bArr, 0, bArr2, i + 4, 20);
                bArr2[bArr2[3] + 4] = 2;
                bArr2[bArr2[3] + 5] = 20;
                int i4 = bArr2[3] + 5;
                bArr2[i4] = (byte) (bArr2[i4] + b2);
                System.arraycopy(bArr, 20, bArr2, bArr2[3] + 6 + b2, 20);
                return bArr2;
            }
            str = "Peer sent corrupt signature";
        } else {
            TypesReader typesReader = new TypesReader(bArr);
            if (typesReader.readString().equals(ID_SSH_DSS)) {
                bArr = typesReader.readByteString();
                if (bArr.length != 40) {
                    str = "Peer sent corrupt signature";
                } else if (typesReader.remain() == 0) {
                    b = bArr[0];
                    if (b == 0) {
                        int i5 = ((b << 24) & (-16777216)) | ((b3 << 16) & 16711680) | ((b4 << 8) & 65280) | (bArr[3] & GZIPHeader.OS_UNKNOWN);
                        int i6 = ((bArr[i5 + 4] << 24) & (-16777216)) | (16711680 & (bArr[i5 + 5] << 16)) | (65280 & (bArr[i5 + 6] << 8)) | (bArr[i5 + 7] & 255);
                        byte[] bArr4 = new byte[i6];
                        System.arraycopy(bArr, i5 + 8, bArr4, 0, i6);
                        bArr = bArr4;
                    }
                    if ((bArr[0] & 128) != 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((bArr[20] & 128) != 0) {
                        b2 = 1;
                    } else {
                        b2 = 0;
                    }
                    bArr2 = new byte[bArr.length + 6 + i + b2];
                    bArr2[0] = 48;
                    if (bArr.length == 40) {
                        bArr2[1] = 44;
                        byte b6 = (byte) (i + 44);
                        bArr2[1] = b6;
                        bArr2[1] = (byte) (b6 + b2);
                        bArr2[2] = 2;
                        bArr2[3] = 20;
                        bArr2[3] = (byte) (i + 20);
                        System.arraycopy(bArr, 0, bArr2, i + 4, 20);
                        bArr2[bArr2[3] + 4] = 2;
                        bArr2[bArr2[3] + 5] = 20;
                        int i7 = bArr2[3] + 5;
                        bArr2[i7] = (byte) (bArr2[i7] + b2);
                        System.arraycopy(bArr, 20, bArr2, bArr2[3] + 6 + b2, 20);
                        return bArr2;
                    }
                    str = "Peer sent corrupt signature";
                } else {
                    str = "Padding in DSA signature!";
                }
            } else {
                str = "Peer sent wrong signature format";
            }
        }
        d.AnonymousClass0.m$6(str);
        return null;
    }

    private static byte[] encodeSignature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ID_SSH_DSS);
        int i = bArr[3] & 255;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 4, bArr2, 0, i);
        int i2 = bArr[i + 5] & 255;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, i + 6, bArr3, 0, i2);
        byte[] bArr4 = new byte[40];
        int i3 = i < 20 ? i : 20;
        int i4 = i2 < 20 ? i2 : 20;
        System.arraycopy(bArr2, i - i3, bArr4, 20 - i3, i3);
        System.arraycopy(bArr3, i2 - i4, bArr4, 40 - i4, i4);
        typesWriter.writeString(bArr4, 0, 40);
        return typesWriter.getBytes();
    }

    public static DSASHA1Verify get() {
        return InstanceHolder.sInstance;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public PublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(ID_SSH_DSS)) {
            d.AnonymousClass0.m$2("This is not a ssh-dss public key!");
            return null;
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        BigInteger mpint3 = typesReader.readMPINT();
        BigInteger mpint4 = typesReader.readMPINT();
        if (typesReader.remain() != 0) {
            d.AnonymousClass0.m$6("Padding in DSA public key!");
            return null;
        }
        try {
            return (DSAPublicKey) KeyFactory.getInstance("DSA").generatePublic(new DSAPublicKeySpec(mpint4, mpint, mpint2, mpint3));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IOException(e);
        }
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] encodePublicKey(PublicKey publicKey) {
        DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ID_SSH_DSS);
        DSAParams params = dSAPublicKey.getParams();
        typesWriter.writeMPInt(params.getP());
        typesWriter.writeMPInt(params.getQ());
        typesWriter.writeMPInt(params.getG());
        typesWriter.writeMPInt(dSAPublicKey.getY());
        return typesWriter.getBytes();
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] generateSignature(byte[] bArr, PrivateKey privateKey, SecureRandom secureRandom) throws IOException {
        try {
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initSign(privateKey);
            signature.update(bArr);
            return encodeSignature(signature.sign());
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new IOException(e);
        }
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public String getKeyFormat() {
        return ID_SSH_DSS;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public boolean verifySignature(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws IOException {
        byte[] bArrDecodeSignature = decodeSignature(bArr2);
        try {
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArrDecodeSignature);
        } catch (InvalidKeyException e) {
            e = e;
            d.AnonymousClass0.m("No such algorithm", e);
            return false;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            d.AnonymousClass0.m("No such algorithm", e);
            return false;
        } catch (SignatureException e3) {
            throw new IOException(e3);
        }
    }
}
