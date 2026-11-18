package com.trilead.ssh2.crypto.cipher;

import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DESede extends DES {
    private boolean encrypt;
    private int[] key1 = null;
    private int[] key2 = null;
    private int[] key3 = null;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CBC extends Wrapper {
        public CBC() {
            super();
        }

        @Override // com.trilead.ssh2.crypto.cipher.DESede.Wrapper, com.trilead.ssh2.crypto.cipher.BlockCipher
        public /* bridge */ /* synthetic */ int getBlockSize() {
            return super.getBlockSize();
        }

        @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
        public void init(boolean z, byte[] bArr, byte[] bArr2) {
            DESede dESede = new DESede();
            dESede.init(z, bArr, bArr2);
            this.bc = new CBCMode(dESede, bArr2, z);
        }

        @Override // com.trilead.ssh2.crypto.cipher.DESede.Wrapper, com.trilead.ssh2.crypto.cipher.BlockCipher
        public /* bridge */ /* synthetic */ void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
            super.transformBlock(bArr, i, bArr2, i2);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CTR extends Wrapper {
        public CTR() {
            super();
        }

        @Override // com.trilead.ssh2.crypto.cipher.DESede.Wrapper, com.trilead.ssh2.crypto.cipher.BlockCipher
        public /* bridge */ /* synthetic */ int getBlockSize() {
            return super.getBlockSize();
        }

        @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
        public void init(boolean z, byte[] bArr, byte[] bArr2) {
            DESede dESede = new DESede();
            dESede.init(true, bArr, bArr2);
            this.bc = new CTRMode(dESede, bArr2, z);
        }

        @Override // com.trilead.ssh2.crypto.cipher.DESede.Wrapper, com.trilead.ssh2.crypto.cipher.BlockCipher
        public /* bridge */ /* synthetic */ void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
            super.transformBlock(bArr, i, bArr2, i2);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class Wrapper implements BlockCipher {
        protected BlockCipher bc;

        private Wrapper() {
        }

        @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
        public int getBlockSize() {
            return this.bc.getBlockSize();
        }

        @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
        public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
            this.bc.transformBlock(bArr, i, bArr2, i2);
        }
    }

    @Override // com.trilead.ssh2.crypto.cipher.DES
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // com.trilead.ssh2.crypto.cipher.DES, com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr, byte[] bArr2) {
        this.key1 = generateWorkingKey(z, bArr, 0);
        this.key2 = generateWorkingKey(!z, bArr, 8);
        this.key3 = generateWorkingKey(z, bArr, 16);
        this.encrypt = z;
    }

    @Override // com.trilead.ssh2.crypto.cipher.DES, com.trilead.ssh2.crypto.cipher.BlockCipher
    public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.key1;
        if (iArr == null) {
            d.AnonymousClass0.m("DESede engine not initialised!");
            return;
        }
        if (this.encrypt) {
            desFunc(iArr, bArr, i, bArr2, i2);
            desFunc(this.key2, bArr2, i2, bArr2, i2);
            desFunc(this.key3, bArr2, i2, bArr2, i2);
        } else {
            desFunc(this.key3, bArr, i, bArr2, i2);
            desFunc(this.key2, bArr2, i2, bArr2, i2);
            desFunc(this.key1, bArr2, i2, bArr2, i2);
        }
    }
}
