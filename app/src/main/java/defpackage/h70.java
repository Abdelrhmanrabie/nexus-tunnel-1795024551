package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class h70 implements li.b {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(h70.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(h70.class, Object.class, "_parentHandle$volatile");
    public volatile /* synthetic */ Object _parentHandle$volatile;
    public volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends g70 {
        public final h70 g;
        public final c i;
        public final oc j;
        public final Object n;

        public b(h70 h70Var, c cVar, oc ocVar, Object obj) {
            this.g = h70Var;
            this.i = cVar;
            this.j = ocVar;
            this.n = obj;
        }

        @Override // defpackage.nw
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            k((Throwable) obj);
            return tb1.a;
        }

        @Override // defpackage.g70
        public final void k(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h70.b;
            oc ocVarU = h70.U(this.j);
            h70 h70Var = this.g;
            c cVar = this.i;
            Object obj = this.n;
            if (ocVarU != null) {
                while (e4.a(ocVarU.g, new b(h70Var, cVar, ocVarU, obj), 1) == gl0.b) {
                    ocVarU = h70.U(ocVarU);
                    if (ocVarU == null) {
                    }
                }
                return;
            }
            h70Var.B(h70Var.I(cVar, obj));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements x10 {
        public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        public volatile /* synthetic */ Object _exceptionsHolder$volatile;
        public volatile /* synthetic */ int _isCompleting$volatile = 0;
        public volatile /* synthetic */ Object _rootCause$volatile;
        public final fl0 b;

        public c(fl0 fl0Var, Throwable th) {
            this.b = fl0Var;
            this._rootCause$volatile = th;
        }

        public final void a(Throwable th) {
            Throwable thB = b();
            if (thB == null) {
                d.set(this, th);
                return;
            }
            if (th == thB) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    defpackage.d.AnonymousClass0.m$1("State is ", obj);
                    return;
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        public final Throwable b() {
            return (Throwable) d.get(this);
        }

        @Override // defpackage.x10
        public final fl0 c() {
            return this.b;
        }

        public final boolean d() {
            return b() != null;
        }

        public final boolean e() {
            return c.get(this) != 0;
        }

        public final ArrayList f(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    defpackage.d.AnonymousClass0.m$1("State is ", obj);
                    return null;
                }
                arrayList = (ArrayList) obj;
            }
            Throwable thB = b();
            if (thB != null) {
                arrayList.add(0, thB);
            }
            if (th != null && !th.equals(thB)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, e.g);
            return arrayList;
        }

        @Override // defpackage.x10
        public final boolean isActive() {
            return b() == null;
        }

        public final String toString() {
            return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + b() + ", exceptions=" + f.get(this) + ", list=" + this.b + ']';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends p7 {
        public final g70 b;
        public fl0 c;
        public final /* synthetic */ h70 d;
        public final /* synthetic */ x10 e;

        public d(g70 g70Var, h70 h70Var, x10 x10Var) {
            this.d = h70Var;
            this.e = x10Var;
            this._consensus$volatile = e.a;
            this.b = g70Var;
        }

        @Override // defpackage.p7
        public final void b(Object obj, Object obj2) {
            kf0 kf0Var = (kf0) obj;
            boolean z = obj2 == null;
            kf0 kf0Var2 = this.b;
            kf0 kf0Var3 = z ? kf0Var2 : this.c;
            if (kf0Var3 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kf0.b;
                while (!atomicReferenceFieldUpdater.compareAndSet(kf0Var, this, kf0Var3)) {
                    if (atomicReferenceFieldUpdater.get(kf0Var) != this) {
                        return;
                    }
                }
                if (z) {
                    kf0Var2.f(this.c);
                }
            }
        }

        @Override // defpackage.p7
        public final ci0 c(Object obj) {
            if (this.d.N() == this.e) {
                return null;
            }
            return e.d$1;
        }
    }

    public h70(boolean z) {
        this._state$volatile = z ? e.i : e.f39h;
    }

    public static oc U(kf0 kf0Var) {
        while (kf0Var.j()) {
            kf0 kf0VarE = kf0Var.e();
            if (kf0VarE == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kf0.c;
                do {
                    kf0Var = (kf0) atomicReferenceFieldUpdater.get(kf0Var);
                } while (kf0Var.j());
            } else {
                kf0Var = kf0VarE;
            }
        }
        while (true) {
            kf0Var = kf0Var.h();
            if (!kf0Var.j()) {
                if (kf0Var instanceof oc) {
                    return (oc) kf0Var;
                }
                if (kf0Var instanceof fl0) {
                    return null;
                }
            }
        }
    }

    public static String a0(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof x10) {
                return ((x10) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof te ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.d()) {
            return "Cancelling";
        }
        return cVar.e() ? "Completing" : "Active";
    }

    public void B(Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039 A[PHI: r0
      0x0039: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v9 java.lang.Object) binds: [B:3:0x0007, B:16:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0056, B:31:0x005e, B:37:0x0075, B:35:0x006b, B:36:0x006f), top: B:81:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x005e A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0056, B:31:0x005e, B:37:0x0075, B:35:0x006b, B:36:0x006f), top: B:81:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006b A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0056, B:31:0x005e, B:37:0x0075, B:35:0x006b, B:36:0x006f), top: B:81:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:81:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[LOOP:2: B:55:0x00ab->B:98:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x003e, please report this as an issue */
    public final boolean C(Object obj) {
        Throwable thH;
        Object objN;
        Throwable thB;
        ci0 ci0Var;
        x10 x10Var;
        fl0 fl0VarM;
        c cVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object objB0;
        Object objB1 = e.c;
        if (L()) {
            do {
                Object objN2 = N();
                if (!(objN2 instanceof x10) || ((objN2 instanceof c) && ((c) objN2).e())) {
                    objB1 = e.c;
                    break;
                }
                objB1 = b0(objN2, new te(H(obj)));
            } while (objB1 == e.e);
            if (objB1 != e.d) {
                if (objB1 == e.c) {
                    thH = null;
                    while (true) {
                        objN = N();
                        if (objN instanceof c) {
                            synchronized (objN) {
                                if (c.f.get((c) objN) == e.g) {
                                    ci0Var = e.f;
                                } else {
                                    boolean zD = ((c) objN).d();
                                    if (obj == null || !zD) {
                                        if (thH == null) {
                                            thH = H(obj);
                                        }
                                        ((c) objN).a(thH);
                                    }
                                    thB = zD ? null : ((c) objN).b();
                                    if (thB != null) {
                                        V(((c) objN).b, thB);
                                    }
                                    ci0Var = e.c;
                                }
                            }
                            objB1 = ci0Var;
                        } else if (objN instanceof x10) {
                            if (thH == null) {
                                thH = H(obj);
                            }
                            x10Var = (x10) objN;
                            if (x10Var.isActive()) {
                                fl0VarM = M(x10Var);
                                if (fl0VarM == null) {
                                    continue;
                                } else {
                                    cVar = new c(fl0VarM, thH);
                                    while (true) {
                                        atomicReferenceFieldUpdater = b;
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, x10Var, cVar)) {
                                            V(fl0VarM, thH);
                                            ci0Var = e.c;
                                            objB1 = ci0Var;
                                        } else if (atomicReferenceFieldUpdater.get(this) != x10Var) {
                                        }
                                    }
                                }
                            } else {
                                objB0 = b0(objN, new te(thH));
                                if (objB0 != e.c) {
                                    defpackage.d.AnonymousClass0.m$1("Cannot happen in ", objN);
                                    return false;
                                }
                                if (objB0 != e.e) {
                                    objB1 = objB0;
                                }
                            }
                        } else {
                            ci0Var = e.f;
                            objB1 = ci0Var;
                        }
                    }
                }
                if (objB1 != e.c && objB1 != e.d) {
                    if (objB1 == e.f) {
                        return false;
                    }
                    B(objB1);
                    return true;
                }
            }
        } else {
            if (objB1 == e.c) {
                thH = null;
                while (true) {
                    objN = N();
                    if (objN instanceof c) {
                        synchronized (objN) {
                            if (c.f.get((c) objN) == e.g) {
                                ci0Var = e.f;
                            } else {
                                boolean zD2 = ((c) objN).d();
                                if (obj == null) {
                                    if (thH == null) {
                                        thH = H(obj);
                                    }
                                    ((c) objN).a(thH);
                                } else {
                                    if (thH == null) {
                                        thH = H(obj);
                                    }
                                    ((c) objN).a(thH);
                                }
                                if (zD2) {
                                }
                                if (thB != null) {
                                    V(((c) objN).b, thB);
                                }
                                ci0Var = e.c;
                            }
                            objB1 = ci0Var;
                        }
                    } else if (objN instanceof x10) {
                        if (thH == null) {
                            thH = H(obj);
                        }
                        x10Var = (x10) objN;
                        if (x10Var.isActive()) {
                            fl0VarM = M(x10Var);
                            if (fl0VarM == null) {
                                continue;
                            } else {
                                cVar = new c(fl0VarM, thH);
                                while (true) {
                                    atomicReferenceFieldUpdater = b;
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, x10Var, cVar)) {
                                        V(fl0VarM, thH);
                                        ci0Var = e.c;
                                        objB1 = ci0Var;
                                    } else if (atomicReferenceFieldUpdater.get(this) != x10Var) {
                                    }
                                }
                            }
                        } else {
                            objB0 = b0(objN, new te(thH));
                            if (objB0 != e.c) {
                                defpackage.d.AnonymousClass0.m$1("Cannot happen in ", objN);
                                return false;
                            }
                            if (objB0 != e.e) {
                                objB1 = objB0;
                            }
                        }
                    } else {
                        ci0Var = e.f;
                        objB1 = ci0Var;
                    }
                }
            }
            if (objB1 != e.c) {
                if (objB1 == e.f) {
                    return false;
                }
                B(objB1);
                return true;
            }
        }
        return true;
    }

    public final boolean D(Throwable th) {
        if (R()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        nc ncVar = (nc) c.get(this);
        if (ncVar == null || ncVar == gl0.b) {
            return z;
        }
        return ncVar.b(th) || z;
    }

    public String E() {
        return "Job was cancelled";
    }

    public boolean F(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return C(th) && K();
    }

    public final void G(x10 x10Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        nc ncVar = (nc) atomicReferenceFieldUpdater.get(this);
        if (ncVar != null) {
            ncVar.a();
            atomicReferenceFieldUpdater.set(this, gl0.b);
        }
        we weVar = null;
        te teVar = obj instanceof te ? (te) obj : null;
        Throwable th = teVar != null ? teVar.a : null;
        if (x10Var instanceof g70) {
            try {
                ((g70) x10Var).k(th);
                return;
            } catch (Throwable th2) {
                P(new we("Exception in completion handler " + x10Var + " for " + this, th2));
                return;
            }
        }
        fl0 fl0VarC = x10Var.c();
        if (fl0VarC != null) {
            for (kf0 kf0VarH = (kf0) fl0VarC.g(); !e4.a(kf0VarH, fl0VarC); kf0VarH = kf0VarH.h()) {
                if (kf0VarH instanceof g70) {
                    g70 g70Var = (g70) kf0VarH;
                    try {
                        g70Var.k(th);
                    } catch (Throwable th3) {
                        if (weVar != null) {
                            e.e(weVar, th3);
                        } else {
                            weVar = new we("Exception in completion handler " + g70Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (weVar != null) {
                P(weVar);
            }
        }
    }

    public final Throwable H(Object obj) {
        Throwable thB;
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new d70(E(), null, this) : th;
        }
        h70 h70Var = (h70) obj;
        Object objN = h70Var.N();
        if (objN instanceof c) {
            thB = ((c) objN).b();
        } else if (objN instanceof te) {
            thB = ((te) objN).a;
        } else {
            if (objN instanceof x10) {
                defpackage.d.AnonymousClass0.m$1("Cannot be cancelling child in this state: ", objN);
                return null;
            }
            thB = null;
        }
        CancellationException cancellationException = thB instanceof CancellationException ? (CancellationException) thB : null;
        return cancellationException == null ? new d70("Parent job is ".concat(a0(objN)), thB, h70Var) : cancellationException;
    }

    public final Object I(c cVar, Object obj) {
        Object obj2 = null;
        Throwable d70Var = null;
        te teVar = obj instanceof te ? (te) obj : null;
        Throwable th = teVar != null ? teVar.a : null;
        synchronized (cVar) {
            try {
                cVar.d();
                ArrayList<Throwable> arrayListF = cVar.f(th);
                if (!arrayListF.isEmpty()) {
                    for (Object obj3 : arrayListF) {
                        if (!(((Throwable) obj3) instanceof CancellationException)) {
                            obj2 = obj3;
                            break;
                        }
                    }
                    d70Var = (Throwable) obj2;
                    if (d70Var == null) {
                        d70Var = (Throwable) arrayListF.get(0);
                    }
                } else if (cVar.d()) {
                    d70Var = new d70(E(), null, this);
                }
                if (d70Var != null && arrayListF.size() > 1) {
                    Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                    for (Throwable th2 : arrayListF) {
                        if (th2 != d70Var && th2 != d70Var && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                            e.e(d70Var, th2);
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (d70Var != null && d70Var != th) {
            obj = new te(d70Var);
        }
        if (d70Var != null && (D(d70Var) || O(d70Var))) {
            te.b.compareAndSet((te) obj, 0, 1);
        }
        W(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        Object y10Var = obj instanceof x10 ? new y10((x10) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, cVar, y10Var) && atomicReferenceFieldUpdater.get(this) == cVar) {
        }
        G(cVar, obj);
        return obj;
    }

    public boolean K() {
        return true;
    }

    public boolean L() {
        return false;
    }

    public final fl0 M(x10 x10Var) {
        fl0 fl0VarC = x10Var.c();
        if (fl0VarC != null) {
            return fl0VarC;
        }
        if (x10Var instanceof oq) {
            return new fl0();
        }
        if (x10Var instanceof g70) {
            Y((g70) x10Var);
            return null;
        }
        defpackage.d.AnonymousClass0.m$1("State should have list: ", x10Var);
        return null;
    }

    public final Object N() {
        while (true) {
            Object obj = b.get(this);
            if (!(obj instanceof p7)) {
                return obj;
            }
            ((p7) obj).a(this);
        }
    }

    public boolean O(Throwable th) {
        return false;
    }

    public void P(we weVar) {
        throw weVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0046  */
    public final void Q(h70 h70Var) {
        byte b2;
        gl0 gl0Var = gl0.b;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (h70Var == null) {
            atomicReferenceFieldUpdater.set(this, gl0Var);
            return;
        }
        do {
            Object objN = h70Var.N();
            boolean z = objN instanceof oq;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = b;
            if (z) {
                if (((oq) objN).b) {
                    b2 = 0;
                } else {
                    oq oqVar = e.i;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(h70Var, objN, oqVar)) {
                            b2 = 1;
                        } else if (atomicReferenceFieldUpdater2.get(h70Var) != objN) {
                            b2 = -1;
                        }
                    }
                }
            } else if (objN instanceof v10) {
                fl0 fl0Var = ((v10) objN).b;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(h70Var, objN, fl0Var)) {
                        b2 = 1;
                    } else if (atomicReferenceFieldUpdater2.get(h70Var) != objN) {
                        b2 = -1;
                    }
                }
            } else {
                b2 = 0;
            }
            if (b2 == 0) {
                break;
            }
        } while (b2 != 1);
        nc ncVar = (nc) e4.a(h70Var, new oc(this), 2);
        atomicReferenceFieldUpdater.set(this, ncVar);
        if (N() instanceof x10) {
            return;
        }
        ncVar.a();
        atomicReferenceFieldUpdater.set(this, gl0Var);
    }

    public boolean R() {
        return false;
    }

    public final Object S(Object obj) {
        Object objB0;
        do {
            objB0 = b0(N(), obj);
            if (objB0 == e.c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                te teVar = obj instanceof te ? (te) obj : null;
                throw new IllegalStateException(str, teVar != null ? teVar.a : null);
            }
        } while (objB0 == e.e);
        return objB0;
    }

    public final void V(fl0 fl0Var, Throwable th) {
        we weVar = null;
        for (kf0 kf0VarH = (kf0) fl0Var.g(); !e4.a(kf0VarH, fl0Var); kf0VarH = kf0VarH.h()) {
            if (kf0VarH instanceof e70) {
                g70 g70Var = (g70) kf0VarH;
                try {
                    g70Var.k(th);
                } catch (Throwable th2) {
                    if (weVar != null) {
                        e.e(weVar, th2);
                    } else {
                        weVar = new we("Exception in completion handler " + g70Var + " for " + this, th2);
                    }
                }
            }
        }
        if (weVar != null) {
            P(weVar);
        }
        D(th);
    }

    public void W(Object obj) {
    }

    public void X() {
    }

    public final void Y(g70 g70Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        fl0 fl0Var = new fl0();
        g70Var.getClass();
        kf0.c.set(fl0Var, g70Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = kf0.b;
        atomicReferenceFieldUpdater2.set(fl0Var, g70Var);
        loop0: while (g70Var.g() == g70Var) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(g70Var, g70Var, fl0Var)) {
                    fl0Var.f(g70Var);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(g70Var) == g70Var);
        }
        kf0 kf0VarH = g70Var.h();
        do {
            atomicReferenceFieldUpdater = b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, g70Var, kf0VarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == g70Var);
    }

    @Override // defpackage.li
    public final li.b a(li.c cVar) {
        if (e4.a(e.b$1, cVar)) {
            return this;
        }
        return null;
    }

    public final boolean b(x10 x10Var, fl0 fl0Var, g70 g70Var) {
        boolean z;
        char c2;
        d dVar = new d(g70Var, this, x10Var);
        do {
            kf0 kf0VarE = fl0Var.e();
            if (kf0VarE == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kf0.c;
                Object obj = atomicReferenceFieldUpdater.get(fl0Var);
                while (true) {
                    kf0VarE = (kf0) obj;
                    if (!kf0VarE.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kf0VarE);
                }
            }
            kf0.c.set(g70Var, kf0VarE);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = kf0.b;
            atomicReferenceFieldUpdater2.set(g70Var, fl0Var);
            dVar.c = fl0Var;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(kf0VarE, fl0Var, dVar)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater2.get(kf0VarE) != fl0Var) {
                    z = false;
                    break;
                }
            }
            if (z) {
                c2 = dVar.a(kf0VarE) == null ? (char) 1 : (char) 2;
            } else {
                c2 = 0;
            }
            if (c2 == 1) {
                return true;
            }
        } while (c2 != 2);
        return false;
    }

    public final Object b0(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ci0 ci0Var;
        if (!(obj instanceof x10)) {
            return e.c;
        }
        if (((obj instanceof oq) || (obj instanceof g70)) && !(obj instanceof oc) && !(obj2 instanceof te)) {
            x10 x10Var = (x10) obj;
            Object y10Var = obj2 instanceof x10 ? new y10((x10) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, x10Var, y10Var)) {
                    W(obj2);
                    G(x10Var, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == x10Var);
            return e.e;
        }
        x10 x10Var2 = (x10) obj;
        fl0 fl0VarM = M(x10Var2);
        if (fl0VarM == null) {
            return e.e;
        }
        oc ocVarU = null;
        c cVar = x10Var2 instanceof c ? (c) x10Var2 : null;
        if (cVar == null) {
            cVar = new c(fl0VarM, null);
        }
        synchronized (cVar) {
            try {
                if (!cVar.e()) {
                    c.c.set(cVar, 1);
                    if (cVar != x10Var2) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = b;
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, x10Var2, cVar)) {
                            if (atomicReferenceFieldUpdater2.get(this) != x10Var2) {
                                ci0Var = e.e;
                            }
                        }
                    }
                    boolean zD = cVar.d();
                    te teVar = obj2 instanceof te ? (te) obj2 : null;
                    if (teVar != null) {
                        cVar.a(teVar.a);
                    }
                    Throwable thB = cVar.b();
                    if (zD) {
                        thB = null;
                    }
                    if (thB != null) {
                        V(fl0VarM, thB);
                    }
                    oc ocVar = x10Var2 instanceof oc ? (oc) x10Var2 : null;
                    if (ocVar == null) {
                        fl0 fl0VarC = x10Var2.c();
                        if (fl0VarC != null) {
                            ocVarU = U(fl0VarC);
                        }
                    } else {
                        ocVarU = ocVar;
                    }
                    if (ocVarU != null) {
                        while (e4.a(ocVarU.g, new b(this, cVar, ocVarU, obj2), 1) == gl0.b) {
                            ocVarU = U(ocVarU);
                            if (ocVarU == null) {
                            }
                        }
                        return e.d;
                    }
                    return I(cVar, obj2);
                }
                ci0Var = e.c;
                return ci0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d0(Object obj) {
        B(obj);
    }

    public final CancellationException e() {
        CancellationException cancellationException;
        Object objN = N();
        if (objN instanceof c) {
            Throwable thB = ((c) objN).b();
            if (thB == null) {
                defpackage.d.AnonymousClass0.m$1("Job is still new or active: ", this);
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thB instanceof CancellationException ? (CancellationException) thB : null;
            return cancellationException == null ? new d70(strConcat, thB, this) : cancellationException;
        }
        if (objN instanceof x10) {
            defpackage.d.AnonymousClass0.m$1("Job is still new or active: ", this);
            return null;
        }
        if (!(objN instanceof te)) {
            return new d70(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((te) objN).a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new d70(E(), th, this) : cancellationException;
    }

    @Override // defpackage.li
    public final li f(li.c cVar) {
        return e4.a(e.b$1, cVar) ? rq.b : this;
    }

    @Override // li.b
    public final li.c getKey() {
        return e.b$1;
    }

    @Override // defpackage.li
    public final Object i(Object obj, bx bxVar) {
        return bxVar.invoke(obj, this);
    }

    public boolean isActive() {
        Object objN = N();
        return (objN instanceof x10) && ((x10) objN).isActive();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + a0(N()) + '}');
        sb.append('@');
        sb.append(e.D(this));
        return sb.toString();
    }

    @Override // defpackage.li
    public final li y(li liVar) {
        return ak.a(this, liVar);
    }
}
