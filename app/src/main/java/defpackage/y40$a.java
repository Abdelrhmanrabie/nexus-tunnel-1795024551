package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y40$a {
    public final dd a;
    public final qt0 c;

    public y40$a(dd ddVar, qt0 qt0Var, int i) {
        qt0Var = (i & 4) != 0 ? null : qt0Var;
        this.a = ddVar;
        this.c = qt0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y40$a)) {
            return false;
        }
        y40$a y40_a = (y40$a) obj;
        return this.a.equals(y40_a.a) && e4.a(this.c, y40_a.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 961;
        qt0 qt0Var = this.c;
        return iHashCode + (qt0Var == null ? 0 : qt0Var.a.hashCode());
    }

    public final String toString() {
        return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString((byte[]) null) + ", outerClass=" + this.c + ')';
    }
}
