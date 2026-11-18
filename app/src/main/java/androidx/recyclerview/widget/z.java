package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends RecyclerView.l {
    public final boolean g = true;

    public final boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        boolean zShouldIgnore = d0Var2.shouldIgnore();
        View view = d0Var2.itemView;
        if (zShouldIgnore) {
            int i5 = cVar.a;
            i2 = cVar.b;
            i = i5;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        k kVar = (k) this;
        if (d0Var == d0Var2) {
            return kVar.g(d0Var, i3, i4, i, i2);
        }
        View view2 = d0Var.itemView;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        float alpha = view2.getAlpha();
        kVar.l(d0Var);
        view2.setTranslationX(translationX);
        view2.setTranslationY(translationY);
        view2.setAlpha(alpha);
        kVar.l(d0Var2);
        view.setTranslationX(-((int) ((i - i3) - translationX)));
        view.setTranslationY(-((int) ((i2 - i4) - translationY)));
        view.setAlpha(0.0f);
        kVar.k.add(new k.a(d0Var, d0Var2, i3, i4, i, i2));
        return true;
    }

    public abstract boolean g(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4);
}
