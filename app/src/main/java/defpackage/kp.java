package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kp implements sy0, lp {
    public final sy0 a;
    public final int b;

    public kp(sy0 sy0Var, int i) {
        this.a = sy0Var;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // defpackage.lp
    public final sy0 a() {
        int i = this.b + 1;
        return i < 0 ? new kp(this, 1) : new kp(this.a, i);
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return new c20(this);
    }
}
