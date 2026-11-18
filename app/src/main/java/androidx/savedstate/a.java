package androidx.savedstate;

import android.os.Bundle;
import defpackage.ak;
import defpackage.d;
import defpackage.e4;
import defpackage.jx0;
import defpackage.tx0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public boolean b;
    public Bundle c;
    public boolean d;
    public Recreator.a e;
    public final jx0 a = new jx0();
    public boolean f = true;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InterfaceC0027a {
        void a(tx0 tx0Var);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        Bundle a();
    }

    public final Bundle a(String str) {
        if (!this.d) {
            d.AnonymousClass0.m("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
            return null;
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.c = null;
        return bundle2;
    }

    public final b b() {
        String str;
        b bVar;
        Iterator it = this.a.iterator();
        do {
            jx0.a aVar = (jx0.a) it;
            if (!aVar.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) aVar.next();
            str = (String) entry.getKey();
            bVar = (b) entry.getValue();
        } while (!e4.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return bVar;
    }

    public final void c(String str, b bVar) {
        if (((b) this.a.d(str, bVar)) == null) {
            return;
        }
        d.AnonymousClass0.m$2("SavedStateProvider with the given key is already registered");
    }

    public final void d() {
        if (!this.f) {
            d.AnonymousClass0.m("Can not perform this action after onSaveInstanceState");
            return;
        }
        Recreator.a aVar = this.e;
        if (aVar == null) {
            aVar = new Recreator.a(this);
        }
        this.e = aVar;
        try {
            androidx.lifecycle.d.a.class.getDeclaredConstructor(null);
            Recreator.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a.add(androidx.lifecycle.d.a.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(ak.AnonymousClass0.m("Class ", androidx.lifecycle.d.a.class.getSimpleName(), " must have default constructor in order to be automatically recreated"), e);
        }
    }
}
