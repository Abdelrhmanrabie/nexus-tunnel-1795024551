package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ul extends tl {
    public final u01 c;

    public ul(u01 u01Var) {
        this.c = u01Var;
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return t4Var != getAnnotations() ? new z3(this, t4Var) : this;
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return z == M0() ? this : this.c.P0(z).R0(getAnnotations());
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return s4Var != getAnnotations() ? new z3(this, s4Var) : this;
    }

    @Override // defpackage.tl
    public final u01 U0() {
        return this.c;
    }
}
