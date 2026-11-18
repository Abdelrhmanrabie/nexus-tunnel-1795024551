package com.google.zxing.qrcode.detector;

import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AlignmentPatternFinder {
    public final int height;
    public final BitMatrix image;
    public final float moduleSize;
    public final int startX;
    public final int startY;
    public final int width;
    public final ArrayList possibleCenters = new ArrayList(5);
    public final int[] crossCheckStateCount = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f) {
        this.image = bitMatrix;
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
    }

    public final boolean foundPatternCross(int[] iArr) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00a8  */
    public final AlignmentPattern handlePossibleCenter(int i, int i2, int[] iArr) {
        float f;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = i3 + i4 + i5;
        float f2 = (i2 - i5) - (i4 / 2.0f);
        int i7 = (int) f2;
        int i8 = i4 * 2;
        BitMatrix bitMatrix = this.image;
        int i9 = bitMatrix.height;
        int[] iArr2 = this.crossCheckStateCount;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i10 = i;
        while (i10 >= 0 && bitMatrix.get(i7, i10)) {
            int i11 = iArr2[1];
            if (i11 > i8) {
                break;
            }
            iArr2[1] = i11 + 1;
            i10--;
        }
        if (i10 < 0 || iArr2[1] > i8) {
            f = Float.NaN;
        } else {
            while (i10 >= 0 && !bitMatrix.get(i7, i10)) {
                int i12 = iArr2[0];
                if (i12 > i8) {
                    break;
                }
                iArr2[0] = i12 + 1;
                i10--;
            }
            if (iArr2[0] > i8) {
                f = Float.NaN;
            } else {
                int i13 = i + 1;
                while (i13 < i9 && bitMatrix.get(i7, i13)) {
                    int i14 = iArr2[1];
                    if (i14 > i8) {
                        break;
                    }
                    iArr2[1] = i14 + 1;
                    i13++;
                }
                if (i13 == i9 || iArr2[1] > i8) {
                    f = Float.NaN;
                } else {
                    while (i13 < i9 && !bitMatrix.get(i7, i13)) {
                        int i15 = iArr2[2];
                        if (i15 > i8) {
                            break;
                        }
                        iArr2[2] = i15 + 1;
                        i13++;
                    }
                    int i16 = iArr2[2];
                    if (i16 <= i8 && Math.abs(((iArr2[0] + iArr2[1]) + i16) - i6) * 5 < i6 * 2 && foundPatternCross(iArr2)) {
                        f = (i13 - iArr2[2]) - (iArr2[1] / 2.0f);
                    } else {
                        f = Float.NaN;
                    }
                }
            }
        }
        if (Float.isNaN(f)) {
            return null;
        }
        float f3 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        ArrayList<AlignmentPattern> arrayList = this.possibleCenters;
        for (AlignmentPattern alignmentPattern : arrayList) {
            float f4 = alignmentPattern.estimatedModuleSize;
            float f5 = alignmentPattern.x;
            float f6 = alignmentPattern.y;
            if (Math.abs(f - f6) <= f3 && Math.abs(f2 - f5) <= f3) {
                float fAbs = Math.abs(f3 - f4);
                if (fAbs <= 1.0f || fAbs <= f4) {
                    return new AlignmentPattern((f5 + f2) / 2.0f, (f6 + f) / 2.0f, (alignmentPattern.estimatedModuleSize + f3) / 2.0f);
                }
            }
        }
        arrayList.add(new AlignmentPattern(f2, f, f3));
        return null;
    }
}
