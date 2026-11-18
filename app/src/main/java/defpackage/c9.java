package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c9 {
    public static final /* synthetic */ c9[] c = {new c9("CLEAR", 0), new c9("SRC", 1), new c9("DST", 2), new c9("SRC_OVER", 3), new c9("DST_OVER", 4), new c9("SRC_IN", 5), new c9("DST_IN", 6), new c9("SRC_OUT", 7), new c9("DST_OUT", 8), new c9("SRC_ATOP", 9), new c9("DST_ATOP", 10), new c9("XOR", 11), new c9("PLUS", 12), new c9("MODULATE", 13), new c9("SCREEN", 14), new c9("OVERLAY", 15), new c9("DARKEN", 16), new c9("LIGHTEN", 17), new c9("COLOR_DODGE", 18), new c9("COLOR_BURN", 19), new c9("HARD_LIGHT", 20), new c9("SOFT_LIGHT", 21), new c9("DIFFERENCE", 22), new c9("EXCLUSION", 23), new c9("MULTIPLY", 24), new c9("HUE", 25), new c9("SATURATION", 26), new c9("COLOR", 27), new c9("LUMINOSITY", 28)};

    /* JADX INFO: Fake field, exist only in values array */
    c9 EF5;

    public static c9 valueOf(String str) {
        return (c9) Enum.valueOf(c9.class, str);
    }

    public static c9[] values() {
        return (c9[]) c.clone();
    }
}
