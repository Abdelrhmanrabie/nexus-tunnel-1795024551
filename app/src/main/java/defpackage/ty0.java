package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ty0 implements Iterator, ai, w90 {
    public int b;
    public h70 c;
    public ai d;

    public final RuntimeException b() {
        int i = this.b;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.b);
    }

    @Override // defpackage.ai
    public final li getContext() {
        return rq.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        while (true) {
            i = this.b;
            if (i != 0) {
                break;
            }
            this.b = 5;
            ai aiVar = this.d;
            this.d = null;
            aiVar.resumeWith(tb1.a);
        }
        if (i == 1) {
            throw null;
        }
        if (i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw b();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.b = 1;
            throw null;
        }
        if (i != 3) {
            throw b();
        }
        this.b = 0;
        h70 h70Var = this.c;
        this.c = null;
        return h70Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.ai
    public final void resumeWith(Object obj) throws Throwable {
        e4.b(obj);
        this.b = 4;
    }
}
