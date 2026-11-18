package androidx.navigation;

import defpackage.bk0;
import defpackage.d;
import defpackage.z11;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b extends androidx.navigation.a implements Iterable<androidx.navigation.a> {
    public final z11 o;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator<androidx.navigation.a> {
        public int b = -1;
        public boolean c = false;

        public a() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b + 1 < b.this.o.g();
        }

        @Override // java.util.Iterator
        public final androidx.navigation.a next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = true;
            z11 z11Var = b.this.o;
            int i = this.b + 1;
            this.b = i;
            return (androidx.navigation.a) z11Var.h(i);
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.c) {
                d.AnonymousClass0.m("You must call next() before you can remove an element");
                return;
            }
            b bVar = b.this;
            ((androidx.navigation.a) bVar.o.h(this.b)).getClass();
            z11 z11Var = bVar.o;
            int i = this.b;
            Object[] objArr = z11Var.d;
            Object obj = objArr[i];
            Object obj2 = z11.g;
            if (obj != obj2) {
                objArr[i] = obj2;
                z11Var.b = true;
            }
            this.b = i - 1;
            this.c = false;
        }
    }

    public b(bk0 bk0Var) {
        super(bk0Var);
        this.o = new z11();
    }

    @Override // java.lang.Iterable
    public final Iterator<androidx.navigation.a> iterator() {
        return new a();
    }

    @Override // androidx.navigation.a
    public final String toString() {
        String hexString;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        androidx.navigation.a aVar = (androidx.navigation.a) this.o.e(0, null);
        androidx.navigation.a aVar2 = aVar != null ? aVar : null;
        if (aVar2 == null) {
            sb.append("0x");
            hexString = Integer.toHexString(0);
        } else {
            sb.append("{");
            sb.append(aVar2.toString());
            hexString = "}";
        }
        sb.append(hexString);
        return sb.toString();
    }
}
