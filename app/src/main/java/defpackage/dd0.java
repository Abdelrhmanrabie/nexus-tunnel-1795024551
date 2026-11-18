package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dd0 extends jd0 {
    public final ai0 n;
    public final qt0 o;
    public final boolean p;
    public final ff0.h q;
    public final ff0.h r;
    public final ff0.h s;
    public final ff0.j t;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends oc0 implements nw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(int i, Object obj, Object obj2) {
            super(1);
            this.G0 = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(Object obj, Object obj2, int i, boolean z) {
            super(1);
            this.G0 = i;
            this.c = obj;
            this.b = obj2;
        }

        /* JADX WARN: Code duplicated, block: B:50:0x00fd  */
        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            qz qzVarC;
            ak hd0_b_a;
            ai0 ai0Var;
            Class<?> cls;
            ju0 ju0VarA;
            int i = this.G0;
            if (i == 0) {
                ij0 ij0Var = (ij0) obj;
                q01 q01Var = (q01) this.b;
                if (q01Var.getName().equals(ij0Var)) {
                    return Collections.singletonList(q01Var);
                }
                dd0 dd0Var = (dd0) this.c;
                return he.X0(dd0.w(dd0Var, ij0Var), dd0.v(dd0Var, ij0Var));
            }
            if (i == 1) {
                int iIntValue = ((Number) obj).intValue();
                s60 s60Var = (s60) ((j91) this.b).a.get(Integer.valueOf(iIntValue));
                return s60Var == null ? (s60) ((i) this.c).invoke(Integer.valueOf(iIntValue)) : s60Var;
            }
            int i2 = 0;
            if (i == 2) {
                ij0 ij0Var2 = (ij0) obj;
                dd0 dd0Var2 = (dd0) this.c;
                boolean zContains = ((Set) dd0Var2.r.invoke()).contains(ij0Var2);
                v8 v8Var = (v8) this.b;
                if (zContains) {
                    ku0 ku0Var = ((c60) v8Var.a).b;
                    ai0 ai0Var2 = dd0Var2.n;
                    qt0 qt0VarC = ku0Var.c(new y40$a(ym.f(ai0Var2).d(ij0Var2), dd0Var2.o, 2));
                    if (qt0VarC != null) {
                        xc0 xc0Var = new xc0(v8Var, ai0Var2, qt0VarC, null);
                        ((c60) v8Var.a).s.getClass();
                        return xc0Var;
                    }
                } else {
                    xt0 xt0Var = (xt0) ((Map) dd0Var2.s.invoke()).get(ij0Var2);
                    if (xt0Var != null) {
                        ff0 ff0Var = ((c60) v8Var.a).a;
                        ed0 ed0Var = new ed0(dd0Var2, i2);
                        ff0Var.getClass();
                        ff0.h hVar = new ff0.h(ff0Var, ed0Var);
                        c60 c60Var = (c60) v8Var.a;
                        ff0 ff0Var2 = c60Var.a;
                        ai0 ai0Var3 = dd0Var2.n;
                        wc0 wc0VarZ = e.Z(v8Var, xt0Var);
                        c60Var.j.getClass();
                        return ir.K0(ff0Var2, ai0Var3, ij0Var2, hVar, wc0VarZ, new tw0$a(xt0Var));
                    }
                }
            } else {
                if (i == 3) {
                    hd0.a aVar = (hd0.a) obj;
                    hd0 hd0Var = (hd0) this.b;
                    fd0 fd0Var = hd0Var.o;
                    dd ddVar = new dd(fd0Var.g, aVar.a);
                    v8 v8Var2 = (v8) this.c;
                    qt0 qt0VarC2 = aVar.b;
                    c60 c60Var2 = (c60) v8Var2.a;
                    if (qt0VarC2 != null) {
                        ku0 ku0Var2 = c60Var2.c;
                        ku0Var2.getClass();
                        try {
                            cls = Class.forName(qt0VarC2.e().b(), false, ku0Var2.a);
                        } catch (ClassNotFoundException unused) {
                            cls = null;
                        }
                        qzVarC = (cls == null || (ju0VarA = e4.a(cls)) == null) ? null : new qz(9, ju0VarA);
                    } else {
                        qzVarC = c60Var2.c.c(ddVar);
                    }
                    ju0 ju0Var = qzVarC == null ? null : (ju0) qzVarC.a;
                    dd ddVarA = ju0Var == null ? null : bt0.a(ju0Var.a);
                    if (ddVarA != null && (!ddVarA.b.e().d() || ddVarA.c)) {
                        return null;
                    }
                    if (ju0Var == null) {
                        hd0_b_a = hd0$b$b.a;
                    } else if (ju0Var.b.a == wb0.a.CLASS) {
                        tn tnVar = ((c60) hd0Var.b.a).d;
                        tnVar.getClass();
                        vc vcVarF = tnVar.f(ju0Var);
                        if (vcVarF == null) {
                            ai0Var = null;
                        } else {
                            fn fnVar = tnVar.a;
                            fnVar.getClass();
                            dd ddVarA2 = bt0.a(ju0Var.a);
                            cd cdVar = fnVar.s;
                            cdVar.getClass();
                            ai0Var = (ai0) cdVar.b.invoke(new cd.a(ddVarA2, vcVarF));
                        }
                        if (ai0Var != null) {
                            hd0_b_a = new hd0$b$a(ai0Var);
                        } else {
                            hd0_b_a = hd0$b$b.a;
                        }
                    } else {
                        hd0_b_a = hd0$b$c.a;
                    }
                    if (hd0_b_a instanceof hd0$b$a) {
                        return ((hd0$b$a) hd0_b_a).a;
                    }
                    if (hd0_b_a instanceof hd0$b$c) {
                        return null;
                    }
                    if (!(hd0_b_a instanceof hd0$b$b)) {
                        d.AnonymousClass0.m();
                        return null;
                    }
                    if (qt0VarC2 == null) {
                        qt0VarC2 = c60Var2.b.c(new y40$a(ddVar, null, 4));
                    }
                    cv cvVarE = qt0VarC2 == null ? null : qt0VarC2.e();
                    if (cvVarE == null || cvVarE.d() || !cvVarE.e().equals(fd0Var.g)) {
                        return null;
                    }
                    xc0 xc0Var2 = new xc0(v8Var2, fd0Var, qt0VarC2, null);
                    c60Var2.s.getClass();
                    return xc0Var2;
                }
                ij0 ij0Var3 = (ij0) obj;
                oo ooVar = (oo) this.b;
                dr0 dr0Var = (dr0) ((LinkedHashMap) ooVar.a).get(ij0Var3);
                if (dr0Var != null) {
                    on onVar = (on) this.c;
                    hn hnVar = onVar.r;
                    return ir.K0(hnVar.a.a, onVar, ij0Var3, (ff0.h) ooVar.c, new in(hnVar.a.a, new qn(i2, onVar, dr0Var)), t11.a);
                }
            }
            return null;
        }
    }

    public dd0(v8 v8Var, ai0 ai0Var, qt0 qt0Var, boolean z, dd0 dd0Var) {
        super(v8Var, dd0Var);
        this.n = ai0Var;
        this.o = qt0Var;
        this.p = z;
        ff0 ff0Var = ((c60) v8Var.a).a;
        qn qnVar = new qn(3, this, v8Var);
        ff0Var.getClass();
        this.q = new ff0.h(ff0Var, qnVar);
        int i = 2;
        this.r = new ff0.h(ff0Var, new ed0(this, i));
        this.s = new ff0.h(ff0Var, new ed0(this, 1));
        this.t = ff0Var.d(new c(this, v8Var, i, false));
    }

    public static q01 C(q01 q01Var, ox oxVar, AbstractCollection abstractCollection) {
        if (abstractCollection.isEmpty()) {
            return q01Var;
        }
        Iterator it = abstractCollection.iterator();
        while (it.hasNext()) {
            q01 q01Var2 = (q01) it.next();
            if (!e4.a(q01Var, q01Var2) && q01Var2.H == null && F(q01Var2, oxVar)) {
                return (q01) q01Var.s().k().mo7build();
            }
        }
        return q01Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static q01 D(q01 q01Var) {
        cv cvVarH;
        wc1 wc1Var = (wc1) he.U0(q01Var.f());
        if (wc1Var != null) {
            od odVarB = wc1Var.getType().L0().b();
            if (odVarB == null) {
                cvVarH = null;
            } else {
                int i = ym.$r8$clinit;
                dv dvVarG = xm.g(odVarB);
                if (!dvVarG.e()) {
                    dvVarG = null;
                }
                if (dvVarG == null) {
                    cvVarH = null;
                } else {
                    cvVarH = dvVarG.h();
                }
            }
            if (!e4.a(cvVarH, m21.d)) {
                wc1Var = null;
            }
        } else {
            wc1Var = null;
        }
        if (wc1Var == null) {
            return null;
        }
        ox.a aVarS = q01Var.s();
        List listF = q01Var.f();
        int size = listF.size() - 1;
        if (size < 0) {
            size = 0;
        }
        q01 q01Var2 = (q01) aVarS.a(he.e1(listF, size)).p(((ca1) wc1Var.getType().K0().get(0)).getType()).mo7build();
        if (q01Var2 == null) {
            return q01Var2;
        }
        q01Var2.A = true;
        return q01Var2;
    }

    public static boolean F(q01 q01Var, ox oxVar) {
        int iC = pn0.d.n(oxVar, q01Var, true).c();
        if (iC != 0) {
            return iC == 1 && !b2.a(oxVar, q01Var);
        }
        throw new NullPointerException(ak.j("DEFAULT.isOverridableByW…iptor, this, true).result", " must not be null"));
    }

    public static boolean G(q01 q01Var, q01 q01Var2) {
        int i = z9.$r8$clinit;
        if (q01Var.getName().b().equals("removeAt") && e4.a(e.p(q01Var), c21.h.b)) {
            q01Var2 = q01Var2.V0();
        }
        return F(q01Var2, q01Var);
    }

    public static q01 H(nq0 nq0Var, String str, nw nwVar) {
        q01 q01Var;
        Iterator it = ((Iterable) nwVar.invoke(ij0.f(str))).iterator();
        do {
            q01Var = null;
            if (!it.hasNext()) {
                break;
            }
            q01 q01Var2 = (q01) it.next();
            if (q01Var2.f().size() == 0) {
                yk0 yk0Var = gc0.a;
                fc0 fc0Var = q01Var2.j;
                if (fc0Var == null ? false : yk0Var.e(fc0Var, nq0Var.getType())) {
                    q01Var = q01Var2;
                }
            }
        } while (q01Var == null);
        return q01Var;
    }

    public static q01 J(nq0 nq0Var, nw nwVar) {
        q01 q01Var;
        fc0 fc0Var;
        String strB = nq0Var.getName().b();
        Iterator it = ((Iterable) nwVar.invoke(ij0.f(e4.j("set", q70.c(strB) ? strB.substring(2) : e.f(strB))))).iterator();
        do {
            q01Var = null;
            if (!it.hasNext()) {
                break;
            }
            q01 q01Var2 = (q01) it.next();
            if (q01Var2.f().size() == 1 && (fc0Var = q01Var2.j) != null) {
                ij0 ij0Var = ub0.e;
                if (ub0.E(fc0Var, m21.a.d) && gc0.a.c(((wc1) he.a1(q01Var2.f())).getType(), nq0Var.getType())) {
                    q01Var = q01Var2;
                }
            }
        } while (q01Var == null);
        return q01Var;
    }

    public static final ArrayList v(dd0 dd0Var, ij0 ij0Var) {
        Collection collectionF = ((vk) dd0Var.e.invoke()).f(ij0Var);
        ArrayList arrayList = new ArrayList(ae.y0(collectionF));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(dd0Var.t((au0) it.next()));
        }
        return arrayList;
    }

    public static final ArrayList w(dd0 dd0Var, ij0 ij0Var) {
        LinkedHashSet linkedHashSetK = dd0Var.K(ij0Var);
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetK) {
            q01 q01Var = (q01) obj;
            if (b2.b((la) q01Var) == null && aa.a(q01Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void A(Set set, AbstractCollection abstractCollection, o11 o11Var, nw nwVar) {
        wq0 wq0VarH;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            nq0 nq0Var = (nq0) it.next();
            l50 l50Var = null;
            if (E(nq0Var, nwVar)) {
                q01 q01VarI = I(nq0Var, nwVar);
                q01 q01VarJ = nq0Var.i ? J(nq0Var, nwVar) : null;
                if (q01VarJ != null) {
                    q01VarJ.p();
                    q01VarI.p();
                }
                l50 l50Var2 = new l50(this.n, e4.f47a, q01VarI.p(), q01VarI.getVisibility(), q01VarJ != null, nq0Var.getName(), q01VarI.g(), null, la.a.b, false, null);
                l50Var2.N0(q01VarI.j, uq.b, p(), null);
                pq0 pq0VarG = b2.g((nq0) l50Var2, q01VarI.getAnnotations(), false, q01VarI.g());
                pq0VarG.r = q01VarI;
                pq0VarG.s = l50Var2.getType();
                if (q01VarJ != null) {
                    wc1 wc1Var = (wc1) he.M0(q01VarJ.f());
                    if (wc1Var == null) {
                        throw new AssertionError(e4.j("No parameter found for ", q01VarJ));
                    }
                    wq0VarH = b2.h(l50Var2, q01VarJ.getAnnotations(), wc1Var.getAnnotations(), false, q01VarJ.getVisibility(), q01VarJ.g());
                    wq0VarH.r = q01VarJ;
                } else {
                    wq0VarH = null;
                }
                l50Var2.L0(pq0VarG, wq0VarH, null, null);
                l50Var = l50Var2;
            }
            if (l50Var != null) {
                abstractCollection.add(l50Var);
                if (o11Var == null) {
                    return;
                }
                o11Var.add(nq0Var);
                return;
            }
        }
    }

    public final boolean E(nq0 nq0Var, nw nwVar) {
        if (nq0Var.B == null) {
            return false;
        }
        q01 q01VarI = I(nq0Var, nwVar);
        q01 q01VarJ = J(nq0Var, nwVar);
        if (q01VarI == null) {
            return false;
        }
        if (nq0Var.i) {
            return q01VarJ != null && q01VarJ.p() == q01VarI.p();
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    public final q01 I(nq0 nq0Var, nw nwVar) {
        ij0 ij0Var;
        pq0 pq0Var = nq0Var.B;
        String strB = null;
        pq0 pq0Var2 = pq0Var == null ? null : (pq0) b2.b((la) pq0Var);
        if (pq0Var2 != null) {
            ub0.A(pq0Var2);
            la laVarB = ym.b(ym.l(pq0Var2), ba.b$27);
            if (laVarB != null && (ij0Var = (ij0) ca.a.get(ym.g(laVarB))) != null) {
                strB = ij0Var.b();
            }
        }
        return (strB == null || b2.d(this.n, pq0Var2)) ? H(nq0Var, q70.a(nq0Var.getName().b()), nwVar) : H(nq0Var, strB, nwVar);
    }

    public final LinkedHashSet K(ij0 ij0Var) {
        boolean z = this.p;
        ai0 ai0Var = this.n;
        if (!z) {
            ((yk0) ((c60) this.b.a).u).getClass();
        }
        Collection collectionD = ai0Var.h().d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            he.C0(((fc0) it.next()).m().a(ij0Var, dl0.g), linkedHashSet);
        }
        return linkedHashSet;
    }

    public final Set L(ij0 ij0Var) {
        boolean z = this.p;
        ai0 ai0Var = this.n;
        if (!z) {
            ((yk0) ((c60) this.b.a).u).getClass();
        }
        Collection collectionD = ai0Var.h().d();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            Collection collectionC = ((fc0) it.next()).m().c(ij0Var, dl0.g);
            ArrayList arrayList2 = new ArrayList(ae.y0(collectionC));
            Iterator it2 = collectionC.iterator();
            while (it2.hasNext()) {
                arrayList2.add((nq0) it2.next());
            }
            he.C0(arrayList2, arrayList);
        }
        return he.i1((Iterable) arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[LOOP:2: B:64:0x0125->B:118:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x017b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x01cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ba A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:66:0x012b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0139  */
    /* JADX WARN: Code duplicated, block: B:72:0x0148  */
    /* JADX WARN: Code duplicated, block: B:75:0x015f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0177  */
    /* JADX WARN: Code duplicated, block: B:85:0x0181  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c0  */
    public final boolean N(q01 q01Var) {
        List listD0;
        List list;
        q01 q01VarD;
        LinkedHashSet<q01> linkedHashSetK;
        ArrayList<ox> arrayList;
        Iterator it;
        ox oxVarA;
        ArrayList arrayList2;
        q01 q01Var2;
        Iterator it2;
        ij0 name = q01Var.getName();
        String strB = name.b();
        cv cvVar = q70.a;
        int i = 0;
        boolean z = strB.startsWith("get") || strB.startsWith("is");
        List<ij0> list2 = uq.b;
        if (z) {
            ij0 ij0VarI = e.I(name, "get", null, 12);
            if (ij0VarI == null) {
                ij0VarI = e.I(name, "is", null, 8);
            }
            listD0 = e.Z(ij0VarI);
        } else if (strB.startsWith("set")) {
            listD0 = ae.D0(new ij0[]{e.I(name, "set", null, 4), e.I(name, "set", "is", 4)});
        } else {
            listD0 = (List) ca.b.get(name);
            if (listD0 == null) {
                listD0 = list2;
            }
        }
        if (listD0 != null && listD0.isEmpty()) {
            ArrayList arrayList3 = c21.b;
            list = (List) c21.l.get(q01Var.getName());
            if (list != null) {
                list2 = list;
            }
            if (list2.isEmpty()) {
                int i2 = aa.$r8$clinit;
                if (!c21.f.contains(q01Var.getName())) {
                    q01VarD = D(q01Var);
                    if (q01VarD != null) {
                        linkedHashSetK = K(q01Var.getName());
                        if (!linkedHashSetK.isEmpty()) {
                            for (q01 q01Var3 : linkedHashSetK) {
                                if (q01Var3.isSuspend()) {
                                }
                            }
                        }
                    }
                    return true;
                }
                LinkedHashSet linkedHashSetK2 = K(q01Var.getName());
                arrayList = new ArrayList();
                it = linkedHashSetK2.iterator();
                while (it.hasNext()) {
                    oxVarA = aa.a((q01) it.next());
                    if (oxVarA == null) {
                        arrayList.add(oxVarA);
                    }
                }
                if (arrayList.isEmpty()) {
                    q01VarD = D(q01Var);
                    if (q01VarD != null) {
                        linkedHashSetK = K(q01Var.getName());
                        if (!linkedHashSetK.isEmpty()) {
                            while (r12.hasNext()) {
                                if (q01Var3.isSuspend()) {
                                }
                            }
                        }
                    }
                    return true;
                }
                for (ox oxVar : arrayList) {
                    if (e.o(q01Var, 2).equals(e.o(oxVar.a(), 2))) {
                    }
                }
                q01VarD = D(q01Var);
                if (q01VarD != null) {
                    linkedHashSetK = K(q01Var.getName());
                    if (!linkedHashSetK.isEmpty()) {
                        while (r12.hasNext()) {
                            if (q01Var3.isSuspend()) {
                            }
                        }
                    }
                }
                return true;
            }
            for (ij0 ij0Var : list2) {
                LinkedHashSet linkedHashSetK3 = K(ij0Var);
                arrayList2 = new ArrayList();
                for (Object obj : linkedHashSetK3) {
                    if (b2.b((la) obj) != null) {
                        arrayList2.add(obj);
                    }
                }
                if (arrayList2.isEmpty()) {
                    ox.a aVarS = q01Var.s();
                    aVarS.q(ij0Var);
                    aVarS.r();
                    aVarS.o();
                    q01Var2 = (q01) aVarS.mo7build();
                    if (arrayList2.isEmpty()) {
                        continue;
                    } else {
                        it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (G((q01) it2.next(), q01Var2)) {
                            }
                        }
                    }
                }
            }
            int i3 = aa.$r8$clinit;
            if (!c21.f.contains(q01Var.getName())) {
                q01VarD = D(q01Var);
                if (q01VarD != null) {
                    linkedHashSetK = K(q01Var.getName());
                    if (!linkedHashSetK.isEmpty()) {
                        while (r12.hasNext()) {
                            if (q01Var3.isSuspend()) {
                            }
                        }
                    }
                }
                return true;
            }
            LinkedHashSet linkedHashSetK4 = K(q01Var.getName());
            arrayList = new ArrayList();
            it = linkedHashSetK4.iterator();
            while (it.hasNext()) {
                oxVarA = aa.a((q01) it.next());
                if (oxVarA == null) {
                    arrayList.add(oxVarA);
                }
            }
            if (arrayList.isEmpty()) {
                q01VarD = D(q01Var);
                if (q01VarD != null) {
                    linkedHashSetK = K(q01Var.getName());
                    if (!linkedHashSetK.isEmpty()) {
                        while (r12.hasNext()) {
                            if (q01Var3.isSuspend()) {
                            }
                        }
                    }
                }
                return true;
            }
            while (r0.hasNext()) {
                if (e.o(q01Var, 2).equals(e.o(oxVar.a(), 2))) {
                }
            }
            q01VarD = D(q01Var);
            if (q01VarD != null) {
                linkedHashSetK = K(q01Var.getName());
                if (!linkedHashSetK.isEmpty()) {
                    while (r12.hasNext()) {
                        if (q01Var3.isSuspend()) {
                        }
                    }
                }
            }
            return true;
        }
        Iterator it3 = listD0.iterator();
        while (it3.hasNext()) {
            Set<nq0> setL = L((ij0) it3.next());
            if (!setL.isEmpty()) {
                for (nq0 nq0Var : setL) {
                    if (!E(nq0Var, new c(i, q01Var, this)) || (!nq0Var.i && q01Var.getName().b().startsWith("set"))) {
                    }
                }
            }
        }
        ArrayList arrayList4 = c21.b;
        list = (List) c21.l.get(q01Var.getName());
        if (list != null) {
            list2 = list;
        }
        if (list2.isEmpty()) {
            int i4 = aa.$r8$clinit;
            if (!c21.f.contains(q01Var.getName())) {
                q01VarD = D(q01Var);
                if (q01VarD != null) {
                    linkedHashSetK = K(q01Var.getName());
                    if (!linkedHashSetK.isEmpty()) {
                        while (r12.hasNext()) {
                            if (q01Var3.isSuspend() || !F(q01VarD, q01Var3)) {
                            }
                        }
                    }
                }
                return true;
            }
            LinkedHashSet linkedHashSetK5 = K(q01Var.getName());
            arrayList = new ArrayList();
            it = linkedHashSetK5.iterator();
            while (it.hasNext()) {
                oxVarA = aa.a((q01) it.next());
                if (oxVarA == null) {
                    arrayList.add(oxVarA);
                }
            }
            if (arrayList.isEmpty()) {
                q01VarD = D(q01Var);
                if (q01VarD != null) {
                    linkedHashSetK = K(q01Var.getName());
                    if (!linkedHashSetK.isEmpty()) {
                        while (r12.hasNext()) {
                            if (q01Var3.isSuspend()) {
                            }
                        }
                    }
                }
                return true;
            }
            while (r0.hasNext()) {
                if (e.o(q01Var, 2).equals(e.o(oxVar.a(), 2)) || F(q01Var, oxVar)) {
                }
            }
            q01VarD = D(q01Var);
            if (q01VarD != null) {
                linkedHashSetK = K(q01Var.getName());
                if (!linkedHashSetK.isEmpty()) {
                    while (r12.hasNext()) {
                        if (q01Var3.isSuspend()) {
                        }
                    }
                }
            }
            return true;
        }
        while (r0.hasNext()) {
            LinkedHashSet linkedHashSetK6 = K(ij0Var);
            arrayList2 = new ArrayList();
            while (r2.hasNext()) {
                if (b2.b((la) obj) != null) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.isEmpty()) {
                ox.a aVarS2 = q01Var.s();
                aVarS2.q(ij0Var);
                aVarS2.r();
                aVarS2.o();
                q01Var2 = (q01) aVarS2.mo7build();
                if (arrayList2.isEmpty()) {
                    continue;
                } else {
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (G((q01) it2.next(), q01Var2)) {
                        }
                    }
                }
            }
        }
        int i5 = aa.$r8$clinit;
        if (!c21.f.contains(q01Var.getName())) {
            q01VarD = D(q01Var);
            if (q01VarD != null) {
                linkedHashSetK = K(q01Var.getName());
                if (!linkedHashSetK.isEmpty()) {
                    while (r12.hasNext()) {
                        if (q01Var3.isSuspend()) {
                        }
                    }
                }
            }
            return true;
        }
        LinkedHashSet linkedHashSetK7 = K(q01Var.getName());
        arrayList = new ArrayList();
        it = linkedHashSetK7.iterator();
        while (it.hasNext()) {
            oxVarA = aa.a((q01) it.next());
            if (oxVarA == null) {
                arrayList.add(oxVarA);
            }
        }
        if (arrayList.isEmpty()) {
            q01VarD = D(q01Var);
            if (q01VarD != null) {
                linkedHashSetK = K(q01Var.getName());
                if (!linkedHashSetK.isEmpty()) {
                    while (r12.hasNext()) {
                        if (q01Var3.isSuspend()) {
                        }
                    }
                }
            }
            return true;
        }
        while (r0.hasNext()) {
            if (e.o(q01Var, 2).equals(e.o(oxVar.a(), 2))) {
            }
        }
        q01VarD = D(q01Var);
        if (q01VarD != null) {
            linkedHashSetK = K(q01Var.getName());
            if (!linkedHashSetK.isEmpty()) {
                while (r12.hasNext()) {
                    if (q01Var3.isSuspend()) {
                    }
                }
            }
        }
        return true;
        return false;
    }

    @Override // defpackage.jd0, defpackage.wg0, defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        Object obj = this.b.a;
        return super.a(ij0Var, dl0Var);
    }

    @Override // defpackage.jd0, defpackage.wg0, defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        Object obj = this.b.a;
        return super.c(ij0Var, dl0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        Object obj = this.b.a;
        dd0 dd0Var = (dd0) this.c;
        zc zcVar = dd0Var == null ? null : (zc) dd0Var.t.invoke(ij0Var);
        return zcVar == null ? (od) this.t.invoke(ij0Var) : zcVar;
    }

    @Override // defpackage.jd0
    public final Set h(lm lmVar, p0 p0Var) {
        return nz0.x1((Set) this.r.invoke(), ((Map) this.s.invoke()).keySet());
    }

    @Override // defpackage.jd0
    public final Set i(lm lmVar, p0 p0Var) {
        Collection collectionD = this.n.h().d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            he.C0(((fc0) it.next()).m().b(), linkedHashSet);
        }
        ff0.h hVar = this.e;
        linkedHashSet.addAll(((vk) hVar.invoke()).a());
        linkedHashSet.addAll(((vk) hVar.invoke()).c());
        linkedHashSet.addAll(h(lmVar, p0Var));
        ((c60) this.b.a).x.getClass();
        linkedHashSet.addAll(new ArrayList());
        return linkedHashSet;
    }

    @Override // defpackage.jd0
    public final void j(ij0 ij0Var, ArrayList arrayList) throws IllegalAccessException, InvocationTargetException {
        boolean zO = this.o.o();
        v8 v8Var = this.b;
        if (zO) {
            ff0.h hVar = this.e;
            if (((vk) hVar.invoke()).e(ij0Var) != null) {
                if (arrayList.isEmpty()) {
                    eu0 eu0VarE = ((vk) hVar.invoke()).e(ij0Var);
                    wc0 wc0VarZ = e.Z(v8Var, eu0VarE);
                    ij0 name = eu0VarE.getName();
                    c60 c60Var = (c60) v8Var.a;
                    c60Var.j.getClass();
                    q50 q50VarY0 = q50.Y0(this.n, wc0VarZ, name, new tw0$a(eu0VarE), true);
                    fc0 fc0VarE = ((oo) v8Var.e).e(eu0VarE.getType(), w60.b(2, false, null, 2));
                    sc0 sc0VarP = p();
                    zh0 zh0Var = zh0.d;
                    cn.d dVar = cn.e;
                    uq uqVar = uq.b;
                    q50VarY0.X0(null, sc0VarP, uqVar, uqVar, fc0VarE, zh0Var, dVar, null);
                    q50VarY0.J = 1;
                    c60Var.g.getClass();
                    arrayList.add(q50VarY0);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((q01) it.next()).f().isEmpty()) {
                        }
                    }
                    eu0 eu0VarE2 = ((vk) hVar.invoke()).e(ij0Var);
                    wc0 wc0VarZ2 = e.Z(v8Var, eu0VarE2);
                    ij0 name2 = eu0VarE2.getName();
                    c60 c60Var2 = (c60) v8Var.a;
                    c60Var2.j.getClass();
                    q50 q50VarY1 = q50.Y0(this.n, wc0VarZ2, name2, new tw0$a(eu0VarE2), true);
                    fc0 fc0VarE2 = ((oo) v8Var.e).e(eu0VarE2.getType(), w60.b(2, false, null, 2));
                    sc0 sc0VarP2 = p();
                    zh0 zh0Var2 = zh0.d;
                    cn.d dVar2 = cn.e;
                    uq uqVar2 = uq.b;
                    q50VarY1.X0(null, sc0VarP2, uqVar2, uqVar2, fc0VarE2, zh0Var2, dVar2, null);
                    q50VarY1.J = 1;
                    c60Var2.g.getClass();
                    arrayList.add(q50VarY1);
                }
            }
        }
        ((c60) v8Var.a).x.getClass();
    }

    @Override // defpackage.jd0
    public final vk k() {
        return new xc(this.o, p0.b$17);
    }

    @Override // defpackage.jd0
    public final void m(LinkedHashSet linkedHashSet, ij0 ij0Var) {
        LinkedHashSet linkedHashSetK = K(ij0Var);
        if (!c21.k.contains(ij0Var)) {
            int i = aa.$r8$clinit;
            if (!c21.f.contains(ij0Var)) {
                if (!linkedHashSetK.isEmpty()) {
                    Iterator it = linkedHashSetK.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((ox) it.next()).isSuspend()) {
                            }
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : linkedHashSetK) {
                    if (N((q01) obj)) {
                        arrayList.add(obj);
                    }
                }
                y(linkedHashSet, ij0Var, arrayList, false);
                return;
            }
        }
        o11 o11Var = new o11();
        LinkedHashSet linkedHashSetM1 = e.m1(ij0Var, linkedHashSetK, uq.b, this.n, mr.a, ((yk0) ((c60) this.b.a).u).e);
        z(ij0Var, linkedHashSet, linkedHashSetM1, linkedHashSet, new n4(1, this, 5));
        z(ij0Var, linkedHashSet, linkedHashSetM1, o11Var, new n4(1, this, 1));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : linkedHashSetK) {
            if (N((q01) obj2)) {
                arrayList2.add(obj2);
            }
        }
        y(linkedHashSet, ij0Var, he.X0(o11Var, arrayList2), true);
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, rc0] */
    @Override // defpackage.jd0
    public final void n(ij0 ij0Var, ArrayList arrayList) {
        Set linkedHashSet;
        au0 au0Var;
        boolean zIsAnnotation = this.o.a.isAnnotation();
        v8 v8Var = this.b;
        if (zIsAnnotation && (au0Var = (au0) he.b1(((vk) this.e.invoke()).f(ij0Var))) != null) {
            wc0 wc0VarZ = e.Z(v8Var, au0Var);
            cn.d dVarF0 = e.f0(b2.a((bu0) au0Var));
            ij0 name = au0Var.getName();
            ((c60) v8Var.a).j.getClass();
            y50 y50VarO0 = y50.O0(this.n, wc0VarZ, dVarF0, false, name, new tw0$a(au0Var), false);
            pq0 pq0VarG = b2.g((nq0) y50VarO0, (s4) e4.f47a, true, y50VarO0.g());
            y50VarO0.L0(pq0VarG, null, null, null);
            v8 v8Var2 = new v8((c60) v8Var.a, new ud0(v8Var, y50VarO0, au0Var, 0), v8Var.c);
            fc0 fc0VarE = ((oo) v8Var2.e).e(au0Var.C(), w60.b(2, au0Var.a.getDeclaringClass().isAnnotation(), null, 2));
            y50VarO0.N0(fc0VarE, uq.b, p(), null);
            pq0VarG.s = fc0VarE;
            arrayList.add(y50VarO0);
        }
        Set setL = L(ij0Var);
        if (setL.isEmpty()) {
            return;
        }
        o11 o11Var = new o11();
        o11 o11Var2 = new o11();
        A(setL, arrayList, o11Var, new bd0(this, 0));
        if (o11Var.isEmpty()) {
            linkedHashSet = he.i1(setL);
        } else {
            linkedHashSet = new LinkedHashSet();
            for (Object obj : setL) {
                if (!o11Var.contains(obj)) {
                    linkedHashSet.add(obj);
                }
            }
        }
        A(linkedHashSet, o11Var2, null, new bd0(this, 1));
        LinkedHashSet linkedHashSetX1 = nz0.x1(setL, o11Var2);
        c60 c60Var = (c60) v8Var.a;
        arrayList.addAll(e.m1(ij0Var, linkedHashSetX1, arrayList, this.n, c60Var.f, ((yk0) c60Var.u).e));
    }

    @Override // defpackage.jd0
    public final Set o() {
        if (this.o.a.isAnnotation()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((vk) this.e.invoke()).d());
        Iterator it = this.n.h().d().iterator();
        while (it.hasNext()) {
            he.C0(((fc0) it.next()).m().d(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // defpackage.jd0
    public final sc0 p() {
        ai0 ai0Var = this.n;
        if (ai0Var != null) {
            int i = xm.$r8$clinit;
            return ai0Var.J0();
        }
        xm.a(0);
        throw null;
    }

    @Override // defpackage.jd0
    public final ok q() {
        return this.n;
    }

    @Override // defpackage.jd0
    public final boolean r(q50 q50Var) {
        if (this.o.a.isAnnotation()) {
            return false;
        }
        return N(q50Var);
    }

    @Override // defpackage.jd0
    public final jd0.a s(ArrayList arrayList, fc0 fc0Var, List list) {
        ((k01.a) ((c60) this.b.a).e).getClass();
        if (this.n == null) {
            ak.AnonymousClass1.m("Argument for @NotNull parameter 'owner' of kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1.resolvePropagatedSignature must not be null");
            return null;
        }
        List list2 = Collections.EMPTY_LIST;
        if (list2 != null) {
            return new jd0.a(list, arrayList, list2, fc0Var);
        }
        d.AnonymousClass0.m$4("Argument for @NotNull parameter 'signatureErrors' of kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature.<init> must not be null");
        return null;
    }

    @Override // defpackage.jd0
    public final String toString() {
        return e4.j("Lazy Java member scope for ", this.o.e());
    }

    public final void x(ArrayList arrayList, v40 v40Var, int i, au0 au0Var, fc0 fc0Var, fc0 fc0Var2) {
        dt0 st0Var;
        s4$a$a s4_a_a = e4.f47a;
        ij0 name = au0Var.getName();
        if (fc0Var == null) {
            ma1.a(2);
            throw null;
        }
        cc1 cc1VarJ = ma1.j(fc0Var, false);
        Object defaultValue = au0Var.a.getDefaultValue();
        if (defaultValue == null) {
            st0Var = null;
        } else {
            Class<?> cls = defaultValue.getClass();
            List list = bt0.a;
            if (Enum.class.isAssignableFrom(cls)) {
                st0Var = new wt0(null, (Enum) defaultValue);
            } else if (defaultValue instanceof Annotation) {
                st0Var = new et0(null, (Annotation) defaultValue);
            } else if (defaultValue instanceof Object[]) {
                st0Var = new gt0(null, (Object[]) defaultValue);
            } else {
                st0Var = defaultValue instanceof Class ? new st0(null, (Class) defaultValue) : new yt0(defaultValue, null);
            }
        }
        boolean z = st0Var != null;
        cc1 cc1VarJ2 = fc0Var2 != null ? ma1.j(fc0Var2, false) : null;
        ((c60) this.b.a).j.getClass();
        arrayList.add(new wc1(v40Var, null, i, s4_a_a, name, cc1VarJ, z, false, false, cc1VarJ2, new tw0$a(au0Var)));
    }

    public final void y(LinkedHashSet linkedHashSet, ij0 ij0Var, ArrayList arrayList, boolean z) {
        c60 c60Var = (c60) this.b.a;
        LinkedHashSet<q01> linkedHashSetM1 = e.m1(ij0Var, arrayList, linkedHashSet, this.n, c60Var.f, ((yk0) c60Var.u).e);
        if (!z) {
            linkedHashSet.addAll(linkedHashSetM1);
            return;
        }
        ArrayList arrayListX0 = he.X0(linkedHashSetM1, linkedHashSet);
        ArrayList arrayList2 = new ArrayList(ae.y0(linkedHashSetM1));
        for (q01 q01VarC : linkedHashSetM1) {
            la laVarB = b2.b((la) q01VarC);
            if (laVarB == null) {
                int i = aa.$r8$clinit;
                laVarB = !c21.f.contains(q01VarC.getName()) ? null : ym.b(q01VarC, ba.b$3);
            }
            q01 q01Var = (q01) laVarB;
            if (q01Var != null) {
                q01VarC = C(q01VarC, q01Var, arrayListX0);
            }
            arrayList2.add(q01VarC);
        }
        linkedHashSet.addAll(arrayList2);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void z(ij0 ij0Var, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, AbstractSet abstractSet, nw nwVar) {
        q01 q01VarC;
        q01 q01VarC2;
        Object next;
        q01 q01Var;
        Iterator it = linkedHashSet2.iterator();
        while (it.hasNext()) {
            q01 q01Var2 = (q01) it.next();
            q01 q01Var3 = (q01) b2.b((la) q01Var2);
            q01 q01Var4 = null;
            if (q01Var3 == null) {
                q01VarC = null;
                break;
            }
            Iterator it2 = ((Collection) nwVar.invoke(ij0.f(b2.a((ox) q01Var3)))).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    q01VarC = null;
                    break;
                }
                ox.a aVarS = ((q01) it2.next()).s();
                aVarS.q(ij0Var);
                aVarS.r();
                aVarS.o();
                q01 q01Var5 = (q01) aVarS.mo7build();
                if (G(q01Var3, q01Var5)) {
                    q01VarC = C(q01Var5, q01Var3, linkedHashSet);
                    break;
                }
            }
            e.s0(abstractSet, q01VarC);
            ox oxVarA = aa.a(q01Var2);
            if (oxVarA == 0) {
                q01VarC2 = null;
            } else {
                Iterator it3 = ((Iterable) nwVar.invoke(((pk) oxVarA).getName())).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    q01 q01Var6 = (q01) next;
                    if (e.o(q01Var6, 2).equals(e.o(oxVarA.a(), 2)) && !F(q01Var6, oxVarA)) {
                        break;
                    }
                }
                q01 q01Var7 = (q01) next;
                if (q01Var7 == null) {
                    q01Var = null;
                } else {
                    ox.a aVarS2 = q01Var7.s();
                    List<wc1> listF = oxVarA.f();
                    ArrayList arrayList = new ArrayList(ae.y0(listF));
                    for (wc1 wc1Var : listF) {
                        arrayList.add(new tc1(wc1Var.getType(), wc1Var.B0()));
                    }
                    aVarS2.a(e.I0(arrayList, q01Var7.f(), oxVarA));
                    aVarS2.r();
                    aVarS2.o();
                    Boolean bool = Boolean.TRUE;
                    aVarS2.mo6b();
                    q01Var = (q01) aVarS2.mo7build();
                }
                if (q01Var != null) {
                    if (!N(q01Var)) {
                        q01Var = null;
                    }
                    if (q01Var == null) {
                        q01VarC2 = null;
                    } else {
                        q01VarC2 = C(q01Var, oxVarA, linkedHashSet);
                    }
                } else {
                    q01VarC2 = null;
                }
            }
            e.s0(abstractSet, q01VarC2);
            if (q01Var2.isSuspend()) {
                Iterator it4 = ((Iterable) nwVar.invoke(q01Var2.getName())).iterator();
                while (it4.hasNext()) {
                    q01 q01VarD = D((q01) it4.next());
                    if (q01VarD == null || !F(q01VarD, q01Var2)) {
                        q01VarD = null;
                    }
                    if (q01VarD != null) {
                        q01Var4 = q01VarD;
                        break;
                    }
                }
            }
            e.s0(abstractSet, q01Var4);
        }
    }
}
