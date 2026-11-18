package com.github.mikephil.charting.components;

import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AxisBase extends ComponentBase {
    public IAxisValueFormatter mAxisValueFormatter;
    public int mDecimals;
    public int mEntryCount;
    public final ArrayList mLimitLines;
    public final int mGridColor = -7829368;
    public final float mGridLineWidth = 1.0f;
    public final int mAxisLineColor = -7829368;
    public final float mAxisLineWidth = 1.0f;
    public float[] mEntries = new float[0];
    public int mLabelCount = 6;
    public boolean mDrawGridLines = true;
    public final boolean mDrawAxisLine = true;
    public final boolean mDrawLabels = true;
    public final boolean mDrawGridLinesBehindData = true;
    public float mSpaceMin = 0.0f;
    public float mSpaceMax = 0.0f;
    public boolean mCustomAxisMin = false;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;
    public final int mAxisMinLabels = 2;
    public final int mAxisMaxLabels = 25;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public final String getFormattedLabel(int i) {
        return (i < 0 || i >= this.mEntries.length) ? AppConfig.CUSTOM : getValueFormatter().getFormattedValue(this.mEntries[i], this);
    }

    public final String getLongestLabel() {
        String str = AppConfig.CUSTOM;
        for (int i = 0; i < this.mEntries.length; i++) {
            String formattedLabel = getFormattedLabel(i);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public final IAxisValueFormatter getValueFormatter() {
        IAxisValueFormatter iAxisValueFormatter = this.mAxisValueFormatter;
        if (iAxisValueFormatter == null || ((iAxisValueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) iAxisValueFormatter).digits != this.mDecimals)) {
            int i = this.mDecimals;
            DefaultAxisValueFormatter defaultAxisValueFormatter = new DefaultAxisValueFormatter();
            defaultAxisValueFormatter.digits = i;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 == 0) {
                    stringBuffer.append(".");
                }
                stringBuffer.append("0");
            }
            defaultAxisValueFormatter.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
            this.mAxisValueFormatter = defaultAxisValueFormatter;
        }
        return this.mAxisValueFormatter;
    }
}
