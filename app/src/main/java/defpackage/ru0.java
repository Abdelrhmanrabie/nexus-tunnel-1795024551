package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ru0 {
    public static final nm a = mm.a;

    public static void a(StringBuilder sb, la laVar) {
        cv cvVar = lc1.a;
        sc0 sc0VarJ0 = laVar.N() != null ? ((ai0) laVar.b()).J0() : null;
        sc0 sc0VarQ = laVar.Q();
        nm nmVar = a;
        if (sc0VarJ0 != null) {
            sb.append(nmVar.s(sc0VarJ0.getType()));
            sb.append(".");
        }
        boolean z = (sc0VarJ0 == null || sc0VarQ == null) ? false : true;
        if (z) {
            sb.append("(");
        }
        if (sc0VarQ != null) {
            sb.append(nmVar.s(sc0VarQ.getType()));
            sb.append(".");
        }
        if (z) {
            sb.append(")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b(ox oxVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        a(sb, oxVar);
        ij0 name = ((pk) oxVar).getName();
        nm nmVar = a;
        sb.append(nmVar.r(name, true));
        he.P0(oxVar.f(), sb, "(", ")", p0.b$6, 48);
        sb.append(": ");
        sb.append(nmVar.s(oxVar.getReturnType()));
        return sb.toString();
    }

    public static String c(nq0 nq0Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(nq0Var.i ? "var " : "val ");
        a(sb, nq0Var);
        ij0 name = nq0Var.getName();
        nm nmVar = a;
        sb.append(nmVar.r(name, true));
        sb.append(": ");
        sb.append(nmVar.s(nq0Var.getType()));
        return sb.toString();
    }
}
