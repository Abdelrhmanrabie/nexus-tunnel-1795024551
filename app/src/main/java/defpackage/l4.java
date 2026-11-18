package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l4 {
    public final p60 a;
    public final ff0.j b;

    public l4(ff0 ff0Var, p60 p60Var) {
        this.a = p60Var;
        this.b = ff0Var.d(new n4(1, this, 0));
    }

    public static List a(qg qgVar) {
        j4 j4Var;
        gm gmVar = gm.b$2;
        if (qgVar instanceof h7) {
            Iterable iterable = (Iterable) ((h7) qgVar).a;
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                he.C0(a((qg) it.next()), arrayList);
            }
            return arrayList;
        }
        if (!(qgVar instanceof kr)) {
            return uq.b;
        }
        j4[] j4VarArrValues = j4.values();
        int length = j4VarArrValues.length;
        int i = 0;
        while (i < length) {
            j4Var = j4VarArrValues[i];
            i++;
            if (((Boolean) gmVar.invoke(qgVar, j4Var)).booleanValue()) {
                return e.Z(j4Var);
            }
        }
        j4Var = null;
        return e.Z(j4Var);
    }

    public final gv0 c(g4 g4Var) {
        p60 p60Var = this.a;
        p70 p70Var = p60Var.a;
        g4Var.e();
        ai0 ai0VarD = ym.d(g4Var);
        if (ai0VarD != null) {
            g4 g4VarC = ai0VarD.getAnnotations().c(k4.d);
            qg qgVar = g4VarC == null ? null : (qg) he.L0(g4VarC.h().values());
            kr krVar = qgVar instanceof kr ? (kr) qgVar : null;
            if (krVar != null) {
                gv0 gv0Var = p60Var.a.b;
                if (gv0Var != null) {
                    return gv0Var;
                }
                String strB = krVar.c.b();
                int iHashCode = strB.hashCode();
                if (iHashCode != -2137067054) {
                    if (iHashCode != -1838656823) {
                        if (iHashCode == 2656902 && strB.equals("WARN")) {
                            return gv0.d;
                        }
                    } else if (strB.equals("STRICT")) {
                        return gv0.f;
                    }
                } else if (strB.equals("IGNORE")) {
                    return gv0.c;
                }
            }
        }
        return null;
    }

    public final g4 d(g4 g4Var) {
        ai0 ai0VarD;
        if (this.a.a.d || (ai0VarD = ym.d(g4Var)) == null) {
            return null;
        }
        if (k4.h.contains(ym.g(ai0VarD)) || ai0VarD.getAnnotations().f(k4.b)) {
            return g4Var;
        }
        if (ai0VarD.v() != 5) {
            return null;
        }
        return (g4) this.b.invoke(ai0VarD);
    }
}
