package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ed {
    public final dd a;
    public final int b;

    public ed(dd ddVar, int i) {
        this.a = ddVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        return this.a.equals(edVar.a) && this.b == edVar.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i3 >= i) {
                break;
            }
            i3++;
            sb.append("kotlin/Array<");
        }
        sb.append(this.a);
        while (i2 < i) {
            i2++;
            sb.append(">");
        }
        return sb.toString();
    }
}
