package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ch {
    public float A;
    public int B;
    public float C;
    public final int[] D;
    public float E;
    public boolean F;
    public boolean G;
    public int I;
    public int J;
    public final vg K;
    public final vg L;
    public final vg M;
    public final vg N;
    public final vg O;
    public final vg P;
    public final vg Q;
    public final vg R;
    public final vg[] S;
    public final ArrayList T;
    public final boolean[] U;
    public final int[] V;
    public dh W;
    public int X;
    public int Y;
    public float Z;
    public int a0;
    public xb b;
    public int b0;
    public xb c;
    public int c0;
    public int d0;
    public int e0;
    public int f0;
    public float g0;
    public float h0;
    public View i0;
    public int j0;
    public String k0;
    public boolean l;
    public int l0;
    public boolean m;
    public int m0;
    public boolean n;
    public final float[] n0;
    public boolean o;
    public final ch[] o0;
    public int p;
    public final ch[] p0;
    public int q;
    public int q0;
    public int r;
    public int r0;
    public int s;
    public int t;
    public final int[] u;
    public int v;
    public int w;
    public float x;
    public int y;
    public int z;
    public boolean a = false;
    public g10 d = null;
    public kd1 e = null;
    public final boolean[] f = {true, true};
    public boolean g = true;
    public int i = -1;
    public int j = -1;

    public ch() {
        new HashMap();
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = new int[2];
        this.v = 0;
        this.w = 0;
        this.x = 1.0f;
        this.y = 0;
        this.z = 0;
        this.A = 1.0f;
        this.B = -1;
        this.C = 1.0f;
        this.D = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.E = 0.0f;
        this.F = false;
        this.I = 0;
        this.J = 0;
        vg vgVar = new vg(this, vg.a.b);
        this.K = vgVar;
        vg vgVar2 = new vg(this, vg.a.c);
        this.L = vgVar2;
        vg vgVar3 = new vg(this, vg.a.d);
        this.M = vgVar3;
        vg vgVar4 = new vg(this, vg.a.f);
        this.N = vgVar4;
        vg vgVar5 = new vg(this, vg.a.g);
        this.O = vgVar5;
        vg vgVar6 = new vg(this, vg.a.j);
        this.P = vgVar6;
        vg vgVar7 = new vg(this, vg.a.n);
        this.Q = vgVar7;
        vg vgVar8 = new vg(this, vg.a.i);
        this.R = vgVar8;
        this.S = new vg[]{vgVar, vgVar3, vgVar2, vgVar4, vgVar5, vgVar8};
        ArrayList arrayList = new ArrayList();
        this.T = arrayList;
        this.U = new boolean[2];
        this.V = new int[]{1, 1};
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.g0 = 0.5f;
        this.h0 = 0.5f;
        this.j0 = 0;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = new float[]{-1.0f, -1.0f};
        this.o0 = new ch[]{null, null};
        this.p0 = new ch[]{null, null};
        this.q0 = -1;
        this.r0 = -1;
        arrayList.add(vgVar);
        arrayList.add(vgVar2);
        arrayList.add(vgVar3);
        arrayList.add(vgVar4);
        arrayList.add(vgVar6);
        arrayList.add(vgVar7);
        arrayList.add(vgVar8);
        arrayList.add(vgVar5);
    }

    public final void A() {
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        ArrayList arrayList = this.T;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            vg vgVar = (vg) arrayList.get(i);
            vgVar.c = false;
            vgVar.b = 0;
        }
    }

    public void B(m6 m6Var) {
        this.K.h();
        this.L.h();
        this.M.h();
        this.N.h();
        this.O.h();
        this.R.h();
        this.P.h();
        this.Q.h();
    }

    public final void E(int i, int i2) {
        if (this.l) {
            return;
        }
        this.K.i(i);
        this.M.i(i2);
        this.b0 = i;
        this.X = i2 - i;
        this.l = true;
    }

    public final void F(int i, int i2) {
        if (this.m) {
            return;
        }
        this.L.i(i);
        this.N.i(i2);
        this.c0 = i;
        this.Y = i2 - i;
        if (this.F) {
            this.O.i(i + this.d0);
        }
        this.m = true;
    }

    public final void G(int i) {
        this.Y = i;
        int i2 = this.f0;
        if (i < i2) {
            this.Y = i2;
        }
    }

    public final void H(int i) {
        this.V[0] = i;
    }

    public final void I(int i) {
        this.V[1] = i;
    }

    public final void J(int i) {
        this.X = i;
        int i2 = this.e0;
        if (i < i2) {
            this.X = i2;
        }
    }

    public void K(boolean z, boolean z2) {
        int i;
        int i2;
        g10 g10Var = this.d;
        boolean z3 = z & g10Var.g;
        kd1 kd1Var = this.e;
        boolean z4 = z2 & kd1Var.g;
        int i3 = g10Var.h.g;
        int i4 = kd1Var.h.g;
        int i5 = g10Var.i.g;
        int i6 = kd1Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.b0 = i3;
        }
        if (z4) {
            this.c0 = i4;
        }
        if (this.j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        int[] iArr = this.V;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.X)) {
                i8 = i2;
            }
            this.X = i8;
            int i10 = this.e0;
            if (i8 < i10) {
                this.X = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.Y)) {
                i9 = i;
            }
            this.Y = i9;
            int i11 = this.f0;
            if (i9 < i11) {
                this.Y = i11;
            }
        }
    }

    public void L(oe0 oe0Var, boolean z) {
        int i;
        int i2;
        kd1 kd1Var;
        g10 g10Var;
        oe0Var.getClass();
        int iO = oe0.o(this.K);
        int iO2 = oe0.o(this.L);
        int iO3 = oe0.o(this.M);
        int iO4 = oe0.o(this.N);
        if (z && (g10Var = this.d) != null) {
            dm dmVar = g10Var.h;
            if (dmVar.j) {
                dm dmVar2 = g10Var.i;
                if (dmVar2.j) {
                    iO = dmVar.g;
                    iO3 = dmVar2.g;
                }
            }
        }
        if (z && (kd1Var = this.e) != null) {
            dm dmVar3 = kd1Var.h;
            if (dmVar3.j) {
                dm dmVar4 = kd1Var.i;
                if (dmVar4.j) {
                    iO2 = dmVar3.g;
                    iO4 = dmVar4.g;
                }
            }
        }
        int i3 = iO4 - iO2;
        if (iO3 - iO < 0 || i3 < 0 || iO == Integer.MIN_VALUE || iO == Integer.MAX_VALUE || iO2 == Integer.MIN_VALUE || iO2 == Integer.MAX_VALUE || iO3 == Integer.MIN_VALUE || iO3 == Integer.MAX_VALUE || iO4 == Integer.MIN_VALUE || iO4 == Integer.MAX_VALUE) {
            iO = 0;
            iO2 = 0;
            iO3 = 0;
            iO4 = 0;
        }
        int i4 = iO3 - iO;
        int i5 = iO4 - iO2;
        this.b0 = iO;
        this.c0 = iO2;
        if (this.j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        int[] iArr = this.V;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.X)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.Y)) {
            i5 = i;
        }
        this.X = i4;
        this.Y = i5;
        int i7 = this.f0;
        if (i5 < i7) {
            this.Y = i7;
        }
        int i8 = this.e0;
        if (i4 < i8) {
            this.X = i8;
        }
        int i9 = this.w;
        if (i9 > 0 && i6 == 3) {
            this.X = Math.min(this.X, i9);
        }
        int i10 = this.z;
        if (i10 > 0 && iArr[1] == 3) {
            this.Y = Math.min(this.Y, i10);
        }
        int i11 = this.X;
        if (i4 != i11) {
            this.i = i11;
        }
        int i12 = this.Y;
        if (i5 != i12) {
            this.j = i12;
        }
    }

    public final void a(dh dhVar, oe0 oe0Var, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            e.g(dhVar, oe0Var, this);
            hashSet.remove(this);
            b(oe0Var, dhVar.R(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.K.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((vg) it.next()).d.a(dhVar, oe0Var, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.M.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((vg) it2.next()).d.a(dhVar, oe0Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.L.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((vg) it3.next()).d.a(dhVar, oe0Var, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.N.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((vg) it4.next()).d.a(dhVar, oe0Var, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.O.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((vg) it5.next()).d.a(dhVar, oe0Var, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:122:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:124:0x0204  */
    /* JADX WARN: Code duplicated, block: B:125:0x020d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0219  */
    /* JADX WARN: Code duplicated, block: B:129:0x0220  */
    /* JADX WARN: Code duplicated, block: B:131:0x0226 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:139:0x0246  */
    /* JADX WARN: Code duplicated, block: B:141:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x026a  */
    /* JADX WARN: Code duplicated, block: B:154:0x0275  */
    /* JADX WARN: Code duplicated, block: B:157:0x027e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0281  */
    /* JADX WARN: Code duplicated, block: B:161:0x0290  */
    /* JADX WARN: Code duplicated, block: B:163:0x0297  */
    /* JADX WARN: Code duplicated, block: B:166:0x029e  */
    /* JADX WARN: Code duplicated, block: B:167:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:170:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:172:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:174:0x02ca A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:176:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:178:0x02d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:180:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:182:0x02de A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:225:0x034f  */
    /* JADX WARN: Code duplicated, block: B:227:0x0355  */
    /* JADX WARN: Code duplicated, block: B:232:0x0369  */
    /* JADX WARN: Code duplicated, block: B:237:0x0375 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:238:0x0377  */
    /* JADX WARN: Code duplicated, block: B:241:0x0385  */
    /* JADX WARN: Code duplicated, block: B:243:0x0388 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:247:0x0398 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:248:0x039a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:256:0x03b2 A[PHI: r13
      0x03b2: PHI (r13v34 int) = (r13v22 int), (r13v22 int), (r13v32 int), (r13v22 int), (r13v22 int), (r13v22 int), (r13v22 int), (r13v22 int) binds: [B:247:0x0398, B:248:0x039a, B:245:0x0392, B:231:0x0367, B:237:0x0375, B:239:0x0379, B:240:0x037b, B:236:0x0371] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:260:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:266:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:268:0x03da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:270:0x03de  */
    /* JADX WARN: Code duplicated, block: B:273:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:278:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:281:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:284:0x0400  */
    /* JADX WARN: Code duplicated, block: B:286:0x0407  */
    /* JADX WARN: Code duplicated, block: B:289:0x0423  */
    /* JADX WARN: Code duplicated, block: B:308:0x046a  */
    /* JADX WARN: Code duplicated, block: B:324:0x050f  */
    /* JADX WARN: Code duplicated, block: B:340:0x0560  */
    /* JADX WARN: Code duplicated, block: B:343:0x0570  */
    /* JADX WARN: Code duplicated, block: B:345:0x0573  */
    /* JADX WARN: Code duplicated, block: B:382:0x0628  */
    /* JADX WARN: Code duplicated, block: B:384:0x062e  */
    /* JADX WARN: Code duplicated, block: B:386:0x0635  */
    /* JADX WARN: Code duplicated, block: B:387:0x063e  */
    /* JADX WARN: Code duplicated, block: B:391:0x0666  */
    /* JADX WARN: Code duplicated, block: B:91:0x0169  */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r12 != 3) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(defpackage.oe0 r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ch.b(oe0, boolean):void");
    }

    public boolean c() {
        return this.j0 != 8;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0179  */
    /* JADX WARN: Code duplicated, block: B:192:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:215:0x033c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:218:0x0345  */
    /* JADX WARN: Code duplicated, block: B:220:0x0349  */
    /* JADX WARN: Code duplicated, block: B:221:0x034b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:227:0x035d  */
    /* JADX WARN: Code duplicated, block: B:229:0x0382  */
    /* JADX WARN: Code duplicated, block: B:232:0x0391  */
    /* JADX WARN: Code duplicated, block: B:238:0x039f  */
    /* JADX WARN: Code duplicated, block: B:239:0x03a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:248:0x03c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:255:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:257:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:258:0x03da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:261:0x03e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:266:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:268:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:271:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:273:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:275:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:276:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:279:0x0405  */
    /* JADX WARN: Code duplicated, block: B:281:0x040b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:285:0x0413 A[PHI: r3
      0x0413: PHI (r3v17 int) = (r3v16 int), (r3v21 int), (r3v21 int), (r3v21 int) binds: [B:278:0x0403, B:280:0x0409, B:281:0x040b, B:283:0x040f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:288:0x0425 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:289:0x0427  */
    /* JADX WARN: Code duplicated, block: B:290:0x042c  */
    /* JADX WARN: Code duplicated, block: B:292:0x042f  */
    /* JADX WARN: Code duplicated, block: B:294:0x0435 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:301:0x0446  */
    /* JADX WARN: Code duplicated, block: B:31:0x0078  */
    /* JADX WARN: Code duplicated, block: B:335:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x0094  */
    /* JADX WARN: Code duplicated, block: B:42:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x009b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:79:0x0101 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:84:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0110 A[PHI: r4 r5 r13 r15
      0x0110: PHI (r4v7 int) = (r4v1 int), (r4v0 int) binds: [B:84:0x010e, B:47:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x0110: PHI (r5v3 int) = (r5v1 int), (r5v0 int) binds: [B:84:0x010e, B:47:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x0110: PHI (r13v18 int) = (r13v9 int), (r13v8 int) binds: [B:84:0x010e, B:47:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x0110: PHI (r15v13 int) = (r15v8 int), (r15v5 int) binds: [B:84:0x010e, B:47:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0114  */
    /* JADX WARN: Code duplicated, block: B:87:0x011c  */
    /* JADX WARN: Code duplicated, block: B:89:0x011f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0127 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:94:0x013f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0171  */
    public final void d(oe0 oe0Var, boolean z, boolean z2, boolean z3, boolean z4, q11 q11Var, q11 q11Var2, int i, boolean z5, vg vgVar, vg vgVar2, int i2, int i3, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f2, boolean z11) {
        boolean z12;
        int i10;
        int i11;
        int i12;
        int iMin;
        int i13;
        int i14;
        boolean z13;
        vg.a aVar;
        vg.a aVar2;
        vg.a aVar3;
        q11 q11VarL;
        vg vgVarG;
        vg vgVar3;
        q11 q11Var3;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i15;
        int i16;
        int i17;
        boolean z18;
        boolean z19;
        ch chVar;
        boolean z20;
        int iMin2;
        boolean z21;
        int i18;
        int iD;
        int i19;
        int i20;
        HashSet hashSet;
        boolean z22;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        boolean z23;
        int i29;
        boolean z24;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        oe0Var = oe0Var;
        int i36 = i8;
        int i37 = i9;
        q11 q11VarL2 = oe0Var.l(vgVar);
        q11 q11VarL3 = oe0Var.l(vgVar2);
        q11 q11VarL4 = oe0Var.l(vgVar.f);
        q11 q11VarL5 = oe0Var.l(vgVar2.f);
        boolean zF = vgVar.f();
        boolean zF2 = vgVar2.f();
        boolean zF3 = this.R.f();
        int i38 = zF2 ? (zF ? 1 : 0) + 1 : zF ? 1 : 0;
        if (zF3) {
            i38++;
        }
        int i39 = i38;
        int i40 = z6 ? 3 : i6;
        if (i == 0) {
            throw null;
        }
        int i41 = i - 1;
        if (i41 != 0 && i41 != 1 && i41 == 2) {
            z12 = i40 != 4;
            i10 = this.i;
            if (i10 != -1 && z) {
                this.i = -1;
                i3 = i10;
                z12 = false;
            }
            i11 = this.j;
            if (i11 != -1 || z) {
                i11 = i3;
            } else {
                this.j = -1;
                z12 = false;
            }
            i12 = i11;
            if (this.j0 == 8) {
                z12 = false;
                iMin = 0;
            } else {
                iMin = i12;
            }
            if (!z11) {
                if (zF && !zF2 && !zF3) {
                    oe0Var.d(q11VarL2, i2);
                } else if (zF && !zF2) {
                    i13 = 8;
                    oe0Var.e(q11VarL2, q11VarL4, vgVar.d(), 8);
                }
                i13 = 8;
            } else {
                i13 = 8;
            }
            if (z12 == 0) {
                if (z5) {
                    oe0Var.e(q11VarL3, q11VarL2, 0, 3);
                    if (i4 > 0) {
                        oe0Var.f(q11VarL3, q11VarL2, i4, i13);
                    }
                    if (i5 < Integer.MAX_VALUE) {
                        oe0Var.g(q11VarL3, q11VarL2, i5, i13);
                    }
                } else {
                    oe0Var.e(q11VarL3, q11VarL2, iMin, i13);
                }
                z13 = z4;
                i14 = i36;
            } else if (i39 == 2 && !z6 && (i40 == 1 || i40 == 0)) {
                int iMax = Math.max(i36, iMin);
                if (i37 > 0) {
                    iMax = Math.min(i37, iMax);
                }
                oe0Var.e(q11VarL3, q11VarL2, iMax, 8);
                z13 = z4;
                i14 = i36;
                z12 = false;
            } else {
                if (i36 == -2) {
                    i36 = iMin;
                }
                if (i37 == -2) {
                    i37 = iMin;
                }
                if (iMin > 0 && i40 != 1) {
                    iMin = 0;
                }
                i13 = 8;
                if (i36 > 0) {
                    oe0Var.f(q11VarL3, q11VarL2, i36, 8);
                    iMin = Math.max(iMin, i36);
                }
                if (i37 > 0) {
                    if (z2 || i40 != 1) {
                        oe0Var.g(q11VarL3, q11VarL2, i37, 8);
                    }
                    iMin = Math.min(iMin, i37);
                }
                if (i40 == 1) {
                    if (z2) {
                        oe0Var.e(q11VarL3, q11VarL2, iMin, i13);
                    } else {
                        oe0Var.e(q11VarL3, q11VarL2, iMin, 5);
                        oe0Var.g(q11VarL3, q11VarL2, iMin, 8);
                    }
                } else if (i40 == 2) {
                    aVar = vg.a.c;
                    aVar2 = vg.a.f;
                    aVar3 = vgVar.e;
                    if (aVar3 != aVar || aVar3 == aVar2) {
                        q11VarL = oe0Var.l(this.W.g(aVar));
                        vgVarG = this.W.g(aVar2);
                    } else {
                        q11VarL = oe0Var.l(this.W.g(vg.a.b));
                        vgVarG = this.W.g(vg.a.d);
                    }
                    q11 q11VarL6 = oe0Var.l(vgVarG);
                    e7 e7VarM = oe0Var.m();
                    b7 b7Var = e7VarM.d;
                    int i42 = i36;
                    b7Var.k(q11VarL3, -1.0f);
                    b7Var.k(q11VarL2, 1.0f);
                    b7Var.k(q11VarL6, f2);
                    b7Var.k(q11VarL, -f2);
                    oe0Var.c(e7VarM);
                    if (z2) {
                        z12 = false;
                    }
                    i36 = i42;
                } else {
                    i14 = i36;
                    z13 = true;
                }
                z13 = z4;
                i14 = i36;
            }
            if (z11 || z8) {
                boolean z25 = z13;
                if (i39 >= 2 && z2 && z25) {
                    oe0Var.f(q11VarL2, q11Var, 0, 8);
                    vg vgVar4 = this.O;
                    boolean z26 = z || vgVar4.f == null;
                    if (!z && (vgVar3 = vgVar4.f) != null) {
                        ch chVar2 = vgVar3.d;
                        if (chVar2.Z != 0.0f) {
                            int[] iArr = chVar2.V;
                            if (iArr[0] == 3 && iArr[1] == 3) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                        } else {
                            z26 = false;
                        }
                    }
                    if (z26) {
                        oe0Var.f(q11Var2, q11VarL3, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (zF || zF2 || zF3) {
                if (zF && !zF2) {
                    vgVar2 = vgVar2;
                    q11VarL3 = q11VarL3;
                    z13 = z13;
                    q11Var3 = q11VarL5;
                    z20 = z2;
                    i35 = (z2 && (vgVar.f.d instanceof h8)) ? 8 : 5;
                } else if (zF || !zF2) {
                    q11Var3 = q11VarL5;
                    if (zF && zF2) {
                        ch chVar3 = vgVar.f.d;
                        ch chVar4 = vgVar2.f.d;
                        z13 = z13;
                        dh dhVar = this.W;
                        int i43 = 6;
                        if (z12) {
                            if (i40 == 0) {
                                if (i37 != 0 || i14 != 0) {
                                    i28 = 5;
                                    i34 = 5;
                                    z24 = false;
                                    z16 = true;
                                    z17 = true;
                                } else if (q11VarL4.i && q11Var3.i) {
                                    oe0Var.e(q11VarL2, q11VarL4, vgVar.d(), 8);
                                    oe0Var.e(q11VarL3, q11Var3, -vgVar2.d(), 8);
                                    return;
                                } else {
                                    i28 = 8;
                                    i34 = 8;
                                    z24 = true;
                                    z16 = false;
                                    z17 = false;
                                }
                                if ((chVar3 instanceof h8) || (chVar4 instanceof h8)) {
                                    int i44 = i34;
                                    i40 = i40;
                                    i27 = i44;
                                    i28 = 4;
                                } else {
                                    int i45 = i34;
                                    i40 = i40;
                                    i27 = i45;
                                }
                            } else {
                                if (i40 == 2) {
                                    if ((chVar3 instanceof h8) || (chVar4 instanceof h8)) {
                                        i31 = 5;
                                    } else {
                                        i33 = 5;
                                        i32 = 5;
                                    }
                                    i40 = i40;
                                    i27 = i32;
                                    i28 = i33;
                                    z23 = false;
                                    z24 = z23;
                                    z16 = true;
                                    z17 = true;
                                } else {
                                    if (i40 == 1) {
                                        i31 = 8;
                                    } else if (i40 == 3) {
                                        i40 = i40;
                                        if (this.B == -1) {
                                            if (z9) {
                                                i30 = z2 ? 5 : 4;
                                            } else {
                                                i30 = 8;
                                            }
                                            i25 = i30;
                                            i22 = 8;
                                        } else if (z6) {
                                            if (i7 == 2 || i7 == 1) {
                                                i26 = 4;
                                                i27 = 5;
                                            } else {
                                                i26 = 5;
                                                i27 = 8;
                                            }
                                            i28 = i26;
                                            z23 = true;
                                            z24 = z23;
                                            z16 = true;
                                            z17 = true;
                                        } else {
                                            if (i37 > 0) {
                                                i25 = 6;
                                                i22 = 5;
                                            } else if (i37 != 0 || i14 != 0) {
                                                i22 = 5;
                                                i23 = 6;
                                                i24 = 4;
                                            } else if (z9) {
                                                if (chVar3 == dhVar || chVar4 == dhVar) {
                                                    i22 = 5;
                                                } else {
                                                    i22 = 4;
                                                }
                                                i23 = 6;
                                                i24 = 4;
                                            } else {
                                                i23 = 6;
                                                i22 = 5;
                                                i24 = 8;
                                            }
                                            int i46 = i24;
                                            i27 = i22;
                                            i29 = i46;
                                            z24 = true;
                                            z16 = true;
                                            z17 = true;
                                        }
                                        i23 = i25;
                                        i24 = 5;
                                        int i47 = i24;
                                        i27 = i22;
                                        i29 = i47;
                                        z24 = true;
                                        z16 = true;
                                        z17 = true;
                                    } else {
                                        z14 = false;
                                        z15 = false;
                                    }
                                    i15 = i23;
                                    q11VarL4 = q11VarL4;
                                    q11VarL2 = q11VarL2;
                                    q11VarL3 = q11VarL3;
                                    z18 = z24;
                                    i17 = i29;
                                    i16 = i27;
                                    oe0Var = oe0Var;
                                    q11Var2 = q11Var2;
                                    if (z17 || q11VarL4 != q11Var3 || chVar3 == dhVar) {
                                        z19 = true;
                                    } else {
                                        z17 = false;
                                        z19 = false;
                                    }
                                    if (z16) {
                                        if (z12 && !z7 && !z9 && q11VarL4 == q11Var && q11Var3 == q11Var2) {
                                            i15 = 8;
                                            z20 = false;
                                            i21 = 8;
                                            z22 = false;
                                        } else {
                                            z20 = z2;
                                            z22 = z19;
                                            i21 = i16;
                                        }
                                        q11 q11Var4 = q11VarL4;
                                        chVar = chVar4;
                                        oe0Var.b(q11VarL2, q11Var4, vgVar.d(), f, q11Var3, q11VarL3, vgVar2.d(), i15);
                                        q11VarL4 = q11Var4;
                                        i16 = i21;
                                        z19 = z22;
                                    } else {
                                        chVar = chVar4;
                                        z20 = z2;
                                    }
                                    if (this.j0 != 8 && ((hashSet = vgVar2.a) == null || hashSet.size() <= 0)) {
                                        return;
                                    }
                                    if (z17) {
                                        if (z20 && q11VarL4 != q11Var3 && !z12 && ((chVar3 instanceof h8) || (chVar instanceof h8))) {
                                            i16 = 6;
                                        }
                                        oe0Var.f(q11VarL2, q11VarL4, vgVar.d(), i16);
                                        oe0Var.g(q11VarL3, q11Var3, -vgVar2.d(), i16);
                                    }
                                    if (z20 || !z10 || (chVar3 instanceof h8) || (chVar instanceof h8) || chVar == dhVar) {
                                        iMin2 = i17;
                                        z21 = z19;
                                    } else {
                                        iMin2 = 6;
                                        i16 = 6;
                                        z21 = true;
                                    }
                                    if (z21) {
                                        if (z18 && (!z9 || z3)) {
                                            if (chVar3 != dhVar && chVar != dhVar) {
                                                i43 = iMin2;
                                            }
                                            if ((chVar3 instanceof py) || (chVar instanceof py)) {
                                                i43 = 5;
                                            }
                                            if ((chVar3 instanceof h8) || (chVar instanceof h8)) {
                                                i43 = 5;
                                            }
                                            if (z9) {
                                                i20 = 5;
                                            } else {
                                                i20 = i43;
                                            }
                                            iMin2 = Math.max(i20, iMin2);
                                        }
                                        if (z20) {
                                            iMin2 = Math.min(i16, iMin2);
                                            if (z6 || z9 || !(chVar3 == dhVar || chVar == dhVar)) {
                                                i19 = iMin2;
                                            } else {
                                                i19 = 4;
                                            }
                                        } else {
                                            i19 = iMin2;
                                        }
                                        oe0Var.e(q11VarL2, q11VarL4, vgVar.d(), i19);
                                        oe0Var.e(q11VarL3, q11Var3, -vgVar2.d(), i19);
                                    }
                                    if (z20) {
                                        if (q11Var == q11VarL4) {
                                            iD = vgVar.d();
                                        } else {
                                            iD = 0;
                                        }
                                        if (q11VarL4 != q11Var) {
                                            oe0Var.f(q11VarL2, q11Var, iD, 5);
                                        }
                                    }
                                    if (z20 || !z12 || i4 != 0 || i14 != 0) {
                                        i18 = 5;
                                    } else if (z12 && i40 == 3) {
                                        oe0Var.f(q11VarL3, q11VarL2, 0, 8);
                                        i18 = 5;
                                    } else {
                                        i18 = 5;
                                        oe0Var.f(q11VarL3, q11VarL2, 0, 5);
                                    }
                                }
                                i32 = i31;
                                i33 = 4;
                                i40 = i40;
                                i27 = i32;
                                i28 = i33;
                                z23 = false;
                                z24 = z23;
                                z16 = true;
                                z17 = true;
                            }
                            i29 = i28;
                            i23 = 6;
                            i15 = i23;
                            q11VarL4 = q11VarL4;
                            q11VarL2 = q11VarL2;
                            q11VarL3 = q11VarL3;
                            z18 = z24;
                            i17 = i29;
                            i16 = i27;
                            oe0Var = oe0Var;
                            q11Var2 = q11Var2;
                            if (z17) {
                                z19 = true;
                            } else {
                                z19 = true;
                            }
                            if (z16) {
                                if (z12) {
                                    z20 = z2;
                                    z22 = z19;
                                    i21 = i16;
                                } else {
                                    z20 = z2;
                                    z22 = z19;
                                    i21 = i16;
                                }
                                q11 q11Var5 = q11VarL4;
                                chVar = chVar4;
                                oe0Var.b(q11VarL2, q11Var5, vgVar.d(), f, q11Var3, q11VarL3, vgVar2.d(), i15);
                                q11VarL4 = q11Var5;
                                i16 = i21;
                                z19 = z22;
                            } else {
                                chVar = chVar4;
                                z20 = z2;
                            }
                            if (this.j0 != 8) {
                            }
                            if (z17) {
                                if (z20) {
                                    i16 = 6;
                                }
                                oe0Var.f(q11VarL2, q11VarL4, vgVar.d(), i16);
                                oe0Var.g(q11VarL3, q11Var3, -vgVar2.d(), i16);
                            }
                            if (z20) {
                                iMin2 = i17;
                                z21 = z19;
                            } else {
                                iMin2 = i17;
                                z21 = z19;
                            }
                            if (z21) {
                                if (z18) {
                                    if (chVar3 != dhVar) {
                                        i43 = iMin2;
                                    }
                                    if (chVar3 instanceof py) {
                                        i43 = 5;
                                    } else {
                                        i43 = 5;
                                    }
                                    if (chVar3 instanceof h8) {
                                        i43 = 5;
                                    } else {
                                        i43 = 5;
                                    }
                                    if (z9) {
                                        i20 = 5;
                                    } else {
                                        i20 = i43;
                                    }
                                    iMin2 = Math.max(i20, iMin2);
                                }
                                if (z20) {
                                    iMin2 = Math.min(i16, iMin2);
                                    if (z6) {
                                        i19 = iMin2;
                                    } else {
                                        i19 = iMin2;
                                    }
                                } else {
                                    i19 = iMin2;
                                }
                                oe0Var.e(q11VarL2, q11VarL4, vgVar.d(), i19);
                                oe0Var.e(q11VarL3, q11Var3, -vgVar2.d(), i19);
                            }
                            if (z20) {
                                if (q11Var == q11VarL4) {
                                    iD = vgVar.d();
                                } else {
                                    iD = 0;
                                }
                                if (q11VarL4 != q11Var) {
                                    oe0Var.f(q11VarL2, q11Var, iD, 5);
                                }
                            }
                            if (z20) {
                                i18 = 5;
                            } else {
                                i18 = 5;
                            }
                        } else {
                            if (q11VarL4.i && q11Var3.i) {
                                oe0Var.b(q11VarL2, q11VarL4, vgVar.d(), f, q11Var3, q11VarL3, vgVar2.d(), 8);
                                if (z2 && z13) {
                                    int iD2 = vgVar2.f != null ? vgVar2.d() : 0;
                                    if (q11Var3 != q11Var2) {
                                        oe0Var.f(q11Var2, q11VarL3, iD2, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            z14 = true;
                            z15 = true;
                        }
                        z16 = z14;
                        z17 = z15;
                        i15 = 6;
                        i16 = 5;
                        i17 = 4;
                        z18 = false;
                        if (z17) {
                            z19 = true;
                        } else {
                            z19 = true;
                        }
                        if (z16) {
                            if (z12) {
                                z20 = z2;
                                z22 = z19;
                                i21 = i16;
                            } else {
                                z20 = z2;
                                z22 = z19;
                                i21 = i16;
                            }
                            q11 q11Var6 = q11VarL4;
                            chVar = chVar4;
                            oe0Var.b(q11VarL2, q11Var6, vgVar.d(), f, q11Var3, q11VarL3, vgVar2.d(), i15);
                            q11VarL4 = q11Var6;
                            i16 = i21;
                            z19 = z22;
                        } else {
                            chVar = chVar4;
                            z20 = z2;
                        }
                        if (this.j0 != 8) {
                        }
                        if (z17) {
                            if (z20) {
                                i16 = 6;
                            }
                            oe0Var.f(q11VarL2, q11VarL4, vgVar.d(), i16);
                            oe0Var.g(q11VarL3, q11Var3, -vgVar2.d(), i16);
                        }
                        if (z20) {
                            iMin2 = i17;
                            z21 = z19;
                        } else {
                            iMin2 = i17;
                            z21 = z19;
                        }
                        if (z21) {
                            if (z18) {
                                if (chVar3 != dhVar) {
                                    i43 = iMin2;
                                }
                                if (chVar3 instanceof py) {
                                    i43 = 5;
                                } else {
                                    i43 = 5;
                                }
                                if (chVar3 instanceof h8) {
                                    i43 = 5;
                                } else {
                                    i43 = 5;
                                }
                                if (z9) {
                                    i20 = 5;
                                } else {
                                    i20 = i43;
                                }
                                iMin2 = Math.max(i20, iMin2);
                            }
                            if (z20) {
                                iMin2 = Math.min(i16, iMin2);
                                if (z6) {
                                    i19 = iMin2;
                                } else {
                                    i19 = iMin2;
                                }
                            } else {
                                i19 = iMin2;
                            }
                            oe0Var.e(q11VarL2, q11VarL4, vgVar.d(), i19);
                            oe0Var.e(q11VarL3, q11Var3, -vgVar2.d(), i19);
                        }
                        if (z20) {
                            if (q11Var == q11VarL4) {
                                iD = vgVar.d();
                            } else {
                                iD = 0;
                            }
                            if (q11VarL4 != q11Var) {
                                oe0Var.f(q11VarL2, q11Var, iD, 5);
                            }
                        }
                        if (z20) {
                            i18 = 5;
                        } else {
                            i18 = 5;
                        }
                    }
                    i35 = i18;
                } else {
                    q11Var3 = q11VarL5;
                    oe0Var.e(q11VarL3, q11Var3, -vgVar2.d(), 8);
                    if (z2) {
                        oe0Var.f(q11VarL2, q11Var, 0, 5);
                        vgVar2 = vgVar2;
                        i18 = 5;
                        q11VarL3 = q11VarL3;
                        z13 = z13;
                    }
                    z20 = z2;
                    i35 = i18;
                }
                if (z20 || !z13) {
                    return;
                }
                int iD3 = vgVar2.f != null ? vgVar2.d() : 0;
                if (q11Var3 != q11Var2) {
                    oe0Var.f(q11Var2, q11VarL3, iD3, i35);
                    return;
                }
                return;
            }
            q11Var3 = q11VarL5;
            i18 = 5;
            z20 = z2;
            i35 = i18;
            if (z20) {
                return;
            } else {
                return;
            }
        }
        i10 = this.i;
        if (i10 != -1) {
            this.i = -1;
            i3 = i10;
            z12 = false;
        }
        i11 = this.j;
        if (i11 != -1) {
            i11 = i3;
        } else {
            i11 = i3;
        }
        i12 = i11;
        if (this.j0 == 8) {
            z12 = false;
            iMin = 0;
        } else {
            iMin = i12;
        }
        if (!z11) {
            i13 = 8;
        } else if (zF) {
            if (zF) {
                i13 = 8;
            } else {
                i13 = 8;
            }
        } else if (zF) {
            i13 = 8;
        } else {
            i13 = 8;
        }
        if (z12 == 0) {
            if (z5) {
                oe0Var.e(q11VarL3, q11VarL2, 0, 3);
                if (i4 > 0) {
                    oe0Var.f(q11VarL3, q11VarL2, i4, i13);
                }
                if (i5 < Integer.MAX_VALUE) {
                    oe0Var.g(q11VarL3, q11VarL2, i5, i13);
                }
            } else {
                oe0Var.e(q11VarL3, q11VarL2, iMin, i13);
            }
            z13 = z4;
            i14 = i36;
        } else if (i39 == 2) {
            if (i36 == -2) {
                i36 = iMin;
            }
            if (i37 == -2) {
                i37 = iMin;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            i13 = 8;
            if (i36 > 0) {
                oe0Var.f(q11VarL3, q11VarL2, i36, 8);
                iMin = Math.max(iMin, i36);
            }
            if (i37 > 0) {
                if (z2) {
                    oe0Var.g(q11VarL3, q11VarL2, i37, 8);
                } else {
                    oe0Var.g(q11VarL3, q11VarL2, i37, 8);
                }
                iMin = Math.min(iMin, i37);
            }
            if (i40 == 1) {
                if (z2) {
                    oe0Var.e(q11VarL3, q11VarL2, iMin, i13);
                } else {
                    oe0Var.e(q11VarL3, q11VarL2, iMin, 5);
                    oe0Var.g(q11VarL3, q11VarL2, iMin, 8);
                }
            } else if (i40 == 2) {
                aVar = vg.a.c;
                aVar2 = vg.a.f;
                aVar3 = vgVar.e;
                if (aVar3 != aVar) {
                    q11VarL = oe0Var.l(this.W.g(aVar));
                    vgVarG = this.W.g(aVar2);
                } else {
                    q11VarL = oe0Var.l(this.W.g(aVar));
                    vgVarG = this.W.g(aVar2);
                }
                q11 q11VarL7 = oe0Var.l(vgVarG);
                e7 e7VarM2 = oe0Var.m();
                b7 b7Var2 = e7VarM2.d;
                int i48 = i36;
                b7Var2.k(q11VarL3, -1.0f);
                b7Var2.k(q11VarL2, 1.0f);
                b7Var2.k(q11VarL7, f2);
                b7Var2.k(q11VarL, -f2);
                oe0Var.c(e7VarM2);
                if (z2) {
                    z12 = false;
                }
                i36 = i48;
            } else {
                i14 = i36;
                z13 = true;
            }
            z13 = z4;
            i14 = i36;
        } else {
            if (i36 == -2) {
                i36 = iMin;
            }
            if (i37 == -2) {
                i37 = iMin;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            i13 = 8;
            if (i36 > 0) {
                oe0Var.f(q11VarL3, q11VarL2, i36, 8);
                iMin = Math.max(iMin, i36);
            }
            if (i37 > 0) {
                if (z2) {
                    oe0Var.g(q11VarL3, q11VarL2, i37, 8);
                } else {
                    oe0Var.g(q11VarL3, q11VarL2, i37, 8);
                }
                iMin = Math.min(iMin, i37);
            }
            if (i40 == 1) {
                if (z2) {
                    oe0Var.e(q11VarL3, q11VarL2, iMin, i13);
                } else {
                    oe0Var.e(q11VarL3, q11VarL2, iMin, 5);
                    oe0Var.g(q11VarL3, q11VarL2, iMin, 8);
                }
            } else if (i40 == 2) {
                aVar = vg.a.c;
                aVar2 = vg.a.f;
                aVar3 = vgVar.e;
                if (aVar3 != aVar) {
                    q11VarL = oe0Var.l(this.W.g(aVar));
                    vgVarG = this.W.g(aVar2);
                } else {
                    q11VarL = oe0Var.l(this.W.g(aVar));
                    vgVarG = this.W.g(aVar2);
                }
                q11 q11VarL8 = oe0Var.l(vgVarG);
                e7 e7VarM3 = oe0Var.m();
                b7 b7Var3 = e7VarM3.d;
                int i49 = i36;
                b7Var3.k(q11VarL3, -1.0f);
                b7Var3.k(q11VarL2, 1.0f);
                b7Var3.k(q11VarL8, f2);
                b7Var3.k(q11VarL, -f2);
                oe0Var.c(e7VarM3);
                if (z2) {
                    z12 = false;
                }
                i36 = i49;
            } else {
                i14 = i36;
                z13 = true;
            }
            z13 = z4;
            i14 = i36;
        }
        if (z11) {
        }
        boolean z27 = z13;
        if (i39 >= 2) {
        }
    }

    public final void e(oe0 oe0Var) {
        oe0Var.l(this.K);
        oe0Var.l(this.L);
        oe0Var.l(this.M);
        oe0Var.l(this.N);
        if (this.d0 > 0) {
            oe0Var.l(this.O);
        }
    }

    public final void f() {
        if (this.d == null) {
            g10 g10Var = new g10(this);
            g10Var.h.e = 4;
            g10Var.i.e = 5;
            g10Var.f = 0;
            this.d = g10Var;
        }
        if (this.e == null) {
            this.e = new kd1(this);
        }
    }

    public vg g(vg.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case 5:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final int h(int i) {
        int[] iArr = this.V;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int i() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public final int n() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public final int o() {
        dh dhVar = this.W;
        return dhVar != null ? dhVar.z0 + this.b0 : this.b0;
    }

    public final int p() {
        dh dhVar = this.W;
        return dhVar != null ? dhVar.A0 + this.c0 : this.c0;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x003b A[RETURN] */
    public final boolean q(int i) {
        if (i == 0) {
            if ((this.K.f != null ? 1 : 0) + (this.M.f != null ? 1 : 0) < 2) {
                return true;
            }
            return false;
        }
        if ((this.L.f != null ? 1 : 0) + (this.N.f != null ? 1 : 0) + (this.O.f != null ? 1 : 0) < 2) {
            return true;
        }
        return false;
    }

    public final boolean r(int i, int i2) {
        vg vgVar;
        vg vgVar2;
        vg vgVar3;
        vg vgVar4;
        if (i == 0) {
            vg vgVar5 = this.K;
            vg vgVar6 = vgVar5.f;
            if (vgVar6 == null || !vgVar6.c || (vgVar4 = (vgVar3 = this.M).f) == null || !vgVar4.c) {
                return false;
            }
            return (vgVar4.c() - vgVar3.d()) - (vgVar5.d() + vgVar5.f.c()) >= i2;
        }
        vg vgVar7 = this.L;
        vg vgVar8 = vgVar7.f;
        if (vgVar8 == null || !vgVar8.c || (vgVar2 = (vgVar = this.N).f) == null || !vgVar2.c) {
            return false;
        }
        return (vgVar2.c() - vgVar.d()) - (vgVar7.d() + vgVar7.f.c()) >= i2;
    }

    public final boolean t(int i) {
        vg vgVar;
        vg vgVar2;
        int i2 = i * 2;
        vg[] vgVarArr = this.S;
        vg vgVar3 = vgVarArr[i2];
        vg vgVar4 = vgVar3.f;
        return (vgVar4 == null || vgVar4.f == vgVar3 || (vgVar2 = (vgVar = vgVarArr[i2 + 1]).f) == null || vgVar2.f != vgVar) ? false : true;
    }

    public String toString() {
        String strM = AppConfig.CUSTOM;
        StringBuilder sbD = e.d(AppConfig.CUSTOM);
        if (this.k0 != null) {
            strM = fb$1.m(new StringBuilder("id: "), this.k0, " ");
        }
        sbD.append(strM);
        sbD.append("(");
        sbD.append(this.b0);
        sbD.append(", ");
        sbD.append(this.c0);
        sbD.append(") - (");
        sbD.append(this.X);
        sbD.append(" x ");
        sbD.append(this.Y);
        sbD.append(")");
        return sbD.toString();
    }

    public final boolean u() {
        vg vgVar = this.K;
        vg vgVar2 = vgVar.f;
        if (vgVar2 != null && vgVar2.f == vgVar) {
            return true;
        }
        vg vgVar3 = this.M;
        vg vgVar4 = vgVar3.f;
        return vgVar4 != null && vgVar4.f == vgVar3;
    }

    public final boolean v() {
        vg vgVar = this.L;
        vg vgVar2 = vgVar.f;
        if (vgVar2 != null && vgVar2.f == vgVar) {
            return true;
        }
        vg vgVar3 = this.N;
        vg vgVar4 = vgVar3.f;
        return vgVar4 != null && vgVar4.f == vgVar3;
    }

    public final boolean w() {
        return this.g && this.j0 != 8;
    }

    public boolean x() {
        if (this.l) {
            return true;
        }
        return this.K.c && this.M.c;
    }

    public boolean y() {
        if (this.m) {
            return true;
        }
        return this.L.c && this.N.c;
    }

    public void z() {
        this.K.g();
        this.L.g();
        this.M.g();
        this.N.g();
        this.O.g();
        this.P.g();
        this.Q.g();
        this.R.g();
        this.W = null;
        this.E = 0.0f;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0.5f;
        this.h0 = 0.5f;
        int[] iArr = this.V;
        iArr[0] = 1;
        iArr[1] = 1;
        this.i0 = null;
        this.j0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        float[] fArr = this.n0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.p = -1;
        this.q = -1;
        int[] iArr2 = this.D;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.s = 0;
        this.t = 0;
        this.x = 1.0f;
        this.A = 1.0f;
        this.w = Integer.MAX_VALUE;
        this.z = Integer.MAX_VALUE;
        this.v = 0;
        this.y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.u;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.i = -1;
        this.j = -1;
    }
}
