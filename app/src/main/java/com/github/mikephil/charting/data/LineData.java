package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LineData {
    public ArrayList mDataSets;
    public float mLeftAxisMax;
    public float mLeftAxisMin;
    public float mRightAxisMax;
    public float mRightAxisMin;
    public float mXMax;
    public float mXMin;
    public float mYMax;
    public float mYMin;

    public final IDataSet getDataSetByIndex(int i) {
        ArrayList arrayList = this.mDataSets;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return (IDataSet) arrayList.get(i);
    }

    public final int getEntryCount() {
        Iterator it = this.mDataSets.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((LineDataSet) ((IDataSet) it.next())).mEntries.size();
        }
        return size;
    }
}
