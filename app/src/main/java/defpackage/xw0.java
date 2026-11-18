package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xw0 extends AtomicLong implements ThreadFactory {
    public final String b;
    public final int c;
    public final boolean d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Thread {
    }

    public xw0(int i, String str, boolean z) {
        this.b = str;
        this.c = i;
        this.d = z;
    }

    public xw0(String str) {
        this(5, str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.b + '-' + incrementAndGet();
        Thread aVar = this.d ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.c);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return fb$1.m(new StringBuilder("RxThreadFactory["), this.b, "]");
    }
}
