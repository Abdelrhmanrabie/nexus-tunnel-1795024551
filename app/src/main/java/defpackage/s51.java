package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class s51 implements Iterable {
    public final ArrayList b = new ArrayList();
    public final w4 c;

    public s51(w4 w4Var) {
        this.c = w4Var;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.iterator();
    }
}
