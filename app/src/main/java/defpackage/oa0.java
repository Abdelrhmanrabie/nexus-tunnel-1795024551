package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class oa0 extends ra0 implements bx {
    public final nu0$b r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ra0.b implements bx {
        public final oa0 n;

        public a(oa0 oa0Var) {
            this.n = oa0Var;
        }

        @Override // defpackage.bx
        public final Object invoke(Object obj, Object obj2) {
            return ((a) this.n.r.invoke()).call(obj, obj2);
        }

        @Override // ra0.a
        public final ra0 p() {
            return this.n;
        }
    }

    public oa0(p90 p90Var, nq0 nq0Var) {
        super(p90Var, nq0Var);
        this.r = new nu0$b(new pa0(this, 0));
        e.V(be0.b, new pa0(this, 1));
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        return ((a) this.r.invoke()).call(obj, obj2);
    }

    @Override // defpackage.ra0
    public final ra0.b r() {
        return (a) this.r.invoke();
    }
}
