package com.google.zxing;

import defpackage.ak;
import defpackage.xt;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class RGBLuminanceSource extends xt.c {
    public final int dataHeight;
    public final int dataWidth;
    public final byte[] luminances;

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2, 1);
        this.dataWidth = i;
        this.dataHeight = i2;
        int i3 = i * i2;
        this.luminances = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.luminances[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    @Override // xt.c
    public final byte[] getMatrix() {
        byte[] bArr = this.luminances;
        int i = this.b;
        int i2 = this.a;
        int i3 = this.dataWidth;
        if (i == i3 && i2 == this.dataHeight) {
            return bArr;
        }
        int i4 = i * i2;
        byte[] bArr2 = new byte[i4];
        if (i == i3) {
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            return bArr2;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            System.arraycopy(bArr, i5, bArr2, i6 * i, i);
            i5 += i3;
        }
        return bArr2;
    }

    @Override // xt.c
    public final byte[] getRow(byte[] bArr, int i) {
        if (i < 0 || i >= this.a) {
            throw new IllegalArgumentException(ak.h(i, "Requested row is outside the image: "));
        }
        int i2 = this.b;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.luminances, i * this.dataWidth, bArr, 0, i2);
        return bArr;
    }
}
