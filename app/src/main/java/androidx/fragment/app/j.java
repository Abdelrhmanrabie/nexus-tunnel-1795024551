package androidx.fragment.app;

import defpackage.wv;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {
    public final /* synthetic */ ArrayList b;

    public j(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wv.a(this.b, 4);
    }
}
