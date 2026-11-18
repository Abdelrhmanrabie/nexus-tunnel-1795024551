package com.google.android.material.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import defpackage.e;
import defpackage.vs;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class AnimationUtils {
    public static final LinearInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final vs FAST_OUT_SLOW_IN_INTERPOLATOR = new vs();
    public static final vs FAST_OUT_LINEAR_IN_INTERPOLATOR = new vs(vs.c);
    public static final vs LINEAR_OUT_SLOW_IN_INTERPOLATOR = new vs(vs.c$1);
    public static final DecelerateInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3, float f4, float f5) {
        if (f5 < f3) {
            return f;
        }
        return f5 > f4 ? f2 : e.a(f2, f, (f5 - f3) / (f4 - f3), f);
    }
}
