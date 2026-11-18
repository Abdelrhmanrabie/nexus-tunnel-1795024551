package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ju0 {
    public final Class a;
    public final wb0 b;

    public ju0(Class cls, wb0 wb0Var) {
        this.a = cls;
        this.b = wb0Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ju0) {
            return e4.a(this.a, ((ju0) obj).a);
        }
        return false;
    }

    public final String getLocation() {
        String name = this.a.getName();
        int i = q31.$r8$clinit;
        return e4.j(name.replace('.', '/'), ".class");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return ju0.class.getName() + ": " + this.a;
    }
}
