package com.github.mikephil.charting.utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MPPointF extends ObjectPool.Poolable {
    public static final ObjectPool pool;
    public float x = 0.0f;
    public float y = 0.0f;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(32, new MPPointF());
        pool = objectPoolCreate;
        objectPoolCreate.replenishPercentage = 0.5f;
    }

    public static MPPointF getInstance(float f, float f2) {
        MPPointF mPPointF = (MPPointF) pool.get();
        mPPointF.x = f;
        mPPointF.y = f2;
        return mPPointF;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        pool.recycle(mPPointF);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable instantiate() {
        return new MPPointF();
    }
}
