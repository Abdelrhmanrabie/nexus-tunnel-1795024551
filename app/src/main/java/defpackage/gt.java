package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gt implements s4 {
    public final s4 b;
    public final mu c;

    public gt(s4 s4Var, mu muVar) {
        this.b = s4Var;
        this.c = muVar;
    }

    @Override // defpackage.s4
    public final g4 c(cv cvVar) {
        if (((Boolean) this.c.invoke(cvVar)).booleanValue()) {
            return this.b.c(cvVar);
        }
        return null;
    }

    @Override // defpackage.s4
    public final boolean f(cv cvVar) {
        if (((Boolean) this.c.invoke(cvVar)).booleanValue()) {
            return this.b.f(cvVar);
        }
        return false;
    }

    @Override // defpackage.s4
    public final boolean isEmpty() {
        s4 s4Var = this.b;
        if ((s4Var instanceof Collection) && ((Collection) s4Var).isEmpty()) {
            return false;
        }
        Iterator it = s4Var.iterator();
        while (it.hasNext()) {
            cv cvVarE = ((g4) it.next()).e();
            if (cvVarE != null && ((Boolean) this.c.invoke(cvVarE)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.b) {
            cv cvVarE = ((g4) obj).e();
            if (cvVarE != null && ((Boolean) this.c.invoke(cvVarE)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }
}
