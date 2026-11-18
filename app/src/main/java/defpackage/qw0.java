package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qw0 {
    public final yf1 a;
    public final ArrayList b = new ArrayList();

    public qw0(yf1 yf1Var) {
        this.a = null;
        this.a = yf1Var;
    }

    public static long a(dm dmVar, long j) {
        yf1 yf1Var = dmVar.d;
        if (yf1Var instanceof e10) {
            return j;
        }
        ArrayList arrayList = dmVar.k;
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            zl zlVar = (zl) arrayList.get(i);
            if (zlVar instanceof dm) {
                dm dmVar2 = (dm) zlVar;
                if (dmVar2.d != yf1Var) {
                    jMin = Math.min(jMin, a(dmVar2, ((long) dmVar2.f) + j));
                }
            }
        }
        if (dmVar != yf1Var.i) {
            return jMin;
        }
        long j2 = yf1Var.j();
        dm dmVar3 = yf1Var.h;
        long j3 = j - j2;
        return Math.min(Math.min(jMin, a(dmVar3, j3)), j3 - ((long) dmVar3.f));
    }

    public static long b(dm dmVar, long j) {
        yf1 yf1Var = dmVar.d;
        if (yf1Var instanceof e10) {
            return j;
        }
        ArrayList arrayList = dmVar.k;
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            zl zlVar = (zl) arrayList.get(i);
            if (zlVar instanceof dm) {
                dm dmVar2 = (dm) zlVar;
                if (dmVar2.d != yf1Var) {
                    jMax = Math.max(jMax, b(dmVar2, ((long) dmVar2.f) + j));
                }
            }
        }
        if (dmVar != yf1Var.h) {
            return jMax;
        }
        long j2 = yf1Var.j();
        dm dmVar3 = yf1Var.i;
        long j3 = j + j2;
        return Math.max(Math.max(jMax, b(dmVar3, j3)), j3 - ((long) dmVar3.f));
    }
}
