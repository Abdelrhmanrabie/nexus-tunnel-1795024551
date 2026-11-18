package defpackage;

import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i7 extends z implements RandomAccess {
    public final /* synthetic */ int[] b;

    public i7(int[] iArr) {
        this.b = iArr;
    }

    @Override // defpackage.z
    public final int b() {
        return this.b.length;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d A[RETURN] */
    @Override // defpackage.z, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Number) obj).intValue();
            int[] iArr = this.b;
            int length = iArr.length;
            int i = 0;
            while (i < length) {
                if (iIntValue != iArr[i]) {
                    i++;
                } else if (i >= 0) {
                    return true;
                }
            }
            i = -1;
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return Integer.valueOf(this.b[i]);
    }

    @Override // defpackage.z, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.b;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iIntValue == iArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // defpackage.z, java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.b.length == 0;
    }

    @Override // defpackage.z, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Number) obj).intValue();
            int[] iArr = this.b;
            int length = iArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (iIntValue == iArr[length]) {
                        return length;
                    }
                    if (i >= 0) {
                        length = i;
                    }
                }
            }
        }
        return -1;
    }
}
