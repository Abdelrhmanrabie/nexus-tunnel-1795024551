package defpackage;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hv0 implements ThreadFactory {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Thread {
        public final int b;

        public a(Runnable runnable) {
            super(runnable, "fonts-androidx");
            this.b = 10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.b);
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new a(runnable);
    }
}
