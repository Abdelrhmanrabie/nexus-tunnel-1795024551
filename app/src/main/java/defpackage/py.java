package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class py extends ch {
    public float s0 = -1.0f;
    public int t0 = -1;
    public int u0 = -1;
    public vg v0 = this.L;
    public int w0 = 0;
    public boolean x0;

    public py() {
        this.T.clear();
        this.T.add(this.v0);
        int length = this.S.length;
        for (int i = 0; i < length; i++) {
            this.S[i] = this.v0;
        }
    }

    @Override // defpackage.ch
    public final void L(oe0 oe0Var, boolean z) {
        if (this.W == null) {
            return;
        }
        vg vgVar = this.v0;
        oe0Var.getClass();
        int iO = oe0.o(vgVar);
        if (this.w0 == 1) {
            this.b0 = iO;
            this.c0 = 0;
            G(this.W.i());
            J(0);
            return;
        }
        this.b0 = 0;
        this.c0 = iO;
        J(this.W.n());
        G(0);
    }

    public final void M(int i) {
        if (this.w0 == i) {
            return;
        }
        this.w0 = i;
        ArrayList arrayList = this.T;
        arrayList.clear();
        vg vgVar = this.w0 == 1 ? this.K : this.L;
        this.v0 = vgVar;
        arrayList.add(vgVar);
        vg[] vgVarArr = this.S;
        int length = vgVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            vgVarArr[i2] = this.v0;
        }
    }

    @Override // defpackage.ch
    public final void b(oe0 oe0Var, boolean z) {
        dh dhVar = this.W;
        if (dhVar == null) {
            return;
        }
        Object objG = dhVar.g(vg.a.b);
        Object objG2 = dhVar.g(vg.a.d);
        dh dhVar2 = this.W;
        boolean z2 = dhVar2 != null && dhVar2.V[0] == 2;
        if (this.w0 == 0) {
            objG = dhVar.g(vg.a.c);
            objG2 = dhVar.g(vg.a.f);
            dh dhVar3 = this.W;
            z2 = dhVar3 != null && dhVar3.V[1] == 2;
        }
        if (this.x0) {
            vg vgVar = this.v0;
            if (vgVar.c) {
                q11 q11VarL = oe0Var.l(vgVar);
                oe0Var.d(q11VarL, this.v0.c());
                if (this.t0 != -1) {
                    if (z2) {
                        oe0Var.f(oe0Var.l(objG2), q11VarL, 0, 5);
                    }
                } else if (this.u0 != -1 && z2) {
                    q11 q11VarL2 = oe0Var.l(objG2);
                    oe0Var.f(q11VarL, oe0Var.l(objG), 0, 5);
                    oe0Var.f(q11VarL2, q11VarL, 0, 5);
                }
                this.x0 = false;
                return;
            }
        }
        if (this.t0 != -1) {
            q11 q11VarL3 = oe0Var.l(this.v0);
            oe0Var.e(q11VarL3, oe0Var.l(objG), this.t0, 8);
            if (z2) {
                oe0Var.f(oe0Var.l(objG2), q11VarL3, 0, 5);
                return;
            }
            return;
        }
        if (this.u0 != -1) {
            q11 q11VarL4 = oe0Var.l(this.v0);
            q11 q11VarL5 = oe0Var.l(objG2);
            oe0Var.e(q11VarL4, q11VarL5, -this.u0, 8);
            if (z2) {
                oe0Var.f(q11VarL4, oe0Var.l(objG), 0, 5);
                oe0Var.f(q11VarL5, q11VarL4, 0, 5);
                return;
            }
            return;
        }
        if (this.s0 != -1.0f) {
            q11 q11VarL6 = oe0Var.l(this.v0);
            q11 q11VarL7 = oe0Var.l(objG2);
            float f = this.s0;
            e7 e7VarM = oe0Var.m();
            b7 b7Var = e7VarM.d;
            b7Var.k(q11VarL6, -1.0f);
            b7Var.k(q11VarL7, f);
            oe0Var.c(e7VarM);
        }
    }

    @Override // defpackage.ch
    public final boolean c() {
        return true;
    }

    @Override // defpackage.ch
    public final vg g(vg.a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return null;
                    }
                }
            }
            if (this.w0 == 0) {
                return this.v0;
            }
            return null;
        }
        if (this.w0 == 1) {
            return this.v0;
        }
        return null;
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
