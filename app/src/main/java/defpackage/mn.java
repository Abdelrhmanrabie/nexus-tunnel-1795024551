package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mn extends uc implements ln {
    public final ar0 K;
    public final jj0 L;
    public final fi0 M;
    public final gd1 N;
    public final rn O;

    public mn(ai0 ai0Var, gh ghVar, s4 s4Var, boolean z, la.a aVar, ar0 ar0Var, jj0 jj0Var, fi0 fi0Var, gd1 gd1Var, rn rnVar, t11 t11Var) {
        super(ai0Var, ghVar, s4Var, z, aVar, t11Var == null ? t11.a : t11Var);
        this.K = ar0Var;
        this.L = jj0Var;
        this.M = fi0Var;
        this.N = gd1Var;
        this.O = rnVar;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean D() {
        return false;
    }

    @Override // defpackage.un
    public final fi0 F() {
        return this.M;
    }

    @Override // defpackage.uc, defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        mn mnVar = new mn((ai0) okVar, (gh) oxVar, s4Var, this.J, aVar, this.K, this.L, this.M, this.N, this.O, t11Var);
        mnVar.B = this.B;
        return mnVar;
    }

    @Override // defpackage.un
    public final jj0 L() {
        return this.L;
    }

    @Override // defpackage.un
    public final rn M() {
        return this.O;
    }

    @Override // defpackage.uc
    public final uc T0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var) {
        mn mnVar = new mn((ai0) okVar, (gh) oxVar, s4Var, this.J, aVar, this.K, this.L, this.M, this.N, this.O, t11Var);
        mnVar.B = this.B;
        return mnVar;
    }

    @Override // defpackage.rx, defpackage.qg0
    public final boolean b0() {
        return false;
    }

    @Override // defpackage.un
    public final b0 g0() {
        return this.K;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean isSuspend() {
        return false;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean r() {
        return false;
    }
}
