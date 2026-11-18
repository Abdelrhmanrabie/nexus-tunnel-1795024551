package com.google.zxing;

import com.jcraft.jzlib.GZIPHeader;
import defpackage.xt;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class InvertedLuminanceSource extends xt.c {
    public final RGBLuminanceSource delegate;

    public InvertedLuminanceSource(RGBLuminanceSource rGBLuminanceSource) {
        super(rGBLuminanceSource.b, rGBLuminanceSource.a, 1);
        this.delegate = rGBLuminanceSource;
    }

    @Override // xt.c
    public final byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int i = this.a * this.b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (matrix[i2] & GZIPHeader.OS_UNKNOWN));
        }
        return bArr;
    }

    @Override // xt.c
    public final byte[] getRow(byte[] bArr, int i) {
        byte[] row = this.delegate.getRow(bArr, i);
        for (int i2 = 0; i2 < this.b; i2++) {
            row[i2] = (byte) (255 - (row[i2] & GZIPHeader.OS_UNKNOWN));
        }
        return row;
    }
}
