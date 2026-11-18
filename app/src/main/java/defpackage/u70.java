package defpackage;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u70 implements ad {
    public static final ke d;
    public static final /* synthetic */ ja0[] e;
    public static final cv f;
    public static final ij0 g;
    public static final dd h;
    public final ji0 a;
    public final ff0.h c;

    static {
        pu0 pu0Var = ou0.a;
        e = new ja0[]{pu0Var.f(new tq0(pu0Var.b(u70.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        d = new ke(20);
        f = m21.i;
        dv dvVar = m21.a.c;
        g = dvVar.g();
        h = dd.l(dvVar.h());
    }

    public u70(ff0 ff0Var, ji0 ji0Var) {
        this.a = ji0Var;
        this.c = new ff0.h(ff0Var, new qn(13, this, ff0Var));
    }

    @Override // defpackage.ad
    public final ai0 a(dd ddVar) {
        if (!e4.a(ddVar, h)) {
            return null;
        }
        ja0 ja0Var = e[0];
        return (bd) this.c.invoke();
    }

    @Override // defpackage.ad
    public final Collection b(cv cvVar) {
        if (!e4.a(cvVar, f)) {
            return yq.b;
        }
        ja0 ja0Var = e[0];
        return Collections.singleton((bd) this.c.invoke());
    }

    @Override // defpackage.ad
    public final boolean c(cv cvVar, ij0 ij0Var) {
        return e4.a(ij0Var, g) && e4.a(cvVar, f);
    }
}
