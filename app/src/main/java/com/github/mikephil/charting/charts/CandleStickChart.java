package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.renderer.CandleStickChartRenderer;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CandleStickChart extends BarLineChartBase<Object> {
    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void getCandleData() {
        if (this.mData == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        CandleStickChartRenderer candleStickChartRenderer = new CandleStickChartRenderer(this.mAnimator, this.mViewPortHandler);
        candleStickChartRenderer.mChart = this;
        this.mRenderer = candleStickChartRenderer;
        XAxis xAxis = this.mXAxis;
        xAxis.mSpaceMin = 0.5f;
        xAxis.mSpaceMax = 0.5f;
    }
}
