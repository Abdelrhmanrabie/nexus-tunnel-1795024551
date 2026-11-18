package com.trilead.ssh2.crypto.cipher;

import defpackage.ak;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AES implements BlockCipher {
    private final int AES_BLOCK_SIZE = 16;
    protected Cipher cipher;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CBC extends AES {
        public CBC() {
            try {
                this.cipher = Cipher.getInstance("AES/CBC/NoPadding");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalArgumentException("Cannot initialize AES/CBC/NoPadding", e);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CTR extends AES {
        public CTR() {
            try {
                this.cipher = Cipher.getInstance("AES/CTR/NoPadding");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalArgumentException("Cannot initialize AES/CBC/NoPadding", e);
            }
        }
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr, byte[] bArr2) {
        try {
            this.cipher.init(z ? 1 : 2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
            throw new IllegalArgumentException(ak.AnonymousClass0.m("Cannot initialize ", this.cipher.getAlgorithm()), e);
        }
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        try {
            this.cipher.update(bArr, i, 16, bArr2, i2);
        } catch (ShortBufferException e) {
            throw new AssertionError(e);
        }
    }
}
