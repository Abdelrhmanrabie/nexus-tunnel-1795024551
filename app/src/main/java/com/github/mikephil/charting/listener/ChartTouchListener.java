package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChartTouchListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    public final Chart mChart;
    public final GestureDetector mGestureDetector;
    public Highlight mLastHighlighted;
    public int mTouchMode;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class ChartGesture {
        public static final /* synthetic */ ChartGesture[] $VALUES = {new ChartGesture("NONE", 0), new ChartGesture("DRAG", 1), new ChartGesture("X_ZOOM", 2), new ChartGesture("Y_ZOOM", 3), new ChartGesture("PINCH_ZOOM", 4), new ChartGesture("ROTATE", 5), new ChartGesture("SINGLE_TAP", 6), new ChartGesture("DOUBLE_TAP", 7), new ChartGesture("LONG_PRESS", 8), new ChartGesture("FLING", 9)};

        /* JADX INFO: Fake field, exist only in values array */
        ChartGesture EF5;

        public static ChartGesture valueOf(String str) {
            return (ChartGesture) Enum.valueOf(ChartGesture.class, str);
        }

        public static ChartGesture[] values() {
            return (ChartGesture[]) $VALUES.clone();
        }
    }

    public ChartTouchListener(Chart chart) {
        ChartGesture[] chartGestureArr = ChartGesture.$VALUES;
        this.mTouchMode = 0;
        this.mChart = chart;
        this.mGestureDetector = new GestureDetector(chart.getContext(), this);
    }
}
