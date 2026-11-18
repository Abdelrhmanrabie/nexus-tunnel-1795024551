package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MergeSplitZipFileTask extends AsyncZipTask<MergeSplitZipFileTaskParameters> {
    private final RawIO rawIO;
    private final ZipModel zipModel;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class MergeSplitZipFileTaskParameters extends AbstractZipTaskParameters {
        private File outputZipFile;

        public MergeSplitZipFileTaskParameters(File file, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputZipFile = file;
        }
    }

    public MergeSplitZipFileTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.rawIO = new RawIO();
        this.zipModel = zipModel;
    }

    private RandomAccessFile createSplitZipFileStream(ZipModel zipModel, int i) {
        return new RandomAccessFile(getNextSplitZipFile(zipModel, i), RandomAccessFileMode.READ.getValue());
    }

    private File getNextSplitZipFile(ZipModel zipModel, int i) {
        if (i == zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) {
            return zipModel.getZipFile();
        }
        return new File(zipModel.getZipFile().getPath().substring(0, zipModel.getZipFile().getPath().lastIndexOf(".")) + (i >= 9 ? ".z" : ".z0") + (i + 1));
    }

    private void updateFileHeaderOffsetsForIndex(List<FileHeader> list, long j, int i, int i2) {
        for (FileHeader fileHeader : list) {
            if (fileHeader.getDiskNumberStart() == i) {
                fileHeader.setOffsetLocalHeader((fileHeader.getOffsetLocalHeader() + j) - ((long) i2));
                fileHeader.setDiskNumberStart(0);
            }
        }
    }

    private void updateHeadersForMergeSplitFileAction(ZipModel zipModel, long j, OutputStream outputStream, Charset charset) throws IOException {
        ZipModel zipModel2 = (ZipModel) zipModel.clone();
        zipModel2.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(j);
        updateSplitZipModel(zipModel2, j);
        new HeaderWriter().finalizeZipFileWithoutValidations(zipModel2, outputStream, charset);
    }

    private void updateSplitEndCentralDirectory(ZipModel zipModel) {
        int size = zipModel.getCentralDirectory().getFileHeaders().size();
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(0);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(size);
    }

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
            return;
        }
        Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = zipModel.getZip64EndOfCentralDirectoryLocator();
        zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
        zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord() + j);
        zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(1);
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
            return;
        }
        Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = zipModel.getZip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(0);
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory());
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
    }

    private void updateSplitZipModel(ZipModel zipModel, long j) {
        zipModel.setSplitArchive(false);
        updateSplitEndCentralDirectory(zipModel);
        if (zipModel.isZip64Format()) {
            updateSplitZip64EndCentralDirLocator(zipModel, j);
            updateSplitZip64EndCentralDirRec(zipModel, j);
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long length = 0;
        if (!this.zipModel.isSplitArchive()) {
            return 0L;
        }
        for (int i = 0; i <= this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk(); i++) {
            length += getNextSplitZipFile(this.zipModel, i).length();
        }
        return length;
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        RandomAccessFile randomAccessFile;
        FileOutputStream fileOutputStream;
        int i;
        int i2;
        MergeSplitZipFileTask mergeSplitZipFileTask = this;
        if (!mergeSplitZipFileTask.zipModel.isSplitArchive()) {
            ZipException zipException = new ZipException("archive not a split zip file");
            progressMonitor.endProgressMonitor(zipException);
            throw zipException;
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(mergeSplitZipFileTaskParameters.outputZipFile);
            try {
                int numberOfThisDisk = mergeSplitZipFileTask.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
                if (numberOfThisDisk <= 0) {
                    throw new ZipException("zip archive not a split zip file");
                }
                int i3 = 0;
                int i4 = 0;
                long j = 0;
                while (true) {
                    ZipModel zipModel = mergeSplitZipFileTask.zipModel;
                    if (i3 <= numberOfThisDisk) {
                        int i5 = i4;
                        try {
                            RandomAccessFile randomAccessFileCreateSplitZipFileStream = mergeSplitZipFileTask.createSplitZipFileStream(zipModel, i3);
                            try {
                                long length = randomAccessFileCreateSplitZipFileStream.length();
                                if (i3 != 0) {
                                    i = i5;
                                    i2 = 0;
                                } else if (mergeSplitZipFileTask.rawIO.readIntLittleEndian(randomAccessFileCreateSplitZipFileStream) == HeaderSignature.SPLIT_ZIP.getValue()) {
                                    i2 = 4;
                                    i = 4;
                                } else {
                                    randomAccessFileCreateSplitZipFileStream.seek(0L);
                                    i = i5;
                                    i2 = 0;
                                }
                                if (i3 == numberOfThisDisk) {
                                    length = mergeSplitZipFileTask.zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
                                }
                                long j2 = i2;
                                FileUtils.copyFile(randomAccessFileCreateSplitZipFileStream, fileOutputStream2, j2, length, progressMonitor, mergeSplitZipFileTaskParameters.zip4jConfig.getBufferSize());
                                long j3 = length;
                                randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                                fileOutputStream = fileOutputStream2;
                                j += j3 - j2;
                                try {
                                    int i6 = i3;
                                    int i7 = i;
                                    mergeSplitZipFileTask.updateFileHeaderOffsetsForIndex(mergeSplitZipFileTask.zipModel.getCentralDirectory().getFileHeaders(), i3 == 0 ? 0L : j, i6, i7);
                                    verifyIfTaskIsCancelled();
                                    try {
                                        randomAccessFile.close();
                                        i3 = i6 + 1;
                                        mergeSplitZipFileTask = this;
                                        i4 = i7;
                                        fileOutputStream2 = fileOutputStream;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream2 = fileOutputStream;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    Throwable th3 = th;
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        if (randomAccessFile == null) {
                                            throw th4;
                                        }
                                        try {
                                            randomAccessFile.close();
                                            throw th4;
                                        } catch (Throwable th5) {
                                            th3.addSuppressed(th5);
                                            throw th4;
                                        }
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } else {
                        FileOutputStream fileOutputStream3 = fileOutputStream2;
                        try {
                            updateHeadersForMergeSplitFileAction(zipModel, j, fileOutputStream3, mergeSplitZipFileTaskParameters.zip4jConfig.getCharset());
                            progressMonitor.endProgressMonitor();
                            fileOutputStream3.close();
                            return;
                        } catch (Throwable th8) {
                            th = th8;
                            fileOutputStream2 = fileOutputStream3;
                        }
                    }
                    Throwable th9 = th;
                    try {
                        throw th9;
                    } catch (Throwable th10) {
                        try {
                            fileOutputStream2.close();
                            throw th10;
                        } catch (Throwable th11) {
                            th9.addSuppressed(th11);
                            throw th10;
                        }
                    }
                }
            } catch (Throwable th12) {
                th = th12;
            }
        } catch (CloneNotSupportedException e) {
            throw new ZipException(e);
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.MERGE_ZIP_FILES;
    }
}
