package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class id implements h90, sc {
    public static final Map c;
    public static final HashMap d;
    public final Class b;

    static {
        int i = 0;
        List listAsList = Arrays.asList(lw.class, nw.class, bx.class, cx.class, dx.class, ex.class, fx.class, gx.class, hx.class, ix.class, mw.class, ow.class, pw.class, qw.class, rw.class, sw.class, tw.class, uw.class, vw.class, ww.class, yw.class, zw.class, ax.class);
        ArrayList arrayList = new ArrayList(ae.y0(listAsList));
        for (Object obj : listAsList) {
            int i2 = i + 1;
            if (i < 0) {
                e.q0();
                throw null;
            }
            arrayList.add(new jo0((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        c = ye1.j(arrayList);
        HashMap map = new HashMap();
        map.put(XMLRPC.TYPE_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put(XMLRPC.TYPE_INT, "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put(XMLRPC.TYPE_DOUBLE, "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        for (String str : map.values()) {
            map3.put("kotlin.jvm.internal." + q31.y0(str, '.') + "CompanionObject", str.concat(".Companion"));
        }
        for (Map.Entry entry : c.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        d = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ye1.e(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), q31.y0((String) entry2.getValue(), '.'));
        }
    }

    public id(Class cls) {
        this.b = cls;
    }

    @Override // defpackage.sc
    public final Class d() {
        return this.b;
    }

    @Override // defpackage.h90
    public final String e() {
        String str;
        Class cls = this.b;
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        boolean zIsArray = cls.isArray();
        HashMap map = d;
        if (!zIsArray) {
            String str2 = (String) map.get(cls.getName());
            return str2 == null ? cls.getCanonicalName() : str2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (str = (String) map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof id) && e.C(this).equals(e.C((h90) obj));
    }

    public final int hashCode() {
        return e.C(this).hashCode();
    }

    public final String toString() {
        return this.b + " (Kotlin reflection is not available)";
    }
}
