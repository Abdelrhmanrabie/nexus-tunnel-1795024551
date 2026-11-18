package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 implements a91 {
    public int a;
    public final hf0 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final Collection a;
        public List b = Collections.singletonList(pr.c);

        public a(Collection collection) {
            this.a = collection;
        }
    }

    public s0(ff0 ff0Var) {
        ca0 ca0Var = new ca0(17, this);
        i iVar = new i(12, this);
        ff0Var.getClass();
        this.b = new hf0(ff0Var, ca0Var, iVar);
    }

    public abstract boolean e(od odVar);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a91) || obj.hashCode() != hashCode()) {
            return false;
        }
        a91 a91Var = (a91) obj;
        if (a91Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        od odVarB = b();
        od odVarB2 = a91Var.b();
        if (odVarB2 == null || pr.h(odVarB) || xm.o(odVarB) || pr.h(odVarB2) || xm.o(odVarB2)) {
            return false;
        }
        return e(odVarB2);
    }

    public abstract Collection g();

    public abstract fc0 h();

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        od odVarB = b();
        int iIdentityHashCode = (pr.h(odVarB) || xm.o(odVarB)) ? System.identityHashCode(this) : xm.g(odVarB).a.hashCode();
        this.a = iIdentityHashCode;
        return iIdentityHashCode;
    }

    public abstract ke j();

    @Override // defpackage.a91
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final List d() {
        return ((a) this.b.invoke()).b;
    }

    public List m(List list) {
        return list;
    }
}
