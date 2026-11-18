package com.trilead.ssh2.crypto.digest;

import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MACs {
    private static final String[] MAC_LIST = {"hmac-sha2-256-etm@openssh.com", "hmac-sha2-512-etm@openssh.com", "hmac-sha1-etm@openssh.com", "hmac-sha2-256", "hmac-sha2-512", "hmac-sha1"};

    public static final void checkMacList(String[] strArr) {
        for (String str : strArr) {
            getKeyLen(str);
        }
    }

    public static final int getKeyLen(String str) {
        if (str == null) {
            d.AnonymousClass0.m$2("type == null");
            return 0;
        }
        if (str.startsWith("hmac-sha1")) {
            return 20;
        }
        if (str.startsWith("hmac-md5")) {
            return 16;
        }
        if (str.startsWith("hmac-sha2-256")) {
            return 32;
        }
        if (str.startsWith("hmac-sha2-512")) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown algorithm ".concat(str));
    }

    public static final String[] getMacList() {
        return MAC_LIST;
    }
}
