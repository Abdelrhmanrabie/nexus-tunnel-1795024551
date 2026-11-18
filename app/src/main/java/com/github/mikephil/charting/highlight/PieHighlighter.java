package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import defpackage.k8;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PieHighlighter extends k8 {
    public final /* synthetic */ int G0;

    public PieHighlighter(PieRadarChartBase pieRadarChartBase, int i) {
        this.G0 = i;
        this.b = new ArrayList();
        this.a = pieRadarChartBase;
    }

    @Override // defpackage.k8
    public final Highlight getClosestHighlight() {
        if (this.G0 == 0) {
            ((PieChart) ((PieRadarChartBase) this.a)).mData.getClass();
            throw new ClassCastException();
        }
        ((ArrayList) this.b).clear();
        RadarChart radarChart = (RadarChart) ((PieRadarChartBase) this.a);
        radarChart.mAnimator.getClass();
        radarChart.mAnimator.getClass();
        radarChart.getSliceAngle();
        throw null;
    }
}
