package androidx.lifecycle;

import android.os.Looper;
import defpackage.he0;
import defpackage.jx0;
import defpackage.km0;
import defpackage.v6;
import java.util.Map;
import jx0.d;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object k = new Object();
    public final Object a = new Object();
    public final jx0 b = new jx0();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class LifecycleBoundObserver extends LiveData<T>.c implements h {
        public final he0 g;

        public LifecycleBoundObserver(he0 he0Var, km0 km0Var) {
            super(km0Var);
            this.g = he0Var;
        }

        @Override // androidx.lifecycle.h
        public final void a(he0 he0Var, e.a aVar) {
            he0 he0Var2 = this.g;
            e.b bVarB = he0Var2.getLifecycle().b();
            if (bVarB != e.b.DESTROYED) {
                e.b bVar = null;
                while (bVar != bVarB) {
                    g(j());
                    bVar = bVarB;
                    bVarB = he0Var2.getLifecycle().b();
                }
                return;
            }
            LiveData liveData = LiveData.this;
            liveData.getClass();
            LiveData.a("removeObserver");
            c cVar = (c) liveData.b.e(this.b);
            if (cVar == null) {
                return;
            }
            cVar.h();
            cVar.g(false);
        }

        @Override // androidx.lifecycle.LiveData.c
        public final void h() {
            this.g.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean i(HamoTunnelPlusMain hamoTunnelPlusMain) {
            return this.g == hamoTunnelPlusMain;
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean j() {
            return this.g.getLifecycle().b().compareTo(e.b.STARTED) >= 0;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.i(obj);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends LiveData<T>.c {
        public b(LiveData liveData, km0 km0Var) {
            super(km0Var);
        }

        @Override // androidx.lifecycle.LiveData.c
        public final boolean j() {
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c {
        public final km0 b;
        public boolean c;
        public int d = -1;

        public c(km0 km0Var) {
            this.b = km0Var;
        }

        public final void g(boolean z) {
            if (z == this.c) {
                return;
            }
            this.c = z;
            int i = z ? 1 : -1;
            LiveData liveData = LiveData.this;
            int i2 = liveData.c;
            liveData.c = i + i2;
            if (!liveData.d) {
                liveData.d = true;
                while (true) {
                    try {
                        int i3 = liveData.c;
                        if (i2 == i3) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    } catch (Throwable th) {
                        liveData.d = false;
                        throw th;
                    }
                }
                liveData.d = false;
            }
            if (this.c) {
                liveData.c(this);
            }
        }

        public void h() {
        }

        public boolean i(HamoTunnelPlusMain hamoTunnelPlusMain) {
            return false;
        }

        public abstract boolean j();
    }

    public LiveData() {
        Object obj = k;
        this.f = obj;
        new a();
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        v6.g().a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(defpackage.e.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(c cVar) {
        if (cVar.c) {
            if (!cVar.j()) {
                cVar.g(false);
                return;
            }
            int i = cVar.d;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            cVar.d = i2;
            cVar.b.a(this.e);
        }
    }

    public final void c(c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar != null) {
                b(cVar);
                cVar = null;
            } else {
                jx0 jx0Var = this.b;
                jx0Var.getClass();
                jx0.d dVar = jx0Var.new d();
                jx0Var.d.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((c) ((Map.Entry) dVar.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public final void d(HamoTunnelPlusMain hamoTunnelPlusMain, km0 km0Var) {
        a("observe");
        if (hamoTunnelPlusMain.getLifecycle().b() == e.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hamoTunnelPlusMain, km0Var);
        c cVar = (c) this.b.d(km0Var, lifecycleBoundObserver);
        if (cVar != null && !cVar.i(hamoTunnelPlusMain)) {
            defpackage.d.AnonymousClass0.m$2("Cannot add the same observer with different lifecycles");
        } else {
            if (cVar != null) {
                return;
            }
            hamoTunnelPlusMain.getLifecycle().a(lifecycleBoundObserver);
        }
    }

    public final void e(androidx.fragment.app.m.d dVar) {
        a("observeForever");
        b bVar = new b(this, dVar);
        c cVar = (c) this.b.d(dVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            defpackage.d.AnonymousClass0.m$2("Cannot add the same observer with different lifecycles");
        } else {
            if (cVar != null) {
                return;
            }
            bVar.g(true);
        }
    }

    public abstract void i(Object obj);
}
