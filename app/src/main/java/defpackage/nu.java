package defpackage;

import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nu implements Comparator {
    public static final nu b = new nu(3);
    public static final nu b$1 = new nu(4);
    public final /* synthetic */ int G0;

    public /* synthetic */ nu(int i) {
        this.G0 = i;
    }

    public static int a(ok okVar) {
        if (okVar == null) {
            xm.a(36);
            throw null;
        }
        if (xm.n(okVar, 4)) {
            return 8;
        }
        if (okVar instanceof gh) {
            return 7;
        }
        if (okVar instanceof nq0) {
            return ((nq0) okVar).z == null ? 6 : 5;
        }
        if (okVar instanceof ox) {
            return ((ox) okVar).Q() == null ? 4 : 3;
        }
        if (okVar instanceof ai0) {
            return 2;
        }
        return okVar instanceof co ? 1 : 0;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer numValueOf;
        int i = this.G0;
        if (i == 0) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2];
                byte b3 = bArr2[i2];
                if (b2 != b3) {
                    return b2 - b3;
                }
            }
        } else {
            if (i == 1) {
                return e.l(((ha0) obj).getName(), ((ha0) obj2).getName());
            }
            if (i == 2) {
                return e.l(((Method) obj).getName(), ((Method) obj2).getName());
            }
            if (i != 3) {
                Integer numB = cn.b((cn.d) obj, (cn.d) obj2);
                if (numB != null) {
                    return numB.intValue();
                }
            } else {
                ok okVar = (ok) obj;
                ok okVar2 = (ok) obj2;
                int iA = a(okVar2) - a(okVar);
                if (iA != 0) {
                    numValueOf = Integer.valueOf(iA);
                } else if (xm.n(okVar, 4) && xm.n(okVar2, 4)) {
                    numValueOf = 0;
                } else {
                    int iCompareTo = okVar.getName().b.compareTo(okVar2.getName().b);
                    numValueOf = iCompareTo != 0 ? Integer.valueOf(iCompareTo) : null;
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
            }
        }
        return 0;
    }
}
