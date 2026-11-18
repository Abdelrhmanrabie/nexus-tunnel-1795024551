package com.google.android.material.color;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class ViewingConditions {
    public static final ViewingConditions DEFAULT;
    public final float aw;
    public final float c;
    public final float fl;
    public final float flRoot;
    public final float n;
    public final float nbb;
    public final float nc;
    public final float ncb;
    public final float[] rgbD;
    public final float z;

    static {
        float[] fArrCopyOf = Arrays.copyOf(ColorUtils.WHITE_POINT_D65, 3);
        float fYFromLstar = (float) ((((double) ColorUtils.yFromLstar()) * 63.66197723675813d) / 100.0d);
        float f = fArrCopyOf[0];
        float[][] fArr = Cam16.XYZ_TO_CAM16RGB;
        float[] fArr2 = fArr[0];
        float f2 = fArr2[0] * f;
        float f3 = fArrCopyOf[1];
        float f4 = (fArr2[1] * f3) + f2;
        float f5 = fArrCopyOf[2];
        float f6 = (fArr2[2] * f5) + f4;
        float[] fArr3 = fArr[1];
        float f7 = (fArr3[2] * f5) + (fArr3[1] * f3) + (fArr3[0] * f);
        float[] fArr4 = fArr[2];
        float f8 = (f5 * fArr4[2]) + (f3 * fArr4[1]) + (f * fArr4[0]);
        float f9 = ((double) 1.0f) >= 0.9d ? 0.69000006f : 0.6549999f;
        float fExp = (1.0f - (((float) Math.exp(((-fYFromLstar) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = fExp;
        if (d > 1.0d) {
            fExp = 1.0f;
        } else if (d < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr5 = {(((100.0f / f6) * fExp) + 1.0f) - fExp, (((100.0f / f7) * fExp) + 1.0f) - fExp, (((100.0f / f8) * fExp) + 1.0f) - fExp};
        float f10 = 1.0f / ((5.0f * fYFromLstar) + 1.0f);
        float f11 = f10 * f10 * f10 * f10;
        float f12 = 1.0f - f11;
        float fCbrt = (0.1f * f12 * f12 * ((float) Math.cbrt(((double) fYFromLstar) * 5.0d))) + (f11 * fYFromLstar);
        float fYFromLstar2 = ColorUtils.yFromLstar() / fArrCopyOf[1];
        double d2 = fYFromLstar2;
        float fSqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float fPow2 = (float) Math.pow(((double) ((fArr5[0] * fCbrt) * f6)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) ((fArr5[1] * fCbrt) * f7)) / 100.0d, 0.42d);
        float fPow4 = (float) Math.pow(((double) ((fArr5[2] * fCbrt) * f8)) / 100.0d, 0.42d);
        float[] fArr6 = {fPow2, fPow3, fPow4};
        float f13 = fArr6[0];
        float f14 = (f13 * 400.0f) / (f13 + 27.13f);
        float f15 = fArr6[1];
        DEFAULT = new ViewingConditions(fYFromLstar2, ((((400.0f * fPow4) / (fPow4 + 27.13f)) * 0.05f) + (f14 * 2.0f) + ((f15 * 400.0f) / (f15 + 27.13f))) * fPow, fPow, fPow, f9, 1.0f, fArr5, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.n = f;
        this.aw = f2;
        this.nbb = f3;
        this.ncb = f4;
        this.c = f5;
        this.nc = f6;
        this.rgbD = fArr;
        this.fl = f7;
        this.flRoot = f8;
        this.z = f9;
    }
}
