package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ZipStandardSplitInputStream extends SplitInputStream {
    private int lastSplitZipFileNumber;

    public ZipStandardSplitInputStream(File file, boolean z, int i) {
        super(file, z, i);
        this.lastSplitZipFileNumber = i;
    }

    @Override // net.lingala.zip4j.io.inputstream.SplitInputStream
    public File getNextSplitFile(int i) throws IOException {
        int i2 = this.lastSplitZipFileNumber;
        File file = this.zipFile;
        if (i == i2) {
            return file;
        }
        String canonicalPath = file.getCanonicalPath();
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + (i >= 9 ? ".z" : ".z0") + (i + 1));
    }
}
