package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.d0 b;
    public final /* synthetic */ ViewPropertyAnimator c;
    public final /* synthetic */ View d;
    public final /* synthetic */ k f;

    public f(View view, ViewPropertyAnimator viewPropertyAnimator, k kVar, RecyclerView.d0 d0Var) {
        this.f = kVar;
        this.b = d0Var;
        this.c = viewPropertyAnimator;
        this.d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.d.setAlpha(1.0f);
        k kVar = this.f;
        RecyclerView.d0 d0Var = this.b;
        kVar.c(d0Var);
        kVar.q.remove(d0Var);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f.getClass();
    }
}
