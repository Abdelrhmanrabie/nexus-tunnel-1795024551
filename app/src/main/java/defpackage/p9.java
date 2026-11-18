package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p9 implements ad {
    public final ff0 a;
    public final ji0 b;

    public p9(ff0 ff0Var, ji0 ji0Var) {
        this.a = ff0Var;
        this.b = ji0Var;
    }

    @Override // defpackage.ad
    public final ai0 a(dd ddVar) {
        if (!ddVar.c && ddVar.b.e().d()) {
            String strB = ddVar.i().b();
            if (q31.e0(strB, "Function")) {
                cv cvVarH = ddVar.h();
                mx.d.getClass();
                mx$a$a mx_a_aA = ke.a(strB, cvVarH);
                if (mx_a_aA != null) {
                    vd0 vd0VarU = this.b.U(cvVarH);
                    ja0 ja0Var = vd0.n[0];
                    List list = (List) vd0VarU.g.invoke();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof v9) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    if (he.M0(arrayList2) == null) {
                        return new lx(this.a, (v9) he.K0(arrayList), mx_a_aA.a, mx_a_aA.b);
                    }
                    d.AnonymousClass0.m$1();
                }
            }
        }
        return null;
    }

    @Override // defpackage.ad
    public final Collection b(cv cvVar) {
        return yq.b;
    }

    @Override // defpackage.ad
    public final boolean c(cv cvVar, ij0 ij0Var) {
        String strB = ij0Var.b();
        if (!strB.startsWith("Function") && !strB.startsWith("KFunction") && !strB.startsWith("SuspendFunction") && !strB.startsWith("KSuspendFunction")) {
            return false;
        }
        mx.d.getClass();
        return ke.a(strB, cvVar) != null;
    }
}
