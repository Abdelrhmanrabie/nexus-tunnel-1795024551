package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum ur0 implements h30.a {
    /* JADX INFO: Fake field, exist only in values array */
    EF5("INTERNAL"),
    /* JADX INFO: Fake field, exist only in values array */
    EF13("PRIVATE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF21("PROTECTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF29("PUBLIC"),
    /* JADX INFO: Fake field, exist only in values array */
    EF37("PRIVATE_TO_THIS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF45("LOCAL");

    public final int b;

    ur0(String str) {
        this.b = i;
    }

    @Override // h30.a
    public final int getNumber() {
        return this.b;
    }
}
