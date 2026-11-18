package defpackage;

import androidx.lifecycle.t;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g20 implements t.b {
    public final ae1[] a;

    public g20(ae1... ae1VarArr) {
        this.a = ae1VarArr;
    }

    @Override // androidx.lifecycle.t.b
    public final zd1 a(Class cls, xi0 xi0Var) {
        rx0 rx0Var = null;
        for (ae1 ae1Var : this.a) {
            if (e4.a(ae1Var.a, cls)) {
                ae1Var.b.getClass();
                rx0Var = new rx0();
            }
        }
        if (rx0Var != null) {
            return rx0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }

    @Override // androidx.lifecycle.t.b
    public final zd1 b(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }
}
