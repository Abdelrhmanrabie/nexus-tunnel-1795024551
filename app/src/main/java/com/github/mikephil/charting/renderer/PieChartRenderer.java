package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.d;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PieChartRenderer extends DataRenderer {
    public Canvas mBitmapCanvas;
    public RectF mCenterTextLastBounds;
    public String mCenterTextLastValue;
    public StaticLayout mCenterTextLayout;
    public TextPaint mCenterTextPaint;
    public PieChart mChart;
    public WeakReference mDrawBitmap;
    public Path mDrawCenterTextPathBuffer;
    public RectF mDrawHighlightedRectF;
    public Path mHoleCirclePath;
    public Paint mHolePaint;
    public RectF[] mRectBuffer;
    public Paint mTransparentCirclePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        int i = (int) viewPortHandler.mChartWidth;
        int i2 = (int) viewPortHandler.mChartHeight;
        WeakReference weakReference = this.mDrawBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != i || bitmapCreateBitmap.getHeight() != i2) {
            if (i <= 0 || i2 <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        this.mChart.mData.getClass();
        d.AnonymousClass0.m$1();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
        float radius;
        float f;
        Paint paint = this.mHolePaint;
        Path path = this.mHoleCirclePath;
        Paint paint2 = this.mTransparentCirclePaint;
        PieChart pieChart = this.mChart;
        boolean z = pieChart.mDrawHole;
        float f2 = pieChart.mTransparentCircleRadiusPercent;
        float f3 = pieChart.mHoleRadiusPercent;
        if (z && this.mBitmapCanvas != null) {
            float radius2 = pieChart.getRadius();
            float f4 = (f3 / 100.0f) * radius2;
            MPPointF centerCircleBox = pieChart.getCenterCircleBox();
            if (Color.alpha(paint.getColor()) > 0) {
                this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, f4, paint);
            }
            if (Color.alpha(paint2.getColor()) > 0 && f2 > f3) {
                int alpha = paint2.getAlpha();
                this.mAnimator.getClass();
                paint2.setAlpha((int) (alpha * 1.0f * 1.0f));
                path.reset();
                path.addCircle(centerCircleBox.x, centerCircleBox.y, (f2 / 100.0f) * radius2, Path.Direction.CW);
                path.addCircle(centerCircleBox.x, centerCircleBox.y, f4, Path.Direction.CCW);
                this.mBitmapCanvas.drawPath(path, paint2);
                paint2.setAlpha(alpha);
            }
            MPPointF.recycleInstance(centerCircleBox);
        }
        canvas.drawBitmap((Bitmap) this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        RectF rectF = this.mCenterTextLastBounds;
        String str = pieChart.mCenterText;
        if (!pieChart.mDrawCenterText || str == null) {
            return;
        }
        MPPointF centerCircleBox2 = pieChart.getCenterCircleBox();
        MPPointF mPPointF = pieChart.mCenterTextOffset;
        MPPointF mPPointF2 = MPPointF.getInstance(mPPointF.x, mPPointF.y);
        float f5 = centerCircleBox2.x + mPPointF2.x;
        float f6 = centerCircleBox2.y + mPPointF2.y;
        if (pieChart.mDrawHole) {
            radius = (f3 / 100.0f) * pieChart.getRadius();
        } else {
            radius = pieChart.getRadius();
        }
        RectF[] rectFArr = this.mRectBuffer;
        RectF rectF2 = rectFArr[0];
        rectF2.left = f5 - radius;
        rectF2.top = f6 - radius;
        rectF2.right = f5 + radius;
        rectF2.bottom = f6 + radius;
        RectF rectF3 = rectFArr[1];
        rectF3.set(rectF2);
        float f7 = pieChart.mCenterTextRadiusPercent / 100.0f;
        if (f7 > 0.0d) {
            rectF3.inset((rectF3.width() - (rectF3.width() * f7)) / 2.0f, (rectF3.height() - (rectF3.height() * f7)) / 2.0f);
        }
        if (str.equals(this.mCenterTextLastValue) && rectF3.equals(rectF)) {
            f = 2.0f;
        } else {
            rectF.set(rectF3);
            this.mCenterTextLastValue = str;
            f = 2.0f;
            this.mCenterTextLayout = new StaticLayout(str, 0, str.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(rectF.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        Path path2 = this.mDrawCenterTextPathBuffer;
        path2.reset();
        path2.addOval(rectF2, Path.Direction.CW);
        canvas.clipPath(path2);
        canvas.translate(rectF3.left, ((rectF3.height() - height) / f) + rectF3.top);
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox2);
        MPPointF.recycleInstance(mPPointF2);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        PieChart pieChart = this.mChart;
        boolean z = pieChart.mDrawHole;
        this.mAnimator.getClass();
        float[] fArr = pieChart.mDrawAngles;
        MPPointF centerCircleBox = pieChart.getCenterCircleBox();
        pieChart.getRadius();
        this.mDrawHighlightedRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (Highlight highlight : highlightArr) {
            if (((int) highlight.mX) < fArr.length) {
                pieChart.mData.getClass();
                d.AnonymousClass0.m$1();
                return;
            }
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        PieChart pieChart = this.mChart;
        pieChart.getCenterCircleBox();
        pieChart.getRadius();
        this.mAnimator.getClass();
        pieChart.mData.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
    }
}
