package androidx.lifecycle;

import defpackage.he0;
import defpackage.qx0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements h {
    public final qx0 b;

    public SavedStateHandleAttacher(qx0 qx0Var) {
        this.b = qx0Var;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        if (aVar == e.a.ON_CREATE) {
            he0Var.getLifecycle().c(this);
            this.b.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
