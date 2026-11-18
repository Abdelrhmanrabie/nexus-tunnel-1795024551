package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g10 extends yf1 {
    public static final int[] k = new int[2];

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0225, code lost:
    
        if (r7 != 1) goto L124;
     */
    @Override // defpackage.zl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g10.a():void");
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0298  */
    /* JADX WARN: Code duplicated, block: B:106:0x029e  */
    /* JADX WARN: Code duplicated, block: B:107:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:109:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:111:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:113:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x016c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0170  */
    /* JADX WARN: Code duplicated, block: B:70:0x017b  */
    /* JADX WARN: Code duplicated, block: B:72:0x017f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0183  */
    /* JADX WARN: Code duplicated, block: B:76:0x019b  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x01df  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:83:0x022e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0233  */
    @Override // defpackage.yf1
    public final void d() {
        ch chVar;
        dh dhVar;
        int i;
        ch chVar2;
        vg[] vgVarArr;
        vg vgVar;
        vg vgVar2;
        vg vgVar3;
        dh dhVar2;
        dm dmVarH;
        dm dmVarH2;
        vg vgVar4;
        ch chVar3;
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2;
        dh dhVar3;
        ArrayList arrayList3;
        boolean zV;
        ch chVar4;
        boolean zU;
        ch chVar5;
        dh dhVar4;
        int i3;
        ch chVar6 = this.b;
        boolean z = chVar6.a;
        ko koVar = this.e;
        if (z) {
            koVar.d(chVar6.n());
        }
        boolean z2 = koVar.j;
        dm dmVar = this.i;
        dm dmVar2 = this.h;
        if (!z2) {
            ch chVar7 = this.b;
            int i4 = chVar7.V[0];
            this.d = i4;
            if (i4 != 3) {
                if (i4 == 4 && (dhVar4 = chVar7.W) != null && ((i3 = dhVar4.V[0]) == 1 || i3 == 4)) {
                    int iN = (dhVar4.n() - this.b.K.d()) - this.b.M.d();
                    yf1.b(dmVar2, dhVar4.d.h, this.b.K.d());
                    yf1.b(dmVar, dhVar4.d.i, -this.b.M.d());
                    koVar.d(iN);
                    return;
                }
                if (i4 == 1) {
                    koVar.d(chVar7.n());
                }
            }
        } else if (this.d == 4 && (dhVar = (chVar = this.b).W) != null && ((i = dhVar.V[0]) == 1 || i == 4)) {
            yf1.b(dmVar2, dhVar.d.h, chVar.K.d());
            yf1.b(dmVar, dhVar.d.i, -this.b.M.d());
            return;
        }
        if (!koVar.j) {
            if (this.d == 3) {
                chVar3 = this.b;
                i2 = chVar3.s;
                arrayList = koVar.k;
                arrayList2 = koVar.l;
                if (i2 != 2) {
                    dhVar3 = chVar3.W;
                    if (dhVar3 != null) {
                        ko koVar2 = dhVar3.e.e;
                        arrayList2.add(koVar2);
                        koVar2.k.add(koVar);
                        koVar.b = true;
                        arrayList.add(dmVar2);
                        arrayList.add(dmVar);
                    }
                } else if (i2 == 3) {
                    if (chVar3.t == 3) {
                        dmVar2.a = this;
                        dmVar.a = this;
                        kd1 kd1Var = chVar3.e;
                        kd1Var.h.a = this;
                        kd1Var.i.a = this;
                        koVar.a = this;
                        zV = chVar3.v();
                        chVar4 = this.b;
                        if (zV) {
                            arrayList2.add(chVar4.e.e);
                            this.b.e.e.k.add(koVar);
                            kd1 kd1Var2 = this.b.e;
                            kd1Var2.e.a = this;
                            arrayList2.add(kd1Var2.h);
                            arrayList2.add(this.b.e.i);
                            this.b.e.h.k.add(koVar);
                            arrayList3 = this.b.e.i.k;
                        } else {
                            zU = chVar4.u();
                            chVar5 = this.b;
                            if (zU) {
                                chVar5.e.e.l.add(koVar);
                                arrayList.add(this.b.e.e);
                            } else {
                                arrayList3 = chVar5.e.e.l;
                            }
                        }
                    } else {
                        ko koVar3 = chVar3.e.e;
                        arrayList2.add(koVar3);
                        koVar3.k.add(koVar);
                        this.b.e.h.k.add(koVar);
                        this.b.e.i.k.add(koVar);
                        koVar.b = true;
                        arrayList.add(dmVar2);
                        arrayList.add(dmVar);
                        dmVar2.l.add(koVar);
                        arrayList3 = dmVar.l;
                    }
                    arrayList3.add(koVar);
                }
            }
            chVar2 = this.b;
            vgVarArr = chVar2.S;
            vgVar = vgVarArr[0];
            vgVar2 = vgVar.f;
            if (vgVar2 != null) {
            }
            if (vgVar2 == null) {
                vgVar3 = vgVarArr[1];
                if (vgVar3.f == null) {
                    if (chVar2 instanceof h8) {
                        return;
                    } else {
                        return;
                    }
                }
                dmVarH = yf1.h(vgVar3);
                if (dmVarH != null) {
                    yf1.b(dmVar, dmVarH, -this.b.S[1].d());
                    c(dmVar2, dmVar, -1, koVar);
                    return;
                }
                return;
            }
            dmVarH2 = yf1.h(vgVar);
            if (dmVarH2 != null) {
                return;
            } else {
                yf1.b(dmVar2, dmVarH2, this.b.S[0].d());
            }
            c(dmVar, dmVar2, 1, koVar);
            return;
        }
        ch chVar8 = this.b;
        if (chVar8.a) {
            vg[] vgVarArr2 = chVar8.S;
            vg vgVar5 = vgVarArr2[0];
            vg vgVar6 = vgVar5.f;
            if (vgVar6 == null || vgVarArr2[1].f == null) {
                if (vgVar6 != null) {
                    dm dmVarH3 = yf1.h(vgVar5);
                    if (dmVarH3 == null) {
                        return;
                    } else {
                        yf1.b(dmVar2, dmVarH3, this.b.S[0].d());
                    }
                } else {
                    vg vgVar7 = vgVarArr2[1];
                    if (vgVar7.f != null) {
                        dm dmVarH4 = yf1.h(vgVar7);
                        if (dmVarH4 != null) {
                            yf1.b(dmVar, dmVarH4, -this.b.S[1].d());
                            yf1.b(dmVar2, dmVar, -koVar.g);
                            return;
                        }
                        return;
                    }
                    if ((chVar8 instanceof h8) || chVar8.W == null || chVar8.g(vg.a.i).f != null) {
                        return;
                    }
                    ch chVar9 = this.b;
                    yf1.b(dmVar2, chVar9.W.d.h, chVar9.o());
                }
                yf1.b(dmVar, dmVar2, koVar.g);
                return;
            }
            boolean zU2 = chVar8.u();
            ch chVar10 = this.b;
            if (!zU2) {
                dm dmVarH5 = yf1.h(chVar10.S[0]);
                if (dmVarH5 != null) {
                    yf1.b(dmVar2, dmVarH5, this.b.S[0].d());
                }
                dm dmVarH6 = yf1.h(this.b.S[1]);
                if (dmVarH6 != null) {
                    yf1.b(dmVar, dmVarH6, -this.b.S[1].d());
                }
                dmVar2.b = true;
                dmVar.b = true;
                return;
            }
            dmVar2.f = chVar10.S[0].d();
            vgVar4 = this.b.S[1];
        } else {
            if (this.d == 3) {
                chVar3 = this.b;
                i2 = chVar3.s;
                arrayList = koVar.k;
                arrayList2 = koVar.l;
                if (i2 != 2) {
                    dhVar3 = chVar3.W;
                    if (dhVar3 != null) {
                        ko koVar4 = dhVar3.e.e;
                        arrayList2.add(koVar4);
                        koVar4.k.add(koVar);
                        koVar.b = true;
                        arrayList.add(dmVar2);
                        arrayList.add(dmVar);
                    }
                } else if (i2 == 3) {
                    if (chVar3.t == 3) {
                        dmVar2.a = this;
                        dmVar.a = this;
                        kd1 kd1Var3 = chVar3.e;
                        kd1Var3.h.a = this;
                        kd1Var3.i.a = this;
                        koVar.a = this;
                        zV = chVar3.v();
                        chVar4 = this.b;
                        if (zV) {
                            arrayList2.add(chVar4.e.e);
                            this.b.e.e.k.add(koVar);
                            kd1 kd1Var4 = this.b.e;
                            kd1Var4.e.a = this;
                            arrayList2.add(kd1Var4.h);
                            arrayList2.add(this.b.e.i);
                            this.b.e.h.k.add(koVar);
                            arrayList3 = this.b.e.i.k;
                        } else {
                            zU = chVar4.u();
                            chVar5 = this.b;
                            if (zU) {
                                chVar5.e.e.l.add(koVar);
                                arrayList.add(this.b.e.e);
                            } else {
                                arrayList3 = chVar5.e.e.l;
                            }
                        }
                    } else {
                        ko koVar5 = chVar3.e.e;
                        arrayList2.add(koVar5);
                        koVar5.k.add(koVar);
                        this.b.e.h.k.add(koVar);
                        this.b.e.i.k.add(koVar);
                        koVar.b = true;
                        arrayList.add(dmVar2);
                        arrayList.add(dmVar);
                        dmVar2.l.add(koVar);
                        arrayList3 = dmVar.l;
                    }
                    arrayList3.add(koVar);
                }
            }
            chVar2 = this.b;
            vgVarArr = chVar2.S;
            vgVar = vgVarArr[0];
            vgVar2 = vgVar.f;
            if (vgVar2 != null || vgVarArr[1].f == null) {
                if (vgVar2 == null) {
                    dmVarH2 = yf1.h(vgVar);
                    if (dmVarH2 != null) {
                        return;
                    } else {
                        yf1.b(dmVar2, dmVarH2, this.b.S[0].d());
                    }
                } else {
                    vgVar3 = vgVarArr[1];
                    if (vgVar3.f == null) {
                        dmVarH = yf1.h(vgVar3);
                        if (dmVarH != null) {
                            yf1.b(dmVar, dmVarH, -this.b.S[1].d());
                            c(dmVar2, dmVar, -1, koVar);
                            return;
                        }
                        return;
                    }
                    if ((chVar2 instanceof h8) || (dhVar2 = chVar2.W) == null) {
                        return;
                    } else {
                        yf1.b(dmVar2, dhVar2.d.h, chVar2.o());
                    }
                }
                c(dmVar, dmVar2, 1, koVar);
                return;
            }
            boolean zU3 = chVar2.u();
            ch chVar11 = this.b;
            if (!zU3) {
                dm dmVarH7 = yf1.h(chVar11.S[0]);
                dm dmVarH8 = yf1.h(this.b.S[1]);
                if (dmVarH7 != null) {
                    dmVarH7.b(this);
                }
                if (dmVarH8 != null) {
                    dmVarH8.b(this);
                }
                this.j = 4;
                return;
            }
            dmVar2.f = chVar11.S[0].d();
            vgVar4 = this.b.S[1];
        }
        dmVar.f = -vgVar4.d();
    }

    @Override // defpackage.yf1
    public final void e() {
        dm dmVar = this.h;
        if (dmVar.j) {
            this.b.b0 = dmVar.g;
        }
    }

    @Override // defpackage.yf1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.yf1
    public final boolean k() {
        return this.d != 3 || this.b.s == 0;
    }

    public final void n() {
        this.g = false;
        dm dmVar = this.h;
        dmVar.c();
        dmVar.j = false;
        dm dmVar2 = this.i;
        dmVar2.c();
        dmVar2.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.b.k0;
    }
}
