package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sb implements v91 {
    public final v91 b;
    public final pd c;
    public final int d;

    public sb(v91 v91Var, pd pdVar, int i) {
        this.b = v91Var;
        this.c = pdVar;
        this.d = i;
    }

    @Override // defpackage.v91
    public final ff0 O() {
        return this.b.O();
    }

    @Override // defpackage.v91
    public final boolean S() {
        return true;
    }

    @Override // defpackage.od
    public final od a() {
        return this.b.a();
    }

    @Override // defpackage.ok, defpackage.od
    public final ok a() {
        return this.b.a();
    }

    @Override // defpackage.v91, defpackage.od
    public final v91 a() {
        return this.b.a();
    }

    @Override // defpackage.ok
    public final ok b() {
        return this.c;
    }

    @Override // defpackage.qk
    public final t11 g() {
        return this.b.g();
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return this.b.getAnnotations();
    }

    @Override // defpackage.v91
    public final int getIndex() {
        return this.b.getIndex() + this.d;
    }

    @Override // defpackage.ok
    public final ij0 getName() {
        return this.b.getName();
    }

    @Override // defpackage.v91
    public final List getUpperBounds() {
        return this.b.getUpperBounds();
    }

    @Override // defpackage.od
    public final a91 h() {
        return this.b.h();
    }

    @Override // defpackage.v91
    public final ad1 j() {
        return this.b.j();
    }

    @Override // defpackage.od
    public final u01 n() {
        return this.b.n();
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        return this.b.r0(bjVar, obj);
    }

    public final String toString() {
        return this.b + "[inner-copy]";
    }

    @Override // defpackage.v91
    public final boolean x() {
        return this.b.x();
    }
}
