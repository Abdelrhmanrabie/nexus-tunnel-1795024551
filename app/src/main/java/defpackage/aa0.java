package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class aa0 extends na0 implements z90 {
    public final nu0$b t;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ra0.c implements bx {
        public final aa0 n;

        public a(aa0 aa0Var) {
            this.n = aa0Var;
        }

        @Override // defpackage.bx
        public final Object invoke(Object obj, Object obj2) throws p10 {
            ((a) this.n.t.invoke()).call(obj, obj2);
            return tb1.a;
        }

        @Override // ra0.a
        public final ra0 p() {
            return this.n;
        }
    }

    public aa0(p90 p90Var, String str, String str2, Object obj) {
        super(p90Var, str, str2, obj);
        this.t = new nu0$b(new ca0(1, this));
    }

    public aa0(p90 p90Var, nq0 nq0Var) {
        super(p90Var, nq0Var);
        this.t = new nu0$b(new ca0(1, this));
    }
}
