package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hw0 extends d0 {
    public final ArrayList b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements ListIterator, w90 {
        public final ListIterator b;
        public final /* synthetic */ hw0 c;

        public a(int i, hw0 hw0Var) {
            this.c = hw0Var;
            this.b = hw0Var.b.listIterator(he.B0(i, hw0Var));
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            ListIterator listIterator = this.b;
            listIterator.add(obj);
            listIterator.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasPrevious();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.b.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            return this.b.previous();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return (this.c.size() - 1) - this.b.previousIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            return this.b.next();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return (this.c.size() - 1) - this.b.nextIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            this.b.remove();
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            this.b.set(obj);
        }
    }

    public hw0(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.b.add(he.B0(i, this), obj);
    }

    @Override // defpackage.d0
    public final int b() {
        return this.b.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b.clear();
    }

    @Override // defpackage.d0
    public final Object e(int i) {
        return this.b.remove(he.A0(i, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.b.get(he.A0(i, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new a(0, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new a(0, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new a(i, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.b.set(he.A0(i, this), obj);
    }
}
