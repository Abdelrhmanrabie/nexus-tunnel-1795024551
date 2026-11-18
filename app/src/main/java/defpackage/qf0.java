package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qf0 implements Cloneable {
    public static final Object g = new Object();
    public boolean b = false;
    public long[] c;
    public Object[] d;
    public int f;

    public qf0() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.c = new long[i4];
        this.d = new Object[i4];
    }

    public final void a(long j, Long l) {
        int i = this.f;
        if (i != 0 && j <= this.c[i - 1]) {
            g(j, l);
            return;
        }
        if (this.b && i >= this.c.length) {
            e();
        }
        int i2 = this.f;
        if (i2 >= this.c.length) {
            int i3 = (i2 + 1) * 8;
            for (int i4 = 4; i4 < 32; i4++) {
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
            }
            int i6 = i3 / 8;
            long[] jArr = new long[i6];
            Object[] objArr = new Object[i6];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i2] = j;
        this.d[i2] = l;
        this.f = i2 + 1;
    }

    public final void c() {
        int i = this.f;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final qf0 clone() {
        try {
            qf0 qf0Var = (qf0) super.clone();
            qf0Var.c = (long[]) this.c.clone();
            qf0Var.d = (Object[]) this.d.clone();
            return qf0Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void e() {
        int i = this.f;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != g) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f = i2;
    }

    public final Object f(long j, Long l) {
        Object obj;
        int iE = e.e(this.c, this.f, j);
        return (iE < 0 || (obj = this.d[iE]) == g) ? l : obj;
    }

    public final void g(long j, Object obj) {
        int iE = e.e(this.c, this.f, j);
        if (iE >= 0) {
            this.d[iE] = obj;
            return;
        }
        int i = ~iE;
        int i2 = this.f;
        if (i < i2) {
            Object[] objArr = this.d;
            if (objArr[i] == g) {
                this.c[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.b && i2 >= this.c.length) {
            e();
            i = ~e.e(this.c, this.f, j);
        }
        int i3 = this.f;
        if (i3 >= this.c.length) {
            int i4 = (i3 + 1) * 8;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 8;
            long[] jArr = new long[i7];
            Object[] objArr2 = new Object[i7];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.d = objArr2;
        }
        int i8 = this.f - i;
        if (i8 != 0) {
            long[] jArr3 = this.c;
            int i9 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i9, i8);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i9, this.f - i);
        }
        this.c[i] = j;
        this.d[i] = obj;
        this.f++;
    }

    public final Object h(int i) {
        if (this.b) {
            e();
        }
        return this.d[i];
    }

    public final String toString() {
        if (this.b) {
            e();
        }
        int i = this.f;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.b) {
                e();
            }
            sb.append(this.c[i2]);
            sb.append('=');
            Object objH = h(i2);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
