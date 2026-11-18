package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y90 extends la0 {
    public final nu0$b s;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ra0.c implements nw {
        public final y90 n;

        public a(y90 y90Var) {
            this.n = y90Var;
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) throws p10 {
            ((a) this.n.s.invoke()).call(obj);
            return tb1.a;
        }

        @Override // ra0.a
        public final ra0 p() {
            return this.n;
        }
    }

    public y90(p90 p90Var, nq0 nq0Var) {
        super(p90Var, nq0Var);
        this.s = new nu0$b(new ca0(27, this));
    }
}
