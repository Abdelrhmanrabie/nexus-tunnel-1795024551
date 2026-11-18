package defpackage;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class oe0 {
    public static boolean p = false;
    public static int q = 1000;
    public final xp0 c;
    public e7[] f;
    public final m6 l;
    public e7 o;
    public boolean a = false;
    public int b = 0;
    public int d = 32;
    public int e = 32;
    public boolean g = false;
    public boolean[] h = new boolean[32];
    public int i = 1;
    public int j = 0;
    public int k = 32;
    public q11[] m = new q11[q];
    public int n = 0;

    public oe0() {
        this.f = null;
        this.f = new e7[32];
        t();
        m6 m6Var = new m6(1);
        this.l = m6Var;
        this.c = new xp0(m6Var);
        this.o = new e7(m6Var);
    }

    public static int o(vg vgVar) {
        q11 q11Var = vgVar.i;
        if (q11Var != null) {
            return (int) (q11Var.g + 0.5f);
        }
        return 0;
    }

    public final q11 a(int i) {
        gp0 gp0Var = (gp0) this.l.b;
        int i2 = gp0Var.b;
        Object obj = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = gp0Var.a;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            gp0Var.b = i3;
            obj = obj2;
        }
        q11 q11Var = (q11) obj;
        if (q11Var == null) {
            q11Var = new q11(i);
        } else {
            q11Var.c();
        }
        q11Var.o = i;
        int i4 = this.n;
        int i5 = q;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            q = i6;
            this.m = (q11[]) Arrays.copyOf(this.m, i6);
        }
        q11[] q11VarArr = this.m;
        int i7 = this.n;
        this.n = i7 + 1;
        q11VarArr[i7] = q11Var;
        return q11Var;
    }

    public final void b(q11 q11Var, q11 q11Var2, int i, float f, q11 q11Var3, q11 q11Var4, int i2, int i3) {
        int i4;
        float f2;
        e7 e7VarM = m();
        b7 b7Var = e7VarM.d;
        if (q11Var2 == q11Var3) {
            b7Var.k(q11Var, 1.0f);
            b7Var.k(q11Var4, 1.0f);
            b7Var.k(q11Var2, -2.0f);
        } else if (f == 0.5f) {
            b7Var.k(q11Var, 1.0f);
            b7Var.k(q11Var2, -1.0f);
            b7Var.k(q11Var3, -1.0f);
            b7Var.k(q11Var4, 1.0f);
            if (i > 0 || i2 > 0) {
                i4 = (-i) + i2;
                f2 = i4;
                e7VarM.b = f2;
            }
        } else if (f <= 0.0f) {
            b7Var.k(q11Var, -1.0f);
            b7Var.k(q11Var2, 1.0f);
            f2 = i;
            e7VarM.b = f2;
        } else if (f >= 1.0f) {
            b7Var.k(q11Var4, -1.0f);
            b7Var.k(q11Var3, 1.0f);
            i4 = -i2;
            f2 = i4;
            e7VarM.b = f2;
        } else {
            float f3 = 1.0f - f;
            b7Var.k(q11Var, f3 * 1.0f);
            b7Var.k(q11Var2, f3 * (-1.0f));
            b7Var.k(q11Var3, f * (-1.0f));
            b7Var.k(q11Var4, f * 1.0f);
            if (i > 0 || i2 > 0) {
                e7VarM.b = (i2 * f) + ((-i) * f3);
            }
        }
        if (i3 != 8) {
            b7Var.k(k(i3), 1.0f);
            b7Var.k(k(i3), -1.0f);
        }
        c(e7VarM);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0198  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ed  */
    public final void c(e7 e7Var) {
        boolean z;
        boolean z2;
        q11 q11VarF;
        ArrayList arrayList;
        if (this.j + 1 >= this.k || this.i + 1 >= this.e) {
            p();
        }
        boolean z3 = e7Var.e;
        b7 b7Var = e7Var.d;
        if (z3) {
            z = false;
        } else {
            if (this.f.length != 0) {
                boolean z4 = false;
                while (!z4) {
                    int i = b7Var.a;
                    int i2 = 0;
                    while (true) {
                        arrayList = e7Var.c;
                        if (i2 >= i) {
                            break;
                        }
                        q11 q11VarB = b7Var.b(i2);
                        if (q11VarB.d != -1 || q11VarB.i) {
                            arrayList.add(q11VarB);
                        }
                        i2++;
                    }
                    int size = arrayList.size();
                    if (size > 0) {
                        for (int i3 = 0; i3 < size; i3++) {
                            q11 q11Var = (q11) arrayList.get(i3);
                            if (q11Var.i) {
                                e7Var.h(this, q11Var, true);
                            } else {
                                e7Var.i(this, this.f[q11Var.d], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z4 = true;
                    }
                }
                if (e7Var.a != null && b7Var.a == 0) {
                    e7Var.e = true;
                    this.a = true;
                }
            }
            if (e7Var.e()) {
                return;
            }
            float f = e7Var.b;
            float f2 = 0.0f;
            if (f < 0.0f) {
                e7Var.b = f * (-1.0f);
                int i4 = b7Var.h;
                for (int i5 = 0; i4 != -1 && i5 < b7Var.a; i5++) {
                    float[] fArr = b7Var.g;
                    fArr[i4] = fArr[i4] * (-1.0f);
                    i4 = b7Var.f[i4];
                }
            }
            int i6 = b7Var.a;
            float f3 = 0.0f;
            float f4 = 0.0f;
            q11 q11Var2 = null;
            q11 q11Var3 = null;
            int i7 = 0;
            boolean z5 = false;
            boolean z6 = false;
            while (i7 < i6) {
                float fH = b7Var.h(i7);
                q11 q11VarB2 = b7Var.b(i7);
                float f5 = f2;
                if (q11VarB2.o == 1) {
                    if (q11Var2 == null) {
                        if (q11VarB2.r <= 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        q11Var2 = q11VarB2;
                        f3 = fH;
                    } else {
                        if (f3 > fH) {
                            if (q11VarB2.r > 1) {
                                z5 = false;
                            }
                            q11Var2 = q11VarB2;
                            f3 = fH;
                        } else if (z5 || q11VarB2.r > 1) {
                        }
                        z5 = true;
                        q11Var2 = q11VarB2;
                        f3 = fH;
                    }
                } else if (q11Var2 == null && fH < f5) {
                    if (q11Var3 == null) {
                        if (q11VarB2.r <= 1) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        q11Var3 = q11VarB2;
                        f4 = fH;
                    } else {
                        if (f4 > fH) {
                            if (q11VarB2.r > 1) {
                                z6 = false;
                            }
                            q11Var3 = q11VarB2;
                            f4 = fH;
                        } else if (z6 || q11VarB2.r > 1) {
                        }
                        z6 = true;
                        q11Var3 = q11VarB2;
                        f4 = fH;
                    }
                }
                i7++;
                f2 = f5;
            }
            float f6 = f2;
            if (q11Var2 == null) {
                q11Var2 = q11Var3;
            }
            if (q11Var2 == null) {
                z2 = true;
            } else {
                e7Var.g(q11Var2);
                z2 = false;
            }
            if (b7Var.a == 0) {
                e7Var.e = true;
            }
            if (z2) {
                if (this.i + 1 >= this.e) {
                    p();
                }
                q11 q11VarA = a(3);
                int i8 = this.b + 1;
                this.b = i8;
                this.i++;
                q11VarA.c = i8;
                m6 m6Var = this.l;
                ((q11[]) m6Var.c)[i8] = q11VarA;
                e7Var.a = q11VarA;
                int i9 = this.j;
                i(e7Var);
                if (this.j == i9 + 1) {
                    e7 e7Var2 = this.o;
                    e7Var2.getClass();
                    b7 b7Var2 = e7Var2.d;
                    e7Var2.a = null;
                    b7Var2.clear();
                    for (int i10 = 0; i10 < b7Var.a; i10++) {
                        b7Var2.g(b7Var.b(i10), b7Var.h(i10), true);
                    }
                    s(this.o);
                    if (q11VarA.d == -1) {
                        if (e7Var.a == q11VarA && (q11VarF = e7Var.f(null, q11VarA)) != null) {
                            e7Var.g(q11VarF);
                        }
                        if (!e7Var.e) {
                            e7Var.a.f(this, e7Var);
                        }
                        gp0 gp0Var = (gp0) m6Var.a;
                        int i11 = gp0Var.b;
                        Object[] objArr = gp0Var.a;
                        if (i11 < objArr.length) {
                            objArr[i11] = e7Var;
                            gp0Var.b = i11 + 1;
                        }
                        this.j--;
                    }
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            q11 q11Var4 = e7Var.a;
            if (q11Var4 == null) {
                return;
            }
            if (q11Var4.o != 1 && e7Var.b < f6) {
                return;
            }
        }
        if (z) {
            return;
        }
        i(e7Var);
    }

    public final void d(q11 q11Var, int i) {
        e7 e7VarM;
        float f;
        int i2 = q11Var.d;
        if (i2 == -1) {
            q11Var.d(this, i);
            for (int i3 = 0; i3 < this.b + 1; i3++) {
                q11 q11Var2 = ((q11[]) this.l.c)[i3];
            }
            return;
        }
        if (i2 != -1) {
            e7 e7Var = this.f[i2];
            if (!e7Var.e) {
                if (e7Var.d.a == 0) {
                    e7Var.e = true;
                } else {
                    e7VarM = m();
                    if (i < 0) {
                        e7VarM.b = i * (-1);
                        f = 1.0f;
                    } else {
                        e7VarM.b = i;
                        f = -1.0f;
                    }
                    e7VarM.d.k(q11Var, f);
                }
            }
            e7Var.b = i;
            return;
        }
        e7VarM = m();
        e7VarM.a = q11Var;
        float f2 = i;
        q11Var.g = f2;
        e7VarM.b = f2;
        e7VarM.e = true;
        c(e7VarM);
    }

    public final void e(q11 q11Var, q11 q11Var2, int i, int i2) {
        if (i2 == 8 && q11Var2.i && q11Var.d == -1) {
            q11Var.d(this, q11Var2.g + i);
            return;
        }
        e7 e7VarM = m();
        b7 b7Var = e7VarM.d;
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            e7VarM.b = i;
        }
        if (z) {
            b7Var.k(q11Var, 1.0f);
            b7Var.k(q11Var2, -1.0f);
        } else {
            b7Var.k(q11Var, -1.0f);
            b7Var.k(q11Var2, 1.0f);
        }
        if (i2 != 8) {
            b7Var.k(k(i2), 1.0f);
            b7Var.k(k(i2), -1.0f);
        }
        c(e7VarM);
    }

    public final void f(q11 q11Var, q11 q11Var2, int i, int i2) {
        e7 e7VarM = m();
        b7 b7Var = e7VarM.d;
        q11 q11VarN = n();
        q11VarN.f = 0;
        e7VarM.c(q11Var, q11Var2, q11VarN, i);
        if (i2 != 8) {
            b7Var.k(k(i2), (int) (b7Var.e(q11VarN) * (-1.0f)));
        }
        c(e7VarM);
    }

    public final void g(q11 q11Var, q11 q11Var2, int i, int i2) {
        e7 e7VarM = m();
        b7 b7Var = e7VarM.d;
        q11 q11VarN = n();
        q11VarN.f = 0;
        e7VarM.d(q11Var, q11Var2, q11VarN, i);
        if (i2 != 8) {
            b7Var.k(k(i2), (int) (b7Var.e(q11VarN) * (-1.0f)));
        }
        c(e7VarM);
    }

    public final void i(e7 e7Var) {
        int i;
        if (e7Var.e) {
            e7Var.a.d(this, e7Var.b);
        } else {
            e7[] e7VarArr = this.f;
            int i2 = this.j;
            e7VarArr[i2] = e7Var;
            q11 q11Var = e7Var.a;
            q11Var.d = i2;
            this.j = i2 + 1;
            q11Var.f(this, e7Var);
        }
        if (this.a) {
            int i3 = 0;
            while (i3 < this.j) {
                if (this.f[i3] == null) {
                    System.out.println("WTF");
                }
                e7 e7Var2 = this.f[i3];
                if (e7Var2 != null && e7Var2.e) {
                    e7Var2.a.d(this, e7Var2.b);
                    gp0 gp0Var = (gp0) this.l.a;
                    int i4 = gp0Var.b;
                    Object[] objArr = gp0Var.a;
                    if (i4 < objArr.length) {
                        objArr[i4] = e7Var2;
                        gp0Var.b = i4 + 1;
                    }
                    this.f[i3] = null;
                    int i5 = i3 + 1;
                    int i6 = i5;
                    while (true) {
                        i = this.j;
                        if (i5 >= i) {
                            break;
                        }
                        e7[] e7VarArr2 = this.f;
                        int i7 = i5 - 1;
                        e7 e7Var3 = e7VarArr2[i5];
                        e7VarArr2[i7] = e7Var3;
                        q11 q11Var2 = e7Var3.a;
                        if (q11Var2.d == i5) {
                            q11Var2.d = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i) {
                        this.f[i6] = null;
                    }
                    this.j = i - 1;
                    i3--;
                }
                i3++;
            }
            this.a = false;
        }
    }

    public final void j() {
        for (int i = 0; i < this.j; i++) {
            e7 e7Var = this.f[i];
            e7Var.a.g = e7Var.b;
        }
    }

    public final q11 k(int i) {
        if (this.i + 1 >= this.e) {
            p();
        }
        q11 q11VarA = a(4);
        int i2 = this.b + 1;
        this.b = i2;
        this.i++;
        q11VarA.c = i2;
        q11VarA.f = i;
        ((q11[]) this.l.c)[i2] = q11VarA;
        xp0 xp0Var = this.c;
        xp0Var.i.a = q11VarA;
        float[] fArr = q11VarA.n;
        Arrays.fill(fArr, 0.0f);
        fArr[q11VarA.f] = 1.0f;
        xp0Var.j(q11VarA);
        return q11VarA;
    }

    public final q11 l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.e) {
            p();
        }
        if (!(obj instanceof vg)) {
            return null;
        }
        vg vgVar = (vg) obj;
        q11 q11Var = vgVar.i;
        if (q11Var == null) {
            vgVar.h();
            q11Var = vgVar.i;
        }
        int i = q11Var.c;
        m6 m6Var = this.l;
        if (i != -1 && i <= this.b && ((q11[]) m6Var.c)[i] != null) {
            return q11Var;
        }
        if (i != -1) {
            q11Var.c();
        }
        int i2 = this.b + 1;
        this.b = i2;
        this.i++;
        q11Var.c = i2;
        q11Var.o = 1;
        ((q11[]) m6Var.c)[i2] = q11Var;
        return q11Var;
    }

    public final e7 m() {
        Object obj;
        m6 m6Var = this.l;
        gp0 gp0Var = (gp0) m6Var.a;
        int i = gp0Var.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = gp0Var.a;
            obj = objArr[i2];
            objArr[i2] = null;
            gp0Var.b = i2;
        } else {
            obj = null;
        }
        e7 e7Var = (e7) obj;
        if (e7Var == null) {
            return new e7(m6Var);
        }
        e7Var.a = null;
        e7Var.d.clear();
        e7Var.b = 0.0f;
        e7Var.e = false;
        return e7Var;
    }

    public final q11 n() {
        if (this.i + 1 >= this.e) {
            p();
        }
        q11 q11VarA = a(3);
        int i = this.b + 1;
        this.b = i;
        this.i++;
        q11VarA.c = i;
        ((q11[]) this.l.c)[i] = q11VarA;
        return q11VarA;
    }

    public final void p() {
        int i = this.d * 2;
        this.d = i;
        this.f = (e7[]) Arrays.copyOf(this.f, i);
        m6 m6Var = this.l;
        m6Var.c = (q11[]) Arrays.copyOf((q11[]) m6Var.c, this.d);
        int i2 = this.d;
        this.h = new boolean[i2];
        this.e = i2;
        this.k = i2;
    }

    public final void q() {
        xp0 xp0Var = this.c;
        if (xp0Var.e()) {
            j();
            return;
        }
        if (this.g) {
            int i = 0;
            while (true) {
                if (i >= this.j) {
                    j();
                    return;
                } else if (!this.f[i].e) {
                    break;
                } else {
                    i++;
                }
            }
        }
        for (int i2 = 0; i2 < this.j; i2++) {
            e7 e7Var = this.f[i2];
            int i3 = 1;
            if (e7Var.a.o != 1) {
                float f = 0.0f;
                if (e7Var.b < 0.0f) {
                    boolean z = false;
                    int i4 = 0;
                    while (!z) {
                        i4 += i3;
                        float f2 = Float.MAX_VALUE;
                        int i5 = -1;
                        int i6 = -1;
                        int i7 = 0;
                        int i8 = 0;
                        while (i7 < this.j) {
                            e7 e7Var2 = this.f[i7];
                            q11 q11Var = e7Var2.a;
                            b7 b7Var = e7Var2.d;
                            if (q11Var.o != i3 && !e7Var2.e && e7Var2.b < f) {
                                int i9 = b7Var.a;
                                int i10 = 0;
                                while (i10 < i9) {
                                    q11 q11VarB = b7Var.b(i10);
                                    float fE = b7Var.e(q11VarB);
                                    if (fE > f) {
                                        for (int i11 = 0; i11 < 9; i11++) {
                                            float f3 = q11VarB.j[i11] / fE;
                                            if ((f3 < f2 && i11 == i8) || i11 > i8) {
                                                i8 = i11;
                                                i6 = q11VarB.c;
                                                i5 = i7;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i10++;
                                    f = 0.0f;
                                }
                            }
                            i7++;
                            f = 0.0f;
                            i3 = 1;
                        }
                        if (i5 != -1) {
                            e7 e7Var3 = this.f[i5];
                            e7Var3.a.d = -1;
                            e7Var3.g(((q11[]) this.l.c)[i6]);
                            q11 q11Var2 = e7Var3.a;
                            q11Var2.d = i5;
                            q11Var2.f(this, e7Var3);
                        } else {
                            z = true;
                        }
                        if (i4 > this.i / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i3 = 1;
                    }
                    break;
                }
            }
        }
        s(xp0Var);
        j();
    }

    public final void s(e7 e7Var) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < this.i; i3++) {
            this.h[i3] = false;
        }
        boolean z = false;
        int i4 = 0;
        while (!z) {
            i4++;
            if (i4 >= this.i * 2) {
                return;
            }
            q11 q11Var = e7Var.a;
            if (q11Var != null) {
                this.h[q11Var.c] = true;
            }
            q11 q11VarA = e7Var.a(this.h);
            if (q11VarA != null) {
                boolean[] zArr = this.h;
                int i5 = q11VarA.c;
                if (zArr[i5]) {
                    return;
                } else {
                    zArr[i5] = true;
                }
            }
            if (q11VarA != null) {
                float f = Float.MAX_VALUE;
                int i6 = i2;
                int i7 = -1;
                while (i6 < this.j) {
                    e7 e7Var2 = this.f[i6];
                    q11 q11Var2 = e7Var2.a;
                    b7 b7Var = e7Var2.d;
                    if (q11Var2.o != 1 && !e7Var2.e && (i = b7Var.h) != -1) {
                        for (int i8 = i2; i != -1 && i8 < b7Var.a; i8++) {
                            if (b7Var.e[i] == q11VarA.c) {
                                float fE = b7Var.e(q11VarA);
                                if (fE >= 0.0f) {
                                    break;
                                }
                                float f2 = (-e7Var2.b) / fE;
                                if (f2 >= f) {
                                    break;
                                }
                                i7 = i6;
                                f = f2;
                                break;
                            }
                            i = b7Var.f[i];
                        }
                    }
                    i6++;
                    i2 = 0;
                }
                if (i7 > -1) {
                    e7 e7Var3 = this.f[i7];
                    e7Var3.a.d = -1;
                    e7Var3.g(q11VarA);
                    q11 q11Var3 = e7Var3.a;
                    q11Var3.d = i7;
                    q11Var3.f(this, e7Var3);
                }
                i2 = 0;
            } else {
                z = true;
            }
        }
    }

    public final void t() {
        for (int i = 0; i < this.j; i++) {
            e7[] e7VarArr = this.f;
            e7 e7Var = e7VarArr[i];
            if (e7Var != null) {
                gp0 gp0Var = (gp0) this.l.a;
                int i2 = gp0Var.b;
                Object[] objArr = gp0Var.a;
                if (i2 < objArr.length) {
                    objArr[i2] = e7Var;
                    gp0Var.b = i2 + 1;
                }
            }
            e7VarArr[i] = null;
        }
    }

    public final void u() {
        m6 m6Var;
        int i = 0;
        while (true) {
            m6Var = this.l;
            q11[] q11VarArr = (q11[]) m6Var.c;
            if (i >= q11VarArr.length) {
                break;
            }
            q11 q11Var = q11VarArr[i];
            if (q11Var != null) {
                q11Var.c();
            }
            i++;
        }
        gp0 gp0Var = (gp0) m6Var.b;
        q11[] q11VarArr2 = this.m;
        int length = this.n;
        if (length > q11VarArr2.length) {
            length = q11VarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            q11 q11Var2 = q11VarArr2[i2];
            int i3 = gp0Var.b;
            Object[] objArr = gp0Var.a;
            if (i3 < objArr.length) {
                objArr[i3] = q11Var2;
                gp0Var.b = i3 + 1;
            }
        }
        this.n = 0;
        Arrays.fill((q11[]) m6Var.c, (Object) null);
        this.b = 0;
        xp0 xp0Var = this.c;
        xp0Var.h = 0;
        xp0Var.b = 0.0f;
        this.i = 1;
        for (int i4 = 0; i4 < this.j; i4++) {
            e7 e7Var = this.f[i4];
        }
        t();
        this.j = 0;
        this.o = new e7(m6Var);
    }
}
