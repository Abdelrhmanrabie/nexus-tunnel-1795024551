package defpackage;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class n11 extends AbstractList implements RandomAccess {
    public int b;
    public Object c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator {
        public static final a b = new a(0);
        public final /* synthetic */ int G0;

        public /* synthetic */ a(int i) {
            this.G0 = i;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.G0 != 0) {
                throw new NoSuchElementException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.G0 == 0) {
                throw new IllegalStateException();
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Iterator {
        public boolean b;
        public final int c;

        public b() {
            this.c = ((AbstractList) n11.this).modCount;
        }

        public final void a() {
            n11 n11Var = n11.this;
            int i = ((AbstractList) n11Var).modCount;
            int i2 = this.c;
            if (i == i2) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) n11Var).modCount + "; expected: " + i2);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.b;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.b) {
                throw new NoSuchElementException();
            }
            this.b = true;
            a();
            return n11.this.c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            a();
            n11.this.clear();
        }
    }

    public static /* synthetic */ void b(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        if (i < 0 || i > (i2 = this.b)) {
            StringBuilder sbN = ak.n(i, "Index: ", ", Size: ");
            sbN.append(this.b);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        if (i2 == 0) {
            this.c = obj;
        } else if (i2 == 1 && i == 0) {
            this.c = new Object[]{obj, this.c};
        } else {
            Object[] objArr = new Object[i2 + 1];
            Object obj2 = this.c;
            if (i2 == 1) {
                objArr[0] = obj2;
            } else {
                Object[] objArr2 = (Object[]) obj2;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.b - i);
            }
            objArr[i] = obj;
            this.c = objArr;
        }
        this.b++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        int i = this.b;
        if (i == 0) {
            this.c = obj;
        } else {
            Object obj2 = this.c;
            if (i == 1) {
                this.c = new Object[]{obj2, obj};
            } else {
                Object[] objArr = (Object[]) obj2;
                int length = objArr.length;
                if (i >= length) {
                    int i2 = ((length * 3) / 2) + 1;
                    int i3 = i + 1;
                    if (i2 < i3) {
                        i2 = i3;
                    }
                    Object[] objArr2 = new Object[i2];
                    this.c = objArr2;
                    System.arraycopy(objArr, 0, objArr2, 0, length);
                    objArr = objArr2;
                }
                objArr[this.b] = obj;
            }
        }
        this.b++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.c = null;
        this.b = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.b)) {
            Object obj = this.c;
            return i2 == 1 ? obj : ((Object[]) obj)[i];
        }
        StringBuilder sbN = ak.n(i, "Index: ", ", Size: ");
        sbN.append(this.b);
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        int i = this.b;
        if (i == 0) {
            return a.b;
        }
        if (i == 1) {
            return new b();
        }
        Iterator it = super.iterator();
        if (it != null) {
            return it;
        }
        b(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.b)) {
            StringBuilder sbN = ak.n(i, "Index: ", ", Size: ");
            sbN.append(this.b);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        Object obj = this.c;
        if (i2 == 1) {
            this.c = null;
        } else {
            Object[] objArr = (Object[]) obj;
            Object obj2 = objArr[i];
            if (i2 == 2) {
                this.c = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.b - 1] = null;
            }
            obj = obj2;
        }
        this.b--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2;
        if (i < 0 || i >= (i2 = this.b)) {
            StringBuilder sbN = ak.n(i, "Index: ", ", Size: ");
            sbN.append(this.b);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        Object obj2 = this.c;
        if (i2 == 1) {
            this.c = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) obj2;
        Object obj3 = objArr[i];
        objArr[i] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            b(4);
            throw null;
        }
        int length = objArr.length;
        int i = this.b;
        if (i == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.c;
                return objArr2;
            }
            objArr[0] = this.c;
        } else {
            if (length < i) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.c, i, objArr.getClass());
                if (objArrCopyOf != null) {
                    return objArrCopyOf;
                }
                b(6);
                throw null;
            }
            if (i != 0) {
                System.arraycopy(this.c, 0, objArr, 0, i);
            }
        }
        int i2 = this.b;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
