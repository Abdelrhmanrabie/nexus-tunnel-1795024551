package defpackage;

import com.android.volley.toolbox.ByteArrayPool$1;
import com.android.volley.toolbox.HurlStack;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yd {
    public static final ByteArrayPool$1 BUF_COMPARATOR = new ByteArrayPool$1();
    public final Object a;
    public int b;
    public int c;
    public final Object d;

    public yd() {
        this.a = new ArrayList();
        this.d = new ArrayList(64);
        this.b = 0;
        this.c = 4096;
    }

    public yd(int i, ArrayList arrayList, int i2, HurlStack.UrlConnectionInputStream urlConnectionInputStream) {
        this.c = i;
        this.d = arrayList;
        this.b = i2;
        this.a = urlConnectionInputStream;
    }

    public yd(byte[] bArr, OutputStream outputStream) {
        this.d = outputStream;
        this.a = bArr;
        this.c = 0;
        this.b = bArr.length;
    }

    public static int a(int i, int i2) {
        return c(i2) + h(i);
    }

    public static int b(int i, int i2) {
        return c(i2) + h(i);
    }

    public static int c(int i) {
        if (i >= 0) {
            return f(i);
        }
        return 10;
    }

    public static int d(int i, b0 b0Var) {
        int iH = h(i);
        int serializedSize = b0Var.getSerializedSize();
        return f(serializedSize) + serializedSize + iH;
    }

    public static int f(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int g(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int h(int i) {
        return f(i << 3);
    }

    public static yd j(OutputStream outputStream, int i) {
        return new yd(new byte[i], outputStream);
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < ((ArrayList) this.d).size(); i2++) {
            byte[] bArr = (byte[]) ((ArrayList) this.d).get(i2);
            if (bArr.length >= i) {
                this.b -= bArr.length;
                ((ArrayList) this.d).remove(i2);
                ((ArrayList) this.a).remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public void i() throws IOException {
        k();
    }

    public void k() throws IOException {
        ((OutputStream) this.d).write((byte[]) this.a, 0, this.c);
        this.c = 0;
    }

    public void l(int i, int i2) throws IOException {
        x(i, 0);
        n(i2);
    }

    public void m(int i, int i2) throws IOException {
        x(i, 0);
        n(i2);
    }

    public void n(int i) throws IOException {
        if (i >= 0) {
            v(i);
        } else {
            w(i);
        }
    }

    public void o(int i, b0 b0Var) throws IOException {
        x(i, 2);
        p(b0Var);
    }

    public void p(b0 b0Var) throws IOException {
        v(b0Var.getSerializedSize());
        b0Var.a(this);
    }

    public void q(int i) throws IOException {
        byte b = (byte) i;
        if (this.c == this.b) {
            k();
        }
        int i2 = this.c;
        this.c = i2 + 1;
        ((byte[]) this.a)[i2] = b;
    }

    public void r(fa faVar) throws IOException {
        int size = faVar.size();
        int i = this.c;
        int i2 = this.b;
        int i3 = i2 - i;
        byte[] bArr = (byte[]) this.a;
        if (i3 >= size) {
            faVar.e(bArr, 0, i, size);
            this.c += size;
            return;
        }
        faVar.e(bArr, 0, i, i3);
        int i4 = size - i3;
        this.c = i2;
        k();
        if (i4 <= i2) {
            faVar.e(bArr, i3, 0, i4);
            this.c = i4;
        } else {
            if (i3 < 0) {
                throw new IndexOutOfBoundsException(ak.f(30, i3, "Source offset < 0: "));
            }
            if (i4 < 0) {
                throw new IndexOutOfBoundsException(ak.f(23, i4, "Length < 0: "));
            }
            int i5 = i3 + i4;
            if (i5 > faVar.size()) {
                throw new IndexOutOfBoundsException(ak.f(39, i5, "Source end offset exceeded: "));
            }
            if (i4 > 0) {
                faVar.q((OutputStream) this.d, i3, i4);
            }
        }
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.c) {
                ((ArrayList) this.a).add(bArr);
                int iBinarySearch = Collections.binarySearch((ArrayList) this.d, bArr, BUF_COMPARATOR);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                ((ArrayList) this.d).add(iBinarySearch, bArr);
                this.b += bArr.length;
                trim();
            }
        }
    }

    public void s(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = this.c;
        int i2 = this.b;
        int i3 = i2 - i;
        byte[] bArr2 = (byte[]) this.a;
        if (i3 >= length) {
            System.arraycopy(bArr, 0, bArr2, i, length);
            this.c += length;
            return;
        }
        System.arraycopy(bArr, 0, bArr2, i, i3);
        int i4 = length - i3;
        this.c = i2;
        k();
        if (i4 > i2) {
            ((OutputStream) this.d).write(bArr, i3, i4);
        } else {
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            this.c = i4;
        }
    }

    public void t(int i) throws IOException {
        q(i & 255);
        q((i >> 8) & 255);
        q((i >> 16) & 255);
        q((i >> 24) & 255);
    }

    public synchronized void trim() {
        while (this.b > this.c) {
            byte[] bArr = (byte[]) ((ArrayList) this.a).remove(0);
            ((ArrayList) this.d).remove(bArr);
            this.b -= bArr.length;
        }
    }

    public void u(long j) throws IOException {
        q(((int) j) & 255);
        q(((int) (j >> 8)) & 255);
        q(((int) (j >> 16)) & 255);
        q(((int) (j >> 24)) & 255);
        q(((int) (j >> 32)) & 255);
        q(((int) (j >> 40)) & 255);
        q(((int) (j >> 48)) & 255);
        q(((int) (j >> 56)) & 255);
    }

    public void v(int i) throws IOException {
        while ((i & (-128)) != 0) {
            q((i & 127) | 128);
            i >>>= 7;
        }
        q(i);
    }

    public void w(long j) throws IOException {
        while (((-128) & j) != 0) {
            q((((int) j) & 127) | 128);
            j >>>= 7;
        }
        q((int) j);
    }

    public void x(int i, int i2) throws IOException {
        v((i << 3) | i2);
    }
}
