package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pe0 implements Iterator, w90 {
    public final CharSequence b;
    public int c;
    public int d;
    public int f;
    public int g;

    public pe0(CharSequence charSequence) {
        this.b = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.c;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.g < 0) {
            this.c = 2;
            return false;
        }
        CharSequence charSequence = this.b;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i4 = this.d; i4 < length2; i4++) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < charSequence.length() && charSequence.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.c = 1;
                this.g = i;
                this.f = length;
                return true;
            }
        }
        i = -1;
        this.c = 1;
        this.g = i;
        this.f = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c = 0;
        int i = this.f;
        int i2 = this.d;
        this.d = this.g + i;
        return this.b.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
