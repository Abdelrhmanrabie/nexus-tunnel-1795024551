package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    public float incomingEndThreshold = 1.0f;

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float val$endFraction;
        public final /* synthetic */ float val$endValue;
        public final /* synthetic */ float val$startFraction;
        public final /* synthetic */ float val$startValue;
        public final /* synthetic */ View val$view;

        public AnonymousClass1(View view, float f, float f2, float f3, float f4) {
            this.val$view = view;
            this.val$startValue = f;
            this.val$endValue = f2;
            this.val$startFraction = f3;
            this.val$endFraction = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.val$view.setAlpha(TransitionUtils.lerp(this.val$startValue, this.val$endValue, this.val$startFraction, this.val$endFraction, fFloatValue, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.FadeProvider$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        public final /* synthetic */ float val$originalAlpha;
        public final /* synthetic */ View val$view;

        public AnonymousClass2(View view, float f) {
            this.val$view = view;
            this.val$originalAlpha = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.val$view.setAlpha(this.val$originalAlpha);
        }
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createAppear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        float f = this.incomingEndThreshold;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, 0.0f, alpha, 0.0f, f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createDisappear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, alpha, 0.0f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, alpha));
        return valueAnimatorOfFloat;
    }
}
