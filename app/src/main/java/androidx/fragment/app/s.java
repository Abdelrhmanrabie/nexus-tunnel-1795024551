package androidx.fragment.app;

import android.util.Log;
import defpackage.be1;
import defpackage.xi0;
import defpackage.zd1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class s extends zd1 {
    public static final a g = new a();
    public final boolean d;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public boolean e = false;
    public boolean f = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements androidx.lifecycle.t.b {
        @Override // androidx.lifecycle.t.b
        public final zd1 a(Class cls, xi0 xi0Var) {
            return b(cls);
        }

        @Override // androidx.lifecycle.t.b
        public final zd1 b(Class cls) {
            return new s(true);
        }
    }

    public s(boolean z) {
        this.d = z;
    }

    public final void a(Fragment fragment) {
        if (this.f) {
            return;
        }
        String str = fragment.mWho;
        HashMap map = this.a;
        if (map.containsKey(str)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (Log.isLoggable("FragmentManager", 2)) {
            fragment.toString();
        }
    }

    public final void b(String str) {
        HashMap map = this.b;
        s sVar = (s) map.get(str);
        if (sVar != null) {
            sVar.onCleared();
            map.remove(str);
        }
        HashMap map2 = this.c;
        be1 be1Var = (be1) map2.get(str);
        if (be1Var != null) {
            LinkedHashMap linkedHashMap = be1Var.a;
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                ((zd1) it.next()).clear();
            }
            linkedHashMap.clear();
            map2.remove(str);
        }
    }

    public final void c(Fragment fragment) {
        if (this.f || this.a.remove(fragment.mWho) == null || !Log.isLoggable("FragmentManager", 2)) {
            return;
        }
        fragment.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.a.equals(sVar.a) && this.b.equals(sVar.b) && this.c.equals(sVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    @Override // defpackage.zd1
    public final void onCleared() {
        if (Log.isLoggable("FragmentManager", 3)) {
            toString();
        }
        this.e = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
