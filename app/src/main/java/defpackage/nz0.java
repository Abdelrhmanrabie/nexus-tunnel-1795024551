package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class nz0 extends e {
    public static final LinkedHashSet x1(Set set, Collection collection) {
        int size;
        Integer numValueOf = fb$1.m(collection) ? Integer.valueOf(collection.size()) : null;
        if (numValueOf != null) {
            size = set.size() + numValueOf.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(ye1.e(size));
        linkedHashSet.addAll(set);
        he.C0(collection, linkedHashSet);
        return linkedHashSet;
    }

    public static final LinkedHashSet y1(Set set, Object obj) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(ye1.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
