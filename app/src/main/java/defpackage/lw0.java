package defpackage;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import we0.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lw0 extends fa {
    public static final int[] n;
    public final int c;
    public final fa d;
    public final fa f;
    public final int g;
    public final int i;
    public int j = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Iterator {
        public final Stack b = new Stack();
        public we0 c;

        public b(fa faVar) {
            while (faVar instanceof lw0) {
                lw0 lw0Var = (lw0) faVar;
                this.b.push(lw0Var);
                faVar = lw0Var.d;
            }
            this.c = (we0) faVar;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final we0 next() {
            we0 we0Var;
            we0 we0Var2 = this.c;
            if (we0Var2 == null) {
                throw new NoSuchElementException();
            }
            do {
                Stack stack = this.b;
                if (stack.isEmpty()) {
                    we0Var = null;
                    break;
                }
                fa faVar = ((lw0) stack.pop()).f;
                while (faVar instanceof lw0) {
                    lw0 lw0Var = (lw0) faVar;
                    stack.push(lw0Var);
                    faVar = lw0Var.d;
                }
                we0Var = (we0) faVar;
            } while (we0Var.c.length == 0);
            this.c = we0Var;
            return we0Var2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements Iterator {
        public final b b;
        public we0.a c;
        public int d;

        public c(lw0 lw0Var) {
            b bVar = new b(lw0Var);
            this.b = bVar;
            this.c = bVar.next().new a();
            this.d = lw0Var.c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.d > 0;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.c.hasNext()) {
                this.c = this.b.next().new a();
            }
            this.d--;
            return Byte.valueOf(this.c.nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        n = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = n;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public lw0(fa faVar, fa faVar2) {
        this.d = faVar;
        this.f = faVar2;
        int size = faVar.size();
        this.g = size;
        this.c = faVar2.size() + size;
        this.i = Math.max(faVar.h(), faVar2.h()) + 1;
    }

    public final boolean equals(Object obj) {
        int iO;
        if (obj == this) {
            return true;
        }
        if (obj instanceof fa) {
            fa faVar = (fa) obj;
            int size = faVar.size();
            int i = this.c;
            if (i == size) {
                if (i == 0) {
                    return true;
                }
                if (this.j == 0 || (iO = faVar.o()) == 0 || this.j == iO) {
                    b bVar = new b(this);
                    we0 next = bVar.next();
                    b bVar2 = new b(faVar);
                    we0 next2 = bVar2.next();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int length = next.c.length - i2;
                        int length2 = next2.c.length - i3;
                        int iMin = Math.min(length, length2);
                        if (!(i2 == 0 ? next.r(next2, i3, iMin) : next2.r(next, i2, iMin))) {
                            break;
                        }
                        i4 += iMin;
                        if (i4 >= i) {
                            if (i4 == i) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == length) {
                            next = bVar.next();
                            i2 = 0;
                        } else {
                            i2 += iMin;
                        }
                        if (iMin == length2) {
                            next2 = bVar2.next();
                            i3 = 0;
                        } else {
                            i3 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.fa
    public final void g(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = i + i3;
        fa faVar = this.d;
        int i6 = this.g;
        if (i5 <= i6) {
            faVar.g(bArr, i, i2, i3);
            return;
        }
        if (i >= i6) {
            i4 = i - i6;
        } else {
            int i7 = i6 - i;
            faVar.g(bArr, i, i2, i7);
            i2 += i7;
            i3 -= i7;
            i4 = 0;
        }
        this.f.g(bArr, i4, i2, i3);
    }

    @Override // defpackage.fa
    public final int h() {
        return this.i;
    }

    public final int hashCode() {
        int iM = this.j;
        if (iM == 0) {
            int i = this.c;
            iM = m(i, 0, i);
            if (iM == 0) {
                iM = 1;
            }
            this.j = iM;
        }
        return iM;
    }

    @Override // defpackage.fa
    public final boolean i() {
        return this.c >= n[this.i];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this);
    }

    @Override // defpackage.fa
    public final boolean j() {
        int iN = this.d.n(0, 0, this.g);
        fa faVar = this.f;
        return faVar.n(iN, 0, faVar.size()) == 0;
    }

    @Override // defpackage.fa
    public final int m(int i, int i2, int i3) {
        int i4;
        int i5 = i2 + i3;
        fa faVar = this.d;
        int i6 = this.g;
        if (i5 <= i6) {
            return faVar.m(i, i2, i3);
        }
        if (i2 >= i6) {
            i4 = i2 - i6;
        } else {
            int i7 = i6 - i2;
            i = faVar.m(i, i2, i7);
            i3 -= i7;
            i4 = 0;
        }
        return this.f.m(i, i4, i3);
    }

    @Override // defpackage.fa
    public final int n(int i, int i2, int i3) {
        int i4;
        int i5 = i2 + i3;
        fa faVar = this.d;
        int i6 = this.g;
        if (i5 <= i6) {
            return faVar.n(i, i2, i3);
        }
        if (i2 >= i6) {
            i4 = i2 - i6;
        } else {
            int i7 = i6 - i2;
            i = faVar.n(i, i2, i7);
            i3 -= i7;
            i4 = 0;
        }
        return this.f.n(i, i4, i3);
    }

    @Override // defpackage.fa
    public final int o() {
        return this.j;
    }

    @Override // defpackage.fa
    public final String p() {
        byte[] bArr;
        int i = this.c;
        if (i == 0) {
            bArr = h30.a;
        } else {
            byte[] bArr2 = new byte[i];
            g(bArr2, 0, 0, i);
            bArr = bArr2;
        }
        return new String(bArr, "UTF-8");
    }

    @Override // defpackage.fa
    public final void q(OutputStream outputStream, int i, int i2) {
        int i3;
        int i4 = i + i2;
        fa faVar = this.d;
        int i5 = this.g;
        if (i4 <= i5) {
            faVar.q(outputStream, i, i2);
            return;
        }
        if (i >= i5) {
            i3 = i - i5;
        } else {
            int i6 = i5 - i;
            faVar.q(outputStream, i, i6);
            i2 -= i6;
            i3 = 0;
        }
        this.f.q(outputStream, i3, i2);
    }

    @Override // defpackage.fa
    public final int size() {
        return this.c;
    }
}
