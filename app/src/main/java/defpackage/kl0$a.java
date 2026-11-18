package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kl0$a {
    public final dd a;
    public final List b;

    public kl0$a(dd ddVar, List list) {
        this.a = ddVar;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kl0$a)) {
            return false;
        }
        kl0$a kl0_a = (kl0$a) obj;
        return e4.a(this.a, kl0_a.a) && e4.a(this.b, kl0_a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.b + ')';
    }
}
