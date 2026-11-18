package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.d0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;
    public final /* synthetic */ int f;
    public final /* synthetic */ ViewPropertyAnimator g;
    public final /* synthetic */ k i;

    public h(k kVar, RecyclerView.d0 d0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.i = kVar;
        this.b = d0Var;
        this.c = i;
        this.d = view;
        this.f = i2;
        this.g = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.c;
        View view = this.d;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.g.setListener(null);
        k kVar = this.i;
        RecyclerView.d0 d0Var = this.b;
        kVar.c(d0Var);
        kVar.p.remove(d0Var);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.i.getClass();
    }
}
