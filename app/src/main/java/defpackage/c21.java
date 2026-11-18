package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class c21 {
    public static final ArrayList b;
    public static final ArrayList c;
    public static final Object d;
    public static final LinkedHashMap e;
    public static final Set f;
    public static final Set g;
    public static final c21$a$a h;
    public static final Object i;
    public static final LinkedHashMap j;
    public static final ArrayList k;
    public static final LinkedHashMap l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b {
        public static final b c;
        public static final b d;
        public static final b f;
        public static final a g;
        public static final /* synthetic */ b[] i;
        public final Object b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends b {
        }

        static {
            b bVar = new b("NULL", 0, null);
            c = bVar;
            b bVar2 = new b("INDEX", 1, -1);
            d = bVar2;
            b bVar3 = new b("FALSE", 2, Boolean.FALSE);
            f = bVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3, null);
            g = aVar;
            i = new b[]{bVar, bVar2, bVar3, aVar};
        }

        public b(String str, int i2, Object obj) {
            super(str, i2);
            this.b = obj;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) i.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object, java.util.Map] */
    static {
        Set setO0 = ae.O0(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(ae.y0(setO0));
        Iterator it = setO0.iterator();
        while (it.hasNext()) {
            arrayList.add(e.a("java/util/Collection", (String) it.next(), "Ljava/util/Collection;", u80.BOOLEAN.d));
        }
        b = arrayList;
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((c21$a$a) it2.next()).b);
        }
        c = arrayList2;
        ArrayList arrayList3 = b;
        ArrayList arrayList4 = new ArrayList(ae.y0(arrayList3));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((c21$a$a) it3.next()).a.b());
        }
        String strJ = e4.j("java/util/", "Collection");
        String str = u80.BOOLEAN.d;
        c21$a$a c21_a_aA = e.a(strJ, "contains", "Ljava/lang/Object;", str);
        b bVar = b.f;
        jo0 jo0Var = new jo0(c21_a_aA, bVar);
        jo0 jo0Var2 = new jo0(e.a(e4.j("java/util/", "Collection"), "remove", "Ljava/lang/Object;", str), bVar);
        jo0 jo0Var3 = new jo0(e.a(e4.j("java/util/", "Map"), "containsKey", "Ljava/lang/Object;", str), bVar);
        jo0 jo0Var4 = new jo0(e.a(e4.j("java/util/", "Map"), "containsValue", "Ljava/lang/Object;", str), bVar);
        jo0 jo0Var5 = new jo0(e.a(e4.j("java/util/", "Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", str), bVar);
        jo0 jo0Var6 = new jo0(e.a(e4.j("java/util/", "Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.g);
        c21$a$a c21_a_aA2 = e.a(e4.j("java/util/", "Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        b bVar2 = b.c;
        jo0 jo0Var7 = new jo0(c21_a_aA2, bVar2);
        jo0 jo0Var8 = new jo0(e.a(e4.j("java/util/", "Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), bVar2);
        String strJ2 = e4.j("java/util/", "List");
        u80 u80Var = u80.INT;
        c21$a$a c21_a_aA3 = e.a(strJ2, "indexOf", "Ljava/lang/Object;", u80Var.d);
        b bVar3 = b.d;
        Map mapH = ye1.h(jo0Var, jo0Var2, jo0Var3, jo0Var4, jo0Var5, jo0Var6, jo0Var7, jo0Var8, new jo0(c21_a_aA3, bVar3), new jo0(e.a(e4.j("java/util/", "List"), "lastIndexOf", "Ljava/lang/Object;", u80Var.d), bVar3));
        d = mapH;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ye1.e(mapH.size()));
        for (Map.Entry entry : mapH.entrySet()) {
            linkedHashMap.put(((c21$a$a) entry.getKey()).b, entry.getValue());
        }
        e = linkedHashMap;
        LinkedHashSet linkedHashSetX1 = nz0.x1(d.keySet(), b);
        ArrayList arrayList5 = new ArrayList(ae.y0(linkedHashSetX1));
        Iterator it4 = linkedHashSetX1.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((c21$a$a) it4.next()).a);
        }
        f = he.i1((Iterable) arrayList5);
        ArrayList arrayList6 = new ArrayList(ae.y0(linkedHashSetX1));
        Iterator it5 = linkedHashSetX1.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((c21$a$a) it5.next()).b);
        }
        g = he.i1((Iterable) arrayList6);
        String str2 = u80.INT.d;
        c21$a$a c21_a_aA4 = e.a("java/util/List", "removeAt", str2, "Ljava/lang/Object;");
        h = c21_a_aA4;
        Map mapH2 = ye1.h(new jo0(e.a(e4.j("java/lang/", "Number"), "toByte", AppConfig.CUSTOM, u80.BYTE.d), ij0.f("byteValue")), new jo0(e.a(e4.j("java/lang/", "Number"), "toShort", AppConfig.CUSTOM, u80.SHORT.d), ij0.f("shortValue")), new jo0(e.a(e4.j("java/lang/", "Number"), "toInt", AppConfig.CUSTOM, str2), ij0.f("intValue")), new jo0(e.a(e4.j("java/lang/", "Number"), "toLong", AppConfig.CUSTOM, u80.LONG.d), ij0.f("longValue")), new jo0(e.a(e4.j("java/lang/", "Number"), "toFloat", AppConfig.CUSTOM, u80.FLOAT.d), ij0.f("floatValue")), new jo0(e.a(e4.j("java/lang/", "Number"), "toDouble", AppConfig.CUSTOM, u80.DOUBLE.d), ij0.f("doubleValue")), new jo0(c21_a_aA4, ij0.f("remove")), new jo0(e.a(e4.j("java/lang/", "CharSequence"), "get", str2, u80.CHAR.d), ij0.f("charAt")));
        i = mapH2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(ye1.e(mapH2.size()));
        for (Map.Entry entry2 : mapH2.entrySet()) {
            linkedHashMap2.put(((c21$a$a) entry2.getKey()).b, entry2.getValue());
        }
        j = linkedHashMap2;
        Set setKeySet = i.keySet();
        ArrayList arrayList7 = new ArrayList(ae.y0(setKeySet));
        Iterator it6 = setKeySet.iterator();
        while (it6.hasNext()) {
            arrayList7.add(((c21$a$a) it6.next()).a);
        }
        k = arrayList7;
        Set<Map.Entry> setEntrySet = i.entrySet();
        ArrayList<jo0> arrayList8 = new ArrayList(ae.y0(setEntrySet));
        for (Map.Entry entry3 : setEntrySet) {
            arrayList8.add(new jo0(((c21$a$a) entry3.getKey()).a, entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (jo0 jo0Var9 : arrayList8) {
            ij0 ij0Var = (ij0) jo0Var9.c;
            Object arrayList9 = linkedHashMap3.get(ij0Var);
            if (arrayList9 == null) {
                arrayList9 = new ArrayList();
                linkedHashMap3.put(ij0Var, arrayList9);
            }
            ((List) arrayList9).add((ij0) jo0Var9.b);
        }
        l = linkedHashMap3;
    }
}
