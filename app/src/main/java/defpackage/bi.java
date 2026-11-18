package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class bi extends i8 {
    private final li _context;
    private transient ai intercepted;

    public bi(ai aiVar, li liVar) {
        super(aiVar);
        this._context = liVar;
    }

    @Override // defpackage.ai
    public li getContext() {
        return this._context;
    }

    public final ai intercepted() {
        ai aiVar = this.intercepted;
        if (aiVar != null) {
            return aiVar;
        }
        oi oiVar = (oi) getContext().a(e.b$2);
        ai qoVar = oiVar != null ? new qo(oiVar, this) : this;
        this.intercepted = qoVar;
        return qoVar;
    }

    @Override // defpackage.i8
    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ai aiVar = this.intercepted;
        if (aiVar != null && aiVar != this) {
            ((oi) getContext().a(e.b$2)).getClass();
            qo qoVar = (qo) aiVar;
            do {
                atomicReferenceFieldUpdater = qo.n;
            } while (atomicReferenceFieldUpdater.get(qoVar) == e.c$1);
            atomicReferenceFieldUpdater.get(qoVar);
        }
        this.intercepted = se.b;
    }
}
