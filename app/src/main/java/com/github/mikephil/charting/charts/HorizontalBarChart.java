package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;
import defpackage.e91;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarChart extends BarChart {
    public final RectF mOffsetsBuffer;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.HorizontalBarChart$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass1 {
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

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffsetsBuffer = new RectF();
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffsetsBuffer = new RectF();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void calculateLegendOffsets(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.mLegend;
        if (legend == null || !legend.mEnabled) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[legend.mOrientation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
            if (i2 == 1) {
                float f = rectF.top;
                Legend legend2 = this.mLegend;
                float fMin = this.mLegend.mYOffset + Math.min(legend2.mNeededHeight, legend2.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f;
                rectF.top = fMin;
                YAxis yAxis = this.mAxisLeft;
                if (yAxis.mEnabled && yAxis.mDrawLabels) {
                    rectF.top = yAxis.getRequiredHeightSpace(this.mAxisRendererLeft.mAxisLabelPaint) + fMin;
                    return;
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            float f2 = rectF.bottom;
            Legend legend3 = this.mLegend;
            float fMin2 = this.mLegend.mYOffset + Math.min(legend3.mNeededHeight, legend3.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f2;
            rectF.bottom = fMin2;
            YAxis yAxis2 = this.mAxisRight;
            if (yAxis2.mEnabled && yAxis2.mDrawLabels) {
                rectF.bottom = yAxis2.getRequiredHeightSpace(this.mAxisRendererRight.mAxisLabelPaint) + fMin2;
                return;
            }
            return;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.mHorizontalAlignment.ordinal()];
        if (i3 == 1) {
            float f3 = rectF.left;
            Legend legend4 = this.mLegend;
            rectF.left = this.mLegend.mXOffset + Math.min(legend4.mNeededWidth, legend4.mMaxSizePercent * this.mViewPortHandler.mChartWidth) + f3;
            return;
        }
        if (i3 == 2) {
            float f4 = rectF.right;
            Legend legend5 = this.mLegend;
            rectF.right = this.mLegend.mXOffset + Math.min(legend5.mNeededWidth, legend5.mMaxSizePercent * this.mViewPortHandler.mChartWidth) + f4;
            return;
        }
        if (i3 != 3) {
            return;
        }
        int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
        if (i4 == 1) {
            float f5 = rectF.top;
            Legend legend6 = this.mLegend;
            rectF.top = this.mLegend.mYOffset + Math.min(legend6.mNeededHeight, legend6.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f5;
            return;
        }
        if (i4 != 2) {
            return;
        }
        float f6 = rectF.bottom;
        Legend legend7 = this.mLegend;
        rectF.bottom = this.mLegend.mYOffset + Math.min(legend7.mNeededHeight, legend7.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f6;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void calculateOffsets() {
        RectF rectF = this.mOffsetsBuffer;
        calculateLegendOffsets(rectF);
        float f = rectF.left + 0.0f;
        float requiredHeightSpace = rectF.top + 0.0f;
        float f2 = rectF.right + 0.0f;
        float requiredHeightSpace2 = rectF.bottom + 0.0f;
        if (this.mAxisLeft.needsOffset()) {
            requiredHeightSpace += this.mAxisLeft.getRequiredHeightSpace(this.mAxisRendererLeft.mAxisLabelPaint);
        }
        if (this.mAxisRight.needsOffset()) {
            requiredHeightSpace2 += this.mAxisRight.getRequiredHeightSpace(this.mAxisRendererRight.mAxisLabelPaint);
        }
        XAxis xAxis = this.mXAxis;
        float f3 = xAxis.mLabelRotatedWidth;
        if (xAxis.mEnabled) {
            XAxis.XAxisPosition xAxisPosition = xAxis.mPosition;
            if (xAxisPosition == XAxis.XAxisPosition.BOTTOM) {
                f += f3;
            } else if (xAxisPosition == XAxis.XAxisPosition.TOP) {
                f2 += f3;
            } else if (xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                f += f3;
                f2 += f3;
            }
        }
        float f4 = 0.0f + f;
        float fConvertDpToPixel = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max(fConvertDpToPixel, f4), Math.max(fConvertDpToPixel, requiredHeightSpace + 0.0f), Math.max(fConvertDpToPixel, f2 + 0.0f), Math.max(fConvertDpToPixel, requiredHeightSpace2 + 0.0f));
        e91 e91Var = this.mRightAxisTransformer;
        this.mAxisRight.getClass();
        e91Var.prepareMatrixOffset();
        e91 e91Var2 = this.mLeftAxisTransformer;
        this.mAxisLeft.getClass();
        e91Var2.prepareMatrixOffset();
        prepareValuePxMatrix();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public final float getHighestVisibleX() {
        e91 transformer = getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        float f = rectF.left;
        float f2 = rectF.top;
        MPPointD mPPointD = this.posForGetHighestVisibleX;
        transformer.getValuesByTouchPoint(f, f2, mPPointD);
        return (float) Math.min(this.mXAxis.mAxisMaximum, mPPointD.y);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public final Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            return null;
        }
        return this.mHighlighter.getHighlight(f2, f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public final float getLowestVisibleX() {
        e91 transformer = getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        float f = rectF.left;
        float f2 = rectF.bottom;
        MPPointD mPPointD = this.posForGetLowestVisibleX;
        transformer.getValuesByTouchPoint(f, f2, mPPointD);
        return (float) Math.max(this.mXAxis.mAxisMinimum, mPPointD.y);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        this.mViewPortHandler = new HorizontalViewPortHandler();
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        HorizontalBarChartRenderer horizontalBarChartRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        new RectF();
        horizontalBarChartRenderer.mValuePaint.setTextAlign(Paint.Align.LEFT);
        this.mRenderer = horizontalBarChartRenderer;
        this.mHighlighter = new HorizontalBarHighlighter(this, 0);
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        XAxisRendererRadarChart xAxisRendererRadarChart = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, 1);
        xAxisRendererRadarChart.mChart = new Path();
        this.mXAxisRenderer = xAxisRendererRadarChart;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void prepareValuePxMatrix() {
        e91 e91Var = this.mRightAxisTransformer;
        YAxis yAxis = this.mAxisRight;
        float f = yAxis.mAxisMinimum;
        float f2 = yAxis.mAxisRange;
        XAxis xAxis = this.mXAxis;
        e91Var.prepareMatrixValuePx(f, f2, xAxis.mAxisRange, xAxis.mAxisMinimum);
        e91 e91Var2 = this.mLeftAxisTransformer;
        YAxis yAxis2 = this.mAxisLeft;
        float f3 = yAxis2.mAxisMinimum;
        float f4 = yAxis2.mAxisRange;
        XAxis xAxis2 = this.mXAxis;
        e91Var2.prepareMatrixValuePx(f3, f4, xAxis2.mAxisRange, xAxis2.mAxisMinimum);
    }
}
