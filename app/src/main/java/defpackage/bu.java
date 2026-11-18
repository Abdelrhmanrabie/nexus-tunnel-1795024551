package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bu extends zt implements yj {
    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new bu(this.c, this.d);
    }

    @Override // defpackage.cc1
    public final cc1 P0(boolean z) {
        return e4.c(this.c.P0(z), this.d.P0(z));
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new bu(this.c, this.d);
    }

    @Override // defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return e4.c(this.c.R0(t4Var), this.d.R0(t4Var));
    }

    @Override // defpackage.zt
    public final u01 S0() {
        return this.c;
    }

    @Override // defpackage.zt
    public final String T0(nm nmVar, nm nmVar2) {
        boolean zH = nmVar2.c.h();
        u01 u01Var = this.d;
        u01 u01Var2 = this.c;
        if (!zH) {
            return nmVar.p(nmVar.s(u01Var2), nmVar.s(u01Var), L0().k());
        }
        return "(" + nmVar.s(u01Var2) + ".." + nmVar.s(u01Var) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [cc1] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // defpackage.yj
    public final cc1 W(fc0 fc0Var) {
        ?? C;
        jc0 jc0VarO0 = fc0Var.O0();
        if (jc0VarO0 instanceof zt) {
            C = jc0VarO0;
        } else {
            if (!(jc0VarO0 instanceof u01)) {
                d.AnonymousClass0.m();
                return null;
            }
            u01 u01Var = (u01) jc0VarO0;
            C = e4.c(u01Var, u01Var.P0(true));
        }
        return e.v1(C, jc0VarO0 instanceof ra1 ? ((ra1) jc0VarO0).i0() : null);
    }

    @Override // defpackage.zt
    public final String toString() {
        return "(" + this.c + ".." + this.d + ')';
    }

    @Override // defpackage.yj
    public final boolean z() {
        u01 u01Var = this.c;
        return (u01Var.L0().b() instanceof v91) && e4.a((Object) u01Var.L0(), (Object) this.d.L0());
    }
}
