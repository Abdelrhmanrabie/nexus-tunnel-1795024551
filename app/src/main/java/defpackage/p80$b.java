package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p80$b extends ak {
    public final String a;
    public final String b;

    public p80$b(String str, String str2) {
        super(23, false);
        this.a = str;
        this.b = str2;
    }

    @Override // defpackage.ak
    /* JADX INFO: renamed from: a */
    public final String mo0a() {
        return e4.j(this.a, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p80$b)) {
            return false;
        }
        p80$b p80_b = (p80$b) obj;
        return e4.a(this.a, p80_b.a) && e4.a(this.b, p80_b.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
