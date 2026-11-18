package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    public MaterialFade() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.incomingEndThreshold = 0.3f;
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.scaleOnDisappear = false;
        scaleProvider.incomingStartScale = 0.8f;
        super(fadeProvider, scaleProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final TimeInterpolator getDefaultEasingInterpolator() {
        return AnimationUtils.LINEAR_INTERPOLATOR;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int getDurationThemeAttrResId(boolean z) {
        return z ? R.style.ul : R.style.uk;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public final int getEasingThemeAttrResId() {
        return R.style.up;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }
}
