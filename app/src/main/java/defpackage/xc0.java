package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xc0 extends zc {
    public final rd0 A;
    public final wc0 B;
    public final ff0.h C;
    public final v8 n;
    public final qt0 o;
    public final ai0 p;
    public final v8 q;
    public final v41 r;
    public final int s;
    public final zh0 t;
    public final a70 u;
    public final boolean v;
    public final on.b w;
    public final dd0 x;
    public final gy0 y;
    public final k20 z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ xc0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(xc0 xc0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = xc0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            int i = this.G0;
            xc0 xc0Var = this.b;
            if (i != 0) {
                if (i == 1) {
                    return e4.b((pd) xc0Var);
                }
                if (ym.f(xc0Var) == null) {
                    return null;
                }
                ((c60) xc0Var.n.a).w.getClass();
                return null;
            }
            qt0 qt0Var = xc0Var.o;
            ArrayList<gu0> typeParameters = qt0Var.getTypeParameters();
            ArrayList arrayList = new ArrayList(ae.y0(typeParameters));
            for (gu0 gu0Var : typeParameters) {
                v91 v91VarA = ((y91) xc0Var.q.b).a(gu0Var);
                if (v91VarA == null) {
                    throw new AssertionError("Parameter " + gu0Var + " surely belongs to class " + qt0Var + ", so it must be resolved");
                }
                arrayList.add(v91VarA);
            }
            return arrayList;
        }
    }

    static {
        ae.O0(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public xc0(v8 v8Var, ok okVar, qt0 qt0Var, ai0 ai0Var) throws IllegalAccessException, InvocationTargetException {
        zh0 zh0Var;
        c60 c60Var = (c60) v8Var.a;
        ff0 ff0Var = c60Var.a;
        ij0 ij0VarF = ij0.f(qt0Var.a.getSimpleName());
        c60Var.j.getClass();
        super(ff0Var, okVar, ij0VarF, new tw0$a(qt0Var));
        this.n = v8Var;
        this.o = qt0Var;
        this.p = ai0Var;
        v8 v8VarA = uh.a(v8Var, this, qt0Var, 4);
        this.q = v8VarA;
        c60 c60Var2 = (c60) v8VarA.a;
        c60Var2.g.getClass();
        int i = 2;
        this.r = new v41(new b(this, i));
        Class cls = qt0Var.a;
        if (cls.isAnnotation()) {
            i = 5;
        } else if (!cls.isInterface()) {
            i = cls.isEnum() ? 3 : 1;
        }
        this.s = i;
        boolean zIsAnnotation = cls.isAnnotation();
        zh0 zh0Var2 = zh0.b;
        int i2 = 0;
        if (!zIsAnnotation && !cls.isEnum()) {
            boolean zW = qt0Var.w();
            boolean z = qt0Var.w() || Modifier.isAbstract(cls.getModifiers()) || cls.isInterface();
            boolean zIsFinal = Modifier.isFinal(cls.getModifiers());
            if (zW) {
                zh0Var = zh0.c;
            } else if (z) {
                zh0Var = zh0.f;
            } else if (!zIsFinal) {
                zh0Var = zh0.d;
            }
            zh0Var2 = zh0Var;
        }
        this.t = zh0Var2;
        this.u = b2.a((bu0) qt0Var);
        Class<?> declaringClass = cls.getDeclaringClass();
        this.v = ((declaringClass == null ? null : new qt0(declaringClass)) == null || Modifier.isStatic(cls.getModifiers())) ? false : true;
        this.w = new on.b(this);
        dd0 dd0Var = new dd0(v8VarA, this, qt0Var, ai0Var != null, null);
        this.x = dd0Var;
        e eVar = gy0.e;
        ((yk0) c60Var2.u).getClass();
        i iVar = new i(18, this);
        eVar.getClass();
        ff0 ff0Var2 = c60Var2.a;
        this.y = new gy0(this, ff0Var2, iVar);
        this.z = new k20(dd0Var);
        this.A = new rd0(v8VarA, qt0Var, this);
        this.B = e.Z(v8VarA, qt0Var);
        this.C = new ff0.h(ff0Var2, new b(this, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Collection, uq] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    @Override // defpackage.ai0
    public final Collection A() throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        zh0 zh0Var = zh0.c;
        zh0 zh0Var2 = this.t;
        ?? arrayList = uq.b;
        if (zh0Var2 != zh0Var) {
            return arrayList;
        }
        int i = 0;
        Object obj = null;
        n60 n60VarB = w60.b(2, false, null, 3);
        Class cls = this.o.a;
        oo ooVar = e4.f46a;
        if (ooVar == null) {
            try {
                ooVar = new oo(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            } catch (NoSuchMethodException unused) {
                ooVar = new oo(obj, obj, obj, obj);
            }
            e4.f46a = ooVar;
        }
        Method method = (Method) ooVar.b;
        if (method == null) {
            clsArr = null;
        } else {
            Object objInvoke = method.invoke(cls, null);
            if (objInvoke == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
                return null;
            }
            clsArr = (Class[]) objInvoke;
        }
        if (clsArr != null) {
            arrayList = new ArrayList(clsArr.length);
            int length = clsArr.length;
            while (i < length) {
                Class cls2 = clsArr[i];
                i++;
                arrayList.add(new tt0(cls2));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            od odVarB = ((oo) this.q.e).e((tt0) it.next(), n60VarB).L0().b();
            ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
            if (ai0Var != null) {
                arrayList2.add(ai0Var);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.pd
    public final boolean B() {
        return this.v;
    }

    @Override // defpackage.ai0
    public final uc E() {
        return null;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return false;
    }

    public final dd0 K0() {
        return (dd0) super.Y();
    }

    @Override // defpackage.k, defpackage.ai0
    public final vg0 V() {
        return this.z;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        return (dd0) this.y.a(lc0_a);
    }

    @Override // defpackage.k, defpackage.ai0
    public final vg0 Y() {
        return (dd0) super.Y();
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return false;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return this.B;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = cn.a;
        a70 a70Var = this.u;
        if (e4.a(a70Var, dVar)) {
            Class<?> declaringClass = this.o.a.getDeclaringClass();
            if ((declaringClass == null ? null : new qt0(declaringClass)) == null) {
                return h50.a;
            }
        }
        return e.f0(a70Var);
    }

    @Override // defpackage.od
    public final a91 h() {
        return this.w;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        return (List) this.x.q.invoke();
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        return (List) this.C.invoke();
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return this.A;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        return this.t;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.ai0
    public final i20 t() {
        return null;
    }

    public final String toString() {
        int i = ym.$r8$clinit;
        return e4.j("Lazy Java class ", xm.g(this));
    }

    @Override // defpackage.ai0
    public final int v() {
        return this.s;
    }
}
