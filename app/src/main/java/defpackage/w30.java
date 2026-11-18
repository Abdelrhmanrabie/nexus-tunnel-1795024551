package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class w30 extends e70 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(w30.class, "_invoked$volatile");
    public volatile /* synthetic */ int _invoked$volatile;
    public final g70 g;

    public w30(g70 g70Var) {
        this.g = g70Var;
    }

    @Override // defpackage.nw
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        k((Throwable) obj);
        return tb1.a;
    }

    @Override // defpackage.g70
    public final void k(Throwable th) {
        if (i.compareAndSet(this, 0, 1)) {
            this.g.invoke(th);
        }
    }
}
