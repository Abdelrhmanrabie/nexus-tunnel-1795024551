package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ro extends fy0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(ro.class, "_decision$volatile");
    public volatile /* synthetic */ int _decision$volatile;

    @Override // defpackage.fy0, defpackage.h70
    public final void B(Object obj) {
        d0(obj);
    }

    @Override // defpackage.fy0, defpackage.h70
    public final void d0(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = g;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1) {
                    d.AnonymousClass0.m("Already resumed");
                    return;
                } else {
                    e.o1(e.T(obj), e.U0(this.f));
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
