package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ k c;

    public e(k kVar, ArrayList arrayList) {
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
                kVar.l.remove(arrayList);
                return;
            }
            RecyclerView.d0 d0Var = (RecyclerView.d0) it.next();
            kVar.getClass();
            View view = d0Var.itemView;
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            kVar.o.add(d0Var);
            viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(kVar.c).setListener(new g(view, viewPropertyAnimatorAnimate, kVar, d0Var)).start();
        }
    }
}
