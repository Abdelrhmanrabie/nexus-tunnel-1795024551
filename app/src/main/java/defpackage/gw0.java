package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class gw0 implements gc {
    public final oc0 a;
    public final String b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends gw0 {
        public static final a c = new a("Boolean", ba.b$17);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends gw0 {
        public static final b c = new b("Int", ba.b$18);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends gw0 {
        public static final c c = new c("Unit", ba.b$19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public gw0(String str, nw nwVar) {
        this.a = (oc0) nwVar;
        this.b = e4.j("must return ", str);
    }

    @Override // defpackage.gc
    public final String a(q50 q50Var) {
        return e4.a((gc) this, q50Var);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [nw, oc0] */
    @Override // defpackage.gc
    public final boolean b(q50 q50Var) {
        return e4.a(q50Var.j, this.a.invoke(ym.e(q50Var)));
    }

    @Override // defpackage.gc
    public final String getDescription() {
        return this.b;
    }
}
