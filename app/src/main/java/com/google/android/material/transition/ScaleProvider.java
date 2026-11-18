package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    public final boolean growing;
    public final float incomingEndScale;
    public float incomingStartScale;
    public float outgoingEndScale;
    public final float outgoingStartScale;
    public boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    public ScaleProvider(boolean z) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z;
    }

    public static ObjectAnimator createScaleAnimator(final View view, float f, float f2) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f, scaleX * f2), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f * scaleY, f2 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                float f3 = scaleX;
                View view2 = view;
                view2.setScaleX(f3);
                view2.setScaleY(scaleY);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createAppear(ViewGroup viewGroup, View view) {
        float f;
        float f2;
        if (this.growing) {
            f = this.incomingStartScale;
            f2 = this.incomingEndScale;
        } else {
            f = this.outgoingEndScale;
            f2 = this.outgoingStartScale;
        }
        return createScaleAnimator(view, f, f2);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createDisappear(ViewGroup viewGroup, View view) {
        float f;
        float f2;
        if (!this.scaleOnDisappear) {
            return null;
        }
        if (this.growing) {
            f = this.outgoingEndScale;
            f2 = this.outgoingStartScale;
        } else {
            f = this.incomingStartScale;
            f2 = this.incomingEndScale;
        }
        return createScaleAnimator(view, f2, f);
    }
}
