package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ib {
    public static final ib b;
    public static final /* synthetic */ ib[] c;

    static {
        ib ibVar = new ib("FOR_SUBTYPING", 0);
        b = ibVar;
        c = new ib[]{ibVar, new ib("FOR_INCORPORATION", 1), new ib("FROM_EXPRESSION", 2)};
    }

    public static ib valueOf(String str) {
        return (ib) Enum.valueOf(ib.class, str);
    }

    public static ib[] values() {
        return (ib[]) c.clone();
    }
}
