package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: do, reason: invalid class name */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Cdo extends y {
    public final hn q;
    public final pr0 r;
    public final in s;

    /* JADX WARN: Illegal instructions before constructor call */
    public Cdo(hn hnVar, pr0 pr0Var, int i) {
        ad1 ad1Var;
        ff0 ff0Var = hnVar.a.a;
        ok okVar = hnVar.c;
        s4$a$a s4_a_a = e4.f47a;
        ij0 ij0VarE = e.E(hnVar.b, pr0Var.g);
        int iOrdinal = pr0Var.j.ordinal();
        if (iOrdinal == 0) {
            ad1Var = ad1.IN_VARIANCE;
        } else if (iOrdinal == 1) {
            ad1Var = ad1.OUT_VARIANCE;
        } else {
            if (iOrdinal != 2) {
                d.AnonymousClass0.m();
                throw null;
            }
            ad1Var = ad1.INVARIANT;
        }
        super(ff0Var, okVar, s4_a_a, ij0VarE, ad1Var, pr0Var.i, i, ke.a);
        this.q = hnVar;
        this.r = pr0Var;
        this.s = new in(ff0Var, new ca0(3, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.y0
    public final List L0() {
        hn hnVar = this.q;
        fi0 fi0Var = hnVar.d;
        pr0 pr0Var = this.r;
        List list = pr0Var.n;
        boolean zIsEmpty = list.isEmpty();
        ArrayList arrayList = list;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List list2 = pr0Var.o;
            arrayList = new ArrayList(ae.y0(list2));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(fi0Var.a(((Integer) it.next()).intValue()));
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.singletonList(ym.e(this).p());
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(hnVar.h.f((nr0) it2.next()));
        }
        return arrayList2;
    }

    @Override // defpackage.j0, defpackage.w3
    public final s4 getAnnotations() {
        return this.s;
    }
}
