package com.google.zxing.common;

import defpackage.d;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class BitMatrix implements Cloneable {
    public final int[] bits;
    public final int height;
    public final int rowSize;
    public final int width;

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            d.AnonymousClass0.m$2("Both dimensions must be greater than 0");
            throw null;
        }
        this.width = i;
        this.height = i2;
        int i3 = (i + 31) / 32;
        this.rowSize = i3;
        this.bits = new int[i3 * i2];
    }

    public BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public final Object clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public final void flip(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.rowSize);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public final boolean get(int i, int i2) {
        return ((this.bits[(i / 32) + (i2 * this.rowSize)] >>> (i & 31)) & 1) != 0;
    }

    public final int hashCode() {
        int i = this.width;
        return Arrays.hashCode(this.bits) + (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31);
    }

    public final void set(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.rowSize);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void setRegion(int i, int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i < 0) {
            str = "Left and top must be nonnegative";
        } else if (i4 <= 0 || i3 <= 0) {
            str = "Height and width must be at least 1";
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 <= this.height && i5 <= this.width) {
                while (i2 < i6) {
                    int i7 = this.rowSize * i2;
                    for (int i8 = i; i8 < i5; i8++) {
                        int i9 = (i8 / 32) + i7;
                        int[] iArr = this.bits;
                        iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                    }
                    i2++;
                }
                return;
            }
            str = "The region must fit inside the matrix";
        }
        d.AnonymousClass0.m$2(str);
    }

    public final String toString() {
        int i = this.width;
        int i2 = this.height;
        StringBuilder sb = new StringBuilder((i + 1) * i2);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                sb.append(get(i4, i3) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
