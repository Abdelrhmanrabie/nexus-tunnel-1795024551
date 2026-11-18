package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ko extends dm {
    public int m;

    public ko(yf1 yf1Var) {
        super(yf1Var);
        this.e = yf1Var instanceof g10 ? 2 : 3;
    }

    @Override // defpackage.dm
    public final void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((zl) it.next()).a();
        }
    }
}
