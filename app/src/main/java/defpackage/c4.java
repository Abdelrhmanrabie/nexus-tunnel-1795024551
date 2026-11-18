package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum c4 {
    NO_ARGUMENTS(3),
    /* JADX INFO: Fake field, exist only in values array */
    UNLESS_EMPTY(2),
    /* JADX INFO: Fake field, exist only in values array */
    ALWAYS_PARENTHESIZED(true, true);

    public final boolean b;
    public final boolean c;

    /* synthetic */ c4(int i) {
        this((i & 1) == 0, false);
    }

    c4(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
    }
}
