package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class YAxisRendererRadarChart extends YAxisRenderer {
    public RadarChart mChart;

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public final void computeAxisValues(float f, float f2) {
        int i;
        AxisBase axisBase = this.mAxis;
        int i2 = axisBase.mLabelCount;
        double dAbs = Math.abs(f2 - f);
        if (i2 == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            axisBase.mEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double dRoundToNextSignificant = Utils.roundToNextSignificant(dAbs / ((double) i2));
        double dRoundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(dRoundToNextSignificant)));
        if (((int) (dRoundToNextSignificant / dRoundToNextSignificant2)) > 5) {
            double d = dRoundToNextSignificant2 * 10.0d;
            if (Math.floor(d) != 0.0d) {
                dRoundToNextSignificant = Math.floor(d);
            }
        }
        double dCeil = dRoundToNextSignificant == 0.0d ? 0.0d : Math.ceil(((double) f) / dRoundToNextSignificant) * dRoundToNextSignificant;
        double dNextUp = dRoundToNextSignificant == 0.0d ? 0.0d : Utils.nextUp(Math.floor(((double) f2) / dRoundToNextSignificant) * dRoundToNextSignificant);
        if (dRoundToNextSignificant != 0.0d) {
            i = 0;
            for (double d2 = dCeil; d2 <= dNextUp; d2 += dRoundToNextSignificant) {
                i++;
            }
        } else {
            i = 0;
        }
        int i3 = i + 1;
        axisBase.mEntryCount = i3;
        if (axisBase.mEntries.length < i3) {
            axisBase.mEntries = new float[i3];
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (dCeil == 0.0d) {
                dCeil = 0.0d;
            }
            axisBase.mEntries[i4] = (float) dCeil;
            dCeil += dRoundToNextSignificant;
        }
        axisBase.mDecimals = dRoundToNextSignificant < 1.0d ? (int) Math.ceil(-Math.log10(dRoundToNextSignificant)) : 0;
        float[] fArr = axisBase.mEntries;
        float f3 = fArr[0];
        axisBase.mAxisMinimum = f3;
        float f4 = fArr[i];
        axisBase.mAxisMaximum = f4;
        axisBase.mAxisRange = Math.abs(f4 - f3);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void renderAxisLabels(Canvas canvas) {
        RadarChart radarChart = this.mChart;
        YAxis yAxis = this.mYAxis;
        if (yAxis.mEnabled && yAxis.mDrawLabels) {
            Paint paint = this.mAxisLabelPaint;
            paint.setTypeface(null);
            paint.setTextSize(yAxis.mTextSize);
            paint.setColor(yAxis.mTextColor);
            MPPointF centerOffsets = radarChart.getCenterOffsets();
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            RectF rectF = radarChart.mViewPortHandler.mContentRect;
            float fMin = Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f) / radarChart.mYAxis.mAxisRange;
            boolean z = yAxis.mDrawTopYLabelEntry;
            int i = yAxis.mEntryCount;
            if (!z) {
                i--;
            }
            float f = yAxis.mXLabelOffset;
            for (int i2 = !yAxis.mDrawBottomYLabelEntry ? 1 : 0; i2 < i; i2++) {
                float f2 = (yAxis.mEntries[i2] - yAxis.mAxisMinimum) * fMin;
                float f3 = radarChart.mRotationAngle;
                Rect rect = Utils.mCalcTextHeightRect;
                double d = f2;
                double d2 = f3;
                mPPointF.x = (float) ((Math.cos(Math.toRadians(d2)) * d) + ((double) centerOffsets.x));
                mPPointF.y = (float) ((Math.sin(Math.toRadians(d2)) * d) + ((double) centerOffsets.y));
                canvas.drawText(yAxis.getFormattedLabel(i2), mPPointF.x + f, mPPointF.y, paint);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void renderLimitLines() {
        if (this.mYAxis.mLimitLines == null) {
            return;
        }
        this.mChart.getSliceAngle();
        throw null;
    }
}
