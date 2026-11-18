package defpackage;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t80 implements vg0 {
    public static final /* synthetic */ ja0[] f;
    public final v8 b;
    public final fd0 c;
    public final hd0 d;
    public final ff0.h e;

    static {
        pu0 pu0Var = ou0.a;
        f = new ja0[]{pu0Var.f(new tq0(pu0Var.b(t80.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public t80(v8 v8Var, cu0 cu0Var, fd0 fd0Var) {
        this.b = v8Var;
        this.c = fd0Var;
        this.d = new hd0(v8Var, cu0Var, fd0Var);
        ff0 ff0Var = ((c60) v8Var.a).a;
        ca0 ca0Var = new ca0(18, this);
        ff0Var.getClass();
        this.e = new ff0.h(ff0Var, ca0Var);
    }

    @Override // defpackage.vg0
    public final Collection a(ij0 ij0Var, dl0 dl0Var) {
        this.c.g.b();
        ij0Var.b();
        vg0[] vg0VarArrH = h();
        Collection collectionA = this.d.a(ij0Var, dl0Var);
        int length = vg0VarArrH.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
            i++;
            collectionA = e.H0(collectionA, vg0Var.a(ij0Var, dl0Var));
        }
        return collectionA == null ? yq.b : collectionA;
    }

    @Override // defpackage.vg0
    public final Set b() {
        vg0[] vg0VarArrH = h();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = vg0VarArrH.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
            i++;
            he.C0(vg0Var.b(), linkedHashSet);
        }
        linkedHashSet.addAll(this.d.b());
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        this.c.g.b();
        ij0Var.b();
        vg0[] vg0VarArrH = h();
        this.d.getClass();
        int length = vg0VarArrH.length;
        Collection collectionH0 = uq.b;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
            i++;
            collectionH0 = e.H0(collectionH0, vg0Var.c(ij0Var, dl0Var));
        }
        return collectionH0 == null ? yq.b : collectionH0;
    }

    @Override // defpackage.vg0
    public final Set d() {
        vg0[] vg0VarArrH = h();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = vg0VarArrH.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
            i++;
            he.C0(vg0Var.d(), linkedHashSet);
        }
        linkedHashSet.addAll(this.d.d());
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        this.c.g.b();
        ij0Var.b();
        hd0 hd0Var = this.d;
        hd0Var.getClass();
        od odVar = null;
        ai0 ai0VarV = hd0Var.v(ij0Var, null);
        if (ai0VarV != null) {
            return ai0VarV;
        }
        vg0[] vg0VarArrH = h();
        int length = vg0VarArrH.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
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
        vg0[] vg0VarArrH = h();
        Collection collectionF = this.d.f(lmVar, nwVar);
        int length = vg0VarArrH.length;
        int i = 0;
        while (i < length) {
            vg0 vg0Var = vg0VarArrH[i];
            i++;
            collectionF = e.H0(collectionF, vg0Var.f(lmVar, nwVar));
        }
        return collectionF == null ? yq.b : collectionF;
    }

    @Override // defpackage.vg0
    public final Set g() {
        vg0[] vg0VarArrH = h();
        HashSet hashSetT = e.t(vg0VarArrH.length == 0 ? uq.b : new l7(0, vg0VarArrH));
        if (hashSetT == null) {
            return null;
        }
        hashSetT.addAll(this.d.g());
        return hashSetT;
    }

    public final vg0[] h() {
        ja0 ja0Var = f[0];
        return (vg0[]) this.e.invoke();
    }

    public final String toString() {
        return e4.j("scope for ", this.c);
    }
}
