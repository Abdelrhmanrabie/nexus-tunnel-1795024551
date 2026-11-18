package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends RecyclerView.r {
    public RecyclerView a;
    public final a b = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends RecyclerView.t {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && this.a) {
                this.a = false;
                a0.this.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.a = true;
        }
    }

    public abstract int[] a(RecyclerView.o oVar, View view);

    /* JADX WARN: Code duplicated, block: B:25:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    public final void b() {
        RecyclerView.o oVar;
        u uVarE;
        int[] iArrA;
        int i;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (oVar = recyclerView.mLayout) == null) {
            return;
        }
        w wVar = (w) this;
        View view = null;
        if (!oVar.canScrollVertically()) {
            if (oVar.canScrollHorizontally()) {
                uVarE = wVar.e(oVar);
            }
            if (view == null) {
                return;
            }
            iArrA = a(oVar, view);
            i = iArrA[0];
            if (i == 0 || iArrA[1] != 0) {
                this.a.smoothScrollBy(i, iArrA[1], false);
            }
            return;
        }
        uVarE = wVar.f(oVar);
        int childCount = oVar.getChildCount();
        if (childCount != 0) {
            int iL = (uVarE.l() / 2) + uVarE.k();
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = oVar.getChildAt(i3);
                int iAbs = Math.abs(((uVarE.c(childAt) / 2) + uVarE.e(childAt)) - iL);
                if (iAbs < i2) {
                    view = childAt;
                    i2 = iAbs;
                }
            }
        }
        if (view == null) {
            return;
        }
        iArrA = a(oVar, view);
        i = iArrA[0];
        if (i == 0) {
        }
        this.a.smoothScrollBy(i, iArrA[1], false);
    }
}
