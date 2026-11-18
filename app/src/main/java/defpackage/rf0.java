package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rf0 extends bc1 {
    public rf0(long j) {
        super(Long.valueOf(j));
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        return ub0VarK.t(wp0.LONG);
    }

    @Override // defpackage.qg
    public final String toString() {
        return ((Number) this.a).longValue() + ".toLong()";
    }
}
