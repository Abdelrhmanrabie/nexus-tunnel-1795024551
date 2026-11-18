package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.gb;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g implements gb.a {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ l.a c;
    public final /* synthetic */ y.d d;

    public g(View view, ViewGroup viewGroup, l.a aVar, y.d dVar) {
        this.a = view;
        this.b = viewGroup;
        this.c = aVar;
        this.d = dVar;
    }

    @Override // gb.a
    public final void onCancel() {
        View view = this.a;
        view.clearAnimation();
        this.b.endViewTransition(view);
        this.c.a();
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(this.d);
        }
    }
}
