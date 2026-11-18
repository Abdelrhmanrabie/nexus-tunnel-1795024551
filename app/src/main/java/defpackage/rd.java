package defpackage;

import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class rd extends v3 {
    public static final void g(on onVar, LinkedHashSet linkedHashSet, vg0 vg0Var, boolean z) {
        for (ok okVar : b2.a(vg0Var, lm.o, 2)) {
            if (okVar instanceof ai0) {
                ai0 ai0VarQ = (ai0) okVar;
                if (ai0VarQ.l0()) {
                    od odVarE = vg0Var.e(ai0VarQ.getName(), dl0.f);
                    ai0VarQ = odVarE instanceof ai0 ? (ai0) odVarE : odVarE instanceof co ? ((co) odVarE).q() : null;
                }
                if (ai0VarQ != null) {
                    int i = xm.$r8$clinit;
                    Iterator it = ai0VarQ.h().d().iterator();
                    while (it.hasNext()) {
                        if (xm.p((fc0) it.next(), onVar)) {
                            linkedHashSet.add(ai0VarQ);
                            break;
                        }
                    }
                    if (z) {
                        g(onVar, linkedHashSet, ai0VarQ.V(), z);
                    }
                }
            }
        }
    }

    public abstract void g(la laVar, la laVar2);
}
