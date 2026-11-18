package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class fy0 extends o implements wi {
    public final ai f;

    public fy0(ai aiVar, li liVar) {
        super(liVar, true);
        this.f = aiVar;
    }

    @Override // defpackage.h70
    public void B(Object obj) {
        e.o1(e.T(obj), e.U0(this.f));
    }

    @Override // defpackage.h70
    public final boolean R() {
        return true;
    }

    @Override // defpackage.h70
    public void d0(Object obj) {
        this.f.resumeWith(e.T(obj));
    }

    @Override // defpackage.wi
    public final wi getCallerFrame() {
        ai aiVar = this.f;
        if (aiVar instanceof wi) {
            return (wi) aiVar;
        }
        return null;
    }
}
