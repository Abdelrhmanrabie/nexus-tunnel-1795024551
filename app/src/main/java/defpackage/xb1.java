package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xb1 implements rc0, Serializable {
    public oc0 b;
    public Object c;

    /* JADX WARN: Type inference failed for: r0v2, types: [lw, oc0] */
    @Override // defpackage.rc0
    public final Object getValue() {
        if (this.c == e.f33d$1) {
            this.c = this.b.invoke();
            this.b = null;
        }
        return this.c;
    }

    public final String toString() {
        return this.c != e.f33d$1 ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
