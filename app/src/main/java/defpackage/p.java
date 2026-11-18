package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements li.b {
    public final li.c b;

    public p(li.c cVar) {
        this.b = cVar;
    }

    @Override // defpackage.li
    public li.b a(li.c cVar) {
        if (e4.a(getKey(), cVar)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.li
    public li f(li.c cVar) {
        return e4.a(getKey(), cVar) ? rq.b : this;
    }

    @Override // li.b
    public final li.c getKey() {
        return this.b;
    }

    @Override // defpackage.li
    public final Object i(Object obj, bx bxVar) {
        return bxVar.invoke(obj, this);
    }

    @Override // defpackage.li
    public final li y(li liVar) {
        return ak.a(this, liVar);
    }
}
