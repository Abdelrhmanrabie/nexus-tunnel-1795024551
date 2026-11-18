package renz.javacodez.vpn.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.bj;
import defpackage.e91;
import defpackage.z21$a;
import java.util.ArrayList;
import java.util.Iterator;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class GraphFragment extends Fragment {
    public int b;
    public Handler c;
    public LineChart d;
    public z21$a f;
    public final a g = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            GraphFragment.this.c.postDelayed(this, 1000L);
            z21$a z21_a = GraphFragment.this.f;
            synchronized (z21_a) {
                z = z21_a.a;
            }
            if (z) {
                GraphFragment.a(GraphFragment.this);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements IAxisValueFormatter {
        public b() {
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public final String getFormattedValue(float f, AxisBase axisBase) {
            GraphFragment.this.f.getClass();
            return z21$a.b((long) f, false);
        }
    }

    public static void a(GraphFragment graphFragment) {
        ArrayList arrayList;
        IDataSet iDataSet;
        IDataSet iDataSet2;
        if (graphFragment.d != null) {
            ArrayList<Entry> arrayList2 = new ArrayList();
            z21$a z21_aM3a = bj.b().m3a();
            graphFragment.f = z21_aM3a;
            synchronized (z21_aM3a) {
                z21_aM3a.c();
                ArrayList arrayList3 = z21_aM3a.e;
                arrayList = new ArrayList();
                for (int i = 0; i < arrayList3.size(); i++) {
                    arrayList.add(Long.valueOf(((z21$a.a) arrayList3.get(i)).a));
                }
            }
            int size = arrayList.size();
            int iMax = Math.max(0, size - 30);
            for (int i2 = iMax; i2 < size; i2++) {
                float fLongValue = ((Long) arrayList.get(i2)).longValue();
                Boolean bool = Boolean.TRUE;
                Entry entry = new Entry();
                entry.y = fLongValue;
                entry.mData = bool;
                entry.x = i2 - iMax;
                arrayList2.add(entry);
            }
            LineDataSet lineDataSet = new LineDataSet();
            lineDataSet.mColors = null;
            lineDataSet.mValueColors = null;
            lineDataSet.mLabel = "DataSet";
            lineDataSet.mAxisDependency = YAxis.AxisDependency.LEFT;
            lineDataSet.mHighlightEnabled = true;
            lineDataSet.mForm = Legend.LegendForm.DEFAULT;
            lineDataSet.mFormSize = Float.NaN;
            lineDataSet.mFormLineWidth = Float.NaN;
            lineDataSet.mDrawValues = true;
            lineDataSet.mDrawIcons = true;
            lineDataSet.mIconsOffset = new MPPointF();
            lineDataSet.mValueTextSize = 17.0f;
            lineDataSet.mVisible = true;
            lineDataSet.mColors = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            lineDataSet.mValueColors = arrayList4;
            lineDataSet.mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
            arrayList4.add(-16777216);
            lineDataSet.mLabel = AppConfig.CUSTOM;
            lineDataSet.mEntries = arrayList2;
            lineDataSet.mYMax = -3.4028235E38f;
            lineDataSet.mYMin = Float.MAX_VALUE;
            lineDataSet.mXMax = -3.4028235E38f;
            lineDataSet.mXMin = Float.MAX_VALUE;
            if (!arrayList2.isEmpty()) {
                for (Entry entry2 : arrayList2) {
                    if (entry2 != null) {
                        float f = entry2.x;
                        if (f < lineDataSet.mXMin) {
                            lineDataSet.mXMin = f;
                        }
                        if (f > lineDataSet.mXMax) {
                            lineDataSet.mXMax = f;
                        }
                        float f2 = entry2.y;
                        if (f2 < lineDataSet.mYMin) {
                            lineDataSet.mYMin = f2;
                        }
                        if (f2 > lineDataSet.mYMax) {
                            lineDataSet.mYMax = f2;
                        }
                    }
                }
            }
            lineDataSet.mHighLightColor = Color.rgb(255, 187, 115);
            lineDataSet.mDrawVerticalHighlightIndicator = true;
            lineDataSet.mDrawHorizontalHighlightIndicator = true;
            lineDataSet.mHighlightLineWidth = 0.5f;
            lineDataSet.mHighlightLineWidth = Utils.convertDpToPixel(0.5f);
            lineDataSet.mFillColor = Color.rgb(140, 234, 255);
            lineDataSet.mFillAlpha = 85;
            lineDataSet.mLineWidth = 2.5f;
            lineDataSet.mDrawFilled = false;
            lineDataSet.mMode = LineDataSet.Mode.LINEAR;
            lineDataSet.mCircleColors = null;
            lineDataSet.mCircleHoleColor = -1;
            lineDataSet.mCircleRadius = 8.0f;
            lineDataSet.mCircleHoleRadius = 4.0f;
            lineDataSet.mCubicIntensity = 0.2f;
            lineDataSet.mFillFormatter = new HurlStack(4);
            lineDataSet.mDrawCircles = true;
            lineDataSet.mDrawCircleHole = true;
            ArrayList arrayList5 = new ArrayList();
            lineDataSet.mCircleColors = arrayList5;
            arrayList5.clear();
            arrayList5.add(Integer.valueOf(Color.rgb(140, 234, 255)));
            int i3 = graphFragment.b;
            lineDataSet.mLineWidth = Utils.convertDpToPixel(1.5f);
            lineDataSet.mDrawCircles = false;
            lineDataSet.mDrawFilled = true;
            lineDataSet.mFillColor = i3;
            if (lineDataSet.mColors == null) {
                lineDataSet.mColors = new ArrayList();
            }
            lineDataSet.mColors.clear();
            lineDataSet.mColors.add(Integer.valueOf(i3));
            lineDataSet.mMode = LineDataSet.Mode.CUBIC_BEZIER;
            lineDataSet.mCubicIntensity = 0.25f;
            lineDataSet.mDrawValues = false;
            ArrayList<IDataSet> arrayList6 = new ArrayList();
            arrayList6.add(lineDataSet);
            LineData lineData = new LineData();
            lineData.mLeftAxisMax = -3.4028235E38f;
            lineData.mLeftAxisMin = Float.MAX_VALUE;
            lineData.mRightAxisMax = -3.4028235E38f;
            lineData.mRightAxisMin = Float.MAX_VALUE;
            lineData.mDataSets = arrayList6;
            lineData.mYMax = -3.4028235E38f;
            lineData.mYMin = Float.MAX_VALUE;
            lineData.mXMax = -3.4028235E38f;
            lineData.mXMin = Float.MAX_VALUE;
            for (IDataSet iDataSet3 : arrayList6) {
                float f3 = lineData.mYMax;
                LineDataSet lineDataSet2 = (LineDataSet) iDataSet3;
                float f4 = lineDataSet2.mYMax;
                if (f3 < f4) {
                    lineData.mYMax = f4;
                }
                float f5 = lineData.mYMin;
                float f6 = lineDataSet2.mYMin;
                if (f5 > f6) {
                    lineData.mYMin = f6;
                }
                float f7 = lineData.mXMax;
                float f8 = lineDataSet2.mXMax;
                if (f7 < f8) {
                    lineData.mXMax = f8;
                }
                float f9 = lineData.mXMin;
                float f10 = lineDataSet2.mXMin;
                if (f9 > f10) {
                    lineData.mXMin = f10;
                }
                if (lineDataSet2.mAxisDependency == YAxis.AxisDependency.LEFT) {
                    if (lineData.mLeftAxisMax < f4) {
                        lineData.mLeftAxisMax = f4;
                    }
                    if (lineData.mLeftAxisMin > f6) {
                        lineData.mLeftAxisMin = f6;
                    }
                } else {
                    if (lineData.mRightAxisMax < f4) {
                        lineData.mRightAxisMax = f4;
                    }
                    if (lineData.mRightAxisMin > f6) {
                        lineData.mRightAxisMin = f6;
                    }
                }
            }
            lineData.mLeftAxisMax = -3.4028235E38f;
            lineData.mLeftAxisMin = Float.MAX_VALUE;
            lineData.mRightAxisMax = -3.4028235E38f;
            lineData.mRightAxisMin = Float.MAX_VALUE;
            Iterator it = arrayList6.iterator();
            do {
                if (!it.hasNext()) {
                    iDataSet = null;
                    break;
                }
                iDataSet = (IDataSet) it.next();
            } while (((LineDataSet) iDataSet).mAxisDependency != YAxis.AxisDependency.LEFT);
            if (iDataSet != null) {
                LineDataSet lineDataSet3 = (LineDataSet) iDataSet;
                lineData.mLeftAxisMax = lineDataSet3.mYMax;
                lineData.mLeftAxisMin = lineDataSet3.mYMin;
                Iterator it2 = arrayList6.iterator();
                while (it2.hasNext()) {
                    LineDataSet lineDataSet4 = (LineDataSet) ((IDataSet) it2.next());
                    if (lineDataSet4.mAxisDependency == YAxis.AxisDependency.LEFT) {
                        float f11 = lineDataSet4.mYMin;
                        if (f11 < lineData.mLeftAxisMin) {
                            lineData.mLeftAxisMin = f11;
                        }
                        float f12 = lineDataSet4.mYMax;
                        if (f12 > lineData.mLeftAxisMax) {
                            lineData.mLeftAxisMax = f12;
                        }
                    }
                }
            }
            Iterator it3 = arrayList6.iterator();
            do {
                if (!it3.hasNext()) {
                    iDataSet2 = null;
                    break;
                }
                iDataSet2 = (IDataSet) it3.next();
            } while (((LineDataSet) iDataSet2).mAxisDependency != YAxis.AxisDependency.RIGHT);
            if (iDataSet2 != null) {
                LineDataSet lineDataSet5 = (LineDataSet) iDataSet2;
                lineData.mRightAxisMax = lineDataSet5.mYMax;
                lineData.mRightAxisMin = lineDataSet5.mYMin;
                Iterator it4 = arrayList6.iterator();
                while (it4.hasNext()) {
                    LineDataSet lineDataSet6 = (LineDataSet) ((IDataSet) it4.next());
                    if (lineDataSet6.mAxisDependency == YAxis.AxisDependency.RIGHT) {
                        float f13 = lineDataSet6.mYMin;
                        if (f13 < lineData.mRightAxisMin) {
                            lineData.mRightAxisMin = f13;
                        }
                        float f14 = lineDataSet6.mYMax;
                        if (f14 > lineData.mRightAxisMax) {
                            lineData.mRightAxisMax = f14;
                        }
                    }
                }
            }
            int size2 = ((LineDataSet) lineData.getDataSetByIndex(0)).mEntries.size();
            LineChart lineChart = graphFragment.d;
            if (size2 < 3) {
                lineChart.setData(null);
            } else {
                lineChart.setData(lineData);
            }
            LineChart lineChart2 = graphFragment.d;
            float f15 = lineChart2.mXAxis.mAxisRange / 30.0f;
            ViewPortHandler viewPortHandler = lineChart2.mViewPortHandler;
            viewPortHandler.getClass();
            if (f15 < 1.0f) {
                f15 = 1.0f;
            }
            viewPortHandler.mMinScaleX = f15;
            viewPortHandler.limitTransAndScale(viewPortHandler.mMatrixTouch, viewPortHandler.mContentRect);
            LineChart lineChart3 = graphFragment.d;
            float entryCount = lineData.getEntryCount();
            ViewPortHandler viewPortHandler2 = lineChart3.mViewPortHandler;
            e91 transformer = lineChart3.getTransformer(YAxis.AxisDependency.LEFT);
            MoveViewJob moveViewJob = (MoveViewJob) MoveViewJob.pool.get();
            moveViewJob.mViewPortHandler = viewPortHandler2;
            moveViewJob.xValue = entryCount;
            moveViewJob.mTrans = transformer;
            moveViewJob.view = lineChart3;
            ViewPortHandler viewPortHandler3 = lineChart3.mViewPortHandler;
            if (viewPortHandler3.mChartHeight <= 0.0f || viewPortHandler3.mChartWidth <= 0.0f) {
                lineChart3.mJobs.add(moveViewJob);
            } else {
                lineChart3.post(moveViewJob);
            }
            graphFragment.d.invalidate();
        }
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = bj.b().m3a();
        View viewInflate = layoutInflater.inflate(R.layout.c0, viewGroup, false);
        this.d = (LineChart) viewInflate.findViewById(R.attr.eu);
        this.b = getActivity().getResources().getColor(R.color.az);
        getActivity().getResources().getColor(android.R.color.white);
        LineChart lineChart = this.d;
        lineChart.mDescription.mEnabled = false;
        lineChart.mLegend.mEnabled = false;
        lineChart.setBackgroundColor(0);
        LineChart lineChart2 = this.d;
        lineChart2.getClass();
        lineChart2.mTouchEnabled = false;
        lineChart2.mDragXEnabled = false;
        lineChart2.mDragYEnabled = false;
        lineChart2.mScaleXEnabled = false;
        lineChart2.mScaleYEnabled = false;
        YAxis yAxis = lineChart2.mAxisRight;
        int i = yAxis.mAxisMaxLabels;
        if (5 <= i) {
            i = 5;
        }
        int i2 = yAxis.mAxisMinLabels;
        if (i < i2) {
            i = i2;
        }
        yAxis.mLabelCount = i;
        yAxis.mDrawGridLines = true;
        yAxis.mTextColor = getActivity().getResources().getColor(R.color.ra);
        yAxis.mCustomAxisMin = true;
        yAxis.mAxisMinimum = 0.0f;
        yAxis.mAxisRange = Math.abs(yAxis.mAxisMaximum - 0.0f);
        yAxis.mAxisValueFormatter = new b();
        YAxis yAxis2 = this.d.mAxisLeft;
        yAxis2.mEnabled = false;
        yAxis2.mCustomAxisMin = true;
        yAxis2.mAxisMinimum = 0.0f;
        yAxis2.mAxisRange = Math.abs(yAxis2.mAxisMaximum - 0.0f);
        LineChart lineChart3 = this.d;
        lineChart3.mXAxis.mEnabled = false;
        lineChart3.mNoDataText = "No Graph Data";
        lineChart3.invalidate();
        Handler handler = new Handler();
        this.c = handler;
        handler.post(this.g);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        this.c.removeCallbacks(this.g);
        super.onDestroy();
    }
}
