package net.lingala.zip4j;

import defpackage.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AddFilesToZipTask;
import net.lingala.zip4j.tasks.AddFolderToZipTask;
import net.lingala.zip4j.tasks.AddStreamToZipTask;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.ExtractAllFilesTask;
import net.lingala.zip4j.tasks.ExtractFileTask;
import net.lingala.zip4j.tasks.MergeSplitZipFileTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.tasks.RenameFilesTask;
import net.lingala.zip4j.tasks.SetCommentTask;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ZipFile implements Closeable {
    private int bufferSize;
    private Charset charset;
    private ExecutorService executorService;
    private HeaderWriter headerWriter;
    private boolean isEncrypted;
    private List<InputStream> openInputStreams;
    private char[] password;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ThreadFactory threadFactory;
    private File zipFile;
    private ZipModel zipModel;

    public ZipFile(File file) {
        this(file, (char[]) null);
    }

    public ZipFile(File file, char[] cArr) {
        this.headerWriter = new HeaderWriter();
        this.charset = null;
        this.bufferSize = 4096;
        this.openInputStreams = new ArrayList();
        if (file == null) {
            d.AnonymousClass0.m$2("input zip file parameter is null");
            throw null;
        }
        this.zipFile = file;
        this.password = cArr;
        this.runInThread = false;
        this.progressMonitor = new ProgressMonitor();
    }

    public ZipFile(String str) {
        this(new File(str), (char[]) null);
    }

    public ZipFile(String str, char[] cArr) {
        this(new File(str), cArr);
    }

    private void addFolder(File file, ZipParameters zipParameters, boolean z) throws ZipException {
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            d.AnonymousClass0.m$5("internal error: zip model is null");
        } else if (z && zipModel.isSplitArchive()) {
            d.AnonymousClass0.m$5("This is a split archive. Zip file format does not allow updating split/spanned files");
        } else {
            new AddFolderToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFolderToZipTask.AddFolderToZipTaskParameters(file, zipParameters, buildConfig()));
        }
    }

    private AsyncZipTask.AsyncTaskParameters buildAsyncParameters() {
        if (this.runInThread) {
            if (this.threadFactory == null) {
                this.threadFactory = Executors.defaultThreadFactory();
            }
            this.executorService = Executors.newSingleThreadExecutor(this.threadFactory);
        }
        return new AsyncZipTask.AsyncTaskParameters(this.executorService, this.runInThread, this.progressMonitor);
    }

    private Zip4jConfig buildConfig() {
        return new Zip4jConfig(this.charset, this.bufferSize);
    }

    private void createNewZipModel() {
        ZipModel zipModel = new ZipModel();
        this.zipModel = zipModel;
        zipModel.setZipFile(this.zipFile);
    }

    private RandomAccessFile initializeRandomAccessFileForHeaderReading() {
        if (!FileUtils.isNumberedSplitFile(this.zipFile)) {
            return new RandomAccessFile(this.zipFile, RandomAccessFileMode.READ.getValue());
        }
        NumberedSplitRandomAccessFile numberedSplitRandomAccessFile = new NumberedSplitRandomAccessFile(this.zipFile, RandomAccessFileMode.READ.getValue(), FileUtils.getAllSortedNumberedSplitFiles(this.zipFile));
        numberedSplitRandomAccessFile.openLastSplitFileForReading();
        return numberedSplitRandomAccessFile;
    }

    private void readZipInfo() throws ZipException {
        if (this.zipModel != null) {
            return;
        }
        if (!this.zipFile.exists()) {
            createNewZipModel();
            return;
        }
        if (!this.zipFile.canRead()) {
            d.AnonymousClass0.m$5("no read access for the input zip file");
            return;
        }
        try {
            RandomAccessFile randomAccessFileInitializeRandomAccessFileForHeaderReading = initializeRandomAccessFileForHeaderReading();
            try {
                ZipModel allHeaders = new HeaderReader().readAllHeaders(randomAccessFileInitializeRandomAccessFileForHeaderReading, buildConfig());
                this.zipModel = allHeaders;
                allHeaders.setZipFile(this.zipFile);
                if (randomAccessFileInitializeRandomAccessFileForHeaderReading != null) {
                    randomAccessFileInitializeRandomAccessFileForHeaderReading.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (randomAccessFileInitializeRandomAccessFileForHeaderReading != null) {
                        try {
                            randomAccessFileInitializeRandomAccessFileForHeaderReading.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (ZipException e) {
            throw e;
        } catch (IOException e2) {
            throw new ZipException(e2);
        }
    }

    private boolean verifyAllSplitFilesOfZipExists(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().exists()) {
                return false;
            }
        }
        return true;
    }

    public void addFile(File file) {
        addFiles(Collections.singletonList(file), new ZipParameters());
    }

    public void addFile(File file, ZipParameters zipParameters) throws ZipException {
        addFiles(Collections.singletonList(file), zipParameters);
    }

    public void addFile(String str) throws ZipException {
        addFile(str, new ZipParameters());
    }

    public void addFile(String str, ZipParameters zipParameters) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            addFiles(Collections.singletonList(new File(str)), zipParameters);
        } else {
            d.AnonymousClass0.m$5("file to add is null or empty");
        }
    }

    public void addFiles(List<File> list) throws ZipException {
        addFiles(list, new ZipParameters());
    }

    public void addFiles(List<File> list, ZipParameters zipParameters) throws ZipException {
        if (list == null || list.size() == 0) {
            d.AnonymousClass0.m$5("input file List is null or empty");
            return;
        }
        if (zipParameters == null) {
            d.AnonymousClass0.m$5("input parameters are null");
            return;
        }
        readZipInfo();
        if (this.zipModel == null) {
            d.AnonymousClass0.m$5("internal error: zip model is null");
        } else if (this.zipFile.exists() && this.zipModel.isSplitArchive()) {
            d.AnonymousClass0.m$5("Zip file already exists. Zip file format does not allow updating split/spanned files");
        } else {
            new AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
        }
    }

    public void addFolder(File file) throws ZipException {
        addFolder(file, new ZipParameters());
    }

    public void addFolder(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            d.AnonymousClass0.m$5("input path is null, cannot add folder to zip file");
            return;
        }
        if (!file.exists()) {
            d.AnonymousClass0.m$5("folder does not exist");
            return;
        }
        if (!file.isDirectory()) {
            d.AnonymousClass0.m$5("input folder is not a directory");
            return;
        }
        if (!file.canRead()) {
            d.AnonymousClass0.m$5("cannot read input folder");
        } else if (zipParameters != null) {
            addFolder(file, zipParameters, true);
        } else {
            d.AnonymousClass0.m$5("input parameters are null, cannot add folder to zip file");
        }
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            d.AnonymousClass0.m$5("inputstream is null, cannot add file to zip");
            return;
        }
        if (zipParameters == null) {
            d.AnonymousClass0.m$5("zip parameters are null");
            return;
        }
        setRunInThread(false);
        readZipInfo();
        if (this.zipModel == null) {
            d.AnonymousClass0.m$5("internal error: zip model is null");
        } else if (this.zipFile.exists() && this.zipModel.isSplitArchive()) {
            d.AnonymousClass0.m$5("Zip file already exists. Zip file format does not allow updating split/spanned files");
        } else {
            new AddStreamToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddStreamToZipTask.AddStreamToZipTaskParameters(inputStream, zipParameters, buildConfig()));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.openInputStreams.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.openInputStreams.clear();
    }

    public void createSplitZipFile(List<File> list, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (this.zipFile.exists()) {
            throw new ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFile method");
        }
        if (list == null || list.size() == 0) {
            d.AnonymousClass0.m$5("input file List is null, cannot create zip file");
            return;
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        this.zipModel.setSplitLength(j);
        new AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
    }

    public void createSplitZipFileFromFolder(File file, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (file == null) {
            d.AnonymousClass0.m$5("folderToAdd is null, cannot create zip file from folder");
            return;
        }
        if (zipParameters == null) {
            d.AnonymousClass0.m$5("input parameters are null, cannot create zip file from folder");
            return;
        }
        if (this.zipFile.exists()) {
            throw new ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFolder method");
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        if (z) {
            this.zipModel.setSplitLength(j);
        }
        addFolder(file, zipParameters, false);
    }

    public void extractAll(String str) throws ZipException {
        extractAll(str, new UnzipParameters());
    }

    public void extractAll(String str, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            d.AnonymousClass0.m$5("output path is null or invalid");
            return;
        }
        if (!Zip4jUtil.createDirectoryIfNotExists(new File(str))) {
            d.AnonymousClass0.m$5("invalid output path");
            return;
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        ZipModel zipModel = this.zipModel;
        if (zipModel != null) {
            new ExtractAllFilesTask(zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new ExtractAllFilesTask.ExtractAllFilesTaskParameters(str, buildConfig()));
        } else {
            d.AnonymousClass0.m$5("Internal error occurred when extracting zip file");
        }
    }

    public void extractFile(String str, String str2) throws ZipException {
        extractFile(str, str2, (String) null, new UnzipParameters());
    }

    public void extractFile(String str, String str2, String str3) throws ZipException {
        extractFile(str, str2, str3, new UnzipParameters());
    }

    public void extractFile(String str, String str2, String str3, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            d.AnonymousClass0.m$5("file to extract is null or empty, cannot extract file");
            return;
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            d.AnonymousClass0.m$5("destination path is empty or null, cannot extract file");
            return;
        }
        if (unzipParameters == null) {
            unzipParameters = new UnzipParameters();
        }
        readZipInfo();
        new ExtractFileTask(this.zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new ExtractFileTask.ExtractFileTaskParameters(str2, str, str3, buildConfig()));
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        extractFile(str, str2, (String) null, unzipParameters);
    }

    public void extractFile(FileHeader fileHeader, String str) throws ZipException {
        extractFile(fileHeader, str, (String) null, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, String str2) throws ZipException {
        extractFile(fileHeader, str, str2, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        if (fileHeader != null) {
            extractFile(fileHeader.getFileName(), str, str2, unzipParameters);
        } else {
            d.AnonymousClass0.m$5("input file header is null, cannot extract file");
        }
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters) throws ZipException {
        extractFile(fileHeader, str, (String) null, unzipParameters);
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        Charset charset = this.charset;
        return charset == null ? InternalZipConstants.CHARSET_UTF_8 : charset;
    }

    public String getComment() throws ZipException {
        String str;
        if (this.zipFile.exists()) {
            readZipInfo();
            ZipModel zipModel = this.zipModel;
            if (zipModel == null) {
                str = "zip model is null, cannot read comment";
            } else {
                if (zipModel.getEndOfCentralDirectoryRecord() != null) {
                    return this.zipModel.getEndOfCentralDirectoryRecord().getComment();
                }
                str = "end of central directory record is null, cannot read comment";
            }
        } else {
            str = "zip file does not exist, cannot read comment";
        }
        d.AnonymousClass0.m$5(str);
        return null;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public File getFile() {
        return this.zipFile;
    }

    public FileHeader getFileHeader(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            d.AnonymousClass0.m$5("input file name is emtpy or null, cannot get FileHeader");
            return null;
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return HeaderUtil.getFileHeader(this.zipModel, str);
    }

    public List<FileHeader> getFileHeaders() throws ZipException {
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        return (zipModel == null || zipModel.getCentralDirectory() == null) ? Collections.EMPTY_LIST : this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws ZipException {
        String str;
        if (fileHeader != null) {
            readZipInfo();
            ZipModel zipModel = this.zipModel;
            if (zipModel != null) {
                ZipInputStream zipInputStreamCreateZipInputStream = UnzipUtil.createZipInputStream(zipModel, fileHeader, this.password);
                this.openInputStreams.add(zipInputStreamCreateZipInputStream);
                return zipInputStreamCreateZipInputStream;
            }
            str = "zip model is null, cannot get inputstream";
        } else {
            str = "FileHeader is null, cannot get InputStream";
        }
        d.AnonymousClass0.m$5(str);
        return null;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public List<File> getSplitZipFiles() throws ZipException {
        readZipInfo();
        return FileUtils.getSplitZipFiles(this.zipModel);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000f  */
    public boolean isEncrypted() throws ZipException {
        String str;
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                str = "Zip Model is null";
            } else {
                if (this.zipModel.getCentralDirectory() == null && this.zipModel.getCentralDirectory().getFileHeaders() != null) {
                    for (FileHeader fileHeader : this.zipModel.getCentralDirectory().getFileHeaders()) {
                        if (fileHeader != null && fileHeader.isEncrypted()) {
                            this.isEncrypted = true;
                            break;
                        }
                    }
                    return this.isEncrypted;
                }
                str = "invalid zip file";
            }
        } else {
            if (this.zipModel.getCentralDirectory() == null) {
            }
            str = "invalid zip file";
        }
        d.AnonymousClass0.m$5(str);
        return false;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public boolean isSplitArchive() throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                d.AnonymousClass0.m$5("Zip Model is null");
                return false;
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public boolean isValidZipFile() {
        if (!this.zipFile.exists()) {
            return false;
        }
        try {
            readZipInfo();
            return !this.zipModel.isSplitArchive() || verifyAllSplitFilesOfZipExists(getSplitZipFiles());
        } catch (Exception unused) {
            return false;
        }
    }

    public void mergeSplitFiles(File file) throws ZipException {
        if (file == null) {
            d.AnonymousClass0.m$5("outputZipFile is null, cannot merge split files");
            return;
        }
        if (file.exists()) {
            d.AnonymousClass0.m$5("output Zip File already exists");
            return;
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel != null) {
            new MergeSplitZipFileTask(zipModel, buildAsyncParameters()).execute(new MergeSplitZipFileTask.MergeSplitZipFileTaskParameters(file, buildConfig()));
        } else {
            d.AnonymousClass0.m$5("zip model is null, corrupt zip file?");
        }
    }

    public void removeFile(String str) {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            removeFiles(Collections.singletonList(str));
        } else {
            d.AnonymousClass0.m$5("file name is empty or null, cannot remove file");
        }
    }

    public void removeFile(FileHeader fileHeader) throws ZipException {
        if (fileHeader != null) {
            removeFile(fileHeader.getFileName());
        } else {
            d.AnonymousClass0.m$5("input file header is null, cannot remove file");
        }
    }

    public void removeFiles(List<String> list) throws ZipException {
        if (list == null) {
            d.AnonymousClass0.m$5("fileNames list is null");
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            d.AnonymousClass0.m$5("Zip file format does not allow updating split/spanned files");
        } else {
            new RemoveFilesFromZipTask(this.zipModel, this.headerWriter, buildAsyncParameters()).execute(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(list, buildConfig()));
        }
    }

    public void renameFile(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            d.AnonymousClass0.m$5("file name to be changed is null or empty");
        } else if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            renameFiles(Collections.singletonMap(str, str2));
        } else {
            d.AnonymousClass0.m$5("newFileName is null or empty");
        }
    }

    public void renameFile(FileHeader fileHeader, String str) throws ZipException {
        if (fileHeader != null) {
            renameFile(fileHeader.getFileName(), str);
        } else {
            d.AnonymousClass0.m$5("File header is null");
        }
    }

    public void renameFiles(Map<String, String> map) throws ZipException {
        if (map == null) {
            d.AnonymousClass0.m$5("fileNamesMap is null");
            return;
        }
        if (map.size() == 0) {
            return;
        }
        readZipInfo();
        if (this.zipModel.isSplitArchive()) {
            d.AnonymousClass0.m$5("Zip file format does not allow updating split/spanned files");
        } else {
            new RenameFilesTask(this.zipModel, this.headerWriter, new RawIO(), buildAsyncParameters()).execute(new RenameFilesTask.RenameFilesTaskParameters(map, buildConfig()));
        }
    }

    public void setBufferSize(int i) {
        if (i >= 512) {
            this.bufferSize = i;
        } else {
            d.AnonymousClass0.m$2("Buffer size cannot be less than 512 bytes");
        }
    }

    public void setCharset(Charset charset) {
        if (charset != null) {
            this.charset = charset;
        } else {
            d.AnonymousClass0.m$2("charset cannot be null");
        }
    }

    public void setComment(String str) throws ZipException {
        if (str == null) {
            d.AnonymousClass0.m$5("input comment is null, cannot update zip file");
            return;
        }
        if (!this.zipFile.exists()) {
            d.AnonymousClass0.m$5("zip file does not exist, cannot set comment for zip file");
            return;
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            d.AnonymousClass0.m$5("zipModel is null, cannot update zip file");
        } else if (zipModel.getEndOfCentralDirectoryRecord() != null) {
            new SetCommentTask(this.zipModel, buildAsyncParameters()).execute(new SetCommentTask.SetCommentTaskTaskParameters(str, buildConfig()));
        } else {
            d.AnonymousClass0.m$5("end of central directory is null, cannot set comment");
        }
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public void setRunInThread(boolean z) {
        this.runInThread = z;
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public String toString() {
        return this.zipFile.toString();
    }
}
