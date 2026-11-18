package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ k c;

    public c(k kVar, ArrayList arrayList) {
        this.c = kVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.b;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            k kVar = this.c;
            if (!zHasNext) {
                arrayList.clear();
                kVar.m.remove(arrayList);
                return;
            }
            k.b bVar = (k.b) it.next();
            RecyclerView.d0 d0Var = bVar.a;
            kVar.getClass();
            View view = d0Var.itemView;
            int i = bVar.d - bVar.b;
            int i2 = bVar.e - bVar.c;
            if (i != 0) {
                view.animate().translationX(0.0f);
            }
            if (i2 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.p.add(d0Var);
            viewPropertyAnimatorAnimate.setDuration(kVar.e).setListener(new h(kVar, d0Var, i, view, i2, viewPropertyAnimatorAnimate)).start();
        }
    }
}
