package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z91$a {
    public final v91 a;
    public final boolean b;
    public final n60 c;

    public z91$a(v91 v91Var, boolean z, n60 n60Var) {
        this.a = v91Var;
        this.b = z;
        this.c = n60Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z91$a)) {
            return false;
        }
        z91$a z91_a = (z91$a) obj;
        if (!e4.a(z91_a.a, this.a) || z91_a.b != this.b) {
            return false;
        }
        n60 n60Var = z91_a.c;
        int i = n60Var.b;
        n60 n60Var2 = this.c;
        return i == n60Var2.b && n60Var.a == n60Var2.a && n60Var.c == n60Var2.c && e4.a(n60Var.e, n60Var2.e);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode();
        int i = (iHashCode * 31) + (this.b ? 1 : 0) + iHashCode;
        n60 n60Var = this.c;
        int iU = ak.u(n60Var.b) + (i * 31) + i;
        int iU2 = ak.u(n60Var.a) + (iU * 31) + iU;
        int i2 = (iU2 * 31) + (n60Var.c ? 1 : 0) + iU2;
        int i3 = i2 * 31;
        u01 u01Var = n60Var.e;
        return i3 + (u01Var == null ? 0 : u01Var.hashCode()) + i2;
    }

    public final String toString() {
        return "DataToEraseUpperBound(typeParameter=" + this.a + ", isRaw=" + this.b + ", typeAttr=" + this.c + ')';
    }
}
