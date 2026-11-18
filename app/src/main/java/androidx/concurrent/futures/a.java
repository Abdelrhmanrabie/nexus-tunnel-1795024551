package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import defpackage.ak;
import defpackage.fb$1;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements ListenableFuture {
    public static final AbstractC0004a ATOMIC_HELPER;
    public static final Object NULL;
    public volatile d listeners;
    public volatile Object value;
    public volatile h waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger log = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: androidx.concurrent.futures.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class AbstractC0004a {
        public abstract boolean a(a aVar, d dVar, d dVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
        public static final b c;
        public static final b d;
        public final boolean a;
        public final Throwable b;

        static {
            if (a.GENERATE_CANCELLATION_CAUSES) {
                d = null;
                c = null;
            } else {
                d = new b(false, null);
                c = new b(true, null);
            }
        }

        public b(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c {
        public final Throwable a;

        /* JADX INFO: renamed from: androidx.concurrent.futures.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class C0005a extends Throwable {
            public C0005a() {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new c(new C0005a());
        }

        public c(Throwable th) {
            AbstractC0004a abstractC0004a = a.ATOMIC_HELPER;
            th.getClass();
            this.a = th;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class d {
        public static final d d = new d(null, null);
        public final Runnable a;
        public final Executor b;
        public d c;

        public d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class e extends AbstractC0004a {
        public final AtomicReferenceFieldUpdater a;
        public final AtomicReferenceFieldUpdater b;
        public final AtomicReferenceFieldUpdater c;
        public final AtomicReferenceFieldUpdater d;
        public final AtomicReferenceFieldUpdater e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean a(a aVar, d dVar, d dVar2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.d;
                if (atomicReferenceFieldUpdater.compareAndSet(aVar, dVar, dVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(aVar) == dVar);
            return false;
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean b(a aVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.e;
                if (atomicReferenceFieldUpdater.compareAndSet(aVar, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(aVar) == obj);
            return false;
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean c(a aVar, h hVar, h hVar2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.c;
                if (atomicReferenceFieldUpdater.compareAndSet(aVar, hVar, hVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(aVar) == hVar);
            return false;
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final void d(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final void e(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class f<V> implements Runnable {
        public final a b;
        public final ListenableFuture c;

        public f(a<V> aVar, ListenableFuture listenableFuture) {
            this.b = aVar;
            this.c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.value != this) {
                return;
            }
            if (a.ATOMIC_HELPER.b(this.b, this, a.getFutureValue(this.c))) {
                a.complete(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class g extends AbstractC0004a {
        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean a(a aVar, d dVar, d dVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.listeners != dVar) {
                        return false;
                    }
                    aVar.listeners = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.value != obj) {
                        return false;
                    }
                    aVar.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.waiters != hVar) {
                        return false;
                    }
                    aVar.waiters = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final void d(h hVar, h hVar2) {
            hVar.b = hVar2;
        }

        @Override // androidx.concurrent.futures.a.AbstractC0004a
        public final void e(h hVar, Thread thread) {
            hVar.a = thread;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class h {
        public static final h c = new h(0);
        public volatile Thread a;
        public volatile h b;

        public h() {
            a.ATOMIC_HELPER.e(this, Thread.currentThread());
        }

        public h(int i) {
        }
    }

    static {
        AbstractC0004a gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, XMLRPC.TAG_VALUE));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        ATOMIC_HELPER = gVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static void complete(a aVar) {
        d dVar;
        d dVar2 = null;
        while (true) {
            h hVar = aVar.waiters;
            if (ATOMIC_HELPER.c(aVar, hVar, h.c)) {
                while (hVar != null) {
                    Thread thread = hVar.a;
                    if (thread != null) {
                        hVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    hVar = hVar.b;
                }
                do {
                    dVar = aVar.listeners;
                } while (!ATOMIC_HELPER.a(aVar, dVar, d.d));
                while (dVar != null) {
                    d dVar3 = dVar.c;
                    dVar.c = dVar2;
                    dVar2 = dVar;
                    dVar = dVar3;
                }
                while (dVar2 != null) {
                    d dVar4 = dVar2.c;
                    Runnable runnable = dVar2.a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        a aVar2 = fVar.b;
                        if (aVar2.value == fVar) {
                            if (ATOMIC_HELPER.b(aVar2, fVar, getFutureValue(fVar.c))) {
                                dVar2 = dVar4;
                                aVar = aVar2;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = dVar2.b;
                        try {
                            executor.execute(runnable);
                        } catch (RuntimeException e2) {
                            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
                        }
                    }
                    dVar2 = dVar4;
                }
                return;
            }
        }
    }

    public static Object getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).a);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public static Object getFutureValue(ListenableFuture listenableFuture) {
        Object obj;
        if (listenableFuture instanceof a) {
            Object obj2 = ((a) listenableFuture).value;
            if (!(obj2 instanceof b)) {
                return obj2;
            }
            b bVar = (b) obj2;
            if (bVar.a) {
                return bVar.b != null ? new b(false, bVar.b) : b.d;
            }
            return obj2;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        boolean z = true;
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return b.d;
        }
        boolean z2 = false;
        while (true) {
            try {
                try {
                    obj = listenableFuture.get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = z;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException e2) {
                if (zIsCancelled) {
                    return new b(false, e2);
                }
                return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
            } catch (ExecutionException e3) {
                return new c(e3.getCause());
            } catch (Throwable th2) {
                return new c(th2);
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj == null ? NULL : obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        b bVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            bVar = new b(z, new CancellationException("Future.cancel() was called."));
        } else {
            bVar = z ? b.c : b.d;
        }
        a<V> aVar = this;
        boolean z2 = false;
        while (true) {
            if (ATOMIC_HELPER.b(aVar, obj, bVar)) {
                complete(aVar);
                if (!(obj instanceof f)) {
                    break;
                }
                ListenableFuture listenableFuture = ((f) obj).c;
                if (!(listenableFuture instanceof a)) {
                    listenableFuture.cancel(z);
                    break;
                }
                aVar = (a) listenableFuture;
                obj = aVar.value;
                if (!(obj == null) && !(obj instanceof f)) {
                    break;
                }
                z2 = true;
            } else {
                obj = aVar.value;
                if (!(obj instanceof f)) {
                    return z2;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof f))) {
            return getDoneValue(obj2);
        }
        h hVar = this.waiters;
        h hVar2 = h.c;
        if (hVar != hVar2) {
            h hVar3 = new h();
            do {
                AbstractC0004a abstractC0004a = ATOMIC_HELPER;
                abstractC0004a.d(hVar3, hVar);
                if (abstractC0004a.c(this, hVar, hVar3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            removeWaiter(hVar3);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return getDoneValue(obj);
                }
                hVar = this.waiters;
            } while (hVar != hVar2);
        }
        return getDoneValue(this.value);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof f))) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.waiters;
            h hVar2 = h.c;
            if (hVar != hVar2) {
                z = true;
                h hVar3 = new h();
                while (true) {
                    AbstractC0004a abstractC0004a = ATOMIC_HELPER;
                    abstractC0004a.d(hVar3, hVar);
                    if (abstractC0004a.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(hVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(hVar3);
                        break;
                    }
                    hVar = this.waiters;
                    if (hVar == hVar2) {
                    }
                }
            }
            return getDoneValue(this.value);
        }
        z = true;
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null ? z : false) && (!(obj3 instanceof f))) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strJ = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strJ2 = ak.j(strJ, " (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            if (jConvert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (jConvert > 0) {
                String strJ3 = strJ2 + jConvert + " " + lowerCase;
                if (z) {
                    strJ3 = ak.j(strJ3, ",");
                }
                strJ2 = ak.j(strJ3, " ");
            }
            if (z) {
                strJ2 = strJ2 + nanos2 + " nanoseconds ";
            }
            strJ = ak.j(strJ2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(ak.j(strJ, " but future completed as timeout expired"));
        }
        throw new TimeoutException(defpackage.e.j(strJ, " for ", string));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof f)) & (obj != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String pendingToString() {
        Object obj = this.value;
        if (obj instanceof f) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture listenableFuture = ((f) obj).c;
            return fb$1.m(sb, listenableFuture == this ? "this future" : String.valueOf(listenableFuture), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void removeWaiter(h hVar) {
        hVar.a = null;
        while (true) {
            h hVar2 = this.waiters;
            if (hVar2 == h.c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.b;
                if (hVar2.a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.b = hVar4;
                    if (hVar3.a == null) {
                    }
                } else if (!ATOMIC_HELPER.c(this, hVar2, hVar4)) {
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[Catch: RuntimeException -> 0x0063, ExecutionException -> 0x0065, CancellationException -> 0x0096, TRY_ENTER, TryCatch #4 {CancellationException -> 0x0096, RuntimeException -> 0x0063, ExecutionException -> 0x0065, blocks: (B:21:0x005b, B:26:0x0067, B:30:0x0075, B:29:0x0071, B:33:0x007f, B:34:0x0086), top: B:46:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071 A[Catch: RuntimeException -> 0x0063, ExecutionException -> 0x0065, CancellationException -> 0x0096, TryCatch #4 {CancellationException -> 0x0096, RuntimeException -> 0x0063, ExecutionException -> 0x0065, blocks: (B:21:0x005b, B:26:0x0067, B:30:0x0075, B:29:0x0071, B:33:0x007f, B:34:0x0086), top: B:46:0x0055 }] */
    public final String toString() {
        String str;
        String strPendingToString;
        boolean z;
        V v;
        String strValueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.value instanceof b) {
            str = "CANCELLED";
            sb.append(str);
        } else if (isDone()) {
            z = false;
            while (true) {
                try {
                    try {
                        v = get();
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                    } catch (Throwable th) {
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (CancellationException unused2) {
                    str = "CANCELLED";
                    sb.append(str);
                } catch (RuntimeException e2) {
                    sb.append("UNKNOWN, cause=[");
                    sb.append(e2.getClass());
                    str = " thrown from get()]";
                    sb.append(str);
                } catch (ExecutionException e3) {
                    sb.append("FAILURE, cause=[");
                    sb.append(e3.getCause());
                    str = "]";
                    sb.append(str);
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            sb.append("SUCCESS, result=[");
            if (v == this) {
                strValueOf = "this future";
            } else {
                strValueOf = String.valueOf(v);
            }
            sb.append(strValueOf);
            sb.append("]");
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e4) {
                strPendingToString = "Exception thrown from implementation: " + e4.getClass();
            }
            if (strPendingToString == null || strPendingToString.isEmpty()) {
                if (isDone()) {
                    z = false;
                    while (true) {
                        v = get();
                        break;
                        break;
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    sb.append("SUCCESS, result=[");
                    if (v == this) {
                        strValueOf = "this future";
                    } else {
                        strValueOf = String.valueOf(v);
                    }
                    sb.append(strValueOf);
                    sb.append("]");
                } else {
                    str = "PENDING";
                }
                sb.append(str);
            } else {
                sb.append("PENDING, info=[");
                sb.append(strPendingToString);
                sb.append("]");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
