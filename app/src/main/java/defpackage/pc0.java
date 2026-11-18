package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pc0 extends AtomicReference implements jm0, wo {
    public final hh b;
    public final ke c = v3.f58c;
    public final ke d = v3.b;

    public pc0(hh hhVar) {
        this.b = hhVar;
    }

    @Override // defpackage.wo
    public final void a() {
        zo.b(this);
    }

    public final void b(Serializable serializable) {
        if (get() == zo.b) {
            return;
        }
        try {
            this.b.accept(serializable);
        } catch (Throwable th) {
            e.r(th);
            ((wo) get()).a();
            c(th);
        }
    }

    public final void c(Throwable th) {
        Object obj = get();
        zo zoVar = zo.b;
        if (obj == zoVar) {
            ui.a(th);
            return;
        }
        lazySet(zoVar);
        try {
            this.c.accept(th);
        } catch (Throwable th2) {
            e.r(th2);
            ui.a(new wf(Arrays.asList(th, th2)));
        }
    }
}
