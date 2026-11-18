package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lr0 extends yx {
    public static final lr0 g;
    public static final ar0.a i = new ar0.a(9);
    public final fa b;
    public List c;
    public byte d;
    public int f;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends yx {
        public static final c n;
        public static final ar0.a o = new ar0.a(10);
        public final fa b;
        public int c;
        public int d;
        public int f;
        public EnumC0036c g;
        public byte i;
        public int j;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends yx.a implements oh0 {
            public int c;
            public int f;
            public int d = -1;
            public EnumC0036c g = EnumC0036c.d;

            /* JADX WARN: Code duplicated, block: B:14:0x001b  */
            @Override // yx.a
            public final yx.a b(xd xdVar, ps psVar) throws Throwable {
                c cVar;
                try {
                    try {
                        c.o.getClass();
                        g(new c(xdVar));
                        return this;
                    } catch (t30 e) {
                        cVar = (c) e.b;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            if (cVar != null) {
                                g(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cVar = null;
                    if (cVar != null) {
                        g(cVar);
                    }
                    throw th;
                }
            }

            @Override // yx.a
            public final b0 build() {
                c cVarF = f();
                if (cVarF.isInitialized()) {
                    return cVarF;
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
                g((c) yxVar);
                return this;
            }

            public final c f() {
                c cVar = new c(this);
                int i = this.c;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.d = this.d;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.f = this.f;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.g = this.g;
                cVar.c = i2;
                return cVar;
            }

            public final void g(c cVar) {
                if (cVar == c.n) {
                    return;
                }
                int i = cVar.c;
                if ((i & 1) == 1) {
                    int i2 = cVar.d;
                    this.c = 1 | this.c;
                    this.d = i2;
                }
                if ((i & 2) == 2) {
                    int i3 = cVar.f;
                    this.c = 2 | this.c;
                    this.f = i3;
                }
                if ((i & 4) == 4) {
                    EnumC0036c enumC0036c = cVar.g;
                    enumC0036c.getClass();
                    this.c = 4 | this.c;
                    this.g = enumC0036c;
                }
                this.b = this.b.d(cVar.b);
            }
        }

        /* JADX INFO: renamed from: lr0$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum EnumC0036c implements h30.a {
            c("CLASS"),
            d("PACKAGE"),
            f("LOCAL");

            public final int b;

            EnumC0036c(String str) {
                this.b = i;
            }

            @Override // h30.a
            public final int getNumber() {
                return this.b;
            }
        }

        static {
            c cVar = new c();
            n = cVar;
            cVar.d = -1;
            cVar.f = 0;
            cVar.g = EnumC0036c.d;
        }

        public c() {
            this.i = (byte) -1;
            this.j = -1;
            this.b = fa.b;
        }

        public c(b bVar) {
            this.i = (byte) -1;
            this.j = -1;
            this.b = bVar.b;
        }

        public c(xd xdVar) {
            this.i = (byte) -1;
            this.j = -1;
            this.d = -1;
            boolean z = false;
            this.f = 0;
            EnumC0036c enumC0036c = EnumC0036c.d;
            this.g = enumC0036c;
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
                            } else if (iN == 16) {
                                this.c |= 2;
                                this.f = xdVar.k();
                            } else if (iN == 24) {
                                int iK = xdVar.k();
                                EnumC0036c enumC0036c2 = iK != 0 ? iK != 1 ? iK != 2 ? null : EnumC0036c.f : enumC0036c : EnumC0036c.c;
                                if (enumC0036c2 == null) {
                                    ydVarJ.v(iN);
                                    ydVarJ.v(iK);
                                } else {
                                    this.c |= 4;
                                    this.g = enumC0036c2;
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
                    try {
                        ydVarJ.k();
                    } catch (IOException unused) {
                    } finally {
                        this.b = bVar.c();
                    }
                    throw th;
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
            ydVar.r(this.b);
        }

        @Override // defpackage.b0
        public final int getSerializedSize() {
            int i = this.j;
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
            int size = this.b.size() + iB;
            this.j = size;
            return size;
        }

        @Override // defpackage.oh0
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if ((this.c & 2) == 2) {
                this.i = (byte) 1;
                return true;
            }
            this.i = (byte) 0;
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

    static {
        lr0 lr0Var = new lr0();
        g = lr0Var;
        lr0Var.c = Collections.EMPTY_LIST;
    }

    public lr0() {
        this.d = (byte) -1;
        this.f = -1;
        this.b = fa.b;
    }

    public lr0(br0.b bVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.b = bVar.b;
    }

    public lr0(xd xdVar, ps psVar) {
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
                            this.c.add(xdVar.g(c.o, psVar));
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
        byte b = this.d;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (!((c) this.c.get(i2)).isInitialized()) {
                this.d = (byte) 0;
                return false;
            }
        }
        this.d = (byte) 1;
        return true;
    }

    @Override // defpackage.b0
    public final yx.a newBuilderForType() {
        return new br0.b(1);
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        br0.b bVar = new br0.b(1);
        bVar.g(this);
        return bVar;
    }
}
