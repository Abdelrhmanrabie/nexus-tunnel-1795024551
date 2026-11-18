package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class fz0 extends e {
    public static final List E(sy0 sy0Var) {
        Iterator it = sy0Var.iterator();
        if (!it.hasNext()) {
            return uq.b;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Collections.singletonList(next);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(next);
            if (!it.hasNext()) {
                return arrayList;
            }
            next = it.next();
        }
    }

    public static final y20 u(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? y20.f : new y20(i, i2 - 1, 1);
    }

    public static final yt u(sy0 sy0Var) {
        mu muVar = new mu(6);
        if (!(sy0Var instanceof c81)) {
            return new yt(sy0Var, new mu(7), muVar);
        }
        c81 c81Var = (c81) sy0Var;
        return new yt(c81Var.a, c81Var.b, muVar);
    }

    public static final sy0 v(lw lwVar) {
        return new ug(new ay(lwVar, new m(1, lwVar)));
    }

    public static final sy0 w(Object obj, nw nwVar) {
        return obj == null ? xq.a : new ay(new k7(obj, 0, 3), nwVar);
    }

    public static final ht y(sy0 sy0Var, nw nwVar) {
        return new ht(sy0Var, true, nwVar);
    }
}
