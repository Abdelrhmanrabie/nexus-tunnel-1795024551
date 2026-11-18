package defpackage;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qu implements Callable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ pu d;
    public final /* synthetic */ int f;

    public /* synthetic */ qu(String str, Context context, pu puVar, int i, int i2) {
        this.G0 = i2;
        this.b = str;
        this.c = context;
        this.d = puVar;
        this.f = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        if (this.G0 != 0) {
            try {
                return uu.a(this.b, this.c, this.d, this.f);
            } catch (Throwable unused) {
                return new uu.a(-3);
            }
        }
        return uu.a(this.b, this.c, this.d, this.f);
    }
}
