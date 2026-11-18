package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ae extends e {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final Object[] A0(int i, int i2, Object[] objArr) {
        int length = objArr.length;
        if (i2 <= length) {
            return Arrays.copyOfRange(objArr, i, i2);
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }

    public static final sy0 B0(Object[] objArr) {
        return objArr.length == 0 ? xq.a : new ge(2, objArr);
    }

    public static final ArrayList D0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Object E0(Object[] objArr) {
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int H0(Object[] objArr, Object obj) {
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String J0(Object[] objArr, String str, String str2, nw nwVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) AppConfig.CUSTOM);
            }
            e.g(sb, obj, nwVar);
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }

    public static final Object K0(Object[] objArr) {
        if (objArr.length != 0) {
            return objArr[objArr.length - 1];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Object L0(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        d.AnonymousClass0.m$2("Array has more than one element.");
        return null;
    }

    public static final List M0(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? N0(objArr) : Collections.singletonList(objArr[0]);
        }
        return uq.b;
    }

    public static final ArrayList N0(Object[] objArr) {
        return new ArrayList(new y6(objArr, false));
    }

    public static final Set O0(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return yq.b;
        }
        if (length == 1) {
            return Collections.singleton(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(ye1.e(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static final int y0(Iterable iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static final void z0(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }
}
