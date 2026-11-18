package androidx.lifecycle;

import defpackage.be1;
import defpackage.cj;
import defpackage.h90;
import defpackage.rc0;
import defpackage.sc;
import defpackage.zd1;
import renz.javacodez.v2ray.ui.SettingsActivity$special$$inlined$viewModels$default$1;
import renz.javacodez.v2ray.ui.SettingsActivity$special$$inlined$viewModels$default$2;
import renz.javacodez.v2ray.ui.SettingsActivity$special$$inlined$viewModels$default$3;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class r<VM extends zd1> implements rc0 {
    public final h90 b;
    public final SettingsActivity$special$$inlined$viewModels$default$2 c;
    public final SettingsActivity$special$$inlined$viewModels$default$1 d;
    public final SettingsActivity$special$$inlined$viewModels$default$3 f;
    public zd1 g;

    public r(h90 h90Var, SettingsActivity$special$$inlined$viewModels$default$2 settingsActivity$special$$inlined$viewModels$default$2, SettingsActivity$special$$inlined$viewModels$default$1 settingsActivity$special$$inlined$viewModels$default$1, SettingsActivity$special$$inlined$viewModels$default$3 settingsActivity$special$$inlined$viewModels$default$3) {
        this.b = h90Var;
        this.c = settingsActivity$special$$inlined$viewModels$default$2;
        this.d = settingsActivity$special$$inlined$viewModels$default$1;
        this.f = settingsActivity$special$$inlined$viewModels$default$3;
    }

    @Override // defpackage.rc0
    public final Object getValue() {
        zd1 zd1Var = this.g;
        if (zd1Var != null) {
            return zd1Var;
        }
        zd1 zd1VarA = new t((be1) this.c.invoke(), (t.b) this.d.invoke(), (cj) this.f.invoke()).a(((sc) this.b).d());
        this.g = zd1VarA;
        return zd1VarA;
    }
}
