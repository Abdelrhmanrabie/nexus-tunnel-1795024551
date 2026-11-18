package defpackage;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum sm {
    f(true),
    g(true),
    i(true),
    j(false),
    n(true),
    o(true),
    p(true),
    q(true),
    r(true),
    s(true),
    t(true),
    u(true),
    v(true),
    w(true);

    public static final Set c;
    public static final Set d;
    public final boolean b;

    static {
        sm[] smVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        int length = smVarArrValues.length;
        int i2 = 0;
        while (i2 < length) {
            sm smVar = smVarArrValues[i2];
            i2++;
            if (smVar.b) {
                arrayList.add(smVar);
            }
        }
        c = he.i1((Iterable) arrayList);
        d = ae.O0(values());
    }

    sm(boolean z) {
        this.b = z;
    }
}
