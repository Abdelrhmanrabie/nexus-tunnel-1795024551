package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialElevationScale extends MaterialVisibility<ScaleProvider> {
    public MaterialElevationScale(boolean z) {
        ScaleProvider scaleProvider = new ScaleProvider(z);
        scaleProvider.outgoingEndScale = 0.85f;
        scaleProvider.incomingStartScale = 0.85f;
        super(scaleProvider, new FadeProvider());
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
