package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ga0$a {
    public static final ga0$a b;
    public static final ga0$a c;
    public static final ga0$a d;
    public static final /* synthetic */ ga0$a[] f;

    static {
        ga0$a ga0_a = new ga0$a("INSTANCE", 0);
        b = ga0_a;
        ga0$a ga0_a2 = new ga0$a("EXTENSION_RECEIVER", 1);
        c = ga0_a2;
        ga0$a ga0_a3 = new ga0$a("VALUE", 2);
        d = ga0_a3;
        f = new ga0$a[]{ga0_a, ga0_a2, ga0_a3};
    }

    public static ga0$a valueOf(String str) {
        return (ga0$a) Enum.valueOf(ga0$a.class, str);
    }

    public static ga0$a[] values() {
        return (ga0$a[]) f.clone();
    }
}
