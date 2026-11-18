package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import defpackage.e;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    public final float[] tempStartValues = new float[9];
    public final float[] tempEndValues = new float[9];
    public final Matrix tempMatrix = new Matrix();

    @Override // android.animation.TypeEvaluator
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        float[] fArr = this.tempStartValues;
        matrix.getValues(fArr);
        float[] fArr2 = this.tempEndValues;
        matrix2.getValues(fArr2);
        for (int i = 0; i < 9; i++) {
            float f2 = fArr2[i];
            float f3 = fArr[i];
            fArr2[i] = e.a(f2, f3, f, f3);
        }
        Matrix matrix3 = this.tempMatrix;
        matrix3.setValues(fArr2);
        return matrix3;
    }
}
