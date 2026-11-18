package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class f70 extends h70 {
    public final boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f70() {
        super(true);
        boolean z = true;
        Q(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h70.c;
        nc ncVar = (nc) atomicReferenceFieldUpdater.get(this);
        oc ocVar = ncVar instanceof oc ? (oc) ncVar : null;
        if (ocVar != null) {
            do {
                h70 h70Var = ocVar.f;
                h70Var.getClass();
                if (!h70Var.K()) {
                    nc ncVar2 = (nc) atomicReferenceFieldUpdater.get(h70Var);
                    ocVar = ncVar2 instanceof oc ? (oc) ncVar2 : null;
                }
            } while (ocVar != null);
            z = false;
        } else {
            z = false;
        }
        this.d = z;
    }

    @Override // defpackage.h70
    public final boolean K() {
        return this.d;
    }

    @Override // defpackage.h70
    public final boolean L() {
        return true;
    }
}
