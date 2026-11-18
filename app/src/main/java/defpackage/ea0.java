package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ea0 extends p90 {
    public final Class c;
    public final nu0$b d = new nu0$b(new fa0(this, 0));

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends p90.a {
        public static final /* synthetic */ ja0[] g;
        public final nu0$a c;
        public final nu0$a d;
        public final nu0$b e;
        public final nu0$b f;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ ea0 b;
            public final /* synthetic */ a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(a aVar, ea0 ea0Var, int i) {
                super(0);
                this.G0 = i;
                this.b = ea0Var;
                this.c = aVar;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            @Override // defpackage.lw
            public final Object invoke() {
                String str;
                if (this.G0 == 0) {
                    ja0 ja0Var = a.g[1];
                    return this.b.n((vg0) this.c.d.invoke(), 1);
                }
                ja0 ja0Var2 = a.g[0];
                ju0 ju0Var = (ju0) this.c.c.invoke();
                if (ju0Var == null) {
                    str = null;
                } else {
                    wb0 wb0Var = ju0Var.b;
                    if (wb0Var.a == wb0.a.MULTIFILE_CLASS_PART) {
                        str = wb0Var.f;
                    } else {
                        str = null;
                    }
                }
                if (str == null || str.length() <= 0) {
                    return null;
                }
                return this.b.c.getClassLoader().loadClass(str.replace('/', '.'));
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(a aVar, int i) {
                super(0);
                this.G0 = i;
                this.b = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
            /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Iterable] */
            /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
            @Override // defpackage.lw
            public final Object invoke() throws t30 {
                wb0 wb0Var;
                String[] strArr;
                String[] strArr2;
                ?? SingletonList;
                if (this.G0 == 0) {
                    ja0 ja0Var = a.g[0];
                    ju0 ju0Var = (ju0) this.b.c.invoke();
                    if (ju0Var == null || (strArr = (wb0Var = ju0Var.b).c) == null || (strArr2 = wb0Var.e) == null) {
                        return null;
                    }
                    jo0 jo0VarH = x80.h(strArr, strArr2);
                    return new j81((r80) jo0VarH.b, (ir0) jo0VarH.c, wb0Var.b);
                }
                ja0 ja0Var2 = a.g[0];
                a aVar = this.b;
                ju0 ju0Var2 = (ju0) aVar.c.invoke();
                if (ju0Var2 == null) {
                    return vg0.b.b;
                }
                Class cls = ju0Var2.a;
                ja0 ja0Var3 = p90.a.b[0];
                m6 m6Var = ((sw0) aVar.a.invoke()).b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) m6Var.c;
                dd ddVarA = bt0.a(cls);
                Object objA = concurrentHashMap.get(ddVarA);
                if (objA == null) {
                    cv cvVarH = bt0.a(cls).h();
                    wb0 wb0Var2 = ju0Var2.b;
                    wb0.a aVar2 = wb0Var2.a;
                    wb0.a aVar3 = wb0.a.MULTIFILE_CLASS;
                    if (aVar2 == aVar3) {
                        String[] strArr3 = aVar2 == aVar3 ? wb0Var2.c : null;
                        List listAsList = strArr3 == null ? null : Arrays.asList(strArr3);
                        if (listAsList == null) {
                            listAsList = uq.b;
                        }
                        SingletonList = new ArrayList();
                        Iterator it = listAsList.iterator();
                        while (it.hasNext()) {
                            qz qzVarC = ((ku0) m6Var.b).c(dd.l(new cv(m80.c((String) it.next()).a.replace('/', '.'))));
                            ju0 ju0Var3 = qzVarC == null ? null : (ju0) qzVarC.a;
                            if (ju0Var3 != null) {
                                SingletonList.add(ju0Var3);
                            }
                        }
                    } else {
                        SingletonList = Collections.singletonList(ju0Var2);
                    }
                    tn tnVar = (tn) m6Var.a;
                    fn fnVar = tnVar.a;
                    fnVar.getClass();
                    wq wqVar = new wq(fnVar.b, cvVarH, 0);
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = SingletonList.iterator();
                    while (it2.hasNext()) {
                        zn znVarA = tnVar.a(wqVar, (ju0) it2.next());
                        if (znVarA != null) {
                            arrayList.add(znVarA);
                        }
                    }
                    objA = uh.a(he.g1(arrayList), "package " + cvVarH + " (" + ju0Var2 + ')');
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(ddVarA, objA);
                    if (objPutIfAbsent != null) {
                        objA = objPutIfAbsent;
                    }
                }
                return (vg0) objA;
            }
        }

        static {
            pu0 pu0Var = ou0.a;
            g = new ja0[]{pu0Var.f(new tq0(pu0Var.b(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), pu0Var.f(new tq0(pu0Var.b(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), pu0Var.f(new tq0(pu0Var.b(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), pu0Var.f(new tq0(pu0Var.b(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), pu0Var.f(new tq0(pu0Var.b(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        }

        public a(ea0 ea0Var) {
            super(ea0Var);
            int i = 1;
            this.c = ak.c(new fa0(ea0Var, 1));
            this.d = ak.c(new c(this, i));
            this.e = new nu0$b(new b(this, ea0Var, i));
            int i2 = 0;
            this.f = new nu0$b(new c(this, i2));
            ak.c(new b(this, ea0Var, i2));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class b extends ux implements bx {
        public static final b d = new b(2);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.b(rg0.class);
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // defpackage.bx
        public final Object invoke(Object obj, Object obj2) {
            return ((rg0) obj).f((kr0) obj2);
        }
    }

    public ea0(Class cls) {
        this.c = cls;
    }

    @Override // defpackage.sc
    public final Class d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ea0) {
            return e4.a(this.c, ((ea0) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // defpackage.p90
    public final Collection k() {
        return uq.b;
    }

    @Override // defpackage.p90
    public final Collection l(ij0 ij0Var) {
        a aVar = (a) this.d.invoke();
        aVar.getClass();
        ja0 ja0Var = a.g[1];
        return ((vg0) aVar.d.invoke()).a(ij0Var, dl0.c);
    }

    @Override // defpackage.p90
    public final nq0 m(int i) {
        a aVar = (a) this.d.invoke();
        aVar.getClass();
        ja0 ja0Var = a.g[3];
        j81 j81Var = (j81) aVar.f.invoke();
        if (j81Var == null) {
            return null;
        }
        r80 r80Var = (r80) j81Var.b;
        ir0 ir0Var = (ir0) j81Var.c;
        q80 q80Var = (q80) j81Var.d;
        kr0 kr0Var = (kr0) e.A(ir0Var, w80.n, i);
        if (kr0Var == null) {
            return null;
        }
        return (nq0) lc1.d(this.c, kr0Var, r80Var, new fi0(ir0Var.j), q80Var, b.d);
    }

    @Override // defpackage.p90
    public final Class o() {
        a aVar = (a) this.d.invoke();
        aVar.getClass();
        ja0 ja0Var = a.g[2];
        Class cls = (Class) aVar.e.invoke();
        return cls == null ? this.c : cls;
    }

    @Override // defpackage.p90
    public final Collection p(ij0 ij0Var) {
        a aVar = (a) this.d.invoke();
        aVar.getClass();
        ja0 ja0Var = a.g[1];
        return ((vg0) aVar.d.invoke()).c(ij0Var, dl0.c);
    }

    public final String toString() {
        return e4.j("file class ", bt0.a(this.c).b());
    }
}
