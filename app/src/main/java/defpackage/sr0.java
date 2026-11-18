package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sr0 extends yx {
    public static final sr0 q;
    public static final ar0.a r = new ar0.a(18);
    public final fa b;
    public int c;
    public int d;
    public int f;
    public c g;
    public int i;
    public int j;
    public d n;
    public byte o;
    public int p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.a implements oh0 {
        public int c;
        public int d;
        public int f;
        public int i;
        public int j;
        public c g = c.d;
        public d n = d.c;

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            sr0 sr0Var;
            try {
                try {
                    sr0.r.getClass();
                    g(new sr0(xdVar));
                    return this;
                } catch (t30 e) {
                    sr0Var = (sr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (sr0Var != null) {
                            g(sr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                sr0Var = null;
                if (sr0Var != null) {
                    g(sr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            sr0 sr0VarF = f();
            sr0VarF.isInitialized();
            return sr0VarF;
        }

        public final Object clone() {
            b bVar = new b();
            bVar.g(f());
            return bVar;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            g((sr0) yxVar);
            return this;
        }

        public final sr0 f() {
            sr0 sr0Var = new sr0(this);
            int i = this.c;
            int i2 = (i & 1) != 1 ? 0 : 1;
            sr0Var.d = this.d;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            sr0Var.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            sr0Var.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            sr0Var.i = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            sr0Var.j = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            sr0Var.n = this.n;
            sr0Var.c = i2;
            return sr0Var;
        }

        public final void g(sr0 sr0Var) {
            if (sr0Var == sr0.q) {
                return;
            }
            int i = sr0Var.c;
            if ((i & 1) == 1) {
                int i2 = sr0Var.d;
                this.c = 1 | this.c;
                this.d = i2;
            }
            if ((i & 2) == 2) {
                int i3 = sr0Var.f;
                this.c = 2 | this.c;
                this.f = i3;
            }
            if ((i & 4) == 4) {
                c cVar = sr0Var.g;
                cVar.getClass();
                this.c = 4 | this.c;
                this.g = cVar;
            }
            int i4 = sr0Var.c;
            if ((i4 & 8) == 8) {
                int i5 = sr0Var.i;
                this.c = 8 | this.c;
                this.i = i5;
            }
            if ((i4 & 16) == 16) {
                int i6 = sr0Var.j;
                this.c = 16 | this.c;
                this.j = i6;
            }
            if ((i4 & 32) == 32) {
                d dVar = sr0Var.n;
                dVar.getClass();
                this.c = 32 | this.c;
                this.n = dVar;
            }
            this.b = this.b.d(sr0Var.b);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum c implements h30.a {
        c("WARNING"),
        d("ERROR"),
        f("HIDDEN");

        public final int b;

        c(String str) {
            this.b = i;
        }

        @Override // h30.a
        public final int getNumber() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum d implements h30.a {
        c("LANGUAGE_VERSION"),
        d("COMPILER_VERSION"),
        f("API_VERSION");

        public final int b;

        d(String str) {
            this.b = i;
        }

        @Override // h30.a
        public final int getNumber() {
            return this.b;
        }
    }

    static {
        sr0 sr0Var = new sr0();
        q = sr0Var;
        sr0Var.d = 0;
        sr0Var.f = 0;
        sr0Var.g = c.d;
        sr0Var.i = 0;
        sr0Var.j = 0;
        sr0Var.n = d.c;
    }

    public sr0() {
        this.o = (byte) -1;
        this.p = -1;
        this.b = fa.b;
    }

    public sr0(b bVar) {
        this.o = (byte) -1;
        this.p = -1;
        this.b = bVar.b;
    }

    public sr0(xd xdVar) {
        int iK;
        this.o = (byte) -1;
        this.p = -1;
        boolean z = false;
        this.d = 0;
        this.f = 0;
        c cVar = c.d;
        this.g = cVar;
        this.i = 0;
        this.j = 0;
        d dVar = d.c;
        this.n = dVar;
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
                        } else if (iN != 16) {
                            d dVar2 = null;
                            c cVar2 = null;
                            if (iN == 24) {
                                iK = xdVar.k();
                                if (iK == 0) {
                                    cVar2 = c.c;
                                } else if (iK == 1) {
                                    cVar2 = cVar;
                                } else if (iK == 2) {
                                    cVar2 = c.f;
                                }
                                if (cVar2 == null) {
                                    ydVarJ.v(iN);
                                    ydVarJ.v(iK);
                                } else {
                                    this.c |= 4;
                                    this.g = cVar2;
                                }
                            } else if (iN == 32) {
                                this.c |= 8;
                                this.i = xdVar.k();
                            } else if (iN == 40) {
                                this.c |= 16;
                                this.j = xdVar.k();
                            } else if (iN == 48) {
                                iK = xdVar.k();
                                if (iK == 0) {
                                    dVar2 = dVar;
                                } else if (iK == 1) {
                                    dVar2 = d.d;
                                } else if (iK == 2) {
                                    dVar2 = d.f;
                                }
                                if (dVar2 == null) {
                                    ydVarJ.v(iN);
                                    ydVarJ.v(iK);
                                } else {
                                    this.c |= 32;
                                    this.n = dVar2;
                                }
                            } else if (!xdVar.q(iN, ydVarJ)) {
                            }
                        } else {
                            this.c |= 2;
                            this.f = xdVar.k();
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
        if ((this.c & 4) == 4) {
            ydVar.l(3, this.g.b);
        }
        if ((this.c & 8) == 8) {
            ydVar.m(4, this.i);
        }
        if ((this.c & 16) == 16) {
            ydVar.m(5, this.j);
        }
        if ((this.c & 32) == 32) {
            ydVar.l(6, this.n.b);
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.p;
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
            iB += yd.b(4, this.i);
        }
        if ((this.c & 16) == 16) {
            iB += yd.b(5, this.j);
        }
        if ((this.c & 32) == 32) {
            iB += yd.a(6, this.n.b);
        }
        int size = this.b.size() + iB;
        this.p = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        if (this.o == 1) {
            return true;
        }
        this.o = (byte) 1;
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
