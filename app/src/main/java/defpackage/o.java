package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends h70 implements ai, ti {
    public final li d;

    public o(li liVar, boolean z) {
        super(z);
        Q((h70) liVar.a(e.b$1));
        this.d = liVar.y(this);
    }

    @Override // defpackage.h70
    public final String E() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // defpackage.h70
    public final void P(we weVar) {
        b2.a(this.d, (Throwable) weVar);
    }

    @Override // defpackage.h70
    public final void W(Object obj) {
        if (obj instanceof te) {
            te.b.get((te) obj);
        }
    }

    @Override // defpackage.ai
    public final li getContext() {
        return this.d;
    }

    @Override // defpackage.ai
    public final void resumeWith(Object obj) {
        Throwable thA = bw0.a(obj);
        if (thA != null) {
            obj = new te(thA);
        }
        Object objS = S(obj);
        if (objS == e.d) {
            return;
        }
        d0(objS);
    }

    @Override // defpackage.ti
    public final li x() {
        return this.d;
    }
}
