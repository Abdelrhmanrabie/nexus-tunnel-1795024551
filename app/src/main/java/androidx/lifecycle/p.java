package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import defpackage.r3;
import defpackage.tx0;
import defpackage.ux0;
import defpackage.xi0;
import defpackage.zd1;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p extends t.d implements t.b {
    public final Application a;
    public final t.a b;
    public final Bundle c;
    public final e d;
    public final androidx.savedstate.a e;

    public p(Application application, tx0 tx0Var, Bundle bundle) {
        t.a aVar;
        this.e = tx0Var.getSavedStateRegistry();
        this.d = tx0Var.getLifecycle();
        this.c = bundle;
        this.a = application;
        if (application != null) {
            if (t.a.c == null) {
                t.a.c = new t.a(application);
            }
            aVar = t.a.c;
        } else {
            aVar = new t.a(null);
        }
        this.b = aVar;
    }

    @Override // androidx.lifecycle.t.b
    public final zd1 a(Class cls, xi0 xi0Var) {
        String str;
        u uVar = u.a;
        LinkedHashMap linkedHashMap = xi0Var.a;
        String str2 = (String) linkedHashMap.get(uVar);
        if (str2 == null) {
            str = "VIEW_MODEL_KEY must always be provided by ViewModelProvider";
        } else {
            if (linkedHashMap.get(o.a) != null && linkedHashMap.get(o.b) != null) {
                Application application = (Application) linkedHashMap.get(s.a);
                boolean zIsAssignableFrom = r3.class.isAssignableFrom(cls);
                Constructor constructorA = ux0.a((!zIsAssignableFrom || application == null) ? ux0.b : ux0.a, cls);
                if (constructorA == null) {
                    return this.b.a(cls, xi0Var);
                }
                return (!zIsAssignableFrom || application == null) ? ux0.b(cls, constructorA, o.a(xi0Var)) : ux0.b(cls, constructorA, application, o.a(xi0Var));
            }
            if (this.d != null) {
                return d(cls, str2);
            }
            str = "SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.";
        }
        defpackage.d.AnonymousClass0.m(str);
        return null;
    }

    @Override // androidx.lifecycle.t.b
    public final zd1 b(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        defpackage.d.AnonymousClass0.m$2("Local and anonymous classes can not be ViewModels");
        return null;
    }

    @Override // androidx.lifecycle.t.d
    public final void c(zd1 zd1Var) {
        e eVar = this.d;
        if (eVar != null) {
            d.a(zd1Var, this.e, eVar);
        }
    }

    public final zd1 d(Class cls, String str) {
        e eVar = this.d;
        if (eVar == null) {
            defpackage.d.AnonymousClass0.m$3("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = r3.class.isAssignableFrom(cls);
        Application application = this.a;
        Constructor constructorA = ux0.a((!zIsAssignableFrom || application == null) ? ux0.b : ux0.a, cls);
        if (constructorA == null) {
            if (application != null) {
                return this.b.b(cls);
            }
            if (t.c.a == null) {
                t.c.a = new t.c();
            }
            return t.c.a.b(cls);
        }
        androidx.savedstate.a aVar = this.e;
        Bundle bundleA = aVar.a(str);
        Class[] clsArr = n.f;
        n nVarA = n.a.a(bundleA, this.c);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, nVarA);
        if (savedStateHandleController.d) {
            defpackage.d.AnonymousClass0.m("Already attached to lifecycleOwner");
            return null;
        }
        savedStateHandleController.d = true;
        eVar.a(savedStateHandleController);
        aVar.c(savedStateHandleController.b, savedStateHandleController.c.e);
        e.b bVarB = eVar.b();
        if (bVarB == e.b.INITIALIZED || bVarB.compareTo(e.b.STARTED) >= 0) {
            aVar.d();
        } else {
            eVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(eVar, aVar));
        }
        zd1 zd1VarB = (!zIsAssignableFrom || application == null) ? ux0.b(cls, constructorA, nVarA) : ux0.b(cls, constructorA, application, nVarA);
        zd1VarB.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return zd1VarB;
    }
}
