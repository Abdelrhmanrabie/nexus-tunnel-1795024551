package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h8 extends ch {
    public ch[] s0;
    public int t0;
    public int u0;
    public boolean v0;
    public int w0;
    public boolean x0;

    public final void M(int i, xf1 xf1Var, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.t0; i2++) {
            ch chVar = this.s0[i2];
            ArrayList arrayList2 = xf1Var.a;
            if (!arrayList2.contains(chVar)) {
                arrayList2.add(chVar);
            }
        }
        for (int i3 = 0; i3 < this.t0; i3++) {
            e4.a(this.s0[i3], i, arrayList, xf1Var);
        }
    }

    public final boolean N() {
        int i;
        vg vgVarG;
        vg vgVarG2;
        vg vgVarG3;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.t0;
            if (i4 >= i) {
                break;
            }
            ch chVar = this.s0[i4];
            if ((this.v0 || chVar.c()) && ((((i2 = this.u0) == 0 || i2 == 1) && !chVar.x()) || (((i3 = this.u0) == 2 || i3 == 3) && !chVar.y()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.t0; i5++) {
            ch chVar2 = this.s0[i5];
            if (this.v0 || chVar2.c()) {
                vg.a aVar = vg.a.f;
                vg.a aVar2 = vg.a.c;
                vg.a aVar3 = vg.a.d;
                vg.a aVar4 = vg.a.b;
                if (!z2) {
                    int i6 = this.u0;
                    if (i6 == 0) {
                        vgVarG3 = chVar2.g(aVar4);
                    } else if (i6 == 1) {
                        vgVarG3 = chVar2.g(aVar3);
                    } else if (i6 == 2) {
                        vgVarG3 = chVar2.g(aVar2);
                    } else {
                        if (i6 == 3) {
                            vgVarG3 = chVar2.g(aVar);
                        }
                        z2 = true;
                    }
                    iMax = vgVarG3.c();
                    z2 = true;
                }
                int i7 = this.u0;
                if (i7 == 0) {
                    vgVarG2 = chVar2.g(aVar4);
                } else {
                    if (i7 == 1) {
                        vgVarG = chVar2.g(aVar3);
                    } else if (i7 == 2) {
                        vgVarG2 = chVar2.g(aVar2);
                    } else if (i7 == 3) {
                        vgVarG = chVar2.g(aVar);
                    }
                    iMax = Math.max(iMax, vgVarG.c());
                }
                iMax = Math.min(iMax, vgVarG2.c());
            }
        }
        int i8 = iMax + this.w0;
        int i9 = this.u0;
        if (i9 == 0 || i9 == 1) {
            E(i8, i8);
        } else {
            F(i8, i8);
        }
        this.x0 = true;
        return true;
    }

    public final int O() {
        int i = this.u0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // defpackage.ch
    public final void b(oe0 oe0Var, boolean z) {
        boolean z2;
        q11 q11Var;
        vg vgVar;
        int i;
        int i2;
        q11 q11Var2;
        int i3;
        vg[] vgVarArr = this.S;
        vg vgVar2 = this.K;
        vgVarArr[0] = vgVar2;
        vg vgVar3 = this.L;
        int i4 = 2;
        vgVarArr[2] = vgVar3;
        vg vgVar4 = this.M;
        vgVarArr[1] = vgVar4;
        vg vgVar5 = this.N;
        vgVarArr[3] = vgVar5;
        for (vg vgVar6 : vgVarArr) {
            vgVar6.i = oe0Var.l(vgVar6);
        }
        int i5 = this.u0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        vg vgVar7 = vgVarArr[i5];
        if (!this.x0) {
            N();
        }
        if (this.x0) {
            this.x0 = false;
            int i6 = this.u0;
            if (i6 == 0 || i6 == 1) {
                oe0Var.d(vgVar2.i, this.b0);
                q11Var2 = vgVar4.i;
                i3 = this.b0;
            } else {
                if (i6 != 2 && i6 != 3) {
                    return;
                }
                oe0Var.d(vgVar3.i, this.c0);
                q11Var2 = vgVar5.i;
                i3 = this.c0;
            }
            oe0Var.d(q11Var2, i3);
            return;
        }
        int i7 = 0;
        while (true) {
            if (i7 >= this.t0) {
                z2 = false;
                break;
            }
            ch chVar = this.s0[i7];
            if ((this.v0 || chVar.c()) && ((((i2 = this.u0) == 0 || i2 == 1) && chVar.V[0] == 3 && chVar.K.f != null && chVar.M.f != null) || ((i2 == 2 || i2 == 3) && chVar.V[1] == 3 && chVar.L.f != null && chVar.N.f != null))) {
                z2 = true;
                break;
            }
            i7++;
        }
        boolean z3 = vgVar2.e() || vgVar4.e();
        boolean z4 = vgVar3.e() || vgVar5.e();
        int i8 = (z2 || !(((i = this.u0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i9 = 0;
        while (i9 < this.t0) {
            ch chVar2 = this.s0[i9];
            if (this.v0 || chVar2.c()) {
                q11 q11VarL = oe0Var.l(chVar2.S[this.u0]);
                int i10 = this.u0;
                vg vgVar8 = chVar2.S[i10];
                vgVar8.i = q11VarL;
                vg vgVar9 = vgVar8.f;
                int i11 = (vgVar9 == null || vgVar9.d != this) ? 0 : vgVar8.g;
                if (i10 == 0 || i10 == i4) {
                    q11 q11Var3 = vgVar7.i;
                    int i12 = this.w0 - i11;
                    e7 e7VarM = oe0Var.m();
                    q11 q11VarN = oe0Var.n();
                    q11VarN.f = 0;
                    e7VarM.d(q11Var3, q11VarL, q11VarN, i12);
                    oe0Var.c(e7VarM);
                } else {
                    q11 q11Var4 = vgVar7.i;
                    int i13 = this.w0 + i11;
                    e7 e7VarM2 = oe0Var.m();
                    q11 q11VarN2 = oe0Var.n();
                    q11VarN2.f = 0;
                    e7VarM2.c(q11Var4, q11VarL, q11VarN2, i13);
                    oe0Var.c(e7VarM2);
                }
                oe0Var.e(vgVar7.i, q11VarL, this.w0 + i11, i8);
            }
            i9++;
            i4 = 2;
        }
        int i14 = this.u0;
        if (i14 == 0) {
            oe0Var.e(vgVar4.i, vgVar2.i, 0, 8);
            oe0Var.e(vgVar2.i, this.W.M.i, 0, 4);
            q11Var = vgVar2.i;
            vgVar = this.W.K;
        } else if (i14 == 1) {
            oe0Var.e(vgVar2.i, vgVar4.i, 0, 8);
            oe0Var.e(vgVar2.i, this.W.K.i, 0, 4);
            q11Var = vgVar2.i;
            vgVar = this.W.M;
        } else if (i14 == 2) {
            oe0Var.e(vgVar5.i, vgVar3.i, 0, 8);
            oe0Var.e(vgVar3.i, this.W.N.i, 0, 4);
            q11Var = vgVar3.i;
            vgVar = this.W.L;
        } else {
            if (i14 != 3) {
                return;
            }
            oe0Var.e(vgVar3.i, vgVar5.i, 0, 8);
            oe0Var.e(vgVar3.i, this.W.L.i, 0, 4);
            q11Var = vgVar3.i;
            vgVar = this.W.N;
        }
        oe0Var.e(q11Var, vgVar.i, 0, 0);
    }

    @Override // defpackage.ch
    public final boolean c() {
        return true;
    }

    @Override // defpackage.ch
    public final String toString() {
        String strM = fb$1.m(new StringBuilder("[Barrier] "), this.k0, " {");
        for (int i = 0; i < this.t0; i++) {
            ch chVar = this.s0[i];
            if (i > 0) {
                strM = ak.j(strM, ", ");
            }
            StringBuilder sbD = e.d(strM);
            sbD.append(chVar.k0);
            strM = sbD.toString();
        }
        return ak.j(strM, "}");
    }

    @Override // defpackage.ch
    public final boolean x() {
        return this.x0;
    }

    @Override // defpackage.ch
    public final boolean y() {
        return this.x0;
    }
}
