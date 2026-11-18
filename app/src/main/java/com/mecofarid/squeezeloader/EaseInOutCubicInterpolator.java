package com.mecofarid.squeezeloader;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class EaseInOutCubicInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = 2.0f * f;
        if (f < 0.5f) {
            return 0.5f * f2 * f2 * f2;
        }
        float f3 = 1;
        float f4 = ((f - 0.5f) * 2) - f3;
        return (0.5f * f4 * f4 * f4) + f3;
    }
}
