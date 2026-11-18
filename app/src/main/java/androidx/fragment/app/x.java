package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import defpackage.be1;
import defpackage.ce1;
import defpackage.cj;
import defpackage.sx0;
import defpackage.tx0;
import defpackage.xi0;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class x implements androidx.lifecycle.c, tx0, ce1 {
    public final Fragment b;
    public final be1 c;
    public androidx.lifecycle.i f = null;
    public sx0 g = null;

    public x(Fragment fragment, be1 be1Var) {
        this.b = fragment;
        this.c = be1Var;
    }

    public final void b() {
        if (this.f == null) {
            this.f = new androidx.lifecycle.i(this);
            sx0 sx0Var = new sx0(this);
            this.g = sx0Var;
            sx0Var.a();
            androidx.lifecycle.o.b(this);
        }
    }

    @Override // androidx.lifecycle.c
    public final cj getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.b;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        xi0 xi0Var = new xi0();
        LinkedHashMap linkedHashMap = xi0Var.a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.s.a, application);
        }
        linkedHashMap.put(androidx.lifecycle.o.a, this);
        linkedHashMap.put(androidx.lifecycle.o.b, this);
        if (fragment.getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.o.c, fragment.getArguments());
        }
        return xi0Var;
    }

    @Override // androidx.lifecycle.c
    public final androidx.lifecycle.t.b getDefaultViewModelProviderFactory() {
        throw null;
    }

    @Override // defpackage.he0
    public final androidx.lifecycle.e getLifecycle() {
        b();
        return this.f;
    }

    @Override // defpackage.tx0
    public final androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.g.b;
    }

    @Override // defpackage.ce1
    public final be1 getViewModelStore() {
        b();
        return this.c;
    }
}
