package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v01 extends u01 {
    public final a91 c;
    public final List d;
    public final boolean f;
    public final vg0 g;
    public final nw i;

    public v01(a91 a91Var, List list, boolean z, vg0 vg0Var, nw nwVar) {
        this.c = a91Var;
        this.d = list;
        this.f = z;
        this.g = vg0Var;
        this.i = nwVar;
        if (vg0Var instanceof pr.c) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + vg0Var + '\n' + a91Var);
        }
    }

    @Override // defpackage.fc0
    public final List K0() {
        return this.d;
    }

    @Override // defpackage.fc0
    public final a91 L0() {
        return this.c;
    }

    @Override // defpackage.fc0
    public final boolean M0() {
        return this.f;
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        u01 u01Var = (u01) this.i.invoke(lc0_a);
        return u01Var == null ? this : u01Var;
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        u01 u01Var = (u01) this.i.invoke(lc0_a);
        return u01Var == null ? this : u01Var;
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        if (z == this.f) {
            return this;
        }
        return z ? new dm0(this, 0) : new dm0(this, 1);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return s4Var.isEmpty() ? this : new z3(this, s4Var);
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return e4.f47a;
    }

    @Override // defpackage.fc0
    public final vg0 m() {
        return this.g;
    }
}
