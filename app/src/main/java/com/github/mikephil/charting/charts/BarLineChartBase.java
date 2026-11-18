package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.e91;
import defpackage.g;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BarLineChartBase<T extends LineData> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    public YAxis mAxisLeft;
    public YAxisRenderer mAxisRendererLeft;
    public YAxisRenderer mAxisRendererRight;
    public YAxis mAxisRight;
    public Paint mBorderPaint;
    public boolean mClipDataToContent;
    public boolean mDoubleTapToZoomEnabled;
    public boolean mDragXEnabled;
    public boolean mDragYEnabled;
    public Paint mGridBackgroundPaint;
    public boolean mHighlightPerDragEnabled;
    public e91 mLeftAxisTransformer;
    public int mMaxVisibleCount;
    public float mMinOffset;
    public RectF mOffsetsBuffer;
    public float[] mOnSizeChangedBuffer;
    public e91 mRightAxisTransformer;
    public boolean mScaleXEnabled;
    public boolean mScaleYEnabled;
    public XAxisRenderer mXAxisRenderer;
    public Matrix mZoomMatrixBuffer;
    public MPPointD posForGetHighestVisibleX;
    public MPPointD posForGetLowestVisibleX;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2, reason: invalid class name */
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

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxVisibleCount = 100;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mClipDataToContent = true;
        this.mMinOffset = 15.0f;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        new Matrix();
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxVisibleCount = 100;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mClipDataToContent = true;
        this.mMinOffset = 15.0f;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        new Matrix();
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public void calcMinMax() {
        XAxis xAxis = this.mXAxis;
        LineData lineData = this.mData;
        float f = lineData.mXMin;
        float f2 = lineData.mXMax;
        float f3 = xAxis.mCustomAxisMin ? xAxis.mAxisMinimum : f - xAxis.mSpaceMin;
        float f4 = f2 + xAxis.mSpaceMax;
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        xAxis.mAxisMinimum = f3;
        xAxis.mAxisMaximum = f4;
        xAxis.mAxisRange = Math.abs(f4 - f3);
        YAxis yAxis = this.mAxisLeft;
        LineData lineData2 = this.mData;
        YAxis.AxisDependency[] axisDependencyArr = YAxis.AxisDependency.$VALUES;
        lineData2.getClass();
        float f5 = lineData2.mLeftAxisMin;
        if (f5 == Float.MAX_VALUE) {
            f5 = lineData2.mRightAxisMin;
        }
        LineData lineData3 = this.mData;
        lineData3.getClass();
        float f6 = lineData3.mLeftAxisMax;
        if (f6 == -3.4028235E38f) {
            f6 = lineData3.mRightAxisMax;
        }
        yAxis.calculate(f5, f6);
        YAxis yAxis2 = this.mAxisRight;
        LineData lineData4 = this.mData;
        lineData4.getClass();
        float f7 = lineData4.mRightAxisMin;
        if (f7 == Float.MAX_VALUE) {
            f7 = lineData4.mLeftAxisMin;
        }
        LineData lineData5 = this.mData;
        lineData5.getClass();
        float f8 = lineData5.mRightAxisMax;
        if (f8 == -3.4028235E38f) {
            f8 = lineData5.mLeftAxisMax;
        }
        yAxis2.calculate(f7, f8);
    }

    public void calculateLegendOffsets(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.mLegend;
        if (legend == null || !legend.mEnabled) {
            return;
        }
        int i = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[legend.mOrientation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            int i2 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                float f = rectF.bottom;
                Legend legend2 = this.mLegend;
                rectF.bottom = this.mLegend.mYOffset + Math.min(legend2.mNeededHeight, legend2.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f;
                return;
            }
            float f2 = rectF.top;
            Legend legend3 = this.mLegend;
            rectF.top = this.mLegend.mYOffset + Math.min(legend3.mNeededHeight, legend3.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f2;
        }
        int i3 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.mHorizontalAlignment.ordinal()];
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
        int i4 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.mVerticalAlignment.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            float f5 = rectF.bottom;
            Legend legend6 = this.mLegend;
            rectF.bottom = this.mLegend.mYOffset + Math.min(legend6.mNeededHeight, legend6.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f5;
            return;
        }
        float f6 = rectF.top;
        Legend legend7 = this.mLegend;
        rectF.top = this.mLegend.mYOffset + Math.min(legend7.mNeededHeight, legend7.mMaxSizePercent * this.mViewPortHandler.mChartHeight) + f6;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        RectF rectF = this.mOffsetsBuffer;
        calculateLegendOffsets(rectF);
        float requiredWidthSpace = rectF.left + 0.0f;
        float f = rectF.top + 0.0f;
        float requiredWidthSpace2 = rectF.right + 0.0f;
        float f2 = rectF.bottom + 0.0f;
        if (this.mAxisLeft.needsOffset()) {
            requiredWidthSpace += this.mAxisLeft.getRequiredWidthSpace(this.mAxisRendererLeft.mAxisLabelPaint);
        }
        if (this.mAxisRight.needsOffset()) {
            requiredWidthSpace2 += this.mAxisRight.getRequiredWidthSpace(this.mAxisRendererRight.mAxisLabelPaint);
        }
        XAxis xAxis = this.mXAxis;
        if (xAxis.mEnabled && xAxis.mDrawLabels) {
            float f3 = xAxis.mYOffset + xAxis.mLabelRotatedHeight;
            XAxis.XAxisPosition xAxisPosition = xAxis.mPosition;
            if (xAxisPosition == XAxis.XAxisPosition.BOTTOM) {
                f2 += f3;
            } else if (xAxisPosition == XAxis.XAxisPosition.TOP) {
                f += f3;
            } else if (xAxisPosition == XAxis.XAxisPosition.BOTH_SIDED) {
                f2 += f3;
                f += f3;
            }
        }
        float f4 = 0.0f + requiredWidthSpace;
        float fConvertDpToPixel = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max(fConvertDpToPixel, f4), Math.max(fConvertDpToPixel, f + 0.0f), Math.max(fConvertDpToPixel, requiredWidthSpace2 + 0.0f), Math.max(fConvertDpToPixel, f2 + 0.0f));
        e91 e91Var = this.mRightAxisTransformer;
        this.mAxisRight.getClass();
        e91Var.prepareMatrixOffset();
        e91 e91Var2 = this.mLeftAxisTransformer;
        this.mAxisLeft.getClass();
        e91Var2.prepareMatrixOffset();
        prepareValuePxMatrix();
    }

    @Override // android.view.View
    public final void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof BarLineChartTouchListener) {
            BarLineChartTouchListener barLineChartTouchListener = (BarLineChartTouchListener) chartTouchListener;
            MPPointF mPPointF = barLineChartTouchListener.mDecelerationVelocity;
            Chart chart = barLineChartTouchListener.mChart;
            MPPointF mPPointF2 = barLineChartTouchListener.mTouchStartPoint;
            MPPointF mPPointF3 = barLineChartTouchListener.mDecelerationCurrentPoint;
            if (mPPointF.x == 0.0f && mPPointF.y == 0.0f) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = mPPointF.x;
            BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
            float f2 = barLineChartBase.mDragDecelerationFrictionCoef;
            float f3 = f * f2;
            mPPointF.x = f3;
            float f4 = f2 * mPPointF.y;
            mPPointF.y = f4;
            float f5 = (jCurrentAnimationTimeMillis - barLineChartTouchListener.mDecelerationLastTime) / 1000.0f;
            float f6 = mPPointF3.x + (f3 * f5);
            mPPointF3.x = f6;
            float f7 = mPPointF3.y + (f4 * f5);
            mPPointF3.y = f7;
            MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f6, f7, 0);
            float f8 = barLineChartBase.mDragXEnabled ? mPPointF3.x - mPPointF2.x : 0.0f;
            float f9 = barLineChartBase.mDragYEnabled ? mPPointF3.y - mPPointF2.y : 0.0f;
            ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
            barLineChartTouchListener.mMatrix.set(barLineChartTouchListener.mSavedMatrix);
            barLineChartTouchListener.inverted();
            barLineChartTouchListener.mMatrix.postTranslate(f8, f9);
            motionEventObtain.recycle();
            ViewPortHandler viewPortHandler = barLineChartBase.mViewPortHandler;
            Matrix matrix = barLineChartTouchListener.mMatrix;
            viewPortHandler.refresh(matrix, chart, false);
            barLineChartTouchListener.mMatrix = matrix;
            barLineChartTouchListener.mDecelerationLastTime = jCurrentAnimationTimeMillis;
            if (Math.abs(mPPointF.x) >= 0.01d || Math.abs(mPPointF.y) >= 0.01d) {
                Rect rect = Utils.mCalcTextHeightRect;
                chart.postInvalidateOnAnimation();
            } else {
                barLineChartBase.calculateOffsets();
                barLineChartBase.postInvalidate();
                mPPointF.x = 0.0f;
                mPPointF.y = 0.0f;
            }
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        e91 transformer = getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        float f = rectF.right;
        float f2 = rectF.bottom;
        MPPointD mPPointD = this.posForGetHighestVisibleX;
        transformer.getValuesByTouchPoint(f, f2, mPPointD);
        return (float) Math.min(this.mXAxis.mAxisMaximum, mPPointD.x);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        e91 transformer = getTransformer(YAxis.AxisDependency.LEFT);
        RectF rectF = this.mViewPortHandler.mContentRect;
        float f = rectF.left;
        float f2 = rectF.bottom;
        MPPointD mPPointD = this.posForGetLowestVisibleX;
        transformer.getValuesByTouchPoint(f, f2, mPPointD);
        return (float) Math.max(this.mXAxis.mAxisMinimum, mPPointD.x);
    }

    @Override // android.view.View
    public final float getScaleX() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.mScaleX;
    }

    @Override // android.view.View
    public final float getScaleY() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.mScaleY;
    }

    public final e91 getTransformer(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.mLeftAxisTransformer : this.mRightAxisTransformer;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new e91(this.mViewPortHandler);
        this.mRightAxisTransformer = new e91(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        this.mHighlighter = new g((BarLineChartBase) this);
        Matrix matrix = this.mViewPortHandler.mMatrixTouch;
        BarLineChartTouchListener barLineChartTouchListener = new BarLineChartTouchListener(this);
        barLineChartTouchListener.mMatrix = new Matrix();
        barLineChartTouchListener.mSavedMatrix = new Matrix();
        barLineChartTouchListener.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        barLineChartTouchListener.mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
        barLineChartTouchListener.mSavedXDist = 1.0f;
        barLineChartTouchListener.mSavedYDist = 1.0f;
        barLineChartTouchListener.mSavedDist = 1.0f;
        barLineChartTouchListener.mDecelerationLastTime = 0L;
        barLineChartTouchListener.mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
        barLineChartTouchListener.mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
        barLineChartTouchListener.mMatrix = matrix;
        barLineChartTouchListener.mDragTriggerDist = Utils.convertDpToPixel(3.0f);
        barLineChartTouchListener.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
        this.mChartTouchListener = barLineChartTouchListener;
        Paint paint = new Paint();
        this.mGridBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null) {
            dataRenderer.initBuffers();
        }
        calcMinMax();
        YAxisRenderer yAxisRenderer = this.mAxisRendererLeft;
        YAxis yAxis = this.mAxisLeft;
        yAxisRenderer.computeAxis(yAxis.mAxisMinimum, yAxis.mAxisMaximum);
        YAxisRenderer yAxisRenderer2 = this.mAxisRendererRight;
        YAxis yAxis2 = this.mAxisRight;
        yAxisRenderer2.computeAxis(yAxis2.mAxisMinimum, yAxis2.mAxisMaximum);
        XAxisRenderer xAxisRenderer = this.mXAxisRenderer;
        XAxis xAxis = this.mXAxis;
        xAxisRenderer.computeAxis(xAxis.mAxisMinimum, xAxis.mAxisMaximum);
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == null) {
            return;
        }
        System.currentTimeMillis();
        YAxis yAxis = this.mAxisLeft;
        if (yAxis.mEnabled) {
            this.mAxisRendererLeft.computeAxis(yAxis.mAxisMinimum, yAxis.mAxisMaximum);
        }
        YAxis yAxis2 = this.mAxisRight;
        if (yAxis2.mEnabled) {
            this.mAxisRendererRight.computeAxis(yAxis2.mAxisMinimum, yAxis2.mAxisMaximum);
        }
        XAxis xAxis = this.mXAxis;
        if (xAxis.mEnabled) {
            this.mXAxisRenderer.computeAxis(xAxis.mAxisMinimum, xAxis.mAxisMaximum);
        }
        this.mXAxisRenderer.renderAxisLine(canvas);
        this.mAxisRendererLeft.renderAxisLine(canvas);
        this.mAxisRendererRight.renderAxisLine(canvas);
        if (this.mXAxis.mDrawGridLinesBehindData) {
            this.mXAxisRenderer.renderGridLines(canvas);
        }
        if (this.mAxisLeft.mDrawGridLinesBehindData) {
            this.mAxisRendererLeft.renderGridLines(canvas);
        }
        if (this.mAxisRight.mDrawGridLinesBehindData) {
            this.mAxisRendererRight.renderGridLines(canvas);
        }
        boolean z = this.mXAxis.mEnabled;
        boolean z2 = this.mAxisLeft.mEnabled;
        boolean z3 = this.mAxisRight.mEnabled;
        int iSave = canvas.save();
        if (this.mClipDataToContent) {
            canvas.clipRect(this.mViewPortHandler.mContentRect);
        }
        this.mRenderer.drawData(canvas);
        if (!this.mXAxis.mDrawGridLinesBehindData) {
            this.mXAxisRenderer.renderGridLines(canvas);
        }
        if (!this.mAxisLeft.mDrawGridLinesBehindData) {
            this.mAxisRendererLeft.renderGridLines(canvas);
        }
        if (!this.mAxisRight.mDrawGridLinesBehindData) {
            this.mAxisRendererRight.renderGridLines(canvas);
        }
        Highlight[] highlightArr = this.mIndicesToHighlight;
        if (highlightArr != null && highlightArr.length > 0 && highlightArr[0] != null) {
            this.mRenderer.drawHighlighted(canvas, highlightArr);
        }
        canvas.restoreToCount(iSave);
        this.mRenderer.drawExtras(canvas);
        if (this.mXAxis.mEnabled) {
            this.mXAxisRenderer.renderLimitLines();
        }
        if (this.mAxisLeft.mEnabled) {
            this.mAxisRendererLeft.renderLimitLines();
        }
        if (this.mAxisRight.mEnabled) {
            this.mAxisRendererRight.renderLimitLines();
        }
        this.mXAxisRenderer.renderAxisLabels(canvas);
        this.mAxisRendererLeft.renderAxisLabels(canvas);
        this.mAxisRendererRight.renderAxisLabels(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.mOnSizeChangedBuffer;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        super.onSizeChanged(i, i2, i3, i4);
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        viewPortHandler.refresh(viewPortHandler.mMatrixTouch, this, true);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener == null || this.mData == null || !this.mTouchEnabled) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void prepareValuePxMatrix() {
        e91 e91Var = this.mRightAxisTransformer;
        XAxis xAxis = this.mXAxis;
        float f = xAxis.mAxisMinimum;
        float f2 = xAxis.mAxisRange;
        YAxis yAxis = this.mAxisRight;
        e91Var.prepareMatrixValuePx(f, f2, yAxis.mAxisRange, yAxis.mAxisMinimum);
        e91 e91Var2 = this.mLeftAxisTransformer;
        XAxis xAxis2 = this.mXAxis;
        float f3 = xAxis2.mAxisMinimum;
        float f4 = xAxis2.mAxisRange;
        YAxis yAxis2 = this.mAxisLeft;
        e91Var2.prepareMatrixValuePx(f3, f4, yAxis2.mAxisRange, yAxis2.mAxisMinimum);
    }
}
