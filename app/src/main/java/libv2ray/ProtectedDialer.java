package libv2ray;

import go.Seq;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProtectedDialer implements Seq.Proxy {
    private final int refnum;

    static {
        Libv2ray.touch();
    }

    public ProtectedDialer() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }

    public ProtectedDialer(int i) {
        this.refnum = i;
        Seq.trackGoRef(i, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProtectedDialer)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public native boolean isVServerReady();

    public native void prepareResolveChan();

    public native boolean protect(long j);

    public String toString() {
        return "ProtectedDialer{}";
    }
}
