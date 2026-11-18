package com.github.ybq.android.spinkit.animation.interpolator;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class KeyFrameInterpolator implements Interpolator {
    public float[] fractions;
    public final PathInterpolator interpolator;

    public KeyFrameInterpolator(PathInterpolator pathInterpolator, float... fArr) {
        this.interpolator = pathInterpolator;
        this.fractions = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        int length = this.fractions.length;
        PathInterpolator pathInterpolator = this.interpolator;
        if (length > 1) {
            int i = 0;
            while (true) {
                float[] fArr = this.fractions;
                if (i >= fArr.length - 1) {
                    break;
                }
                float f2 = fArr[i];
                i++;
                float f3 = fArr[i];
                float f4 = f3 - f2;
                if (f >= f2 && f <= f3) {
                    return (pathInterpolator.getInterpolation((f - f2) / f4) * f4) + f2;
                }
            }
        }
        return pathInterpolator.getInterpolation(f);
    }
}
