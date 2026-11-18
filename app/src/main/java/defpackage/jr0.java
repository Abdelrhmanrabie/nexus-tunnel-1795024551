package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jr0 extends yx.c {
    public static final jr0 p;
    public static final ar0.a q = new ar0.a(7);
    public final fa c;
    public int d;
    public mr0 f;
    public lr0 g;
    public ir0 i;
    public List j;
    public byte n;
    public int o;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public mr0 g = mr0.g;
        public lr0 i = lr0.g;
        public ir0 j = ir0.q;
        public List n = Collections.EMPTY_LIST;

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            jr0 jr0Var;
            try {
                try {
                    jr0.q.getClass();
                    h(new jr0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    jr0Var = (jr0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (jr0Var != null) {
                            h(jr0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                jr0Var = null;
                if (jr0Var != null) {
                    h(jr0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            jr0 jr0VarG = g();
            if (jr0VarG.isInitialized()) {
                return jr0VarG;
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
            h((jr0) yxVar);
            return this;
        }

        public final jr0 g() {
            jr0 jr0Var = new jr0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            jr0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            jr0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            jr0Var.i = this.j;
            if ((i & 8) == 8) {
                this.n = Collections.unmodifiableList(this.n);
                this.f &= -9;
            }
            jr0Var.j = this.n;
            jr0Var.d = i2;
            return jr0Var;
        }

        public final void h(jr0 jr0Var) {
            ir0 ir0Var;
            lr0 lr0Var;
            mr0 mr0Var;
            if (jr0Var == jr0.p) {
                return;
            }
            if ((jr0Var.d & 1) == 1) {
                mr0 mr0VarM9f = jr0Var.f;
                if ((this.f & 1) == 1 && (mr0Var = this.g) != mr0.g) {
                    br0.b bVar = new br0.b(3);
                    bVar.g(mr0Var);
                    bVar.g(mr0VarM9f);
                    mr0VarM9f = bVar.m9f();
                }
                this.g = mr0VarM9f;
                this.f |= 1;
            }
            if ((jr0Var.d & 2) == 2) {
                lr0 lr0VarM8f = jr0Var.g;
                if ((this.f & 2) == 2 && (lr0Var = this.i) != lr0.g) {
                    br0.b bVar2 = new br0.b(1);
                    bVar2.g(lr0Var);
                    bVar2.g(lr0VarM8f);
                    lr0VarM8f = bVar2.m8f();
                }
                this.i = lr0VarM8f;
                this.f |= 2;
            }
            if ((jr0Var.d & 4) == 4) {
                ir0 ir0VarG = jr0Var.i;
                if ((this.f & 4) == 4 && (ir0Var = this.j) != ir0.q) {
                    ir0.b bVar3 = new ir0.b();
                    bVar3.h(ir0Var);
                    bVar3.h(ir0VarG);
                    ir0VarG = bVar3.g();
                }
                this.j = ir0VarG;
                this.f |= 4;
            }
            if (!jr0Var.j.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = jr0Var.j;
                    this.f &= -9;
                } else {
                    if ((this.f & 8) != 8) {
                        this.n = new ArrayList(this.n);
                        this.f |= 8;
                    }
                    this.n.addAll(jr0Var.j);
                }
            }
            f(jr0Var);
            this.b = this.b.d(jr0Var.c);
        }
    }

    static {
        jr0 jr0Var = new jr0();
        p = jr0Var;
        jr0Var.f = mr0.g;
        jr0Var.g = lr0.g;
        jr0Var.i = ir0.q;
        jr0Var.j = Collections.EMPTY_LIST;
    }

    public jr0() {
        this.n = (byte) -1;
        this.o = -1;
        this.c = fa.b;
    }

    public jr0(b bVar) {
        super(bVar);
        this.n = (byte) -1;
        this.o = -1;
        this.c = bVar.b;
    }

    public jr0(xd xdVar, ps psVar) {
        int i;
        this.n = (byte) -1;
        this.o = -1;
        this.f = mr0.g;
        this.g = lr0.g;
        this.i = ir0.q;
        this.j = Collections.EMPTY_LIST;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        char c = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        br0.b bVar2 = null;
                        br0.b bVar3 = null;
                        ir0.b bVar4 = null;
                        if (iN != 10) {
                            if (iN == 18) {
                                i = 2;
                                if ((this.d & 2) == 2) {
                                    lr0 lr0Var = this.g;
                                    lr0Var.getClass();
                                    bVar2 = new br0.b(1);
                                    bVar2.g(lr0Var);
                                }
                                lr0 lr0Var2 = (lr0) xdVar.g(lr0.i, psVar);
                                this.g = lr0Var2;
                                if (bVar2 != null) {
                                    bVar2.g(lr0Var2);
                                    this.g = bVar2.m8f();
                                }
                            } else if (iN == 26) {
                                i = 4;
                                if ((this.d & 4) == 4) {
                                    ir0 ir0Var = this.i;
                                    ir0Var.getClass();
                                    bVar4 = new ir0.b();
                                    bVar4.h(ir0Var);
                                }
                                ir0 ir0Var2 = (ir0) xdVar.g(ir0.r, psVar);
                                this.i = ir0Var2;
                                if (bVar4 != null) {
                                    bVar4.h(ir0Var2);
                                    this.i = bVar4.g();
                                }
                            } else if (iN == 34) {
                                int i2 = (c == true ? 1 : 0) & '\b';
                                c = c;
                                if (i2 != 8) {
                                    this.j = new ArrayList();
                                    c = '\b';
                                }
                                this.j.add(xdVar.g(zq0.I, psVar));
                            } else if (!k(xdVar, ydVarJ, psVar, iN)) {
                            }
                            this.d |= i;
                        } else {
                            if ((this.d & 1) == 1) {
                                mr0 mr0Var = this.f;
                                mr0Var.getClass();
                                bVar3 = new br0.b(3);
                                bVar3.g(mr0Var);
                            }
                            mr0 mr0Var2 = (mr0) xdVar.g(mr0.i, psVar);
                            this.f = mr0Var2;
                            if (bVar3 != null) {
                                bVar3.g(mr0Var2);
                                this.f = bVar3.m9f();
                            }
                            this.d |= 1;
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & '\b') == 8) {
                        this.j = Collections.unmodifiableList(this.j);
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
        if (((c == true ? 1 : 0) & '\b') == 8) {
            this.j = Collections.unmodifiableList(this.j);
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
            ydVar.o(1, this.f);
        }
        if ((this.d & 2) == 2) {
            ydVar.o(2, this.g);
        }
        if ((this.d & 4) == 4) {
            ydVar.o(3, this.i);
        }
        for (int i = 0; i < this.j.size(); i++) {
            ydVar.o(4, (b0) this.j.get(i));
        }
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return p;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.o;
        if (i != -1) {
            return i;
        }
        int iD = (this.d & 1) == 1 ? yd.d(1, this.f) : 0;
        if ((this.d & 2) == 2) {
            iD += yd.d(2, this.g);
        }
        if ((this.d & 4) == 4) {
            iD += yd.d(3, this.i);
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            iD += yd.d(4, (b0) this.j.get(i2));
        }
        int size = this.c.size() + f() + iD;
        this.o = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.n;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if ((this.d & 2) == 2 && !this.g.isInitialized()) {
            this.n = (byte) 0;
            return false;
        }
        if ((this.d & 4) == 4 && !this.i.isInitialized()) {
            this.n = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.j.size(); i++) {
            if (!((zq0) this.j.get(i)).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        if (e()) {
            this.n = (byte) 1;
            return true;
        }
        this.n = (byte) 0;
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
