package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ur extends oi implements ol {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(ur.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(ur.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(ur.class, "_isCompleted$volatile");
    public volatile /* synthetic */ Object _delayed$volatile;
    public volatile /* synthetic */ int _isCompleted$volatile = 0;
    public volatile /* synthetic */ Object _queue$volatile;
    public long d;
    public boolean f;
    public z6 g;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class b extends q61 {
    }

    public final void B() {
        long j2 = this.d - 4294967296L;
        this.d = j2;
        if (j2 <= 0 && this.f) {
            shutdown();
        }
    }

    public final void C(boolean z) {
        this.d = (z ? 4294967296L : 1L) + this.d;
        if (z) {
            return;
        }
        this.f = true;
    }

    public final boolean D() {
        z6 z6Var = this.g;
        if (z6Var == null) {
            return false;
        }
        qo qoVar = (qo) (z6Var.isEmpty() ? null : z6Var.removeFirst());
        if (qoVar == null) {
            return false;
        }
        qoVar.run();
        return true;
    }

    public abstract Thread E();

    public void H(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (n.get(this) == 0) {
                if (obj == null) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == null);
                } else if (obj instanceof mf0) {
                    mf0 mf0Var = (mf0) obj;
                    int iA = mf0Var.a(runnable);
                    if (iA == 0) {
                        break;
                    }
                    if (iA == 1) {
                        mf0 mf0VarC = mf0Var.c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mf0VarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (iA != 2) {
                    }
                } else if (obj != e.f$1) {
                    mf0 mf0Var2 = new mf0(8, true);
                    mf0Var2.a((Runnable) obj);
                    mf0Var2.a(runnable);
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, mf0Var2)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            al.o.H(runnable);
            return;
        }
        Thread threadE = E();
        if (Thread.currentThread() != threadE) {
            LockSupport.unpark(threadE);
        }
    }

    public final boolean J() {
        z6 z6Var = this.g;
        if (!(z6Var != null ? z6Var.isEmpty() : true)) {
            return false;
        }
        Object obj = i.get(this);
        if (obj != null) {
            if (obj instanceof mf0) {
                long j2 = mf0.f.get((mf0) obj);
                if (((int) (1073741823 & j2)) != ((int) ((j2 & 1152921503533105152L) >> 30))) {
                    return false;
                }
            } else if (obj != e.f$1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0090, code lost:
    
        if (((int) (1073741823 & r5)) == ((int) ((r5 & 1152921503533105152L) >> 30))) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long K() {
        /*
            r9 = this;
            boolean r0 = r9.D()
            r1 = 0
            if (r0 == 0) goto La
            goto L98
        La:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.ur.j
            java.lang.Object r0 = r0.get(r9)
            ur$b r0 = (ur.b) r0
        L12:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.ur.i
            java.lang.Object r3 = r0.get(r9)
            r4 = 0
            if (r3 != 0) goto L1c
            goto L4f
        L1c:
            boolean r5 = r3 instanceof defpackage.mf0
            if (r5 == 0) goto L41
            r4 = r3
            mf0 r4 = (defpackage.mf0) r4
            java.lang.Object r5 = r4.d()
            ci0 r6 = defpackage.mf0.g
            if (r5 == r6) goto L2f
            r4 = r5
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            goto L4f
        L2f:
            mf0 r5 = r4.c()
        L33:
            boolean r4 = r0.compareAndSet(r9, r3, r5)
            if (r4 == 0) goto L3a
            goto L12
        L3a:
            java.lang.Object r4 = r0.get(r9)
            if (r4 == r3) goto L33
            goto L12
        L41:
            ci0 r5 = defpackage.e.f$1
            if (r3 != r5) goto L46
            goto L4f
        L46:
            boolean r5 = r0.compareAndSet(r9, r3, r4)
            if (r5 == 0) goto La2
            r4 = r3
            java.lang.Runnable r4 = (java.lang.Runnable) r4
        L4f:
            if (r4 == 0) goto L55
            r4.run()
            return r1
        L55:
            z6 r0 = r9.g
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L5f
            goto L65
        L5f:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L67
        L65:
            r5 = r3
            goto L68
        L67:
            r5 = r1
        L68:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 != 0) goto L6d
            goto L98
        L6d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.ur.i
            java.lang.Object r0 = r0.get(r9)
            if (r0 == 0) goto L99
            boolean r5 = r0 instanceof defpackage.mf0
            if (r5 == 0) goto L93
            mf0 r0 = (defpackage.mf0) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = defpackage.mf0.f
            long r5 = r5.get(r0)
            r7 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r7 = r7 & r5
            int r0 = (int) r7
            r7 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r7
            r7 = 30
            long r5 = r5 >> r7
            int r5 = (int) r5
            if (r0 != r5) goto L98
            goto L99
        L93:
            ci0 r5 = defpackage.e.f$1
            if (r0 != r5) goto L98
            return r3
        L98:
            return r1
        L99:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.ur.j
            java.lang.Object r0 = r0.get(r9)
            ur$b r0 = (ur.b) r0
            return r3
        La2:
            java.lang.Object r5 = r0.get(r9)
            if (r5 == r3) goto L46
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ur.K():long");
    }

    public void shutdown() {
        p61.a.set(null);
        n.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            ci0 ci0Var = e.f$1;
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, ci0Var)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof mf0) {
                ((mf0) obj).b();
                break;
            } else {
                if (obj == ci0Var) {
                    break;
                }
                mf0 mf0Var = new mf0(8, true);
                mf0Var.a((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, mf0Var)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (K() <= 0) {
        }
        System.nanoTime();
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        H(runnable);
    }
}
