package com.jcraft.jzlib;

import defpackage.d;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DeflaterOutputStream extends FilterOutputStream {
    protected static final int DEFAULT_BUFSIZE = 512;
    private final byte[] buf1;
    protected byte[] buffer;
    private boolean close_out;
    private boolean closed;
    protected final Deflater deflater;
    protected boolean mydeflater;
    private boolean syncFlush;

    public DeflaterOutputStream(OutputStream outputStream) {
        this(outputStream, new Deflater(-1), 512, true);
        this.mydeflater = true;
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater) {
        this(outputStream, deflater, 512, true);
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, int i) {
        this(outputStream, deflater, i, true);
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, int i, boolean z) {
        super(outputStream);
        this.closed = false;
        this.syncFlush = false;
        this.buf1 = new byte[1];
        this.mydeflater = false;
        this.close_out = true;
        if (outputStream == null || deflater == null) {
            throw null;
        }
        if (i <= 0) {
            d.AnonymousClass0.m$2("buffer size must be greater than 0");
            throw null;
        }
        this.deflater = deflater;
        this.buffer = new byte[i];
        this.close_out = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        finish();
        if (this.mydeflater) {
            this.deflater.end();
        }
        if (this.close_out) {
            ((FilterOutputStream) this).out.close();
        }
        this.closed = true;
    }

    public int deflate(int i) throws IOException {
        Deflater deflater = this.deflater;
        byte[] bArr = this.buffer;
        deflater.setOutput(bArr, 0, bArr.length);
        int iDeflate = this.deflater.deflate(i);
        if (iDeflate == -5 ? this.deflater.avail_in > 0 || i == 4 : !(iDeflate == 0 || iDeflate == 1)) {
            d.AnonymousClass0.m$6("failed to deflate");
            return 0;
        }
        int i2 = this.deflater.next_out_index;
        if (i2 > 0) {
            ((FilterOutputStream) this).out.write(this.buffer, 0, i2);
        }
        return iDeflate;
    }

    public void finish() throws IOException {
        while (!this.deflater.finished()) {
            deflate(4);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int iDeflate;
        if (this.syncFlush && !this.deflater.finished()) {
            do {
                iDeflate = deflate(2);
                if (this.deflater.next_out_index < this.buffer.length) {
                    break;
                }
            } while (iDeflate != 1);
        }
        ((FilterOutputStream) this).out.flush();
    }

    public Deflater getDeflater() {
        return this.deflater;
    }

    public boolean getSyncFlush() {
        return this.syncFlush;
    }

    public long getTotalIn() {
        return this.deflater.getTotalIn();
    }

    public long getTotalOut() {
        return this.deflater.getTotalOut();
    }

    public void setSyncFlush(boolean z) {
        this.syncFlush = z;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.buf1;
        bArr[0] = (byte) (i & 255);
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.deflater.finished()) {
            d.AnonymousClass0.m$6("finished");
            return;
        }
        if (((i < 0) | (i2 < 0)) || (i + i2 > bArr.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i3 = this.syncFlush ? 2 : 0;
        this.deflater.setInput(bArr, i, i2, true);
        while (this.deflater.avail_in > 0 && deflate(i3) != 1) {
        }
    }
}
