package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kd1 extends yf1 {
    public final dm k;
    public m8 l;

    public kd1(ch chVar) {
        super(chVar);
        dm dmVar = new dm(this);
        this.k = dmVar;
        this.l = null;
        this.h.e = 6;
        this.i.e = 7;
        dmVar.e = 8;
        this.f = 1;
    }

    @Override // defpackage.zl
    public final void a() {
        float f;
        float f2;
        float f3;
        int i;
        if (ak.u(this.j) == 3) {
            ch chVar = this.b;
            l(chVar.L, chVar.N, 1);
            return;
        }
        ko koVar = this.e;
        if (koVar.c && !koVar.j && this.d == 3) {
            ch chVar2 = this.b;
            int i2 = chVar2.t;
            if (i2 == 2) {
                dh dhVar = chVar2.W;
                if (dhVar != null) {
                    ko koVar2 = dhVar.e.e;
                    if (koVar2.j) {
                        f = chVar2.A;
                        f2 = koVar2.g;
                        f3 = f2 * f;
                        i = (int) (f3 + 0.5f);
                        koVar.d(i);
                    }
                }
            } else if (i2 == 3) {
                ko koVar3 = chVar2.d.e;
                if (koVar3.j) {
                    int i3 = chVar2.a0;
                    if (i3 != -1) {
                        if (i3 == 0) {
                            f2 = koVar3.g;
                            f = chVar2.Z;
                            f3 = f2 * f;
                            i = (int) (f3 + 0.5f);
                        } else if (i3 != 1) {
                            i = 0;
                        }
                        koVar.d(i);
                    }
                    f3 = koVar3.g / chVar2.Z;
                    i = (int) (f3 + 0.5f);
                    koVar.d(i);
                }
            }
        }
        dm dmVar = this.h;
        if (dmVar.c) {
            dm dmVar2 = this.i;
            if (dmVar2.c) {
                if (dmVar.j && dmVar2.j && koVar.j) {
                    return;
                }
                boolean z = koVar.j;
                ArrayList arrayList = dmVar.l;
                ArrayList arrayList2 = dmVar2.l;
                if (!z && this.d == 3) {
                    ch chVar3 = this.b;
                    if (chVar3.s == 0 && !chVar3.v()) {
                        dm dmVar3 = (dm) arrayList.get(0);
                        dm dmVar4 = (dm) arrayList2.get(0);
                        int i4 = dmVar3.g + dmVar.f;
                        int i5 = dmVar4.g + dmVar2.f;
                        dmVar.d(i4);
                        dmVar2.d(i5);
                        koVar.d(i5 - i4);
                        return;
                    }
                }
                if (!koVar.j && this.d == 3 && this.a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    dm dmVar5 = (dm) arrayList.get(0);
                    int i6 = (((dm) arrayList2.get(0)).g + dmVar2.f) - (dmVar5.g + dmVar.f);
                    int i7 = koVar.m;
                    if (i6 < i7) {
                        koVar.d(i6);
                    } else {
                        koVar.d(i7);
                    }
                }
                if (koVar.j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    dm dmVar6 = (dm) arrayList.get(0);
                    dm dmVar7 = (dm) arrayList2.get(0);
                    int i8 = dmVar6.g;
                    int i9 = dmVar.f + i8;
                    int i10 = dmVar7.g;
                    int i11 = dmVar2.f + i10;
                    float f4 = this.b.h0;
                    if (dmVar6 == dmVar7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    dmVar.d((int) ((((i10 - i8) - koVar.g) * f4) + i8 + 0.5f));
                    dmVar2.d(dmVar.g + koVar.g);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:155:0x0304 A[PHI: r0
      0x0304: PHI (r0v22 g10) = (r0v15 g10), (r0v33 g10) binds: [B:154:0x0302, B:128:0x028b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.yf1
    public final void d() {
        ch chVar;
        dh dhVar;
        dh dhVar2;
        g10 g10Var;
        yf1 yf1Var;
        ch chVar2;
        dh dhVar3;
        ch chVar3 = this.b;
        boolean z = chVar3.a;
        ko koVar = this.e;
        if (z) {
            koVar.d(chVar3.i());
        }
        boolean z2 = koVar.j;
        dm dmVar = this.i;
        dm dmVar2 = this.h;
        if (!z2) {
            ch chVar4 = this.b;
            this.d = chVar4.V[1];
            if (chVar4.F) {
                this.l = new m8(this);
            }
            int i = this.d;
            if (i != 3) {
                if (i == 4 && (dhVar3 = this.b.W) != null && dhVar3.V[1] == 1) {
                    int i2 = (dhVar3.i() - this.b.L.d()) - this.b.N.d();
                    yf1.b(dmVar2, dhVar3.e.h, this.b.L.d());
                    yf1.b(dmVar, dhVar3.e.i, -this.b.N.d());
                    koVar.d(i2);
                    return;
                }
                if (i == 1) {
                    koVar.d(this.b.i());
                }
            }
        } else if (this.d == 4 && (dhVar = (chVar = this.b).W) != null && dhVar.V[1] == 1) {
            yf1.b(dmVar2, dhVar.e.h, chVar.L.d());
            yf1.b(dmVar, dhVar.e.i, -this.b.N.d());
            return;
        }
        boolean z3 = koVar.j;
        dm dmVar3 = this.k;
        if (z3) {
            ch chVar5 = this.b;
            if (chVar5.a) {
                vg[] vgVarArr = chVar5.S;
                vg vgVar = vgVarArr[2];
                vg vgVar2 = vgVar.f;
                if (vgVar2 != null && vgVarArr[3].f != null) {
                    boolean zV = chVar5.v();
                    ch chVar6 = this.b;
                    if (zV) {
                        dmVar2.f = chVar6.S[2].d();
                        dmVar.f = -this.b.S[3].d();
                    } else {
                        dm dmVarH = yf1.h(chVar6.S[2]);
                        if (dmVarH != null) {
                            yf1.b(dmVar2, dmVarH, this.b.S[2].d());
                        }
                        dm dmVarH2 = yf1.h(this.b.S[3]);
                        if (dmVarH2 != null) {
                            yf1.b(dmVar, dmVarH2, -this.b.S[3].d());
                        }
                        dmVar2.b = true;
                        dmVar.b = true;
                    }
                    chVar2 = this.b;
                    if (!chVar2.F) {
                        return;
                    }
                } else if (vgVar2 != null) {
                    dm dmVarH3 = yf1.h(vgVar);
                    if (dmVarH3 == null) {
                        return;
                    }
                    yf1.b(dmVar2, dmVarH3, this.b.S[2].d());
                    yf1.b(dmVar, dmVar2, koVar.g);
                    chVar2 = this.b;
                    if (!chVar2.F) {
                        return;
                    }
                } else {
                    vg vgVar3 = vgVarArr[3];
                    if (vgVar3.f != null) {
                        dm dmVarH4 = yf1.h(vgVar3);
                        if (dmVarH4 != null) {
                            yf1.b(dmVar, dmVarH4, -this.b.S[3].d());
                            yf1.b(dmVar2, dmVar, -koVar.g);
                        }
                        chVar2 = this.b;
                        if (!chVar2.F) {
                            return;
                        }
                    } else {
                        vg vgVar4 = vgVarArr[4];
                        if (vgVar4.f != null) {
                            dm dmVarH5 = yf1.h(vgVar4);
                            if (dmVarH5 != null) {
                                yf1.b(dmVar3, dmVarH5, 0);
                                yf1.b(dmVar2, dmVar3, -this.b.d0);
                                yf1.b(dmVar, dmVar2, koVar.g);
                                return;
                            }
                            return;
                        }
                        if ((chVar5 instanceof h8) || chVar5.W == null || chVar5.g(vg.a.i).f != null) {
                            return;
                        }
                        ch chVar7 = this.b;
                        yf1.b(dmVar2, chVar7.W.e.h, chVar7.p());
                        yf1.b(dmVar, dmVar2, koVar.g);
                        chVar2 = this.b;
                        if (!chVar2.F) {
                            return;
                        }
                    }
                }
                yf1.b(dmVar3, dmVar2, chVar2.d0);
                return;
            }
        }
        ArrayList arrayList = koVar.l;
        if (z3 || this.d != 3) {
            koVar.b(this);
        } else {
            ch chVar8 = this.b;
            int i3 = chVar8.t;
            if (i3 == 2) {
                dh dhVar4 = chVar8.W;
                if (dhVar4 != null) {
                    yf1Var = dhVar4.e;
                    ko koVar2 = yf1Var.e;
                    arrayList.add(koVar2);
                    koVar2.k.add(koVar);
                    koVar.b = true;
                    ArrayList arrayList2 = koVar.k;
                    arrayList2.add(dmVar2);
                    arrayList2.add(dmVar);
                }
            } else if (i3 == 3 && !chVar8.v()) {
                ch chVar9 = this.b;
                if (chVar9.s != 3) {
                    yf1Var = chVar9.d;
                    ko koVar3 = yf1Var.e;
                    arrayList.add(koVar3);
                    koVar3.k.add(koVar);
                    koVar.b = true;
                    ArrayList arrayList3 = koVar.k;
                    arrayList3.add(dmVar2);
                    arrayList3.add(dmVar);
                }
            }
        }
        ch chVar10 = this.b;
        vg[] vgVarArr2 = chVar10.S;
        vg vgVar5 = vgVarArr2[2];
        vg vgVar6 = vgVar5.f;
        if (vgVar6 != null && vgVarArr2[3].f != null) {
            boolean zV2 = chVar10.v();
            ch chVar11 = this.b;
            if (zV2) {
                dmVar2.f = chVar11.S[2].d();
                dmVar.f = -this.b.S[3].d();
            } else {
                dm dmVarH6 = yf1.h(chVar11.S[2]);
                dm dmVarH7 = yf1.h(this.b.S[3]);
                if (dmVarH6 != null) {
                    dmVarH6.b(this);
                }
                if (dmVarH7 != null) {
                    dmVarH7.b(this);
                }
                this.j = 4;
            }
            if (this.b.F) {
                c(dmVar3, dmVar2, 1, this.l);
            }
        } else if (vgVar6 != null) {
            dm dmVarH8 = yf1.h(vgVar5);
            if (dmVarH8 != null) {
                yf1.b(dmVar2, dmVarH8, this.b.S[2].d());
                c(dmVar, dmVar2, 1, koVar);
                if (this.b.F) {
                    c(dmVar3, dmVar2, 1, this.l);
                }
                if (this.d == 3) {
                    ch chVar12 = this.b;
                    if (chVar12.Z > 0.0f) {
                        g10Var = chVar12.d;
                        if (g10Var.d == 3) {
                            g10Var.e.k.add(koVar);
                            arrayList.add(this.b.d.e);
                            koVar.a = this;
                        }
                    }
                }
            }
        } else {
            vg vgVar7 = vgVarArr2[3];
            if (vgVar7.f != null) {
                dm dmVarH9 = yf1.h(vgVar7);
                if (dmVarH9 != null) {
                    yf1.b(dmVar, dmVarH9, -this.b.S[3].d());
                    c(dmVar2, dmVar, -1, koVar);
                    if (this.b.F) {
                        c(dmVar3, dmVar2, 1, this.l);
                    }
                }
            } else {
                vg vgVar8 = vgVarArr2[4];
                if (vgVar8.f != null) {
                    dm dmVarH10 = yf1.h(vgVar8);
                    if (dmVarH10 != null) {
                        yf1.b(dmVar3, dmVarH10, 0);
                        c(dmVar2, dmVar3, -1, this.l);
                        c(dmVar, dmVar2, 1, koVar);
                    }
                } else if (!(chVar10 instanceof h8) && (dhVar2 = chVar10.W) != null) {
                    yf1.b(dmVar2, dhVar2.e.h, chVar10.p());
                    c(dmVar, dmVar2, 1, koVar);
                    if (this.b.F) {
                        c(dmVar3, dmVar2, 1, this.l);
                    }
                    if (this.d == 3) {
                        ch chVar13 = this.b;
                        if (chVar13.Z > 0.0f) {
                            g10Var = chVar13.d;
                            if (g10Var.d == 3) {
                                g10Var.e.k.add(koVar);
                                arrayList.add(this.b.d.e);
                                koVar.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            koVar.c = true;
        }
    }

    @Override // defpackage.yf1
    public final void e() {
        dm dmVar = this.h;
        if (dmVar.j) {
            this.b.c0 = dmVar.g;
        }
    }

    @Override // defpackage.yf1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.yf1
    public final boolean k() {
        return this.d != 3 || this.b.t == 0;
    }

    public final void m() {
        this.g = false;
        dm dmVar = this.h;
        dmVar.c();
        dmVar.j = false;
        dm dmVar2 = this.i;
        dmVar2.c();
        dmVar2.j = false;
        dm dmVar3 = this.k;
        dmVar3.c();
        dmVar3.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.b.k0;
    }
}
