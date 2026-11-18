package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cl0 implements gc {
    public static final cl0 a = new cl0(0);
    public static final cl0 a$1 = new cl0(1);
    public final /* synthetic */ int G0;

    public /* synthetic */ cl0(int i) {
        this.G0 = i;
    }

    @Override // defpackage.gc
    public final String a(q50 q50Var) {
        return e4.a((gc) this, q50Var);
    }

    @Override // defpackage.gc
    public final boolean b(q50 q50Var) {
        int i = this.G0;
        List<wc1> listF = q50Var.f();
        if (i == 0) {
            if (!listF.isEmpty()) {
                for (wc1 wc1Var : listF) {
                    if (ym.a(wc1Var) || wc1Var.p != null) {
                    }
                }
            }
            return true;
        }
        wc1 wc1Var2 = (wc1) listF.get(1);
        ke keVar = tu0.d;
        int i2 = ym.$r8$clinit;
        gi0 gi0VarD = xm.d(wc1Var2);
        keVar.getClass();
        ai0 ai0VarA = e4.a(gi0VarD, m21.a.P);
        u01 u01VarF = ai0VarA == null ? null : e4.f(e4.f47a, ai0VarA.h(), Collections.singletonList(new da1((v91) he.a1(ai0VarA.h().getParameters()))), false);
        if (u01VarF != null) {
            return gc0.a.e(u01VarF, ma1.j(wc1Var2.getType(), false));
        }
        return false;
    }

    @Override // defpackage.gc
    public final String getDescription() {
        return this.G0 != 0 ? "second parameter must be of type KProperty<*> or its supertype" : "should not have varargs or parameters with default values";
    }
}
