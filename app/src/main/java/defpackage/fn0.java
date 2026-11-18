package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fn0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final ViewGroup b;
    public ViewTreeObserver c;
    public final Runnable d;

    public fn0(ViewGroup viewGroup, Runnable runnable) {
        this.b = viewGroup;
        this.c = viewGroup.getViewTreeObserver();
        this.d = runnable;
    }

    public static void a(ViewGroup viewGroup, Runnable runnable) {
        if (viewGroup == null) {
            d.AnonymousClass0.m$1("view == null");
            return;
        }
        fn0 fn0Var = new fn0(viewGroup, runnable);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(fn0Var);
        viewGroup.addOnAttachStateChangeListener(fn0Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.c.isAlive();
        ViewGroup viewGroup = this.b;
        (zIsAlive ? this.c : viewGroup.getViewTreeObserver()).removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        this.d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.c.isAlive();
        ViewGroup viewGroup = this.b;
        (zIsAlive ? this.c : viewGroup.getViewTreeObserver()).removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
    }
}
