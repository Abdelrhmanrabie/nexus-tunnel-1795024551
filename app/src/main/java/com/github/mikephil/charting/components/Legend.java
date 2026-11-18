package com.github.mikephil.charting.components;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Legend extends ComponentBase {
    public ArrayList mCalculatedLabelBreakPoints;
    public ArrayList mCalculatedLabelSizes;
    public ArrayList mCalculatedLineSizes;
    public LegendDirection mDirection;
    public LegendEntry[] mEntries;
    public float mFormLineWidth;
    public float mFormSize;
    public float mFormToTextSpace;
    public LegendHorizontalAlignment mHorizontalAlignment;
    public float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    public LegendOrientation mOrientation;
    public LegendForm mShape;
    public float mStackSpace;
    public float mTextHeightMax;
    public LegendVerticalAlignment mVerticalAlignment;
    public float mXEntrySpace;

    /* JADX INFO: renamed from: com.github.mikephil.charting.components.Legend$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
                LegendOrientation[] legendOrientationArr = LegendOrientation.$VALUES;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LegendDirection {
        public static final /* synthetic */ LegendDirection[] $VALUES;
        public static final LegendDirection LEFT_TO_RIGHT;
        public static final LegendDirection RIGHT_TO_LEFT;

        static {
            LegendDirection legendDirection = new LegendDirection("LEFT_TO_RIGHT", 0);
            LEFT_TO_RIGHT = legendDirection;
            LegendDirection legendDirection2 = new LegendDirection("RIGHT_TO_LEFT", 1);
            RIGHT_TO_LEFT = legendDirection2;
            $VALUES = new LegendDirection[]{legendDirection, legendDirection2};
        }

        public static LegendDirection valueOf(String str) {
            return (LegendDirection) Enum.valueOf(LegendDirection.class, str);
        }

        public static LegendDirection[] values() {
            return (LegendDirection[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LegendForm {
        public static final /* synthetic */ LegendForm[] $VALUES;
        public static final LegendForm DEFAULT;
        public static final LegendForm NONE;
        public static final LegendForm SQUARE;

        static {
            LegendForm legendForm = new LegendForm("NONE", 0);
            NONE = legendForm;
            LegendForm legendForm2 = new LegendForm("EMPTY", 1);
            LegendForm legendForm3 = new LegendForm("DEFAULT", 2);
            DEFAULT = legendForm3;
            LegendForm legendForm4 = new LegendForm("SQUARE", 3);
            SQUARE = legendForm4;
            $VALUES = new LegendForm[]{legendForm, legendForm2, legendForm3, legendForm4, new LegendForm("CIRCLE", 4), new LegendForm("LINE", 5)};
        }

        public static LegendForm valueOf(String str) {
            return (LegendForm) Enum.valueOf(LegendForm.class, str);
        }

        public static LegendForm[] values() {
            return (LegendForm[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LegendHorizontalAlignment {
        public static final /* synthetic */ LegendHorizontalAlignment[] $VALUES;
        public static final LegendHorizontalAlignment CENTER;
        public static final LegendHorizontalAlignment LEFT;
        public static final LegendHorizontalAlignment RIGHT;

        static {
            LegendHorizontalAlignment legendHorizontalAlignment = new LegendHorizontalAlignment("LEFT", 0);
            LEFT = legendHorizontalAlignment;
            LegendHorizontalAlignment legendHorizontalAlignment2 = new LegendHorizontalAlignment("CENTER", 1);
            CENTER = legendHorizontalAlignment2;
            LegendHorizontalAlignment legendHorizontalAlignment3 = new LegendHorizontalAlignment("RIGHT", 2);
            RIGHT = legendHorizontalAlignment3;
            $VALUES = new LegendHorizontalAlignment[]{legendHorizontalAlignment, legendHorizontalAlignment2, legendHorizontalAlignment3};
        }

        public static LegendHorizontalAlignment valueOf(String str) {
            return (LegendHorizontalAlignment) Enum.valueOf(LegendHorizontalAlignment.class, str);
        }

        public static LegendHorizontalAlignment[] values() {
            return (LegendHorizontalAlignment[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LegendOrientation {
        public static final /* synthetic */ LegendOrientation[] $VALUES;
        public static final LegendOrientation HORIZONTAL;
        public static final LegendOrientation VERTICAL;

        static {
            LegendOrientation legendOrientation = new LegendOrientation("HORIZONTAL", 0);
            HORIZONTAL = legendOrientation;
            LegendOrientation legendOrientation2 = new LegendOrientation("VERTICAL", 1);
            VERTICAL = legendOrientation2;
            $VALUES = new LegendOrientation[]{legendOrientation, legendOrientation2};
        }

        public static LegendOrientation valueOf(String str) {
            return (LegendOrientation) Enum.valueOf(LegendOrientation.class, str);
        }

        public static LegendOrientation[] values() {
            return (LegendOrientation[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LegendVerticalAlignment {
        public static final /* synthetic */ LegendVerticalAlignment[] $VALUES;
        public static final LegendVerticalAlignment BOTTOM;
        public static final LegendVerticalAlignment CENTER;
        public static final LegendVerticalAlignment TOP;

        static {
            LegendVerticalAlignment legendVerticalAlignment = new LegendVerticalAlignment("TOP", 0);
            TOP = legendVerticalAlignment;
            LegendVerticalAlignment legendVerticalAlignment2 = new LegendVerticalAlignment("CENTER", 1);
            CENTER = legendVerticalAlignment2;
            LegendVerticalAlignment legendVerticalAlignment3 = new LegendVerticalAlignment("BOTTOM", 2);
            BOTTOM = legendVerticalAlignment3;
            $VALUES = new LegendVerticalAlignment[]{legendVerticalAlignment, legendVerticalAlignment2, legendVerticalAlignment3};
        }

        public static LegendVerticalAlignment valueOf(String str) {
            return (LegendVerticalAlignment) Enum.valueOf(LegendVerticalAlignment.class, str);
        }

        public static LegendVerticalAlignment[] values() {
            return (LegendVerticalAlignment[]) $VALUES.clone();
        }
    }
}
