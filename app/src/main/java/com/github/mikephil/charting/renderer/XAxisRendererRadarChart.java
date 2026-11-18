package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.d;
import defpackage.e91;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class XAxisRendererRadarChart extends XAxisRenderer {
    public final /* synthetic */ int G0;
    public Object mChart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, e91 e91Var, int i) {
        super(viewPortHandler, xAxis, e91Var);
        this.G0 = i;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f, float f2) {
        if (this.G0 != 1) {
            super.computeAxis(f, f2);
            return;
        }
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        RectF rectF = viewPortHandler.mContentRect;
        if (rectF.width() > 10.0f && !viewPortHandler.isFullyZoomedOutY()) {
            float f3 = rectF.left;
            float f4 = rectF.bottom;
            e91 e91Var = this.mTrans;
            MPPointD valuesByTouchPoint = e91Var.getValuesByTouchPoint(f3, f4);
            MPPointD valuesByTouchPoint2 = e91Var.getValuesByTouchPoint(rectF.left, rectF.top);
            float f5 = (float) valuesByTouchPoint.y;
            float f6 = (float) valuesByTouchPoint2.y;
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f = f5;
            f2 = f6;
        }
        computeAxisValues(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void computeSize() {
        if (this.G0 != 1) {
            super.computeSize();
            return;
        }
        XAxis xAxis = this.mXAxis;
        xAxis.getClass();
        Paint paint = this.mAxisLabelPaint;
        paint.setTypeface(null);
        paint.setTextSize(xAxis.mTextSize);
        FSize fSizeCalcTextSize = Utils.calcTextSize(paint, xAxis.getLongestLabel());
        float f = fSizeCalcTextSize.width;
        float f2 = (int) ((xAxis.mXOffset * 3.5f) + f);
        float f3 = fSizeCalcTextSize.height;
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f, f3);
        Math.round(f2);
        Math.round(f3);
        xAxis.mLabelRotatedWidth = (int) ((xAxis.mXOffset * 3.5f) + sizeOfRotatedRectangleByDegrees.width);
        xAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        FSize.pool.recycle(sizeOfRotatedRectangleByDegrees);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void drawGridLine(Canvas canvas, float f, float f2, Path path) {
        if (this.G0 != 1) {
            super.drawGridLine(canvas, f, f2, path);
            return;
        }
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        path.moveTo(viewPortHandler.mContentRect.right, f2);
        path.lineTo(viewPortHandler.mContentRect.left, f2);
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void drawLabels(Canvas canvas, float f, MPPointF mPPointF) {
        Canvas canvas2;
        float f2;
        MPPointF mPPointF2;
        if (this.G0 != 1) {
            super.drawLabels(canvas, f, mPPointF);
            return;
        }
        AxisBase axisBase = this.mXAxis;
        axisBase.getClass();
        int i = axisBase.mEntryCount * 2;
        float[] fArr = new float[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 2) {
            fArr[i3 + 1] = axisBase.mEntries[i3 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        while (i2 < i) {
            float f3 = fArr[i2 + 1];
            if (((ViewPortHandler) this.a).isInBoundsY(f3)) {
                canvas2 = canvas;
                f2 = f;
                mPPointF2 = mPPointF;
                drawLabel(canvas2, axisBase.getValueFormatter().getFormattedValue(axisBase.mEntries[i2 / 2], axisBase), f2, f3, mPPointF2);
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

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public RectF getGridClippingRect() {
        if (this.G0 != 1) {
            return super.getGridClippingRect();
        }
        RectF rectF = ((ViewPortHandler) this.a).mContentRect;
        RectF rectF2 = this.mGridClippingRect;
        rectF2.set(rectF);
        rectF2.inset(0.0f, -this.mAxis.mGridLineWidth);
        return rectF2;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void renderAxisLabels(Canvas canvas) {
        float f;
        float f2;
        float f3;
        if (this.G0 == 0) {
            XAxis xAxis = this.mXAxis;
            if (xAxis.mEnabled && xAxis.mDrawLabels) {
                MPPointF.getInstance(0.5f, 0.25f);
                Paint paint = this.mAxisLabelPaint;
                paint.setTypeface(null);
                paint.setTextSize(xAxis.mTextSize);
                paint.setColor(xAxis.mTextColor);
                ((RadarChart) this.mChart).getSliceAngle();
                throw null;
            }
            return;
        }
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        XAxis xAxis2 = this.mXAxis;
        if (xAxis2.mEnabled && xAxis2.mDrawLabels) {
            float f4 = xAxis2.mXOffset;
            Paint paint2 = this.mAxisLabelPaint;
            paint2.setTypeface(null);
            paint2.setTextSize(xAxis2.mTextSize);
            paint2.setColor(xAxis2.mTextColor);
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            XAxis.XAxisPosition xAxisPosition = xAxis2.mPosition;
            if (xAxisPosition != XAxis.XAxisPosition.TOP) {
                if (xAxisPosition == XAxis.XAxisPosition.TOP_INSIDE) {
                    mPPointF.x = 1.0f;
                    mPPointF.y = 0.5f;
                    f = viewPortHandler.mContentRect.right;
                } else {
                    if (xAxisPosition != XAxis.XAxisPosition.BOTTOM) {
                        if (xAxisPosition == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                            mPPointF.x = 1.0f;
                            mPPointF.y = 0.5f;
                            f2 = viewPortHandler.mContentRect.left;
                        } else {
                            mPPointF.x = 0.0f;
                            mPPointF.y = 0.5f;
                            drawLabels(canvas, viewPortHandler.mContentRect.right + f4, mPPointF);
                        }
                    }
                    mPPointF.x = 1.0f;
                    mPPointF.y = 0.5f;
                    f = viewPortHandler.mContentRect.left;
                }
                f3 = f - f4;
                drawLabels(canvas, f3, mPPointF);
                MPPointF.recycleInstance(mPPointF);
            }
            mPPointF.x = 0.0f;
            mPPointF.y = 0.5f;
            f2 = viewPortHandler.mContentRect.right;
            f3 = f2 + f4;
            drawLabels(canvas, f3, mPPointF);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void renderAxisLine(Canvas canvas) {
        Canvas canvas2;
        if (this.G0 != 1) {
            super.renderAxisLine(canvas);
            return;
        }
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        XAxis xAxis = this.mXAxis;
        boolean z = xAxis.mDrawAxisLine;
        XAxis.XAxisPosition xAxisPosition = xAxis.mPosition;
        if (z && xAxis.mEnabled) {
            int i = xAxis.mAxisLineColor;
            Paint paint = this.mAxisLinePaint;
            paint.setColor(i);
            paint.setStrokeWidth(xAxis.mAxisLineWidth);
            if (xAxisPosition == XAxis.XAxisPosition.TOP || xAxisPosition == XAxis.XAxisPosition.TOP_INSIDE || xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF = viewPortHandler.mContentRect;
                float f = rectF.right;
                canvas2 = canvas;
                canvas2.drawLine(f, rectF.top, f, rectF.bottom, paint);
            } else {
                canvas2 = canvas;
            }
            if (xAxisPosition == XAxis.XAxisPosition.BOTTOM || xAxisPosition == XAxis.XAxisPosition.BOTTOM_INSIDE || xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                RectF rectF2 = viewPortHandler.mContentRect;
                float f2 = rectF2.left;
                canvas2.drawLine(f2, rectF2.top, f2, rectF2.bottom, paint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void renderLimitLines() {
        if (this.G0 == 0) {
            throw null;
        }
        ArrayList arrayList = this.mXAxis.mLimitLines;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        ((Path) this.mChart).reset();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        d.AnonymousClass0.m$1();
    }
}
