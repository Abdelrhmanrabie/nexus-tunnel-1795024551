package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class h7 extends qg {
    public final oc0 b;

    /* JADX WARN: Multi-variable type inference failed */
    public h7(List list, nw nwVar) {
        super(list);
        this.b = (oc0) nwVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [nw, oc0] */
    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        od odVarB;
        fc0 fc0Var = (fc0) this.b.invoke(gi0Var);
        if (!ub0.z(fc0Var) && (((odVarB = fc0Var.L0().b()) == null || ub0.s(odVarB) == null) && !ub0.C(fc0Var, m21.a.U.i()) && !ub0.C(fc0Var, m21.a.V.i()) && !ub0.C(fc0Var, m21.a.W.i()))) {
            ub0.C(fc0Var, m21.a.X.i());
        }
        return fc0Var;
    }
}
