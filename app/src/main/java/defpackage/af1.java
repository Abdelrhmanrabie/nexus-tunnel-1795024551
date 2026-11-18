package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class af1 {
    public static final af1 k;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float f;
    public final float[] g;
    public final float h;
    public final float i;
    public final float j;

    static {
        float f;
        float f2;
        float[] fArr = e.j;
        double d = (((double) 50.0f) + 16.0d) / 116.0d;
        float fPow = (float) ((((double) (((float) Math.pow(d, 3.0d)) * 100.0f)) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = e.f41h;
        float f3 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f4 = fArr3[0] * f3;
        float f5 = fArr[1];
        float f6 = (fArr3[1] * f5) + f4;
        float f7 = fArr[2];
        float f8 = (fArr3[2] * f7) + f6;
        float[] fArr4 = fArr2[1];
        float f9 = (fArr4[2] * f7) + (fArr4[1] * f5) + (fArr4[0] * f3);
        float[] fArr5 = fArr2[2];
        float f10 = (f7 * fArr5[2]) + (f5 * fArr5[1]) + (f3 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f = 0.100000046f;
            f2 = 0.59f;
        } else {
            f = 0.12999998f;
            f2 = 0.525f;
        }
        float f11 = f + f2;
        float fExp = (1.0f - (((float) Math.exp(((-fPow) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d2 = fExp;
        if (d2 > 1.0d) {
            fExp = 1.0f;
        } else if (d2 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f8) * fExp) + 1.0f) - fExp, (((100.0f / f9) * fExp) + 1.0f) - fExp, (((100.0f / f10) * fExp) + 1.0f) - fExp};
        float f12 = 1.0f / ((5.0f * fPow) + 1.0f);
        float f13 = f12 * f12 * f12 * f12;
        float f14 = 1.0f - f13;
        float fCbrt = (0.1f * f14 * f14 * ((float) Math.cbrt(((double) fPow) * 5.0d))) + (f13 * fPow);
        float fPow2 = (((float) Math.pow(d, 3.0d)) * 100.0f) / fArr[1];
        double d3 = fPow2;
        float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float fPow3 = 0.725f / ((float) Math.pow(d3, 0.2d));
        float fPow4 = (float) Math.pow(((double) ((fArr6[0] * fCbrt) * f8)) / 100.0d, 0.42d);
        float fPow5 = (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f9)) / 100.0d, 0.42d);
        float fPow6 = (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f10)) / 100.0d, 0.42d);
        float[] fArr7 = {fPow4, fPow5, fPow6};
        float f15 = fArr7[0];
        float f16 = (f15 * 400.0f) / (f15 + 27.13f);
        float f17 = fArr7[1];
        k = new af1(fPow2, ((((400.0f * fPow6) / (fPow6 + 27.13f)) * 0.05f) + (f16 * 2.0f) + ((f17 * 400.0f) / (f17 + 27.13f))) * fPow3, fPow3, fPow3, f11, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public af1(float f, float f2, float f3, float f4, float f5, float[] fArr, float f6, float f7, float f8) {
        this.f = f;
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.g = fArr;
        this.h = f6;
        this.i = f7;
        this.j = f8;
    }
}
