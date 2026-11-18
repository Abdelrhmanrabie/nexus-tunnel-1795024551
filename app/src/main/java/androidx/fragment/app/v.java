package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public s d;

    public final void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            defpackage.d.AnonymousClass0.m$3("Fragment already added: ", fragment);
            return;
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment b(String str) {
        u uVar = (u) this.b.get(str);
        if (uVar != null) {
            return uVar.c;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment fragmentFindFragmentByWho;
        for (u uVar : this.b.values()) {
            if (uVar != null && (fragmentFindFragmentByWho = uVar.c.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            arrayList.add(uVar != null ? uVar.c : null);
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public final void g(u uVar) {
        Fragment fragment = uVar.c;
        String str = fragment.mWho;
        HashMap map = this.b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, uVar);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            boolean z = fragment.mRetainInstance;
            s sVar = this.d;
            if (z) {
                sVar.a(fragment);
            } else {
                sVar.c(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            fragment.toString();
        }
    }

    public final void h(u uVar) {
        Fragment fragment = uVar.c;
        if (fragment.mRetainInstance) {
            this.d.c(fragment);
        }
        if (((u) this.b.put(fragment.mWho, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            fragment.toString();
        }
    }
}
