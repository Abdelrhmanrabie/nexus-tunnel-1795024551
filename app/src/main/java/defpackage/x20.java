package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class x20 implements Iterator, w90 {
    public final int b;
    public final int c;
    public boolean d;
    public int f;

    public x20(int i, int i2, int i3) {
        this.b = i3;
        this.c = i2;
        boolean z = i3 <= 0 ? i >= i2 : i <= i2;
        this.d = z;
        this.f = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.d;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public final int nextInt() {
        int i = this.f;
        if (i != this.c) {
            this.f = this.b + i;
            return i;
        }
        if (!this.d) {
            throw new NoSuchElementException();
        }
        this.d = false;
        return i;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
