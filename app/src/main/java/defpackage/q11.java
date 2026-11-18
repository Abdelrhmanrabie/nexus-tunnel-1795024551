package defpackage;

import java.util.Arrays;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q11 implements Comparable {
    public boolean b;
    public float g;
    public int o;
    public int c = -1;
    public int d = -1;
    public int f = 0;
    public boolean i = false;
    public final float[] j = new float[9];
    public final float[] n = new float[9];
    public e7[] p = new e7[16];
    public int q = 0;
    public int r = 0;

    public q11(int i) {
        this.o = i;
    }

    public final void a(e7 e7Var) {
        int i = 0;
        while (true) {
            int i2 = this.q;
            e7[] e7VarArr = this.p;
            if (i >= i2) {
                if (i2 >= e7VarArr.length) {
                    this.p = (e7[]) Arrays.copyOf(e7VarArr, e7VarArr.length * 2);
                }
                e7[] e7VarArr2 = this.p;
                int i3 = this.q;
                e7VarArr2[i3] = e7Var;
                this.q = i3 + 1;
                return;
            }
            if (e7VarArr[i] == e7Var) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(e7 e7Var) {
        int i = this.q;
        int i2 = 0;
        while (i2 < i) {
            if (this.p[i2] == e7Var) {
                while (i2 < i - 1) {
                    e7[] e7VarArr = this.p;
                    int i3 = i2 + 1;
                    e7VarArr[i2] = e7VarArr[i3];
                    i2 = i3;
                }
                this.q--;
                return;
            }
            i2++;
        }
    }

    public final void c() {
        this.o = 5;
        this.f = 0;
        this.c = -1;
        this.d = -1;
        this.g = 0.0f;
        this.i = false;
        int i = this.q;
        for (int i2 = 0; i2 < i; i2++) {
            this.p[i2] = null;
        }
        this.q = 0;
        this.r = 0;
        this.b = false;
        Arrays.fill(this.n, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.c - ((q11) obj).c;
    }

    public final void d(oe0 oe0Var, float f) {
        this.g = f;
        this.i = true;
        int i = this.q;
        this.d = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.p[i2].h(oe0Var, this, false);
        }
        this.q = 0;
    }

    public final void f(oe0 oe0Var, e7 e7Var) {
        int i = this.q;
        for (int i2 = 0; i2 < i; i2++) {
            this.p[i2].i(oe0Var, e7Var, false);
        }
        this.q = 0;
    }

    public final String toString() {
        return AppConfig.CUSTOM + this.c;
    }
}
