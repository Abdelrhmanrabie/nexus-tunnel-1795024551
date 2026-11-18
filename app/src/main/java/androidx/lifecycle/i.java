package androidx.lifecycle;

import android.os.Looper;
import defpackage.el;
import defpackage.ge0;
import defpackage.he0;
import defpackage.jx0;
import defpackage.ke0;
import defpackage.v6;
import defpackage.xs;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e {
    public final WeakReference e;
    public int f;
    public boolean g;
    public boolean h;
    public final boolean b = true;
    public xs c = new xs();
    public e.b d = e.b.INITIALIZED;
    public final ArrayList i = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
        public e.b a;
        public final h b;

        public a(ge0 ge0Var, e.b bVar) {
            h reflectiveGenericLifecycleObserver;
            HashMap map = ke0.a;
            boolean z = ge0Var instanceof h;
            boolean z2 = ge0Var instanceof el;
            if (z && z2) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((el) ge0Var, (h) ge0Var);
            } else if (z2) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((el) ge0Var, null);
            } else if (z) {
                reflectiveGenericLifecycleObserver = (h) ge0Var;
            } else {
                Class<?> cls = ge0Var.getClass();
                if (ke0.b(cls) == 2) {
                    List list = (List) ke0.b.get(cls);
                    if (list.size() == 1) {
                        reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(ke0.a((Constructor) list.get(0), ge0Var));
                    } else {
                        int size = list.size();
                        b[] bVarArr = new b[size];
                        for (int i = 0; i < size; i++) {
                            bVarArr[i] = ke0.a((Constructor) list.get(i), ge0Var);
                        }
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(bVarArr);
                    }
                } else {
                    reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(ge0Var);
                }
            }
            this.b = reflectiveGenericLifecycleObserver;
            this.a = bVar;
        }

        public final void a(he0 he0Var, e.a aVar) {
            e.b bVarA = aVar.a();
            e.b bVar = this.a;
            if (bVarA.compareTo(bVar) < 0) {
                bVar = bVarA;
            }
            this.a = bVar;
            this.b.a(he0Var, aVar);
            this.a = bVarA;
        }
    }

    public i(he0 he0Var) {
        this.e = new WeakReference(he0Var);
    }

    @Override // androidx.lifecycle.e
    public final void a(ge0 ge0Var) {
        he0 he0Var;
        e.a aVar;
        e("addObserver");
        e.b bVar = this.d;
        e.b bVar2 = e.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = e.b.INITIALIZED;
        }
        a aVar2 = new a(ge0Var, bVar2);
        if (((a) this.c.d(ge0Var, aVar2)) == null && (he0Var = (he0) this.e.get()) != null) {
            boolean z = this.f != 0 || this.g;
            e.b bVarD = d(ge0Var);
            this.f++;
            while (aVar2.a.compareTo(bVarD) < 0 && this.c.g.containsKey(ge0Var)) {
                e.b bVar3 = aVar2.a;
                ArrayList arrayList = this.i;
                arrayList.add(bVar3);
                e.a.C0015a c0015a = e.a.Companion;
                e.b bVar4 = aVar2.a;
                c0015a.getClass();
                int iOrdinal = bVar4.ordinal();
                if (iOrdinal == 1) {
                    aVar = e.a.ON_CREATE;
                } else if (iOrdinal != 2) {
                    aVar = iOrdinal != 3 ? null : e.a.ON_RESUME;
                } else {
                    aVar = e.a.ON_START;
                }
                if (aVar == null) {
                    throw new IllegalStateException("no event up from " + aVar2.a);
                }
                aVar2.a(he0Var, aVar);
                arrayList.remove(arrayList.size() - 1);
                bVarD = d(ge0Var);
            }
            if (!z) {
                i();
            }
            this.f--;
        }
    }

    @Override // androidx.lifecycle.e
    public final e.b b() {
        return this.d;
    }

    @Override // androidx.lifecycle.e
    public final void c(ge0 ge0Var) {
        e("removeObserver");
        this.c.e(ge0Var);
    }

    public final e.b d(ge0 ge0Var) {
        a aVar;
        xs xsVar = this.c;
        jx0.c cVar = xsVar.g.containsKey(ge0Var) ? ((jx0.c) xsVar.g.get(ge0Var)).f : null;
        e.b bVar = (cVar == null || (aVar = (a) cVar.c) == null) ? null : aVar.a;
        ArrayList arrayList = this.i;
        e.b bVar2 = arrayList.isEmpty() ? null : (e.b) arrayList.get(arrayList.size() - 1);
        e.b bVar3 = this.d;
        if (bVar == null || bVar.compareTo(bVar3) >= 0) {
            bVar = bVar3;
        }
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    public final void e(String str) {
        if (this.b) {
            v6.g().a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(defpackage.e.n("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(e.a aVar) {
        e("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(e.b bVar) {
        e.b bVar2 = this.d;
        if (bVar2 == bVar) {
            return;
        }
        e.b bVar3 = e.b.INITIALIZED;
        e.b bVar4 = e.b.DESTROYED;
        if (bVar2 == bVar3 && bVar == bVar4) {
            StringBuilder sb = new StringBuilder("no event down from ");
            sb.append(this.d);
            Object obj = this.e.get();
            sb.append(" in component ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString().toString());
        }
        this.d = bVar;
        if (this.g || this.f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        i();
        this.g = false;
        if (this.d == bVar4) {
            this.c = new xs();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    public final void i() {
        boolean z;
        e.a aVar;
        e.a aVar2;
        he0 he0Var = (he0) this.e.get();
        if (he0Var == null) {
            defpackage.d.AnonymousClass0.m("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
            return;
        }
        while (true) {
            xs xsVar = this.c;
            if (xsVar.f == 0) {
                z = true;
            } else {
                e.b bVar = ((a) xsVar.b.c).a;
                e.b bVar2 = ((a) xsVar.c.c).a;
                if (bVar == bVar2 && this.d == bVar2) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.h = false;
            if (z) {
                return;
            }
            int iCompareTo = this.d.compareTo(((a) xsVar.b.c).a);
            ArrayList arrayList = this.i;
            if (iCompareTo < 0) {
                xs xsVar2 = this.c;
                jx0.a aVar3 = new jx0.a(xsVar2.c, xsVar2.b, 1);
                xsVar2.d.put(aVar3, Boolean.FALSE);
                while (aVar3.hasNext() && !this.h) {
                    Map.Entry entry = (Map.Entry) aVar3.next();
                    ge0 ge0Var = (ge0) entry.getKey();
                    a aVar4 = (a) entry.getValue();
                    while (aVar4.a.compareTo(this.d) > 0 && !this.h && this.c.g.containsKey(ge0Var)) {
                        e.a.C0015a c0015a = e.a.Companion;
                        e.b bVar3 = aVar4.a;
                        c0015a.getClass();
                        int iOrdinal = bVar3.ordinal();
                        if (iOrdinal == 2) {
                            aVar2 = e.a.ON_DESTROY;
                        } else if (iOrdinal != 3) {
                            aVar2 = iOrdinal != 4 ? null : e.a.ON_PAUSE;
                        } else {
                            aVar2 = e.a.ON_STOP;
                        }
                        if (aVar2 == null) {
                            throw new IllegalStateException("no event down from " + aVar4.a);
                        }
                        arrayList.add(aVar2.a());
                        aVar4.a(he0Var, aVar2);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
            jx0.c cVar = this.c.c;
            if (!this.h && cVar != null && this.d.compareTo(((a) cVar.c).a) > 0) {
                xs xsVar3 = this.c;
                xsVar3.getClass();
                jx0.d dVar = new jx0.d();
                xsVar3.d.put(dVar, Boolean.FALSE);
                while (dVar.hasNext() && !this.h) {
                    Map.Entry entry2 = (Map.Entry) dVar.next();
                    ge0 ge0Var2 = (ge0) entry2.getKey();
                    a aVar5 = (a) entry2.getValue();
                    while (aVar5.a.compareTo(this.d) < 0 && !this.h && this.c.g.containsKey(ge0Var2)) {
                        arrayList.add(aVar5.a);
                        e.a.C0015a c0015a2 = e.a.Companion;
                        e.b bVar4 = aVar5.a;
                        c0015a2.getClass();
                        int iOrdinal2 = bVar4.ordinal();
                        if (iOrdinal2 == 1) {
                            aVar = e.a.ON_CREATE;
                        } else if (iOrdinal2 != 2) {
                            aVar = iOrdinal2 != 3 ? null : e.a.ON_RESUME;
                        } else {
                            aVar = e.a.ON_START;
                        }
                        if (aVar == null) {
                            throw new IllegalStateException("no event up from " + aVar5.a);
                        }
                        aVar5.a(he0Var, aVar);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
        }
    }
}
