package com.jcraft.jzlib;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Adler32 implements Checksum {
    private static final int BASE = 65521;
    private static final int NMAX = 5552;
    private long s1 = 1;
    private long s2 = 0;

    public static long combine(long j, long j2, long j3) {
        long j4 = j3 % 65521;
        long j5 = j & 65535;
        long j6 = (j2 & 65535) + 65520 + j5;
        long j7 = (((((j >> 16) & 65535) + (65535 & (j2 >> 16))) + 65521) - j4) + ((j4 * j5) % 65521);
        if (j6 >= 65521) {
            j6 -= 65521;
        }
        if (j6 >= 65521) {
            j6 -= 65521;
        }
        if (j7 >= 131042) {
            j7 -= 131042;
        }
        if (j7 >= 65521) {
            j7 -= 65521;
        }
        return (j7 << 16) | j6;
    }

    @Override // com.jcraft.jzlib.Checksum
    public Adler32 copy() {
        Adler32 adler32 = new Adler32();
        adler32.s1 = this.s1;
        adler32.s2 = this.s2;
        return adler32;
    }

    @Override // com.jcraft.jzlib.Checksum
    public long getValue() {
        return (this.s2 << 16) | this.s1;
    }

    @Override // com.jcraft.jzlib.Checksum
    public void reset() {
        this.s1 = 1L;
        this.s2 = 0L;
    }

    @Override // com.jcraft.jzlib.Checksum
    public void reset(long j) {
        this.s1 = j & 65535;
        this.s2 = (j >> 16) & 65535;
    }

    @Override // com.jcraft.jzlib.Checksum
    public void update(byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        if (i2 == 1) {
            long j4 = this.s1 + ((long) (bArr[i] & GZIPHeader.OS_UNKNOWN));
            j2 = this.s2 + j4;
            this.s2 = j2;
            this.s1 = j4 % 65521;
        } else {
            int i3 = i2 / NMAX;
            int i4 = i2 % NMAX;
            while (true) {
                int i5 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i6 = NMAX;
                while (true) {
                    int i7 = i6 - 1;
                    j3 = this.s1;
                    if (i6 > 0) {
                        long j5 = j3 + ((long) (bArr[i] & GZIPHeader.OS_UNKNOWN));
                        this.s1 = j5;
                        this.s2 += j5;
                        i++;
                        i6 = i7;
                    }
                }
                this.s1 = j3 % 65521;
                this.s2 %= 65521;
                i3 = i5;
            }
            while (true) {
                int i8 = i4 - 1;
                j = this.s1;
                if (i4 <= 0) {
                    break;
                }
                long j6 = j + ((long) (bArr[i] & GZIPHeader.OS_UNKNOWN));
                this.s1 = j6;
                this.s2 += j6;
                i++;
                i4 = i8;
            }
            this.s1 = j % 65521;
            j2 = this.s2;
        }
        this.s2 = j2 % 65521;
    }
}
