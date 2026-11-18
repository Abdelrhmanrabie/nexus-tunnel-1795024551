package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vr0$a extends dg0 {
    public final zq0 d;
    public final vr0$a e;
    public final dd f;
    public final zq0.c g;
    public final boolean h;

    public vr0$a(zq0 zq0Var, jj0 jj0Var, fi0 fi0Var, t11 t11Var, vr0$a vr0_a) {
        super(jj0Var, fi0Var, t11Var);
        this.d = zq0Var;
        this.e = vr0_a;
        this.f = e.x(jj0Var, zq0Var.g);
        zq0.c cVar = (zq0.c) xt.f.c(zq0Var.f);
        this.g = cVar == null ? zq0.c.c : cVar;
        this.h = e.i(xt.g, zq0Var.f);
    }

    @Override // defpackage.dg0
    public final cv a() {
        return this.f.b();
    }
}
