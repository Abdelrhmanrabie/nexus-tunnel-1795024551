package androidx.lifecycle;

import defpackage.be1;
import defpackage.ce1;
import defpackage.tx0;
import defpackage.zd1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a implements androidx.savedstate.a.InterfaceC0027a {
        @Override // androidx.savedstate.a.InterfaceC0027a
        public final void a(tx0 tx0Var) {
            if (!(tx0Var instanceof ce1)) {
                defpackage.d.AnonymousClass0.m("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                return;
            }
            be1 viewModelStore = ((ce1) tx0Var).getViewModelStore();
            androidx.savedstate.a savedStateRegistry = tx0Var.getSavedStateRegistry();
            viewModelStore.getClass();
            LinkedHashMap linkedHashMap = viewModelStore.a;
            Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
            while (it.hasNext()) {
                d.a((zd1) linkedHashMap.get((String) it.next()), savedStateRegistry, tx0Var.getLifecycle());
            }
            if (new HashSet(linkedHashMap.keySet()).isEmpty()) {
                return;
            }
            savedStateRegistry.d();
        }
    }

    public static final void a(zd1 zd1Var, androidx.savedstate.a aVar, e eVar) {
        boolean z;
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) zd1Var.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || (z = savedStateHandleController.d)) {
            return;
        }
        if (z) {
            defpackage.d.AnonymousClass0.m("Already attached to lifecycleOwner");
            return;
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
    }
}
