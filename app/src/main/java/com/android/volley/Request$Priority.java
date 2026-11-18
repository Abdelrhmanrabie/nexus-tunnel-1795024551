package com.android.volley;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Request$Priority {
    public static final /* synthetic */ Request$Priority[] $VALUES;
    public static final Request$Priority NORMAL;

    /* JADX INFO: Fake field, exist only in values array */
    Request$Priority EF0;

    static {
        Request$Priority request$Priority = new Request$Priority("LOW", 0);
        Request$Priority request$Priority2 = new Request$Priority("NORMAL", 1);
        NORMAL = request$Priority2;
        $VALUES = new Request$Priority[]{request$Priority, request$Priority2, new Request$Priority("HIGH", 2), new Request$Priority("IMMEDIATE", 3)};
    }

    public static Request$Priority valueOf(String str) {
        return (Request$Priority) Enum.valueOf(Request$Priority.class, str);
    }

    public static Request$Priority[] values() {
        return (Request$Priority[]) $VALUES.clone();
    }
}
