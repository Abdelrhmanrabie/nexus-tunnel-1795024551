package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gz0 extends AtomicReference implements wo {
    public final /* synthetic */ int G0 = 0;

    public /* synthetic */ gz0() {
    }

    public /* synthetic */ gz0(Object obj) {
        super(obj);
    }

    @Override // defpackage.wo
    public final void a() {
        Object andSet;
        if (this.G0 == 0) {
            zo.b(this);
        } else {
            if (get() == null || (andSet = getAndSet(null)) == null) {
                return;
            }
            ((Runnable) andSet).run();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        if (this.G0 != 1) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder("RunnableDisposable(disposed=");
        sb.append(get() == null);
        sb.append(", ");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }
}
