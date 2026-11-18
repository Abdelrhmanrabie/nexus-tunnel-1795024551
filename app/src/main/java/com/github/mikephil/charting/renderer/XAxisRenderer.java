package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.d;
import defpackage.e91;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class XAxisRenderer extends AxisRenderer {
    public final RectF mGridClippingRect;
    public float[] mRenderGridLinesBuffer;
    public final Path mRenderGridLinesPath;
    public final float[] mRenderLimitLinesBuffer;
    public final XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, e91 e91Var) {
        super(viewPortHandler, e91Var, xAxis);
        this.mRenderGridLinesPath = new Path();
        this.mRenderGridLinesBuffer = new float[2];
        this.mGridClippingRect = new RectF();
        this.mRenderLimitLinesBuffer = new float[2];
        new RectF();
        new Path();
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f, float f2) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        RectF rectF = viewPortHandler.mContentRect;
        if (rectF.width() > 10.0f && !viewPortHandler.isFullyZoomedOutX()) {
            float f3 = rectF.left;
            float f4 = rectF.top;
            e91 e91Var = this.mTrans;
            MPPointD valuesByTouchPoint = e91Var.getValuesByTouchPoint(f3, f4);
            MPPointD valuesByTouchPoint2 = e91Var.getValuesByTouchPoint(rectF.right, rectF.top);
            float f5 = (float) valuesByTouchPoint.x;
            float f6 = (float) valuesByTouchPoint2.x;
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f = f5;
            f2 = f6;
        }
        computeAxisValues(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public final void computeAxisValues(float f, float f2) {
        super.computeAxisValues(f, f2);
        computeSize();
    }

    public void computeSize() {
        XAxis xAxis = this.mXAxis;
        String longestLabel = xAxis.getLongestLabel();
        Paint paint = this.mAxisLabelPaint;
        paint.setTypeface(null);
        paint.setTextSize(xAxis.mTextSize);
        FSize fSizeCalcTextSize = Utils.calcTextSize(paint, longestLabel);
        float f = fSizeCalcTextSize.width;
        float fCalcTextHeight = Utils.calcTextHeight(paint, "Q");
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f, fCalcTextHeight);
        Math.round(f);
        Math.round(fCalcTextHeight);
        xAxis.mLabelRotatedWidth = Math.round(sizeOfRotatedRectangleByDegrees.width);
        xAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        ObjectPool objectPool = FSize.pool;
        objectPool.recycle(sizeOfRotatedRectangleByDegrees);
        objectPool.recycle(fSizeCalcTextSize);
    }

    public void drawGridLine(Canvas canvas, float f, float f2, Path path) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        path.moveTo(f, viewPortHandler.mContentRect.bottom);
        path.lineTo(f, viewPortHandler.mContentRect.top);
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    public final void drawLabel(Canvas canvas, String str, float f, float f2, MPPointF mPPointF) {
        Paint.FontMetrics fontMetrics = Utils.mFontMetricsBuffer;
        Paint paint = this.mAxisLabelPaint;
        float fontMetrics2 = paint.getFontMetrics(fontMetrics);
        int length = str.length();
        Rect rect = Utils.mDrawTextRectBuffer;
        paint.getTextBounds(str, 0, length, rect);
        float fWidth = 0.0f - rect.left;
        float f3 = (-fontMetrics.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (mPPointF.x != 0.0f || mPPointF.y != 0.0f) {
            fWidth -= rect.width() * mPPointF.x;
            f3 -= fontMetrics2 * mPPointF.y;
        }
        canvas.drawText(str, fWidth + f, f3 + f2, paint);
        paint.setTextAlign(textAlign);
    }

    public void drawLabels(Canvas canvas, float f, MPPointF mPPointF) {
        Canvas canvas2;
        float f2;
        MPPointF mPPointF2;
        AxisBase axisBase = this.mXAxis;
        axisBase.getClass();
        int i = axisBase.mEntryCount * 2;
        float[] fArr = new float[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 2) {
            fArr[i3] = axisBase.mEntries[i3 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        while (i2 < i) {
            float f3 = fArr[i2];
            ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
            if (viewPortHandler.isInBoundsLeft(f3) && viewPortHandler.isInBoundsRight(f3)) {
                canvas2 = canvas;
                f2 = f;
                mPPointF2 = mPPointF;
                drawLabel(canvas2, axisBase.getValueFormatter().getFormattedValue(axisBase.mEntries[i2 / 2], axisBase), f3, f2, mPPointF2);
            } else {
                canvas2 = canvas;
                f2 = f;
                mPPointF2 = mPPointF;
            }
            i2 += 2;
            canvas = canvas2;
            f = f2;
            mPPointF = mPPointF2;
        }
    }

    public RectF getGridClippingRect() {
        RectF rectF = ((ViewPortHandler) this.a).mContentRect;
        RectF rectF2 = this.mGridClippingRect;
        rectF2.set(rectF);
        rectF2.inset(-this.mAxis.mGridLineWidth, 0.0f);
        return rectF2;
    }

    public void renderAxisLabels(Canvas canvas) {
        float f;
        float f2;
        float f3;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        XAxis xAxis = this.mXAxis;
        if (xAxis.mEnabled && xAxis.mDrawLabels) {
            float f4 = xAxis.mYOffset;
            Paint paint = this.mAxisLabelPaint;
            paint.setTypeface(null);
            paint.setTextSize(xAxis.mTextSize);
            paint.setColor(xAxis.mTextColor);
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            XAxis.XAxisPosition xAxisPosition = xAxis.mPosition;
            if (xAxisPosition != XAxis.XAxisPosition.TOP) {
                if (xAxisPosition == XAxis.XAxisPosition.TOP_INSIDE) {
                    mPPointF.x = 0.5f;
                    mPPointF.y = 1.0f;
                    f = viewPortHandler.mContentRect.top + f4;
                    f4 = xAxis.mLabelRotatedHeight;
                } else {
                    if (xAxisPosition != XAxis.XAxisPosition.BOTTOM) {
                        XAxis.XAxisPosition xAxisPosition2 = XAxis.XAxisPosition.BOTTOM_INSIDE;
                        mPPointF.x = 0.5f;
                        if (xAxisPosition == xAxisPosition2) {
                            mPPointF.y = 0.0f;
                            f2 = viewPortHandler.mContentRect.bottom - f4;
                            f4 = xAxis.mLabelRotatedHeight;
                        } else {
                            mPPointF.y = 1.0f;
                            drawLabels(canvas, viewPortHandler.mContentRect.top - f4, mPPointF);
                        }
                    }
                    mPPointF.x = 0.5f;
                    mPPointF.y = 0.0f;
                    f = viewPortHandler.mContentRect.bottom;
                }
                f3 = f + f4;
                drawLabels(canvas, f3, mPPointF);
                MPPointF.recycleInstance(mPPointF);
            }
            mPPointF.x = 0.5f;
            mPPointF.y = 1.0f;
            f2 = viewPortHandler.mContentRect.top;
            f3 = f2 - f4;
            drawLabels(canvas, f3, mPPointF);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        Canvas canvas2;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        XAxis xAxis = this.mXAxis;
        boolean z = xAxis.mDrawAxisLine;
        XAxis.XAxisPosition xAxisPosition = xAxis.mPosition;
        if (z && xAxis.mEnabled) {
            int i = xAxis.mAxisLineColor;
            Paint paint = this.mAxisLinePaint;
            paint.setColor(i);
            paint.setStrokeWidth(xAxis.mAxisLineWidth);
            paint.setPathEffect(null);
            if (xAxisPosition == XAxis.XAxisPosition.TOP || xAxisPosition == XAxis.XAxisPosition.TOP_INSIDE || xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF = viewPortHandler.mContentRect;
                float f = rectF.left;
                float f2 = rectF.top;
                canvas2 = canvas;
                canvas2.drawLine(f, f2, rectF.right, f2, paint);
            } else {
                canvas2 = canvas;
            }
            if (xAxisPosition == XAxis.XAxisPosition.BOTTOM || xAxisPosition == XAxis.XAxisPosition.BOTTOM_INSIDE || xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF2 = viewPortHandler.mContentRect;
                float f3 = rectF2.left;
                float f4 = rectF2.bottom;
                canvas2.drawLine(f3, f4, rectF2.right, f4, paint);
            }
        }
    }

    public final void renderGridLines(Canvas canvas) {
        XAxis xAxis = this.mXAxis;
        if (xAxis.mDrawGridLines && xAxis.mEnabled) {
            int iSave = canvas.save();
            canvas.clipRect(getGridClippingRect());
            if (this.mRenderGridLinesBuffer.length != this.mAxis.mEntryCount * 2) {
                this.mRenderGridLinesBuffer = new float[xAxis.mEntryCount * 2];
            }
            float[] fArr = this.mRenderGridLinesBuffer;
            for (int i = 0; i < fArr.length; i += 2) {
                float[] fArr2 = xAxis.mEntries;
                int i2 = i / 2;
                fArr[i] = fArr2[i2];
                fArr[i + 1] = fArr2[i2];
            }
            this.mTrans.pointValuesToPixel(fArr);
            int i3 = xAxis.mGridColor;
            Paint paint = this.mGridPaint;
            paint.setColor(i3);
            paint.setStrokeWidth(xAxis.mGridLineWidth);
            paint.setPathEffect(null);
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                drawGridLine(canvas, fArr[i4], fArr[i4 + 1], path);
            }
            canvas.restoreToCount(iSave);
        }
    }

    public void renderLimitLines() {
        ArrayList arrayList = this.mXAxis.mLimitLines;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        d.AnonymousClass0.m$1();
    }
}
