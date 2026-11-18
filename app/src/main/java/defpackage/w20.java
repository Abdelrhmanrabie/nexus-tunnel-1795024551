package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class w20 implements Iterable, w90 {
    public final int b;
    public final int c;
    public final int d;

    public w20(int i, int i2, int i3) {
        if (i3 == 0) {
            d.AnonymousClass0.m$2("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            d.AnonymousClass0.m$2("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.b = i;
        this.c = e.i(i, i2, i3);
        this.d = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w20)) {
            return false;
        }
        if (isEmpty() && ((w20) obj).isEmpty()) {
            return true;
        }
        w20 w20Var = (w20) obj;
        return this.b == w20Var.b && this.c == w20Var.c && this.d == w20Var.d;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public boolean isEmpty() {
        int i = this.d;
        int i2 = this.c;
        int i3 = this.b;
        if (i > 0) {
            return i3 > i2;
        }
        return i3 < i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new x20(this.b, this.c, this.d);
    }

    public String toString() {
        int i = this.c;
        int i2 = this.b;
        int i3 = this.d;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        if (i3 > 0) {
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i3);
        } else {
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i3);
        }
        return sb.toString();
    }
}
