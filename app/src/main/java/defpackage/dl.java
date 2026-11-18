package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dl extends cs implements Executor {
    public static final dl d = new dl();
    public static final oi f;

    static {
        oi le0Var = ub1.d;
        int i = i51.a;
        if (64 >= i) {
            i = 64;
        }
        int iP0 = e.p0(i, 12, "kotlinx.coroutines.io.parallelism");
        if (iP0 >= 1) {
            if (iP0 < t51.d) {
                if (iP0 >= 1) {
                    le0Var = new le0(iP0);
                }
            }
            f = le0Var;
            return;
        }
        d.AnonymousClass0.m((Object) ak.h(iP0, "Expected positive parallelism level, but got "));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        x(rq.b, runnable);
    }

    @Override // defpackage.oi
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        f.x(liVar, runnable);
    }
}
