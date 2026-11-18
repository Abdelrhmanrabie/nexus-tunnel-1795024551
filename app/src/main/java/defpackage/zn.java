package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zn extends vn {
    public final xn0 g;
    public final String h;
    public final cv i;

    public zn(xn0 xn0Var, ir0 ir0Var, jj0 jj0Var, y8 y8Var, s80 s80Var, fn fnVar, String str, lw lwVar) {
        fi0 fi0Var = new fi0(ir0Var.j);
        gd1 gd1Var = gd1.b;
        gd1 gd1VarA = ak.a(ir0Var.n);
        fnVar.getClass();
        super(new hn(fnVar, jj0Var, xn0Var, fi0Var, gd1VarA, y8Var, s80Var, null, uq.b), ir0Var.f, ir0Var.g, ir0Var.i, lwVar);
        this.g = xn0Var;
        this.h = str;
        this.i = xn0Var.g;
    }

    @Override // defpackage.vn, defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        fn fnVar = this.b.a;
        this.g.g.b();
        ij0Var.b();
        return super.e(ij0Var, dl0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        List listI = i(lmVar, nwVar);
        Iterable iterable = this.b.a.k;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            he.C0(((ad) it.next()).b(this.i), arrayList);
        }
        return he.X0(arrayList, listI);
    }

    @Override // defpackage.vn
    public final void h(ArrayList arrayList) {
    }

    @Override // defpackage.vn
    public final dd l(ij0 ij0Var) {
        return new dd(this.i, ij0Var);
    }

    @Override // defpackage.vn
    public final Set n() {
        return yq.b;
    }

    @Override // defpackage.vn
    public final Set o$1() {
        return yq.b;
    }

    @Override // defpackage.vn
    public final Set p() {
        return yq.b;
    }

    @Override // defpackage.vn
    public final boolean q(ij0 ij0Var) {
        if (super.q(ij0Var)) {
            return true;
        }
        Iterable iterable = this.b.a.k;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((ad) it.next()).c(this.i, ij0Var)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return this.h;
    }
}
