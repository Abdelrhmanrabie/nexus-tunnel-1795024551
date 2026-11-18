package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class p7 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p7.class, Object.class, "_consensus$volatile");
    public volatile /* synthetic */ Object _consensus$volatile;

    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        ci0 ci0Var = e.a;
        if (obj2 == ci0Var) {
            ci0 ci0VarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == ci0Var) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, ci0Var, ci0VarC)) {
                    if (atomicReferenceFieldUpdater.get(this) != ci0Var) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                    }
                }
                obj2 = ci0VarC;
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract ci0 c(Object obj);

    public final String toString() {
        return getClass().getSimpleName() + '@' + e.D(this);
    }
}
