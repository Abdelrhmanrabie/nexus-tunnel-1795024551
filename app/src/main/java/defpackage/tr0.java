package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tr0 extends yx {
    public static final tr0 g;
    public static final ar0.a i = new ar0.a(19);
    public final fa b;
    public List c;
    public byte d;
    public int f;

    static {
        tr0 tr0Var = new tr0();
        g = tr0Var;
        tr0Var.c = Collections.EMPTY_LIST;
    }

    public tr0() {
        this.d = (byte) -1;
        this.f = -1;
        this.b = fa.b;
    }

    public tr0(br0.b bVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.b = bVar.b;
    }

    public tr0(xd xdVar, ps psVar) {
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
                            this.c.add(xdVar.g(sr0.r, psVar));
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
        if (this.d == 1) {
            return true;
        }
        this.d = (byte) 1;
        return true;
    }

    @Override // defpackage.b0
    public final yx.a newBuilderForType() {
        return new br0.b(2);
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        br0.b bVar = new br0.b(2);
        bVar.g(this);
        return bVar;
    }
}
