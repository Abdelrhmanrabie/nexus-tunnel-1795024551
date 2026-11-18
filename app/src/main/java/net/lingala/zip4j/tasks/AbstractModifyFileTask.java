package net.lingala.zip4j.tasks;

import defpackage.d;
import defpackage.e;
import java.io.File;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.FileUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractModifyFileTask<T> extends AsyncZipTask<T> {
    public AbstractModifyFileTask(AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
    }

    private int getIndexOfFileHeader(List<FileHeader> list, FileHeader fileHeader) throws ZipException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(fileHeader)) {
                return i;
            }
        }
        d.AnonymousClass0.m$5("Could not find file header in list of central directory file headers");
        return 0;
    }

    private void restoreFileName(File file, File file2) throws ZipException {
        String str;
        if (!file.delete()) {
            str = "cannot delete old zip file";
        } else if (file2.renameTo(file)) {
            return;
        } else {
            str = "cannot rename modified zip file";
        }
        d.AnonymousClass0.m$5(str);
    }

    public void cleanupFile(boolean z, File file, File file2) {
        if (z) {
            restoreFileName(file, file2);
        } else {
            if (file2.delete()) {
                return;
            }
            d.AnonymousClass0.m$5("Could not delete temporary file");
        }
    }

    public List<FileHeader> cloneAndSortFileHeadersByOffset(List<FileHeader> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<FileHeader>() { // from class: net.lingala.zip4j.tasks.AbstractModifyFileTask.1
            @Override // java.util.Comparator
            public int compare(FileHeader fileHeader, FileHeader fileHeader2) {
                if (fileHeader.getFileName().equals(fileHeader2.getFileName())) {
                    return 0;
                }
                return fileHeader.getOffsetLocalHeader() < fileHeader2.getOffsetLocalHeader() ? -1 : 1;
            }
        });
        return arrayList;
    }

    public long copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor, int i) throws ZipException {
        FileUtils.copyFile(randomAccessFile, outputStream, j, j + j2, progressMonitor, i);
        return j2;
    }

    public long getOffsetOfNextEntry(List<FileHeader> list, FileHeader fileHeader, ZipModel zipModel) throws ZipException {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        return indexOfFileHeader == list.size() + (-1) ? HeaderUtil.getOffsetStartOfCentralDirectory(zipModel) : list.get(indexOfFileHeader + 1).getOffsetLocalHeader();
    }

    public File getTemporaryFile(String str) {
        Random random = new Random();
        StringBuilder sbD = e.d(str);
        sbD.append(random.nextInt(10000));
        File file = new File(sbD.toString());
        while (file.exists()) {
            StringBuilder sbD2 = e.d(str);
            sbD2.append(random.nextInt(10000));
            file = new File(sbD2.toString());
        }
        return file;
    }

    public void updateOffsetsForAllSubsequentFileHeaders(List<FileHeader> list, ZipModel zipModel, FileHeader fileHeader, long j) {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        if (indexOfFileHeader == -1) {
            d.AnonymousClass0.m$5("Could not locate modified file header in zipModel");
            return;
        }
        while (true) {
            indexOfFileHeader++;
            if (indexOfFileHeader >= list.size()) {
                return;
            }
            FileHeader fileHeader2 = list.get(indexOfFileHeader);
            fileHeader2.setOffsetLocalHeader(fileHeader2.getOffsetLocalHeader() + j);
            if (zipModel.isZip64Format() && fileHeader2.getZip64ExtendedInfo() != null && fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() != -1) {
                fileHeader2.getZip64ExtendedInfo().setOffsetLocalHeader(fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() + j);
            }
        }
    }
}
