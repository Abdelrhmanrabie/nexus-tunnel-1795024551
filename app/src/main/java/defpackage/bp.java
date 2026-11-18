package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bp extends qg {
    public final /* synthetic */ int G0 = 0;

    public bp(double d) {
        super(Double.valueOf(d));
    }

    public bp(float f) {
        super(Float.valueOf(f));
    }

    public /* synthetic */ bp(Object obj) {
        super(obj);
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        wp0 wp0Var;
        int i = this.G0;
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        if (i != 0) {
            wp0Var = i != 1 ? wp0.FLOAT : wp0.BOOLEAN;
        } else {
            wp0Var = wp0.DOUBLE;
        }
        return ub0VarK.t(wp0Var);
    }

    @Override // defpackage.qg
    public String toString() {
        StringBuilder sb;
        String str;
        int i = this.G0;
        if (i == 0) {
            sb = new StringBuilder();
            sb.append(((Number) this.a).doubleValue());
            str = ".toDouble()";
        } else {
            if (i != 2) {
                return super.toString();
            }
            sb = new StringBuilder();
            sb.append(((Number) this.a).floatValue());
            str = ".toFloat()";
        }
        sb.append(str);
        return sb.toString();
    }
}
