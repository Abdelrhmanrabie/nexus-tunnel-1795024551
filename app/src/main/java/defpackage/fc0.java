package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class fc0 implements w3, jc0 {
    public int b;

    public abstract List K0();

    public abstract a91 L0();

    public abstract boolean M0();

    public abstract fc0 N0(lc0$a lc0_a);

    public abstract cc1 O0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fc0)) {
            return false;
        }
        fc0 fc0Var = (fc0) obj;
        if (M0() == fc0Var.M0()) {
            return e.O(e.f37g, O0(), fc0Var.O0());
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode;
        int i = this.b;
        if (i != 0) {
            return i;
        }
        if (e.O(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (M0() ? 1 : 0) + ((K0().hashCode() + (L0().hashCode() * 31)) * 31);
        }
        this.b = iHashCode;
        return iHashCode;
    }

    public abstract vg0 m();
}
