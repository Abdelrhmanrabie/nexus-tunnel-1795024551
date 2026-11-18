package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a80 implements f3, yo0 {
    public static final /* synthetic */ ja0[] h;
    public final ji0 a;
    public final ff0.h c;
    public final u01 d;
    public final ff0.h e;
    public final ff0.b f;
    public final ff0.h g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a f;
        public static final /* synthetic */ a[] g;

        static {
            a aVar = new a("HIDDEN", 0);
            b = aVar;
            a aVar2 = new a("VISIBLE", 1);
            c = aVar2;
            a aVar3 = new a("NOT_CONSIDERED", 2);
            d = aVar3;
            a aVar4 = new a("DROP", 3);
            f = aVar4;
            g = new a[]{aVar, aVar2, aVar3, aVar4};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        h = new ja0[]{pu0Var.f(new tq0(pu0Var.b(a80.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), pu0Var.f(new tq0(pu0Var.b(a80.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), pu0Var.f(new tq0(pu0Var.b(a80.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public a80(ji0 ji0Var, ff0 ff0Var, ca0 ca0Var) {
        this.a = ji0Var;
        this.c = new ff0.h(ff0Var, ca0Var);
        int i = 1;
        bd bdVar = new bd(new wq(ji0Var, new cv("java.io"), 1), ij0.f("Serializable"), zh0.f, 2, Collections.singletonList(new de0(ff0Var, new d80(this, 0))), ff0Var);
        bdVar.K0(vg0.b.b, yq.b, null);
        this.d = bdVar.n();
        this.e = new ff0.h(ff0Var, new qn(i, this, ff0Var));
        this.f = new ff0.b(ff0Var, new ConcurrentHashMap(3, 1.0f, 2));
        this.g = new ff0.h(ff0Var, new d80(this, i));
    }

    @Override // defpackage.f3
    public final Collection a(on onVar) {
        ai0 ai0VarA0;
        if (onVar.q == 1) {
            g();
            xc0 xc0VarF = f(onVar);
            if (xc0VarF != null && (ai0VarA0 = e.a0(ym.g(xc0VarF), ss.f)) != null) {
                ha1 ha1Var = new ha1(e.L0(ai0VarA0, xc0VarF));
                List list = (List) xc0VarF.x.q.invoke();
                ArrayList<uc> arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    uc ucVar = (uc) next;
                    if (ucVar.getVisibility().a.b) {
                        Collection collectionI = ai0VarA0.i();
                        if (!collectionI.isEmpty()) {
                            Iterator it2 = collectionI.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (pn0.j((uc) it2.next(), ucVar.c(ha1Var)) == 1) {
                                    }
                                }
                            }
                        }
                        if (ucVar.f().size() == 1) {
                            od odVarB = ((wc1) he.a1(ucVar.f())).getType().L0().b();
                            if (e4.a(odVarB != null ? xm.g(odVarB) : null, xm.g(onVar))) {
                            }
                        }
                        if (!ub0.D(ucVar) && !l80.e.contains(e.q1(xc0VarF, e.o(ucVar, 3)))) {
                            arrayList.add(next);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
                for (uc ucVar2 : arrayList) {
                    ucVar2.getClass();
                    rx.a aVarO0 = ucVar2.O0(ha1.b);
                    aVarO0.b = onVar;
                    aVarO0.j = onVar.n();
                    aVarO0.n = true;
                    aVarO0.a = ha1Var.a;
                    if (!l80.f.contains(e.q1(xc0VarF, e.o(ucVar2, 3)))) {
                        ja0 ja0Var = h[2];
                        aVarO0.r = (s4) this.g.invoke();
                    }
                    rx rxVarL0 = aVarO0.w.L0(aVarO0);
                    if (rxVarL0 == null) {
                        d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                        return null;
                    }
                    arrayList2.add((uc) rxVarL0);
                }
                return arrayList2;
            }
        }
        return uq.b;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0295  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:80:0x0200  */
    /* JADX WARN: Instruction removed from duplicated block: B:80:0x0200, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    @Override // defpackage.f3
    public final Collection b(ij0 ij0Var, on onVar) throws Throwable {
        q01 q01Var;
        Iterable iterableSingleton;
        Object next;
        Object obj;
        boolean z;
        ?? r6;
        boolean zBooleanValue;
        boolean zA = e4.a(ij0Var, sd.e);
        List<q01> list = uq.b;
        ja0[] ja0VarArr = h;
        int i = 1;
        if (zA) {
            ij0 ij0Var2 = ub0.e;
            if (ub0.c(onVar, m21.a.g) || ub0.s(onVar) != null) {
                List list2 = onVar.g.t;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (e.E(onVar.r.b, ((fr0) it.next()).i).equals(sd.e)) {
                            return list;
                        }
                    }
                }
                ja0 ja0Var = ja0VarArr[1];
                ox.a aVarS = ((q01) he.Z0(((u01) this.e.invoke()).m().a(ij0Var, dl0.b))).s();
                aVarS.l(onVar);
                aVarS.c(cn.e);
                aVarS.p(onVar.n());
                aVarS.d(onVar.J0());
                return Collections.singletonList((q01) aVarS.mo7build());
            }
        }
        g();
        f80 f80Var = new f80(ij0Var, 0);
        xc0 xc0VarF = f(onVar);
        if (xc0VarF != null) {
            cv cvVarG = ym.g(xc0VarF);
            ss ssVar = ss.f;
            ai0 ai0VarA0 = e.a0(cvVarG, ssVar);
            if (ai0VarA0 == null) {
                iterableSingleton = yq.b;
            } else {
                String str = l60.a;
                cv cvVar = (cv) l60.k.get(xm.g(ai0VarA0));
                iterableSingleton = cvVar == null ? Collections.singleton(ai0VarA0) : Arrays.asList(ai0VarA0, ssVar.j(cvVar));
            }
            if (iterableSingleton instanceof List) {
                List list3 = (List) iterableSingleton;
                if (list3.isEmpty()) {
                    obj = null;
                } else {
                    obj = list3.get(list3.size() - 1);
                }
            } else {
                Iterator it2 = iterableSingleton.iterator();
                if (it2.hasNext()) {
                    do {
                        next = it2.next();
                    } while (it2.hasNext());
                    obj = next;
                } else {
                    obj = null;
                }
            }
            ai0 ai0Var = (ai0) obj;
            if (ai0Var != null) {
                int i2 = o11.$r8$clinit;
                ArrayList arrayList = new ArrayList(ae.y0(iterableSingleton));
                Iterator it3 = iterableSingleton.iterator();
                while (it3.hasNext()) {
                    arrayList.add(ym.g((ai0) it3.next()));
                }
                o11 o11Var = new o11();
                o11Var.addAll(arrayList);
                String str2 = l60.a;
                boolean zContainsKey = l60.j.containsKey(xm.g(onVar));
                cv cvVarG2 = ym.g(xc0VarF);
                qn qnVar = new qn(5, xc0VarF, ai0Var);
                ff0.b bVar = this.f;
                bVar.getClass();
                Object objInvoke = bVar.invoke(new ff0.e(cvVarG2, qnVar));
                if (objInvoke == null) {
                    throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction.computeIfAbsent must not return null");
                }
                Iterable iterable = (Iterable) f80Var.invoke(((ai0) objInvoke).Y());
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : iterable) {
                    q01 q01Var2 = (q01) obj2;
                    if (q01Var2.getKind() == la.a.b && q01Var2.getVisibility().a.b && !ub0.D(q01Var2)) {
                        Collection collectionD = q01Var2.d();
                        if (collectionD.isEmpty()) {
                            r6 = i;
                            if (!(l80.d.contains(e.q1((ai0) q01Var2.b(), e.o(q01Var2, 3))) ^ zContainsKey)) {
                                zBooleanValue = ((Boolean) ak.b(Collections.singletonList(q01Var2), e.a$1, new an(new ba(this), new boolean[i]))).booleanValue();
                            }
                            if (r6 != 0) {
                                r6 = zBooleanValue;
                            }
                        } else {
                            Iterator it4 = collectionD.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    r6 = i;
                                    if (!(l80.d.contains(e.q1((ai0) q01Var2.b(), e.o(q01Var2, 3))) ^ zContainsKey)) {
                                        zBooleanValue = ((Boolean) ak.b(Collections.singletonList(q01Var2), e.a$1, new an(new ba(this), new boolean[i]))).booleanValue();
                                    }
                                    z = r6 != 0;
                                } else if (o11Var.contains(ym.g(((ox) it4.next()).b()))) {
                                }
                                r6 = zBooleanValue;
                            }
                        }
                    } else {
                        r6 = zBooleanValue;
                    }
                    if (z) {
                        r6 = zBooleanValue;
                        arrayList2.add(obj2);
                    } else {
                        r6 = zBooleanValue;
                    }
                    i = 1;
                }
                list = arrayList2;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (q01 q01Var3 : list) {
            ox oxVarC = q01Var3.c(new ha1(e.L0((ai0) q01Var3.b(), onVar)));
            if (oxVarC == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                return null;
            }
            ox.a aVarS2 = ((q01) oxVarC).s();
            aVarS2.l(onVar);
            aVarS2.d(onVar.J0());
            aVarS2.o();
            int iOrdinal = ((a) ak.b(Collections.singletonList((ai0) q01Var3.b()), new bj(18, this), new an(e.o(q01Var3, 3), new vu0()))).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 2) {
                    ja0 ja0Var2 = ja0VarArr[2];
                    aVarS2.g((s4) this.g.invoke());
                } else if (iOrdinal == 3) {
                    q01Var = null;
                }
                q01Var = (q01) aVarS2.mo7build();
            } else if (onVar.o == zh0.b && onVar.q != 3) {
                q01Var = null;
            } else {
                aVarS2.f();
                q01Var = (q01) aVarS2.mo7build();
            }
            if (q01Var != null) {
                arrayList3.add(q01Var);
            }
        }
        return arrayList3;
    }

    @Override // defpackage.f3
    public final Collection c(on onVar) {
        g();
        xc0 xc0VarF = f(onVar);
        return xc0VarF == null ? yq.b : xc0VarF.K0().b();
    }

    @Override // defpackage.yo0
    public final boolean d(on onVar, bo boVar) {
        xc0 xc0VarF = f(onVar);
        if (xc0VarF == null || !boVar.getAnnotations().f(zo0.a)) {
            return true;
        }
        g();
        String strO = e.o(boVar, 3);
        Collection collectionA = xc0VarF.K0().a(boVar.getName(), dl0.b);
        if (collectionA.isEmpty()) {
            return false;
        }
        Iterator it = collectionA.iterator();
        while (it.hasNext()) {
            if (e.o((q01) it.next(), 3).equals(strO)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.f3
    public final Collection e(on onVar) {
        int i = ym.$r8$clinit;
        dv dvVarG = xm.g(onVar);
        LinkedHashSet linkedHashSet = l80.a;
        dv dvVar = m21.a.g;
        boolean zIsAssignableFrom = false;
        boolean z = dvVarG.equals(dvVar) || m21.a.b0.get(dvVarG) != null;
        u01 u01Var = this.d;
        if (z) {
            ja0 ja0Var = h[1];
            return Arrays.asList((u01) this.e.invoke(), u01Var);
        }
        if (dvVarG.equals(dvVar) || m21.a.b0.get(dvVarG) != null) {
            zIsAssignableFrom = true;
        } else {
            dd ddVarG = l60.g(dvVarG);
            if (ddVarG != null) {
                try {
                    zIsAssignableFrom = Serializable.class.isAssignableFrom(Class.forName(ddVarG.b().b()));
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        return zIsAssignableFrom ? Collections.singletonList(u01Var) : uq.b;
    }

    public final xc0 f(ai0 ai0Var) {
        dd ddVarG;
        if (ai0Var == null) {
            ub0.a(108);
            throw null;
        }
        ij0 ij0Var = ub0.e;
        if (!ub0.c(ai0Var, m21.a.a) && ub0.K(ai0Var)) {
            int i = ym.$r8$clinit;
            dv dvVarG = xm.g(ai0Var);
            if (dvVarG.e() && (ddVarG = l60.g(dvVarG)) != null) {
                ai0 ai0VarJ0 = e.j0(g().a, ddVarG.b());
                if (ai0VarJ0 instanceof xc0) {
                    return (xc0) ai0VarJ0;
                }
            }
        }
        return null;
    }

    public final w70.a g() {
        ja0 ja0Var = h[0];
        return (w70.a) this.c.invoke();
    }
}
