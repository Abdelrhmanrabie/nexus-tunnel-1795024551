package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ca {
    public static final Object a;
    public static final LinkedHashMap b;
    public static final Set c;
    public static final Set d;

    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object, java.util.Map] */
    static {
        dv dvVar = m21.a.j;
        jo0 jo0Var = new jo0(dvVar.b(ij0.f(XMLRPC.TAG_NAME)).h(), ij0.f(XMLRPC.TAG_NAME));
        jo0 jo0Var2 = new jo0(dvVar.b(ij0.f("ordinal")).h(), ij0.f("ordinal"));
        jo0 jo0Var3 = new jo0(m21.a.A.c(ij0.f("size")), ij0.f("size"));
        cv cvVar = m21.a.E;
        Map mapH = ye1.h(jo0Var, jo0Var2, jo0Var3, new jo0(cvVar.c(ij0.f("size")), ij0.f("size")), new jo0(m21.a.e.b(ij0.f("length")).h(), ij0.f("length")), new jo0(cvVar.c(ij0.f("keys")), ij0.f("keySet")), new jo0(cvVar.c(ij0.f("values")), ij0.f("values")), new jo0(cvVar.c(ij0.f("entries")), ij0.f("entrySet")));
        a = mapH;
        Set<Map.Entry> setEntrySet = mapH.entrySet();
        ArrayList<jo0> arrayList = new ArrayList(ae.y0(setEntrySet));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new jo0(((cv) entry.getKey()).a.g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (jo0 jo0Var4 : arrayList) {
            ij0 ij0Var = (ij0) jo0Var4.c;
            Object arrayList2 = linkedHashMap.get(ij0Var);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(ij0Var, arrayList2);
            }
            ((List) arrayList2).add((ij0) jo0Var4.b);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(ye1.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), he.g1(he.h1((Iterable) entry2.getValue())));
        }
        b = linkedHashMap2;
        Set setKeySet = a.keySet();
        c = setKeySet;
        ArrayList arrayList3 = new ArrayList(ae.y0(setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList3.add(((cv) it.next()).a.g());
        }
        d = he.i1((Iterable) arrayList3);
    }
}
