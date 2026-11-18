package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ab0 {
    public static final ab0 c = new ab0(null, null);
    public final bb0 a;
    public final wa0 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bb0.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bb0 bb0Var = bb0.b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bb0 bb0Var2 = bb0.b;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public ab0(bb0 bb0Var, wa0 wa0Var) {
        String str;
        this.a = bb0Var;
        this.b = wa0Var;
        if ((bb0Var == null) == (wa0Var == null)) {
            return;
        }
        if (bb0Var == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + bb0Var + " requires type to be specified.";
        }
        d.AnonymousClass0.m((Object) str);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab0)) {
            return false;
        }
        ab0 ab0Var = (ab0) obj;
        return this.a == ab0Var.a && e4.a(this.b, ab0Var.b);
    }

    public final int hashCode() {
        bb0 bb0Var = this.a;
        int iHashCode = (bb0Var == null ? 0 : bb0Var.hashCode()) * 31;
        wa0 wa0Var = this.b;
        return iHashCode + (wa0Var != null ? wa0Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb;
        bb0 bb0Var = this.a;
        int i = bb0Var == null ? -1 : a.a[bb0Var.ordinal()];
        if (i == -1) {
            return "*";
        }
        wa0 wa0Var = this.b;
        if (i == 1) {
            return String.valueOf(wa0Var);
        }
        if (i == 2) {
            sb = new StringBuilder("in ");
        } else {
            if (i != 3) {
                d.AnonymousClass0.m();
                return null;
            }
            sb = new StringBuilder("out ");
        }
        sb.append(wa0Var);
        return sb.toString();
    }
}
