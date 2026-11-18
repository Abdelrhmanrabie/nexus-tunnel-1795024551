package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class w extends a0 {
    public t c;
    public s d;

    public static int c(View view, u uVar) {
        return ((uVar.c(view) / 2) + uVar.e(view)) - ((uVar.l() / 2) + uVar.k());
    }

    @Override // androidx.recyclerview.widget.a0
    public final int[] a(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = c(view, e(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = c(view, f(oVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final s e(RecyclerView.o oVar) {
        s sVar = this.d;
        if (sVar == null || sVar.a != oVar) {
            this.d = new s(oVar);
        }
        return this.d;
    }

    public final t f(RecyclerView.o oVar) {
        t tVar = this.c;
        if (tVar == null || tVar.a != oVar) {
            this.c = new t(oVar);
        }
        return this.c;
    }
}
