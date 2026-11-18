package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.d;
import defpackage.e91;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    public final float[] mRenderLimitLinesBuffer;
    public final Path mRenderLimitLinesPathBuffer;

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, e91 e91Var) {
        super(viewPortHandler, yAxis, e91Var);
        new Path();
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mRenderLimitLinesBuffer = new float[4];
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public final void computeAxis(float f, float f2) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        RectF rectF = viewPortHandler.mContentRect;
        if (rectF.height() > 10.0f && !viewPortHandler.isFullyZoomedOutX()) {
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

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        YAxis yAxis = this.mYAxis;
        yAxis.getClass();
        Paint paint = this.mAxisLabelPaint;
        paint.setTypeface(null);
        paint.setTextSize(yAxis.mTextSize);
        paint.setColor(yAxis.mTextColor);
        boolean z = yAxis.mDrawTopYLabelEntry;
        int i = yAxis.mEntryCount;
        if (!z) {
            i--;
        }
        float f3 = yAxis.mXLabelOffset;
        for (int i2 = !yAxis.mDrawBottomYLabelEntry ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(yAxis.getFormattedLabel(i2), fArr[i2 * 2], (f - f2) + f3, paint);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final RectF getGridClippingRect() {
        RectF rectF = ((ViewPortHandler) this.a).mContentRect;
        RectF rectF2 = this.mGridClippingRect;
        rectF2.set(rectF);
        rectF2.inset(-this.mAxis.mGridLineWidth, 0.0f);
        return rectF2;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final float[] getTransformedPositions() {
        int length = this.mGetTransformedPositionsBuffer.length;
        YAxis yAxis = this.mYAxis;
        int i = yAxis.mEntryCount * 2;
        if (length != i) {
            this.mGetTransformedPositionsBuffer = new float[i];
        }
        float[] fArr = this.mGetTransformedPositionsBuffer;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = yAxis.mEntries[i2 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        return fArr;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final Path linePath(Path path, int i, float[] fArr) {
        float f = fArr[i];
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        path.moveTo(f, viewPortHandler.mContentRect.top);
        path.lineTo(fArr[i], viewPortHandler.mContentRect.bottom);
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void renderAxisLabels(Canvas canvas) {
        float f;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawLabels) {
            float[] transformedPositions = getTransformedPositions();
            Paint paint = this.mAxisLabelPaint;
            paint.setTypeface(null);
            paint.setTextSize(yAxis.mTextSize);
            paint.setColor(yAxis.mTextColor);
            paint.setTextAlign(Paint.Align.CENTER);
            float fConvertDpToPixel = Utils.convertDpToPixel(2.5f);
            float fCalcTextHeight = Utils.calcTextHeight(paint, "Q");
            if (yAxis.mAxisDependency == YAxis.AxisDependency.LEFT) {
                YAxis.YAxisLabelPosition[] yAxisLabelPositionArr = YAxis.YAxisLabelPosition.$VALUES;
                f = viewPortHandler.mContentRect.top - fConvertDpToPixel;
            } else {
                YAxis.YAxisLabelPosition[] yAxisLabelPositionArr2 = YAxis.YAxisLabelPosition.$VALUES;
                f = viewPortHandler.mContentRect.bottom + fCalcTextHeight + fConvertDpToPixel;
            }
            drawYLabels(canvas, f, transformedPositions, yAxis.mYOffset);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void renderAxisLine(Canvas canvas) {
        RectF rectF;
        float f;
        float f2;
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawAxisLine) {
            int i = yAxis.mAxisLineColor;
            Paint paint = this.mAxisLinePaint;
            paint.setColor(i);
            paint.setStrokeWidth(yAxis.mAxisLineWidth);
            YAxis.AxisDependency axisDependency = yAxis.mAxisDependency;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.LEFT;
            ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
            if (axisDependency == axisDependency2) {
                rectF = viewPortHandler.mContentRect;
                f = rectF.left;
                f2 = rectF.top;
            } else {
                rectF = viewPortHandler.mContentRect;
                f = rectF.left;
                f2 = rectF.bottom;
            }
            float f3 = f2;
            canvas.drawLine(f, f3, rectF.right, f3, paint);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void renderLimitLines() {
        ArrayList arrayList = this.mYAxis.mLimitLines;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        this.mRenderLimitLinesPathBuffer.reset();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        d.AnonymousClass0.m$1();
    }
}
