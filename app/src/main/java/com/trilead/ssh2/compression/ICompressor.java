package com.trilead.ssh2.compression;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface ICompressor {
    boolean canCompressPreauth();

    int compress(byte[] bArr, int i, int i2, byte[] bArr2);

    int getBufferSize();

    byte[] uncompress(byte[] bArr, int i, int[] iArr);
}
