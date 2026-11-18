package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class kf0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(kf0.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(kf0.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(kf0.class, Object.class, "_removedRef$volatile");
    public volatile /* synthetic */ Object _next$volatile = this;
    public volatile /* synthetic */ Object _prev$volatile = this;
    public volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class b extends uq0 implements ka0 {
        @Override // kotlin.jvm.internal.a
        public final a90 computeReflected() {
            return ou0.a.e(this);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            return this.receiver.getClass().getSimpleName();
        }
    }

    public final kf0 e() {
        kf0 kf0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = c;
            kf0 kf0Var2 = (kf0) atomicReferenceFieldUpdater2.get(this);
            kf0Var = kf0Var2;
            while (true) {
                kf0 kf0Var3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = b;
                    obj = atomicReferenceFieldUpdater.get(kf0Var);
                    if (obj == this) {
                        if (kf0Var2 != kf0Var) {
                            while (!atomicReferenceFieldUpdater2.compareAndSet(this, kf0Var2, kf0Var)) {
                                if (atomicReferenceFieldUpdater2.get(this) != kf0Var2) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        break;
                    }
                    if (j()) {
                        return null;
                    }
                    if (obj == null) {
                        break loop0;
                    }
                    if (obj instanceof p7) {
                        ((p7) obj).a(kf0Var);
                        break;
                    }
                    if (!(obj instanceof yu0)) {
                        kf0Var3 = kf0Var;
                        kf0Var = (kf0) obj;
                    } else {
                        if (kf0Var3 != null) {
                            break;
                        }
                        kf0Var = (kf0) atomicReferenceFieldUpdater2.get(kf0Var);
                    }
                }
                kf0 kf0Var4 = ((yu0) obj).a;
                while (!atomicReferenceFieldUpdater.compareAndSet(kf0Var3, kf0Var, kf0Var4)) {
                    if (atomicReferenceFieldUpdater.get(kf0Var3) != kf0Var) {
                        break;
                    }
                }
                kf0Var = kf0Var3;
            }
        }
        return kf0Var;
    }

    public final void f(kf0 kf0Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            kf0 kf0Var2 = (kf0) atomicReferenceFieldUpdater.get(kf0Var);
            if (g() != kf0Var) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(kf0Var, kf0Var2, this)) {
                    if (j()) {
                        kf0Var.e();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(kf0Var) == kf0Var2);
        }
    }

    public final Object g() {
        while (true) {
            Object obj = b.get(this);
            if (!(obj instanceof p7)) {
                return obj;
            }
            ((p7) obj).a(this);
        }
    }

    public final kf0 h() {
        kf0 kf0Var;
        Object objG = g();
        yu0 yu0Var = objG instanceof yu0 ? (yu0) objG : null;
        return (yu0Var == null || (kf0Var = yu0Var.a) == null) ? (kf0) objG : kf0Var;
    }

    public boolean j() {
        return g() instanceof yu0;
    }

    public String toString() {
        return new b(1, e.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + e.D(this);
    }
}
