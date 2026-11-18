package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.a;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    public float animationFraction;
    public ObjectAnimator animator;
    public a animatorCompleteCallback;
    public final LinearProgressIndicatorSpec baseSpec;
    public ObjectAnimator completeEndAnimator;
    public boolean dirtyColors;
    public int indicatorColorIndex;
    public final Interpolator[] interpolatorArray;
    public static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = {533, 567, 850, 750};
    public static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = {1267, InternalZipConstants.AES_HASH_ITERATIONS, 333, 0};
    public static final Property ANIMATION_FRACTION = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.3
        @Override // android.util.Property
        public final Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.animationFraction);
        }

        @Override // android.util.Property
        public final void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f) {
            LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate2 = linearIndeterminateDisjointAnimatorDelegate;
            float fFloatValue = f.floatValue();
            linearIndeterminateDisjointAnimatorDelegate2.animationFraction = fFloatValue;
            int i = (int) (fFloatValue * 1800.0f);
            for (int i2 = 0; i2 < 4; i2++) {
                linearIndeterminateDisjointAnimatorDelegate2.segmentPositions[i2] = Math.max(0.0f, Math.min(1.0f, linearIndeterminateDisjointAnimatorDelegate2.interpolatorArray[i2].getInterpolation((i - LinearIndeterminateDisjointAnimatorDelegate.DELAY_TO_MOVE_SEGMENT_ENDS[i2]) / LinearIndeterminateDisjointAnimatorDelegate.DURATION_TO_MOVE_SEGMENT_ENDS[i2])));
            }
            if (linearIndeterminateDisjointAnimatorDelegate2.dirtyColors) {
                Arrays.fill(linearIndeterminateDisjointAnimatorDelegate2.segmentColors, MaterialColors.compositeARGBWithAlpha(linearIndeterminateDisjointAnimatorDelegate2.baseSpec.indicatorColors[linearIndeterminateDisjointAnimatorDelegate2.indicatorColorIndex], linearIndeterminateDisjointAnimatorDelegate2.drawable.totalAlpha));
                linearIndeterminateDisjointAnimatorDelegate2.dirtyColors = false;
            }
            linearIndeterminateDisjointAnimatorDelegate2.drawable.invalidateSelf();
        }
    };

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolatorArray = new Interpolator[]{AnimationUtils.loadInterpolator(context, R.animator.j), AnimationUtils.loadInterpolator(context, R.animator.k), AnimationUtils.loadInterpolator(context, R.animator.l), AnimationUtils.loadInterpolator(context, R.animator.m)};
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
        cancelAnimatorImmediately();
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.setFloatValues(this.animationFraction, 1.0f);
            this.completeEndAnimator.setDuration((long) ((1.0f - this.animationFraction) * 1800.0f));
            this.completeEndAnimator.start();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void startAnimator() {
        ObjectAnimator objectAnimator = this.animator;
        Property property = ANIMATION_FRACTION;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) property, 0.0f, 1.0f);
            this.animator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex = (linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex + 1) % linearIndeterminateDisjointAnimatorDelegate.baseSpec.indicatorColors.length;
                    linearIndeterminateDisjointAnimatorDelegate.dirtyColors = true;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) property, 1.0f);
            this.completeEndAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.completeEndAnimator.setInterpolator(null);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.cancelAnimatorImmediately();
                    a aVar = linearIndeterminateDisjointAnimatorDelegate.animatorCompleteCallback;
                    if (aVar != null) {
                        aVar.onAnimationEnd();
                    }
                }
            });
        }
        this.indicatorColorIndex = 0;
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.totalAlpha);
        int[] iArr = this.segmentColors;
        iArr[0] = iCompositeARGBWithAlpha;
        iArr[1] = iCompositeARGBWithAlpha;
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
