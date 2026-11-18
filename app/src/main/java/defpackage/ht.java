package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ht implements sy0 {
    public final sy0 a;
    public final boolean b;
    public final nw c;

    public ht(sy0 sy0Var, boolean z, nw nwVar) {
        this.a = sy0Var;
        this.b = z;
        this.c = nwVar;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return new et.b(this);
    }
}
