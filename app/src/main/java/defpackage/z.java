package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class z implements List, Collection, w90 {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends a7 implements ListIterator {
        public c(int i) {
            super(1, z.this);
            int iB = z.this.b();
            if (i < 0 || i > iB) {
                throw new IndexOutOfBoundsException(ak.i(i, iB, "index: ", ", size: "));
            }
            this.c = i;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.c > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.c;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.c - 1;
            this.c = i;
            return z.this.get(i);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.c - 1;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends z implements RandomAccess {
        public final z b;
        public final int c;
        public final int d;

        public d(z zVar, int i, int i2) {
            this.b = zVar;
            this.c = i;
            ui.a(i, i2, zVar.b());
            this.d = i2 - i;
        }

        @Override // defpackage.z
        public final int b() {
            return this.d;
        }

        @Override // java.util.List
        public final Object get(int i) {
            int i2 = this.d;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
            }
            return this.b.get(this.c + i);
        }
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int b();

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        a7 a7Var = new a7(1, this);
        while (a7Var.hasNext()) {
            if (e4.a(a7Var.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            Collection collection = (Collection) obj;
            if (b() != collection.size()) {
                return false;
            }
            Iterator it = collection.iterator();
            a7 a7Var = new a7(1, this);
            while (a7Var.hasNext()) {
                if (!e4.a(a7Var.next(), it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        int iHashCode = 1;
        a7 a7Var = new a7(1, this);
        while (a7Var.hasNext()) {
            Object next = a7Var.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        a7 a7Var = new a7(1, this);
        int i = 0;
        while (a7Var.hasNext()) {
            if (e4.a(a7Var.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return b() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a7(1, this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        c cVar = new c(b());
        while (cVar.hasPrevious()) {
            if (e4.a(cVar.previous(), obj)) {
                return cVar.c;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new c(i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return e.Q((Collection) this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return e.R(this, objArr);
    }

    public final String toString() {
        return he.R0(this, ", ", "[", "]", new m(0, this), 24);
    }
}
