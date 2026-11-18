package defpackage;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class he extends ce {
    public static final int A0(int i, hw0 hw0Var) {
        if (i >= 0 && i <= hw0Var.size() - 1) {
            return (hw0Var.size() - 1) - i;
        }
        StringBuilder sbN = ak.n(i, "Element index ", " must be in range [");
        sbN.append(new y20(0, hw0Var.size() - 1, 1));
        sbN.append("].");
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    public static final int B0(int i, hw0 hw0Var) {
        if (i >= 0 && i <= hw0Var.b()) {
            return hw0Var.b() - i;
        }
        StringBuilder sbN = ak.n(i, "Position index ", " must be in range [");
        sbN.append(new y20(0, hw0Var.b(), 1));
        sbN.append("].");
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    public static final void C0(Iterable iterable, AbstractCollection abstractCollection) {
        if (iterable instanceof Collection) {
            abstractCollection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static final List G0(List list) {
        ArrayList arrayList;
        if (fb$1.m(list)) {
            int size = list.size() - 1;
            if (size <= 0) {
                return uq.b;
            }
            if (size == 1) {
                return Collections.singletonList(S0(list));
            }
            arrayList = new ArrayList(size);
            if (fb$1.m(list)) {
                if (list instanceof RandomAccess) {
                    int size2 = list.size();
                    for (int i = 1; i < size2; i++) {
                        arrayList.add(list.get(i));
                    }
                } else {
                    ListIterator listIterator = list.listIterator(1);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : list) {
            if (i2 >= 1) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return e.e0(arrayList);
    }

    public static final Object J0(Iterable iterable) {
        if (iterable instanceof List) {
            return K0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object K0(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final Object L0(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final Object M0(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final Object N0(List list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final void O0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, nw nwVar) {
        sb.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            } else {
                e.g(sb, obj, nwVar);
            }
        }
        if (i >= 0 && i2 > i) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static /* synthetic */ void P0(Collection collection, StringBuilder sb, String str, String str2, nw nwVar, int i) {
        String str3 = (i & 4) != 0 ? AppConfig.CUSTOM : str;
        String str4 = (i & 8) != 0 ? AppConfig.CUSTOM : str2;
        if ((i & 64) != 0) {
            nwVar = null;
        }
        O0(collection, sb, ", ", str3, str4, -1, "...", nwVar);
    }

    public static String R0(Iterable iterable, String str, String str2, String str3, nw nwVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? AppConfig.CUSTOM : str2;
        String str6 = (i & 4) != 0 ? AppConfig.CUSTOM : str3;
        if ((i & 32) != 0) {
            nwVar = null;
        }
        StringBuilder sb = new StringBuilder();
        O0(iterable, sb, str4, str5, str6, -1, "...", nwVar);
        return sb.toString();
    }

    public static final Object S0(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            return T0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static final Object T0(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static final Object U0(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final ArrayList V0(s4 s4Var, Iterable iterable) {
        if (s4Var instanceof Collection) {
            return X0(iterable, (Collection) s4Var);
        }
        ArrayList arrayList = new ArrayList();
        C0(s4Var, arrayList);
        C0(iterable, arrayList);
        return arrayList;
    }

    public static final ArrayList X0(Iterable iterable, Collection collection) {
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            C0(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final ArrayList Y0(Collection collection, Object obj) {
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static final Object Z0(Iterable iterable) {
        if (iterable instanceof List) {
            return a1((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        d.AnonymousClass0.m$2("Collection has more than one element.");
        return null;
    }

    public static final Object a1(List list) {
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        d.AnonymousClass0.m$2("List has more than one element.");
        return null;
    }

    public static final Object b1(Collection collection) {
        if (collection instanceof List) {
            List list = (List) collection;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static final List e1(List list, int i) {
        if (i < 0) {
            d.AnonymousClass0.m((Object) e.i(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return uq.b;
        }
        if (fb$1.m(list)) {
            if (i >= list.size()) {
                return g1(list);
            }
            if (i == 1) {
                return Collections.singletonList(J0(list));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return e.e0(arrayList);
    }

    public static final void f1(Iterable iterable, AbstractCollection abstractCollection) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static final List g1(Iterable iterable) {
        ArrayList arrayList;
        boolean z = iterable instanceof Collection;
        if (!z) {
            if (z) {
                arrayList = new ArrayList((Collection) iterable);
            } else {
                arrayList = new ArrayList();
                f1(iterable, arrayList);
            }
            return e.e0(arrayList);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return uq.b;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final LinkedHashSet h1(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f1(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static final Set i1(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(ye1.e(collection.size()));
                f1(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            f1(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : Collections.singleton(linkedHashSet2.iterator().next());
            }
        }
        return yq.b;
    }

    public static final l7 j1(List list) {
        int i = 1;
        return new l7(i, new k7(list, i, 0));
    }

    public static final ArrayList k1(List list, List list2) {
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(ae.y0(list), ae.y0(list2)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new jo0(it.next(), it2.next()));
        }
        return arrayList;
    }
}
