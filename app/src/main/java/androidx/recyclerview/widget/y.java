package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static int a(RecyclerView.a0 a0Var, u uVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(RecyclerView.o.getPosition(view) - RecyclerView.o.getPosition(view2)) + 1;
        }
        return Math.min(uVar.l(), uVar.b(view2) - uVar.e(view));
    }

    public static int b(RecyclerView.a0 a0Var, u uVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (a0Var.b() - Math.max(RecyclerView.o.getPosition(view), RecyclerView.o.getPosition(view2))) - 1) : Math.max(0, Math.min(RecyclerView.o.getPosition(view), RecyclerView.o.getPosition(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(uVar.b(view2) - uVar.e(view)) / (Math.abs(RecyclerView.o.getPosition(view) - RecyclerView.o.getPosition(view2)) + 1))) + (uVar.k() - uVar.e(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.a0 a0Var, u uVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) (((uVar.b(view2) - uVar.e(view)) / (Math.abs(RecyclerView.o.getPosition(view) - RecyclerView.o.getPosition(view2)) + 1)) * a0Var.b());
    }
}
