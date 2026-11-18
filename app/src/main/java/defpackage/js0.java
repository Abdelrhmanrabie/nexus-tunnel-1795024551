package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class js0 extends ea1 {
    public static final n60 c = w60.b(2, false, null, 3).b(3);
    public static final n60 d = w60.b(2, false, null, 3).b(2);
    public final m6 b;

    public js0(m6 m6Var) {
        this.b = m6Var == null ? new m6(this) : m6Var;
    }

    public static ca1 g(v91 v91Var, n60 n60Var, fc0 fc0Var) {
        int iU = ak.u(n60Var.b);
        ad1 ad1Var = ad1.INVARIANT;
        if (iU == 0 || iU == 1) {
            if (v91Var.j().c) {
                return !fc0Var.L0().getParameters().isEmpty() ? new da1(fc0Var, ad1.OUT_VARIANCE) : w60.a(v91Var, n60Var);
            }
            return new da1(ym.e(v91Var).o(), ad1Var);
        }
        if (iU == 2) {
            return new da1(fc0Var, ad1Var);
        }
        d.AnonymousClass0.m();
        return null;
    }

    @Override // defpackage.ea1
    public final ca1 d(fc0 fc0Var) {
        return new da1(i(fc0Var, new n60(2, false, null, 30)));
    }

    public final jo0 h(u01 u01Var, ai0 ai0Var, n60 n60Var) {
        if (u01Var.L0().getParameters().isEmpty()) {
            return new jo0(u01Var, Boolean.FALSE);
        }
        if (ub0.z(u01Var)) {
            ca1 ca1Var = (ca1) u01Var.K0().get(0);
            return new jo0(e4.f(u01Var.getAnnotations(), u01Var.L0(), Collections.singletonList(new da1(i(ca1Var.getType(), n60Var), ca1Var.c())), u01Var.M0()), Boolean.FALSE);
        }
        if (e.O((fc0) u01Var)) {
            return new jo0(pr.d(e4.j("Raw error type: ", u01Var.L0())), Boolean.FALSE);
        }
        vg0 vg0VarJ = ai0Var.J(this);
        s4 annotations = u01Var.getAnnotations();
        a91 a91VarH = ai0Var.h();
        List<v91> parameters = ai0Var.h().getParameters();
        ArrayList arrayList = new ArrayList(ae.y0(parameters));
        for (v91 v91Var : parameters) {
            arrayList.add(g(v91Var, n60Var, this.b.a(v91Var, true, n60Var)));
        }
        return new jo0(e4.g(annotations, a91VarH, arrayList, u01Var.M0(), vg0VarJ, new i(7, ai0Var)), Boolean.TRUE);
    }

    public final fc0 i(fc0 fc0Var, n60 n60Var) {
        od odVarB = fc0Var.L0().b();
        if (odVarB instanceof v91) {
            return i(this.b.a((v91) odVarB, true, n60Var), n60Var);
        }
        if (!(odVarB instanceof ai0)) {
            throw new IllegalStateException(e4.j("Unexpected declaration kind: ", odVarB).toString());
        }
        od odVarB2 = e.s1(fc0Var).L0().b();
        if (odVarB2 instanceof ai0) {
            jo0 jo0VarH = h(e.c1(fc0Var), (ai0) odVarB, c);
            u01 u01Var = (u01) jo0VarH.b;
            boolean zBooleanValue = ((Boolean) jo0VarH.c).booleanValue();
            jo0 jo0VarH2 = h(e.s1(fc0Var), (ai0) odVarB2, d);
            u01 u01Var2 = (u01) jo0VarH2.b;
            return (zBooleanValue || ((Boolean) jo0VarH2.c).booleanValue()) ? new ls0(u01Var, u01Var2, 0) : e4.c(u01Var, u01Var2);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + odVarB2 + "\" while for lower it's \"" + odVarB + '\"').toString());
    }
}
