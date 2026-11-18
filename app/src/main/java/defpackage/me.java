package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class me {
    public static final LinkedHashSet a;

    static {
        Set set = wp0.g;
        ArrayList arrayList = new ArrayList(ae.y0(set));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(m21.i.c(((wp0) it.next()).b));
        }
        ArrayList arrayListY0 = he.Y0(he.Y0(he.Y0(arrayList, m21.a.f.h()), m21.a.h.h()), m21.a.j.h());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayListY0.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(dd.l((cv) it2.next()));
        }
        a = linkedHashSet;
    }
}
