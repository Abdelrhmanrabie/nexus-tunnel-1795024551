package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ViewPortHandler {
    public final Matrix mMatrixTouch = new Matrix();
    public final RectF mContentRect = new RectF();
    public float mChartWidth = 0.0f;
    public float mChartHeight = 0.0f;
    public final float mMinScaleY = 1.0f;
    public final float mMaxScaleY = Float.MAX_VALUE;
    public float mMinScaleX = 1.0f;
    public final float mMaxScaleX = Float.MAX_VALUE;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mTransX = 0.0f;
    public final Matrix mCenterViewPortMatrixBuffer = new Matrix();
    public final float[] matrixBuffer = new float[9];

    public final boolean isFullyZoomedOutX() {
        float f = this.mScaleX;
        float f2 = this.mMinScaleX;
        return f <= f2 && f2 <= 1.0f;
    }

    public final boolean isFullyZoomedOutY() {
        float f = this.mScaleY;
        float f2 = this.mMinScaleY;
        return f <= f2 && f2 <= 1.0f;
    }

    public final boolean isInBoundsLeft(float f) {
        return this.mContentRect.left <= f + 1.0f;
    }

    public final boolean isInBoundsRight(float f) {
        return this.mContentRect.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public final boolean isInBoundsY(float f) {
        RectF rectF = this.mContentRect;
        if (rectF.top <= f) {
            return rectF.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
        }
        return false;
    }

    public final void limitTransAndScale(Matrix matrix, RectF rectF) {
        float fHeight;
        float fWidth;
        float[] fArr = this.matrixBuffer;
        matrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[0];
        float f3 = fArr[5];
        float f4 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f2), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, f4), this.mMaxScaleY);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fHeight = 0.0f;
            fWidth = 0.0f;
        }
        this.mTransX = Math.min(Math.max(f, ((this.mScaleX - 1.0f) * (-fWidth)) - 0.0f), 0.0f);
        float fMax = Math.max(Math.min(f3, ((this.mScaleY - 1.0f) * fHeight) + 0.0f), -0.0f);
        fArr[2] = this.mTransX;
        fArr[0] = this.mScaleX;
        fArr[5] = fMax;
        fArr[4] = this.mScaleY;
        matrix.setValues(fArr);
    }

    public final float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public final void refresh(Matrix matrix, View view, boolean z) {
        Matrix matrix2 = this.mMatrixTouch;
        matrix2.set(matrix);
        limitTransAndScale(matrix2, this.mContentRect);
        if (z) {
            view.invalidate();
        }
        matrix.set(matrix2);
    }

    public final void restrainViewPort(float f, float f2, float f3, float f4) {
        this.mContentRect.set(f, f2, this.mChartWidth - f3, this.mChartHeight - f4);
    }
}
