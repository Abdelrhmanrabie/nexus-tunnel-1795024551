package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c7 extends dg0 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object d;

    public /* synthetic */ c7(int i, Object obj) {
        this.G0 = i;
        this.d = obj;
    }

    @Override // defpackage.dg0
    /* JADX INFO: renamed from: a */
    public final void mo12a() {
        int i = this.G0;
        Object obj = this.d;
        if (i != 0) {
            ((g7) obj).clear();
        } else {
            ((d7) obj).clear();
        }
    }

    @Override // defpackage.dg0
    public final Object b(int i, int i2) {
        int i3 = this.G0;
        Object obj = this.d;
        return i3 != 0 ? ((g7) obj).c[i] : ((d7) obj).c[(i << 1) + i2];
    }

    @Override // defpackage.dg0
    public final Map c() {
        if (this.G0 == 0) {
            return (d7) this.d;
        }
        throw new UnsupportedOperationException("not a map");
    }

    @Override // defpackage.dg0
    public final int d() {
        int i = this.G0;
        Object obj = this.d;
        return i != 0 ? ((g7) obj).d : ((d7) obj).d;
    }

    @Override // defpackage.dg0
    public final int e(Object obj) {
        int i = this.G0;
        Object obj2 = this.d;
        if (i == 0) {
            return ((d7) obj2).f(obj);
        }
        g7 g7Var = (g7) obj2;
        return obj == null ? g7Var.g() : g7Var.e(obj.hashCode(), obj);
    }

    @Override // defpackage.dg0
    public final int f(Object obj) {
        int i = this.G0;
        Object obj2 = this.d;
        if (i == 0) {
            return ((d7) obj2).h(obj);
        }
        g7 g7Var = (g7) obj2;
        return obj == null ? g7Var.g() : g7Var.e(obj.hashCode(), obj);
    }

    @Override // defpackage.dg0
    public final void g(Object obj, Object obj2) {
        int i = this.G0;
        Object obj3 = this.d;
        if (i != 0) {
            ((g7) obj3).add(obj);
        } else {
            ((d7) obj3).put(obj, obj2);
        }
    }

    @Override // defpackage.dg0
    public final void h(int i) {
        int i2 = this.G0;
        Object obj = this.d;
        if (i2 != 0) {
            ((g7) obj).h(i);
        } else {
            ((d7) obj).j(i);
        }
    }

    @Override // defpackage.dg0
    public final Object i(int i, Object obj) {
        if (this.G0 != 0) {
            throw new UnsupportedOperationException("not a map");
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = ((d7) this.d).c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }
}
