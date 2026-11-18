package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kc0$a extends ak {
    public static final kc0$a a = new kc0$a(16, false);

    public static u01 c(u01 u01Var) {
        a91 a91VarL0 = u01Var.L0();
        boolean z = false;
        j30 j30Var = null;
        if (a91VarL0 instanceof nb) {
            nb nbVar = (nb) a91VarL0;
            ca1 ca1Var = nbVar.a;
            ca1 ca1Var2 = ca1Var.c() == ad1.IN_VARIANCE ? ca1Var : null;
            cc1 cc1VarO0 = ca1Var2 == null ? null : ca1Var2.getType().O0();
            if (nbVar.b == null) {
                Collection collectionD = nbVar.d();
                ArrayList arrayList = new ArrayList(ae.y0(collectionD));
                Iterator it = collectionD.iterator();
                while (it.hasNext()) {
                    arrayList.add(((fc0) it.next()).O0());
                }
                nbVar.b = new vk0(ca1Var, new uk0(arrayList, 0), (v91) null, 8);
            }
            return new tk0(ib.b, nbVar.b, cc1VarO0, u01Var.getAnnotations(), u01Var.M0(), 32);
        }
        if (!(a91VarL0 instanceof j30) || !u01Var.M0()) {
            return u01Var;
        }
        j30 j30Var2 = (j30) a91VarL0;
        LinkedHashSet linkedHashSet = j30Var2.b;
        ArrayList arrayList2 = new ArrayList(ae.y0(linkedHashSet));
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            arrayList2.add(ma1.j((fc0) it2.next(), true));
            z = true;
        }
        if (z) {
            fc0 fc0Var = j30Var2.a;
            cc1 cc1VarJ = fc0Var != null ? ma1.j(fc0Var, true) : null;
            arrayList2.isEmpty();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList2);
            linkedHashSet2.hashCode();
            j30Var = new j30(linkedHashSet2, cc1VarJ);
        }
        if (j30Var != null) {
            j30Var2 = j30Var;
        }
        return j30Var2.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [cc1] */
    public final cc1 b(jc0 jc0Var) {
        ?? C;
        if (!(jc0Var instanceof fc0)) {
            d.AnonymousClass0.m$2("Failed requirement.");
            return null;
        }
        jc0 jc0VarO0 = ((fc0) jc0Var).O0();
        if (jc0VarO0 instanceof u01) {
            C = c((u01) jc0VarO0);
        } else {
            if (!(jc0VarO0 instanceof zt)) {
                d.AnonymousClass0.m();
                return null;
            }
            zt ztVar = (zt) jc0VarO0;
            u01 u01Var = ztVar.c;
            u01 u01VarC = c(u01Var);
            u01 u01Var2 = ztVar.d;
            u01 u01VarC2 = c(u01Var2);
            C = (u01VarC == u01Var && u01VarC2 == u01Var2) ? jc0VarO0 : e4.c(u01VarC, u01VarC2);
        }
        n4 n4Var = new n4(1, this, 2);
        fc0 fc0VarI0 = jc0VarO0 instanceof ra1 ? ((ra1) jc0VarO0).i0() : null;
        return e.v1(C, fc0VarI0 != null ? (fc0) n4Var.invoke(fc0VarI0) : null);
    }
}
