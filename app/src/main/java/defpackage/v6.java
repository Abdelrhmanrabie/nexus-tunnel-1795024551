package defpackage;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v6 extends v3 {
    public static volatile v6 b;
    public final jl a;

    public v6() {
        jl jlVar = new jl();
        Executors.newFixedThreadPool(4, new cg());
        this.a = jlVar;
    }

    public static v6 g() {
        if (b != null) {
            return b;
        }
        synchronized (v6.class) {
            try {
                if (b == null) {
                    b = new v6();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }
}
