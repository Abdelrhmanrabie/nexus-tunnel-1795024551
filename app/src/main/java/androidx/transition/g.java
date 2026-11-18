package androidx.transition;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h.g {
    public final /* synthetic */ androidx.fragment.app.k b;

    public g(androidx.fragment.app.k kVar) {
        this.b = kVar;
    }

    @Override // androidx.transition.h.g
    public final void onTransitionCancel() {
    }

    @Override // androidx.transition.h.g
    public final void onTransitionEnd(h hVar) {
        this.b.run();
    }

    @Override // androidx.transition.h.g
    public final void onTransitionPause() {
    }

    @Override // androidx.transition.h.g
    public final void onTransitionResume() {
    }

    @Override // androidx.transition.h.g
    public final void onTransitionStart(h hVar) {
    }
}
