package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u60 extends oc0 implements lw {
    public final /* synthetic */ oo b;
    public final /* synthetic */ v91 c;
    public final /* synthetic */ tt0 d;
    public final /* synthetic */ n60 f;
    public final /* synthetic */ a91 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u60(oo ooVar, v91 v91Var, tt0 tt0Var, n60 n60Var, a91 a91Var) {
        super(0);
        this.b = ooVar;
        this.c = v91Var;
        this.d = tt0Var;
        this.f = n60Var;
        this.g = a91Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        m6 m6Var = (m6) this.b.c;
        boolean zS = this.d.s();
        od odVarB = this.g.b();
        return m6Var.a(this.c, zS, n60.a(this.f, 0, null, odVarB == null ? null : odVarB.n(), 15));
    }
}
