package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c20 implements Iterator, w90 {
    public final /* synthetic */ int G0 = 0;
    public final Iterator b;
    public int c;

    public c20(Iterator it) {
        this.b = it;
    }

    public c20(kp kpVar) {
        this.b = kpVar.a.iterator();
        this.c = kpVar.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        if (this.G0 == 0) {
            return this.b.hasNext();
        }
        while (true) {
            int i = this.c;
            it = this.b;
            if (i <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.c--;
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        if (this.G0 == 0) {
            int i = this.c;
            this.c = i + 1;
            if (i >= 0) {
                return new a20(i, this.b.next());
            }
            e.q0();
            throw null;
        }
        while (true) {
            int i2 = this.c;
            it = this.b;
            if (i2 <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.c--;
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.G0 == 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
