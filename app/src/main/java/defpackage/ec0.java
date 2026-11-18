package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum ec0 {
    v(true),
    w(true),
    x(false),
    y(true),
    z(true),
    A(true),
    B(true),
    C(true),
    D(true),
    E(true),
    F(true),
    G(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF3(false),
    H(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF6(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF0(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF2(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF3(false),
    I(false),
    J(false),
    K(false),
    L(false),
    M(false),
    N(false),
    O(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF331(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF342(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF353(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF364(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF375(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF386(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF397(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF408(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF419(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF430(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF441(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF452(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF463(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF474(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF485(false),
    /* JADX INFO: Fake field, exist only in values array */
    EF496(false);

    public static final HashMap c = new HashMap();
    public static final List d;
    public static final List f;
    public static final List g;
    public static final List i;
    public static final List j;
    public static final List n;
    public static final List o;
    public static final List p;
    public static final List q;
    public static final List r;
    public static final List s;
    public static final List t;
    public final boolean b;

    static {
        ec0[] ec0VarArrValues = values();
        int length = ec0VarArrValues.length;
        int i2 = 0;
        while (i2 < length) {
            ec0 ec0Var = ec0VarArrValues[i2];
            i2++;
            c.put(ec0Var.name(), ec0Var);
        }
        ec0[] ec0VarArrValues2 = values();
        ArrayList arrayList = new ArrayList();
        int length2 = ec0VarArrValues2.length;
        int i3 = 0;
        while (i3 < length2) {
            ec0 ec0Var2 = ec0VarArrValues2[i3];
            i3++;
            if (ec0Var2.b) {
                arrayList.add(ec0Var2);
            }
        }
        he.i1((Iterable) arrayList);
        ae.O0(values());
        ec0 ec0Var3 = v;
        d = Arrays.asList(w, ec0Var3);
        f = Arrays.asList(O, ec0Var3);
        g = Arrays.asList(I, ec0Var3);
        ec0 ec0Var4 = J;
        i = Arrays.asList(K, ec0Var4, ec0Var3);
        j = Arrays.asList(ec0Var4, ec0Var3);
        n = Arrays.asList(L, ec0Var3);
        o = Arrays.asList(M, ec0Var3);
        ec0 ec0Var5 = y;
        ec0 ec0Var6 = z;
        p = Arrays.asList(N, ec0Var5, ec0Var6);
        ec0 ec0Var7 = F;
        q = Collections.singletonList(ec0Var7);
        ec0 ec0Var8 = E;
        r = Collections.singletonList(ec0Var8);
        s = Collections.singletonList(D);
        ec0 ec0Var9 = H;
        t = Collections.singletonList(ec0Var9);
        o4 o4Var = o4.CONSTRUCTOR_PARAMETER;
        ec0 ec0Var10 = B;
        ye1.h(new jo0(o4Var, ec0Var10), new jo0(o4.FIELD, ec0Var6), new jo0(o4.PROPERTY, ec0Var5), new jo0(o4.FILE, ec0Var9), new jo0(o4.PROPERTY_GETTER, ec0Var8), new jo0(o4.PROPERTY_SETTER, ec0Var7), new jo0(o4.RECEIVER, ec0Var10), new jo0(o4.SETTER_PARAMETER, ec0Var10), new jo0(o4.PROPERTY_DELEGATE_FIELD, ec0Var6));
    }

    ec0(boolean z2) {
        this.b = z2;
    }
}
