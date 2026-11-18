package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import defpackage.e91;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TransformerHorizontalBarChart extends e91 {
    @Override // defpackage.e91
    public final void prepareMatrixOffset() {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.e;
        Matrix matrix = (Matrix) this.b;
        matrix.reset();
        matrix.postTranslate(viewPortHandler.mContentRect.left, viewPortHandler.mChartHeight - viewPortHandler.offsetBottom());
    }
}
