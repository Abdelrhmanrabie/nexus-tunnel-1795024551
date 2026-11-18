package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qd0 extends b2 {
    public final /* synthetic */ xc0 a;
    public final /* synthetic */ LinkedHashSet b;
    public final /* synthetic */ oc0 c;

    /* JADX WARN: Multi-variable type inference failed */
    public qd0(xc0 xc0Var, LinkedHashSet linkedHashSet, nw nwVar) {
        this.a = xc0Var;
        this.b = linkedHashSet;
        this.c = (oc0) nwVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [nw, oc0] */
    @Override // defpackage.b2
    /* JADX INFO: renamed from: b */
    public final boolean mo2b(Object obj) {
        ai0 ai0Var = (ai0) obj;
        if (ai0Var == this.a) {
            return true;
        }
        vg0 vg0VarO0 = ai0Var.o0();
        if (!(vg0VarO0 instanceof sd0)) {
            return true;
        }
        this.b.addAll((Collection) this.c.invoke(vg0VarO0));
        return false;
    }

    @Override // defpackage.b2
    public final /* bridge */ /* synthetic */ Object result() {
        return tb1.a;
    }
}
