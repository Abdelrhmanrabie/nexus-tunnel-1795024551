package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class w70 extends ub0 {
    public static final /* synthetic */ ja0[] h;
    public hi0 f;
    public final ff0.h g;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final ji0 a;

        public a(ji0 ji0Var) {
            this.a = ji0Var;
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        h = new ja0[]{pu0Var.f(new tq0(pu0Var.b(w70.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w70(ff0 ff0Var) {
        super(ff0Var);
        ak.r(1, "kind");
        this.g = new ff0.h(ff0Var, new qn(17, this, ff0Var));
        int iU = ak.u(1);
        if (iU == 1) {
            d();
        } else {
            if (iU != 2) {
                return;
            }
            d();
        }
    }

    public final a80 L() {
        ja0 ja0Var = h[0];
        return (a80) this.g.invoke();
    }

    @Override // defpackage.ub0
    public final f3 e() {
        return L();
    }

    @Override // defpackage.ub0
    public final Iterable m() {
        Iterable iterableM = super.m();
        ji0 ji0Var = this.a;
        ji0Var.getClass();
        return he.Y0((Collection) iterableM, new u70(this.d, ji0Var));
    }

    @Override // defpackage.ub0
    public final yo0 q() {
        return L();
    }
}
