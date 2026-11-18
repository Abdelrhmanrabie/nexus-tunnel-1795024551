package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e10 extends yf1 {
    @Override // defpackage.zl
    public final void a() {
        h8 h8Var = (h8) this.b;
        int i = h8Var.u0;
        dm dmVar = this.h;
        Iterator it = dmVar.l.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = ((dm) it.next()).g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            dmVar.d(i3 + h8Var.w0);
        } else {
            dmVar.d(i2 + h8Var.w0);
        }
    }

    @Override // defpackage.yf1
    public final void d() {
        yf1 yf1Var;
        ch chVar = this.b;
        if (chVar instanceof h8) {
            dm dmVar = this.h;
            dmVar.b = true;
            h8 h8Var = (h8) chVar;
            int i = h8Var.u0;
            boolean z = h8Var.v0;
            ArrayList arrayList = dmVar.l;
            int i2 = 0;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        dmVar.e = 6;
                        while (i2 < h8Var.t0) {
                            ch chVar2 = h8Var.s0[i2];
                            if (z || chVar2.j0 != 8) {
                                dm dmVar2 = chVar2.e.h;
                                dmVar2.k.add(dmVar);
                                arrayList.add(dmVar2);
                            }
                            i2++;
                        }
                    } else {
                        if (i != 3) {
                            return;
                        }
                        dmVar.e = 7;
                        while (i2 < h8Var.t0) {
                            ch chVar3 = h8Var.s0[i2];
                            if (z || chVar3.j0 != 8) {
                                dm dmVar3 = chVar3.e.i;
                                dmVar3.k.add(dmVar);
                                arrayList.add(dmVar3);
                            }
                            i2++;
                        }
                    }
                    dm dmVar4 = this.b.e.h;
                    dmVar.k.add(dmVar4);
                    dmVar4.l.add(dmVar);
                    yf1Var = this.b.e;
                } else {
                    dmVar.e = 5;
                    while (i2 < h8Var.t0) {
                        ch chVar4 = h8Var.s0[i2];
                        if (z || chVar4.j0 != 8) {
                            dm dmVar5 = chVar4.d.i;
                            dmVar5.k.add(dmVar);
                            arrayList.add(dmVar5);
                        }
                        i2++;
                    }
                }
                dm dmVar6 = yf1Var.i;
                dmVar.k.add(dmVar6);
                dmVar6.l.add(dmVar);
            }
            dmVar.e = 4;
            while (i2 < h8Var.t0) {
                ch chVar5 = h8Var.s0[i2];
                if (z || chVar5.j0 != 8) {
                    dm dmVar7 = chVar5.d.h;
                    dmVar7.k.add(dmVar);
                    arrayList.add(dmVar7);
                }
                i2++;
            }
            dm dmVar8 = this.b.d.h;
            dmVar.k.add(dmVar8);
            dmVar8.l.add(dmVar);
            yf1Var = this.b.d;
            dm dmVar9 = yf1Var.i;
            dmVar.k.add(dmVar9);
            dmVar9.l.add(dmVar);
        }
    }

    @Override // defpackage.yf1
    public final void e() {
        ch chVar = this.b;
        if (chVar instanceof h8) {
            int i = ((h8) chVar).u0;
            dm dmVar = this.h;
            if (i == 0 || i == 1) {
                chVar.b0 = dmVar.g;
            } else {
                chVar.c0 = dmVar.g;
            }
        }
    }

    @Override // defpackage.yf1
    public final void f() {
        this.c = null;
        this.h.c();
    }

    @Override // defpackage.yf1
    public final boolean k() {
        return false;
    }
}
