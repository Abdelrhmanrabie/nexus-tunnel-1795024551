package defpackage;

import com.jcraft.jzlib.GZIPHeader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xd {
    public int c;
    public final InputStream e;
    public int f;
    public int i;
    public int h = Integer.MAX_VALUE;
    public final byte[] a = new byte[4096];
    public int b = 0;
    public int d = 0;
    public int g = 0;

    public xd(InputStream inputStream) {
        this.e = inputStream;
    }

    public final void a(int i) {
        if (this.f != i) {
            throw new t30("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int b() {
        int i = this.h;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.g + this.d);
    }

    public final void c(int i) {
        this.h = i;
        o();
    }

    public final int d(int i) {
        if (i < 0) {
            throw new t30("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.g + this.d + i;
        int i3 = this.h;
        if (i2 > i3) {
            throw t30.b();
        }
        this.h = i2;
        o();
        return i3;
    }

    public final we0 e() {
        int iK = k();
        int i = this.b;
        int i2 = this.d;
        if (iK > i - i2 || iK <= 0) {
            return iK == 0 ? fa.b : new we0(h(iK));
        }
        byte[] bArr = new byte[iK];
        System.arraycopy(this.a, i2, bArr, 0, iK);
        we0 we0Var = new we0(bArr);
        this.d += iK;
        return we0Var;
    }

    public final int f() {
        return k();
    }

    public final b0 g(ar0.a aVar, ps psVar) throws t30 {
        int iK = k();
        if (this.i >= 64) {
            throw new t30("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iD = d(iK);
        this.i++;
        b0 b0Var = (b0) aVar.a(this, psVar);
        a(0);
        this.i--;
        c(iD);
        return b0Var;
    }

    public final byte[] h(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return h30.a;
            }
            throw new t30("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.g;
        int i3 = this.d;
        int i4 = i2 + i3 + i;
        int i5 = this.h;
        if (i4 > i5) {
            r((i5 - i2) - i3);
            throw t30.b();
        }
        byte[] bArr = this.a;
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i6 = this.b - i3;
            System.arraycopy(bArr, i3, bArr2, 0, i6);
            this.d = this.b;
            int i7 = i - i6;
            if (i7 > 0 && !s(i7)) {
                throw t30.b();
            }
            System.arraycopy(bArr, 0, bArr2, i6, i7);
            this.d = i7;
            return bArr2;
        }
        int i8 = this.b;
        this.g = i2 + i8;
        this.d = 0;
        this.b = 0;
        int length = i8 - i3;
        int i9 = i - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i9 > 0) {
            int iMin = Math.min(i9, 4096);
            byte[] bArr3 = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = this.e.read(bArr3, i10, iMin - i10);
                if (i11 == -1) {
                    throw t30.b();
                }
                this.g += i11;
                i10 += i11;
            }
            i9 -= iMin;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, i3, bArr4, 0, length);
        for (byte[] bArr5 : arrayList) {
            System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
            length += bArr5.length;
        }
        return bArr4;
    }

    public final int i() throws t30 {
        int i = this.d;
        if (this.b - i < 4) {
            if (!s(4)) {
                throw t30.b();
            }
            i = this.d;
        }
        this.d = i + 4;
        byte[] bArr = this.a;
        return ((bArr[i + 3] & GZIPHeader.OS_UNKNOWN) << 24) | (bArr[i] & GZIPHeader.OS_UNKNOWN) | ((bArr[i + 1] & GZIPHeader.OS_UNKNOWN) << 8) | ((bArr[i + 2] & GZIPHeader.OS_UNKNOWN) << 16);
    }

    public final long j() throws t30 {
        int i = this.d;
        if (this.b - i < 8) {
            if (!s(8)) {
                throw t30.b();
            }
            i = this.d;
        }
        this.d = i + 8;
        byte[] bArr = this.a;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0087 A[PHI: r2
      0x0087: PHI (r2v8 int) = (r2v7 int), (r2v10 int) binds: [B:25:0x0063, B:29:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    public final int k() {
        int i;
        long j;
        int i2 = this.d;
        int i3 = this.b;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.a;
            byte b = bArr[i2];
            if (b >= 0) {
                this.d = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                long j2 = i6;
                if (j2 >= 0) {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    long j3 = i8;
                    if (j3 < 0) {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        j2 = i10;
                        if (j2 < 0) {
                            i5 = i9;
                            j = -2080896;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (int) (((long) (i10 ^ (b2 << 28))) ^ 266354560);
                            if (b2 < 0) {
                                int i12 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i12] < 0) {
                                                int i13 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i13;
                                                    i = i11;
                                                }
                                            }
                                        } else {
                                            i = i11;
                                            i5 = i12;
                                        }
                                    }
                                } else {
                                    i = i11;
                                    i5 = i12;
                                }
                            }
                            i = i11;
                        }
                        this.d = i5;
                        return i;
                    }
                    i = (int) (16256 ^ j3);
                    i5 = i7;
                    this.d = i5;
                    return i;
                }
                j = -128;
                i = (int) (j ^ j2);
                this.d = i5;
                return i;
            }
        }
        return (int) m();
    }

    public final long l() {
        long j;
        long j2;
        long j3;
        int i = this.d;
        int i2 = this.b;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.a;
            byte b = bArr[i];
            if (b >= 0) {
                this.d = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                long j4 = (bArr[i3] << 7) ^ b;
                if (j4 < 0) {
                    j = (-128) ^ j4;
                } else {
                    int i5 = i + 3;
                    long j5 = j4 ^ ((long) (bArr[i4] << 14));
                    if (j5 >= 0) {
                        j3 = 16256;
                    } else {
                        i4 = i + 4;
                        long j6 = j5 ^ ((long) (bArr[i5] << 21));
                        if (j6 < 0) {
                            j2 = -2080896;
                        } else {
                            i5 = i + 5;
                            j5 = j6 ^ (((long) bArr[i4]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i4 = i + 6;
                                j6 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j5 = j6 ^ (((long) bArr[i4]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j6 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i6 = i + 9;
                                            long j7 = (j6 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                int i7 = i + 10;
                                                if (bArr[i6] >= 0) {
                                                    i4 = i7;
                                                }
                                            } else {
                                                i4 = i6;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                            }
                        }
                        j = j2 ^ j6;
                    }
                    i4 = i5;
                    j = j3 ^ j5;
                }
                this.d = i4;
                return j;
            }
        }
        return m();
    }

    public final long m() throws t30 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.d == this.b && !s(1)) {
                throw t30.b();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            byte b = this.a[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new t30("CodedInputStream encountered a malformed varint.");
    }

    public final int n() throws t30 {
        if (this.d == this.b && !s(1)) {
            this.f = 0;
            return 0;
        }
        int iK = k();
        this.f = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new t30("Protocol message contained an invalid tag (zero).");
    }

    public final void o() {
        int i = this.b + this.c;
        this.b = i;
        int i2 = this.g + i;
        int i3 = this.h;
        if (i2 <= i3) {
            this.c = 0;
            return;
        }
        int i4 = i2 - i3;
        this.c = i4;
        this.b = i - i4;
    }

    public final boolean q(int i, yd ydVar) throws IOException {
        int iN;
        int i2 = i & 7;
        if (i2 == 0) {
            long jL = l();
            ydVar.v(i);
            ydVar.w(jL);
            return true;
        }
        if (i2 == 1) {
            long j = j();
            ydVar.v(i);
            ydVar.u(j);
            return true;
        }
        if (i2 == 2) {
            we0 we0VarE = e();
            ydVar.v(i);
            ydVar.v(we0VarE.c.length);
            ydVar.r(we0VarE);
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw new t30("Protocol message tag had invalid wire type.");
            }
            int i3 = i();
            ydVar.v(i);
            ydVar.t(i3);
            return true;
        }
        ydVar.v(i);
        do {
            iN = n();
            if (iN == 0) {
                break;
            }
        } while (q(iN, ydVar));
        int i4 = ((i >>> 3) << 3) | 4;
        a(i4);
        ydVar.v(i4);
        return true;
    }

    public final void r(int i) throws t30 {
        int i2 = this.b;
        int i3 = this.d;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.d = i3 + i;
            return;
        }
        if (i < 0) {
            throw new t30("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.g;
        int i6 = i5 + i3 + i;
        int i7 = this.h;
        if (i6 > i7) {
            r((i7 - i5) - i3);
            throw t30.b();
        }
        this.d = i2;
        while (s(1)) {
            int i8 = i - i4;
            int i9 = this.b;
            if (i8 <= i9) {
                this.d = i8;
                return;
            } else {
                i4 += i9;
                this.d = i9;
            }
        }
        throw t30.b();
    }

    public final boolean s(int i) throws IOException {
        int i2 = this.d;
        int i3 = i2 + i;
        int i4 = this.b;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.g + i2 + i <= this.h) {
            byte[] bArr = this.a;
            if (i2 > 0) {
                if (i4 > i2) {
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.g += i2;
                this.b -= i2;
                this.d = 0;
            }
            int i5 = this.b;
            int i6 = this.e.read(bArr, i5, bArr.length - i5);
            if (i6 == 0 || i6 < -1 || i6 > bArr.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i6);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i6 > 0) {
                this.b += i6;
                if ((this.g + i) - 67108864 > 0) {
                    throw new t30("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                o();
                if (this.b >= i) {
                    return true;
                }
                return s(i);
            }
        }
        return false;
    }
}
