package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zn0 implements ao0 {
    public final ArrayList a;

    public zn0(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // defpackage.ao0
    public final boolean a(cv cvVar) {
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (e4.a(((xn0) ((wn0) it.next())).g, cvVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.ao0
    public final List b(cv cvVar) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (e4.a(((xn0) ((wn0) obj)).g, cvVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // defpackage.ao0
    public final void c(cv cvVar, ArrayList arrayList) {
        for (Object obj : this.a) {
            if (e4.a(((xn0) ((wn0) obj)).g, cvVar)) {
                arrayList.add(obj);
            }
        }
    }

    @Override // defpackage.ao0
    public final Collection l(cv cvVar, nw nwVar) {
        return fz0.E(fz0.y(new c81(new ge(0, this.a), p0.b$18), new uf$a(cvVar, 1)));
    }
}
