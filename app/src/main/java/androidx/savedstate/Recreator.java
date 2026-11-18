package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import defpackage.ak;
import defpackage.d;
import defpackage.he0;
import defpackage.tx0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements h {
    public final tx0 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a implements androidx.savedstate.a.b {
        public final LinkedHashSet a = new LinkedHashSet();

        public a(androidx.savedstate.a aVar) {
            aVar.c("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.b
        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.a));
            return bundle;
        }
    }

    public Recreator(tx0 tx0Var) {
        this.b = tx0Var;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        if (aVar != e.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        he0Var.getLifecycle().c(this);
        tx0 tx0Var = this.b;
        Bundle bundleA = tx0Var.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            d.AnonymousClass0.m("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.a.InterfaceC0027a.class);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        ((androidx.savedstate.a.InterfaceC0027a) declaredConstructor.newInstance(null)).a(tx0Var);
                    } catch (Exception e) {
                        throw new RuntimeException(ak.m("Failed to instantiate ", str), e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(ak.AnonymousClass0.m("Class ", clsAsSubclass.getSimpleName(), " must have default constructor in order to be automatically recreated"), e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(defpackage.e.n("Class ", str, " wasn't found"), e3);
            }
        }
    }
}
