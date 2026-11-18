package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class dg0 {
    public final /* synthetic */ int G0 = 0;
    public Object a;
    public Object b;
    public Object c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator {
        public final int b;
        public int c;
        public int d;
        public boolean f = false;

        public a(int i) {
            this.b = i;
            this.c = dg0.this.d();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.d < this.c;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = dg0.this.b(this.d, this.b);
            this.d++;
            this.f = true;
            return objB;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f) {
                throw new IllegalStateException();
            }
            int i = this.d - 1;
            this.d = i;
            this.c--;
            this.f = false;
            dg0.this.h(i);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Set {
        public final /* synthetic */ int G0;
        public final /* synthetic */ dg0 b;

        public /* synthetic */ b(dg0 dg0Var, int i) {
            this.G0 = i;
            this.b = dg0Var;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            if (this.G0 != 0) {
                throw new UnsupportedOperationException();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection collection) {
            if (this.G0 != 0) {
                throw new UnsupportedOperationException();
            }
            dg0 dg0Var = this.b;
            int iD = dg0Var.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                dg0Var.g(entry.getKey(), entry.getValue());
            }
            return iD != dg0Var.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            this.b.mo12a();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (this.G0 != 0) {
                if (this.b.e(obj) < 0) {
                    return false;
                }
            } else {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                dg0 dg0Var = this.b;
                int iE = dg0Var.e(key);
                if (iE < 0) {
                    return false;
                }
                Object objB = dg0Var.b(iE, 1);
                Object value = entry.getValue();
                if (objB != value && (objB == null || !objB.equals(value))) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection collection) {
            if (this.G0 == 0) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Map mapC = this.b.c();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!mapC.containsKey(it2.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return dg0.j(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i = this.G0;
            dg0 dg0Var = this.b;
            if (i != 0) {
                int iHashCode = 0;
                for (int iD = dg0Var.d() - 1; iD >= 0; iD--) {
                    Object objB = dg0Var.b(iD, 0);
                    iHashCode += objB == null ? 0 : objB.hashCode();
                }
                return iHashCode;
            }
            int iHashCode2 = 0;
            for (int iD2 = dg0Var.d() - 1; iD2 >= 0; iD2--) {
                Object objB2 = dg0Var.b(iD2, 0);
                Object objB3 = dg0Var.b(iD2, 1);
                iHashCode2 += (objB2 == null ? 0 : objB2.hashCode()) ^ (objB3 == null ? 0 : objB3.hashCode());
            }
            return iHashCode2;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            int i = this.G0;
            dg0 dg0Var = this.b;
            if (i != 0) {
                return dg0Var.d() == 0;
            }
            return dg0Var.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            int i = this.G0;
            dg0 dg0Var = this.b;
            return i != 0 ? dg0Var.new a(0) : dg0Var.new d();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            if (this.G0 == 0) {
                throw new UnsupportedOperationException();
            }
            dg0 dg0Var = this.b;
            int iE = dg0Var.e(obj);
            if (iE < 0) {
                return false;
            }
            dg0Var.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection collection) {
            if (this.G0 == 0) {
                throw new UnsupportedOperationException();
            }
            Map mapC = this.b.c();
            int size = mapC.size();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                mapC.remove(it.next());
            }
            return size != mapC.size();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection collection) {
            if (this.G0 != 0) {
                return dg0.k(this.b.c(), collection);
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            int i = this.G0;
            dg0 dg0Var = this.b;
            return i != 0 ? dg0Var.d() : dg0Var.d();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            if (this.G0 == 0) {
                throw new UnsupportedOperationException();
            }
            dg0 dg0Var = this.b;
            int iD = dg0Var.d();
            Object[] objArr = new Object[iD];
            for (int i = 0; i < iD; i++) {
                objArr[i] = dg0Var.b(i, 0);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            if (this.G0 != 0) {
                return this.b.l(0, objArr);
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d implements Iterator, Map.Entry {
        public int b;
        public boolean d = false;
        public int c = -1;

        public d() {
            this.b = dg0.this.d() - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Object value;
            Object objB;
            if (!this.d) {
                defpackage.d.AnonymousClass0.m("This container does not support retaining Map.Entry objects");
                return false;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i = this.c;
                dg0 dg0Var = dg0.this;
                Object objB2 = dg0Var.b(i, 0);
                if ((key == objB2 || (key != null && key.equals(objB2))) && ((value = entry.getValue()) == (objB = dg0Var.b(this.c, 1)) || (value != null && value.equals(objB)))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            if (this.d) {
                return dg0.this.b(this.c, 0);
            }
            defpackage.d.AnonymousClass0.m("This container does not support retaining Map.Entry objects");
            return null;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            if (this.d) {
                return dg0.this.b(this.c, 1);
            }
            defpackage.d.AnonymousClass0.m("This container does not support retaining Map.Entry objects");
            return null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.d) {
                defpackage.d.AnonymousClass0.m("This container does not support retaining Map.Entry objects");
                return 0;
            }
            int i = this.c;
            dg0 dg0Var = dg0.this;
            Object objB = dg0Var.b(i, 0);
            Object objB2 = dg0Var.b(this.c, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c++;
            this.d = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            dg0.this.h(this.c);
            this.c--;
            this.b--;
            this.d = false;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (this.d) {
                return dg0.this.i(this.c, obj);
            }
            defpackage.d.AnonymousClass0.m("This container does not support retaining Map.Entry objects");
            return null;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e implements Collection {
        public e() {
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            dg0.this.mo12a();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return dg0.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return dg0.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return dg0.this.new a(1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            dg0 dg0Var = dg0.this;
            int iF = dg0Var.f(obj);
            if (iF < 0) {
                return false;
            }
            dg0Var.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            dg0 dg0Var = dg0.this;
            int iD = dg0Var.d();
            int i = 0;
            boolean z = false;
            while (i < iD) {
                if (collection.contains(dg0Var.b(i, 1))) {
                    dg0Var.h(i);
                    i--;
                    iD--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            dg0 dg0Var = dg0.this;
            int iD = dg0Var.d();
            int i = 0;
            boolean z = false;
            while (i < iD) {
                if (!collection.contains(dg0Var.b(i, 1))) {
                    dg0Var.h(i);
                    i--;
                    iD--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return dg0.this.d();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            dg0 dg0Var = dg0.this;
            int iD = dg0Var.d();
            Object[] objArr = new Object[iD];
            for (int i = 0; i < iD; i++) {
                objArr[i] = dg0Var.b(i, 1);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return dg0.this.l(1, objArr);
        }
    }

    public /* synthetic */ dg0() {
    }

    public dg0(jj0 jj0Var, fi0 fi0Var, t11 t11Var) {
        this.a = jj0Var;
        this.b = fi0Var;
        this.c = t11Var;
    }

    public static boolean j(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean k(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract cv a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract void mo12a();

    public abstract Object b(int i, int i2);

    public abstract Map c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(Object obj, Object obj2);

    public abstract void h(int i);

    public abstract Object i(int i, Object obj);

    public Object[] l(int i, Object[] objArr) {
        int iD = d();
        if (objArr.length < iD) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iD);
        }
        for (int i2 = 0; i2 < iD; i2++) {
            objArr[i2] = b(i2, i);
        }
        if (objArr.length > iD) {
            objArr[iD] = null;
        }
        return objArr;
    }

    public String toString() {
        if (this.G0 != 1) {
            return super.toString();
        }
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
