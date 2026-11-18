package com.github.mikephil.charting.data;

import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import defpackage.bj;
import java.util.ArrayList;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LineDataSet implements IDataSet {
    public YAxis.AxisDependency mAxisDependency;
    public ArrayList mCircleColors;
    public int mCircleHoleColor;
    public float mCircleHoleRadius;
    public float mCircleRadius;
    public ArrayList mColors;
    public float mCubicIntensity;
    public boolean mDrawCircleHole;
    public boolean mDrawCircles;
    public boolean mDrawFilled;
    public boolean mDrawHorizontalHighlightIndicator;
    public boolean mDrawIcons;
    public boolean mDrawValues;
    public boolean mDrawVerticalHighlightIndicator;
    public ArrayList mEntries;
    public int mFillAlpha;
    public int mFillColor;
    public HurlStack mFillFormatter;
    public Legend.LegendForm mForm;
    public float mFormLineWidth;
    public float mFormSize;
    public int mHighLightColor;
    public boolean mHighlightEnabled;
    public float mHighlightLineWidth;
    public MPPointF mIconsOffset;
    public String mLabel;
    public float mLineWidth;
    public Mode mMode;
    public ArrayList mValueColors;
    public transient bj mValueFormatter;
    public float mValueTextSize;
    public boolean mVisible;
    public float mXMax;
    public float mXMin;
    public float mYMax;
    public float mYMin;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static final Mode CUBIC_BEZIER;
        public static final Mode LINEAR;
        public static final Mode STEPPED;

        static {
            Mode mode = new Mode("LINEAR", 0);
            LINEAR = mode;
            Mode mode2 = new Mode("STEPPED", 1);
            STEPPED = mode2;
            Mode mode3 = new Mode("CUBIC_BEZIER", 2);
            CUBIC_BEZIER = mode3;
            $VALUES = new Mode[]{mode, mode2, mode3, new Mode("HORIZONTAL_BEZIER", 3)};
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public final ArrayList getEntriesForXValue(float f) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.mEntries;
        int size = arrayList2.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (size + i) / 2;
            float f2 = ((Entry) arrayList2.get(i2)).x;
            if (f == f2) {
                while (i2 > 0) {
                    int i3 = i2 - 1;
                    if (((Entry) arrayList2.get(i3)).x != f) {
                        break;
                    }
                    i2 = i3;
                }
                int size2 = arrayList2.size();
                while (i2 < size2) {
                    Entry entry = (Entry) arrayList2.get(i2);
                    if (entry.x != f) {
                        break;
                    }
                    arrayList.add(entry);
                    i2++;
                }
                break;
            }
            if (f > f2) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }

    public final Entry getEntryForIndex(int i) {
        return (Entry) this.mEntries.get(i);
    }

    public final Entry getEntryForXValue(float f, float f2, DataSet$Rounding dataSet$Rounding) {
        int size;
        int i;
        Entry entry;
        ArrayList arrayList = this.mEntries;
        if (arrayList == null || arrayList.isEmpty()) {
            size = -1;
        } else {
            size = arrayList.size() - 1;
            int i2 = 0;
            while (i2 < size) {
                int i3 = (i2 + size) / 2;
                float f3 = ((Entry) arrayList.get(i3)).x - f;
                int i4 = i3 + 1;
                float f4 = ((Entry) arrayList.get(i4)).x - f;
                float fAbs = Math.abs(f3);
                float fAbs2 = Math.abs(f4);
                if (fAbs2 >= fAbs) {
                    if (fAbs >= fAbs2) {
                        double d = f3;
                        if (d < 0.0d) {
                            if (d < 0.0d) {
                            }
                        }
                    }
                    size = i3;
                }
                i2 = i4;
            }
            if (size != -1) {
                float f5 = ((Entry) arrayList.get(size)).x;
                if (dataSet$Rounding == DataSet$Rounding.UP) {
                    if (f5 < f && size < arrayList.size() - 1) {
                        size++;
                    }
                } else if (dataSet$Rounding == DataSet$Rounding.DOWN && f5 > f && size > 0) {
                    size--;
                }
                if (!Float.isNaN(f2)) {
                    while (size > 0) {
                        int i5 = size - 1;
                        if (((Entry) arrayList.get(i5)).x != f5) {
                            break;
                        }
                        size = i5;
                    }
                    float f6 = ((Entry) arrayList.get(size)).y;
                    loop2: while (true) {
                        i = size;
                        size = i;
                        do {
                            size++;
                            if (size >= arrayList.size()) {
                                break loop2;
                            }
                            entry = (Entry) arrayList.get(size);
                            if (entry.x != f5) {
                                break loop2;
                            }
                        } while (Math.abs(entry.y - f2) > Math.abs(f6 - f2));
                        f6 = f2;
                    }
                    size = i;
                }
            }
        }
        if (size > -1) {
            return (Entry) arrayList.get(size);
        }
        return null;
    }

    public final String toString() {
        ArrayList arrayList = this.mEntries;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder("DataSet, label: ");
        String str = this.mLabel;
        if (str == null) {
            str = AppConfig.CUSTOM;
        }
        sb.append(str);
        sb.append(", entries: ");
        sb.append(arrayList.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuffer.append(((Entry) arrayList.get(i)).toString().concat(" "));
        }
        return stringBuffer.toString();
    }
}
