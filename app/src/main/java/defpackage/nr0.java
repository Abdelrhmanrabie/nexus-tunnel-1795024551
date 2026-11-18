package defpackage;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nr0 extends yx.c {
    public static final ar0.a A = new ar0.a(12);
    public static final nr0 z;
    public final fa c;
    public int d;
    public List f;
    public boolean g;
    public int i;
    public nr0 j;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public nr0 s;
    public int t;
    public nr0 u;
    public int v;
    public int w;
    public byte x;
    public int y;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx {
        public static final b n;
        public static final ar0.a o = new ar0.a(13);
        public final fa b;
        public int c;
        public c d;
        public nr0 f;
        public int g;
        public byte i;
        public int j;

        /* JADX INFO: renamed from: nr0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0041b extends yx.a implements oh0 {
            public int c;
            public c d = c.f;
            public nr0 f = nr0.z;
            public int g;

            /* JADX WARN: Code duplicated, block: B:14:0x001b  */
            @Override // yx.a
            public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                b bVar;
                try {
                    try {
                        b.o.getClass();
                        g(new b(xdVar, psVar));
                        return this;
                    } catch (t30 e) {
                        bVar = (b) e.b;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            if (bVar != null) {
                                g(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                    if (bVar != null) {
                        g(bVar);
                    }
                    throw th;
                }
            }

            @Override // yx.a
            public final b0 build() {
                b bVarF = f();
                if (bVarF.isInitialized()) {
                    return bVarF;
                }
                throw new we();
            }

            public final Object clone() {
                C0041b c0041b = new C0041b();
                c0041b.g(f());
                return c0041b;
            }

            @Override // yx.a
            public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
                g((b) yxVar);
                return this;
            }

            public final b f() {
                b bVar = new b(this);
                int i = this.c;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.d = this.d;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.f = this.f;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                bVar.g = this.g;
                bVar.c = i2;
                return bVar;
            }

            public final void g(b bVar) {
                nr0 nr0Var;
                if (bVar == b.n) {
                    return;
                }
                if ((bVar.c & 1) == 1) {
                    c cVar = bVar.d;
                    cVar.getClass();
                    this.c = 1 | this.c;
                    this.d = cVar;
                }
                if ((bVar.c & 2) == 2) {
                    nr0 nr0VarG = bVar.f;
                    if ((this.c & 2) == 2 && (nr0Var = this.f) != nr0.z) {
                        c cVarO = nr0.o(nr0Var);
                        cVarO.h(nr0VarG);
                        nr0VarG = cVarO.g();
                    }
                    this.f = nr0VarG;
                    this.c |= 2;
                }
                if ((bVar.c & 4) == 4) {
                    int i = bVar.g;
                    this.c = 4 | this.c;
                    this.g = i;
                }
                this.b = this.b.d(bVar.b);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum c implements h30.a {
            c("IN"),
            d("OUT"),
            f("INV"),
            g("STAR");

            public final int b;

            c(String str) {
                this.b = i;
            }

            @Override // h30.a
            public final int getNumber() {
                return this.b;
            }
        }

        static {
            b bVar = new b();
            n = bVar;
            bVar.d = c.f;
            bVar.f = nr0.z;
            bVar.g = 0;
        }

        public b() {
            this.i = (byte) -1;
            this.j = -1;
            this.b = fa.b;
        }

        public b(C0041b c0041b) {
            this.i = (byte) -1;
            this.j = -1;
            this.b = c0041b.b;
        }

        public b(xd xdVar, ps psVar) {
            this.i = (byte) -1;
            this.j = -1;
            c cVar = c.f;
            this.d = cVar;
            this.f = nr0.z;
            boolean z = false;
            this.g = 0;
            fa.b bVar = new fa.b();
            yd ydVarJ = yd.j(bVar, 1);
            while (!z) {
                try {
                    try {
                        int iN = xdVar.n();
                        if (iN != 0) {
                            c cVarO = null;
                            c cVar2 = null;
                            if (iN == 8) {
                                int iK = xdVar.k();
                                if (iK == 0) {
                                    cVar2 = c.c;
                                } else if (iK == 1) {
                                    cVar2 = c.d;
                                } else if (iK == 2) {
                                    cVar2 = cVar;
                                } else if (iK == 3) {
                                    cVar2 = c.g;
                                }
                                if (cVar2 == null) {
                                    ydVarJ.v(iN);
                                    ydVarJ.v(iK);
                                } else {
                                    this.c |= 1;
                                    this.d = cVar2;
                                }
                            } else if (iN == 18) {
                                if ((this.c & 2) == 2) {
                                    nr0 nr0Var = this.f;
                                    nr0Var.getClass();
                                    cVarO = nr0.o(nr0Var);
                                }
                                nr0 nr0Var2 = (nr0) xdVar.g(nr0.A, psVar);
                                this.f = nr0Var2;
                                if (cVarO != null) {
                                    cVarO.h(nr0Var2);
                                    this.f = cVarO.g();
                                }
                                this.c |= 2;
                            } else if (iN == 24) {
                                this.c |= 4;
                                this.g = xdVar.k();
                            } else if (!xdVar.q(iN, ydVarJ)) {
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        try {
                            ydVarJ.k();
                        } catch (IOException unused) {
                        } finally {
                            this.b = bVar.c();
                        }
                        throw th;
                    }
                } catch (t30 e) {
                    e.b = this;
                    throw e;
                } catch (IOException e2) {
                    t30 t30Var = new t30(e2.getMessage());
                    t30Var.b = this;
                    throw t30Var;
                }
            }
            try {
                ydVarJ.k();
            } catch (IOException unused2) {
            } finally {
                this.b = bVar.c();
            }
        }

        @Override // defpackage.b0
        public final void a(yd ydVar) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                ydVar.l(1, this.d.b);
            }
            if ((this.c & 2) == 2) {
                ydVar.o(2, this.f);
            }
            if ((this.c & 4) == 4) {
                ydVar.m(3, this.g);
            }
            ydVar.r(this.b);
        }

        @Override // defpackage.b0
        public final int getSerializedSize() {
            int i = this.j;
            if (i != -1) {
                return i;
            }
            int iA = (this.c & 1) == 1 ? yd.a(1, this.d.b) : 0;
            if ((this.c & 2) == 2) {
                iA += yd.d(2, this.f);
            }
            if ((this.c & 4) == 4) {
                iA += yd.b(3, this.g);
            }
            int size = this.b.size() + iA;
            this.j = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            byte b = this.i;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if ((this.c & 2) != 2 || this.f.isInitialized()) {
                this.i = (byte) 1;
                return true;
            }
            this.i = (byte) 0;
            return false;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new C0041b();
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            C0041b c0041b = new C0041b();
            c0041b.g(this);
            return c0041b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends yx.b {
        public int f;
        public List g = Collections.EMPTY_LIST;
        public boolean i;
        public int j;
        public nr0 n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public nr0 t;
        public int u;
        public nr0 v;
        public int w;
        public int x;

        public c() {
            nr0 nr0Var = nr0.z;
            this.n = nr0Var;
            this.t = nr0Var;
            this.v = nr0Var;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            nr0 nr0Var;
            try {
                try {
                    nr0.A.getClass();
                    h(new nr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    nr0Var = (nr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (nr0Var != null) {
                            h(nr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                nr0Var = null;
                if (nr0Var != null) {
                    h(nr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            nr0 nr0VarG = g();
            if (nr0VarG.isInitialized()) {
                return nr0VarG;
            }
            throw new we();
        }

        public final Object clone() {
            c cVar = new c();
            cVar.h(g());
            return cVar;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            h((nr0) yxVar);
            return this;
        }

        public final nr0 g() {
            nr0 nr0Var = new nr0(this);
            int i = this.f;
            if ((i & 1) == 1) {
                this.g = Collections.unmodifiableList(this.g);
                this.f &= -2;
            }
            nr0Var.f = this.g;
            int i2 = (i & 2) != 2 ? 0 : 1;
            nr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            nr0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            nr0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            nr0Var.n = this.o;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            nr0Var.o = this.p;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            nr0Var.p = this.q;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            nr0Var.q = this.r;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            nr0Var.r = this.s;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            nr0Var.s = this.t;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            nr0Var.t = this.u;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            nr0Var.u = this.v;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            nr0Var.v = this.w;
            if ((i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) == 8192) {
                i2 |= 4096;
            }
            nr0Var.w = this.x;
            nr0Var.d = i2;
            return nr0Var;
        }

        public final void h(nr0 nr0Var) {
            nr0 nr0Var2;
            nr0 nr0Var3;
            nr0 nr0Var4;
            nr0 nr0Var5 = nr0.z;
            if (nr0Var == nr0Var5) {
                return;
            }
            if (!nr0Var.f.isEmpty()) {
                if (this.g.isEmpty()) {
                    this.g = nr0Var.f;
                    this.f &= -2;
                } else {
                    if ((this.f & 1) != 1) {
                        this.g = new ArrayList(this.g);
                        this.f |= 1;
                    }
                    this.g.addAll(nr0Var.f);
                }
            }
            int i = nr0Var.d;
            if ((i & 1) == 1) {
                boolean z = nr0Var.g;
                this.f |= 2;
                this.i = z;
            }
            if ((i & 2) == 2) {
                int i2 = nr0Var.i;
                this.f |= 4;
                this.j = i2;
            }
            if ((i & 4) == 4) {
                nr0 nr0VarG = nr0Var.j;
                if ((this.f & 8) == 8 && (nr0Var4 = this.n) != nr0Var5) {
                    c cVarO = nr0.o(nr0Var4);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.n = nr0VarG;
                this.f |= 8;
            }
            if ((nr0Var.d & 8) == 8) {
                int i3 = nr0Var.n;
                this.f |= 16;
                this.o = i3;
            }
            if (nr0Var.m()) {
                int i4 = nr0Var.o;
                this.f |= 32;
                this.p = i4;
            }
            int i5 = nr0Var.d;
            if ((i5 & 32) == 32) {
                int i6 = nr0Var.p;
                this.f |= 64;
                this.q = i6;
            }
            if ((i5 & 64) == 64) {
                int i7 = nr0Var.q;
                this.f |= 128;
                this.r = i7;
            }
            if ((i5 & 128) == 128) {
                int i8 = nr0Var.r;
                this.f |= 256;
                this.s = i8;
            }
            if ((i5 & 256) == 256) {
                nr0 nr0VarG2 = nr0Var.s;
                if ((this.f & 512) == 512 && (nr0Var3 = this.t) != nr0Var5) {
                    c cVarO2 = nr0.o(nr0Var3);
                    cVarO2.h(nr0VarG2);
                    nr0VarG2 = cVarO2.g();
                }
                this.t = nr0VarG2;
                this.f |= 512;
            }
            int i9 = nr0Var.d;
            if ((i9 & 512) == 512) {
                int i10 = nr0Var.t;
                this.f |= 1024;
                this.u = i10;
            }
            if ((i9 & 1024) == 1024) {
                nr0 nr0VarG3 = nr0Var.u;
                if ((this.f & 2048) == 2048 && (nr0Var2 = this.v) != nr0Var5) {
                    c cVarO3 = nr0.o(nr0Var2);
                    cVarO3.h(nr0VarG3);
                    nr0VarG3 = cVarO3.g();
                }
                this.v = nr0VarG3;
                this.f |= 2048;
            }
            int i11 = nr0Var.d;
            if ((i11 & 2048) == 2048) {
                int i12 = nr0Var.v;
                this.f |= 4096;
                this.w = i12;
            }
            if ((i11 & 4096) == 4096) {
                int i13 = nr0Var.w;
                this.f |= AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
                this.x = i13;
            }
            f(nr0Var);
            this.b = this.b.d(nr0Var.c);
        }
    }

    static {
        nr0 nr0Var = new nr0();
        z = nr0Var;
        nr0Var.n();
    }

    public nr0() {
        this.x = (byte) -1;
        this.y = -1;
        this.c = fa.b;
    }

    public nr0(c cVar) {
        super(cVar);
        this.x = (byte) -1;
        this.y = -1;
        this.c = cVar.b;
    }

    public nr0(xd xdVar, ps psVar) {
        int i;
        this.x = (byte) -1;
        this.y = -1;
        n();
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int iN = xdVar.n();
                    ar0.a aVar = A;
                    c cVarO = null;
                    switch (iN) {
                        case 0:
                            z2 = true;
                            break;
                        case 8:
                            this.d |= 4096;
                            this.w = xdVar.k();
                            break;
                        case 18:
                            if (!z3) {
                                this.f = new ArrayList();
                                z3 = true;
                            }
                            this.f.add(xdVar.g(b.o, psVar));
                            break;
                        case 24:
                            this.d |= 1;
                            this.g = xdVar.l() != 0;
                            break;
                        case 32:
                            this.d |= 2;
                            this.i = xdVar.k();
                            break;
                        case 42:
                            i = 4;
                            if ((this.d & 4) == 4) {
                                nr0 nr0Var = this.j;
                                nr0Var.getClass();
                                cVarO = o(nr0Var);
                            }
                            nr0 nr0Var2 = (nr0) xdVar.g(aVar, psVar);
                            this.j = nr0Var2;
                            if (cVarO != null) {
                                cVarO.h(nr0Var2);
                                this.j = cVarO.g();
                            }
                            this.d |= i;
                            break;
                        case 48:
                            this.d |= 16;
                            this.o = xdVar.k();
                            break;
                        case 56:
                            this.d |= 32;
                            this.p = xdVar.k();
                            break;
                        case 64:
                            this.d |= 8;
                            this.n = xdVar.k();
                            break;
                        case 72:
                            this.d |= 64;
                            this.q = xdVar.k();
                            break;
                        case 82:
                            i = 256;
                            if ((this.d & 256) == 256) {
                                nr0 nr0Var3 = this.s;
                                nr0Var3.getClass();
                                cVarO = o(nr0Var3);
                            }
                            nr0 nr0Var4 = (nr0) xdVar.g(aVar, psVar);
                            this.s = nr0Var4;
                            if (cVarO != null) {
                                cVarO.h(nr0Var4);
                                this.s = cVarO.g();
                            }
                            this.d |= i;
                            break;
                        case 88:
                            this.d |= 512;
                            this.t = xdVar.k();
                            break;
                        case 96:
                            this.d |= 128;
                            this.r = xdVar.k();
                            break;
                        case 106:
                            i = 1024;
                            if ((this.d & 1024) == 1024) {
                                nr0 nr0Var5 = this.u;
                                nr0Var5.getClass();
                                cVarO = o(nr0Var5);
                            }
                            nr0 nr0Var6 = (nr0) xdVar.g(aVar, psVar);
                            this.u = nr0Var6;
                            if (cVarO != null) {
                                cVarO.h(nr0Var6);
                                this.u = cVarO.g();
                            }
                            this.d |= i;
                            break;
                        case 112:
                            this.d |= 2048;
                            this.v = xdVar.k();
                            break;
                        default:
                            if (!k(xdVar, ydVarJ, psVar, iN)) {
                                z2 = true;
                            }
                            break;
                    }
                } catch (Throwable th) {
                    if (z3) {
                        this.f = Collections.unmodifiableList(this.f);
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
            } catch (t30 e) {
                e.b = this;
                throw e;
            } catch (IOException e2) {
                t30 t30Var = new t30(e2.getMessage());
                t30Var.b = this;
                throw t30Var;
            }
        }
        if (z3) {
            this.f = Collections.unmodifiableList(this.f);
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

    public static c o(nr0 nr0Var) {
        c cVar = new c();
        cVar.h(nr0Var);
        return cVar;
    }

    @Override // defpackage.b0
    public final void a(yd ydVar) throws IOException {
        getSerializedSize();
        zl0 zl0Var = new zl0(this);
        if ((this.d & 4096) == 4096) {
            ydVar.m(1, this.w);
        }
        for (int i = 0; i < this.f.size(); i++) {
            ydVar.o(2, (b0) this.f.get(i));
        }
        if ((this.d & 1) == 1) {
            boolean z2 = this.g;
            ydVar.x(3, 0);
            ydVar.q(z2 ? 1 : 0);
        }
        if ((this.d & 2) == 2) {
            ydVar.m(4, this.i);
        }
        if ((this.d & 4) == 4) {
            ydVar.o(5, this.j);
        }
        if ((this.d & 16) == 16) {
            ydVar.m(6, this.o);
        }
        if ((this.d & 32) == 32) {
            ydVar.m(7, this.p);
        }
        if ((this.d & 8) == 8) {
            ydVar.m(8, this.n);
        }
        if ((this.d & 64) == 64) {
            ydVar.m(9, this.q);
        }
        if ((this.d & 256) == 256) {
            ydVar.o(10, this.s);
        }
        if ((this.d & 512) == 512) {
            ydVar.m(11, this.t);
        }
        if ((this.d & 128) == 128) {
            ydVar.m(12, this.r);
        }
        if ((this.d & 1024) == 1024) {
            ydVar.o(13, this.u);
        }
        if ((this.d & 2048) == 2048) {
            ydVar.m(14, this.v);
        }
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return z;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.y;
        if (i != -1) {
            return i;
        }
        int iB = (this.d & 4096) == 4096 ? yd.b(1, this.w) : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            iB += yd.d(2, (b0) this.f.get(i2));
        }
        if ((this.d & 1) == 1) {
            iB += yd.h(3) + 1;
        }
        if ((this.d & 2) == 2) {
            iB += yd.b(4, this.i);
        }
        if ((this.d & 4) == 4) {
            iB += yd.d(5, this.j);
        }
        if ((this.d & 16) == 16) {
            iB += yd.b(6, this.o);
        }
        if ((this.d & 32) == 32) {
            iB += yd.b(7, this.p);
        }
        if ((this.d & 8) == 8) {
            iB += yd.b(8, this.n);
        }
        if ((this.d & 64) == 64) {
            iB += yd.b(9, this.q);
        }
        if ((this.d & 256) == 256) {
            iB += yd.d(10, this.s);
        }
        if ((this.d & 512) == 512) {
            iB += yd.b(11, this.t);
        }
        if ((this.d & 128) == 128) {
            iB += yd.b(12, this.r);
        }
        if ((this.d & 1024) == 1024) {
            iB += yd.d(13, this.u);
        }
        if ((this.d & 2048) == 2048) {
            iB += yd.b(14, this.v);
        }
        int size = this.c.size() + f() + iB;
        this.y = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.x;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((b) this.f.get(i)).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        if ((this.d & 4) == 4 && !this.j.isInitialized()) {
            this.x = (byte) 0;
            return false;
        }
        if ((this.d & 256) == 256 && !this.s.isInitialized()) {
            this.x = (byte) 0;
            return false;
        }
        if ((this.d & 1024) == 1024 && !this.u.isInitialized()) {
            this.x = (byte) 0;
            return false;
        }
        if (e()) {
            this.x = (byte) 1;
            return true;
        }
        this.x = (byte) 0;
        return false;
    }

    public final boolean m() {
        return (this.d & 16) == 16;
    }

    public final void n() {
        this.f = Collections.EMPTY_LIST;
        this.g = false;
        this.i = 0;
        nr0 nr0Var = z;
        this.j = nr0Var;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = nr0Var;
        this.t = 0;
        this.u = nr0Var;
        this.v = 0;
        this.w = 0;
    }

    @Override // defpackage.b0
    public final yx.a newBuilderForType() {
        return new c();
    }

    public final c p() {
        return o(this);
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        return o(this);
    }
}
