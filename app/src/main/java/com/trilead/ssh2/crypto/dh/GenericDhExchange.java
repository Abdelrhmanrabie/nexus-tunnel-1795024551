package com.trilead.ssh2.crypto.dh;

import com.trilead.ssh2.crypto.digest.HashForSSH2Types;
import com.trilead.ssh2.log.Logger;
import defpackage.d;
import java.math.BigInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class GenericDhExchange {
    private static final Logger log = Logger.getLogger(GenericDhExchange.class);
    BigInteger sharedSecret;

    public static GenericDhExchange getInstance(String str) {
        if (Curve25519Exchange.NAME.equals(str) || Curve25519Exchange.ALT_NAME.equals(str)) {
            return new Curve25519Exchange();
        }
        return str.startsWith("ecdh-sha2-") ? new EcDhExchange() : new DhExchange();
    }

    public byte[] calculateH(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        HashForSSH2Types hashForSSH2Types = new HashForSSH2Types(getHashAlgo());
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(90, "Client: '" + new String(bArr) + "'");
            logger.log(90, "Server: '" + new String(bArr2) + "'");
        }
        hashForSSH2Types.updateByteString(bArr);
        hashForSSH2Types.updateByteString(bArr2);
        hashForSSH2Types.updateByteString(bArr3);
        hashForSSH2Types.updateByteString(bArr4);
        hashForSSH2Types.updateByteString(bArr5);
        hashForSSH2Types.updateByteString(getE());
        hashForSSH2Types.updateByteString(getServerE());
        hashForSSH2Types.updateBigInt(this.sharedSecret);
        return hashForSSH2Types.getDigest();
    }

    public abstract byte[] getE();

    public abstract String getHashAlgo();

    public BigInteger getK() {
        BigInteger bigInteger = this.sharedSecret;
        if (bigInteger != null) {
            return bigInteger;
        }
        d.AnonymousClass0.m("Shared secret not yet known, need f first!");
        return null;
    }

    public abstract byte[] getServerE();

    public abstract void init(String str);

    public abstract void setF(byte[] bArr);
}
