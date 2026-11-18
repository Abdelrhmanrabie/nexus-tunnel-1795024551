package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y20 extends w20 {
    public static final y20 f = new y20(1, 0, 1);

    @Override // defpackage.w20
    public final boolean equals(Object obj) {
        if (!(obj instanceof y20)) {
            return false;
        }
        if (isEmpty() && ((y20) obj).isEmpty()) {
            return true;
        }
        y20 y20Var = (y20) obj;
        if (this.b == y20Var.b) {
            return this.c == y20Var.c;
        }
        return false;
    }

    @Override // defpackage.w20
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.b * 31) + this.c;
    }

    @Override // defpackage.w20
    public final boolean isEmpty() {
        return this.b > this.c;
    }

    @Override // defpackage.w20
    public final String toString() {
        return this.b + ".." + this.c;
    }
}
