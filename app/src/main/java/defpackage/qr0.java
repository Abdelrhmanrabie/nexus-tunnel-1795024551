package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qr0 extends yx {
    public static final qr0 j;
    public static final ar0.a n = new ar0.a(16);
    public final fa b;
    public int c;
    public List d;
    public int f;
    public byte g;
    public int i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.a implements oh0 {
        public final /* synthetic */ int G0;
        public int c;
        public Object d;
        public int f;

        public b(int i) {
            this.G0 = i;
            if (i == 1) {
                this.d = Collections.EMPTY_LIST;
            } else if (i == 2) {
                this.d = yq0.b.c.v;
            } else {
                this.d = Collections.EMPTY_LIST;
                this.f = -1;
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0040  */
        /* JADX WARN: Code duplicated, block: B:43:0x005e  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            int i = this.G0;
            qr0 qr0Var = null;
            yq0 yq0Var = null;
            yq0.b bVar = null;
            if (i == 0) {
                try {
                    try {
                        qr0.n.getClass();
                        g(new qr0(xdVar, psVar));
                        return this;
                    } catch (t30 e) {
                        qr0 qr0Var2 = (qr0) e.b;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            qr0Var = qr0Var2;
                            if (qr0Var != null) {
                                g(qr0Var);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (qr0Var != null) {
                        g(qr0Var);
                    }
                    throw th;
                }
            }
            try {
                if (i == 1) {
                    try {
                        try {
                            yq0.n.getClass();
                            g(new yq0(xdVar, psVar));
                            return this;
                        } catch (t30 e2) {
                            yq0 yq0Var2 = (yq0) e2.b;
                            try {
                                throw e2;
                            } catch (Throwable th3) {
                                th = th3;
                                yq0Var = yq0Var2;
                                if (yq0Var != null) {
                                    g(yq0Var);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (yq0Var != null) {
                            g(yq0Var);
                        }
                        throw th;
                    }
                }
                try {
                    yq0.b.n.getClass();
                    h(new yq0.b(xdVar, psVar));
                    return this;
                } catch (t30 e3) {
                    yq0.b bVar2 = (yq0.b) e3.b;
                    try {
                        throw e3;
                    } catch (Throwable th5) {
                        th = th5;
                        bVar = bVar2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            if (bVar != null) {
                h(bVar);
            }
            throw th;
        }

        @Override // yx.a
        public final b0 build() {
            int i = this.G0;
            if (i == 0) {
                qr0 qr0VarF = f();
                if (qr0VarF.isInitialized()) {
                    return qr0VarF;
                }
                throw new we();
            }
            if (i != 1) {
                yq0.b bVarM17f = m17f();
                if (bVarM17f.isInitialized()) {
                    return bVarM17f;
                }
                throw new we();
            }
            yq0 yq0VarM18f = m18f();
            if (yq0VarM18f.isInitialized()) {
                return yq0VarM18f;
            }
            throw new we();
        }

        public final Object clone() {
            int i = this.G0;
            if (i == 0) {
                b bVar = new b(0);
                bVar.g(f());
                return bVar;
            }
            if (i != 1) {
                b bVar2 = new b(2);
                bVar2.h(m17f());
                return bVar2;
            }
            b bVar3 = new b(1);
            bVar3.g(m18f());
            return bVar3;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            int i = this.G0;
            if (i == 0) {
                g((qr0) yxVar);
                return this;
            }
            if (i != 1) {
                h((yq0.b) yxVar);
                return this;
            }
            g((yq0) yxVar);
            return this;
        }

        public qr0 f() {
            qr0 qr0Var = new qr0(this);
            int i = this.c;
            if ((i & 1) == 1) {
                this.d = Collections.unmodifiableList((List) this.d);
                this.c &= -2;
            }
            qr0Var.d = (List) this.d;
            int i2 = (i & 2) != 2 ? 0 : 1;
            qr0Var.f = this.f;
            qr0Var.c = i2;
            return qr0Var;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public yq0.b m17f() {
            yq0.b bVar = new yq0.b(this);
            int i = this.c;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bVar.d = this.f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bVar.f = (yq0.b.c) this.d;
            bVar.c = i2;
            return bVar;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public yq0 m18f() {
            yq0 yq0Var = new yq0(this);
            int i = this.c;
            int i2 = (i & 1) != 1 ? 0 : 1;
            yq0Var.d = this.f;
            if ((i & 2) == 2) {
                this.d = Collections.unmodifiableList((List) this.d);
                this.c &= -3;
            }
            yq0Var.f = (List) this.d;
            yq0Var.c = i2;
            return yq0Var;
        }

        public void g(qr0 qr0Var) {
            if (qr0Var == qr0.j) {
                return;
            }
            if (!qr0Var.d.isEmpty()) {
                if (((List) this.d).isEmpty()) {
                    this.d = qr0Var.d;
                    this.c &= -2;
                } else {
                    if ((this.c & 1) != 1) {
                        this.d = new ArrayList((List) this.d);
                        this.c |= 1;
                    }
                    ((List) this.d).addAll(qr0Var.d);
                }
            }
            if ((qr0Var.c & 1) == 1) {
                int i = qr0Var.f;
                this.c |= 2;
                this.f = i;
            }
            this.b = this.b.d(qr0Var.b);
        }

        public void g(yq0 yq0Var) {
            if (yq0Var == yq0.j) {
                return;
            }
            if ((yq0Var.c & 1) == 1) {
                int i = yq0Var.d;
                this.c = 1 | this.c;
                this.f = i;
            }
            if (!yq0Var.f.isEmpty()) {
                if (((List) this.d).isEmpty()) {
                    this.d = yq0Var.f;
                    this.c &= -3;
                } else {
                    if ((this.c & 2) != 2) {
                        this.d = new ArrayList((List) this.d);
                        this.c |= 2;
                    }
                    ((List) this.d).addAll(yq0Var.f);
                }
            }
            this.b = this.b.d(yq0Var.b);
        }

        public void h(yq0.b bVar) {
            yq0.b.c cVar;
            if (bVar == yq0.b.j) {
                return;
            }
            int i = bVar.c;
            if ((i & 1) == 1) {
                int i2 = bVar.d;
                this.c = 1 | this.c;
                this.f = i2;
            }
            if ((i & 2) == 2) {
                yq0.b.c cVarF = bVar.f;
                if ((this.c & 2) == 2 && (cVar = (yq0.b.c) this.d) != yq0.b.c.v) {
                    yq0.b.c.C0047b c0047b = new yq0.b.c.C0047b();
                    c0047b.g(cVar);
                    c0047b.g(cVarF);
                    cVarF = c0047b.f();
                }
                this.d = cVarF;
                this.c |= 2;
            }
            this.b = this.b.d(bVar.b);
        }
    }

    static {
        qr0 qr0Var = new qr0();
        j = qr0Var;
        qr0Var.d = Collections.EMPTY_LIST;
        qr0Var.f = -1;
    }

    public qr0() {
        this.g = (byte) -1;
        this.i = -1;
        this.b = fa.b;
    }

    public qr0(b bVar) {
        this.g = (byte) -1;
        this.i = -1;
        this.b = bVar.b;
    }

    public qr0(xd xdVar, ps psVar) {
        this.g = (byte) -1;
        this.i = -1;
        this.d = Collections.EMPTY_LIST;
        this.f = -1;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int iN = xdVar.n();
                        if (iN != 0) {
                            if (iN == 10) {
                                if (!z2) {
                                    this.d = new ArrayList();
                                    z2 = true;
                                }
                                this.d.add(xdVar.g(nr0.A, psVar));
                            } else if (iN == 16) {
                                this.c |= 1;
                                this.f = xdVar.k();
                            } else if (!xdVar.q(iN, ydVarJ)) {
                            }
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
                if (z2) {
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
        if (z2) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            ydVarJ.k();
        } catch (IOException unused2) {
        } finally {
            this.b = bVar.c();
        }
    }

    public static b e(qr0 qr0Var) {
        b bVar = new b(0);
        bVar.g(qr0Var);
        return bVar;
    }

    @Override // defpackage.b0
    public final void a(yd ydVar) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.d.size(); i++) {
            ydVar.o(1, (b0) this.d.get(i));
        }
        if ((this.c & 1) == 1) {
            ydVar.m(2, this.f);
        }
        ydVar.r(this.b);
    }

    public final b f() {
        return e(this);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iB = 0;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            iB += yd.d(1, (b0) this.d.get(i2));
        }
        if ((this.c & 1) == 1) {
            iB += yd.b(2, this.f);
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
        for (int i = 0; i < this.d.size(); i++) {
            if (!((nr0) this.d.get(i)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
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
        return e(this);
    }
}
