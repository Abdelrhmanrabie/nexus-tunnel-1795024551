package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vi {
    public static final vi b;
    public static final /* synthetic */ vi[] c;

    static {
        vi viVar = new vi("COROUTINE_SUSPENDED", 0);
        b = viVar;
        c = new vi[]{viVar, new vi("UNDECIDED", 1), new vi("RESUMED", 2)};
    }

    public static vi valueOf(String str) {
        return (vi) Enum.valueOf(vi.class, str);
    }

    public static vi[] values() {
        return (vi[]) c.clone();
    }
}
