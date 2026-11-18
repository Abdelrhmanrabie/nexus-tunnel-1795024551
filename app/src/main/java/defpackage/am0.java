package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class am0 {
    public static final am0 b;
    public static final am0 c;
    public static final am0 d;
    public static final /* synthetic */ am0[] f;

    static {
        am0 am0Var = new am0("FORCE_FLEXIBILITY", 0);
        b = am0Var;
        am0 am0Var2 = new am0("NULLABLE", 1);
        c = am0Var2;
        am0 am0Var3 = new am0("NOT_NULL", 2);
        d = am0Var3;
        f = new am0[]{am0Var, am0Var2, am0Var3};
    }

    public static am0 valueOf(String str) {
        return (am0) Enum.valueOf(am0.class, str);
    }

    public static am0[] values() {
        return (am0[]) f.clone();
    }
}
