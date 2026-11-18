package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tk0 extends u01 implements rb {
    public final ib c;
    public final vk0 d;
    public final cc1 f;
    public final s4 g;
    public final boolean i;
    public final boolean j;

    public /* synthetic */ tk0(ib ibVar, vk0 vk0Var, cc1 cc1Var, s4 s4Var, boolean z, int i) {
        this(ibVar, vk0Var, cc1Var, (i & 8) != 0 ? e4.f47a : s4Var, (i & 16) != 0 ? false : z, false);
    }

    public tk0(ib ibVar, vk0 vk0Var, cc1 cc1Var, s4 s4Var, boolean z, boolean z2) {
        this.c = ibVar;
        this.d = vk0Var;
        this.f = cc1Var;
        this.g = s4Var;
        this.i = z;
        this.j = z2;
    }

    @Override // defpackage.fc0
    public final List K0() {
        return uq.b;
    }

    @Override // defpackage.fc0
    public final a91 L0() {
        return this.d;
    }

    @Override // defpackage.fc0
    public final boolean M0() {
        return this.i;
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 P0(boolean z) {
        return new tk0(this.c, this.d, this.f, this.g, z, 32);
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new tk0(this.c, this.d, this.f, t4Var, this.i, 32);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return new tk0(this.c, this.d, this.f, this.g, z, 32);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return new tk0(this.c, this.d, this.f, s4Var, this.i, 32);
    }

    @Override // defpackage.cc1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public final tk0 Q0(lc0$a lc0_a) {
        cc1 cc1Var;
        vk0 vk0Var = this.d;
        ca1 ca1VarA = vk0Var.a.a(lc0_a);
        qn qnVar = vk0Var.b == null ? null : new qn(15, vk0Var, lc0_a);
        vk0 vk0Var2 = vk0Var.c;
        if (vk0Var2 == null) {
            vk0Var2 = vk0Var;
        }
        vk0 vk0Var3 = new vk0(ca1VarA, qnVar, vk0Var2, vk0Var.d);
        cc1 cc1Var2 = this.f;
        if (cc1Var2 == null) {
            cc1Var = null;
        } else {
            lc0_a.getClass();
            cc1Var = cc1Var2;
        }
        return new tk0(this.c, vk0Var3, cc1Var, this.g, this.i, 32);
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return this.g;
    }

    @Override // defpackage.fc0
    public final vg0 m() {
        return pr.c("No member resolution should be done on captured type!", true);
    }
}
