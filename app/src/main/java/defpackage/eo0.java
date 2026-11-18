package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class eo0 implements sc {
    public final Class b;

    public eo0(Class cls) {
        this.b = cls;
    }

    @Override // defpackage.sc
    public final Class d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof eo0) {
            return e4.a(this.b, ((eo0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b + " (Kotlin reflection is not available)";
    }
}
