package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.j0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class DataRenderer extends j0 {
    public final HurlStack mAnimator;
    public Paint mHighlightPaint;
    public final Paint mRenderPaint;
    public final Paint mValuePaint;

    public DataRenderer(HurlStack hurlStack, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.mAnimator = hurlStack;
        Paint paint = new Paint(1);
        this.mRenderPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        new Paint(4);
        Paint paint2 = new Paint(1);
        this.mValuePaint = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(Utils.convertDpToPixel(9.0f));
        Paint paint3 = new Paint(1);
        this.mHighlightPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void drawData(Canvas canvas);

    public abstract void drawExtras(Canvas canvas);

    public abstract void drawHighlighted(Canvas canvas, Highlight[] highlightArr);

    public abstract void drawValues(Canvas canvas);

    public abstract void initBuffers();

    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) ((Chart) chartInterface).mData.getEntryCount()) < ((ViewPortHandler) this.a).mScaleX * ((float) ((BarLineChartBase) chartInterface).mMaxVisibleCount);
    }
}
