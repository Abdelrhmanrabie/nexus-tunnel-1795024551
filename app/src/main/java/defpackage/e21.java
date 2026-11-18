package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class e21 {
    public static final LinkedHashSet a;
    public static final dd b;

    static {
        List listAsList = Arrays.asList(r70.a, r70.h, r70.i, r70.c, r70.d, r70.f);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(dd.l((cv) it.next()));
        }
        a = linkedHashSet;
        b = dd.l(r70.g);
    }
}
