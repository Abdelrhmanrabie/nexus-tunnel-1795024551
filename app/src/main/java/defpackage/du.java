package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class du extends zt implements ra1 {
    public final zt f;
    public final fc0 g;

    public du(zt ztVar, fc0 fc0Var) {
        super(ztVar.c, ztVar.d);
        this.f = ztVar;
        this.g = fc0Var;
    }

    @Override // defpackage.ra1
    public final cc1 G0() {
        return this.f;
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new du(this.f, this.g);
    }

    @Override // defpackage.cc1
    public final cc1 P0(boolean z) {
        return e.v1(this.f.P0(z), this.g.O0().P0(z));
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new du(this.f, this.g);
    }

    @Override // defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return e.v1(this.f.R0(t4Var), this.g);
    }

    @Override // defpackage.zt
    public final u01 S0() {
        return this.f.S0();
    }

    @Override // defpackage.zt
    public final String T0(nm nmVar, nm nmVar2) {
        um umVar = nmVar2.c;
        umVar.getClass();
        ja0 ja0Var = um.W[11];
        return ((Boolean) umVar.m.a).booleanValue() ? nmVar.s(this.g) : this.f.T0(nmVar, nmVar2);
    }

    @Override // defpackage.ra1
    public final fc0 i0() {
        return this.g;
    }

    @Override // defpackage.zt
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.g + ")] " + this.f;
    }
}
