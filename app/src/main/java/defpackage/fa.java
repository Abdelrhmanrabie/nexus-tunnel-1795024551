package defpackage;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class fa implements Iterable {
    public static final we0 b = new we0(new byte[0]);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends OutputStream {
        public static final byte[] i = new byte[0];
        public int d;
        public int g;
        public final int b = 128;
        public final ArrayList c = new ArrayList();
        public byte[] f = new byte[128];

        public final void a(int i2) {
            this.c.add(new we0(this.f));
            int length = this.d + this.f.length;
            this.d = length;
            this.f = new byte[Math.max(this.b, Math.max(i2, length >>> 1))];
            this.g = 0;
        }

        public final void b() {
            int i2 = this.g;
            byte[] bArr = this.f;
            int length = bArr.length;
            ArrayList arrayList = this.c;
            if (i2 >= length) {
                arrayList.add(new we0(this.f));
                this.f = i;
            } else if (i2 > 0) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
                arrayList.add(new we0(bArr2));
            }
            this.d += this.g;
            this.g = 0;
        }

        public final synchronized fa c() {
            ArrayList arrayList;
            try {
                b();
                arrayList = this.c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add((fa) it.next());
                    }
                    arrayList = arrayList2;
                }
            } catch (Throwable th) {
                throw th;
            }
            return arrayList.isEmpty() ? fa.b : fa.b(arrayList.iterator(), arrayList.size());
        }

        public final String toString() {
            int i2;
            String hexString = Integer.toHexString(System.identityHashCode(this));
            synchronized (this) {
                i2 = this.d + this.g;
            }
            return String.format("<ByteString.Output@%s size=%d>", hexString, Integer.valueOf(i2));
        }

        @Override // java.io.OutputStream
        public final synchronized void write(int i2) {
            try {
                if (this.g == this.f.length) {
                    a(1);
                }
                byte[] bArr = this.f;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr[i3] = (byte) i2;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public final synchronized void write(byte[] bArr, int i2, int i3) {
            try {
                byte[] bArr2 = this.f;
                int length = bArr2.length;
                int i4 = this.g;
                if (i3 <= length - i4) {
                    System.arraycopy(bArr, i2, bArr2, i4, i3);
                    this.g += i3;
                } else {
                    int length2 = bArr2.length - i4;
                    System.arraycopy(bArr, i2, bArr2, i4, length2);
                    int i5 = i3 - length2;
                    a(i5);
                    System.arraycopy(bArr, i2 + length2, this.f, 0, i5);
                    this.g = i5;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static fa b(Iterator it, int i) {
        if (i == 1) {
            return (fa) it.next();
        }
        int i2 = i >>> 1;
        return b(it, i2).d(b(it, i - i2));
    }

    public static b l() {
        return new b();
    }

    public final fa d(fa faVar) {
        int size = size();
        int size2 = faVar.size();
        if (((long) size) + ((long) size2) >= 2147483647L) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
        int[] iArr = lw0.n;
        lw0 lw0Var = this instanceof lw0 ? (lw0) this : null;
        if (faVar.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return faVar;
        }
        int size3 = faVar.size() + size();
        if (size3 < 128) {
            int size4 = size();
            int size5 = faVar.size();
            byte[] bArr = new byte[size4 + size5];
            e(bArr, 0, 0, size4);
            faVar.e(bArr, 0, size4, size5);
            return new we0(bArr);
        }
        if (lw0Var != null) {
            fa faVar2 = lw0Var.f;
            if (faVar.size() + faVar2.size() < 128) {
                int size6 = faVar2.size();
                int size7 = faVar.size();
                byte[] bArr2 = new byte[size6 + size7];
                faVar2.e(bArr2, 0, 0, size6);
                faVar.e(bArr2, 0, size6, size7);
                return new lw0(lw0Var.d, new we0(bArr2));
            }
        }
        if (lw0Var != null) {
            fa faVar3 = lw0Var.d;
            int iH = faVar3.h();
            fa faVar4 = lw0Var.f;
            if (iH > faVar4.h()) {
                if (lw0Var.i > faVar.h()) {
                    return new lw0(faVar3, new lw0(faVar4, faVar));
                }
            }
        }
        if (size3 >= lw0.n[Math.max(h(), faVar.h()) + 1]) {
            return new lw0(this, faVar);
        }
        bj bjVar = new bj(22, (byte) 0);
        bjVar.a(this);
        bjVar.a(faVar);
        Stack stack = (Stack) bjVar.a;
        fa lw0Var2 = (fa) stack.pop();
        while (!stack.isEmpty()) {
            lw0Var2 = new lw0((fa) stack.pop(), lw0Var2);
        }
        return lw0Var2;
    }

    public final void e(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(ak.f(30, i, "Source offset < 0: "));
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(ak.f(30, i2, "Target offset < 0: "));
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(ak.f(23, i3, "Length < 0: "));
        }
        int i4 = i + i3;
        if (i4 > size()) {
            throw new IndexOutOfBoundsException(ak.f(34, i4, "Source end offset < 0: "));
        }
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            throw new IndexOutOfBoundsException(ak.f(34, i5, "Target end offset < 0: "));
        }
        if (i3 > 0) {
            g(bArr, i, i2, i3);
        }
    }

    public abstract void g(byte[] bArr, int i, int i2, int i3);

    public abstract int h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract int m(int i, int i2, int i3);

    public abstract int n(int i, int i2, int i3);

    public abstract int o();

    public abstract String p();

    public abstract void q(OutputStream outputStream, int i, int i2);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
