package net.lingala.zip4j.tasks;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import defpackage.fb$1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractExtractFileTask<T> extends AsyncZipTask<T> {
    private final UnzipParameters unzipParameters;
    private final ZipModel zipModel;

    public AbstractExtractFileTask(ZipModel zipModel, UnzipParameters unzipParameters, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
        this.unzipParameters = unzipParameters;
    }

    private void assertCanonicalPathsAreSame(File file, String str, FileHeader fileHeader) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (file.isDirectory()) {
            String str2 = InternalZipConstants.FILE_SEPARATOR;
            if (!canonicalPath.endsWith(str2)) {
                canonicalPath = ak.j(canonicalPath, str2);
            }
        }
        if (!canonicalPath.startsWith(new File(str).getCanonicalPath() + File.separator)) {
            throw new ZipException(ak.AnonymousClass0.m("illegal file name that breaks out of the target directory: ", fileHeader.getFileName()));
        }
    }

    private void checkOutputDirectoryStructure(File file) throws ZipException {
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return;
        }
        throw new ZipException("Unable to create parent directories: " + file.getParentFile());
    }

    private void createSymLink(ZipInputStream zipInputStream, FileHeader fileHeader, File file, ProgressMonitor progressMonitor) throws IOException {
        String str = new String(readCompleteEntry(zipInputStream, fileHeader, progressMonitor));
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            d.AnonymousClass0.m$5("Could not create parent directories");
            return;
        }
        try {
            Files.createSymbolicLink(file.toPath(), Paths.get(str, new String[0]), new FileAttribute[0]);
        } catch (NoSuchMethodError unused) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    private File determineOutputFile(FileHeader fileHeader, String str, String str2) {
        String fileName = fileHeader.getFileName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = fileName;
        }
        return new File(fb$1.m(e.d(str), InternalZipConstants.FILE_SEPARATOR, str2));
    }

    private boolean isSymbolicLink(FileHeader fileHeader) {
        byte[] externalFileAttributes = fileHeader.getExternalFileAttributes();
        if (externalFileAttributes == null || externalFileAttributes.length < 4) {
            return false;
        }
        return BitUtils.isBitSet(externalFileAttributes[3], 5);
    }

    private byte[] readCompleteEntry(ZipInputStream zipInputStream, FileHeader fileHeader, ProgressMonitor progressMonitor) throws ZipException {
        int uncompressedSize = (int) fileHeader.getUncompressedSize();
        byte[] bArr = new byte[uncompressedSize];
        if (zipInputStream.read(bArr) == uncompressedSize) {
            progressMonitor.updateWorkCompleted(uncompressedSize);
            return bArr;
        }
        d.AnonymousClass0.m$5("Could not read complete entry");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0031  */
    private void unzipFile(ZipInputStream zipInputStream, File file, ProgressMonitor progressMonitor, byte[] bArr) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i = zipInputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                        progressMonitor.updateWorkCompleted(i);
                        verifyIfTaskIsCancelled();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
                throw e;
            }
        } catch (Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    private void verifyNextEntry(ZipInputStream zipInputStream, FileHeader fileHeader) throws IOException {
        if (BitUtils.isBitSet(fileHeader.getGeneralPurposeFlag()[0], 6)) {
            throw new ZipException(ak.AnonymousClass0.m("Entry with name ", fileHeader.getFileName(), " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented."));
        }
        LocalFileHeader nextEntry = zipInputStream.getNextEntry(fileHeader, false);
        if (nextEntry == null) {
            throw new ZipException(ak.AnonymousClass0.m("Could not read corresponding local file header for file header: ", fileHeader.getFileName()));
        }
        if (fileHeader.getFileName().equals(nextEntry.getFileName())) {
            return;
        }
        d.AnonymousClass0.m$5("File header and local file header mismatch");
    }

    public void extractFile(ZipInputStream zipInputStream, FileHeader fileHeader, String str, String str2, ProgressMonitor progressMonitor, byte[] bArr) throws Exception {
        if (!isSymbolicLink(fileHeader) || this.unzipParameters.isExtractSymbolicLinks()) {
            String str3 = InternalZipConstants.FILE_SEPARATOR;
            if (!str.endsWith(str3)) {
                str = ak.j(str, str3);
            }
            File fileDetermineOutputFile = determineOutputFile(fileHeader, str, str2);
            progressMonitor.setFileName(fileDetermineOutputFile.getAbsolutePath());
            assertCanonicalPathsAreSame(fileDetermineOutputFile, str, fileHeader);
            verifyNextEntry(zipInputStream, fileHeader);
            if (fileHeader.isDirectory()) {
                if (!fileDetermineOutputFile.exists() && !fileDetermineOutputFile.mkdirs()) {
                    throw new ZipException("Could not create directory: " + fileDetermineOutputFile);
                }
            } else if (isSymbolicLink(fileHeader)) {
                createSymLink(zipInputStream, fileHeader, fileDetermineOutputFile, progressMonitor);
            } else {
                checkOutputDirectoryStructure(fileDetermineOutputFile);
                unzipFile(zipInputStream, fileDetermineOutputFile, progressMonitor, bArr);
            }
            UnzipUtil.applyFileAttributes(fileHeader, fileDetermineOutputFile);
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }
}
