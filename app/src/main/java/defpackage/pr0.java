package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pr0 extends yx.c {
    public static final pr0 s;
    public static final ar0.a t = new ar0.a(15);
    public final fa c;
    public int d;
    public int f;
    public int g;
    public boolean i;
    public c j;
    public List n;
    public List o;
    public int p;
    public byte q;
    public int r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g;
        public int i;
        public boolean j;
        public c n = c.f;
        public List o;
        public List p;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.o = list;
            this.p = list;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            pr0 pr0Var;
            try {
                try {
                    pr0.t.getClass();
                    h(new pr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    pr0Var = (pr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (pr0Var != null) {
                            h(pr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                pr0Var = null;
                if (pr0Var != null) {
                    h(pr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            pr0 pr0VarG = g();
            if (pr0VarG.isInitialized()) {
                return pr0VarG;
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
            h((pr0) yxVar);
            return this;
        }

        public final pr0 g() {
            pr0 pr0Var = new pr0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            pr0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            pr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            pr0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            pr0Var.j = this.n;
            if ((i & 16) == 16) {
                this.o = Collections.unmodifiableList(this.o);
                this.f &= -17;
            }
            pr0Var.n = this.o;
            if ((this.f & 32) == 32) {
                this.p = Collections.unmodifiableList(this.p);
                this.f &= -33;
            }
            pr0Var.o = this.p;
            pr0Var.d = i2;
            return pr0Var;
        }

        public final void h(pr0 pr0Var) {
            if (pr0Var == pr0.s) {
                return;
            }
            int i = pr0Var.d;
            if ((i & 1) == 1) {
                int i2 = pr0Var.f;
                this.f = 1 | this.f;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = pr0Var.g;
                this.f = 2 | this.f;
                this.i = i3;
            }
            if ((i & 4) == 4) {
                boolean z = pr0Var.i;
                this.f = 4 | this.f;
                this.j = z;
            }
            if ((i & 8) == 8) {
                c cVar = pr0Var.j;
                cVar.getClass();
                this.f = 8 | this.f;
                this.n = cVar;
            }
            if (!pr0Var.n.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = pr0Var.n;
                    this.f &= -17;
                } else {
                    if ((this.f & 16) != 16) {
                        this.o = new ArrayList(this.o);
                        this.f |= 16;
                    }
                    this.o.addAll(pr0Var.n);
                }
            }
            if (!pr0Var.o.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = pr0Var.o;
                    this.f &= -33;
                } else {
                    if ((this.f & 32) != 32) {
                        this.p = new ArrayList(this.p);
                        this.f |= 32;
                    }
                    this.p.addAll(pr0Var.o);
                }
            }
            f(pr0Var);
            this.b = this.b.d(pr0Var.c);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum c implements h30.a {
        c("IN"),
        d("OUT"),
        f("INV");

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
        pr0 pr0Var = new pr0();
        s = pr0Var;
        pr0Var.f = 0;
        pr0Var.g = 0;
        pr0Var.i = false;
        pr0Var.j = c.f;
        List list = Collections.EMPTY_LIST;
        pr0Var.n = list;
        pr0Var.o = list;
    }

    public pr0() {
        this.p = -1;
        this.q = (byte) -1;
        this.r = -1;
        this.c = fa.b;
    }

    public pr0(b bVar) {
        super(bVar);
        this.p = -1;
        this.q = (byte) -1;
        this.r = -1;
        this.c = bVar.b;
    }

    public pr0(xd xdVar, ps psVar) {
        List list;
        Object objG;
        this.p = -1;
        this.q = (byte) -1;
        this.r = -1;
        this.f = 0;
        this.g = 0;
        this.i = false;
        c cVar = c.f;
        this.j = cVar;
        List list2 = Collections.EMPTY_LIST;
        this.n = list2;
        this.o = list2;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.d |= 1;
                            this.f = xdVar.k();
                        } else if (iN == 16) {
                            this.d |= 2;
                            this.g = xdVar.k();
                        } else if (iN == 24) {
                            this.d |= 4;
                            this.i = xdVar.l() != 0;
                        } else if (iN != 32) {
                            if (iN == 42) {
                                if ((i & 16) != 16) {
                                    this.n = new ArrayList();
                                    i |= 16;
                                }
                                list = this.n;
                                objG = xdVar.g(nr0.A, psVar);
                            } else if (iN == 48) {
                                if ((i & 32) != 32) {
                                    this.o = new ArrayList();
                                    i |= 32;
                                }
                                list = this.o;
                                objG = Integer.valueOf(xdVar.k());
                            } else if (iN == 50) {
                                int iD = xdVar.d(xdVar.k());
                                if ((i & 32) != 32 && xdVar.b() > 0) {
                                    this.o = new ArrayList();
                                    i |= 32;
                                }
                                while (xdVar.b() > 0) {
                                    this.o.add(Integer.valueOf(xdVar.k()));
                                }
                                xdVar.c(iD);
                            } else if (!k(xdVar, ydVarJ, psVar, iN)) {
                            }
                            list.add(objG);
                        } else {
                            int iK = xdVar.k();
                            c cVar2 = iK != 0 ? iK != 1 ? iK != 2 ? null : cVar : c.d : c.c;
                            if (cVar2 == null) {
                                ydVarJ.v(iN);
                                ydVarJ.v(iK);
                            } else {
                                this.d |= 8;
                                this.j = cVar2;
                            }
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
                if ((i & 16) == 16) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if ((i & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
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
        if ((i & 16) == 16) {
            this.n = Collections.unmodifiableList(this.n);
        }
        if ((i & 32) == 32) {
            this.o = Collections.unmodifiableList(this.o);
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
        if ((this.d & 1) == 1) {
            ydVar.m(1, this.f);
        }
        if ((this.d & 2) == 2) {
            ydVar.m(2, this.g);
        }
        if ((this.d & 4) == 4) {
            boolean z = this.i;
            ydVar.x(3, 0);
            ydVar.q(z ? 1 : 0);
        }
        if ((this.d & 8) == 8) {
            ydVar.l(4, this.j.b);
        }
        for (int i = 0; i < this.n.size(); i++) {
            ydVar.o(5, (b0) this.n.get(i));
        }
        if (this.o.size() > 0) {
            ydVar.v(50);
            ydVar.v(this.p);
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            ydVar.n(((Integer) this.o.get(i2)).intValue());
        }
        zl0Var.a(InternalZipConstants.AES_HASH_ITERATIONS, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return s;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        List list;
        int i = this.r;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int iB = (this.d & 1) == 1 ? yd.b(1, this.f) : 0;
        if ((this.d & 2) == 2) {
            iB += yd.b(2, this.g);
        }
        if ((this.d & 4) == 4) {
            iB += yd.h(3) + 1;
        }
        if ((this.d & 8) == 8) {
            iB += yd.a(4, this.j.b);
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            iB += yd.d(5, (b0) this.n.get(i3));
        }
        int iC = 0;
        while (true) {
            int size = this.o.size();
            list = this.o;
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
        this.p = iC;
        int size2 = this.c.size() + f() + iC2;
        this.r = size2;
        return size2;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.q;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        int i = this.d;
        if ((i & 1) != 1) {
            this.q = (byte) 0;
            return false;
        }
        if ((i & 2) != 2) {
            this.q = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if (!((nr0) this.n.get(i2)).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        if (e()) {
            this.q = (byte) 1;
            return true;
        }
        this.q = (byte) 0;
        return false;
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
