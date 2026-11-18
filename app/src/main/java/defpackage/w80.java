package defpackage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class w80 {
    public static final yx.e a;
    public static final yx.e b;
    public static final yx.e c;
    public static final yx.e d;
    public static final yx.e e;
    public static final yx.e f;
    public static final yx.e g;
    public static final yx.e h;
    public static final yx.e i;
    public static final yx.e j;
    public static final yx.e k;
    public static final yx.e l;
    public static final yx.e m;
    public static final yx.e n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends yx {
        public static final a j;
        public static final ar0.a n = new ar0.a(20);
        public final fa b;
        public int c;
        public int d;
        public int f;
        public byte g;
        public int i;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends yx.a implements oh0 {
            public final /* synthetic */ int G0;
            public int c;
            public int d;
            public int f;

            public /* synthetic */ b(int i) {
                this.G0 = i;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001f  */
            /* JADX WARN: Code duplicated, block: B:28:0x003d  */
            @Override // yx.a
            public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                b bVar = null;
                a aVar = null;
                if (this.G0 != 0) {
                    try {
                        try {
                            b.n.getClass();
                            g(new b(xdVar));
                            return this;
                        } catch (t30 e) {
                            b bVar2 = (b) e.b;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                bVar = bVar2;
                                if (bVar != null) {
                                    g(bVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bVar != null) {
                            g(bVar);
                        }
                        throw th;
                    }
                }
                try {
                    try {
                        a.n.getClass();
                        g(new a(xdVar));
                        return this;
                    } catch (t30 e2) {
                        a aVar2 = (a) e2.b;
                        try {
                            throw e2;
                        } catch (Throwable th3) {
                            th = th3;
                            aVar = aVar2;
                            if (aVar != null) {
                                g(aVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (aVar != null) {
                        g(aVar);
                    }
                    throw th;
                }
            }

            @Override // yx.a
            public final b0 build() {
                if (this.G0 != 0) {
                    b bVarM58f = m58f();
                    bVarM58f.isInitialized();
                    return bVarM58f;
                }
                a aVarF = f();
                aVarF.isInitialized();
                return aVarF;
            }

            public final Object clone() {
                if (this.G0 != 0) {
                    b bVar = new b(1);
                    bVar.g(m58f());
                    return bVar;
                }
                b bVar2 = new b(0);
                bVar2.g(f());
                return bVar2;
            }

            @Override // yx.a
            public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
                if (this.G0 != 0) {
                    g((b) yxVar);
                    return this;
                }
                g((a) yxVar);
                return this;
            }

            public a f() {
                a aVar = new a(this);
                int i = this.c;
                int i2 = (i & 1) != 1 ? 0 : 1;
                aVar.d = this.d;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                aVar.f = this.f;
                aVar.c = i2;
                return aVar;
            }

            /* JADX INFO: renamed from: f, reason: collision with other method in class */
            public b m58f() {
                b bVar = new b(this);
                int i = this.c;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.d = this.d;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.f = this.f;
                bVar.c = i2;
                return bVar;
            }

            public void g(a aVar) {
                if (aVar == a.j) {
                    return;
                }
                int i = aVar.c;
                if ((i & 1) == 1) {
                    int i2 = aVar.d;
                    this.c = 1 | this.c;
                    this.d = i2;
                }
                if ((i & 2) == 2) {
                    int i3 = aVar.f;
                    this.c = 2 | this.c;
                    this.f = i3;
                }
                this.b = this.b.d(aVar.b);
            }

            public void g(b bVar) {
                if (bVar == b.j) {
                    return;
                }
                int i = bVar.c;
                if ((i & 1) == 1) {
                    int i2 = bVar.d;
                    this.c = 1 | this.c;
                    this.d = i2;
                }
                if ((i & 2) == 2) {
                    int i3 = bVar.f;
                    this.c = 2 | this.c;
                    this.f = i3;
                }
                this.b = this.b.d(bVar.b);
            }
        }

        static {
            a aVar = new a();
            j = aVar;
            aVar.d = 0;
            aVar.f = 0;
        }

        public a() {
            this.g = (byte) -1;
            this.i = -1;
            this.b = fa.b;
        }

        public a(b bVar) {
            this.g = (byte) -1;
            this.i = -1;
            this.b = bVar.b;
        }

        public a(xd xdVar) {
            this.g = (byte) -1;
            this.i = -1;
            boolean z = false;
            this.d = 0;
            this.f = 0;
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
                            } else if (iN == 16) {
                                this.c |= 2;
                                this.f = xdVar.k();
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
                ydVar.m(1, this.d);
            }
            if ((this.c & 2) == 2) {
                ydVar.m(2, this.f);
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
                iB += yd.b(2, this.f);
            }
            int size = this.b.size() + iB;
            this.i = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            if (this.g == 1) {
                return true;
            }
            this.g = (byte) 1;
            return true;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new b(0);
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            b bVar = new b(0);
            bVar.g(this);
            return bVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx {
        public static final b j;
        public static final ar0.a n = new ar0.a(21);
        public final fa b;
        public int c;
        public int d;
        public int f;
        public byte g;
        public int i;

        static {
            b bVar = new b();
            j = bVar;
            bVar.d = 0;
            bVar.f = 0;
        }

        public b() {
            this.g = (byte) -1;
            this.i = -1;
            this.b = fa.b;
        }

        public b(a.b bVar) {
            this.g = (byte) -1;
            this.i = -1;
            this.b = bVar.b;
        }

        public b(xd xdVar) {
            this.g = (byte) -1;
            this.i = -1;
            boolean z = false;
            this.d = 0;
            this.f = 0;
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
                            } else if (iN == 16) {
                                this.c |= 2;
                                this.f = xdVar.k();
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

        public static a.b e(b bVar) {
            a.b bVar2 = new a.b(1);
            bVar2.g(bVar);
            return bVar2;
        }

        @Override // defpackage.b0
        public final void a(yd ydVar) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                ydVar.m(1, this.d);
            }
            if ((this.c & 2) == 2) {
                ydVar.m(2, this.f);
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
                iB += yd.b(2, this.f);
            }
            int size = this.b.size() + iB;
            this.i = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            if (this.g == 1) {
                return true;
            }
            this.g = (byte) 1;
            return true;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new a.b(1);
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            return e(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends yx {
        public static final c p;
        public static final ar0.a q = new ar0.a(22);
        public final fa b;
        public int c;
        public a d;
        public b f;
        public b g;
        public b i;
        public b j;
        public byte n;
        public int o;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends yx.a implements oh0 {
            public int c;
            public a d = a.j;
            public b f;
            public b g;
            public b i;
            public b j;

            public b() {
                b bVar = b.j;
                this.f = bVar;
                this.g = bVar;
                this.i = bVar;
                this.j = bVar;
            }

            /* JADX WARN: Code duplicated, block: B:14:0x001b  */
            @Override // yx.a
            public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                c cVar;
                try {
                    try {
                        c.q.getClass();
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
                cVarF.isInitialized();
                return cVarF;
            }

            public final Object clone() {
                b bVar = new b();
                bVar.g(f());
                return bVar;
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
                cVar.c = i2;
                return cVar;
            }

            public final void g(c cVar) {
                b bVar;
                b bVar2;
                b bVar3;
                b bVar4;
                a aVar;
                if (cVar == c.p) {
                    return;
                }
                if ((cVar.c & 1) == 1) {
                    a aVarF = cVar.d;
                    if ((this.c & 1) == 1 && (aVar = this.d) != a.j) {
                        a.b bVar5 = new a.b(0);
                        bVar5.g(aVar);
                        bVar5.g(aVarF);
                        aVarF = bVar5.f();
                    }
                    this.d = aVarF;
                    this.c |= 1;
                }
                if ((cVar.c & 2) == 2) {
                    b bVarM58f = cVar.f;
                    if ((this.c & 2) == 2 && (bVar4 = this.f) != b.j) {
                        a.b bVarE = b.e(bVar4);
                        bVarE.g(bVarM58f);
                        bVarM58f = bVarE.m58f();
                    }
                    this.f = bVarM58f;
                    this.c |= 2;
                }
                if ((cVar.c & 4) == 4) {
                    b bVarM58f2 = cVar.g;
                    if ((this.c & 4) == 4 && (bVar3 = this.g) != b.j) {
                        a.b bVarE2 = b.e(bVar3);
                        bVarE2.g(bVarM58f2);
                        bVarM58f2 = bVarE2.m58f();
                    }
                    this.g = bVarM58f2;
                    this.c |= 4;
                }
                if ((cVar.c & 8) == 8) {
                    b bVarM58f3 = cVar.i;
                    if ((this.c & 8) == 8 && (bVar2 = this.i) != b.j) {
                        a.b bVarE3 = b.e(bVar2);
                        bVarE3.g(bVarM58f3);
                        bVarM58f3 = bVarE3.m58f();
                    }
                    this.i = bVarM58f3;
                    this.c |= 8;
                }
                if ((cVar.c & 16) == 16) {
                    b bVarM58f4 = cVar.j;
                    if ((this.c & 16) == 16 && (bVar = this.j) != b.j) {
                        a.b bVarE4 = b.e(bVar);
                        bVarE4.g(bVarM58f4);
                        bVarM58f4 = bVarE4.m58f();
                    }
                    this.j = bVarM58f4;
                    this.c |= 16;
                }
                this.b = this.b.d(cVar.b);
            }
        }

        static {
            c cVar = new c();
            p = cVar;
            cVar.d = a.j;
            b bVar = b.j;
            cVar.f = bVar;
            cVar.g = bVar;
            cVar.i = bVar;
            cVar.j = bVar;
        }

        public c() {
            this.n = (byte) -1;
            this.o = -1;
            this.b = fa.b;
        }

        public c(b bVar) {
            this.n = (byte) -1;
            this.o = -1;
            this.b = bVar.b;
        }

        public c(xd xdVar, ps psVar) {
            int i;
            this.n = (byte) -1;
            this.o = -1;
            this.d = a.j;
            b bVar = b.j;
            this.f = bVar;
            this.g = bVar;
            this.i = bVar;
            this.j = bVar;
            fa.b bVar2 = new fa.b();
            yd ydVarJ = yd.j(bVar2, 1);
            int i2 = 0;
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iN = xdVar.n();
                        if (iN != 0) {
                            a.b bVarE = null;
                            if (iN != 10) {
                                if (iN == 18) {
                                    i = 2;
                                    if ((this.c & 2) == 2) {
                                        b bVar3 = this.f;
                                        bVar3.getClass();
                                        bVarE = b.e(bVar3);
                                    }
                                    b bVar4 = (b) xdVar.g(b.n, psVar);
                                    this.f = bVar4;
                                    if (bVarE != null) {
                                        bVarE.g(bVar4);
                                        this.f = bVarE.m58f();
                                    }
                                } else if (iN == 26) {
                                    i = 4;
                                    if ((this.c & 4) == 4) {
                                        b bVar5 = this.g;
                                        bVar5.getClass();
                                        bVarE = b.e(bVar5);
                                    }
                                    b bVar6 = (b) xdVar.g(b.n, psVar);
                                    this.g = bVar6;
                                    if (bVarE != null) {
                                        bVarE.g(bVar6);
                                        this.g = bVarE.m58f();
                                    }
                                } else if (iN == 34) {
                                    i = 8;
                                    if ((this.c & 8) == 8) {
                                        b bVar7 = this.i;
                                        bVar7.getClass();
                                        bVarE = b.e(bVar7);
                                    }
                                    b bVar8 = (b) xdVar.g(b.n, psVar);
                                    this.i = bVar8;
                                    if (bVarE != null) {
                                        bVarE.g(bVar8);
                                        this.i = bVarE.m58f();
                                    }
                                } else if (iN == 42) {
                                    i = 16;
                                    if ((this.c & 16) == 16) {
                                        b bVar9 = this.j;
                                        bVar9.getClass();
                                        bVarE = b.e(bVar9);
                                    }
                                    b bVar10 = (b) xdVar.g(b.n, psVar);
                                    this.j = bVar10;
                                    if (bVarE != null) {
                                        bVarE.g(bVar10);
                                        this.j = bVarE.m58f();
                                    }
                                } else if (!xdVar.q(iN, ydVarJ)) {
                                }
                                this.c |= i;
                            } else {
                                if ((this.c & 1) == 1) {
                                    a aVar = this.d;
                                    aVar.getClass();
                                    bVarE = new a.b(i2);
                                    bVarE.g(aVar);
                                }
                                a aVar2 = (a) xdVar.g(a.n, psVar);
                                this.d = aVar2;
                                if (bVarE != null) {
                                    bVarE.g(aVar2);
                                    this.d = bVarE.f();
                                }
                                this.c |= 1;
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
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
            try {
                ydVarJ.k();
            } catch (IOException unused2) {
            } finally {
                this.b = bVar2.c();
            }
        }

        @Override // defpackage.b0
        public final void a(yd ydVar) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                ydVar.o(1, this.d);
            }
            if ((this.c & 2) == 2) {
                ydVar.o(2, this.f);
            }
            if ((this.c & 4) == 4) {
                ydVar.o(3, this.g);
            }
            if ((this.c & 8) == 8) {
                ydVar.o(4, this.i);
            }
            if ((this.c & 16) == 16) {
                ydVar.o(5, this.j);
            }
            ydVar.r(this.b);
        }

        @Override // defpackage.b0
        public final int getSerializedSize() {
            int i = this.o;
            if (i != -1) {
                return i;
            }
            int iD = (this.c & 1) == 1 ? yd.d(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iD += yd.d(2, this.f);
            }
            if ((this.c & 4) == 4) {
                iD += yd.d(3, this.g);
            }
            if ((this.c & 8) == 8) {
                iD += yd.d(4, this.i);
            }
            if ((this.c & 16) == 16) {
                iD += yd.d(5, this.j);
            }
            int size = this.b.size() + iD;
            this.o = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            if (this.n == 1) {
                return true;
            }
            this.n = (byte) 1;
            return true;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new b();
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            b bVar = new b();
            bVar.g(this);
            return bVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends yx {
        public static final d j;
        public static final ar0.a n = new ar0.a(23);
        public final fa b;
        public List c;
        public List d;
        public int f;
        public byte g;
        public int i;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends yx.a implements oh0 {
            public int c;
            public List d;
            public List f;

            public b() {
                List list = Collections.EMPTY_LIST;
                this.d = list;
                this.f = list;
            }

            /* JADX WARN: Code duplicated, block: B:14:0x001b  */
            @Override // yx.a
            public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                d dVar;
                try {
                    try {
                        d.n.getClass();
                        g(new d(xdVar, psVar));
                        return this;
                    } catch (t30 e) {
                        dVar = (d) e.b;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            if (dVar != null) {
                                g(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dVar = null;
                    if (dVar != null) {
                        g(dVar);
                    }
                    throw th;
                }
            }

            @Override // yx.a
            public final b0 build() {
                d dVarF = f();
                dVarF.isInitialized();
                return dVarF;
            }

            public final Object clone() {
                b bVar = new b();
                bVar.g(f());
                return bVar;
            }

            @Override // yx.a
            public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
                g((d) yxVar);
                return this;
            }

            public final d f() {
                d dVar = new d(this);
                if ((this.c & 1) == 1) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.c &= -2;
                }
                dVar.c = this.d;
                if ((this.c & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.c &= -3;
                }
                dVar.d = this.f;
                return dVar;
            }

            public final void g(d dVar) {
                if (dVar == d.j) {
                    return;
                }
                if (!dVar.c.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = dVar.c;
                        this.c &= -2;
                    } else {
                        if ((this.c & 1) != 1) {
                            this.d = new ArrayList(this.d);
                            this.c |= 1;
                        }
                        this.d.addAll(dVar.c);
                    }
                }
                if (!dVar.d.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = dVar.d;
                        this.c &= -3;
                    } else {
                        if ((this.c & 2) != 2) {
                            this.f = new ArrayList(this.f);
                            this.c |= 2;
                        }
                        this.f.addAll(dVar.d);
                    }
                }
                this.b = this.b.d(dVar.b);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class c extends yx {
            public static final c s;
            public static final ar0.a t = new ar0.a(24);
            public final fa b;
            public int c;
            public int d;
            public int f;
            public Object g;
            public EnumC0046c i;
            public List j;
            public int n;
            public List o;
            public int p;
            public byte q;
            public int r;

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public final class b extends yx.a implements oh0 {
                public int c;
                public int f;
                public List j;
                public List n;
                public int d = 1;
                public Object g = AppConfig.CUSTOM;
                public EnumC0046c i = EnumC0046c.c;

                public b() {
                    List list = Collections.EMPTY_LIST;
                    this.j = list;
                    this.n = list;
                }

                /* JADX WARN: Code duplicated, block: B:14:0x001b  */
                @Override // yx.a
                public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                    c cVar;
                    try {
                        try {
                            c.t.getClass();
                            g(new c(xdVar));
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
                    cVarF.isInitialized();
                    return cVarF;
                }

                public final Object clone() {
                    b bVar = new b();
                    bVar.g(f());
                    return bVar;
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
                        this.j = Collections.unmodifiableList(this.j);
                        this.c &= -17;
                    }
                    cVar.j = this.j;
                    if ((this.c & 32) == 32) {
                        this.n = Collections.unmodifiableList(this.n);
                        this.c &= -33;
                    }
                    cVar.o = this.n;
                    cVar.c = i2;
                    return cVar;
                }

                public final void g(c cVar) {
                    if (cVar == c.s) {
                        return;
                    }
                    int i = cVar.c;
                    if ((i & 1) == 1) {
                        int i2 = cVar.d;
                        this.c = 1 | this.c;
                        this.d = i2;
                    }
                    if ((i & 2) == 2) {
                        int i3 = cVar.f;
                        this.c = 2 | this.c;
                        this.f = i3;
                    }
                    if ((i & 4) == 4) {
                        this.c |= 4;
                        this.g = cVar.g;
                    }
                    if ((i & 8) == 8) {
                        EnumC0046c enumC0046c = cVar.i;
                        enumC0046c.getClass();
                        this.c = 8 | this.c;
                        this.i = enumC0046c;
                    }
                    if (!cVar.j.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = cVar.j;
                            this.c &= -17;
                        } else {
                            if ((this.c & 16) != 16) {
                                this.j = new ArrayList(this.j);
                                this.c |= 16;
                            }
                            this.j.addAll(cVar.j);
                        }
                    }
                    if (!cVar.o.isEmpty()) {
                        if (this.n.isEmpty()) {
                            this.n = cVar.o;
                            this.c &= -33;
                        } else {
                            if ((this.c & 32) != 32) {
                                this.n = new ArrayList(this.n);
                                this.c |= 32;
                            }
                            this.n.addAll(cVar.o);
                        }
                    }
                    this.b = this.b.d(cVar.b);
                }
            }

            /* JADX INFO: renamed from: w80$d$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public enum EnumC0046c implements h30.a {
                c("NONE"),
                d("INTERNAL_TO_CLASS_ID"),
                f("DESC_TO_CLASS_ID");

                public final int b;

                EnumC0046c(String str) {
                    this.b = i;
                }

                @Override // h30.a
                public final int getNumber() {
                    return this.b;
                }
            }

            static {
                c cVar = new c();
                s = cVar;
                cVar.d = 1;
                cVar.f = 0;
                cVar.g = AppConfig.CUSTOM;
                cVar.i = EnumC0046c.c;
                List list = Collections.EMPTY_LIST;
                cVar.j = list;
                cVar.o = list;
            }

            public c() {
                this.n = -1;
                this.p = -1;
                this.q = (byte) -1;
                this.r = -1;
                this.b = fa.b;
            }

            public c(b bVar) {
                this.n = -1;
                this.p = -1;
                this.q = (byte) -1;
                this.r = -1;
                this.b = bVar.b;
            }

            public c(xd xdVar) {
                List list;
                int iD;
                this.n = -1;
                this.p = -1;
                this.q = (byte) -1;
                this.r = -1;
                this.d = 1;
                boolean z = false;
                this.f = 0;
                this.g = AppConfig.CUSTOM;
                EnumC0046c enumC0046c = EnumC0046c.c;
                this.i = enumC0046c;
                List list2 = Collections.EMPTY_LIST;
                this.j = list2;
                this.o = list2;
                fa.b bVar = new fa.b();
                yd ydVarJ = yd.j(bVar, 1);
                int i = 0;
                while (!z) {
                    try {
                        try {
                            int iN = xdVar.n();
                            if (iN != 0) {
                                if (iN == 8) {
                                    this.c |= 1;
                                    this.d = xdVar.k();
                                } else if (iN == 16) {
                                    this.c |= 2;
                                    this.f = xdVar.k();
                                } else if (iN != 24) {
                                    if (iN != 32) {
                                        if (iN == 34) {
                                            iD = xdVar.d(xdVar.k());
                                            if ((i & 16) != 16 && xdVar.b() > 0) {
                                                this.j = new ArrayList();
                                                i |= 16;
                                            }
                                            while (xdVar.b() > 0) {
                                                this.j.add(Integer.valueOf(xdVar.k()));
                                            }
                                        } else if (iN == 40) {
                                            if ((i & 32) != 32) {
                                                this.o = new ArrayList();
                                                i |= 32;
                                            }
                                            list = this.o;
                                        } else if (iN == 42) {
                                            iD = xdVar.d(xdVar.k());
                                            if ((i & 32) != 32 && xdVar.b() > 0) {
                                                this.o = new ArrayList();
                                                i |= 32;
                                            }
                                            while (xdVar.b() > 0) {
                                                this.o.add(Integer.valueOf(xdVar.k()));
                                            }
                                        } else if (iN == 50) {
                                            we0 we0VarE = xdVar.e();
                                            this.c |= 4;
                                            this.g = we0VarE;
                                        } else if (!xdVar.q(iN, ydVarJ)) {
                                        }
                                        xdVar.c(iD);
                                    } else {
                                        if ((i & 16) != 16) {
                                            this.j = new ArrayList();
                                            i |= 16;
                                        }
                                        list = this.j;
                                    }
                                    list.add(Integer.valueOf(xdVar.k()));
                                } else {
                                    int iK = xdVar.k();
                                    EnumC0046c enumC0046c2 = iK != 0 ? iK != 1 ? iK != 2 ? null : EnumC0046c.f : EnumC0046c.d : enumC0046c;
                                    if (enumC0046c2 == null) {
                                        ydVarJ.v(iN);
                                        ydVarJ.v(iK);
                                    } else {
                                        this.c |= 8;
                                        this.i = enumC0046c2;
                                    }
                                }
                            }
                            z = true;
                        } catch (Throwable th) {
                            if ((i & 16) == 16) {
                                this.j = Collections.unmodifiableList(this.j);
                            }
                            if ((i & 32) == 32) {
                                this.o = Collections.unmodifiableList(this.o);
                            }
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
                if ((i & 16) == 16) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if ((i & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
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
                fa we0Var;
                getSerializedSize();
                if ((this.c & 1) == 1) {
                    ydVar.m(1, this.d);
                }
                if ((this.c & 2) == 2) {
                    ydVar.m(2, this.f);
                }
                if ((this.c & 8) == 8) {
                    ydVar.l(3, this.i.b);
                }
                if (this.j.size() > 0) {
                    ydVar.v(34);
                    ydVar.v(this.n);
                }
                for (int i = 0; i < this.j.size(); i++) {
                    ydVar.n(((Integer) this.j.get(i)).intValue());
                }
                if (this.o.size() > 0) {
                    ydVar.v(42);
                    ydVar.v(this.p);
                }
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    ydVar.n(((Integer) this.o.get(i2)).intValue());
                }
                if ((this.c & 4) == 4) {
                    Object obj = this.g;
                    if (obj instanceof String) {
                        try {
                            we0Var = new we0(((String) obj).getBytes("UTF-8"));
                            this.g = we0Var;
                        } catch (UnsupportedEncodingException e) {
                            defpackage.d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                            return;
                        }
                    } else {
                        we0Var = (fa) obj;
                    }
                    ydVar.x(6, 2);
                    ydVar.v(we0Var.size());
                    ydVar.r(we0Var);
                }
                ydVar.r(this.b);
            }

            @Override // defpackage.b0
            public final int getSerializedSize() {
                List list;
                List list2;
                fa we0Var;
                int i = this.r;
                if (i != -1) {
                    return i;
                }
                int iB = (this.c & 1) == 1 ? yd.b(1, this.d) : 0;
                if ((this.c & 2) == 2) {
                    iB += yd.b(2, this.f);
                }
                if ((this.c & 8) == 8) {
                    iB += yd.a(3, this.i.b);
                }
                int i2 = 0;
                int iC = 0;
                while (true) {
                    int size = this.j.size();
                    list = this.j;
                    if (i2 >= size) {
                        break;
                    }
                    iC += yd.c(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                int iC2 = iB + iC;
                if (!list.isEmpty()) {
                    iC2 = iC2 + 1 + yd.c(iC);
                }
                this.n = iC;
                int i3 = 0;
                int iC3 = 0;
                while (true) {
                    int size2 = this.o.size();
                    list2 = this.o;
                    if (i3 >= size2) {
                        break;
                    }
                    iC3 += yd.c(((Integer) list2.get(i3)).intValue());
                    i3++;
                }
                int size3 = iC2 + iC3;
                if (!list2.isEmpty()) {
                    size3 = size3 + 1 + yd.c(iC3);
                }
                this.p = iC3;
                if ((this.c & 4) == 4) {
                    Object obj = this.g;
                    if (obj instanceof String) {
                        try {
                            we0Var = new we0(((String) obj).getBytes("UTF-8"));
                            this.g = we0Var;
                        } catch (UnsupportedEncodingException e) {
                            defpackage.d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                            return 0;
                        }
                    } else {
                        we0Var = (fa) obj;
                    }
                    size3 += we0Var.size() + yd.f(we0Var.size()) + yd.h(6);
                }
                int size4 = this.b.size() + size3;
                this.r = size4;
                return size4;
            }

            @Override // defpackage.oh0
            public final boolean isInitialized() {
                if (this.q == 1) {
                    return true;
                }
                this.q = (byte) 1;
                return true;
            }

            @Override // defpackage.b0
            public final yx.a newBuilderForType() {
                return new b();
            }

            @Override // defpackage.b0
            public final yx.a toBuilder() {
                b bVar = new b();
                bVar.g(this);
                return bVar;
            }
        }

        static {
            d dVar = new d();
            j = dVar;
            List list = Collections.EMPTY_LIST;
            dVar.c = list;
            dVar.d = list;
        }

        public d() {
            this.f = -1;
            this.g = (byte) -1;
            this.i = -1;
            this.b = fa.b;
        }

        public d(b bVar) {
            this.f = -1;
            this.g = (byte) -1;
            this.i = -1;
            this.b = bVar.b;
        }

        public d(xd xdVar, ps psVar) {
            List list;
            Object objG;
            this.f = -1;
            this.g = (byte) -1;
            this.i = -1;
            List list2 = Collections.EMPTY_LIST;
            this.c = list2;
            this.d = list2;
            fa.b bVar = new fa.b();
            yd ydVarJ = yd.j(bVar, 1);
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        try {
                            int iN = xdVar.n();
                            if (iN != 0) {
                                if (iN == 10) {
                                    if ((i & 1) != 1) {
                                        this.c = new ArrayList();
                                        i |= 1;
                                    }
                                    list = this.c;
                                    objG = xdVar.g(c.t, psVar);
                                } else if (iN == 40) {
                                    if ((i & 2) != 2) {
                                        this.d = new ArrayList();
                                        i |= 2;
                                    }
                                    list = this.d;
                                    objG = Integer.valueOf(xdVar.k());
                                } else if (iN == 42) {
                                    int iD = xdVar.d(xdVar.k());
                                    if ((i & 2) != 2 && xdVar.b() > 0) {
                                        this.d = new ArrayList();
                                        i |= 2;
                                    }
                                    while (xdVar.b() > 0) {
                                        this.d.add(Integer.valueOf(xdVar.k()));
                                    }
                                    xdVar.c(iD);
                                } else if (!xdVar.q(iN, ydVarJ)) {
                                }
                                list.add(objG);
                            }
                            z = true;
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
                    if ((i & 1) == 1) {
                        this.c = Collections.unmodifiableList(this.c);
                    }
                    if ((i & 2) == 2) {
                        this.d = Collections.unmodifiableList(this.d);
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
            if ((i & 1) == 1) {
                this.c = Collections.unmodifiableList(this.c);
            }
            if ((i & 2) == 2) {
                this.d = Collections.unmodifiableList(this.d);
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
            for (int i = 0; i < this.c.size(); i++) {
                ydVar.o(1, (b0) this.c.get(i));
            }
            if (this.d.size() > 0) {
                ydVar.v(42);
                ydVar.v(this.f);
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                ydVar.n(((Integer) this.d.get(i2)).intValue());
            }
            ydVar.r(this.b);
        }

        @Override // defpackage.b0
        public final int getSerializedSize() {
            List list;
            int i = this.i;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int iD = 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                iD += yd.d(1, (b0) this.c.get(i3));
            }
            int iC = 0;
            while (true) {
                int size = this.d.size();
                list = this.d;
                if (i2 >= size) {
                    break;
                }
                iC += yd.c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            int iC2 = iD + iC;
            if (!list.isEmpty()) {
                iC2 = iC2 + 1 + yd.c(iC);
            }
            this.f = iC;
            int size2 = this.b.size() + iC2;
            this.i = size2;
            return size2;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            if (this.g == 1) {
                return true;
            }
            this.g = (byte) 1;
            return true;
        }

        @Override // defpackage.b0
        public final yx.a newBuilderForType() {
            return new b();
        }

        @Override // defpackage.b0
        public final yx.a toBuilder() {
            b bVar = new b();
            bVar.g(this);
            return bVar;
        }
    }

    static {
        ar0 ar0Var = ar0.o;
        b bVar = b.j;
        kg1.c cVar = kg1.i;
        a = yx.d(ar0Var, bVar, bVar, 100, cVar, b.class);
        fr0 fr0Var = fr0.x;
        b = yx.d(fr0Var, bVar, bVar, 100, cVar, b.class);
        kg1 kg1Var = kg1.d;
        c = yx.d(fr0Var, 0, null, 101, kg1Var, Integer.class);
        kr0 kr0Var = kr0.x;
        c cVar2 = c.p;
        d = yx.d(kr0Var, cVar2, cVar2, 100, cVar, c.class);
        e = yx.d(kr0Var, 0, null, 101, kg1Var, Integer.class);
        nr0 nr0Var = nr0.z;
        yq0 yq0Var = yq0.j;
        f = yx.c(nr0Var, yq0Var, 100, cVar, yq0.class);
        g = yx.d(nr0Var, Boolean.FALSE, null, 101, kg1.f, Boolean.class);
        h = yx.c(pr0.s, yq0Var, 100, cVar, yq0.class);
        zq0 zq0Var = zq0.H;
        i = yx.d(zq0Var, 0, null, 101, kg1Var, Integer.class);
        j = yx.c(zq0Var, kr0Var, 102, cVar, kr0.class);
        k = yx.d(zq0Var, 0, null, 103, kg1Var, Integer.class);
        l = yx.d(zq0Var, 0, null, 104, kg1Var, Integer.class);
        ir0 ir0Var = ir0.q;
        m = yx.d(ir0Var, 0, null, 101, kg1Var, Integer.class);
        n = yx.c(ir0Var, kr0Var, 102, cVar, kr0.class);
    }
}
