package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zf0 implements Map, Serializable, w90 {
    public static final zf0 t;
    public Object[] b;
    public Object[] c;
    public int[] d;
    public int[] f;
    public int g;
    public int i;
    public int j;
    public int n;
    public int o;
    public ag0 p;
    public cg0 q;
    public ag0 r;
    public boolean s;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends j51 implements Iterator, w90 {
        public final /* synthetic */ int G0;

        public b(zf0 zf0Var, int i) {
            this.G0 = i;
            this.b = zf0Var;
            this.c = -1;
            this.d = zf0Var.n;
            b$1();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object obj;
            int i = this.G0;
            a();
            int i2 = this.a;
            if (i == 0) {
                zf0 zf0Var = (zf0) this.b;
                if (i2 >= zf0Var.i) {
                    throw new NoSuchElementException();
                }
                this.a = i2 + 1;
                this.c = i2;
                c cVar = new c(zf0Var, i2);
                b$1();
                return cVar;
            }
            zf0 zf0Var2 = (zf0) this.b;
            if (i != 1) {
                if (i2 >= zf0Var2.i) {
                    throw new NoSuchElementException();
                }
                this.a = i2 + 1;
                this.c = i2;
                obj = zf0Var2.c[i2];
            } else {
                if (i2 >= zf0Var2.i) {
                    throw new NoSuchElementException();
                }
                this.a = i2 + 1;
                this.c = i2;
                obj = zf0Var2.b[i2];
            }
            b$1();
            return obj;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements Map.Entry, w90 {
        public final zf0 b;
        public final int c;
        public final int d;

        public c(zf0 zf0Var, int i) {
            this.b = zf0Var;
            this.c = i;
            this.d = zf0Var.n;
        }

        public final void a() {
            if (this.b.n != this.d) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return e4.a(entry.getKey(), getKey()) && e4.a(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            a();
            return this.b.b[this.c];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            a();
            return this.b.c[this.c];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            a();
            zf0 zf0Var = this.b;
            zf0Var.b$1();
            Object[] objArrU0 = zf0Var.c;
            if (objArrU0 == null) {
                objArrU0 = e.u0(zf0Var.b.length);
                zf0Var.c = objArrU0;
            }
            int i = this.c;
            Object obj2 = objArrU0[i];
            objArrU0[i] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    static {
        zf0 zf0Var = new zf0(0);
        zf0Var.s = true;
        t = zf0Var;
    }

    public zf0(int i) {
        Object[] objArrU0 = e.u0(i);
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.b = objArrU0;
        this.c = null;
        this.d = iArr;
        this.f = new int[iHighestOneBit];
        this.g = 2;
        this.i = 0;
        this.j = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        b$1();
        while (true) {
            int iK = k(obj);
            int i = this.g * 2;
            int length = this.f.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.f;
                int i3 = iArr[iK];
                if (i3 <= 0) {
                    int i4 = this.i;
                    Object[] objArr = this.b;
                    if (i4 >= objArr.length) {
                        i(1);
                        break;
                    }
                    int i5 = i4 + 1;
                    this.i = i5;
                    objArr[i4] = obj;
                    this.d[i4] = iK;
                    iArr[iK] = i5;
                    this.o++;
                    this.n++;
                    if (i2 > this.g) {
                        this.g = i2;
                    }
                    return i4;
                }
                if (e4.a(this.b[i3 - 1], obj)) {
                    return -i3;
                }
                i2++;
                if (i2 > i) {
                    l(this.f.length * 2);
                    break;
                }
                iK = iK == 0 ? this.f.length - 1 : iK - 1;
            }
        }
    }

    public final void b$1() {
        if (this.s) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        b$1();
        int i = this.i - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.d;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.f[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        e.k1(0, this.i, this.b);
        Object[] objArr = this.c;
        if (objArr != null) {
            e.k1(0, this.i, objArr);
        }
        this.o = 0;
        this.i = 0;
        this.n++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return j(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int i;
        int i2 = this.i;
        while (true) {
            i = -1;
            i2--;
            if (i2 >= 0) {
                if (this.d[i2] >= 0 && e4.a(this.c[i2], obj)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        return i >= 0;
    }

    public final void e(boolean z) {
        int i;
        Object[] objArr = this.c;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.i;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.d;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.b;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.f[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        e.k1(i3, i, this.b);
        if (objArr != null) {
            e.k1(i3, this.i, objArr);
        }
        this.i = i3;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        ag0 ag0Var = this.r;
        if (ag0Var != null) {
            return ag0Var;
        }
        ag0 ag0Var2 = new ag0(this, 0);
        this.r = ag0Var2;
        return ag0Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean z;
        Map.Entry entry;
        int iJ;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.o == map.size()) {
                    Iterator it = map.entrySet().iterator();
                    do {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (next == null) {
                                break;
                            }
                            try {
                                entry = (Map.Entry) next;
                                iJ = j(entry.getKey());
                            } catch (ClassCastException unused) {
                            }
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    } while (iJ < 0 ? false : e4.a(this.c[iJ], entry.getValue()));
                    z = false;
                    if (z) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iJ = j(obj);
        if (iJ < 0) {
            return null;
        }
        return this.c[iJ];
    }

    @Override // java.util.Map
    public final int hashCode() {
        b bVar = new b(this, 0);
        int i = 0;
        while (bVar.hasNext()) {
            int i2 = bVar.a;
            zf0 zf0Var = (zf0) bVar.b;
            if (i2 >= zf0Var.i) {
                throw new NoSuchElementException();
            }
            bVar.a = i2 + 1;
            bVar.c = i2;
            Object obj = zf0Var.b[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object obj2 = zf0Var.c[bVar.c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            bVar.b$1();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final void i(int i) {
        Object[] objArr = this.b;
        int length = objArr.length;
        int i2 = this.i;
        int i3 = length - i2;
        int i4 = i2 - this.o;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            e(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.b = Arrays.copyOf(objArr, i6);
            Object[] objArr2 = this.c;
            this.c = objArr2 != null ? Arrays.copyOf(objArr2, i6) : null;
            this.d = Arrays.copyOf(this.d, i6);
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.f.length) {
                l(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.o == 0;
    }

    public final int j(Object obj) {
        int iK = k(obj);
        int i = this.g;
        while (true) {
            int i2 = this.f[iK];
            if (i2 == 0) {
                break;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (e4.a(this.b[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                break;
            }
            iK = iK == 0 ? this.f.length - 1 : iK - 1;
        }
        return -1;
    }

    public final int k(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.j;
    }

    @Override // java.util.Map
    public final Set keySet() {
        ag0 ag0Var = this.p;
        if (ag0Var != null) {
            return ag0Var;
        }
        ag0 ag0Var2 = new ag0(this, 1);
        this.p = ag0Var2;
        return ag0Var2;
    }

    public final void l(int i) {
        int[] iArr;
        this.n++;
        int i2 = 0;
        if (this.i > this.o) {
            e(false);
        }
        this.f = new int[i];
        this.j = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.i) {
            int i3 = i2 + 1;
            int iK = k(this.b[i2]);
            int i4 = this.g;
            while (true) {
                iArr = this.f;
                if (iArr[iK] == 0) {
                    break;
                }
                i4--;
                if (i4 < 0) {
                    d.AnonymousClass0.m("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                    return;
                }
                iK = iK == 0 ? iArr.length - 1 : iK - 1;
            }
            iArr[iK] = i3;
            this.d[i2] = iK;
            i2 = i3;
        }
    }

    public final void m(int i) {
        this.b[i] = null;
        Object[] objArr = this.c;
        if (objArr != null) {
            objArr[i] = null;
        }
        int length = this.d[i];
        int i2 = this.g * 2;
        int length2 = this.f.length / 2;
        if (i2 > length2) {
            i2 = length2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = length;
        do {
            length = length == 0 ? this.f.length - 1 : length - 1;
            i4++;
            int i6 = this.g;
            int[] iArr = this.f;
            if (i4 > i6) {
                iArr[i5] = 0;
            } else {
                int i7 = iArr[length];
                if (i7 == 0) {
                    iArr[i5] = 0;
                } else {
                    if (i7 < 0) {
                        iArr[i5] = -1;
                    } else {
                        int i8 = i7 - 1;
                        int iK = k(this.b[i8]) - length;
                        int[] iArr2 = this.f;
                        if ((iK & (iArr2.length - 1)) >= i4) {
                            iArr2[i5] = i7;
                            this.d[i8] = i5;
                        }
                        i3--;
                    }
                    i5 = length;
                    i4 = 0;
                    i3--;
                }
            }
            this.d[i] = -1;
            this.o--;
            this.n++;
        } while (i3 >= 0);
        this.f[i5] = -1;
        this.d[i] = -1;
        this.o--;
        this.n++;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b$1();
        int iA = a(obj);
        Object[] objArrU0 = this.c;
        if (objArrU0 == null) {
            objArrU0 = e.u0(this.b.length);
            this.c = objArrU0;
        }
        if (iA >= 0) {
            objArrU0[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArrU0[i];
        objArrU0[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b$1();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        i(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArrU0 = this.c;
            if (objArrU0 == null) {
                objArrU0 = e.u0(this.b.length);
                this.c = objArrU0;
            }
            if (iA >= 0) {
                objArrU0[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!e4.a(entry.getValue(), objArrU0[i])) {
                    objArrU0[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b$1();
        int iJ = j(obj);
        if (iJ < 0) {
            return null;
        }
        Object obj2 = this.c[iJ];
        m(iJ);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.o;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.o * 3) + 2);
        sb.append("{");
        int i = 0;
        b bVar = new b(this, 0);
        while (bVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = bVar.a;
            zf0 zf0Var = (zf0) bVar.b;
            if (i2 >= zf0Var.i) {
                throw new NoSuchElementException();
            }
            bVar.a = i2 + 1;
            bVar.c = i2;
            Object obj = zf0Var.b[i2];
            if (obj == zf0Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object obj2 = zf0Var.c[bVar.c];
            if (obj2 == zf0Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            bVar.b$1();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        cg0 cg0Var = this.q;
        if (cg0Var != null) {
            return cg0Var;
        }
        cg0 cg0Var2 = new cg0(this);
        this.q = cg0Var2;
        return cg0Var2;
    }
}
