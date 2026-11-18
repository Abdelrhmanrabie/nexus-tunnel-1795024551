package net.lingala.zip4j.io.outputstream;

import defpackage.d;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ZipEntryOutputStream extends OutputStream {
    private OutputStream outputStream;
    private long numberOfBytesWrittenForThisEntry = 0;
    private boolean entryClosed = false;

    public ZipEntryOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void closeEntry() {
        this.entryClosed = true;
    }

    public long getNumberOfBytesWrittenForThisEntry() {
        return this.numberOfBytesWrittenForThisEntry;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.entryClosed) {
            d.AnonymousClass0.m("ZipEntryOutputStream is closed");
        } else {
            this.outputStream.write(bArr, i, i2);
            this.numberOfBytesWrittenForThisEntry += (long) i2;
        }
    }
}
