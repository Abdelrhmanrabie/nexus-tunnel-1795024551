package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class td0 extends y {
    public final v8 q;
    public final gu0 r;

    /* JADX WARN: Illegal instructions before constructor call */
    public td0(v8 v8Var, gu0 gu0Var, int i, qk qkVar) {
        c60 c60Var = (c60) v8Var.a;
        super(c60Var.a, qkVar, new wc0(v8Var, gu0Var, false), ij0.f(gu0Var.a.getName()), ad1.INVARIANT, false, i, c60Var.m);
        this.q = v8Var;
        this.r = gu0Var;
    }

    @Override // defpackage.y0
    public final List G0(List list) {
        v8 v8Var = this.q;
        m6 m6Var = ((c60) v8Var.a).r;
        m6Var.getClass();
        ArrayList arrayList = new ArrayList(ae.y0(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            fc0 fc0Var = (fc0) it.next();
            if (!ma1.d(fc0Var, ba.b$21, null, null)) {
                fc0Var = d01$b.d(new d01$b(m6Var, this, fc0Var, uq.b, false, v8Var, j4.TYPE_PARAMETER_BOUNDS, 128), null, 3).a;
            }
            arrayList.add(fc0Var);
        }
        return arrayList;
    }

    @Override // defpackage.y0
    public final List L0() {
        Type[] bounds = this.r.a.getBounds();
        ArrayList arrayList = new ArrayList(bounds.length);
        int length = bounds.length;
        int i = 0;
        while (i < length) {
            Type type = bounds[i];
            i++;
            arrayList.add(new tt0(type));
        }
        tt0 tt0Var = (tt0) (arrayList.size() == 1 ? arrayList.get(0) : null);
        Collection collection = arrayList;
        if (e4.a(tt0Var != null ? tt0Var.a : null, Object.class)) {
            collection = uq.b;
        }
        boolean zIsEmpty = collection.isEmpty();
        v8 v8Var = this.q;
        if (zIsEmpty) {
            return Collections.singletonList(e4.c(((c60) v8Var.a).o.k().f(), ((c60) v8Var.a).o.k().p()));
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(collection));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(((oo) v8Var.e).e((tt0) it.next(), w60.b(2, false, this, 1)));
        }
        return arrayList2;
    }
}
