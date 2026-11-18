package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class og {
    public ng a;
    public final Context b;
    public ConnectivityManager c = null;

    public og(Context context) {
        this.b = context;
    }

    public final ConnectivityManager a() {
        if (this.c == null) {
            this.c = (ConnectivityManager) this.b.getSystemService("connectivity");
        }
        return this.c;
    }
}
