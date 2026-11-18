package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y21 extends wg0 {
    public static final /* synthetic */ ja0[] d;
    public final on b;
    public final ff0.h c;

    static {
        pu0 pu0Var = ou0.a;
        d = new ja0[]{pu0Var.f(new tq0(pu0Var.b(y21.class), "functions", "getFunctions()Ljava/util/List;"))};
    }

    public y21(ff0 ff0Var, on onVar) {
        this.b = onVar;
        ca0 ca0Var = new ca0(26, this);
        ff0Var.getClass();
        this.c = new ff0.h(ff0Var, ca0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        ja0 ja0Var = d[0];
        List list = (List) this.c.invoke();
        n11 n11Var = new n11();
        for (Object obj : list) {
            if (((q01) obj).getName().equals(ij0Var)) {
                n11Var.add(obj);
            }
        }
        return n11Var;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        return null;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        ja0 ja0Var = d[0];
        return (List) this.c.invoke();
    }
}
