package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultAxisValueFormatter implements IAxisValueFormatter {
    public int digits;
    public DecimalFormat mFormat;

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    public final String getFormattedValue(float f, AxisBase axisBase) {
        return this.mFormat.format(f);
    }
}
