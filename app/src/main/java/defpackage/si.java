package defpackage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class si implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(si.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater o = AtomicLongFieldUpdater.newUpdater(si.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater p = AtomicIntegerFieldUpdater.newUpdater(si.class, "_isTerminated$volatile");
    public static final ci0 q = new ci0("NOT_IN_STACK", 1);
    public volatile /* synthetic */ int _isTerminated$volatile;
    public final int b;
    public final int c;
    public volatile /* synthetic */ long controlState$volatile;
    public final long d;
    public final String f;
    public final ky g;
    public final ky i;
    public final kv0 j;
    public volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");
        public final ih1 b;
        public final vu0 c;
        public b d;
        public long f;
        public long g;
        public int i;
        public volatile int indexInArray;
        public boolean j;
        public volatile Object nextParkedWorker;
        public volatile /* synthetic */ int workerCtl$volatile;

        public a(int i) {
            setDaemon(true);
            setContextClassLoader(si.class.getClassLoader());
            this.b = new ih1();
            this.c = new vu0();
            this.d = b.f;
            this.nextParkedWorker = si.q;
            this.i = h0.c.b().nextInt();
            f(i);
        }

        public final n51 a(boolean z) {
            boolean z2;
            n51 n51VarE;
            n51 n51VarE2;
            b bVar = this.d;
            b bVar2 = b.b;
            si siVar = si.this;
            if (bVar == bVar2) {
                z2 = true;
                break;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = si.o;
            while (true) {
                long j = atomicLongFieldUpdater.get(siVar);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    z2 = false;
                    break;
                }
                if (si.o.compareAndSet(siVar, j, j - 4398046511104L)) {
                    this.d = b.b;
                    z2 = true;
                    break;
                }
            }
            ih1 ih1Var = this.b;
            n51 n51Var = null;
            if (z2) {
                if (z) {
                    boolean z3 = d(siVar.b * 2) == 0;
                    if (z3 && (n51VarE2 = e()) != null) {
                        return n51VarE2;
                    }
                    ih1Var.getClass();
                    n51 n51VarC = (n51) ih1.b.getAndSet(ih1Var, null);
                    if (n51VarC == null) {
                        n51VarC = ih1Var.c();
                    }
                    if (n51VarC != null) {
                        return n51VarC;
                    }
                    if (!z3 && (n51VarE = e()) != null) {
                        return n51VarE;
                    }
                } else {
                    n51 n51VarE3 = e();
                    if (n51VarE3 != null) {
                        return n51VarE3;
                    }
                }
                return i(3);
            }
            ih1Var.getClass();
            loop1: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ih1.b;
                n51 n51Var2 = (n51) atomicReferenceFieldUpdater.get(ih1Var);
                if (n51Var2 == null || n51Var2.c.a != 1) {
                    int i = ih1.d.get(ih1Var);
                    int i2 = ih1.c.get(ih1Var);
                    while (i != i2 && ih1.e.get(ih1Var) != 0) {
                        i2--;
                        n51 n51VarD = ih1Var.d(i2, true);
                        if (n51VarD != null) {
                            n51Var = n51VarD;
                            break;
                        }
                    }
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(ih1Var, n51Var2, null)) {
                        n51Var = n51Var2;
                        break loop1;
                    }
                } while (atomicReferenceFieldUpdater.get(ih1Var) == n51Var2);
            }
            if (n51Var != null) {
                return n51Var;
            }
            n51 n51Var3 = (n51) siVar.i.d();
            return n51Var3 == null ? i(1) : n51Var3;
        }

        public final int d(int i) {
            int i2 = this.i;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.i = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final n51 e() {
            int iD = d(2);
            si siVar = si.this;
            ky kyVar = siVar.i;
            ky kyVar2 = siVar.g;
            if (iD == 0) {
                n51 n51Var = (n51) kyVar2.d();
                if (n51Var != null) {
                    return n51Var;
                }
            } else {
                n51 n51Var2 = (n51) kyVar.d();
                if (n51Var2 != null) {
                    return n51Var2;
                }
                kyVar = kyVar2;
            }
            return (n51) kyVar.d();
        }

        public final void f(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(si.this.f);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final boolean h(b bVar) {
            b bVar2 = this.d;
            boolean z = bVar2 == b.b;
            if (z) {
                si.o.addAndGet(si.this, 4398046511104L);
            }
            if (bVar2 != bVar) {
                this.d = bVar;
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:56:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:58:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:71:0x00c1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x00df A[SYNTHETIC] */
        public final n51 i(int i) {
            long j;
            n51 n51VarD;
            long j2;
            long j3;
            n51 n51Var;
            AtomicLongFieldUpdater atomicLongFieldUpdater = si.o;
            si siVar = si.this;
            int i2 = (int) (atomicLongFieldUpdater.get(siVar) & 2097151);
            n51 n51Var2 = null;
            if (i2 < 2) {
                return null;
            }
            int iD = d(i2);
            int i3 = 0;
            long jMin = Long.MAX_VALUE;
            while (i3 < i2) {
                iD++;
                if (iD > i2) {
                    iD = 1;
                }
                a aVar = (a) siVar.j.b(iD);
                if (aVar != null && aVar != this) {
                    ih1 ih1Var = aVar.b;
                    if (i != 3) {
                        ih1Var.getClass();
                        int i4 = ih1.d.get(ih1Var);
                        int i5 = ih1.c.get(ih1Var);
                        boolean z = i == 1;
                        while (true) {
                            j = 0;
                            if (i4 != i5 && (!z || ih1.e.get(ih1Var) != 0)) {
                                int i6 = i4 + 1;
                                n51VarD = ih1Var.d(i4, z);
                                if (n51VarD != null) {
                                    break;
                                }
                                i4 = i6;
                            } else {
                                n51VarD = n51Var2;
                                break;
                            }
                        }
                    } else {
                        n51VarD = ih1Var.c();
                        j = 0;
                    }
                    vu0 vu0Var = this.c;
                    if (n51VarD != null) {
                        vu0Var.b = n51VarD;
                        n51Var = n51Var2;
                        j2 = -1;
                    } else {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ih1.b;
                            n51 n51Var3 = (n51) atomicReferenceFieldUpdater.get(ih1Var);
                            j2 = -1;
                            if (n51Var3 != null) {
                                if (((n51Var3.c.a == 1 ? 1 : 2) & i) != 0) {
                                    t51.f.getClass();
                                    ih1 ih1Var2 = ih1Var;
                                    long jNanoTime = System.nanoTime() - n51Var3.b;
                                    long j4 = t51.b;
                                    if (jNanoTime < j4) {
                                        j3 = j4 - jNanoTime;
                                    } else {
                                        while (true) {
                                            n51Var = null;
                                            if (atomicReferenceFieldUpdater.compareAndSet(ih1Var2, n51Var3, null)) {
                                                vu0Var.b = n51Var3;
                                            } else if (atomicReferenceFieldUpdater.get(ih1Var2) != n51Var3) {
                                                ih1Var = ih1Var2;
                                            }
                                        }
                                    }
                                }
                                n51Var = null;
                                if (j3 == j2) {
                                    n51 n51Var4 = (n51) vu0Var.b;
                                    vu0Var.b = n51Var;
                                    return n51Var4;
                                }
                                if (j3 > j) {
                                    jMin = Math.min(jMin, j3);
                                }
                            }
                            j3 = -2;
                            n51Var = null;
                            if (j3 == j2) {
                                n51 n51Var5 = (n51) vu0Var.b;
                                vu0Var.b = n51Var;
                                return n51Var5;
                            }
                            if (j3 > j) {
                                jMin = Math.min(jMin, j3);
                            }
                        }
                    }
                    j3 = j2;
                    if (j3 == j2) {
                        n51 n51Var6 = (n51) vu0Var.b;
                        vu0Var.b = n51Var;
                        return n51Var6;
                    }
                    if (j3 > j) {
                        jMin = Math.min(jMin, j3);
                    }
                }
                i3++;
                n51Var2 = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.g = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AtomicLongFieldUpdater atomicLongFieldUpdater;
            long j;
            int i;
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (si.p.get(si.this) == 0) {
                        b bVar = this.d;
                        b bVar2 = b.g;
                        if (bVar == bVar2) {
                            break loop0;
                        }
                        n51 n51VarA = a(this.j);
                        if (n51VarA == null) {
                            this.j = false;
                            if (this.g == 0) {
                                Object obj = this.nextParkedWorker;
                                ci0 ci0Var = si.q;
                                long j2 = 2097151;
                                if (obj != ci0Var) {
                                    o.set(this, -1);
                                    while (this.nextParkedWorker != si.q) {
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
                                        if (atomicIntegerFieldUpdater.get(this) != -1) {
                                            break;
                                        }
                                        si siVar = si.this;
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = si.p;
                                        if (atomicIntegerFieldUpdater2.get(siVar) != 0) {
                                            break;
                                        }
                                        b bVar3 = this.d;
                                        b bVar4 = b.g;
                                        if (bVar3 == bVar4) {
                                            break;
                                        }
                                        h(b.d);
                                        Thread.interrupted();
                                        if (this.f == 0) {
                                            this.f = System.nanoTime() + si.this.d;
                                        }
                                        LockSupport.parkNanos(si.this.d);
                                        if (System.nanoTime() - this.f >= 0) {
                                            this.f = 0L;
                                            si siVar2 = si.this;
                                            synchronized (siVar2.j) {
                                                try {
                                                    if (atomicIntegerFieldUpdater2.get(siVar2) == 0) {
                                                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = si.o;
                                                        if (((int) (atomicLongFieldUpdater2.get(siVar2) & j2)) > siVar2.b && atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                            int i2 = this.indexInArray;
                                                            f(0);
                                                            siVar2.d(this, i2, 0);
                                                            int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(siVar2) & j2);
                                                            if (andDecrement != i2) {
                                                                a aVar = (a) siVar2.j.b(andDecrement);
                                                                siVar2.j.c(i2, aVar);
                                                                aVar.f(i2);
                                                                siVar2.d(aVar, andDecrement, i2);
                                                            }
                                                            siVar2.j.c(andDecrement, null);
                                                            this.d = bVar4;
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    throw th;
                                                }
                                            }
                                        }
                                        j2 = j2;
                                    }
                                } else {
                                    si siVar3 = si.this;
                                    if (this.nextParkedWorker == ci0Var) {
                                        do {
                                            atomicLongFieldUpdater = si.n;
                                            j = atomicLongFieldUpdater.get(siVar3);
                                            i = this.indexInArray;
                                            this.nextParkedWorker = siVar3.j.b((int) (j & 2097151));
                                        } while (!atomicLongFieldUpdater.compareAndSet(siVar3, j, ((2097152 + j) & (-2097152)) | ((long) i)));
                                    }
                                }
                            } else {
                                if (z) {
                                    h(b.d);
                                    Thread.interrupted();
                                    LockSupport.parkNanos(this.g);
                                    this.g = 0L;
                                    break;
                                }
                                z = true;
                            }
                        } else {
                            this.g = 0L;
                            int i3 = n51VarA.c.a;
                            this.f = 0L;
                            if (this.d == b.d) {
                                this.d = b.c;
                            }
                            si siVar4 = si.this;
                            if (i3 != 0 && h(b.c) && !siVar4.f() && !siVar4.e(si.o.get(siVar4))) {
                                siVar4.f();
                            }
                            try {
                                n51VarA.run();
                            } catch (Throwable th2) {
                                Thread threadCurrentThread = Thread.currentThread();
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                            }
                            if (i3 != 0) {
                                si.o.addAndGet(siVar4, -2097152L);
                                if (this.d == bVar2) {
                                    break;
                                }
                                this.d = b.f;
                                break;
                            }
                            break;
                        }
                    } else {
                        break loop0;
                    }
                }
            }
            h(b.g);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b f;
        public static final b g;
        public static final /* synthetic */ b[] i;

        static {
            b bVar = new b("CPU_ACQUIRED", 0);
            b = bVar;
            b bVar2 = new b("BLOCKING", 1);
            c = bVar2;
            b bVar3 = new b("PARKING", 2);
            d = bVar3;
            b bVar4 = new b("DORMANT", 3);
            f = bVar4;
            b bVar5 = new b("TERMINATED", 4);
            g = bVar5;
            i = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) i.clone();
        }
    }

    public si(long j, String str, int i, int i2) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.f = str;
        if (i < 1) {
            d.AnonymousClass0.m((Object) e.i(i, "Core pool size ", " should be at least 1"));
            throw null;
        }
        if (!(i2 >= i)) {
            d.AnonymousClass0.m((Object) ak.i(i2, i, "Max pool size ", " should be greater than or equals to core pool size "));
            throw null;
        }
        if (i2 > 2097150) {
            d.AnonymousClass0.m((Object) e.i(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.g = new ky();
        this.i = new ky();
        kv0 kv0Var = new kv0();
        kv0Var.array = new AtomicReferenceArray((i + 1) * 2);
        this.j = kv0Var;
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    public final int a() {
        synchronized (this.j) {
            try {
                if (p.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = o;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.b) {
                    return 0;
                }
                if (i >= this.c) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.j.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(i3);
                this.j.c(i3, aVar);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                aVar.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Runnable runnable, p51 p51Var) {
        n51 r51Var;
        b bVar;
        AtomicReferenceArray atomicReferenceArray;
        t51.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof n51) {
            r51Var = (n51) runnable;
            r51Var.b = jNanoTime;
            r51Var.c = p51Var;
        } else {
            r51Var = new r51(runnable, jNanoTime, p51Var);
        }
        boolean z = r51Var.c.a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = o;
        long jAddAndGet = z ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !si.this.equals(this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.d) != b.g && (r51Var.c.a != 0 || bVar != b.c)) {
            aVar.j = true;
            ih1 ih1Var = aVar.b;
            ih1Var.getClass();
            r51Var = (n51) ih1.b.getAndSet(ih1Var, r51Var);
            if (r51Var == null) {
                r51Var = null;
            } else {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ih1.c;
                if (atomicIntegerFieldUpdater.get(ih1Var) - ih1.d.get(ih1Var) != 127) {
                    if (r51Var.c.a == 1) {
                        ih1.e.incrementAndGet(ih1Var);
                    }
                    int i = atomicIntegerFieldUpdater.get(ih1Var) & 127;
                    while (true) {
                        atomicReferenceArray = ih1Var.a;
                        if (atomicReferenceArray.get(i) == null) {
                            break;
                        } else {
                            Thread.yield();
                        }
                    }
                    atomicReferenceArray.lazySet(i, r51Var);
                    atomicIntegerFieldUpdater.incrementAndGet(ih1Var);
                    r51Var = null;
                }
            }
        }
        if (r51Var != null) {
            if (!(r51Var.c.a == 1 ? this.i : this.g).a(r51Var)) {
                throw new RejectedExecutionException(fb$1.m(new StringBuilder(), this.f, " was terminated"));
            }
        }
        boolean zF = f();
        if (z) {
            if (zF || e(jAddAndGet)) {
                return;
            }
            f();
            return;
        }
        if (zF || e(atomicLongFieldUpdater.get(this))) {
            return;
        }
        f();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006a A[LOOP:2: B:29:0x0063->B:32:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        n51 n51VarA;
        n51 n51VarC;
        if (p.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
            if (aVar == null || !si.this.equals(this)) {
                aVar = null;
            }
            synchronized (this.j) {
                i = (int) (o.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    a aVar2 = (a) this.j.b(i2);
                    if (aVar2 != aVar) {
                        while (aVar2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        ih1 ih1Var = aVar2.b;
                        ky kyVar = this.i;
                        ih1Var.getClass();
                        n51 n51Var = (n51) ih1.b.getAndSet(ih1Var, null);
                        if (n51Var != null) {
                            kyVar.a(n51VarC);
                        } else {
                            kyVar.a(n51Var);
                        }
                        while (true) {
                            n51VarC = ih1Var.c();
                            if (n51VarC == null) {
                                break;
                            } else {
                                kyVar.a(n51VarC);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.i.b();
            this.g.b();
            while (true) {
                if (aVar != null) {
                    n51VarA = aVar.a(true);
                    if (n51VarA == null) {
                        n51VarA = (n51) this.g.d();
                        if (n51VarA == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    n51VarA = (n51) this.g.d();
                    if (n51VarA == null && (n51VarA = (n51) this.i.d()) == null) {
                        break;
                    }
                }
                try {
                    n51VarA.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (aVar != null) {
                aVar.h(b.g);
            }
            n.set(this, 0L);
            o.set(this, 0L);
        }
    }

    public final void d(a aVar, int i, int i2) {
        while (true) {
            long j = n.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    a aVar2 = aVar;
                    while (true) {
                        Object obj = aVar2.nextParkedWorker;
                        if (obj == q) {
                            i3 = -1;
                            break;
                        }
                        if (obj == null) {
                            i3 = 0;
                            break;
                        }
                        aVar2 = (a) obj;
                        int i4 = aVar2.indexInArray;
                        if (i4 != 0) {
                            i3 = i4;
                            break;
                        }
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0 && n.compareAndSet(this, j, j2 | ((long) i3))) {
                return;
            }
        }
    }

    public final boolean e(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.b;
        if (i < i2) {
            int iA = a();
            if (iA == 1 && i2 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(runnable, t51.g);
    }

    public final boolean f() {
        ci0 ci0Var;
        int i;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = n;
            long j = atomicLongFieldUpdater.get(this);
            a aVar = (a) this.j.b((int) (2097151 & j));
            if (aVar == null) {
                aVar = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                a aVar2 = aVar;
                do {
                    Object obj = aVar2.nextParkedWorker;
                    ci0Var = q;
                    if (obj == ci0Var) {
                        i = -1;
                        break;
                    }
                    if (obj == null) {
                        i = 0;
                        break;
                    }
                    aVar2 = (a) obj;
                    i = aVar2.indexInArray;
                } while (i == 0);
                if (i >= 0 && atomicLongFieldUpdater.compareAndSet(this, j, j2 | ((long) i))) {
                    aVar.nextParkedWorker = ci0Var;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.o.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        StringBuilder sb;
        char c;
        ArrayList arrayList = new ArrayList();
        kv0 kv0Var = this.j;
        int length = kv0Var.array.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            a aVar = (a) kv0Var.b(i6);
            if (aVar != null) {
                ih1 ih1Var = aVar.b;
                ih1Var.getClass();
                Object obj = ih1.b.get(ih1Var);
                int i7 = ih1.c.get(ih1Var) - ih1.d.get(ih1Var);
                if (obj != null) {
                    i7++;
                }
                int iOrdinal = aVar.d.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    sb = new StringBuilder();
                    sb.append(i7);
                    c = 'c';
                } else if (iOrdinal == 1) {
                    i2++;
                    sb = new StringBuilder();
                    sb.append(i7);
                    c = 'b';
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        sb = new StringBuilder();
                        sb.append(i7);
                        c = 'd';
                    }
                } else if (iOrdinal == 4) {
                    i5++;
                }
                sb.append(c);
                arrayList.add(sb.toString());
            }
        }
        long j = o.get(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f);
        sb2.append('@');
        sb2.append(e.D(this));
        sb2.append("[Pool Size {core = ");
        int i8 = this.b;
        sb2.append(i8);
        sb2.append(", max = ");
        sb2.append(this.c);
        sb2.append("}, Worker States {CPU = ");
        sb2.append(i);
        sb2.append(", blocking = ");
        sb2.append(i2);
        sb2.append(", parked = ");
        sb2.append(i3);
        sb2.append(", dormant = ");
        sb2.append(i4);
        sb2.append(", terminated = ");
        sb2.append(i5);
        sb2.append("}, running workers queues = ");
        sb2.append(arrayList);
        sb2.append(", global CPU queue size = ");
        sb2.append(this.g.c());
        sb2.append(", global blocking queue size = ");
        sb2.append(this.i.c());
        sb2.append(", Control State {created workers= ");
        sb2.append((int) (2097151 & j));
        sb2.append(", blocking tasks = ");
        sb2.append((int) ((4398044413952L & j) >> 21));
        sb2.append(", CPUs acquired = ");
        sb2.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb2.append("}]");
        return sb2.toString();
    }
}
