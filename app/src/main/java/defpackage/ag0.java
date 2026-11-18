package defpackage;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ag0 extends AbstractSet implements w90 {
    public final /* synthetic */ int G0;
    public final zf0 b;

    public /* synthetic */ ag0(zf0 zf0Var, int i) {
        this.G0 = i;
        this.b = zf0Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        if (this.G0 != 0) {
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        if (this.G0 != 0) {
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (this.G0 != 0) {
            return this.b.containsKey(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zf0 zf0Var = this.b;
        zf0Var.getClass();
        int iJ = zf0Var.j(entry.getKey());
        if (iJ < 0) {
            return false;
        }
        return e4.a(zf0Var.c[iJ], entry.getValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        if (this.G0 != 0) {
            return super.containsAll(collection);
        }
        zf0 zf0Var = this.b;
        zf0Var.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iJ = zf0Var.j(entry.getKey());
                    if (!(iJ < 0 ? false : e4.a(zf0Var.c[iJ], entry.getValue()))) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        int i = this.G0;
        zf0 zf0Var = this.b;
        return i != 0 ? zf0Var.isEmpty() : zf0Var.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.G0;
        zf0 zf0Var = this.b;
        zf0Var.getClass();
        return i != 0 ? new zf0.b(zf0Var, 1) : new zf0.b(zf0Var, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (this.G0 != 0) {
            zf0 zf0Var = this.b;
            zf0Var.b$1();
            int iJ = zf0Var.j(obj);
            if (iJ < 0) {
                return false;
            }
            zf0Var.m(iJ);
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zf0 zf0Var2 = this.b;
        zf0Var2.getClass();
        zf0Var2.b$1();
        int iJ2 = zf0Var2.j(entry.getKey());
        if (iJ2 < 0 || !e4.a(zf0Var2.c[iJ2], entry.getValue())) {
            return false;
        }
        zf0Var2.m(iJ2);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        this.b.b$1();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        this.b.b$1();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.G0;
        zf0 zf0Var = this.b;
        return i != 0 ? zf0Var.o : zf0Var.o;
    }
}
