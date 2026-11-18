package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c21$a$a {
    public final ij0 a;
    public final String b;

    public c21$a$a(ij0 ij0Var, String str) {
        this.a = ij0Var;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c21$a$a)) {
            return false;
        }
        c21$a$a c21_a_a = (c21$a$a) obj;
        return this.a.equals(c21_a_a.a) && this.b.equals(c21_a_a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NameAndSignature(name=");
        sb.append(this.a);
        sb.append(", signature=");
        return fb$1.m(sb, this.b, ')');
    }
}
