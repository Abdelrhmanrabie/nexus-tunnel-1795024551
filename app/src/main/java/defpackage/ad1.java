package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum ad1 {
    INVARIANT(0, true),
    IN_VARIANCE(1, false),
    OUT_VARIANCE(2, true);

    public final String b;
    public final boolean c;

    ad1(int i2, boolean z) {
        this.b = str;
        this.c = z;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
