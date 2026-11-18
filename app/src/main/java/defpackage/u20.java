package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u20 implements Callable, wo {
    public static final FutureTask i = new FutureTask(v3.f56a, null);
    public final gm0.a b;
    public final ScheduledExecutorService f;
    public Thread g;
    public final AtomicReference d = new AtomicReference();
    public final AtomicReference c = new AtomicReference();

    public u20(gm0.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.b = aVar;
        this.f = scheduledExecutorService;
    }

    @Override // defpackage.wo
    public final void a() {
        AtomicReference atomicReference = this.d;
        FutureTask futureTask = i;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.g != Thread.currentThread());
        }
        Future future2 = (Future) this.c.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.g != Thread.currentThread());
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.g = Thread.currentThread();
        try {
            this.b.run();
            this.g = null;
            Future futureSubmit = this.f.submit(this);
            while (true) {
                AtomicReference atomicReference = this.c;
                Future future = (Future) atomicReference.get();
                if (future == i) {
                    futureSubmit.cancel(this.g != Thread.currentThread());
                    return null;
                }
                while (!atomicReference.compareAndSet(future, futureSubmit)) {
                    if (atomicReference.get() != future) {
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            this.g = null;
            ui.a(th);
            throw th;
        }
    }
}
