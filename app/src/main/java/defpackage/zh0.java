package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zh0 {
    public static final zh0 b;
    public static final zh0 c;
    public static final zh0 d;
    public static final zh0 f;
    public static final /* synthetic */ zh0[] g;

    static {
        zh0 zh0Var = new zh0("FINAL", 0);
        b = zh0Var;
        zh0 zh0Var2 = new zh0("SEALED", 1);
        c = zh0Var2;
        zh0 zh0Var3 = new zh0("OPEN", 2);
        d = zh0Var3;
        zh0 zh0Var4 = new zh0("ABSTRACT", 3);
        f = zh0Var4;
        g = new zh0[]{zh0Var, zh0Var2, zh0Var3, zh0Var4};
    }

    public static zh0 valueOf(String str) {
        return (zh0) Enum.valueOf(zh0.class, str);
    }

    public static zh0[] values() {
        return (zh0[]) g.clone();
    }
}
