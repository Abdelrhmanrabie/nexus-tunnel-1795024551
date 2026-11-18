package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class n40 {
    public static final ij0 a = ij0.f("message");
    public static final ij0 b = ij0.f("allowedTargets");
    public static final ij0 c = ij0.f(XMLRPC.TAG_VALUE);
    public static final Object d;

    static {
        cv cvVar = m21.a.s;
        cv cvVar2 = r70.c;
        jo0 jo0Var = new jo0(cvVar, cvVar2);
        cv cvVar3 = m21.a.v;
        cv cvVar4 = r70.d;
        jo0 jo0Var2 = new jo0(cvVar3, cvVar4);
        cv cvVar5 = m21.a.w;
        cv cvVar6 = r70.f;
        d = ye1.h(jo0Var, jo0Var2, new jo0(cvVar5, cvVar6));
        ye1.h(new jo0(cvVar2, cvVar), new jo0(cvVar4, cvVar3), new jo0(r70.e, m21.a.m), new jo0(cvVar6, cvVar5));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    public static kp0 a(cv cvVar, o40 o40Var, v8 v8Var) {
        ct0 ct0VarC;
        ct0 ct0VarC2;
        if (e4.a(cvVar, m21.a.m) && (ct0VarC2 = o40Var.c(r70.e)) != null) {
            return new f50(ct0VarC2, v8Var);
        }
        cv cvVar2 = (cv) d.get(cvVar);
        if (cvVar2 == null || (ct0VarC = o40Var.c(cvVar2)) == null) {
            return null;
        }
        return b(v8Var, ct0VarC, false);
    }

    public static kp0 b(v8 v8Var, ct0 ct0Var, boolean z) {
        dd ddVarA = bt0.a(((sc) e.v(ct0Var.a)).d());
        if (ddVarA.equals(dd.l(r70.c))) {
            return new k60(ct0Var, v8Var);
        }
        if (ddVarA.equals(dd.l(r70.d))) {
            return new e60(ct0Var, v8Var);
        }
        if (ddVarA.equals(dd.l(r70.f))) {
            return new m40(v8Var, ct0Var, m21.a.w);
        }
        if (ddVarA.equals(dd.l(r70.e))) {
            return null;
        }
        return new vc0(v8Var, ct0Var, z);
    }
}
