package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u10 implements ws0 {
    public final k a;

    public u10(k kVar) {
        this.a = kVar;
    }

    public final boolean equals(Object obj) {
        u10 u10Var = obj instanceof u10 ? (u10) obj : null;
        return this.a.equals(u10Var != null ? u10Var.a : null);
    }

    @Override // defpackage.ws0
    public final fc0 getType() {
        return this.a.n();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Class{" + this.a.n() + '}';
    }
}
