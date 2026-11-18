package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xx0 extends AtomicReferenceArray implements Runnable, Callable, wo {
    public static final Object d = new Object();
    public static final Object f = new Object();
    public static final Object g = new Object();
    public static final Object i = new Object();
    public final Runnable b;
    public final boolean c;

    public xx0(Runnable runnable, vf vfVar) {
        super(3);
        this.b = runnable;
        this.c = true;
        lazySet(0, vfVar);
    }

    @Override // defpackage.wo
    public final void a() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        while (true) {
            Object obj6 = get(1);
            obj = i;
            if (obj6 == obj || obj6 == (obj4 = f) || obj6 == (obj5 = g)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 == null) {
                    break;
                }
                ((Future) obj6).cancel(z && this.c);
                break;
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = d) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((vf) obj2).b(this);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        Object obj3 = g;
        Object obj4 = f;
        Object obj5 = d;
        Object obj6 = i;
        lazySet(2, Thread.currentThread());
        try {
            this.b.run();
            Object obj7 = get(0);
            if (obj7 != obj5 && compareAndSet(0, obj7, obj6) && obj7 != null) {
                ((vf) obj7).b(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == obj4 || obj2 == obj3) {
                    break;
                }
            } while (!compareAndSet(1, obj2, obj6));
            lazySet(2, null);
        } catch (Throwable th) {
            try {
                ui.a(th);
                throw th;
            } catch (Throwable th2) {
                Object obj8 = get(0);
                if (obj8 != obj5 && compareAndSet(0, obj8, obj6) && obj8 != null) {
                    ((vf) obj8).b(this);
                }
                do {
                    obj = get(1);
                    if (obj == obj4 || obj == obj3) {
                        break;
                    }
                } while (!compareAndSet(1, obj, obj6));
                lazySet(2, null);
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public final String toString() {
        String str;
        Object obj = get(1);
        if (obj == i) {
            str = "Finished";
        } else if (obj == f) {
            str = "Disposed(Sync)";
        } else if (obj == g) {
            str = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            if (obj2 == null) {
                str = "Waiting";
            } else {
                str = "Running on " + obj2;
            }
        }
        return ak.AnonymousClass0.m("xx0[", str, "]");
    }
}
