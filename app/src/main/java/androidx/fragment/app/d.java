package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ y.d f;
    public final /* synthetic */ l.a g;

    public d(ViewGroup viewGroup, View view, boolean z, y.d dVar, l.a aVar) {
        this.b = viewGroup;
        this.c = view;
        this.d = z;
        this.f = dVar;
        this.g = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.b;
        View view = this.c;
        viewGroup.endViewTransition(view);
        boolean z = this.d;
        y.d dVar = this.f;
        if (z) {
            dVar.a.a(view);
        }
        this.g.a();
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(dVar);
        }
    }
}
