package com.trilead.ssh2.crypto.keys;

import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519KeyPairGenerator extends KeyPairGeneratorSpi {
    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        try {
            byte[] bArr = new byte[32];
            ((SecureRandom) Random.localRandom.get()).nextBytes(bArr);
            return new KeyPair(new Ed25519PublicKey(Arrays.copyOf(Hex.scalarMultWithBase(Hex.getHashedScalar(bArr)).toBytes(), 32)), new Ed25519PrivateKey(Arrays.copyOf(bArr, 32)));
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
    }
}
