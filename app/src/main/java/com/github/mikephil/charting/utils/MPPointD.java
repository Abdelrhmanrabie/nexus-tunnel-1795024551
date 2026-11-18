package com.github.mikephil.charting.utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MPPointD extends ObjectPool.Poolable {
    public static final ObjectPool pool;
    public double x = 0.0d;
    public double y = 0.0d;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(64, new MPPointD());
        pool = objectPoolCreate;
        objectPoolCreate.replenishPercentage = 0.5f;
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = (MPPointD) pool.get();
        mPPointD.x = d;
        mPPointD.y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle(mPPointD);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable instantiate() {
        return new MPPointD();
    }

    public final String toString() {
        return "MPPointD, x: " + this.x + ", y: " + this.y;
    }
}
