package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xf implements ao0 {
    public final List a;
    public final String b;

    public xf(List list, String str) {
        this.a = list;
        this.b = str;
        list.size();
        he.i1((Iterable) list).size();
    }

    @Override // defpackage.ao0
    public final boolean a(cv cvVar) {
        List list = this.a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!e.N((ao0) it.next(), cvVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.ao0
    public final List b(cv cvVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            e.k((ao0) it.next(), cvVar, arrayList);
        }
        return he.g1(arrayList);
    }

    @Override // defpackage.ao0
    public final void c(cv cvVar, ArrayList arrayList) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            e.k((ao0) it.next(), cvVar, arrayList);
        }
    }

    @Override // defpackage.ao0
    public final Collection l(cv cvVar, nw nwVar) {
        HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((ao0) it.next()).l(cvVar, nwVar));
        }
        return hashSet;
    }

    public final String toString() {
        return this.b;
    }
}
