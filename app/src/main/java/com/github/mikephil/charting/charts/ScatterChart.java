package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ScatterChart extends BarLineChartBase<Object> {
    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void getScatterData() {
        if (this.mData == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        ScatterChartRenderer scatterChartRenderer = new ScatterChartRenderer(this.mAnimator, this.mViewPortHandler);
        scatterChartRenderer.mChart = this;
        this.mRenderer = scatterChartRenderer;
        XAxis xAxis = this.mXAxis;
        xAxis.mSpaceMin = 0.5f;
        xAxis.mSpaceMax = 0.5f;
    }
}
