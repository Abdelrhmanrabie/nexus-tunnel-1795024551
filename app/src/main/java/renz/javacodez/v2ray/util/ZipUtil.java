package renz.javacodez.v2ray.util;

import defpackage.be;
import defpackage.e;
import defpackage.ge;
import defpackage.ug;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ZipUtil {
    private static final int BUFFER_SIZE = 4096;
    public static final ZipUtil INSTANCE = new ZipUtil();

    private ZipUtil() {
    }

    private final void extractFile(InputStream inputStream, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                bufferedOutputStream.close();
                return;
            }
            bufferedOutputStream.write(bArr, 0, i);
        }
    }

    public final boolean unzipToFolder(File file, String str) {
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                for (ZipEntry zipEntry : new ug(new ge(5, new be(zipFile.entries())))) {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    try {
                        String str2 = str + File.separator + zipEntry.getName();
                        if (zipEntry.isDirectory()) {
                            new File(str2).mkdir();
                        } else {
                            INSTANCE.extractFile(inputStream, str2);
                        }
                        e.F0(inputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            e.F0(inputStream, th);
                            throw th2;
                        }
                    }
                }
                zipFile.close();
                return true;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    e.F0(zipFile, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean zipFromFolder(String str, String str2) {
        File[] fileArrListFiles;
        byte[] bArr = new byte[4096];
        try {
            if (str.length() != 0 && str2.length() != 0) {
                ArrayList<String> arrayList = new ArrayList();
                File file = new File(str);
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isFile()) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                    for (String str3 : arrayList) {
                        zipOutputStream.putNextEntry(new ZipEntry(new File(str3).getName()));
                        FileInputStream fileInputStream = new FileInputStream(str3);
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i > 0) {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                        fileInputStream.close();
                    }
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
