package net.lingala.zip4j.io.outputstream;

import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.model.ZipParameters;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class NoCipherOutputStream extends CipherOutputStream<NoEncrypter> {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class NoEncrypter implements Encrypter {
        @Override // net.lingala.zip4j.crypto.Encrypter
        public int encryptData(byte[] bArr) {
            return encryptData(bArr, 0, bArr.length);
        }

        @Override // net.lingala.zip4j.crypto.Encrypter
        public int encryptData(byte[] bArr, int i, int i2) {
            return i2;
        }
    }

    public NoCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) {
        super(zipEntryOutputStream, zipParameters, cArr);
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public NoEncrypter initializeEncrypter(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) {
        return new NoEncrypter();
    }
}
