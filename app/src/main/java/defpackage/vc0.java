package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vc0 implements g4, kp0 {
    public static final /* synthetic */ ja0[] i;
    public final v8 a;
    public final ct0 b;
    public final ff0.f c;
    public final ff0.h d;
    public final tw0$a e;
    public final ff0.h f;
    public final boolean h;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ vc0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(vc0 vc0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = vc0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() throws IllegalAccessException, InvocationTargetException {
            int i = this.G0;
            vc0 vc0Var = this.b;
            if (i == 0) {
                ArrayList<dt0> arrayListG = vc0Var.b.g();
                ArrayList arrayList = new ArrayList();
                for (dt0 dt0Var : arrayListG) {
                    ij0 ij0Var = dt0Var.a;
                    if (ij0Var == null) {
                        ij0Var = r70.b;
                    }
                    qg qgVarA = vc0Var.a(dt0Var);
                    jo0 jo0Var = qgVarA == null ? null : new jo0(ij0Var, qgVarA);
                    if (jo0Var != null) {
                        arrayList.add(jo0Var);
                    }
                }
                return ye1.j(arrayList);
            }
            if (i == 1) {
                return bt0.a(((sc) e.v(vc0Var.b.a)).d()).b();
            }
            cv cvVarE = vc0Var.e();
            ct0 ct0Var = vc0Var.b;
            if (cvVarE == null) {
                return pr.d(e4.j("No fqName: ", ct0Var));
            }
            v8 v8Var = vc0Var.a;
            ai0 ai0VarA0 = e.a0(cvVarE, ((c60) v8Var.a).o.k());
            if (ai0VarA0 == null) {
                qt0 qt0Var = new qt0(((sc) e.v(ct0Var.a)).d());
                c60 c60Var = (c60) v8Var.a;
                bj bjVar = (bj) c60Var.k.a;
                bjVar.getClass();
                ai0VarA0 = bjVar.a(qt0Var);
                if (ai0VarA0 == null) {
                    gi0 gi0Var = c60Var.o;
                    dd ddVarL = dd.l(cvVarE);
                    fn fnVar = c60Var.d.a;
                    fnVar.getClass();
                    ai0VarA0 = e4.c(gi0Var, ddVarL, fnVar.l);
                }
            }
            return ai0VarA0.n();
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        i = new ja0[]{pu0Var.f(new tq0(pu0Var.b(vc0.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), pu0Var.f(new tq0(pu0Var.b(vc0.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), pu0Var.f(new tq0(pu0Var.b(vc0.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public vc0(v8 v8Var, ct0 ct0Var, boolean z) {
        this.a = v8Var;
        this.b = ct0Var;
        c60 c60Var = (c60) v8Var.a;
        ff0 ff0Var = c60Var.a;
        a aVar = new a(this, 1);
        ff0Var.getClass();
        this.c = new ff0.f(ff0Var, aVar);
        this.d = new ff0.h(ff0Var, new a(this, 2));
        c60Var.j.getClass();
        this.e = new tw0$a(ct0Var);
        this.f = new ff0.h(ff0Var, new a(this, 0));
        ct0Var.getClass();
        this.h = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final qg a(dt0 dt0Var) {
        fu0 ht0Var;
        if (dt0Var instanceof yt0) {
            return b2.b(((yt0) dt0Var).b);
        }
        if (dt0Var instanceof wt0) {
            Enum r6 = ((wt0) dt0Var).b;
            Class<?> enclosingClass = r6.getClass();
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            return new kr(bt0.a(enclosingClass), ij0.f(r6.name()));
        }
        boolean z = dt0Var instanceof gt0;
        v8 v8Var = this.a;
        if (z) {
            gt0 gt0Var = (gt0) dt0Var;
            ij0 ij0Var = gt0Var.a;
            if (ij0Var == null) {
                ij0Var = r70.b;
            }
            ArrayList elements = gt0Var.getElements();
            ja0 ja0Var = i[1];
            if (!e.O((fc0) this.d.invoke())) {
                wc1 wc1VarO0 = e.O0(ij0Var, ym.d(this));
                fc0 fc0VarH = wc1VarO0 == null ? ((c60) v8Var.a).o.k().h(pr.d("Unknown array element type")) : wc1VarO0.getType();
                ArrayList arrayList = new ArrayList(ae.y0(elements));
                Iterator it = elements.iterator();
                while (it.hasNext()) {
                    qg qgVarA = a((dt0) it.next());
                    if (qgVarA == null) {
                        qgVarA = new xl0(null);
                    }
                    arrayList.add(qgVarA);
                }
                return new h7(arrayList, new jn(fc0VarH, 1));
            }
        } else {
            if (dt0Var instanceof et0) {
                return new r4(new vc0(v8Var, new ct0(((et0) dt0Var).b), false));
            }
            if (dt0Var instanceof st0) {
                Class cls = ((st0) dt0Var).b;
                if (cls.isPrimitive()) {
                    ht0Var = new du0(cls);
                } else if ((cls instanceof GenericArrayType) || cls.isArray()) {
                    ht0Var = new ht0(cls);
                } else {
                    ht0Var = cls instanceof WildcardType ? new iu0((WildcardType) cls) : new tt0(cls);
                }
                fc0 fc0VarE = ((oo) v8Var.e).e(ht0Var, w60.b(2, false, null, 3));
                if (!e.O(fc0VarE)) {
                    fc0 type = fc0VarE;
                    int i2 = 0;
                    while (ub0.z(type)) {
                        type = ((ca1) he.a1(type.K0())).getType();
                        i2++;
                    }
                    od odVarB = type.L0().b();
                    if (odVarB instanceof ai0) {
                        dd ddVarF = ym.f(odVarB);
                        return ddVarF == null ? new m90(new m90.a.C0037a(fc0VarE)) : new m90(ddVarF, i2);
                    }
                    if (odVarB instanceof v91) {
                        return new m90(dd.l(m21.a.a.h()), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override // defpackage.g4
    public final cv e() {
        ja0 ja0Var = i[0];
        return (cv) this.c.invoke();
    }

    @Override // defpackage.g4
    public final t11 g() {
        return this.e;
    }

    @Override // defpackage.g4
    public final fc0 getType() {
        ja0 ja0Var = i[1];
        return (u01) this.d.invoke();
    }

    @Override // defpackage.g4
    public final Map h() {
        ja0 ja0Var = i[2];
        return (Map) this.f.invoke();
    }

    public final String toString() {
        return mm.a.F(this, null);
    }
}
