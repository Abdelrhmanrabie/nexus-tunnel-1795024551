package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ft {
    public static final ft b;
    public static final /* synthetic */ ft[] c;

    /* JADX INFO: Fake field, exist only in values array */
    ft EF0;

    static {
        ft ftVar = new ft("TOP_DOWN", 0);
        ft ftVar2 = new ft("BOTTOM_UP", 1);
        b = ftVar2;
        c = new ft[]{ftVar, ftVar2};
    }

    public static ft valueOf(String str) {
        return (ft) Enum.valueOf(ft.class, str);
    }

    public static ft[] values() {
        return (ft[]) c.clone();
    }
}
