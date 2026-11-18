package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ih1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ih1.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(ih1.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(ih1.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(ih1.class, "blockingTasksInBuffer$volatile");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    public volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    public volatile /* synthetic */ int consumerIndex$volatile;
    public volatile /* synthetic */ Object lastScheduledTask$volatile;
    public volatile /* synthetic */ int producerIndex$volatile;

    public final n51 c() {
        n51 n51Var;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (n51Var = (n51) this.a.getAndSet(i2, null)) != null) {
                if (n51Var.c.a == 1) {
                    e.decrementAndGet(this);
                }
                return n51Var;
            }
        }
    }

    public final n51 d(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.a;
        n51 n51Var = (n51) atomicReferenceArray.get(i2);
        if (n51Var != null) {
            if ((n51Var.c.a == 1) == z) {
                while (!atomicReferenceArray.compareAndSet(i2, n51Var, null)) {
                    if (atomicReferenceArray.get(i2) != n51Var) {
                    }
                }
                if (z) {
                    e.decrementAndGet(this);
                }
                return n51Var;
            }
        }
        return null;
    }
}
