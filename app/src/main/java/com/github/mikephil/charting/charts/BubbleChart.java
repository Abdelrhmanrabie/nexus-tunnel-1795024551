package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;
import com.github.mikephil.charting.utils.Utils;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BubbleChart extends BarLineChartBase<Object> {
    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void getBubbleData() {
        if (this.mData == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        BubbleChartRenderer bubbleChartRenderer = new BubbleChartRenderer(this.mAnimator, this.mViewPortHandler);
        bubbleChartRenderer.mChart = this;
        bubbleChartRenderer.mRenderPaint.setStyle(Paint.Style.FILL);
        bubbleChartRenderer.mHighlightPaint.setStyle(Paint.Style.STROKE);
        bubbleChartRenderer.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
        this.mRenderer = bubbleChartRenderer;
    }
}
