package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tx extends q01 {
    public tx(ok okVar, tx txVar, la.a aVar, boolean z) {
        super(okVar, txVar, e4.f47a, mn0.g, aVar, t11.a);
        this.r = true;
        this.A = z;
        this.B = false;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean D() {
        return false;
    }

    @Override // defpackage.q01, defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        return new tx(okVar, (tx) oxVar, aVar, this.A);
    }

    @Override // defpackage.rx
    public final rx L0(rx.a aVar) {
        boolean z;
        ij0 ij0Var;
        tx txVar = (tx) super.L0(aVar);
        if (txVar == null) {
            return null;
        }
        List listF = txVar.f();
        if (listF.isEmpty()) {
            return txVar;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            if (e.z(((wc1) it.next()).getType()) != null) {
                List listF2 = txVar.f();
                ArrayList arrayList = new ArrayList(ae.y0(listF2));
                Iterator it2 = listF2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(e.z(((wc1) it2.next()).getType()));
                }
                int size = txVar.f().size() - arrayList.size();
                List<wc1> listF3 = txVar.f();
                ArrayList arrayList2 = new ArrayList(ae.y0(listF3));
                for (wc1 wc1Var : listF3) {
                    ij0 name = wc1Var.getName();
                    int i = wc1Var.i;
                    int i2 = i - size;
                    if (i2 >= 0 && (ij0Var = (ij0) arrayList.get(i2)) != null) {
                        name = ij0Var;
                    }
                    arrayList2.add(wc1Var.I(txVar, name, i));
                }
                rx.a aVarO0 = txVar.O0(ha1.b);
                if (arrayList.isEmpty()) {
                    z = false;
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        if (((ij0) it3.next()) == null) {
                            z = true;
                        }
                    }
                    z = false;
                }
                aVarO0.u = Boolean.valueOf(z);
                aVarO0.g = arrayList2;
                aVarO0.e = txVar.V0();
                return super.L0(aVarO0);
            }
        }
        return txVar;
    }

    @Override // defpackage.rx, defpackage.qg0
    public final boolean b0() {
        return false;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean r() {
        return false;
    }
}
