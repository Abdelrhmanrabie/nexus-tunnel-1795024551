package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class le0 extends oi implements ol {
    public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(le0.class, "runningWorkers$volatile");
    public final int f;
    public final lf0 i;
    public final Object j;
    public volatile /* synthetic */ int runningWorkers$volatile;

    public le0(int i) {
        li.b bVar = ub1.d;
        this.f = i;
        if ((bVar instanceof ol ? (ol) bVar : null) == null) {
            int i2 = bl.$r8$clinit;
        }
        this.i = new lf0();
        this.j = new Object();
    }

    public final Runnable B() {
        while (true) {
            Runnable runnable = (Runnable) this.i.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.j) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.i.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        this.i.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n;
        if (atomicIntegerFieldUpdater.get(this) < this.f) {
            synchronized (this.j) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableB = B();
                if (runnableB == null) {
                    return;
                }
                ub1.d.x(this, new f2(6, this, runnableB));
            }
        }
    }
}
