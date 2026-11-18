package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class op extends zt {
    public final s4 f;

    public op(ub0 ub0Var, s4 s4Var) {
        super(ub0Var.o(), ub0Var.p());
        this.f = s4Var;
    }

    @Override // defpackage.zt, defpackage.fc0
    public final boolean M0() {
        return false;
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        return this;
    }

    @Override // defpackage.cc1
    public final cc1 P0(boolean z) {
        return this;
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        return this;
    }

    @Override // defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new op(this.d.L0().k(), t4Var);
    }

    @Override // defpackage.zt
    public final u01 S0() {
        return this.d;
    }

    @Override // defpackage.zt
    public final String T0(nm nmVar, nm nmVar2) {
        return "dynamic";
    }

    @Override // defpackage.zt, defpackage.w3
    public final s4 getAnnotations() {
        return this.f;
    }
}
