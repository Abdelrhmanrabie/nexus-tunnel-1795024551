package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.bj;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Chart<T extends LineData> extends ViewGroup implements ChartInterface {
    public HurlStack mAnimator;
    public ChartTouchListener mChartTouchListener;
    public LineData mData;
    public bj mDefaultValueFormatter;
    public Paint mDescPaint;
    public Description mDescription;
    public boolean mDragDecelerationEnabled;
    public float mDragDecelerationFrictionCoef;
    public boolean mHighLightPerTapEnabled;
    public IHighlighter mHighlighter;
    public Highlight[] mIndicesToHighlight;
    public Paint mInfoPaint;
    public ArrayList mJobs;
    public Legend mLegend;
    public LegendRenderer mLegendRenderer;
    public float mMaxHighlightDistance;
    public String mNoDataText;
    public boolean mOffsetsCalculated;
    public DataRenderer mRenderer;
    public boolean mTouchEnabled;
    public ViewPortHandler mViewPortHandler;
    public XAxis mXAxis;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.Chart$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat;
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Paint$Align;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $SwitchMap$android$graphics$Bitmap$CompressFormat = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Paint.Align.values().length];
            $SwitchMap$android$graphics$Paint$Align = iArr2;
            try {
                iArr2[Paint.Align.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Paint$Align[Paint.Align.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new bj(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mJobs = new ArrayList();
        init();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new bj(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mJobs = new ArrayList();
        init();
    }

    public abstract void calculateOffsets();

    public final void drawDescription(Canvas canvas) {
        Description description = this.mDescription;
        if (description == null || !description.mEnabled) {
            return;
        }
        this.mDescPaint.setTypeface(null);
        this.mDescPaint.setTextSize(this.mDescription.mTextSize);
        this.mDescPaint.setColor(this.mDescription.mTextColor);
        this.mDescPaint.setTextAlign(this.mDescription.mTextAlign);
        float width = getWidth();
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        float f = (width - (viewPortHandler.mChartWidth - viewPortHandler.mContentRect.right)) - this.mDescription.mXOffset;
        float height = getHeight() - this.mViewPortHandler.offsetBottom();
        Description description2 = this.mDescription;
        canvas.drawText(description2.text, f, height - description2.mYOffset, this.mDescPaint);
    }

    public final MPPointF getCenterOffsets() {
        RectF rectF = this.mViewPortHandler.mContentRect;
        return MPPointF.getInstance(rectF.centerX(), rectF.centerY());
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == null) {
            return null;
        }
        return this.mHighlighter.getHighlight(f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    public final void highlightValue(Highlight highlight) {
        Highlight highlight2;
        Entry entryForXValue;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            int i = highlight.mDataSetIndex;
            LineData lineData = this.mData;
            lineData.getClass();
            ArrayList arrayList = lineData.mDataSets;
            if (i >= arrayList.size()) {
                entryForXValue = null;
            } else {
                IDataSet iDataSet = (IDataSet) arrayList.get(i);
                float f = highlight.mX;
                float f2 = highlight.mY;
                LineDataSet lineDataSet = (LineDataSet) iDataSet;
                lineDataSet.getClass();
                entryForXValue = lineDataSet.getEntryForXValue(f, f2, DataSet$Rounding.CLOSEST);
            }
            if (entryForXValue == null) {
                this.mIndicesToHighlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
        }
        Highlight[] highlightArr = this.mIndicesToHighlight;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight2 = highlightArr[0]) == null) {
            this.mChartTouchListener.mLastHighlighted = null;
        } else {
            this.mChartTouchListener.mLastHighlighted = highlight2;
        }
        invalidate();
    }

    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new HurlStack(3);
        Context context = getContext();
        Rect rect = Utils.mCalcTextHeightRect;
        if (context == null) {
            Utils.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            Utils.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Utils.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            Utils.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            Utils.mMetrics = context.getResources().getDisplayMetrics();
        }
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        Description description = new Description();
        description.text = "Description Label";
        description.mTextAlign = Paint.Align.RIGHT;
        description.mTextSize = Utils.convertDpToPixel(8.0f);
        this.mDescription = description;
        Legend legend = new Legend();
        legend.mEntries = new LegendEntry[0];
        legend.mHorizontalAlignment = Legend.LegendHorizontalAlignment.LEFT;
        legend.mVerticalAlignment = Legend.LegendVerticalAlignment.BOTTOM;
        legend.mOrientation = Legend.LegendOrientation.HORIZONTAL;
        legend.mDirection = Legend.LegendDirection.LEFT_TO_RIGHT;
        legend.mShape = Legend.LegendForm.SQUARE;
        legend.mFormSize = 8.0f;
        legend.mFormLineWidth = 3.0f;
        legend.mXEntrySpace = 6.0f;
        legend.mFormToTextSpace = 5.0f;
        legend.mStackSpace = 3.0f;
        legend.mMaxSizePercent = 0.95f;
        legend.mNeededWidth = 0.0f;
        legend.mNeededHeight = 0.0f;
        legend.mTextHeightMax = 0.0f;
        legend.mCalculatedLabelSizes = new ArrayList(16);
        legend.mCalculatedLabelBreakPoints = new ArrayList(16);
        legend.mCalculatedLineSizes = new ArrayList(16);
        legend.mTextSize = Utils.convertDpToPixel(10.0f);
        legend.mXOffset = Utils.convertDpToPixel(5.0f);
        legend.mYOffset = Utils.convertDpToPixel(3.0f);
        this.mLegend = legend;
        LegendRenderer legendRenderer = new LegendRenderer(this.mViewPortHandler);
        legendRenderer.computedEntries = new ArrayList(16);
        legendRenderer.legendFontMetrics = new Paint.FontMetrics();
        legendRenderer.mLineFormPath = new Path();
        legendRenderer.mLegend = legend;
        Paint paint = new Paint(1);
        legendRenderer.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        paint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        legendRenderer.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mLegendRenderer = legendRenderer;
        XAxis xAxis = new XAxis();
        xAxis.mLabelRotatedWidth = 1;
        xAxis.mLabelRotatedHeight = 1;
        xAxis.mPosition = XAxis.XAxisPosition.TOP;
        xAxis.mYOffset = Utils.convertDpToPixel(4.0f);
        this.mXAxis = xAxis;
        this.mDescPaint = new Paint(1);
        Paint paint3 = new Paint(1);
        this.mInfoPaint = paint3;
        paint3.setColor(Color.rgb(247, 189, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
    }

    public abstract void notifyDataSetChanged();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        if (this.mData != null) {
            if (this.mOffsetsCalculated) {
                return;
            }
            calculateOffsets();
            this.mOffsetsCalculated = true;
            return;
        }
        if (TextUtils.isEmpty(this.mNoDataText)) {
            return;
        }
        MPPointF mPPointF = MPPointF.getInstance(getWidth() / 2.0f, getHeight() / 2.0f);
        int i = AnonymousClass2.$SwitchMap$android$graphics$Paint$Align[this.mInfoPaint.getTextAlign().ordinal()];
        if (i == 1) {
            f = 0.0f;
        } else {
            if (i != 2) {
                canvas.drawText(this.mNoDataText, mPPointF.x, mPPointF.y, this.mInfoPaint);
                return;
            }
            f = (float) (((double) mPPointF.x) * 2.0d);
        }
        mPPointF.x = f;
        canvas.drawText(this.mNoDataText, f, mPPointF.y, this.mInfoPaint);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iConvertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(iConvertDpToPixel, i)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(iConvertDpToPixel, i2)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        ArrayList arrayList = this.mJobs;
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            RectF rectF = viewPortHandler.mContentRect;
            float f = rectF.left;
            float f2 = rectF.top;
            float f3 = viewPortHandler.mChartWidth - rectF.right;
            float fOffsetBottom = viewPortHandler.offsetBottom();
            viewPortHandler.mChartHeight = i2;
            viewPortHandler.mChartWidth = i;
            viewPortHandler.restrainViewPort(f, f2, f3, fOffsetBottom);
        }
        notifyDataSetChanged();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            post((Runnable) it.next());
        }
        arrayList.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(LineData lineData) {
        bj bjVar = this.mDefaultValueFormatter;
        this.mData = lineData;
        this.mOffsetsCalculated = false;
        if (lineData == null) {
            return;
        }
        float f = lineData.mYMin;
        float f2 = lineData.mYMax;
        float fRoundToNextSignificant = Utils.roundToNextSignificant(lineData.getEntryCount() < 2 ? Math.max(Math.abs(f), Math.abs(f2)) : Math.abs(f2 - f));
        bjVar.setup(Float.isInfinite(fRoundToNextSignificant) ? 0 : ((int) Math.ceil(-Math.log10(fRoundToNextSignificant))) + 2);
        Iterator it = this.mData.mDataSets.iterator();
        while (it.hasNext()) {
            LineDataSet lineDataSet = (LineDataSet) ((IDataSet) it.next());
            bj bjVar2 = lineDataSet.mValueFormatter;
            if (bjVar2 == null || bjVar2 == bjVar) {
                lineDataSet.mValueFormatter = bjVar;
            }
        }
        notifyDataSetChanged();
    }
}
