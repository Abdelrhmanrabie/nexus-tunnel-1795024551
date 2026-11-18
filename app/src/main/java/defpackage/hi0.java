package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hi0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ji0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hi0(ji0 ji0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = ji0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        ji0 ji0Var = this.b;
        if (i != 0) {
            return i != 1 ? new w70.a(ji0Var) : ji0Var.U(m21.f).j;
        }
        fi0 fi0Var = ji0Var.j;
        if (fi0Var == null) {
            throw new AssertionError(fb$1.m(new StringBuilder("Dependencies of module "), ji0Var.getName().b, " were not set before querying module content"));
        }
        List list = fi0Var.a;
        ji0Var.i0();
        list.contains(ji0Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ji0) it.next()).getClass();
        }
        ArrayList arrayList = new ArrayList(ae.y0(list));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((ji0) it2.next()).n);
        }
        return new xf(arrayList, e4.j("CompositeProvider@ModuleDescriptor for ", ji0Var.getName()));
    }
}
