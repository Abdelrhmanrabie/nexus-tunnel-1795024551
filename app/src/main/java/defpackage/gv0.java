package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gv0 {
    public static final gv0 c;
    public static final gv0 d;
    public static final gv0 f;
    public static final /* synthetic */ gv0[] g;

    static {
        gv0 gv0Var = new gv0("IGNORE", 0);
        c = gv0Var;
        gv0 gv0Var2 = new gv0("WARN", 1);
        d = gv0Var2;
        gv0 gv0Var3 = new gv0("STRICT", 2);
        f = gv0Var3;
        g = new gv0[]{gv0Var, gv0Var2, gv0Var3};
    }

    public static gv0 valueOf(String str) {
        return (gv0) Enum.valueOf(gv0.class, str);
    }

    public static gv0[] values() {
        return (gv0[]) g.clone();
    }
}
