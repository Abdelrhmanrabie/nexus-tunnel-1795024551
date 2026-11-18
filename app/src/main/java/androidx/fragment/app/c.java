package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ y.d c;
    public final /* synthetic */ l d;

    public c(l lVar, ArrayList arrayList, y.d dVar) {
        this.d = lVar;
        this.b = arrayList;
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.b;
        y.d dVar = this.c;
        if (arrayList.contains(dVar)) {
            arrayList.remove(dVar);
            this.d.getClass();
            dVar.a.a(dVar.c.mView);
        }
    }
}
