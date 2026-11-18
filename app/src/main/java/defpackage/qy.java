package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qy extends yf1 {
    @Override // defpackage.zl
    public final void a() {
        dm dmVar = this.h;
        if (dmVar.c && !dmVar.j) {
            dmVar.d((int) ((((dm) dmVar.l.get(0)).g * ((py) this.b).s0) + 0.5f));
        }
    }

    @Override // defpackage.yf1
    public final void d() {
        yf1 yf1Var;
        ch chVar = this.b;
        py pyVar = (py) chVar;
        int i = pyVar.t0;
        int i2 = pyVar.u0;
        int i3 = pyVar.w0;
        dm dmVar = this.h;
        if (i3 == 1) {
            if (i != -1) {
                dmVar.l.add(chVar.W.d.h);
                this.b.W.d.h.k.add(dmVar);
                dmVar.f = i;
            } else if (i2 != -1) {
                dmVar.l.add(chVar.W.d.i);
                this.b.W.d.i.k.add(dmVar);
                dmVar.f = -i2;
            } else {
                dmVar.b = true;
                dmVar.l.add(chVar.W.d.i);
                this.b.W.d.i.k.add(dmVar);
            }
            dm dmVar2 = this.b.d.h;
            dmVar.k.add(dmVar2);
            dmVar2.l.add(dmVar);
            yf1Var = this.b.d;
        } else {
            if (i != -1) {
                dmVar.l.add(chVar.W.e.h);
                this.b.W.e.h.k.add(dmVar);
                dmVar.f = i;
            } else if (i2 != -1) {
                dmVar.l.add(chVar.W.e.i);
                this.b.W.e.i.k.add(dmVar);
                dmVar.f = -i2;
            } else {
                dmVar.b = true;
                dmVar.l.add(chVar.W.e.i);
                this.b.W.e.i.k.add(dmVar);
            }
            dm dmVar3 = this.b.e.h;
            dmVar.k.add(dmVar3);
            dmVar3.l.add(dmVar);
            yf1Var = this.b.e;
        }
        dm dmVar4 = yf1Var.i;
        dmVar.k.add(dmVar4);
        dmVar4.l.add(dmVar);
    }

    @Override // defpackage.yf1
    public final void e() {
        ch chVar = this.b;
        int i = ((py) chVar).w0;
        dm dmVar = this.h;
        if (i == 1) {
            chVar.b0 = dmVar.g;
        } else {
            chVar.c0 = dmVar.g;
        }
    }

    @Override // defpackage.yf1
    public final void f() {
        this.h.c();
    }

    @Override // defpackage.yf1
    public final boolean k() {
        return false;
    }
}
