package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.bj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class LineChart extends BarLineChartBase<LineData> {
    public LineChart(Context context) {
        super(context);
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

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void init() {
        super.init();
        LineChartRenderer lineChartRenderer = new LineChartRenderer(this.mAnimator, this.mViewPortHandler);
        lineChartRenderer.mBitmapConfig = Bitmap.Config.ARGB_8888;
        lineChartRenderer.cubicPath = new Path();
        lineChartRenderer.cubicFillPath = new Path();
        lineChartRenderer.mLineBuffer = new float[4];
        lineChartRenderer.mGenerateFilledPathBuffer = new Path();
        lineChartRenderer.mImageCaches = new HashMap();
        lineChartRenderer.mCirclesBuffer = new float[2];
        lineChartRenderer.mChart = this;
        Paint paint = new Paint(1);
        lineChartRenderer.mCirclePaintInner = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        this.mRenderer = lineChartRenderer;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof LineChartRenderer)) {
            LineChartRenderer lineChartRenderer = (LineChartRenderer) dataRenderer;
            Canvas canvas = lineChartRenderer.mBitmapCanvas;
            if (canvas != null) {
                canvas.setBitmap(null);
                lineChartRenderer.mBitmapCanvas = null;
            }
            WeakReference weakReference = lineChartRenderer.mDrawBitmap;
            if (weakReference != null) {
                Bitmap bitmap = (Bitmap) weakReference.get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                lineChartRenderer.mDrawBitmap.clear();
                lineChartRenderer.mDrawBitmap = null;
            }
        }
        super.onDetachedFromWindow();
    }
}
