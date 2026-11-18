package defpackage;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tn {
    public static final Set b = Collections.singleton(wb0.a.CLASS);
    public static final Set c = ae.O0(new wb0.a[]{wb0.a.FILE_FACADE, wb0.a.MULTIFILE_CLASS_PART});
    public static final q80 d;
    public static final q80 e;
    public fn a;

    static {
        new q80(new int[]{1, 1, 2}, false);
        d = new q80(new int[]{1, 1, 11}, false);
        e = new q80(new int[]{1, 1, 13}, false);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    public final zn a(xn0 xn0Var, ju0 ju0Var) {
        jo0 jo0VarH;
        wb0 wb0Var = ju0Var.b;
        q80 q80Var = wb0Var.b;
        String[] strArr = wb0Var.c;
        if (strArr == null) {
            strArr = wb0Var.d;
        }
        if (strArr == null) {
            strArr = null;
        } else {
            if (!c.contains(wb0Var.a)) {
                strArr = null;
            }
        }
        if (strArr != null) {
            String[] strArr2 = wb0Var.e;
            try {
                if (strArr2 != null) {
                    try {
                        jo0VarH = x80.h(strArr, strArr2);
                        if (jo0VarH != null) {
                            r80 r80Var = (r80) jo0VarH.b;
                            ir0 ir0Var = (ir0) jo0VarH.c;
                            d(ju0Var);
                            e(ju0Var);
                            s80 s80Var = new s80(ju0Var, ir0Var, r80Var, b(ju0Var));
                            fn fnVar = this.a;
                            fnVar.getClass();
                            return new zn(xn0Var, ir0Var, r80Var, q80Var, s80Var, fnVar, "scope for " + s80Var + " in " + xn0Var, r2.b$4);
                        }
                    } catch (t30 e2) {
                        throw new IllegalStateException(e4.j("Could not read data from ", ju0Var.getLocation()), e2);
                    }
                }
            } catch (Throwable th) {
                fn fnVar2 = this.a;
                fnVar2.getClass();
                fnVar2.c.getClass();
                if (q80Var.c()) {
                    throw th;
                }
                jo0VarH = null;
            }
        }
        return null;
    }

    public final int b(ju0 ju0Var) {
        fn fnVar = this.a;
        fnVar.getClass();
        fnVar.c.getClass();
        int i = ju0Var.b.g;
        if ((i & 64) == 0 || (i & 32) != 0) {
            return ((i & 16) == 0 || (i & 32) != 0) ? 1 : 3;
        }
        return 2;
    }

    public final void d(ju0 ju0Var) {
        fn fnVar = this.a;
        fnVar.getClass();
        fnVar.c.getClass();
        if (ju0Var.b.b.c()) {
            return;
        }
        q80 q80Var = q80.g;
        ju0Var.getLocation();
        bt0.a(ju0Var.a);
    }

    public final void e(ju0 ju0Var) {
        fn fnVar = this.a;
        fnVar.getClass();
        fnVar.c.getClass();
        fn fnVar2 = this.a;
        fnVar2.getClass();
        fnVar2.c.getClass();
        wb0 wb0Var = ju0Var.b;
        if ((wb0Var.g & 2) != 0) {
            wb0Var.b.equals(d);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    public final vc f(ju0 ju0Var) {
        jo0 jo0VarF;
        wb0 wb0Var = ju0Var.b;
        q80 q80Var = wb0Var.b;
        String[] strArr = wb0Var.c;
        if (strArr == null) {
            strArr = wb0Var.d;
        }
        if (strArr == null) {
            strArr = null;
        } else {
            if (!b.contains(wb0Var.a)) {
                strArr = null;
            }
        }
        if (strArr != null) {
            String[] strArr2 = wb0Var.e;
            try {
                if (strArr2 != null) {
                    try {
                        jo0VarF = x80.f(strArr, strArr2);
                        if (jo0VarF != null) {
                            r80 r80Var = (r80) jo0VarF.b;
                            zq0 zq0Var = (zq0) jo0VarF.c;
                            d(ju0Var);
                            e(ju0Var);
                            return new vc(r80Var, zq0Var, q80Var, new zb0(ju0Var, b(ju0Var)));
                        }
                    } catch (t30 e2) {
                        throw new IllegalStateException(e4.j("Could not read data from ", ju0Var.getLocation()), e2);
                    }
                }
            } catch (Throwable th) {
                fn fnVar = this.a;
                fnVar.getClass();
                fnVar.c.getClass();
                if (q80Var.c()) {
                    throw th;
                }
                jo0VarF = null;
            }
        }
        return null;
    }
}
