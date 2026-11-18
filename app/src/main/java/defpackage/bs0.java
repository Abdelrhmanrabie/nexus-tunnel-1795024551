package defpackage;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bs0 {
    public static volatile bs0 e;
    public int a;
    public boolean b;
    public Selector c;
    public ServerSocketChannel d;

    public static bs0 a() {
        synchronized (bs0.class) {
            try {
                if (e == null) {
                    bs0 bs0Var = new bs0();
                    bs0Var.a = 8080;
                    bs0Var.b = false;
                    e = bs0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e;
    }
}
