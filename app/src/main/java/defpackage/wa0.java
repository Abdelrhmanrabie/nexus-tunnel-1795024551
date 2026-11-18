package defpackage;

import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wa0 {
    public static final /* synthetic */ ja0[] g;
    public final fc0 b;
    public final nu0$a c;
    public final nu0$a d;

    static {
        pu0 pu0Var = ou0.a;
        g = new ja0[]{pu0Var.f(new tq0(pu0Var.b(wa0.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), pu0Var.f(new tq0(pu0Var.b(wa0.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public wa0(fc0 fc0Var, lw lwVar) {
        this.b = fc0Var;
        nu0$a nu0_aC = null;
        nu0$a nu0_a = lwVar instanceof nu0$a ? (nu0$a) lwVar : null;
        if (nu0_a != null) {
            nu0_aC = nu0_a;
        } else if (lwVar != null) {
            nu0_aC = ak.c(lwVar);
        }
        this.c = nu0_aC;
        this.d = ak.c(new va0(this, 1));
        ak.c(new qn(16, this, lwVar));
    }

    public final n90 d(fc0 fc0Var) {
        od odVarB = fc0Var.L0().b();
        if (odVarB instanceof ai0) {
            Class clsH = lc1.h((ai0) odVarB);
            if (clsH != null) {
                if (!clsH.isArray()) {
                    if (ma1.g(fc0Var)) {
                        return new j90(clsH);
                    }
                    Class cls = (Class) bt0.b.get(clsH);
                    if (cls != null) {
                        clsH = cls;
                    }
                    return new j90(clsH);
                }
                List listK0 = fc0Var.K0();
                ca1 ca1Var = (ca1) (listK0.size() == 1 ? listK0.get(0) : null);
                if (ca1Var == null) {
                    return new j90(clsH);
                }
                n90 n90VarD = d(ca1Var.getType());
                if (n90VarD != null) {
                    return new j90(Array.newInstance((Class<?>) ((sc) e.t(n90VarD)).d(), 0).getClass());
                }
                throw new yi(e4.j("Cannot determine classifier for array element type: ", this));
            }
        } else {
            if (odVarB instanceof v91) {
                return new ya0(null, (v91) odVarB);
            }
            if (odVarB instanceof co) {
                throw new yi(e4.j("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof wa0) {
            return e4.a(this.b, ((wa0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        nm nmVar = ru0.a;
        return ru0.a.s(this.b);
    }
}
