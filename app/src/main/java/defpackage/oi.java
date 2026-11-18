package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class oi extends p implements li.b {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a implements li.c {
    }

    public oi() {
        super(e.b$2);
    }

    public boolean A() {
        return !(this instanceof nb1);
    }

    @Override // defpackage.p, defpackage.li
    public final li.b a(li.c cVar) {
        li.b bVar;
        if (!(cVar instanceof a)) {
            if (e.b$2 == cVar) {
                return this;
            }
            return null;
        }
        if (this.b == ((a) cVar) && (bVar = (li.b) ld0.b$28.invoke(this)) != null) {
            return bVar;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (defpackage.e.b$2 == r2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return defpackage.rq.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (((li.b) defpackage.ld0.b$28.invoke(r1)) == null) goto L14;
     */
    @Override // defpackage.p, defpackage.li
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.li f(li.c r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof oi.a
            if (r0 == 0) goto L16
            oi$a r2 = (oi.a) r2
            li$c r0 = r1.b
            if (r0 == r2) goto Lb
            goto L1d
        Lb:
            ld0 r2 = defpackage.ld0.b$28
            java.lang.Object r2 = r2.invoke(r1)
            li$b r2 = (li.b) r2
            if (r2 == 0) goto L1d
            goto L1a
        L16:
            e r0 = defpackage.e.b$2
            if (r0 != r2) goto L1d
        L1a:
            rq r2 = defpackage.rq.b
            return r2
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi.f(li$c):li");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + e.D(this);
    }

    public abstract void x(li liVar, Runnable runnable);
}
