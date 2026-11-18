package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class BarLineChartTouchListener extends ChartTouchListener {
    public LineDataSet mClosestDataSetToTouch;
    public MPPointF mDecelerationCurrentPoint;
    public long mDecelerationLastTime;
    public MPPointF mDecelerationVelocity;
    public float mDragTriggerDist;
    public Matrix mMatrix;
    public float mMinScalePointerDistance;
    public float mSavedDist;
    public Matrix mSavedMatrix;
    public float mSavedXDist;
    public float mSavedYDist;
    public MPPointF mTouchPointCenter;
    public MPPointF mTouchStartPoint;
    public VelocityTracker mVelocityTracker;

    public static float spacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y * y) + (x * x));
    }

    public final MPPointF getTrans(float f, float f2) {
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
        ViewPortHandler viewPortHandler = barLineChartBase.mViewPortHandler;
        float f3 = f - viewPortHandler.mContentRect.left;
        inverted();
        return MPPointF.getInstance(f3, -((barLineChartBase.getMeasuredHeight() - f2) - viewPortHandler.offsetBottom()));
    }

    public final void inverted() {
        LineDataSet lineDataSet = this.mClosestDataSetToTouch;
        Chart chart = this.mChart;
        if (lineDataSet == null) {
            BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
            barLineChartBase.mAxisLeft.getClass();
            barLineChartBase.mAxisRight.getClass();
        }
        LineDataSet lineDataSet2 = this.mClosestDataSetToTouch;
        if (lineDataSet2 != null) {
            BarLineChartBase barLineChartBase2 = (BarLineChartBase) chart;
            YAxis.AxisDependency axisDependency = lineDataSet2.mAxisDependency;
            barLineChartBase2.getClass();
            (axisDependency == YAxis.AxisDependency.LEFT ? barLineChartBase2.mAxisLeft : barLineChartBase2.mAxisRight).getClass();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
        barLineChartBase.getClass();
        if (barLineChartBase.mDoubleTapToZoomEnabled && barLineChartBase.mData.getEntryCount() > 0) {
            MPPointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            float f = barLineChartBase.mScaleXEnabled ? 1.4f : 1.0f;
            float f2 = barLineChartBase.mScaleYEnabled ? 1.4f : 1.0f;
            float f3 = trans.x;
            float f4 = trans.y;
            ViewPortHandler viewPortHandler = barLineChartBase.mViewPortHandler;
            Matrix matrix = barLineChartBase.mZoomMatrixBuffer;
            viewPortHandler.getClass();
            matrix.reset();
            matrix.set(viewPortHandler.mMatrixTouch);
            matrix.postScale(f, f2, f3, -f4);
            barLineChartBase.mViewPortHandler.refresh(matrix, barLineChartBase, false);
            barLineChartBase.calculateOffsets();
            barLineChartBase.postInvalidate();
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        ((BarLineChartBase) this.mChart).getClass();
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        ((BarLineChartBase) this.mChart).getClass();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        Chart chart = this.mChart;
        BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
        barLineChartBase.getClass();
        if (!barLineChartBase.mHighLightPerTapEnabled) {
            return false;
        }
        Highlight highlightByTouchPoint = barLineChartBase.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            highlightByTouchPoint = null;
        }
        chart.highlightValue(highlightByTouchPoint);
        this.mLastHighlighted = highlightByTouchPoint;
        return super.onSingleTapUp(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:161:0x028f A[PHI: r1 r11
      0x028f: PHI (r1v13 float) = (r1v12 float), (r1v12 float), (r1v23 float), (r1v23 float) binds: [B:160:0x028d, B:157:0x0284, B:148:0x025d, B:149:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x028f: PHI (r11v9 float) = (r11v8 float), (r11v8 float), (r11v10 float), (r11v10 float) binds: [B:160:0x028d, B:157:0x0284, B:148:0x025d, B:149:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
    
        r9 = 2;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r18, android.view.MotionEvent r19) {
        /*
            Method dump skipped, instruction units count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.BarLineChartTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        MPPointF mPPointF = this.mTouchStartPoint;
        mPPointF.x = motionEvent.getX();
        mPPointF.y = motionEvent.getY();
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
        Highlight highlightByTouchPoint = barLineChartBase.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        this.mClosestDataSetToTouch = highlightByTouchPoint != null ? (LineDataSet) barLineChartBase.mData.getDataSetByIndex(highlightByTouchPoint.mDataSetIndex) : null;
    }
}
