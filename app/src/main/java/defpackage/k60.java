package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k60 extends m40 {
    public static final /* synthetic */ ja0[] h;
    public final ff0.h g;

    static {
        pu0 pu0Var = ou0.a;
        h = new ja0[]{pu0Var.f(new tq0(pu0Var.b(k60.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public k60(ct0 ct0Var, v8 v8Var) {
        super(v8Var, ct0Var, m21.a.s);
        ff0 ff0Var = ((c60) v8Var.a).a;
        ca0 ca0Var = new ca0(9, this);
        ff0Var.getClass();
        this.g = new ff0.h(ff0Var, ca0Var);
    }

    @Override // defpackage.m40, defpackage.g4
    public final Map h() {
        ja0 ja0Var = h[0];
        return (Map) this.g.invoke();
    }
}
