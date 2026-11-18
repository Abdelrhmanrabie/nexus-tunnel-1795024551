package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ay implements sy0 {
    public final lw a;
    public final nw b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator, w90 {
        public Object b;
        public final Object d;
        public final /* synthetic */ int G0 = 0;
        public int c = -2;

        public a(ay ayVar) {
            this.d = ayVar;
        }

        public a(ge geVar) {
            this.d = ((sy0) geVar.a).iterator();
        }

        public final void a() {
            if (this.G0 == 0) {
                int i = this.c;
                ay ayVar = (ay) this.d;
                Object objInvoke = i == -2 ? ayVar.a.invoke() : ayVar.b.invoke(this.b);
                this.b = objInvoke;
                this.c = objInvoke != null ? 1 : 0;
                return;
            }
            Iterator it = (Iterator) this.d;
            if (it.hasNext()) {
                Object next = it.next();
                if (((Boolean) ba.b$5.invoke(next)).booleanValue()) {
                    this.c = 1;
                    this.b = next;
                    return;
                }
            }
            this.c = 0;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i = this.G0;
            int i2 = this.c;
            if (i != 0) {
                if (i2 == -1) {
                    a();
                }
                if (this.c != 1) {
                    return false;
                }
            } else {
                if (i2 < 0) {
                    a();
                }
                if (this.c != 1) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object obj;
            int i = this.G0;
            int i2 = this.c;
            if (i != 0) {
                if (i2 == -1) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                obj = this.b;
                this.b = null;
            } else {
                if (i2 < 0) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                obj = this.b;
            }
            this.c = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.G0 == 0) {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ay(lw lwVar, nw nwVar) {
        this.a = lwVar;
        this.b = nwVar;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return new a(this);
    }
}
