package defpackage;

import kotlin.jvm.internal.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tq0 extends uq0 implements ma0 {
    public tq0(h90 h90Var, String str, String str2) {
        super(!fb$1.m(h90Var) ? 1 : 0, ((sc) h90Var).d(), a.C0035a.b, str, str2);
    }

    @Override // kotlin.jvm.internal.a
    public final a90 computeReflected() {
        return ou0.a.f(this);
    }

    @Override // defpackage.ma0
    public final na0.a getGetter() {
        return ((ma0) getReflected()).getGetter();
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return getGetter().call(obj);
    }
}
