package com.trilead.ssh2.signature;

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
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RSASHA1Verify implements SSHSignature {
    public static final String ID_SSH_RSA = "ssh-rsa";
    private static final Logger log = Logger.getLogger(RSASHA1Verify.class);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class InstanceHolder {
        private static RSASHA1Verify sInstance = new RSASHA1Verify();

        private InstanceHolder() {
        }
    }

    private RSASHA1Verify() {
    }

    private static byte[] decodeSignature(byte[] bArr) throws IOException {
        String str;
        TypesReader typesReader = new TypesReader(bArr);
        if (typesReader.readString().equals(ID_SSH_RSA)) {
            byte[] byteString = typesReader.readByteString();
            if (byteString.length != 0) {
                Logger logger = log;
                if (logger.isEnabled()) {
                    logger.log(80, "Decoding ssh-rsa signature string (length: " + byteString.length + ")");
                }
                if (typesReader.remain() == 0) {
                    return byteString;
                }
                str = "Padding in RSA signature!";
            } else {
                str = "Error in RSA signature, S is empty.";
            }
        } else {
            str = "Peer sent wrong signature format";
        }
        d.AnonymousClass0.m$6(str);
        return null;
    }

    private static byte[] encodeSignature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ID_SSH_RSA);
        if (bArr.length <= 1 || bArr[0] != 0) {
            typesWriter.writeString(bArr, 0, bArr.length);
        } else {
            typesWriter.writeString(bArr, 1, bArr.length - 1);
        }
        return typesWriter.getBytes();
    }

    public static RSASHA1Verify get() {
        return InstanceHolder.sInstance;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public PublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(ID_SSH_RSA)) {
            d.AnonymousClass0.m$2("This is not a ssh-rsa public key");
            return null;
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        if (typesReader.remain() != 0) {
            d.AnonymousClass0.m$6("Padding in RSA public key!");
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(mpint2, mpint));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            d.AnonymousClass0.m("No RSA KeyFactory available", e);
            return null;
        }
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] encodePublicKey(PublicKey publicKey) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ID_SSH_RSA);
        typesWriter.writeMPInt(rSAPublicKey.getPublicExponent());
        typesWriter.writeMPInt(rSAPublicKey.getModulus());
        return typesWriter.getBytes();
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] generateSignature(byte[] bArr, PrivateKey privateKey, SecureRandom secureRandom) throws IOException {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(privateKey, secureRandom);
            signature.update(bArr);
            return encodeSignature(signature.sign());
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new IOException(e);
        }
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public String getKeyFormat() {
        return ID_SSH_RSA;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public boolean verifySignature(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws IOException {
        byte[] bArrDecodeSignature = decodeSignature(bArr2);
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArrDecodeSignature);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new IOException(e);
        }
    }
}
