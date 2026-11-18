package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class h50 {
    public static final cn.d a;
    public static final cn.d b;
    public static final cn.d c;
    public static final HashMap d;

    static {
        a70 a70Var = a70.c$10;
        cn.d dVar = new cn.d(a70Var, 9);
        a = dVar;
        a70 a70Var2 = a70.c;
        cn.d dVar2 = new cn.d(a70Var2, 10);
        b = dVar2;
        a70 a70Var3 = a70.c$11;
        cn.d dVar3 = new cn.d(a70Var3, 11);
        c = dVar3;
        HashMap map = new HashMap();
        d = map;
        map.put(a70Var, dVar);
        map.put(a70Var2, dVar2);
        map.put(a70Var3, dVar3);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean c(uk ukVar, ok okVar) {
        if (ukVar == null) {
            a(2);
            throw null;
        }
        if (okVar == null) {
            a(3);
            throw null;
        }
        wn0 wn0Var = (wn0) xm.i(ukVar, wn0.class, false);
        wn0 wn0Var2 = (wn0) xm.i(okVar, wn0.class, false);
        return (wn0Var2 == null || wn0Var == null || !((xn0) wn0Var).g.equals(((xn0) wn0Var2).g)) ? false : true;
    }
}
