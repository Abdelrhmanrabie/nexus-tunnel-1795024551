package com.jcraft.jzlib;

import defpackage.ak;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ZInputStream extends FilterInputStream {
    private byte[] buf;
    private byte[] buf1;
    protected boolean compress;
    protected Deflater deflater;
    protected int flush;
    protected InflaterInputStream iis;
    protected InputStream in;

    public ZInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public ZInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.flush = 0;
        this.buf1 = new byte[1];
        this.buf = new byte[512];
        this.in = inputStream;
        Deflater deflater = new Deflater();
        this.deflater = deflater;
        deflater.init(i);
        this.compress = true;
    }

    public ZInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.flush = 0;
        this.in = null;
        this.buf1 = new byte[1];
        this.buf = new byte[512];
        this.iis = new InflaterInputStream(inputStream, z);
        this.compress = false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.compress) {
            this.deflater.end();
        } else {
            this.iis.close();
        }
    }

    public int getFlushMode() {
        return this.flush;
    }

    public long getTotalIn() {
        return this.compress ? this.deflater.total_in : this.iis.getTotalIn();
    }

    public long getTotalOut() {
        return this.compress ? this.deflater.total_out : this.iis.getTotalOut();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (read(this.buf1, 0, 1) == -1) {
            return -1;
        }
        return this.buf1[0] & GZIPHeader.OS_UNKNOWN;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iDeflate;
        if (!this.compress) {
            return this.iis.read(bArr, i, i2);
        }
        this.deflater.setOutput(bArr, i, i2);
        do {
            InputStream inputStream = this.in;
            byte[] bArr2 = this.buf;
            int i3 = inputStream.read(bArr2, 0, bArr2.length);
            if (i3 != -1) {
                this.deflater.setInput(this.buf, 0, i3, true);
                iDeflate = this.deflater.deflate(this.flush);
                int i4 = this.deflater.next_out_index;
                if (i4 <= 0) {
                    if (iDeflate != 1) {
                        if (iDeflate == -2) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    return i4;
                }
            } else {
                return -1;
            }
        } while (iDeflate != -3);
        throw new ZStreamException(ak.AnonymousClass0.m("deflating: ", this.deflater.msg));
    }

    public void setFlushMode(int i) {
        this.flush = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        return read(new byte[j < ((long) 512) ? (int) j : 512]);
    }
}
