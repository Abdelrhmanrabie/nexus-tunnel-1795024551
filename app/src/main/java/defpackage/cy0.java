package defpackage;

import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class cy0 {
    public static final bg a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {
        public static final bg a = new bg();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class b {
        public static final y30 a = new y30();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c {
        public static final zk0 a = new zk0();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class d {
        public static final k11 a;

        static {
            k11 k11Var = new k11();
            AtomicReference atomicReference = new AtomicReference();
            boolean z = by0.a;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, k11.d);
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(by0.a);
            atomicReference.lazySet(scheduledThreadPoolExecutor);
            a = k11Var;
        }
    }

    static {
        try {
            Objects.requireNonNull(d.a, "Scheduler Supplier result can't be null");
            try {
                bg bgVar = a.a;
                Objects.requireNonNull(bgVar, "Scheduler Supplier result can't be null");
                a = bgVar;
                try {
                    Objects.requireNonNull(b.a, "Scheduler Supplier result can't be null");
                    int i = b81.$r8$clinit;
                    try {
                        Objects.requireNonNull(c.a, "Scheduler Supplier result can't be null");
                    } catch (Throwable th) {
                        throw xr.a(th);
                    }
                } catch (Throwable th2) {
                    throw xr.a(th2);
                }
            } catch (Throwable th3) {
                throw xr.a(th3);
            }
        } catch (Throwable th4) {
            throw xr.a(th4);
        }
    }
}
