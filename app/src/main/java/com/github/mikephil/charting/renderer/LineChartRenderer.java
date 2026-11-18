package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.bj;
import defpackage.e91;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LineChartRenderer extends LineRadarRenderer {
    public Path cubicFillPath;
    public Path cubicPath;
    public Canvas mBitmapCanvas;
    public Bitmap.Config mBitmapConfig;
    public LineChart mChart;
    public Paint mCirclePaintInner;
    public float[] mCirclesBuffer;
    public WeakReference mDrawBitmap;
    public Path mGenerateFilledPathBuffer;
    public HashMap mImageCaches;
    public float[] mLineBuffer;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;
                LineDataSet.Mode[] modeArr = LineDataSet.Mode.$VALUES;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;
                LineDataSet.Mode[] modeArr2 = LineDataSet.Mode.$VALUES;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;
                LineDataSet.Mode[] modeArr3 = LineDataSet.Mode.$VALUES;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class DataSetImageCache {
        public Bitmap[] circleBitmaps;
        public final Path mCirclePathBuffer = new Path();

        public DataSetImageCache() {
        }
    }

    public final void drawCubicFill(Canvas canvas, LineDataSet lineDataSet, Path path, e91 e91Var, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        HurlStack hurlStack = lineDataSet.mFillFormatter;
        LineChart lineChart = this.mChart;
        hurlStack.getClass();
        float fillLinePosition = HurlStack.getFillLinePosition(lineDataSet, lineChart);
        path.lineTo(lineDataSet.getEntryForIndex(xBounds.min + xBounds.range).x, fillLinePosition);
        path.lineTo(lineDataSet.getEntryForIndex(xBounds.min).x, fillLinePosition);
        path.close();
        e91Var.pathValueToPixel(path);
        int i = (lineDataSet.mFillAlpha << 24) | (lineDataSet.mFillColor & 16777215);
        Rect rect = Utils.mCalcTextHeightRect;
        int iSave = canvas.save();
        canvas.clipPath(path);
        canvas.drawColor(i);
        canvas.restoreToCount(iSave);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawData(Canvas canvas) {
        Iterator it;
        e91 e91Var;
        int i;
        PathEffect pathEffect;
        char c;
        LineChart lineChart = this.mChart;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        float f = viewPortHandler.mChartWidth;
        RectF rectF = viewPortHandler.mContentRect;
        int i2 = (int) f;
        int i3 = (int) viewPortHandler.mChartHeight;
        WeakReference weakReference = this.mDrawBitmap;
        PathEffect pathEffect2 = null;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != i2 || bitmapCreateBitmap.getHeight() != i3) {
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, this.mBitmapConfig);
            this.mDrawBitmap = new WeakReference(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        Bitmap bitmap = bitmapCreateBitmap;
        int i4 = 0;
        bitmap.eraseColor(0);
        Iterator it2 = lineChart.mData.mDataSets.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            Paint paint = this.mRenderPaint;
            if (!zHasNext) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                return;
            }
            LineDataSet lineDataSet = (LineDataSet) it2.next();
            if (lineDataSet.mVisible) {
                Path path = this.cubicPath;
                Path path2 = this.cubicFillPath;
                ArrayList arrayList = lineDataSet.mEntries;
                YAxis.AxisDependency axisDependency = lineDataSet.mAxisDependency;
                int i5 = i4;
                if (arrayList.size() < 1) {
                    pathEffect = pathEffect2;
                    bitmap = bitmap;
                    it = it2;
                    i = i5;
                } else {
                    paint.setStrokeWidth(lineDataSet.mLineWidth);
                    paint.setPathEffect(pathEffect2);
                    int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[lineDataSet.mMode.ordinal()];
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    HurlStack hurlStack = this.mAnimator;
                    if (i6 != 3) {
                        if (i6 != 4) {
                            int size = arrayList.size();
                            int i7 = lineDataSet.mMode == LineDataSet.Mode.STEPPED ? 1 : i5;
                            int i8 = i7 == 0 ? 2 : 4;
                            e91 transformer = lineChart.getTransformer(axisDependency);
                            hurlStack.getClass();
                            paint.setStyle(Paint.Style.STROKE);
                            xBounds.set(lineChart, lineDataSet);
                            if (!lineDataSet.mDrawFilled || size <= 0) {
                                lineChart = lineChart;
                                bitmap = bitmap;
                                it = it2;
                                c = 2;
                            } else {
                                Path path3 = this.mGenerateFilledPathBuffer;
                                c = 2;
                                int i9 = xBounds.min;
                                int i10 = xBounds.range + i9;
                                int i11 = i5;
                                while (true) {
                                    it = it2;
                                    int i12 = (i11 * 128) + i9;
                                    int i13 = i11;
                                    int i14 = i12 + 128;
                                    if (i14 > i10) {
                                        i14 = i10;
                                    }
                                    int i15 = i10;
                                    if (i12 <= i14) {
                                        lineDataSet.mFillFormatter.getClass();
                                        float fillLinePosition = HurlStack.getFillLinePosition(lineDataSet, lineChart);
                                        int i16 = lineDataSet.mMode == LineDataSet.Mode.STEPPED ? 1 : i5;
                                        path3.reset();
                                        Entry entryForIndex = lineDataSet.getEntryForIndex(i12);
                                        int i17 = i16;
                                        path3.moveTo(entryForIndex.x, fillLinePosition);
                                        path3.lineTo(entryForIndex.x, entryForIndex.y * 1.0f);
                                        int i18 = i12 + 1;
                                        Entry entryForIndex2 = null;
                                        while (i18 <= i14) {
                                            entryForIndex2 = lineDataSet.getEntryForIndex(i18);
                                            int i19 = i18;
                                            if (i17 != 0) {
                                                path3.lineTo(entryForIndex2.x, entryForIndex.y * 1.0f);
                                            }
                                            path3.lineTo(entryForIndex2.x, entryForIndex2.y * 1.0f);
                                            i18 = i19 + 1;
                                            entryForIndex = entryForIndex2;
                                        }
                                        if (entryForIndex2 != null) {
                                            path3.lineTo(entryForIndex2.x, fillLinePosition);
                                        }
                                        path3.close();
                                        transformer.pathValueToPixel(path3);
                                        int i20 = (lineDataSet.mFillColor & 16777215) | (lineDataSet.mFillAlpha << 24);
                                        Rect rect = Utils.mCalcTextHeightRect;
                                        int iSave = canvas.save();
                                        canvas.clipPath(path3);
                                        canvas.drawColor(i20);
                                        canvas.restoreToCount(iSave);
                                    }
                                    int i21 = i13 + 1;
                                    if (i12 > i14) {
                                        break;
                                    }
                                    i11 = i21;
                                    it2 = it;
                                    i10 = i15;
                                    i9 = i9;
                                    bitmap = bitmap;
                                    lineChart = lineChart;
                                }
                            }
                            int size2 = lineDataSet.mColors.size();
                            float[] fArr = this.mLineBuffer;
                            if (size2 > 1) {
                                int i22 = i8 * 2;
                                if (fArr.length <= i22) {
                                    this.mLineBuffer = new float[i8 * 4];
                                }
                                int i23 = xBounds.min;
                                int i24 = xBounds.range + i23;
                                while (i23 < i24) {
                                    Entry entryForIndex3 = lineDataSet.getEntryForIndex(i23);
                                    if (entryForIndex3 != null) {
                                        float[] fArr2 = this.mLineBuffer;
                                        float f2 = entryForIndex3.x;
                                        fArr2[i5] = f2;
                                        float f3 = entryForIndex3.y * 1.0f;
                                        fArr2[1] = f3;
                                        if (i23 < xBounds.max) {
                                            Entry entryForIndex4 = lineDataSet.getEntryForIndex(i23 + 1);
                                            if (entryForIndex4 == null) {
                                                break;
                                            }
                                            float[] fArr3 = this.mLineBuffer;
                                            float f4 = entryForIndex4.x;
                                            if (i7 != 0) {
                                                fArr3[c] = f4;
                                                float f5 = fArr3[1];
                                                fArr3[3] = f5;
                                                fArr3[4] = f4;
                                                fArr3[5] = f5;
                                                fArr3[6] = f4;
                                                fArr3[7] = entryForIndex4.y * 1.0f;
                                            } else {
                                                fArr3[c] = f4;
                                                fArr3[3] = entryForIndex4.y * 1.0f;
                                            }
                                        } else {
                                            fArr2[c] = f2;
                                            fArr2[3] = f3;
                                        }
                                        float[] fArr4 = this.mLineBuffer;
                                        float f6 = fArr4[i5];
                                        float f7 = fArr4[1];
                                        float f8 = fArr4[i22 - 2];
                                        float f9 = fArr4[i22 - 1];
                                        if (f6 != f8 || f7 != f9) {
                                            transformer.pointValuesToPixel(fArr4);
                                            if (!viewPortHandler.isInBoundsRight(f6)) {
                                                break;
                                            }
                                            if (viewPortHandler.isInBoundsLeft(f8)) {
                                                if (rectF.top <= Math.max(f7, f9)) {
                                                    if (rectF.bottom >= ((int) (Math.min(f7, f9) * 100.0f)) / 100.0f) {
                                                        ArrayList arrayList2 = lineDataSet.mColors;
                                                        paint.setColor(((Integer) arrayList2.get(i23 % arrayList2.size())).intValue());
                                                        canvas.drawLines(this.mLineBuffer, i5, i22, paint);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i23++;
                                    i5 = 0;
                                }
                            } else {
                                int length = fArr.length;
                                int i25 = size * i8;
                                if (length < Math.max(i25, i8) * 2) {
                                    this.mLineBuffer = new float[Math.max(i25, i8) * 4];
                                }
                                if (lineDataSet.getEntryForIndex(xBounds.min) != null) {
                                    int i26 = xBounds.min;
                                    int i27 = 0;
                                    while (i26 <= xBounds.range + xBounds.min) {
                                        Entry entryForIndex5 = lineDataSet.getEntryForIndex(i26 == 0 ? 0 : i26 - 1);
                                        Entry entryForIndex6 = lineDataSet.getEntryForIndex(i26);
                                        if (entryForIndex5 != null && entryForIndex6 != null) {
                                            float f10 = entryForIndex6.x;
                                            float[] fArr5 = this.mLineBuffer;
                                            fArr5[i27] = entryForIndex5.x;
                                            int i28 = i27 + 2;
                                            float f11 = entryForIndex5.y * 1.0f;
                                            fArr5[i27 + 1] = f11;
                                            if (i7 != 0) {
                                                fArr5[i28] = f10;
                                                fArr5[i27 + 3] = f11;
                                                fArr5[i27 + 4] = f10;
                                                i28 = i27 + 6;
                                                fArr5[i27 + 5] = f11;
                                            }
                                            fArr5[i28] = f10;
                                            fArr5[i28 + 1] = entryForIndex6.y * 1.0f;
                                            i27 = i28 + 2;
                                        }
                                        i26++;
                                    }
                                    if (i27 > 0) {
                                        transformer.pointValuesToPixel(this.mLineBuffer);
                                        int iMax = Math.max((xBounds.range + 1) * i8, i8) * 2;
                                        paint.setColor(((Integer) lineDataSet.mColors.get(0)).intValue());
                                        canvas.drawLines(this.mLineBuffer, 0, iMax, paint);
                                    }
                                }
                            }
                            paint.setPathEffect(null);
                            lineChart = lineChart;
                        } else {
                            bitmap = bitmap;
                            it = it2;
                            hurlStack.getClass();
                            e91 transformer2 = lineChart.getTransformer(axisDependency);
                            xBounds.set(lineChart, lineDataSet);
                            path.reset();
                            if (xBounds.range >= 1) {
                                Entry entryForIndex7 = lineDataSet.getEntryForIndex(xBounds.min);
                                path.moveTo(entryForIndex7.x, entryForIndex7.y * 1.0f);
                                int i29 = xBounds.min + 1;
                                while (i29 <= xBounds.range + xBounds.min) {
                                    Entry entryForIndex8 = lineDataSet.getEntryForIndex(i29);
                                    float f12 = entryForIndex7.x;
                                    float f13 = entryForIndex8.x;
                                    float f14 = ((f13 - f12) / 2.0f) + f12;
                                    float f15 = entryForIndex7.y * 1.0f;
                                    float f16 = entryForIndex8.y * 1.0f;
                                    path.cubicTo(f14, f15, f14, f16, f13, f16);
                                    i29++;
                                    entryForIndex7 = entryForIndex8;
                                }
                            }
                            if (lineDataSet.mDrawFilled) {
                                path2.reset();
                                path2.addPath(path);
                                drawCubicFill(this.mBitmapCanvas, lineDataSet, path2, transformer2, this.mXBounds);
                            }
                            paint.setColor(((Integer) lineDataSet.mColors.get(0)).intValue());
                            paint.setStyle(Paint.Style.STROKE);
                            transformer2.pathValueToPixel(path);
                            this.mBitmapCanvas.drawPath(path, paint);
                            paint.setPathEffect(null);
                        }
                    } else {
                        bitmap = bitmap;
                        it = it2;
                        hurlStack.getClass();
                        e91 transformer3 = lineChart.getTransformer(axisDependency);
                        xBounds.set(lineChart, lineDataSet);
                        float f17 = lineDataSet.mCubicIntensity;
                        path.reset();
                        if (xBounds.range >= 1) {
                            int i30 = xBounds.min;
                            Entry entryForIndex9 = lineDataSet.getEntryForIndex(Math.max(i30 - 1, 0));
                            Entry entryForIndex10 = lineDataSet.getEntryForIndex(Math.max(i30, 0));
                            if (entryForIndex10 != null) {
                                path.moveTo(entryForIndex10.x, entryForIndex10.y * 1.0f);
                                int i31 = -1;
                                int i32 = xBounds.min + 1;
                                Entry entry = entryForIndex10;
                                while (i32 <= xBounds.range + xBounds.min) {
                                    if (i31 != i32) {
                                        entryForIndex10 = lineDataSet.getEntryForIndex(i32);
                                    }
                                    int i33 = i32 + 1;
                                    if (i33 < arrayList.size()) {
                                        i32 = i33;
                                    }
                                    Entry entryForIndex11 = lineDataSet.getEntryForIndex(i32);
                                    float f18 = entryForIndex10.x;
                                    float f19 = (f18 - entryForIndex9.x) * f17;
                                    float f20 = entryForIndex10.y;
                                    float f21 = (f20 - entryForIndex9.y) * f17;
                                    float f22 = entryForIndex11.x;
                                    float f23 = entry.x;
                                    float f24 = (f22 - f23) * f17;
                                    float f25 = entryForIndex11.y;
                                    float f26 = entry.y;
                                    path.cubicTo(f23 + f19, (f26 + f21) * 1.0f, f18 - f24, (f20 - ((f25 - f26) * f17)) * 1.0f, f18, f20 * 1.0f);
                                    entryForIndex9 = entry;
                                    i31 = i32;
                                    i32 = i33;
                                    entry = entryForIndex10;
                                    entryForIndex10 = entryForIndex11;
                                }
                            }
                            paint.setPathEffect(pathEffect);
                        }
                        if (lineDataSet.mDrawFilled) {
                            path2.reset();
                            path2.addPath(path);
                            e91Var = transformer3;
                            drawCubicFill(this.mBitmapCanvas, lineDataSet, path2, e91Var, this.mXBounds);
                        } else {
                            e91Var = transformer3;
                        }
                        i = 0;
                        paint.setColor(((Integer) lineDataSet.mColors.get(0)).intValue());
                        paint.setStyle(Paint.Style.STROKE);
                        e91Var.pathValueToPixel(path);
                        this.mBitmapCanvas.drawPath(path, paint);
                        pathEffect = null;
                        paint.setPathEffect(null);
                        paint.setPathEffect(pathEffect);
                    }
                    pathEffect = null;
                    i = 0;
                    paint.setPathEffect(pathEffect);
                }
                pathEffect2 = pathEffect;
                i4 = i;
                it2 = it;
                bitmap = bitmap;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:50:0x012d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0144  */
    /* JADX WARN: Code duplicated, block: B:57:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x012a A[EDGE_INSN: B:70:0x012a->B:49:0x012a BREAK  A[LOOP:2: B:46:0x0122->B:61:0x016c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x012a A[EDGE_INSN: B:71:0x012a->B:49:0x012a BREAK  A[LOOP:2: B:46:0x0122->B:61:0x016c], SYNTHETIC] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawExtras(Canvas canvas) {
        HashMap map;
        int i;
        float f;
        int i2;
        LineChart lineChart;
        ArrayList arrayList;
        DataSetImageCache dataSetImageCache;
        int i3;
        int i4;
        Entry entryForIndex;
        LineChartRenderer lineChartRenderer = this;
        ViewPortHandler viewPortHandler = (ViewPortHandler) lineChartRenderer.a;
        HashMap map2 = lineChartRenderer.mImageCaches;
        lineChartRenderer.mRenderPaint.setStyle(Paint.Style.FILL);
        lineChartRenderer.mAnimator.getClass();
        float[] fArr = lineChartRenderer.mCirclesBuffer;
        int i5 = 0;
        float f2 = 0.0f;
        fArr[0] = 0.0f;
        int i6 = 1;
        fArr[1] = 0.0f;
        LineChart lineChart2 = lineChartRenderer.mChart;
        ArrayList arrayList2 = lineChart2.mData.mDataSets;
        int i7 = 0;
        while (i7 < arrayList2.size()) {
            LineDataSet lineDataSet = (LineDataSet) arrayList2.get(i7);
            boolean z = lineDataSet.mVisible;
            ArrayList arrayList3 = lineDataSet.mCircleColors;
            float f3 = lineDataSet.mCircleHoleRadius;
            float f4 = lineDataSet.mCircleRadius;
            int i8 = lineDataSet.mCircleHoleColor;
            if (z && lineDataSet.mDrawCircles && lineDataSet.mEntries.size() != 0) {
                lineChartRenderer.mCirclePaintInner.setColor(i8);
                e91 transformer = lineChart2.getTransformer(lineDataSet.mAxisDependency);
                i = i5;
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = lineChartRenderer.mXBounds;
                xBounds.set(lineChart2, lineDataSet);
                f = f2;
                int i9 = (!lineDataSet.mDrawCircleHole || f3 >= f4 || f3 <= f) ? i : i6;
                i2 = i6;
                int i10 = (i9 == 0 || i8 != 1122867) ? i : i2;
                if (map2.containsKey(lineDataSet)) {
                    dataSetImageCache = (DataSetImageCache) map2.get(lineDataSet);
                } else {
                    dataSetImageCache = lineChartRenderer.new DataSetImageCache();
                    map2.put(lineDataSet, dataSetImageCache);
                }
                dataSetImageCache.getClass();
                int size = arrayList3.size();
                map = map2;
                Bitmap[] bitmapArr = dataSetImageCache.circleBitmaps;
                if (bitmapArr == null) {
                    dataSetImageCache.circleBitmaps = new Bitmap[size];
                } else if (bitmapArr.length != size) {
                    dataSetImageCache.circleBitmaps = new Bitmap[size];
                } else {
                    lineChart = lineChart2;
                    arrayList = arrayList2;
                    int i11 = xBounds.range;
                    i3 = xBounds.min;
                    i4 = i11 + i3;
                    while (i3 <= i4) {
                        entryForIndex = lineDataSet.getEntryForIndex(i3);
                        if (entryForIndex == null) {
                            break;
                        }
                        fArr[i] = entryForIndex.x;
                        fArr[i2] = entryForIndex.y * 1.0f;
                        transformer.pointValuesToPixel(fArr);
                        if (!viewPortHandler.isInBoundsRight(fArr[i])) {
                            break;
                        }
                        if (!viewPortHandler.isInBoundsLeft(fArr[i]) && viewPortHandler.isInBoundsY(fArr[i2])) {
                            Bitmap[] bitmapArr2 = dataSetImageCache.circleBitmaps;
                            Bitmap bitmap = bitmapArr2[i3 % bitmapArr2.length];
                            if (bitmap != null) {
                                canvas.drawBitmap(bitmap, fArr[i] - f4, fArr[i2] - f4, (Paint) null);
                            }
                        }
                        i3++;
                    }
                }
                Path path = dataSetImageCache.mCirclePathBuffer;
                LineChartRenderer lineChartRenderer2 = LineChartRenderer.this;
                int i12 = i9;
                int size2 = arrayList3.size();
                int i13 = i10;
                int i14 = i;
                while (i14 < size2) {
                    int i15 = size2;
                    LineChart lineChart3 = lineChart2;
                    ArrayList arrayList4 = arrayList2;
                    int i16 = (int) (((double) f4) * 2.1d);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_4444);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    dataSetImageCache.circleBitmaps[i14] = bitmapCreateBitmap;
                    Paint paint = lineChartRenderer2.mRenderPaint;
                    paint.setColor(((Integer) arrayList3.get(i14)).intValue());
                    if (i13 != 0) {
                        path.reset();
                        path.addCircle(f4, f4, f4, Path.Direction.CW);
                        path.addCircle(f4, f4, f3, Path.Direction.CCW);
                        canvas2.drawPath(path, paint);
                    } else {
                        canvas2.drawCircle(f4, f4, f4, paint);
                        if (i12 != 0) {
                            canvas2.drawCircle(f4, f4, f3, lineChartRenderer2.mCirclePaintInner);
                        }
                    }
                    i14++;
                    size2 = i15;
                    lineChart2 = lineChart3;
                    arrayList2 = arrayList4;
                }
                lineChart = lineChart2;
                arrayList = arrayList2;
                int i17 = xBounds.range;
                i3 = xBounds.min;
                i4 = i17 + i3;
                while (i3 <= i4) {
                    entryForIndex = lineDataSet.getEntryForIndex(i3);
                    if (entryForIndex == null) {
                        break;
                        break;
                    }
                    fArr[i] = entryForIndex.x;
                    fArr[i2] = entryForIndex.y * 1.0f;
                    transformer.pointValuesToPixel(fArr);
                    if (!viewPortHandler.isInBoundsRight(fArr[i])) {
                        break;
                        break;
                    } else {
                        if (!viewPortHandler.isInBoundsLeft(fArr[i])) {
                        }
                        i3++;
                    }
                }
            } else {
                map = map2;
                i = i5;
                f = f2;
                i2 = i6;
                lineChart = lineChart2;
                arrayList = arrayList2;
            }
            i7++;
            lineChartRenderer = this;
            i5 = i;
            f2 = f;
            i6 = i2;
            map2 = map;
            lineChart2 = lineChart;
            arrayList2 = arrayList;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        LineChart lineChart = this.mChart;
        LineData lineData = lineChart.mData;
        for (Highlight highlight : highlightArr) {
            LineDataSet lineDataSet = (LineDataSet) lineData.getDataSetByIndex(highlight.mDataSetIndex);
            if (lineDataSet != null && lineDataSet.mHighlightEnabled) {
                Entry entryForXValue = lineDataSet.getEntryForXValue(highlight.mX, highlight.mY, DataSet$Rounding.CLOSEST);
                ArrayList arrayList = lineDataSet.mEntries;
                if (entryForXValue != null) {
                    float fIndexOf = arrayList.indexOf(entryForXValue);
                    float size = arrayList.size();
                    this.mAnimator.getClass();
                    if (fIndexOf < size * 1.0f) {
                        MPPointD pixelForValues = lineChart.getTransformer(lineDataSet.mAxisDependency).getPixelForValues(entryForXValue.x, entryForXValue.y * 1.0f);
                        float f = (float) pixelForValues.x;
                        float f2 = (float) pixelForValues.y;
                        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
                        this.mHighlightPaint.setColor(lineDataSet.mHighLightColor);
                        this.mHighlightPaint.setStrokeWidth(lineDataSet.mHighlightLineWidth);
                        this.mHighlightPaint.setPathEffect(null);
                        boolean z = lineDataSet.mDrawVerticalHighlightIndicator;
                        Path path = this.mHighlightLinePath;
                        if (z) {
                            path.reset();
                            path.moveTo(f, viewPortHandler.mContentRect.top);
                            path.lineTo(f, viewPortHandler.mContentRect.bottom);
                            canvas.drawPath(path, this.mHighlightPaint);
                        }
                        if (lineDataSet.mDrawHorizontalHighlightIndicator) {
                            path.reset();
                            path.moveTo(viewPortHandler.mContentRect.left, f2);
                            path.lineTo(viewPortHandler.mContentRect.right, f2);
                            canvas.drawPath(path, this.mHighlightPaint);
                        }
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void drawValues(Canvas canvas) {
        ViewPortHandler viewPortHandler;
        LineChart lineChart;
        LineChartRenderer lineChartRenderer = this;
        ViewPortHandler viewPortHandler2 = (ViewPortHandler) lineChartRenderer.a;
        LineChart lineChart2 = lineChartRenderer.mChart;
        if (lineChartRenderer.isDrawingValuesAllowed(lineChart2)) {
            ArrayList arrayList = lineChart2.mData.mDataSets;
            int i = 0;
            while (i < arrayList.size()) {
                LineDataSet lineDataSet = (LineDataSet) arrayList.get(i);
                if (!lineDataSet.mVisible || (!(lineDataSet.mDrawValues || lineDataSet.mDrawIcons) || lineDataSet.mEntries.size() < 1)) {
                    viewPortHandler = viewPortHandler2;
                    lineChart = lineChart2;
                } else {
                    Paint paint = lineChartRenderer.mValuePaint;
                    paint.setTypeface(null);
                    paint.setTextSize(lineDataSet.mValueTextSize);
                    e91 transformer = lineChart2.getTransformer(lineDataSet.mAxisDependency);
                    int i2 = (int) (lineDataSet.mCircleRadius * 1.75f);
                    if (!lineDataSet.mDrawCircles) {
                        i2 /= 2;
                    }
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = lineChartRenderer.mXBounds;
                    xBounds.set(lineChart2, lineDataSet);
                    lineChartRenderer.mAnimator.getClass();
                    int i3 = xBounds.min;
                    float f = 1.0f;
                    int i4 = (((int) ((xBounds.max - i3) * 1.0f)) + 1) * 2;
                    if (((float[]) transformer.g).length != i4) {
                        transformer.g = new float[i4];
                    }
                    float[] fArr = (float[]) transformer.g;
                    int i5 = 0;
                    while (i5 < i4) {
                        Entry entryForIndex = lineDataSet.getEntryForIndex((i5 / 2) + i3);
                        float f2 = f;
                        if (entryForIndex != null) {
                            fArr[i5] = entryForIndex.x;
                            fArr[i5 + 1] = entryForIndex.y * f2;
                        } else {
                            fArr[i5] = 0.0f;
                            fArr[i5 + 1] = 0.0f;
                        }
                        i5 += 2;
                        f = f2;
                    }
                    Matrix matrix = (Matrix) transformer.a;
                    matrix.set((Matrix) transformer.c);
                    matrix.postConcat(((ViewPortHandler) transformer.e).mMatrixTouch);
                    matrix.postConcat((Matrix) transformer.b);
                    matrix.mapPoints(fArr);
                    MPPointF mPPointF = lineDataSet.mIconsOffset;
                    MPPointF mPPointF2 = (MPPointF) MPPointF.pool.get();
                    float f3 = mPPointF.x;
                    mPPointF2.x = f3;
                    mPPointF2.y = mPPointF.y;
                    mPPointF2.x = Utils.convertDpToPixel(f3);
                    mPPointF2.y = Utils.convertDpToPixel(mPPointF2.y);
                    int i6 = 0;
                    while (i6 < fArr.length) {
                        float f4 = fArr[i6];
                        float f5 = fArr[i6 + 1];
                        if (!viewPortHandler2.isInBoundsRight(f4)) {
                            break;
                        }
                        if (viewPortHandler2.isInBoundsLeft(f4) && viewPortHandler2.isInBoundsY(f5)) {
                            int i7 = i6 / 2;
                            Entry entryForIndex2 = lineDataSet.getEntryForIndex(xBounds.min + i7);
                            if (lineDataSet.mDrawValues) {
                                bj bjVar = lineDataSet.mValueFormatter;
                                if (bjVar == null) {
                                    bjVar = Utils.mDefaultValueFormatter;
                                }
                                float f6 = entryForIndex2.y;
                                ArrayList arrayList2 = lineDataSet.mValueColors;
                                paint.setColor(((Integer) arrayList2.get(i7 % arrayList2.size())).intValue());
                                canvas.drawText(((DecimalFormat) bjVar.a).format(f6), f4, f5 - i2, paint);
                            }
                            entryForIndex2.getClass();
                        } else {
                            viewPortHandler2 = viewPortHandler2;
                            lineChart2 = lineChart2;
                        }
                        i6 += 2;
                        viewPortHandler2 = viewPortHandler2;
                        lineChart2 = lineChart2;
                    }
                    viewPortHandler = viewPortHandler2;
                    lineChart = lineChart2;
                    MPPointF.recycleInstance(mPPointF2);
                }
                i++;
                lineChartRenderer = this;
                viewPortHandler2 = viewPortHandler;
                lineChart2 = lineChart;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void initBuffers() {
    }
}
