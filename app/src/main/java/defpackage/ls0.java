package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ls0 extends zt {
    public ls0(u01 u01Var, u01 u01Var2, int i) {
        super(u01Var, u01Var2);
        gc0.a.e(u01Var, u01Var2);
    }

    public static final ArrayList U0(nm nmVar, u01 u01Var) {
        List<ca1> listK0 = u01Var.K0();
        ArrayList arrayList = new ArrayList(ae.y0(listK0));
        for (ca1 ca1Var : listK0) {
            StringBuilder sb = new StringBuilder();
            he.P0(Collections.singletonList(ca1Var), sb, null, null, new om(nmVar, 0), 60);
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public static final String V0(String str, String str2) {
        if (!q31.d0(str, '<')) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int iJ0 = q31.j0(str, '<', 0, 6);
        sb.append(iJ0 == -1 ? str : str.substring(0, iJ0));
        sb.append('<');
        sb.append(str2);
        sb.append('>');
        sb.append(q31.y0(str, '>'));
        return sb.toString();
    }

    @Override // defpackage.fc0
    /* JADX INFO: renamed from: N0 */
    public final fc0 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new ls0(this.c, this.d);
    }

    @Override // defpackage.cc1
    public final cc1 P0(boolean z) {
        return new ls0(this.c.P0(z), this.d.P0(z), 0);
    }

    @Override // defpackage.cc1
    public final cc1 Q0(lc0$a lc0_a) {
        lc0_a.getClass();
        return new ls0(this.c, this.d);
    }

    @Override // defpackage.cc1
    public final cc1 R0(t4 t4Var) {
        return new ls0(this.c.R0(t4Var), this.d.R0(t4Var), 0);
    }

    @Override // defpackage.zt
    public final u01 S0() {
        return this.c;
    }

    @Override // defpackage.zt
    public final String T0(nm nmVar, nm nmVar2) {
        u01 u01Var = this.c;
        String strS = nmVar.s(u01Var);
        u01 u01Var2 = this.d;
        String strS2 = nmVar.s(u01Var2);
        if (nmVar2.c.h()) {
            return "raw (" + strS + ".." + strS2 + ')';
        }
        if (u01Var2.K0().isEmpty()) {
            return nmVar.p(strS, strS2, L0().k());
        }
        ArrayList arrayListU0 = U0(nmVar, u01Var);
        ArrayList arrayListU1 = U0(nmVar, u01Var2);
        String strR0 = he.R0(arrayListU0, ", ", null, null, ld0.b$6, 30);
        ArrayList arrayListK1 = he.k1(arrayListU0, arrayListU1);
        if (!arrayListK1.isEmpty()) {
            Iterator it = arrayListK1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    strS2 = V0(strS2, strR0);
                    break;
                }
                jo0 jo0Var = (jo0) it.next();
                String str = (String) jo0Var.b;
                String str2 = (String) jo0Var.c;
                if (!e4.a(str, q31.p0("out ", str2)) && !e4.a(str2, "*")) {
                    break;
                }
            }
        } else {
            strS2 = V0(strS2, strR0);
            break;
        }
        String strV0 = V0(strS, strR0);
        return e4.a(strV0, strS2) ? strV0 : nmVar.p(strV0, strS2, L0().k());
    }

    @Override // defpackage.zt, defpackage.fc0
    public final vg0 m() {
        od odVarB = L0().b();
        ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
        if (ai0Var != null) {
            return ai0Var.J(new js0(null));
        }
        throw new IllegalStateException(e4.j("Incorrect classifier: ", L0().b()).toString());
    }
}
