package com.trilead.ssh2.crypto.digest;

import defpackage.ak;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class HMAC implements MAC {
    private static final String ETM_SUFFIX = "-etm@openssh.com";
    static final String HMAC_MD5 = "hmac-md5";
    static final String HMAC_MD5_96 = "hmac-md5-96";
    static final String HMAC_SHA1 = "hmac-sha1";
    static final String HMAC_SHA1_96 = "hmac-sha1-96";
    static final String HMAC_SHA1_ETM = "hmac-sha1-etm@openssh.com";
    static final String HMAC_SHA2_256 = "hmac-sha2-256";
    static final String HMAC_SHA2_256_ETM = "hmac-sha2-256-etm@openssh.com";
    static final String HMAC_SHA2_512 = "hmac-sha2-512";
    static final String HMAC_SHA2_512_ETM = "hmac-sha2-512-etm@openssh.com";
    private final byte[] buffer;
    private final boolean encryptThenMac;
    private final Mac mac;
    private final int outSize;

    public HMAC(String str, byte[] bArr) {
        Mac mac;
        try {
            boolean zEquals = HMAC_SHA1.equals(str);
            String str2 = InternalZipConstants.AES_MAC_ALGORITHM;
            if (zEquals || HMAC_SHA1_96.equals(str)) {
                mac = Mac.getInstance(str2);
                this.mac = mac;
                this.encryptThenMac = false;
            } else {
                if (!HMAC_SHA1_ETM.equals(str)) {
                    if (HMAC_MD5.equals(str) || HMAC_MD5_96.equals(str)) {
                        mac = Mac.getInstance("HmacMD5");
                    } else {
                        str2 = "HmacSHA256";
                        if (!HMAC_SHA2_256.equals(str)) {
                            if (!HMAC_SHA2_256_ETM.equals(str)) {
                                str2 = "HmacSHA512";
                                if (!HMAC_SHA2_512.equals(str)) {
                                    if (!HMAC_SHA2_512_ETM.equals(str)) {
                                        throw new IllegalArgumentException("Unknown algorithm " + str);
                                    }
                                }
                            }
                        }
                        mac = Mac.getInstance(str2);
                    }
                    this.mac = mac;
                    this.encryptThenMac = false;
                }
                this.mac = Mac.getInstance(str2);
                this.encryptThenMac = true;
            }
            int macLength = this.mac.getMacLength();
            if (str.endsWith("-96")) {
                this.outSize = 12;
                this.buffer = new byte[macLength];
            } else {
                this.outSize = macLength;
                this.buffer = null;
            }
            try {
                this.mac.init(new SecretKeySpec(bArr, str));
            } catch (InvalidKeyException e) {
                throw new IllegalArgumentException(e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(ak.m("Unknown algorithm ", str), e2);
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public final void getMac(byte[] bArr, int i) {
        try {
            byte[] bArr2 = this.buffer;
            Mac mac = this.mac;
            if (bArr2 == null) {
                mac.doFinal(bArr, i);
            } else {
                mac.doFinal(bArr2, 0);
                System.arraycopy(this.buffer, 0, bArr, i, bArr.length - i);
            }
        } catch (ShortBufferException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public final void initMac(int i) {
        this.mac.reset();
        this.mac.update((byte) (i >> 24));
        this.mac.update((byte) (i >> 16));
        this.mac.update((byte) (i >> 8));
        this.mac.update((byte) i);
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public boolean isEncryptThenMac() {
        return this.encryptThenMac;
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public final int size() {
        return this.outSize;
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public final void update(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}
