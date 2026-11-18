package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MenuItem;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class k8 implements IHighlighter {
    public Object a;
    public Object b;

    public k8(Context context) {
        this.a = context;
    }

    public k8(f5 f5Var) {
        this.b = f5Var;
    }

    public void a() {
        f5$h$a f5_h_a = (f5$h$a) this.a;
        if (f5_h_a != null) {
            try {
                ((f5) this.b).g.unregisterReceiver(f5_h_a);
            } catch (IllegalArgumentException unused) {
            }
            this.a = null;
        }
    }

    public abstract IntentFilter b();

    public abstract int c();

    public MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof m41)) {
            return menuItem;
        }
        m41 m41Var = (m41) menuItem;
        if (((o01) this.b) == null) {
            this.b = new o01();
        }
        MenuItem menuItem2 = (MenuItem) ((o01) this.b).getOrDefault(menuItem, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        hh0 hh0Var = new hh0((Context) this.a, m41Var);
        ((o01) this.b).put(m41Var, hh0Var);
        return hh0Var;
    }

    public abstract void d();

    public void e() {
        a();
        IntentFilter intentFilterB = b();
        if (intentFilterB.countActions() == 0) {
            return;
        }
        if (((f5$h$a) this.a) == null) {
            this.a = new BroadcastReceiver() { // from class: f5$h$a
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    this.a.d();
                }
            };
        }
        ((f5) this.b).g.registerReceiver((f5$h$a) this.a, intentFilterB);
    }

    public abstract Highlight getClosestHighlight();

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f, float f2) {
        IDataSet iDataSet;
        PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) this.a;
        if (pieRadarChartBase.distanceToCenter(f, f2) <= pieRadarChartBase.getRadius()) {
            float angleForPoint = pieRadarChartBase.getAngleForPoint(f, f2);
            if (pieRadarChartBase instanceof PieChart) {
                pieRadarChartBase.mAnimator.getClass();
                angleForPoint /= 1.0f;
            }
            int indexForAngle = pieRadarChartBase.getIndexForAngle(angleForPoint);
            if (indexForAngle >= 0) {
                ArrayList<IDataSet> arrayList = pieRadarChartBase.mData.mDataSets;
                if (arrayList == null || arrayList.isEmpty()) {
                    iDataSet = null;
                } else {
                    iDataSet = (IDataSet) arrayList.get(0);
                    for (IDataSet iDataSet2 : arrayList) {
                        if (((LineDataSet) iDataSet2).mEntries.size() > ((LineDataSet) iDataSet).mEntries.size()) {
                            iDataSet = iDataSet2;
                        }
                    }
                }
                if (indexForAngle < ((LineDataSet) iDataSet).mEntries.size()) {
                    getClosestHighlight();
                    throw null;
                }
            }
        }
        return null;
    }
}
