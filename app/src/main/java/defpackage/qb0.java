package defpackage;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qb0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ub0 b;

    public /* synthetic */ qb0(ub0 ub0Var, int i) {
        this.G0 = i;
        this.b = ub0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        ub0 ub0Var = this.b;
        if (i == 0) {
            ji0 ji0Var = ub0Var.a;
            ji0Var.getClass();
            vd0 vd0VarU = ji0Var.U(m21.i);
            ji0 ji0Var2 = ub0Var.a;
            ji0Var2.getClass();
            vd0 vd0VarU2 = ji0Var2.U(m21.k);
            ji0 ji0Var3 = ub0Var.a;
            ji0Var3.getClass();
            vd0 vd0VarU3 = ji0Var3.U(m21.l);
            ji0 ji0Var4 = ub0Var.a;
            ji0Var4.getClass();
            return Arrays.asList(vd0VarU, vd0VarU2, vd0VarU3, ji0Var4.U(m21.j));
        }
        EnumMap enumMap = new EnumMap(wp0.class);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (wp0 wp0Var : wp0.values()) {
            u01 u01VarN = ub0Var.k(wp0Var.b.b()).n();
            u01 u01VarN2 = ub0Var.k(wp0Var.c.b()).n();
            enumMap.put(wp0Var, u01VarN2);
            map.put(u01VarN, u01VarN2);
            map2.put(u01VarN2, u01VarN);
        }
        return new ub0.a(enumMap, map2);
    }
}
