package defpackage;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z6 extends d0 {
    public static final Object[] f = new Object[0];
    public int b;
    public Object[] c = f;
    public int d;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        m();
        h(this.d + 1);
        int iL = l(this.b + i);
        int i3 = this.d;
        if (i < ((i3 + 1) >> 1)) {
            if (iL == 0) {
                iL = this.c.length;
            }
            int i4 = iL - 1;
            int i5 = this.b;
            int length = (i5 == 0 ? this.c.length : i5) - 1;
            Object[] objArr = this.c;
            if (i4 >= i5) {
                objArr[length] = objArr[i5];
                ae.z0(objArr, i5, objArr, i5 + 1, iL);
            } else {
                ae.z0(objArr, i5 - 1, objArr, i5, objArr.length);
                Object[] objArr2 = this.c;
                objArr2[objArr2.length - 1] = objArr2[0];
                ae.z0(objArr2, 0, objArr2, 1, iL);
            }
            this.c[i4] = obj;
            this.b = length;
        } else {
            int iL2 = l(i3 + this.b);
            Object[] objArr3 = this.c;
            if (iL < iL2) {
                ae.z0(objArr3, iL + 1, objArr3, iL, iL2);
            } else {
                ae.z0(objArr3, 1, objArr3, 0, iL2);
                Object[] objArr4 = this.c;
                objArr4[0] = objArr4[objArr4.length - 1];
                ae.z0(objArr4, iL + 1, objArr4, iL, objArr4.length - 1);
            }
            this.c[iL] = obj;
        }
        this.d++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0052 A[PHI: r0
      0x0052: PHI (r0v11 int) = (r0v9 int), (r0v12 int) binds: [B:16:0x0047, B:19:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.d) {
            return addAll(collection);
        }
        m();
        h(collection.size() + this.d);
        int iL = l(this.d + this.b);
        int iL2 = l(this.b + i);
        int size = collection.size();
        if (i >= ((this.d + 1) >> 1)) {
            int length = iL2 + size;
            Object[] objArr = this.c;
            if (iL2 < iL) {
                int i3 = size + iL;
                if (i3 <= objArr.length) {
                    ae.z0(objArr, length, objArr, iL2, iL);
                } else if (length >= objArr.length) {
                    length -= objArr.length;
                    ae.z0(objArr, length, objArr, iL2, iL);
                } else {
                    int length2 = iL - (i3 - objArr.length);
                    ae.z0(objArr, 0, objArr, length2, iL);
                    Object[] objArr2 = this.c;
                    ae.z0(objArr2, length, objArr2, iL2, length2);
                }
            } else {
                ae.z0(objArr, size, objArr, 0, iL);
                Object[] objArr3 = this.c;
                if (length >= objArr3.length) {
                    ae.z0(objArr3, length - objArr3.length, objArr3, iL2, objArr3.length);
                } else {
                    ae.z0(objArr3, 0, objArr3, objArr3.length - size, objArr3.length);
                    Object[] objArr4 = this.c;
                    ae.z0(objArr4, length, objArr4, iL2, objArr4.length - size);
                }
            }
            g(iL2, collection);
            return true;
        }
        int i4 = this.b;
        int length3 = i4 - size;
        Object[] objArr5 = this.c;
        if (iL2 < i4) {
            ae.z0(objArr5, length3, objArr5, i4, objArr5.length);
            Object[] objArr6 = this.c;
            int length4 = objArr6.length - size;
            if (size >= iL2) {
                ae.z0(objArr6, length4, objArr6, 0, iL2);
            } else {
                ae.z0(objArr6, length4, objArr6, 0, size);
                Object[] objArr7 = this.c;
                ae.z0(objArr7, 0, objArr7, size, iL2);
            }
        } else if (length3 >= 0) {
            ae.z0(objArr5, length3, objArr5, i4, iL2);
        } else {
            length3 += objArr5.length;
            int i5 = iL2 - i4;
            int length5 = objArr5.length - length3;
            if (length5 >= i5) {
                ae.z0(objArr5, length3, objArr5, i4, iL2);
            } else {
                ae.z0(objArr5, length3, objArr5, i4, i4 + length5);
                Object[] objArr8 = this.c;
                ae.z0(objArr8, 0, objArr8, this.b + length5, iL2);
            }
        }
        this.b = length3;
        g(j(iL2 - size), collection);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        m();
        h(collection.size() + this.d);
        g(l(this.d + this.b), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        m();
        h(this.d + 1);
        int length = this.b;
        if (length == 0) {
            length = this.c.length;
        }
        int i = length - 1;
        this.b = i;
        this.c[i] = obj;
        this.d++;
    }

    public final void addLast(Object obj) {
        m();
        h(this.d + 1);
        this.c[l(this.d + this.b)] = obj;
        this.d++;
    }

    @Override // defpackage.d0
    public final int b() {
        return this.d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            m();
            k(this.b, l(this.d + this.b));
        }
        this.b = 0;
        this.d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.d0
    public final Object e(int i) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
        }
        if (i == b() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        m();
        int iL = l(this.b + i);
        Object[] objArr = this.c;
        Object obj = objArr[iL];
        int i3 = this.d >> 1;
        int i4 = this.b;
        if (i < i3) {
            if (iL >= i4) {
                ae.z0(objArr, i4 + 1, objArr, i4, iL);
            } else {
                ae.z0(objArr, 1, objArr, 0, iL);
                Object[] objArr2 = this.c;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.b;
                ae.z0(objArr2, i5 + 1, objArr2, i5, objArr2.length - 1);
            }
            Object[] objArr3 = this.c;
            int i6 = this.b;
            objArr3[i6] = null;
            this.b = i(i6);
        } else {
            int iL2 = l((b() - 1) + i4);
            Object[] objArr4 = this.c;
            int i7 = iL + 1;
            if (iL <= iL2) {
                ae.z0(objArr4, iL, objArr4, i7, iL2 + 1);
            } else {
                ae.z0(objArr4, iL, objArr4, i7, objArr4.length);
                Object[] objArr5 = this.c;
                objArr5[objArr5.length - 1] = objArr5[0];
                ae.z0(objArr5, 0, objArr5, 1, iL2 + 1);
            }
            this.c[iL2] = null;
        }
        this.d--;
        return obj;
    }

    public final void g(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.c.length;
        while (i < length && it.hasNext()) {
            this.c[i] = it.next();
            i++;
        }
        int i2 = this.b;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.c[i3] = it.next();
        }
        this.d = collection.size() + this.d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
        }
        return this.c[l(this.b + i)];
    }

    public final void h(int i) {
        if (i < 0) {
            d.AnonymousClass0.m("Deque is too big.");
            return;
        }
        Object[] objArr = this.c;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f) {
            if (i < 10) {
                i = 10;
            }
            this.c = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        ae.z0(objArr, 0, objArr2, this.b, objArr.length);
        Object[] objArr3 = this.c;
        int length2 = objArr3.length;
        int i3 = this.b;
        ae.z0(objArr3, length2 - i3, objArr2, 0, i3);
        this.b = 0;
        this.c = objArr2;
    }

    public final int i(int i) {
        if (i == this.c.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int iL = l(this.d + this.b);
        int length = this.b;
        if (length < iL) {
            while (length < iL) {
                if (!e4.a(obj, this.c[length])) {
                    length++;
                }
            }
            return -1;
        }
        if (length < iL) {
            return -1;
        }
        int length2 = this.c.length;
        while (length < length2) {
            if (!e4.a(obj, this.c[length])) {
                length++;
            }
        }
        for (int i = 0; i < iL; i++) {
            if (e4.a(obj, this.c[i])) {
                length = i + this.c.length;
            }
        }
        return -1;
        return length - this.b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.d == 0;
    }

    public final int j(int i) {
        return i < 0 ? i + this.c.length : i;
    }

    public final void k(int i, int i2) {
        Object[] objArr = this.c;
        if (i < i2) {
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Arrays.fill(objArr, i, objArr.length, (Object) null);
            Arrays.fill(this.c, 0, i2, (Object) null);
        }
    }

    public final int l(int i) {
        Object[] objArr = this.c;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int iL = l(this.d + this.b);
        int i = this.b;
        if (i < iL) {
            length = iL - 1;
            if (i <= length) {
                while (!e4.a(obj, this.c[length])) {
                    if (length != i) {
                        length--;
                    }
                }
                return length - this.b;
            }
            return -1;
        }
        if (i > iL) {
            int i2 = iL - 1;
            while (true) {
                Object[] objArr = this.c;
                if (-1 >= i2) {
                    length = objArr.length - 1;
                    int i3 = this.b;
                    if (i3 <= length) {
                        while (!e4.a(obj, this.c[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        break;
                    }
                } else {
                    if (e4.a(obj, objArr[i2])) {
                        length = i2 + this.c.length;
                        break;
                    }
                    i2--;
                }
            }
            return length - this.b;
        }
        return -1;
    }

    public final void m() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        e(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iL;
        Object[] objArr;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.c.length != 0) {
            int iL2 = l(this.d + this.b);
            int i = this.b;
            if (i < iL2) {
                iL = i;
                while (true) {
                    objArr = this.c;
                    if (i >= iL2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.c[iL] = obj;
                        iL++;
                    }
                    i++;
                }
                Arrays.fill(objArr, iL, iL2, (Object) null);
            } else {
                int length = this.c.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.c[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iL = l(i2);
                for (int i3 = 0; i3 < iL2; i3++) {
                    Object[] objArr3 = this.c;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.c[iL] = obj3;
                        iL = i(iL);
                    }
                }
                z = z2;
            }
            if (z) {
                m();
                this.d = j(iL - this.b);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m();
        Object[] objArr = this.c;
        int i = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.b = i(i);
        this.d--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m();
        int iL = l((b() - 1) + this.b);
        Object[] objArr = this.c;
        Object obj = objArr[iL];
        objArr[iL] = null;
        this.d--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        ui.a(i, i2, this.d);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.d) {
            clear();
            return;
        }
        if (i3 == 1) {
            e(i);
            return;
        }
        m();
        int i4 = this.d - i2;
        int i5 = this.b;
        if (i < i4) {
            int iL = l((i - 1) + i5);
            int iL2 = l((i2 - 1) + this.b);
            while (i > 0) {
                int i6 = iL + 1;
                int iMin = Math.min(i, Math.min(i6, iL2 + 1));
                Object[] objArr = this.c;
                int i7 = iL2 - iMin;
                int i8 = iL - iMin;
                ae.z0(objArr, i7 + 1, objArr, i8 + 1, i6);
                iL = j(i8);
                iL2 = j(i7);
                i -= iMin;
            }
            int iL3 = l(this.b + i3);
            k(this.b, iL3);
            this.b = iL3;
        } else {
            int iL4 = l(i5 + i2);
            int iL5 = l(this.b + i);
            int i9 = this.d;
            while (true) {
                i9 -= i2;
                if (i9 <= 0) {
                    break;
                }
                Object[] objArr2 = this.c;
                i2 = Math.min(i9, Math.min(objArr2.length - iL4, objArr2.length - iL5));
                Object[] objArr3 = this.c;
                int i10 = iL4 + i2;
                ae.z0(objArr3, iL5, objArr3, iL4, i10);
                iL4 = l(i10);
                iL5 = l(iL5 + i2);
            }
            int iL6 = l(this.d + this.b);
            k(j(iL6 - i3), iL6);
        }
        this.d -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iL;
        Object[] objArr;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.c.length != 0) {
            int iL2 = l(this.d + this.b);
            int i = this.b;
            if (i < iL2) {
                iL = i;
                while (true) {
                    objArr = this.c;
                    if (i >= iL2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.c[iL] = obj;
                        iL++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(objArr, iL, iL2, (Object) null);
            } else {
                int length = this.c.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.c;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.c[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iL = l(i2);
                for (int i3 = 0; i3 < iL2; i3++) {
                    Object[] objArr3 = this.c;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.c[iL] = obj3;
                        iL = i(iL);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                m();
                this.d = j(iL - this.b);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(ak.i(i, i2, "index: ", ", size: "));
        }
        int iL = l(this.b + i);
        Object[] objArr = this.c;
        Object obj2 = objArr[iL];
        objArr[iL] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.d]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.d;
        if (length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        int iL = l(this.d + this.b);
        int i2 = this.b;
        if (i2 < iL) {
            ae.z0(this.c, 0, objArr, i2, iL);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.c;
            ae.z0(objArr2, 0, objArr, this.b, objArr2.length);
            Object[] objArr3 = this.c;
            ae.z0(objArr3, objArr3.length - this.b, objArr, 0, iL);
        }
        int i3 = this.d;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
