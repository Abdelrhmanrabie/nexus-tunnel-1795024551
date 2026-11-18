package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c30 implements a91 {
    public final LinkedHashSet c;
    public final v41 e;

    public c30(LinkedHashSet linkedHashSet) {
        e4.h(uq.b, e4.f47a, pr.c("Scope for integer literal type", true), this, false);
        this.e = new v41(new r2(this));
        this.c = linkedHashSet;
    }

    @Override // defpackage.a91
    public final od b() {
        return null;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return false;
    }

    @Override // defpackage.a91
    public final Collection d() {
        return (List) this.e.getValue();
    }

    @Override // defpackage.a91
    public final List getParameters() {
        return uq.b;
    }

    @Override // defpackage.a91
    public final ub0 k() {
        throw null;
    }

    public final String toString() {
        return e4.j("IntegerLiteralType", "[" + he.R0(this.c, ",", null, null, ba.b$13, 30) + ']');
    }
}
