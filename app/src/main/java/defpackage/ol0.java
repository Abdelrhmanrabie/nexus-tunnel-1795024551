package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ol0 extends tl implements yj {
    public final u01 c;

    public ol0(u01 u01Var) {
        this.c = u01Var;
    }

    @Override // defpackage.tl, defpackage.fc0
    public final boolean M0() {
        return false;
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new ol0(this.c.R0(t4Var));
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return z ? this.c.P0(true) : this;
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return new ol0(this.c.R0(s4Var));
    }

    @Override // defpackage.tl
    public final u01 U0() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yj
    public final cc1 W(fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        if (!ma1.h(cc1VarO0) && !ma1.g(cc1VarO0)) {
            return cc1VarO0;
        }
        if (cc1VarO0 instanceof u01) {
            u01 u01Var = (u01) cc1VarO0;
            u01 u01VarP0 = u01Var.P0(false);
            return !ma1.h(u01Var) ? u01VarP0 : new ol0(u01VarP0);
        }
        if (!(cc1VarO0 instanceof zt)) {
            throw new IllegalStateException(e4.j("Incorrect type: ", cc1VarO0).toString());
        }
        zt ztVar = (zt) cc1VarO0;
        u01 u01Var2 = ztVar.c;
        u01 u01VarP1 = u01Var2.P0(false);
        if (ma1.h(u01Var2)) {
            u01VarP1 = new ol0(u01VarP1);
        }
        u01 u01Var3 = ztVar.d;
        u01 u01VarP2 = u01Var3.P0(false);
        if (ma1.h(u01Var3)) {
            u01VarP2 = new ol0(u01VarP2);
        }
        return e.v1(e4.c(u01VarP1, u01VarP2), cc1VarO0 instanceof ra1 ? ((ra1) cc1VarO0).i0() : null);
    }

    @Override // defpackage.tl
    public final tl W0(u01 u01Var) {
        return new ol0(u01Var);
    }

    @Override // defpackage.yj
    public final boolean z() {
        return true;
    }
}
