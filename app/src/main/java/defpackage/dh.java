package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dh extends ch {
    public int A0;
    public int v0;
    public int z0;
    public ArrayList s0 = new ArrayList();
    public final m6 t0 = new m6(this);
    public final cm u0 = new cm(this);
    public ConstraintLayout.b w0 = null;
    public boolean x0 = false;
    public final oe0 y0 = new oe0();
    public int B0 = 0;
    public int C0 = 0;
    public wb[] D0 = new wb[4];
    public wb[] E0 = new wb[4];
    public int F0 = 257;
    public boolean G0 = false;
    public boolean H0 = false;
    public WeakReference I0 = null;
    public WeakReference J0 = null;
    public WeakReference K0 = null;
    public WeakReference L0 = null;
    public final HashSet M0 = new HashSet();
    public final n8$a N0 = new n8$a();

    public static void Q(ch chVar, n8$b n8_b, n8$a n8_a) {
        int i;
        int i2;
        if (n8_b == null) {
            return;
        }
        if (chVar.j0 == 8 || (chVar instanceof py) || (chVar instanceof h8)) {
            n8_a.e = 0;
            n8_a.f = 0;
            return;
        }
        int[] iArr = chVar.V;
        n8_a.a = iArr[0];
        n8_a.b = iArr[1];
        n8_a.c = chVar.n();
        n8_a.d = chVar.i();
        n8_a.i = false;
        n8_a.j = 0;
        boolean z = n8_a.a == 3;
        boolean z2 = n8_a.b == 3;
        boolean z3 = z && chVar.Z > 0.0f;
        boolean z4 = z2 && chVar.Z > 0.0f;
        if (z && chVar.q(0) && chVar.s == 0 && !z3) {
            n8_a.a = 2;
            if (z2 && chVar.t == 0) {
                n8_a.a = 1;
            }
            z = false;
        }
        if (z2 && chVar.q(1) && chVar.t == 0 && !z4) {
            n8_a.b = 2;
            if (z && chVar.s == 0) {
                n8_a.b = 1;
            }
            z2 = false;
        }
        if (chVar.x()) {
            n8_a.a = 1;
            z = false;
        }
        if (chVar.y()) {
            n8_a.b = 1;
            z2 = false;
        }
        int[] iArr2 = chVar.u;
        if (z3) {
            if (iArr2[0] == 4) {
                n8_a.a = 1;
            } else if (!z2) {
                if (n8_a.b == 1) {
                    i2 = n8_a.d;
                } else {
                    n8_a.a = 2;
                    ((ConstraintLayout.b) n8_b).b(chVar, n8_a);
                    i2 = n8_a.f;
                }
                n8_a.a = 1;
                n8_a.c = (int) (chVar.Z * i2);
            }
        }
        if (z4) {
            if (iArr2[1] == 4) {
                n8_a.b = 1;
            } else if (!z) {
                if (n8_a.a == 1) {
                    i = n8_a.c;
                } else {
                    n8_a.b = 2;
                    ((ConstraintLayout.b) n8_b).b(chVar, n8_a);
                    i = n8_a.e;
                }
                n8_a.b = 1;
                int i3 = chVar.a0;
                float f = chVar.Z;
                float f2 = i;
                n8_a.d = i3 == -1 ? (int) (f2 / f) : (int) (f * f2);
            }
        }
        ((ConstraintLayout.b) n8_b).b(chVar, n8_a);
        chVar.J(n8_a.e);
        chVar.G(n8_a.f);
        chVar.F = n8_a.h;
        int i4 = n8_a.g;
        chVar.d0 = i4;
        chVar.F = i4 > 0;
        n8_a.j = 0;
    }

    @Override // defpackage.ch
    public final void B(m6 m6Var) {
        super.B(m6Var);
        int size = this.s0.size();
        for (int i = 0; i < size; i++) {
            ((ch) this.s0.get(i)).B(m6Var);
        }
    }

    @Override // defpackage.ch
    public final void K(boolean z, boolean z2) {
        super.K(z, z2);
        int size = this.s0.size();
        for (int i = 0; i < size; i++) {
            ((ch) this.s0.get(i)).K(z, z2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:214:0x0379  */
    /* JADX WARN: Code duplicated, block: B:219:0x0385  */
    /* JADX WARN: Code duplicated, block: B:223:0x0397  */
    /* JADX WARN: Code duplicated, block: B:352:0x0604  */
    /* JADX WARN: Code duplicated, block: B:366:0x0633  */
    /* JADX WARN: Code duplicated, block: B:384:0x0668 A[PHI: r30
      0x0668: PHI (r30v1 vg) = (r30v0 vg), (r30v11 vg), (r30v11 vg) binds: [B:155:0x025d, B:336:0x05d0, B:368:0x0636] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00cf A[PHI: r23
      0x00cf: PHI (r23v18 boolean) = (r23v17 boolean), (r23v17 boolean), (r23v19 boolean) binds: [B:34:0x00c0, B:36:0x00c8, B:19:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:463:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:465:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:467:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:469:0x07e5  */
    /* JADX WARN: Code duplicated, block: B:472:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:474:0x07fd A[LOOP:34: B:473:0x07fb->B:474:0x07fd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:478:0x0811 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:483:0x081e A[LOOP:33: B:482:0x081c->B:483:0x081e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:486:0x0852  */
    /* JADX WARN: Code duplicated, block: B:490:0x0864  */
    /* JADX WARN: Code duplicated, block: B:495:0x0884  */
    /* JADX WARN: Code duplicated, block: B:496:0x0891  */
    /* JADX WARN: Code duplicated, block: B:499:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:500:0x08ad  */
    /* JADX WARN: Code duplicated, block: B:502:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:504:0x08b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:507:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:510:0x08cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:516:0x08e5  */
    /* JADX WARN: Code duplicated, block: B:519:0x08ed  */
    /* JADX WARN: Code duplicated, block: B:520:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:578:0x03b5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0126  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v55, types: [int] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r33v0, types: [ch, dh] */
    /* JADX WARN: Type inference failed for: r5v14, types: [int] */
    /* JADX WARN: Type inference failed for: r6v106, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v73, types: [int] */
    /* JADX WARN: Type inference failed for: r9v23 */
    public final void M() {
        ?? r22;
        vg vgVar;
        int i;
        int i2;
        boolean z;
        char c;
        vg vgVar2;
        boolean z2;
        boolean[] zArr;
        boolean[] zArr2;
        int i3;
        boolean z3;
        int iMax;
        ?? r14;
        boolean z4;
        boolean z5;
        int iMax2;
        ?? r0;
        boolean z6;
        boolean z7;
        ?? r1;
        boolean z8;
        boolean z9;
        boolean z10;
        ?? r2;
        ?? r3;
        int i4;
        int iMax3;
        int iMax4;
        int iMax5;
        int iMax6;
        boolean zR;
        int size;
        int i5;
        boolean z11;
        ch chVar;
        boolean z12;
        xf1 xf1Var;
        xf1 xf1Var2;
        int iB;
        int iB2;
        int i6;
        ArrayList arrayList;
        xf1 xf1Var3;
        xf1 xf1Var4;
        boolean z13;
        ArrayList arrayList2;
        ConstraintLayout.b bVar;
        h8 h8Var;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int i7;
        boolean z14;
        int i8;
        boolean z15;
        this.b0 = 0;
        this.c0 = 0;
        this.G0 = false;
        this.H0 = false;
        int size2 = this.s0.size();
        int iMax7 = Math.max(0, n());
        int iMax8 = Math.max(0, i());
        int[] iArr = this.V;
        int i9 = iArr[1];
        int i10 = iArr[0];
        int i11 = this.v0;
        vg vgVar3 = this.L;
        vg vgVar4 = this.K;
        if (i11 == 0 && e.x(this.F0, 1)) {
            ConstraintLayout.b bVar2 = this.w0;
            int i12 = iArr[0];
            int i13 = iArr[1];
            A();
            ArrayList arrayList5 = this.s0;
            int size3 = arrayList5.size();
            for (int i14 = 0; i14 < size3; i14++) {
                ((ch) arrayList5.get(i14)).A();
            }
            boolean z16 = this.x0;
            if (i12 == 1) {
                E(0, n());
            } else {
                vgVar4.i(0);
                this.b0 = 0;
            }
            int i15 = 0;
            boolean z17 = false;
            boolean z18 = false;
            while (i15 < size3) {
                int[] iArr2 = iArr;
                ch chVar2 = (ch) arrayList5.get(i15);
                int i16 = i15;
                if (chVar2 instanceof py) {
                    py pyVar = (py) chVar2;
                    z15 = z17;
                    if (pyVar.w0 == 1) {
                        int iN = pyVar.t0;
                        if (iN == -1) {
                            if (pyVar.u0 != -1 && x()) {
                                iN = n() - pyVar.u0;
                            } else if (x()) {
                                iN = (int) ((pyVar.s0 * n()) + 0.5f);
                            }
                            pyVar.v0.i(iN);
                            pyVar.x0 = true;
                        } else {
                            pyVar.v0.i(iN);
                            pyVar.x0 = true;
                        }
                        z17 = true;
                    } else {
                        z17 = z15;
                    }
                } else {
                    z15 = z17;
                    if ((chVar2 instanceof h8) && ((h8) chVar2).O() == 0) {
                        z17 = z15;
                        z18 = true;
                    } else {
                        z17 = z15;
                    }
                }
                i15 = i16 + 1;
                iArr = iArr2;
            }
            r22 = iArr;
            if (z17) {
                for (int i17 = 0; i17 < size3; i17 = i8 + 1) {
                    ch chVar3 = (ch) arrayList5.get(i17);
                    if (chVar3 instanceof py) {
                        py pyVar2 = (py) chVar3;
                        i8 = i17;
                        if (pyVar2.w0 == 1) {
                            b2.b(0, pyVar2, bVar2, z16);
                        }
                    } else {
                        i8 = i17;
                    }
                }
            }
            b2.b(0, this, bVar2, z16);
            if (z18) {
                for (int i18 = 0; i18 < size3; i18++) {
                    ch chVar4 = (ch) arrayList5.get(i18);
                    if (chVar4 instanceof h8) {
                        h8 h8Var2 = (h8) chVar4;
                        if (h8Var2.O() == 0 && h8Var2.N()) {
                            b2.b(1, h8Var2, bVar2, z16);
                        }
                    }
                }
            }
            if (i13 == 1) {
                F(0, i());
            } else {
                vgVar3.i(0);
                this.c0 = 0;
            }
            int i19 = 0;
            boolean z19 = false;
            boolean z20 = false;
            while (i19 < size3) {
                ch chVar5 = (ch) arrayList5.get(i19);
                int i20 = i19;
                if (chVar5 instanceof py) {
                    py pyVar3 = (py) chVar5;
                    if (pyVar3.w0 == 0) {
                        int i21 = pyVar3.t0;
                        if (i21 == -1) {
                            if (pyVar3.u0 != -1 && y()) {
                                i21 = i() - pyVar3.u0;
                            } else if (y()) {
                                i21 = (int) ((pyVar3.s0 * i()) + 0.5f);
                            } else {
                                z14 = true;
                            }
                            pyVar3.v0.i(i21);
                            z14 = true;
                            pyVar3.x0 = true;
                        } else {
                            pyVar3.v0.i(i21);
                            z14 = true;
                            pyVar3.x0 = true;
                        }
                        z19 = z14;
                    }
                } else if ((chVar5 instanceof h8) && ((h8) chVar5).O() == 1) {
                    z20 = true;
                }
                i19 = i20 + 1;
            }
            if (z19) {
                for (int i22 = 0; i22 < size3; i22++) {
                    ch chVar6 = (ch) arrayList5.get(i22);
                    if (chVar6 instanceof py) {
                        py pyVar4 = (py) chVar6;
                        if (pyVar4.w0 == 0) {
                            b2.g(1, pyVar4, bVar2);
                        }
                    }
                }
            }
            b2.g(0, this, bVar2);
            if (z20) {
                for (int i23 = 0; i23 < size3; i23++) {
                    ch chVar7 = (ch) arrayList5.get(i23);
                    if (chVar7 instanceof h8) {
                        h8 h8Var3 = (h8) chVar7;
                        if (h8Var3.O() == 1 && h8Var3.N()) {
                            b2.g(1, h8Var3, bVar2);
                        }
                    }
                }
            }
            for (int i24 = 0; i24 < size3; i24++) {
                ch chVar8 = (ch) arrayList5.get(i24);
                if (chVar8.w() && b2.a(chVar8)) {
                    Q(chVar8, bVar2, b2.f13a);
                    if (!(chVar8 instanceof py)) {
                        i7 = 0;
                        b2.b(0, chVar8, bVar2, z16);
                    } else if (((py) chVar8).w0 == 0) {
                        i7 = 0;
                    } else {
                        b2.b(0, chVar8, bVar2, z16);
                    }
                    b2.g(i7, chVar8, bVar2);
                }
            }
            for (int i25 = 0; i25 < size2; i25++) {
                ch chVar9 = (ch) this.s0.get(i25);
                if (chVar9.w() && !(chVar9 instanceof py) && !(chVar9 instanceof h8)) {
                    int iH = chVar9.h(0);
                    int iH2 = chVar9.h(1);
                    if (iH != 3 || chVar9.s == 1 || iH2 != 3 || chVar9.t == 1) {
                        Q(chVar9, this.w0, new n8$a());
                    }
                }
            }
        } else {
            r22 = iArr;
        }
        oe0 oe0Var = this.y0;
        if (size2 <= 2 || !((i10 == 2 || i9 == 2) && e.x(this.F0, 1024))) {
            vgVar = vgVar4;
            i = iMax8;
            i2 = iMax7;
            z = false;
        } else {
            ConstraintLayout.b bVar3 = this.w0;
            ArrayList arrayList6 = this.s0;
            int size4 = arrayList6.size();
            int i26 = 0;
            while (true) {
                if (i26 < size4) {
                    ch chVar10 = (ch) arrayList6.get(i26);
                    ?? r5 = r22[0];
                    ?? r6 = r22[1];
                    int[] iArr3 = chVar10.V;
                    int i27 = i26;
                    if (e4.b(r5, r6, iArr3[0], iArr3[1])) {
                        i26 = i27 + 1;
                    } else {
                        vgVar = vgVar4;
                        i = iMax8;
                        i2 = iMax7;
                        z = false;
                    }
                } else {
                    int i28 = 0;
                    ArrayList arrayList7 = null;
                    ArrayList arrayList8 = null;
                    ArrayList arrayList9 = null;
                    ArrayList arrayList10 = null;
                    ArrayList arrayList11 = null;
                    ArrayList arrayList12 = null;
                    while (i28 < size4) {
                        int i29 = i28;
                        ch chVar11 = (ch) arrayList6.get(i28);
                        ArrayList arrayList13 = arrayList7;
                        ?? r7 = r22[0];
                        ArrayList arrayList14 = arrayList8;
                        ?? r15 = r22[1];
                        ArrayList arrayList15 = arrayList9;
                        int[] iArr4 = chVar11.V;
                        vg vgVar5 = vgVar4;
                        if (!e4.b(r7, r15, iArr4[0], iArr4[1])) {
                            Q(chVar11, bVar3, this.N0);
                        }
                        boolean z21 = chVar11 instanceof py;
                        if (z21) {
                            py pyVar5 = (py) chVar11;
                            if (pyVar5.w0 == 0) {
                                arrayList9 = arrayList15 == null ? new ArrayList() : arrayList15;
                                arrayList9.add(pyVar5);
                            } else {
                                arrayList9 = arrayList15;
                            }
                            z13 = z21;
                            if (pyVar5.w0 == 1) {
                                arrayList2 = arrayList13 == null ? new ArrayList() : arrayList13;
                                arrayList2.add(pyVar5);
                            } else {
                                arrayList2 = arrayList13;
                            }
                        } else {
                            z13 = z21;
                            arrayList2 = arrayList13;
                            arrayList9 = arrayList15;
                        }
                        boolean z22 = chVar11 instanceof h8;
                        if (z22) {
                            if (z22) {
                                h8Var = (h8) chVar11;
                                if (h8Var.O() == 0) {
                                    ArrayList arrayList16 = arrayList14 == null ? new ArrayList() : arrayList14;
                                    arrayList16.add(h8Var);
                                    arrayList14 = arrayList16;
                                } else {
                                    arrayList2 = arrayList2;
                                }
                                bVar = bVar3;
                                if (h8Var.O() == 1) {
                                    if (arrayList11 == null) {
                                        arrayList11 = new ArrayList();
                                    }
                                    arrayList4 = arrayList11;
                                    arrayList3 = arrayList14;
                                }
                                if (chVar11.K.f == null && chVar11.M.f == null && !z13 && !z22) {
                                    if (arrayList10 == null) {
                                        arrayList10 = new ArrayList();
                                    }
                                    ArrayList arrayList17 = arrayList10;
                                    arrayList17.add(chVar11);
                                    arrayList10 = arrayList17;
                                }
                                if (chVar11.L.f != null && chVar11.N.f == null && chVar11.O.f == null && !z13 && !z22) {
                                    if (arrayList12 == null) {
                                        arrayList12 = new ArrayList();
                                    }
                                    ArrayList arrayList18 = arrayList12;
                                    arrayList18.add(chVar11);
                                    arrayList12 = arrayList18;
                                }
                                i28 = i29 + 1;
                                arrayList7 = arrayList2;
                                vgVar4 = vgVar5;
                                bVar3 = bVar;
                            } else {
                                arrayList2 = arrayList2;
                                bVar = bVar3;
                                h8Var = (h8) chVar11;
                                arrayList3 = arrayList14 == null ? new ArrayList() : arrayList14;
                                arrayList3.add(h8Var);
                                if (arrayList11 == null) {
                                    arrayList11 = new ArrayList();
                                }
                                arrayList4 = arrayList11;
                            }
                            arrayList4.add(h8Var);
                            arrayList8 = arrayList3;
                            arrayList11 = arrayList4;
                            if (chVar11.K.f == null) {
                                if (arrayList10 == null) {
                                    arrayList10 = new ArrayList();
                                }
                                ArrayList arrayList19 = arrayList10;
                                arrayList19.add(chVar11);
                                arrayList10 = arrayList19;
                            }
                            if (chVar11.L.f != null) {
                            }
                            i28 = i29 + 1;
                            arrayList7 = arrayList2;
                            vgVar4 = vgVar5;
                            bVar3 = bVar;
                        } else {
                            arrayList2 = arrayList2;
                            bVar = bVar3;
                        }
                        arrayList8 = arrayList14;
                        if (chVar11.K.f == null) {
                            if (arrayList10 == null) {
                                arrayList10 = new ArrayList();
                            }
                            ArrayList arrayList110 = arrayList10;
                            arrayList110.add(chVar11);
                            arrayList10 = arrayList110;
                        }
                        if (chVar11.L.f != null) {
                        }
                        i28 = i29 + 1;
                        arrayList7 = arrayList2;
                        vgVar4 = vgVar5;
                        bVar3 = bVar;
                    }
                    ArrayList arrayList20 = arrayList7;
                    vgVar = vgVar4;
                    ArrayList<h8> arrayList21 = arrayList8;
                    ArrayList arrayList22 = arrayList9;
                    ArrayList<xf1> arrayList23 = new ArrayList();
                    if (arrayList20 != null) {
                        Iterator it = arrayList20.iterator();
                        while (it.hasNext()) {
                            e4.a((py) it.next(), 0, arrayList23, null);
                        }
                    }
                    xf1 xf1Var5 = null;
                    int i30 = 0;
                    if (arrayList21 != null) {
                        for (h8 h8Var4 : arrayList21) {
                            xf1 xf1VarA = e4.a(h8Var4, i30, arrayList23, xf1Var5);
                            h8Var4.M(i30, xf1VarA, arrayList23);
                            xf1VarA.a(arrayList23);
                            xf1Var5 = null;
                            i30 = 0;
                        }
                    }
                    HashSet hashSet = g(vg.a.b).a;
                    if (hashSet != null) {
                        Iterator it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            e4.a(((vg) it2.next()).d, 0, arrayList23, null);
                        }
                    }
                    HashSet hashSet2 = g(vg.a.d).a;
                    if (hashSet2 != null) {
                        Iterator it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            e4.a(((vg) it3.next()).d, 0, arrayList23, null);
                        }
                    }
                    vg.a aVar = vg.a.i;
                    HashSet hashSet3 = g(aVar).a;
                    if (hashSet3 != null) {
                        Iterator it4 = hashSet3.iterator();
                        while (it4.hasNext()) {
                            e4.a(((vg) it4.next()).d, 0, arrayList23, null);
                        }
                    }
                    xf1 xf1Var6 = null;
                    if (arrayList10 != null) {
                        Iterator it5 = arrayList10.iterator();
                        while (it5.hasNext()) {
                            e4.a((ch) it5.next(), 0, arrayList23, null);
                        }
                    }
                    if (arrayList22 != null) {
                        Iterator it6 = arrayList22.iterator();
                        while (it6.hasNext()) {
                            e4.a((py) it6.next(), 1, arrayList23, null);
                        }
                    }
                    int i31 = 1;
                    if (arrayList11 != null) {
                        Iterator it7 = arrayList11.iterator();
                        while (it7.hasNext()) {
                            h8 h8Var5 = (h8) it7.next();
                            Iterator it8 = it7;
                            xf1 xf1VarA2 = e4.a(h8Var5, i31, arrayList23, xf1Var6);
                            h8Var5.M(i31, xf1VarA2, arrayList23);
                            xf1VarA2.a(arrayList23);
                            it7 = it8;
                            xf1Var6 = null;
                            i31 = 1;
                        }
                    }
                    HashSet hashSet4 = g(vg.a.c).a;
                    if (hashSet4 != null) {
                        Iterator it9 = hashSet4.iterator();
                        while (it9.hasNext()) {
                            e4.a(((vg) it9.next()).d, 1, arrayList23, null);
                        }
                    }
                    HashSet hashSet5 = g(vg.a.g).a;
                    if (hashSet5 != null) {
                        Iterator it10 = hashSet5.iterator();
                        while (it10.hasNext()) {
                            e4.a(((vg) it10.next()).d, 1, arrayList23, null);
                        }
                    }
                    HashSet hashSet6 = g(vg.a.f).a;
                    if (hashSet6 != null) {
                        Iterator it11 = hashSet6.iterator();
                        while (it11.hasNext()) {
                            e4.a(((vg) it11.next()).d, 1, arrayList23, null);
                        }
                    }
                    HashSet hashSet7 = g(aVar).a;
                    if (hashSet7 != null) {
                        Iterator it12 = hashSet7.iterator();
                        while (it12.hasNext()) {
                            e4.a(((vg) it12.next()).d, 1, arrayList23, null);
                        }
                    }
                    boolean z23 = true;
                    if (arrayList12 != null) {
                        Iterator it13 = arrayList12.iterator();
                        while (it13.hasNext()) {
                            e4.a((ch) it13.next(), 1, arrayList23, null);
                        }
                    }
                    int i32 = 0;
                    while (i32 < size4) {
                        ch chVar12 = (ch) arrayList6.get(i32);
                        int[] iArr5 = chVar12.V;
                        boolean z24 = z23;
                        if (iArr5[0] == 3 && iArr5[z24 ? 1 : 0] == 3) {
                            int i33 = chVar12.q0;
                            int size5 = arrayList23.size();
                            int i34 = 0;
                            while (true) {
                                if (i34 >= size5) {
                                    i6 = i32;
                                    arrayList = arrayList6;
                                    xf1Var3 = null;
                                    break;
                                }
                                i6 = i32;
                                xf1Var3 = (xf1) arrayList23.get(i34);
                                arrayList = arrayList6;
                                if (i33 == xf1Var3.b) {
                                    break;
                                }
                                i34++;
                                arrayList6 = arrayList;
                                i32 = i6;
                            }
                            int i35 = chVar12.r0;
                            int size6 = arrayList23.size();
                            int i36 = 0;
                            while (true) {
                                if (i36 >= size6) {
                                    xf1Var4 = null;
                                    break;
                                }
                                xf1Var4 = (xf1) arrayList23.get(i36);
                                if (i35 == xf1Var4.b) {
                                    break;
                                } else {
                                    i36++;
                                }
                            }
                            if (xf1Var3 != null && xf1Var4 != null) {
                                xf1Var3.c(0, xf1Var4);
                                xf1Var4.c = 2;
                                arrayList23.remove(xf1Var3);
                            }
                        } else {
                            i6 = i32;
                            arrayList = arrayList6;
                        }
                        i32 = i6 + 1;
                        arrayList6 = arrayList;
                        z23 = true;
                    }
                    if (arrayList23.size() <= 1) {
                        i = iMax8;
                        i2 = iMax7;
                        z = false;
                    } else {
                        int i37 = 0;
                        if (r22[0] == 2) {
                            int i38 = 0;
                            xf1Var = null;
                            for (xf1 xf1Var7 : arrayList23) {
                                if (xf1Var7.c != 1 && (iB2 = xf1Var7.b(oe0Var, i37)) > i38) {
                                    xf1Var = xf1Var7;
                                    i38 = iB2;
                                }
                                i37 = 0;
                            }
                            if (xf1Var != null) {
                                H(1);
                                J(i38);
                            } else {
                                xf1Var = null;
                            }
                        } else {
                            xf1Var = null;
                        }
                        if (r22[1] == 2) {
                            int i39 = 0;
                            xf1Var2 = null;
                            for (xf1 xf1Var8 : arrayList23) {
                                if (xf1Var8.c != 0 && (iB = xf1Var8.b(oe0Var, 1)) > i39) {
                                    xf1Var2 = xf1Var8;
                                    i39 = iB;
                                }
                            }
                            if (xf1Var2 != null) {
                                I(1);
                                G(i39);
                            } else {
                                xf1Var2 = null;
                            }
                        } else {
                            xf1Var2 = null;
                        }
                        if (xf1Var == null && xf1Var2 == null) {
                            i = iMax8;
                            i2 = iMax7;
                            z = false;
                        } else {
                            if (i10 == 2) {
                                if (iMax7 >= n() || iMax7 <= 0) {
                                    iMax7 = n();
                                } else {
                                    J(iMax7);
                                    this.G0 = true;
                                }
                            }
                            if (i9 == 2) {
                                if (iMax8 >= i() || iMax8 <= 0) {
                                    iMax8 = i();
                                } else {
                                    G(iMax8);
                                    this.H0 = true;
                                }
                            }
                            i = iMax8;
                            i2 = iMax7;
                            z = true;
                        }
                    }
                }
            }
        }
        boolean z25 = R(64) || R(128);
        oe0Var.getClass();
        oe0Var.g = false;
        if (this.F0 == 0 || !z25) {
            c = 1;
        } else {
            c = 1;
            oe0Var.g = true;
        }
        ArrayList arrayList24 = this.s0;
        boolean z26 = r22[0] == 2 || r22[c] == 2;
        this.B0 = 0;
        this.C0 = 0;
        for (int i40 = 0; i40 < size2; i40++) {
            ch chVar13 = (ch) this.s0.get(i40);
            if (chVar13 instanceof dh) {
                ((dh) chVar13).M();
            }
        }
        boolean zR2 = R(64);
        boolean z27 = z;
        int i41 = 0;
        boolean z28 = true;
        while (z28) {
            int i42 = i41 + 1;
            try {
                oe0Var.u();
                this.B0 = 0;
                this.C0 = 0;
                e(oe0Var);
                for (int i43 = 0; i43 < size2; i43++) {
                    ((ch) this.s0.get(i43)).e(oe0Var);
                }
                O(oe0Var);
                try {
                    WeakReference weakReference = this.I0;
                    if (weakReference == null || weakReference.get() == null) {
                        vgVar2 = vgVar3;
                    } else {
                        vgVar2 = vgVar3;
                        try {
                            oe0Var.f(oe0Var.l((vg) this.I0.get()), oe0Var.l(vgVar3), 0, 5);
                            this.I0 = null;
                        } catch (Exception e) {
                            e = e;
                            z12 = true;
                            e.printStackTrace();
                            System.out.println("EXCEPTION : " + e);
                            z2 = z12;
                            zArr = e.o;
                            if (z2) {
                                zArr[2] = false;
                                zR = R(64);
                                L(oe0Var, zR);
                                size = this.s0.size();
                                i5 = 0;
                                z11 = false;
                                while (i5 < size) {
                                    chVar = (ch) this.s0.get(i5);
                                    chVar.L(oe0Var, zR);
                                    boolean[] zArr3 = zArr;
                                    boolean z29 = zR;
                                    if (chVar.i == -1) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    i5++;
                                    zArr = zArr3;
                                    zR = z29;
                                    z11 = z11;
                                }
                                zArr2 = zArr;
                                z3 = z11;
                            } else {
                                zArr2 = zArr;
                                L(oe0Var, zR2);
                                for (i3 = 0; i3 < size2; i3++) {
                                    ((ch) this.s0.get(i3)).L(oe0Var, zR2);
                                }
                                z3 = false;
                            }
                            if (z26 != 0) {
                                iMax3 = 0;
                                iMax4 = 0;
                                for (i4 = 0; i4 < size2; i4++) {
                                    ch chVar14 = (ch) this.s0.get(i4);
                                    iMax3 = Math.max(iMax3, chVar14.n() + chVar14.b0);
                                    iMax4 = Math.max(iMax4, chVar14.i() + chVar14.c0);
                                }
                                iMax5 = Math.max(this.e0, iMax3);
                                iMax6 = Math.max(this.f0, iMax4);
                                z3 = z3;
                                if (i10 == 2) {
                                    z3 = z3;
                                    J(iMax5);
                                    r22[0] = 2;
                                    z27 = true;
                                    z3 = true;
                                }
                                if (i9 == 2) {
                                    G(iMax6);
                                    r22[1] = 2;
                                    z27 = true;
                                    z3 = true;
                                }
                            }
                            iMax = Math.max(this.e0, n());
                            if (iMax > n()) {
                                J(iMax);
                                r14 = 1;
                                r22[0] = 1;
                                z5 = true;
                                z4 = true;
                            } else {
                                r14 = 1;
                                z4 = z27;
                                z5 = z3;
                            }
                            iMax2 = Math.max(this.f0, i());
                            if (iMax2 > i()) {
                                G(iMax2);
                                r22[r14] = r14;
                                r3 = r14;
                                z6 = r3 == true ? 1 : 0;
                            } else {
                                r0 = z4;
                            }
                            if (r0 == 0) {
                                z6 = z5;
                                if (r22[0] == 2) {
                                    r2 = r0;
                                    z10 = z6;
                                    if (n() > i2) {
                                        this.G0 = r14;
                                        r22[0] = r14;
                                        J(i2);
                                        ?? r4 = r14;
                                        z10 = r4 == true ? 1 : 0;
                                        r2 = r4;
                                    }
                                }
                                r0 = r3;
                                r2 = r0;
                                r2 = r0;
                                z10 = z6;
                                z10 = z6;
                                r1 = r2;
                                r1 = r2;
                                z7 = z10;
                                z7 = z10;
                                if (r22[r14] != 2) {
                                }
                                if (i42 > 8) {
                                    z9 = false;
                                } else {
                                    z9 = z8;
                                }
                                i41 = i42;
                                vgVar3 = vgVar2;
                                z26 = z26;
                                z28 = z9;
                            } else {
                                z6 = z5;
                                r0 = r3;
                                r1 = r0;
                                z7 = z6;
                            }
                            r1 = r2;
                            z7 = z10;
                            z27 = r1 == true ? 1 : 0;
                            z8 = z7;
                            if (i42 > 8) {
                                z9 = false;
                            } else {
                                z9 = z8;
                            }
                            i41 = i42;
                            vgVar3 = vgVar2;
                            z26 = z26;
                            z28 = z9;
                        }
                    }
                    WeakReference weakReference2 = this.K0;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        oe0Var.f(oe0Var.l(this.N), oe0Var.l((vg) this.K0.get()), 0, 5);
                        this.K0 = null;
                    }
                    WeakReference weakReference3 = this.J0;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        vg vgVar6 = vgVar;
                        try {
                            vgVar = vgVar6;
                            oe0Var.f(oe0Var.l((vg) this.J0.get()), oe0Var.l(vgVar6), 0, 5);
                            this.J0 = null;
                        } catch (Exception e2) {
                            e = e2;
                            vgVar = vgVar6;
                            z12 = true;
                            e.printStackTrace();
                            System.out.println("EXCEPTION : " + e);
                            z2 = z12;
                            zArr = e.o;
                            if (z2) {
                                zArr[2] = false;
                                zR = R(64);
                                L(oe0Var, zR);
                                size = this.s0.size();
                                i5 = 0;
                                z11 = false;
                                while (i5 < size) {
                                    chVar = (ch) this.s0.get(i5);
                                    chVar.L(oe0Var, zR);
                                    boolean[] zArr4 = zArr;
                                    boolean z210 = zR;
                                    if (chVar.i == -1) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    i5++;
                                    zArr = zArr4;
                                    zR = z210;
                                    z11 = z11;
                                }
                                zArr2 = zArr;
                                z3 = z11;
                            } else {
                                zArr2 = zArr;
                                L(oe0Var, zR2);
                                while (i3 < size2) {
                                    ((ch) this.s0.get(i3)).L(oe0Var, zR2);
                                }
                                z3 = false;
                            }
                            if (z26 != 0) {
                                iMax3 = 0;
                                iMax4 = 0;
                                while (i4 < size2) {
                                    ch chVar15 = (ch) this.s0.get(i4);
                                    iMax3 = Math.max(iMax3, chVar15.n() + chVar15.b0);
                                    iMax4 = Math.max(iMax4, chVar15.i() + chVar15.c0);
                                }
                                iMax5 = Math.max(this.e0, iMax3);
                                iMax6 = Math.max(this.f0, iMax4);
                                z3 = z3;
                                if (i10 == 2) {
                                    z3 = z3;
                                    J(iMax5);
                                    r22[0] = 2;
                                    z27 = true;
                                    z3 = true;
                                }
                                if (i9 == 2) {
                                    G(iMax6);
                                    r22[1] = 2;
                                    z27 = true;
                                    z3 = true;
                                }
                            }
                            iMax = Math.max(this.e0, n());
                            if (iMax > n()) {
                                J(iMax);
                                r14 = 1;
                                r22[0] = 1;
                                z5 = true;
                                z4 = true;
                            } else {
                                r14 = 1;
                                z4 = z27;
                                z5 = z3;
                            }
                            iMax2 = Math.max(this.f0, i());
                            if (iMax2 > i()) {
                                G(iMax2);
                                r22[r14] = r14;
                                r3 = r14;
                                z6 = r3 == true ? 1 : 0;
                            } else {
                                r0 = z4;
                            }
                            if (r0 == 0) {
                                z6 = z5;
                                if (r22[0] == 2) {
                                    r2 = r0;
                                    z10 = z6;
                                    if (n() > i2) {
                                        this.G0 = r14;
                                        r22[0] = r14;
                                        J(i2);
                                        ?? r8 = r14;
                                        z10 = r8 == true ? 1 : 0;
                                        r2 = r8;
                                    }
                                }
                                r0 = r3;
                                r2 = r0;
                                r2 = r0;
                                z10 = z6;
                                z10 = z6;
                                r1 = r2;
                                r1 = r2;
                                z7 = z10;
                                z7 = z10;
                                if (r22[r14] != 2) {
                                }
                                if (i42 > 8) {
                                    z9 = false;
                                } else {
                                    z9 = z8;
                                }
                                i41 = i42;
                                vgVar3 = vgVar2;
                                z26 = z26;
                                z28 = z9;
                            } else {
                                z6 = z5;
                                r0 = r3;
                                r1 = r0;
                                z7 = z6;
                            }
                            r1 = r2;
                            z7 = z10;
                            z27 = r1 == true ? 1 : 0;
                            z8 = z7;
                            if (i42 > 8) {
                                z9 = false;
                            } else {
                                z9 = z8;
                            }
                            i41 = i42;
                            vgVar3 = vgVar2;
                            z26 = z26;
                            z28 = z9;
                        }
                    }
                    WeakReference weakReference4 = this.L0;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        oe0Var.f(oe0Var.l(this.M), oe0Var.l((vg) this.L0.get()), 0, 5);
                        try {
                            this.L0 = null;
                        } catch (Exception e3) {
                            e = e3;
                            z12 = true;
                            e.printStackTrace();
                            System.out.println("EXCEPTION : " + e);
                            z2 = z12;
                        }
                    }
                    oe0Var.q();
                    z2 = true;
                } catch (Exception e4) {
                    e = e4;
                    vgVar2 = vgVar3;
                }
            } catch (Exception e5) {
                e = e5;
                vgVar2 = vgVar3;
                z12 = z28;
            }
            zArr = e.o;
            if (z2) {
                zArr[2] = false;
                zR = R(64);
                L(oe0Var, zR);
                size = this.s0.size();
                i5 = 0;
                z11 = false;
                while (i5 < size) {
                    chVar = (ch) this.s0.get(i5);
                    chVar.L(oe0Var, zR);
                    boolean[] zArr5 = zArr;
                    boolean z211 = zR;
                    if (chVar.i == -1 || chVar.j != -1) {
                        z11 = true;
                    }
                    i5++;
                    zArr = zArr5;
                    zR = z211;
                    z11 = z11;
                }
                zArr2 = zArr;
                z3 = z11;
            } else {
                zArr2 = zArr;
                L(oe0Var, zR2);
                while (i3 < size2) {
                    ((ch) this.s0.get(i3)).L(oe0Var, zR2);
                }
                z3 = false;
            }
            if (z26 != 0 && i42 < 8 && zArr2[2]) {
                iMax3 = 0;
                iMax4 = 0;
                while (i4 < size2) {
                    ch chVar16 = (ch) this.s0.get(i4);
                    iMax3 = Math.max(iMax3, chVar16.n() + chVar16.b0);
                    iMax4 = Math.max(iMax4, chVar16.i() + chVar16.c0);
                }
                iMax5 = Math.max(this.e0, iMax3);
                iMax6 = Math.max(this.f0, iMax4);
                z3 = z3;
                if (i10 == 2 && n() < iMax5) {
                    z3 = z3;
                    J(iMax5);
                    r22[0] = 2;
                    z27 = true;
                    z3 = true;
                }
                if (i9 == 2 && i() < iMax6) {
                    G(iMax6);
                    r22[1] = 2;
                    z27 = true;
                    z3 = true;
                }
            }
            iMax = Math.max(this.e0, n());
            if (iMax > n()) {
                J(iMax);
                r14 = 1;
                r22[0] = 1;
                z5 = true;
                z4 = true;
            } else {
                r14 = 1;
                z4 = z27;
                z5 = z3;
            }
            iMax2 = Math.max(this.f0, i());
            if (iMax2 > i()) {
                G(iMax2);
                r22[r14] = r14;
                r3 = r14;
                z6 = r3 == true ? 1 : 0;
            } else {
                r0 = z4;
            }
            if (r0 == 0) {
                z6 = z5;
                if (r22[0] == 2 && i2 > 0) {
                    r2 = r0;
                    z10 = z6;
                    if (n() > i2) {
                        this.G0 = r14;
                        r22[0] = r14;
                        J(i2);
                        ?? r9 = r14;
                        z10 = r9 == true ? 1 : 0;
                        r2 = r9;
                    }
                }
                r0 = r3;
                r2 = r0;
                r2 = r0;
                z10 = z6;
                z10 = z6;
                r1 = r2;
                r1 = r2;
                z7 = z10;
                z7 = z10;
                if (r22[r14] != 2 && i > 0 && i() > i) {
                    r1 = r2;
                    z7 = z10;
                    this.H0 = r14;
                    r22[r14] = r14;
                    G(i);
                    z8 = true;
                    z27 = true;
                }
                if (i42 > 8) {
                    z9 = false;
                } else {
                    z9 = z8;
                }
                i41 = i42;
                vgVar3 = vgVar2;
                z26 = z26;
                z28 = z9;
            } else {
                z6 = z5;
                r0 = r3;
                r1 = r0;
                z7 = z6;
            }
            r1 = r2;
            z7 = z10;
            z27 = r1 == true ? 1 : 0;
            z8 = z7;
            if (i42 > 8) {
                z9 = false;
            } else {
                z9 = z8;
            }
            i41 = i42;
            vgVar3 = vgVar2;
            z26 = z26;
            z28 = z9;
        }
        this.s0 = arrayList24;
        if (z27) {
            r22[0] = i10;
            r22[1] = i9;
        }
        B(oe0Var.l);
    }

    public final void N(int i, ch chVar) {
        if (i == 0) {
            int i2 = this.B0 + 1;
            wb[] wbVarArr = this.E0;
            if (i2 >= wbVarArr.length) {
                this.E0 = (wb[]) Arrays.copyOf(wbVarArr, wbVarArr.length * 2);
            }
            wb[] wbVarArr2 = this.E0;
            int i3 = this.B0;
            wbVarArr2[i3] = new wb(chVar, 0, this.x0);
            this.B0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.C0 + 1;
            wb[] wbVarArr3 = this.D0;
            if (i4 >= wbVarArr3.length) {
                this.D0 = (wb[]) Arrays.copyOf(wbVarArr3, wbVarArr3.length * 2);
            }
            wb[] wbVarArr4 = this.D0;
            int i5 = this.C0;
            wbVarArr4[i5] = new wb(chVar, 1, this.x0);
            this.C0 = i5 + 1;
        }
    }

    public final void O(oe0 oe0Var) {
        dh dhVar;
        oe0 oe0Var2;
        boolean zR = R(64);
        b(oe0Var, zR);
        int size = this.s0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ch chVar = (ch) this.s0.get(i);
            boolean[] zArr = chVar.U;
            zArr[0] = false;
            zArr[1] = false;
            if (chVar instanceof h8) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ch chVar2 = (ch) this.s0.get(i2);
                if (chVar2 instanceof h8) {
                    h8 h8Var = (h8) chVar2;
                    for (int i3 = 0; i3 < h8Var.t0; i3++) {
                        ch chVar3 = h8Var.s0[i3];
                        if (h8Var.v0 || chVar3.c()) {
                            int i4 = h8Var.u0;
                            if (i4 == 0 || i4 == 1) {
                                chVar3.U[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                chVar3.U[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.M0;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            ch chVar4 = (ch) this.s0.get(i5);
            chVar4.getClass();
            if (chVar4 instanceof py) {
                chVar4.b(oe0Var, zR);
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            if (it.hasNext()) {
                ((ch) it.next()).getClass();
                d.AnonymousClass0.m$1();
                return;
            } else if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((ch) it2.next()).b(oe0Var, zR);
                }
                hashSet.clear();
            }
        }
        if (oe0.p) {
            HashSet<ch> hashSet2 = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                ch chVar5 = (ch) this.s0.get(i6);
                chVar5.getClass();
                if (!(chVar5 instanceof py)) {
                    hashSet2.add(chVar5);
                }
            }
            dhVar = this;
            oe0Var2 = oe0Var;
            dhVar.a(this, oe0Var2, hashSet2, this.V[0] == 2 ? 0 : 1, false);
            for (ch chVar6 : hashSet2) {
                e.g(this, oe0Var2, chVar6);
                chVar6.b(oe0Var2, zR);
            }
        } else {
            dhVar = this;
            oe0Var2 = oe0Var;
            for (int i7 = 0; i7 < size; i7++) {
                ch chVar7 = (ch) dhVar.s0.get(i7);
                if (chVar7 instanceof dh) {
                    int[] iArr = chVar7.V;
                    int i8 = iArr[0];
                    int i9 = iArr[1];
                    if (i8 == 2) {
                        chVar7.H(1);
                    }
                    if (i9 == 2) {
                        chVar7.I(1);
                    }
                    chVar7.b(oe0Var2, zR);
                    if (i8 == 2) {
                        chVar7.H(i8);
                    }
                    if (i9 == 2) {
                        chVar7.I(i9);
                    }
                } else {
                    e.g(this, oe0Var2, chVar7);
                    if (!(chVar7 instanceof py)) {
                        chVar7.b(oe0Var2, zR);
                    }
                }
            }
        }
        if (dhVar.B0 > 0) {
            e.h(this, oe0Var2, null, 0);
        }
        if (dhVar.C0 > 0) {
            e.h(this, oe0Var2, null, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    public final boolean P(int i, boolean z) {
        boolean z2;
        ko koVar;
        int i2;
        cm cmVar = this.u0;
        dh dhVar = cmVar.a;
        boolean z3 = false;
        int iH = dhVar.h(0);
        int iH2 = dhVar.h(1);
        int iO = dhVar.o();
        int iP = dhVar.p();
        ArrayList<yf1> arrayList = cmVar.e;
        if (z && (iH == 2 || iH2 == 2)) {
            for (yf1 yf1Var : arrayList) {
                if (yf1Var.f == i && !yf1Var.k()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && iH == 2) {
                    dhVar.H(1);
                    dhVar.J(cmVar.d(dhVar, 0));
                    koVar = dhVar.d.e;
                    i2 = dhVar.n();
                    koVar.d(i2);
                }
            } else if (z && iH2 == 2) {
                dhVar.I(1);
                dhVar.G(cmVar.d(dhVar, 1));
                koVar = dhVar.e.e;
                i2 = dhVar.i();
                koVar.d(i2);
            }
        }
        int[] iArr = dhVar.V;
        if (i == 0) {
            int i3 = iArr[0];
            if (i3 == 1 || i3 == 4) {
                int iN = dhVar.n() + iO;
                dhVar.d.i.d(iN);
                dhVar.d.e.d(iN - iO);
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            int i4 = iArr[1];
            if (i4 == 1 || i4 == 4) {
                int i5 = dhVar.i() + iP;
                dhVar.e.i.d(i5);
                dhVar.e.e.d(i5 - iP);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        cmVar.g();
        for (yf1 yf1Var2 : arrayList) {
            if (yf1Var2.f == i && (yf1Var2.b != dhVar || yf1Var2.g)) {
                yf1Var2.e();
            }
        }
        for (yf1 yf1Var3 : arrayList) {
            if (yf1Var3.f == i && (z2 || yf1Var3.b != dhVar)) {
                if (!yf1Var3.h.j || !yf1Var3.i.j || (!(yf1Var3 instanceof xb) && !yf1Var3.e.j)) {
                    dhVar.H(iH);
                    dhVar.I(iH2);
                    return z3;
                }
            }
        }
        z3 = true;
        dhVar.H(iH);
        dhVar.I(iH2);
        return z3;
    }

    public final boolean R(int i) {
        return (this.F0 & i) == i;
    }

    @Override // defpackage.ch
    public final void z() {
        this.y0.u();
        this.z0 = 0;
        this.A0 = 0;
        this.s0.clear();
        super.z();
    }
}
