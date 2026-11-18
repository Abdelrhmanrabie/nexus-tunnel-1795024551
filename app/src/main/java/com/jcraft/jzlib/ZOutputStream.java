package com.jcraft.jzlib;

import defpackage.ak;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ZOutputStream extends FilterOutputStream {
    protected byte[] buf;
    private byte[] buf1;
    protected int bufsize;
    protected boolean compress;
    private DeflaterOutputStream dos;
    private boolean end;
    protected int flush;
    private Inflater inflater;
    protected OutputStream out;

    public ZOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.bufsize = 512;
        this.flush = 0;
        this.buf = new byte[512];
        this.end = false;
        this.buf1 = new byte[1];
        this.out = outputStream;
        Inflater inflater = new Inflater();
        this.inflater = inflater;
        inflater.init();
        this.compress = false;
    }

    public ZOutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, false);
    }

    public ZOutputStream(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.bufsize = 512;
        this.flush = 0;
        this.buf = new byte[512];
        this.end = false;
        this.buf1 = new byte[1];
        this.out = outputStream;
        this.dos = new DeflaterOutputStream(outputStream, new Deflater(i, z));
        this.compress = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            finish();
        } catch (IOException unused) {
        } finally {
            end();
            this.out.close();
            this.out = null;
        }
    }

    public synchronized void end() {
        if (this.end) {
            return;
        }
        if (this.compress) {
            try {
                this.dos.finish();
            } catch (Exception unused) {
            }
        } else {
            this.inflater.end();
        }
        this.end = true;
    }

    public void finish() throws IOException {
        if (this.compress) {
            write(AppConfig.CUSTOM.getBytes(), 0, 0);
        } else {
            this.dos.finish();
        }
        flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    public int getFlushMode() {
        return this.flush;
    }

    public long getTotalIn() {
        return this.compress ? this.dos.getTotalIn() : this.inflater.total_in;
    }

    public long getTotalOut() {
        return this.compress ? this.dos.getTotalOut() : this.inflater.total_out;
    }

    public void setFlushMode(int i) {
        this.flush = i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.buf1;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (this.compress) {
            this.dos.write(bArr, i, i2);
            return;
        }
        this.inflater.setInput(bArr, i, i2, true);
        int iInflate = 0;
        do {
            Inflater inflater = this.inflater;
            if (inflater.avail_in <= 0) {
                break;
            }
            byte[] bArr2 = this.buf;
            inflater.setOutput(bArr2, 0, bArr2.length);
            iInflate = this.inflater.inflate(this.flush);
            int i3 = this.inflater.next_out_index;
            if (i3 > 0) {
                this.out.write(this.buf, 0, i3);
            }
        } while (iInflate == 0);
        if (iInflate != 0) {
            throw new ZStreamException(ak.AnonymousClass0.m("inflating: ", this.inflater.msg));
        }
    }
}
