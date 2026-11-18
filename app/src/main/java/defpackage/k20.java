package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k20 extends wg0 {
    public final vg0 b;

    public k20(vg0 vg0Var) {
        this.b = vg0Var;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set b() {
        return this.b.b();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set d() {
        return this.b.d();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        od odVarE = this.b.e(ij0Var, dl0Var);
        if (odVarE != null) {
            ai0 ai0Var = odVarE instanceof ai0 ? (ai0) odVarE : null;
            if (ai0Var != null) {
                return ai0Var;
            }
            if (odVarE instanceof co) {
                return (co) odVarE;
            }
        }
        return null;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        int i = lm.l & lmVar.b;
        lm lmVar2 = i == 0 ? null : new lm(lmVar.a, i);
        if (lmVar2 == null) {
            return uq.b;
        }
        Collection collectionF = this.b.f(lmVar2, nwVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionF) {
            if (obj instanceof pd) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set g() {
        return this.b.g();
    }

    public final String toString() {
        return e4.j("Classes from ", this.b);
    }
}
