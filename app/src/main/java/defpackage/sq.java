package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sq implements wo {
    public static final sq b;
    public static final /* synthetic */ sq[] c;

    static {
        sq sqVar = new sq("INSTANCE", 0);
        b = sqVar;
        c = new sq[]{sqVar, new sq("NEVER", 1)};
    }

    public static sq valueOf(String str) {
        return (sq) Enum.valueOf(sq.class, str);
    }

    public static sq[] values() {
        return (sq[]) c.clone();
    }

    @Override // defpackage.wo
    public final void a() {
    }
}
