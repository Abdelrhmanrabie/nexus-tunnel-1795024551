package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ao extends nq0 implements ln {
    public final kr0 F;
    public final jj0 G;
    public final fi0 H;
    public final gd1 I;
    public final rn J;

    public ao(ok okVar, nq0 nq0Var, s4 s4Var, zh0 zh0Var, cn.d dVar, boolean z, ij0 ij0Var, la.a aVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, kr0 kr0Var, jj0 jj0Var, fi0 fi0Var, gd1 gd1Var, rn rnVar) {
        super(okVar, nq0Var, s4Var, zh0Var, dVar, z, ij0Var, aVar, t11.a, z2, z3, z6, z4, z5);
        this.F = kr0Var;
        this.G = jj0Var;
        this.H = fi0Var;
        this.I = gd1Var;
        this.J = rnVar;
    }

    @Override // defpackage.un
    public final fi0 F() {
        return this.H;
    }

    @Override // defpackage.nq0
    public final nq0 G0(ok okVar, zh0 zh0Var, cn.d dVar, nq0 nq0Var, la.a aVar, ij0 ij0Var) {
        return new ao(okVar, nq0Var, getAnnotations(), zh0Var, dVar, this.i, ij0Var, aVar, this.s, this.t, b0(), this.x, this.u, this.F, this.G, this.H, this.I, this.J);
    }

    @Override // defpackage.un
    public final jj0 L() {
        return this.G;
    }

    @Override // defpackage.un
    public final rn M() {
        return this.J;
    }

    @Override // defpackage.nq0, defpackage.qg0
    public final boolean b0() {
        return e.i(xt.D, this.F.f);
    }

    @Override // defpackage.un
    public final b0 g0() {
        return this.F;
    }
}
