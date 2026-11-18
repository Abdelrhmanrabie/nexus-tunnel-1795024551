package defpackage;

import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class or extends u01 {
    public final a91 c;
    public final vg0 d;
    public final List f;
    public final boolean g;
    public final String i;

    public or(a91 a91Var, vg0 vg0Var) {
        this(a91Var, vg0Var, null, false, 28);
    }

    public or(a91 a91Var, vg0 vg0Var, List list, boolean z, int i) {
        list = (i & 4) != 0 ? uq.b : list;
        z = (i & 8) != 0 ? false : z;
        this.c = a91Var;
        this.d = vg0Var;
        this.f = list;
        this.g = z;
        this.i = "???";
    }

    @Override // defpackage.fc0
    public final List K0() {
        return this.f;
    }

    @Override // defpackage.fc0
    public final a91 L0() {
        return this.c;
    }

    @Override // defpackage.fc0
    public final boolean M0() {
        return this.g;
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        return this;
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        return this;
    }

    @Override // defpackage.u01, defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return this;
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: S0 */
    public final u01 P0(boolean z) {
        return new or(this.c, this.d, this.f, z, 16);
    }

    @Override // defpackage.u01
    /* JADX INFO: renamed from: T0 */
    public final u01 R0(s4 s4Var) {
        return this;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return e4.f47a;
    }

    @Override // defpackage.fc0
    public final vg0 m() {
        return this.d;
    }

    @Override // defpackage.u01
    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        List list = this.f;
        if (list.isEmpty()) {
            string = AppConfig.CUSTOM;
        } else {
            StringBuilder sb2 = new StringBuilder();
            he.O0(list, sb2, ", ", "<", ">", -1, "...", null);
            string = sb2.toString();
        }
        sb.append(string);
        return sb.toString();
    }
}
