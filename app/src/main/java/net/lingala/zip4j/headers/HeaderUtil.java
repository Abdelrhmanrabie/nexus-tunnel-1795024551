package net.lingala.zip4j.headers;

import defpackage.ak;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HeaderUtil {
    public static String decodeStringWithCharset(byte[] bArr, boolean z, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        return z ? new String(bArr, InternalZipConstants.CHARSET_UTF_8) : new String(bArr, InternalZipConstants.ZIP4J_DEFAULT_CHARSET);
    }

    public static byte[] getBytesFromString(String str, Charset charset) {
        return charset == null ? str.getBytes(InternalZipConstants.ZIP4J_DEFAULT_CHARSET) : str.getBytes(charset);
    }

    public static FileHeader getFileHeader(ZipModel zipModel, String str) throws ZipException {
        FileHeader fileHeaderWithExactMatch = getFileHeaderWithExactMatch(zipModel, str);
        if (fileHeaderWithExactMatch != null) {
            return fileHeaderWithExactMatch;
        }
        String strReplaceAll = str.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
        FileHeader fileHeaderWithExactMatch2 = getFileHeaderWithExactMatch(zipModel, strReplaceAll);
        return fileHeaderWithExactMatch2 == null ? getFileHeaderWithExactMatch(zipModel, strReplaceAll.replaceAll(InternalZipConstants.ZIP_FILE_SEPARATOR, "\\\\")) : fileHeaderWithExactMatch2;
    }

    private static FileHeader getFileHeaderWithExactMatch(ZipModel zipModel, String str) throws ZipException {
        if (zipModel == null) {
            throw new ZipException(ak.m("zip model is null, cannot determine file header with exact match for fileName: ", str));
        }
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException(ak.m("file name is null, cannot determine file header with exact match for fileName: ", str));
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new ZipException(ak.m("central directory is null, cannot determine file header with exact match for fileName: ", str));
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException(ak.m("file Headers are null, cannot determine file header with exact match for fileName: ", str));
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() == 0) {
            return null;
        }
        for (FileHeader fileHeader : zipModel.getCentralDirectory().getFileHeaders()) {
            String fileName = fileHeader.getFileName();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(fileName) && str.equalsIgnoreCase(fileName)) {
                return fileHeader;
            }
        }
        return null;
    }

    public static List<FileHeader> getFileHeadersUnderDirectory(List<FileHeader> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (FileHeader fileHeader : list) {
            if (fileHeader.getFileName().startsWith(str)) {
                arrayList.add(fileHeader);
            }
        }
        return arrayList;
    }

    public static long getOffsetStartOfCentralDirectory(ZipModel zipModel) {
        return zipModel.isZip64Format() ? zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() : zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
    }

    public static long getTotalUncompressedSizeOfAllFileHeaders(List<FileHeader> list) {
        long uncompressedSize = 0;
        for (FileHeader fileHeader : list) {
            uncompressedSize += (fileHeader.getZip64ExtendedInfo() == null || fileHeader.getZip64ExtendedInfo().getUncompressedSize() <= 0) ? fileHeader.getUncompressedSize() : fileHeader.getZip64ExtendedInfo().getUncompressedSize();
        }
        return uncompressedSize;
    }
}
