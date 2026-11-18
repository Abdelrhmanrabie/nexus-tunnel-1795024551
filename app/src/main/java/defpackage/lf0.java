package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class lf0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(lf0.class, Object.class, "_cur$volatile");
    public volatile /* synthetic */ Object _cur$volatile = new mf0(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            mf0 mf0Var = (mf0) atomicReferenceFieldUpdater.get(this);
            int iA = mf0Var.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                mf0 mf0VarC = mf0Var.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mf0Var, mf0VarC) && atomicReferenceFieldUpdater.get(this) == mf0Var) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            mf0 mf0Var = (mf0) atomicReferenceFieldUpdater.get(this);
            if (mf0Var.b()) {
                return;
            }
            mf0 mf0VarC = mf0Var.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mf0Var, mf0VarC) && atomicReferenceFieldUpdater.get(this) == mf0Var) {
            }
        }
    }

    public final int c() {
        mf0 mf0Var = (mf0) a.get(this);
        mf0Var.getClass();
        long j = mf0.f.get(mf0Var);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            mf0 mf0Var = (mf0) atomicReferenceFieldUpdater.get(this);
            Object objD = mf0Var.d();
            if (objD != mf0.g) {
                return objD;
            }
            mf0 mf0VarC = mf0Var.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mf0Var, mf0VarC) && atomicReferenceFieldUpdater.get(this) == mf0Var) {
            }
        }
    }
}
