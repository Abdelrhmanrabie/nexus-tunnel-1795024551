package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o9 implements g4 {
    public final ub0 a;
    public final cv b;
    public final Object c;
    public final Object d = e.V(be0.b, new ca0(12, this));

    public o9(ub0 ub0Var, cv cvVar, Map map) {
        this.a = ub0Var;
        this.b = cvVar;
        this.c = map;
    }

    @Override // defpackage.g4
    public final cv e() {
        return this.b;
    }

    @Override // defpackage.g4
    public final t11 g() {
        return t11.a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, rc0] */
    @Override // defpackage.g4
    public final fc0 getType() {
        return (fc0) this.d.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // defpackage.g4
    public final Map h() {
        return this.c;
    }
}
