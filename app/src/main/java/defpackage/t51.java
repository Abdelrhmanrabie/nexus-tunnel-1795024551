package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class t51 {
    public static final String a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static final mj0 f;
    public static final p51 g;
    public static final p51 h;

    static {
        String property;
        int i = i51.a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        a = property;
        b = e.o0(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int i2 = i51.a;
        if (i2 < 2) {
            i2 = 2;
        }
        c = e.p0(i2, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        d = e.p0(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(e.o0(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f = mj0.a;
        g = new p51(0);
        h = new p51(1);
    }
}
