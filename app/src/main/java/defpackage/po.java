package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class po extends ea1 {
    public final ea1 b;
    public final ea1 c;

    public po(ea1 ea1Var, ea1 ea1Var2) {
        this.b = ea1Var;
        this.c = ea1Var2;
    }

    @Override // defpackage.ea1
    public final boolean a() {
        return this.b.a() || this.c.a();
    }

    @Override // defpackage.ea1
    public final boolean b() {
        return this.b.b() || this.c.b();
    }

    @Override // defpackage.ea1
    public final s4 c(s4 s4Var) {
        return this.c.c(this.b.c(s4Var));
    }

    @Override // defpackage.ea1
    public final ca1 d(fc0 fc0Var) {
        ca1 ca1VarD = this.b.d(fc0Var);
        return ca1VarD == null ? this.c.d(fc0Var) : ca1VarD;
    }

    @Override // defpackage.ea1
    public final fc0 f(fc0 fc0Var, ad1 ad1Var) {
        return this.c.f(this.b.f(fc0Var, ad1Var), ad1Var);
    }
}
