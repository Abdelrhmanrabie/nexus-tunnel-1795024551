package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ra0 extends b90 implements ja0 {
    public static final Object q = new Object();
    public final p90 g;
    public final String i;
    public final String j;
    public final Object n;
    public final nu0$b o;
    public final nu0$a p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a extends b90 implements u90 {
        @Override // defpackage.b90
        public final p90 j() {
            return p().g;
        }

        @Override // defpackage.b90
        public final boolean n() {
            return p().n();
        }

        public abstract kq0 o();

        public abstract ra0 p();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class b extends a {
        public static final /* synthetic */ ja0[] j;
        public final nu0$a g = ak.c(new a(this, 1));
        public final nu0$b i = new nu0$b(new a(this, 0));

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(b bVar, int i) {
                super(0);
                this.G0 = i;
                this.b = bVar;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                int i = this.G0;
                b bVar = this.b;
                if (i == 0) {
                    return e.b((a) bVar, true);
                }
                pq0 pq0Var = bVar.p().l().B;
                if (pq0Var != null) {
                    return pq0Var;
                }
                nq0 nq0VarL = bVar.p().l();
                return b2.g(nq0VarL, (s4) e4.f47a, true, nq0VarL.g());
            }
        }

        static {
            pu0 pu0Var = ou0.a;
            j = new ja0[]{pu0Var.f(new tq0(pu0Var.b(b.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), pu0Var.f(new tq0(pu0Var.b(b.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public final boolean equals(Object obj) {
            return (obj instanceof b) && e4.a(p(), ((b) obj).p());
        }

        @Override // defpackage.a90
        public final String getName() {
            return fb$1.m(new StringBuilder("<get-"), p().i, '>');
        }

        public final int hashCode() {
            return p().hashCode();
        }

        @Override // defpackage.b90
        public final ta i() {
            ja0 ja0Var = j[1];
            return (ta) this.i.invoke();
        }

        @Override // defpackage.b90
        public final la l() {
            ja0 ja0Var = j[0];
            return (pq0) this.g.invoke();
        }

        @Override // ra0.a
        public final kq0 o() {
            ja0 ja0Var = j[0];
            return (pq0) this.g.invoke();
        }

        public final String toString() {
            return e4.j("getter of ", p());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c extends a {
        public static final /* synthetic */ ja0[] j;
        public final nu0$a g = ak.c(new a(this, 1));
        public final nu0$b i = new nu0$b(new a(this, 0));

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(c cVar, int i) {
                super(0);
                this.G0 = i;
                this.b = cVar;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                int i = this.G0;
                c cVar = this.b;
                if (i == 0) {
                    return e.b((a) cVar, false);
                }
                wq0 wq0Var = cVar.p().l().C;
                if (wq0Var != null) {
                    return wq0Var;
                }
                nq0 nq0VarL = cVar.p().l();
                s4$a$a s4_a_a = e4.f47a;
                return b2.h(nq0VarL, s4_a_a, s4_a_a, true, nq0VarL.getVisibility(), nq0VarL.g());
            }
        }

        static {
            pu0 pu0Var = ou0.a;
            j = new ja0[]{pu0Var.f(new tq0(pu0Var.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), pu0Var.f(new tq0(pu0Var.b(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public final boolean equals(Object obj) {
            return (obj instanceof c) && e4.a(p(), ((c) obj).p());
        }

        @Override // defpackage.a90
        public final String getName() {
            return fb$1.m(new StringBuilder("<set-"), p().i, '>');
        }

        public final int hashCode() {
            return p().hashCode();
        }

        @Override // defpackage.b90
        public final ta i() {
            ja0 ja0Var = j[1];
            return (ta) this.i.invoke();
        }

        @Override // defpackage.b90
        public final la l() {
            ja0 ja0Var = j[0];
            return (wq0) this.g.invoke();
        }

        @Override // ra0.a
        public final kq0 o() {
            ja0 ja0Var = j[0];
            return (wq0) this.g.invoke();
        }

        public final String toString() {
            return e4.j("setter of ", p());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ ra0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(ra0 ra0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = ra0Var;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0077  */
        /* JADX WARN: Code duplicated, block: B:30:0x007b  */
        /* JADX WARN: Code duplicated, block: B:33:0x0089  */
        /* JADX WARN: Code duplicated, block: B:35:0x0095  */
        @Override // defpackage.lw
        public final Object invoke() {
            Object objA1;
            Class<?> enclosingClass;
            bt btVar;
            boolean zF;
            int i = this.G0;
            ra0 ra0Var = this.b;
            boolean z = false;
            if (i == 0) {
                p90 p90Var = ra0Var.g;
                p90Var.getClass();
                String str = ra0Var.i;
                String str2 = ra0Var.j;
                Matcher matcher = ((Pattern) p90.b.b).matcher(str2);
                g gVar = matcher.matches() ? new g(14, matcher, z) : null;
                if (gVar != null) {
                    String str3 = (String) gVar.a().get(1);
                    nq0 nq0VarM = p90Var.m(Integer.parseInt(str3));
                    if (nq0VarM != null) {
                        return nq0VarM;
                    }
                    StringBuilder sbQ = ak.q("Local property #", str3, " not found in ");
                    sbQ.append(p90Var.d());
                    throw new yi(sbQ.toString());
                }
                Collection collectionP = p90Var.p(ij0.f(str));
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionP) {
                    if (e4.a(uw0.b((nq0) obj).a(), str2)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new yi("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + p90Var);
                }
                if (arrayList.size() != 1) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj2 : arrayList) {
                        cn.d visibility = ((nq0) obj2).getVisibility();
                        Object arrayList2 = linkedHashMap.get(visibility);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            linkedHashMap.put(visibility, arrayList2);
                        }
                        ((List) arrayList2).add(obj2);
                    }
                    TreeMap treeMap = new TreeMap(nu.b$1);
                    treeMap.putAll(linkedHashMap);
                    List list = (List) he.S0(treeMap.values());
                    if (list.size() != 1) {
                        String strR0 = he.R0(p90Var.p(ij0.f(str)), "\n", null, null, p0.b$5, 30);
                        StringBuilder sb = new StringBuilder("Property '");
                        sb.append(str);
                        sb.append("' (JVM signature: ");
                        sb.append(str2);
                        sb.append(") not resolved in ");
                        sb.append(p90Var);
                        sb.append(':');
                        sb.append(strR0.length() == 0 ? " no members found" : e4.j("\n", strR0));
                        throw new yi(sb.toString());
                    }
                    objA1 = he.K0(list);
                } else {
                    objA1 = he.a1(arrayList);
                }
                return (nq0) objA1;
            }
            dd ddVar = uw0.a;
            uh uhVarB = uw0.b(ra0Var.l());
            if (uhVarB instanceof v80$c) {
                v80$c v80_c = (v80$c) uhVarB;
                ps psVar = x80.a;
                jj0 jj0Var = v80_c.d;
                fi0 fi0Var = v80_c.e;
                kr0 kr0Var = v80_c.b;
                p80$a p80_aB = x80.b(kr0Var, jj0Var, fi0Var, true);
                if (p80_aB != null) {
                    ao aoVar = v80_c.a;
                    if (aoVar.getKind() != la.a.c) {
                        ok okVarB = aoVar.b();
                        if (xm.l(okVarB)) {
                            ok okVarB2 = okVarB.b();
                            if (xm.n(okVarB2, 1) || xm.n(okVarB2, 3)) {
                                ai0 ai0Var = (ai0) okVarB;
                                LinkedHashSet linkedHashSet = me.a;
                                if (xm.l(ai0Var)) {
                                    LinkedHashSet linkedHashSet2 = me.a;
                                    dd ddVarF = ym.f(ai0Var);
                                    if (linkedHashSet2.contains(ddVarF == null ? null : ddVarF.g())) {
                                        if (xm.l(aoVar.b())) {
                                            btVar = aoVar.D;
                                            if (btVar == null && btVar.getAnnotations().f(q70.a)) {
                                                zF = true;
                                            } else {
                                                zF = aoVar.getAnnotations().f(q70.a);
                                            }
                                            if (zF) {
                                            }
                                        }
                                    }
                                }
                                z = true;
                            } else if (xm.l(aoVar.b())) {
                                btVar = aoVar.D;
                                if (btVar == null) {
                                    zF = aoVar.getAnnotations().f(q70.a);
                                } else {
                                    zF = aoVar.getAnnotations().f(q70.a);
                                }
                                if (zF) {
                                    z = true;
                                }
                            }
                        } else if (xm.l(aoVar.b())) {
                            btVar = aoVar.D;
                            if (btVar == null) {
                                zF = aoVar.getAnnotations().f(q70.a);
                            } else {
                                zF = aoVar.getAnnotations().f(q70.a);
                            }
                            if (zF) {
                                z = true;
                            }
                        }
                    }
                    p90 p90Var2 = ra0Var.g;
                    if (z || x80.d(kr0Var)) {
                        enclosingClass = p90Var2.d().getEnclosingClass();
                    } else {
                        ok okVarB3 = aoVar.b();
                        enclosingClass = okVarB3 instanceof ai0 ? lc1.h((ai0) okVarB3) : p90Var2.d();
                    }
                    if (enclosingClass != null) {
                        try {
                            return enclosingClass.getDeclaredField(p80_aB.a);
                        } catch (NoSuchFieldException unused) {
                        }
                    }
                }
            } else {
                if (uhVarB instanceof v80$a) {
                    return ((v80$a) uhVarB).a;
                }
                if (!(uhVarB instanceof v80$b) && !(uhVarB instanceof v80$d)) {
                    defpackage.d.AnonymousClass0.m();
                    return null;
                }
            }
            return null;
        }
    }

    public ra0(p90 p90Var, String str, String str2, nq0 nq0Var, Object obj) {
        this.g = p90Var;
        this.i = str;
        this.j = str2;
        this.n = obj;
        this.o = new nu0$b(new d(this, 1));
        this.p = new nu0$a(nq0Var, new d(this, 0));
    }

    public ra0(p90 p90Var, nq0 nq0Var) {
        this(p90Var, nq0Var.getName().b(), uw0.b(nq0Var).a(), nq0Var, kotlin.jvm.internal.a.C0035a.b);
    }

    public final boolean equals(Object obj) {
        cv cvVar = lc1.a;
        ra0 ra0Var = null;
        ra0 ra0Var2 = obj instanceof ra0 ? (ra0) obj : null;
        if (ra0Var2 == null) {
            uq0 uq0Var = obj instanceof uq0 ? (uq0) obj : null;
            a90 a90VarCompute = uq0Var == null ? null : uq0Var.compute();
            if (a90VarCompute instanceof ra0) {
                ra0Var = (ra0) a90VarCompute;
            }
        } else {
            ra0Var = ra0Var2;
        }
        return ra0Var != null && e4.a(this.g, ra0Var.g) && e4.a(this.i, ra0Var.i) && e4.a(this.j, ra0Var.j) && e4.a(this.n, ra0Var.n);
    }

    @Override // defpackage.a90
    public final String getName() {
        return this.i;
    }

    public final int hashCode() {
        return this.j.hashCode() + e.d(this.g.hashCode() * 31, this.i);
    }

    @Override // defpackage.b90
    public final ta i() {
        return r().i();
    }

    @Override // defpackage.b90
    public final p90 j() {
        return this.g;
    }

    @Override // defpackage.b90
    public final boolean n() {
        return !e4.a(this.n, kotlin.jvm.internal.a.C0035a.b);
    }

    public final Member o() {
        if (!l().x) {
            return null;
        }
        dd ddVar = uw0.a;
        uh uhVarB = uw0.b(l());
        if (uhVarB instanceof v80$c) {
            v80$c v80_c = (v80$c) uhVarB;
            w80.c cVar = v80_c.c;
            if ((cVar.c & 16) == 16) {
                w80.b bVar = cVar.j;
                int i = bVar.c;
                if ((i & 1) != 1 || (i & 2) != 2) {
                    return null;
                }
                int i2 = bVar.d;
                jj0 jj0Var = v80_c.d;
                return this.g.i(jj0Var.getString(i2), jj0Var.getString(bVar.f));
            }
        }
        return (Field) this.o.invoke();
    }

    @Override // defpackage.b90
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final nq0 l() {
        return (nq0) this.p.invoke();
    }

    public abstract b r();

    public final String toString() {
        nm nmVar = ru0.a;
        return ru0.c(l());
    }
}
