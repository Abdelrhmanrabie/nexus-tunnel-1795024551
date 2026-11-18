package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class al0 extends yx0.b {
    public final ScheduledThreadPoolExecutor b;
    public volatile boolean c;

    public al0(ThreadFactory threadFactory) {
        boolean z = by0.a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(by0.a);
        this.b = scheduledThreadPoolExecutor;
    }

    @Override // defpackage.wo
    public final void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.shutdownNow();
    }

    @Override // yx0.b
    public final wo c(yx0.b.a aVar, long j, TimeUnit timeUnit) {
        Object obj;
        boolean z;
        if (this.c) {
            return sq.b;
        }
        xx0 xx0Var = new xx0(aVar, null);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.b;
        try {
            Future futureSubmit = j <= 0 ? scheduledThreadPoolExecutor.submit((Callable) xx0Var) : scheduledThreadPoolExecutor.schedule((Callable) xx0Var, j, timeUnit);
            do {
                obj = xx0Var.get(1);
                if (obj == xx0.i) {
                    break;
                }
                if (obj == xx0.f) {
                    z = false;
                } else if (obj == xx0.g) {
                    z = xx0Var.c;
                }
                futureSubmit.cancel(z);
                return xx0Var;
            } while (!xx0Var.compareAndSet(1, obj, futureSubmit));
            return xx0Var;
        } catch (RejectedExecutionException e) {
            ui.a(e);
            return xx0Var;
        }
    }
}
