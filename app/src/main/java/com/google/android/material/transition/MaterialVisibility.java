package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.l;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import defpackage.g81;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends l {
    public final ArrayList additionalAnimatorProviders = new ArrayList();
    public final VisibilityAnimatorProvider primaryAnimatorProvider;
    public final VisibilityAnimatorProvider secondaryAnimatorProvider;

    public MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    public static void addAnimatorIfNeeded(ArrayList arrayList, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator animatorCreateAppear = z ? visibilityAnimatorProvider.createAppear(viewGroup, view) : visibilityAnimatorProvider.createDisappear(viewGroup, view);
        if (animatorCreateAppear != null) {
            arrayList.add(animatorCreateAppear);
        }
    }

    public final AnimatorSet createAnimator(ViewGroup viewGroup, View view, boolean z) {
        int iResolveThemeDuration;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z);
        Iterator it = this.additionalAnimatorProviders.iterator();
        while (it.hasNext()) {
            addAnimatorIfNeeded(arrayList, (VisibilityAnimatorProvider) it.next(), viewGroup, view, z);
        }
        Context context = viewGroup.getContext();
        int durationThemeAttrResId = getDurationThemeAttrResId(z);
        RectF rectF = TransitionUtils.transformAlphaRectF;
        if (durationThemeAttrResId != 0 && this.mDuration == -1 && (iResolveThemeDuration = MotionUtils.resolveThemeDuration(context, durationThemeAttrResId, -1)) != -1) {
            setDuration(iResolveThemeDuration);
        }
        int easingThemeAttrResId = getEasingThemeAttrResId();
        TimeInterpolator defaultEasingInterpolator = getDefaultEasingInterpolator();
        if (easingThemeAttrResId != 0 && this.mInterpolator == null) {
            setInterpolator(MotionUtils.resolveThemeInterpolator(context, easingThemeAttrResId, defaultEasingInterpolator));
        }
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public TimeInterpolator getDefaultEasingInterpolator() {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int getDurationThemeAttrResId(boolean z) {
        return 0;
    }

    public int getEasingThemeAttrResId() {
        return 0;
    }

    @Override // androidx.transition.l
    public Animator onAppear(ViewGroup viewGroup, View view, g81 g81Var) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // androidx.transition.l
    public Animator onDisappear(ViewGroup viewGroup, View view, g81 g81Var) {
        return createAnimator(viewGroup, view, false);
    }
}
