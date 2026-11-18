package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import defpackage.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedChartRenderer extends DataRenderer {
    public WeakReference mChart;
    public ArrayList mHighlightBuffer;
    public ArrayList mRenderers;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;
                CombinedChart.DrawOrder[] drawOrderArr = CombinedChart.DrawOrder.$VALUES;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;
                CombinedChart.DrawOrder[] drawOrderArr2 = CombinedChart.DrawOrder.$VALUES;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;
                CombinedChart.DrawOrder[] drawOrderArr3 = CombinedChart.DrawOrder.$VALUES;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$github$mikephil$charting$charts$CombinedChart$DrawOrder;
                CombinedChart.DrawOrder[] drawOrderArr4 = CombinedChart.DrawOrder.$VALUES;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        Iterator it = this.mRenderers.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).drawData(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
        Iterator it = this.mRenderers.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).drawExtras(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0062, please report this as an issue */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData;
        int i;
        int i2;
        ArrayList arrayList = this.mHighlightBuffer;
        Chart chart = (Chart) this.mChart.get();
        if (chart == null) {
            return;
        }
        for (DataRenderer dataRenderer : this.mRenderers) {
            if (dataRenderer instanceof BarChartRenderer) {
                ((BarChartRenderer) dataRenderer).mChart.getBarData();
            } else {
                if (dataRenderer instanceof LineChartRenderer) {
                    lineData = ((LineChartRenderer) dataRenderer).mChart.mData;
                } else if (dataRenderer instanceof CandleStickChartRenderer) {
                    ((CandleStickChartRenderer) dataRenderer).mChart.getCandleData();
                } else if (dataRenderer instanceof ScatterChartRenderer) {
                    ((ScatterChartRenderer) dataRenderer).mChart.getScatterData();
                } else if (dataRenderer instanceof BubbleChartRenderer) {
                    ((BubbleChartRenderer) dataRenderer).mChart.getBubbleData();
                }
                if (lineData == null) {
                    chart.mData.getClass();
                    d.AnonymousClass0.m$1();
                    return;
                }
                arrayList.clear();
                for (Highlight highlight : highlightArr) {
                    i2 = highlight.mDataIndex;
                    if (i2 != -1 || i2 == -1) {
                        arrayList.add(highlight);
                    }
                }
                dataRenderer.drawHighlighted(canvas, (Highlight[]) arrayList.toArray(new Highlight[arrayList.size()]));
            }
            lineData = null;
            if (lineData == null) {
                chart.mData.getClass();
                d.AnonymousClass0.m$1();
                return;
            }
            arrayList.clear();
            while (i < r4) {
                i2 = highlight.mDataIndex;
                if (i2 != -1) {
                    arrayList.add(highlight);
                } else {
                    arrayList.add(highlight);
                }
            }
            dataRenderer.drawHighlighted(canvas, (Highlight[]) arrayList.toArray(new Highlight[arrayList.size()]));
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        Iterator it = this.mRenderers.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).drawValues(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
        Iterator it = this.mRenderers.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).initBuffers();
        }
    }
}
