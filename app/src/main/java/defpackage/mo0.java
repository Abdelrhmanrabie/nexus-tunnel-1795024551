package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mo0 {
    public static final mo0 b;
    public static final mo0 c;
    public static final mo0 d;
    public static final /* synthetic */ mo0[] f;

    static {
        mo0 mo0Var = new mo0("ALL", 0);
        b = mo0Var;
        mo0 mo0Var2 = new mo0("ONLY_NON_SYNTHESIZED", 1);
        c = mo0Var2;
        mo0 mo0Var3 = new mo0("NONE", 2);
        d = mo0Var3;
        f = new mo0[]{mo0Var, mo0Var2, mo0Var3};
    }

    public static mo0 valueOf(String str) {
        return (mo0) Enum.valueOf(mo0.class, str);
    }

    public static mo0[] values() {
        return (mo0[]) f.clone();
    }
}
