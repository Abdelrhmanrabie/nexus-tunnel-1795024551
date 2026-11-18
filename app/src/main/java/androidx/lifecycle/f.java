package androidx.lifecycle;

import defpackage.ai;
import defpackage.bx;
import defpackage.e4;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.vi;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f extends t41 implements bx {
    public /* synthetic */ Object b;
    public final /* synthetic */ LifecycleCoroutineScopeImpl c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, ai aiVar) {
        super(aiVar);
        this.c = lifecycleCoroutineScopeImpl;
    }

    @Override // defpackage.i8
    public final ai create(Object obj, ai aiVar) {
        f fVar = new f(this.c, aiVar);
        fVar.b = obj;
        return fVar;
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        f fVar = (f) create((ti) obj, (ai) obj2);
        tb1 tb1Var = tb1.a;
        fVar.invokeSuspend(tb1Var);
        return tb1Var;
    }

    @Override // defpackage.i8
    public final Object invokeSuspend(Object obj) throws Throwable {
        vi viVar = vi.b;
        e4.b(obj);
        ti tiVar = (ti) this.b;
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.c;
        if (lifecycleCoroutineScopeImpl.b.b().compareTo(e.b.INITIALIZED) >= 0) {
            lifecycleCoroutineScopeImpl.b.a(lifecycleCoroutineScopeImpl);
        } else {
            defpackage.e.z0(tiVar.x(), null);
        }
        return tb1.a;
    }
}
