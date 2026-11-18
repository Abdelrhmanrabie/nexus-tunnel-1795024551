package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class jx0 implements Iterable {
    public c b;
    public c c;
    public final WeakHashMap d = new WeakHashMap();
    public int f = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends f implements Iterator {
        public final /* synthetic */ int G0;
        public c b;
        public c c;

        public a(c cVar, c cVar2, int i) {
            this.G0 = i;
            this.b = cVar2;
            this.c = cVar;
        }

        @Override // jx0.f
        public final void a(c cVar) {
            c cVarC = null;
            if (this.b == cVar && cVar == this.c) {
                this.c = null;
                this.b = null;
            }
            c cVar2 = this.b;
            if (cVar2 == cVar) {
                this.b = this.G0 != 0 ? cVar2.d : cVar2.f;
            }
            c cVar3 = this.c;
            if (cVar3 == cVar) {
                c cVar4 = this.b;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarC = c(cVar3);
                }
                this.c = cVarC;
            }
        }

        public final c c(c cVar) {
            return this.G0 != 0 ? cVar.f : cVar.d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c cVar = this.c;
            c cVar2 = this.b;
            this.c = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements Map.Entry {
        public final Object b;
        public final Object c;
        public c d;
        public c f;

        public c(Object obj, Object obj2) {
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.c.equals(cVar.c);
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends f implements Iterator {
        public c b;
        public boolean c = true;

        public d() {
        }

        @Override // jx0.f
        public final void a(c cVar) {
            c cVar2 = this.b;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f;
                this.b = cVar3;
                this.c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.c) {
                return jx0.this.b != null;
            }
            c cVar = this.b;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c cVar;
            if (this.c) {
                this.c = false;
                cVar = jx0.this.b;
            } else {
                c cVar2 = this.b;
                cVar = cVar2 != null ? cVar2.d : null;
            }
            this.b = cVar;
            return cVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class f {
        public abstract void a(c cVar);
    }

    public c b(Object obj) {
        c cVar = this.b;
        while (cVar != null && !cVar.b.equals(obj)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    public Object d(Object obj, Object obj2) {
        c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.c;
        }
        c cVar = new c(obj, obj2);
        this.f++;
        c cVar2 = this.c;
        if (cVar2 == null) {
            this.b = cVar;
        } else {
            cVar2.d = cVar;
            cVar.f = cVar2;
        }
        this.c = cVar;
        return null;
    }

    public Object e(Object obj) {
        c cVarB = b(obj);
        if (cVarB == null) {
            return null;
        }
        this.f--;
        WeakHashMap weakHashMap = this.d;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarB);
            }
        }
        c cVar = cVarB.f;
        c cVar2 = cVarB.d;
        if (cVar != null) {
            cVar.d = cVar2;
        } else {
            this.b = cVar2;
        }
        c cVar3 = cVarB.d;
        if (cVar3 != null) {
            cVar3.f = cVar;
        } else {
            this.c = cVar;
        }
        cVarB.d = null;
        cVarB.f = null;
        return cVarB.c;
    }

    public final boolean equals(Object obj) {
        a aVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jx0)) {
            return false;
        }
        jx0 jx0Var = (jx0) obj;
        if (this.f != jx0Var.f) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = jx0Var.iterator();
        while (true) {
            aVar = (a) it;
            if (!aVar.hasNext()) {
                break;
            }
            a aVar2 = (a) it2;
            if (!aVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) aVar.next();
            Object next = aVar2.next();
            if (entry == null && next != null) {
                return false;
            }
            if (entry != null && !entry.equals(next)) {
                return false;
            }
        }
        return (aVar.hasNext() || ((a) it2).hasNext()) ? false : true;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) aVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        a aVar = new a(this.b, this.c, 0);
        this.d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) aVar.next()).toString());
            if (aVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
