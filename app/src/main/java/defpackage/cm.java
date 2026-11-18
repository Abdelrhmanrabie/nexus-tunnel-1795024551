package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cm {
    public final dh a;
    public final dh d;
    public ConstraintLayout.b f;
    public final n8$a g;
    public final ArrayList h;
    public boolean b = true;
    public boolean c = true;
    public final ArrayList e = new ArrayList();

    public cm(dh dhVar) {
        new ArrayList();
        this.f = null;
        this.g = new n8$a();
        this.h = new ArrayList();
        this.a = dhVar;
        this.d = dhVar;
    }

    public final void a(dm dmVar, int i, ArrayList arrayList, qw0 qw0Var) {
        yf1 yf1Var = dmVar.d;
        if (yf1Var.c == null) {
            dh dhVar = this.a;
            if (yf1Var == dhVar.d || yf1Var == dhVar.e) {
                return;
            }
            if (qw0Var == null) {
                qw0Var = new qw0(yf1Var);
                arrayList.add(qw0Var);
            }
            yf1Var.c = qw0Var;
            qw0Var.b.add(yf1Var);
            dm dmVar2 = yf1Var.h;
            for (zl zlVar : dmVar2.k) {
                if (zlVar instanceof dm) {
                    a((dm) zlVar, i, arrayList, qw0Var);
                }
            }
            dm dmVar3 = yf1Var.i;
            for (zl zlVar2 : dmVar3.k) {
                if (zlVar2 instanceof dm) {
                    a((dm) zlVar2, i, arrayList, qw0Var);
                }
            }
            if (i == 1 && (yf1Var instanceof kd1)) {
                for (zl zlVar3 : ((kd1) yf1Var).k.k) {
                    if (zlVar3 instanceof dm) {
                        a((dm) zlVar3, i, arrayList, qw0Var);
                    }
                }
            }
            Iterator it = dmVar2.l.iterator();
            while (it.hasNext()) {
                a((dm) it.next(), i, arrayList, qw0Var);
            }
            Iterator it2 = dmVar3.l.iterator();
            while (it2.hasNext()) {
                a((dm) it2.next(), i, arrayList, qw0Var);
            }
            if (i == 1 && (yf1Var instanceof kd1)) {
                Iterator it3 = ((kd1) yf1Var).k.l.iterator();
                while (it3.hasNext()) {
                    a((dm) it3.next(), i, arrayList, qw0Var);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0185 A[DONT_INVERT, PHI: r15
      0x0185: PHI (r15v3 int) = (r15v2 int), (r15v4 int), (r15v5 int), (r15v2 int) binds: [B:82:0x011a, B:105:0x017a, B:100:0x015b, B:84:0x011e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:156:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    public final void b(dh dhVar) {
        int iN;
        int i;
        int iN2;
        int i2;
        int i3;
        int i4;
        int i5;
        int iN3;
        int i6;
        ko koVar;
        int i7;
        int i8;
        int iN4;
        for (ch chVar : dhVar.s0) {
            int[] iArr = chVar.V;
            int i9 = iArr[0];
            int i10 = iArr[1];
            if (chVar.j0 != 8) {
                float f = chVar.x;
                int i11 = 2;
                if (f < 1.0f && i9 == 3) {
                    chVar.s = 2;
                }
                float f2 = chVar.A;
                if (f2 < 1.0f && i10 == 3) {
                    chVar.t = 2;
                }
                if (chVar.Z > 0.0f) {
                    if (i9 == 3 && (i10 == 2 || i10 == 1)) {
                        chVar.s = 3;
                    } else if (i10 == 3 && (i9 == 2 || i9 == 1)) {
                        chVar.t = 3;
                    } else if (i9 == 3 && i10 == 3) {
                        if (chVar.s == 0) {
                            chVar.s = 3;
                        }
                        if (chVar.t == 0) {
                            chVar.t = 3;
                        }
                    }
                }
                vg vgVar = chVar.M;
                vg vgVar2 = chVar.K;
                if (i9 == 3 && chVar.s == 1 && (vgVar2.f == null || vgVar.f == null)) {
                    i9 = 2;
                }
                vg vgVar3 = chVar.N;
                vg vgVar4 = chVar.L;
                int i12 = 0;
                if (i10 == 3 && chVar.t == 1 && (vgVar4.f == null || vgVar3.f == null)) {
                    i10 = 2;
                }
                g10 g10Var = chVar.d;
                g10Var.d = i9;
                int i13 = chVar.s;
                g10Var.a = i13;
                kd1 kd1Var = chVar.e;
                kd1Var.d = i10;
                int i14 = chVar.t;
                kd1Var.a = i14;
                if ((i9 == 4 || i9 == 1 || i9 == 2) && (i10 == 4 || i10 == 1 || i10 == 2)) {
                    int iN5 = chVar.n();
                    if (i9 == 4) {
                        iN = (dhVar.n() - vgVar2.g) - vgVar.g;
                        i11 = 1;
                    } else {
                        i11 = i9;
                        iN = iN5;
                    }
                    int i15 = chVar.i();
                    if (i10 == 4) {
                        i = (dhVar.i() - vgVar4.g) - vgVar3.g;
                        i10 = 1;
                    } else {
                        i = i15;
                    }
                    i12 = i;
                    iN2 = iN;
                    i4 = iN2;
                    i2 = i12;
                    i3 = i10;
                    i5 = i11;
                    f(chVar, i5, i4, i3, i2);
                    chVar.d.e.d(chVar.n());
                    chVar.e.e.d(chVar.i());
                } else {
                    int[] iArr2 = dhVar.V;
                    vg[] vgVarArr = chVar.S;
                    int i16 = 3;
                    if (i9 == 3 && (i10 == 2 || i10 == 1)) {
                        if (i13 == 3) {
                            if (i10 == 2) {
                                f(chVar, 2, 0, 2, 0);
                            }
                            int i17 = chVar.i();
                            i6 = i17;
                            iN3 = (int) ((i17 * chVar.Z) + 0.5f);
                            i12 = i6;
                            i11 = 1;
                            iN2 = iN3;
                            i10 = 1;
                        } else {
                            if (i13 == 1) {
                                f(chVar, 2, 0, i10, 0);
                                koVar = chVar.d.e;
                                i7 = chVar.n();
                            } else {
                                if (i13 == 2) {
                                    int i18 = iArr2[0];
                                    if (i18 == 1 || i18 == 4) {
                                        iN4 = (int) ((f * dhVar.n()) + 0.5f);
                                        i8 = chVar.i();
                                        i12 = i8;
                                        iN2 = iN4;
                                        i11 = 1;
                                    }
                                } else if (vgVarArr[0].f == null || vgVarArr[1].f == null) {
                                    iN2 = 0;
                                }
                                i16 = 3;
                                if (i10 != i16) {
                                    if (i9 != i16) {
                                    }
                                } else if (i9 != i16) {
                                }
                            }
                            koVar.m = i7;
                        }
                        i4 = iN2;
                        i2 = i12;
                        i3 = i10;
                        i5 = i11;
                        f(chVar, i5, i4, i3, i2);
                        chVar.d.e.d(chVar.n());
                        chVar.e.e.d(chVar.i());
                    } else if (i10 != i16 && (i9 == 2 || i9 == 1)) {
                        if (i14 == i16) {
                            if (i9 == 2) {
                                f(chVar, 2, 0, 2, 0);
                            }
                            int iN6 = chVar.n();
                            float f3 = chVar.Z;
                            if (chVar.a0 == -1) {
                                f3 = 1.0f / f3;
                            }
                            i8 = (int) ((iN6 * f3) + 0.5f);
                            iN4 = iN6;
                            i10 = 1;
                            i12 = i8;
                            iN2 = iN4;
                            i11 = 1;
                            i4 = iN2;
                            i2 = i12;
                            i3 = i10;
                            i5 = i11;
                        } else {
                            if (i14 == 1) {
                                f(chVar, i9, 0, 2, 0);
                            } else {
                                if (i14 == 2) {
                                    int i19 = iArr2[1];
                                    if (i19 == 1 || i19 == 4) {
                                        iN2 = chVar.n();
                                        i12 = (int) ((f2 * dhVar.i()) + 0.5f);
                                        i11 = i9;
                                        i10 = 1;
                                        i4 = iN2;
                                        i2 = i12;
                                        i3 = i10;
                                        i5 = i11;
                                    } else {
                                        i16 = 3;
                                    }
                                } else {
                                    if (vgVarArr[2].f != null) {
                                        i16 = 3;
                                        if (vgVarArr[3].f == null) {
                                        }
                                    }
                                    i4 = 0;
                                    i2 = 0;
                                    i3 = i10;
                                    i5 = 2;
                                }
                                if (i9 != i16) {
                                }
                            }
                            koVar = chVar.e.e;
                            i7 = chVar.i();
                            koVar.m = i7;
                        }
                        f(chVar, i5, i4, i3, i2);
                        chVar.d.e.d(chVar.n());
                        chVar.e.e.d(chVar.i());
                    } else if (i9 != i16 && i10 == i16) {
                        if (i13 == 1 || i14 == 1) {
                            f(chVar, 2, 0, 2, 0);
                            chVar.d.e.m = chVar.n();
                            koVar = chVar.e.e;
                            i7 = chVar.i();
                            koVar.m = i7;
                        } else if (i14 == 2 && i13 == 2 && iArr2[0] == 1 && iArr2[1] == 1) {
                            iN3 = (int) ((f * dhVar.n()) + 0.5f);
                            i6 = (int) ((f2 * dhVar.i()) + 0.5f);
                            i12 = i6;
                            i11 = 1;
                            iN2 = iN3;
                            i10 = 1;
                            i4 = iN2;
                            i2 = i12;
                            i3 = i10;
                            i5 = i11;
                            f(chVar, i5, i4, i3, i2);
                            chVar.d.e.d(chVar.n());
                            chVar.e.e.d(chVar.i());
                        }
                    }
                }
            }
            chVar.a = true;
        }
    }

    public final void c() {
        yf1 qyVar;
        ArrayList<yf1> arrayList = this.e;
        arrayList.clear();
        dh dhVar = this.d;
        dhVar.d.f();
        dhVar.e.f();
        arrayList.add(dhVar.d);
        arrayList.add(dhVar.e);
        HashSet hashSet = null;
        for (ch chVar : dhVar.s0) {
            if (chVar instanceof py) {
                qyVar = new qy(chVar);
                chVar.d.f();
                chVar.e.f();
                qyVar.f = ((py) chVar).w0;
            } else {
                if (chVar.u()) {
                    if (chVar.b == null) {
                        chVar.b = new xb(0, chVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(chVar.b);
                } else {
                    arrayList.add(chVar.d);
                }
                if (chVar.v()) {
                    if (chVar.c == null) {
                        chVar.c = new xb(1, chVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(chVar.c);
                } else {
                    arrayList.add(chVar.e);
                }
                if (chVar instanceof h8) {
                    qyVar = new e10(chVar);
                }
            }
            arrayList.add(qyVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((yf1) it.next()).f();
        }
        for (yf1 yf1Var : arrayList) {
            if (yf1Var.b != dhVar) {
                yf1Var.d();
            }
        }
        ArrayList arrayList2 = this.h;
        arrayList2.clear();
        dh dhVar2 = this.a;
        e(dhVar2.d, 0, arrayList2);
        e(dhVar2.e, 1, arrayList2);
        this.b = false;
    }

    public final int d(dh dhVar, int i) {
        ArrayList arrayList;
        int i2;
        long j;
        long j2;
        long jB;
        float f;
        long j3;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i3 = 0;
        long jMax = 0;
        while (i3 < size) {
            yf1 yf1Var = ((qw0) arrayList2.get(i3)).a;
            if (!(yf1Var instanceof xb) ? !(i != 0 ? (yf1Var instanceof kd1) : (yf1Var instanceof g10)) : ((xb) yf1Var).f != i) {
                dm dmVar = (i == 0 ? dhVar.d : dhVar.e).h;
                dm dmVar2 = (i == 0 ? dhVar.d : dhVar.e).i;
                boolean zContains = yf1Var.h.l.contains(dmVar);
                dm dmVar3 = yf1Var.i;
                boolean zContains2 = dmVar3.l.contains(dmVar2);
                long j4 = yf1Var.j();
                dm dmVar4 = yf1Var.h;
                if (zContains && zContains2) {
                    long jB2 = qw0.b(dmVar4, 0L);
                    arrayList = arrayList2;
                    i2 = size;
                    long jA = qw0.a(dmVar3, 0L);
                    long j5 = jB2 - j4;
                    int i4 = dmVar3.f;
                    long j6 = j5 >= ((long) (-i4)) ? j5 + ((long) i4) : j5;
                    long j7 = (-jA) - j4;
                    long j8 = dmVar4.f;
                    long j9 = j7 - j8;
                    if (j9 >= j8) {
                        j9 -= j8;
                    }
                    ch chVar = yf1Var.b;
                    if (i == 0) {
                        f = chVar.g0;
                    } else if (i == 1) {
                        f = chVar.h0;
                    } else {
                        chVar.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j3 = (long) ((j6 / (1.0f - f)) + (j9 / f));
                    } else {
                        j3 = 0;
                    }
                    float f2 = j3;
                    j = (((long) dmVar4.f) + ((((long) ((f2 * f) + 0.5f)) + j4) + ((long) e.a(1.0f, f, f2, 0.5f)))) - ((long) dmVar3.f);
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    if (zContains) {
                        jB = qw0.b(dmVar4, dmVar4.f);
                        j2 = ((long) dmVar4.f) + j4;
                    } else if (zContains2) {
                        long jA2 = qw0.a(dmVar3, dmVar3.f);
                        j2 = ((long) (-dmVar3.f)) + j4;
                        jB = -jA2;
                    } else {
                        j = (yf1Var.j() + ((long) dmVar4.f)) - ((long) dmVar3.f);
                    }
                    j = Math.max(jB, j2);
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                j = 0;
            }
            jMax = Math.max(jMax, j);
            i3++;
            arrayList2 = arrayList;
            size = i2;
        }
        return (int) jMax;
    }

    public final void e(yf1 yf1Var, int i, ArrayList arrayList) {
        dm dmVar;
        dm dmVar2;
        dm dmVar3;
        Iterator it = yf1Var.h.k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            dmVar = yf1Var.i;
            if (!zHasNext) {
                break;
            }
            zl zlVar = (zl) it.next();
            if (zlVar instanceof dm) {
                dmVar3 = (dm) zlVar;
            } else if (zlVar instanceof yf1) {
                dmVar3 = ((yf1) zlVar).h;
            }
            a(dmVar3, i, arrayList, null);
        }
        for (zl zlVar2 : dmVar.k) {
            if (zlVar2 instanceof dm) {
                dmVar2 = (dm) zlVar2;
            } else if (zlVar2 instanceof yf1) {
                dmVar2 = ((yf1) zlVar2).i;
            }
            a(dmVar2, i, arrayList, null);
        }
        if (i == 1) {
            for (zl zlVar3 : ((kd1) yf1Var).k.k) {
                if (zlVar3 instanceof dm) {
                    a((dm) zlVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void f(ch chVar, int i, int i2, int i3, int i4) {
        n8$a n8_a = this.g;
        n8_a.a = i;
        n8_a.b = i3;
        n8_a.c = i2;
        n8_a.d = i4;
        this.f.b(chVar, n8_a);
        chVar.J(n8_a.e);
        chVar.G(n8_a.f);
        chVar.F = n8_a.h;
        int i5 = n8_a.g;
        chVar.d0 = i5;
        chVar.F = i5 > 0;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0085 A[PHI: r2 r4
      0x0085: PHI (r2v5 ko) = (r2v4 ko), (r2v9 ko) binds: [B:31:0x0083, B:26:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r4v5 int) = (r4v4 int), (r4v8 int) binds: [B:31:0x0083, B:26:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0088 A[PHI: r2 r4
      0x0088: PHI (r2v6 ko) = (r2v4 ko), (r2v9 ko) binds: [B:31:0x0083, B:26:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r4v6 int) = (r4v4 int), (r4v8 int) binds: [B:31:0x0083, B:26:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    public final void g() {
        ko koVar;
        int iN;
        m8 m8Var;
        for (ch chVar : this.a.s0) {
            if (!chVar.a) {
                int[] iArr = chVar.V;
                boolean z = false;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = chVar.s;
                int i4 = chVar.t;
                boolean z2 = i == 2 || (i == 3 && i3 == 1);
                if (i2 == 2 || (i2 == 3 && i4 == 1)) {
                    z = true;
                }
                ko koVar2 = chVar.d.e;
                boolean z3 = koVar2.j;
                ko koVar3 = chVar.e.e;
                boolean z4 = koVar3.j;
                if (z3 && z4) {
                    f(chVar, 1, koVar2.g, 1, koVar3.g);
                } else {
                    if (z3 && z) {
                        f(chVar, 1, koVar2.g, 2, koVar3.g);
                        koVar = chVar.e.e;
                        iN = chVar.i();
                        if (i2 == 3) {
                            koVar.m = iN;
                        } else {
                            koVar.d(iN);
                        }
                    } else if (z4 && z2) {
                        f(chVar, 2, koVar2.g, 1, koVar3.g);
                        koVar = chVar.d.e;
                        iN = chVar.n();
                        if (i == 3) {
                            koVar.m = iN;
                        } else {
                            koVar.d(iN);
                        }
                    }
                    if (!chVar.a && (m8Var = chVar.e.l) != null) {
                        m8Var.d(chVar.d0);
                    }
                }
                chVar.a = true;
                if (!chVar.a) {
                }
            }
        }
    }
}
