package com.trilead.ssh2.auth;

import defpackage.d;
import java.security.PublicKey;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class SignatureProxy {
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private PublicKey mPublicKey;

    public SignatureProxy(PublicKey publicKey) {
        if (publicKey != null) {
            this.mPublicKey = publicKey;
        } else {
            d.AnonymousClass0.m$2("Public key must not be null");
            throw null;
        }
    }

    public PublicKey getPublicKey() {
        return this.mPublicKey;
    }

    public abstract byte[] sign(byte[] bArr, String str);
}
