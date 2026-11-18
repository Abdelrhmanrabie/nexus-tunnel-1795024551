package com.trilead.ssh2.crypto.cipher;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface BlockCipher {
    int getBlockSize();

    void init(boolean z, byte[] bArr, byte[] bArr2);

    void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2);
}
