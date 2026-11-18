package defpackage;

import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kd0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ jd0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kd0(jd0 jd0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = jd0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kd0(jd0 jd0Var, xt0 xt0Var, y50 y50Var) {
        super(0);
        this.G0 = 0;
        this.b = jd0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        jd0 jd0Var = this.b;
        if (i == 0) {
            ((c60) jd0Var.b.a).h.getClass();
            return null;
        }
        if (i != 1) {
            if (i == 2) {
                return jd0Var.h(lm.o, null);
            }
            if (i == 3) {
                return jd0Var.k();
            }
            if (i == 4) {
                return jd0Var.i(lm.p, null);
            }
            ke keVar = lm.c;
            return jd0Var.o();
        }
        lm lmVar = lm.m;
        vg0.a.getClass();
        p0 p0Var = p0.b$13;
        dl0 dl0Var = dl0.f;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (lmVar.a(lm.l)) {
            for (ij0 ij0Var : jd0Var.h(lmVar, p0Var)) {
                Boolean bool = Boolean.TRUE;
                e.s0(linkedHashSet, jd0Var.e(ij0Var, dl0Var));
            }
        }
        boolean zA = lmVar.a(lm.i);
        List list = lmVar.a;
        if (zA && !list.contains(km.a.a)) {
            for (ij0 ij0Var2 : jd0Var.i(lmVar, p0Var)) {
                Boolean bool2 = Boolean.TRUE;
                linkedHashSet.addAll(jd0Var.a(ij0Var2, dl0Var));
            }
        }
        if (lmVar.a(lm.j) && !list.contains(km.a.a)) {
            for (ij0 ij0Var3 : jd0Var.o()) {
                Boolean bool3 = Boolean.TRUE;
                linkedHashSet.addAll(jd0Var.c(ij0Var3, dl0Var));
            }
        }
        return he.g1(linkedHashSet);
    }
}
