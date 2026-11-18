package com.jcraft.jzlib;

import defpackage.d;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class GZIPInputStream extends InflaterInputStream {
    public GZIPInputStream(InputStream inputStream) {
        this(inputStream, 512, true);
    }

    public GZIPInputStream(InputStream inputStream, int i, boolean z) {
        this(inputStream, new Inflater(31), i, z);
        this.myinflater = true;
    }

    public GZIPInputStream(InputStream inputStream, Inflater inflater, int i, boolean z) {
        super(inputStream, inflater, i, z);
    }

    private int fill(byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        do {
            try {
                i = ((FilterInputStream) this).in.read(bArr, i2, bArr.length - i2);
            } catch (IOException unused) {
                i = -1;
            }
            if (i == -1) {
                break;
            }
            i2 += i;
        } while (i2 < length);
        return i2;
    }

    public long getCRC() throws GZIPException {
        Inflate inflate = this.inflater.istate;
        if (inflate.mode == 12) {
            return inflate.getGZIPHeader().getCRC();
        }
        throw new GZIPException("checksum is not calculated yet.");
    }

    public String getComment() {
        return this.inflater.istate.getGZIPHeader().getComment();
    }

    public long getModifiedtime() {
        return this.inflater.istate.getGZIPHeader().getModifiedTime();
    }

    public String getName() {
        return this.inflater.istate.getGZIPHeader().getName();
    }

    public int getOS() {
        return this.inflater.istate.getGZIPHeader().getOS();
    }

    @Override // com.jcraft.jzlib.InflaterInputStream
    public void readHeader() throws IOException {
        Inflater inflater;
        byte[] bArr;
        int iFill;
        byte[] bytes = AppConfig.CUSTOM.getBytes();
        this.inflater.setOutput(bytes, 0, 0);
        this.inflater.setInput(bytes, 0, 0, false);
        byte[] bArr2 = new byte[10];
        int iFill2 = fill(bArr2);
        if (iFill2 != 10) {
            if (iFill2 > 0) {
                this.inflater.setInput(bArr2, 0, iFill2, false);
                Inflater inflater2 = this.inflater;
                inflater2.next_in_index = 0;
                inflater2.avail_in = iFill2;
            }
            d.AnonymousClass0.m$6("no input");
            return;
        }
        this.inflater.setInput(bArr2, 0, iFill2, false);
        byte[] bArr3 = new byte[1];
        do {
            if (this.inflater.avail_in <= 0) {
                if (((FilterInputStream) this).in.read(bArr3) <= 0) {
                    d.AnonymousClass0.m$6("no input");
                    return;
                }
                this.inflater.setInput(bArr3, 0, 1, true);
            }
            int iInflate = this.inflater.inflate(0);
            inflater = this.inflater;
            if (iInflate != 0) {
                int length = 2048 - inflater.next_in.length;
                if (length > 0 && (iFill = fill((bArr = new byte[length]))) > 0) {
                    Inflater inflater3 = this.inflater;
                    inflater3.avail_in += inflater3.next_in_index;
                    inflater3.next_in_index = 0;
                    inflater3.setInput(bArr, 0, iFill, true);
                }
                Inflater inflater4 = this.inflater;
                inflater4.avail_in += inflater4.next_in_index;
                inflater4.next_in_index = 0;
                throw new IOException(this.inflater.msg);
            }
        } while (inflater.istate.inParsingHeader());
    }
}
