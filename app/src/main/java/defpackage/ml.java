package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ml extends tl implements yj {
    public final u01 c;

    public ml(u01 u01Var) {
        this.c = u01Var;
    }

    @Override // defpackage.tl, defpackage.fc0
    public final boolean M0() {
        return false;
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new ml(this.c.R0(t4Var));
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return z ? this.c.P0(z) : this;
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return new ml(this.c.R0(s4Var));
    }

    @Override // defpackage.tl
    public final u01 U0() {
        return this.c;
    }

    @Override // defpackage.yj
    public final cc1 W(fc0 fc0Var) {
        return e.d1(fc0Var.O0());
    }

    @Override // defpackage.tl
    public final tl W0(u01 u01Var) {
        return new ml(u01Var);
    }

    @Override // defpackage.u01
    public final String toString() {
        return this.c + " & Any";
    }

    @Override // defpackage.yj
    public final boolean z() {
        u01 u01Var = this.c;
        u01Var.L0();
        return u01Var.L0().b() instanceof v91;
    }
}
