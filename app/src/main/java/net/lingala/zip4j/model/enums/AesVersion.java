package net.lingala.zip4j.model.enums;

import defpackage.d;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum AesVersion {
    ONE(1),
    TWO(2);

    private int versionNumber;

    AesVersion(int i) {
        this.versionNumber = i;
    }

    public static AesVersion getFromVersionNumber(int i) throws ZipException {
        for (AesVersion aesVersion : values()) {
            if (aesVersion.versionNumber == i) {
                return aesVersion;
            }
        }
        d.AnonymousClass0.m$5("Unsupported Aes version");
        return null;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }
}
