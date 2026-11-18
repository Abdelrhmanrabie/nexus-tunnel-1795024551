package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bo extends q01 implements ln {
    public final fr0 J;
    public final jj0 K;
    public final fi0 L;
    public final gd1 M;
    public final rn N;

    public bo(ok okVar, q01 q01Var, s4 s4Var, ij0 ij0Var, la.a aVar, fr0 fr0Var, jj0 jj0Var, fi0 fi0Var, gd1 gd1Var, rn rnVar, t11 t11Var) {
        super(okVar, q01Var, s4Var, ij0Var, aVar, t11Var == null ? t11.a : t11Var);
        this.J = fr0Var;
        this.K = jj0Var;
        this.L = fi0Var;
        this.M = gd1Var;
        this.N = rnVar;
    }

    @Override // defpackage.un
    public final fi0 F() {
        return this.L;
    }

    @Override // defpackage.q01, defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        bo boVar = new bo(okVar, (q01) oxVar, s4Var, ij0Var == null ? getName() : ij0Var, aVar, this.J, this.K, this.L, this.M, this.N, t11Var);
        boVar.B = this.B;
        return boVar;
    }

    @Override // defpackage.un
    public final jj0 L() {
        return this.K;
    }

    @Override // defpackage.un
    public final rn M() {
        return this.N;
    }

    @Override // defpackage.un
    public final b0 g0() {
        return this.J;
    }
}
