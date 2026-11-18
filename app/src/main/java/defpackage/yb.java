package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yb implements vg0 {
    public final String b;
    public final vg0[] c;

    public yb(String str, vg0[] vg0VarArr) {
        this.b = str;
        this.c = vg0VarArr;
    }

    @Override // defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        if (length == 0) {
            return uq.b;
        }
        int i = 0;
        if (length == 1) {
            return vg0VarArr[0].a(ij0Var, dl0Var);
        }
        int length2 = vg0VarArr.length;
        Collection collectionH0 = null;
        while (i < length2) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            collectionH0 = e.H0(collectionH0, vg0Var.a(ij0Var, dl0Var));
        }
        return collectionH0 == null ? yq.b : collectionH0;
    }

    @Override // defpackage.vg0
    public final Set b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            he.C0(vg0Var.b(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        if (length == 0) {
            return uq.b;
        }
        int i = 0;
        if (length == 1) {
            return vg0VarArr[0].c(ij0Var, dl0Var);
        }
        int length2 = vg0VarArr.length;
        Collection collectionH0 = null;
        while (i < length2) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            collectionH0 = e.H0(collectionH0, vg0Var.c(ij0Var, dl0Var));
        }
        return collectionH0 == null ? yq.b : collectionH0;
    }

    @Override // defpackage.vg0
    public final Set d() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            he.C0(vg0Var.d(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        od odVar = null;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            od odVarE = vg0Var.e(ij0Var, dl0Var);
            if (odVarE != null) {
                if (!(odVarE instanceof pd) || !((pd) odVarE).l0()) {
                    return odVarE;
                }
                if (odVar == null) {
                    odVar = odVarE;
                }
            }
        }
        return odVar;
    }

    @Override // defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        vg0[] vg0VarArr = this.c;
        int length = vg0VarArr.length;
        if (length == 0) {
            return uq.b;
        }
        int i = 0;
        if (length == 1) {
            return vg0VarArr[0].f(lmVar, nwVar);
        }
        int length2 = vg0VarArr.length;
        Collection collectionH0 = null;
        while (i < length2) {
            vg0 vg0Var = vg0VarArr[i];
            i++;
            collectionH0 = e.H0(collectionH0, vg0Var.f(lmVar, nwVar));
        }
        return collectionH0 == null ? yq.b : collectionH0;
    }

    @Override // defpackage.vg0
    public final Set g() {
        vg0[] vg0VarArr = this.c;
        return e.t(vg0VarArr.length == 0 ? uq.b : new l7(0, vg0VarArr));
    }

    public final String toString() {
        return this.b;
    }
}
