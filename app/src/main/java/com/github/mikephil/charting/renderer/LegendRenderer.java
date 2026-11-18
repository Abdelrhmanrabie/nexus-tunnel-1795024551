package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.j0;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LegendRenderer extends j0 {
    public ArrayList computedEntries;
    public Paint.FontMetrics legendFontMetrics;
    public Legend mLegend;
    public Paint mLegendFormPaint;
    public Paint mLegendLabelPaint;
    public Path mLineFormPath;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        public static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
                Legend.LegendForm[] legendFormArr = Legend.LegendForm.$VALUES;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
                Legend.LegendForm[] legendFormArr2 = Legend.LegendForm.$VALUES;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
                Legend.LegendForm[] legendFormArr3 = Legend.LegendForm.$VALUES;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
                Legend.LegendForm[] legendFormArr4 = Legend.LegendForm.$VALUES;
                iArr5[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
                Legend.LegendForm[] legendFormArr5 = Legend.LegendForm.$VALUES;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr7 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr7;
            try {
                iArr7[0] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
                Legend.LegendOrientation[] legendOrientationArr = Legend.LegendOrientation.$VALUES;
                iArr8[1] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr9 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr9;
            try {
                iArr9[0] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;
                Legend.LegendVerticalAlignment[] legendVerticalAlignmentArr = Legend.LegendVerticalAlignment.$VALUES;
                iArr10[2] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;
                Legend.LegendVerticalAlignment[] legendVerticalAlignmentArr2 = Legend.LegendVerticalAlignment.$VALUES;
                iArr11[1] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr12 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr12;
            try {
                iArr12[0] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
                Legend.LegendHorizontalAlignment[] legendHorizontalAlignmentArr = Legend.LegendHorizontalAlignment.$VALUES;
                iArr13[2] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
                Legend.LegendHorizontalAlignment[] legendHorizontalAlignmentArr2 = Legend.LegendHorizontalAlignment.$VALUES;
                iArr14[1] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public final void computeLegend(LineData lineData) {
        float f;
        float f2;
        String str;
        float f3;
        Paint paint = this.mLegendLabelPaint;
        Legend legend = this.mLegend;
        legend.getClass();
        ArrayList arrayList = this.computedEntries;
        arrayList.clear();
        LineData lineData2 = lineData;
        int i = 0;
        while (true) {
            ArrayList arrayList2 = lineData.mDataSets;
            int i2 = -1;
            if (i >= (arrayList2 == null ? 0 : arrayList2.size())) {
                break;
            }
            IDataSet dataSetByIndex = lineData2.getDataSetByIndex(i);
            if (dataSetByIndex != null) {
                LineDataSet lineDataSet = (LineDataSet) dataSetByIndex;
                ArrayList arrayList3 = lineDataSet.mColors;
                int size = lineDataSet.mEntries.size();
                int i3 = 0;
                while (i3 < arrayList3.size() && i3 < size) {
                    String str2 = (i3 >= arrayList3.size() + i2 || i3 >= size + (-1)) ? ((LineDataSet) lineData.getDataSetByIndex(i)).mLabel : null;
                    Legend.LegendForm legendForm = lineDataSet.mForm;
                    float f4 = lineDataSet.mFormSize;
                    float f5 = lineDataSet.mFormLineWidth;
                    int iIntValue = ((Integer) arrayList3.get(i3)).intValue();
                    LegendEntry legendEntry = new LegendEntry();
                    Legend.LegendForm[] legendFormArr = Legend.LegendForm.$VALUES;
                    legendEntry.label = str2;
                    legendEntry.form = legendForm;
                    legendEntry.formSize = f4;
                    legendEntry.formLineWidth = f5;
                    legendEntry.formColor = iIntValue;
                    arrayList.add(legendEntry);
                    i3++;
                    i2 = -1;
                }
                lineData2 = lineData;
            }
            i++;
        }
        legend.mEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
        paint.setTextSize(legend.mTextSize);
        paint.setColor(legend.mTextColor);
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.a;
        ArrayList arrayList4 = legend.mCalculatedLabelBreakPoints;
        ArrayList arrayList5 = legend.mCalculatedLabelSizes;
        ArrayList arrayList6 = legend.mCalculatedLineSizes;
        float f6 = legend.mFormSize;
        float fConvertDpToPixel = Utils.convertDpToPixel(f6);
        float fConvertDpToPixel2 = Utils.convertDpToPixel(legend.mStackSpace);
        float fConvertDpToPixel3 = Utils.convertDpToPixel(legend.mFormToTextSpace);
        float fConvertDpToPixel4 = Utils.convertDpToPixel(legend.mXEntrySpace);
        float fConvertDpToPixel5 = Utils.convertDpToPixel(0.0f);
        LegendEntry[] legendEntryArr = legend.mEntries;
        int length = legendEntryArr.length;
        int length2 = legendEntryArr.length;
        int i4 = 0;
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (i4 < length2) {
            int i5 = i4;
            LegendEntry legendEntry2 = legendEntryArr[i5];
            float f9 = f6;
            float fConvertDpToPixel6 = Utils.convertDpToPixel(Float.isNaN(legendEntry2.formSize) ? f9 : legendEntry2.formSize);
            if (fConvertDpToPixel6 > f7) {
                f7 = fConvertDpToPixel6;
            }
            String str3 = legendEntry2.label;
            if (str3 != null) {
                float fMeasureText = (int) paint.measureText(str3);
                if (fMeasureText > f8) {
                    f8 = fMeasureText;
                }
            }
            i4 = i5 + 1;
            f6 = f9;
        }
        LegendEntry[] legendEntryArr2 = legend.mEntries;
        int length3 = legendEntryArr2.length;
        int i6 = 0;
        float f10 = 0.0f;
        while (i6 < length3) {
            int i7 = i6;
            String str4 = legendEntryArr2[i7].label;
            if (str4 != null) {
                float fCalcTextHeight = Utils.calcTextHeight(paint, str4);
                if (fCalcTextHeight > f10) {
                    f10 = fCalcTextHeight;
                }
            }
            i6 = i7 + 1;
        }
        legend.mTextHeightMax = f10;
        int i8 = Legend.AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[legend.mOrientation.ordinal()];
        if (i8 == 1) {
            Paint.FontMetrics fontMetrics = Utils.mFontMetrics;
            paint.getFontMetrics(fontMetrics);
            float f11 = fontMetrics.descent - fontMetrics.ascent;
            float fMax = 0.0f;
            float f12 = 0.0f;
            float fMeasureText2 = 0.0f;
            boolean z = false;
            for (int i9 = 0; i9 < length; i9++) {
                LegendEntry legendEntry3 = legendEntryArr[i9];
                Legend.LegendForm legendForm2 = legendEntry3.form;
                float f13 = legendEntry3.formSize;
                boolean z2 = legendForm2 != Legend.LegendForm.NONE;
                float fConvertDpToPixel7 = Float.isNaN(f13) ? fConvertDpToPixel : Utils.convertDpToPixel(f13);
                String str5 = legendEntry3.label;
                if (!z) {
                    fMeasureText2 = 0.0f;
                }
                if (z2) {
                    if (z) {
                        fMeasureText2 += fConvertDpToPixel2;
                    }
                    fMeasureText2 += fConvertDpToPixel7;
                }
                if (str5 != null) {
                    if (z2 && !z) {
                        f = fMeasureText2 + fConvertDpToPixel3;
                    } else if (z) {
                        fMax = Math.max(fMax, fMeasureText2);
                        f12 += f11 + fConvertDpToPixel5;
                        f = 0.0f;
                        z = false;
                    } else {
                        f = fMeasureText2;
                    }
                    f12 = f11 + fConvertDpToPixel5 + f12;
                    fMeasureText2 = f + ((int) paint.measureText(str5));
                } else {
                    fMeasureText2 += fConvertDpToPixel7;
                    if (i9 < length - 1) {
                        fMeasureText2 += fConvertDpToPixel2;
                    }
                    z = true;
                }
                fMax = Math.max(fMax, fMeasureText2);
            }
            legend.mNeededWidth = fMax;
            legend.mNeededHeight = f12;
        } else if (i8 == 2) {
            Paint.FontMetrics fontMetrics2 = Utils.mFontMetrics;
            paint.getFontMetrics(fontMetrics2);
            float f14 = fontMetrics2.descent - fontMetrics2.ascent;
            paint.getFontMetrics(fontMetrics2);
            float f15 = (fontMetrics2.ascent - fontMetrics2.top) + fontMetrics2.bottom + fConvertDpToPixel5;
            viewPortHandler.mContentRect.width();
            arrayList4.clear();
            arrayList5.clear();
            arrayList6.clear();
            int i10 = -1;
            int i11 = 0;
            float fMax2 = 0.0f;
            float f16 = 0.0f;
            float f17 = 0.0f;
            while (true) {
                f2 = f15;
                if (i11 >= length) {
                    break;
                }
                LegendEntry legendEntry4 = legendEntryArr[i11];
                float f18 = fConvertDpToPixel;
                Legend.LegendForm legendForm3 = legendEntry4.form;
                float f19 = fConvertDpToPixel2;
                float f20 = legendEntry4.formSize;
                boolean z3 = legendForm3 != Legend.LegendForm.NONE;
                float fConvertDpToPixel8 = Float.isNaN(f20) ? f18 : Utils.convertDpToPixel(f20);
                String str6 = legendEntry4.label;
                boolean z4 = z3;
                arrayList4.add(Boolean.FALSE);
                float f21 = i10 == -1 ? 0.0f : f16 + f19;
                ArrayList arrayList7 = arrayList4;
                if (str6 != null) {
                    arrayList5.add(Utils.calcTextSize(paint, str6));
                    f3 = f21 + (z4 ? fConvertDpToPixel3 + fConvertDpToPixel8 : 0.0f) + ((FSize) arrayList5.get(i11)).width;
                    str = str6;
                } else {
                    FSize fSize = (FSize) FSize.pool.get();
                    str = str6;
                    fSize.width = 0.0f;
                    fSize.height = 0.0f;
                    arrayList5.add(fSize);
                    if (!z4) {
                        fConvertDpToPixel8 = 0.0f;
                    }
                    f3 = f21 + fConvertDpToPixel8;
                    if (i10 == -1) {
                        i10 = i11;
                    }
                }
                if (str != null || i11 == length - 1) {
                    float f22 = (f17 == 0.0f ? 0.0f : fConvertDpToPixel4) + f3 + f17;
                    if (i11 == length - 1) {
                        FSize fSize2 = (FSize) FSize.pool.get();
                        fSize2.width = f22;
                        fSize2.height = f14;
                        arrayList6.add(fSize2);
                        fMax2 = Math.max(fMax2, f22);
                    }
                    f17 = f22;
                }
                if (str != null) {
                    i10 = -1;
                }
                i11++;
                arrayList4 = arrayList7;
                f15 = f2;
                fConvertDpToPixel2 = f19;
                f16 = f3;
                fConvertDpToPixel = f18;
            }
            legend.mNeededWidth = fMax2;
            legend.mNeededHeight = (f2 * (arrayList6.size() == 0 ? 0 : arrayList6.size() - 1)) + (f14 * arrayList6.size());
        }
        legend.mNeededHeight += legend.mYOffset;
        legend.mNeededWidth += legend.mXOffset;
    }

    public final void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        Canvas canvas2;
        Path path = this.mLineFormPath;
        Paint paint = this.mLegendFormPaint;
        int i = legendEntry.formColor;
        float f3 = legendEntry.formLineWidth;
        float f4 = legendEntry.formSize;
        if (i == 1122868 || i == 1122867 || i == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm legendForm = legendEntry.form;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm = legend.mShape;
        }
        paint.setColor(i);
        if (Float.isNaN(f4)) {
            f4 = legend.mFormSize;
        }
        float fConvertDpToPixel = Utils.convertDpToPixel(f4);
        float f5 = fConvertDpToPixel / 2.0f;
        int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[legendForm.ordinal()];
        if (i2 == 3 || i2 == 4) {
            canvas2 = canvas;
            paint.setStyle(Paint.Style.FILL);
            canvas2.drawCircle(f + f5, f2, f5, paint);
        } else if (i2 != 5) {
            if (i2 == 6) {
                if (Float.isNaN(f3)) {
                    f3 = legend.mFormLineWidth;
                }
                float fConvertDpToPixel2 = Utils.convertDpToPixel(f3);
                legend.getClass();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(fConvertDpToPixel2);
                paint.setPathEffect(null);
                path.reset();
                path.moveTo(f, f2);
                path.lineTo(f + fConvertDpToPixel, f2);
                canvas.drawPath(path, paint);
            }
            canvas2 = canvas;
        } else {
            paint.setStyle(Paint.Style.FILL);
            canvas2 = canvas;
            canvas2.drawRect(f, f2 - f5, f + fConvertDpToPixel, f2 + f5, paint);
        }
        canvas2.restoreToCount(iSave);
    }

    public final void renderLegend(Canvas canvas) {
        float f;
        float f2;
        float f3;
        Canvas canvas2;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        float f4;
        float f5;
        Canvas canvas3;
        boolean z;
        float f6;
        float f7;
        String str;
        Legend.LegendDirection legendDirection;
        float fMeasureText;
        float f8;
        float fWidth;
        LegendRenderer legendRenderer = this;
        Paint.FontMetrics fontMetrics = legendRenderer.legendFontMetrics;
        Paint paint = legendRenderer.mLegendLabelPaint;
        ViewPortHandler viewPortHandler = (ViewPortHandler) legendRenderer.a;
        Legend legend = legendRenderer.mLegend;
        if (legend.mEnabled) {
            paint.setTextSize(legend.mTextSize);
            paint.setColor(legend.mTextColor);
            Rect rect = Utils.mCalcTextHeightRect;
            paint.getFontMetrics(fontMetrics);
            float f9 = fontMetrics.descent - fontMetrics.ascent;
            paint.getFontMetrics(fontMetrics);
            float fConvertDpToPixel = Utils.convertDpToPixel(0.0f) + (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
            float fCalcTextHeight = f9 - (Utils.calcTextHeight(paint, "ABC") / 2.0f);
            LegendEntry[] legendEntryArr = legend.mEntries;
            float fConvertDpToPixel2 = Utils.convertDpToPixel(legend.mFormToTextSpace);
            float fConvertDpToPixel3 = Utils.convertDpToPixel(legend.mXEntrySpace);
            Legend.LegendOrientation legendOrientation = legend.mOrientation;
            Legend.LegendHorizontalAlignment legendHorizontalAlignment = legend.mHorizontalAlignment;
            Legend.LegendVerticalAlignment legendVerticalAlignment = legend.mVerticalAlignment;
            Legend.LegendDirection legendDirection2 = legend.mDirection;
            float fConvertDpToPixel4 = Utils.convertDpToPixel(legend.mFormSize);
            float fConvertDpToPixel5 = Utils.convertDpToPixel(legend.mStackSpace);
            float f10 = legend.mYOffset;
            float f11 = legend.mXOffset;
            int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[legendHorizontalAlignment.ordinal()];
            if (i2 == 1) {
                if (legendOrientation != Legend.LegendOrientation.VERTICAL) {
                    f11 += viewPortHandler.mContentRect.left;
                }
                f = legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? f11 + legend.mNeededWidth : f11;
            } else if (i2 == 2) {
                f = (legendOrientation == Legend.LegendOrientation.VERTICAL ? viewPortHandler.mChartWidth : viewPortHandler.mContentRect.right) - f11;
                if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f -= legend.mNeededWidth;
                }
            } else if (i2 != 3) {
                f = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation2 = Legend.LegendOrientation.VERTICAL;
                if (legendOrientation == legendOrientation2) {
                    fWidth = viewPortHandler.mChartWidth / 2.0f;
                } else {
                    RectF rectF = viewPortHandler.mContentRect;
                    fWidth = (rectF.width() / 2.0f) + rectF.left;
                }
                Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f = fWidth + (legendDirection2 == legendDirection3 ? f11 : -f11);
                if (legendOrientation == legendOrientation2) {
                    double d = f;
                    float f12 = legend.mNeededWidth;
                    f = (float) (d + (legendDirection2 == legendDirection3 ? (((double) (-f12)) / 2.0d) + ((double) f11) : (((double) f12) / 2.0d) - ((double) f11)));
                }
            }
            int i3 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[legendOrientation.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[legendVerticalAlignment.ordinal()];
                if (i4 == 1) {
                    f5 = (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : viewPortHandler.mContentRect.top) + f10;
                } else if (i4 == 2) {
                    f5 = (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? viewPortHandler.mChartHeight : viewPortHandler.mContentRect.bottom) - (legend.mNeededHeight + f10);
                } else if (i4 != 3) {
                    f5 = 0.0f;
                } else {
                    f5 = legend.mYOffset + ((viewPortHandler.mChartHeight / 2.0f) - (legend.mNeededHeight / 2.0f));
                }
                float f13 = f5;
                boolean z2 = false;
                int i5 = 0;
                float f14 = 0.0f;
                while (i5 < legendEntryArr.length) {
                    LegendEntry legendEntry = legendEntryArr[i5];
                    Legend.LegendForm legendForm = legendEntry.form;
                    String str2 = legendEntry.label;
                    float f15 = legendEntry.formSize;
                    boolean z3 = legendForm != Legend.LegendForm.NONE;
                    float fConvertDpToPixel6 = Float.isNaN(f15) ? fConvertDpToPixel4 : Utils.convertDpToPixel(f15);
                    if (z3) {
                        Legend.LegendDirection legendDirection4 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        float f16 = legendDirection2 == legendDirection4 ? f + f14 : f - (fConvertDpToPixel6 - f14);
                        z = z3;
                        f6 = f;
                        legendDirection = legendDirection2;
                        str = str2;
                        float f17 = f16;
                        f7 = f13;
                        canvas3 = canvas;
                        legendRenderer.drawForm(canvas3, f17, f13 + fCalcTextHeight, legendEntry, legendRenderer.mLegend);
                        fMeasureText = legendDirection == legendDirection4 ? f17 + fConvertDpToPixel6 : f17;
                    } else {
                        canvas3 = canvas;
                        z = z3;
                        f6 = f;
                        f7 = f13;
                        str = str2;
                        legendDirection = legendDirection2;
                        fMeasureText = f6;
                    }
                    if (str != null) {
                        if (z && !z2) {
                            fMeasureText += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? fConvertDpToPixel2 : -fConvertDpToPixel2;
                        } else if (z2) {
                            fMeasureText = f6;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fMeasureText -= (int) paint.measureText(str);
                        }
                        if (z2) {
                            float f18 = f9 + fConvertDpToPixel + f7;
                            f7 = f18;
                            f8 = f18 + f9;
                        } else {
                            f8 = f7 + f9;
                        }
                        canvas3.drawText(str, fMeasureText, f8, paint);
                        f13 = f9 + fConvertDpToPixel + f7;
                        f14 = 0.0f;
                    } else {
                        f14 = fConvertDpToPixel6 + fConvertDpToPixel5 + f14;
                        f13 = f7;
                        z2 = true;
                    }
                    i5++;
                    legendDirection2 = legendDirection;
                    f = f6;
                }
                return;
            }
            float f19 = f;
            ArrayList arrayList3 = legend.mCalculatedLineSizes;
            ArrayList arrayList4 = legend.mCalculatedLabelSizes;
            ArrayList arrayList5 = legend.mCalculatedLabelBreakPoints;
            int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[legendVerticalAlignment.ordinal()];
            if (i6 == 1) {
                f2 = f10;
            } else if (i6 != 2) {
                f2 = i6 != 3 ? 0.0f : ((viewPortHandler.mChartHeight - legend.mNeededHeight) / 2.0f) + f10;
            } else {
                f2 = (viewPortHandler.mChartHeight - f10) - legend.mNeededHeight;
            }
            int length = legendEntryArr.length;
            float f20 = f19;
            int i7 = 0;
            int i8 = 0;
            while (i8 < length) {
                float f21 = f2;
                LegendEntry legendEntry2 = legendEntryArr[i8];
                float f22 = f20;
                Legend.LegendForm legendForm2 = legendEntry2.form;
                int i9 = length;
                String str3 = legendEntry2.label;
                LegendEntry[] legendEntryArr2 = legendEntryArr;
                float f23 = legendEntry2.formSize;
                boolean z4 = legendForm2 != Legend.LegendForm.NONE;
                float fConvertDpToPixel7 = Float.isNaN(f23) ? fConvertDpToPixel4 : Utils.convertDpToPixel(f23);
                if (i8 >= arrayList5.size() || !((Boolean) arrayList5.get(i8)).booleanValue()) {
                    f3 = f22;
                } else {
                    f21 = f9 + fConvertDpToPixel + f21;
                    f3 = f19;
                }
                if (f3 == f19 && legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i7 < arrayList3.size()) {
                    f3 += (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? ((FSize) arrayList3.get(i7)).width : -((FSize) arrayList3.get(i7)).width) / 2.0f;
                    i7++;
                }
                int i10 = i7;
                boolean z5 = str3 == null;
                if (z4) {
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f3 -= fConvertDpToPixel7;
                    }
                    float f24 = f3;
                    arrayList = arrayList5;
                    arrayList2 = arrayList3;
                    i = i8;
                    canvas2 = canvas;
                    legendRenderer.drawForm(canvas2, f24, f21 + fCalcTextHeight, legendEntry2, legendRenderer.mLegend);
                    f3 = legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT ? f24 + fConvertDpToPixel7 : f24;
                } else {
                    canvas2 = canvas;
                    arrayList = arrayList5;
                    arrayList2 = arrayList3;
                    i = i8;
                }
                if (z5) {
                    f4 = legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel5 : fConvertDpToPixel5;
                } else {
                    if (z4) {
                        f3 += legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel2 : fConvertDpToPixel2;
                    }
                    Legend.LegendDirection legendDirection5 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (legendDirection2 == legendDirection5) {
                        f3 -= ((FSize) arrayList4.get(i)).width;
                    }
                    canvas2.drawText(str3, f3, f21 + f9, paint);
                    if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f3 += ((FSize) arrayList4.get(i)).width;
                    }
                    f4 = legendDirection2 == legendDirection5 ? -fConvertDpToPixel3 : fConvertDpToPixel3;
                }
                f20 = f3 + f4;
                i8 = i + 1;
                legendRenderer = this;
                f2 = f21;
                i7 = i10;
                length = i9;
                legendEntryArr = legendEntryArr2;
                arrayList5 = arrayList;
                arrayList3 = arrayList2;
            }
        }
    }
}
