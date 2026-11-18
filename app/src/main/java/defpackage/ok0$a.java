package defpackage;

import java.math.BigInteger;
import java.util.Locale;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ok0$a implements Comparable {
    public final BigInteger b;
    public final int c;
    public final boolean d;
    public final boolean f;
    public BigInteger g;
    public BigInteger i;

    public ok0$a(ha haVar, boolean z) {
        this.d = z;
        this.b = BigInteger.valueOf(ha.a((String) haVar.a));
        this.c = haVar.b;
        this.f = true;
    }

    public ok0$a(BigInteger bigInteger, int i, boolean z, boolean z2) {
        this.b = bigInteger;
        this.c = i;
        this.d = z;
        this.f = z2;
    }

    public final boolean a(ok0$a ok0_a) {
        BigInteger bigIntegerB = b();
        BigInteger bigIntegerD = d();
        return (bigIntegerB.compareTo(ok0_a.b()) != 1) && (bigIntegerD.compareTo(ok0_a.d()) != -1);
    }

    public final BigInteger b() {
        if (this.g == null) {
            this.g = f(false);
        }
        return this.g;
    }

    public final String c() {
        long jLongValue = this.b.longValue();
        Locale locale = Locale.US;
        return ((jLongValue >> 24) % 256) + "." + ((jLongValue >> 16) % 256) + "." + ((jLongValue >> 8) % 256) + "." + (jLongValue % 256);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ok0$a ok0_a = (ok0$a) obj;
        int iCompareTo = b().compareTo(ok0_a.b());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = ok0_a.c;
        int i2 = this.c;
        if (i2 > i) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public final BigInteger d() {
        if (this.i == null) {
            this.i = f(true);
        }
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ok0$a)) {
            return super.equals(obj);
        }
        ok0$a ok0_a = (ok0$a) obj;
        return this.c == ok0_a.c && ok0_a.b().equals(b());
    }

    public final BigInteger f(boolean z) {
        boolean z2 = this.f;
        int i = this.c;
        int i2 = z2 ? 32 - i : 128 - i;
        BigInteger bit = this.b;
        for (int i3 = 0; i3 < i2; i3++) {
            bit = z ? bit.setBit(i3) : bit.clearBit(i3);
        }
        return bit;
    }

    public final ok0$a[] g() {
        BigInteger bigIntegerB = b();
        int i = this.c + 1;
        boolean z = this.d;
        boolean z2 = this.f;
        ok0$a ok0_a = new ok0$a(bigIntegerB, i, z, z2);
        return new ok0$a[]{ok0_a, new ok0$a(ok0_a.d().add(BigInteger.ONE), i, z, z2)};
    }

    public final String toString() {
        boolean z = this.f;
        int i = this.c;
        if (z) {
            Locale locale = Locale.US;
            return c() + InternalZipConstants.ZIP_FILE_SEPARATOR + i;
        }
        Locale locale2 = Locale.US;
        BigInteger bigIntegerShiftRight = this.b;
        String str = null;
        boolean z2 = true;
        while (bigIntegerShiftRight.compareTo(BigInteger.ZERO) == 1) {
            long jLongValue = bigIntegerShiftRight.mod(BigInteger.valueOf(65536L)).longValue();
            if (str != null || jLongValue != 0) {
                if (str == null && !z2) {
                    str = ":";
                }
                str = z2 ? String.format(Locale.US, "%x", Long.valueOf(jLongValue), str) : String.format(Locale.US, "%x:%s", Long.valueOf(jLongValue), str);
            }
            bigIntegerShiftRight = bigIntegerShiftRight.shiftRight(16);
            z2 = false;
        }
        if (str == null) {
            str = "::";
        }
        return str + InternalZipConstants.ZIP_FILE_SEPARATOR + i;
    }
}
