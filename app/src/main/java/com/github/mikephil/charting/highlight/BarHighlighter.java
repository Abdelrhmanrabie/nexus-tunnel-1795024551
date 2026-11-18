package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import defpackage.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BarHighlighter extends g {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarHighlighter(BarLineChartBase barLineChartBase, int i) {
        super(barLineChartBase);
        this.G0 = i;
    }

    @Override // defpackage.g
    public LineData getData() {
        if (this.G0 != 0) {
            return super.getData();
        }
        ((BarDataProvider) ((BarLineChartBase) this.a)).getBarData();
        return null;
    }

    @Override // defpackage.g
    public float getDistance(float f, float f2, float f3, float f4) {
        return this.G0 != 0 ? super.getDistance(f, f2, f3, f4) : Math.abs(f - f3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.g, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f, float f2) {
        if (this.G0 != 0) {
            return super.getHighlight(f, f2);
        }
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.a;
        if (super.getHighlight(f, f2) == null) {
            return null;
        }
        barLineChartBase.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f, f2);
        ((BarDataProvider) barLineChartBase).getBarData();
        throw null;
    }

    @Override // defpackage.g
    public List getHighlightsAtXValue(float f) {
        if (this.G0 != 1) {
            return super.getHighlightsAtXValue(f);
        }
        ((ArrayList) this.b).clear();
        ((CombinedChart) ((BarLineChartBase) this.a)).mData.getClass();
        throw new ClassCastException();
    }
}
