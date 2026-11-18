package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hr extends z implements gr, Serializable {
    public final Enum[] b;

    public hr(Enum[] enumArr) {
        this.b = enumArr;
    }

    @Override // defpackage.z
    public final int b() {
        return this.b.length;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    @Override // defpackage.z, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        Enum r0;
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (iOrdinal >= 0) {
            Enum[] enumArr = this.b;
            if (iOrdinal < enumArr.length) {
                r0 = enumArr[iOrdinal];
            } else {
                r0 = null;
            }
        } else {
            r0 = null;
        }
        return r0 == r4;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.b;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(ak.i(i, length, "index: ", ", size: "));
        }
        return enumArr[i];
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    @Override // defpackage.z, java.util.List
    public final int indexOf(Object obj) {
        Enum r1;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int iOrdinal = r4.ordinal();
        if (iOrdinal >= 0) {
            Enum[] enumArr = this.b;
            if (iOrdinal < enumArr.length) {
                r1 = enumArr[iOrdinal];
            } else {
                r1 = null;
            }
        } else {
            r1 = null;
        }
        if (r1 == r4) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // defpackage.z, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }
}
