package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import defpackage.g81;
import defpackage.qd1;
import defpackage.te1;
import defpackage.ye1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c extends l {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends AnimatorListenerAdapter {
        public final View b;
        public boolean c = false;

        public a(View view) {
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ye1 ye1Var = te1.a;
            View view = this.b;
            ye1Var.f(view, 1.0f);
            if (this.c) {
                view.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            WeakHashMap weakHashMap = qd1.a;
            View view = this.b;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.c = true;
                view.setLayerType(2, null);
            }
        }
    }

    public c() {
    }

    public c(int i) {
        if ((i & (-4)) == 0) {
            this.mMode = i;
        } else {
            defpackage.d.AnonymousClass0.m$2("Only MODE_IN and MODE_OUT flags are allowed");
            throw null;
        }
    }

    public final ObjectAnimator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        te1.a.f(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, te1.b, f2);
        objectAnimatorOfFloat.addListener(new a(view));
        addListener(new b(view));
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.l, androidx.transition.h
    public final void captureStartValues(g81 g81Var) {
        l.captureValues(g81Var);
        g81Var.a.put("android:fade:transitionAlpha", Float.valueOf(te1.a.e(g81Var.b)));
    }

    @Override // androidx.transition.l
    public final Animator onAppear(ViewGroup viewGroup, View view, g81 g81Var) {
        Float f;
        float fFloatValue = (g81Var == null || (f = (Float) g81Var.a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f.floatValue();
        return a(view, fFloatValue != 1.0f ? fFloatValue : 0.0f, 1.0f);
    }

    @Override // androidx.transition.l
    public final Animator onDisappear(ViewGroup viewGroup, View view, g81 g81Var) {
        Float f;
        te1.a.getClass();
        return a(view, (g81Var == null || (f = (Float) g81Var.a.get("android:fade:transitionAlpha")) == null) ? 1.0f : f.floatValue(), 0.0f);
    }
}
