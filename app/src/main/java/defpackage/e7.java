package defpackage;

import java.util.ArrayList;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class e7 {
    public final b7 d;
    public q11 a = null;
    public float b = 0.0f;
    public final ArrayList c = new ArrayList();
    public boolean e = false;

    public e7(m6 m6Var) {
        this.d = new b7(this, m6Var);
    }

    public q11 a(boolean[] zArr) {
        return f(zArr, null);
    }

    public final void c(q11 q11Var, q11 q11Var2, q11 q11Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        b7 b7Var = this.d;
        if (z) {
            b7Var.k(q11Var, 1.0f);
            b7Var.k(q11Var2, -1.0f);
            b7Var.k(q11Var3, -1.0f);
        } else {
            b7Var.k(q11Var, -1.0f);
            b7Var.k(q11Var2, 1.0f);
            b7Var.k(q11Var3, 1.0f);
        }
    }

    public final void d(q11 q11Var, q11 q11Var2, q11 q11Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        b7 b7Var = this.d;
        if (z) {
            b7Var.k(q11Var, 1.0f);
            b7Var.k(q11Var2, -1.0f);
            b7Var.k(q11Var3, 1.0f);
        } else {
            b7Var.k(q11Var, -1.0f);
            b7Var.k(q11Var2, 1.0f);
            b7Var.k(q11Var3, -1.0f);
        }
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.a == 0;
    }

    public final q11 f(boolean[] zArr, q11 q11Var) {
        int i;
        b7 b7Var = this.d;
        int i2 = b7Var.a;
        q11 q11Var2 = null;
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            float fH = b7Var.h(i3);
            if (fH < 0.0f) {
                q11 q11VarB = b7Var.b(i3);
                if ((zArr == null || !zArr[q11VarB.c]) && q11VarB != q11Var && (((i = q11VarB.o) == 3 || i == 4) && fH < f)) {
                    f = fH;
                    q11Var2 = q11VarB;
                }
            }
        }
        return q11Var2;
    }

    public final void g(q11 q11Var) {
        q11 q11Var2 = this.a;
        b7 b7Var = this.d;
        if (q11Var2 != null) {
            b7Var.k(q11Var2, -1.0f);
            this.a.d = -1;
            this.a = null;
        }
        float fI = b7Var.i(q11Var, true) * (-1.0f);
        this.a = q11Var;
        if (fI == 1.0f) {
            return;
        }
        this.b /= fI;
        int i = b7Var.h;
        for (int i2 = 0; i != -1 && i2 < b7Var.a; i2++) {
            float[] fArr = b7Var.g;
            fArr[i] = fArr[i] / fI;
            i = b7Var.f[i];
        }
    }

    public final void h(oe0 oe0Var, q11 q11Var, boolean z) {
        if (q11Var.i) {
            b7 b7Var = this.d;
            float fE = b7Var.e(q11Var);
            this.b = (q11Var.g * fE) + this.b;
            b7Var.i(q11Var, z);
            if (z) {
                q11Var.b(this);
            }
            if (b7Var.a == 0) {
                this.e = true;
                oe0Var.a = true;
            }
        }
    }

    public void i(oe0 oe0Var, e7 e7Var, boolean z) {
        b7 b7Var = this.d;
        b7Var.getClass();
        float fE = b7Var.e(e7Var.a);
        b7Var.i(e7Var.a, z);
        b7 b7Var2 = e7Var.d;
        int i = b7Var2.a;
        for (int i2 = 0; i2 < i; i2++) {
            q11 q11VarB = b7Var2.b(i2);
            b7Var.g(q11VarB, b7Var2.e(q11VarB) * fE, z);
        }
        this.b = (e7Var.b * fE) + this.b;
        if (z) {
            e7Var.a.b(this);
        }
        if (this.a == null || b7Var.a != 0) {
            return;
        }
        this.e = true;
        oe0Var.a = true;
    }

    public String toString() {
        boolean z;
        StringBuilder sbD;
        String str;
        StringBuilder sb;
        String strJ = ak.j(this.a == null ? "0" : AppConfig.CUSTOM + this.a, " = ");
        if (this.b != 0.0f) {
            StringBuilder sbD2 = e.d(strJ);
            sbD2.append(this.b);
            strJ = sbD2.toString();
            z = true;
        } else {
            z = false;
        }
        b7 b7Var = this.d;
        int i = b7Var.a;
        for (int i2 = 0; i2 < i; i2++) {
            q11 q11VarB = b7Var.b(i2);
            if (q11VarB != null) {
                float fH = b7Var.h(i2);
                if (fH != 0.0f) {
                    String string = q11VarB.toString();
                    if (z) {
                        sbD = e.d(strJ);
                        if (fH > 0.0f) {
                            sbD.append(" + ");
                            strJ = sbD.toString();
                        } else {
                            str = " - ";
                            sbD.append(str);
                            strJ = sbD.toString();
                            fH *= -1.0f;
                        }
                    } else if (fH < 0.0f) {
                        sbD = e.d(strJ);
                        str = "- ";
                        sbD.append(str);
                        strJ = sbD.toString();
                        fH *= -1.0f;
                    }
                    if (fH == 1.0f) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        sb.append(strJ);
                        sb.append(fH);
                        strJ = " ";
                    }
                    strJ = fb$1.m(sb, strJ, string);
                    z = true;
                }
            }
        }
        return !z ? ak.j(strJ, "0.0") : strJ;
    }
}
