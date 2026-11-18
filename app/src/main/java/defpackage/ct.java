package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ct implements qs {
    @Override // defpackage.qs
    public final qs.a a() {
        return qs.a.d;
    }

    @Override // defpackage.qs
    public final qs.b b(ja jaVar, ja jaVar2, ai0 ai0Var) {
        boolean z = jaVar2 instanceof nq0;
        qs.b bVar = qs.b.d;
        if (z && (jaVar instanceof nq0)) {
            nq0 nq0Var = (nq0) jaVar2;
            nq0 nq0Var2 = (nq0) jaVar;
            if (nq0Var.getName().equals(nq0Var2.getName())) {
                pq0 pq0Var = nq0Var.B;
                if (pq0Var == null && nq0Var2.B == null) {
                    return qs.b.b;
                }
                if (pq0Var == null || nq0Var2.B == null) {
                    return qs.b.c;
                }
            }
        }
        return bVar;
    }
}
