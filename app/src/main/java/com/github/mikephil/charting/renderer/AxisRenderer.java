package com.github.mikephil.charting.renderer;

import android.graphics.Paint;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.e91;
import defpackage.j0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AxisRenderer extends j0 {
    public final AxisBase mAxis;
    public final Paint mAxisLabelPaint;
    public final Paint mAxisLinePaint;
    public final Paint mGridPaint;
    public final Paint mLimitLinePaint;
    public final e91 mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, e91 e91Var, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = e91Var;
        this.mAxis = axisBase;
        if (viewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            paint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(-16777216);
            paint2.setStrokeWidth(1.0f);
            paint2.setStyle(style);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(style);
        }
    }

    public void computeAxis(float f, float f2) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        if (viewPortHandler != null) {
            RectF rectF = viewPortHandler.mContentRect;
            if (rectF.width() > 10.0f && !viewPortHandler.isFullyZoomedOutY()) {
                float f3 = rectF.left;
                float f4 = rectF.top;
                e91 e91Var = this.mTrans;
                MPPointD valuesByTouchPoint = e91Var.getValuesByTouchPoint(f3, f4);
                MPPointD valuesByTouchPoint2 = e91Var.getValuesByTouchPoint(rectF.left, rectF.bottom);
                float f5 = (float) valuesByTouchPoint2.y;
                float f6 = (float) valuesByTouchPoint.y;
                MPPointD.recycleInstance(valuesByTouchPoint);
                MPPointD.recycleInstance(valuesByTouchPoint2);
                f = f5;
                f2 = f6;
            }
        }
        computeAxisValues(f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0083  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f A[SYNTHETIC] */
    public void computeAxisValues(float f, float f2) {
        int i;
        int i2;
        int i3;
        AxisBase axisBase = this.mAxis;
        int i4 = axisBase.mLabelCount;
        double dAbs = Math.abs(f2 - f);
        if (i4 == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            axisBase.mEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double dRoundToNextSignificant = Utils.roundToNextSignificant(dAbs / ((double) i4));
        double dRoundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(dRoundToNextSignificant)));
        if (((int) (dRoundToNextSignificant / dRoundToNextSignificant2)) > 5) {
            double d = dRoundToNextSignificant2 * 10.0d;
            if (Math.floor(d) != 0.0d) {
                dRoundToNextSignificant = Math.floor(d);
            }
        }
        double dCeil = dRoundToNextSignificant == 0.0d ? 0.0d : Math.ceil(((double) f) / dRoundToNextSignificant) * dRoundToNextSignificant;
        double dNextUp = dRoundToNextSignificant == 0.0d ? 0.0d : Utils.nextUp(Math.floor(((double) f2) / dRoundToNextSignificant) * dRoundToNextSignificant);
        if (dRoundToNextSignificant == 0.0d || dNextUp == dCeil) {
            if (dNextUp == dCeil) {
                i2 = 1;
            } else {
                i = 0;
            }
            axisBase.mEntryCount = i2;
            if (axisBase.mEntries.length < i2) {
                axisBase.mEntries = new float[i2];
            }
            for (i3 = 0; i3 < i2; i3++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                axisBase.mEntries[i3] = (float) dCeil;
                dCeil += dRoundToNextSignificant;
            }
            axisBase.mDecimals = dRoundToNextSignificant < 1.0d ? (int) Math.ceil(-Math.log10(dRoundToNextSignificant)) : 0;
        }
        i = 0;
        for (double d2 = dCeil; d2 <= dNextUp; d2 += dRoundToNextSignificant) {
            i++;
        }
        i2 = i;
        axisBase.mEntryCount = i2;
        if (axisBase.mEntries.length < i2) {
            axisBase.mEntries = new float[i2];
        }
        while (i3 < i2) {
            if (dCeil == 0.0d) {
                dCeil = 0.0d;
            }
            axisBase.mEntries[i3] = (float) dCeil;
            dCeil += dRoundToNextSignificant;
        }
        axisBase.mDecimals = dRoundToNextSignificant < 1.0d ? (int) Math.ceil(-Math.log10(dRoundToNextSignificant)) : 0;
    }
}
