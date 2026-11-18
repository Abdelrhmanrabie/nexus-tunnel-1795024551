package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rb1 implements li.b, li.c {
    public static final rb1 b = new rb1();

    @Override // defpackage.li
    public final li.b a(li.c cVar) {
        if (e4.a(this, cVar)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.li
    public final li f(li.c cVar) {
        return e4.a(this, cVar) ? rq.b : this;
    }

    @Override // li.b
    public final li.c getKey() {
        return this;
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
