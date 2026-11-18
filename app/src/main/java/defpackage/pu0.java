package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class pu0 {
    public u90 a(ux uxVar) {
        return uxVar;
    }

    public h90 b(Class cls) {
        return new id(cls);
    }

    public o90 c(Class cls, String str) {
        return new eo0(cls);
    }

    public z90 d(aj0 aj0Var) {
        return aj0Var;
    }

    public ka0 e(kf0.b bVar) {
        return bVar;
    }

    public ma0 f(tq0 tq0Var) {
        return tq0Var;
    }

    public String g(kx kxVar) {
        String string = kxVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String h(oc0 oc0Var) {
        return g(oc0Var);
    }
}
