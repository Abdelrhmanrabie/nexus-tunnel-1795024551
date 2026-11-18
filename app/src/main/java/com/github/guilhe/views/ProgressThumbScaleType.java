package com.github.guilhe.views;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressThumbScaleType {
    public static final /* synthetic */ ProgressThumbScaleType[] $VALUES;
    public static final ProgressThumbScaleType AUTO;
    public static final ProgressThumbScaleType POINT;
    public static final ProgressThumbScaleType RATE;

    static {
        ProgressThumbScaleType progressThumbScaleType = new ProgressThumbScaleType("AUTO", 0);
        AUTO = progressThumbScaleType;
        ProgressThumbScaleType progressThumbScaleType2 = new ProgressThumbScaleType("POINT", 1);
        POINT = progressThumbScaleType2;
        ProgressThumbScaleType progressThumbScaleType3 = new ProgressThumbScaleType("RATE", 2);
        RATE = progressThumbScaleType3;
        $VALUES = new ProgressThumbScaleType[]{progressThumbScaleType, progressThumbScaleType2, progressThumbScaleType3};
    }

    public static ProgressThumbScaleType valueOf(String str) {
        return (ProgressThumbScaleType) Enum.valueOf(ProgressThumbScaleType.class, str);
    }

    public static ProgressThumbScaleType[] values() {
        return (ProgressThumbScaleType[]) $VALUES.clone();
    }
}
