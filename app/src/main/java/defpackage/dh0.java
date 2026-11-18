package defpackage;

import androidx.lifecycle.e;
import androidx.lifecycle.h;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dh0 {
    public final Runnable a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final HashMap c = new HashMap();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final e a;
        public h b;

        public a(e eVar, h hVar) {
            this.a = eVar;
            this.b = hVar;
            eVar.a(hVar);
        }
    }

    public dh0(Runnable runnable) {
        this.a = runnable;
    }

    public final void c(kh0 kh0Var) {
        this.b.remove(kh0Var);
        a aVar = (a) this.c.remove(kh0Var);
        if (aVar != null) {
            aVar.a.c(aVar.b);
            aVar.b = null;
        }
        this.a.run();
    }
}
