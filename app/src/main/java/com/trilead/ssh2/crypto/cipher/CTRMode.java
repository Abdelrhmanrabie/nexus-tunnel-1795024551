package com.trilead.ssh2.crypto.cipher;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CTRMode implements BlockCipher {
    byte[] X;
    byte[] Xenc;
    BlockCipher bc;
    int blockSize;
    int count = 0;
    boolean doEncrypt;

    public CTRMode(BlockCipher blockCipher, byte[] bArr, boolean z) {
        this.bc = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.doEncrypt = z;
        if (blockSize == bArr.length) {
            byte[] bArr2 = new byte[blockSize];
            this.X = bArr2;
            this.Xenc = new byte[blockSize];
            System.arraycopy(bArr, 0, bArr2, 0, blockSize);
            return;
        }
        throw new IllegalArgumentException("IV must be " + this.blockSize + " bytes long! (currently " + bArr.length + ")");
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public final int getBlockSize() {
        return this.blockSize;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public final void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        byte b;
        int i4 = 0;
        this.bc.transformBlock(this.X, 0, this.Xenc, 0);
        while (true) {
            i3 = this.blockSize;
            if (i4 >= i3) {
                break;
            }
            bArr2[i2 + i4] = (byte) (bArr[i + i4] ^ this.Xenc[i4]);
            i4++;
        }
        do {
            i3--;
            if (i3 < 0) {
                return;
            }
            byte[] bArr3 = this.X;
            b = (byte) (bArr3[i3] + 1);
            bArr3[i3] = b;
        } while (b == 0);
    }
}
