package net.lingala.zip4j.crypto;

import com.jcraft.jzlib.GZIPHeader;
import defpackage.d;
import java.security.SecureRandom;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class StandardEncrypter implements Encrypter {
    private byte[] headerBytes;
    private final ZipCryptoEngine zipCryptoEngine = new ZipCryptoEngine();

    public StandardEncrypter(char[] cArr, long j) throws ZipException {
        init(cArr, j);
    }

    private void init(char[] cArr, long j) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            d.AnonymousClass0.m$5("input password is null or empty, cannot initialize standard encrypter");
            return;
        }
        this.zipCryptoEngine.initKeys(cArr);
        this.headerBytes = generateRandomBytes();
        this.zipCryptoEngine.initKeys(cArr);
        byte[] bArr = this.headerBytes;
        bArr[11] = (byte) (j >>> 24);
        bArr[10] = (byte) (j >>> 16);
        encryptData(bArr);
    }

    public byte encryptByte(byte b) {
        byte bDecryptByte = (byte) ((this.zipCryptoEngine.decryptByte() & GZIPHeader.OS_UNKNOWN) ^ b);
        this.zipCryptoEngine.updateKeys(b);
        return bDecryptByte;
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr) {
        bArr.getClass();
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 < 0) {
            d.AnonymousClass0.m$5("invalid length specified to decrpyt data");
            return 0;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            bArr[i3] = encryptByte(bArr[i3]);
        }
        return i2;
    }

    public byte[] generateRandomBytes() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 12; i++) {
            bArr[i] = encryptByte((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}
