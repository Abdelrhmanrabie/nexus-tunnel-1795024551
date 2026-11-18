package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mx$a$a {
    public final mx a;
    public final int b;

    public mx$a$a(mx mxVar, int i) {
        this.a = mxVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mx$a$a)) {
            return false;
        }
        mx$a$a mx_a_a = (mx$a$a) obj;
        return this.a == mx_a_a.a && this.b == mx_a_a.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "KindWithArity(kind=" + this.a + ", arity=" + this.b + ')';
    }
}
