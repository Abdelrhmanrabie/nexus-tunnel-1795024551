package defpackage;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o91 {
    public static final o91 a = new o91();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {
        public static final c b;
        public static final C0042a c;
        public static final d d;
        public static final b f;
        public static final /* synthetic */ a[] g;

        /* JADX INFO: renamed from: o91$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0042a extends a {
            public C0042a() {
                super("ACCEPT_NULL", 1);
            }

            @Override // o91.a
            public final a a(cc1 cc1Var) {
                return a.b(cc1Var);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends a {
            public b() {
                super("NOT_NULL", 3);
            }

            @Override // o91.a
            public final a a(cc1 cc1Var) {
                return this;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends a {
            public c() {
                super("START", 0);
            }

            @Override // o91.a
            public final a a(cc1 cc1Var) {
                return a.b(cc1Var);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class d extends a {
            public d() {
                super("UNKNOWN", 2);
            }

            @Override // o91.a
            public final a a(cc1 cc1Var) {
                a aVarB = a.b(cc1Var);
                return aVarB == a.c ? this : aVarB;
            }
        }

        static {
            c cVar = new c();
            b = cVar;
            C0042a c0042a = new C0042a();
            c = c0042a;
            d dVar = new d();
            d = dVar;
            b bVar = new b();
            f = bVar;
            g = new a[]{cVar, c0042a, dVar, bVar};
        }

        public static a b(cc1 cc1Var) {
            if (cc1Var.M0()) {
                return c;
            }
            if (cc1Var instanceof ml) {
            }
            return e.x(e.s(false, (ld) e.f37g, 24), e.c1(cc1Var), z81.b.a) ? f : d;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }

        public abstract a a(cc1 cc1Var);
    }

    public static ArrayList a(AbstractCollection abstractCollection, bx bxVar) {
        ArrayList<u01> arrayList = new ArrayList(abstractCollection);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u01 u01Var = (u01) it.next();
            if (!arrayList.isEmpty()) {
                for (u01 u01Var2 : arrayList) {
                    if (u01Var2 != u01Var && ((Boolean) bxVar.invoke(u01Var2, u01Var)).booleanValue()) {
                        it.remove();
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12, types: [u01] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [fc0, java.lang.Object, u01] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.LinkedHashSet, java.util.Set] */
    public final u01 b(ArrayList arrayList) {
        Object objZ0;
        arrayList.size();
        ArrayList<u01> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u01 u01Var = (u01) it.next();
            if (u01Var.L0() instanceof j30) {
                Collection collectionD = u01Var.L0().d();
                ArrayList arrayList3 = new ArrayList(ae.y0(collectionD));
                Iterator it2 = collectionD.iterator();
                while (it2.hasNext()) {
                    u01 u01VarS1 = e.s1((fc0) it2.next());
                    if (u01Var.M0()) {
                        u01VarS1 = u01VarS1.P0(true);
                    }
                    arrayList3.add(u01VarS1);
                }
                arrayList2.addAll(arrayList3);
            } else {
                arrayList2.add(u01Var);
            }
        }
        a aVarA = a.b;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            aVarA = aVarA.a((cc1) it3.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (u01 u01VarP0 : arrayList2) {
            if (aVarA == a.f) {
                if (u01VarP0 instanceof tk0) {
                    tk0 tk0Var = (tk0) u01VarP0;
                    u01VarP0 = new tk0(tk0Var.c, tk0Var.d, tk0Var.f, tk0Var.g, tk0Var.i, true);
                }
                u01 u01VarA = b2.a((cc1) u01VarP0);
                u01VarP0 = (u01VarA == null && (u01VarA = e.e1(u01VarP0)) == null) ? u01VarP0.P0(false) : u01VarA;
            }
            linkedHashSet.add(u01VarP0);
        }
        if (linkedHashSet.size() == 1) {
            objZ0 = he.Z0(linkedHashSet);
        } else {
            ArrayList arrayListA = a(linkedHashSet, new q91(2, this, 0));
            arrayListA.isEmpty();
            u01 u01Var2 = null;
            if (!arrayListA.isEmpty()) {
                Iterator it4 = arrayListA.iterator();
                if (!it4.hasNext()) {
                    d.AnonymousClass0.m$3("Empty collection can't be reduced.");
                    return null;
                }
                ?? next = it4.next();
                while (it4.hasNext()) {
                    u01 u01Var3 = (u01) it4.next();
                    next = (u01) next;
                    if (next != 0 && u01Var3 != null) {
                        a91 a91VarL0 = next.L0();
                        a91 a91VarL1 = u01Var3.L0();
                        boolean z = a91VarL0 instanceof c30;
                        if (z && (a91VarL1 instanceof c30)) {
                            LinkedHashSet linkedHashSet2 = ((c30) a91VarL0).c;
                            LinkedHashSet linkedHashSet3 = ((c30) a91VarL1).c;
                            LinkedHashSet linkedHashSetH1 = he.h1(linkedHashSet2);
                            he.C0(linkedHashSet3, linkedHashSetH1);
                            next = e4.h(uq.b, e4.f47a, pr.c("Scope for integer literal type", true), new c30(linkedHashSetH1), false);
                        } else if (z) {
                            if (((c30) a91VarL0).c.contains(u01Var3)) {
                                next = u01Var3;
                            }
                        } else if (!(a91VarL1 instanceof c30) || !((c30) a91VarL1).c.contains(next)) {
                        }
                    }
                    next = 0;
                }
                u01Var2 = (u01) next;
            }
            if (u01Var2 != null) {
                return u01Var2;
            }
            xk0.b.getClass();
            ArrayList arrayListA2 = a(arrayListA, new q91(2, xk0.a.b, 1));
            arrayListA2.isEmpty();
            if (arrayListA2.size() >= 2) {
                return new j30(linkedHashSet).e();
            }
            objZ0 = he.Z0(arrayListA2);
        }
        return (u01) objZ0;
    }
}
