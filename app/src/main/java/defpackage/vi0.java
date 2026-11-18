package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vi0 {
    public static final vi0 b;
    public static final vi0 c;
    public static final /* synthetic */ vi0[] d;

    static {
        vi0 vi0Var = new vi0("READ_ONLY", 0);
        b = vi0Var;
        vi0 vi0Var2 = new vi0("MUTABLE", 1);
        c = vi0Var2;
        d = new vi0[]{vi0Var, vi0Var2};
    }

    public static vi0 valueOf(String str) {
        return (vi0) Enum.valueOf(vi0.class, str);
    }

    public static vi0[] values() {
        return (vi0[]) d.clone();
    }
}
