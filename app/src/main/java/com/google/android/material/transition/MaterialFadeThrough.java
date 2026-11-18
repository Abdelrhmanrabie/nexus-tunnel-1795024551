package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import defpackage.g81;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
    public MaterialFadeThrough() {
        FadeThroughProvider fadeThroughProvider = new FadeThroughProvider();
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.scaleOnDisappear = false;
        scaleProvider.incomingStartScale = 0.92f;
        super(fadeThroughProvider, scaleProvider);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int getDurationThemeAttrResId(boolean z) {
        return R.style.ug;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public final int getEasingThemeAttrResId() {
        return R.style.uq;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.l
    public final Animator onAppear(ViewGroup viewGroup, View view, g81 g81Var) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.l
    public final Animator onDisappear(ViewGroup viewGroup, View view, g81 g81Var) {
        return createAnimator(viewGroup, view, false);
    }
}
