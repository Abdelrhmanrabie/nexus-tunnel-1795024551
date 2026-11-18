package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ji0 extends pk implements gi0 {
    public final ff0 d;
    public final ub0 f;
    public final vq g;
    public final e i;
    public fi0 j;
    public ao0 n;
    public final boolean o;
    public final ff0.c p;
    public final v41 q;

    public ji0(ij0 ij0Var, ff0 ff0Var, ub0 ub0Var, int i) {
        super(e4.f47a, ij0Var);
        this.d = ff0Var;
        this.f = ub0Var;
        if (!ij0Var.c) {
            throw new IllegalArgumentException(e4.j("Module name must be special: ", ij0Var));
        }
        this.g = vq.b;
        this.i = e.b$3;
        this.o = true;
        this.p = ff0Var.g(new i(4, this));
        this.q = new v41(new hi0(this, 0));
    }

    @Override // defpackage.gi0
    public final void A0() {
        if (this.j == null) {
            throw new AssertionError(fb$1.m(new StringBuilder("Dependencies of module "), getName().b, " were not set"));
        }
    }

    @Override // defpackage.gi0
    public final vd0 U(cv cvVar) {
        i0();
        return (vd0) this.p.invoke(cvVar);
    }

    @Override // defpackage.ok
    public final ok b() {
        return null;
    }

    public final void i0() {
        if (this.o) {
            return;
        }
        this.g.getClass();
        throw new ob1(e4.j("Accessing invalid module descriptor ", this));
    }

    @Override // defpackage.gi0
    public final ub0 k() {
        return this.f;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        ((nm) bjVar.a).R(this, (StringBuilder) obj, true);
        return tb1.a;
    }

    @Override // defpackage.gi0
    public final Object t0(ci0 ci0Var) {
        this.g.getClass();
        return null;
    }

    @Override // defpackage.gi0
    public final boolean y(gi0 gi0Var) {
        if (equals(gi0Var)) {
            return true;
        }
        this.j.getClass();
        A0();
        gi0Var.A0();
        return false;
    }
}
