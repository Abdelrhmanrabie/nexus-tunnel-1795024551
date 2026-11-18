package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;
import defpackage.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CombinedChart extends BarLineChartBase<Object> implements BarDataProvider {
    public DrawOrder[] mDrawOrder;
    public boolean mHighlightFullBarEnabled;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class DrawOrder {
        public static final /* synthetic */ DrawOrder[] $VALUES;
        public static final DrawOrder BAR;
        public static final DrawOrder BUBBLE;
        public static final DrawOrder CANDLE;
        public static final DrawOrder LINE;
        public static final DrawOrder SCATTER;

        static {
            DrawOrder drawOrder = new DrawOrder("BAR", 0);
            BAR = drawOrder;
            DrawOrder drawOrder2 = new DrawOrder("BUBBLE", 1);
            BUBBLE = drawOrder2;
            DrawOrder drawOrder3 = new DrawOrder("LINE", 2);
            LINE = drawOrder3;
            DrawOrder drawOrder4 = new DrawOrder("CANDLE", 3);
            CANDLE = drawOrder4;
            DrawOrder drawOrder5 = new DrawOrder("SCATTER", 4);
            SCATTER = drawOrder5;
            $VALUES = new DrawOrder[]{drawOrder, drawOrder2, drawOrder3, drawOrder4, drawOrder5};
        }

        public static DrawOrder valueOf(String str) {
            return (DrawOrder) Enum.valueOf(DrawOrder.class, str);
        }

        public static DrawOrder[] values() {
            return (DrawOrder[]) $VALUES.clone();
        }
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightFullBarEnabled = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHighlightFullBarEnabled = false;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public final void getBarData() {
        if (this.mData == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            return null;
        }
        Highlight highlight = this.mHighlighter.getHighlight(f, f2);
        return (highlight == null || !this.mHighlightFullBarEnabled) ? highlight : new Highlight(highlight.mX, highlight.mY, highlight.mXPx, highlight.mYPx, highlight.mDataSetIndex, highlight.axis);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0085  */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        BarHighlighter barHighlighter = new BarHighlighter(this, 1);
        getBarData();
        this.mHighlighter = barHighlighter;
        this.mHighlightFullBarEnabled = true;
        CombinedChartRenderer combinedChartRenderer = new CombinedChartRenderer(this.mAnimator, this.mViewPortHandler);
        ArrayList arrayList = new ArrayList(5);
        combinedChartRenderer.mRenderers = arrayList;
        combinedChartRenderer.mHighlightBuffer = new ArrayList();
        WeakReference weakReference = new WeakReference(this);
        combinedChartRenderer.mChart = weakReference;
        arrayList.clear();
        CombinedChart combinedChart = (CombinedChart) weakReference.get();
        if (combinedChart != null) {
            for (DrawOrder drawOrder : combinedChart.mDrawOrder) {
                int i = CombinedChartRenderer.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder[drawOrder.ordinal()];
                if (i == 1) {
                    combinedChart.getBarData();
                } else if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && combinedChart.mData != null) {
                                d.AnonymousClass0.m$1();
                            }
                        } else if (combinedChart.mData != null) {
                            d.AnonymousClass0.m$1();
                        }
                    } else if (combinedChart.mData != null) {
                        d.AnonymousClass0.m$1();
                    }
                } else if (combinedChart.mData != null) {
                    d.AnonymousClass0.m$1();
                }
            }
        }
        this.mRenderer = combinedChartRenderer;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final void setData(LineData lineData) {
        throw null;
    }
}
