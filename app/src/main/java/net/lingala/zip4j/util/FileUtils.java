package net.lingala.zip4j.util;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ExcludeFileFilter;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    public static final byte[] DEFAULT_POSIX_FILE_ATTRIBUTES = {0, 0, -92, -127};
    public static final byte[] DEFAULT_POSIX_FOLDER_ATTRIBUTES = {0, 0, -19, 65};

    private static void addIfBitSet(byte b, int i, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (BitUtils.isBitSet(b, i)) {
            set.add(posixFilePermission);
        }
    }

    private static void applyPosixFileAttributes(Path path, byte[] bArr) {
        if (bArr[2] == 0 && bArr[3] == 0) {
            return;
        }
        try {
            HashSet hashSet = new HashSet();
            addIfBitSet(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
            addIfBitSet(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
            addIfBitSet(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
            addIfBitSet(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
            addIfBitSet(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
            addIfBitSet(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
            addIfBitSet(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
            addIfBitSet(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
            addIfBitSet(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(path, hashSet);
        } catch (IOException unused) {
        }
    }

    private static void applyWindowsFileAttributes(Path path, byte[] bArr) {
        if (bArr[0] == 0) {
            return;
        }
        DosFileAttributeView dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        try {
            dosFileAttributeView.setReadOnly(BitUtils.isBitSet(bArr[0], 0));
            dosFileAttributeView.setHidden(BitUtils.isBitSet(bArr[0], 1));
            dosFileAttributeView.setSystem(BitUtils.isBitSet(bArr[0], 2));
            dosFileAttributeView.setArchive(BitUtils.isBitSet(bArr[0], 5));
        } catch (IOException unused) {
        }
    }

    private static void assertFileExists(File file) throws ZipException {
        if (file.exists()) {
            return;
        }
        throw new ZipException("File does not exist: " + file);
    }

    public static void assertFilesExist(List<File> list, ZipParameters.SymbolicLinkAction symbolicLinkAction) throws ZipException {
        for (File file : list) {
            if (!isSymbolicLink(file)) {
                assertFileExists(file);
            } else if (symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE) || symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY)) {
                assertSymbolicLinkTargetExists(file);
            }
        }
    }

    private static void assertSymbolicLinkTargetExists(File file) throws ZipException {
        if (file.exists()) {
            return;
        }
        throw new ZipException("Symlink target '" + readSymbolicLink(file) + "' does not exist for link '" + file + "'");
    }

    public static void copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor, int i) throws ZipException {
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            d.AnonymousClass0.m$5("invalid offsets");
            return;
        }
        if (j == j2) {
            return;
        }
        try {
            randomAccessFile.seek(j);
            long j4 = j2 - j;
            byte[] bArr = j4 < ((long) i) ? new byte[(int) j4] : new byte[i];
            while (true) {
                int i2 = randomAccessFile.read(bArr);
                if (i2 == -1) {
                    return;
                }
                outputStream.write(bArr, 0, i2);
                long j5 = i2;
                progressMonitor.updateWorkCompleted(j5);
                if (progressMonitor.isCancelAllTasks()) {
                    progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
                    return;
                }
                j3 += j5;
                if (j3 == j4) {
                    return;
                }
                if (((long) bArr.length) + j3 > j4) {
                    bArr = new byte[(int) (j4 - j3)];
                }
            }
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    public static File[] getAllSortedNumberedSplitFiles(File file) {
        final String fileNameWithoutExtension = getFileNameWithoutExtension(file.getName());
        File[] fileArrListFiles = file.getParentFile().listFiles(new FilenameFilter() { // from class: net.lingala.zip4j.util.FileUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.startsWith(fileNameWithoutExtension + ".");
            }
        });
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    public static byte[] getDefaultFileAttributes(boolean z) {
        byte[] bArr = new byte[4];
        if (!isUnix() && !isMac()) {
            if (isWindows() && z) {
                bArr[0] = BitUtils.setBit(bArr[0], 4);
            }
            return bArr;
        }
        if (z) {
            System.arraycopy(DEFAULT_POSIX_FOLDER_ATTRIBUTES, 0, bArr, 0, 4);
            return bArr;
        }
        System.arraycopy(DEFAULT_POSIX_FILE_ATTRIBUTES, 0, bArr, 0, 4);
        return bArr;
    }

    private static String getExtensionZerosPrefix(int i) {
        if (i < 9) {
            return "00";
        }
        return i < 99 ? "0" : AppConfig.CUSTOM;
    }

    public static byte[] getFileAttributes(File file) {
        if (file != null) {
            try {
                if (Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    Path path = file.toPath();
                    if (isWindows()) {
                        return getWindowsFileAttributes(path);
                    }
                    if (isMac() || isUnix()) {
                        return getPosixFileAttributes(path);
                    }
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        return !name.contains(".") ? AppConfig.CUSTOM : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String getFileNameWithoutExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public static List<File> getFilesInDirectoryRecursive(File file, boolean z, boolean z2) {
        return getFilesInDirectoryRecursive(file, z, z2, null);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:33:0x004b A[SYNTHETIC] */
    public static List<File> getFilesInDirectoryRecursive(File file, boolean z, boolean z2, ExcludeFileFilter excludeFileFilter) throws ZipException {
        if (file == null) {
            d.AnonymousClass0.m$5("input path is null, cannot read files in the directory");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && file.canRead() && fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (excludeFileFilter == null || !excludeFileFilter.isExcluded(file2)) {
                    if (!file2.isHidden()) {
                        arrayList.add(file2);
                        if (file2.isDirectory()) {
                            arrayList.addAll(getFilesInDirectoryRecursive(file2, z, z2, excludeFileFilter));
                        }
                    } else if (file2.isDirectory()) {
                        if (z2) {
                            arrayList.add(file2);
                            if (file2.isDirectory()) {
                                arrayList.addAll(getFilesInDirectoryRecursive(file2, z, z2, excludeFileFilter));
                            }
                        }
                    } else if (z) {
                        arrayList.add(file2);
                        if (file2.isDirectory()) {
                            arrayList.addAll(getFilesInDirectoryRecursive(file2, z, z2, excludeFileFilter));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String getNameOfFileInZip(File file, String str) {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            return str;
        }
        return isSymbolicLink(file) ? file.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).getFileName().toString() : file.getName();
    }

    public static String getNextNumberedSplitFileCounterAsExtension(int i) {
        return "." + getExtensionZerosPrefix(i) + (i + 1);
    }

    private static byte[] getPosixFileAttributes(Path path) {
        byte[] bArr = new byte[4];
        try {
            Set<PosixFilePermission> setPermissions = ((PosixFileAttributeView) Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes().permissions();
            bArr[3] = setBitIfApplicable(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
            bArr[3] = setBitIfApplicable(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            bArr[3] = setBitIfApplicable(Files.isSymbolicLink(path), bArr[3], 5);
            bArr[3] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = setBitIfApplicable(setPermissions.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:34:0x011e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0143  */
    /* JADX WARN: Code duplicated, block: B:39:0x014f  */
    /* JADX WARN: Code duplicated, block: B:42:0x015c A[RETURN] */
    public static String getRelativeFileName(File file, ZipParameters zipParameters) throws ZipException {
        String nameOfFileInZip;
        StringBuilder sb;
        String rootFolderNameInZip;
        String string;
        String strSubstring;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getDefaultFolderPath())) {
                File file2 = new File(canonicalPath);
                nameOfFileInZip = getNameOfFileInZip(file2, zipParameters.getFileNameInZip());
                if (file2.isDirectory()) {
                    sb = new StringBuilder();
                }
                rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
                if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                    if (!rootFolderNameInZip.endsWith("\\")) {
                        StringBuilder sbD = e.d(rootFolderNameInZip);
                        sbD.append(InternalZipConstants.FILE_SEPARATOR);
                        rootFolderNameInZip = sbD.toString();
                    }
                    rootFolderNameInZip = rootFolderNameInZip.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
                    nameOfFileInZip = ak.j(rootFolderNameInZip, nameOfFileInZip);
                }
                if (Zip4jUtil.isStringNotNullAndNotEmpty(nameOfFileInZip)) {
                    return nameOfFileInZip;
                }
                StringBuilder sbQ = ak.q("fileName to add to zip is empty or null. fileName: '", nameOfFileInZip, "' DefaultFolderPath: '");
                sbQ.append(zipParameters.getDefaultFolderPath());
                sbQ.append("' FileNameInZip: ");
                sbQ.append(zipParameters.getFileNameInZip());
                string = sbQ.toString();
                if (isSymbolicLink(file)) {
                    string = ak.j(string, "isSymlink: true ");
                }
                if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                    string = e.n("rootFolderNameInZip: '", rootFolderNameInZip, "' ");
                }
                d.AnonymousClass0.m$5(string);
                return null;
            }
            String canonicalPath2 = new File(zipParameters.getDefaultFolderPath()).getCanonicalPath();
            String str = InternalZipConstants.FILE_SEPARATOR;
            if (!canonicalPath2.endsWith(str)) {
                canonicalPath2 = canonicalPath2 + str;
            }
            if (isSymbolicLink(file)) {
                strSubstring = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
            } else {
                strSubstring = canonicalPath.substring(canonicalPath2.length());
            }
            if (strSubstring.startsWith(System.getProperty("file.separator"))) {
                strSubstring = strSubstring.substring(1);
            }
            File file3 = new File(canonicalPath);
            if (file3.isDirectory()) {
                nameOfFileInZip = strSubstring.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb = new StringBuilder();
            } else {
                String strReplaceAll = strSubstring.substring(0, strSubstring.lastIndexOf(file3.getName())).replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb = new StringBuilder();
                sb.append(strReplaceAll);
                sb.append(getNameOfFileInZip(file3, zipParameters.getFileNameInZip()));
            }
            nameOfFileInZip = sb.toString();
            rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                if (!rootFolderNameInZip.endsWith("\\") && !rootFolderNameInZip.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    StringBuilder sbD2 = e.d(rootFolderNameInZip);
                    sbD2.append(InternalZipConstants.FILE_SEPARATOR);
                    rootFolderNameInZip = sbD2.toString();
                }
                rootFolderNameInZip = rootFolderNameInZip.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
                nameOfFileInZip = ak.j(rootFolderNameInZip, nameOfFileInZip);
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(nameOfFileInZip)) {
                return nameOfFileInZip;
            }
            StringBuilder sbQ2 = ak.q("fileName to add to zip is empty or null. fileName: '", nameOfFileInZip, "' DefaultFolderPath: '");
            sbQ2.append(zipParameters.getDefaultFolderPath());
            sbQ2.append("' FileNameInZip: ");
            sbQ2.append(zipParameters.getFileNameInZip());
            string = sbQ2.toString();
            if (isSymbolicLink(file)) {
                string = ak.j(string, "isSymlink: true ");
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                string = e.n("rootFolderNameInZip: '", rootFolderNameInZip, "' ");
            }
            d.AnonymousClass0.m$5(string);
            return null;
            sb.append(nameOfFileInZip);
            sb.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
            nameOfFileInZip = sb.toString();
            rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                if (!rootFolderNameInZip.endsWith("\\")) {
                    StringBuilder sbD3 = e.d(rootFolderNameInZip);
                    sbD3.append(InternalZipConstants.FILE_SEPARATOR);
                    rootFolderNameInZip = sbD3.toString();
                }
                rootFolderNameInZip = rootFolderNameInZip.replaceAll("\\\\", InternalZipConstants.ZIP_FILE_SEPARATOR);
                nameOfFileInZip = ak.j(rootFolderNameInZip, nameOfFileInZip);
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(nameOfFileInZip)) {
                return nameOfFileInZip;
            }
            StringBuilder sbQ3 = ak.q("fileName to add to zip is empty or null. fileName: '", nameOfFileInZip, "' DefaultFolderPath: '");
            sbQ3.append(zipParameters.getDefaultFolderPath());
            sbQ3.append("' FileNameInZip: ");
            sbQ3.append(zipParameters.getFileNameInZip());
            string = sbQ3.toString();
            if (isSymbolicLink(file)) {
                string = ak.j(string, "isSymlink: true ");
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                string = e.n("rootFolderNameInZip: '", rootFolderNameInZip, "' ");
            }
            d.AnonymousClass0.m$5(string);
            return null;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    public static List<File> getSplitZipFiles(ZipModel zipModel) throws ZipException {
        String str;
        if (zipModel == null) {
            str = "cannot get split zip files: zipmodel is null";
        } else {
            if (zipModel.getEndOfCentralDirectoryRecord() == null) {
                return null;
            }
            if (zipModel.getZipFile().exists()) {
                ArrayList arrayList = new ArrayList();
                File zipFile = zipModel.getZipFile();
                if (!zipModel.isSplitArchive()) {
                    arrayList.add(zipFile);
                    return arrayList;
                }
                int numberOfThisDisk = zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
                if (numberOfThisDisk == 0) {
                    arrayList.add(zipFile);
                    return arrayList;
                }
                int i = 0;
                while (i <= numberOfThisDisk) {
                    if (i == numberOfThisDisk) {
                        arrayList.add(zipModel.getZipFile());
                    } else {
                        StringBuilder sbO = ak.o(zipFile.getName().contains(".") ? zipFile.getPath().substring(0, zipFile.getPath().lastIndexOf(".")) : zipFile.getPath(), i >= 9 ? ".z" : ".z0");
                        sbO.append(i + 1);
                        arrayList.add(new File(sbO.toString()));
                    }
                    i++;
                }
                return arrayList;
            }
            str = "zip file does not exist";
        }
        d.AnonymousClass0.m$5(str);
        return null;
    }

    private static byte[] getWindowsFileAttributes(Path path) {
        byte[] bArr = new byte[4];
        try {
            DosFileAttributes attributes = ((DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes();
            bArr[0] = setBitIfApplicable(attributes.isArchive(), setBitIfApplicable(attributes.isDirectory(), setBitIfApplicable(attributes.isSystem(), setBitIfApplicable(attributes.isHidden(), setBitIfApplicable(attributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String getZipFileNameWithoutExtension(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            d.AnonymousClass0.m$5("zip file name is empty or null, cannot determine zip file name");
            return null;
        }
        if (str.contains(System.getProperty("file.separator"))) {
            str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
        }
        return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isNumberedSplitFile(File file) {
        return file.getName().endsWith(InternalZipConstants.SEVEN_ZIP_SPLIT_FILE_EXTENSION_PATTERN);
    }

    public static boolean isSymbolicLink(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isZipEntryDirectory(String str) {
        return str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || str.endsWith("\\");
    }

    public static String readSymbolicLink(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return AppConfig.CUSTOM;
        }
    }

    private static byte setBitIfApplicable(boolean z, byte b, int i) {
        return z ? BitUtils.setBit(b, i) : b;
    }

    public static void setFileAttributes(Path path, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (isWindows()) {
            applyWindowsFileAttributes(path, bArr);
        } else if (isMac() || isUnix()) {
            applyPosixFileAttributes(path, bArr);
        }
    }

    public static void setFileLastModifiedTime(Path path, long j) {
        if (j <= 0 || !Files.exists(path, new LinkOption[0])) {
            return;
        }
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(Zip4jUtil.dosToExtendedEpochTme(j)));
        } catch (Exception unused) {
        }
    }

    public static void setFileLastModifiedTimeWithoutNio(File file, long j) {
        file.setLastModified(Zip4jUtil.dosToExtendedEpochTme(j));
    }
}
