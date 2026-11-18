package androidx.lifecycle;

import defpackage.he0;
import defpackage.li;
import defpackage.ti;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl implements h, ti {
    public final e b;
    public final li c;

    public LifecycleCoroutineScopeImpl(e eVar, li liVar) {
        this.b = eVar;
        this.c = liVar;
        if (eVar.b() == e.b.DESTROYED) {
            defpackage.e.z0(liVar, null);
        }
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        e eVar = this.b;
        if (eVar.b().compareTo(e.b.DESTROYED) <= 0) {
            eVar.c(this);
            defpackage.e.z0(this.c, null);
        }
    }

    @Override // defpackage.ti
    public final li x() {
        return this.c;
    }
}
