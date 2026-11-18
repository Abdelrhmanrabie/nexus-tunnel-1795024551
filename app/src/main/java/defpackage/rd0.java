package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
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
public final class rd0 extends sd0 {
    public final qt0 n;
    public final xc0 o;

    public rd0(v8 v8Var, qt0 qt0Var, xc0 xc0Var) {
        super(v8Var, null);
        this.n = qt0Var;
        this.o = xc0Var;
    }

    public static nq0 v(nq0 nq0Var) {
        if (nq0Var.getKind() != la.a.c) {
            return nq0Var;
        }
        Collection collectionD = nq0Var.d();
        ArrayList arrayList = new ArrayList(ae.y0(collectionD));
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            arrayList.add(v((nq0) it.next()));
        }
        return (nq0) he.a1(he.g1(he.h1(arrayList)));
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        return null;
    }

    @Override // defpackage.jd0
    public final Set h(lm lmVar, p0 p0Var) {
        return yq.b;
    }

    @Override // defpackage.jd0
    public final Set i(lm lmVar, p0 p0Var) {
        LinkedHashSet linkedHashSetH1 = he.h1(((vk) this.e.invoke()).a());
        rd0 rd0VarR0 = e.R0(this.o);
        Set setB = rd0VarR0 == null ? null : rd0VarR0.b();
        if (setB == null) {
            setB = yq.b;
        }
        linkedHashSetH1.addAll(setB);
        if (this.n.a.isEnum()) {
            linkedHashSetH1.addAll(Arrays.asList(m21.b, m21.a));
        }
        ((c60) this.b.a).x.getClass();
        linkedHashSetH1.addAll(new ArrayList());
        return linkedHashSetH1;
    }

    @Override // defpackage.jd0
    public final void j(ij0 ij0Var, ArrayList arrayList) {
        ((c60) this.b.a).x.getClass();
    }

    @Override // defpackage.jd0
    public final vk k() {
        return new xc(this.n, ld0.b$8);
    }

    @Override // defpackage.jd0
    public final void m(LinkedHashSet linkedHashSet, ij0 ij0Var) {
        q01 q01VarE;
        xc0 xc0Var = this.o;
        rd0 rd0VarR0 = e.R0(xc0Var);
        Collection collectionI1 = rd0VarR0 == null ? yq.b : he.i1(rd0VarR0.a(ij0Var, dl0.g));
        c60 c60Var = (c60) this.b.a;
        linkedHashSet.addAll(e.n1(ij0Var, collectionI1, linkedHashSet, this.o, c60Var.f, ((yk0) c60Var.u).e));
        if (this.n.a.isEnum()) {
            if (ij0Var.equals(m21.b)) {
                q01VarE = b2.d(xc0Var);
            } else if (!ij0Var.equals(m21.a)) {
                return;
            } else {
                q01VarE = b2.e(xc0Var);
            }
            linkedHashSet.add(q01VarE);
        }
    }

    @Override // defpackage.sd0, defpackage.jd0
    public final void n(ij0 ij0Var, ArrayList arrayList) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f80 f80Var = new f80(ij0Var, 1);
        xc0 xc0Var = this.o;
        ak.b(Collections.singletonList(xc0Var), e.l, new qd0(xc0Var, linkedHashSet, f80Var));
        boolean zIsEmpty = arrayList.isEmpty();
        v8 v8Var = this.b;
        if (!zIsEmpty) {
            c60 c60Var = (c60) v8Var.a;
            arrayList.addAll(e.n1(ij0Var, linkedHashSet, arrayList, this.o, c60Var.f, ((yk0) c60Var.u).e));
            return;
        }
        ij0 ij0Var2 = ij0Var;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            nq0 nq0VarV = v((nq0) obj);
            Object arrayList2 = linkedHashMap.get(nq0VarV);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(nq0VarV, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collection = (Collection) ((Map.Entry) it.next()).getValue();
            c60 c60Var2 = (c60) v8Var.a;
            ij0 ij0Var3 = ij0Var2;
            he.C0(e.n1(ij0Var3, collection, arrayList, this.o, c60Var2.f, ((yk0) c60Var2.u).e), arrayList3);
            ij0Var2 = ij0Var3;
        }
        arrayList.addAll(arrayList3);
    }

    @Override // defpackage.jd0
    public final Set o() {
        LinkedHashSet linkedHashSetH1 = he.h1(((vk) this.e.invoke()).d());
        ld0 ld0Var = ld0.b$27;
        xc0 xc0Var = this.o;
        ak.b(Collections.singletonList(xc0Var), e.l, new qd0(xc0Var, linkedHashSetH1, ld0Var));
        return linkedHashSetH1;
    }

    @Override // defpackage.jd0
    public final ok q() {
        return this.o;
    }
}
