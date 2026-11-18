package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class y8 {
    public final int[] a;
    public final int b;
    public final int c;
    public final int d;
    public final List e;

    public y8(int... iArr) {
        this.a = iArr;
        Integer numValueOf = iArr.length > 0 ? Integer.valueOf(iArr[0]) : null;
        this.b = numValueOf == null ? -1 : numValueOf.intValue();
        Integer numValueOf2 = 1 < iArr.length ? Integer.valueOf(iArr[1]) : null;
        this.c = numValueOf2 == null ? -1 : numValueOf2.intValue();
        Integer numValueOf3 = 2 < iArr.length ? Integer.valueOf(iArr[2]) : null;
        this.d = numValueOf3 != null ? numValueOf3.intValue() : -1;
        this.e = iArr.length > 3 ? he.g1(new z.d(new i7(iArr), 3, iArr.length)) : uq.b;
    }

    public final boolean a(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.d >= i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        y8 y8Var = (y8) obj;
        return this.b == y8Var.b && this.c == y8Var.c && this.d == y8Var.d && e4.a(this.e, y8Var.e);
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = (i * 31) + this.c + i;
        int i3 = (i2 * 31) + this.d + i2;
        return this.e.hashCode() + (i3 * 31) + i3;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = this.a;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            i++;
            if (i2 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList.isEmpty() ? "unknown" : he.R0(arrayList, ".", null, null, null, 62);
    }
}
