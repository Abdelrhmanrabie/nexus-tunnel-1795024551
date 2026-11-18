package defpackage;

import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jb extends u01 implements rb {
    public final ca1 c;
    public final nb d;
    public final boolean f;
    public final s4 g;

    public jb(ca1 ca1Var, nb nbVar, boolean z, s4 s4Var) {
        this.c = ca1Var;
        this.d = nbVar;
        this.f = z;
        this.g = s4Var;
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
        return this.f;
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        return new jb(this.c.a(lc0_a), this.d, this.f, this.g);
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 P0(boolean z) {
        if (z == this.f) {
            return this;
        }
        return new jb(this.c, this.d, z, this.g);
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        return new jb(this.c.a(lc0_a), this.d, this.f, this.g);
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new jb(this.c, this.d, this.f, t4Var);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        if (z == this.f) {
            return this;
        }
        return new jb(this.c, this.d, z, this.g);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return new jb(this.c, this.d, this.f, s4Var);
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return this.g;
    }

    @Override // defpackage.fc0
    public final vg0 m() {
        return pr.c("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    }

    @Override // defpackage.u01
    public final String toString() {
        StringBuilder sb = new StringBuilder("Captured(");
        sb.append(this.c);
        sb.append(')');
        sb.append(this.f ? "?" : AppConfig.CUSTOM);
        return sb.toString();
    }
}
