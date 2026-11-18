package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q80 extends y8 {
    public static final q80 g = new q80(new int[]{1, 6, 0}, false);
    public final boolean f;

    static {
        new q80(new int[0], false);
    }

    public q80(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        this.f = z;
    }

    public final boolean c() {
        int i = this.c;
        int i2 = this.b;
        if (i2 == 1 && i == 0) {
            return false;
        }
        boolean z = this.f;
        q80 q80Var = g;
        if (z) {
            int i3 = q80Var.c;
            int i4 = q80Var.b;
            if (i2 == 0) {
                if (i4 != 0 || i != i3) {
                    return false;
                }
            } else if (i2 != i4 || i > i3) {
                return false;
            }
        } else if (i2 != q80Var.b || i > q80Var.c + 1) {
            return false;
        }
        return true;
    }
}
