package defpackage;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vb1 extends AbstractList implements RandomAccess, zd0 {
    public final yd0 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements ListIterator {
        public final ListIterator b;

        public a(vb1 vb1Var, int i) {
            this.b = vb1Var.b.listIterator(i);
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.b.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            return (String) this.b.next();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.b.nextIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            return (String) this.b.previous();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.b.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public vb1(yd0 yd0Var) {
        this.b = yd0Var;
    }

    @Override // defpackage.zd0
    public final void a(we0 we0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.b.get(i);
    }

    @Override // defpackage.zd0
    public final fa getByteString(int i) {
        return this.b.getByteString(i);
    }

    @Override // defpackage.zd0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.b.b);
    }

    @Override // defpackage.zd0
    public final vb1 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new pg.a(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new a(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.b.size();
    }
}
