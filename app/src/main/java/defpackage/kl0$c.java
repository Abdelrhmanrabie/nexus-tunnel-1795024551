package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kl0$c extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ oo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kl0$c(oo ooVar, int i) {
        super(1);
        this.G0 = i;
        this.b = ooVar;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        if (this.G0 != 0) {
            return new wq((gi0) this.b.b, (cv) obj, 0);
        }
        kl0$a kl0_a = (kl0$a) obj;
        dd ddVar = kl0_a.a;
        if (ddVar.c) {
            throw new UnsupportedOperationException(e4.j("Unresolved local class: ", ddVar));
        }
        dd ddVarG = ddVar.g();
        List list = kl0_a.b;
        oo ooVar = this.b;
        gd gdVarA = ddVarG == null ? (gd) ((ff0.c) ooVar.c).invoke(ddVar.h()) : ooVar.a(ddVarG, he.G0(list));
        boolean z = !ddVar.b.e().d();
        ff0 ff0Var = (ff0) ooVar.a;
        ij0 ij0VarJ = ddVar.j();
        Integer num = (Integer) he.M0(list);
        return new zc(ff0Var, gdVarA, ij0VarJ, z, num != null ? num.intValue() : 0) { // from class: kl0$b
            public final boolean n;
            public final ArrayList o;
            public final jd p;

            {
                super(ff0Var, gdVarA, ij0VarJ, t11.a);
                this.n = z;
                y20 y20VarU = fz0.u(0, i);
                ArrayList arrayList = new ArrayList(ae.y0(y20VarU));
                Iterator it = y20VarU.iterator();
                while (true) {
                    x20 x20Var = (x20) it;
                    if (!x20Var.d) {
                        this.o = arrayList;
                        List listB = e4.b((pd) this);
                        int i = ym.$r8$clinit;
                        this.p = new jd(this, listB, Collections.singleton(xm.d(this).k().f()), ff0Var);
                        return;
                    }
                    int iNextInt = x20Var.nextInt();
                    arrayList.add(w91.O0(this, ad1.INVARIANT, ij0.f(e4.j("T", Integer.valueOf(iNextInt))), iNextInt, ff0Var));
                }
            }

            @Override // defpackage.ai0
            public final Collection A() {
                return uq.b;
            }

            @Override // defpackage.pd
            public final boolean B() {
                return this.n;
            }

            @Override // defpackage.ai0
            public final uc E() {
                return null;
            }

            @Override // defpackage.ai0
            public final boolean I0() {
                return false;
            }

            @Override // defpackage.ai0
            public final vg0 W(lc0$a lc0_a) {
                return vg0.b.b;
            }

            @Override // defpackage.qg0
            public final boolean Z() {
                return false;
            }

            @Override // defpackage.zc, defpackage.qg0
            public final boolean b0() {
                return false;
            }

            @Override // defpackage.ai0
            public final boolean c0() {
                return false;
            }

            @Override // defpackage.ai0
            public final boolean f0() {
                return false;
            }

            @Override // defpackage.w3
            public final s4 getAnnotations() {
                return e4.f47a;
            }

            @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
            public final cn.d getVisibility() {
                return cn.e;
            }

            @Override // defpackage.od
            public final a91 h() {
                return this.p;
            }

            @Override // defpackage.ai0
            public final Collection i() {
                return yq.b;
            }

            @Override // defpackage.ai0
            public final boolean k0() {
                return false;
            }

            @Override // defpackage.qg0
            public final boolean l0() {
                return false;
            }

            @Override // defpackage.ai0, defpackage.pd
            public final List o() {
                return this.o;
            }

            @Override // defpackage.ai0
            public final vg0 o0() {
                return vg0.b.b;
            }

            @Override // defpackage.ai0, defpackage.qg0
            public final zh0 p() {
                return zh0.b;
            }

            @Override // defpackage.ai0
            public final boolean r() {
                return false;
            }

            @Override // defpackage.ai0
            public final i20 t() {
                return null;
            }

            public final String toString() {
                return "class " + getName() + " (not found)";
            }

            @Override // defpackage.ai0
            public final int v() {
                return 1;
            }
        };
    }
}
