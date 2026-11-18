package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d01$b {
    public final w3 a;
    public final fc0 b;
    public final Object c;
    public final boolean d;
    public final v8 e;
    public final j4 f;
    public final boolean g;
    public final boolean h;
    public final /* synthetic */ m6 i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class a extends ux implements nw {
        public static final a d = new a(1);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "containsFunctionN";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.b(b2.class);
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            return Boolean.valueOf(d01$b.a((cc1) obj));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class c extends ux implements nw {
        public static final c d = new c(1);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "containsFunctionN";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.b(b2.class);
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            return Boolean.valueOf(d01$b.a((cc1) obj));
        }
    }

    public d01$b(m6 m6Var, w3 w3Var, fc0 fc0Var, Collection collection, boolean z, v8 v8Var, j4 j4Var, int i) {
        this.i = m6Var;
        boolean z2 = (i & 64) == 0;
        boolean z3 = (i & 128) == 0;
        this.i = m6Var;
        this.a = w3Var;
        this.b = fc0Var;
        this.c = collection;
        this.d = z;
        this.e = v8Var;
        this.f = j4Var;
        this.g = z2;
        this.h = z3;
    }

    public static final boolean a(cc1 cc1Var) {
        od odVarB = cc1Var.L0().b();
        if (odVarB == null) {
            return false;
        }
        ij0 name = odVarB.getName();
        cv cvVar = l60.f;
        return e4.a(name, cvVar.a.g()) && e4.a(ym.c(odVarB), cvVar);
    }

    public static bm0 b(v91 v91Var) {
        boolean z;
        if (v91Var instanceof td0) {
            td0 td0Var = (td0) v91Var;
            List upperBounds = td0Var.getUpperBounds();
            if (!upperBounds.isEmpty()) {
                Iterator it = upperBounds.iterator();
                while (it.hasNext()) {
                    if (!e.O((fc0) it.next())) {
                        List upperBounds2 = td0Var.getUpperBounds();
                        if (upperBounds2.isEmpty()) {
                            z = true;
                        } else {
                            Iterator it2 = upperBounds2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    cc1 cc1VarO0 = ((fc0) it2.next()).O0();
                                    zt ztVar = cc1VarO0 instanceof zt ? (zt) cc1VarO0 : null;
                                    if (ztVar == null || ztVar.c.M0() == ztVar.d.M0()) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        }
                        am0 am0Var = am0.d;
                        am0 am0Var2 = am0.c;
                        if (!z) {
                            List upperBounds3 = td0Var.getUpperBounds();
                            if (upperBounds3.isEmpty()) {
                                am0Var = am0Var2;
                            } else {
                                Iterator it3 = upperBounds3.iterator();
                                while (it3.hasNext()) {
                                    if (!ma1.g((fc0) it3.next())) {
                                    }
                                }
                                am0Var = am0Var2;
                            }
                            return new bm0(am0Var, false);
                        }
                        List<fc0> upperBounds4 = td0Var.getUpperBounds();
                        if (!upperBounds4.isEmpty()) {
                            for (fc0 fc0Var : upperBounds4) {
                                if ((fc0Var instanceof du) && !ma1.g(((du) fc0Var).g)) {
                                    return new bm0(am0Var, true);
                                }
                            }
                        }
                        List<fc0> upperBounds5 = td0Var.getUpperBounds();
                        if (!upperBounds5.isEmpty()) {
                            for (fc0 fc0Var2 : upperBounds5) {
                                if ((fc0Var2 instanceof du) && ma1.g(((du) fc0Var2).g)) {
                                    return new bm0(am0Var2, true);
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ d01$a d(d01$b d01_b, j91 j91Var, int i) {
        if ((i & 1) != 0) {
            j91Var = null;
        }
        return d01_b.c(j91Var, false);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080  */
    public static s60 e(fc0 fc0Var) {
        jo0 jo0Var;
        am0 am0Var;
        od odVarB;
        ai0 ai0Var;
        if (fc0Var.O0() instanceof zt) {
            zt ztVar = (zt) fc0Var.O0();
            jo0Var = new jo0(ztVar.c, ztVar.d);
        } else {
            jo0Var = new jo0(fc0Var, fc0Var);
        }
        fc0 fc0Var2 = (fc0) jo0Var.b;
        fc0 fc0Var3 = (fc0) jo0Var.c;
        vi0 vi0Var = null;
        if (fc0Var2.M0()) {
            am0Var = am0.c;
        } else {
            am0Var = !fc0Var3.M0() ? am0.d : null;
        }
        or orVar = ma1.a;
        od odVarB2 = fc0Var2.L0().b();
        ai0 ai0Var2 = odVarB2 instanceof ai0 ? (ai0) odVarB2 : null;
        if (ai0Var2 != null) {
            String str = l60.a;
            if (l60.k.containsKey(xm.g(ai0Var2))) {
                vi0Var = vi0.b;
            } else {
                odVarB = fc0Var3.L0().b();
                if (odVarB instanceof ai0) {
                    ai0Var = (ai0) odVarB;
                } else {
                    ai0Var = null;
                }
                if (ai0Var != null) {
                    String str2 = l60.a;
                    if (l60.j.containsKey(xm.g(ai0Var))) {
                        vi0Var = vi0.c;
                    }
                }
            }
        } else {
            odVarB = fc0Var3.L0().b();
            if (odVarB instanceof ai0) {
                ai0Var = (ai0) odVarB;
            } else {
                ai0Var = null;
            }
            if (ai0Var != null) {
                String str3 = l60.a;
                if (l60.j.containsKey(xm.g(ai0Var))) {
                    vi0Var = vi0.c;
                }
            }
        }
        return new s60(am0Var, vi0Var, (fc0Var.O0() instanceof ol0) || (fc0Var.O0() instanceof ml), false);
    }

    public static final vi0 f(List list, s4 s4Var, vi0 vi0Var) {
        if (list != null && list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (s4Var.c((cv) it.next()) != null) {
                return vi0Var;
            }
        }
        return null;
    }

    public static final void g(d01$b d01_b, ArrayList arrayList, fc0 fc0Var, v8 v8Var, v91 v91Var) {
        v8 v8VarC = uh.c(v8Var, fc0Var.getAnnotations());
        t60 t60VarA = v8VarC.a();
        e50 e50Var = t60VarA == null ? null : (e50) t60VarA.a.get(d01_b.g ? j4.TYPE_PARAMETER_BOUNDS : j4.TYPE_USE);
        arrayList.add(new u81(fc0Var, e50Var, v91Var, false));
        if (d01_b.h && (fc0Var instanceof ls0)) {
            return;
        }
        for (jo0 jo0Var : he.k1(fc0Var.K0(), fc0Var.L0().getParameters())) {
            ca1 ca1Var = (ca1) jo0Var.b;
            v91 v91Var2 = (v91) jo0Var.c;
            if (ca1Var.b()) {
                arrayList.add(new u81(ca1Var.getType(), e50Var, v91Var2, true));
            } else {
                g(d01_b, arrayList, ca1Var.getType(), v8VarC, v91Var2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:200:0x030c  */
    /* JADX WARN: Code duplicated, block: B:201:0x030e  */
    /* JADX WARN: Code duplicated, block: B:203:0x0311  */
    /* JADX WARN: Code duplicated, block: B:204:0x0313  */
    /* JADX WARN: Code duplicated, block: B:208:0x031b  */
    /* JADX WARN: Code duplicated, block: B:210:0x031e  */
    /* JADX WARN: Code duplicated, block: B:211:0x0320  */
    /* JADX WARN: Code duplicated, block: B:217:0x032f  */
    /* JADX WARN: Code duplicated, block: B:220:0x0334  */
    /* JADX WARN: Code duplicated, block: B:221:0x0336  */
    /* JADX WARN: Code duplicated, block: B:225:0x033e  */
    /* JADX WARN: Code duplicated, block: B:232:0x0356  */
    /* JADX WARN: Code duplicated, block: B:235:0x035b  */
    /* JADX WARN: Code duplicated, block: B:238:0x0362  */
    /* JADX WARN: Code duplicated, block: B:241:0x036c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0379  */
    /* JADX WARN: Code duplicated, block: B:256:0x039c  */
    /* JADX WARN: Code duplicated, block: B:258:0x039f  */
    /* JADX WARN: Code duplicated, block: B:259:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:261:0x03a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:264:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:306:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x0379 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:? A[LOOP:8: B:239:0x0366->B:308:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Iterable, java.lang.Object, java.util.Collection] */
    public final d01$a c(j91 j91Var, boolean z) {
        v8 v8Var;
        boolean z2;
        int size;
        m6 m6Var;
        fc0 fc0Var;
        boolean zD;
        e50 e50Var;
        boolean z3;
        s60 s60Var;
        bm0 bm0VarB;
        s60 s60Var2;
        am0 am0Var;
        boolean z4;
        am0 am0Var2;
        vi0 vi0Var;
        am0 am0Var3;
        boolean z5;
        boolean z6;
        boolean z7;
        s60 s60Var3;
        Iterator it;
        wc1 wc1Var;
        fc0 fc0Var2;
        ?? r3 = this.c;
        ArrayList arrayList = new ArrayList(ae.y0(r3));
        Iterator it2 = r3.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            v8Var = this.e;
            z2 = true;
            if (!zHasNext) {
                break;
            }
            fc0 fc0Var3 = (fc0) it2.next();
            ArrayList arrayList2 = new ArrayList(1);
            g(this, arrayList2, fc0Var3, v8Var, null);
            arrayList.add(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(1);
        fc0 fc0Var4 = this.b;
        g(this, arrayList3, fc0Var4, v8Var, null);
        boolean z8 = this.d;
        if (!z8 || r3.isEmpty()) {
            size = arrayList3.size();
            break;
        }
        Iterator it3 = r3.iterator();
        while (true) {
            if (!it3.hasNext()) {
                size = arrayList3.size();
                break;
            }
            if (!gc0.a.c((fc0) it3.next(), fc0Var4)) {
                size = 1;
                break;
            }
        }
        s60[] s60VarArr = new s60[size];
        int i = 0;
        while (true) {
            m6Var = this.i;
            if (i >= size) {
                break;
            }
            boolean z9 = i == 0 ? z2 : false;
            u81 u81Var = (u81) arrayList3.get(i);
            fc0 fc0Var5 = u81Var.a;
            ArrayList<fc0> arrayList4 = new ArrayList();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                u81 u81Var2 = (u81) he.N0((List) it4.next(), i);
                fc0 fc0Var6 = u81Var2 == null ? null : u81Var2.a;
                if (fc0Var6 != null) {
                    arrayList4.add(fc0Var6);
                }
            }
            ArrayList arrayList5 = arrayList;
            ArrayList arrayList6 = new ArrayList(ae.y0(arrayList4));
            for (Iterator it5 = arrayList4.iterator(); it5.hasNext(); it5 = it5) {
                arrayList6.add(e((fc0) it5.next()));
            }
            ArrayList arrayList7 = new ArrayList();
            Iterator it6 = arrayList6.iterator();
            while (it6.hasNext()) {
                int i2 = size;
                vi0 vi0Var2 = ((s60) it6.next()).b;
                if (vi0Var2 != null) {
                    arrayList7.add(vi0Var2);
                }
                size = i2;
            }
            int i3 = size;
            Set setI1 = he.i1((Iterable) arrayList7);
            ArrayList arrayList8 = new ArrayList();
            Iterator it7 = arrayList6.iterator();
            while (it7.hasNext()) {
                ArrayList arrayList9 = arrayList3;
                am0 am0Var4 = ((s60) it7.next()).a;
                if (am0Var4 != null) {
                    arrayList8.add(am0Var4);
                }
                arrayList3 = arrayList9;
            }
            ArrayList arrayList10 = arrayList3;
            Set setI2 = he.i1((Iterable) arrayList8);
            ArrayList arrayList11 = new ArrayList();
            for (fc0 fc0Var7 : arrayList4) {
                ArrayList arrayList12 = arrayList6;
                boolean z10 = z8;
                fc0 fc0VarI0 = fc0Var7 instanceof ra1 ? ((ra1) fc0Var7).i0() : null;
                if (fc0VarI0 != null) {
                    fc0Var7 = fc0VarI0;
                }
                am0 am0Var5 = e(fc0Var7).a;
                if (am0Var5 != null) {
                    arrayList11.add(am0Var5);
                }
                z8 = z10;
                arrayList6 = arrayList12;
            }
            ArrayList arrayList13 = arrayList6;
            boolean z11 = z8;
            Set setI3 = he.i1((Iterable) arrayList11);
            vi0 vi0Var3 = vi0.c;
            vi0 vi0Var4 = vi0.b;
            am0 am0Var6 = am0.c;
            am0 am0Var7 = am0.b;
            int i4 = i;
            am0 am0Var8 = am0.d;
            boolean z12 = z9;
            v91 v91Var = u81Var.c;
            boolean z13 = u81Var.d;
            w3 w3Var = this.a;
            if (z13) {
                if ((v91Var == null ? null : v91Var.j()) == ad1.IN_VARIANCE) {
                    s60Var = s60.e;
                    setI3 = setI3;
                    s60VarArr = s60VarArr;
                }
                if (s60Var.d) {
                    s60Var2 = null;
                } else {
                    s60Var2 = s60Var;
                }
                if (s60Var2 == null) {
                    am0Var = null;
                } else {
                    am0Var = s60Var2.a;
                }
                if (z11 || !z12) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (am0Var == am0Var7) {
                    am0Var2 = am0Var7;
                } else {
                    am0Var2 = (am0) e.L(setI2, am0Var8, am0Var6, am0Var, z4);
                }
                if (am0Var2 == null && !z) {
                    if (!(w3Var instanceof wc1)) {
                        w3Var = null;
                    }
                    wc1Var = (wc1) w3Var;
                    if (wc1Var == null) {
                        fc0Var2 = null;
                    } else {
                        fc0Var2 = wc1Var.p;
                    }
                    if (fc0Var2 != null && z12 && am0Var2 == am0Var6) {
                        am0Var2 = null;
                    }
                } else {
                    am0Var2 = null;
                }
                vi0Var = (vi0) e.L(setI1, vi0Var3, vi0Var4, s60Var.b, z4);
                am0Var3 = s60Var.a;
                Set set = setI3;
                if (am0Var3 == am0Var || !e4.a(set, setI2)) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (s60Var.c) {
                    z6 = true;
                } else {
                    if (!arrayList13.isEmpty()) {
                        it = arrayList13.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((s60) it.next()).c) {
                                    z6 = true;
                                }
                            }
                        }
                    }
                    z6 = false;
                }
                if (am0Var2 == null || !z5) {
                    if (am0Var2 == null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z6 || am0Var2 != am0Var8) {
                        s60Var3 = new s60(am0Var2, vi0Var, false, z7);
                    } else {
                        s60Var3 = new s60(am0Var2, vi0Var, true, z7);
                    }
                } else {
                    if (am0Var3 != am0Var7) {
                        am0Var7 = (am0) e.L(set, am0Var8, am0Var6, am0Var3, z4);
                    }
                    s60Var3 = (z6 && am0Var7 == am0Var8) ? new s60(am0Var7, vi0Var, true, true) : new s60(am0Var7, vi0Var, false, true);
                }
                s60VarArr[i4] = s60Var3;
                i = i4 + 1;
                arrayList = arrayList5;
                z8 = z11;
                size = i3;
                arrayList3 = arrayList10;
                v8Var = v8Var;
                fc0Var4 = fc0Var4;
                s60VarArr = s60VarArr;
                z2 = true;
            } else {
                fc0Var4 = fc0Var4;
            }
            ((c60) v8Var.a).t.getClass();
            s4 annotations = (!z12 || w3Var == null) ? fc0Var5.getAnnotations() : e.n(w3Var.getAnnotations(), fc0Var5.getAnnotations());
            if (z12) {
                t60 t60VarA = v8Var.a();
                e50Var = t60VarA == null ? null : (e50) t60VarA.a.get(this.f);
            } else {
                e50Var = u81Var.b;
            }
            od odVarB = fc0Var5.L0().b();
            v91 v91Var2 = odVarB instanceof v91 ? (v91) odVarB : null;
            bm0 bm0VarB2 = v91Var2 == null ? null : b(v91Var2);
            jo0 jo0Var = bm0VarB2 == null ? new jo0(null, Boolean.FALSE) : new jo0(new bm0(am0Var8, bm0VarB2.b), Boolean.valueOf(bm0VarB2.a == am0Var8));
            bm0 bm0Var = (bm0) jo0Var.b;
            boolean zBooleanValue = ((Boolean) jo0Var.c).booleanValue();
            Iterator it8 = annotations.iterator();
            bm0 bm0Var2 = null;
            while (true) {
                if (!it8.hasNext()) {
                    z3 = zBooleanValue;
                    break;
                }
                z3 = zBooleanValue;
                Iterator it9 = it8;
                bm0 bm0VarB3 = m6Var.b((g4) it8.next(), this.g);
                if (bm0Var2 == null) {
                    bm0Var2 = bm0VarB3;
                } else if (bm0VarB3 != null && !bm0VarB3.equals(bm0Var2)) {
                    boolean z14 = bm0Var2.b;
                    boolean z15 = bm0VarB3.b;
                    if (!z15 || z14) {
                        if (z15 || !z14) {
                            bm0Var2 = null;
                            break;
                        }
                        bm0Var2 = bm0VarB3;
                    }
                }
                it8 = it9;
                zBooleanValue = z3;
            }
            if (bm0Var2 == null || z13) {
                bm0Var2 = null;
            }
            if (bm0Var2 == null) {
                if (bm0Var == null) {
                    bm0Var = e50Var == null ? null : e50Var.a;
                }
                if (v91Var == null || (bm0VarB = b(v91Var)) == null) {
                    bm0VarB = null;
                } else if (bm0VarB.a == am0Var6) {
                    bm0VarB = bm0.a(bm0VarB, false, 2);
                }
                if (bm0VarB != null) {
                    if (bm0Var == null) {
                        bm0Var = bm0VarB;
                    } else {
                        boolean z16 = bm0Var.b;
                        boolean z17 = bm0VarB.b;
                        if (!z17 || z16) {
                            if (z17 || !z16) {
                                am0 am0Var9 = bm0VarB.a;
                                am0 am0Var10 = bm0Var.a;
                                if (am0Var9.compareTo(am0Var10) >= 0 && am0Var9.compareTo(am0Var10) > 0) {
                                    bm0Var = bm0VarB;
                                }
                            } else {
                                bm0Var = bm0VarB;
                            }
                        }
                    }
                }
            } else {
                bm0Var = bm0Var2;
            }
            boolean z18 = bm0Var2 == null ? z3 || (e50Var != null && e50Var.c) : bm0Var2.a == am0Var8;
            am0 am0Var11 = bm0Var == null ? null : bm0Var.a;
            vi0 vi0VarF = f(s70.l, annotations, vi0Var4);
            vi0 vi0VarF2 = f(s70.m, annotations, vi0Var3);
            if (vi0VarF != null && vi0VarF2 != null && !vi0VarF.equals(vi0VarF2)) {
                vi0VarF2 = null;
            } else if (vi0VarF != null) {
                vi0VarF2 = vi0VarF;
            }
            s60Var = new s60(am0Var11, vi0VarF2, z18 && ma1.h(fc0Var5), bm0Var != null && bm0Var.b);
            if (s60Var.d) {
                s60Var2 = s60Var;
            } else {
                s60Var2 = null;
            }
            if (s60Var2 == null) {
                am0Var = null;
            } else {
                am0Var = s60Var2.a;
            }
            if (z11) {
                z4 = false;
            } else {
                z4 = false;
            }
            if (am0Var == am0Var7) {
                am0Var2 = am0Var7;
            } else {
                am0Var2 = (am0) e.L(setI2, am0Var8, am0Var6, am0Var, z4);
            }
            if (am0Var2 == null) {
                am0Var2 = null;
            } else {
                if (!(w3Var instanceof wc1)) {
                    w3Var = null;
                }
                wc1Var = (wc1) w3Var;
                if (wc1Var == null) {
                    fc0Var2 = null;
                } else {
                    fc0Var2 = wc1Var.p;
                }
                if (fc0Var2 != null) {
                    am0Var2 = null;
                }
            }
            vi0Var = (vi0) e.L(setI1, vi0Var3, vi0Var4, s60Var.b, z4);
            am0Var3 = s60Var.a;
            Set set2 = setI3;
            if (am0Var3 == am0Var) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (s60Var.c) {
                z6 = true;
            } else {
                if (!arrayList13.isEmpty()) {
                    it = arrayList13.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((s60) it.next()).c) {
                                z6 = true;
                            }
                        }
                    }
                }
                z6 = false;
            }
            if (am0Var2 == null) {
                if (am0Var2 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z6) {
                    s60Var3 = new s60(am0Var2, vi0Var, false, z7);
                } else {
                    s60Var3 = new s60(am0Var2, vi0Var, false, z7);
                }
            } else {
                if (am0Var2 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z6) {
                    s60Var3 = new s60(am0Var2, vi0Var, false, z7);
                } else {
                    s60Var3 = new s60(am0Var2, vi0Var, false, z7);
                }
            }
            s60VarArr[i4] = s60Var3;
            i = i4 + 1;
            arrayList = arrayList5;
            z8 = z11;
            size = i3;
            arrayList3 = arrayList10;
            v8Var = v8Var;
            fc0Var4 = fc0Var4;
            s60VarArr = s60VarArr;
            z2 = true;
        }
        fc0 fc0Var8 = fc0Var4;
        nw iVar = new i(2, s60VarArr);
        dd0.c cVar = j91Var == null ? null : new dd0.c(1, j91Var, iVar);
        boolean z19 = this.h;
        if (z19) {
            fc0Var = fc0Var8;
            zD = ma1.d(fc0Var, a.d, ba.b$12, null);
        } else {
            fc0Var = fc0Var8;
            zD = ma1.d(fc0Var, c.d, null, null);
        }
        Object obj = m6Var.c;
        if (cVar != null) {
            iVar = cVar;
        }
        cc1 cc1Var = (cc1) ke.b(fc0Var.O0(), iVar, 0, z19).a;
        return cc1Var == null ? new d01$a(fc0Var, false, zD) : new d01$a(cc1Var, true, zD);
    }
}
