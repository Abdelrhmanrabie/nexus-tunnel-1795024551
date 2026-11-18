package com.jcraft.jzlib;

import java.io.OutputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class GZIPOutputStream extends DeflaterOutputStream {
    public GZIPOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    public GZIPOutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, true);
    }

    public GZIPOutputStream(OutputStream outputStream, int i, boolean z) {
        this(outputStream, new Deflater(-1, 31), i, z);
        this.mydeflater = true;
    }

    public GZIPOutputStream(OutputStream outputStream, Deflater deflater, int i, boolean z) {
        super(outputStream, deflater, i, z);
    }

    private void check() throws GZIPException {
        if (this.deflater.dstate.status != 42) {
            throw new GZIPException("header is already written.");
        }
    }

    public long getCRC() throws GZIPException {
        Deflate deflate = this.deflater.dstate;
        if (deflate.status == 666) {
            return deflate.getGZIPHeader().getCRC();
        }
        throw new GZIPException("checksum is not calculated yet.");
    }

    public void setComment(String str) throws GZIPException {
        check();
        this.deflater.dstate.getGZIPHeader().setComment(str);
    }

    public void setModifiedTime(long j) throws GZIPException {
        check();
        this.deflater.dstate.getGZIPHeader().setModifiedTime(j);
    }

    public void setName(String str) throws GZIPException {
        check();
        this.deflater.dstate.getGZIPHeader().setName(str);
    }

    public void setOS(int i) throws GZIPException {
        check();
        this.deflater.dstate.getGZIPHeader().setOS(i);
    }
}
