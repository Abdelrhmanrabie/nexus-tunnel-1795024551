package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.a;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;
import defpackage.vs;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public static final Property ANIMATION_FRACTION;
    public static final Property COMPLETE_END_FRACTION;
    public float animationFraction;
    public ObjectAnimator animator;
    public a animatorCompleteCallback;
    public final CircularProgressIndicatorSpec baseSpec;
    public ObjectAnimator completeEndAnimator;
    public float completeEndFraction;
    public int indicatorColorIndexOffset;
    public final vs interpolator;
    public static final int[] DELAY_TO_EXPAND_IN_MS = {0, 1350, 2700, 4050};
    public static final int[] DELAY_TO_COLLAPSE_IN_MS = {667, 2017, 3367, 4717};
    public static final int[] DELAY_TO_FADE_IN_MS = {InternalZipConstants.AES_HASH_ITERATIONS, 2350, 3700, 5050};

    static {
        Class<Float> cls = Float.class;
        ANIMATION_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "animationFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.3
            @Override // android.util.Property
            public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.animationFraction);
            }

            @Override // android.util.Property
            public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f) {
                CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate2 = circularIndeterminateAnimatorDelegate;
                float fFloatValue = f.floatValue();
                circularIndeterminateAnimatorDelegate2.animationFraction = fFloatValue;
                int i = (int) (5400.0f * fFloatValue);
                vs vsVar = circularIndeterminateAnimatorDelegate2.interpolator;
                float[] fArr = circularIndeterminateAnimatorDelegate2.segmentPositions;
                float f2 = fFloatValue * 1520.0f;
                fArr[0] = (-20.0f) + f2;
                fArr[1] = f2;
                for (int i2 = 0; i2 < 4; i2++) {
                    float f3 = 667;
                    fArr[1] = (vsVar.getInterpolation((i - CircularIndeterminateAnimatorDelegate.DELAY_TO_EXPAND_IN_MS[i2]) / f3) * 250.0f) + fArr[1];
                    fArr[0] = (vsVar.getInterpolation((i - CircularIndeterminateAnimatorDelegate.DELAY_TO_COLLAPSE_IN_MS[i2]) / f3) * 250.0f) + fArr[0];
                }
                float f4 = fArr[0];
                float f5 = fArr[1];
                float f6 = ((f5 - f4) * circularIndeterminateAnimatorDelegate2.completeEndFraction) + f4;
                fArr[0] = f6;
                fArr[0] = f6 / 360.0f;
                fArr[1] = f5 / 360.0f;
                CircularProgressIndicatorSpec circularProgressIndicatorSpec = circularIndeterminateAnimatorDelegate2.baseSpec;
                for (int i3 = 0; i3 < 4; i3++) {
                    float f7 = (i - CircularIndeterminateAnimatorDelegate.DELAY_TO_FADE_IN_MS[i3]) / 333;
                    if (f7 >= 0.0f && f7 <= 1.0f) {
                        int i4 = i3 + circularIndeterminateAnimatorDelegate2.indicatorColorIndexOffset;
                        int[] iArr = circularProgressIndicatorSpec.indicatorColors;
                        int length = i4 % iArr.length;
                        int length2 = (length + 1) % iArr.length;
                        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], circularIndeterminateAnimatorDelegate2.drawable.totalAlpha);
                        int iCompositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(circularProgressIndicatorSpec.indicatorColors[length2], circularIndeterminateAnimatorDelegate2.drawable.totalAlpha);
                        float interpolation = vsVar.getInterpolation(f7);
                        int[] iArr2 = circularIndeterminateAnimatorDelegate2.segmentColors;
                        ArgbEvaluatorCompat argbEvaluatorCompat = ArgbEvaluatorCompat.instance;
                        Integer numValueOf = Integer.valueOf(iCompositeARGBWithAlpha);
                        Integer numValueOf2 = Integer.valueOf(iCompositeARGBWithAlpha2);
                        argbEvaluatorCompat.getClass();
                        iArr2[0] = ArgbEvaluatorCompat.evaluate2(interpolation, numValueOf, numValueOf2).intValue();
                        break;
                    }
                }
                circularIndeterminateAnimatorDelegate2.drawable.invalidateSelf();
            }
        };
        COMPLETE_END_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "completeEndFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.4
            @Override // android.util.Property
            public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.completeEndFraction);
            }

            @Override // android.util.Property
            public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f) {
                circularIndeterminateAnimatorDelegate.completeEndFraction = f.floatValue();
            }
        };
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = circularProgressIndicatorSpec;
        this.interpolator = new vs();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void registerAnimatorsCompleteCallback(a aVar) {
        this.animatorCompleteCallback = aVar;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator objectAnimator = this.completeEndAnimator;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.start();
        } else {
            cancelAnimatorImmediately();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void startAnimator() {
        if (this.animator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset + 4) % circularIndeterminateAnimatorDelegate.baseSpec.indicatorColors.length;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) COMPLETE_END_FRACTION, 0.0f, 1.0f);
            this.completeEndAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.completeEndAnimator.setInterpolator(this.interpolator);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.cancelAnimatorImmediately();
                    a aVar = circularIndeterminateAnimatorDelegate.animatorCompleteCallback;
                    if (aVar != null) {
                        aVar.onAnimationEnd();
                    }
                }
            });
        }
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.totalAlpha);
        this.completeEndFraction = 0.0f;
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
