package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class HorizontalBarHighlighter extends BarHighlighter {
    @Override // defpackage.g
    public final ArrayList buildHighlights(IDataSet iDataSet, int i, float f) {
        Entry entryForXValue;
        DataSet$Rounding dataSet$Rounding = DataSet$Rounding.CLOSEST;
        ArrayList arrayList = new ArrayList();
        LineDataSet lineDataSet = (LineDataSet) iDataSet;
        ArrayList<Entry> entriesForXValue = lineDataSet.getEntriesForXValue(f);
        if (entriesForXValue.size() == 0 && (entryForXValue = lineDataSet.getEntryForXValue(f, Float.NaN, dataSet$Rounding)) != null) {
            entriesForXValue = lineDataSet.getEntriesForXValue(entryForXValue.x);
        }
        if (entriesForXValue.size() != 0) {
            for (Entry entry : entriesForXValue) {
                MPPointD pixelForValues = ((BarLineChartBase) ((BarDataProvider) ((BarLineChartBase) this.a))).getTransformer(lineDataSet.mAxisDependency).getPixelForValues(entry.y, entry.x);
                arrayList.add(new Highlight(entry.x, entry.y, (float) pixelForValues.x, (float) pixelForValues.y, i, lineDataSet.mAxisDependency));
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, defpackage.g
    public final float getDistance(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.highlight.BarHighlighter, defpackage.g, com.github.mikephil.charting.highlight.IHighlighter
    public final Highlight getHighlight(float f, float f2) {
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.a;
        ((BarDataProvider) barLineChartBase).getBarData();
        if (getHighlightForX((float) barLineChartBase.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f2, f).y, f2, f) == null) {
            return null;
        }
        throw null;
    }
}
