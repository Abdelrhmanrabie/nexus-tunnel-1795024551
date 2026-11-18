package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rr0 extends yx.c {
    public static final rr0 r;
    public static final ar0.a s = new ar0.a(17);
    public final fa c;
    public int d;
    public int f;
    public int g;
    public nr0 i;
    public int j;
    public nr0 n;
    public int o;
    public byte p;
    public int q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g;
        public int i;
        public nr0 j;
        public int n;
        public nr0 o;
        public int p;

        public b() {
            nr0 nr0Var = nr0.z;
            this.j = nr0Var;
            this.o = nr0Var;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            rr0 rr0Var;
            try {
                try {
                    rr0.s.getClass();
                    h(new rr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    rr0Var = (rr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (rr0Var != null) {
                            h(rr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                rr0Var = null;
                if (rr0Var != null) {
                    h(rr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            rr0 rr0VarG = g();
            if (rr0VarG.isInitialized()) {
                return rr0VarG;
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
            h((rr0) yxVar);
            return this;
        }

        public final rr0 g() {
            rr0 rr0Var = new rr0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            rr0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            rr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            rr0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            rr0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            rr0Var.n = this.o;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            rr0Var.o = this.p;
            rr0Var.d = i2;
            return rr0Var;
        }

        public final void h(rr0 rr0Var) {
            nr0 nr0Var;
            nr0 nr0Var2;
            if (rr0Var == rr0.r) {
                return;
            }
            int i = rr0Var.d;
            if ((i & 1) == 1) {
                int i2 = rr0Var.f;
                this.f = 1 | this.f;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = rr0Var.g;
                this.f = 2 | this.f;
                this.i = i3;
            }
            if ((i & 4) == 4) {
                nr0 nr0VarG = rr0Var.i;
                if ((this.f & 4) == 4 && (nr0Var2 = this.j) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var2);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.j = nr0VarG;
                this.f |= 4;
            }
            int i4 = rr0Var.d;
            if ((i4 & 8) == 8) {
                int i5 = rr0Var.j;
                this.f = 8 | this.f;
                this.n = i5;
            }
            if ((i4 & 16) == 16) {
                nr0 nr0VarG2 = rr0Var.n;
                if ((this.f & 16) == 16 && (nr0Var = this.o) != nr0.z) {
                    nr0.c cVarO2 = nr0.o(nr0Var);
                    cVarO2.h(nr0VarG2);
                    nr0VarG2 = cVarO2.g();
                }
                this.o = nr0VarG2;
                this.f |= 16;
            }
            if ((rr0Var.d & 32) == 32) {
                int i6 = rr0Var.o;
                this.f = 32 | this.f;
                this.p = i6;
            }
            f(rr0Var);
            this.b = this.b.d(rr0Var.c);
        }
    }

    static {
        rr0 rr0Var = new rr0();
        r = rr0Var;
        rr0Var.f = 0;
        rr0Var.g = 0;
        nr0 nr0Var = nr0.z;
        rr0Var.i = nr0Var;
        rr0Var.j = 0;
        rr0Var.n = nr0Var;
        rr0Var.o = 0;
    }

    public rr0() {
        this.p = (byte) -1;
        this.q = -1;
        this.c = fa.b;
    }

    public rr0(b bVar) {
        super(bVar);
        this.p = (byte) -1;
        this.q = -1;
        this.c = bVar.b;
    }

    public rr0(xd xdVar, ps psVar) {
        this.p = (byte) -1;
        this.q = -1;
        boolean z = false;
        this.f = 0;
        this.g = 0;
        nr0 nr0Var = nr0.z;
        this.i = nr0Var;
        this.j = 0;
        this.n = nr0Var;
        this.o = 0;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.d |= 1;
                            this.f = xdVar.k();
                        } else if (iN != 16) {
                            nr0.c cVarO = null;
                            if (iN == 26) {
                                if ((this.d & 4) == 4) {
                                    nr0 nr0Var2 = this.i;
                                    nr0Var2.getClass();
                                    cVarO = nr0.o(nr0Var2);
                                }
                                nr0 nr0Var3 = (nr0) xdVar.g(nr0.A, psVar);
                                this.i = nr0Var3;
                                if (cVarO != null) {
                                    cVarO.h(nr0Var3);
                                    this.i = cVarO.g();
                                }
                                this.d |= 4;
                            } else if (iN == 34) {
                                if ((this.d & 16) == 16) {
                                    nr0 nr0Var4 = this.n;
                                    nr0Var4.getClass();
                                    cVarO = nr0.o(nr0Var4);
                                }
                                nr0 nr0Var5 = (nr0) xdVar.g(nr0.A, psVar);
                                this.n = nr0Var5;
                                if (cVarO != null) {
                                    cVarO.h(nr0Var5);
                                    this.n = cVarO.g();
                                }
                                this.d |= 16;
                            } else if (iN == 40) {
                                this.d |= 8;
                                this.j = xdVar.k();
                            } else if (iN == 48) {
                                this.d |= 32;
                                this.o = xdVar.k();
                            } else if (!k(xdVar, ydVarJ, psVar, iN)) {
                            }
                        } else {
                            this.d |= 2;
                            this.g = xdVar.k();
                        }
                    }
                    z = true;
                } catch (Throwable th) {
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
            ydVar.o(3, this.i);
        }
        if ((this.d & 16) == 16) {
            ydVar.o(4, this.n);
        }
        if ((this.d & 8) == 8) {
            ydVar.m(5, this.j);
        }
        if ((this.d & 32) == 32) {
            ydVar.m(6, this.o);
        }
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return r;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.q;
        if (i != -1) {
            return i;
        }
        int iB = (this.d & 1) == 1 ? yd.b(1, this.f) : 0;
        if ((this.d & 2) == 2) {
            iB += yd.b(2, this.g);
        }
        if ((this.d & 4) == 4) {
            iB += yd.d(3, this.i);
        }
        if ((this.d & 16) == 16) {
            iB += yd.d(4, this.n);
        }
        if ((this.d & 8) == 8) {
            iB += yd.b(5, this.j);
        }
        if ((this.d & 32) == 32) {
            iB += yd.b(6, this.o);
        }
        int size = this.c.size() + f() + iB;
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
        int i = this.d;
        if ((i & 2) != 2) {
            this.p = (byte) 0;
            return false;
        }
        if ((i & 4) == 4 && !this.i.isInitialized()) {
            this.p = (byte) 0;
            return false;
        }
        if ((this.d & 16) == 16 && !this.n.isInitialized()) {
            this.p = (byte) 0;
            return false;
        }
        if (e()) {
            this.p = (byte) 1;
            return true;
        }
        this.p = (byte) 0;
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
