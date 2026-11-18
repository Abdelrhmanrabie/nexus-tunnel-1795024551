package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class x3 {
    public static final x3 b;
    public static final x3 c;
    public static final x3 d;
    public static final x3 f;
    public static final /* synthetic */ x3[] g;

    static {
        x3 x3Var = new x3("FUNCTION", 0);
        b = x3Var;
        x3 x3Var2 = new x3("PROPERTY", 1);
        c = x3Var2;
        x3 x3Var3 = new x3("PROPERTY_GETTER", 2);
        d = x3Var3;
        x3 x3Var4 = new x3("PROPERTY_SETTER", 3);
        f = x3Var4;
        g = new x3[]{x3Var, x3Var2, x3Var3, x3Var4};
    }

    public static x3 valueOf(String str) {
        return (x3) Enum.valueOf(x3.class, str);
    }

    public static x3[] values() {
        return (x3[]) g.clone();
    }
}
