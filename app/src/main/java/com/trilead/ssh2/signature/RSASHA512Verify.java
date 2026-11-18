package com.trilead.ssh2.signature;

import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import defpackage.d;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RSASHA512Verify implements SSHSignature {
    public static final String ID_RSA_SHA_2_512 = "rsa-sha2-512";
    private static final Logger log = Logger.getLogger(RSASHA512Verify.class);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class InstanceHolder {
        private static final RSASHA512Verify sInstance = new RSASHA512Verify();

        private InstanceHolder() {
        }
    }

    private RSASHA512Verify() {
    }

    private static byte[] decodeRSASHA512Signature(byte[] bArr) throws IOException {
        String str;
        TypesReader typesReader = new TypesReader(bArr);
        if (typesReader.readString().equals(ID_RSA_SHA_2_512)) {
            byte[] byteString = typesReader.readByteString();
            if (byteString.length != 0) {
                Logger logger = log;
                if (logger.isEnabled()) {
                    logger.log(80, "Decoding rsa-sha2-512 signature string (length: " + byteString.length + ")");
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

    private static byte[] encodeRSASHA512Signature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ID_RSA_SHA_2_512);
        if (bArr.length <= 1 || bArr[0] != 0) {
            typesWriter.writeString(bArr, 0, bArr.length);
        } else {
            typesWriter.writeString(bArr, 1, bArr.length - 1);
        }
        return typesWriter.getBytes();
    }

    public static RSASHA512Verify get() {
        return InstanceHolder.sInstance;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public PublicKey decodePublicKey(byte[] bArr) {
        return RSASHA1Verify.get().decodePublicKey(bArr);
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] encodePublicKey(PublicKey publicKey) {
        return RSASHA1Verify.get().encodePublicKey(publicKey);
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public byte[] generateSignature(byte[] bArr, PrivateKey privateKey, SecureRandom secureRandom) throws IOException {
        try {
            Signature signature = Signature.getInstance("SHA512withRSA");
            signature.initSign(privateKey, secureRandom);
            signature.update(bArr);
            return encodeRSASHA512Signature(signature.sign());
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new IOException(e);
        }
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public String getKeyFormat() {
        return ID_RSA_SHA_2_512;
    }

    @Override // com.trilead.ssh2.signature.SSHSignature
    public boolean verifySignature(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws IOException {
        byte[] bArrDecodeRSASHA512Signature = decodeRSASHA512Signature(bArr2);
        try {
            Signature signature = Signature.getInstance("SHA512withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArrDecodeRSASHA512Signature);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new IOException(e);
        }
    }
}
