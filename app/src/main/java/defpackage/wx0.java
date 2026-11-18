package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wx0 extends AtomicReference implements Runnable, wo {
    public static final FutureTask f;
    public static final FutureTask g;
    public final gm0.a b;
    public final boolean c = true;
    public Thread d;

    static {
        wx$c wx_c = v3.f56a;
        f = new FutureTask(wx_c, null);
        g = new FutureTask(wx_c, null);
    }

    public wx0(gm0.a aVar) {
        this.b = aVar;
    }

    @Override // defpackage.wo
    public final void a() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == f || future == (futureTask = g) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.d == Thread.currentThread() ? false : this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d = Thread.currentThread();
        try {
            this.b.run();
            this.d = null;
        } catch (Throwable th) {
            a();
            this.d = null;
            ui.a(th);
            throw th;
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Future future = (Future) get();
        if (future == f) {
            str = "Finished";
        } else if (future == g) {
            str = "Disposed";
        } else if (this.d != null) {
            str = "Running on " + this.d;
        } else {
            str = "Waiting";
        }
        return ak.AnonymousClass0.m("wx0[", str, "]");
    }
}
