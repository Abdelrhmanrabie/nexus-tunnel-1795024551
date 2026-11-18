package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xp0 extends e7 {
    public q11[] f;
    public int h;
    public final g i;

    public xp0(m6 m6Var) {
        super(m6Var);
        this.f = new q11[128];
        this.h = 0;
        this.i = new g(this);
    }

    @Override // defpackage.e7
    public final q11 a(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.h; i2++) {
            q11[] q11VarArr = this.f;
            q11 q11Var = q11VarArr[i2];
            if (!zArr[q11Var.c]) {
                g gVar = this.i;
                gVar.a = q11Var;
                int i3 = 8;
                if (i != -1) {
                    q11 q11Var2 = q11VarArr[i];
                    while (i3 >= 0) {
                        float f = q11Var2.n[i3];
                        float f2 = ((q11) gVar.a).n[i3];
                        if (f2 != f) {
                            if (f2 >= f) {
                                break;
                            }
                            i = i2;
                            break;
                            break;
                        }
                        i3--;
                    }
                } else {
                    while (i3 >= 0) {
                        float f3 = ((q11) gVar.a).n[i3];
                        if (f3 > 0.0f) {
                            break;
                        }
                        if (f3 < 0.0f) {
                            i = i2;
                            break;
                        }
                        i3--;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // defpackage.e7
    public final boolean e() {
        return this.h == 0;
    }

    @Override // defpackage.e7
    public final void i(oe0 oe0Var, e7 e7Var, boolean z) {
        q11 q11Var = e7Var.a;
        if (q11Var == null) {
            return;
        }
        b7 b7Var = e7Var.d;
        int i = b7Var.a;
        for (int i2 = 0; i2 < i; i2++) {
            q11 q11VarB = b7Var.b(i2);
            float fH = b7Var.h(i2);
            g gVar = this.i;
            gVar.a = q11VarB;
            boolean z2 = q11VarB.b;
            float[] fArr = q11Var.n;
            if (z2) {
                boolean z3 = true;
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr2 = ((q11) gVar.a).n;
                    float f = (fArr[i3] * fH) + fArr2[i3];
                    fArr2[i3] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        ((q11) gVar.a).n[i3] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    ((xp0) gVar.b).k((q11) gVar.a);
                }
            } else {
                for (int i4 = 0; i4 < 9; i4++) {
                    float f2 = fArr[i4];
                    if (f2 != 0.0f) {
                        float f3 = f2 * fH;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        ((q11) gVar.a).n[i4] = f3;
                    } else {
                        ((q11) gVar.a).n[i4] = 0.0f;
                    }
                }
                j(q11VarB);
            }
            this.b = (e7Var.b * fH) + this.b;
        }
        k(q11Var);
    }

    public final void j(q11 q11Var) {
        int i = this.h + 1;
        q11[] q11VarArr = this.f;
        if (i > q11VarArr.length) {
            q11[] q11VarArr2 = (q11[]) Arrays.copyOf(q11VarArr, q11VarArr.length * 2);
            this.f = q11VarArr2;
        }
        q11[] q11VarArr3 = this.f;
        int i2 = this.h;
        q11VarArr3[i2] = q11Var;
        this.h = i2 + 1;
        q11Var.b = true;
        q11Var.a(this);
    }

    public final void k(q11 q11Var) {
        int i = 0;
        while (i < this.h) {
            if (this.f[i] == q11Var) {
                while (true) {
                    int i2 = this.h - 1;
                    if (i >= i2) {
                        this.h = i2;
                        q11Var.b = false;
                        return;
                    } else {
                        q11[] q11VarArr = this.f;
                        int i3 = i + 1;
                        q11VarArr[i] = q11VarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.e7
    public final String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.h; i++) {
            q11 q11Var = this.f[i];
            g gVar = this.i;
            gVar.a = q11Var;
            str = str + gVar + " ";
        }
        return str;
    }
}
