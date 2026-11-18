package com.trilead.ssh2.crypto;

import com.jcraft.jzlib.GZIPHeader;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SimpleDERReader {
    private static final int CONSTRUCTED = 32;
    byte[] buffer;
    int count;
    int pos;

    public SimpleDERReader(byte[] bArr) {
        resetInput(bArr);
    }

    public SimpleDERReader(byte[] bArr, int i, int i2) {
        resetInput(bArr, i, i2);
    }

    private byte readByte() throws IOException {
        int i = this.count;
        if (i <= 0) {
            d.AnonymousClass0.m$6("DER byte array: out of data");
            return (byte) 0;
        }
        this.count = i - 1;
        byte[] bArr = this.buffer;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return bArr[i2];
    }

    private byte[] readBytes(int i) throws IOException {
        if (i > this.count) {
            d.AnonymousClass0.m$6("DER byte array: out of data");
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, this.pos, bArr, 0, i);
        this.pos += i;
        this.count -= i;
        return bArr;
    }

    public int available() {
        return this.count;
    }

    public int ignoreNextObject() throws IOException {
        int i = readByte() & GZIPHeader.OS_UNKNOWN;
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        readBytes(length);
        return i;
    }

    public SimpleDERReader readConstructed() throws IOException {
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        SimpleDERReader simpleDERReader = new SimpleDERReader(this.buffer, this.pos, length);
        this.pos += length;
        this.count -= length;
        return simpleDERReader;
    }

    public int readConstructedType() throws IOException {
        byte b = readByte();
        int i = b & GZIPHeader.OS_UNKNOWN;
        if ((b & 32) == 32) {
            return b & 31;
        }
        throw new IOException(ak.h(i, "Expected constructed type, but was "));
    }

    public BigInteger readInt() {
        int i = readByte() & GZIPHeader.OS_UNKNOWN;
        if (i != 2) {
            throw new IOException(ak.h(i, "Expected DER Integer, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        return new BigInteger(1, readBytes(length));
    }

    public int readLength() throws IOException {
        byte b = readByte();
        int i = b & GZIPHeader.OS_UNKNOWN;
        if ((b & 128) == 0) {
            return i;
        }
        int i2 = b & 127;
        if (i2 == 0 || i2 > 4) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            i3 = (i3 << 8) | (readByte() & GZIPHeader.OS_UNKNOWN);
            i2--;
        }
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    public byte[] readOctetString() throws IOException {
        int i = readByte() & GZIPHeader.OS_UNKNOWN;
        if (i != 4 && i != 3) {
            throw new IOException(ak.h(i, "Expected DER Octetstring, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        return readBytes(length);
    }

    public String readOid() throws IOException {
        int i = readByte() & GZIPHeader.OS_UNKNOWN;
        if (i != 6) {
            throw new IOException(ak.h(i, "Expected DER OID, but found type "));
        }
        int length = readLength();
        if (length < 1 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        byte[] bytes = readBytes(length);
        StringBuilder sb = new StringBuilder(64);
        int i2 = bytes[0] / 40;
        if (i2 == 0) {
            sb.append('0');
        } else if (i2 != 1) {
            sb.append('2');
            bytes[0] = (byte) (bytes[0] - 80);
        } else {
            sb.append('1');
            bytes[0] = (byte) (bytes[0] - 40);
        }
        long j = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b = bytes[i3];
            j = (j << 7) + ((long) (b & 127));
            if ((b & 128) == 0) {
                sb.append('.');
                sb.append(j);
                j = 0;
            }
        }
        return sb.toString();
    }

    public byte[] readSequenceAsByteArray() throws IOException {
        int i = readByte() & GZIPHeader.OS_UNKNOWN;
        if (i != 48) {
            throw new IOException(ak.h(i, "Expected DER Sequence, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(e.i(length, "Illegal len in DER object (", ")"));
        }
        return readBytes(length);
    }

    public void resetInput(byte[] bArr) {
        resetInput(bArr, 0, bArr.length);
    }

    public void resetInput(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.pos = i;
        this.count = i2;
    }
}
