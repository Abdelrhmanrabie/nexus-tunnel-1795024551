package defpackage;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kx0 implements rc0, Serializable {
    public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(kx0.class, Object.class, "c");
    public volatile oc0 b;
    public volatile Object c;

    /* JADX WARN: Type inference failed for: r0v1, types: [lw, oc0] */
    @Override // defpackage.rc0
    public final Object getValue() {
        Object obj = this.c;
        e eVar = e.f33d$1;
        if (obj != eVar) {
            return obj;
        }
        ?? r0 = this.b;
        if (r0 != 0) {
            Object objInvoke = r0.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, eVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != eVar) {
                }
            }
            this.b = null;
            return objInvoke;
        }
        return this.c;
    }

    public final String toString() {
        return this.c != e.f33d$1 ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
