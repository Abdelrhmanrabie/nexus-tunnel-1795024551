package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bb0 {
    public static final bb0 b;
    public static final bb0 c;
    public static final bb0 d;
    public static final /* synthetic */ bb0[] f;

    static {
        bb0 bb0Var = new bb0("INVARIANT", 0);
        b = bb0Var;
        bb0 bb0Var2 = new bb0("IN", 1);
        c = bb0Var2;
        bb0 bb0Var3 = new bb0("OUT", 2);
        d = bb0Var3;
        f = new bb0[]{bb0Var, bb0Var2, bb0Var3};
    }

    public static bb0 valueOf(String str) {
        return (bb0) Enum.valueOf(bb0.class, str);
    }

    public static bb0[] values() {
        return (bb0[]) f.clone();
    }
}
