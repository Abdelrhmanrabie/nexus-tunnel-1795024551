package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m50 implements qs {
    @Override // defpackage.qs
    public final qs.a a() {
        return qs.a.b;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:50:0x00aa  */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0032, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qs
    public final qs.b b(ja jaVar, ja jaVar2, ai0 ai0Var) {
        boolean z;
        la laVar;
        la laVarB;
        ox oxVar;
        if ((jaVar instanceof la) && (jaVar2 instanceof ox) && !ub0.A(jaVar2)) {
            int i = aa.$r8$clinit;
            ox oxVar2 = (ox) jaVar2;
            pk pkVar = (pk) oxVar2;
            ij0 name = pkVar.getName();
            Set set = c21.f;
            if (set.contains(name)) {
                laVar = (la) jaVar;
                laVarB = b2.b(laVar);
                if (laVarB == null) {
                    if (set.contains(((pk) laVar).getName())) {
                        laVarB = ym.b(laVar, ba.b$3);
                    } else {
                        laVarB = null;
                    }
                }
                boolean zD0 = oxVar2.D0();
                boolean z2 = jaVar instanceof ox;
                if (z2) {
                }
                if (oxVar == null) {
                    z = false;
                } else {
                    z = false;
                }
                z = true;
            } else {
                if (c21.k.contains(pkVar.getName())) {
                    laVar = (la) jaVar;
                    laVarB = b2.b(laVar);
                    if (laVarB == null) {
                        if (set.contains(((pk) laVar).getName())) {
                            laVarB = null;
                        } else {
                            laVarB = ym.b(laVar, ba.b$3);
                        }
                    }
                    boolean zD1 = oxVar2.D0();
                    boolean z3 = jaVar instanceof ox;
                    oxVar = z3 ? (ox) jaVar : null;
                    if (((oxVar == null && zD1 == oxVar.D0()) || (laVarB != null && oxVar2.D0())) && (!(ai0Var instanceof xc0) || oxVar2.v0() != null || laVarB == null || b2.d(ai0Var, laVarB) || ((laVarB instanceof ox) && z3 && aa.a((ox) laVarB) != null && e.o(oxVar2, 2).equals(e.o(((ox) jaVar).a(), 2))))) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return (z || b2.a(jaVar, jaVar2)) ? qs.b.c : qs.b.d;
    }
}
