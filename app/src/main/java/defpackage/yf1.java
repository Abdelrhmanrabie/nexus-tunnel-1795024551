package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class yf1 implements zl {
    public int a;
    public ch b;
    public qw0 c;
    public int d;
    public final ko e = new ko(this);
    public int f = 0;
    public boolean g = false;
    public final dm h = new dm(this);
    public final dm i = new dm(this);
    public int j = 1;

    public yf1(ch chVar) {
        this.b = chVar;
    }

    public static void b(dm dmVar, dm dmVar2, int i) {
        dmVar.l.add(dmVar2);
        dmVar.f = i;
        dmVar2.k.add(dmVar);
    }

    public static dm h(vg vgVar) {
        yf1 yf1Var;
        yf1 yf1Var2;
        vg vgVar2 = vgVar.f;
        if (vgVar2 == null) {
            return null;
        }
        int iOrdinal = vgVar2.e.ordinal();
        ch chVar = vgVar2.d;
        if (iOrdinal == 1) {
            yf1Var = chVar.d;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    yf1Var2 = chVar.d;
                } else {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            return null;
                        }
                        return chVar.e.k;
                    }
                    yf1Var2 = chVar.e;
                }
                return yf1Var2.i;
            }
            yf1Var = chVar.e;
        }
        return yf1Var.h;
    }

    public static dm i(vg vgVar, int i) {
        vg vgVar2 = vgVar.f;
        if (vgVar2 == null) {
            return null;
        }
        ch chVar = vgVar2.d;
        yf1 yf1Var = i == 0 ? chVar.d : chVar.e;
        int iOrdinal = vgVar2.e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return yf1Var.h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return yf1Var.i;
        }
        return null;
    }

    public final void c(dm dmVar, dm dmVar2, int i, ko koVar) {
        dmVar.l.add(dmVar2);
        dmVar.l.add(this.e);
        dmVar.h = i;
        dmVar.i = koVar;
        dmVar2.k.add(dmVar);
        koVar.k.add(dmVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        ch chVar = this.b;
        if (i2 == 0) {
            int i3 = chVar.w;
            int iMax = Math.max(chVar.v, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            int i4 = chVar.z;
            int iMax2 = Math.max(chVar.y, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        ko koVar = this.e;
        if (koVar.j) {
            return koVar.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code duplicated, block: B:28:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    public final void l(vg vgVar, vg vgVar2, int i) {
        int i2;
        int iG;
        ko koVar;
        float f;
        float f2;
        dm dmVarH = h(vgVar);
        dm dmVarH2 = h(vgVar2);
        if (dmVarH.j && dmVarH2.j) {
            int iD = vgVar.d() + dmVarH.g;
            int iD2 = dmVarH2.g - vgVar2.d();
            int i3 = iD2 - iD;
            ko koVar2 = this.e;
            if (!koVar2.j && this.d == 3) {
                int i4 = this.a;
                if (i4 != 0) {
                    if (i4 == 1) {
                        iG = Math.min(g(koVar2.m, i), i3);
                    } else if (i4 == 2) {
                        ch chVar = this.b;
                        dh dhVar = chVar.W;
                        if (dhVar != null) {
                            ko koVar3 = (i == 0 ? dhVar.d : dhVar.e).e;
                            if (koVar3.j) {
                                i2 = (int) ((koVar3.g * (i == 0 ? chVar.x : chVar.A)) + 0.5f);
                            }
                        }
                    } else if (i4 == 3) {
                        ch chVar2 = this.b;
                        yf1 yf1Var = chVar2.d;
                        if (yf1Var.d == 3 && yf1Var.a == 3) {
                            kd1 kd1Var = chVar2.e;
                            if (kd1Var.d != 3 || kd1Var.a != 3) {
                                if (i == 0) {
                                    yf1Var = chVar2.e;
                                }
                                koVar = yf1Var.e;
                                if (koVar.j) {
                                    f = chVar2.Z;
                                    f2 = koVar.g;
                                    if (i == 1) {
                                        iG = (int) ((f2 / f) + 0.5f);
                                    } else {
                                        iG = (int) ((f * f2) + 0.5f);
                                    }
                                }
                            }
                        } else {
                            if (i == 0) {
                                yf1Var = chVar2.e;
                            }
                            koVar = yf1Var.e;
                            if (koVar.j) {
                                f = chVar2.Z;
                                f2 = koVar.g;
                                if (i == 1) {
                                    iG = (int) ((f2 / f) + 0.5f);
                                } else {
                                    iG = (int) ((f * f2) + 0.5f);
                                }
                            }
                        }
                    }
                    koVar2.d(iG);
                } else {
                    i2 = i3;
                }
                iG = g(i2, i);
                koVar2.d(iG);
            }
            if (koVar2.j) {
                int i5 = koVar2.g;
                dm dmVar = this.i;
                dm dmVar2 = this.h;
                if (i5 == i3) {
                    dmVar2.d(iD);
                    dmVar.d(iD2);
                    return;
                }
                ch chVar3 = this.b;
                float f3 = i == 0 ? chVar3.g0 : chVar3.h0;
                if (dmVarH == dmVarH2) {
                    iD = dmVarH.g;
                    iD2 = dmVarH2.g;
                    f3 = 0.5f;
                }
                dmVar2.d((int) ((((iD2 - iD) - i5) * f3) + iD + 0.5f));
                dmVar.d(dmVar2.g + koVar2.g);
            }
        }
    }
}
