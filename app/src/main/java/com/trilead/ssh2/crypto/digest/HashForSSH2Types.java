package com.trilead.ssh2.crypto.digest;

import defpackage.ak;
import defpackage.d;
import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HashForSSH2Types {
    MessageDigest md;

    public HashForSSH2Types(String str) {
        try {
            this.md = MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException(ak.m("Unsupported algorithm ", str));
        }
    }

    public void getDigest(byte[] bArr) {
        getDigest(bArr, 0);
    }

    public void getDigest(byte[] bArr, int i) {
        try {
            this.md.digest(bArr, i, bArr.length - i);
        } catch (DigestException e) {
            d.AnonymousClass0.m$1("Unable to digest", (Throwable) e);
        }
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.md.getDigestLength()];
        getDigest(bArr);
        return bArr;
    }

    public int getDigestLength() {
        return this.md.getDigestLength();
    }

    public void reset() {
        this.md.reset();
    }

    public void updateBigInt(BigInteger bigInteger) {
        updateByteString(bigInteger.toByteArray());
    }

    public void updateByte(byte b) {
        this.md.update(new byte[]{b});
    }

    public void updateByteString(byte[] bArr) {
        updateUINT32(bArr.length);
        updateBytes(bArr);
    }

    public void updateBytes(byte[] bArr) {
        this.md.update(bArr);
    }

    public void updateUINT32(int i) {
        this.md.update((byte) (i >> 24));
        this.md.update((byte) (i >> 16));
        this.md.update((byte) (i >> 8));
        this.md.update((byte) i);
    }
}
