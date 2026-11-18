package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    public final BarChart mChart;

    public BarChartRenderer(BarChart barChart, HurlStack hurlStack, ViewPortHandler viewPortHandler) {
        super(hurlStack, viewPortHandler);
        new RectF();
        new RectF();
        this.mChart = barChart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        new Paint(1).setStyle(style);
        new Paint(1).setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        this.mChart.getBarData();
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        this.mChart.getBarData();
        if (highlightArr.length <= 0) {
            return;
        }
        int i = highlightArr[0].mDataSetIndex;
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        BarChart barChart = this.mChart;
        if (isDrawingValuesAllowed(barChart)) {
            barChart.getBarData();
            throw null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        this.mChart.getBarData();
        throw null;
    }
}
