package androidx.lifecycle;

import defpackage.he0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements h {
    public final String b;
    public final n c;
    public boolean d;

    public SavedStateHandleController(String str, n nVar) {
        this.b = str;
        this.c = nVar;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.d = false;
            he0Var.getLifecycle().c(this);
        }
    }
}
