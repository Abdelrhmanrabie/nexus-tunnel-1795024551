package defpackage;

import androidx.recyclerview.widget.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fr0 extends yx.c {
    public static final fr0 x;
    public static final ar0.a y = new ar0.a(5);
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
    public List r;
    public qr0 s;
    public List t;
    public br0 u;
    public byte v;
    public int w;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g = 6;
        public int i = 6;
        public int j;
        public nr0 n;
        public int o;
        public List p;
        public nr0 q;
        public int r;
        public List s;
        public qr0 t;
        public List u;
        public br0 v;

        public b() {
            nr0 nr0Var = nr0.z;
            this.n = nr0Var;
            List list = Collections.EMPTY_LIST;
            this.p = list;
            this.q = nr0Var;
            this.s = list;
            this.t = qr0.j;
            this.u = list;
            this.v = br0.g;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            fr0 fr0Var;
            try {
                try {
                    fr0.y.getClass();
                    h(new fr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    fr0Var = (fr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (fr0Var != null) {
                            h(fr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fr0Var = null;
                if (fr0Var != null) {
                    h(fr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            fr0 fr0VarG = g();
            if (fr0VarG.isInitialized()) {
                return fr0VarG;
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
            h((fr0) yxVar);
            return this;
        }

        public final fr0 g() {
            fr0 fr0Var = new fr0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            fr0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            fr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            fr0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            fr0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            fr0Var.n = this.o;
            if ((i & 32) == 32) {
                this.p = Collections.unmodifiableList(this.p);
                this.f &= -33;
            }
            fr0Var.o = this.p;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            fr0Var.p = this.q;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            fr0Var.q = this.r;
            if ((this.f & 256) == 256) {
                this.s = Collections.unmodifiableList(this.s);
                this.f &= -257;
            }
            fr0Var.r = this.s;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            fr0Var.s = this.t;
            if ((this.f & 1024) == 1024) {
                this.u = Collections.unmodifiableList(this.u);
                this.f &= -1025;
            }
            fr0Var.t = this.u;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            fr0Var.u = this.v;
            fr0Var.d = i2;
            return fr0Var;
        }

        public final void h(fr0 fr0Var) {
            br0 br0Var;
            qr0 qr0Var;
            nr0 nr0Var;
            nr0 nr0Var2;
            if (fr0Var == fr0.x) {
                return;
            }
            int i = fr0Var.d;
            if ((i & 1) == 1) {
                int i2 = fr0Var.f;
                this.f |= 1;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = fr0Var.g;
                this.f = 2 | this.f;
                this.i = i3;
            }
            if ((i & 4) == 4) {
                int i4 = fr0Var.i;
                this.f = 4 | this.f;
                this.j = i4;
            }
            if ((i & 8) == 8) {
                nr0 nr0VarG = fr0Var.j;
                if ((this.f & 8) == 8 && (nr0Var2 = this.n) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var2);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.n = nr0VarG;
                this.f |= 8;
            }
            if ((fr0Var.d & 16) == 16) {
                int i5 = fr0Var.n;
                this.f = 16 | this.f;
                this.o = i5;
            }
            if (!fr0Var.o.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = fr0Var.o;
                    this.f &= -33;
                } else {
                    if ((this.f & 32) != 32) {
                        this.p = new ArrayList(this.p);
                        this.f |= 32;
                    }
                    this.p.addAll(fr0Var.o);
                }
            }
            if ((fr0Var.d & 32) == 32) {
                nr0 nr0VarG2 = fr0Var.p;
                if ((this.f & 64) == 64 && (nr0Var = this.q) != nr0.z) {
                    nr0.c cVarO2 = nr0.o(nr0Var);
                    cVarO2.h(nr0VarG2);
                    nr0VarG2 = cVarO2.g();
                }
                this.q = nr0VarG2;
                this.f |= 64;
            }
            if ((fr0Var.d & 64) == 64) {
                int i6 = fr0Var.q;
                this.f |= 128;
                this.r = i6;
            }
            if (!fr0Var.r.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = fr0Var.r;
                    this.f &= -257;
                } else {
                    if ((this.f & 256) != 256) {
                        this.s = new ArrayList(this.s);
                        this.f |= 256;
                    }
                    this.s.addAll(fr0Var.r);
                }
            }
            if ((fr0Var.d & 128) == 128) {
                qr0 qr0VarF = fr0Var.s;
                if ((this.f & 512) == 512 && (qr0Var = this.t) != qr0.j) {
                    qr0.b bVarE = qr0.e(qr0Var);
                    bVarE.g(qr0VarF);
                    qr0VarF = bVarE.f();
                }
                this.t = qr0VarF;
                this.f |= 512;
            }
            if (!fr0Var.t.isEmpty()) {
                if (this.u.isEmpty()) {
                    this.u = fr0Var.t;
                    this.f &= -1025;
                } else {
                    if ((this.f & 1024) != 1024) {
                        this.u = new ArrayList(this.u);
                        this.f |= 1024;
                    }
                    this.u.addAll(fr0Var.t);
                }
            }
            if ((fr0Var.d & 256) == 256) {
                br0 br0VarF = fr0Var.u;
                if ((this.f & 2048) == 2048 && (br0Var = this.v) != br0.g) {
                    br0.b bVar = new br0.b(0);
                    bVar.g(br0Var);
                    bVar.g(br0VarF);
                    br0VarF = bVar.f();
                }
                this.v = br0VarF;
                this.f |= 2048;
            }
            f(fr0Var);
            this.b = this.b.d(fr0Var.c);
        }
    }

    static {
        fr0 fr0Var = new fr0();
        x = fr0Var;
        fr0Var.m();
    }

    public fr0() {
        this.v = (byte) -1;
        this.w = -1;
        this.c = fa.b;
    }

    public fr0(b bVar) {
        super(bVar);
        this.v = (byte) -1;
        this.w = -1;
        this.c = bVar.b;
    }

    public fr0(xd xdVar, ps psVar) {
        int i;
        List list;
        ar0.a aVar;
        int i2;
        Object objG;
        this.v = (byte) -1;
        this.w = -1;
        m();
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        int i3 = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iN = xdVar.n();
                        nr0.c cVarO = null;
                        br0.b bVar2 = null;
                        qr0.b bVarE = null;
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
                                int i4 = (i3 == true ? 1 : 0) & 32;
                                int i5 = i3;
                                if (i4 != 32) {
                                    this.o = new ArrayList();
                                    i5 = (i3 == true ? 1 : 0) | 32;
                                }
                                list = this.o;
                                aVar = pr0.t;
                                i2 = i5;
                                i3 = i2;
                                objG = xdVar.g(aVar, psVar);
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
                                int i6 = (i3 == true ? 1 : 0) & 256;
                                int i7 = i3;
                                if (i6 != 256) {
                                    this.r = new ArrayList();
                                    i7 = (i3 == true ? 1 : 0) | 256;
                                }
                                list = this.r;
                                aVar = rr0.s;
                                i2 = i7;
                                i3 = i2;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 56:
                                this.d |= 16;
                                this.n = xdVar.k();
                                break;
                            case 64:
                                this.d |= 64;
                                this.q = xdVar.k();
                                break;
                            case 72:
                                this.d |= 1;
                                this.f = xdVar.k();
                                break;
                            case 242:
                                i = 128;
                                if ((this.d & 128) == 128) {
                                    qr0 qr0Var = this.s;
                                    qr0Var.getClass();
                                    bVarE = qr0.e(qr0Var);
                                }
                                qr0 qr0Var2 = (qr0) xdVar.g(qr0.n, psVar);
                                this.s = qr0Var2;
                                if (bVarE != null) {
                                    bVarE.g(qr0Var2);
                                    this.s = bVarE.f();
                                }
                                this.d |= i;
                                break;
                            case 248:
                                int i8 = (i3 == true ? 1 : 0) & 1024;
                                int i9 = i3;
                                if (i8 != 1024) {
                                    this.t = new ArrayList();
                                    i9 = (i3 == true ? 1 : 0) | 1024;
                                }
                                list = this.t;
                                i3 = i9;
                                objG = Integer.valueOf(xdVar.k());
                                list.add(objG);
                                break;
                            case n.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                int iD = xdVar.d(xdVar.k());
                                int i10 = (i3 == true ? 1 : 0) & 1024;
                                i3 = i3;
                                if (i10 != 1024 && xdVar.b() > 0) {
                                    i3 = i3;
                                    this.t = new ArrayList();
                                    i3 = (i3 == true ? 1 : 0) | 1024;
                                }
                                i3 = i3;
                                while (xdVar.b() > 0) {
                                    this.t.add(Integer.valueOf(xdVar.k()));
                                }
                                xdVar.c(iD);
                                break;
                            case 258:
                                if ((this.d & 256) == 256) {
                                    br0 br0Var = this.u;
                                    br0Var.getClass();
                                    bVar2 = new br0.b(0);
                                    bVar2.g(br0Var);
                                }
                                br0 br0Var2 = (br0) xdVar.g(br0.i, psVar);
                                this.u = br0Var2;
                                if (bVar2 != null) {
                                    bVar2.g(br0Var2);
                                    this.u = bVar2.f();
                                }
                                this.d |= 256;
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
                    }
                } catch (IOException e2) {
                    t30 t30Var = new t30(e2.getMessage());
                    t30Var.b = this;
                    throw t30Var;
                }
            } catch (Throwable th) {
                if (((i3 == true ? 1 : 0) & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if (((i3 == true ? 1 : 0) & 256) == 256) {
                    this.r = Collections.unmodifiableList(this.r);
                }
                if (((i3 == true ? 1 : 0) & 1024) == 1024) {
                    this.t = Collections.unmodifiableList(this.t);
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
        if (((i3 == true ? 1 : 0) & 32) == 32) {
            this.o = Collections.unmodifiableList(this.o);
        }
        if (((i3 == true ? 1 : 0) & 256) == 256) {
            this.r = Collections.unmodifiableList(this.r);
        }
        if (((i3 == true ? 1 : 0) & 1024) == 1024) {
            this.t = Collections.unmodifiableList(this.t);
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
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            ydVar.o(6, (b0) this.r.get(i2));
        }
        if ((this.d & 16) == 16) {
            ydVar.m(7, this.n);
        }
        if ((this.d & 64) == 64) {
            ydVar.m(8, this.q);
        }
        if ((this.d & 1) == 1) {
            ydVar.m(9, this.f);
        }
        if ((this.d & 128) == 128) {
            ydVar.o(30, this.s);
        }
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            ydVar.m(31, ((Integer) this.t.get(i3)).intValue());
        }
        if ((this.d & 256) == 256) {
            ydVar.o(32, this.u);
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
        List list;
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
        for (int i4 = 0; i4 < this.r.size(); i4++) {
            iB += yd.d(6, (b0) this.r.get(i4));
        }
        if ((this.d & 16) == 16) {
            iB += yd.b(7, this.n);
        }
        if ((this.d & 64) == 64) {
            iB += yd.b(8, this.q);
        }
        if ((this.d & 1) == 1) {
            iB += yd.b(9, this.f);
        }
        if ((this.d & 128) == 128) {
            iB += yd.d(30, this.s);
        }
        int iC = 0;
        while (true) {
            int size = this.t.size();
            list = this.t;
            if (i2 >= size) {
                break;
            }
            iC += yd.c(((Integer) list.get(i2)).intValue());
            i2++;
        }
        int size2 = (list.size() * 2) + iB + iC;
        if ((this.d & 256) == 256) {
            size2 += yd.d(32, this.u);
        }
        int size3 = this.c.size() + f() + size2;
        this.w = size3;
        return size3;
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
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            if (!((rr0) this.r.get(i3)).isInitialized()) {
                this.v = (byte) 0;
                return false;
            }
        }
        if ((this.d & 128) == 128 && !this.s.isInitialized()) {
            this.v = (byte) 0;
            return false;
        }
        if ((this.d & 256) == 256 && !this.u.isInitialized()) {
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
        this.f = 6;
        this.g = 6;
        this.i = 0;
        nr0 nr0Var = nr0.z;
        this.j = nr0Var;
        this.n = 0;
        List list = Collections.EMPTY_LIST;
        this.o = list;
        this.p = nr0Var;
        this.q = 0;
        this.r = list;
        this.s = qr0.j;
        this.t = list;
        this.u = br0.g;
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
