package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y30 extends yx0 {
    public static final xw0 d;
    public static final xw0 e;
    public static final a j;
    public final AtomicReference c;
    public static final TimeUnit g = TimeUnit.SECONDS;
    public static final long f = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final ConcurrentLinkedQueue c;
        public final vf d;
        public final ScheduledExecutorService f;
        public final ScheduledFuture g;

        public a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.c = new ConcurrentLinkedQueue();
            this.d = new vf(0);
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, y30.e);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.g = scheduledFutureScheduleWithFixedDelay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedQueue<c> concurrentLinkedQueue = this.c;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jNanoTime = System.nanoTime();
            for (c cVar : concurrentLinkedQueue) {
                if (cVar.d > jNanoTime) {
                    return;
                }
                if (concurrentLinkedQueue.remove(cVar)) {
                    vf vfVar = this.d;
                    int i = vfVar.b;
                    boolean zB = vfVar.b(cVar);
                    if (i != 0) {
                        if (zB) {
                            cVar.a();
                        }
                    } else if (zB) {
                        cVar.a();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends al0 {
        public final long d;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.d = 0L;
        }
    }

    static {
        new c(new xw0("RxCachedThreadSchedulerShutdown")).a();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        xw0 xw0Var = new xw0(iMax, "RxCachedThreadScheduler", false);
        d = xw0Var;
        e = new xw0(iMax, "RxCachedWorkerPoolEvictor", false);
        Boolean.getBoolean("rx3.io-scheduled-release");
        a aVar = new a(0L, null, xw0Var);
        j = aVar;
        aVar.d.a();
        ScheduledFuture scheduledFuture = aVar.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = aVar.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public y30() {
        AtomicReference atomicReference;
        a aVar = j;
        this.c = new AtomicReference(aVar);
        a aVar2 = new a(f, g, d);
        do {
            atomicReference = this.c;
            if (atomicReference.compareAndSet(aVar, aVar2)) {
                return;
            }
        } while (atomicReference.get() == aVar);
        aVar2.d.a();
        ScheduledFuture scheduledFuture = aVar2.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = aVar2.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
