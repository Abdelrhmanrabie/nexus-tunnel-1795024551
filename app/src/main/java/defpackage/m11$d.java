package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m11$d extends AbstractSet {
    public final /* synthetic */ l11 b;

    public m11$d(l11 l11Var) {
        this.b = l11Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.b.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.b.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        final l11 l11Var = this.b;
        return new Iterator() { // from class: m11$c
            public int b = -1;
            public boolean c;
            public Iterator d;

            public final Iterator a() {
                if (this.d == null) {
                    this.d = l11Var.d.entrySet().iterator();
                }
                return this.d;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.b + 1 < l11Var.c.size() || a().hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                this.c = true;
                int i = this.b + 1;
                this.b = i;
                l11 l11Var2 = l11Var;
                return (Map.Entry) (i < l11Var2.c.size() ? l11Var2.c.get(this.b) : a().next());
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (!this.c) {
                    d.AnonymousClass0.m("remove() was called before next()");
                    return;
                }
                this.c = false;
                int i = l11.$r8$clinit;
                l11 l11Var2 = l11Var;
                l11Var2.b();
                if (this.b >= l11Var2.c.size()) {
                    a().remove();
                    return;
                }
                int i2 = this.b;
                this.b = i2 - 1;
                l11Var2.g(i2);
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.b.remove(entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b.size();
    }
}
