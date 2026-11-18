package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ga extends bc1 {
    public ga(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        return ub0VarK.t(wp0.BYTE);
    }

    @Override // defpackage.qg
    public final String toString() {
        return ((Number) this.a).intValue() + ".toByte()";
    }
}
