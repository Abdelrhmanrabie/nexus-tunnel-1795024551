package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dc0 {
    public static final dc0 b;
    public static final dc0 c;
    public static final dc0 d;
    public static final /* synthetic */ dc0[] f;

    static {
        dc0 dc0Var = new dc0("RUNTIME", 0);
        b = dc0Var;
        dc0 dc0Var2 = new dc0("BINARY", 1);
        c = dc0Var2;
        dc0 dc0Var3 = new dc0("SOURCE", 2);
        d = dc0Var3;
        f = new dc0[]{dc0Var, dc0Var2, dc0Var3};
    }

    public static dc0 valueOf(String str) {
        return (dc0) Enum.valueOf(dc0.class, str);
    }

    public static dc0[] values() {
        return (dc0[]) f.clone();
    }
}
