package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ ArrayList d;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ArrayList g;

    public bw(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.b = i;
        this.c = arrayList;
        this.d = arrayList2;
        this.f = arrayList3;
        this.g = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i = 0; i < this.b; i++) {
            View view = (View) this.c.get(i);
            String str = (String) this.d.get(i);
            WeakHashMap weakHashMap = qd1.a;
            view.setTransitionName(str);
            ((View) this.f.get(i)).setTransitionName((String) this.g.get(i));
        }
    }
}
