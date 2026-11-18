package net.lingala.zip4j.io.outputstream;

import defpackage.d;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.FileHeaderFactory;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ZipOutputStream extends OutputStream {
    private CompressedOutputStream compressedOutputStream;
    private CountingOutputStream countingOutputStream;
    private CRC32 crc32;
    private boolean entryClosed;
    private FileHeader fileHeader;
    private FileHeaderFactory fileHeaderFactory;
    private HeaderWriter headerWriter;
    private LocalFileHeader localFileHeader;
    private char[] password;
    private RawIO rawIO;
    private boolean streamClosed;
    private long uncompressedSizeForThisEntry;
    private Zip4jConfig zip4jConfig;
    private ZipModel zipModel;

    public ZipOutputStream(OutputStream outputStream) {
        this(outputStream, null, null);
    }

    public ZipOutputStream(OutputStream outputStream, Charset charset) {
        this(outputStream, null, charset);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr) {
        this(outputStream, cArr, null);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Charset charset) {
        this(outputStream, cArr, new Zip4jConfig(charset, 4096), new ZipModel());
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Zip4jConfig zip4jConfig, ZipModel zipModel) throws IOException {
        this.fileHeaderFactory = new FileHeaderFactory();
        this.headerWriter = new HeaderWriter();
        this.crc32 = new CRC32();
        this.rawIO = new RawIO();
        this.uncompressedSizeForThisEntry = 0L;
        this.entryClosed = true;
        if (zip4jConfig.getBufferSize() < 512) {
            d.AnonymousClass0.m$2("Buffer size cannot be less than 512 bytes");
            throw null;
        }
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        this.countingOutputStream = countingOutputStream;
        this.password = cArr;
        this.zip4jConfig = zip4jConfig;
        this.zipModel = initializeZipModel(zipModel, countingOutputStream);
        this.streamClosed = false;
        writeSplitZipHeaderIfApplicable();
    }

    private void ensureStreamOpen() throws IOException {
        if (this.streamClosed) {
            d.AnonymousClass0.m$6("Stream is closed");
        }
    }

    private void initializeAndWriteFileHeader(ZipParameters zipParameters) throws IOException {
        FileHeader fileHeaderGenerateFileHeader = this.fileHeaderFactory.generateFileHeader(zipParameters, this.countingOutputStream.isSplitZipFile(), this.countingOutputStream.getCurrentSplitFileCounter(), this.zip4jConfig.getCharset(), this.rawIO);
        this.fileHeader = fileHeaderGenerateFileHeader;
        fileHeaderGenerateFileHeader.setOffsetLocalHeader(this.countingOutputStream.getOffsetForNextEntry());
        LocalFileHeader localFileHeaderGenerateLocalFileHeader = this.fileHeaderFactory.generateLocalFileHeader(this.fileHeader);
        this.localFileHeader = localFileHeaderGenerateLocalFileHeader;
        this.headerWriter.writeLocalFileHeader(this.zipModel, localFileHeaderGenerateLocalFileHeader, this.countingOutputStream, this.zip4jConfig.getCharset());
    }

    private CipherOutputStream initializeCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters) throws ZipException {
        String str;
        if (!zipParameters.isEncryptFiles()) {
            return new NoCipherOutputStream(zipEntryOutputStream, zipParameters, null);
        }
        char[] cArr = this.password;
        if (cArr == null || cArr.length == 0) {
            str = "password not set";
        } else {
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.AES) {
                return new AesCipherOutputStream(zipEntryOutputStream, zipParameters, this.password);
            }
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
                return new ZipStandardCipherOutputStream(zipEntryOutputStream, zipParameters, this.password);
            }
            EncryptionMethod encryptionMethod = zipParameters.getEncryptionMethod();
            EncryptionMethod encryptionMethod2 = EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG;
            if (encryptionMethod == encryptionMethod2) {
                throw new ZipException(encryptionMethod2 + " encryption method is not supported");
            }
            str = "Invalid encryption method";
        }
        d.AnonymousClass0.m$5(str);
        return null;
    }

    private CompressedOutputStream initializeCompressedOutputStream(CipherOutputStream cipherOutputStream, ZipParameters zipParameters) {
        return zipParameters.getCompressionMethod() == CompressionMethod.DEFLATE ? new DeflaterOutputStream(cipherOutputStream, zipParameters.getCompressionLevel(), this.zip4jConfig.getBufferSize()) : new StoreOutputStream(cipherOutputStream);
    }

    private CompressedOutputStream initializeCompressedOutputStream(ZipParameters zipParameters) {
        return initializeCompressedOutputStream(initializeCipherOutputStream(new ZipEntryOutputStream(this.countingOutputStream), zipParameters), zipParameters);
    }

    private ZipModel initializeZipModel(ZipModel zipModel, CountingOutputStream countingOutputStream) {
        if (zipModel == null) {
            zipModel = new ZipModel();
        }
        if (countingOutputStream.isSplitZipFile()) {
            zipModel.setSplitArchive(true);
            zipModel.setSplitLength(countingOutputStream.getSplitLength());
        }
        return zipModel;
    }

    private void reset() {
        this.uncompressedSizeForThisEntry = 0L;
        this.crc32.reset();
        this.compressedOutputStream.close();
    }

    private void verifyZipParameters(ZipParameters zipParameters) {
        String str;
        if (Zip4jUtil.isStringNullOrEmpty(zipParameters.getFileNameInZip())) {
            str = "fileNameInZip is null or empty";
        } else if (zipParameters.getCompressionMethod() != CompressionMethod.STORE || zipParameters.getEntrySize() >= 0 || FileUtils.isZipEntryDirectory(zipParameters.getFileNameInZip()) || !zipParameters.isWriteExtendedLocalFileHeader()) {
            return;
        } else {
            str = "uncompressed size should be set for zip entries of compression type store";
        }
        d.AnonymousClass0.m$2(str);
    }

    private boolean writeCrc(FileHeader fileHeader) {
        if (fileHeader.isEncrypted() && fileHeader.getEncryptionMethod().equals(EncryptionMethod.AES)) {
            return fileHeader.getAesExtraDataRecord().getAesVersion().equals(AesVersion.ONE);
        }
        return true;
    }

    private void writeSplitZipHeaderIfApplicable() throws IOException {
        if (this.countingOutputStream.isSplitZipFile()) {
            this.rawIO.writeIntLittleEndian(this.countingOutputStream, (int) HeaderSignature.SPLIT_ZIP.getValue());
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.entryClosed) {
            closeEntry();
        }
        this.zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.countingOutputStream.getNumberOfBytesWritten());
        this.headerWriter.finalizeZipFile(this.zipModel, this.countingOutputStream, this.zip4jConfig.getCharset());
        this.countingOutputStream.close();
        this.streamClosed = true;
    }

    public FileHeader closeEntry() throws IOException {
        this.compressedOutputStream.closeEntry();
        long compressedSize = this.compressedOutputStream.getCompressedSize();
        this.fileHeader.setCompressedSize(compressedSize);
        this.localFileHeader.setCompressedSize(compressedSize);
        this.fileHeader.setUncompressedSize(this.uncompressedSizeForThisEntry);
        this.localFileHeader.setUncompressedSize(this.uncompressedSizeForThisEntry);
        if (writeCrc(this.fileHeader)) {
            this.fileHeader.setCrc(this.crc32.getValue());
            this.localFileHeader.setCrc(this.crc32.getValue());
        }
        this.zipModel.getLocalFileHeaders().add(this.localFileHeader);
        this.zipModel.getCentralDirectory().getFileHeaders().add(this.fileHeader);
        if (this.localFileHeader.isDataDescriptorExists()) {
            this.headerWriter.writeExtendedLocalHeader(this.localFileHeader, this.countingOutputStream);
        }
        reset();
        this.entryClosed = true;
        return this.fileHeader;
    }

    public void putNextEntry(ZipParameters zipParameters) throws IOException {
        verifyZipParameters(zipParameters);
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        if (FileUtils.isZipEntryDirectory(zipParameters.getFileNameInZip())) {
            zipParameters2.setWriteExtendedLocalFileHeader(false);
            zipParameters2.setCompressionMethod(CompressionMethod.STORE);
            zipParameters2.setEncryptFiles(false);
            zipParameters2.setEntrySize(0L);
        }
        initializeAndWriteFileHeader(zipParameters2);
        this.compressedOutputStream = initializeCompressedOutputStream(zipParameters2);
        this.entryClosed = false;
    }

    public void setComment(String str) throws IOException {
        ensureStreamOpen();
        this.zipModel.getEndOfCentralDirectoryRecord().setComment(str);
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
        ensureStreamOpen();
        this.crc32.update(bArr, i, i2);
        this.compressedOutputStream.write(bArr, i, i2);
        this.uncompressedSizeForThisEntry += (long) i2;
    }
}
