package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class a7 implements Iterator, w90 {
    public final /* synthetic */ int G0;
    public final Object b;
    public int c;

    public /* synthetic */ a7(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.G0;
        int i2 = this.c;
        Object obj = this.b;
        if (i != 0) {
            return i2 < ((z) obj).b();
        }
        return i2 < ((Object[]) obj).length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.G0 != 0) {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.c;
            this.c = i + 1;
            return ((z) this.b).get(i);
        }
        try {
            Object[] objArr = (Object[]) this.b;
            int i2 = this.c;
            this.c = i2 + 1;
            return objArr[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.c--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.G0 == 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
