package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class td implements Closeable, ti {
    public final li b;

    public td(li liVar) {
        this.b = liVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e.z0(this.b, null);
    }

    @Override // defpackage.ti
    public final li x() {
        return this.b;
    }
}
