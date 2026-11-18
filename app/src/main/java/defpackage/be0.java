package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class be0 {
    public static final be0 b;
    public static final be0 c;
    public static final /* synthetic */ be0[] d;

    /* JADX INFO: Fake field, exist only in values array */
    be0 EF0;

    static {
        be0 be0Var = new be0("SYNCHRONIZED", 0);
        be0 be0Var2 = new be0("PUBLICATION", 1);
        b = be0Var2;
        be0 be0Var3 = new be0("NONE", 2);
        c = be0Var3;
        d = new be0[]{be0Var, be0Var2, be0Var3};
    }

    public static be0 valueOf(String str) {
        return (be0) Enum.valueOf(be0.class, str);
    }

    public static be0[] values() {
        return (be0[]) d.clone();
    }
}
