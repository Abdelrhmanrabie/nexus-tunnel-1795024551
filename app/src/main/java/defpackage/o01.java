package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class o01 {
    public static Object[] f;
    public static int g;
    public static Object[] i;
    public static int j;
    public int[] b = e.m;
    public Object[] c = e.f45n;
    public int d = 0;

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (o01.class) {
                try {
                    if (j < 10) {
                        objArr[0] = i;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        i = objArr;
                        j++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (o01.class) {
                try {
                    if (g < 10) {
                        objArr[0] = f;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f = objArr;
                        g++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (o01.class) {
                try {
                    Object[] objArr = i;
                    if (objArr != null) {
                        this.c = objArr;
                        i = (Object[]) objArr[0];
                        this.b = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        j--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 == 4) {
            synchronized (o01.class) {
                try {
                    Object[] objArr2 = f;
                    if (objArr2 != null) {
                        this.c = objArr2;
                        f = (Object[]) objArr2[0];
                        this.b = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        g--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2 << 1];
    }

    public final void b(int i2) {
        int i3 = this.d;
        int[] iArr = this.b;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            a(i2);
            if (this.d > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, i3 << 1);
            }
            c(iArr, objArr, i3);
        }
        if (this.d != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i2 = this.d;
        if (i2 > 0) {
            int[] iArr = this.b;
            Object[] objArr = this.c;
            this.b = e.m;
            this.c = e.f45n;
            this.d = 0;
            c(iArr, objArr, i2);
        }
        if (this.d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final int e(int i2, Object obj) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iD = e.d(i3, i2, this.b);
            if (iD < 0 || obj.equals(this.c[iD << 1])) {
                return iD;
            }
            int i4 = iD + 1;
            while (i4 < i3 && this.b[i4] == i2) {
                if (obj.equals(this.c[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iD - 1; i5 >= 0 && this.b[i5] == i2; i5--) {
                if (obj.equals(this.c[i5 << 1])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean equals(Object obj) {
        int i2;
        int i3;
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof o01) {
                o01 o01Var = (o01) obj;
                if (this.d == o01Var.d) {
                    for (0; i3 < this.d; i3 + 1) {
                        Object objI = i(i3);
                        Object objK = k(i3);
                        Object orDefault = o01Var.getOrDefault(objI, null);
                        if (objK == null) {
                            i3 = (orDefault == null && o01Var.containsKey(objI)) ? i3 + 1 : 0;
                        } else if (objK.equals(orDefault)) {
                        }
                    }
                    return true;
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.d == map.size()) {
                    for (0; i2 < this.d; i2 + 1) {
                        Object objI2 = i(i2);
                        Object objK2 = k(i2);
                        Object obj2 = map.get(objI2);
                        if (objK2 == null) {
                            i2 = (obj2 == null && map.containsKey(objI2)) ? i2 + 1 : 0;
                        } else if (objK2.equals(obj2)) {
                        }
                    }
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int f(Object obj) {
        return obj == null ? g() : e(obj.hashCode(), obj);
    }

    public final int g() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iD = e.d(i2, 0, this.b);
            if (iD < 0 || this.c[iD << 1] == null) {
                return iD;
            }
            int i3 = iD + 1;
            while (i3 < i2 && this.b[i3] == 0) {
                if (this.c[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iD - 1; i4 >= 0 && this.b[i4] == 0; i4--) {
                if (this.c[i4 << 1] == null) {
                    return i4;
                }
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iF = f(obj);
        return iF >= 0 ? this.c[(iF << 1) + 1] : obj2;
    }

    public final int h(Object obj) {
        int i2 = this.d * 2;
        Object[] objArr = this.c;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i2 = this.d;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i2) {
        return this.c[i2 << 1];
    }

    public final boolean isEmpty() {
        return this.d <= 0;
    }

    public final Object j(int i2) {
        Object[] objArr = this.c;
        int i3 = i2 << 1;
        Object obj = objArr[i3 + 1];
        int i4 = this.d;
        int[] iArr = this.b;
        int i5 = 0;
        if (i4 <= 1) {
            c(iArr, objArr, i4);
            this.b = e.m;
            this.c = e.f45n;
        } else {
            int i6 = i4 - 1;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.c;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.d) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.b, 0, i2);
                    System.arraycopy(objArr, 0, this.c, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.b, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.c, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.d) {
            throw new ConcurrentModificationException();
        }
        this.d = i5;
        return obj;
    }

    public final Object k(int i2) {
        return this.c[(i2 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i2;
        int iE;
        int i3 = this.d;
        if (obj == null) {
            iE = g();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iE = e(iHashCode, obj);
        }
        if (iE >= 0) {
            int i4 = (iE << 1) + 1;
            Object[] objArr = this.c;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~iE;
        int[] iArr = this.b;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.c;
            a(i6);
            if (i3 != this.d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.c, 0, objArr2.length);
            }
            c(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.b;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.d - i5) << 1);
        }
        int i8 = this.d;
        if (i3 == i8) {
            int[] iArr4 = this.b;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.c;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.d = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return j(iF);
        }
        return null;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objK = k(iF);
        if (obj2 != objK && (obj2 == null || !obj2.equals(objK))) {
            return false;
        }
        j(iF);
        return true;
    }

    public final Object replace(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        int i2 = (iF << 1) + 1;
        Object[] objArr = this.c;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        Object objK = k(iF);
        if (objK != obj2 && (obj2 == null || !obj2.equals(objK))) {
            return false;
        }
        int i2 = (iF << 1) + 1;
        Object[] objArr = this.c;
        Object obj4 = objArr[i2];
        objArr[i2] = obj3;
        return true;
    }

    public final int size() {
        return this.d;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objI = i(i2);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objK = k(i2);
            if (objK != this) {
                sb.append(objK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
