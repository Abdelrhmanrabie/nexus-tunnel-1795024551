package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ir0 extends yx.c {
    public static final ir0 q;
    public static final ar0.a r = new ar0.a(6);
    public final fa c;
    public int d;
    public List f;
    public List g;
    public List i;
    public qr0 j;
    public tr0 n;
    public byte o;
    public int p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public List g;
        public List i;
        public List j;
        public qr0 n;
        public tr0 o;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.g = list;
            this.i = list;
            this.j = list;
            this.n = qr0.j;
            this.o = tr0.g;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            ir0 ir0Var;
            try {
                try {
                    ir0.r.getClass();
                    h(new ir0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    ir0Var = (ir0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (ir0Var != null) {
                            h(ir0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                ir0Var = null;
                if (ir0Var != null) {
                    h(ir0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            ir0 ir0VarG = g();
            if (ir0VarG.isInitialized()) {
                return ir0VarG;
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
            h((ir0) yxVar);
            return this;
        }

        public final ir0 g() {
            ir0 ir0Var = new ir0(this);
            int i = this.f;
            if ((i & 1) == 1) {
                this.g = Collections.unmodifiableList(this.g);
                this.f &= -2;
            }
            ir0Var.f = this.g;
            if ((this.f & 2) == 2) {
                this.i = Collections.unmodifiableList(this.i);
                this.f &= -3;
            }
            ir0Var.g = this.i;
            if ((this.f & 4) == 4) {
                this.j = Collections.unmodifiableList(this.j);
                this.f &= -5;
            }
            ir0Var.i = this.j;
            int i2 = (i & 8) != 8 ? 0 : 1;
            ir0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            ir0Var.n = this.o;
            ir0Var.d = i2;
            return ir0Var;
        }

        public final void h(ir0 ir0Var) {
            tr0 tr0Var;
            qr0 qr0Var;
            if (ir0Var == ir0.q) {
                return;
            }
            if (!ir0Var.f.isEmpty()) {
                if (this.g.isEmpty()) {
                    this.g = ir0Var.f;
                    this.f &= -2;
                } else {
                    if ((this.f & 1) != 1) {
                        this.g = new ArrayList(this.g);
                        this.f |= 1;
                    }
                    this.g.addAll(ir0Var.f);
                }
            }
            if (!ir0Var.g.isEmpty()) {
                if (this.i.isEmpty()) {
                    this.i = ir0Var.g;
                    this.f &= -3;
                } else {
                    if ((this.f & 2) != 2) {
                        this.i = new ArrayList(this.i);
                        this.f |= 2;
                    }
                    this.i.addAll(ir0Var.g);
                }
            }
            if (!ir0Var.i.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = ir0Var.i;
                    this.f &= -5;
                } else {
                    if ((this.f & 4) != 4) {
                        this.j = new ArrayList(this.j);
                        this.f |= 4;
                    }
                    this.j.addAll(ir0Var.i);
                }
            }
            if ((ir0Var.d & 1) == 1) {
                qr0 qr0VarF = ir0Var.j;
                if ((this.f & 8) == 8 && (qr0Var = this.n) != qr0.j) {
                    qr0.b bVarE = qr0.e(qr0Var);
                    bVarE.g(qr0VarF);
                    qr0VarF = bVarE.f();
                }
                this.n = qr0VarF;
                this.f |= 8;
            }
            if ((ir0Var.d & 2) == 2) {
                tr0 tr0VarM10f = ir0Var.n;
                if ((this.f & 16) == 16 && (tr0Var = this.o) != tr0.g) {
                    br0.b bVar = new br0.b(2);
                    bVar.g(tr0Var);
                    bVar.g(tr0VarM10f);
                    tr0VarM10f = bVar.m10f();
                }
                this.o = tr0VarM10f;
                this.f |= 16;
            }
            f(ir0Var);
            this.b = this.b.d(ir0Var.c);
        }
    }

    static {
        ir0 ir0Var = new ir0();
        q = ir0Var;
        List list = Collections.EMPTY_LIST;
        ir0Var.f = list;
        ir0Var.g = list;
        ir0Var.i = list;
        ir0Var.j = qr0.j;
        ir0Var.n = tr0.g;
    }

    public ir0() {
        this.o = (byte) -1;
        this.p = -1;
        this.c = fa.b;
    }

    public ir0(b bVar) {
        super(bVar);
        this.o = (byte) -1;
        this.p = -1;
        this.c = bVar.b;
    }

    public ir0(xd xdVar, ps psVar) {
        List list;
        ar0.a aVar;
        this.o = (byte) -1;
        this.p = -1;
        List list2 = Collections.EMPTY_LIST;
        this.f = list2;
        this.g = list2;
        this.i = list2;
        this.j = qr0.j;
        this.n = tr0.g;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN == 26) {
                            int i2 = (i == true ? 1 : 0) & 1;
                            int i3 = i;
                            if (i2 != 1) {
                                this.f = new ArrayList();
                                i3 = (i == true ? 1 : 0) | 1;
                            }
                            list = this.f;
                            aVar = fr0.y;
                            i = i3;
                        } else if (iN == 34) {
                            int i4 = (i == true ? 1 : 0) & 2;
                            int i5 = i;
                            if (i4 != 2) {
                                this.g = new ArrayList();
                                i5 = (i == true ? 1 : 0) | 2;
                            }
                            list = this.g;
                            aVar = kr0.y;
                            i = i5;
                        } else if (iN != 42) {
                            br0.b bVar2 = null;
                            qr0.b bVarE = null;
                            if (iN == 242) {
                                if ((this.d & 1) == 1) {
                                    qr0 qr0Var = this.j;
                                    qr0Var.getClass();
                                    bVarE = qr0.e(qr0Var);
                                }
                                qr0 qr0Var2 = (qr0) xdVar.g(qr0.n, psVar);
                                this.j = qr0Var2;
                                if (bVarE != null) {
                                    bVarE.g(qr0Var2);
                                    this.j = bVarE.f();
                                }
                                this.d |= 1;
                            } else if (iN == 258) {
                                if ((this.d & 2) == 2) {
                                    tr0 tr0Var = this.n;
                                    tr0Var.getClass();
                                    bVar2 = new br0.b(2);
                                    bVar2.g(tr0Var);
                                }
                                tr0 tr0Var2 = (tr0) xdVar.g(tr0.i, psVar);
                                this.n = tr0Var2;
                                if (bVar2 != null) {
                                    bVar2.g(tr0Var2);
                                    this.n = bVar2.m10f();
                                }
                                this.d |= 2;
                            } else if (!k(xdVar, ydVarJ, psVar, iN)) {
                            }
                        } else {
                            int i6 = (i == true ? 1 : 0) & 4;
                            int i7 = i;
                            if (i6 != 4) {
                                this.i = new ArrayList();
                                i7 = (i == true ? 1 : 0) | 4;
                            }
                            list = this.i;
                            aVar = or0.v;
                            i = i7;
                        }
                        list.add(xdVar.g(aVar, psVar));
                    }
                    z = true;
                } catch (Throwable th) {
                    if (((i == true ? 1 : 0) & 1) == 1) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    if (((i == true ? 1 : 0) & 2) == 2) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    if (((i == true ? 1 : 0) & 4) == 4) {
                        this.i = Collections.unmodifiableList(this.i);
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
        if (((i == true ? 1 : 0) & 1) == 1) {
            this.f = Collections.unmodifiableList(this.f);
        }
        if (((i == true ? 1 : 0) & 2) == 2) {
            this.g = Collections.unmodifiableList(this.g);
        }
        if (((i == true ? 1 : 0) & 4) == 4) {
            this.i = Collections.unmodifiableList(this.i);
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
        for (int i = 0; i < this.f.size(); i++) {
            ydVar.o(3, (b0) this.f.get(i));
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            ydVar.o(4, (b0) this.g.get(i2));
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            ydVar.o(5, (b0) this.i.get(i3));
        }
        if ((this.d & 1) == 1) {
            ydVar.o(30, this.j);
        }
        if ((this.d & 2) == 2) {
            ydVar.o(32, this.n);
        }
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return q;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.p;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            iD += yd.d(3, (b0) this.f.get(i2));
        }
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            iD += yd.d(4, (b0) this.g.get(i3));
        }
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            iD += yd.d(5, (b0) this.i.get(i4));
        }
        if ((this.d & 1) == 1) {
            iD += yd.d(30, this.j);
        }
        if ((this.d & 2) == 2) {
            iD += yd.d(32, this.n);
        }
        int size = this.c.size() + f() + iD;
        this.p = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.o;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((fr0) this.f.get(i)).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            if (!((kr0) this.g.get(i2)).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((or0) this.i.get(i3)).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        if ((this.d & 1) == 1 && !this.j.isInitialized()) {
            this.o = (byte) 0;
            return false;
        }
        if (e()) {
            this.o = (byte) 1;
            return true;
        }
        this.o = (byte) 0;
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
