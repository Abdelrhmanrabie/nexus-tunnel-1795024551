package androidx.fragment.app;

import defpackage.d7;
import defpackage.wv;
import defpackage.yv;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {
    public final /* synthetic */ y.d b;
    public final /* synthetic */ y.d c;
    public final /* synthetic */ boolean d;

    public h(y.d dVar, y.d dVar2, boolean z, d7 d7Var) {
        this.b = dVar;
        this.c = dVar2;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Fragment fragment = this.b.c;
        Fragment fragment2 = this.c.c;
        yv yvVar = wv.a;
        if (this.d) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }
}
