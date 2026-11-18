package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y31 extends wg0 {
    public final ji0 b;
    public final cv c;

    public y31(ji0 ji0Var, cv cvVar) {
        this.b = ji0Var;
        this.c = cvVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007f  */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r7.a.contains(km.b.a) != false) goto L9;
     */
    @Override // defpackage.wg0, defpackage.vg0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection f(defpackage.lm r7, defpackage.nw r8) {
        /*
            r6 = this;
            int r0 = defpackage.lm.h
            boolean r0 = r7.a(r0)
            if (r0 != 0) goto L9
            goto L1b
        L9:
            cv r0 = r6.c
            boolean r1 = r0.d()
            if (r1 == 0) goto L1e
            km$b r1 = km.b.a
            java.util.List r7 = r7.a
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto L1e
        L1b:
            uq r7 = defpackage.uq.b
            return r7
        L1e:
            ji0 r7 = r6.b
            r7.i0()
            r7.i0()
            v41 r1 = r7.q
            java.lang.Object r1 = r1.getValue()
            xf r1 = (defpackage.xf) r1
            java.util.Collection r1 = r1.l(r0, r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.HashSet r1 = (java.util.HashSet) r1
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L41:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L84
            java.lang.Object r3 = r1.next()
            cv r3 = (defpackage.cv) r3
            dv r3 = r3.a
            ij0 r3 = r3.g()
            java.lang.Object r4 = r8.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L41
            boolean r4 = r3.c
            if (r4 == 0) goto L64
            goto L7f
        L64:
            cv r3 = r0.c(r3)
            vd0 r3 = r7.U(r3)
            ja0[] r4 = defpackage.vd0.n
            r5 = 1
            r4 = r4[r5]
            ff0$h r4 = r3.i
            java.lang.Object r4 = r4.invoke()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L80
        L7f:
            r3 = 0
        L80:
            defpackage.e.s0(r2, r3)
            goto L41
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y31.f(lm, nw):java.util.Collection");
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set g() {
        return yq.b;
    }

    public final String toString() {
        return "subpackages of " + this.c + " from " + this.b;
    }
}
