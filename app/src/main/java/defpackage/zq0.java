package defpackage;

import androidx.recyclerview.widget.n;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zq0 extends yx.c {
    public static final zq0 H;
    public static final ar0.a I = new ar0.a(28);
    public nr0 A;
    public int B;
    public qr0 C;
    public List D;
    public tr0 E;
    public byte F;
    public int G;
    public final fa c;
    public int d;
    public int f;
    public int g;
    public int i;
    public List j;
    public List n;
    public List o;
    public int p;
    public List q;
    public int r;
    public List s;
    public List t;
    public List u;
    public List v;
    public List w;
    public List x;
    public int y;
    public int z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends yx.b {
        public qr0 A;
        public List B;
        public tr0 C;
        public int f;
        public int g = 6;
        public int i;
        public int j;
        public List n;
        public List o;
        public List p;
        public List q;
        public List r;
        public List s;
        public List t;
        public List u;
        public List v;
        public List w;
        public int x;
        public nr0 y;
        public int z;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.n = list;
            this.o = list;
            this.p = list;
            this.q = list;
            this.r = list;
            this.s = list;
            this.t = list;
            this.u = list;
            this.v = list;
            this.w = list;
            this.y = nr0.z;
            this.A = qr0.j;
            this.B = list;
            this.C = tr0.g;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001b  */
        @Override // yx.a
        public final yx.a b(xd xdVar, ps psVar) throws Throwable {
            zq0 zq0Var;
            try {
                try {
                    zq0.I.getClass();
                    h(new zq0(xdVar, psVar));
                    return this;
                } catch (t30 e) {
                    zq0Var = (zq0) e.b;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        if (zq0Var != null) {
                            h(zq0Var);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zq0Var = null;
                if (zq0Var != null) {
                    h(zq0Var);
                }
                throw th;
            }
        }

        @Override // yx.a
        public final b0 build() {
            zq0 zq0VarG = g();
            if (zq0VarG.isInitialized()) {
                return zq0VarG;
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
            h((zq0) yxVar);
            return this;
        }

        public final zq0 g() {
            zq0 zq0Var = new zq0(this);
            int i = this.f;
            int i2 = (i & 1) != 1 ? 0 : 1;
            zq0Var.f = this.g;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            zq0Var.g = this.i;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            zq0Var.i = this.j;
            if ((i & 8) == 8) {
                this.n = Collections.unmodifiableList(this.n);
                this.f &= -9;
            }
            zq0Var.j = this.n;
            if ((this.f & 16) == 16) {
                this.o = Collections.unmodifiableList(this.o);
                this.f &= -17;
            }
            zq0Var.n = this.o;
            if ((this.f & 32) == 32) {
                this.p = Collections.unmodifiableList(this.p);
                this.f &= -33;
            }
            zq0Var.o = this.p;
            if ((this.f & 64) == 64) {
                this.q = Collections.unmodifiableList(this.q);
                this.f &= -65;
            }
            zq0Var.q = this.q;
            if ((this.f & 128) == 128) {
                this.r = Collections.unmodifiableList(this.r);
                this.f &= -129;
            }
            zq0Var.s = this.r;
            if ((this.f & 256) == 256) {
                this.s = Collections.unmodifiableList(this.s);
                this.f &= -257;
            }
            zq0Var.t = this.s;
            if ((this.f & 512) == 512) {
                this.t = Collections.unmodifiableList(this.t);
                this.f &= -513;
            }
            zq0Var.u = this.t;
            if ((this.f & 1024) == 1024) {
                this.u = Collections.unmodifiableList(this.u);
                this.f &= -1025;
            }
            zq0Var.v = this.u;
            if ((this.f & 2048) == 2048) {
                this.v = Collections.unmodifiableList(this.v);
                this.f &= -2049;
            }
            zq0Var.w = this.v;
            if ((this.f & 4096) == 4096) {
                this.w = Collections.unmodifiableList(this.w);
                this.f &= -4097;
            }
            zq0Var.x = this.w;
            if ((i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) == 8192) {
                i2 |= 8;
            }
            zq0Var.z = this.x;
            if ((i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) == 16384) {
                i2 |= 16;
            }
            zq0Var.A = this.y;
            if ((i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) == 32768) {
                i2 |= 32;
            }
            zq0Var.B = this.z;
            if ((i & 65536) == 65536) {
                i2 |= 64;
            }
            zq0Var.C = this.A;
            if ((this.f & 131072) == 131072) {
                this.B = Collections.unmodifiableList(this.B);
                this.f &= -131073;
            }
            zq0Var.D = this.B;
            if ((i & 262144) == 262144) {
                i2 |= 128;
            }
            zq0Var.E = this.C;
            zq0Var.d = i2;
            return zq0Var;
        }

        public final void h(zq0 zq0Var) {
            tr0 tr0Var;
            qr0 qr0Var;
            nr0 nr0Var;
            if (zq0Var == zq0.H) {
                return;
            }
            int i = zq0Var.d;
            if ((i & 1) == 1) {
                int i2 = zq0Var.f;
                this.f = 1 | this.f;
                this.g = i2;
            }
            if ((i & 2) == 2) {
                int i3 = zq0Var.g;
                this.f |= 2;
                this.i = i3;
            }
            if ((i & 4) == 4) {
                int i4 = zq0Var.i;
                this.f = 4 | this.f;
                this.j = i4;
            }
            if (!zq0Var.j.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = zq0Var.j;
                    this.f &= -9;
                } else {
                    if ((this.f & 8) != 8) {
                        this.n = new ArrayList(this.n);
                        this.f |= 8;
                    }
                    this.n.addAll(zq0Var.j);
                }
            }
            if (!zq0Var.n.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = zq0Var.n;
                    this.f &= -17;
                } else {
                    if ((this.f & 16) != 16) {
                        this.o = new ArrayList(this.o);
                        this.f |= 16;
                    }
                    this.o.addAll(zq0Var.n);
                }
            }
            if (!zq0Var.o.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = zq0Var.o;
                    this.f &= -33;
                } else {
                    if ((this.f & 32) != 32) {
                        this.p = new ArrayList(this.p);
                        this.f |= 32;
                    }
                    this.p.addAll(zq0Var.o);
                }
            }
            if (!zq0Var.q.isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = zq0Var.q;
                    this.f &= -65;
                } else {
                    if ((this.f & 64) != 64) {
                        this.q = new ArrayList(this.q);
                        this.f |= 64;
                    }
                    this.q.addAll(zq0Var.q);
                }
            }
            if (!zq0Var.s.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = zq0Var.s;
                    this.f &= -129;
                } else {
                    if ((this.f & 128) != 128) {
                        this.r = new ArrayList(this.r);
                        this.f |= 128;
                    }
                    this.r.addAll(zq0Var.s);
                }
            }
            if (!zq0Var.t.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = zq0Var.t;
                    this.f &= -257;
                } else {
                    if ((this.f & 256) != 256) {
                        this.s = new ArrayList(this.s);
                        this.f |= 256;
                    }
                    this.s.addAll(zq0Var.t);
                }
            }
            if (!zq0Var.u.isEmpty()) {
                if (this.t.isEmpty()) {
                    this.t = zq0Var.u;
                    this.f &= -513;
                } else {
                    if ((this.f & 512) != 512) {
                        this.t = new ArrayList(this.t);
                        this.f |= 512;
                    }
                    this.t.addAll(zq0Var.u);
                }
            }
            if (!zq0Var.v.isEmpty()) {
                if (this.u.isEmpty()) {
                    this.u = zq0Var.v;
                    this.f &= -1025;
                } else {
                    if ((this.f & 1024) != 1024) {
                        this.u = new ArrayList(this.u);
                        this.f |= 1024;
                    }
                    this.u.addAll(zq0Var.v);
                }
            }
            if (!zq0Var.w.isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = zq0Var.w;
                    this.f &= -2049;
                } else {
                    if ((this.f & 2048) != 2048) {
                        this.v = new ArrayList(this.v);
                        this.f |= 2048;
                    }
                    this.v.addAll(zq0Var.w);
                }
            }
            if (!zq0Var.x.isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = zq0Var.x;
                    this.f &= -4097;
                } else {
                    if ((this.f & 4096) != 4096) {
                        this.w = new ArrayList(this.w);
                        this.f |= 4096;
                    }
                    this.w.addAll(zq0Var.x);
                }
            }
            int i5 = zq0Var.d;
            if ((i5 & 8) == 8) {
                int i6 = zq0Var.z;
                this.f |= AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
                this.x = i6;
            }
            if ((i5 & 16) == 16) {
                nr0 nr0VarG = zq0Var.A;
                if ((this.f & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) == 16384 && (nr0Var = this.y) != nr0.z) {
                    nr0.c cVarO = nr0.o(nr0Var);
                    cVarO.h(nr0VarG);
                    nr0VarG = cVarO.g();
                }
                this.y = nr0VarG;
                this.f |= AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME;
            }
            int i7 = zq0Var.d;
            if ((i7 & 32) == 32) {
                int i8 = zq0Var.B;
                this.f |= AttribFlags.SSH_FILEXFER_ATTR_CTIME;
                this.z = i8;
            }
            if ((i7 & 64) == 64) {
                qr0 qr0VarF = zq0Var.C;
                if ((this.f & 65536) == 65536 && (qr0Var = this.A) != qr0.j) {
                    qr0.b bVarE = qr0.e(qr0Var);
                    bVarE.g(qr0VarF);
                    qr0VarF = bVarE.f();
                }
                this.A = qr0VarF;
                this.f |= 65536;
            }
            if (!zq0Var.D.isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = zq0Var.D;
                    this.f &= -131073;
                } else {
                    if ((this.f & 131072) != 131072) {
                        this.B = new ArrayList(this.B);
                        this.f |= 131072;
                    }
                    this.B.addAll(zq0Var.D);
                }
            }
            if ((zq0Var.d & 128) == 128) {
                tr0 tr0VarM10f = zq0Var.E;
                if ((this.f & 262144) == 262144 && (tr0Var = this.C) != tr0.g) {
                    br0.b bVar = new br0.b(2);
                    bVar.g(tr0Var);
                    bVar.g(tr0VarM10f);
                    tr0VarM10f = bVar.m10f();
                }
                this.C = tr0VarM10f;
                this.f |= 262144;
            }
            f(zq0Var);
            this.b = this.b.d(zq0Var.c);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum c implements h30.a {
        c("CLASS"),
        d("INTERFACE"),
        f("ENUM_CLASS"),
        /* JADX INFO: Fake field, exist only in values array */
        EF5("ENUM_ENTRY"),
        g("ANNOTATION_CLASS"),
        /* JADX INFO: Fake field, exist only in values array */
        EF9("OBJECT"),
        i("COMPANION_OBJECT");

        public final int b;

        c(String str) {
            this.b = i;
        }

        @Override // h30.a
        public final int getNumber() {
            return this.b;
        }
    }

    static {
        zq0 zq0Var = new zq0();
        H = zq0Var;
        zq0Var.m();
    }

    public zq0() {
        this.p = -1;
        this.r = -1;
        this.y = -1;
        this.F = (byte) -1;
        this.G = -1;
        this.c = fa.b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public zq0(xd xdVar, ps psVar) {
        List list;
        int iD;
        ar0.a aVar;
        Object objG;
        br0.b bVar;
        this.p = -1;
        this.r = -1;
        this.y = -1;
        this.F = (byte) -1;
        this.G = -1;
        m();
        fa.b bVarL = fa.l();
        boolean z = true;
        yd ydVarJ = yd.j(bVarL, 1);
        boolean z2 = false;
        int i = 0;
        while (true) {
            boolean z3 = z;
            if (z2) {
                if ((i & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if ((i & 8) == 8) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if ((i & 16) == 16) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if ((i & 64) == 64) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if ((i & 128) == 128) {
                    this.s = Collections.unmodifiableList(this.s);
                }
                if ((i & 256) == 256) {
                    this.t = Collections.unmodifiableList(this.t);
                }
                if ((i & 512) == 512) {
                    this.u = Collections.unmodifiableList(this.u);
                }
                if ((i & 1024) == 1024) {
                    this.v = Collections.unmodifiableList(this.v);
                }
                if ((i & 2048) == 2048) {
                    this.w = Collections.unmodifiableList(this.w);
                }
                if ((i & 4096) == 4096) {
                    this.x = Collections.unmodifiableList(this.x);
                }
                if ((i & 131072) == 131072) {
                    this.D = Collections.unmodifiableList(this.D);
                }
                try {
                    ydVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.c = bVarL.c();
                    throw th;
                }
                this.c = bVarL.c();
                i$1();
                return;
            }
            try {
                try {
                    try {
                        int iN = xdVar.n();
                        switch (iN) {
                            case 0:
                                z2 = z3;
                                break;
                            case 8:
                                this.d |= 1;
                                this.f = xdVar.f();
                                break;
                            case 16:
                                if ((i & 32) != 32) {
                                    this.o = new ArrayList();
                                    i |= 32;
                                }
                                list = this.o;
                                objG = Integer.valueOf(xdVar.f());
                                list.add(objG);
                                break;
                            case 18:
                                iD = xdVar.d(xdVar.k());
                                if ((i & 32) != 32 && xdVar.b() > 0) {
                                    this.o = new ArrayList();
                                    i |= 32;
                                }
                                while (xdVar.b() > 0) {
                                    this.o.add(Integer.valueOf(xdVar.f()));
                                }
                                xdVar.c(iD);
                                break;
                            case 24:
                                this.d |= 2;
                                this.g = xdVar.f();
                                break;
                            case 32:
                                this.d |= 4;
                                this.i = xdVar.f();
                                break;
                            case 42:
                                if ((i & 8) != 8) {
                                    this.j = new ArrayList();
                                    i |= 8;
                                }
                                list = this.j;
                                aVar = pr0.t;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 50:
                                if ((i & 16) != 16) {
                                    this.n = new ArrayList();
                                    i |= 16;
                                }
                                list = this.n;
                                aVar = nr0.A;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 56:
                                if ((i & 64) != 64) {
                                    this.q = new ArrayList();
                                    i |= 64;
                                }
                                list = this.q;
                                objG = Integer.valueOf(xdVar.f());
                                list.add(objG);
                                break;
                            case 58:
                                iD = xdVar.d(xdVar.k());
                                if ((i & 64) != 64 && xdVar.b() > 0) {
                                    this.q = new ArrayList();
                                    i |= 64;
                                }
                                while (xdVar.b() > 0) {
                                    this.q.add(Integer.valueOf(xdVar.f()));
                                }
                                xdVar.c(iD);
                                break;
                            case 66:
                                if ((i & 128) != 128) {
                                    this.s = new ArrayList();
                                    i |= 128;
                                }
                                list = this.s;
                                aVar = ar0.p;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 74:
                                if ((i & 256) != 256) {
                                    this.t = new ArrayList();
                                    i |= 256;
                                }
                                list = this.t;
                                aVar = fr0.y;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 82:
                                if ((i & 512) != 512) {
                                    this.u = new ArrayList();
                                    i |= 512;
                                }
                                list = this.u;
                                aVar = kr0.y;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 90:
                                if ((i & 1024) != 1024) {
                                    this.v = new ArrayList();
                                    i |= 1024;
                                }
                                list = this.v;
                                aVar = or0.v;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 106:
                                if ((i & 2048) != 2048) {
                                    this.w = new ArrayList();
                                    i |= 2048;
                                }
                                list = this.w;
                                aVar = dr0.n;
                                objG = xdVar.g(aVar, psVar);
                                list.add(objG);
                                break;
                            case 128:
                                if ((i & 4096) != 4096) {
                                    this.x = new ArrayList();
                                    i |= 4096;
                                }
                                list = this.x;
                                objG = Integer.valueOf(xdVar.f());
                                list.add(objG);
                                break;
                            case 130:
                                iD = xdVar.d(xdVar.k());
                                if ((i & 4096) != 4096 && xdVar.b() > 0) {
                                    this.x = new ArrayList();
                                    i |= 4096;
                                }
                                while (xdVar.b() > 0) {
                                    this.x.add(Integer.valueOf(xdVar.f()));
                                }
                                xdVar.c(iD);
                                break;
                            case 136:
                                this.d |= 8;
                                this.z = xdVar.f();
                                break;
                            case 146:
                                nr0.c cVarP = (this.d & 16) == 16 ? this.A.p() : null;
                                nr0 nr0Var = (nr0) xdVar.g(nr0.A, psVar);
                                this.A = nr0Var;
                                if (cVarP != 0) {
                                    cVarP.h(nr0Var);
                                    this.A = cVarP.g();
                                }
                                this.d |= 16;
                                break;
                            case 152:
                                this.d |= 32;
                                this.B = xdVar.f();
                                break;
                            case 242:
                                qr0.b bVarF = (this.d & 64) == 64 ? this.C.f() : null;
                                qr0 qr0Var = (qr0) xdVar.g(qr0.n, psVar);
                                this.C = qr0Var;
                                if (bVarF != 0) {
                                    bVarF.g(qr0Var);
                                    this.C = bVarF.f();
                                }
                                this.d |= 64;
                                break;
                            case 248:
                                if ((i & 131072) != 131072) {
                                    this.D = new ArrayList();
                                    i |= 131072;
                                }
                                list = this.D;
                                objG = Integer.valueOf(xdVar.f());
                                list.add(objG);
                                break;
                            case n.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                iD = xdVar.d(xdVar.k());
                                if ((i & 131072) != 131072 && xdVar.b() > 0) {
                                    this.D = new ArrayList();
                                    i |= 131072;
                                }
                                while (xdVar.b() > 0) {
                                    this.D.add(Integer.valueOf(xdVar.f()));
                                }
                                xdVar.c(iD);
                                break;
                            case 258:
                                if ((this.d & 128) == 128) {
                                    tr0 tr0Var = this.E;
                                    tr0Var.getClass();
                                    bVar = new br0.b(2);
                                    bVar.g(tr0Var);
                                } else {
                                    bVar = null;
                                }
                                tr0 tr0Var2 = (tr0) xdVar.g(tr0.i, psVar);
                                this.E = tr0Var2;
                                if (bVar != null) {
                                    bVar.g(tr0Var2);
                                    this.E = bVar.m10f();
                                }
                                this.d |= 128;
                                break;
                            default:
                                if (!k(xdVar, ydVarJ, psVar, iN)) {
                                    z2 = z3;
                                }
                                break;
                        }
                        z = z3;
                    } catch (t30 e) {
                        e.b = this;
                        throw e;
                    }
                } catch (IOException e2) {
                    t30 t30Var = new t30(e2.getMessage());
                    t30Var.b = this;
                    throw t30Var;
                }
            } catch (Throwable th2) {
                if ((i & 32) == 32) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if ((i & 8) == 8) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if ((i & 16) == 16) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if ((i & 64) == 64) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if ((i & 128) == 128) {
                    this.s = Collections.unmodifiableList(this.s);
                }
                if ((i & 256) == 256) {
                    this.t = Collections.unmodifiableList(this.t);
                }
                if ((i & 512) == 512) {
                    this.u = Collections.unmodifiableList(this.u);
                }
                if ((i & 1024) == 1024) {
                    this.v = Collections.unmodifiableList(this.v);
                }
                if ((i & 2048) == 2048) {
                    this.w = Collections.unmodifiableList(this.w);
                }
                if ((i & 4096) == 4096) {
                    this.x = Collections.unmodifiableList(this.x);
                }
                if ((i & 131072) == 131072) {
                    this.D = Collections.unmodifiableList(this.D);
                }
                try {
                    ydVarJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.c = bVarL.c();
                    throw th3;
                }
                this.c = bVarL.c();
                i$1();
                throw th2;
            }
        }
    }

    public zq0(b bVar) {
        super(bVar);
        this.p = -1;
        this.r = -1;
        this.y = -1;
        this.F = (byte) -1;
        this.G = -1;
        this.c = bVar.b;
    }

    @Override // defpackage.b0
    public final void a(yd ydVar) throws IOException {
        getSerializedSize();
        zl0 zl0Var = new zl0(this);
        if ((this.d & 1) == 1) {
            ydVar.m(1, this.f);
        }
        if (this.o.size() > 0) {
            ydVar.v(18);
            ydVar.v(this.p);
        }
        for (int i = 0; i < this.o.size(); i++) {
            ydVar.n(((Integer) this.o.get(i)).intValue());
        }
        if ((this.d & 2) == 2) {
            ydVar.m(3, this.g);
        }
        if ((this.d & 4) == 4) {
            ydVar.m(4, this.i);
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            ydVar.o(5, (b0) this.j.get(i2));
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            ydVar.o(6, (b0) this.n.get(i3));
        }
        if (this.q.size() > 0) {
            ydVar.v(58);
            ydVar.v(this.r);
        }
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            ydVar.n(((Integer) this.q.get(i4)).intValue());
        }
        for (int i5 = 0; i5 < this.s.size(); i5++) {
            ydVar.o(8, (b0) this.s.get(i5));
        }
        for (int i6 = 0; i6 < this.t.size(); i6++) {
            ydVar.o(9, (b0) this.t.get(i6));
        }
        for (int i7 = 0; i7 < this.u.size(); i7++) {
            ydVar.o(10, (b0) this.u.get(i7));
        }
        for (int i8 = 0; i8 < this.v.size(); i8++) {
            ydVar.o(11, (b0) this.v.get(i8));
        }
        for (int i9 = 0; i9 < this.w.size(); i9++) {
            ydVar.o(13, (b0) this.w.get(i9));
        }
        if (this.x.size() > 0) {
            ydVar.v(130);
            ydVar.v(this.y);
        }
        for (int i10 = 0; i10 < this.x.size(); i10++) {
            ydVar.n(((Integer) this.x.get(i10)).intValue());
        }
        if ((this.d & 8) == 8) {
            ydVar.m(17, this.z);
        }
        if ((this.d & 16) == 16) {
            ydVar.o(18, this.A);
        }
        if ((this.d & 32) == 32) {
            ydVar.m(19, this.B);
        }
        if ((this.d & 64) == 64) {
            ydVar.o(30, this.C);
        }
        for (int i11 = 0; i11 < this.D.size(); i11++) {
            ydVar.m(31, ((Integer) this.D.get(i11)).intValue());
        }
        if ((this.d & 128) == 128) {
            ydVar.o(32, this.E);
        }
        zl0Var.a(19000, ydVar);
        ydVar.r(this.c);
    }

    @Override // defpackage.oh0
    public final b0 getDefaultInstanceForType() {
        return H;
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        List list;
        List list2;
        List list3;
        List list4;
        int i = this.G;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int iB = (this.d & 1) == 1 ? yd.b(1, this.f) : 0;
        int i3 = 0;
        int iC = 0;
        while (true) {
            int size = this.o.size();
            list = this.o;
            if (i3 >= size) {
                break;
            }
            iC += yd.c(((Integer) list.get(i3)).intValue());
            i3++;
        }
        int iD = iB + iC;
        if (!list.isEmpty()) {
            iD = iD + 1 + yd.c(iC);
        }
        this.p = iC;
        if ((this.d & 2) == 2) {
            iD += yd.b(3, this.g);
        }
        if ((this.d & 4) == 4) {
            iD += yd.b(4, this.i);
        }
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            iD += yd.d(5, (b0) this.j.get(i4));
        }
        for (int i5 = 0; i5 < this.n.size(); i5++) {
            iD += yd.d(6, (b0) this.n.get(i5));
        }
        int i6 = 0;
        int iC2 = 0;
        while (true) {
            int size2 = this.q.size();
            list2 = this.q;
            if (i6 >= size2) {
                break;
            }
            iC2 += yd.c(((Integer) list2.get(i6)).intValue());
            i6++;
        }
        int iD2 = iD + iC2;
        if (!list2.isEmpty()) {
            iD2 = iD2 + 1 + yd.c(iC2);
        }
        this.r = iC2;
        for (int i7 = 0; i7 < this.s.size(); i7++) {
            iD2 += yd.d(8, (b0) this.s.get(i7));
        }
        for (int i8 = 0; i8 < this.t.size(); i8++) {
            iD2 += yd.d(9, (b0) this.t.get(i8));
        }
        for (int i9 = 0; i9 < this.u.size(); i9++) {
            iD2 += yd.d(10, (b0) this.u.get(i9));
        }
        for (int i10 = 0; i10 < this.v.size(); i10++) {
            iD2 += yd.d(11, (b0) this.v.get(i10));
        }
        for (int i11 = 0; i11 < this.w.size(); i11++) {
            iD2 += yd.d(13, (b0) this.w.get(i11));
        }
        int i12 = 0;
        int iC3 = 0;
        while (true) {
            int size3 = this.x.size();
            list3 = this.x;
            if (i12 >= size3) {
                break;
            }
            iC3 += yd.c(((Integer) list3.get(i12)).intValue());
            i12++;
        }
        int iD3 = iD2 + iC3;
        if (!list3.isEmpty()) {
            iD3 = iD3 + 2 + yd.c(iC3);
        }
        this.y = iC3;
        if ((this.d & 8) == 8) {
            iD3 += yd.b(17, this.z);
        }
        if ((this.d & 16) == 16) {
            iD3 += yd.d(18, this.A);
        }
        if ((this.d & 32) == 32) {
            iD3 += yd.b(19, this.B);
        }
        if ((this.d & 64) == 64) {
            iD3 += yd.d(30, this.C);
        }
        int iC4 = 0;
        while (true) {
            int size4 = this.D.size();
            list4 = this.D;
            if (i2 >= size4) {
                break;
            }
            iC4 += yd.c(((Integer) list4.get(i2)).intValue());
            i2++;
        }
        int size5 = (list4.size() * 2) + iD3 + iC4;
        if ((this.d & 128) == 128) {
            size5 += yd.d(32, this.E);
        }
        int size6 = this.c.size() + f() + size5;
        this.G = size6;
        return size6;
    }

    @Override // defpackage.oh0
    public final boolean isInitialized() {
        byte b2 = this.F;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if ((this.d & 2) != 2) {
            this.F = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.j.size(); i++) {
            if (!((pr0) this.j.get(i)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if (!((nr0) this.n.get(i2)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (!((ar0) this.s.get(i3)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.t.size(); i4++) {
            if (!((fr0) this.t.get(i4)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < this.u.size(); i5++) {
            if (!((kr0) this.u.get(i5)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.v.size(); i6++) {
            if (!((or0) this.v.get(i6)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < this.w.size(); i7++) {
            if (!((dr0) this.w.get(i7)).isInitialized()) {
                this.F = (byte) 0;
                return false;
            }
        }
        if ((this.d & 16) == 16 && !this.A.isInitialized()) {
            this.F = (byte) 0;
            return false;
        }
        if ((this.d & 64) == 64 && !this.C.isInitialized()) {
            this.F = (byte) 0;
            return false;
        }
        if (e()) {
            this.F = (byte) 1;
            return true;
        }
        this.F = (byte) 0;
        return false;
    }

    public final void m() {
        this.f = 6;
        this.g = 0;
        this.i = 0;
        List list = Collections.EMPTY_LIST;
        this.j = list;
        this.n = list;
        this.o = list;
        this.q = list;
        this.s = list;
        this.t = list;
        this.u = list;
        this.v = list;
        this.w = list;
        this.x = list;
        this.z = 0;
        this.A = nr0.z;
        this.B = 0;
        this.C = qr0.j;
        this.D = list;
        this.E = tr0.g;
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
