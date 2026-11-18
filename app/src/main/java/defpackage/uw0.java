package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class uw0 {
    public static final dd a = dd.l(new cv("java.lang.Void"));

    /* JADX WARN: Multi-variable type inference failed */
    public static o80$e a(ox oxVar) {
        String strA = b2.a(oxVar);
        if (strA == null) {
            if (oxVar instanceof pq0) {
                strA = q70.a(((pk) ym.l(oxVar)).getName().b());
            } else if (oxVar instanceof wq0) {
                String strB = ((pk) ym.l(oxVar)).getName().b();
                strA = e4.j("set", q70.c(strB) ? strB.substring(2) : e.f(strB));
            } else {
                strA = ((pk) oxVar).getName().b();
            }
        }
        return new o80$e(new p80$b(strA, e.o(oxVar, 1)));
    }

    public static uh b(nq0 nq0Var) {
        nq0 nq0VarA = ((nq0) xm.u(nq0Var)).a();
        if (nq0VarA instanceof ao) {
            ao aoVar = (ao) nq0VarA;
            yx.e eVar = w80.d;
            kr0 kr0Var = aoVar.F;
            w80.c cVar = (w80.c) e.z(kr0Var, eVar);
            if (cVar != null) {
                return new v80$c(aoVar, kr0Var, cVar, aoVar.G, aoVar.H);
            }
        } else if (nq0VarA instanceof y50) {
            t11 t11VarG = ((y50) nq0VarA).g();
            tw0$a tw0_a = t11VarG instanceof tw0$a ? (tw0$a) t11VarG : null;
            ui uiVar = tw0_a == null ? null : tw0_a.b;
            if (uiVar instanceof xt0) {
                return new v80$a(((xt0) uiVar).a);
            }
            if (!(uiVar instanceof au0)) {
                d.AnonymousClass0.m("Incorrect resolution sequence for Java field ", nq0VarA, " (source = ", uiVar);
                return null;
            }
            Method method = ((au0) uiVar).a;
            wq0 wq0Var = nq0VarA.C;
            t11 t11VarG2 = wq0Var == null ? null : wq0Var.g();
            tw0$a tw0_a2 = t11VarG2 instanceof tw0$a ? (tw0$a) t11VarG2 : null;
            ui uiVar2 = tw0_a2 == null ? null : tw0_a2.b;
            au0 au0Var = uiVar2 instanceof au0 ? (au0) uiVar2 : null;
            return new v80$b(method, au0Var != null ? au0Var.a : null);
        }
        o80$e o80_eA = a(nq0VarA.B);
        wq0 wq0Var2 = nq0VarA.C;
        return new v80$d(o80_eA, wq0Var2 != null ? a(wq0Var2) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e4 c(ox oxVar) {
        ox oxVarA = ((ox) xm.u(oxVar)).a();
        if (oxVarA instanceof ln) {
            ln lnVar = (ln) oxVarA;
            b0 b0VarG0 = lnVar.g0();
            if (b0VarG0 instanceof fr0) {
                ps psVar = x80.a;
                p80$b p80_bC = x80.c((fr0) b0VarG0, lnVar.L(), lnVar.F());
                if (p80_bC != null) {
                    return new o80$e(p80_bC);
                }
            }
            if (b0VarG0 instanceof ar0) {
                ps psVar2 = x80.a;
                p80$b p80_bA = x80.a((ar0) b0VarG0, lnVar.L(), lnVar.F());
                if (p80_bA != null) {
                    return j20.b(oxVar.b()) ? new o80$e(p80_bA) : new o80$d(p80_bA);
                }
            }
            return a(oxVarA);
        }
        if (oxVarA instanceof q50) {
            t11 t11VarG = ((q50) oxVarA).g();
            tw0$a tw0_a = t11VarG instanceof tw0$a ? (tw0$a) t11VarG : null;
            ui uiVar = tw0_a == null ? null : tw0_a.b;
            au0 au0Var = uiVar instanceof au0 ? (au0) uiVar : null;
            if (au0Var != null) {
                return new o80$c(au0Var.a);
            }
            throw new yi(e4.j("Incorrect resolution sequence for Java method ", oxVarA));
        }
        if (oxVarA instanceof v40) {
            t11 t11VarG2 = ((v40) oxVarA).g();
            tw0$a tw0_a2 = t11VarG2 instanceof tw0$a ? (tw0$a) t11VarG2 : null;
            ui uiVar2 = tw0_a2 == null ? null : tw0_a2.b;
            if (uiVar2 instanceof ut0) {
                return new o80$b(((ut0) uiVar2).a);
            }
            if (uiVar2 instanceof qt0) {
                Class cls = ((qt0) uiVar2).a;
                if (cls.isAnnotation()) {
                    return new o80$a(cls);
                }
            }
            d.AnonymousClass0.m("Incorrect resolution sequence for Java constructor ", oxVarA, " (", uiVar2);
            return null;
        }
        pk pkVar = (pk) oxVarA;
        if ((pkVar.getName().equals(m21.b) && oxVarA.getKind() == la.a.f && xm.n(oxVarA.b(), 3)) || ((pkVar.getName().equals(m21.a) && oxVarA.getKind() == la.a.f && xm.n(oxVarA.b(), 3)) || (pkVar.getName().equals(sd.e) && oxVarA.f().isEmpty()))) {
            return a(oxVarA);
        }
        StringBuilder sb = new StringBuilder("Unknown origin of ");
        sb.append(oxVarA);
        Object obj = oxVarA.getClass();
        sb.append(" (");
        sb.append(obj);
        sb.append(')');
        throw new yi(sb.toString());
    }
}
