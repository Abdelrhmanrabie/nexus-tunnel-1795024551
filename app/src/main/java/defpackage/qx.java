package defpackage;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qx implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ qx(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        if (i == 0) {
            return (List) this.b;
        }
        if (i != 1) {
            px pxVar = (px) this.b;
            return b2.a("Scope for type parameter ".concat(((ij0) pxVar.b).b()), (SequencedCollection) ((y0) pxVar.c).getUpperBounds());
        }
        ir.a aVar = (ir.a) this.b;
        HashSet hashSet = new HashSet();
        for (ij0 ij0Var : (Set) aVar.e.p.invoke()) {
            if (ij0Var == null) {
                ir.a.h(5);
                throw null;
            }
            hashSet.addAll((Collection) aVar.b.invoke(ij0Var));
            hashSet.addAll((Collection) aVar.c.invoke(ij0Var));
        }
        return hashSet;
    }
}
