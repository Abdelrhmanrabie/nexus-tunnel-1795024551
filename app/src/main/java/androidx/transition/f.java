package androidx.transition;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i {
    public final /* synthetic */ Object b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Object g;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ e j;

    public f(e eVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.j = eVar;
        this.b = obj;
        this.c = arrayList;
        this.g = obj2;
        this.i = arrayList2;
    }

    @Override // androidx.transition.h.g
    public final void onTransitionEnd(h hVar) {
        hVar.removeListener(this);
    }

    @Override // androidx.transition.i, androidx.transition.h.g
    public final void onTransitionStart(h hVar) {
        e eVar = this.j;
        Object obj = this.b;
        if (obj != null) {
            eVar.t(obj, this.c, null);
        }
        Object obj2 = this.g;
        if (obj2 != null) {
            eVar.t(obj2, this.i, null);
        }
    }
}
