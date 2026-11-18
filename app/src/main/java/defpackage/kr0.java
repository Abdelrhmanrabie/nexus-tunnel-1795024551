package defpackage;

import androidx.recyclerview.widget.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kr0 extends yx.c {
    public static final kr0 x;
    public static final ar0.a y = new ar0.a(8);
    public final fa c;
    public int d;
    public int f;
    public int g;
    public int i;
    public nr0 j;
    public int n;
    public List o;
    public nr0 p;
    public int q;
    public rr0 r;
    public int s;
    public int t;
    public List u;
    public byte v;
    public int w;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g = 518;
        public int i = 2054;
        public int j;
        public nr0 n;
        public int o;
        public List p;
        public nr0 q;
        public int r;
        public rr0 s;
        public int t;
        public int u;
        public List v;

        public b() {
            nr0 nr0Var = nr0.z;
            this.n = nr0Var;
            List list = Collections.EMPTY_LIST;
            this.p = list;
            this.q = nr0Var;
            this.s = rr0.r;
            this.v = list;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            kr0 kr0Var;
            try {
                try {
                    kr0.y.getClass();
                    h(new kr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    kr0Var = (kr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (kr0Var != null) {
                            h(kr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                kr0Var = null;
                if (kr0Var != null) {
                    h(kr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            kr0 kr0VarG = g();
            if (kr0VarG.isInitialized()) {
                return kr0VarG;
            }
            throw new we();
        }

        public final Object clone() {
            b bVar = new b();
            bVar.h(g());
            return bVar;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            h((kr0) yxVar);
            return this;
        }

        public final kr0 g() {
            kr0 kr0Var = new kr0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            kr0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            kr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            kr0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            kr0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            kr0Var.n = this.o;
            if ((i & 32) == 32) {
                this.p = Collections.unmodifiableList(this.p);
                this.f &= -33;
            }
            kr0Var.o = this.p;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            kr0Var.p = this.q;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            kr0Var.q = this.r;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            kr0Var.r = this.s;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            kr0Var.s = this.t;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            kr0Var.t = this.u;
            if ((this.f & 2048) == 2048) {
                this.v = Collections.unmodifiableList(this.v);
                this.f &= -2049;
            }
            kr0Var.u = this.v;
            kr0Var.d = i2;
            return kr0Var;
        }

        public final void h(kr0 kr0Var) {
            rr0 rr0Var;
            nr0 nr0Var;
            nr0 nr0Var2;
            if (kr0Var == kr0.x) {
                return;
            }
            int i = kr0Var.d;
            if ((i & 1) == 1) {
                int i2 = kr0Var.f;
                this.f |= 1;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = kr0Var.g;
                this.f = 2 | this.f;
                this.i = i3;
            }
            if ((i & 4) == 4) {
                int i4 = kr0Var.i;
                this.f = 4 | this.f;
                this.j = i4;
            }
            if ((i & 8) == 8) {
                nr0 nr0VarG = kr0Var.j;
                if ((this.f & 8) == 8 && (nr0Var2 = this.n) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var2);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.n = nr0VarG;
                this.f |= 8;
            }
            if ((kr0Var.d & 16) == 16) {
                int i5 = kr0Var.n;
                this.f = 16 | this.f;
                this.o = i5;
            }
            if (!kr0Var.o.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = kr0Var.o;
                    this.f &= -33;
                } else {
                    if ((this.f & 32) != 32) {
                        this.p = new ArrayList(this.p);
                        this.f |= 32;
                    }
                    this.p.addAll(kr0Var.o);
                }
            }
            if ((kr0Var.d & 32) == 32) {
                nr0 nr0VarG2 = kr0Var.p;
                if ((this.f & 64) == 64 && (nr0Var = this.q) != nr0.z) {
                    nr0.c cVarO2 = nr0.o(nr0Var);
                    cVarO2.h(nr0VarG2);
                    nr0VarG2 = cVarO2.g();
                }
                this.q = nr0VarG2;
                this.f |= 64;
            }
            int i6 = kr0Var.d;
            if ((i6 & 64) == 64) {
                int i7 = kr0Var.q;
                this.f |= 128;
                this.r = i7;
            }
            if ((i6 & 128) == 128) {
                rr0 rr0VarG = kr0Var.r;
                if ((this.f & 256) == 256 && (rr0Var = this.s) != rr0.r) {
                    rr0.b bVar = new rr0.b();
                    bVar.h(rr0Var);
                    bVar.h(rr0VarG);
                    rr0VarG = bVar.g();
                }
                this.s = rr0VarG;
                this.f |= 256;
            }
            int i8 = kr0Var.d;
            if ((i8 & 256) == 256) {
                int i9 = kr0Var.s;
                this.f |= 512;
                this.t = i9;
            }
            if ((i8 & 512) == 512) {
                int i10 = kr0Var.t;
                this.f |= 1024;
                this.u = i10;
            }
            if (!kr0Var.u.isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = kr0Var.u;
                    this.f &= -2049;
                } else {
                    if ((this.f & 2048) != 2048) {
                        this.v = new ArrayList(this.v);
                        this.f |= 2048;
                    }
                    this.v.addAll(kr0Var.u);
                }
            }
            f(kr0Var);
            this.b = this.b.d(kr0Var.c);
        }
    }

    static {
        kr0 kr0Var = new kr0();
        x = kr0Var;
        kr0Var.m();
    }

    public kr0() {
        this.v = (byte) -1;
        this.w = -1;
        this.c = fa.b;
    }

    public kr0(b bVar) {
        super(bVar);
        this.v = (byte) -1;
        this.w = -1;
        this.c = bVar.b;
    }

    public kr0(xd xdVar, ps psVar) {
        int i;
        List list;
        Object objG;
        this.v = (byte) -1;
        this.w = -1;
        m();
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    nr0.c cVarO = null;
                    rr0.b bVar2 = null;
                    nr0.c cVarO2 = null;
                    switch (iN) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.d |= 2;
                            this.g = xdVar.k();
                            break;
                        case 16:
                            this.d |= 4;
                            this.i = xdVar.k();
                            break;
                        case 26:
                            i = 8;
                            if ((this.d & 8) == 8) {
                                nr0 nr0Var = this.j;
                                nr0Var.getClass();
                                cVarO = nr0.o(nr0Var);
                            }
                            nr0 nr0Var2 = (nr0) xdVar.g(nr0.A, psVar);
                            this.j = nr0Var2;
                            if (cVarO != null) {
                                cVarO.h(nr0Var2);
                                this.j = cVarO.g();
                            }
                            this.d |= i;
                            break;
                        case 34:
                            int i3 = (i2 == true ? 1 : 0) & 32;
                            int i4 = i2;
                            if (i3 != 32) {
                                this.o = new ArrayList();
                                i4 = (i2 == true ? 1 : 0) | 32;
                            }
                            list = this.o;
                            i2 = i4;
                            objG = xdVar.g(pr0.t, psVar);
                            list.add(objG);
                            break;
                        case 42:
                            if ((this.d & 32) == 32) {
                                nr0 nr0Var3 = this.p;
                                nr0Var3.getClass();
                                cVarO2 = nr0.o(nr0Var3);
                            }
                            nr0 nr0Var4 = (nr0) xdVar.g(nr0.A, psVar);
                            this.p = nr0Var4;
                            if (cVarO2 != null) {
                                cVarO2.h(nr0Var4);
                                this.p = cVarO2.g();
                            }
                            this.d |= 32;
                            break;
                        case 50:
                            i = 128;
                            if ((this.d & 128) == 128) {
                                rr0 rr0Var = this.r;
                                rr0Var.getClass();
                                bVar2 = new rr0.b();
                                bVar2.h(rr0Var);
                            }
                            rr0 rr0Var2 = (rr0) xdVar.g(rr0.s, psVar);
                            this.r = rr0Var2;
                            if (bVar2 != null) {
                                bVar2.h(rr0Var2);
                                this.r = bVar2.g();
                            }
                            this.d |= i;
                            break;
                        case 56:
                            this.d |= 256;
                            this.s = xdVar.k();
                            break;
                        case 64:
                            this.d |= 512;
                            this.t = xdVar.k();
                            break;
                        case 72:
                            this.d |= 16;
                            this.n = xdVar.k();
                            break;
                        case 80:
                            this.d |= 64;
                            this.q = xdVar.k();
                            break;
                        case 88:
                            this.d |= 1;
                            this.f = xdVar.k();
                            break;
                        case 248:
                            int i5 = (i2 == true ? 1 : 0) & 2048;
                            int i6 = i2;
                            if (i5 != 2048) {
                                this.u = new ArrayList();
                                i6 = (i2 == true ? 1 : 0) | 2048;
                            }
                            list = this.u;
                            i2 = i6;
                            objG = Integer.valueOf(xdVar.k());
                            list.add(objG);
                            break;
                        case n.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                            int iD = xdVar.d(xdVar.k());
                            int i7 = (i2 == true ? 1 : 0) & 2048;
                            i2 = i2;
                            if (i7 != 2048 && xdVar.b() > 0) {
                                i2 = i2;
                                this.u = new ArrayList();
                                i2 = (i2 == true ? 1 : 0) | 2048;
                            }
                            i2 = i2;
                            while (xdVar.b() > 0) {
                                this.u.add(Integer.valueOf(xdVar.k()));
                            }
                            xdVar.c(iD);
                            break;
                        default:
                            if (!k(xdVar, ydVarJ, psVar, iN)) {
                                z = true;
                            }
                            break;
                    }
                } catch (t30 e) {
                    e.b = this;
                    throw e;
                } catch (IOException e2) {
                    t30 t30Var = new t30(e2.getMessage());
                    t30Var.b = this;
                    throw t30Var;
                }
            } catch (Throwable th) {
                if (((i2 == true ? 1 : 0) & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if (((i2 == true ? 1 : 0) & 2048) == 2048) {
                    this.u = Collections.unmodifiableList(this.u);
                }
                try {
                    ydVarJ.k();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.c = bVar.c();
                    throw th2;
                }
                this.c = bVar.c();
                i$1();
                throw th;
            }
        }
        if (((i2 == true ? 1 : 0) & 32) == 32) {
            this.o = Collections.unmodifiableList(this.o);
        }
        if (((i2 == true ? 1 : 0) & 2048) == 2048) {
            this.u = Collections.unmodifiableList(this.u);
        }
        try {
            ydVarJ.k();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.c = bVar.c();
            throw th3;
        }
        this.c = bVar.c();
        i$1();
    }

    @Override // defpackage.b0
    public final void a(yd ydVar) throws IOException {
        getSerializedSize();
        zl0 zl0Var = new zl0(this);
        if ((this.d & 2) == 2) {
            ydVar.m(1, this.g);
        }
        if ((this.d & 4) == 4) {
            ydVar.m(2, this.i);
        }
        if ((this.d & 8) == 8) {
            ydVar.o(3, this.j);
        }
        for (int i = 0; i < this.o.size(); i++) {
            ydVar.o(4, (b0) this.o.get(i));
        }
        if ((this.d & 32) == 32) {
            ydVar.o(5, this.p);
        }
        if ((this.d & 128) == 128) {
            ydVar.o(6, this.r);
        }
        if ((this.d & 256) == 256) {
            ydVar.m(7, this.s);
        }
        if ((this.d & 512) == 512) {
            ydVar.m(8, this.t);
        }
        if ((this.d & 16) == 16) {
            ydVar.m(9, this.n);
        }
        if ((this.d & 64) == 64) {
            ydVar.m(10, this.q);
        }
        if ((this.d & 1) == 1) {
            ydVar.m(11, this.f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            ydVar.m(31, ((Integer) this.u.get(i2)).intValue());
        }
        zl0Var.a(19000, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return x;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.w;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int iB = (this.d & 2) == 2 ? yd.b(1, this.g) : 0;
        if ((this.d & 4) == 4) {
            iB += yd.b(2, this.i);
        }
        if ((this.d & 8) == 8) {
            iB += yd.d(3, this.j);
        }
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            iB += yd.d(4, (b0) this.o.get(i3));
        }
        if ((this.d & 32) == 32) {
            iB += yd.d(5, this.p);
        }
        if ((this.d & 128) == 128) {
            iB += yd.d(6, this.r);
        }
        if ((this.d & 256) == 256) {
            iB += yd.b(7, this.s);
        }
        if ((this.d & 512) == 512) {
            iB += yd.b(8, this.t);
        }
        if ((this.d & 16) == 16) {
            iB += yd.b(9, this.n);
        }
        if ((this.d & 64) == 64) {
            iB += yd.b(10, this.q);
        }
        if ((this.d & 1) == 1) {
            iB += yd.b(11, this.f);
        }
        int iC = 0;
        while (true) {
            int size = this.u.size();
            List list = this.u;
            if (i2 >= size) {
                int size2 = this.c.size() + f() + (list.size() * 2) + iB + iC;
                this.w = size2;
                return size2;
            }
            iC += yd.c(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.v;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        int i = this.d;
        if ((i & 4) != 4) {
            this.v = (byte) 0;
            return false;
        }
        if ((i & 8) == 8 && !this.j.isInitialized()) {
            this.v = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            if (!((pr0) this.o.get(i2)).isInitialized()) {
                this.v = (byte) 0;
                return false;
            }
        }
        if ((this.d & 32) == 32 && !this.p.isInitialized()) {
            this.v = (byte) 0;
            return false;
        }
        if ((this.d & 128) == 128 && !this.r.isInitialized()) {
            this.v = (byte) 0;
            return false;
        }
        if (e()) {
            this.v = (byte) 1;
            return true;
        }
        this.v = (byte) 0;
        return false;
    }

    public final void m() {
        this.f = 518;
        this.g = 2054;
        this.i = 0;
        nr0 nr0Var = nr0.z;
        this.j = nr0Var;
        this.n = 0;
        List list = Collections.EMPTY_LIST;
        this.o = list;
        this.p = nr0Var;
        this.q = 0;
        this.r = rr0.r;
        this.s = 0;
        this.t = 0;
        this.u = list;
    }

    @Override // defpackage.b0
    public final yx.a newBuilderForType() {
        return new b();
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        b bVar = new b();
        bVar.h(this);
        return bVar;
    }
}
