package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class yx0 {
    public static final boolean a = Boolean.getBoolean("rx3.scheduler.use-nanotime");
    public static final long b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class b implements wo {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a implements Runnable {
            public final Object b;
            public final gz0 c;
            public final long d;
            public long f;
            public long g;
            public long i;

            public a(long j, Runnable runnable, long j2, gz0 gz0Var, long j3) {
                this.b = runnable;
                this.c = gz0Var;
                this.d = j3;
                this.g = j2;
                this.i = j;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.lang.Runnable] */
            @Override // java.lang.Runnable
            public final void run() {
                long j;
                this.b.run();
                gz0 gz0Var = this.c;
                if (((wo) gz0Var.get()) == zo.b) {
                    return;
                }
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                b bVar = b.this;
                bVar.getClass();
                long jB = b.b(timeUnit);
                long j2 = yx0.b;
                long j3 = jB + j2;
                long j4 = this.g;
                long j5 = this.d;
                if (j3 < j4 || jB >= j4 + j5 + j2) {
                    j = jB + j5;
                    long j6 = this.f + 1;
                    this.f = j6;
                    this.i = j - (j5 * j6);
                } else {
                    long j7 = this.i;
                    long j8 = this.f + 1;
                    this.f = j8;
                    j = (j8 * j5) + j7;
                }
                this.g = jB;
                wo woVarC = bVar.c(this, j - jB, timeUnit);
                while (true) {
                    wo woVar = (wo) gz0Var.get();
                    if (woVar == zo.b) {
                        woVarC.a();
                        return;
                    } else {
                        while (!gz0Var.compareAndSet(woVar, woVarC)) {
                            if (gz0Var.get() != woVar) {
                            }
                        }
                        return;
                    }
                }
            }
        }

        public static long b(TimeUnit timeUnit) {
            long jNanoTime;
            TimeUnit timeUnit2;
            if (yx0.a) {
                jNanoTime = System.nanoTime();
                timeUnit2 = TimeUnit.NANOSECONDS;
            } else {
                jNanoTime = System.currentTimeMillis();
                timeUnit2 = TimeUnit.MILLISECONDS;
            }
            return timeUnit.convert(jNanoTime, timeUnit2);
        }

        public abstract wo c(a aVar, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit timeUnit;
        long jLongValue = Long.getLong("rx3.scheduler.drift-tolerance", 15L).longValue();
        String property = System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes");
        if ("seconds".equalsIgnoreCase(property)) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            timeUnit = "milliseconds".equalsIgnoreCase(property) ? TimeUnit.MILLISECONDS : TimeUnit.MINUTES;
        }
        b = timeUnit.toNanos(jLongValue);
    }
}
