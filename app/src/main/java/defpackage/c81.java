package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c81 implements sy0 {
    public final sy0 a;
    public final nw b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator, w90 {
        public final Iterator b;

        public a() {
            this.b = c81.this.a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            return c81.this.b.invoke(this.b.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c81(sy0 sy0Var, nw nwVar) {
        this.a = sy0Var;
        this.b = nwVar;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return new a();
    }
}
