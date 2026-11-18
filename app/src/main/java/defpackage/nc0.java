package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nc0 implements Comparable {
    public static final nc0 g = new nc0(2, 1);
    public final int b;
    public final int c;
    public final int f;

    public nc0(int i, int i2) {
        this.b = i;
        this.c = i2;
        if (i >= 0 && i < 256 && i2 >= 0 && i2 < 256) {
            this.f = (i << 16) + (i2 << 8);
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + ".0").toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f - ((nc0) obj).f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        nc0 nc0Var = obj instanceof nc0 ? (nc0) obj : null;
        return nc0Var != null && this.f == nc0Var.f;
    }

    public final int hashCode() {
        return this.f;
    }

    public final String toString() {
        return this.b + '.' + this.c + ".0";
    }
}
