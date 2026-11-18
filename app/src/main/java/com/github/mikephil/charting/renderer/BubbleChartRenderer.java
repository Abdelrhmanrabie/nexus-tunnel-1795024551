package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.highlight.Highlight;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
    public BubbleChart mChart;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        this.mChart.getBubbleData();
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        this.mChart.getBubbleData();
        this.mAnimator.getClass();
        if (highlightArr.length <= 0) {
            return;
        }
        int i = highlightArr[0].mDataSetIndex;
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        this.mChart.getBubbleData();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
    }
}
