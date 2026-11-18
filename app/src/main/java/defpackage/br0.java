package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class br0 extends yx {
    public static final br0 g;
    public static final ar0.a i = new ar0.a(1);
    public final fa b;
    public List c;
    public byte d;
    public int f;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.a implements oh0 {
        public final /* synthetic */ int G0;
        public int c;
        public List d;

        public b(int i) {
            List list;
            this.G0 = i;
            if (i != 1 && i != 2) {
                if (i == 3) {
                    list = yd0.c;
                }
                this.d = list;
            }
            list = Collections.EMPTY_LIST;
            this.d = list;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0025  */
        /* JADX WARN: Code duplicated, block: B:58:0x007f  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            int i = this.G0;
            br0 br0Var = null;
            mr0 mr0Var = null;
            tr0 tr0Var = null;
            lr0 lr0Var = null;
            if (i == 0) {
                try {
                    try {
                        br0.i.getClass();
                        g(new br0(xdVar, psVar));
                        return this;
                    } catch (t30 e) {
                        br0 br0Var2 = (br0) e.b;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            br0Var = br0Var2;
                            if (br0Var != null) {
                                g(br0Var);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (br0Var != null) {
                        g(br0Var);
                    }
                    throw th;
                }
            }
            try {
                if (i != 1) {
                    try {
                        if (i != 2) {
                            try {
                                try {
                                    mr0.i.getClass();
                                    g(new mr0(xdVar));
                                    return this;
                                } catch (t30 e2) {
                                    mr0 mr0Var2 = (mr0) e2.b;
                                    try {
                                        throw e2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        mr0Var = mr0Var2;
                                        if (mr0Var != null) {
                                            g(mr0Var);
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (mr0Var != null) {
                                    g(mr0Var);
                                }
                                throw th;
                            }
                        }
                        try {
                            tr0.i.getClass();
                            g(new tr0(xdVar, psVar));
                            return this;
                        } catch (t30 e3) {
                            tr0 tr0Var2 = (tr0) e3.b;
                            try {
                                throw e3;
                            } catch (Throwable th5) {
                                th = th5;
                                tr0Var = tr0Var2;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    if (tr0Var != null) {
                        g(tr0Var);
                    }
                    throw th;
                }
                try {
                    lr0.i.getClass();
                    g(new lr0(xdVar, psVar));
                    return this;
                } catch (t30 e4) {
                    lr0 lr0Var2 = (lr0) e4.b;
                    try {
                        throw e4;
                    } catch (Throwable th7) {
                        th = th7;
                        lr0Var = lr0Var2;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
            if (lr0Var != null) {
                g(lr0Var);
            }
            throw th;
        }

        @Override // yx.a
        public final b0 build() {
            int i = this.G0;
            if (i == 0) {
                br0 br0VarF = f();
                if (br0VarF.isInitialized()) {
                    return br0VarF;
                }
                throw new we();
            }
            if (i == 1) {
                lr0 lr0VarM8f = m8f();
                if (lr0VarM8f.isInitialized()) {
                    return lr0VarM8f;
                }
                throw new we();
            }
            if (i != 2) {
                mr0 mr0VarM9f = m9f();
                mr0VarM9f.isInitialized();
                return mr0VarM9f;
            }
            tr0 tr0VarM10f = m10f();
            tr0VarM10f.isInitialized();
            return tr0VarM10f;
        }

        public final Object clone() {
            int i = this.G0;
            if (i == 0) {
                b bVar = new b(0);
                bVar.g(f());
                return bVar;
            }
            if (i == 1) {
                b bVar2 = new b(1);
                bVar2.g(m8f());
                return bVar2;
            }
            if (i != 2) {
                b bVar3 = new b(3);
                bVar3.g(m9f());
                return bVar3;
            }
            b bVar4 = new b(2);
            bVar4.g(m10f());
            return bVar4;
        }

        @Override // yx.a
        public final /* bridge */ /* synthetic */ yx.a e(yx yxVar) {
            int i = this.G0;
            if (i == 0) {
                g((br0) yxVar);
                return this;
            }
            if (i == 1) {
                g((lr0) yxVar);
                return this;
            }
            if (i != 2) {
                g((mr0) yxVar);
                return this;
            }
            g((tr0) yxVar);
            return this;
        }

        public br0 f() {
            br0 br0Var = new br0(this);
            if ((this.c & 1) == 1) {
                this.d = Collections.unmodifiableList(this.d);
                this.c &= -2;
            }
            br0Var.c = this.d;
            return br0Var;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public lr0 m8f() {
            lr0 lr0Var = new lr0(this);
            if ((this.c & 1) == 1) {
                this.d = Collections.unmodifiableList(this.d);
                this.c &= -2;
            }
            lr0Var.c = this.d;
            return lr0Var;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public mr0 m9f() {
            mr0 mr0Var = new mr0(this);
            if ((this.c & 1) == 1) {
                this.d = ((zd0) this.d).getUnmodifiableView();
                this.c &= -2;
            }
            mr0Var.c = (zd0) this.d;
            return mr0Var;
        }

        /* JADX INFO: renamed from: f, reason: collision with other method in class */
        public tr0 m10f() {
            tr0 tr0Var = new tr0(this);
            if ((this.c & 1) == 1) {
                this.d = Collections.unmodifiableList(this.d);
                this.c &= -2;
            }
            tr0Var.c = this.d;
            return tr0Var;
        }

        public void g(br0 br0Var) {
            if (br0Var == br0.g) {
                return;
            }
            if (!br0Var.c.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = br0Var.c;
                    this.c &= -2;
                } else {
                    if ((this.c & 1) != 1) {
                        this.d = new ArrayList(this.d);
                        this.c |= 1;
                    }
                    this.d.addAll(br0Var.c);
                }
            }
            this.b = this.b.d(br0Var.b);
        }

        public void g(lr0 lr0Var) {
            if (lr0Var == lr0.g) {
                return;
            }
            if (!lr0Var.c.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = lr0Var.c;
                    this.c &= -2;
                } else {
                    if ((this.c & 1) != 1) {
                        this.d = new ArrayList(this.d);
                        this.c |= 1;
                    }
                    this.d.addAll(lr0Var.c);
                }
            }
            this.b = this.b.d(lr0Var.b);
        }

        public void g(mr0 mr0Var) {
            if (mr0Var == mr0.g) {
                return;
            }
            if (!mr0Var.c.isEmpty()) {
                if (((zd0) this.d).isEmpty()) {
                    this.d = mr0Var.c;
                    this.c &= -2;
                } else {
                    if ((this.c & 1) != 1) {
                        this.d = new yd0((zd0) this.d);
                        this.c |= 1;
                    }
                    ((zd0) this.d).addAll(mr0Var.c);
                }
            }
            this.b = this.b.d(mr0Var.b);
        }

        public void g(tr0 tr0Var) {
            if (tr0Var == tr0.g) {
                return;
            }
            if (!tr0Var.c.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = tr0Var.c;
                    this.c &= -2;
                } else {
                    if ((this.c & 1) != 1) {
                        this.d = new ArrayList(this.d);
                        this.c |= 1;
                    }
                    this.d.addAll(tr0Var.c);
                }
            }
            this.b = this.b.d(tr0Var.b);
        }
    }

    static {
        br0 br0Var = new br0();
        g = br0Var;
        br0Var.c = Collections.EMPTY_LIST;
    }

    public br0() {
        this.d = (byte) -1;
        this.f = -1;
        this.b = fa.b;
    }

    public br0(b bVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.b = bVar.b;
    }

    public br0(xd xdVar, ps psVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.c = Collections.EMPTY_LIST;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN == 10) {
                            if (!z2) {
                                this.c = new ArrayList();
                                z2 = true;
                            }
                            this.c.add(xdVar.g(cr0.p, psVar));
                        } else if (!xdVar.q(iN, ydVarJ)) {
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2) {
                        this.c = Collections.unmodifiableList(this.c);
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
        if (z2) {
            this.c = Collections.unmodifiableList(this.c);
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
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            ydVar.o(1, (b0) this.c.get(i2));
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i2 = this.f;
        if (i2 != -1) {
            return i2;
        }
        int iD = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            iD += yd.d(1, (b0) this.c.get(i3));
        }
        int size = this.b.size() + iD;
        this.f = size;
        return size;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.d;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (!((cr0) this.c.get(i2)).isInitialized()) {
                this.d = (byte) 0;
                return false;
            }
        }
        this.d = (byte) 1;
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
