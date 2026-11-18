package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class wc1 extends yc1 implements lo0 {
    public final int i;
    public final boolean j;
    public final boolean n;
    public final boolean o;
    public final fc0 p;
    public final wc1 q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends wc1 {
        public final v41 r;

        public a(ja jaVar, wc1 wc1Var, int i, s4 s4Var, ij0 ij0Var, fc0 fc0Var, boolean z, boolean z2, boolean z3, fc0 fc0Var2, t11 t11Var, lw lwVar) {
            super(jaVar, wc1Var, i, s4Var, ij0Var, fc0Var, z, z2, z3, fc0Var2, t11Var);
            this.r = new v41(lwVar);
        }

        @Override // defpackage.wc1
        public final wc1 I(tx txVar, ij0 ij0Var, int i) {
            return new a(txVar, null, i, getAnnotations(), ij0Var, getType(), B0(), this.n, this.o, this.p, t11.a, new ca0(20, this));
        }
    }

    public wc1(ja jaVar, wc1 wc1Var, int i, s4 s4Var, ij0 ij0Var, fc0 fc0Var, boolean z, boolean z2, boolean z3, fc0 fc0Var2, t11 t11Var) {
        super(jaVar, s4Var, ij0Var, fc0Var, t11Var);
        this.i = i;
        this.j = z;
        this.n = z2;
        this.o = z3;
        this.p = fc0Var2;
        this.q = wc1Var == null ? this : wc1Var;
    }

    public final boolean B0() {
        return this.j && ((la) ((ja) super.b())).getKind() != la.a.c;
    }

    public wc1 I(tx txVar, ij0 ij0Var, int i) {
        return new wc1(txVar, null, i, getAnnotations(), ij0Var, getType(), B0(), this.n, this.o, this.p, t11.a);
    }

    @Override // defpackage.yc1
    public final boolean P() {
        return false;
    }

    @Override // defpackage.rk
    public final wc1 a() {
        wc1 wc1Var = this.q;
        return wc1Var == this ? this : wc1Var.a();
    }

    @Override // defpackage.rk, defpackage.ok
    public final ja b() {
        return (ja) super.b();
    }

    @Override // defpackage.rk, defpackage.ok
    public final ok b() {
        return (ja) super.b();
    }

    @Override // defpackage.b41
    public final qk c(ha1 ha1Var) {
        if (ha1Var.a.e()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.ja
    public final Collection d() {
        Collection collectionD = ((ja) super.b()).d();
        ArrayList arrayList = new ArrayList(ae.y0(collectionD));
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            arrayList.add((wc1) ((ja) it.next()).f().get(this.i));
        }
        return arrayList;
    }

    @Override // defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        return cn.f;
    }

    @Override // defpackage.yc1
    public final /* bridge */ /* synthetic */ qg q0() {
        return null;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        ((nm) bjVar.a).g0(this, true, (StringBuilder) obj, true);
        return tb1.a;
    }
}
