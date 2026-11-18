package com.trilead.ssh2.compression;

import com.jcraft.jzlib.ZStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Zlib implements ICompressor {
    private static final int DEFAULT_BUF_SIZE = 4096;
    private static final int LEVEL = 5;
    private byte[] deflate_tmpbuf;
    private byte[] inflate_tmpbuf;
    private byte[] inflated_buf;
    private ZStream deflate = new ZStream();
    private ZStream inflate = new ZStream();

    public Zlib() {
        this.deflate.deflateInit(5);
        this.inflate.inflateInit();
        this.deflate_tmpbuf = new byte[4096];
        this.inflate_tmpbuf = new byte[4096];
        this.inflated_buf = new byte[4096];
    }

    @Override // com.trilead.ssh2.compression.ICompressor
    public boolean canCompressPreauth() {
        return true;
    }

    @Override // com.trilead.ssh2.compression.ICompressor
    public int compress(byte[] bArr, int i, int i2, byte[] bArr2) {
        ZStream zStream = this.deflate;
        zStream.next_in = bArr;
        zStream.next_in_index = i;
        zStream.avail_in = i2 - i;
        if (bArr.length + 1024 > this.deflate_tmpbuf.length) {
            this.deflate_tmpbuf = new byte[bArr.length + 1024];
        }
        zStream.next_out = this.deflate_tmpbuf;
        zStream.next_out_index = 0;
        zStream.avail_out = bArr2.length;
        if (zStream.deflate(1) != 0) {
            System.err.println("compress: compression failure");
        }
        if (this.deflate.avail_in > 0) {
            System.err.println("compress: deflated data too large");
        }
        int length = bArr2.length - this.deflate.avail_out;
        System.arraycopy(this.deflate_tmpbuf, 0, bArr2, 0, length);
        return length;
    }

    @Override // com.trilead.ssh2.compression.ICompressor
    public int getBufferSize() {
        return 4096;
    }

    @Override // com.trilead.ssh2.compression.ICompressor
    public byte[] uncompress(byte[] bArr, int i, int[] iArr) {
        ZStream zStream = this.inflate;
        zStream.next_in = bArr;
        zStream.next_in_index = i;
        zStream.avail_in = iArr[0];
        int i2 = 0;
        while (true) {
            ZStream zStream2 = this.inflate;
            zStream2.next_out = this.inflate_tmpbuf;
            zStream2.next_out_index = 0;
            zStream2.avail_out = 4096;
            int iInflate = zStream2.inflate(1);
            if (iInflate == -5) {
                if (i2 > bArr.length - i) {
                    byte[] bArr2 = new byte[i2 + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    System.arraycopy(this.inflated_buf, 0, bArr2, i, i2);
                    bArr = bArr2;
                } else {
                    System.arraycopy(this.inflated_buf, 0, bArr, i, i2);
                }
                iArr[0] = i2;
                return bArr;
            }
            if (iInflate != 0) {
                System.err.println("uncompress: inflate returnd " + iInflate);
                return null;
            }
            byte[] bArr3 = this.inflated_buf;
            int length = bArr3.length;
            int i3 = (i2 + 4096) - this.inflate.avail_out;
            if (length < i3) {
                byte[] bArr4 = new byte[i3];
                System.arraycopy(bArr3, 0, bArr4, 0, i2);
                this.inflated_buf = bArr4;
            }
            System.arraycopy(this.inflate_tmpbuf, 0, this.inflated_buf, i2, 4096 - this.inflate.avail_out);
            i2 += 4096 - this.inflate.avail_out;
            iArr[0] = i2;
        }
    }
}
