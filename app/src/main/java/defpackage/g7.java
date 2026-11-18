package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g7 implements Collection, Set {
    public static final int[] g = new int[0];
    public static final Object[] i = new Object[0];
    public static Object[] j;
    public static int n;
    public static Object[] o;
    public static int p;
    public int[] b;
    public Object[] c;
    public int d;
    public c7 f;

    public g7(int i2) {
        if (i2 == 0) {
            this.b = g;
            this.c = i;
        } else {
            b(i2);
        }
        this.d = 0;
    }

    public static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g7.class) {
                try {
                    if (p < 10) {
                        objArr[0] = o;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        o = objArr;
                        p++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g7.class) {
                try {
                    if (n < 10) {
                        objArr[0] = j;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        j = objArr;
                        n++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i2;
        int iE;
        if (obj == null) {
            iE = g();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iE = e(iHashCode, obj);
        }
        if (iE >= 0) {
            return false;
        }
        int i3 = ~iE;
        int i4 = this.d;
        int[] iArr = this.b;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.c;
            b(i5);
            int[] iArr2 = this.b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            d(iArr, objArr, this.d);
        }
        int i6 = this.d;
        if (i3 < i6) {
            int[] iArr3 = this.b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i3, objArr2, i7, this.d - i3);
        }
        this.b[i3] = i2;
        this.c[i3] = obj;
        this.d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.d;
        int[] iArr = this.b;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.c;
            b(size);
            int i2 = this.d;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, this.d);
            }
            d(iArr, objArr, this.d);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final void b(int i2) {
        if (i2 == 8) {
            synchronized (g7.class) {
                try {
                    Object[] objArr = o;
                    if (objArr != null) {
                        this.c = objArr;
                        o = (Object[]) objArr[0];
                        this.b = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        p--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 == 4) {
            synchronized (g7.class) {
                try {
                    Object[] objArr2 = j;
                    if (objArr2 != null) {
                        this.c = objArr2;
                        j = (Object[]) objArr2[0];
                        this.b = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        n--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i2 = this.d;
        if (i2 != 0) {
            d(this.b, this.c, i2);
            this.b = g;
            this.c = i;
            this.d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? g() : e(obj.hashCode(), obj)) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int e(int i2, Object obj) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int iD = e.d(i3, i2, this.b);
        if (iD < 0 || obj.equals(this.c[iD])) {
            return iD;
        }
        int i4 = iD + 1;
        while (i4 < i3 && this.b[i4] == i2) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iD - 1; i5 >= 0 && this.b[i5] == i2; i5--) {
            if (obj.equals(this.c[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.d == set.size()) {
                for (int i2 = 0; i2 < this.d; i2++) {
                    try {
                        if (set.contains(this.c[i2])) {
                        }
                    } catch (ClassCastException | NullPointerException unused) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int g() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int iD = e.d(i2, 0, this.b);
        if (iD < 0 || this.c[iD] == null) {
            return iD;
        }
        int i3 = iD + 1;
        while (i3 < i2 && this.b[i3] == 0) {
            if (this.c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iD - 1; i4 >= 0 && this.b[i4] == 0; i4--) {
            if (this.c[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void h(int i2) {
        Object[] objArr = this.c;
        Object obj = objArr[i2];
        int i3 = this.d;
        int[] iArr = this.b;
        if (i3 <= 1) {
            d(iArr, objArr, i3);
            this.b = g;
            this.c = i;
            this.d = 0;
            return;
        }
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            int i4 = i3 - 1;
            this.d = i4;
            if (i2 < i4) {
                int i5 = i2 + 1;
                System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                Object[] objArr2 = this.c;
                System.arraycopy(objArr2, i5, objArr2, i2, this.d - i2);
            }
            this.c[this.d] = null;
            return;
        }
        b(i3 > 8 ? i3 + (i3 >> 1) : 8);
        this.d--;
        if (i2 > 0) {
            System.arraycopy(iArr, 0, this.b, 0, i2);
            System.arraycopy(objArr, 0, this.c, 0, i2);
        }
        int i6 = this.d;
        if (i2 < i6) {
            int i7 = i2 + 1;
            System.arraycopy(iArr, i7, this.b, i2, i6 - i2);
            System.arraycopy(objArr, i7, this.c, i2, this.d - i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.b;
        int i2 = this.d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f == null) {
            this.f = new c7(1, this);
        }
        c7 c7Var = this.f;
        if (((dg0.b) c7Var.b) == null) {
            c7Var.b = new dg0.b(c7Var, 1);
        }
        return ((dg0.b) c7Var.b).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iG = obj == null ? g() : e(obj.hashCode(), obj);
        if (iG < 0) {
            return false;
        }
        h(iG);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i2 = this.d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.d;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i2 = this.d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.d);
        }
        System.arraycopy(this.c, 0, objArr, 0, this.d);
        int length = objArr.length;
        int i2 = this.d;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.c[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
