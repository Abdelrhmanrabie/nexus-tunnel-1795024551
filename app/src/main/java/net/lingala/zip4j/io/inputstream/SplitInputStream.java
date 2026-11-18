package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class SplitInputStream extends InputStream {
    private int currentSplitFileCounter;
    private boolean isSplitZipArchive;
    protected RandomAccessFile randomAccessFile;
    private byte[] singleByteArray = new byte[1];
    protected File zipFile;

    public SplitInputStream(File file, boolean z, int i) {
        this.currentSplitFileCounter = 0;
        this.randomAccessFile = new RandomAccessFile(file, RandomAccessFileMode.READ.getValue());
        this.zipFile = file;
        this.isSplitZipArchive = z;
        if (z) {
            this.currentSplitFileCounter = i;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public abstract File getNextSplitFile(int i);

    public void openRandomAccessFileForIndex(int i) throws IOException {
        File nextSplitFile = getNextSplitFile(i);
        if (nextSplitFile.exists()) {
            this.randomAccessFile.close();
            this.randomAccessFile = new RandomAccessFile(nextSplitFile, RandomAccessFileMode.READ.getValue());
        } else {
            throw new FileNotFoundException("zip split file does not exist: " + nextSplitFile);
        }
    }

    public void prepareExtractionForFileHeader(FileHeader fileHeader) throws IOException {
        if (this.isSplitZipArchive && this.currentSplitFileCounter != fileHeader.getDiskNumberStart()) {
            openRandomAccessFileForIndex(fileHeader.getDiskNumberStart());
            this.currentSplitFileCounter = fileHeader.getDiskNumberStart();
        }
        this.randomAccessFile.seek(fileHeader.getOffsetLocalHeader());
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.singleByteArray) == -1) {
            return -1;
        }
        return this.singleByteArray[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.randomAccessFile.read(bArr, i, i2);
        if ((i3 == i2 && i3 != -1) || !this.isSplitZipArchive) {
            return i3;
        }
        openRandomAccessFileForIndex(this.currentSplitFileCounter + 1);
        this.currentSplitFileCounter++;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.randomAccessFile.read(bArr, i3, i2 - i3);
        return i4 > 0 ? i3 + i4 : i3;
    }
}
