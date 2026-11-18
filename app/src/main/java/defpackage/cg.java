package defpackage;

import java.io.Serializable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cg implements ThreadFactory {
    public final /* synthetic */ int G0;
    public final Serializable b;

    public cg() {
        this.G0 = 1;
        this.b = new AtomicInteger(0);
    }

    public /* synthetic */ cg(String str) {
        this.G0 = 0;
        this.b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        if (this.G0 == 0) {
            Thread thread = new Thread(runnable, (String) this.b);
            thread.setPriority(10);
            return thread;
        }
        Thread thread2 = new Thread(runnable);
        thread2.setName("arch_disk_io_" + ((AtomicInteger) this.b).getAndIncrement());
        return thread2;
    }
}
