package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cr0 extends yx {
    public static final cr0 o;
    public static final ar0.a p = new ar0.a(2);
    public final fa b;
    public int c;
    public c d;
    public List f;
    public er0 g;
    public d i;
    public byte j;
    public int n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.a implements oh0 {
        public int c;
        public c d = c.c;
        public List f = Collections.EMPTY_LIST;
        public er0 g = er0.r;
        public d i = d.c;

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            cr0 cr0Var;
            try {
                try {
                    cr0.p.getClass();
                    g(new cr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    cr0Var = (cr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (cr0Var != null) {
                            g(cr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cr0Var = null;
                if (cr0Var != null) {
                    g(cr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            cr0 cr0VarF = f();
            if (cr0VarF.isInitialized()) {
                return cr0VarF;
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
            g((cr0) yxVar);
            return this;
        }

        public final cr0 f() {
            cr0 cr0Var = new cr0(this);
            int i = this.c;
            int i2 = (i & 1) != 1 ? 0 : 1;
            cr0Var.d = this.d;
            if ((i & 2) == 2) {
                this.f = Collections.unmodifiableList(this.f);
                this.c &= -3;
            }
            cr0Var.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            cr0Var.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            cr0Var.i = this.i;
            cr0Var.c = i2;
            return cr0Var;
        }

        public final void g(cr0 cr0Var) {
            er0 er0Var;
            if (cr0Var == cr0.o) {
                return;
            }
            if ((cr0Var.c & 1) == 1) {
                c cVar = cr0Var.d;
                cVar.getClass();
                this.c |= 1;
                this.d = cVar;
            }
            if (!cr0Var.f.isEmpty()) {
                if (this.f.isEmpty()) {
                    this.f = cr0Var.f;
                    this.c &= -3;
                } else {
                    if ((this.c & 2) != 2) {
                        this.f = new ArrayList(this.f);
                        this.c |= 2;
                    }
                    this.f.addAll(cr0Var.f);
                }
            }
            if ((cr0Var.c & 2) == 2) {
                er0 er0VarF = cr0Var.g;
                if ((this.c & 4) == 4 && (er0Var = this.g) != er0.r) {
                    er0.b bVar = new er0.b();
                    bVar.g(er0Var);
                    bVar.g(er0VarF);
                    er0VarF = bVar.f();
                }
                this.g = er0VarF;
                this.c |= 4;
            }
            if ((cr0Var.c & 4) == 4) {
                d dVar = cr0Var.i;
                dVar.getClass();
                this.c |= 8;
                this.i = dVar;
            }
            this.b = this.b.d(cr0Var.b);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum c implements h30.a {
        c("RETURNS_CONSTANT"),
        d("CALLS"),
        f("RETURNS_NOT_NULL");

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
        c("AT_MOST_ONCE"),
        d("EXACTLY_ONCE"),
        f("AT_LEAST_ONCE");

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
        cr0 cr0Var = new cr0();
        o = cr0Var;
        cr0Var.d = c.c;
        cr0Var.f = Collections.EMPTY_LIST;
        cr0Var.g = er0.r;
        cr0Var.i = d.c;
    }

    public cr0() {
        this.j = (byte) -1;
        this.n = -1;
        this.b = fa.b;
    }

    public cr0(b bVar) {
        this.j = (byte) -1;
        this.n = -1;
        this.b = bVar.b;
    }

    public cr0(xd xdVar, ps psVar) {
        int iK;
        this.j = (byte) -1;
        this.n = -1;
        c cVar = c.c;
        this.d = cVar;
        this.f = Collections.EMPTY_LIST;
        this.g = er0.r;
        d dVar = d.c;
        this.i = dVar;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        char c2 = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        d dVar2 = null;
                        c cVar2 = null;
                        er0.b bVar2 = null;
                        if (iN == 8) {
                            iK = xdVar.k();
                            if (iK == 0) {
                                cVar2 = cVar;
                            } else if (iK == 1) {
                                cVar2 = c.d;
                            } else if (iK == 2) {
                                cVar2 = c.f;
                            }
                            if (cVar2 == null) {
                                ydVarJ.v(iN);
                                ydVarJ.v(iK);
                            } else {
                                this.c |= 1;
                                this.d = cVar2;
                            }
                        } else if (iN == 18) {
                            int i = (c2 == true ? 1 : 0) & 2;
                            c2 = c2;
                            if (i != 2) {
                                this.f = new ArrayList();
                                c2 = 2;
                            }
                            this.f.add(xdVar.g(er0.s, psVar));
                        } else if (iN == 26) {
                            if ((this.c & 2) == 2) {
                                er0 er0Var = this.g;
                                er0Var.getClass();
                                bVar2 = new er0.b();
                                bVar2.g(er0Var);
                            }
                            er0 er0Var2 = (er0) xdVar.g(er0.s, psVar);
                            this.g = er0Var2;
                            if (bVar2 != null) {
                                bVar2.g(er0Var2);
                                this.g = bVar2.f();
                            }
                            this.c |= 2;
                        } else if (iN == 32) {
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
                                this.c |= 4;
                                this.i = dVar2;
                            }
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
                if (((c2 == true ? 1 : 0) & 2) == 2) {
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
        if (((c2 == true ? 1 : 0) & 2) == 2) {
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
            ydVar.l(1, this.d.b);
        }
        for (int i = 0; i < this.f.size(); i++) {
            ydVar.o(2, (b0) this.f.get(i));
        }
        if ((this.c & 2) == 2) {
            ydVar.o(3, this.g);
        }
        if ((this.c & 4) == 4) {
            ydVar.l(4, this.i.b);
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.n;
        if (i != -1) {
            return i;
        }
        int iA = (this.c & 1) == 1 ? yd.a(1, this.d.b) : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            iA += yd.d(2, (b0) this.f.get(i2));
        }
        if ((this.c & 2) == 2) {
            iA += yd.d(3, this.g);
        }
        if ((this.c & 4) == 4) {
            iA += yd.a(4, this.i.b);
        }
        int size = this.b.size() + iA;
        this.n = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.j;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((er0) this.f.get(i)).isInitialized()) {
                this.j = (byte) 0;
                return false;
            }
        }
        if ((this.c & 2) != 2 || this.g.isInitialized()) {
            this.j = (byte) 1;
            return true;
        }
        this.j = (byte) 0;
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
