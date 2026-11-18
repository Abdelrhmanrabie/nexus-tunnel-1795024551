package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.highlight.Highlight;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    public CandleStickChart mChart;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        this.mChart.getCandleData();
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        this.mChart.getCandleData();
        if (highlightArr.length <= 0) {
            return;
        }
        int i = highlightArr[0].mDataSetIndex;
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        CandleStickChart candleStickChart = this.mChart;
        if (isDrawingValuesAllowed(candleStickChart)) {
            candleStickChart.getCandleData();
            throw null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
    }
}
