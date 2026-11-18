package defpackage;

import androidx.recyclerview.widget.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class or0 extends yx.c {
    public static final or0 u;
    public static final ar0.a v = new ar0.a(14);
    public final fa c;
    public int d;
    public int f;
    public int g;
    public List i;
    public nr0 j;
    public int n;
    public nr0 o;
    public int p;
    public List q;
    public List r;
    public byte s;
    public int t;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g = 6;
        public int i;
        public List j;
        public nr0 n;
        public int o;
        public nr0 p;
        public int q;
        public List r;
        public List s;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.j = list;
            nr0 nr0Var = nr0.z;
            this.n = nr0Var;
            this.p = nr0Var;
            this.r = list;
            this.s = list;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            or0 or0Var;
            try {
                try {
                    or0.v.getClass();
                    h(new or0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    or0Var = (or0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (or0Var != null) {
                            h(or0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                or0Var = null;
                if (or0Var != null) {
                    h(or0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            or0 or0VarG = g();
            if (or0VarG.isInitialized()) {
                return or0VarG;
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
            h((or0) yxVar);
            return this;
        }

        public final or0 g() {
            or0 or0Var = new or0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            or0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            or0Var.g = this.i;
            if ((i & 4) == 4) {
                this.j = Collections.unmodifiableList(this.j);
                this.f &= -5;
            }
            or0Var.i = this.j;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            or0Var.j = this.n;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            or0Var.n = this.o;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            or0Var.o = this.p;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            or0Var.p = this.q;
            if ((this.f & 128) == 128) {
                this.r = Collections.unmodifiableList(this.r);
                this.f &= -129;
            }
            or0Var.q = this.r;
            if ((this.f & 256) == 256) {
                this.s = Collections.unmodifiableList(this.s);
                this.f &= -257;
            }
            or0Var.r = this.s;
            or0Var.d = i2;
            return or0Var;
        }

        public final void h(or0 or0Var) {
            nr0 nr0Var;
            nr0 nr0Var2;
            if (or0Var == or0.u) {
                return;
            }
            int i = or0Var.d;
            if ((i & 1) == 1) {
                int i2 = or0Var.f;
                this.f |= 1;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = or0Var.g;
                this.f = 2 | this.f;
                this.i = i3;
            }
            if (!or0Var.i.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = or0Var.i;
                    this.f &= -5;
                } else {
                    if ((this.f & 4) != 4) {
                        this.j = new ArrayList(this.j);
                        this.f |= 4;
                    }
                    this.j.addAll(or0Var.i);
                }
            }
            if ((or0Var.d & 4) == 4) {
                nr0 nr0VarG = or0Var.j;
                if ((this.f & 8) == 8 && (nr0Var2 = this.n) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var2);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.n = nr0VarG;
                this.f |= 8;
            }
            int i4 = or0Var.d;
            if ((i4 & 8) == 8) {
                int i5 = or0Var.n;
                this.f |= 16;
                this.o = i5;
            }
            if ((i4 & 16) == 16) {
                nr0 nr0VarG2 = or0Var.o;
                if ((this.f & 32) == 32 && (nr0Var = this.p) != nr0.z) {
                    nr0.c cVarO2 = nr0.o(nr0Var);
                    cVarO2.h(nr0VarG2);
                    nr0VarG2 = cVarO2.g();
                }
                this.p = nr0VarG2;
                this.f |= 32;
            }
            if ((or0Var.d & 32) == 32) {
                int i6 = or0Var.p;
                this.f |= 64;
                this.q = i6;
            }
            if (!or0Var.q.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = or0Var.q;
                    this.f &= -129;
                } else {
                    if ((this.f & 128) != 128) {
                        this.r = new ArrayList(this.r);
                        this.f |= 128;
                    }
                    this.r.addAll(or0Var.q);
                }
            }
            if (!or0Var.r.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = or0Var.r;
                    this.f &= -257;
                } else {
                    if ((this.f & 256) != 256) {
                        this.s = new ArrayList(this.s);
                        this.f |= 256;
                    }
                    this.s.addAll(or0Var.r);
                }
            }
            f(or0Var);
            this.b = this.b.d(or0Var.c);
        }
    }

    static {
        or0 or0Var = new or0();
        u = or0Var;
        or0Var.f = 6;
        or0Var.g = 0;
        List list = Collections.EMPTY_LIST;
        or0Var.i = list;
        nr0 nr0Var = nr0.z;
        or0Var.j = nr0Var;
        or0Var.n = 0;
        or0Var.o = nr0Var;
        or0Var.p = 0;
        or0Var.q = list;
        or0Var.r = list;
    }

    public or0() {
        this.s = (byte) -1;
        this.t = -1;
        this.c = fa.b;
    }

    public or0(b bVar) {
        super(bVar);
        this.s = (byte) -1;
        this.t = -1;
        this.c = bVar.b;
    }

    public or0(xd xdVar, ps psVar) {
        List list;
        ar0.a aVar;
        Object objG;
        this.s = (byte) -1;
        this.t = -1;
        this.f = 6;
        boolean z = false;
        this.g = 0;
        List list2 = Collections.EMPTY_LIST;
        this.i = list2;
        nr0 nr0Var = nr0.z;
        this.j = nr0Var;
        this.n = 0;
        this.o = nr0Var;
        this.p = 0;
        this.q = list2;
        this.r = list2;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        int i = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iN = xdVar.n();
                        nr0.c cVarO = null;
                        switch (iN) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.d |= 1;
                                this.f = xdVar.k();
                                break;
                            case 16:
                                this.d |= 2;
                                this.g = xdVar.k();
                                break;
                            case 26:
                                if ((i & 4) != 4) {
                                    this.i = new ArrayList();
                                    i |= 4;
                                }
                                list = this.i;
                                aVar = pr0.t;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 34:
                                if ((this.d & 4) == 4) {
                                    nr0 nr0Var2 = this.j;
                                    nr0Var2.getClass();
                                    cVarO = nr0.o(nr0Var2);
                                }
                                nr0 nr0Var3 = (nr0) xdVar.g(nr0.A, psVar);
                                this.j = nr0Var3;
                                if (cVarO != null) {
                                    cVarO.h(nr0Var3);
                                    this.j = cVarO.g();
                                }
                                this.d |= 4;
                                break;
                            case 40:
                                this.d |= 8;
                                this.n = xdVar.k();
                                break;
                            case 50:
                                if ((this.d & 16) == 16) {
                                    nr0 nr0Var4 = this.o;
                                    nr0Var4.getClass();
                                    cVarO = nr0.o(nr0Var4);
                                }
                                nr0 nr0Var5 = (nr0) xdVar.g(nr0.A, psVar);
                                this.o = nr0Var5;
                                if (cVarO != null) {
                                    cVarO.h(nr0Var5);
                                    this.o = cVarO.g();
                                }
                                this.d |= 16;
                                break;
                            case 56:
                                this.d |= 32;
                                this.p = xdVar.k();
                                break;
                            case 66:
                                if ((i & 128) != 128) {
                                    this.q = new ArrayList();
                                    i |= 128;
                                }
                                list = this.q;
                                aVar = yq0.n;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 248:
                                if ((i & 256) != 256) {
                                    this.r = new ArrayList();
                                    i |= 256;
                                }
                                list = this.r;
                                objG = Integer.valueOf(xdVar.k());
                                list.add(objG);
                                break;
                            case n.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                int iD = xdVar.d(xdVar.k());
                                if ((i & 256) != 256 && xdVar.b() > 0) {
                                    this.r = new ArrayList();
                                    i |= 256;
                                }
                                while (xdVar.b() > 0) {
                                    this.r.add(Integer.valueOf(xdVar.k()));
                                }
                                xdVar.c(iD);
                                break;
                            default:
                                if (!k(xdVar, ydVarJ, psVar, iN)) {
                                    z = true;
                                }
                                break;
                        }
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
                if ((i & 4) == 4) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                if ((i & 128) == 128) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if ((i & 256) == 256) {
                    this.r = Collections.unmodifiableList(this.r);
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
        if ((i & 4) == 4) {
            this.i = Collections.unmodifiableList(this.i);
        }
        if ((i & 128) == 128) {
            this.q = Collections.unmodifiableList(this.q);
        }
        if ((i & 256) == 256) {
            this.r = Collections.unmodifiableList(this.r);
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
        for (int i = 0; i < this.i.size(); i++) {
            ydVar.o(3, (b0) this.i.get(i));
        }
        if ((this.d & 4) == 4) {
            ydVar.o(4, this.j);
        }
        if ((this.d & 8) == 8) {
            ydVar.m(5, this.n);
        }
        if ((this.d & 16) == 16) {
            ydVar.o(6, this.o);
        }
        if ((this.d & 32) == 32) {
            ydVar.m(7, this.p);
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            ydVar.o(8, (b0) this.q.get(i2));
        }
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            ydVar.m(31, ((Integer) this.r.get(i3)).intValue());
        }
        zl0Var.a(200, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return u;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.t;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int iB = (this.d & 1) == 1 ? yd.b(1, this.f) : 0;
        if ((this.d & 2) == 2) {
            iB += yd.b(2, this.g);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            iB += yd.d(3, (b0) this.i.get(i3));
        }
        if ((this.d & 4) == 4) {
            iB += yd.d(4, this.j);
        }
        if ((this.d & 8) == 8) {
            iB += yd.b(5, this.n);
        }
        if ((this.d & 16) == 16) {
            iB += yd.d(6, this.o);
        }
        if ((this.d & 32) == 32) {
            iB += yd.b(7, this.p);
        }
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            iB += yd.d(8, (b0) this.q.get(i4));
        }
        int iC = 0;
        while (true) {
            int size = this.r.size();
            List list = this.r;
            if (i2 >= size) {
                int size2 = this.c.size() + f() + (list.size() * 2) + iB + iC;
                this.t = size2;
                return size2;
            }
            iC += yd.c(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.s;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if ((this.d & 2) != 2) {
            this.s = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (!((pr0) this.i.get(i)).isInitialized()) {
                this.s = (byte) 0;
                return false;
            }
        }
        if ((this.d & 4) == 4 && !this.j.isInitialized()) {
            this.s = (byte) 0;
            return false;
        }
        if ((this.d & 16) == 16 && !this.o.isInitialized()) {
            this.s = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            if (!((yq0) this.q.get(i2)).isInitialized()) {
                this.s = (byte) 0;
                return false;
            }
        }
        if (e()) {
            this.s = (byte) 1;
            return true;
        }
        this.s = (byte) 0;
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
