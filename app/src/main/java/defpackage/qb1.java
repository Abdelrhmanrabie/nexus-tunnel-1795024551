package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qb1 extends fy0 {
    public final ThreadLocal g;
    public volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public qb1(ai aiVar, li liVar) {
        rb1 rb1Var = rb1.b;
        super(aiVar, liVar.a(rb1Var) == null ? liVar.y(rb1Var) : liVar);
        ThreadLocal threadLocal = new ThreadLocal();
        this.g = threadLocal;
        if (aiVar.getContext().a(e.b$2) instanceof oi) {
            return;
        }
        Object objB = b2.b(liVar, (Object) null);
        b2.a(liVar, objB);
        this.threadLocalIsSet = true;
        threadLocal.set(new jo0(liVar, objB));
    }

    @Override // defpackage.fy0, defpackage.h70
    public final void d0(Object obj) {
        if (this.threadLocalIsSet) {
            jo0 jo0Var = (jo0) this.g.get();
            if (jo0Var != null) {
                b2.a((li) jo0Var.b, jo0Var.c);
            }
            this.g.remove();
        }
        Object objT = e.T(obj);
        ai aiVar = this.f;
        li context = aiVar.getContext();
        Object objB = b2.b(context, (Object) null);
        qb1 qb1VarB = objB != b2.a ? ak.b(aiVar, context, objB) : null;
        try {
            this.f.resumeWith(objT);
        } finally {
            if (qb1VarB == null || qb1VarB.f0()) {
                b2.a(context, objB);
            }
        }
    }

    public final boolean f0() {
        boolean z = this.threadLocalIsSet && this.g.get() == null;
        this.g.remove();
        return !z;
    }
}
