package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class co extends rk implements un, pd {
    public final cn.d g;
    public List i;
    public final r0 j;
    public final ff0 n;
    public final or0 o;
    public final jj0 p;
    public final fi0 q;
    public final gd1 r;
    public final rn s;
    public Object t;
    public u01 u;
    public u01 v;
    public List w;
    public u01 x;

    public co(ff0 ff0Var, ok okVar, s4 s4Var, ij0 ij0Var, cn.d dVar, or0 or0Var, jj0 jj0Var, fi0 fi0Var, gd1 gd1Var, rn rnVar) {
        super(okVar, s4Var, ij0Var, t11.a);
        this.g = dVar;
        this.j = new r0(this);
        this.n = ff0Var;
        this.o = or0Var;
        this.p = jj0Var;
        this.q = fi0Var;
        this.r = gd1Var;
        this.s = rnVar;
    }

    @Override // defpackage.pd
    public final boolean B() {
        u01 u01Var = this.u;
        u01Var.getClass();
        return ma1.d(u01Var, new i(10, this), null, null);
    }

    @Override // defpackage.un
    public final fi0 F() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G0(List list, u01 u01Var, u01 u01Var2) {
        ArrayList arrayList;
        ha1 ha1VarD;
        co coVar;
        uc ucVarC;
        co coVar2 = this;
        coVar2.i = list;
        coVar2.u = u01Var;
        coVar2.v = u01Var2;
        coVar2.w = e4.b((pd) coVar2);
        ai0 ai0VarQ = coVar2.q();
        coVar2.x = ma1.n(coVar2, ai0VarQ == null ? vg0.b.b : ai0VarQ.Y(), new p0(1, 0));
        ai0 ai0VarQ2 = coVar2.q();
        if (ai0VarQ2 == null) {
            arrayList = uq.b;
        } else {
            Collection<uc> collectionI = ai0VarQ2.i();
            arrayList = new ArrayList();
            for (uc ucVar : collectionI) {
                p81.M.getClass();
                p81 p81Var = null;
                p81Var = null;
                if (coVar2.q() == null) {
                    ha1VarD = null;
                } else {
                    u01 u01Var3 = coVar2.v;
                    u01Var3.getClass();
                    ha1VarD = ha1.d(u01Var3);
                }
                if (ha1VarD == null || (ucVarC = ucVar.c(ha1VarD)) == null) {
                    coVar = coVar2;
                } else {
                    p81 p81Var2 = new p81(coVar2.n, coVar2, ucVarC, null, ucVar.getAnnotations(), ucVar.getKind(), coVar2.g());
                    coVar = coVar2;
                    ha1 ha1Var = ha1VarD;
                    ArrayList arrayListM0 = rx.M0(p81Var2, ucVar.f(), ha1Var, false, false, null);
                    if (arrayListM0 != null) {
                        u01 u01VarC1 = e.c1(ucVarC.j.O0());
                        u01 u01Var4 = coVar.x;
                        u01Var4.getClass();
                        u01 u01VarT1 = e.t1(u01VarC1, u01Var4);
                        sc0 sc0Var = ucVar.o;
                        sc0 sc0VarF = sc0Var != null ? b2.f(p81Var2, ha1Var.i(sc0Var.getType(), ad1.INVARIANT), e4.f47a) : null;
                        List list2 = coVar.i;
                        list2.getClass();
                        p81Var2.N0(sc0VarF, null, list2, arrayListM0, u01VarT1, zh0.b, coVar.g);
                        p81Var = p81Var2;
                    }
                }
                if (p81Var != null) {
                    arrayList.add(p81Var);
                }
                coVar2 = coVar;
            }
        }
        coVar2.t = arrayList;
    }

    @Override // defpackage.un
    public final jj0 L() {
        throw null;
    }

    @Override // defpackage.un
    public final rn M() {
        return this.s;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final od a() {
        return this;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return this;
    }

    @Override // defpackage.qg0
    public final boolean b0() {
        return false;
    }

    @Override // defpackage.b41
    public final qk c(ha1 ha1Var) {
        if (ha1Var.a.e()) {
            return this;
        }
        co coVar = new co(this.n, b(), getAnnotations(), getName(), this.g, this.o, this.p, this.q, this.r, this.s);
        List list = this.i;
        list.getClass();
        u01 u01Var = this.u;
        u01Var.getClass();
        ad1 ad1Var = ad1.INVARIANT;
        u01 u01VarG = e.g(ha1Var.i(u01Var, ad1Var));
        u01 u01Var2 = this.v;
        u01Var2.getClass();
        coVar.G0(list, u01VarG, e.g(ha1Var.i(u01Var2, ad1Var)));
        return coVar;
    }

    @Override // defpackage.qg0
    public final cn.d getVisibility() {
        return this.g;
    }

    @Override // defpackage.od
    public final a91 h() {
        return this.j;
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: i0 */
    public final qk a() {
        return this;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.od
    public final u01 n() {
        u01 u01Var = this.x;
        u01Var.getClass();
        return u01Var;
    }

    @Override // defpackage.pd
    public final List o() {
        List list = this.i;
        list.getClass();
        return list;
    }

    public final ai0 q() {
        u01 u01Var = this.v;
        u01Var.getClass();
        if (e.O((fc0) u01Var)) {
            return null;
        }
        u01 u01Var2 = this.v;
        u01Var2.getClass();
        od odVarB = u01Var2.L0().b();
        if (odVarB instanceof ai0) {
            return (ai0) odVarB;
        }
        return null;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        nm nmVar = (nm) bjVar.a;
        nmVar.G(sb, this, null);
        nmVar.i0(this.g, sb);
        nmVar.N(this, sb);
        sb.append(nmVar.L("typealias"));
        sb.append(" ");
        nmVar.R(this, sb, true);
        List list = this.i;
        list.getClass();
        nmVar.e0(sb, list, false);
        nmVar.H(this, sb);
        sb.append(" = ");
        u01 u01Var = this.u;
        u01Var.getClass();
        sb.append(nmVar.s(u01Var));
        return tb1.a;
    }

    @Override // defpackage.pk
    public final String toString() {
        return e4.j("typealias ", getName().b());
    }
}
