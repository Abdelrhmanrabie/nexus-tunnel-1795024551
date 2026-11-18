package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.d;
import defpackage.e91;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class YAxisRenderer extends AxisRenderer {
    public float[] mGetTransformedPositionsBuffer;
    public final RectF mGridClippingRect;
    public final Path mRenderGridLinesPath;
    public final Path mRenderLimitLines;
    public final float[] mRenderLimitLinesBuffer;
    public final YAxis mYAxis;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, e91 e91Var) {
        super(viewPortHandler, e91Var, yAxis);
        this.mRenderGridLinesPath = new Path();
        this.mGridClippingRect = new RectF();
        this.mGetTransformedPositionsBuffer = new float[2];
        new Path();
        new RectF();
        this.mRenderLimitLines = new Path();
        this.mRenderLimitLinesBuffer = new float[2];
        new RectF();
        this.mYAxis = yAxis;
        if (viewPortHandler != null) {
            this.mAxisLabelPaint.setColor(-16777216);
            this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
            Paint paint = new Paint(1);
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        YAxis yAxis = this.mYAxis;
        boolean z = yAxis.mDrawTopYLabelEntry;
        int i = yAxis.mEntryCount;
        if (!z) {
            i--;
        }
        float f3 = yAxis.mXLabelOffset;
        for (int i2 = !yAxis.mDrawBottomYLabelEntry ? 1 : 0; i2 < i; i2++) {
            canvas.drawText(yAxis.getFormattedLabel(i2), f + f3, fArr[(i2 * 2) + 1] + f2, this.mAxisLabelPaint);
        }
    }

    public RectF getGridClippingRect() {
        RectF rectF = ((ViewPortHandler) this.a).mContentRect;
        RectF rectF2 = this.mGridClippingRect;
        rectF2.set(rectF);
        rectF2.inset(0.0f, -this.mAxis.mGridLineWidth);
        return rectF2;
    }

    public float[] getTransformedPositions() {
        int length = this.mGetTransformedPositionsBuffer.length;
        YAxis yAxis = this.mYAxis;
        int i = yAxis.mEntryCount * 2;
        if (length != i) {
            this.mGetTransformedPositionsBuffer = new float[i];
        }
        float[] fArr = this.mGetTransformedPositionsBuffer;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2 + 1] = yAxis.mEntries[i2 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        return fArr;
    }

    public Path linePath(Path path, int i, float[] fArr) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        int i2 = i + 1;
        path.moveTo(viewPortHandler.mContentRect.left, fArr[i2]);
        path.lineTo(viewPortHandler.mContentRect.right, fArr[i2]);
        return path;
    }

    public void renderAxisLabels(Canvas canvas) {
        float f;
        float f2;
        float f3;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawLabels) {
            float[] transformedPositions = getTransformedPositions();
            Paint paint = this.mAxisLabelPaint;
            paint.setTypeface(null);
            paint.setTextSize(yAxis.mTextSize);
            paint.setColor(yAxis.mTextColor);
            float f4 = yAxis.mXOffset;
            float fCalcTextHeight = yAxis.mYOffset + (Utils.calcTextHeight(paint, "A") / 2.5f);
            YAxis.AxisDependency axisDependency = yAxis.mAxisDependency;
            YAxis.YAxisLabelPosition yAxisLabelPosition = yAxis.mPosition;
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (yAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    paint.setTextAlign(Paint.Align.RIGHT);
                    f = viewPortHandler.mContentRect.left;
                    f3 = f - f4;
                } else {
                    paint.setTextAlign(Paint.Align.LEFT);
                    f2 = viewPortHandler.mContentRect.left;
                    f3 = f2 + f4;
                }
            } else if (yAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                paint.setTextAlign(Paint.Align.LEFT);
                f2 = viewPortHandler.mContentRect.right;
                f3 = f2 + f4;
            } else {
                paint.setTextAlign(Paint.Align.RIGHT);
                f = viewPortHandler.mContentRect.right;
                f3 = f - f4;
            }
            drawYLabels(canvas, f3, transformedPositions, fCalcTextHeight);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        RectF rectF;
        float f;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawAxisLine) {
            int i = yAxis.mAxisLineColor;
            Paint paint = this.mAxisLinePaint;
            paint.setColor(i);
            paint.setStrokeWidth(yAxis.mAxisLineWidth);
            if (yAxis.mAxisDependency == YAxis.AxisDependency.LEFT) {
                rectF = viewPortHandler.mContentRect;
                f = rectF.left;
            } else {
                rectF = viewPortHandler.mContentRect;
                f = rectF.right;
            }
            float f2 = f;
            canvas.drawLine(f2, rectF.top, f2, viewPortHandler.mContentRect.bottom, paint);
        }
    }

    public final void renderGridLines(Canvas canvas) {
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawGridLines) {
            int iSave = canvas.save();
            canvas.clipRect(getGridClippingRect());
            float[] transformedPositions = getTransformedPositions();
            int i = yAxis.mGridColor;
            Paint paint = this.mGridPaint;
            paint.setColor(i);
            paint.setStrokeWidth(yAxis.mGridLineWidth);
            paint.setPathEffect(null);
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i2 = 0; i2 < transformedPositions.length; i2 += 2) {
                canvas.drawPath(linePath(path, i2, transformedPositions), paint);
                path.reset();
            }
            canvas.restoreToCount(iSave);
        }
    }

    public void renderLimitLines() {
        ArrayList arrayList = this.mYAxis.mLimitLines;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        this.mRenderLimitLines.reset();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        d.AnonymousClass0.m$1();
    }
}
