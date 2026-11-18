package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dr0 extends yx.c {
    public static final dr0 j;
    public static final ar0.a n = new ar0.a(3);
    public final fa c;
    public int d;
    public int f;
    public byte g;
    public int i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g;

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            dr0 dr0Var;
            try {
                try {
                    dr0.n.getClass();
                    g(new dr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    dr0Var = (dr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (dr0Var != null) {
                            g(dr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dr0Var = null;
                if (dr0Var != null) {
                    g(dr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            dr0 dr0Var = new dr0(this);
            int i = (this.f & 1) != 1 ? 0 : 1;
            dr0Var.f = this.g;
            dr0Var.d = i;
            if (dr0Var.isInitialized()) {
                return dr0Var;
            }
            throw new we();
        }

        public final Object clone() {
            b bVar = new b();
            dr0 dr0Var = new dr0(this);
            int i = (this.f & 1) != 1 ? 0 : 1;
            dr0Var.f = this.g;
            dr0Var.d = i;
            bVar.g(dr0Var);
            return bVar;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            g((dr0) yxVar);
            return this;
        }

        public final void g(dr0 dr0Var) {
            if (dr0Var == dr0.j) {
                return;
            }
            if ((dr0Var.d & 1) == 1) {
                int i = dr0Var.f;
                this.f = 1 | this.f;
                this.g = i;
            }
            f(dr0Var);
            this.b = this.b.d(dr0Var.c);
        }
    }

    static {
        dr0 dr0Var = new dr0();
        j = dr0Var;
        dr0Var.f = 0;
    }

    public dr0() {
        this.g = (byte) -1;
        this.i = -1;
        this.c = fa.b;
    }

    public dr0(b bVar) {
        super(bVar);
        this.g = (byte) -1;
        this.i = -1;
        this.c = bVar.b;
    }

    public dr0(xd xdVar, ps psVar) {
        this.g = (byte) -1;
        this.i = -1;
        boolean z = false;
        this.f = 0;
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
                        } else if (!k(xdVar, ydVarJ, psVar, iN)) {
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
                } catch (Throwable th2) {
                    this.c = bVar.c();
                    throw th2;
                }
                this.c = bVar.c();
                i$1();
                throw th;
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
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return j;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int size = this.c.size() + f() + ((this.d & 1) == 1 ? yd.b(1, this.f) : 0);
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
        if (e()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
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
