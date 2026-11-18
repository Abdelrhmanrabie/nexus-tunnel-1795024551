package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qo extends n51 implements wi, ai {
    public static final /* synthetic */ AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(qo.class, Object.class, "_reusableCancellableContinuation$volatile");
    public volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public int d;
    public final oi f;
    public final bi g;
    public Object i;
    public final Object j;

    public qo(oi oiVar, bi biVar) {
        super(0L, t51.g);
        this.d = -1;
        this.f = oiVar;
        this.g = biVar;
        this.i = e.b;
        this.j = biVar.getContext().i(0, gm.b$4);
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            e.e(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        b2.a(this.g.getContext(), (Throwable) new yi("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // defpackage.wi
    public final wi getCallerFrame() {
        bi biVar = this.g;
        if (fb$1.m(biVar)) {
            return biVar;
        }
        return null;
    }

    @Override // defpackage.ai
    public final li getContext() {
        return this.g.getContext();
    }

    @Override // defpackage.ai
    public final void resumeWith(Object obj) {
        bi biVar = this.g;
        li context = biVar.getContext();
        Throwable thA = bw0.a(obj);
        Object teVar = thA == null ? obj : new te(thA);
        oi oiVar = this.f;
        if (oiVar.A()) {
            this.i = teVar;
            this.d = 0;
            oiVar.x(context, this);
            return;
        }
        ThreadLocal threadLocal = p61.a;
        ur e9Var = (ur) threadLocal.get();
        if (e9Var == null) {
            e9Var = new e9(Thread.currentThread());
            threadLocal.set(e9Var);
        }
        if (e9Var.d >= 4294967296L) {
            this.i = teVar;
            this.d = 0;
            z6 z6Var = e9Var.g;
            if (z6Var == null) {
                z6Var = new z6();
                e9Var.g = z6Var;
            }
            z6Var.addLast(this);
            return;
        }
        e9Var.C(true);
        try {
            li context2 = biVar.getContext();
            Object objB = b2.b(context2, this.j);
            try {
                biVar.resumeWith(obj);
                b2.a(context2, objB);
                while (e9Var.D()) {
                }
            } catch (Throwable th) {
                b2.a(context2, objB);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                f(th2, null);
            } finally {
                e9Var.B();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Object aVar = tb1.a;
        p51 p51Var = this.c;
        try {
            bi biVar = this.g;
            Object obj = this.j;
            li context = biVar.getContext();
            Object objB = b2.b(context, obj);
            qb1 qb1VarB = objB != b2.a ? ak.b(biVar, context, objB) : null;
            try {
                li context2 = biVar.getContext();
                Object aVar2 = this.i;
                this.i = e.b;
                te teVar = aVar2 instanceof te ? (te) aVar2 : null;
                Throwable th = teVar != null ? teVar.a : null;
                h70 h70Var = (th == null && ((i = this.d) == 1 || i == 2)) ? (h70) context2.a(e.b$1) : null;
                if (h70Var != null && !h70Var.isActive()) {
                    CancellationException cancellationExceptionE = h70Var.e();
                    if (aVar2 instanceof ue) {
                        throw null;
                    }
                    aVar2 = new bw0.a(cancellationExceptionE);
                } else if (th != null) {
                    aVar2 = new bw0.a(th);
                }
                biVar.resumeWith(aVar2);
                if (qb1VarB == null || qb1VarB.f0()) {
                    b2.a(context, objB);
                }
                try {
                    p51Var.getClass();
                } catch (Throwable th2) {
                    aVar = new bw0.a(th2);
                }
                f(null, bw0.a(aVar));
            } catch (Throwable th3) {
                if (qb1VarB == null || qb1VarB.f0()) {
                    b2.a(context, objB);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                p51Var.getClass();
            } catch (Throwable th5) {
                aVar = new bw0.a(th5);
            }
            f(th4, bw0.a(aVar));
        }
    }

    public final String toString() {
        Object aVar;
        StringBuilder sb = new StringBuilder("DispatchedContinuation[");
        sb.append(this.f);
        sb.append(", ");
        bi biVar = this.g;
        try {
            aVar = biVar + '@' + e.D(biVar);
        } catch (Throwable th) {
            aVar = new bw0.a(th);
        }
        if (bw0.a(aVar) != null) {
            aVar = biVar.getClass().getName() + '@' + e.D(biVar);
        }
        return fb$1.m(sb, (String) aVar, ']');
    }
}
