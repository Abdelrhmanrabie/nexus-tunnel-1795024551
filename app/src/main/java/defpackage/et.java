package defpackage;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class et implements sy0 {
    public final /* synthetic */ int G0 = 0;
    public final Object a;
    public final Object b;
    public final int c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a extends c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Iterator, w90 {
        public final /* synthetic */ int G0;
        public int b;
        public Object c;
        public Object d;
        public final /* synthetic */ sy0 f;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a extends a {
            public boolean b;
            public File[] c;
            public int d;
            public boolean e;

            @Override // et.c
            public final File a() {
                int i;
                boolean z = this.e;
                File file = this.a;
                if (!z && this.c == null) {
                    File[] fileArrListFiles = file.listFiles();
                    this.c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null && (i = this.d) < fileArr.length) {
                    this.d = i + 1;
                    return fileArr[i];
                }
                if (this.b) {
                    return null;
                }
                this.b = true;
                return file;
            }
        }

        /* JADX INFO: renamed from: et$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0032b extends c {
            public boolean b;

            @Override // et.c
            public final File a() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return this.a;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends a {
            public boolean b;
            public File[] c;
            public int d;

            @Override // et.c
            public final File a() {
                boolean z = this.b;
                File file = this.a;
                if (!z) {
                    this.b = true;
                    return file;
                }
                File[] fileArr = this.c;
                if (fileArr != null && this.d >= fileArr.length) {
                    return null;
                }
                if (fileArr == null) {
                    File[] fileArrListFiles = file.listFiles();
                    this.c = fileArrListFiles;
                    if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                        return null;
                    }
                }
                File[] fileArr2 = this.c;
                int i = this.d;
                this.d = i + 1;
                return fileArr2[i];
            }
        }

        public b(et etVar) {
            this.G0 = 0;
            this.f = etVar;
            ArrayDeque arrayDeque = new ArrayDeque();
            this.d = arrayDeque;
            File file = (File) etVar.a;
            if (file.isDirectory()) {
                arrayDeque.push(b(file));
            } else if (file.isFile()) {
                arrayDeque.push(new C0032b(file));
            } else {
                this.b = 2;
            }
        }

        public b(ht htVar) {
            this.G0 = 1;
            this.f = htVar;
            this.c = htVar.a.iterator();
            this.b = -1;
        }

        public b(yt ytVar) {
            this.G0 = 2;
            this.f = ytVar;
            this.c = ytVar.a.iterator();
        }

        public void a() {
            int i;
            Object next;
            ht htVar;
            do {
                Iterator it = (Iterator) this.c;
                if (it.hasNext()) {
                    next = it.next();
                    htVar = (ht) this.f;
                } else {
                    i = 0;
                }
                this.b = i;
            } while (((Boolean) htVar.c.invoke(next)).booleanValue() != htVar.b);
            this.d = next;
            i = 1;
            this.b = i;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m13a() {
            Iterator it;
            File file = null;
            if (this.G0 != 0) {
                Iterator it2 = (Iterator) this.d;
                if (it2 == null || !it2.hasNext()) {
                    do {
                        Iterator it3 = (Iterator) this.c;
                        if (!it3.hasNext()) {
                            this.b = 2;
                            this.d = null;
                            return false;
                        }
                        Object next = it3.next();
                        yt ytVar = (yt) this.f;
                        it = (Iterator) ytVar.c.invoke(ytVar.b.invoke(next));
                    } while (!it.hasNext());
                    this.d = it;
                }
                this.b = 1;
                return true;
            }
            this.b = 3;
            while (true) {
                ArrayDeque arrayDeque = (ArrayDeque) this.d;
                c cVar = (c) arrayDeque.peek();
                if (cVar == null) {
                    break;
                }
                File fileA = cVar.a();
                if (fileA == null) {
                    arrayDeque.pop();
                } else {
                    if (fileA.equals(cVar.a) || !fileA.isDirectory() || arrayDeque.size() >= ((et) this.f).c) {
                        file = fileA;
                        break;
                    }
                    arrayDeque.push(b(fileA));
                }
            }
            if (file != null) {
                this.c = file;
                this.b = 1;
            } else {
                this.b = 2;
            }
            return this.b == 1;
        }

        public a b(File file) {
            int iOrdinal = ((ft) ((et) this.f).b).ordinal();
            if (iOrdinal == 0) {
                return new c(file);
            }
            if (iOrdinal == 1) {
                return new a(file);
            }
            d.AnonymousClass0.m();
            return null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i = this.G0;
            int i2 = this.b;
            if (i == 0) {
                if (i2 == 0) {
                    return m13a();
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        d.AnonymousClass0.m$2("hasNext called when the iterator is in the FAILED state.");
                        return false;
                    }
                }
            }
            if (i != 1) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return m13a();
                    }
                }
            }
            if (i2 == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i = this.G0;
            int i2 = this.b;
            if (i == 0) {
                if (i2 != 1 && (i2 == 2 || !m13a())) {
                    throw new NoSuchElementException();
                }
                this.b = 0;
                return (File) this.c;
            }
            if (i != 1) {
                if (i2 == 2) {
                    throw new NoSuchElementException();
                }
                if (i2 == 0 && !m13a()) {
                    throw new NoSuchElementException();
                }
                this.b = 0;
                return ((Iterator) this.d).next();
            }
            if (i2 == -1) {
                a();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.d;
            this.d = null;
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = this.G0;
            if (i == 0) {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
            if (i == 1) {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c {
        public final File a;

        public c(File file) {
            this.a = file;
        }

        public abstract File a();
    }

    public et(File file) {
        ft ftVar = ft.b;
        this.a = file;
        this.b = ftVar;
        this.c = Integer.MAX_VALUE;
    }

    public et(CharSequence charSequence, int i, bx bxVar) {
        this.a = charSequence;
        this.c = i;
        this.b = bxVar;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return this.G0 != 0 ? new wl$a(this) : new b(this);
    }
}
