package defpackage;

import java.util.Collections;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ym {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class b extends ux implements nw {
        public static final b d = new b(1);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.b(wc1.class);
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            return Boolean.valueOf(((wc1) obj).B0());
        }
    }

    static {
        ij0.f(XMLRPC.TAG_VALUE);
    }

    public static final boolean a(wc1 wc1Var) {
        return ((Boolean) ak.b(Collections.singletonList(wc1Var), zm.a, new an(b.d, new boolean[1]))).booleanValue();
    }

    public static la b(la laVar, nw nwVar) {
        return (la) ak.b(Collections.singletonList(laVar), new zm(0), new an(new vu0(), nwVar));
    }

    public static final cv c(qk qkVar) {
        dv dvVarG = xm.g(qkVar);
        if (!dvVarG.e()) {
            dvVarG = null;
        }
        if (dvVarG == null) {
            return null;
        }
        return dvVarG.h();
    }

    public static final ai0 d(g4 g4Var) {
        od odVarB = g4Var.getType().L0().b();
        if (odVarB instanceof ai0) {
            return (ai0) odVarB;
        }
        return null;
    }

    public static final ub0 e(ok okVar) {
        return xm.d(okVar).k();
    }

    public static final dd f(od odVar) {
        dd ddVarF;
        if (odVar == null) {
            return null;
        }
        ok okVarB = odVar.b();
        if (okVarB instanceof wn0) {
            return new dd(((xn0) ((wn0) okVarB)).g, odVar.getName());
        }
        if (!(okVarB instanceof pd) || (ddVarF = f((od) okVarB)) == null) {
            return null;
        }
        return ddVarF.d(odVar.getName());
    }

    public static final cv g(ok okVar) {
        cv cvVarH = xm.h(okVar);
        return cvVarH != null ? cvVarH : xm.g(okVar.b()).b(okVar.getName()).h();
    }

    public static final void i(gi0 gi0Var) {
        if (gi0Var.t0(e4.a) == null) {
            return;
        }
        d.AnonymousClass0.m$1();
    }

    public static final la l(la laVar) {
        return laVar instanceof kq0 ? ((kq0) laVar).X() : laVar;
    }
}
