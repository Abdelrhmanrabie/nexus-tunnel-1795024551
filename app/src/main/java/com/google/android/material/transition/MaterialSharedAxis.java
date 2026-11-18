package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.g81;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public MaterialSharedAxis(int i, boolean z) {
        VisibilityAnimatorProvider slideDistanceProvider;
        if (i == 0) {
            slideDistanceProvider = new SlideDistanceProvider(z ? 8388613 : 8388611);
        } else if (i == 1) {
            slideDistanceProvider = new SlideDistanceProvider(z ? 80 : 48);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(ak.h(i, "Invalid axis: "));
            }
            slideDistanceProvider = new ScaleProvider(z);
        }
        super(slideDistanceProvider, new FadeThroughProvider());
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
