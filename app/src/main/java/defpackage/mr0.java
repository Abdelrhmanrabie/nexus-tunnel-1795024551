package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mr0 extends yx {
    public static final mr0 g;
    public static final ar0.a i = new ar0.a(11);
    public final fa b;
    public zd0 c;
    public byte d;
    public int f;

    static {
        mr0 mr0Var = new mr0();
        g = mr0Var;
        mr0Var.c = yd0.c;
    }

    public mr0() {
        this.d = (byte) -1;
        this.f = -1;
        this.b = fa.b;
    }

    public mr0(br0.b bVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.b = bVar.b;
    }

    public mr0(xd xdVar) {
        this.d = (byte) -1;
        this.f = -1;
        this.c = yd0.c;
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
                            we0 we0VarE = xdVar.e();
                            if (!z2) {
                                this.c = new yd0();
                                z2 = true;
                            }
                            this.c.a(we0VarE);
                        } else if (!xdVar.q(iN, ydVarJ)) {
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2) {
                        this.c = this.c.getUnmodifiableView();
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
            this.c = this.c.getUnmodifiableView();
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
            fa byteString = this.c.getByteString(i2);
            ydVar.x(1, 2);
            ydVar.v(byteString.size());
            ydVar.r(byteString);
        }
        ydVar.r(this.b);
    }

    @Override // defpackage.b0
    public final int getSerializedSize() {
        int i2 = this.f;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        int size = 0;
        while (true) {
            int size2 = this.c.size();
            zd0 zd0Var = this.c;
            if (i3 >= size2) {
                int size3 = this.b.size() + zd0Var.size() + size;
                this.f = size3;
                return size3;
            }
            fa byteString = zd0Var.getByteString(i3);
            size += byteString.size() + yd.f(byteString.size());
            i3++;
        }
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
        return new br0.b(3);
    }

    @Override // defpackage.b0
    public final yx.a toBuilder() {
        br0.b bVar = new br0.b(3);
        bVar.g(this);
        return bVar;
    }
}
