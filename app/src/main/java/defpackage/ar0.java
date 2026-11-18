package defpackage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ar0 extends yx.c {
    public static final ar0 o;
    public static final a p = new a(0);
    public final fa c;
    public int d;
    public int f;
    public List g;
    public List i;
    public byte j;
    public int n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final /* synthetic */ int G0;

        static {
            int i = ps.$r8$clinit;
        }

        public /* synthetic */ a(int i) {
            this.G0 = i;
        }

        public static void b(b0 b0Var) throws t30 {
            if (b0Var == null || b0Var.isInitialized()) {
                return;
            }
            t30 t30Var = new t30(new we().getMessage());
            t30Var.b = b0Var;
            throw t30Var;
        }

        public final Object a(xd xdVar, ps psVar) {
            switch (this.G0) {
                case 0:
                    return new ar0(xdVar, psVar);
                case 1:
                    return new br0(xdVar, psVar);
                case 2:
                    return new cr0(xdVar, psVar);
                case 3:
                    return new dr0(xdVar, psVar);
                case 4:
                    return new er0(xdVar, psVar);
                case 5:
                    return new fr0(xdVar, psVar);
                case 6:
                    return new ir0(xdVar, psVar);
                case 7:
                    return new jr0(xdVar, psVar);
                case 8:
                    return new kr0(xdVar, psVar);
                case 9:
                    return new lr0(xdVar, psVar);
                case 10:
                    return new lr0.c(xdVar);
                case 11:
                    return new mr0(xdVar);
                case 12:
                    return new nr0(xdVar, psVar);
                case 13:
                    return new nr0.b(xdVar, psVar);
                case 14:
                    return new or0(xdVar, psVar);
                case 15:
                    return new pr0(xdVar, psVar);
                case 16:
                    return new qr0(xdVar, psVar);
                case 17:
                    return new rr0(xdVar, psVar);
                case 18:
                    return new sr0(xdVar);
                case 19:
                    return new tr0(xdVar, psVar);
                case 20:
                    return new w80.a(xdVar);
                case 21:
                    return new w80.b(xdVar);
                case 22:
                    return new w80.c(xdVar, psVar);
                case 23:
                    return new w80.d(xdVar, psVar);
                case 24:
                    return new w80.d.c(xdVar);
                case 25:
                    return new yq0(xdVar, psVar);
                case 26:
                    return new yq0.b(xdVar, psVar);
                case 27:
                    return new yq0.b.c(xdVar, psVar);
                default:
                    return new zq0(xdVar, psVar);
            }
        }

        public final b0 c(ByteArrayInputStream byteArrayInputStream, ps psVar) throws t30 {
            b0 b0Var;
            try {
                int i = byteArrayInputStream.read();
                if (i == -1) {
                    b0Var = null;
                } else {
                    if ((i & 128) != 0) {
                        i &= 127;
                        int i2 = 7;
                        while (true) {
                            if (i2 < 32) {
                                int i3 = byteArrayInputStream.read();
                                if (i3 == -1) {
                                    throw t30.b();
                                }
                                i |= (i3 & 127) << i2;
                                if ((i3 & 128) == 0) {
                                    break;
                                }
                                i2 += 7;
                            } else {
                                while (true) {
                                    if (i2 >= 64) {
                                        throw new t30("CodedInputStream encountered a malformed varint.");
                                    }
                                    int i4 = byteArrayInputStream.read();
                                    if (i4 == -1) {
                                        throw t30.b();
                                    }
                                    if ((i4 & 128) == 0) {
                                        break;
                                    }
                                    i2 += 7;
                                }
                            }
                        }
                    }
                    xd xdVar = new xd(new b0.a(i, byteArrayInputStream));
                    b0 b0Var2 = (b0) a(xdVar, psVar);
                    try {
                        xdVar.a(0);
                        b0Var = b0Var2;
                    } catch (t30 e) {
                        e.b = b0Var2;
                        throw e;
                    }
                }
                b(b0Var);
                return b0Var;
            } catch (IOException e2) {
                throw new t30(e2.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public int f;
        public int g = 6;
        public List i;
        public List j;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.i = list;
            this.j = list;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0019  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            ar0 ar0Var;
            try {
                try {
                    h((ar0) ar0.p.a(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    ar0Var = (ar0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (ar0Var != null) {
                            h(ar0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                ar0Var = null;
                if (ar0Var != null) {
                    h(ar0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            ar0 ar0VarG = g();
            if (ar0VarG.isInitialized()) {
                return ar0VarG;
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
            h((ar0) yxVar);
            return this;
        }

        public final ar0 g() {
            ar0 ar0Var = new ar0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            ar0Var.f = this.g;
            if ((i & 2) == 2) {
                this.i = Collections.unmodifiableList(this.i);
                this.f &= -3;
            }
            ar0Var.g = this.i;
            if ((this.f & 4) == 4) {
                this.j = Collections.unmodifiableList(this.j);
                this.f &= -5;
            }
            ar0Var.i = this.j;
            ar0Var.d = i2;
            return ar0Var;
        }

        public final void h(ar0 ar0Var) {
            if (ar0Var == ar0.o) {
                return;
            }
            if ((ar0Var.d & 1) == 1) {
                int i = ar0Var.f;
                this.f = 1 | this.f;
                this.g = i;
            }
            if (!ar0Var.g.isEmpty()) {
                if (this.i.isEmpty()) {
                    this.i = ar0Var.g;
                    this.f &= -3;
                } else {
                    if ((this.f & 2) != 2) {
                        this.i = new ArrayList(this.i);
                        this.f |= 2;
                    }
                    this.i.addAll(ar0Var.g);
                }
            }
            if (!ar0Var.i.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = ar0Var.i;
                    this.f &= -5;
                } else {
                    if ((this.f & 4) != 4) {
                        this.j = new ArrayList(this.j);
                        this.f |= 4;
                    }
                    this.j.addAll(ar0Var.i);
                }
            }
            f(ar0Var);
            this.b = this.b.d(ar0Var.c);
        }
    }

    static {
        ar0 ar0Var = new ar0();
        o = ar0Var;
        ar0Var.f = 6;
        List list = Collections.EMPTY_LIST;
        ar0Var.g = list;
        ar0Var.i = list;
    }

    public ar0() {
        this.j = (byte) -1;
        this.n = -1;
        this.c = fa.b;
    }

    public ar0(b bVar) {
        super(bVar);
        this.j = (byte) -1;
        this.n = -1;
        this.c = bVar.b;
    }

    public ar0(xd xdVar, ps psVar) {
        List list;
        Object objG;
        this.j = (byte) -1;
        this.n = -1;
        this.f = 6;
        List list2 = Collections.EMPTY_LIST;
        this.g = list2;
        this.i = list2;
        fa.b bVar = new fa.b();
        yd ydVarJ = yd.j(bVar, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    int iN = xdVar.n();
                    if (iN != 0) {
                        if (iN != 8) {
                            if (iN == 18) {
                                if ((i & 2) != 2) {
                                    this.g = new ArrayList();
                                    i |= 2;
                                }
                                list = this.g;
                                objG = xdVar.g(rr0.s, psVar);
                            } else if (iN == 248) {
                                if ((i & 4) != 4) {
                                    this.i = new ArrayList();
                                    i |= 4;
                                }
                                list = this.i;
                                objG = Integer.valueOf(xdVar.k());
                            } else if (iN == 250) {
                                int iD = xdVar.d(xdVar.k());
                                if ((i & 4) != 4 && xdVar.b() > 0) {
                                    this.i = new ArrayList();
                                    i |= 4;
                                }
                                while (xdVar.b() > 0) {
                                    this.i.add(Integer.valueOf(xdVar.k()));
                                }
                                xdVar.c(iD);
                            } else if (!k(xdVar, ydVarJ, psVar, iN)) {
                            }
                            list.add(objG);
                        } else {
                            this.d |= 1;
                            this.f = xdVar.k();
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
                if ((i & 2) == 2) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                if ((i & 4) == 4) {
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
        }
        if ((i & 2) == 2) {
            this.g = Collections.unmodifiableList(this.g);
        }
        if ((i & 4) == 4) {
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
        if ((this.d & 1) == 1) {
            ydVar.m(1, this.f);
        }
        for (int i = 0; i < this.g.size(); i++) {
            ydVar.o(2, (b0) this.g.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            ydVar.m(31, ((Integer) this.i.get(i2)).intValue());
        }
        zl0Var.a(19000, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return o;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i = this.n;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int iB = (this.d & 1) == 1 ? yd.b(1, this.f) : 0;
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            iB += yd.d(2, (b0) this.g.get(i3));
        }
        int iC = 0;
        while (true) {
            int size = this.i.size();
            List list = this.i;
            if (i2 >= size) {
                int size2 = this.c.size() + f() + (list.size() * 2) + iB + iC;
                this.n = size2;
                return size2;
            }
            iC += yd.c(((Integer) list.get(i2)).intValue());
            i2++;
        }
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
        for (int i = 0; i < this.g.size(); i++) {
            if (!((rr0) this.g.get(i)).isInitialized()) {
                this.j = (byte) 0;
                return false;
            }
        }
        if (e()) {
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
        bVar.h(this);
        return bVar;
    }
}
