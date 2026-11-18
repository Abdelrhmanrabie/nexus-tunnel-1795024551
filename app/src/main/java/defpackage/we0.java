package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class we0 extends fa {
    public final byte[] c;
    public int d = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Iterator {
        public int b = 0;
        public final int c;

        public a() {
            this.c = we0.this.c.length;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b < this.c;
        }

        @Override // java.util.Iterator
        public final Object next() {
            return Byte.valueOf(nextByte());
        }

        public final byte nextByte() {
            try {
                byte[] bArr = we0.this.c;
                int i = this.b;
                this.b = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public we0(byte[] bArr) {
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fa) {
            byte[] bArr = this.c;
            if (bArr.length == ((fa) obj).size()) {
                if (bArr.length == 0) {
                    return true;
                }
                if (obj instanceof we0) {
                    return r((we0) obj, 0, bArr.length);
                }
                if (obj instanceof lw0) {
                    return obj.equals(this);
                }
                String strValueOf = String.valueOf(obj.getClass());
                throw new IllegalArgumentException(fb$1.m(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
        }
        return false;
    }

    @Override // defpackage.fa
    public final void g(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.c, i, bArr, i2, i3);
    }

    @Override // defpackage.fa
    public final int h() {
        return 0;
    }

    public final int hashCode() {
        int iM = this.d;
        if (iM == 0) {
            int length = this.c.length;
            iM = m(length, 0, length);
            if (iM == 0) {
                iM = 1;
            }
            this.d = iM;
        }
        return iM;
    }

    @Override // defpackage.fa
    public final boolean i() {
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a();
    }

    @Override // defpackage.fa
    public final boolean j() {
        byte[] bArr = this.c;
        return e.E(bArr, 0, bArr.length) == 0;
    }

    @Override // defpackage.fa
    public final int m(int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + this.c[i4];
        }
        return i;
    }

    @Override // defpackage.fa
    public final int n(int i, int i2, int i3) {
        byte b;
        int i4;
        int i5;
        int i6;
        int i7 = i3 + i2;
        byte[] bArr = this.c;
        if (i != 0) {
            if (i2 >= i7) {
                return i;
            }
            byte b2 = (byte) i;
            if (b2 >= -32) {
                if (b2 < -16) {
                    byte b3 = (byte) (~(i >> 8));
                    if (b3 == 0) {
                        int i8 = i2 + 1;
                        byte b4 = bArr[i2];
                        if (i8 < i7) {
                            i2 = i8;
                            b3 = b4;
                        } else {
                            if (b2 > -12 || b4 > -65) {
                                return -1;
                            }
                            i5 = b4 << 8;
                        }
                    }
                    if (b3 > -65) {
                        return -1;
                    }
                    if (b2 == -32 && b3 < -96) {
                        return -1;
                    }
                    if (b2 == -19 && b3 >= -96) {
                        return -1;
                    }
                    i6 = i2 + 1;
                    if (bArr[i2] > -65) {
                        return -1;
                    }
                } else {
                    byte b5 = (byte) (~(i >> 8));
                    if (b5 == 0) {
                        i4 = i2 + 1;
                        b5 = bArr[i2];
                        if (i4 < i7) {
                            b = 0;
                        } else {
                            if (b2 > -12 || b5 > -65) {
                                return -1;
                            }
                            i5 = b5 << 8;
                        }
                    } else {
                        b = (byte) (i >> 16);
                        i4 = i2;
                    }
                    if (b == 0) {
                        int i9 = i4 + 1;
                        byte b6 = bArr[i4];
                        if (i9 >= i7) {
                            if (b2 > -12 || b5 > -65 || b6 > -65) {
                                return -1;
                            }
                            return (b6 << 16) ^ ((b5 << 8) ^ b2);
                        }
                        b = b6;
                        i4 = i9;
                    }
                    if (b5 > -65) {
                        return -1;
                    }
                    if ((((b5 + 112) + (b2 << 28)) >> 30) != 0 || b > -65) {
                        return -1;
                    }
                    i2 = i4 + 1;
                    if (bArr[i4] > -65) {
                        return -1;
                    }
                }
                return i5 ^ b2;
            }
            if (b2 < -62) {
                return -1;
            }
            i6 = i2 + 1;
            if (bArr[i2] > -65) {
                return -1;
            }
            i2 = i6;
        }
        return e.E(bArr, i2, i7);
    }

    @Override // defpackage.fa
    public final int o() {
        return this.d;
    }

    @Override // defpackage.fa
    public final String p() {
        byte[] bArr = this.c;
        return new String(bArr, 0, bArr.length, "UTF-8");
    }

    @Override // defpackage.fa
    public final void q(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.c, i, i2);
    }

    public final boolean r(we0 we0Var, int i, int i2) {
        byte[] bArr = we0Var.c;
        int length = bArr.length;
        byte[] bArr2 = this.c;
        if (i2 > length) {
            int length2 = bArr2.length;
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 <= bArr.length) {
            int i3 = 0;
            while (i3 < i2) {
                if (bArr2[i3] != bArr[i]) {
                    return false;
                }
                i3++;
                i++;
            }
            return true;
        }
        int length3 = bArr.length;
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("Ran off end of other: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(length3);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // defpackage.fa
    public final int size() {
        return this.c.length;
    }
}
