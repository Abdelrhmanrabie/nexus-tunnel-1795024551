package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class on extends k implements ok {
    public final ff0.h A;
    public final ff0.f B;
    public final vr0$a C;
    public final s4 D;
    public final zq0 g;
    public final y8 i;
    public final t11 j;
    public final dd n;
    public final zh0 o;
    public final cn.d p;
    public final int q;
    public final hn r;
    public final wg0 s;
    public final b t;
    public final gy0 u;
    public final oo v;
    public final ok w;
    public final ff0.f x;
    public final ff0.h y;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends vn {
        public final lc0$a g;
        public final ff0.h h;
        public final ff0.h i;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(a aVar, int i) {
                super(0);
                this.G0 = i;
                this.b = aVar;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                if (this.G0 == 0) {
                    lm lmVar = lm.m;
                    vg0.a.getClass();
                    return this.b.i(lmVar, p0.b$13);
                }
                a aVar = this.b;
                lc0$a lc0_a = aVar.g;
                on onVar = on.this;
                lc0_a.getClass();
                return ((s0) onVar.h()).d();
            }
        }

        public a(lc0$a lc0_a) {
            hn hnVar = on.this.r;
            zq0 zq0Var = on.this.g;
            List list = zq0Var.t;
            List list2 = zq0Var.u;
            List list3 = zq0Var.v;
            List list4 = zq0Var.q;
            jj0 jj0Var = hnVar.b;
            fn fnVar = hnVar.a;
            ArrayList arrayList = new ArrayList(ae.y0(list4));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(e.E(jj0Var, ((Number) it.next()).intValue()));
            }
            super(hnVar, list, list2, list3, new uk0(arrayList, 1));
            this.g = lc0_a;
            ff0 ff0Var = fnVar.a;
            b bVar = new b(this, 0);
            ff0Var.getClass();
            this.h = new ff0.h(ff0Var, bVar);
            ff0 ff0Var2 = fnVar.a;
            b bVar2 = new b(this, 1);
            ff0Var2.getClass();
            this.i = new ff0.h(ff0Var2, bVar2);
        }

        @Override // defpackage.vn, defpackage.wg0, defpackage.vg0
        public final Collection a(ij0 ij0Var, dl0 dl0Var) {
            fn fnVar = this.b.a;
            return this.c.a(ij0Var);
        }

        @Override // defpackage.vn, defpackage.wg0, defpackage.vg0
        public final Collection c(ij0 ij0Var, dl0 dl0Var) {
            fn fnVar = this.b.a;
            return this.c.c(ij0Var);
        }

        @Override // defpackage.vn, defpackage.wg0, defpackage.vg0
        public final od e(ij0 ij0Var, dl0 dl0Var) {
            ai0 ai0Var;
            fn fnVar = this.b.a;
            oo ooVar = on.this.v;
            return (ooVar == null || (ai0Var = (ai0) ((ff0.j) ooVar.b).invoke(ij0Var)) == null) ? super.e(ij0Var, dl0Var) : ai0Var;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Collection f(lm lmVar, nw nwVar) {
            return (Collection) this.h.invoke();
        }

        @Override // defpackage.vn
        public final void h(ArrayList arrayList) {
            Object obj;
            oo ooVar = on.this.v;
            if (ooVar == null) {
                obj = null;
            } else {
                Set setKeySet = ((LinkedHashMap) ooVar.a).keySet();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    ai0 ai0Var = (ai0) ((ff0.j) ooVar.b).invoke((ij0) it.next());
                    if (ai0Var != null) {
                        arrayList2.add(ai0Var);
                    }
                }
                obj = arrayList2;
            }
            if (obj == null) {
                obj = uq.b;
            }
            arrayList.addAll(obj);
        }

        @Override // defpackage.vn
        public final void j(ij0 ij0Var, ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((Collection) this.i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList2.addAll(((fc0) it.next()).m().a(ij0Var, dl0.d));
            }
            hn hnVar = this.b;
            arrayList.addAll(hnVar.a.n.b(ij0Var, on.this));
            ArrayList arrayList3 = new ArrayList(arrayList);
            hnVar.a.q.e.h(ij0Var, arrayList2, arrayList3, on.this, new jr(arrayList, 1));
        }

        @Override // defpackage.vn
        public final void k(ij0 ij0Var, ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((Collection) this.i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList2.addAll(((fc0) it.next()).m().c(ij0Var, dl0.d));
            }
            ArrayList arrayList3 = new ArrayList(arrayList);
            this.b.a.q.e.h(ij0Var, arrayList2, arrayList3, on.this, new jr(arrayList, 1));
        }

        @Override // defpackage.vn
        public final dd l(ij0 ij0Var) {
            return on.this.n.d(ij0Var);
        }

        @Override // defpackage.vn
        public final Set n() {
            List listL = on.this.t.d();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                Set setG = ((fc0) it.next()).m().g();
                if (setG == null) {
                    return null;
                }
                he.C0(setG, linkedHashSet);
            }
            return linkedHashSet;
        }

        @Override // defpackage.vn
        public final Set o$1() {
            on onVar = on.this;
            List listL = onVar.t.d();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                he.C0(((fc0) it.next()).m().b(), linkedHashSet);
            }
            linkedHashSet.addAll(this.b.a.n.c(onVar));
            return linkedHashSet;
        }

        @Override // defpackage.vn
        public final Set p() {
            List listL = on.this.t.d();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                he.C0(((fc0) it.next()).m().d(), linkedHashSet);
            }
            return linkedHashSet;
        }

        @Override // defpackage.vn
        public final boolean r(bo boVar) {
            return this.b.a.o.d(on.this, boVar);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends l {
        public final /* synthetic */ int G0 = 0;
        public final ff0.h c;
        public final /* synthetic */ k d;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(on onVar) {
            this.d = onVar;
            hn hnVar = onVar.r;
            super(hnVar.a.a);
            ff0 ff0Var = hnVar.a.a;
            d dVar = new d(onVar, 1);
            ff0Var.getClass();
            this.c = new ff0.h(ff0Var, dVar);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(xc0 xc0Var) {
            this.d = xc0Var;
            v8 v8Var = xc0Var.q;
            super(((c60) v8Var.a).a);
            ff0 ff0Var = ((c60) v8Var.a).a;
            xc0.b bVar = new xc0.b(xc0Var, 1);
            ff0Var.getClass();
            this.c = new ff0.h(ff0Var, bVar);
        }

        @Override // defpackage.l, defpackage.a91
        public final od b() {
            int i = this.G0;
            k kVar = this.d;
            return i != 0 ? (xc0) kVar : (on) kVar;
        }

        @Override // defpackage.a91
        public final boolean c() {
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:107:0x023a  */
        /* JADX WARN: Code duplicated, block: B:108:0x023c  */
        /* JADX WARN: Code duplicated, block: B:111:0x0259  */
        /* JADX WARN: Code duplicated, block: B:114:0x0272 A[LOOP:3: B:112:0x026c->B:114:0x0272, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:118:0x028d  */
        /* JADX WARN: Code duplicated, block: B:120:0x0292  */
        /* JADX WARN: Code duplicated, block: B:51:0x00d8 A[EDGE_INSN: B:51:0x00d8->B:52:0x00d9 BREAK  A[LOOP:0: B:32:0x00a3->B:167:0x00a3]] */
        /* JADX WARN: Code duplicated, block: B:87:0x01b2  */
        /* JADX WARN: Code duplicated, block: B:91:0x01bd  */
        /* JADX WARN: Code duplicated, block: B:93:0x020d  */
        /* JADX WARN: Code duplicated, block: B:96:0x0216  */
        /* JADX WARN: Code duplicated, block: B:97:0x0218  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Iterable] */
        /* JADX WARN: Type inference failed for: r5v24, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r5v40 */
        @Override // defpackage.s0
        public final Collection g() {
            ?? arrayList;
            ?? arrayList2;
            cv cvVar;
            cv cvVar2;
            u01 u01VarF;
            Iterator it;
            ad1 ad1Var;
            ai0 ai0Var;
            fc0 fc0VarK;
            ArrayList arrayList3;
            Iterator it2;
            tt0 tt0Var;
            fc0 fc0Var;
            a91 a91VarL0;
            a91 a91VarL1;
            ArrayList arrayList4;
            String str;
            int i = this.G0;
            k kVar = this.d;
            if (i == 0) {
                on onVar = (on) kVar;
                zq0 zq0Var = onVar.g;
                hn hnVar = onVar.r;
                fi0 fi0Var = hnVar.d;
                fn fnVar = hnVar.a;
                List list = zq0Var.n;
                if (list.isEmpty()) {
                    arrayList = list;
                    arrayList = 0;
                }
                if (arrayList == 0) {
                    List list2 = zq0Var.o;
                    arrayList = new ArrayList(ae.y0(list2));
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(fi0Var.a(((Integer) it3.next()).intValue()));
                    }
                }
                ArrayList arrayList5 = new ArrayList(ae.y0(arrayList));
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    arrayList5.add(hnVar.h.f((nr0) it4.next()));
                }
                ArrayList arrayListX0 = he.X0(fnVar.n.e(onVar), arrayList5);
                ArrayList<kl0$b> arrayList6 = new ArrayList();
                Iterator it5 = arrayListX0.iterator();
                while (it5.hasNext()) {
                    od odVarB = ((fc0) it5.next()).L0().b();
                    kl0$b kl0_b = odVarB instanceof kl0$b ? (kl0$b) odVarB : null;
                    if (kl0_b != null) {
                        arrayList6.add(kl0_b);
                    }
                }
                if (!arrayList6.isEmpty()) {
                    mr mrVar = fnVar.h;
                    ArrayList arrayList7 = new ArrayList(ae.y0(arrayList6));
                    for (kl0$b kl0_b2 : arrayList6) {
                        dd ddVarF = ym.f(kl0_b2);
                        arrayList7.add(ddVarF == null ? kl0_b2.getName().b() : ddVarF.b().b());
                    }
                    mrVar.b(onVar, arrayList7);
                }
                return he.g1(arrayListX0);
            }
            xc0 xc0Var = (xc0) kVar;
            Class cls = xc0Var.o.a;
            boolean zA = e4.a(cls, Object.class);
            uq uqVar = uq.b;
            if (zA) {
                arrayList2 = uqVar;
            } else {
                o6 o6Var = new o6(2);
                Type genericSuperclass = cls.getGenericSuperclass();
                o6Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
                o6Var.b(cls.getGenericInterfaces());
                Object[] objArrF = o6Var.f(new Type[o6Var.e()]);
                List listAsList = objArrF.length > 0 ? Arrays.asList(objArrF) : uqVar;
                arrayList2 = new ArrayList(ae.y0(listAsList));
                Iterator it6 = listAsList.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(new tt0((Type) it6.next()));
                }
            }
            ArrayList arrayList8 = new ArrayList(arrayList2.size());
            boolean z = false;
            ArrayList arrayList9 = new ArrayList(0);
            g4 g4VarC = xc0Var.B.c(r70.n);
            int i2 = 3;
            if (g4VarC != null) {
                Object objB1 = he.b1(g4VarC.h().values());
                h31 h31Var = objB1 instanceof h31 ? (h31) objB1 : null;
                if (h31Var != null && (str = (String) h31Var.a) != null) {
                    int i3 = 1;
                    int i4 = 0;
                    while (true) {
                        if (i4 < str.length()) {
                            char cCharAt = str.charAt(i4);
                            i4++;
                            int iU = ak.u(i3);
                            if (iU != 0) {
                                if (iU != 1) {
                                    if (iU != 2) {
                                        continue;
                                    }
                                } else if (cCharAt == '.') {
                                    i3 = 3;
                                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                                }
                            }
                            if (Character.isJavaIdentifierPart(cCharAt)) {
                                i3 = 2;
                            }
                        } else if (i3 != 3) {
                            cvVar = new cv(str);
                            break;
                        }
                        cvVar = null;
                        break;
                    }
                }
                cvVar = null;
                break;
            }
            cvVar = null;
            break;
            if (cvVar == null || cvVar.d() || !cvVar.h(m21.h)) {
                cvVar = null;
            }
            ad1 ad1Var2 = ad1.INVARIANT;
            v8 v8Var = xc0Var.q;
            if (cvVar == null) {
                HashMap map = rs.a;
                cvVar2 = (cv) rs.a.get(ym.g(xc0Var));
                if (cvVar2 == null) {
                    u01VarF = null;
                }
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    tt0Var = (tt0) it.next();
                    fc0 fc0VarE = ((oo) v8Var.e).e(tt0Var, w60.b(1, z, null, i2));
                    m6 m6Var = ((c60) v8Var.a).r;
                    m6Var.getClass();
                    ad1 ad1Var3 = ad1Var2;
                    int i5 = i2;
                    Iterator it7 = it;
                    fc0Var = d01$b.d(new d01$b(m6Var, null, fc0VarE, uqVar, false, v8Var, j4.TYPE_USE, 64), null, i5).a;
                    if (fc0Var.L0().b() instanceof kl0$b) {
                        arrayList9.add(tt0Var);
                    }
                    a91VarL0 = fc0Var.L0();
                    if (u01VarF == null) {
                        a91VarL1 = null;
                    } else {
                        a91VarL1 = u01VarF.L0();
                    }
                    if (!e4.a((Object) a91VarL0, (Object) a91VarL1) && !ub0.y(fc0Var)) {
                        arrayList8.add(fc0Var);
                    }
                    i2 = i5;
                    ad1Var2 = ad1Var3;
                    it = it7;
                    z = false;
                }
                ad1Var = ad1Var2;
                ai0Var = xc0Var.p;
                if (ai0Var == null) {
                    fc0VarK = null;
                } else {
                    fc0VarK = new ha1(e.L0(ai0Var, xc0Var)).k(ai0Var.n(), ad1Var);
                }
                e.s0(arrayList8, fc0VarK);
                e.s0(arrayList8, u01VarF);
                if (!arrayList9.isEmpty()) {
                    mr mrVar2 = ((c60) v8Var.a).f;
                    arrayList3 = new ArrayList(ae.y0(arrayList9));
                    it2 = arrayList9.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((tt0) ((fu0) it2.next())).a.toString());
                    }
                    mrVar2.b(xc0Var, arrayList3);
                }
                return !arrayList8.isEmpty() ? he.g1(arrayList8) : Collections.singletonList(((c60) v8Var.a).o.k().f());
            }
            cvVar2 = cvVar;
            gi0 gi0Var = ((c60) v8Var.a).o;
            dl0 dl0Var = dl0.n;
            int i6 = ym.$r8$clinit;
            cvVar2.d();
            od odVarE = gi0Var.U(cvVar2.e()).j.e(cvVar2.a.g(), dl0Var);
            ai0 ai0Var2 = odVarE instanceof ai0 ? (ai0) odVarE : null;
            if (ai0Var2 != null) {
                int size = ai0Var2.h().getParameters().size();
                List parameters = xc0Var.w.getParameters();
                int size2 = parameters.size();
                if (size2 == size) {
                    arrayList4 = new ArrayList(ae.y0(parameters));
                    Iterator it8 = parameters.iterator();
                    while (it8.hasNext()) {
                        arrayList4.add(new da1(((v91) it8.next()).n(), ad1Var2));
                    }
                } else if (size2 == 1 && size > 1 && cvVar == null) {
                    da1 da1Var = new da1(((v91) he.a1(parameters)).n(), ad1Var2);
                    y20 y20Var = new y20(1, size, 1);
                    ArrayList arrayList10 = new ArrayList(ae.y0(y20Var));
                    Iterator it9 = y20Var.iterator();
                    while (true) {
                        x20 x20Var = (x20) it9;
                        if (!x20Var.d) {
                            break;
                        }
                        x20Var.nextInt();
                        arrayList10.add(da1Var);
                    }
                    arrayList4 = arrayList10;
                } else {
                    u01VarF = null;
                }
                u01VarF = e4.f(e4.f47a, ai0Var2.h(), arrayList4, false);
            } else {
                u01VarF = null;
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                tt0Var = (tt0) it.next();
                fc0 fc0VarE2 = ((oo) v8Var.e).e(tt0Var, w60.b(1, z, null, i2));
                m6 m6Var2 = ((c60) v8Var.a).r;
                m6Var2.getClass();
                ad1 ad1Var4 = ad1Var2;
                int i7 = i2;
                Iterator it10 = it;
                fc0Var = d01$b.d(new d01$b(m6Var2, null, fc0VarE2, uqVar, false, v8Var, j4.TYPE_USE, 64), null, i7).a;
                if (fc0Var.L0().b() instanceof kl0$b) {
                    arrayList9.add(tt0Var);
                }
                a91VarL0 = fc0Var.L0();
                if (u01VarF == null) {
                    a91VarL1 = null;
                } else {
                    a91VarL1 = u01VarF.L0();
                }
                if (!e4.a((Object) a91VarL0, (Object) a91VarL1)) {
                    arrayList8.add(fc0Var);
                }
                i2 = i7;
                ad1Var2 = ad1Var4;
                it = it10;
                z = false;
            }
            ad1Var = ad1Var2;
            ai0Var = xc0Var.p;
            if (ai0Var == null) {
                fc0VarK = null;
            } else {
                fc0VarK = new ha1(e.L0(ai0Var, xc0Var)).k(ai0Var.n(), ad1Var);
            }
            e.s0(arrayList8, fc0VarK);
            e.s0(arrayList8, u01VarF);
            if (!arrayList9.isEmpty()) {
                mr mrVar3 = ((c60) v8Var.a).f;
                arrayList3 = new ArrayList(ae.y0(arrayList9));
                it2 = arrayList9.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((tt0) ((fu0) it2.next())).a.toString());
                }
                mrVar3.b(xc0Var, arrayList3);
            }
            if (!arrayList8.isEmpty()) {
            }
        }

        @Override // defpackage.a91
        public final List getParameters() {
            return (List) this.c.invoke();
        }

        @Override // defpackage.s0
        public final ke j() {
            return this.G0 != 0 ? ((c60) ((xc0) this.d).q.a).m : ke.a;
        }

        @Override // defpackage.l
        /* JADX INFO: renamed from: p */
        public final ai0 b() {
            int i = this.G0;
            k kVar = this.d;
            return i != 0 ? (xc0) kVar : (on) kVar;
        }

        public final String toString() {
            int i = this.G0;
            k kVar = this.d;
            return i != 0 ? ((xc0) kVar).getName().b() : ((on) kVar).getName().b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ on b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(on onVar, int i) {
            super(0);
            this.G0 = i;
            this.b = onVar;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            ij0 name;
            u01 u01VarD;
            cn.d dVar;
            Object next;
            int i = this.G0;
            on onVar = this.b;
            if (i == 0) {
                return he.g1(onVar.r.a.e.g(onVar.C));
            }
            if (i == 1) {
                return e4.b((pd) onVar);
            }
            Object obj = null;
            if (i != 2) {
                boolean z = false;
                if (i == 3) {
                    List list = onVar.g.s;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (e.i(xt.m, ((ar0) obj2).f)) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
                    Iterator it = arrayList.iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        hn hnVar = onVar.r;
                        if (!zHasNext) {
                            return he.X0(hnVar.a.n.a(onVar), he.X0(e.Z(onVar.E()), arrayList2));
                        }
                        arrayList2.add(hnVar.i.d((ar0) it.next(), false));
                    }
                } else if (i != 4) {
                    if (i != 5) {
                        zh0 zh0Var = zh0.c;
                        zh0 zh0Var2 = onVar.o;
                        if (zh0Var2 == zh0Var) {
                            List<Integer> list2 = onVar.g.x;
                            if (!list2.isEmpty()) {
                                ArrayList arrayList3 = new ArrayList();
                                for (Integer num : list2) {
                                    hn hnVar2 = onVar.r;
                                    fn fnVar = hnVar2.a;
                                    dd ddVarX = e.x(hnVar2.b, num.intValue());
                                    Set set = cd.c;
                                    cd cdVar = fnVar.s;
                                    cdVar.getClass();
                                    ai0 ai0Var = (ai0) cdVar.b.invoke(new cd.a(ddVarX, null));
                                    if (ai0Var != null) {
                                        arrayList3.add(ai0Var);
                                    }
                                }
                                return arrayList3;
                            }
                            if (zh0Var2 == zh0Var) {
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                ok okVar = onVar.w;
                                if (okVar instanceof wn0) {
                                    rd.g(onVar, linkedHashSet, ((wn0) okVar).m(), false);
                                }
                                rd.g(onVar, linkedHashSet, onVar.V(), true);
                                return linkedHashSet;
                            }
                        }
                        return uq.b;
                    }
                    int i2 = onVar.q;
                    if (i2 == 6 || i2 == 4) {
                        jm$a jm_a = new jm$a(onVar, null, e4.f47a, true, la.a.b, t11.a);
                        List list3 = Collections.EMPTY_LIST;
                        int i3 = xm.$r8$clinit;
                        if (i2 == 3 || i2 == 6 || i2 == 4 || xm.q(onVar)) {
                            dVar = cn.a;
                        } else if (xm.n(onVar, 1) && onVar.getName().equals(f21.a)) {
                            dVar = cn.k;
                            if (dVar == null) {
                                xm.a(52);
                                throw null;
                            }
                        } else {
                            dVar = cn.e;
                        }
                        jm_a.V0(list3, dVar);
                        jm_a.j = onVar.n();
                        return jm_a;
                    }
                    Iterator it2 = onVar.g.s.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (xt.m.c(((ar0) next).f).booleanValue());
                    ar0 ar0Var = (ar0) next;
                    if (ar0Var != null) {
                        return onVar.r.i.d(ar0Var, true);
                    }
                } else if (j20.b(onVar)) {
                    zq0 zq0Var = onVar.g;
                    boolean z2 = (zq0Var.d & 8) == 8;
                    hn hnVar3 = onVar.r;
                    if (z2) {
                        name = e.E(hnVar3.b, zq0Var.z);
                    } else {
                        if (onVar.i.a(1, 5, 1)) {
                            throw new IllegalStateException(e4.j("Inline class has no underlying property name in metadata: ", onVar).toString());
                        }
                        uc ucVarE = onVar.E();
                        if (ucVarE == null) {
                            throw new IllegalStateException(e4.j("Inline class has no primary constructor: ", onVar).toString());
                        }
                        name = ((wc1) he.K0(ucVarE.f())).getName();
                    }
                    fi0 fi0Var = hnVar3.d;
                    int i4 = zq0Var.d;
                    nr0 nr0VarA = (i4 & 16) == 16 ? zq0Var.A : (i4 & 32) == 32 ? fi0Var.a(zq0Var.B) : null;
                    if (nr0VarA == null) {
                        Iterator it3 = onVar.K0().c(name, dl0.j).iterator();
                        Object obj3 = null;
                        while (true) {
                            if (!it3.hasNext()) {
                                if (!z) {
                                    break;
                                }
                                obj = obj3;
                                break;
                            }
                            Object next2 = it3.next();
                            if (((nq0) next2).z == null) {
                                if (z) {
                                    break;
                                }
                                obj3 = next2;
                                z = true;
                            }
                        }
                        nq0 nq0Var = (nq0) obj;
                        if (nq0Var == null) {
                            throw new IllegalStateException(e4.j("Inline class has no underlying property: ", onVar).toString());
                        }
                        u01VarD = (u01) nq0Var.getType();
                    } else {
                        u01VarD = hnVar3.h.d(nr0VarA, true);
                    }
                    return new i20(name, u01VarD);
                }
            } else {
                zq0 zq0Var2 = onVar.g;
                if ((zq0Var2.d & 4) == 4) {
                    od odVarE = onVar.K0().e(e.E(onVar.r.b, zq0Var2.i), dl0.j);
                    if (odVarE instanceof ai0) {
                        return (ai0) odVarE;
                    }
                }
            }
            return null;
        }
    }

    public on(hn hnVar, zq0 zq0Var, jj0 jj0Var, y8 y8Var, t11 t11Var) {
        int i;
        super(hnVar.a.a, e.x(jj0Var, zq0Var.g).j());
        this.g = zq0Var;
        this.i = y8Var;
        this.j = t11Var;
        int i2 = zq0Var.g;
        this.n = dd.f(jj0Var.b(i2), jj0Var.a(i2));
        this.o = uh.a((hr0) xt.e.c(zq0Var.f));
        this.p = ui.a((ur0) xt.d.c(zq0Var.f));
        zq0.c cVar = (zq0.c) xt.f.c(zq0Var.f);
        switch (cVar == null ? -1 : wr0$a.b[cVar.ordinal()]) {
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
            case 7:
                i = 6;
                break;
            default:
                i = 1;
                break;
        }
        this.q = i;
        List list = zq0Var.j;
        fi0 fi0Var = new fi0(zq0Var.C);
        gd1 gd1Var = gd1.b;
        gd1 gd1VarA = ak.a(zq0Var.E);
        int i3 = i;
        fn fnVar = hnVar.a;
        ff0 ff0Var = fnVar.a;
        int i4 = 3;
        this.r = new hn(fnVar, jj0Var, this, fi0Var, (y8Var.b != 1 || y8Var.c < 4) ? hnVar.e : gd1VarA, y8Var, hnVar.g, hnVar.h, list);
        this.s = i3 == 3 ? new y21(ff0Var, this) : vg0.b.b;
        this.t = new b(this);
        e eVar = gy0.e;
        fnVar.q.getClass();
        n4 n4Var = new n4(1, this, i4);
        eVar.getClass();
        this.u = new gy0(this, ff0Var, n4Var);
        this.v = i3 == 3 ? new oo(this) : null;
        ok okVar = hnVar.c;
        this.w = okVar;
        d dVar = new d(this, 5);
        ff0Var.getClass();
        this.x = new ff0.f(ff0Var, dVar);
        this.y = new ff0.h(ff0Var, new d(this, i4));
        new ff0.f(ff0Var, new d(this, 2));
        this.A = new ff0.h(ff0Var, new d(this, 6));
        this.B = new ff0.f(ff0Var, new d(this, 4));
        on onVar = okVar instanceof on ? (on) okVar : null;
        this.C = new vr0$a(r11, jj0Var, fi0Var, t11Var, onVar == null ? null : onVar.C);
        this.D = !xt.c.c(zq0Var.f).booleanValue() ? e4.f47a : new hl0(ff0Var, new d(this, 0));
    }

    @Override // defpackage.ai0
    public final Collection A() {
        return (Collection) this.A.invoke();
    }

    @Override // defpackage.pd
    public final boolean B() {
        return e.i(xt.g, this.g.f);
    }

    @Override // defpackage.ai0
    public final uc E() {
        return (uc) this.x.invoke();
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return e.i(xt.h, this.g.f);
    }

    public final a K0() {
        this.r.a.q.getClass();
        return (a) this.u.a(lc0$a.a);
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        return this.u.a(lc0_a);
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.ok
    public final ok b() {
        return this.w;
    }

    @Override // defpackage.qg0
    public final boolean b0() {
        return e.i(xt.i, this.g.f);
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return xt.f.c(this.g.f) == zq0.c.i;
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return e.i(xt.l, this.g.f);
    }

    @Override // defpackage.qk
    public final t11 g() {
        return this.j;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return this.D;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        return this.p;
    }

    @Override // defpackage.od
    public final a91 h() {
        return this.t;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        return (Collection) this.y.invoke();
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return e.i(xt.k, this.g.f) && this.i.a(1, 4, 2);
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return e.i(xt.j, this.g.f);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        return he.g1(this.r.h.g.values());
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return this.s;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        return this.o;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        if (!e.i(xt.k, this.g.f)) {
            return false;
        }
        y8 y8Var = this.i;
        int i = y8Var.b;
        if (i >= 1) {
            if (i > 1) {
                return false;
            }
            int i2 = y8Var.c;
            if (i2 >= 4 && (i2 > 4 || y8Var.d > 1)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.ai0
    public final i20 t() {
        return (i20) this.B.invoke();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("deserialized ");
        sb.append(l0() ? "expect " : AppConfig.CUSTOM);
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // defpackage.ai0
    public final int v() {
        return this.q;
    }
}
