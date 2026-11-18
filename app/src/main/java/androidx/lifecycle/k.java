package androidx.lifecycle;

import android.os.Handler;
import defpackage.he0;
import defpackage.jf;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k implements he0 {
    public static final k o = new k();
    public int b;
    public int c;
    public Handler g;
    public boolean d = true;
    public boolean f = true;
    public final i i = new i(this);
    public final jf j = new jf(this, 3, 2);
    public final b n = new b();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b implements m.a {
        public b() {
        }
    }

    public final void a() {
        int i = this.c + 1;
        this.c = i;
        if (i == 1) {
            if (!this.d) {
                this.g.removeCallbacks(this.j);
            } else {
                this.i.f(e.a.ON_RESUME);
                this.d = false;
            }
        }
    }

    @Override // defpackage.he0
    public final e getLifecycle() {
        return this.i;
    }
}
