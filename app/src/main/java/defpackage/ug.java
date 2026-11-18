package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ug implements sy0 {
    public final AtomicReference a;

    public ug(sy0 sy0Var) {
        this.a = new AtomicReference(sy0Var);
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        sy0 sy0Var = (sy0) this.a.getAndSet(null);
        if (sy0Var != null) {
            return sy0Var.iterator();
        }
        d.AnonymousClass0.m("This sequence can be consumed only once.");
        return null;
    }
}
