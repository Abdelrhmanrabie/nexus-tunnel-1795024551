package defpackage;

import android.graphics.Color;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class je {
    public static final ThreadLocal a = new ThreadLocal();

    public static int a(double d, double d2, double d3) {
        double d4 = (((-0.4986d) * d3) + (((-1.5372d) * d2) + (3.2406d * d))) / 100.0d;
        double d5 = ((0.0415d * d3) + ((1.8758d * d2) + ((-0.9689d) * d))) / 100.0d;
        double d6 = ((1.057d * d3) + (((-0.204d) * d2) + (0.0557d * d))) / 100.0d;
        double dPow = d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d;
        double dPow2 = d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d;
        double dPow3 = d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d;
        int iRound = (int) Math.round(dPow * 255.0d);
        int iMin = iRound < 0 ? 0 : Math.min(iRound, 255);
        int iRound2 = (int) Math.round(dPow2 * 255.0d);
        int iMin2 = iRound2 < 0 ? 0 : Math.min(iRound2, 255);
        int iRound3 = (int) Math.round(dPow3 * 255.0d);
        return Color.rgb(iMin, iMin2, iRound3 >= 0 ? Math.min(iRound3, 255) : 0);
    }

    public static int b(int i, int i2) {
        int i3;
        int i4;
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int i5 = 255 - iAlpha2;
        int i6 = 255 - (((255 - iAlpha) * i5) / 255);
        int iRed = Color.red(i);
        int iRed2 = Color.red(i2);
        int i7 = 0;
        if (i6 == 0) {
            i3 = 0;
        } else {
            i3 = (((iRed2 * iAlpha) * i5) + ((iRed * 255) * iAlpha2)) / (i6 * 255);
        }
        int iGreen = Color.green(i);
        int iGreen2 = Color.green(i2);
        if (i6 == 0) {
            i4 = 0;
        } else {
            i4 = (((iGreen2 * iAlpha) * i5) + ((iGreen * 255) * iAlpha2)) / (i6 * 255);
        }
        int iBlue = Color.blue(i);
        int iBlue2 = Color.blue(i2);
        if (i6 != 0) {
            i7 = (((iBlue2 * iAlpha) * i5) + ((iBlue * 255) * iAlpha2)) / (i6 * 255);
        }
        return Color.argb(i6, i3, i4, i7);
    }

    public static int c(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & 16777215) | (i2 << 24);
        }
        d.AnonymousClass0.m$2("alpha must be between 0 and 255.");
        return 0;
    }
}
