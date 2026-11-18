package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gb {
    public boolean a;
    public a b;
    public boolean c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        void onCancel();
    }

    public final void b(a aVar) {
        synchronized (this) {
            while (this.c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.b != aVar) {
                this.b = aVar;
                if (this.a) {
                    aVar.onCancel();
                }
            }
        }
    }
}
