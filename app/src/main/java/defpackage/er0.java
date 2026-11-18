package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class er0 extends yx {
    public static final er0 r;
    public static final ar0.a s = new ar0.a(4);
    public final fa b;
    public int c;
    public int d;
    public int f;
    public c g;
    public nr0 i;
    public int j;
    public List n;
    public List o;
    public byte p;
    public int q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.a implements oh0 {
        public int c;
        public int d;
        public int f;
        public c g = c.c;
        public nr0 i = nr0.z;
        public int j;
        public List n;
        public List o;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.n = list;
            this.o = list;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            er0 er0Var;
            try {
                try {
                    er0.s.getClass();
                    g(new er0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    er0Var = (er0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (er0Var != null) {
                            g(er0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                er0Var = null;
                if (er0Var != null) {
                    g(er0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            er0 er0VarF = f();
            if (er0VarF.isInitialized()) {
                return er0VarF;
            }
            throw new we();
        }

        public final Object clone() {
            b bVar = new b();
            bVar.g(f());
            return bVar;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            g((er0) yxVar);
            return this;
        }

        public final er0 f() {
            er0 er0Var = new er0(this);
            int i = this.c;
            int i2 = (i & 1) != 1 ? 0 : 1;
            er0Var.d = this.d;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            er0Var.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            er0Var.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            er0Var.i = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            er0Var.j = this.j;
            if ((i & 32) == 32) {
                this.n = Collections.unmodifiableList(this.n);
                this.c &= -33;
            }
            er0Var.n = this.n;
            if ((this.c & 64) == 64) {
                this.o = Collections.unmodifiableList(this.o);
                this.c &= -65;
            }
            er0Var.o = this.o;
            er0Var.c = i2;
            return er0Var;
        }

        public final void g(er0 er0Var) {
            nr0 nr0Var;
            if (er0Var == er0.r) {
                return;
            }
            int i = er0Var.c;
            if ((i & 1) == 1) {
                int i2 = er0Var.d;
                this.c = 1 | this.c;
                this.d = i2;
            }
            if ((i & 2) == 2) {
                int i3 = er0Var.f;
                this.c = 2 | this.c;
                this.f = i3;
            }
            if ((i & 4) == 4) {
                c cVar = er0Var.g;
                cVar.getClass();
                this.c = 4 | this.c;
                this.g = cVar;
            }
            if ((er0Var.c & 8) == 8) {
                nr0 nr0VarG = er0Var.i;
                if ((this.c & 8) == 8 && (nr0Var = this.i) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.i = nr0VarG;
                this.c |= 8;
            }
            if ((er0Var.c & 16) == 16) {
                int i4 = er0Var.j;
                this.c = 16 | this.c;
                this.j = i4;
            }
            if (!er0Var.n.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = er0Var.n;
                    this.c &= -33;
                } else {
                    if ((this.c & 32) != 32) {
                        this.n = new ArrayList(this.n);
                        this.c |= 32;
                    }
                    this.n.addAll(er0Var.n);
                }
            }
            if (!er0Var.o.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = er0Var.o;
                    this.c &= -65;
                } else {
                    if ((this.c & 64) != 64) {
                        this.o = new ArrayList(this.o);
                        this.c |= 64;
                    }
                    this.o.addAll(er0Var.o);
                }
            }
            this.b = this.b.d(er0Var.b);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum c implements h30.a {
        c("TRUE"),
        d("FALSE"),
        f("NULL");

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
        er0 er0Var = new er0();
        r = er0Var;
        er0Var.d = 0;
        er0Var.f = 0;
        er0Var.g = c.c;
        er0Var.i = nr0.z;
        er0Var.j = 0;
        List list = Collections.EMPTY_LIST;
        er0Var.n = list;
        er0Var.o = list;
    }

    public er0() {
        this.p = (byte) -1;
        this.q = -1;
        this.b = fa.b;
    }

    public er0(b bVar) {
        this.p = (byte) -1;
        this.q = -1;
        this.b = bVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public er0(xd xdVar, ps psVar) {
        List list;
        c cVar;
        this.p = (byte) -1;
        this.q = -1;
        boolean z = false;
        this.d = 0;
        this.f = 0;
        c cVar2 = c.c;
        this.g = cVar2;
        this.i = nr0.z;
        this.j = 0;
        List list2 = Collections.EMPTY_LIST;
        this.n = list2;
        this.o = list2;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        int i = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iN = xdVar.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.c |= 1;
                                this.d = xdVar.k();
                            } else if (iN != 16) {
                                Object objO = null;
                                if (iN == 24) {
                                    int iK = xdVar.k();
                                    if (iK != 0) {
                                        if (iK == 1) {
                                            objO = c.d;
                                        } else if (iK == 2) {
                                            objO = c.f;
                                        }
                                        cVar = objO;
                                    } else {
                                        cVar = cVar2;
                                    }
                                    if (cVar == 0) {
                                        ydVarJ.v(iN);
                                        ydVarJ.v(iK);
                                    } else {
                                        this.c |= 4;
                                        this.g = cVar;
                                    }
                                } else if (iN == 34) {
                                    if ((this.c & 8) == 8) {
                                        nr0 nr0Var = this.i;
                                        nr0Var.getClass();
                                        objO = nr0.o(nr0Var);
                                    }
                                    nr0.c cVar3 = objO;
                                    nr0 nr0Var2 = (nr0) xdVar.g(nr0.A, psVar);
                                    this.i = nr0Var2;
                                    if (cVar3 != 0) {
                                        cVar3.h(nr0Var2);
                                        this.i = cVar3.g();
                                    }
                                    this.c |= 8;
                                } else if (iN != 40) {
                                    ar0.a aVar = s;
                                    if (iN == 50) {
                                        if ((i & 32) != 32) {
                                            this.n = new ArrayList();
                                            i |= 32;
                                        }
                                        list = this.n;
                                    } else if (iN == 58) {
                                        if ((i & 64) != 64) {
                                            this.o = new ArrayList();
                                            i |= 64;
                                        }
                                        list = this.o;
                                    } else if (!xdVar.q(iN, ydVarJ)) {
                                    }
                                    list.add(xdVar.g(aVar, psVar));
                                } else {
                                    this.c |= 16;
                                    this.j = xdVar.k();
                                }
                            } else {
                                this.c |= 2;
                                this.f = xdVar.k();
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        t30 t30Var = new t30(e.getMessage());
                        t30Var.b = this;
                        throw t30Var;
                    }
                } catch (t30 e2) {
                    e2.b = this;
                    throw e2;
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if ((i & 64) == 64) {
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
        }
        if ((i & 32) == 32) {
            this.n = Collections.unmodifiableList(this.n);
        }
        if ((i & 64) == 64) {
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
        getSerializedSize();
        if ((this.c & 1) == 1) {
            ydVar.m(1, this.d);
        }
        if ((this.c & 2) == 2) {
            ydVar.m(2, this.f);
        }
        if ((this.c & 4) == 4) {
            ydVar.l(3, this.g.b);
        }
        if ((this.c & 8) == 8) {
            ydVar.o(4, this.i);
        }
        if ((this.c & 16) == 16) {
            ydVar.m(5, this.j);
        }
        for (int i = 0; i < this.n.size(); i++) {
            ydVar.o(6, (b0) this.n.get(i));
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            ydVar.o(7, (b0) this.o.get(i2));
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.q;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? yd.b(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iB += yd.b(2, this.f);
        }
        if ((this.c & 4) == 4) {
            iB += yd.a(3, this.g.b);
        }
        if ((this.c & 8) == 8) {
            iB += yd.d(4, this.i);
        }
        if ((this.c & 16) == 16) {
            iB += yd.b(5, this.j);
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            iB += yd.d(6, (b0) this.n.get(i2));
        }
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            iB += yd.d(7, (b0) this.o.get(i3));
        }
        int size = this.b.size() + iB;
        this.q = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.p;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if ((this.c & 8) == 8 && !this.i.isInitialized()) {
            this.p = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.n.size(); i++) {
            if (!((er0) this.n.get(i)).isInitialized()) {
                this.p = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            if (!((er0) this.o.get(i2)).isInitialized()) {
                this.p = (byte) 0;
                return false;
            }
        }
        this.p = (byte) 1;
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
