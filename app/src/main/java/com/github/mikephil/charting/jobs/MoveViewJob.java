package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.ViewPortHandler;
import defpackage.e91;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MoveViewJob extends ObjectPool.Poolable implements Runnable {
    public static final ObjectPool pool;
    public e91 mTrans;
    public ViewPortHandler mViewPortHandler;
    public final float[] pts = new float[2];
    public View view;
    public float xValue;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(2, new MoveViewJob(null, 0.0f, null, null));
        pool = objectPoolCreate;
        objectPoolCreate.replenishPercentage = 0.5f;
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f, e91 e91Var, View view) {
        this.mViewPortHandler = viewPortHandler;
        this.xValue = f;
        this.mTrans = e91Var;
        this.view = view;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable instantiate() {
        return new MoveViewJob(this.mViewPortHandler, this.xValue, this.mTrans, this.view);
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f = this.xValue;
        float[] fArr = this.pts;
        fArr[0] = f;
        fArr[1] = 0.0f;
        this.mTrans.pointValuesToPixel(fArr);
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        View view = this.view;
        Matrix matrix = viewPortHandler.mCenterViewPortMatrixBuffer;
        matrix.reset();
        matrix.set(viewPortHandler.mMatrixTouch);
        float f2 = fArr[0];
        RectF rectF = viewPortHandler.mContentRect;
        matrix.postTranslate(-(f2 - rectF.left), -(fArr[1] - rectF.top));
        viewPortHandler.refresh(matrix, view, true);
        pool.recycle(this);
    }
}
