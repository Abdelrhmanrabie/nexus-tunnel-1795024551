package net.lingala.zip4j.io.inputstream;

import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.model.LocalFileHeader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class NoCipherInputStream extends CipherInputStream {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NoDecrypter implements Decrypter {
        @Override // net.lingala.zip4j.crypto.Decrypter
        public int decryptData(byte[] bArr, int i, int i2) {
            return i2;
        }
    }

    public NoCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr, int i) {
        super(zipEntryInputStream, localFileHeader, cArr, i);
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public Decrypter initializeDecrypter(LocalFileHeader localFileHeader, char[] cArr) {
        return new NoDecrypter();
    }
}
