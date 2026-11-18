package androidx.lifecycle;

import android.os.Handler;
import defpackage.he0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a implements Runnable {
        public final i b;
        public final e.a c;
        public boolean d;

        public a(i iVar, e.a aVar) {
            this.b = iVar;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.d) {
                return;
            }
            this.b.f(this.c);
            this.d = true;
        }
    }

    public q(he0 he0Var) {
        new i(he0Var);
        new Handler();
    }
}
