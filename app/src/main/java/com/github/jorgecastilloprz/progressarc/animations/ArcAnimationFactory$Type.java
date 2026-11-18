package com.github.jorgecastilloprz.progressarc.animations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ArcAnimationFactory$Type {
    public static final /* synthetic */ ArcAnimationFactory$Type[] $VALUES;
    public static final ArcAnimationFactory$Type COMPLETE;
    public static final ArcAnimationFactory$Type GROW;
    public static final ArcAnimationFactory$Type ROTATE;
    public static final ArcAnimationFactory$Type SHRINK;

    static {
        ArcAnimationFactory$Type arcAnimationFactory$Type = new ArcAnimationFactory$Type("ROTATE", 0);
        ROTATE = arcAnimationFactory$Type;
        ArcAnimationFactory$Type arcAnimationFactory$Type2 = new ArcAnimationFactory$Type("GROW", 1);
        GROW = arcAnimationFactory$Type2;
        ArcAnimationFactory$Type arcAnimationFactory$Type3 = new ArcAnimationFactory$Type("SHRINK", 2);
        SHRINK = arcAnimationFactory$Type3;
        ArcAnimationFactory$Type arcAnimationFactory$Type4 = new ArcAnimationFactory$Type("COMPLETE", 3);
        COMPLETE = arcAnimationFactory$Type4;
        $VALUES = new ArcAnimationFactory$Type[]{arcAnimationFactory$Type, arcAnimationFactory$Type2, arcAnimationFactory$Type3, arcAnimationFactory$Type4};
    }

    public static ArcAnimationFactory$Type valueOf(String str) {
        return (ArcAnimationFactory$Type) Enum.valueOf(ArcAnimationFactory$Type.class, str);
    }

    public static ArcAnimationFactory$Type[] values() {
        return (ArcAnimationFactory$Type[]) $VALUES.clone();
    }
}
