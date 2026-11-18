package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class g70 extends kf0 implements yo, x10, nw {
    public h70 f;

    @Override // defpackage.yo
    public final void a() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        h70 h70Var = this.f;
        h70Var.getClass();
        while (true) {
            Object objN = h70Var.N();
            if (objN instanceof g70) {
                if (objN != this) {
                    return;
                }
                oq oqVar = e.i;
                do {
                    atomicReferenceFieldUpdater2 = h70.b;
                    if (atomicReferenceFieldUpdater2.compareAndSet(h70Var, objN, oqVar)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(h70Var) == objN);
            } else {
                if (!(objN instanceof x10) || ((x10) objN).c() == null) {
                    return;
                }
                while (true) {
                    Object objG = g();
                    if (objG instanceof yu0) {
                        return;
                    }
                    if (objG == this) {
                        return;
                    }
                    kf0 kf0Var = (kf0) objG;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = kf0.d;
                    yu0 yu0Var = (yu0) atomicReferenceFieldUpdater3.get(kf0Var);
                    if (yu0Var == null) {
                        yu0Var = new yu0(kf0Var);
                        atomicReferenceFieldUpdater3.set(kf0Var, yu0Var);
                    }
                    do {
                        atomicReferenceFieldUpdater = kf0.b;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objG, yu0Var)) {
                            kf0Var.e();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objG);
                }
            }
        }
    }

    @Override // defpackage.x10
    public final fl0 c() {
        return null;
    }

    @Override // defpackage.x10
    public final boolean isActive() {
        return true;
    }

    public abstract void k(Throwable th);

    @Override // defpackage.kf0
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(e.D(this));
        sb.append("[job@");
        h70 h70Var = this.f;
        h70Var.getClass();
        sb.append(e.D(h70Var));
        sb.append(']');
        return sb.toString();
    }
}
