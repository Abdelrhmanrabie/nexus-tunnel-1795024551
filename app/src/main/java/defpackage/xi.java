package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xi {
    public static final xi b;
    public static final /* synthetic */ xi[] d;

    static {
        xi xiVar = new xi("DEFAULT", 0);
        b = xiVar;
        d = new xi[]{xiVar, new xi("LAZY", 1), new xi("ATOMIC", 2), new xi("UNDISPATCHED", 3)};
    }

    public static xi valueOf(String str) {
        return (xi) Enum.valueOf(xi.class, str);
    }

    public static xi[] values() {
        return (xi[]) d.clone();
    }
}
