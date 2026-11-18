package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import defpackage.bj;
import defpackage.cw;
import defpackage.gb;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class e extends cw {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements h.g {
        public final /* synthetic */ View b;
        public final /* synthetic */ ArrayList c;

        public a(View view, ArrayList arrayList) {
            this.b = view;
            this.c = arrayList;
        }

        @Override // androidx.transition.h.g
        public final void onTransitionCancel() {
        }

        @Override // androidx.transition.h.g
        public final void onTransitionEnd(h hVar) {
            hVar.removeListener(this);
            this.b.setVisibility(8);
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((View) arrayList.get(i)).setVisibility(0);
            }
        }

        @Override // androidx.transition.h.g
        public final void onTransitionPause() {
        }

        @Override // androidx.transition.h.g
        public final void onTransitionResume() {
        }

        @Override // androidx.transition.h.g
        public final void onTransitionStart(h hVar) {
            hVar.removeListener(this);
            hVar.addListener(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends h.f {
        public b(Rect rect) {
        }
    }

    @Override // defpackage.cw
    public final void a(View view, Object obj) {
        ((h) obj).addTarget(view);
    }

    @Override // defpackage.cw
    public final void b(Object obj, ArrayList arrayList) {
        h hVar = (h) obj;
        if (hVar == null) {
            return;
        }
        int i = 0;
        if (hVar instanceof k) {
            k kVar = (k) hVar;
            int size = kVar.b.size();
            while (i < size) {
                b((i < 0 || i >= kVar.b.size()) ? null : (h) kVar.b.get(i), arrayList);
                i++;
            }
            return;
        }
        if (cw.h(hVar.mTargetIds) && cw.h(hVar.mTargets)) {
            int size2 = arrayList.size();
            while (i < size2) {
                hVar.addTarget((View) arrayList.get(i));
                i++;
            }
        }
    }

    @Override // defpackage.cw
    public final void c(ViewGroup viewGroup, Object obj) {
        j.a(viewGroup, (h) obj);
    }

    @Override // defpackage.cw
    public final boolean e(Object obj) {
        return obj instanceof h;
    }

    @Override // defpackage.cw
    public final Object f(Object obj) {
        if (obj != null) {
            return ((h) obj).mo1clone();
        }
        return null;
    }

    @Override // defpackage.cw
    public final Object i(Object obj, Object obj2, Object obj3) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        h hVar3 = (h) obj3;
        if (hVar != null && hVar2 != null) {
            k kVar = new k();
            kVar.a(hVar);
            kVar.a(hVar2);
            kVar.f(1);
            hVar = kVar;
        } else if (hVar == null) {
            hVar = hVar2 != null ? hVar2 : null;
        }
        if (hVar3 == null) {
            return hVar;
        }
        k kVar2 = new k();
        if (hVar != null) {
            kVar2.a(hVar);
        }
        kVar2.a(hVar3);
        return kVar2;
    }

    @Override // defpackage.cw
    public final Object j(Object obj, Object obj2) {
        k kVar = new k();
        if (obj != null) {
            kVar.a((h) obj);
        }
        kVar.a((h) obj2);
        return kVar;
    }

    @Override // defpackage.cw
    public final void k(Object obj, View view, ArrayList arrayList) {
        ((h) obj).addListener(new a(view, arrayList));
    }

    @Override // defpackage.cw
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((h) obj).addListener(new f(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // defpackage.cw
    public final void m(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            cw.g(view, rect);
            ((h) obj).setEpicenterCallback(new d(rect));
        }
    }

    @Override // defpackage.cw
    public final void n(Object obj, Rect rect) {
        ((h) obj).setEpicenterCallback(new b(rect));
    }

    @Override // defpackage.cw
    public final void o(Object obj, gb gbVar, androidx.fragment.app.k kVar) {
        h hVar = (h) obj;
        gbVar.b(new bj(14, hVar));
        hVar.addListener(new g(kVar));
    }

    @Override // defpackage.cw
    public final void p(Object obj, View view, ArrayList arrayList) {
        k kVar = (k) obj;
        ArrayList arrayList2 = kVar.mTargets;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cw.d((View) arrayList.get(i), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(kVar, arrayList);
    }

    @Override // defpackage.cw
    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        k kVar = (k) obj;
        if (kVar != null) {
            ArrayList arrayList3 = kVar.mTargets;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            t(kVar, arrayList, arrayList2);
        }
    }

    @Override // defpackage.cw
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        k kVar = new k();
        kVar.a((h) obj);
        return kVar;
    }

    public final void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        h hVar = (h) obj;
        int i = 0;
        if (hVar instanceof k) {
            k kVar = (k) hVar;
            int size = kVar.b.size();
            while (i < size) {
                t((i < 0 || i >= kVar.b.size()) ? null : (h) kVar.b.get(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (!cw.h(hVar.mTargetIds)) {
            return;
        }
        ArrayList arrayList3 = hVar.mTargets;
        if (arrayList3.size() != arrayList.size() || !arrayList3.containsAll(arrayList)) {
            return;
        }
        int size2 = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size2) {
            hVar.addTarget((View) arrayList2.get(i));
            i++;
        }
        int size3 = arrayList.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                return;
            } else {
                hVar.removeTarget((View) arrayList.get(size3));
            }
        }
    }
}
