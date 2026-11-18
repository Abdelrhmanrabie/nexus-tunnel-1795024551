package defpackage;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class q2 {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final k2 a;
        public final l2 b;

        public a(l2 l2Var, k2 k2Var) {
            this.a = k2Var;
            this.b = l2Var;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public final e a;
        public final ArrayList b = new ArrayList();

        public b(e eVar) {
            this.a = eVar;
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.e.get(str);
        if ((aVar != null ? aVar.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                aVar.a.a(aVar.b.c(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new j2(intent, i2));
        return true;
    }

    public abstract void b(int i, l2 l2Var, Object obj);

    public final s2 c(final String str, he0 he0Var, final l2 l2Var, final k2 k2Var) {
        e lifecycle = he0Var.getLifecycle();
        if (lifecycle.b().compareTo(e.b.STARTED) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(he0Var);
            e.b bVarB = lifecycle.b();
            sb.append(" is attempting to register while current state is ");
            sb.append(bVarB);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString().toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.c;
        b bVar = (b) linkedHashMap.get(str);
        if (bVar == null) {
            bVar = new b(lifecycle);
        }
        h hVar = new h() { // from class: p2
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var2, e.a aVar) {
                e.a aVar2 = e.a.ON_START;
                q2 q2Var = this.b;
                String str2 = str;
                if (aVar2 != aVar) {
                    if (e.a.ON_STOP == aVar) {
                        q2Var.e.remove(str2);
                        return;
                    } else {
                        if (e.a.ON_DESTROY == aVar) {
                            q2Var.f(str2);
                            return;
                        }
                        return;
                    }
                }
                LinkedHashMap linkedHashMap2 = q2Var.e;
                l2 l2Var2 = l2Var;
                k2 k2Var2 = k2Var;
                linkedHashMap2.put(str2, new q2.a(l2Var2, k2Var2));
                LinkedHashMap linkedHashMap3 = q2Var.f;
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    k2Var2.a(obj);
                }
                Bundle bundle = q2Var.g;
                j2 j2Var = (j2) ak.a(bundle, str2);
                if (j2Var != null) {
                    bundle.remove(str2);
                    k2Var2.a(l2Var2.c(j2Var.c, j2Var.b));
                }
            }
        };
        bVar.a.a(hVar);
        bVar.b.add(hVar);
        linkedHashMap.put(str, bVar);
        return new s2();
    }

    public final t2 d(String str, l2 l2Var, k2 k2Var) {
        e(str);
        this.e.put(str, new a(l2Var, k2Var));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            k2Var.a(obj);
        }
        Bundle bundle = this.g;
        j2 j2Var = (j2) ak.a(bundle, str);
        if (j2Var != null) {
            bundle.remove(str);
            k2Var.a(l2Var.c(j2Var.c, j2Var.b));
        }
        return new t2(this, str, l2Var);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        for (Number number : fz0.v(r2.b)) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String str) {
        Integer num;
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Objects.toString(linkedHashMap.get(str));
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            Objects.toString((j2) ak.a(bundle, str));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.c;
        b bVar = (b) linkedHashMap2.get(str);
        if (bVar != null) {
            ArrayList arrayList = bVar.b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.a.c((h) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
