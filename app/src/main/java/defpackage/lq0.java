package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lq0 {
    public static final lq0 b;
    public static final lq0 c;
    public static final /* synthetic */ lq0[] d;

    /* JADX INFO: Fake field, exist only in values array */
    lq0 EF0;

    static {
        lq0 lq0Var = new lq0("PRETTY", 0);
        lq0 lq0Var2 = new lq0("DEBUG", 1);
        b = lq0Var2;
        lq0 lq0Var3 = new lq0("NONE", 2);
        c = lq0Var3;
        d = new lq0[]{lq0Var, lq0Var2, lq0Var3};
    }

    public static lq0 valueOf(String str) {
        return (lq0) Enum.valueOf(lq0.class, str);
    }

    public static lq0[] values() {
        return (lq0[]) d.clone();
    }
}
