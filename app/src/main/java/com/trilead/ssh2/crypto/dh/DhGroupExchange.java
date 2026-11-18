package com.trilead.ssh2.crypto.dh;

import com.trilead.ssh2.DHGexParameters;
import com.trilead.ssh2.crypto.digest.HashForSSH2Types;
import defpackage.d;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DhGroupExchange {
    private BigInteger e;
    private BigInteger f;
    private BigInteger g;
    private BigInteger k;
    private BigInteger p;
    private BigInteger x;

    public DhGroupExchange(BigInteger bigInteger, BigInteger bigInteger2) {
        this.p = bigInteger;
        this.g = bigInteger2;
    }

    public byte[] calculateH(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, DHGexParameters dHGexParameters) {
        HashForSSH2Types hashForSSH2Types = new HashForSSH2Types(str);
        hashForSSH2Types.updateByteString(bArr);
        hashForSSH2Types.updateByteString(bArr2);
        hashForSSH2Types.updateByteString(bArr3);
        hashForSSH2Types.updateByteString(bArr4);
        hashForSSH2Types.updateByteString(bArr5);
        if (dHGexParameters.getMin_group_len() > 0) {
            hashForSSH2Types.updateUINT32(dHGexParameters.getMin_group_len());
        }
        hashForSSH2Types.updateUINT32(dHGexParameters.getPref_group_len());
        if (dHGexParameters.getMax_group_len() > 0) {
            hashForSSH2Types.updateUINT32(dHGexParameters.getMax_group_len());
        }
        hashForSSH2Types.updateBigInt(this.p);
        hashForSSH2Types.updateBigInt(this.g);
        hashForSSH2Types.updateBigInt(this.e);
        hashForSSH2Types.updateBigInt(this.f);
        hashForSSH2Types.updateBigInt(this.k);
        return hashForSSH2Types.getDigest();
    }

    public BigInteger getE() {
        BigInteger bigInteger = this.e;
        if (bigInteger != null) {
            return bigInteger;
        }
        d.AnonymousClass0.m("Not initialized!");
        return null;
    }

    public BigInteger getK() {
        BigInteger bigInteger = this.k;
        if (bigInteger != null) {
            return bigInteger;
        }
        d.AnonymousClass0.m("Shared secret not yet known, need f first!");
        return null;
    }

    public void init(SecureRandom secureRandom) {
        this.k = null;
        BigInteger bigInteger = new BigInteger(this.p.bitLength() - 1, secureRandom);
        this.x = bigInteger;
        this.e = this.g.modPow(bigInteger, this.p);
    }

    public void setF(BigInteger bigInteger) {
        if (this.e == null) {
            d.AnonymousClass0.m("Not initialized!");
        } else if (BigInteger.valueOf(0L).compareTo(bigInteger) >= 0 || this.p.compareTo(bigInteger) <= 0) {
            d.AnonymousClass0.m$2("Invalid f specified!");
        } else {
            this.f = bigInteger;
            this.k = bigInteger.modPow(this.x, this.p);
        }
    }
}
