package com.trilead.ssh2;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SFTPv3FileHandle {
    final SFTPv3Client client;
    final byte[] fileHandle;
    boolean isClosed = false;

    public SFTPv3FileHandle(SFTPv3Client sFTPv3Client, byte[] bArr) {
        this.client = sFTPv3Client;
        this.fileHandle = bArr;
    }

    public SFTPv3Client getClient() {
        return this.client;
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}
