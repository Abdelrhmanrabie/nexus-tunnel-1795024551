package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z10 extends ea1 {
    public final v91[] b;
    public final ca1[] c;
    public final boolean d;

    public z10(v91[] v91VarArr, ca1[] ca1VarArr, boolean z) {
        this.b = v91VarArr;
        this.c = ca1VarArr;
        this.d = z;
    }

    @Override // defpackage.ea1
    public final boolean b() {
        return this.d;
    }

    @Override // defpackage.ea1
    public final ca1 d(fc0 fc0Var) {
        od odVarB = fc0Var.L0().b();
        v91 v91Var = odVarB instanceof v91 ? (v91) odVarB : null;
        if (v91Var != null) {
            int index = v91Var.getIndex();
            v91[] v91VarArr = this.b;
            if (index < v91VarArr.length && e4.a((Object) v91VarArr[index].h(), (Object) v91Var.h())) {
                return this.c[index];
            }
        }
        return null;
    }

    @Override // defpackage.ea1
    public final boolean e() {
        return this.c.length == 0;
    }
}
