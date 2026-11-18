package com.github.mikephil.charting.utils;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import defpackage.bj;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utils {
    public static final Rect mCalcTextHeightRect;
    public static final Rect mCalcTextSizeRect;
    public static final bj mDefaultValueFormatter;
    public static final Rect mDrawTextRectBuffer;
    public static final Paint.FontMetrics mFontMetrics;
    public static final Paint.FontMetrics mFontMetricsBuffer;
    public static int mMaximumFlingVelocity = 8000;
    public static DisplayMetrics mMetrics = null;
    public static int mMinimumFlingVelocity = 50;

    static {
        Double.longBitsToDouble(1L);
        Float.intBitsToFloat(1);
        mCalcTextHeightRect = new Rect();
        mFontMetrics = new Paint.FontMetrics();
        mCalcTextSizeRect = new Rect();
        mDefaultValueFormatter = new bj(1);
        new Rect();
        mDrawTextRectBuffer = new Rect();
        mFontMetricsBuffer = new Paint.FontMetrics();
    }

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize fSize = (FSize) FSize.pool.get();
        fSize.width = 0.0f;
        fSize.height = 0.0f;
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = rect.width();
        fSize.height = rect.height();
        return fSize;
    }

    public static float convertDpToPixel(float f) {
        DisplayMetrics displayMetrics = mMetrics;
        return displayMetrics == null ? f : f * displayMetrics.density;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f, float f2) {
        double d = 0.0f;
        float fAbs = Math.abs(((float) Math.sin(d)) * f2) + Math.abs(((float) Math.cos(d)) * f);
        float fAbs2 = Math.abs(f2 * ((float) Math.cos(d))) + Math.abs(f * ((float) Math.sin(d)));
        FSize fSize = (FSize) FSize.pool.get();
        fSize.width = fAbs;
        fSize.height = fAbs2;
        return fSize;
    }

    public static double nextUp(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d2) + (d2 >= 0.0d ? 1L : -1L));
    }

    public static float roundToNextSignificant(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d) || d == 0.0d) {
            return 0.0f;
        }
        float fPow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d < 0.0d ? -d : d))));
        return Math.round(d * ((double) fPow)) / fPow;
    }
}
