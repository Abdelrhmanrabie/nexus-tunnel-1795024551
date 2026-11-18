package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import defpackage.d;
import java.lang.ref.WeakReference;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PieChart extends PieRadarChartBase<Object> {
    public final float[] mAbsoluteAngles;
    public final String mCenterText;
    public final MPPointF mCenterTextOffset;
    public final float mCenterTextRadiusPercent;
    public final RectF mCircleBox;
    public final float[] mDrawAngles;
    public final boolean mDrawCenterText;
    public final boolean mDrawHole;
    public final float mHoleRadiusPercent;
    public final float mTransparentCircleRadiusPercent;

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mCenterText = AppConfig.CUSTOM;
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleBox = new RectF();
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mCenterText = AppConfig.CUSTOM;
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final void calcMinMax() {
        this.mData.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == null) {
            return;
        }
        RectF rectF = this.mViewPortHandler.mContentRect;
        rectF.left += 0.0f;
        rectF.top += 0.0f;
        rectF.right -= 0.0f;
        rectF.bottom -= 0.0f;
        Math.min(rectF.width(), rectF.height());
        getCenterOffsets();
        this.mData.getClass();
        d.AnonymousClass0.m$1();
    }

    public final MPPointF getCenterCircleBox() {
        RectF rectF = this.mCircleBox;
        return MPPointF.getInstance(rectF.centerX(), rectF.centerY());
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final int getIndexForAngle(float f) {
        float f2 = f - this.mRotationAngle;
        Rect rect = Utils.mCalcTextHeightRect;
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        float f3 = f2 % 360.0f;
        int i = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i >= fArr.length) {
                return -1;
            }
            if (fArr[i] > f3) {
                return i;
            }
            i++;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRequiredLegendOffset() {
        return this.mLegendRenderer.mLegendLabelPaint.getTextSize() * 2.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        PieChartRenderer pieChartRenderer = new PieChartRenderer(this.mAnimator, this.mViewPortHandler);
        pieChartRenderer.mCenterTextLastBounds = new RectF();
        pieChartRenderer.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        new Path();
        new RectF();
        pieChartRenderer.mHoleCirclePath = new Path();
        pieChartRenderer.mDrawCenterTextPathBuffer = new Path();
        pieChartRenderer.mDrawHighlightedRectF = new RectF();
        pieChartRenderer.mChart = this;
        Paint paint = new Paint(1);
        pieChartRenderer.mHolePaint = paint;
        paint.setColor(-1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        pieChartRenderer.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        paint2.setStyle(style);
        paint2.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        pieChartRenderer.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        textPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        float fConvertDpToPixel = Utils.convertDpToPixel(13.0f);
        Paint paint3 = pieChartRenderer.mValuePaint;
        paint3.setTextSize(fConvertDpToPixel);
        paint3.setColor(-1);
        Paint.Align align = Paint.Align.CENTER;
        paint3.setTextAlign(align);
        Paint paint4 = new Paint(1);
        paint4.setColor(-1);
        paint4.setTextAlign(align);
        paint4.setTextSize(Utils.convertDpToPixel(13.0f));
        new Paint(1).setStyle(Paint.Style.STROKE);
        this.mRenderer = pieChartRenderer;
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this, 0);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            PieChartRenderer pieChartRenderer = (PieChartRenderer) dataRenderer;
            Canvas canvas = pieChartRenderer.mBitmapCanvas;
            if (canvas != null) {
                canvas.setBitmap(null);
                pieChartRenderer.mBitmapCanvas = null;
            }
            WeakReference weakReference = pieChartRenderer.mDrawBitmap;
            if (weakReference != null) {
                Bitmap bitmap = (Bitmap) weakReference.get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                pieChartRenderer.mDrawBitmap.clear();
                pieChartRenderer.mDrawBitmap = null;
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == null) {
            return;
        }
        this.mRenderer.drawData(canvas);
        Highlight[] highlightArr = this.mIndicesToHighlight;
        if (highlightArr != null && highlightArr.length > 0 && highlightArr[0] != null) {
            this.mRenderer.drawHighlighted(canvas, highlightArr);
        }
        this.mRenderer.drawExtras(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
    }
}
