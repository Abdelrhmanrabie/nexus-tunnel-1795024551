package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xb extends yf1 {
    public final ArrayList k;
    public int l;

    /* JADX WARN: Code duplicated, block: B:15:0x002b A[PHI: r2
      0x002b: PHI (r2v2 vg) = (r2v0 vg), (r2v3 vg) binds: [B:14:0x0029, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0065 A[PHI: r6
      0x0065: PHI (r6v24 vg) = (r6v12 vg), (r6v25 vg) binds: [B:38:0x0063, B:32:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    public xb(int i, ch chVar) {
        vg vgVar;
        ch chVar2;
        vg vgVar2;
        super(chVar);
        this.k = new ArrayList();
        this.f = i;
        ch chVar3 = this.b;
        while (true) {
            int i2 = this.f;
            if (i2 == 0) {
                vg vgVar3 = chVar3.K;
                vgVar = vgVar3.f;
                if (vgVar == null || vgVar.f != vgVar3) {
                    chVar2 = null;
                } else {
                    chVar2 = vgVar.d;
                }
            } else {
                if (i2 == 1) {
                    vg vgVar4 = chVar3.L;
                    vgVar = vgVar4.f;
                    if (vgVar != null && vgVar.f == vgVar4) {
                        chVar2 = vgVar.d;
                    }
                } else {
                    chVar3.getClass();
                }
                chVar2 = null;
            }
            if (chVar2 == null) {
                break;
            } else {
                chVar3 = chVar2;
            }
        }
        this.b = chVar3;
        int i3 = this.f;
        zl zlVar = i3 == 0 ? chVar3.d : i3 == 1 ? chVar3.e : null;
        ArrayList<yf1> arrayList = this.k;
        while (true) {
            arrayList.add(zlVar);
            int i4 = this.f;
            if (i4 == 0) {
                vg vgVar5 = chVar3.M;
                vgVar2 = vgVar5.f;
                if (vgVar2 == null || vgVar2.f != vgVar5) {
                    chVar3 = null;
                } else {
                    chVar3 = vgVar2.d;
                }
            } else {
                if (i4 == 1) {
                    vg vgVar6 = chVar3.N;
                    vgVar2 = vgVar6.f;
                    if (vgVar2 != null && vgVar2.f == vgVar6) {
                        chVar3 = vgVar2.d;
                    }
                } else {
                    chVar3.getClass();
                }
                chVar3 = null;
            }
            if (chVar3 == null) {
                break;
            }
            int i5 = this.f;
            zlVar = i5 == 0 ? chVar3.d : i5 == 1 ? chVar3.e : null;
        }
        for (yf1 yf1Var : arrayList) {
            int i6 = this.f;
            if (i6 == 0) {
                yf1Var.b.b = this;
            } else if (i6 == 1) {
                yf1Var.b.c = this;
            }
        }
        if (this.f == 0 && this.b.W.x0 && arrayList.size() > 1) {
            this.b = ((yf1) arrayList.get(arrayList.size() - 1)).b;
        }
        int i7 = this.f;
        ch chVar4 = this.b;
        this.l = i7 == 0 ? chVar4.l0 : chVar4.m0;
    }

    /* JADX WARN: Code duplicated, block: B:299:0x00e8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:64:0x00da  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:91:0x014c  */
    @Override // defpackage.zl
    public final void a() {
        int i;
        int i2;
        boolean z;
        float f;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f3;
        dm dmVar = this.h;
        if (dmVar.j) {
            dm dmVar2 = this.i;
            if (dmVar2.j) {
                dh dhVar = this.b.W;
                boolean z2 = fb$1.m(dhVar) ? dhVar.x0 : false;
                int i15 = dmVar2.g - dmVar.g;
                ArrayList arrayList = this.k;
                int size = arrayList.size();
                int i16 = 0;
                while (true) {
                    i = -1;
                    i2 = 8;
                    if (i16 >= size) {
                        i16 = -1;
                        break;
                    } else if (((yf1) arrayList.get(i16)).b.j0 != 8) {
                        break;
                    } else {
                        i16++;
                    }
                }
                int i17 = size - 1;
                for (int i18 = i17; i18 >= 0; i18--) {
                    if (((yf1) arrayList.get(i18)).b.j0 != 8) {
                        i = i18;
                        break;
                    }
                }
                int i19 = 0;
                while (true) {
                    if (i19 >= 2) {
                        z = z2;
                        f = 0.0f;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        break;
                    }
                    f = 0.0f;
                    int i20 = 0;
                    i5 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    while (i20 < size) {
                        yf1 yf1Var = (yf1) arrayList.get(i20);
                        ch chVar = yf1Var.b;
                        boolean z3 = z2;
                        if (chVar.j0 == i2) {
                            i13 = i19;
                        } else {
                            i22++;
                            if (i20 > 0 && i20 >= i16) {
                                i5 += yf1Var.h.f;
                            }
                            ko koVar = yf1Var.e;
                            int i23 = koVar.g;
                            i13 = i19;
                            boolean z4 = yf1Var.d != 3;
                            if (z4) {
                                int i24 = this.f;
                                if (i24 == 0 && !chVar.d.e.j) {
                                    return;
                                }
                                if (i24 == 1 && !chVar.e.e.j) {
                                    return;
                                }
                            } else {
                                if (yf1Var.a == 1 && i13 == 0) {
                                    i14 = koVar.m;
                                    i21++;
                                } else {
                                    if (koVar.j) {
                                        i14 = i23;
                                    }
                                    if (z4) {
                                        i5 += i14;
                                    } else {
                                        i21++;
                                        f3 = chVar.n0[this.f];
                                        if (f3 >= 0.0f) {
                                            f += f3;
                                        }
                                    }
                                    if (i20 >= i17 && i20 < i) {
                                        i5 += -yf1Var.i.f;
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                    i21++;
                                    f3 = chVar.n0[this.f];
                                    if (f3 >= 0.0f) {
                                        f += f3;
                                    }
                                } else {
                                    i5 += i14;
                                }
                                if (i20 >= i17) {
                                }
                            }
                            i14 = i23;
                            if (z4) {
                                i21++;
                                f3 = chVar.n0[this.f];
                                if (f3 >= 0.0f) {
                                    f += f3;
                                }
                            } else {
                                i5 += i14;
                            }
                            if (i20 >= i17) {
                            }
                        }
                        i20++;
                        z2 = z3;
                        i19 = i13;
                        i2 = 8;
                    }
                    z = z2;
                    int i25 = i19;
                    if (i5 < i15 || i21 == 0) {
                        i3 = i21;
                        i4 = i22;
                        break;
                    } else {
                        i19 = i25 + 1;
                        z2 = z;
                        i2 = 8;
                    }
                }
                int i26 = dmVar.g;
                if (z) {
                    i26 = dmVar2.g;
                }
                float f4 = 0.5f;
                if (i5 > i15) {
                    int i27 = (int) (((i5 - i15) / 2.0f) + 0.5f);
                    i26 = z ? i26 + i27 : i26 - i27;
                }
                if (i3 > 0) {
                    float f5 = i15 - i5;
                    int i28 = (int) ((f5 / i3) + 0.5f);
                    int i29 = 0;
                    int i30 = 0;
                    while (i29 < size) {
                        float f6 = f4;
                        yf1 yf1Var2 = (yf1) arrayList.get(i29);
                        int i31 = i26;
                        ch chVar2 = yf1Var2.b;
                        int i32 = i3;
                        float f7 = f5;
                        if (chVar2.j0 != 8 && yf1Var2.d == 3) {
                            ko koVar2 = yf1Var2.e;
                            if (koVar2.j) {
                                i10 = i28;
                            } else {
                                if (f > 0.0f) {
                                    i9 = (int) (((chVar2.n0[this.f] * f7) / f) + f6);
                                    i10 = i28;
                                } else {
                                    i9 = i28;
                                    i10 = i9;
                                }
                                if (this.f == 0) {
                                    i11 = chVar2.w;
                                    i12 = chVar2.v;
                                } else {
                                    i11 = chVar2.z;
                                    i12 = chVar2.y;
                                }
                                int iMax = Math.max(i12, yf1Var2.a == 1 ? Math.min(i9, koVar2.m) : i9);
                                if (i11 > 0) {
                                    iMax = Math.min(i11, iMax);
                                }
                                if (iMax != i9) {
                                    i30++;
                                    i9 = iMax;
                                }
                                koVar2.d(i9);
                            }
                        } else {
                            i10 = i28;
                        }
                        i29++;
                        i26 = i31;
                        f4 = f6;
                        i3 = i32;
                        f5 = f7;
                        i28 = i10;
                    }
                    i6 = i26;
                    f2 = f4;
                    int i33 = i3;
                    if (i30 > 0) {
                        i3 = i33 - i30;
                        i5 = 0;
                        for (int i34 = 0; i34 < size; i34++) {
                            yf1 yf1Var3 = (yf1) arrayList.get(i34);
                            if (yf1Var3.b.j0 != 8) {
                                if (i34 > 0 && i34 >= i16) {
                                    i5 += yf1Var3.h.f;
                                }
                                i5 += yf1Var3.e.g;
                                if (i34 < i17 && i34 < i) {
                                    i5 += -yf1Var3.i.f;
                                }
                            }
                        }
                    } else {
                        i3 = i33;
                    }
                    i8 = 2;
                    if (this.l == 2 && i30 == 0) {
                        i7 = 0;
                        this.l = 0;
                    } else {
                        i7 = 0;
                    }
                } else {
                    i6 = i26;
                    f2 = 0.5f;
                    i7 = 0;
                    i8 = 2;
                }
                if (i5 > i15) {
                    this.l = i8;
                }
                if (i4 > 0 && i3 == 0 && i16 == i) {
                    this.l = i8;
                }
                int i35 = this.l;
                if (i35 == 1) {
                    int i36 = i4 > 1 ? (i15 - i5) / (i4 - 1) : i4 == 1 ? (i15 - i5) / 2 : i7;
                    if (i3 > 0) {
                        i36 = i7;
                    }
                    int i37 = i6;
                    for (int i38 = i7; i38 < size; i38++) {
                        yf1 yf1Var4 = (yf1) arrayList.get(z ? size - (i38 + 1) : i38);
                        int i39 = yf1Var4.b.j0;
                        dm dmVar3 = yf1Var4.i;
                        dm dmVar4 = yf1Var4.h;
                        if (i39 == 8) {
                            dmVar4.d(i37);
                            dmVar3.d(i37);
                        } else {
                            if (i38 > 0) {
                                i37 = z ? i37 - i36 : i37 + i36;
                            }
                            if (i38 > 0 && i38 >= i16) {
                                int i40 = dmVar4.f;
                                i37 = z ? i37 - i40 : i37 + i40;
                            }
                            if (z) {
                                dmVar3.d(i37);
                            } else {
                                dmVar4.d(i37);
                            }
                            ko koVar3 = yf1Var4.e;
                            int i41 = koVar3.g;
                            if (yf1Var4.d == 3 && yf1Var4.a == 1) {
                                i41 = koVar3.m;
                            }
                            i37 = z ? i37 - i41 : i37 + i41;
                            if (z) {
                                dmVar4.d(i37);
                            } else {
                                dmVar3.d(i37);
                            }
                            yf1Var4.g = true;
                            if (i38 < i17 && i38 < i) {
                                int i42 = -dmVar3.f;
                                i37 = z ? i37 - i42 : i37 + i42;
                            }
                        }
                    }
                    return;
                }
                if (i35 == 0) {
                    int i43 = (i15 - i5) / (i4 + 1);
                    if (i3 > 0) {
                        i43 = i7;
                    }
                    int i44 = i6;
                    for (int i45 = i7; i45 < size; i45++) {
                        yf1 yf1Var5 = (yf1) arrayList.get(z ? size - (i45 + 1) : i45);
                        int i46 = yf1Var5.b.j0;
                        dm dmVar5 = yf1Var5.i;
                        dm dmVar6 = yf1Var5.h;
                        if (i46 == 8) {
                            dmVar6.d(i44);
                            dmVar5.d(i44);
                        } else {
                            int i47 = z ? i44 - i43 : i44 + i43;
                            if (i45 > 0 && i45 >= i16) {
                                int i48 = dmVar6.f;
                                i47 = z ? i47 - i48 : i47 + i48;
                            }
                            if (z) {
                                dmVar5.d(i47);
                            } else {
                                dmVar6.d(i47);
                            }
                            ko koVar4 = yf1Var5.e;
                            int iMin = koVar4.g;
                            if (yf1Var5.d == 3 && yf1Var5.a == 1) {
                                iMin = Math.min(iMin, koVar4.m);
                            }
                            i44 = z ? i47 - iMin : i47 + iMin;
                            if (z) {
                                dmVar6.d(i44);
                            } else {
                                dmVar5.d(i44);
                            }
                            if (i45 < i17 && i45 < i) {
                                int i49 = -dmVar5.f;
                                i44 = z ? i44 - i49 : i44 + i49;
                            }
                        }
                    }
                    return;
                }
                if (i35 == 2) {
                    int i50 = this.f;
                    ch chVar3 = this.b;
                    float f8 = i50 == 0 ? chVar3.g0 : chVar3.h0;
                    if (z) {
                        f8 = 1.0f - f8;
                    }
                    int i51 = (int) (((i15 - i5) * f8) + f2);
                    if (i51 < 0 || i3 > 0) {
                        i51 = i7;
                    }
                    int i52 = z ? i6 - i51 : i6 + i51;
                    for (int i53 = i7; i53 < size; i53++) {
                        yf1 yf1Var6 = (yf1) arrayList.get(z ? size - (i53 + 1) : i53);
                        int i54 = yf1Var6.b.j0;
                        dm dmVar7 = yf1Var6.i;
                        dm dmVar8 = yf1Var6.h;
                        if (i54 == 8) {
                            dmVar8.d(i52);
                            dmVar7.d(i52);
                        } else {
                            if (i53 > 0 && i53 >= i16) {
                                int i55 = dmVar8.f;
                                i52 = z ? i52 - i55 : i52 + i55;
                            }
                            if (z) {
                                dmVar7.d(i52);
                            } else {
                                dmVar8.d(i52);
                            }
                            ko koVar5 = yf1Var6.e;
                            int i56 = koVar5.g;
                            if (yf1Var6.d == 3 && yf1Var6.a == 1) {
                                i56 = koVar5.m;
                            }
                            i52 = z ? i52 - i56 : i52 + i56;
                            if (z) {
                                dmVar8.d(i52);
                            } else {
                                dmVar7.d(i52);
                            }
                            if (i53 < i17 && i53 < i) {
                                int i57 = -dmVar7.f;
                                i52 = z ? i52 - i57 : i52 + i57;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009f A[PHI: r0 r1
      0x009f: PHI (r0v9 int) = (r0v6 int), (r0v13 int) binds: [B:29:0x009d, B:19:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x009f: PHI (r1v10 dm) = (r1v7 dm), (r1v14 dm) binds: [B:29:0x009d, B:19:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.yf1
    public final void d() {
        dm dmVarI;
        int iD;
        ArrayList arrayList = this.k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((yf1) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        ch chVar = ((yf1) arrayList.get(0)).b;
        ch chVar2 = ((yf1) arrayList.get(size - 1)).b;
        int i = this.f;
        dm dmVar = this.i;
        dm dmVar2 = this.h;
        if (i == 0) {
            vg vgVar = chVar.K;
            vg vgVar2 = chVar2.M;
            dm dmVarI2 = yf1.i(vgVar, 0);
            int iD2 = vgVar.d();
            ch chVarM = m();
            if (chVarM != null) {
                iD2 = chVarM.K.d();
            }
            if (dmVarI2 != null) {
                yf1.b(dmVar2, dmVarI2, iD2);
            }
            dmVarI = yf1.i(vgVar2, 0);
            iD = vgVar2.d();
            ch chVarN = n();
            if (chVarN != null) {
                iD = chVarN.M.d();
            }
            if (dmVarI != null) {
                yf1.b(dmVar, dmVarI, -iD);
            }
        } else {
            vg vgVar3 = chVar.L;
            vg vgVar4 = chVar2.N;
            dm dmVarI3 = yf1.i(vgVar3, 1);
            int iD3 = vgVar3.d();
            ch chVarM2 = m();
            if (chVarM2 != null) {
                iD3 = chVarM2.L.d();
            }
            if (dmVarI3 != null) {
                yf1.b(dmVar2, dmVarI3, iD3);
            }
            dmVarI = yf1.i(vgVar4, 1);
            iD = vgVar4.d();
            ch chVarN2 = n();
            if (chVarN2 != null) {
                iD = chVarN2.N.d();
            }
            if (dmVarI != null) {
                yf1.b(dmVar, dmVarI, -iD);
            }
        }
        dmVar2.a = this;
        dmVar.a = this;
    }

    @Override // defpackage.yf1
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((yf1) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // defpackage.yf1
    public final void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((yf1) it.next()).f();
        }
    }

    @Override // defpackage.yf1
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            yf1 yf1Var = (yf1) arrayList.get(i);
            j = ((long) yf1Var.i.f) + yf1Var.j() + j + ((long) yf1Var.h.f);
        }
        return j;
    }

    @Override // defpackage.yf1
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((yf1) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final ch m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            ch chVar = ((yf1) arrayList.get(i)).b;
            if (chVar.j0 != 8) {
                return chVar;
            }
            i++;
        }
    }

    public final ch n() {
        ch chVar;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            chVar = ((yf1) arrayList.get(size)).b;
        } while (chVar.j0 == 8);
        return chVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        for (yf1 yf1Var : this.k) {
            sb.append("<");
            sb.append(yf1Var);
            sb.append("> ");
        }
        return sb.toString();
    }
}
