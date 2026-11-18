package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.h;
import defpackage.g81;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TextScale extends h {
    @Override // androidx.transition.h
    public final void captureEndValues(g81 g81Var) {
        View view = g81Var.b;
        if (view instanceof TextView) {
            g81Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.h
    public final void captureStartValues(g81 g81Var) {
        View view = g81Var.b;
        if (view instanceof TextView) {
            g81Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.h
    public final Animator createAnimator(ViewGroup viewGroup, g81 g81Var, g81 g81Var2) {
        if (g81Var == null || g81Var2 == null || !(g81Var.b instanceof TextView)) {
            return null;
        }
        View view = g81Var2.b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        HashMap map = g81Var.a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        HashMap map2 = g81Var2.a;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView2 = textView;
                textView2.setScaleX(fFloatValue3);
                textView2.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}
