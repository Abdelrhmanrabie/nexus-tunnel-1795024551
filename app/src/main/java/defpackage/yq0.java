package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yq0 extends yx {
    public static final yq0 j;
    public static final ar0.a n = new ar0.a(25);
    public final fa b;
    public int c;
    public int d;
    public List f;
    public byte g;
    public int i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx {
        public static final b j;
        public static final ar0.a n = new ar0.a(26);
        public final fa b;
        public int c;
        public int d;
        public c f;
        public byte g;
        public int i;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends yx {
            public static final c v;
            public static final ar0.a w = new ar0.a(27);
            public final fa b;
            public int c;
            public EnumC0048c d;
            public long f;
            public float g;
            public double i;
            public int j;
            public int n;
            public int o;
            public yq0 p;
            public List q;
            public int r;
            public int s;
            public byte t;
            public int u;

            /* JADX INFO: renamed from: yq0$b$c$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public final class C0047b extends yx.a implements oh0 {
                public int c;
                public long f;
                public float g;
                public double i;
                public int j;
                public int n;
                public int o;
                public int r;
                public int s;
                public EnumC0048c d = EnumC0048c.c;
                public yq0 p = yq0.j;
                public List q = Collections.EMPTY_LIST;

                /* JADX WARN: Code duplicated, block: B:14:0x001b  */
                @Override // yx.a
                public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                    c cVar;
                    try {
                        try {
                            c.w.getClass();
                            g(new c(xdVar, psVar));
                            return this;
                        } catch (t30 e) {
                            cVar = (c) e.b;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                if (cVar != null) {
                                    g(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cVar = null;
                        if (cVar != null) {
                            g(cVar);
                        }
                        throw th;
                    }
                }

                @Override // yx.a
                public final b0 build() {
                    c cVarF = f();
                    if (cVarF.isInitialized()) {
                        return cVarF;
                    }
                    throw new we();
                }

                public final Object clone() {
                    C0047b c0047b = new C0047b();
                    c0047b.g(f());
                    return c0047b;
                }

                @Override // yx.a
                public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
                    g((c) yxVar);
                    return this;
                }

                public final c f() {
                    c cVar = new c(this);
                    int i = this.c;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    cVar.d = this.d;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    cVar.f = this.f;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    cVar.g = this.g;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    cVar.i = this.i;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    cVar.j = this.j;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    cVar.n = this.n;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    cVar.o = this.o;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    cVar.p = this.p;
                    if ((i & 256) == 256) {
                        this.q = Collections.unmodifiableList(this.q);
                        this.c &= -257;
                    }
                    cVar.q = this.q;
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    cVar.r = this.r;
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    cVar.s = this.s;
                    cVar.c = i2;
                    return cVar;
                }

                public final void g(c cVar) {
                    yq0 yq0Var;
                    if (cVar == c.v) {
                        return;
                    }
                    if ((cVar.c & 1) == 1) {
                        EnumC0048c enumC0048c = cVar.d;
                        enumC0048c.getClass();
                        this.c |= 1;
                        this.d = enumC0048c;
                    }
                    int i = cVar.c;
                    if ((i & 2) == 2) {
                        long j = cVar.f;
                        this.c |= 2;
                        this.f = j;
                    }
                    if ((i & 4) == 4) {
                        float f = cVar.g;
                        this.c = 4 | this.c;
                        this.g = f;
                    }
                    if ((i & 8) == 8) {
                        double d = cVar.i;
                        this.c |= 8;
                        this.i = d;
                    }
                    if ((i & 16) == 16) {
                        int i2 = cVar.j;
                        this.c = 16 | this.c;
                        this.j = i2;
                    }
                    if ((i & 32) == 32) {
                        int i3 = cVar.n;
                        this.c = 32 | this.c;
                        this.n = i3;
                    }
                    if ((i & 64) == 64) {
                        int i4 = cVar.o;
                        this.c = 64 | this.c;
                        this.o = i4;
                    }
                    if ((i & 128) == 128) {
                        yq0 yq0VarM18f = cVar.p;
                        if ((this.c & 128) == 128 && (yq0Var = this.p) != yq0.j) {
                            qr0.b bVar = new qr0.b(1);
                            bVar.g(yq0Var);
                            bVar.g(yq0VarM18f);
                            yq0VarM18f = bVar.m18f();
                        }
                        this.p = yq0VarM18f;
                        this.c |= 128;
                    }
                    if (!cVar.q.isEmpty()) {
                        if (this.q.isEmpty()) {
                            this.q = cVar.q;
                            this.c &= -257;
                        } else {
                            if ((this.c & 256) != 256) {
                                this.q = new ArrayList(this.q);
                                this.c |= 256;
                            }
                            this.q.addAll(cVar.q);
                        }
                    }
                    int i5 = cVar.c;
                    if ((i5 & 256) == 256) {
                        int i6 = cVar.r;
                        this.c |= 512;
                        this.r = i6;
                    }
                    if ((i5 & 512) == 512) {
                        int i7 = cVar.s;
                        this.c |= 1024;
                        this.s = i7;
                    }
                    this.b = this.b.d(cVar.b);
                }
            }

            /* JADX INFO: renamed from: yq0$b$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public enum EnumC0048c implements h30.a {
                c("BYTE"),
                d("CHAR"),
                f("SHORT"),
                g("INT"),
                i("LONG"),
                j("FLOAT"),
                n("DOUBLE"),
                o("BOOLEAN"),
                p("STRING"),
                q("CLASS"),
                r("ENUM"),
                s("ANNOTATION"),
                t("ARRAY");

                public final int b;

                EnumC0048c(String str) {
                    this.b = i;
                }

                public static EnumC0048c a(int i2) {
                    switch (i2) {
                        case 0:
                            return c;
                        case 1:
                            return d;
                        case 2:
                            return f;
                        case 3:
                            return g;
                        case 4:
                            return i;
                        case 5:
                            return j;
                        case 6:
                            return n;
                        case 7:
                            return o;
                        case 8:
                            return p;
                        case 9:
                            return q;
                        case 10:
                            return r;
                        case 11:
                            return s;
                        case 12:
                            return t;
                        default:
                            return null;
                    }
                }

                @Override // h30.a
                public final int getNumber() {
                    return this.b;
                }
            }

            static {
                c cVar = new c();
                v = cVar;
                cVar.e();
            }

            public c() {
                this.t = (byte) -1;
                this.u = -1;
                this.b = fa.b;
            }

            public c(xd xdVar, ps psVar) {
                qr0.b bVar;
                this.t = (byte) -1;
                this.u = -1;
                e();
                fa.b bVar2 = new fa.b();
                yd ydVarJ = yd.j(bVar2, 1);
                boolean z = false;
                char c = 0;
                while (!z) {
                    try {
                        try {
                            int iN = xdVar.n();
                            switch (iN) {
                                case 0:
                                    break;
                                case 8:
                                    int iK = xdVar.k();
                                    EnumC0048c enumC0048cA = EnumC0048c.a(iK);
                                    if (enumC0048cA == null) {
                                        ydVarJ.v(iN);
                                        ydVarJ.v(iK);
                                    } else {
                                        this.c |= 1;
                                        this.d = enumC0048cA;
                                        continue;
                                    }
                                    break;
                                case 16:
                                    this.c |= 2;
                                    long jL = xdVar.l();
                                    this.f = (-(jL & 1)) ^ (jL >>> 1);
                                    continue;
                                case 29:
                                    this.c |= 4;
                                    this.g = Float.intBitsToFloat(xdVar.i());
                                    continue;
                                case 33:
                                    this.c |= 8;
                                    this.i = Double.longBitsToDouble(xdVar.j());
                                    continue;
                                case 40:
                                    this.c |= 16;
                                    this.j = xdVar.k();
                                    continue;
                                case 48:
                                    this.c |= 32;
                                    this.n = xdVar.k();
                                    continue;
                                case 56:
                                    this.c |= 64;
                                    this.o = xdVar.k();
                                    continue;
                                case 66:
                                    if ((this.c & 128) == 128) {
                                        yq0 yq0Var = this.p;
                                        yq0Var.getClass();
                                        bVar = new qr0.b(1);
                                        bVar.g(yq0Var);
                                    } else {
                                        bVar = null;
                                    }
                                    yq0 yq0Var2 = (yq0) xdVar.g(yq0.n, psVar);
                                    this.p = yq0Var2;
                                    if (bVar != null) {
                                        bVar.g(yq0Var2);
                                        this.p = bVar.m18f();
                                    }
                                    this.c |= 128;
                                    continue;
                                case 74:
                                    if ((c & 256) != 256) {
                                        this.q = new ArrayList();
                                        c = 256;
                                    }
                                    this.q.add(xdVar.g(w, psVar));
                                    continue;
                                case 80:
                                    this.c |= 512;
                                    this.s = xdVar.k();
                                    continue;
                                case 88:
                                    this.c |= 256;
                                    this.r = xdVar.k();
                                    continue;
                                default:
                                    if (!xdVar.q(iN, ydVarJ)) {
                                        break;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (Throwable th) {
                            if ((c & 256) == 256) {
                                this.q = Collections.unmodifiableList(this.q);
                            }
                            try {
                                ydVarJ.k();
                            } catch (IOException unused) {
                            } finally {
                                this.b = bVar2.c();
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
                if ((c & 256) == 256) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                try {
                    ydVarJ.k();
                } catch (IOException unused2) {
                } finally {
                    this.b = bVar2.c();
                }
            }

            public c(C0047b c0047b) {
                this.t = (byte) -1;
                this.u = -1;
                this.b = c0047b.b;
            }

            @Override // defpackage.b0
            public final void a(yd ydVar) throws IOException {
                getSerializedSize();
                if ((this.c & 1) == 1) {
                    ydVar.l(1, this.d.b);
                }
                if ((this.c & 2) == 2) {
                    long j = this.f;
                    ydVar.x(2, 0);
                    ydVar.w((j >> 63) ^ (j << 1));
                }
                if ((this.c & 4) == 4) {
                    float f = this.g;
                    ydVar.x(3, 5);
                    ydVar.t(Float.floatToRawIntBits(f));
                }
                if ((this.c & 8) == 8) {
                    double d = this.i;
                    ydVar.x(4, 1);
                    ydVar.u(Double.doubleToRawLongBits(d));
                }
                if ((this.c & 16) == 16) {
                    ydVar.m(5, this.j);
                }
                if ((this.c & 32) == 32) {
                    ydVar.m(6, this.n);
                }
                if ((this.c & 64) == 64) {
                    ydVar.m(7, this.o);
                }
                if ((this.c & 128) == 128) {
                    ydVar.o(8, this.p);
                }
                for (int i = 0; i < this.q.size(); i++) {
                    ydVar.o(9, (b0) this.q.get(i));
                }
                if ((this.c & 512) == 512) {
                    ydVar.m(10, this.s);
                }
                if ((this.c & 256) == 256) {
                    ydVar.m(11, this.r);
                }
                ydVar.r(this.b);
            }

            public final void e() {
                this.d = EnumC0048c.c;
                this.f = 0L;
                this.g = 0.0f;
                this.i = 0.0d;
                this.j = 0;
                this.n = 0;
                this.o = 0;
                this.p = yq0.j;
                this.q = Collections.EMPTY_LIST;
                this.r = 0;
                this.s = 0;
            }

            @Override // defpackage.b0
            public final int getSerializedSize() {
                int i = this.u;
                if (i != -1) {
                    return i;
                }
                int iA = (this.c & 1) == 1 ? yd.a(1, this.d.b) : 0;
                if ((this.c & 2) == 2) {
                    long j = this.f;
                    iA += yd.g((j >> 63) ^ (j << 1)) + yd.h(2);
                }
                if ((this.c & 4) == 4) {
                    iA += yd.h(3) + 4;
                }
                if ((this.c & 8) == 8) {
                    iA += yd.h(4) + 8;
                }
                if ((this.c & 16) == 16) {
                    iA += yd.b(5, this.j);
                }
                if ((this.c & 32) == 32) {
                    iA += yd.b(6, this.n);
                }
                if ((this.c & 64) == 64) {
                    iA += yd.b(7, this.o);
                }
                if ((this.c & 128) == 128) {
                    iA += yd.d(8, this.p);
                }
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    iA += yd.d(9, (b0) this.q.get(i2));
                }
                if ((this.c & 512) == 512) {
                    iA += yd.b(10, this.s);
                }
                if ((this.c & 256) == 256) {
                    iA += yd.b(11, this.r);
                }
                int size = this.b.size() + iA;
                this.u = size;
                return size;
            }

            @Override // defpackage.oh0
            public final boolean isInitialized() {
                byte b = this.t;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if ((this.c & 128) == 128 && !this.p.isInitialized()) {
                    this.t = (byte) 0;
                    return false;
                }
                for (int i = 0; i < this.q.size(); i++) {
                    if (!((c) this.q.get(i)).isInitialized()) {
                        this.t = (byte) 0;
                        return false;
                    }
                }
                this.t = (byte) 1;
                return true;
            }

            @Override // defpackage.b0
            public final yx.a newBuilderForType() {
                return new C0047b();
            }

            @Override // defpackage.b0
            public final yx.a toBuilder() {
                C0047b c0047b = new C0047b();
                c0047b.g(this);
                return c0047b;
            }
        }

        static {
            b bVar = new b();
            j = bVar;
            bVar.d = 0;
            bVar.f = c.v;
        }

        public b() {
            this.g = (byte) -1;
            this.i = -1;
            this.b = fa.b;
        }

        public b(qr0.b bVar) {
            this.g = (byte) -1;
            this.i = -1;
            this.b = bVar.b;
        }

        public b(xd xdVar, ps psVar) {
            c.C0047b c0047b;
            this.g = (byte) -1;
            this.i = -1;
            boolean z = false;
            this.d = 0;
            this.f = c.v;
            fa.b bVar = new fa.b();
            yd ydVarJ = yd.j(bVar, 1);
            while (!z) {
                try {
                    try {
                        int iN = xdVar.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.c |= 1;
                                this.d = xdVar.k();
                            } else if (iN == 18) {
                                if ((this.c & 2) == 2) {
                                    c cVar = this.f;
                                    cVar.getClass();
                                    c0047b = new c.C0047b();
                                    c0047b.g(cVar);
                                } else {
                                    c0047b = null;
                                }
                                c cVar2 = (c) xdVar.g(c.w, psVar);
                                this.f = cVar2;
                                if (c0047b != null) {
                                    c0047b.g(cVar2);
                                    this.f = c0047b.f();
                                }
                                this.c |= 2;
                            } else if (!xdVar.q(iN, ydVarJ)) {
                            }
                        }
                        z = true;
                    } catch (t30 e) {
                        e.b = this;
                        throw e;
                    } catch (IOException e2) {
                        t30 t30Var = new t30(e2.getMessage());
                        t30Var.b = this;
                        throw t30Var;
                    }
                } catch (Throwable th) {
                    try {
                        ydVarJ.k();
                    } catch (IOException unused) {
                    } finally {
                        this.b = bVar.c();
                    }
                    throw th;
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
                ydVar.m(1, this.d);
            }
            if ((this.c & 2) == 2) {
                ydVar.o(2, this.f);
            }
            ydVar.r(this.b);
        }

        @Override // defpackage.b0
        public final int getSerializedSize() {
            int i = this.i;
            if (i != -1) {
                return i;
            }
            int iB = (this.c & 1) == 1 ? yd.b(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iB += yd.d(2, this.f);
            }
            int size = this.b.size() + iB;
            this.i = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            byte b = this.g;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            int i = this.c;
            if ((i & 1) != 1) {
                this.g = (byte) 0;
                return false;
            }
            if ((i & 2) != 2) {
                this.g = (byte) 0;
                return false;
            }
            if (this.f.isInitialized()) {
                this.g = (byte) 1;
                return true;
            }
            this.g = (byte) 0;
            return false;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new qr0.b(2);
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            qr0.b bVar = new qr0.b(2);
            bVar.h(this);
            return bVar;
        }
    }

    static {
        yq0 yq0Var = new yq0();
        j = yq0Var;
        yq0Var.d = 0;
        yq0Var.f = Collections.EMPTY_LIST;
    }

    public yq0() {
        this.g = (byte) -1;
        this.i = -1;
        this.b = fa.b;
    }

    public yq0(qr0.b bVar) {
        this.g = (byte) -1;
        this.i = -1;
        this.b = bVar.b;
    }

    public yq0(xd xdVar, ps psVar) {
        this.g = (byte) -1;
        this.i = -1;
        boolean z = false;
        this.d = 0;
        this.f = Collections.EMPTY_LIST;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        char c = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = xdVar.k();
                        } else if (iN == 18) {
                            if ((c & 2) != 2) {
                                this.f = new ArrayList();
                                c = 2;
                            }
                            this.f.add(xdVar.g(b.n, psVar));
                        } else if (!xdVar.q(iN, ydVarJ)) {
                        }
                    }
                    z = true;
                } catch (t30 e) {
                    e.b = this;
                    throw e;
                } catch (IOException e2) {
                    t30 t30Var = new t30(e2.getMessage());
                    t30Var.b = this;
                    throw t30Var;
                }
            } catch (Throwable th) {
                if ((c & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                try {
                    ydVarJ.k();
                } catch (IOException unused) {
                } finally {
                    this.b = bVar.c();
                }
                throw th;
            }
        }
        if ((c & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
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
            ydVar.m(1, this.d);
        }
        for (int i = 0; i < this.f.size(); i++) {
            ydVar.o(2, (b0) this.f.get(i));
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? yd.b(1, this.d) : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            iB += yd.d(2, (b0) this.f.get(i2));
        }
        int size = this.b.size() + iB;
        this.i = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.g;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if ((this.c & 1) != 1) {
            this.g = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((b) this.f.get(i)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
        }
        this.g = (byte) 1;
        return true;
    }

    @Override // defpackage.b0
    public final yx.a newBuilderForType() {
        return new qr0.b(1);
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        qr0.b bVar = new qr0.b(1);
        bVar.g(this);
        return bVar;
    }
}
