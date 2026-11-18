package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends cs implements ol {
    public final Executor d;

    public ds(ExecutorService executorService) {
        Method method;
        this.d = executorService;
        Method method2 = eg.a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executorService instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executorService : null;
            if (scheduledThreadPoolExecutor != null && (method = eg.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.d;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ds) && ((ds) obj).d == this.d;
    }

    public final int hashCode() {
        return System.identityHashCode(this.d);
    }

    @Override // defpackage.oi
    public final String toString() {
        return this.d.toString();
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        try {
            this.d.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            e.z0(liVar, cancellationException);
            uo.b.x(liVar, runnable);
        }
    }
}
