package androidx.recyclerview.widget;

import defpackage.gp0;
import defpackage.o01;
import defpackage.qf0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public final o01 a = new o01();
    public final qf0 b = new qf0();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public static final gp0 d = new gp0(20);
        public int a;
        public RecyclerView.l.c b;
        public RecyclerView.l.c c;

        public static a a() {
            a aVar = (a) d.b();
            return aVar == null ? new a() : aVar;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
    }

    public final RecyclerView.l.c b(RecyclerView.d0 d0Var, int i) {
        a aVar;
        RecyclerView.l.c cVar;
        o01 o01Var = this.a;
        int iF = o01Var.f(d0Var);
        if (iF >= 0 && (aVar = (a) o01Var.k(iF)) != null) {
            int i2 = aVar.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                aVar.a = i3;
                if (i == 4) {
                    cVar = aVar.b;
                } else if (i == 8) {
                    cVar = aVar.c;
                } else {
                    defpackage.d.AnonymousClass0.m$2("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    o01Var.j(iF);
                    aVar.a = 0;
                    aVar.b = null;
                    aVar.c = null;
                    a.d.a(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    public final void c(RecyclerView.d0 d0Var) {
        a aVar = (a) this.a.getOrDefault(d0Var, null);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    public final void d(RecyclerView.d0 d0Var) {
        qf0 qf0Var = this.b;
        if (qf0Var.b) {
            qf0Var.e();
        }
        for (int i = qf0Var.f - 1; i >= 0; i--) {
            if (d0Var == qf0Var.h(i)) {
                Object[] objArr = qf0Var.d;
                Object obj = objArr[i];
                Object obj2 = qf0.g;
                if (obj == obj2) {
                    break;
                }
                objArr[i] = obj2;
                qf0Var.b = true;
                break;
            }
        }
        a aVar = (a) this.a.remove(d0Var);
        if (aVar != null) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            a.d.a(aVar);
        }
    }
}
