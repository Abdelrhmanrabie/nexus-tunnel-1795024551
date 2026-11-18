package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class n60 {
    public final int a;
    public final int b;
    public final boolean c;
    public final Set d;
    public final u01 e;

    public n60(int i, int i2, boolean z, Set set, u01 u01Var) {
        ak.r(i, "howThisTypeIsUsed");
        ak.r(i2, "flexibility");
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = set;
        this.e = u01Var;
    }

    public /* synthetic */ n60(int i, boolean z, Set set, int i2) {
        this(i, 1, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : set, null);
    }

    public static n60 a(n60 n60Var, int i, Set set, u01 u01Var, int i2) {
        int i3 = n60Var.a;
        if ((i2 & 2) != 0) {
            i = n60Var.b;
        }
        int i4 = i;
        boolean z = n60Var.c;
        if ((i2 & 8) != 0) {
            set = n60Var.d;
        }
        Set set2 = set;
        if ((i2 & 16) != 0) {
            u01Var = n60Var.e;
        }
        ak.r(i3, "howThisTypeIsUsed");
        ak.r(i4, "flexibility");
        return new n60(i3, i4, z, set2, u01Var);
    }

    public final n60 b(int i) {
        ak.r(i, "flexibility");
        return a(this, i, null, null, 29);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n60)) {
            return false;
        }
        n60 n60Var = (n60) obj;
        return this.a == n60Var.a && this.b == n60Var.b && this.c == n60Var.c && e4.a(this.d, n60Var.d) && e4.a(this.e, n60Var.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        int iU = (ak.u(this.b) + (ak.u(this.a) * 31)) * 31;
        boolean z = this.c;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = (iU + r0) * 31;
        Set set = this.d;
        int iHashCode = (i + (set == null ? 0 : set.hashCode())) * 31;
        u01 u01Var = this.e;
        return iHashCode + (u01Var != null ? u01Var.hashCode() : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("JavaTypeAttributes(howThisTypeIsUsed=");
        int i = this.a;
        String str2 = "null";
        if (i == 1) {
            str = "SUPERTYPE";
        } else {
            str = i == 2 ? "COMMON" : "null";
        }
        sb.append(str);
        sb.append(", flexibility=");
        int i2 = this.b;
        if (i2 == 1) {
            str2 = "INFLEXIBLE";
        } else if (i2 == 2) {
            str2 = "FLEXIBLE_UPPER_BOUND";
        } else if (i2 == 3) {
            str2 = "FLEXIBLE_LOWER_BOUND";
        }
        sb.append(str2);
        sb.append(", isForAnnotationParameter=");
        sb.append(this.c);
        sb.append(", visitedTypeParameters=");
        sb.append(this.d);
        sb.append(", defaultType=");
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
