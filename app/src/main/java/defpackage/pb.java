package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pb extends ea1 {
    public final /* synthetic */ int G0;
    public final ea1 b;

    public /* synthetic */ pb(ea1 ea1Var, int i) {
        this.G0 = i;
        this.b = ea1Var;
    }

    @Override // defpackage.ea1
    public boolean a() {
        return this.G0 != 0 ? super.a() : this.b.a();
    }

    @Override // defpackage.ea1
    public boolean b() {
        if (this.G0 != 0) {
            return super.b();
        }
        return true;
    }

    @Override // defpackage.ea1
    public final s4 c(s4 s4Var) {
        return this.b.c(s4Var);
    }

    @Override // defpackage.ea1
    public final ca1 d(fc0 fc0Var) {
        int i = this.G0;
        ea1 ea1Var = this.b;
        if (i != 0) {
            return ea1Var.d(fc0Var);
        }
        ca1 ca1VarD = ea1Var.d(fc0Var);
        if (ca1VarD == null) {
            return null;
        }
        od odVarB = fc0Var.L0().b();
        return ak.a(ca1VarD, odVarB instanceof v91 ? (v91) odVarB : null);
    }

    @Override // defpackage.ea1
    public final boolean e() {
        int i = this.G0;
        ea1 ea1Var = this.b;
        return i != 0 ? ea1Var.e() : ea1Var.e();
    }

    @Override // defpackage.ea1
    public final fc0 f(fc0 fc0Var, ad1 ad1Var) {
        return this.b.f(fc0Var, ad1Var);
    }
}
