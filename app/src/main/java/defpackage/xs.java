package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xs extends jx0 {
    public final HashMap g = new HashMap();

    @Override // defpackage.jx0
    public final jx0.c b(Object obj) {
        return (jx0.c) this.g.get(obj);
    }

    @Override // defpackage.jx0
    public final Object d(Object obj, Object obj2) {
        jx0.c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.c;
        }
        jx0.c cVar = new jx0.c(obj, obj2);
        this.f++;
        jx0.c cVar2 = this.c;
        if (cVar2 == null) {
            this.b = cVar;
        } else {
            cVar2.d = cVar;
            cVar.f = cVar2;
        }
        this.c = cVar;
        this.g.put(obj, cVar);
        return null;
    }

    @Override // defpackage.jx0
    public final Object e(Object obj) {
        Object objE = super.e(obj);
        this.g.remove(obj);
        return objE;
    }
}
