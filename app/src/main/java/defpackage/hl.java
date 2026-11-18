package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hl extends cs {
    public static final hl f = new hl();
    public final si d = new si(t51.e, t51.a, t51.c, t51.d);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.oi
    public final String toString() {
        return "Dispatchers.Default";
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = si.n;
        this.d.c(runnable, t51.g);
    }
}
