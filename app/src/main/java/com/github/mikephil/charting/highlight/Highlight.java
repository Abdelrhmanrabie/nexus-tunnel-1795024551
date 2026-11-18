package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Highlight {
    public final YAxis.AxisDependency axis;
    public final int mDataIndex = -1;
    public final int mDataSetIndex;
    public final float mX;
    public final float mXPx;
    public final float mY;
    public final float mYPx;

    public Highlight(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.mX = f;
        this.mY = f2;
        this.mXPx = f3;
        this.mYPx = f4;
        this.mDataSetIndex = i;
        this.axis = axisDependency;
    }

    public final boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mDataIndex == highlight.mDataIndex;
    }

    public final String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): -1";
    }
}
