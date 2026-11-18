package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zm implements ak.c, yo0 {
    public static final zm a = new zm(1);
    public static final zm a$1 = new zm(2);
    public static final zm a$2 = new zm(3);
    public static final zm a$3 = new zm(4);
    public static final zm a$4 = new zm(5);
    public final /* synthetic */ int G0;

    public /* synthetic */ zm(int i) {
        this.G0 = i;
    }

    @Override // ak.c
    public Iterable Q(Object obj) {
        if (this.G0 == 0) {
            la laVar = (la) obj;
            return laVar == null ? uq.b : laVar.d();
        }
        Collection collectionD = ((wc1) obj).d();
        ArrayList arrayList = new ArrayList(ae.y0(collectionD));
        Iterator it = ((ArrayList) collectionD).iterator();
        while (it.hasNext()) {
            arrayList.add(((wc1) it.next()).a());
        }
        return arrayList;
    }

    @Override // defpackage.yo0
    public boolean d(on onVar, bo boVar) {
        if (this.G0 != 2) {
            return !boVar.getAnnotations().f(zo0.a);
        }
        return true;
    }

    public String toString() {
        return this.G0 != 6 ? super.toString() : "NULL_VALUE";
    }
}
