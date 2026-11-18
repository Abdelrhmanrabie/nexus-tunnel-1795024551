package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class HorizontalBarChartRenderer extends BarChartRenderer {
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        BarChart barChart = this.mChart;
        if (isDrawingValuesAllowed(barChart)) {
            barChart.getBarData();
            throw null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
        this.mChart.getBarData();
        throw null;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) ((Chart) chartInterface).mData.getEntryCount()) < ((ViewPortHandler) this.a).mScaleY * ((float) ((BarLineChartBase) chartInterface).mMaxVisibleCount);
    }
}
