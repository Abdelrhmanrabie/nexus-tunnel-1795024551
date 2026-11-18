package defpackage;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tm0 implements OnBackAnimationCallback {
    public final /* synthetic */ nm0 a;
    public final /* synthetic */ nm0 b;
    public final /* synthetic */ pm0 c;
    public final /* synthetic */ pm0 d;

    public tm0(nm0 nm0Var, nm0 nm0Var2, pm0 pm0Var, pm0 pm0Var2) {
        this.a = nm0Var;
        this.b = nm0Var2;
        this.c = pm0Var;
        this.d = pm0Var2;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        this.d.invoke();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.c.invoke();
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        this.b.invoke(new d8(backEvent));
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        this.a.invoke(new d8(backEvent));
    }
}
