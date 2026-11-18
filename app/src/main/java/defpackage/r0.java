package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements a91 {
    public final /* synthetic */ co a;

    public r0(co coVar) {
        this.a = coVar;
    }

    @Override // defpackage.a91
    public final od b() {
        return this.a;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a91
    public final Collection d() {
        u01 u01Var = this.a.u;
        u01Var.getClass();
        return u01Var.L0().d();
    }

    @Override // defpackage.a91
    public final List getParameters() {
        List list = this.a.w;
        list.getClass();
        return list;
    }

    @Override // defpackage.a91
    public final ub0 k() {
        return ym.e(this.a);
    }

    public final String toString() {
        return "[typealias " + this.a.getName().b() + ']';
    }
}
