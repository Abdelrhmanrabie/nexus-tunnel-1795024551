package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bm0 {
    public final am0 a;
    public final boolean b;

    public bm0(am0 am0Var, boolean z) {
        this.a = am0Var;
        this.b = z;
    }

    public static bm0 a(bm0 bm0Var, boolean z, int i) {
        am0 am0Var = am0.b;
        if ((i & 1) != 0) {
            am0Var = bm0Var.a;
        }
        if ((i & 2) != 0) {
            z = bm0Var.b;
        }
        bm0Var.getClass();
        return new bm0(am0Var, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bm0)) {
            return false;
        }
        bm0 bm0Var = (bm0) obj;
        return this.a == bm0Var.a && this.b == bm0Var.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }
}
