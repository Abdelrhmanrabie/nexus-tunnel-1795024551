package defpackage;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class va0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ wa0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ va0(wa0 wa0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = wa0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        wa0 wa0Var = this.b;
        if (i != 0) {
            return wa0Var.d(wa0Var.b);
        }
        nu0$a nu0_a = wa0Var.c;
        return bt0.c(nu0_a == null ? null : (Type) nu0_a.invoke());
    }
}
