package com.google.android.material.color;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class Cam16 {
    public final float astar;
    public final float bstar;
    public final float chroma;
    public final float hue;
    public final float j;
    public final float jstar;
    public static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    private Cam16(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.hue = f;
        this.chroma = f2;
        this.j = f3;
        this.jstar = f7;
        this.astar = f8;
        this.bstar = f9;
    }

    public static Cam16 fromInt(int i) {
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        float fLinearized = ColorUtils.linearized(((16711680 & i) >> 16) / 255.0f) * 100.0f;
        float fLinearized2 = ColorUtils.linearized(((65280 & i) >> 8) / 255.0f) * 100.0f;
        float fLinearized3 = ColorUtils.linearized((i & 255) / 255.0f) * 100.0f;
        float f = (0.18051042f * fLinearized3) + (0.35762063f * fLinearized2) + (0.41233894f * fLinearized);
        float f2 = (0.0722f * fLinearized3) + (0.7152f * fLinearized2) + (0.2126f * fLinearized);
        float f3 = (fLinearized3 * 0.9503448f) + (fLinearized2 * 0.11916382f) + (fLinearized * 0.01932141f);
        float[][] fArr = XYZ_TO_CAM16RGB;
        float[] fArr2 = fArr[0];
        float f4 = (fArr2[2] * f3) + (fArr2[1] * f2) + (fArr2[0] * f);
        float[] fArr3 = fArr[1];
        float f5 = (fArr3[2] * f3) + (fArr3[1] * f2) + (fArr3[0] * f);
        float[] fArr4 = fArr[2];
        float f6 = (f3 * fArr4[2]) + (f2 * fArr4[1]) + (f * fArr4[0]);
        float[] fArr5 = viewingConditions.rgbD;
        float f7 = viewingConditions.flRoot;
        float f8 = viewingConditions.c;
        float f9 = viewingConditions.aw;
        float f10 = fArr5[0] * f4;
        float f11 = fArr5[1] * f5;
        float f12 = fArr5[2] * f6;
        float f13 = viewingConditions.fl;
        float fPow = (float) Math.pow(((double) (Math.abs(f10) * f13)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f11) * f13)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f12) * f13)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f10) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f11) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f12) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f14 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d)) / 11.0f;
        float f15 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f16 = fSignum2 * 20.0f;
        float f17 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f16)) / 20.0f;
        float f18 = (((fSignum * 40.0f) + f16) + fSignum3) / 20.0f;
        double d2 = f15;
        double d3 = f14;
        float fAtan2 = (((float) Math.atan2(d2, d3)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f19 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f18 * viewingConditions.nbb) / f9, viewingConditions.z * f8)) * 100.0f;
        float f20 = f9 + 4.0f;
        float fSqrt = (4.0f / f8) * ((float) Math.sqrt(fPow4 / 100.0f)) * f20 * f7;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.n), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(((double) fAtan2) < 20.14d ? fAtan2 + 360.0f : fAtan2) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.nc) * viewingConditions.ncb) * ((float) Math.hypot(d3, d2))) / (f17 + 0.305f), 0.9d));
        float fSqrt2 = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float f21 = fSqrt2 * f7;
        float fSqrt3 = ((float) Math.sqrt((fPow5 * f8) / f20)) * 50.0f;
        float f22 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog1p = ((float) Math.log1p(0.0228f * f21)) * 43.85965f;
        double d4 = f19;
        return new Cam16(fAtan2, fSqrt2, fPow4, fSqrt, f21, fSqrt3, f22, fLog1p * ((float) Math.cos(d4)), fLog1p * ((float) Math.sin(d4)));
    }

    public static Cam16 fromJch(float f, float f2, float f3) {
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        double d = ((double) f) / 100.0d;
        float fSqrt = (4.0f / viewingConditions.c) * ((float) Math.sqrt(d));
        float f4 = viewingConditions.aw + 4.0f;
        float f5 = viewingConditions.flRoot;
        float f6 = fSqrt * f4 * f5;
        float f7 = f5 * f2;
        float fSqrt2 = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(d))) * viewingConditions.c) / f4)) * 50.0f;
        float f8 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog1p = ((float) Math.log1p(((double) f7) * 0.0228d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new Cam16(f3, f2, f, f6, f7, fSqrt2, f8, ((float) Math.cos(d2)) * fLog1p, fLog1p * ((float) Math.sin(d2)));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final int viewed(ViewingConditions viewingConditions) {
        float fSqrt;
        float f = this.chroma;
        double d = f;
        float f2 = this.j;
        if (d != 0.0d) {
            double d2 = f2;
            if (d2 == 0.0d) {
                fSqrt = 0.0f;
            } else {
                fSqrt = f / ((float) Math.sqrt(d2 / 100.0d));
            }
        } else {
            fSqrt = 0.0f;
        }
        float f3 = viewingConditions.n;
        float f4 = viewingConditions.fl;
        float fPow = (float) Math.pow(((double) fSqrt) / Math.pow(1.64d - Math.pow(0.29d, f3), 0.73d), 1.1111111111111112d);
        double d3 = (this.hue * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + d3) + 3.8d)) * 0.25f;
        float fPow2 = viewingConditions.aw * ((float) Math.pow(((double) f2) / 100.0d, (1.0d / ((double) viewingConditions.c)) / ((double) viewingConditions.z)));
        float f5 = fCos * 3846.1538f * viewingConditions.nc * viewingConditions.ncb;
        float f6 = fPow2 / viewingConditions.nbb;
        float fSin = (float) Math.sin(d3);
        float fCos2 = (float) Math.cos(d3);
        float f7 = (((0.305f + f6) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (f5 * 23.0f)));
        float f8 = fCos2 * f7;
        float f9 = f7 * fSin;
        float f10 = f6 * 460.0f;
        float f11 = ((288.0f * f9) + ((451.0f * f8) + f10)) / 1403.0f;
        float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
        float f13 = ((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f;
        float f14 = 100.0f / f4;
        float fSignum = Math.signum(f11) * f14 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f12) * f14 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f13) * f14 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f13)) * 27.13d) / (400.0d - ((double) Math.abs(f13)))), 2.380952380952381d));
        float[] fArr = viewingConditions.rgbD;
        float f15 = fSignum / fArr[0];
        float f16 = fSignum2 / fArr[1];
        float f17 = fSignum3 / fArr[2];
        float[][] fArr2 = CAM16RGB_TO_XYZ;
        float[] fArr3 = fArr2[0];
        float f18 = (fArr3[2] * f17) + (fArr3[1] * f16) + (fArr3[0] * f15);
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[2] * f17) + (fArr4[1] * f16) + (fArr4[0] * f15);
        float[] fArr5 = fArr2[2];
        return ColorUtils.intFromXyzComponents(f18, f19, (f17 * fArr5[2]) + (f16 * fArr5[1]) + (f15 * fArr5[0]));
    }
}
