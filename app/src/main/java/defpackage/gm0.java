package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gm0 extends em0 {
    public final bg a;
    public final long b;
    public final long c;
    public final TimeUnit d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends AtomicReference implements wo, Runnable {
        public final pc0 b;
        public long c;

        public a(pc0 pc0Var) {
            this.b = pc0Var;
        }

        @Override // defpackage.wo
        public final void a() {
            zo.b(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (get() != zo.b) {
                long j = this.c;
                this.c = 1 + j;
                this.b.b(Long.valueOf(j));
            }
        }
    }

    public gm0(long j, long j2, TimeUnit timeUnit, bg bgVar) {
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.a = bgVar;
    }

    public final void b(pc0 pc0Var) {
        bg.c cVar;
        Future future;
        a aVar = new a(pc0Var);
        if (zo.c(pc0Var, aVar)) {
            try {
                pc0Var.d.getClass();
            } catch (Throwable th) {
                e.r(th);
                zo.b(aVar);
                pc0Var.c(th);
            }
        }
        bg bgVar = this.a;
        TimeUnit timeUnit = this.d;
        bg.b bVar = (bg.b) bgVar.c.get();
        int i = bVar.a;
        if (i == 0) {
            cVar = bg.g;
        } else {
            long j = bVar.c;
            bVar.c = 1 + j;
            cVar = bVar.b[(int) (j % ((long) i))];
        }
        cVar.getClass();
        long j2 = this.c;
        wo woVar = sq.b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = cVar.b;
        long j3 = this.b;
        boolean z = false;
        try {
            if (j2 <= 0) {
                u20 u20Var = new u20(aVar, scheduledThreadPoolExecutor);
                Future futureSubmit = j3 <= 0 ? scheduledThreadPoolExecutor.submit(u20Var) : scheduledThreadPoolExecutor.schedule(u20Var, j3, timeUnit);
                loop0: while (true) {
                    AtomicReference atomicReference = u20Var.d;
                    Future future2 = (Future) atomicReference.get();
                    if (future2 == u20.i) {
                        futureSubmit.cancel(u20Var.g != Thread.currentThread());
                        break;
                    } else {
                        do {
                            if (atomicReference.compareAndSet(future2, futureSubmit)) {
                                break loop0;
                            }
                        } while (atomicReference.get() == future2);
                    }
                }
                woVar = u20Var;
            } else {
                wx0 wx0Var = new wx0(aVar);
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = scheduledThreadPoolExecutor.scheduleAtFixedRate(wx0Var, j3, j2, timeUnit);
                do {
                    future = (Future) wx0Var.get();
                    if (future == wx0.f) {
                        break;
                    }
                    if (future == wx0.g) {
                        if (wx0Var.d != Thread.currentThread()) {
                            z = wx0Var.c;
                        }
                        scheduledFutureScheduleAtFixedRate.cancel(z);
                        break;
                    }
                } while (!wx0Var.compareAndSet(future, scheduledFutureScheduleAtFixedRate));
                woVar = wx0Var;
            }
        } catch (RejectedExecutionException e) {
            ui.a(e);
        }
        zo.c(aVar, woVar);
    }
}
