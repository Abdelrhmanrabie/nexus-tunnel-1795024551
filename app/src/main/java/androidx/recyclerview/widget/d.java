package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ k c;

    public d(k kVar, ArrayList arrayList) {
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
                kVar.n.remove(arrayList);
                return;
            }
            k.a aVar = (k.a) it.next();
            kVar.getClass();
            RecyclerView.d0 d0Var = aVar.a;
            View view = d0Var == null ? null : d0Var.itemView;
            RecyclerView.d0 d0Var2 = aVar.b;
            View view2 = d0Var2 != null ? d0Var2.itemView : null;
            ArrayList arrayList2 = kVar.r;
            long j = kVar.f;
            if (view != null) {
                ViewPropertyAnimator duration = view.animate().setDuration(j);
                arrayList2.add(aVar.a);
                duration.translationX(aVar.e - aVar.c);
                duration.translationY(aVar.f - aVar.d);
                duration.alpha(0.0f).setListener(new i(kVar, aVar, duration, view)).start();
            }
            if (view2 != null) {
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                arrayList2.add(aVar.b);
                viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new j(kVar, aVar, viewPropertyAnimatorAnimate, view2)).start();
            }
        }
    }
}
