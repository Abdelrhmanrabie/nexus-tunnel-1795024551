package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class on0 {
    public static final on0 b;
    public static final on0 c;
    public static final /* synthetic */ on0[] d;

    static {
        on0 on0Var = new on0("RENDER_OVERRIDE", 0);
        b = on0Var;
        on0 on0Var2 = new on0("RENDER_OPEN", 1);
        c = on0Var2;
        d = new on0[]{on0Var, on0Var2, new on0("RENDER_OPEN_OVERRIDE", 2)};
    }

    public static on0 valueOf(String str) {
        return (on0) Enum.valueOf(on0.class, str);
    }

    public static on0[] values() {
        return (on0[]) d.clone();
    }
}
