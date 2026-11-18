package net.lingala.zip4j.io.inputstream;

import defpackage.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class AesCipherInputStream extends CipherInputStream<AESDecrypter> {
    private byte[] aes16ByteBlock;
    private int aes16ByteBlockPointer;
    private int aes16ByteBlockReadLength;
    private int bytesCopiedInThisIteration;
    private int lengthToCopyInThisIteration;
    private int lengthToRead;
    private int offsetWithAesBlock;
    private int remainingAes16ByteBlockLength;
    private byte[] singleByteBuffer;

    public AesCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr, int i) {
        super(zipEntryInputStream, localFileHeader, cArr, i);
        this.singleByteBuffer = new byte[1];
        this.aes16ByteBlock = new byte[16];
        this.aes16ByteBlockPointer = 0;
        this.remainingAes16ByteBlockLength = 0;
        this.lengthToRead = 0;
        this.offsetWithAesBlock = 0;
        this.bytesCopiedInThisIteration = 0;
        this.lengthToCopyInThisIteration = 0;
        this.aes16ByteBlockReadLength = 0;
    }

    private void copyBytesFromBuffer(byte[] bArr, int i) {
        int i2 = this.lengthToRead;
        int i3 = this.remainingAes16ByteBlockLength;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.lengthToCopyInThisIteration = i2;
        System.arraycopy(this.aes16ByteBlock, this.aes16ByteBlockPointer, bArr, i, i2);
        incrementAesByteBlockPointer(this.lengthToCopyInThisIteration);
        decrementRemainingAesBytesLength(this.lengthToCopyInThisIteration);
        int i4 = this.bytesCopiedInThisIteration;
        int i5 = this.lengthToCopyInThisIteration;
        this.bytesCopiedInThisIteration = i4 + i5;
        this.lengthToRead -= i5;
        this.offsetWithAesBlock += i5;
    }

    private void decrementRemainingAesBytesLength(int i) {
        int i2 = this.remainingAes16ByteBlockLength - i;
        this.remainingAes16ByteBlockLength = i2;
        if (i2 <= 0) {
            this.remainingAes16ByteBlockLength = 0;
        }
    }

    private byte[] getPasswordVerifier() {
        byte[] bArr = new byte[2];
        readRaw(bArr);
        return bArr;
    }

    private byte[] getSalt(LocalFileHeader localFileHeader) throws IOException {
        String str;
        if (localFileHeader.getAesExtraDataRecord() != null) {
            AESExtraDataRecord aesExtraDataRecord = localFileHeader.getAesExtraDataRecord();
            if (aesExtraDataRecord.getAesKeyStrength() != null) {
                byte[] bArr = new byte[aesExtraDataRecord.getAesKeyStrength().getSaltLength()];
                readRaw(bArr);
                return bArr;
            }
            str = "Invalid aes key strength in aes extra data record";
        } else {
            str = "invalid aes extra data record";
        }
        d.AnonymousClass0.m$6(str);
        return null;
    }

    private void incrementAesByteBlockPointer(int i) {
        int i2 = this.aes16ByteBlockPointer + i;
        this.aes16ByteBlockPointer = i2;
        if (i2 >= 15) {
            this.aes16ByteBlockPointer = 15;
        }
    }

    private void verifyContent(byte[] bArr) throws IOException {
        if (getLocalFileHeader().isDataDescriptorExists() && CompressionMethod.DEFLATE.equals(Zip4jUtil.getCompressionMethod(getLocalFileHeader()))) {
            return;
        }
        byte[] bArr2 = new byte[10];
        System.arraycopy(getDecrypter().getCalculatedAuthenticationBytes(), 0, bArr2, 0, 10);
        if (Arrays.equals(bArr, bArr2)) {
            return;
        }
        d.AnonymousClass0.m$6("Reached end of data for this entry, but aes verification failed");
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public void endOfEntryReached(InputStream inputStream) throws IOException {
        verifyContent(readStoredMac(inputStream));
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public AESDecrypter initializeDecrypter(LocalFileHeader localFileHeader, char[] cArr) {
        return new AESDecrypter(localFileHeader.getAesExtraDataRecord(), cArr, getSalt(localFileHeader), getPasswordVerifier());
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read() {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0];
    }

    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0049 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        this.lengthToRead = i2;
        this.offsetWithAesBlock = i;
        this.bytesCopiedInThisIteration = 0;
        if (this.remainingAes16ByteBlockLength != 0) {
            copyBytesFromBuffer(bArr, i);
            int i5 = this.bytesCopiedInThisIteration;
            if (i5 == i2) {
                return i5;
            }
        }
        if (this.lengthToRead < 16) {
            byte[] bArr2 = this.aes16ByteBlock;
            int i6 = super.read(bArr2, 0, bArr2.length);
            this.aes16ByteBlockReadLength = i6;
            this.aes16ByteBlockPointer = 0;
            if (i6 == -1) {
                this.remainingAes16ByteBlockLength = 0;
                int i7 = this.bytesCopiedInThisIteration;
                if (i7 > 0) {
                    return i7;
                }
            } else {
                this.remainingAes16ByteBlockLength = i6;
                copyBytesFromBuffer(bArr, this.offsetWithAesBlock);
                int i8 = this.bytesCopiedInThisIteration;
                if (i8 == i2) {
                    return i8;
                }
                int i9 = this.offsetWithAesBlock;
                int i10 = this.lengthToRead;
                i3 = super.read(bArr, i9, i10 - (i10 % 16));
                i4 = this.bytesCopiedInThisIteration;
                if (i3 == -1) {
                    return i3 + i4;
                }
                if (i4 > 0) {
                    return i4;
                }
            }
        } else {
            int i11 = this.offsetWithAesBlock;
            int i12 = this.lengthToRead;
            i3 = super.read(bArr, i11, i12 - (i12 % 16));
            i4 = this.bytesCopiedInThisIteration;
            if (i3 == -1) {
                return i3 + i4;
            }
            if (i4 > 0) {
                return i4;
            }
        }
        return -1;
    }

    public byte[] readStoredMac(InputStream inputStream) throws ZipException {
        byte[] bArr = new byte[10];
        if (Zip4jUtil.readFully(inputStream, bArr) == 10) {
            return bArr;
        }
        d.AnonymousClass0.m$5("Invalid AES Mac bytes. Could not read sufficient data");
        return null;
    }
}
