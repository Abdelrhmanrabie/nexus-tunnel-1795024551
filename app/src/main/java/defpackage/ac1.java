package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ac1 {
    public static final Set a;
    public static final HashMap b;
    public static final HashMap c;
    public static final LinkedHashSet d;

    static {
        zb1[] zb1VarArrValues = zb1.values();
        ArrayList arrayList = new ArrayList(zb1VarArrValues.length);
        int length = zb1VarArrValues.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            zb1 zb1Var = zb1VarArrValues[i2];
            i2++;
            arrayList.add(zb1Var.c);
        }
        a = he.i1((Iterable) arrayList);
        yb1[] yb1VarArrValues = yb1.values();
        ArrayList arrayList2 = new ArrayList(yb1VarArrValues.length);
        int length2 = yb1VarArrValues.length;
        int i3 = 0;
        while (i3 < length2) {
            yb1 yb1Var = yb1VarArrValues[i3];
            i3++;
            arrayList2.add(yb1Var.b);
        }
        he.i1((Iterable) arrayList2);
        b = new HashMap();
        c = new HashMap();
        jo0[] jo0VarArr = {new jo0(yb1.UBYTEARRAY, ij0.f("ubyteArrayOf")), new jo0(yb1.USHORTARRAY, ij0.f("ushortArrayOf")), new jo0(yb1.UINTARRAY, ij0.f("uintArrayOf")), new jo0(yb1.ULONGARRAY, ij0.f("ulongArrayOf"))};
        HashMap map = new HashMap(ye1.e(4));
        for (int i4 = 0; i4 < 4; i4++) {
            jo0 jo0Var = jo0VarArr[i4];
            map.put(jo0Var.b, jo0Var.c);
        }
        zb1[] zb1VarArrValues2 = zb1.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length3 = zb1VarArrValues2.length;
        int i5 = 0;
        while (i5 < length3) {
            zb1 zb1Var2 = zb1VarArrValues2[i5];
            i5++;
            linkedHashSet.add(zb1Var2.d.j());
        }
        d = linkedHashSet;
        zb1[] zb1VarArrValues3 = zb1.values();
        int length4 = zb1VarArrValues3.length;
        while (i < length4) {
            zb1 zb1Var3 = zb1VarArrValues3[i];
            i++;
            HashMap map2 = b;
            dd ddVar = zb1Var3.d;
            dd ddVar2 = zb1Var3.b;
            map2.put(ddVar, ddVar2);
            c.put(ddVar2, zb1Var3.d);
        }
    }

    public static final boolean a(fc0 fc0Var) {
        od odVarB;
        if (ma1.p(fc0Var) || (odVarB = fc0Var.L0().b()) == null) {
            return false;
        }
        ok okVarB = odVarB.b();
        return (okVarB instanceof wn0) && e4.a(((xn0) ((wn0) okVarB)).g, m21.i) && a.contains(odVarB.getName());
    }
}
