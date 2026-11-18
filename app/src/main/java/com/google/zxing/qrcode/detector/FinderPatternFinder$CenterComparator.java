package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class FinderPatternFinder$CenterComparator implements Serializable, Comparator {
    public final /* synthetic */ int G0;
    public final float average;

    public /* synthetic */ FinderPatternFinder$CenterComparator(int i, float f) {
        this.G0 = i;
        this.average = f;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        FinderPattern finderPattern = (FinderPattern) obj;
        FinderPattern finderPattern2 = (FinderPattern) obj2;
        if (this.G0 != 0) {
            float f = finderPattern2.estimatedModuleSize;
            float f2 = this.average;
            float fAbs = Math.abs(f - f2);
            float fAbs2 = Math.abs(finderPattern.estimatedModuleSize - f2);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
        int i = finderPattern2.count;
        int i2 = finderPattern.count;
        if (i != i2) {
            return i - i2;
        }
        float f3 = finderPattern2.estimatedModuleSize;
        float f4 = this.average;
        float fAbs3 = Math.abs(f3 - f4);
        float fAbs4 = Math.abs(finderPattern.estimatedModuleSize - f4);
        if (fAbs3 < fAbs4) {
            return 1;
        }
        return fAbs3 == fAbs4 ? 0 : -1;
    }
}
