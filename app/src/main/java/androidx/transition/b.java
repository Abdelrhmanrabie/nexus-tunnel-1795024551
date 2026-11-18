package androidx.transition;

import android.view.View;
import defpackage.te1;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i {
    public final /* synthetic */ View b;

    public b(View view) {
        this.b = view;
    }

    @Override // androidx.transition.h.g
    public final void onTransitionEnd(h hVar) {
        te1.a.f(this.b, 1.0f);
        hVar.removeListener(this);
    }
}
