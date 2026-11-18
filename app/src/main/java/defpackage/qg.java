package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class qg {
    public final Object a;

    public qg(Object obj) {
        this.a = obj;
    }

    public abstract fc0 a(gi0 gi0Var);

    public Object b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Object objB = b();
        qg qgVar = obj instanceof qg ? (qg) obj : null;
        return e4.a(objB, qgVar != null ? qgVar.b() : null);
    }

    public final int hashCode() {
        Object objB = b();
        if (objB == null) {
            return 0;
        }
        return objB.hashCode();
    }

    public String toString() {
        return String.valueOf(b());
    }
}
