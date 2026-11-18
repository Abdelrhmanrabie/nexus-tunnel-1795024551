package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends LineData> extends Chart<T> {
    public float mRawRotationAngle;
    public final boolean mRotateEnabled;
    public float mRotationAngle;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
                Legend.LegendOrientation[] legendOrientationArr = Legend.LegendOrientation.$VALUES;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr3 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr3;
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
                Legend.LegendHorizontalAlignment[] legendHorizontalAlignmentArr = Legend.LegendHorizontalAlignment.$VALUES;
                iArr4[2] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
                Legend.LegendHorizontalAlignment[] legendHorizontalAlignmentArr2 = Legend.LegendHorizontalAlignment.$VALUES;
                iArr5[1] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr6 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr6;
            try {
                iArr6[0] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;
                Legend.LegendVerticalAlignment[] legendVerticalAlignmentArr = Legend.LegendVerticalAlignment.$VALUES;
                iArr7[2] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
    }

    public void calcMinMax() {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    /* JADX WARN: Code duplicated, block: B:52:0x014b  */
    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        float f;
        float requiredBaseOffset;
        float requiredBaseOffset2;
        float requiredBaseOffset3;
        float requiredBaseOffset4;
        float fConvertDpToPixel;
        float fMin;
        float f2;
        float fMin2;
        Legend.LegendVerticalAlignment legendVerticalAlignment;
        Legend legend = this.mLegend;
        float f3 = 0.0f;
        if (legend == null || !legend.mEnabled) {
            f = 0.0f;
            requiredBaseOffset = 0.0f;
            requiredBaseOffset2 = 0.0f;
            requiredBaseOffset3 = 0.0f;
            requiredBaseOffset4 = 0.0f;
        } else {
            float fMin3 = Math.min(legend.mNeededWidth, legend.mMaxSizePercent * this.mViewPortHandler.mChartWidth);
            int i = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.mOrientation.ordinal()];
            if (i == 1) {
                Legend legend2 = this.mLegend;
                Legend.LegendHorizontalAlignment legendHorizontalAlignment = legend2.mHorizontalAlignment;
                if (legendHorizontalAlignment != Legend.LegendHorizontalAlignment.LEFT && legendHorizontalAlignment != Legend.LegendHorizontalAlignment.RIGHT) {
                    fConvertDpToPixel = 0.0f;
                    f = 0.0f;
                } else if (legend2.mVerticalAlignment == Legend.LegendVerticalAlignment.CENTER) {
                    fConvertDpToPixel = Utils.convertDpToPixel(13.0f) + fMin3;
                    f = 0.0f;
                } else {
                    float fConvertDpToPixel2 = Utils.convertDpToPixel(8.0f) + fMin3;
                    Legend legend3 = this.mLegend;
                    float f4 = legend3.mNeededHeight + legend3.mTextHeightMax;
                    MPPointF mPPointF = MPPointF.getInstance(getWidth() / 2.0f, getHeight() / 2.0f);
                    float width = this.mLegend.mHorizontalAlignment == Legend.LegendHorizontalAlignment.RIGHT ? (getWidth() - fConvertDpToPixel2) + 15.0f : fConvertDpToPixel2 - 15.0f;
                    float f5 = f4 + 15.0f;
                    float fDistanceToCenter = distanceToCenter(width, f5);
                    float radius = getRadius();
                    float angleForPoint = getAngleForPoint(width, f5);
                    MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
                    double d = radius;
                    f = 0.0f;
                    double d2 = angleForPoint;
                    mPPointF2.x = (float) ((Math.cos(Math.toRadians(d2)) * d) + ((double) mPPointF.x));
                    float fSin = (float) ((Math.sin(Math.toRadians(d2)) * d) + ((double) mPPointF.y));
                    mPPointF2.y = fSin;
                    float fDistanceToCenter2 = distanceToCenter(mPPointF2.x, fSin);
                    float fConvertDpToPixel3 = Utils.convertDpToPixel(5.0f);
                    if (f5 < mPPointF.y || getHeight() - fConvertDpToPixel2 <= getWidth()) {
                        fConvertDpToPixel = fDistanceToCenter < fDistanceToCenter2 ? (fDistanceToCenter2 - fDistanceToCenter) + fConvertDpToPixel3 : 0.0f;
                    } else {
                        fConvertDpToPixel = fConvertDpToPixel2;
                    }
                    MPPointF.recycleInstance(mPPointF);
                    MPPointF.recycleInstance(mPPointF2);
                }
                int i2 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.mHorizontalAlignment.ordinal()];
                if (i2 == 1) {
                    fMin = f;
                    f3 = fMin;
                    f2 = f3;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        int i3 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                fMin2 = f;
                            } else {
                                Legend legend4 = this.mLegend;
                                fMin2 = Math.min(legend4.mNeededHeight, legend4.mMaxSizePercent * this.mViewPortHandler.mChartHeight);
                            }
                            f3 = fMin2;
                            fMin = f;
                        } else {
                            Legend legend5 = this.mLegend;
                            fMin = Math.min(legend5.mNeededHeight, legend5.mMaxSizePercent * this.mViewPortHandler.mChartHeight);
                            f3 = f;
                        }
                    } else {
                        fMin2 = f;
                        f3 = fMin2;
                        fMin = f;
                    }
                    fConvertDpToPixel = f;
                    f2 = fConvertDpToPixel;
                } else {
                    f2 = fConvertDpToPixel;
                    fMin = f;
                    f3 = fMin;
                    fConvertDpToPixel = f3;
                }
            } else if (i == 2 && ((legendVerticalAlignment = this.mLegend.mVerticalAlignment) == Legend.LegendVerticalAlignment.TOP || legendVerticalAlignment == Legend.LegendVerticalAlignment.BOTTOM)) {
                float requiredLegendOffset = getRequiredLegendOffset();
                Legend legend6 = this.mLegend;
                fMin = Math.min(legend6.mNeededHeight + requiredLegendOffset, legend6.mMaxSizePercent * this.mViewPortHandler.mChartHeight);
                int i4 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
                if (i4 == 1) {
                    fConvertDpToPixel = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                } else if (i4 != 2) {
                    fMin = 0.0f;
                    fConvertDpToPixel = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                } else {
                    fConvertDpToPixel = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                    f3 = fMin;
                    fMin = 0.0f;
                }
            } else {
                fMin = 0.0f;
                fConvertDpToPixel = 0.0f;
                f2 = 0.0f;
                f = 0.0f;
            }
            requiredBaseOffset4 = getRequiredBaseOffset() + fConvertDpToPixel;
            requiredBaseOffset2 = getRequiredBaseOffset() + f2;
            requiredBaseOffset3 = getRequiredBaseOffset() + fMin;
            requiredBaseOffset = getRequiredBaseOffset() + f3;
        }
        float fConvertDpToPixel4 = Utils.convertDpToPixel(f);
        if (this instanceof RadarChart) {
            XAxis xAxis = this.mXAxis;
            if (xAxis.mEnabled && xAxis.mDrawLabels) {
                fConvertDpToPixel4 = Math.max(fConvertDpToPixel4, xAxis.mLabelRotatedWidth);
            }
        }
        this.mViewPortHandler.restrainViewPort(Math.max(fConvertDpToPixel4, requiredBaseOffset4 + f), Math.max(fConvertDpToPixel4, requiredBaseOffset3 + f), Math.max(fConvertDpToPixel4, requiredBaseOffset2 + f), Math.max(fConvertDpToPixel4, Math.max(getRequiredBaseOffset(), requiredBaseOffset + f)));
    }

    @Override // android.view.View
    public final void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            PieRadarChartTouchListener pieRadarChartTouchListener = (PieRadarChartTouchListener) chartTouchListener;
            Chart chart = pieRadarChartTouchListener.mChart;
            if (pieRadarChartTouchListener.mDecelerationAngularVelocity == 0.0f) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) chart;
            float f = pieRadarChartBase.mDragDecelerationFrictionCoef * pieRadarChartTouchListener.mDecelerationAngularVelocity;
            pieRadarChartTouchListener.mDecelerationAngularVelocity = f;
            float f2 = (f * ((jCurrentAnimationTimeMillis - pieRadarChartTouchListener.mDecelerationLastTime) / 1000.0f)) + pieRadarChartBase.mRotationAngle;
            pieRadarChartBase.mRawRotationAngle = f2;
            Rect rect = Utils.mCalcTextHeightRect;
            while (f2 < 0.0f) {
                f2 += 360.0f;
            }
            pieRadarChartBase.mRotationAngle = f2 % 360.0f;
            pieRadarChartTouchListener.mDecelerationLastTime = jCurrentAnimationTimeMillis;
            if (Math.abs(pieRadarChartTouchListener.mDecelerationAngularVelocity) >= 0.001d) {
                chart.postInvalidateOnAnimation();
            } else {
                pieRadarChartTouchListener.mDecelerationAngularVelocity = 0.0f;
            }
        }
    }

    public final float distanceToCenter(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        float f3 = centerOffsets.x;
        float f4 = f > f3 ? f - f3 : f3 - f;
        float f5 = centerOffsets.y;
        float fSqrt = (float) Math.sqrt(Math.pow(f2 > f5 ? f2 - f5 : f5 - f2, 2.0d) + Math.pow(f4, 2.0d));
        MPPointF.recycleInstance(centerOffsets);
        return fSqrt;
    }

    public final float getAngleForPoint(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.x;
        double d2 = f2 - centerOffsets.y;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d2 * d2) + (d * d))));
        if (f > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        MPPointF.recycleInstance(centerOffsets);
        return f3;
    }

    public abstract int getIndexForAngle(float f);

    public abstract float getRadius();

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        PieRadarChartTouchListener pieRadarChartTouchListener = new PieRadarChartTouchListener(this);
        pieRadarChartTouchListener.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        pieRadarChartTouchListener.mStartAngle = 0.0f;
        pieRadarChartTouchListener._velocitySamples = new ArrayList();
        pieRadarChartTouchListener.mDecelerationLastTime = 0L;
        pieRadarChartTouchListener.mDecelerationAngularVelocity = 0.0f;
        this.mChartTouchListener = pieRadarChartTouchListener;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.mTouchEnabled || (chartTouchListener = this.mChartTouchListener) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }
}
