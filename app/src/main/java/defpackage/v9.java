package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v9 extends xn0 implements wn0 {
    public final r9 j;
    public final g o;
    public final m6 p;
    public jr0 q;
    public zn r;

    public v9(cv cvVar, gi0 gi0Var, jr0 jr0Var, r9 r9Var) {
        super(gi0Var, cvVar);
        this.j = r9Var;
        g gVar = new g(jr0Var.f, jr0Var.g, 17, false);
        this.o = gVar;
        this.p = new m6(jr0Var, gVar, r9Var, new p0(this));
        this.q = jr0Var;
    }

    public final void K0(fn fnVar) {
        jr0 jr0Var = this.q;
        if (jr0Var == null) {
            d.AnonymousClass0.m("Repeated call to DeserializedPackageFragmentImpl::initialize");
            return;
        }
        this.q = null;
        this.r = new zn(this, jr0Var.i, this.o, this.j, null, fnVar, e4.j("scope of ", this), new yn$a(0, this));
    }

    @Override // defpackage.wn0
    public final vg0 m() {
        zn znVar = this.r;
        znVar.getClass();
        return znVar;
    }

    @Override // defpackage.xn0, defpackage.pk
    public final String toString() {
        StringBuilder sb = new StringBuilder("builtins package fragment for ");
        sb.append(this.g);
        sb.append(" from ");
        int i = ym.$r8$clinit;
        sb.append(xm.d(this));
        return sb.toString();
    }
}
