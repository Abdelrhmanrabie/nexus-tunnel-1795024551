package defpackage;

import android.os.Bundle;
import androidx.lifecycle.n;
import androidx.savedstate.a;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qx0 implements a.b {
    public final a a;
    public boolean b;
    public Bundle c;
    public final v41 d;

    public qx0(a aVar, ce1 ce1Var) {
        this.a = aVar;
        this.d = new v41(new ca0(16, ce1Var));
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((rx0) this.d.getValue()).a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((n) entry.getValue()).e.a();
            if (!bundleA.equals(Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.b = false;
        return bundle;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        Bundle bundleA = this.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.c = bundle;
        this.b = true;
    }
}
