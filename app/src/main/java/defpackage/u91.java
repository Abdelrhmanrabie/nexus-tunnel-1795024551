package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u91 {
    public static final u91 k = new u91(false, false, false, false, false, new u91(false, false, false, false, false, null, false, null, null, 1023), false, null, null, 988);
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final u91 f;
    public final boolean g;
    public final u91 h;
    public final u91 i;

    public u91(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, u91 u91Var, boolean z6, u91 u91Var2, u91 u91Var3, int i) {
        z = (i & 1) != 0 ? true : z;
        z2 = (i & 2) != 0 ? true : z2;
        z3 = (i & 4) != 0 ? false : z3;
        z4 = (i & 8) != 0 ? false : z4;
        z5 = (i & 16) != 0 ? false : z5;
        u91Var = (i & 32) != 0 ? null : u91Var;
        z6 = (i & 64) != 0 ? true : z6;
        u91Var2 = (i & 128) != 0 ? u91Var : u91Var2;
        u91Var3 = (i & 256) != 0 ? u91Var : u91Var3;
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = u91Var;
        this.g = z6;
        this.h = u91Var2;
        this.i = u91Var3;
    }
}
