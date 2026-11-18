package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class j20 {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new cv("kotlin.jvm.JvmInline");
    }

    public static final boolean b(ok okVar) {
        if (!(okVar instanceof ai0)) {
            return false;
        }
        ai0 ai0Var = (ai0) okVar;
        return ai0Var.r() || ai0Var.k0();
    }

    public static final boolean d(yc1 yc1Var) {
        i20 i20VarT;
        if (yc1Var.Q() != null) {
            return false;
        }
        ok okVarB = yc1Var.b();
        ij0 ij0Var = null;
        ai0 ai0Var = okVarB instanceof ai0 ? (ai0) okVarB : null;
        if (ai0Var != null && (i20VarT = ai0Var.t()) != null) {
            ij0Var = i20VarT.a;
        }
        return e4.a(ij0Var, yc1Var.getName());
    }
}
