package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class iy extends wg0 {
    public static final /* synthetic */ ja0[] d;
    public final k b;
    public final ff0.h c;

    static {
        pu0 pu0Var = ou0.a;
        d = new ja0[]{pu0Var.f(new tq0(pu0Var.b(iy.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public iy(ff0 ff0Var, k kVar) {
        this.b = kVar;
        this.c = new ff0.h(ff0Var, new ca0(8, this));
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        ja0 ja0Var = d[0];
        List list = (List) this.c.invoke();
        n11 n11Var = new n11();
        for (Object obj : list) {
            if ((obj instanceof q01) && ((q01) obj).getName().equals(ij0Var)) {
                n11Var.add(obj);
            }
        }
        return n11Var;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        ja0 ja0Var = d[0];
        List list = (List) this.c.invoke();
        n11 n11Var = new n11();
        for (Object obj : list) {
            if ((obj instanceof nq0) && ((nq0) obj).getName().equals(ij0Var)) {
                n11Var.add(obj);
            }
        }
        return n11Var;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        if (!lmVar.a(lm.n.b)) {
            return uq.b;
        }
        ja0 ja0Var = d[0];
        return (List) this.c.invoke();
    }

    public abstract List h();
}
