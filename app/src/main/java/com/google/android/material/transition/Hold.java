package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.l;
import defpackage.g81;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Hold extends l {
    @Override // androidx.transition.l
    public final Animator onAppear(ViewGroup viewGroup, View view, g81 g81Var) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // androidx.transition.l
    public final Animator onDisappear(ViewGroup viewGroup, View view, g81 g81Var) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
