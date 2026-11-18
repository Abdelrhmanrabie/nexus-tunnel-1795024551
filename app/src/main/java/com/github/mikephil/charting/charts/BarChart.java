package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BarChart extends BarLineChartBase<Object> implements BarDataProvider {
    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void calcMinMax() {
        this.mData.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public final void getBarData() {
        if (this.mData == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            return null;
        }
        return this.mHighlighter.getHighlight(f, f2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mHighlighter = new BarHighlighter(this, 0);
        XAxis xAxis = this.mXAxis;
        xAxis.mSpaceMin = 0.5f;
        xAxis.mSpaceMax = 0.5f;
    }
}
