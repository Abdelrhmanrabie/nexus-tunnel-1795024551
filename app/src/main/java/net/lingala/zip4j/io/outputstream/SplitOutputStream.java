package net.lingala.zip4j.io.outputstream;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SplitOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {
    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private RandomAccessFile raf;
    private RawIO rawIO;
    private long splitLength;
    private File zipFile;

    public SplitOutputStream(File file) {
        this(file, -1L);
    }

    public SplitOutputStream(File file, long j) throws ZipException {
        this.rawIO = new RawIO();
        if (j >= 0 && j < 65536) {
            d.AnonymousClass0.m$5("split length less than minimum allowed split length of 65536 Bytes");
            throw null;
        }
        this.raf = new RandomAccessFile(file, RandomAccessFileMode.WRITE.getValue());
        this.splitLength = j;
        this.zipFile = file;
        this.currSplitFileCounter = 0;
        this.bytesWrittenForThisPart = 0L;
    }

    private boolean isBufferSizeFitForCurrSplitFile(int i) {
        long j = this.splitLength;
        return j < 65536 || this.bytesWrittenForThisPart + ((long) i) <= j;
    }

    private boolean isHeaderData(byte[] bArr) {
        int intLittleEndian = this.rawIO.readIntLittleEndian(bArr);
        for (HeaderSignature headerSignature : HeaderSignature.values()) {
            if (headerSignature != HeaderSignature.SPLIT_ZIP && headerSignature.getValue() == intLittleEndian) {
                return true;
            }
        }
        return false;
    }

    private void startNextSplitFile() throws IOException {
        String str;
        String zipFileNameWithoutExtension = FileUtils.getZipFileNameWithoutExtension(this.zipFile.getName());
        String absolutePath = this.zipFile.getAbsolutePath();
        if (this.zipFile.getParent() == null) {
            str = AppConfig.CUSTOM;
        } else {
            str = this.zipFile.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.currSplitFileCounter + 1);
        if (this.currSplitFileCounter >= 9) {
            str2 = ".z" + (this.currSplitFileCounter + 1);
        }
        File file = new File(e.j(str, zipFileNameWithoutExtension, str2));
        this.raf.close();
        if (file.exists()) {
            throw new IOException(ak.AnonymousClass0.m("split file: ", file.getName(), " already exists in the current directory, cannot rename this file"));
        }
        if (!this.zipFile.renameTo(file)) {
            d.AnonymousClass0.m$6("cannot rename newly created split file");
            return;
        }
        this.zipFile = new File(absolutePath);
        this.raf = new RandomAccessFile(this.zipFile, RandomAccessFileMode.WRITE.getValue());
        this.currSplitFileCounter++;
    }

    public boolean checkBufferSizeAndStartNextSplitFile(int i) throws ZipException {
        if (i < 0) {
            d.AnonymousClass0.m$5("negative buffersize for checkBufferSizeAndStartNextSplitFile");
            return false;
        }
        if (isBufferSizeFitForCurrSplitFile(i)) {
            return false;
        }
        try {
            startNextSplitFile();
            this.bytesWrittenForThisPart = 0L;
            return true;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public int getCurrentSplitFileCounter() {
        return this.currSplitFileCounter;
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public long getFilePointer() {
        return this.raf.getFilePointer();
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public boolean isSplitZipFile() {
        return this.splitLength != -1;
    }

    public void seek(long j) throws IOException {
        this.raf.seek(j);
    }

    public int skipBytes(int i) {
        return this.raf.skipBytes(i);
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
        long j;
        if (i2 <= 0) {
            return;
        }
        long j2 = this.splitLength;
        if (j2 == -1) {
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart += (long) i2;
            return;
        }
        long j3 = this.bytesWrittenForThisPart;
        if (j3 >= j2) {
            startNextSplitFile();
            this.raf.write(bArr, i, i2);
            j = i2;
        } else {
            long j4 = i2;
            if (j3 + j4 > j2) {
                if (isHeaderData(bArr)) {
                    startNextSplitFile();
                    this.raf.write(bArr, i, i2);
                } else {
                    this.raf.write(bArr, i, (int) (this.splitLength - this.bytesWrittenForThisPart));
                    startNextSplitFile();
                    RandomAccessFile randomAccessFile = this.raf;
                    long j5 = this.splitLength - this.bytesWrittenForThisPart;
                    randomAccessFile.write(bArr, i + ((int) j5), (int) (j4 - j5));
                    j4 -= this.splitLength - this.bytesWrittenForThisPart;
                }
                this.bytesWrittenForThisPart = j4;
                return;
            }
            this.raf.write(bArr, i, i2);
            j = this.bytesWrittenForThisPart + j4;
        }
        this.bytesWrittenForThisPart = j;
    }
}
