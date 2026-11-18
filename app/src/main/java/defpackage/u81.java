package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u81 {
    public final fc0 a;
    public final e50 b;
    public final v91 c;
    public final boolean d;

    public u81(fc0 fc0Var, e50 e50Var, v91 v91Var, boolean z) {
        this.a = fc0Var;
        this.b = e50Var;
        this.c = v91Var;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u81)) {
            return false;
        }
        u81 u81Var = (u81) obj;
        return e4.a(this.a, u81Var.a) && e4.a(this.b, u81Var.b) && e4.a(this.c, u81Var.c) && this.d == u81Var.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        e50 e50Var = this.b;
        int iHashCode2 = (iHashCode + (e50Var == null ? 0 : e50Var.hashCode())) * 31;
        v91 v91Var = this.c;
        int iHashCode3 = (iHashCode2 + (v91Var != null ? v91Var.hashCode() : 0)) * 31;
        boolean z = this.d;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.a + ", defaultQualifiers=" + this.b + ", typeParameterForArgument=" + this.c + ", isFromStarProjection=" + this.d + ')';
    }
}
