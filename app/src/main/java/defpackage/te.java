package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class te {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(te.class, "_handled$volatile");
    public volatile /* synthetic */ int _handled$volatile = 0;
    public final Throwable a;

    public te(Throwable th) {
        this.a = th;
    }

    public final String toString() {
        return "te[" + this.a + ']';
    }
}
