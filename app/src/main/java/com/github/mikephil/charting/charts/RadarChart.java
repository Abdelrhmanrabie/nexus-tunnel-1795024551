package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RadarChart extends PieRadarChartBase<Object> {
    public final boolean mDrawWeb;
    public XAxisRendererRadarChart mXAxisRenderer;
    public YAxis mYAxis;
    public YAxisRendererRadarChart mYAxisRenderer;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Color.rgb(122, 122, 122);
        Color.rgb(122, 122, 122);
        this.mDrawWeb = true;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Color.rgb(122, 122, 122);
        Color.rgb(122, 122, 122);
        this.mDrawWeb = true;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final void calcMinMax() {
        if (this.mData != null) {
            throw new ClassCastException();
        }
        YAxis.AxisDependency[] axisDependencyArr = YAxis.AxisDependency.$VALUES;
        throw null;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final int getIndexForAngle(float f) {
        Rect rect = Utils.mCalcTextHeightRect;
        getSliceAngle();
        throw null;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRadius() {
        RectF rectF = this.mViewPortHandler.mContentRect;
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRequiredBaseOffset() {
        XAxis xAxis = this.mXAxis;
        return (xAxis.mEnabled && xAxis.mDrawLabels) ? xAxis.mLabelRotatedWidth : Utils.convertDpToPixel(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public final float getRequiredLegendOffset() {
        return this.mLegendRenderer.mLegendLabelPaint.getTextSize() * 4.0f;
    }

    public final void getSliceAngle() {
        this.mData.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        YAxis yAxis = new YAxis(YAxis.AxisDependency.LEFT);
        this.mYAxis = yAxis;
        yAxis.mXLabelOffset = 10.0f;
        Rect rect = Utils.mCalcTextHeightRect;
        RadarChartRenderer radarChartRenderer = new RadarChartRenderer(this.mAnimator, this.mViewPortHandler);
        new Path();
        new Path();
        radarChartRenderer.mChart = this;
        Paint paint = new Paint(1);
        radarChartRenderer.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        radarChartRenderer.mHighlightPaint.setStrokeWidth(2.0f);
        radarChartRenderer.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
        new Paint(1).setStyle(style);
        new Paint(1);
        this.mRenderer = radarChartRenderer;
        YAxisRendererRadarChart yAxisRendererRadarChart = new YAxisRendererRadarChart(this.mViewPortHandler, this.mYAxis, null);
        new Path();
        yAxisRendererRadarChart.mChart = this;
        this.mYAxisRenderer = yAxisRendererRadarChart;
        XAxisRendererRadarChart xAxisRendererRadarChart = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, null, 0);
        xAxisRendererRadarChart.mChart = this;
        this.mXAxisRenderer = xAxisRendererRadarChart;
        this.mHighlighter = new PieHighlighter(this, 1);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public final void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        throw null;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == null) {
            return;
        }
        XAxis xAxis = this.mXAxis;
        if (xAxis.mEnabled) {
            this.mXAxisRenderer.computeAxis(xAxis.mAxisMinimum, xAxis.mAxisMaximum);
        }
        this.mXAxisRenderer.renderAxisLabels(canvas);
        if (this.mDrawWeb) {
            this.mRenderer.drawExtras(canvas);
        }
        boolean z = this.mYAxis.mEnabled;
        this.mRenderer.drawData(canvas);
        Highlight[] highlightArr = this.mIndicesToHighlight;
        if (highlightArr != null && highlightArr.length > 0 && highlightArr[0] != null) {
            this.mRenderer.drawHighlighted(canvas, highlightArr);
        }
        if (this.mYAxis.mEnabled) {
            this.mYAxisRenderer.renderLimitLines();
        }
        this.mYAxisRenderer.renderAxisLabels(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
    }
}
