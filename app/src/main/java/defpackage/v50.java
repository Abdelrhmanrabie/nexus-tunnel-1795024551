package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v50 {
    public static final v50 d = new v50(gv0.f, 6);
    public final gv0 a;
    public final nc0 b;
    public final gv0 c;

    public v50(gv0 gv0Var, int i) {
        this(gv0Var, (i & 2) != 0 ? new nc0(1, 0) : null, gv0Var);
    }

    public v50(gv0 gv0Var, nc0 nc0Var, gv0 gv0Var2) {
        this.a = gv0Var;
        this.b = nc0Var;
        this.c = gv0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v50)) {
            return false;
        }
        v50 v50Var = (v50) obj;
        return this.a == v50Var.a && e4.a(this.b, v50Var.b) && this.c == v50Var.c;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        nc0 nc0Var = this.b;
        return this.c.hashCode() + ((iHashCode + (nc0Var == null ? 0 : nc0Var.f)) * 31);
    }

    public final String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }
}
