package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xc implements vk {
    public final qt0 a;
    public final oc0 b;
    public final i c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final LinkedHashMap f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [nw, oc0] */
    /* JADX WARN: Type inference failed for: r6v6, types: [nw, oc0] */
    public xc(qt0 qt0Var, nw nwVar) {
        this.a = qt0Var;
        this.b = (oc0) nwVar;
        i iVar = new i(17, this);
        this.c = iVar;
        ht htVarY = fz0.y(new ge(0, qt0Var.A()), iVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        et.b bVar = new et.b(htVarY);
        while (bVar.hasNext()) {
            Object next = bVar.next();
            ij0 name = ((au0) next).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(next);
        }
        this.d = linkedHashMap;
        ht htVarY2 = fz0.y(new ge(0, this.a.getFields()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        et.b bVar2 = new et.b(htVarY2);
        while (bVar2.hasNext()) {
            Object next2 = bVar2.next();
            linkedHashMap2.put(((xt0) next2).getName(), next2);
        }
        this.e = linkedHashMap2;
        ArrayList arrayListK = this.a.k();
        ?? r6 = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayListK) {
            if (((Boolean) r6.invoke(obj)).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        int iE = ye1.e(ae.y0(arrayList2));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iE < 16 ? 16 : iE);
        for (Object obj2 : arrayList2) {
            linkedHashMap3.put(((eu0) obj2).getName(), obj2);
        }
        this.f = linkedHashMap3;
    }

    @Override // defpackage.vk
    public final Set a() {
        ht htVarY = fz0.y(new ge(0, this.a.A()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        et.b bVar = new et.b(htVarY);
        while (bVar.hasNext()) {
            linkedHashSet.add(((au0) bVar.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // defpackage.vk
    public final xt0 b(ij0 ij0Var) {
        return (xt0) this.e.get(ij0Var);
    }

    @Override // defpackage.vk
    public final Set c() {
        return this.f.keySet();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [nw, oc0] */
    @Override // defpackage.vk
    public final Set d() {
        ht htVarY = fz0.y(new ge(0, this.a.getFields()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        et.b bVar = new et.b(htVarY);
        while (bVar.hasNext()) {
            linkedHashSet.add(((xt0) bVar.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // defpackage.vk
    public final eu0 e(ij0 ij0Var) {
        return (eu0) this.f.get(ij0Var);
    }

    @Override // defpackage.vk
    public final Collection f(ij0 ij0Var) {
        List list = (List) this.d.get(ij0Var);
        return list == null ? uq.b : list;
    }
}
