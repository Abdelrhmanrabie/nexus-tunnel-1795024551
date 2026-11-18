package defpackage;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.savedstate.Recreator;
import androidx.savedstate.a;
import java.util.Map;
import jx0.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sx0 {
    public final tx0 a;
    public final a b = new a();
    public boolean c;

    public sx0(tx0 tx0Var) {
        this.a = tx0Var;
    }

    public final void a() {
        tx0 tx0Var = this.a;
        e lifecycle = tx0Var.getLifecycle();
        if (lifecycle.b() != e.b.INITIALIZED) {
            d.AnonymousClass0.m("Restarter must be created only during owner's initialization stage");
            return;
        }
        lifecycle.a(new Recreator(tx0Var));
        a aVar = this.b;
        aVar.getClass();
        if (aVar.b) {
            d.AnonymousClass0.m("SavedStateRegistry was already attached.");
            return;
        }
        lifecycle.a(new ef(1, aVar));
        aVar.b = true;
        this.c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.c) {
            a();
        }
        e lifecycle = this.a.getLifecycle();
        if (lifecycle.b().compareTo(e.b.STARTED) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
        }
        a aVar = this.b;
        if (!aVar.b) {
            d.AnonymousClass0.m("You must call performAttach() before calling performRestore(Bundle).");
        } else if (aVar.d) {
            d.AnonymousClass0.m("SavedStateRegistry was already restored.");
        } else {
            aVar.c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
            aVar.d = true;
        }
    }

    public final void c(Bundle bundle) {
        a aVar = this.b;
        aVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aVar.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        jx0 jx0Var = aVar.a;
        jx0Var.getClass();
        jx0.d dVar = jx0Var.new d();
        jx0Var.d.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
