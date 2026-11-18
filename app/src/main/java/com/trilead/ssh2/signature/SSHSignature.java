package com.trilead.ssh2.signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface SSHSignature {
    PublicKey decodePublicKey(byte[] bArr);

    byte[] encodePublicKey(PublicKey publicKey);

    byte[] generateSignature(byte[] bArr, PrivateKey privateKey, SecureRandom secureRandom);

    String getKeyFormat();

    boolean verifySignature(byte[] bArr, byte[] bArr2, PublicKey publicKey);
}
