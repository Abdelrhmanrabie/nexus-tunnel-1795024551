package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d7 extends o01 implements Map {
    public c7 n;

    public d7(d7 d7Var) {
        int i = d7Var.d;
        b(i);
        if (this.d != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(d7Var.i(i2), d7Var.k(i2));
            }
        } else if (i > 0) {
            System.arraycopy(d7Var.b, 0, this.b, 0, i);
            System.arraycopy(d7Var.c, 0, this.c, 0, i << 1);
            this.d = i;
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.n == null) {
            this.n = new c7(0, this);
        }
        c7 c7Var = this.n;
        if (((dg0.b) c7Var.a) == null) {
            c7Var.a = new dg0.b(c7Var, 0);
        }
        return (dg0.b) c7Var.a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.n == null) {
            this.n = new c7(0, this);
        }
        c7 c7Var = this.n;
        if (((dg0.b) c7Var.b) == null) {
            c7Var.b = new dg0.b(c7Var, 1);
        }
        return (dg0.b) c7Var.b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.d);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.n == null) {
            this.n = new c7(0, this);
        }
        c7 c7Var = this.n;
        if (((dg0.e) c7Var.c) == null) {
            c7Var.c = new dg0.e();
        }
        return (dg0.e) c7Var.c;
    }
}
