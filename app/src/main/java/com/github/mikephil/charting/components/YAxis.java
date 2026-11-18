package com.github.mikephil.charting.components;

import android.graphics.Paint;
import android.graphics.Rect;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class YAxis extends AxisBase {
    public final AxisDependency mAxisDependency;
    public final boolean mDrawBottomYLabelEntry = true;
    public final boolean mDrawTopYLabelEntry = true;
    public final float mSpacePercentTop = 10.0f;
    public final float mSpacePercentBottom = 10.0f;
    public final YAxisLabelPosition mPosition = YAxisLabelPosition.OUTSIDE_CHART;
    public float mXLabelOffset = 0.0f;
    public final float mMaxWidth = Float.POSITIVE_INFINITY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class AxisDependency {
        public static final /* synthetic */ AxisDependency[] $VALUES;
        public static final AxisDependency LEFT;
        public static final AxisDependency RIGHT;

        static {
            AxisDependency axisDependency = new AxisDependency("LEFT", 0);
            LEFT = axisDependency;
            AxisDependency axisDependency2 = new AxisDependency("RIGHT", 1);
            RIGHT = axisDependency2;
            $VALUES = new AxisDependency[]{axisDependency, axisDependency2};
        }

        public static AxisDependency valueOf(String str) {
            return (AxisDependency) Enum.valueOf(AxisDependency.class, str);
        }

        public static AxisDependency[] values() {
            return (AxisDependency[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class YAxisLabelPosition {
        public static final /* synthetic */ YAxisLabelPosition[] $VALUES;
        public static final YAxisLabelPosition OUTSIDE_CHART;

        static {
            YAxisLabelPosition yAxisLabelPosition = new YAxisLabelPosition("OUTSIDE_CHART", 0);
            OUTSIDE_CHART = yAxisLabelPosition;
            $VALUES = new YAxisLabelPosition[]{yAxisLabelPosition, new YAxisLabelPosition("INSIDE_CHART", 1)};
        }

        public static YAxisLabelPosition valueOf(String str) {
            return (YAxisLabelPosition) Enum.valueOf(YAxisLabelPosition.class, str);
        }

        public static YAxisLabelPosition[] values() {
            return (YAxisLabelPosition[]) $VALUES.clone();
        }
    }

    public YAxis(AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }

    public final void calculate(float f, float f2) {
        float f3;
        if (f > f2 && this.mCustomAxisMin) {
            f2 = (f < 0.0f ? 0.5f : 1.5f) * f;
        }
        if (Math.abs(f2 - f) == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float fAbs = Math.abs(f2 - f);
        if (this.mCustomAxisMin) {
            f3 = this.mAxisMinimum;
        } else {
            f3 = f - (this.mSpacePercentBottom * (fAbs / 100.0f));
        }
        this.mAxisMinimum = f3;
        float f4 = (this.mSpacePercentTop * (fAbs / 100.0f)) + f2;
        this.mAxisMaximum = f4;
        this.mAxisRange = Math.abs(f3 - f4);
    }

    public final float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return (this.mYOffset * 2.0f) + Utils.calcTextHeight(paint, getLongestLabel());
    }

    public final float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        String longestLabel = getLongestLabel();
        Rect rect = Utils.mCalcTextHeightRect;
        float fMeasureText = (this.mXOffset * 2.0f) + ((int) paint.measureText(longestLabel));
        float fConvertDpToPixel = this.mMaxWidth;
        if (fConvertDpToPixel > 0.0f && fConvertDpToPixel != Float.POSITIVE_INFINITY) {
            fConvertDpToPixel = Utils.convertDpToPixel(fConvertDpToPixel);
        }
        if (fConvertDpToPixel <= 0.0d) {
            fConvertDpToPixel = fMeasureText;
        }
        return Math.max(0.0f, Math.min(fMeasureText, fConvertDpToPixel));
    }

    public final boolean needsOffset() {
        return this.mEnabled && this.mDrawLabels && this.mPosition == YAxisLabelPosition.OUTSIDE_CHART;
    }
}
