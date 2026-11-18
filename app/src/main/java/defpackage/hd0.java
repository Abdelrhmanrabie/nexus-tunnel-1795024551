package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hd0 extends sd0 {
    public final cu0 n;
    public final fd0 o;
    public final ff0.f p;
    public final ff0.j q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final ij0 a;
        public final qt0 b;

        public a(ij0 ij0Var, qt0 qt0Var) {
            this.a = ij0Var;
            this.b = qt0Var;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return e4.a(this.a, ((a) obj).a);
            }
            return false;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    public hd0(v8 v8Var, cu0 cu0Var, fd0 fd0Var) {
        super(v8Var, null);
        this.n = cu0Var;
        this.o = fd0Var;
        ff0 ff0Var = ((c60) v8Var.a).a;
        qn qnVar = new qn(8, v8Var, this);
        ff0Var.getClass();
        this.p = new ff0.f(ff0Var, qnVar);
        this.q = ff0Var.d(new dd0.c(v8Var, this, 3, false));
    }

    @Override // defpackage.jd0, defpackage.wg0, defpackage.vg0
    public final Collection c(ij0 ij0Var, dl0 dl0Var) {
        return uq.b;
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        return v(ij0Var, null);
    }

    @Override // defpackage.jd0, defpackage.wg0, defpackage.vg0
    public final Collection f(lm lmVar, nw nwVar) {
        if (!lmVar.a(lm.l | lm.e)) {
            return uq.b;
        }
        Iterable iterable = (Iterable) this.d.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            ok okVar = (ok) obj;
            if ((okVar instanceof ai0) && ((Boolean) nwVar.invoke(((ai0) okVar).getName())).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // defpackage.jd0
    public final Set h(lm lmVar, p0 p0Var) {
        if (!lmVar.a(lm.e)) {
            return yq.b;
        }
        Set set = (Set) this.p.invoke();
        if (set == null) {
            this.n.getClass();
            return new LinkedHashSet();
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(ij0.f((String) it.next()));
        }
        return hashSet;
    }

    @Override // defpackage.jd0
    public final Set i(lm lmVar, p0 p0Var) {
        return yq.b;
    }

    @Override // defpackage.jd0
    public final vk k() {
        return vk.a.a;
    }

    @Override // defpackage.jd0
    public final void m(LinkedHashSet linkedHashSet, ij0 ij0Var) {
    }

    @Override // defpackage.jd0
    public final Set o() {
        return yq.b;
    }

    @Override // defpackage.jd0
    public final ok q() {
        return this.o;
    }

    public final ai0 v(ij0 ij0Var, qt0 qt0Var) {
        ij0 ij0Var2 = f21.a;
        if (ij0Var.b().length() <= 0 || ij0Var.c) {
            return null;
        }
        Set set = (Set) this.p.invoke();
        if (qt0Var == null && set != null && !set.contains(ij0Var.b())) {
            return null;
        }
        return (ai0) this.q.invoke(new a(ij0Var, qt0Var));
    }
}
