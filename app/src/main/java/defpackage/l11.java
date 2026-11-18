package defpackage;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l11 extends AbstractMap {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int b;
    public List c = Collections.EMPTY_LIST;
    public Map d = Collections.EMPTY_MAP;
    public boolean f;
    public volatile m11$d g;

    public l11(int i) {
        this.b = i;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x003d A[SYNTHETIC] */
    public final int a(Comparable comparable) {
        int i;
        int iCompareTo;
        int size = this.c.size();
        int i2 = size - 1;
        if (i2 < 0) {
            size = 0;
            while (size <= i2) {
                i = (size + i2) / 2;
                iCompareTo = comparable.compareTo(((m11$b) this.c.get(i)).b);
                if (iCompareTo < 0) {
                    i2 = i - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i;
                    }
                    size = i + 1;
                }
            }
        } else {
            int iCompareTo2 = comparable.compareTo(((m11$b) this.c.get(i2)).b);
            if (iCompareTo2 <= 0) {
                if (iCompareTo2 == 0) {
                    return i2;
                }
                size = 0;
                while (size <= i2) {
                    i = (size + i2) / 2;
                    iCompareTo = comparable.compareTo(((m11$b) this.c.get(i)).b);
                    if (iCompareTo < 0) {
                        i2 = i - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i;
                        }
                        size = i + 1;
                    }
                }
            }
        }
        return -(size + 1);
    }

    public final void b() {
        if (this.f) {
            throw new UnsupportedOperationException();
        }
    }

    public final Iterable c() {
        return this.d.isEmpty() ? ak.f4b : this.d.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
        if (this.d.isEmpty()) {
            return;
        }
        this.d.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.d.containsKey(comparable);
    }

    public final SortedMap e() {
        b();
        if (this.d.isEmpty() && !(this.d instanceof TreeMap)) {
            this.d = new TreeMap();
        }
        return (SortedMap) this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.g == null) {
            this.g = new m11$d(this);
        }
        return this.g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((m11$b) this.c.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.c.isEmpty();
        int i = this.b;
        if (zIsEmpty && !(this.c instanceof ArrayList)) {
            this.c = new ArrayList(i);
        }
        int i2 = -(iA + 1);
        if (i2 >= i) {
            return e().put(comparable, obj);
        }
        if (this.c.size() == i) {
            m11$b m11_b = (m11$b) this.c.remove(i - 1);
            e().put(m11_b.b, m11_b.c);
        }
        this.c.add(i2, new m11$b(this, comparable, obj));
        return null;
    }

    public final Object g(int i) {
        b();
        Object obj = ((m11$b) this.c.remove(i)).c;
        if (!this.d.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.c;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new m11$b(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((m11$b) this.c.get(iA)).c : this.d.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return g(iA);
        }
        if (this.d.isEmpty()) {
            return null;
        }
        return this.d.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.d.size() + this.c.size();
    }
}
