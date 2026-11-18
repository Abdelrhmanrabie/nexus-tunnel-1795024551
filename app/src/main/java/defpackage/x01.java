package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class x01 extends tl implements ra1 {
    public final u01 c;
    public final fc0 d;

    public x01(u01 u01Var, fc0 fc0Var) {
        this.c = u01Var;
        this.d = fc0Var;
    }

    @Override // defpackage.ra1
    public final cc1 G0() {
        return this.c;
    }

    @Override // defpackage.tl, defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new x01(this.c, this.d);
    }

    @Override // defpackage.tl, defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new x01(this.c, this.d);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return (u01) e.v1(this.c.P0(z), this.d.O0().P0(z));
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return (u01) e.v1(this.c.R0(s4Var), this.d);
    }

    @Override // defpackage.tl
    public final u01 U0() {
        return this.c;
    }

    @Override // defpackage.tl
    /* JADX INFO: renamed from: V0 */
    public final u01 N0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new x01(this.c, this.d);
    }

    @Override // defpackage.tl
    public final tl W0(u01 u01Var) {
        return new x01(u01Var, this.d);
    }

    @Override // defpackage.ra1
    public final fc0 i0() {
        return this.d;
    }

    @Override // defpackage.u01
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.d + ")] " + this.c;
    }
}
