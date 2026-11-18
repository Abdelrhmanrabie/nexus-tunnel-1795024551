package com.trilead.ssh2.crypto.dh;

import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.trilead.ssh2.auth.SignatureProxy;
import defpackage.ak;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.SecureRandom;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Curve25519Exchange extends GenericDhExchange {
    public static final String ALT_NAME = "curve25519-sha256@libssh.org";
    public static final int KEY_SIZE = 32;
    public static final String NAME = "curve25519-sha256";
    private byte[] clientPrivate;
    private byte[] clientPublic;
    private byte[] serverPublic;

    public Curve25519Exchange() {
    }

    public Curve25519Exchange(byte[] bArr) {
        if (bArr.length != 32) {
            throw new AssertionError("secret must be key size");
        }
        this.clientPrivate = (byte[]) bArr.clone();
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public byte[] getE() {
        return (byte[]) this.clientPublic.clone();
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public String getHashAlgo() {
        return SignatureProxy.SHA256;
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public byte[] getServerE() {
        return (byte[]) this.serverPublic.clone();
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public void init(String str) throws IOException {
        if (!NAME.equals(str) && !ALT_NAME.equals(str)) {
            throw new IOException(ak.m("Invalid name ", str));
        }
        byte[] bArr = new byte[32];
        ((SecureRandom) Random.localRandom.get()).nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] | 7);
        byte b = (byte) (bArr[31] & 63);
        bArr[31] = b;
        bArr[31] = (byte) (b | 128);
        this.clientPrivate = bArr;
        try {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            this.clientPublic = Hex.computeSharedSecret(bArr, bArr2);
        } catch (InvalidKeyException e) {
            throw new IOException(e);
        }
    }

    @Override // com.trilead.ssh2.crypto.dh.GenericDhExchange
    public void setF(byte[] bArr) throws IOException {
        if (bArr.length != 32) {
            throw new IOException("Server sent invalid key length " + bArr.length + " (expected 32)");
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        this.serverPublic = bArr2;
        try {
            byte[] bArrComputeSharedSecret = Hex.computeSharedSecret(this.clientPrivate, bArr2);
            int i = 0;
            for (int i2 = 0; i2 < 32; i2++) {
                i |= bArrComputeSharedSecret[i2];
            }
            if (i == 0) {
                throw new IOException("Invalid key computed; all zeroes");
            }
            this.sharedSecret = new BigInteger(1, bArrComputeSharedSecret);
        } catch (InvalidKeyException e) {
            throw new IOException(e);
        }
    }
}
