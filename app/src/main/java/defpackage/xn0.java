package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class xn0 extends rk implements wn0 {
    public final cv g;
    public final String i;

    /* JADX WARN: Illegal instructions before constructor call */
    public xn0(gi0 gi0Var, cv cvVar) {
        ij0 ij0VarG;
        s4$a$a s4_a_a = e4.f47a;
        dv dvVar = cvVar.a;
        if (dvVar.a.isEmpty()) {
            ij0VarG = dv.e;
            if (ij0VarG == null) {
                dv.a(12);
                throw null;
            }
        } else {
            ij0VarG = dvVar.g();
        }
        super(gi0Var, s4_a_a, ij0VarG, t11.a);
        this.g = cvVar;
        this.i = "package " + cvVar + " of " + gi0Var;
    }

    @Override // defpackage.rk, defpackage.ok
    public final gi0 b() {
        return (gi0) super.b();
    }

    @Override // defpackage.rk, defpackage.ok
    public final ok b() {
        return (gi0) super.b();
    }

    @Override // defpackage.rk, defpackage.qk
    public t11 g() {
        return t11.a;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        nm nmVar = (nm) bjVar.a;
        nmVar.getClass();
        nmVar.V(this.g, "package-fragment", sb);
        if (nmVar.c.h()) {
            sb.append(" in ");
            nmVar.R(b(), sb, false);
        }
        return tb1.a;
    }

    @Override // defpackage.pk
    public String toString() {
        return this.i;
    }
}
