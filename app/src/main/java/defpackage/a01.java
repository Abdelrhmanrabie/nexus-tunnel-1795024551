package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a01 extends bc1 {
    public a01(short s) {
        super(Short.valueOf(s));
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        return ub0VarK.t(wp0.SHORT);
    }

    @Override // defpackage.qg
    public final String toString() {
        return ((Number) this.a).intValue() + ".toShort()";
    }
}
