package defpackage;

import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d80 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ a80 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d80(a80 a80Var, int i) {
        super(0);
        this.G0 = i;
        this.b = a80Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        a80 a80Var = this.b;
        if (i == 0) {
            return a80Var.a.f.f();
        }
        ub0 ub0Var = a80Var.a.f;
        ij0 ij0Var = q4.a;
        List listSingletonList = Collections.singletonList(new o9(ub0Var, m21.a.m, ye1.h(new jo0(q4.a, new h31("This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version")), new jo0(q4.b, new r4(new o9(ub0Var, m21.a.o, ye1.h(new jo0(q4.d, new h31(AppConfig.CUSTOM)), new jo0(q4.e, new h7(uq.b, new i(9, ub0Var))))))), new jo0(q4.c, new kr(dd.l(m21.a.n), ij0.f("WARNING"))))));
        return listSingletonList.isEmpty() ? e4.f47a : new t4(0, listSingletonList);
    }
}
