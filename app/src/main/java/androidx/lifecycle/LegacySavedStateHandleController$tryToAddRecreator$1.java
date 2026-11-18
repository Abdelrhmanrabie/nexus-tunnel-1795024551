package androidx.lifecycle;

import defpackage.he0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements h {
    public final /* synthetic */ e b;
    public final /* synthetic */ androidx.savedstate.a c;

    public LegacySavedStateHandleController$tryToAddRecreator$1(e eVar, androidx.savedstate.a aVar) {
        this.b = eVar;
        this.c = aVar;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        if (aVar == e.a.ON_START) {
            this.b.c(this);
            this.c.d();
        }
    }
}
