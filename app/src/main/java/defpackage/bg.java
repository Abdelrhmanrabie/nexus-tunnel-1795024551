package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bg extends yx0 {
    public static final b d;
    public static final xw0 e;
    public static final int f;
    public static final c g;
    public final AtomicReference c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public final int a;
        public final c[] b;
        public long c;

        public b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends al0 {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx3.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        f = iAvailableProcessors;
        c cVar = new c(new xw0("RxComputationShutdown"));
        g = cVar;
        cVar.a();
        xw0 xw0Var = new xw0(Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), "RxComputationThreadPool", true);
        e = xw0Var;
        b bVar = new b(0, xw0Var);
        d = bVar;
        for (c cVar2 : bVar.b) {
            cVar2.a();
        }
    }

    public bg() {
        AtomicReference atomicReference;
        b bVar = d;
        this.c = new AtomicReference(bVar);
        b bVar2 = new b(f, e);
        do {
            atomicReference = this.c;
            if (atomicReference.compareAndSet(bVar, bVar2)) {
                return;
            }
        } while (atomicReference.get() == bVar);
        for (c cVar : bVar2.b) {
            cVar.a();
        }
    }
}
