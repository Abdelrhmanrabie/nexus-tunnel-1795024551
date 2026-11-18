package com.jcraft.jzlib;

import defpackage.ak;
import java.io.UnsupportedEncodingException;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class GZIPHeader implements Cloneable {
    public static final byte OS_AMIGA = 1;
    public static final byte OS_ATARI = 5;
    public static final byte OS_CPM = 9;
    public static final byte OS_MACOS = 7;
    public static final byte OS_MSDOS = 0;
    public static final byte OS_OS2 = 6;
    public static final byte OS_QDOS = 12;
    public static final byte OS_RISCOS = 13;
    public static final byte OS_TOPS20 = 10;
    public static final byte OS_UNIX = 3;
    public static final byte OS_UNKNOWN = -1;
    public static final byte OS_VMCMS = 4;
    public static final byte OS_VMS = 2;
    public static final byte OS_WIN32 = 11;
    public static final byte OS_ZSYSTEM = 8;
    byte[] comment;
    long crc;
    byte[] extra;
    int hcrc;
    byte[] name;
    long time;
    int xflags;
    boolean text = false;
    private boolean fhcrc = false;
    int os = 255;
    boolean done = false;
    long mtime = 0;

    public Object clone() {
        GZIPHeader gZIPHeader = (GZIPHeader) super.clone();
        byte[] bArr = gZIPHeader.extra;
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            gZIPHeader.extra = bArr2;
        }
        byte[] bArr3 = gZIPHeader.name;
        if (bArr3 != null) {
            int length2 = bArr3.length;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr3, 0, bArr4, 0, length2);
            gZIPHeader.name = bArr4;
        }
        byte[] bArr5 = gZIPHeader.comment;
        if (bArr5 != null) {
            int length3 = bArr5.length;
            byte[] bArr6 = new byte[length3];
            System.arraycopy(bArr5, 0, bArr6, 0, length3);
            gZIPHeader.comment = bArr6;
        }
        return gZIPHeader;
    }

    public long getCRC() {
        return this.crc;
    }

    public String getComment() {
        byte[] bArr = this.comment;
        if (bArr == null) {
            return AppConfig.CUSTOM;
        }
        try {
            return new String(bArr, InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new InternalError(e.toString());
        }
    }

    public long getModifiedTime() {
        return this.mtime;
    }

    public String getName() {
        byte[] bArr = this.name;
        if (bArr == null) {
            return AppConfig.CUSTOM;
        }
        try {
            return new String(bArr, InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new InternalError(e.toString());
        }
    }

    public int getOS() {
        return this.os;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    public void put(Deflate deflate) {
        int i;
        boolean z = this.text;
        ?? r0 = z;
        if (this.fhcrc) {
            r0 = (z ? 1 : 0) | 2;
        }
        ?? r1 = r0;
        if (this.extra != null) {
            r1 = (r0 == true ? 1 : 0) | 4;
        }
        ?? r2 = r1;
        if (this.name != null) {
            r2 = (r1 == true ? 1 : 0) | 8;
        }
        int i2 = r2;
        if (this.comment != null) {
            i2 = (r2 == true ? 1 : 0) | 16;
        }
        int i3 = deflate.level;
        if (i3 == 1) {
            i = 4;
        } else {
            i = i3 == 9 ? 2 : 0;
        }
        deflate.put_short(-29921);
        deflate.put_byte((byte) 8);
        deflate.put_byte((byte) i2);
        deflate.put_byte((byte) this.mtime);
        deflate.put_byte((byte) (this.mtime >> 8));
        deflate.put_byte((byte) (this.mtime >> 16));
        deflate.put_byte((byte) (this.mtime >> 24));
        deflate.put_byte((byte) i);
        deflate.put_byte((byte) this.os);
        byte[] bArr = this.extra;
        if (bArr != null) {
            deflate.put_byte((byte) bArr.length);
            deflate.put_byte((byte) (this.extra.length >> 8));
            byte[] bArr2 = this.extra;
            deflate.put_byte(bArr2, 0, bArr2.length);
        }
        byte[] bArr3 = this.name;
        if (bArr3 != null) {
            deflate.put_byte(bArr3, 0, bArr3.length);
            deflate.put_byte((byte) 0);
        }
        byte[] bArr4 = this.comment;
        if (bArr4 != null) {
            deflate.put_byte(bArr4, 0, bArr4.length);
            deflate.put_byte((byte) 0);
        }
    }

    public void setCRC(long j) {
        this.crc = j;
    }

    public void setComment(String str) {
        try {
            this.comment = str.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException("comment must be in ISO-8859-1 " + this.name);
        }
    }

    public void setModifiedTime(long j) {
        this.mtime = j;
    }

    public void setName(String str) {
        try {
            this.name = str.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException(ak.m("name must be in ISO-8859-1 ", str));
        }
    }

    public void setOS(int i) {
        if ((i < 0 || i > 13) && i != 255) {
            throw new IllegalArgumentException(ak.h(i, "os: "));
        }
        this.os = i;
    }
}
