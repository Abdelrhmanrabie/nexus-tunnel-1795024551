package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hn {
    public final fn a;
    public final jj0 b;
    public final ok c;
    public final fi0 d;
    public final gd1 e;
    public final y8 f;
    public final rn g;
    public final e91 h;
    public final rg0 i;

    public hn(fn fnVar, jj0 jj0Var, ok okVar, fi0 fi0Var, gd1 gd1Var, y8 y8Var, rn rnVar, e91 e91Var, List list) {
        this.a = fnVar;
        this.b = jj0Var;
        this.c = okVar;
        this.d = fi0Var;
        this.e = gd1Var;
        this.f = y8Var;
        this.g = rnVar;
        this.h = new e91(this, e91Var, list, "Deserializer for \"" + okVar.getName() + '\"', rnVar == null ? "[container not found]" : rnVar.a());
        this.i = new rg0(this);
    }

    public static hn b(hn hnVar, rk rkVar, List list) {
        jj0 jj0Var = hnVar.b;
        fi0 fi0Var = hnVar.d;
        gd1 gd1Var = hnVar.e;
        y8 y8Var = hnVar.f;
        fn fnVar = hnVar.a;
        int i = y8Var.b;
        return new hn(fnVar, jj0Var, rkVar, fi0Var, gd1Var, y8Var, hnVar.g, hnVar.h, list);
    }
}
