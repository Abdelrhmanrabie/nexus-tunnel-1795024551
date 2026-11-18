package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d6 extends bv {
    public final /* synthetic */ e6.d p;
    public final /* synthetic */ e6 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d6(e6 e6Var, e6 e6Var2, e6.d dVar) {
        super(e6Var2);
        this.q = e6Var;
        this.p = dVar;
    }

    @Override // defpackage.bv
    public final b01 b() {
        return this.p;
    }

    @Override // defpackage.bv
    public final boolean c() {
        e6 e6Var = this.q;
        e6.f fVar = e6Var.i;
        if (fVar.a()) {
            return true;
        }
        fVar.j(e6Var.getTextDirection(), e6Var.getTextAlignment());
        return true;
    }
}
