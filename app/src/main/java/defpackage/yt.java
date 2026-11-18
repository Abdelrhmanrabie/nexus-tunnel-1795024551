package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yt implements sy0 {
    public final sy0 a;
    public final nw b;
    public final nw c;

    public yt(sy0 sy0Var, nw nwVar, nw nwVar2) {
        this.a = sy0Var;
        this.b = nwVar;
        this.c = nwVar2;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        return new et.b(this);
    }
}
