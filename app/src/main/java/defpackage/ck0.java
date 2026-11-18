package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ck0 {
    public static final HashMap b = new HashMap();
    public final HashMap a = new HashMap();

    public static String b(Class cls) {
        HashMap map = b;
        String str = (String) map.get(cls);
        if (str != null) {
            return str;
        }
        bk0.a aVar = (bk0.a) cls.getAnnotation(bk0.a.class);
        String strValue = aVar != null ? aVar.value() : null;
        if (strValue == null || strValue.isEmpty()) {
            throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()));
        }
        map.put(cls, strValue);
        return strValue;
    }

    public final void a(bk0 bk0Var) {
        String strB = b(bk0Var.getClass());
        if (strB.isEmpty()) {
            d.AnonymousClass0.m$2("navigator name cannot be an empty string");
        }
    }
}
