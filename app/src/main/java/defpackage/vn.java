package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class vn extends wg0 {
    public static final /* synthetic */ ja0[] f;
    public final hn b;
    public final b c;
    public final ff0.h d;
    public final ff0.f e;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public static final /* synthetic */ ja0[] j;
        public final LinkedHashMap a;
        public final LinkedHashMap b;
        public final LinkedHashMap c;
        public final ff0.c d;
        public final ff0.c e;
        public final ff0.j f;
        public final ff0.h g;
        public final ff0.h h;

        /* JADX INFO: renamed from: vn$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0045b extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ b b;
            public final /* synthetic */ vn c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0045b(b bVar, vn vnVar, int i) {
                super(0);
                this.G0 = i;
                this.b = bVar;
                this.c = vnVar;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                Set setKeySet;
                Set setO$1;
                int i = this.G0;
                b bVar = this.b;
                if (i != 0) {
                    setKeySet = bVar.b.keySet();
                    setO$1 = this.c.p();
                } else {
                    setKeySet = bVar.a.keySet();
                    setO$1 = this.c.o$1();
                }
                return nz0.x1(setKeySet, setO$1);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends oc0 implements nw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(b bVar, int i) {
                super(1);
                this.G0 = i;
                this.b = bVar;
            }

            /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object, java.util.Map] */
            @Override // defpackage.nw
            public final Object invoke(Object obj) {
                hn hnVar;
                fi0 fi0Var;
                jj0 jj0Var;
                String str;
                nr0 nr0VarA;
                nr0 nr0VarA2;
                int i = this.G0;
                ij0 ij0Var = (ij0) obj;
                b bVar = this.b;
                int i2 = 2;
                if (i == 0) {
                    LinkedHashMap linkedHashMap = bVar.a;
                    ar0.a aVar = fr0.y;
                    byte[] bArr = (byte[]) linkedHashMap.get(ij0Var);
                    vn vnVar = vn.this;
                    Collection collectionE = bArr == null ? uq.b : fz0.E(fz0.v(new k90(aVar, new ByteArrayInputStream(bArr), vnVar, i2)));
                    ArrayList arrayList = new ArrayList(collectionE.size());
                    Iterator it = collectionE.iterator();
                    while (it.hasNext()) {
                        bo boVarE = vnVar.b.i.e((fr0) it.next());
                        if (!vnVar.r(boVarE)) {
                            boVarE = null;
                        }
                        if (boVarE != null) {
                            arrayList.add(boVarE);
                        }
                    }
                    vnVar.j(ij0Var, arrayList);
                    return e.G0(arrayList);
                }
                if (i == 1) {
                    LinkedHashMap linkedHashMap2 = bVar.b;
                    ar0.a aVar2 = kr0.y;
                    byte[] bArr2 = (byte[]) linkedHashMap2.get(ij0Var);
                    vn vnVar2 = vn.this;
                    Collection collectionE2 = bArr2 == null ? uq.b : fz0.E(fz0.v(new k90(aVar2, new ByteArrayInputStream(bArr2), vnVar2, i2)));
                    ArrayList arrayList2 = new ArrayList(collectionE2.size());
                    Iterator it2 = collectionE2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(vnVar2.b.i.f((kr0) it2.next()));
                    }
                    vnVar2.k(ij0Var, arrayList2);
                    return e.G0(arrayList2);
                }
                byte[] bArr3 = (byte[]) bVar.c.get(ij0Var);
                if (bArr3 != null) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr3);
                    hn hnVar2 = vn.this.b;
                    or0 or0Var = (or0) or0.v.c(byteArrayInputStream, hnVar2.a.p);
                    if (or0Var != null) {
                        rg0 rg0Var = hnVar2.i;
                        rg0Var.getClass();
                        List list = or0Var.q;
                        ArrayList arrayList3 = new ArrayList(ae.y0(list));
                        Iterator it3 = list.iterator();
                        while (true) {
                            boolean zHasNext = it3.hasNext();
                            hnVar = rg0Var.a;
                            fi0Var = hnVar.d;
                            jj0Var = hnVar.b;
                            if (!zHasNext) {
                                break;
                            }
                            arrayList3.add(rg0Var.b.a((yq0) it3.next(), jj0Var));
                        }
                        co coVar = new co(hnVar.a.a, hnVar.c, arrayList3.isEmpty() ? e4.f47a : new t4(0, arrayList3), e.E(jj0Var, or0Var.g), ui.a((ur0) xt.d.c(or0Var.f)), or0Var, hnVar.b, fi0Var, hnVar.e, hnVar.g);
                        e91 e91Var = hn.b(hnVar, coVar, or0Var.i).h;
                        List listG1 = he.g1(e91Var.g.values());
                        int i3 = or0Var.d;
                        if ((i3 & 4) != 4) {
                            if ((i3 & 8) == 8) {
                                nr0VarA = fi0Var.a(or0Var.n);
                            } else {
                                str = "No underlyingType in ProtoBuf.TypeAlias";
                            }
                            d.AnonymousClass0.m(str);
                            return null;
                        }
                        nr0VarA = or0Var.j;
                        u01 u01VarD = e91Var.d(nr0VarA, false);
                        int i4 = or0Var.d;
                        if ((i4 & 16) == 16) {
                            nr0VarA2 = or0Var.o;
                        } else {
                            if ((i4 & 32) != 32) {
                                str = "No expandedType in ProtoBuf.TypeAlias";
                                d.AnonymousClass0.m(str);
                                return null;
                            }
                            nr0VarA2 = fi0Var.a(or0Var.p);
                        }
                        coVar.G0(listG1, u01VarD, e91Var.d(nr0VarA2, false));
                        return coVar;
                    }
                }
                return null;
            }
        }

        static {
            pu0 pu0Var = ou0.a;
            j = new ja0[]{pu0Var.f(new tq0(pu0Var.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), pu0Var.f(new tq0(pu0Var.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public b(List list, List list2, List list3) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                ij0 ij0VarE = e.E(vn.this.b.b, ((fr0) ((b0) obj)).i);
                Object arrayList = linkedHashMap.get(ij0VarE);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(ij0VarE, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.a = h(linkedHashMap);
            vn vnVar = vn.this;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                ij0 ij0VarE2 = e.E(vnVar.b.b, ((kr0) ((b0) obj2)).i);
                Object arrayList2 = linkedHashMap2.get(ij0VarE2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(ij0VarE2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.b = h(linkedHashMap2);
            vn.this.b.a.c.getClass();
            vn vnVar2 = vn.this;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj3 : list3) {
                ij0 ij0VarE3 = e.E(vnVar2.b.b, ((or0) ((b0) obj3)).g);
                Object arrayList3 = linkedHashMap3.get(ij0VarE3);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap3.put(ij0VarE3, arrayList3);
                }
                ((List) arrayList3).add(obj3);
            }
            this.c = h(linkedHashMap3);
            int i = 0;
            this.d = vn.this.b.a.a.g(new c(this, i));
            int i2 = 1;
            this.e = vn.this.b.a.a.g(new c(this, i2));
            this.f = vn.this.b.a.a.d(new c(this, 2));
            vn vnVar3 = vn.this;
            ff0 ff0Var = vnVar3.b.a.a;
            C0045b c0045b = new C0045b(this, vnVar3, i);
            ff0Var.getClass();
            this.g = new ff0.h(ff0Var, c0045b);
            vn vnVar4 = vn.this;
            ff0 ff0Var2 = vnVar4.b.a.a;
            C0045b c0045b2 = new C0045b(this, vnVar4, i2);
            ff0Var2.getClass();
            this.h = new ff0.h(ff0Var2, c0045b2);
        }

        public static LinkedHashMap h(LinkedHashMap linkedHashMap) throws IOException {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(ye1.e(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<b0> iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(ae.y0(iterable));
                for (b0 b0Var : iterable) {
                    int serializedSize = b0Var.getSerializedSize();
                    int iF = yd.f(serializedSize) + serializedSize;
                    if (iF > 4096) {
                        iF = 4096;
                    }
                    yd ydVarJ = yd.j(byteArrayOutputStream, iF);
                    ydVarJ.v(serializedSize);
                    b0Var.a(ydVarJ);
                    ydVarJ.k();
                    arrayList.add(tb1.a);
                }
                linkedHashMap2.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap2;
        }

        public final Collection a(ij0 ij0Var) {
            ja0 ja0Var = j[0];
            return !((Set) this.g.invoke()).contains(ij0Var) ? uq.b : (Collection) this.d.invoke(ij0Var);
        }

        public final Collection c(ij0 ij0Var) {
            ja0 ja0Var = j[1];
            return !((Set) this.h.invoke()).contains(ij0Var) ? uq.b : (Collection) this.e.invoke(ij0Var);
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        f = new ja0[]{pu0Var.f(new tq0(pu0Var.b(vn.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), pu0Var.f(new tq0(pu0Var.b(vn.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public vn(hn hnVar, List list, List list2, List list3, lw lwVar) {
        this.b = hnVar;
        fn fnVar = hnVar.a;
        fnVar.c.getClass();
        this.c = new b(list, list2, list3);
        ca0 ca0Var = new ca0(lwVar);
        ff0 ff0Var = fnVar.a;
        ff0Var.getClass();
        this.d = new ff0.h(ff0Var, ca0Var);
        this.e = new ff0.f(ff0Var, new ca0(23, this));
    }

    @Override // defpackage.wg0, defpackage.vg0
    public Collection a(ij0 ij0Var, dl0 dl0Var) {
        return this.c.a(ij0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set b() {
        b bVar = this.c;
        bVar.getClass();
        ja0 ja0Var = b.j[0];
        return (Set) bVar.g.invoke();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public Collection c(ij0 ij0Var, dl0 dl0Var) {
        return this.c.c(ij0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set d() {
        b bVar = this.c;
        bVar.getClass();
        ja0 ja0Var = b.j[1];
        return (Set) bVar.h.invoke();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public od e(ij0 ij0Var, dl0 dl0Var) {
        if (!q(ij0Var)) {
            b bVar = this.c;
            if (bVar.c.keySet().contains(ij0Var)) {
                return (co) bVar.f.invoke(ij0Var);
            }
            return null;
        }
        fn fnVar = this.b.a;
        dd ddVarL = l(ij0Var);
        Set set = cd.c;
        cd cdVar = fnVar.s;
        cdVar.getClass();
        return (ai0) cdVar.b.invoke(new cd.a(ddVarL, null));
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set g() {
        ja0 ja0Var = f[1];
        return (Set) this.e.invoke();
    }

    public abstract void h(ArrayList arrayList);

    public final List i(lm lmVar, nw nwVar) {
        ArrayList arrayList = new ArrayList(0);
        if (lmVar.a(lm.f)) {
            h(arrayList);
        }
        b bVar = this.c;
        bVar.getClass();
        dl0 dl0Var = dl0.b;
        boolean zA = lmVar.a(lm.j);
        nu nuVar = nu.b;
        if (zA) {
            ja0 ja0Var = b.j[1];
            Set<ij0> set = (Set) bVar.h.invoke();
            ArrayList arrayList2 = new ArrayList();
            for (ij0 ij0Var : set) {
                if (((Boolean) nwVar.invoke(ij0Var)).booleanValue()) {
                    arrayList2.addAll(bVar.c(ij0Var));
                }
            }
            if (arrayList2.size() > 1) {
                Collections.sort(arrayList2, nuVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (lmVar.a(lm.i)) {
            ja0 ja0Var2 = b.j[0];
            Set<ij0> set2 = (Set) bVar.g.invoke();
            ArrayList arrayList3 = new ArrayList();
            for (ij0 ij0Var2 : set2) {
                if (((Boolean) nwVar.invoke(ij0Var2)).booleanValue()) {
                    arrayList3.addAll(bVar.a(ij0Var2));
                }
            }
            if (arrayList3.size() > 1) {
                Collections.sort(arrayList3, nuVar);
            }
            arrayList.addAll(arrayList3);
        }
        if (lmVar.a(lm.l)) {
            for (ij0 ij0Var3 : m()) {
                if (((Boolean) nwVar.invoke(ij0Var3)).booleanValue()) {
                    fn fnVar = this.b.a;
                    dd ddVarL = l(ij0Var3);
                    Set set3 = cd.c;
                    cd cdVar = fnVar.s;
                    cdVar.getClass();
                    e.s0(arrayList, (ai0) cdVar.b.invoke(new cd.a(ddVarL, null)));
                }
            }
        }
        if (lmVar.a(lm.g)) {
            for (Object obj : bVar.c.keySet()) {
                if (((Boolean) nwVar.invoke(obj)).booleanValue()) {
                    e.s0(arrayList, (co) bVar.f.invoke(obj));
                }
            }
        }
        return e.G0(arrayList);
    }

    public void j(ij0 ij0Var, ArrayList arrayList) {
    }

    public void k(ij0 ij0Var, ArrayList arrayList) {
    }

    public abstract dd l(ij0 ij0Var);

    public final Set m() {
        ja0 ja0Var = f[0];
        return (Set) this.d.invoke();
    }

    public abstract Set n();

    public abstract Set o$1();

    public abstract Set p();

    public boolean q(ij0 ij0Var) {
        return m().contains(ij0Var);
    }

    public boolean r(bo boVar) {
        return true;
    }
}
