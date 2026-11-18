package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class zt extends cc1 implements jc0 {
    public final u01 c;
    public final u01 d;

    public zt(u01 u01Var, u01 u01Var2) {
        this.c = u01Var;
        this.d = u01Var2;
    }

    @Override // defpackage.fc0
    public final List K0() {
        return S0().K0();
    }

    @Override // defpackage.fc0
    public final a91 L0() {
        return S0().L0();
    }

    @Override // defpackage.fc0
    public boolean M0() {
        return S0().M0();
    }

    public abstract u01 S0();

    public abstract String T0(nm nmVar, nm nmVar2);

    @Override // defpackage.w3
    public s4 getAnnotations() {
        return S0().getAnnotations();
    }

    @Override // defpackage.fc0
    public vg0 m() {
        return S0().m();
    }

    public String toString() {
        return mm.b.s(this);
    }
}
