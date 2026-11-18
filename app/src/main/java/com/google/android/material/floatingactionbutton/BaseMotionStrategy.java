package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import defpackage.e;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class BaseMotionStrategy implements MotionStrategy {
    public final Context context;
    public MotionSpec defaultMotionSpec;
    public final ExtendedFloatingActionButton fab;
    public final ArrayList listeners = new ArrayList();
    public MotionSpec motionSpec;
    public final AnimatorTracker tracker;

    public BaseMotionStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet createAnimator() {
        MotionSpec motionSpec = this.motionSpec;
        if (motionSpec == null) {
            if (this.defaultMotionSpec == null) {
                this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
            }
            motionSpec = this.defaultMotionSpec;
            motionSpec.getClass();
        }
        return createAnimator(motionSpec);
    }

    public final AnimatorSet createAnimator(MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        boolean zHasPropertyValues = motionSpec.hasPropertyValues("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.fab;
        if (zHasPropertyValues) {
            arrayList.add(motionSpec.getAnimator("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", extendedFloatingActionButton, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", extendedFloatingActionButton, ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", extendedFloatingActionButton, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") { // from class: com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
                @Override // android.util.Property
                public final Float get(ExtendedFloatingActionButton extendedFloatingActionButton2) {
                    ExtendedFloatingActionButton extendedFloatingActionButton3 = extendedFloatingActionButton2;
                    float fAlpha = (Color.alpha(extendedFloatingActionButton3.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton3.originalTextCsl.getColorForState(extendedFloatingActionButton3.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor()));
                    DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
                    return Float.valueOf(e.a(1.0f, 0.0f, fAlpha, 0.0f));
                }

                @Override // android.util.Property
                public final void set(ExtendedFloatingActionButton extendedFloatingActionButton2, Float f) {
                    ExtendedFloatingActionButton extendedFloatingActionButton3 = extendedFloatingActionButton2;
                    Float f2 = f;
                    int colorForState = extendedFloatingActionButton3.originalTextCsl.getColorForState(extendedFloatingActionButton3.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor());
                    float fAlpha = Color.alpha(colorForState) / 255.0f;
                    float fFloatValue = f2.floatValue();
                    DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
                    ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (e.a(fAlpha, 0.0f, fFloatValue, 0.0f) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f2.floatValue() == 1.0f) {
                        extendedFloatingActionButton3.silentlyUpdateTextColor(extendedFloatingActionButton3.originalTextCsl);
                    } else {
                        extendedFloatingActionButton3.silentlyUpdateTextColor(colorStateListValueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationCancel() {
        this.tracker.currentAnimator = null;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationEnd() {
        this.tracker.currentAnimator = null;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(Animator animator) {
        AnimatorTracker animatorTracker = this.tracker;
        Animator animator2 = animatorTracker.currentAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        animatorTracker.currentAnimator = animator;
    }
}
