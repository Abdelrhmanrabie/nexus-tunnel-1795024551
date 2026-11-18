package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pg implements Iterable {
    public static final pg f = new pg();
    public final Object b;
    public final pg c;
    public final int d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator {
        public final /* synthetic */ int G0 = 0;
        public Object b;

        public /* synthetic */ a() {
        }

        public a(vb1 vb1Var) {
            this.b = vb1Var.b.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i = this.G0;
            Object obj = this.b;
            if (i != 0) {
                return ((Iterator) obj).hasNext();
            }
            return ((pg) obj).d > 0;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i = this.G0;
            Object obj = this.b;
            if (i != 0) {
                return (String) ((Iterator) obj).next();
            }
            pg pgVar = (pg) obj;
            Object obj2 = pgVar.b;
            this.b = pgVar.c;
            return obj2;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.G0 == 0) {
                throw new UnsupportedOperationException();
            }
            throw new UnsupportedOperationException();
        }
    }

    public pg() {
        this.d = 0;
        this.b = null;
        this.c = null;
    }

    public pg(Object obj, pg pgVar) {
        this.b = obj;
        this.c = pgVar;
        this.d = pgVar.d + 1;
    }

    public final pg b(Object obj) {
        if (this.d != 0) {
            Object obj2 = this.b;
            boolean zEquals = obj2.equals(obj);
            pg pgVar = this.c;
            if (zEquals) {
                return pgVar;
            }
            pg pgVarB = pgVar.b(obj);
            if (pgVarB != pgVar) {
                return new pg(obj2, pgVarB);
            }
        }
        return this;
    }

    public final pg d(int i) {
        if (i < 0 || i > this.d) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            return this;
        }
        return this.c.d(i - 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        pg pgVarD = d(0);
        a aVar = new a();
        aVar.b = pgVarD;
        return aVar;
    }
}
