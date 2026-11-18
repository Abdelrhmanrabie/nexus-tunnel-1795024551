package androidx.lifecycle;

import android.os.Bundle;
import defpackage.ae1;
import defpackage.ce1;
import defpackage.cj;
import defpackage.g20;
import defpackage.nw;
import defpackage.oc0;
import defpackage.ou0;
import defpackage.qx0;
import defpackage.rx0;
import defpackage.sc;
import defpackage.tx0;
import defpackage.xi0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final b a = new b();
    public static final c b = new c();
    public static final a c = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends oc0 implements nw {
        public static final d b = new d();

        public d() {
            super(1);
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            return new rx0();
        }
    }

    public static final n a(xi0 xi0Var) {
        LinkedHashMap linkedHashMap = xi0Var.a;
        tx0 tx0Var = (tx0) linkedHashMap.get(a);
        if (tx0Var == null) {
            defpackage.d.AnonymousClass0.m$2("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        ce1 ce1Var = (ce1) linkedHashMap.get(b);
        if (ce1Var == null) {
            defpackage.d.AnonymousClass0.m$2("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle = (Bundle) linkedHashMap.get(c);
        String str = (String) linkedHashMap.get(u.a);
        if (str == null) {
            defpackage.d.AnonymousClass0.m$2("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            return null;
        }
        androidx.savedstate.a.b bVarB = tx0Var.getSavedStateRegistry().b();
        qx0 qx0Var = bVarB instanceof qx0 ? (qx0) bVarB : null;
        if (qx0Var == null) {
            defpackage.d.AnonymousClass0.m("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
            return null;
        }
        LinkedHashMap linkedHashMap2 = c(ce1Var).a;
        n nVar = (n) linkedHashMap2.get(str);
        if (nVar != null) {
            return nVar;
        }
        Class[] clsArr = n.f;
        qx0Var.b();
        Bundle bundle2 = qx0Var.c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = qx0Var.c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = qx0Var.c;
        if (bundle5 != null && bundle5.isEmpty()) {
            qx0Var.c = null;
        }
        n nVarA = n.a.a(bundle3, bundle);
        linkedHashMap2.put(str, nVarA);
        return nVarA;
    }

    public static final void b(tx0 tx0Var) {
        e.b bVarB = tx0Var.getLifecycle().b();
        if (bVarB != e.b.INITIALIZED && bVarB != e.b.CREATED) {
            defpackage.d.AnonymousClass0.m$2("Failed requirement.");
        } else if (tx0Var.getSavedStateRegistry().b() == null) {
            qx0 qx0Var = new qx0(tx0Var.getSavedStateRegistry(), (ce1) tx0Var);
            tx0Var.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", qx0Var);
            tx0Var.getLifecycle().a(new SavedStateHandleAttacher(qx0Var));
        }
    }

    public static final rx0 c(ce1 ce1Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ae1(((sc) ou0.a.b(rx0.class)).d(), d.b));
        ae1[] ae1VarArr = (ae1[]) arrayList.toArray(new ae1[0]);
        return (rx0) new t(ce1Var.getViewModelStore(), new g20((ae1[]) Arrays.copyOf(ae1VarArr, ae1VarArr.length)), ce1Var instanceof androidx.lifecycle.c ? ((androidx.lifecycle.c) ce1Var).getDefaultViewModelCreationExtras() : cj.a.b).b(rx0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
