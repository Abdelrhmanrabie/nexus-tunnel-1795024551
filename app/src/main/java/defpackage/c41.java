package defpackage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c41 implements vg0 {
    public final vg0 b;
    public final ha1 c;
    public HashMap d;
    public final v41 e = new v41(new ca0(2, this));

    public c41(vg0 vg0Var, ha1 ha1Var) {
        this.b = vg0Var;
        this.c = new ha1(ak.b(ha1Var.a));
    }

    @Override // defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        return i(this.b.a(ij0Var, dl0Var));
    }

    @Override // defpackage.vg0
    public final Set b() {
        return this.b.b();
    }

    @Override // defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        return i(this.b.c(ij0Var, dl0Var));
    }

    @Override // defpackage.vg0
    public final Set d() {
        return this.b.d();
    }

    @Override // defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        od odVarE = this.b.e(ij0Var, dl0Var);
        if (odVarE == null) {
            return null;
        }
        return (od) h(odVarE);
    }

    @Override // defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        return (Collection) this.e.getValue();
    }

    @Override // defpackage.vg0
    public final Set g() {
        return this.b.g();
    }

    public final ok h(ok okVar) {
        ha1 ha1Var = this.c;
        if (ha1Var.a.e()) {
            return okVar;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        HashMap map = this.d;
        Object objC = map.get(okVar);
        if (objC == null) {
            if (!(okVar instanceof b41)) {
                throw new IllegalStateException(e4.j("Unknown descriptor in scope: ", okVar).toString());
            }
            objC = ((b41) okVar).c(ha1Var);
            if (objC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + okVar + " substitution fails");
            }
            map.put(okVar, objC);
        }
        return (ok) objC;
    }

    public final Collection i(Collection collection) {
        if (this.c.a.e() || collection.isEmpty()) {
            return collection;
        }
        int size = collection.size();
        LinkedHashSet linkedHashSet = new LinkedHashSet(size >= 3 ? (size / 3) + size + 1 : 3);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(h((ok) it.next()));
        }
        return linkedHashSet;
    }
}
