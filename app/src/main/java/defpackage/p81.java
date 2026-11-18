package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p81 extends rx implements gh {
    public static final ke M;
    public final ff0 J;
    public final co K;
    public uc L;

    static {
        pu0 pu0Var = ou0.a;
        pu0Var.f(new tq0(pu0Var.b(p81.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"));
        M = new ke(12);
    }

    public p81(ff0 ff0Var, co coVar, uc ucVar, p81 p81Var, s4 s4Var, la.a aVar, t11 t11Var) {
        super(aVar, coVar, p81Var, t11Var, s4Var, f21.e);
        this.J = ff0Var;
        this.K = coVar;
        qn qnVar = new qn(10, this, ucVar);
        ff0Var.getClass();
        new ff0.f(ff0Var, qnVar);
        this.L = ucVar;
    }

    @Override // defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        la.a aVar2 = la.a.b;
        return new p81(this.J, this.K, this.L, this, s4Var, aVar2, t11Var);
    }

    @Override // defpackage.rx, defpackage.b41
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public final p81 c(ha1 ha1Var) {
        ox oxVarC = super.c(ha1Var);
        if (oxVarC == null) {
            d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
            return null;
        }
        p81 p81Var = (p81) oxVarC;
        uc ucVarC = this.L.a().c(ha1.d(p81Var.j));
        if (ucVarC == null) {
            return null;
        }
        p81Var.L = ucVarC;
        return p81Var;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ja a() {
        return (p81) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final la a() {
        return (p81) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return (p81) super.a();
    }

    @Override // defpackage.rx, defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ox a() {
        return (p81) super.a();
    }

    @Override // defpackage.rk, defpackage.ok
    public final ok b() {
        return this.K;
    }

    @Override // defpackage.rk, defpackage.ok
    public final pd b() {
        return this.K;
    }

    @Override // defpackage.gh
    public final ai0 e0() {
        return this.L.e0();
    }

    @Override // defpackage.rx, defpackage.ja
    public final fc0 getReturnType() {
        return this.j;
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: i0 */
    public final qk a() {
        return (p81) super.a();
    }

    @Override // defpackage.rx, defpackage.la
    public final la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar) {
        la.a aVar = la.a.c;
        rx.a aVarO0 = O0(ha1.b);
        aVarO0.l(ai0Var);
        aVarO0.c = zh0Var;
        aVarO0.d = dVar;
        aVarO0.f = aVar;
        aVarO0.l = false;
        rx rxVarL0 = aVarO0.w.L0(aVarO0);
        if (rxVarL0 != null) {
            return (p81) rxVarL0;
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return null;
    }
}
