package com.trilead.ssh2.compression;

import defpackage.ak;
import java.util.ArrayList;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CompressionFactory {
    private static List<CompressorEntry> compressors;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CompressorEntry {
        String compressorClass;
        String type;

        private CompressorEntry(String str, String str2) {
            this.type = str;
            this.compressorClass = str2;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        compressors = arrayList;
        arrayList.add(new CompressorEntry("zlib", "com.trilead.ssh2.compression.Zlib"));
        compressors.add(new CompressorEntry("zlib@openssh.com", "com.trilead.ssh2.compression.ZlibOpenSSH"));
        compressors.add(new CompressorEntry("none", AppConfig.CUSTOM));
    }

    private CompressionFactory() {
    }

    public static void addCompressor(String str, String str2) {
        compressors.add(new CompressorEntry(str, str2));
    }

    public static void checkCompressorList(String[] strArr) {
        for (String str : strArr) {
            getEntry(str);
        }
    }

    public static ICompressor createCompressor(String str) {
        try {
            CompressorEntry entry = getEntry(str);
            if (AppConfig.CUSTOM.equals(entry.compressorClass)) {
                return null;
            }
            return (ICompressor) Class.forName(entry.compressorClass).getConstructor(null).newInstance(null);
        } catch (Exception unused) {
            throw new IllegalArgumentException(ak.m("Cannot instantiate ", str));
        }
    }

    public static String[] getDefaultCompressorList() {
        String[] strArr = new String[compressors.size()];
        for (int i = 0; i < compressors.size(); i++) {
            strArr[i] = compressors.get(i).type;
        }
        return strArr;
    }

    private static CompressorEntry getEntry(String str) {
        for (CompressorEntry compressorEntry : compressors) {
            if (compressorEntry.type.equals(str)) {
                return compressorEntry;
            }
        }
        throw new IllegalArgumentException(ak.m("Unknown algorithm ", str));
    }
}
