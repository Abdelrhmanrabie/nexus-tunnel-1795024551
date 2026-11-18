package com.trilead.ssh2.crypto.dh;

import com.trilead.ssh2.signature.ECDSASHA2Verify;
import defpackage.ak;
import defpackage.d;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.KeyAgreement;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class EcDhExchange extends GenericDhExchange {
    private ECPrivateKey clientPrivate;
    private ECPublicKey clientPublic;
    private ECPublicKey serverPublic;

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public byte[] getE() {
        return ECDSASHA2Verify.encodeECPoint(this.clientPublic.getW(), this.clientPublic.getParams().getCurve());
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public String getHashAlgo() {
        return ECDSASHA2Verify.getDigestAlgorithmForParams(this.clientPublic);
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public byte[] getServerE() {
        return ECDSASHA2Verify.encodeECPoint(this.serverPublic.getW(), this.serverPublic.getParams().getCurve());
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public void init(String str) throws IOException {
        ECParameterSpec parameterSpec;
        String str2;
        if ("ecdh-sha2-nistp256".equals(str)) {
            parameterSpec = ECDSASHA2Verify.ECDSASHA2NISTP256Verify.get().getParameterSpec();
        } else if ("ecdh-sha2-nistp384".equals(str)) {
            parameterSpec = ECDSASHA2Verify.ECDSASHA2NISTP384Verify.get().getParameterSpec();
        } else {
            if (!"ecdh-sha2-nistp521".equals(str)) {
                throw new IllegalArgumentException(ak.m("Unknown EC curve ", str));
            }
            parameterSpec = ECDSASHA2Verify.ECDSASHA2NISTP521Verify.get().getParameterSpec();
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(parameterSpec);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            this.clientPrivate = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
            this.clientPublic = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            str2 = "Invalid DH parameters";
            d.AnonymousClass0.m(str2, e);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str2 = "No DH keypair generator";
            d.AnonymousClass0.m(str2, e);
        }
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public void setF(byte[] bArr) throws IOException {
        if (this.clientPublic == null) {
            d.AnonymousClass0.m("DhDsaExchange not initialized!");
            return;
        }
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            ECDSASHA2Verify verifierForKey = ECDSASHA2Verify.getVerifierForKey(this.clientPublic);
            if (verifierForKey == null) {
                throw new IOException("No such EC group");
            }
            this.serverPublic = (ECPublicKey) keyFactory.generatePublic(new ECPublicKeySpec(verifierForKey.decodeECPoint(bArr), verifierForKey.getParameterSpec()));
            KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
            keyAgreement.init(this.clientPrivate);
            keyAgreement.doPhase(this.serverPublic, true);
            this.sharedSecret = new BigInteger(1, keyAgreement.generateSecret());
        } catch (InvalidKeyException e) {
            e = e;
            d.AnonymousClass0.m("Invalid ECDH key", e);
        } catch (NoSuchAlgorithmException e2) {
            d.AnonymousClass0.m("No ECDH key agreement method", (Throwable) e2);
        } catch (InvalidKeySpecException e3) {
            e = e3;
            d.AnonymousClass0.m("Invalid ECDH key", e);
        }
    }
}
