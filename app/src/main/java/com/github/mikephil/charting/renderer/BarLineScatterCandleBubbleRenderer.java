package com.github.mikephil.charting.renderer;

import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
    public final XBounds mXBounds;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class XBounds {
        public int max;
        public int min;
        public int range;

        public XBounds() {
        }

        public final void set(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, LineDataSet lineDataSet) {
            BarLineScatterCandleBubbleRenderer.this.mAnimator.getClass();
            float fMax = Math.max(0.0f, Math.min(1.0f, 1.0f));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            Entry entryForXValue = lineDataSet.getEntryForXValue(lowestVisibleX, Float.NaN, DataSet$Rounding.DOWN);
            ArrayList arrayList = lineDataSet.mEntries;
            Entry entryForXValue2 = lineDataSet.getEntryForXValue(highestVisibleX, Float.NaN, DataSet$Rounding.UP);
            this.min = entryForXValue == null ? 0 : arrayList.indexOf(entryForXValue);
            int iIndexOf = entryForXValue2 != null ? arrayList.indexOf(entryForXValue2) : 0;
            this.max = iIndexOf;
            this.range = (int) ((iIndexOf - this.min) * fMax);
        }
    }

    public BarLineScatterCandleBubbleRenderer(HurlStack hurlStack, ViewPortHandler viewPortHandler) {
        super(hurlStack, viewPortHandler);
        this.mXBounds = new XBounds();
    }
}
