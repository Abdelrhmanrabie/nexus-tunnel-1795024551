package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class s41 {
    public static final wi0 a;

    static {
        wq wqVar = new wq(pr.a, m21.c, 0);
        ij0 ij0VarG = m21.d.a.g();
        ff0.a aVar = ff0.e;
        wi0 wi0Var = new wi0(wqVar, ij0VarG, aVar);
        wi0Var.p = zh0.f;
        wi0Var.q = cn.e;
        List listSingletonList = Collections.singletonList(w91.O0(wi0Var, ad1.IN_VARIANCE, ij0.f("T"), 0, aVar));
        if (wi0Var.s != null) {
            throw new IllegalStateException("Type parameters are already set for " + wi0Var.getName());
        }
        ArrayList arrayList = new ArrayList(listSingletonList);
        wi0Var.s = arrayList;
        wi0Var.r = new jd(wi0Var, arrayList, wi0Var.t, wi0Var.u);
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            wi0.i0(13);
            throw null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((uc) it.next()).j = wi0Var.n();
        }
        a = wi0Var;
    }
}
