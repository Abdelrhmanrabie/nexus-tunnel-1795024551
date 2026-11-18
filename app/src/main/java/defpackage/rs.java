package defpackage;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class rs {
    public static final HashMap a = new HashMap();

    static {
        b(m21.a.J, a("java.util.ArrayList", "java.util.LinkedList"));
        b(m21.a.L, a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b(m21.a.M, a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b(new cv("java.util.function.Function"), a("java.util.function.UnaryOperator"));
        b(new cv("java.util.function.BiFunction"), a("java.util.function.BinaryOperator"));
    }

    public static ArrayList a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            arrayList.add(new cv(str));
        }
        return arrayList;
    }

    public static void b(cv cvVar, ArrayList arrayList) {
        for (Object obj : arrayList) {
            a.put(obj, cvVar);
        }
    }
}
