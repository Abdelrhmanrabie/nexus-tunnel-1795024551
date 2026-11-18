package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t4 implements s4 {
    public final /* synthetic */ int G0;
    public final Object b;

    public /* synthetic */ t4(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    public t4(s4[] s4VarArr) {
        this.G0 = 1;
        this.b = ae.M0(s4VarArr);
    }

    @Override // defpackage.s4
    public final g4 c(cv cvVar) {
        int i = this.G0;
        Object obj = null;
        if (i == 0) {
            for (Object obj2 : this) {
                if (e4.a(((g4) obj2).e(), cvVar)) {
                    obj = obj2;
                    break;
                }
            }
            return (g4) obj;
        }
        Object obj3 = this.b;
        if (i != 1) {
            if (e4.a(cvVar, (cv) obj3)) {
                return cr.a;
            }
            return null;
        }
        int i2 = 0;
        et.b bVar = new et.b(new ht(new c81(new ge(i2, (List) obj3), new uf$a(cvVar, i2)), false, new cz0(0)));
        return (g4) (bVar.hasNext() ? bVar.next() : null);
    }

    @Override // defpackage.s4
    public final boolean f(cv cvVar) {
        int i = this.G0;
        if (i != 0) {
            if (i == 1) {
                Iterator it = ((List) this.b).iterator();
                while (it.hasNext()) {
                    if (((s4) it.next()).f(cvVar)) {
                    }
                }
                return false;
            }
            if (c(cvVar) == null) {
                return false;
            }
        } else if (c(cvVar) == null) {
            return false;
        }
        return true;
    }

    @Override // defpackage.s4
    public final boolean isEmpty() {
        int i = this.G0;
        if (i == 0) {
            return ((List) this.b).isEmpty();
        }
        if (i != 1) {
            return false;
        }
        List list = (List) this.b;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((s4) it.next()).isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int i = this.G0;
        if (i == 0) {
            return ((List) this.b).iterator();
        }
        if (i != 1) {
            return tq.b;
        }
        return new et.b(new yt(new ge(0, (List) this.b), p0.b$10, ez0.d));
    }

    public String toString() {
        return this.G0 != 0 ? super.toString() : ((List) this.b).toString();
    }
}
