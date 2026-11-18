package net.lingala.zip4j.io.inputstream;

import com.jcraft.jzlib.GZIPHeader;
import defpackage.d;
import defpackage.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NumberedSplitRandomAccessFile extends RandomAccessFile {
    private File[] allSortedSplitFiles;
    private int currentOpenSplitFileCounter;
    private RandomAccessFile randomAccessFile;
    private String rwMode;
    private byte[] singleByteBuffer;
    private long splitLength;

    public NumberedSplitRandomAccessFile(File file, String str) {
        this(file, str, FileUtils.getAllSortedNumberedSplitFiles(file));
    }

    public NumberedSplitRandomAccessFile(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.singleByteBuffer = new byte[1];
        this.currentOpenSplitFileCounter = 0;
        super.close();
        if (RandomAccessFileMode.WRITE.getValue().equals(str)) {
            d.AnonymousClass0.m$2("write mode is not allowed for NumberedSplitRandomAccessFile");
            throw null;
        }
        assertAllSplitFilesExist(fileArr);
        this.randomAccessFile = new RandomAccessFile(file, str);
        this.allSortedSplitFiles = fileArr;
        this.splitLength = file.length();
        this.rwMode = str;
    }

    public NumberedSplitRandomAccessFile(String str, String str2) {
        this(new File(str), str2);
    }

    private void assertAllSplitFilesExist(File[] fileArr) throws IOException {
        int i = 1;
        for (File file : fileArr) {
            String fileExtension = FileUtils.getFileExtension(file);
            try {
                if (i != Integer.parseInt(fileExtension)) {
                    throw new IOException("Split file number " + i + " does not exist");
                }
                i++;
            } catch (NumberFormatException unused) {
                throw new IOException(e.n("Split file extension not in expected format. Found: ", fileExtension, " expected of format: .001, .002, etc"));
            }
        }
    }

    private void openRandomAccessFileForIndex(int i) throws IOException {
        if (this.currentOpenSplitFileCounter == i) {
            return;
        }
        if (i > this.allSortedSplitFiles.length - 1) {
            d.AnonymousClass0.m$6("split counter greater than number of split files");
            return;
        }
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.randomAccessFile = new RandomAccessFile(this.allSortedSplitFiles[i], this.rwMode);
        this.currentOpenSplitFileCounter = i;
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.randomAccessFile.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long length() {
        return this.randomAccessFile.length();
    }

    public void openLastSplitFileForReading() {
        openRandomAccessFileForIndex(this.allSortedSplitFiles.length - 1);
    }

    @Override // java.io.RandomAccessFile
    public int read() {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & GZIPHeader.OS_UNKNOWN;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.randomAccessFile.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.currentOpenSplitFileCounter;
        if (i4 == this.allSortedSplitFiles.length - 1) {
            return -1;
        }
        openRandomAccessFileForIndex(i4 + 1);
        return read(bArr, i, i2);
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws IOException {
        int i = (int) (j / this.splitLength);
        if (i != this.currentOpenSplitFileCounter) {
            openRandomAccessFileForIndex(i);
        }
        this.randomAccessFile.seek(j - (((long) i) * this.splitLength));
    }

    public void seekInCurrentPart(long j) {
        this.randomAccessFile.seek(j);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
