package defpackage;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class be implements Iterator, w90 {
    public final /* synthetic */ int G0 = 0;
    public final Object b;

    public be(Enumeration enumeration) {
        this.b = enumeration;
    }

    public be(Object[] objArr) {
        this.b = new a7(0, objArr);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.G0;
        Object obj = this.b;
        return i != 0 ? ((a7) obj).hasNext() : ((Enumeration) obj).hasMoreElements();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.G0;
        Object obj = this.b;
        return i != 0 ? ((a7) obj).next() : ((Enumeration) obj).nextElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.G0 == 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        throw new UnsupportedOperationException();
    }
}
