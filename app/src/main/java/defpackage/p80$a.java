package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p80$a extends ak {
    public final String a;
    public final String b;

    public p80$a(String str, String str2) {
        super(23, false);
        this.a = str;
        this.b = str2;
    }

    @Override // defpackage.ak
    /* JADX INFO: renamed from: a */
    public final String mo0a() {
        return this.a + ':' + this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p80$a)) {
            return false;
        }
        p80$a p80_a = (p80$a) obj;
        return e4.a(this.a, p80_a.a) && e4.a(this.b, p80_a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
