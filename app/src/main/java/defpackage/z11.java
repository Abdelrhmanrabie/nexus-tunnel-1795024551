package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z11 implements Cloneable {
    public static final Object g = new Object();
    public boolean b = false;
    public int[] c;
    public Object[] d;
    public int f;

    public z11() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.c = new int[i4];
        this.d = new Object[i4];
    }

    public final void a(int i, Object obj) {
        int i2 = this.f;
        if (i2 != 0 && i <= this.c[i2 - 1]) {
            f(i, obj);
            return;
        }
        if (this.b && i2 >= this.c.length) {
            d();
        }
        int i3 = this.f;
        if (i3 >= this.c.length) {
            int i4 = (i3 + 1) * 4;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 4;
            int[] iArr = new int[i7];
            Object[] objArr = new Object[i7];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i3] = i;
        this.d[i3] = obj;
        this.f = i3 + 1;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final z11 clone() {
        try {
            z11 z11Var = (z11) super.clone();
            z11Var.c = (int[]) this.c.clone();
            z11Var.d = (Object[]) this.d.clone();
            return z11Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void d() {
        int i = this.f;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != g) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f = i2;
    }

    public final Object e(int i, Integer num) {
        Object obj;
        int iD = e.d(this.f, i, this.c);
        return (iD < 0 || (obj = this.d[iD]) == g) ? num : obj;
    }

    public final void f(int i, Object obj) {
        int iD = e.d(this.f, i, this.c);
        if (iD >= 0) {
            this.d[iD] = obj;
            return;
        }
        int i2 = ~iD;
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.d;
            if (objArr[i2] == g) {
                this.c[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.b && i3 >= this.c.length) {
            d();
            i2 = ~e.d(this.f, i, this.c);
        }
        int i4 = this.f;
        if (i4 >= this.c.length) {
            int i5 = (i4 + 1) * 4;
            for (int i6 = 4; i6 < 32; i6++) {
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
            }
            int i8 = i5 / 4;
            int[] iArr = new int[i8];
            Object[] objArr2 = new Object[i8];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.d = objArr2;
        }
        int i9 = this.f - i2;
        if (i9 != 0) {
            int[] iArr3 = this.c;
            int i10 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i10, i9);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i10, this.f - i2);
        }
        this.c[i2] = i;
        this.d[i2] = obj;
        this.f++;
    }

    public final int g() {
        if (this.b) {
            d();
        }
        return this.f;
    }

    public final Object h(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.b) {
                d();
            }
            sb.append(this.c[i]);
            sb.append('=');
            Object objH = h(i);
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
