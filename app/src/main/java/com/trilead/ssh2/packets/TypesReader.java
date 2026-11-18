package com.trilead.ssh2.packets;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.util.Tokenizer;
import defpackage.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TypesReader {
    byte[] arr;
    int max;
    int pos;

    public TypesReader(byte[] bArr) {
        this.max = 0;
        this.arr = bArr;
        this.pos = 0;
        this.max = bArr.length;
    }

    public TypesReader(byte[] bArr, int i) {
        this.max = 0;
        this.arr = bArr;
        this.pos = i;
        this.max = bArr.length;
        if (i < 0 || i > bArr.length) {
            d.AnonymousClass0.m$2("Illegal offset.");
            throw null;
        }
    }

    public TypesReader(byte[] bArr, int i, int i2) {
        this.arr = bArr;
        this.pos = i;
        int i3 = i2 + i;
        this.max = i3;
        if (i < 0 || i >= bArr.length) {
            d.AnonymousClass0.m$2("Illegal offset.");
            throw null;
        }
        if (i3 < 0 || i3 > bArr.length) {
            d.AnonymousClass0.m$2("Illegal length.");
            throw null;
        }
    }

    public boolean readBoolean() throws IOException {
        int i = this.pos;
        if (i >= this.max) {
            d.AnonymousClass0.m$6("Packet too short.");
            return false;
        }
        byte[] bArr = this.arr;
        this.pos = i + 1;
        return bArr[i] != 0;
    }

    public int readByte() throws IOException {
        int i = this.pos;
        if (i >= this.max) {
            d.AnonymousClass0.m$6("Packet too short.");
            return 0;
        }
        byte[] bArr = this.arr;
        this.pos = i + 1;
        return bArr[i] & GZIPHeader.OS_UNKNOWN;
    }

    public byte[] readByteString() throws IOException {
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i > this.max) {
            d.AnonymousClass0.m$6("Malformed SSH byte string.");
            return null;
        }
        byte[] bArr = new byte[uint32];
        System.arraycopy(this.arr, i, bArr, 0, uint32);
        this.pos += uint32;
        return bArr;
    }

    public void readBytes(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0) {
            d.AnonymousClass0.m$6("Negative offset or length specified");
            return;
        }
        if (i2 > bArr.length - i) {
            d.AnonymousClass0.m$6("Length too long for output buffer");
            return;
        }
        int i3 = this.pos;
        if (i3 + i2 > this.max) {
            d.AnonymousClass0.m$6("Packet too short.");
        } else {
            System.arraycopy(this.arr, i3, bArr, i, i2);
            this.pos += i2;
        }
    }

    public byte[] readBytes(int i) throws IOException {
        String str;
        if (i >= 0) {
            int i2 = this.pos;
            if (i2 + i <= this.max) {
                byte[] bArr = new byte[i];
                System.arraycopy(this.arr, i2, bArr, 0, i);
                this.pos += i;
                return bArr;
            }
            str = "Packet too short.";
        } else {
            str = "Negative length requested";
        }
        d.AnonymousClass0.m$6(str);
        return null;
    }

    public BigInteger readMPINT() throws IOException {
        byte[] byteString = readByteString();
        return byteString.length == 0 ? BigInteger.ZERO : new BigInteger(byteString);
    }

    public String[] readNameList() {
        return Tokenizer.parseTokens(readString(), ',');
    }

    public String readString() throws IOException {
        String str;
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i > this.max) {
            d.AnonymousClass0.m$6("Malformed SSH string.");
            return null;
        }
        try {
            str = new String(this.arr, i, uint32, InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            str = new String(this.arr, this.pos, uint32);
        }
        this.pos += uint32;
        return str;
    }

    public String readString(String str) throws IOException {
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i > this.max) {
            d.AnonymousClass0.m$6("Malformed SSH string.");
            return null;
        }
        String str2 = str == null ? new String(this.arr, i, uint32) : new String(this.arr, i, uint32, str);
        this.pos += uint32;
        return str2;
    }

    public int readUINT32() throws IOException {
        int i = this.pos;
        int i2 = i + 4;
        if (i2 > this.max) {
            d.AnonymousClass0.m$6("Packet too short.");
            return 0;
        }
        byte[] bArr = this.arr;
        int i3 = ((bArr[i + 1] & GZIPHeader.OS_UNKNOWN) << 16) | ((bArr[i] & GZIPHeader.OS_UNKNOWN) << 24);
        int i4 = i3 | ((bArr[i + 2] & GZIPHeader.OS_UNKNOWN) << 8);
        this.pos = i2;
        return (bArr[i + 3] & GZIPHeader.OS_UNKNOWN) | i4;
    }

    public long readUINT64() throws IOException {
        int i = this.pos;
        int i2 = i + 8;
        if (i2 > this.max) {
            d.AnonymousClass0.m$6("Packet too short.");
            return 0L;
        }
        byte[] bArr = this.arr;
        long j = ((bArr[i + 1] & GZIPHeader.OS_UNKNOWN) << 16) | ((bArr[i] & GZIPHeader.OS_UNKNOWN) << 24) | ((bArr[i + 2] & GZIPHeader.OS_UNKNOWN) << 8) | (bArr[i + 3] & GZIPHeader.OS_UNKNOWN);
        int i3 = ((bArr[i + 4] & GZIPHeader.OS_UNKNOWN) << 24) | ((bArr[i + 5] & GZIPHeader.OS_UNKNOWN) << 16) | ((bArr[i + 6] & GZIPHeader.OS_UNKNOWN) << 8);
        this.pos = i2;
        return (((long) ((bArr[i + 7] & GZIPHeader.OS_UNKNOWN) | i3)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (j << 32);
    }

    public int remain() {
        return this.max - this.pos;
    }
}
