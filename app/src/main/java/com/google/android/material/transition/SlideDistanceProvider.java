package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    public final int slideEdge;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    public static ObjectAnimator createTranslationXAnimator(final View view, float f, float f2, final float f3) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, f2));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                view.setTranslationX(f3);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static ObjectAnimator createTranslationYAnimator(final View view, float f, float f2, final float f3) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f, f2));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                view.setTranslationY(f3);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createAppear(ViewGroup viewGroup, View view) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.oi);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view, dimensionPixelSize + translationX, translationX, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view, translationX - dimensionPixelSize, translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view, translationY - dimensionPixelSize, translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view, dimensionPixelSize + translationY, translationY, translationY);
        }
        if (i == 8388611) {
            WeakHashMap weakHashMap = qd1.a;
            return createTranslationXAnimator(view, viewGroup.getLayoutDirection() == 1 ? dimensionPixelSize + translationX : translationX - dimensionPixelSize, translationX, translationX);
        }
        if (i != 8388613) {
            throw new IllegalArgumentException(ak.h(i, "Invalid slide direction: "));
        }
        WeakHashMap weakHashMap2 = qd1.a;
        return createTranslationXAnimator(view, viewGroup.getLayoutDirection() == 1 ? translationX - dimensionPixelSize : dimensionPixelSize + translationX, translationX, translationX);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public final Animator createDisappear(ViewGroup viewGroup, View view) {
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.oi);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view, translationX, translationX - dimensionPixelSize, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view, translationX, dimensionPixelSize + translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view, translationY, dimensionPixelSize + translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view, translationY, translationY - dimensionPixelSize, translationY);
        }
        if (i == 8388611) {
            WeakHashMap weakHashMap = qd1.a;
            return createTranslationXAnimator(view, translationX, viewGroup.getLayoutDirection() == 1 ? translationX - dimensionPixelSize : dimensionPixelSize + translationX, translationX);
        }
        if (i != 8388613) {
            throw new IllegalArgumentException(ak.h(i, "Invalid slide direction: "));
        }
        WeakHashMap weakHashMap2 = qd1.a;
        return createTranslationXAnimator(view, translationX, viewGroup.getLayoutDirection() == 1 ? dimensionPixelSize + translationX : translationX - dimensionPixelSize, translationX);
    }
}
