package com.github.mikephil.charting.listener;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PieRadarChartTouchListener extends ChartTouchListener {
    public ArrayList _velocitySamples;
    public float mDecelerationAngularVelocity;
    public long mDecelerationLastTime;
    public float mStartAngle;
    public MPPointF mTouchStartPoint;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class AngularVelocitySample {
        public float angle;
        public long time;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        ((PieRadarChartBase) this.mChart).getClass();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
        Chart chart = this.mChart;
        PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) chart;
        pieRadarChartBase.getClass();
        if (!pieRadarChartBase.mHighLightPerTapEnabled) {
            return false;
        }
        Highlight highlightByTouchPoint = pieRadarChartBase.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            highlightByTouchPoint = null;
        }
        chart.highlightValue(highlightByTouchPoint);
        this.mLastHighlighted = highlightByTouchPoint;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[LOOP:0: B:26:0x0077->B:28:0x007d, LOOP_END] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float fAbs;
        float angleForPoint;
        ArrayList arrayList = this._velocitySamples;
        MPPointF mPPointF = this.mTouchStartPoint;
        if (!this.mGestureDetector.onTouchEvent(motionEvent)) {
            Chart chart = this.mChart;
            PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) chart;
            if (pieRadarChartBase.mRotateEnabled) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (pieRadarChartBase.mDragDecelerationEnabled) {
                            this.mDecelerationAngularVelocity = 0.0f;
                            sampleVelocity(x, y);
                            if (arrayList.isEmpty()) {
                                fAbs = 0.0f;
                            } else {
                                AngularVelocitySample angularVelocitySample = (AngularVelocitySample) arrayList.get(0);
                                AngularVelocitySample angularVelocitySample2 = (AngularVelocitySample) arrayList.get(arrayList.size() - 1);
                                AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    angularVelocitySample3 = (AngularVelocitySample) arrayList.get(size);
                                    if (angularVelocitySample3.angle != angularVelocitySample2.angle) {
                                        break;
                                    }
                                }
                                float f = (angularVelocitySample2.time - angularVelocitySample.time) / 1000.0f;
                                if (f == 0.0f) {
                                    f = 0.1f;
                                }
                                float f2 = angularVelocitySample2.angle;
                                float f3 = angularVelocitySample3.angle;
                                boolean z = f2 >= f3;
                                if (Math.abs(f2 - f3) > 270.0d) {
                                    z = !z;
                                }
                                float f4 = angularVelocitySample2.angle;
                                float f5 = angularVelocitySample.angle;
                                if (f4 - f5 > 180.0d) {
                                    angularVelocitySample.angle = (float) (((double) f5) + 360.0d);
                                } else if (f5 - f4 > 180.0d) {
                                    angularVelocitySample2.angle = (float) (((double) f4) + 360.0d);
                                }
                                fAbs = Math.abs((angularVelocitySample2.angle - angularVelocitySample.angle) / f);
                                if (!z) {
                                    fAbs = -fAbs;
                                }
                            }
                            this.mDecelerationAngularVelocity = fAbs;
                            if (fAbs != 0.0f) {
                                this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                                Rect rect = Utils.mCalcTextHeightRect;
                                chart.postInvalidateOnAnimation();
                            }
                        }
                        ViewParent parent = pieRadarChartBase.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                        this.mTouchMode = 0;
                    } else if (action == 2) {
                        if (pieRadarChartBase.mDragDecelerationEnabled) {
                            sampleVelocity(x, y);
                        }
                        if (this.mTouchMode == 0) {
                            float f6 = x - mPPointF.x;
                            float f7 = y - mPPointF.y;
                            if (((float) Math.sqrt((f7 * f7) + (f6 * f6))) > Utils.convertDpToPixel(8.0f)) {
                                ChartTouchListener.ChartGesture[] chartGestureArr = ChartTouchListener.ChartGesture.$VALUES;
                                this.mTouchMode = 6;
                                ViewParent parent2 = pieRadarChartBase.getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                            } else if (this.mTouchMode == 6) {
                                angleForPoint = pieRadarChartBase.getAngleForPoint(x, y) - this.mStartAngle;
                                pieRadarChartBase.mRawRotationAngle = angleForPoint;
                                Rect rect2 = Utils.mCalcTextHeightRect;
                                while (angleForPoint < 0.0f) {
                                    angleForPoint += 360.0f;
                                }
                                pieRadarChartBase.mRotationAngle = angleForPoint % 360.0f;
                                pieRadarChartBase.invalidate();
                            }
                        } else if (this.mTouchMode == 6) {
                            angleForPoint = pieRadarChartBase.getAngleForPoint(x, y) - this.mStartAngle;
                            pieRadarChartBase.mRawRotationAngle = angleForPoint;
                            Rect rect3 = Utils.mCalcTextHeightRect;
                            while (angleForPoint < 0.0f) {
                                angleForPoint += 360.0f;
                            }
                            pieRadarChartBase.mRotationAngle = angleForPoint % 360.0f;
                            pieRadarChartBase.invalidate();
                        }
                    }
                    chart.getClass();
                    return true;
                }
                chart.getClass();
                this.mDecelerationAngularVelocity = 0.0f;
                arrayList.clear();
                if (pieRadarChartBase.mDragDecelerationEnabled) {
                    sampleVelocity(x, y);
                }
                this.mStartAngle = pieRadarChartBase.getAngleForPoint(x, y) - pieRadarChartBase.mRawRotationAngle;
                mPPointF.x = x;
                mPPointF.y = y;
            }
        }
        return true;
    }

    public final void sampleVelocity(float f, float f2) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        ArrayList arrayList = this._velocitySamples;
        float angleForPoint = ((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2);
        AngularVelocitySample angularVelocitySample = new AngularVelocitySample();
        angularVelocitySample.time = jCurrentAnimationTimeMillis;
        angularVelocitySample.angle = angleForPoint;
        arrayList.add(angularVelocitySample);
        for (int size = arrayList.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - ((AngularVelocitySample) arrayList.get(0)).time > 1000; size--) {
            arrayList.remove(0);
        }
    }
}
