package com.google.android.material.color;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class ColorUtils {
    public static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};

    private ColorUtils() {
    }

    public static float delinearized(float f) {
        return f <= 0.0031308f ? f * 12.92f : (((float) Math.pow(f, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int intFromLstar(float f) {
        float f2 = (f + 16.0f) / 116.0f;
        float f3 = f2 * f2 * f2;
        boolean z = f3 > 0.008856452f;
        float f4 = (f > 8.0f ? 1 : (f == 8.0f ? 0 : -1)) > 0 ? f3 : f / 903.2963f;
        float f5 = z ? f3 : ((f2 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f3 = ((f2 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        float[] fArr2 = {f5 * fArr[0], f4 * fArr[1], f3 * fArr[2]};
        return intFromXyzComponents(fArr2[0], fArr2[1], fArr2[2]);
    }

    public static int intFromXyzComponents(float f, float f2, float f3) {
        float f4 = f / 100.0f;
        float f5 = f2 / 100.0f;
        float f6 = f3 / 100.0f;
        float f7 = ((-0.4986f) * f6) + ((-1.5372f) * f5) + (3.2406f * f4);
        float f8 = (0.0415f * f6) + (1.8758f * f5) + ((-0.9689f) * f4);
        float f9 = f6 * 1.057f;
        float f10 = f9 + (f5 * (-0.204f)) + (f4 * 0.0557f);
        float fDelinearized = delinearized(f7);
        float fDelinearized2 = delinearized(f8);
        float fDelinearized3 = delinearized(f10);
        return ((Math.max(Math.min(255, Math.round(fDelinearized * 255.0f)), 0) & 255) << 16) | (-16777216) | ((Math.max(Math.min(255, Math.round(fDelinearized2 * 255.0f)), 0) & 255) << 8) | (Math.max(Math.min(255, Math.round(fDelinearized3 * 255.0f)), 0) & 255);
    }

    public static float linearized(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float lstarFromInt(int i) {
        float fLinearized = linearized(((16711680 & i) >> 16) / 255.0f) * 100.0f;
        float fLinearized2 = linearized(((65280 & i) >> 8) / 255.0f) * 100.0f;
        float fLinearized3 = linearized((i & 255) / 255.0f) * 100.0f;
        float[] fArr = {(0.18051042f * fLinearized3) + (0.35762063f * fLinearized2) + (0.41233894f * fLinearized), (0.0722f * fLinearized3) + (0.7152f * fLinearized2) + (0.2126f * fLinearized), (fLinearized3 * 0.9503448f) + (fLinearized2 * 0.11916382f) + (fLinearized * 0.01932141f)};
        float f = fArr[1];
        float[] fArr2 = WHITE_POINT_D65;
        double d = f / fArr2[1];
        double dCbrt = d > 0.008856451679035631d ? Math.cbrt(d) : ((d * 903.2962962962963d) + 16.0d) / 116.0d;
        double d2 = fArr[0] / fArr2[0];
        double dCbrt2 = d2 > 0.008856451679035631d ? Math.cbrt(d2) : ((d2 * 903.2962962962963d) + 16.0d) / 116.0d;
        double d3 = fArr[2] / fArr2[2];
        return (float) new double[]{(116.0d * dCbrt) - 16.0d, (dCbrt2 - dCbrt) * 500.0d, (dCbrt - (d3 > 0.008856451679035631d ? Math.cbrt(d3) : ((d3 * 903.2962962962963d) + 16.0d) / 116.0d)) * 200.0d}[0];
    }

    public static float yFromLstar() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
