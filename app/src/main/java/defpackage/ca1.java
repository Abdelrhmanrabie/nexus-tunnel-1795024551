package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ca1 {
    public abstract ca1 a(lc0$a lc0_a);

    public abstract boolean b();

    public abstract ad1 c();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ca1)) {
            return false;
        }
        ca1 ca1Var = (ca1) obj;
        return b() == ca1Var.b() && c() == ca1Var.c() && getType().equals(ca1Var.getType());
    }

    public abstract fc0 getType();

    public final int hashCode() {
        int iHashCode = c().hashCode() * 31;
        if (ma1.p(getType())) {
            return iHashCode + 19;
        }
        return iHashCode + (b() ? 17 : getType().hashCode());
    }

    public final String toString() {
        if (b()) {
            return "*";
        }
        if (c() == ad1.INVARIANT) {
            return getType().toString();
        }
        return c() + " " + getType();
    }
}
