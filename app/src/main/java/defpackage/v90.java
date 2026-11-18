package defpackage;

import kotlin.jvm.internal.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v90 extends b90 implements kx, u90, lw, nw, mw, ow, pw, qw, rw, sw, tw, uw, vw, ww, bx, yw, zw, ax, cx, dx, ex, fx, gx, hx, ix {
    public static final /* synthetic */ ja0[] q;
    public final p90 g;
    public final String i;
    public final Object j;
    public final nu0$a n;
    public final nu0$b o;

    static {
        pu0 pu0Var = ou0.a;
        q = new ja0[]{pu0Var.f(new tq0(pu0Var.b(v90.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), pu0Var.f(new tq0(pu0Var.b(v90.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), pu0Var.f(new tq0(pu0Var.b(v90.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    }

    public v90(p90 p90Var, String str, String str2, ox oxVar, Object obj) {
        this.g = p90Var;
        this.i = str2;
        this.j = obj;
        this.n = new nu0$a(oxVar, new qn(14, this, str));
        this.o = new nu0$b(new ca0(19, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v90(p90 p90Var, ox oxVar) {
        this(p90Var, ((pk) oxVar).getName().b(), uw0.c(oxVar).a(), oxVar, a.C0035a.b);
    }

    public final boolean equals(Object obj) {
        v90 v90VarA = lc1.a(obj);
        return v90VarA != null && e4.a(this.g, v90VarA.g) && getName().equals(v90VarA.getName()) && e4.a(this.i, v90VarA.i) && e4.a(this.j, v90VarA.j);
    }

    @Override // defpackage.kx
    public final int getArity() {
        return i().a().size();
    }

    @Override // defpackage.a90
    public final String getName() {
        return ((pk) l()).getName().b();
    }

    public final int hashCode() {
        return this.i.hashCode() + ((getName().hashCode() + (this.g.hashCode() * 31)) * 31);
    }

    @Override // defpackage.b90
    public final ta i() {
        ja0 ja0Var = q[1];
        return (ta) this.o.invoke();
    }

    @Override // defpackage.lw
    public final Object invoke() {
        return call(new Object[0]);
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return call(obj);
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    @Override // defpackage.b90
    public final p90 j() {
        return this.g;
    }

    @Override // defpackage.b90
    public final boolean n() {
        return !e4.a(this.j, a.C0035a.b);
    }

    @Override // defpackage.b90
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final ox l() {
        ja0 ja0Var = q[0];
        return (ox) this.n.invoke();
    }

    public final String toString() {
        nm nmVar = ru0.a;
        return ru0.b(l());
    }
}
