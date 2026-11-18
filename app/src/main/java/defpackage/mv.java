package defpackage;

import android.os.Handler;
import androidx.fragment.app.n;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class mv extends kv {
    public final n b;
    public final n c;
    public final Handler d;
    public final qv f;

    public mv(n nVar) {
        Handler handler = new Handler();
        this.f = new qv();
        this.b = nVar;
        if (nVar == null) {
            d.AnonymousClass0.m$1("context == null");
            throw null;
        }
        this.c = nVar;
        this.d = handler;
    }
}
