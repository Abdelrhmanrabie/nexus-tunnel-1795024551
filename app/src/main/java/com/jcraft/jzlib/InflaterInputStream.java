package com.jcraft.jzlib;

import defpackage.d;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class InflaterInputStream extends FilterInputStream {
    protected static final int DEFAULT_BUFSIZE = 512;
    private byte[] b;
    protected byte[] buf;
    private byte[] byte1;
    private boolean close_in;
    private boolean closed;
    private boolean eof;
    protected final Inflater inflater;
    protected boolean myinflater;

    public InflaterInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater) {
        this(inputStream, inflater, 512);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater, int i) {
        this(inputStream, inflater, i, true);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater, int i, boolean z) {
        super(inputStream);
        this.closed = false;
        this.eof = false;
        this.close_in = true;
        this.myinflater = false;
        this.byte1 = new byte[1];
        this.b = new byte[512];
        if (inputStream == null || inflater == null) {
            throw null;
        }
        if (i <= 0) {
            d.AnonymousClass0.m$2("buffer size must be greater than 0");
            throw null;
        }
        this.inflater = inflater;
        this.buf = new byte[i];
        this.close_in = z;
    }

    public InflaterInputStream(InputStream inputStream, boolean z) {
        this(inputStream, new Inflater(z));
        this.myinflater = true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (!this.closed) {
            return this.eof ? 0 : 1;
        }
        d.AnonymousClass0.m$6("Stream closed");
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        if (this.myinflater) {
            this.inflater.end();
        }
        if (this.close_in) {
            ((FilterInputStream) this).in.close();
        }
        this.closed = true;
    }

    public void fill() throws IOException {
        if (this.closed) {
            d.AnonymousClass0.m$6("Stream closed");
            return;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.buf;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            Inflater inflater = this.inflater;
            if (inflater.istate.wrap != 0 || inflater.finished()) {
                if (this.inflater.istate.was == -1) {
                    throw new EOFException("Unexpected end of ZLIB input stream");
                }
                d.AnonymousClass0.m$6("footer is not found");
                return;
            }
            this.buf[0] = 0;
            i = 1;
        }
        this.inflater.setInput(this.buf, 0, i, true);
    }

    public byte[] getAvailIn() {
        Inflater inflater = this.inflater;
        int i = inflater.avail_in;
        if (i <= 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(inflater.next_in, inflater.next_in_index, bArr, 0, i);
        return bArr;
    }

    public Inflater getInflater() {
        return this.inflater;
    }

    public long getTotalIn() {
        return this.inflater.getTotalIn();
    }

    public long getTotalOut() {
        return this.inflater.getTotalOut();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            d.AnonymousClass0.m$6("Stream closed");
            return 0;
        }
        if (read(this.byte1, 0, 1) == -1) {
            return -1;
        }
        return this.byte1[0] & GZIPHeader.OS_UNKNOWN;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            d.AnonymousClass0.m$6("Stream closed");
            return 0;
        }
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.eof) {
            return -1;
        }
        this.inflater.setOutput(bArr, i, i2);
        int i3 = 0;
        while (!this.eof) {
            if (this.inflater.avail_in == 0) {
                fill();
            }
            int iInflate = this.inflater.inflate(0);
            Inflater inflater = this.inflater;
            int i4 = inflater.next_out_index;
            i3 += i4 - i;
            if (iInflate == -3) {
                throw new IOException(this.inflater.msg);
            }
            if (iInflate == 1 || iInflate == 2) {
                this.eof = true;
                if (iInflate == 2) {
                    return -1;
                }
            }
            if (inflater.avail_out == 0) {
                return i3;
            }
            i = i4;
        }
        return i3;
    }

    public void readHeader() throws IOException {
        byte[] bytes = AppConfig.CUSTOM.getBytes();
        this.inflater.setInput(bytes, 0, 0, false);
        this.inflater.setOutput(bytes, 0, 0);
        this.inflater.inflate(0);
        if (this.inflater.istate.inParsingHeader()) {
            byte[] bArr = new byte[1];
            while (((FilterInputStream) this).in.read(bArr) > 0) {
                this.inflater.setInput(bArr);
                if (this.inflater.inflate(0) != 0) {
                    throw new IOException(this.inflater.msg);
                }
                if (!this.inflater.istate.inParsingHeader()) {
                    return;
                }
            }
            d.AnonymousClass0.m$6("no input");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            d.AnonymousClass0.m$2("negative skip length");
            return 0L;
        }
        if (this.closed) {
            d.AnonymousClass0.m$6("Stream closed");
            return 0L;
        }
        int iMin = (int) Math.min(j, 2147483647L);
        int i = 0;
        while (i < iMin) {
            int length = iMin - i;
            byte[] bArr = this.b;
            if (length > bArr.length) {
                length = bArr.length;
            }
            int i2 = read(bArr, 0, length);
            if (i2 == -1) {
                this.eof = true;
                break;
            }
            i += i2;
        }
        return i;
    }
}
