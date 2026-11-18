package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wc0 implements s4 {
    public final v8 b;
    public final o40 c;
    public final boolean d;
    public final ff0.j f;

    public wc0(v8 v8Var, o40 o40Var, boolean z) {
        this.b = v8Var;
        this.c = o40Var;
        this.d = z;
        this.f = ((c60) v8Var.a).a.d(new i(16, this));
    }

    @Override // defpackage.s4
    public final g4 c(cv cvVar) {
        o40 o40Var = this.c;
        ct0 ct0VarC = o40Var.c(cvVar);
        g4 g4Var = ct0VarC == null ? null : (g4) this.f.invoke(ct0VarC);
        if (g4Var != null) {
            return g4Var;
        }
        ij0 ij0Var = n40.a;
        return n40.a(cvVar, o40Var, this.b);
    }

    @Override // defpackage.s4
    public final boolean f(cv cvVar) {
        return c(cvVar) != null;
    }

    @Override // defpackage.s4
    public final boolean isEmpty() {
        return this.c.getAnnotations().isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        o40 o40Var = this.c;
        c81 c81Var = new c81(new ge(0, o40Var.getAnnotations()), this.f);
        ij0 ij0Var = n40.a;
        return new et.b(new ht(fz0.u(ae.B0(new sy0[]{c81Var, ae.B0(new Object[]{n40.a(m21.a.m, o40Var, this.b)})})), false, new cz0(0)));
    }
}
