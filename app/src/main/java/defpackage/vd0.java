package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vd0 extends pk {
    public static final /* synthetic */ ja0[] n;
    public final ji0 d;
    public final cv f;
    public final ff0.h g;
    public final ff0.h i;
    public final l91 j;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ vd0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(vd0 vd0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = vd0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            int i = this.G0;
            if (i == 0) {
                vd0 vd0Var = this.b;
                ji0 ji0Var = vd0Var.d;
                ji0Var.i0();
                return Boolean.valueOf(e.N((xf) ji0Var.q.getValue(), vd0Var.f));
            }
            if (i == 1) {
                vd0 vd0Var2 = this.b;
                ji0 ji0Var2 = vd0Var2.d;
                ji0Var2.i0();
                xf xfVar = (xf) ji0Var2.q.getValue();
                cv cvVar = vd0Var2.f;
                ArrayList arrayList = new ArrayList();
                e.k(xfVar, cvVar, arrayList);
                return arrayList;
            }
            ja0[] ja0VarArr = vd0.n;
            ja0 ja0Var = ja0VarArr[1];
            vd0 vd0Var3 = this.b;
            if (((Boolean) vd0Var3.i.invoke()).booleanValue()) {
                return vg0.b.b;
            }
            ja0 ja0Var2 = ja0VarArr[0];
            List list = (List) vd0Var3.g.invoke();
            ArrayList arrayList2 = new ArrayList(ae.y0(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((wn0) it.next()).m());
            }
            ji0 ji0Var3 = vd0Var3.d;
            cv cvVar2 = vd0Var3.f;
            return uh.a(he.Y0(arrayList2, new y31(ji0Var3, cvVar2)), "package view scope for " + cvVar2 + " in " + ji0Var3.getName());
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        n = new ja0[]{pu0Var.f(new tq0(pu0Var.b(vd0.class), "fragments", "getFragments()Ljava/util/List;")), pu0Var.f(new tq0(pu0Var.b(vd0.class), "empty", "getEmpty()Z"))};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public vd0(ji0 ji0Var, cv cvVar, ff0 ff0Var) {
        ij0 ij0VarG;
        s4$a$a s4_a_a = e4.f47a;
        dv dvVar = cvVar.a;
        if (dvVar.a.isEmpty()) {
            ij0VarG = dv.e;
            if (ij0VarG == null) {
                dv.a(12);
                throw null;
            }
        } else {
            ij0VarG = dvVar.g();
        }
        super(s4_a_a, ij0VarG);
        this.d = ji0Var;
        this.f = cvVar;
        a aVar = new a(this, 1);
        ff0Var.getClass();
        this.g = new ff0.h(ff0Var, aVar);
        this.i = new ff0.h(ff0Var, new a(this, 0));
        this.j = new l91(ff0Var, new a(this, 2));
    }

    @Override // defpackage.ok
    public final ok b() {
        cv cvVar = this.f;
        if (cvVar.d()) {
            return null;
        }
        return this.d.U(cvVar.e());
    }

    public final boolean equals(Object obj) {
        vd0 vd0Var = obj instanceof vd0 ? (vd0) obj : null;
        if (vd0Var == null) {
            return false;
        }
        if (e4.a(this.f, vd0Var.f)) {
            return e4.a(this.d, vd0Var.d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.d.hashCode() * 31);
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        StringBuilder sb = (StringBuilder) obj;
        nm nmVar = (nm) bjVar.a;
        nmVar.getClass();
        nmVar.V(this.f, "package", sb);
        if (nmVar.c.h()) {
            sb.append(" in context of ");
            nmVar.R(this.d, sb, false);
        }
        return tb1.a;
    }
}
