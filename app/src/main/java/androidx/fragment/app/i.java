package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import defpackage.cw;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {
    public final /* synthetic */ cw b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Rect d;

    public i(cw cwVar, View view, Rect rect) {
        this.b = cwVar;
        this.c = view;
        this.d = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.getClass();
        cw.g(this.c, this.d);
    }
}
