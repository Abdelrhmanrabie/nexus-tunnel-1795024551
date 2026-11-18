package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kr extends qg {
    public final dd b;
    public final ij0 c;

    public kr(dd ddVar, ij0 ij0Var) {
        super(new jo0(ddVar, ij0Var));
        this.b = ddVar;
        this.c = ij0Var;
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        dd ddVar = this.b;
        ai0 ai0VarA = e4.a(gi0Var, ddVar);
        if (ai0VarA == null || !xm.n(ai0VarA, 3)) {
            ai0VarA = null;
        }
        if (ai0VarA != null) {
            return ai0VarA.n();
        }
        return pr.d("Containing class for error-class based enum entry " + ddVar + '.' + this.c);
    }

    @Override // defpackage.qg
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
