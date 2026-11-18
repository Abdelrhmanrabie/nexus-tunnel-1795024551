package com.trilead.ssh2.packets;

import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthFailure {
    String[] authThatCanContinue;
    boolean partialSuccess;
    byte[] payload;

    public PacketUserauthFailure(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 51) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_USERAUTH_FAILURE! (", ")"));
        }
        this.authThatCanContinue = typesReader.readNameList();
        this.partialSuccess = typesReader.readBoolean();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_USERAUTH_FAILURE packet!");
        throw null;
    }

    public PacketUserauthFailure(String[] strArr, boolean z) {
        this.authThatCanContinue = strArr;
        this.partialSuccess = z;
    }

    public String[] getAuthThatCanContinue() {
        return this.authThatCanContinue;
    }

    public boolean isPartialSuccess() {
        return this.partialSuccess;
    }
}
