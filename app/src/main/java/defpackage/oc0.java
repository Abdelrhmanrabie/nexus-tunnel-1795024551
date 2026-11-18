package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class oc0 implements kx, Serializable {
    private final int arity;

    public oc0(int i) {
        this.arity = i;
    }

    @Override // defpackage.kx
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        return ou0.a.h(this);
    }
}
