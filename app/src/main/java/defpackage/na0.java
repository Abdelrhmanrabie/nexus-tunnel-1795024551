package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class na0 extends ra0 implements ma0 {
    public final nu0$b r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ra0.b implements nw {
        public final na0 n;

        public a(na0 na0Var) {
            this.n = na0Var;
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            return ((a) this.n.r.invoke()).call(obj);
        }

        @Override // ra0.a
        public final ra0 p() {
            return this.n;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ na0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(na0 na0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = na0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            return this.G0 != 0 ? this.b.o() : new a(this.b);
        }
    }

    public na0(p90 p90Var, String str, String str2, Object obj) {
        super(p90Var, str, str2, null, obj);
        this.r = new nu0$b(new b(this, 0));
        e.V(be0.b, new b(this, 1));
    }

    public na0(p90 p90Var, nq0 nq0Var) {
        super(p90Var, nq0Var);
        this.r = new nu0$b(new b(this, 0));
        e.V(be0.b, new b(this, 1));
    }

    @Override // defpackage.ma0
    public final a getGetter() {
        return (a) this.r.invoke();
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return ((a) this.r.invoke()).call(obj);
    }

    @Override // defpackage.ra0
    public final ra0.b r() {
        return (a) this.r.invoke();
    }
}
