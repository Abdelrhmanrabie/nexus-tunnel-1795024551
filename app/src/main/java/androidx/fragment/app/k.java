package androidx.fragment.app;

import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {
    public final /* synthetic */ l.c b;
    public final /* synthetic */ y.d c;

    public k(l.c cVar, y.d dVar) {
        this.b = cVar;
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a();
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(this.c);
        }
    }
}
