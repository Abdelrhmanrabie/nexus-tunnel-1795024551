package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.preference.c;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tp0 extends x {
    public final RecyclerView a;
    public final x.a b;
    public final a c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends a1 {
        public a() {
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            RecyclerView recyclerView;
            tp0 tp0Var = tp0.this;
            tp0Var.b.onInitializeAccessibilityNodeInfo(view, o1Var);
            RecyclerView recyclerView2 = tp0Var.a;
            recyclerView2.getClass();
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            int adapterPositionInRecyclerView = (childViewHolderInt == null || (recyclerView = childViewHolderInt.mOwnerRecyclerView) == null) ? -1 : recyclerView.getAdapterPositionInRecyclerView(childViewHolderInt);
            RecyclerView.g gVar = recyclerView2.mAdapter;
            if (gVar instanceof c) {
                ((c) gVar).e(adapterPositionInRecyclerView);
            }
        }

        @Override // defpackage.a1
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return tp0.this.b.performAccessibilityAction(view, i, bundle);
        }
    }

    public tp0(RecyclerView recyclerView) {
        super(recyclerView);
        this.b = this.mItemDelegate;
        this.c = new a();
        this.a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.x
    public final a1 getItemDelegate() {
        return this.c;
    }
}
