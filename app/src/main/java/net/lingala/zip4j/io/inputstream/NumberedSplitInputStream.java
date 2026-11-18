package net.lingala.zip4j.io.inputstream;

import defpackage.e;
import java.io.File;
import java.io.IOException;
import net.lingala.zip4j.util.FileUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NumberedSplitInputStream extends SplitInputStream {
    public NumberedSplitInputStream(File file, boolean z, int i) {
        super(file, z, i);
    }

    @Override // net.lingala.zip4j.io.inputstream.SplitInputStream
    public File getNextSplitFile(int i) throws IOException {
        String canonicalPath = this.zipFile.getCanonicalPath();
        StringBuilder sbD = e.d(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")));
        sbD.append(FileUtils.getNextNumberedSplitFileCounterAsExtension(i));
        return new File(sbD.toString());
    }
}
