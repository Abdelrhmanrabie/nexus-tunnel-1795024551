package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class de0 extends fc0 {
    public final ff0 c;
    public final oc0 d;
    public final ff0.h f;

    /* JADX WARN: Multi-variable type inference failed */
    public de0(ff0 ff0Var, lw lwVar) {
        this.c = ff0Var;
        this.d = (oc0) lwVar;
        ff0Var.getClass();
        this.f = new ff0.h(ff0Var, lwVar);
    }

    @Override // defpackage.fc0
    public final List K0() {
        return P0().K0();
    }

    @Override // defpackage.fc0
    public final a91 L0() {
        return P0().L0();
    }

    @Override // defpackage.fc0
    public final boolean M0() {
        return P0().M0();
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        return new de0(this.c, new qn(2, lc0_a, this));
    }

    @Override // defpackage.fc0
    public final cc1 O0() {
        fc0 fc0VarP0 = P0();
        while (fc0VarP0 instanceof de0) {
            fc0VarP0 = ((de0) fc0VarP0).P0();
        }
        return (cc1) fc0VarP0;
    }

    public final fc0 P0() {
        return (fc0) this.f.invoke();
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return P0().getAnnotations();
    }

    @Override // defpackage.fc0
    public final vg0 m() {
        return P0().m();
    }

    public final String toString() {
        ff0.h hVar = this.f;
        return (hVar.d == ff0.l.b || hVar.d == ff0.l.c) ? "<Not computed yet>" : P0().toString();
    }
}
