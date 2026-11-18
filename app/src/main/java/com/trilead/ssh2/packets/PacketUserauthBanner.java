package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthBanner {
    String language;
    String message;
    byte[] payload;

    public PacketUserauthBanner(String str, String str2) {
        this.message = str;
        this.language = str2;
    }

    public PacketUserauthBanner(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 53) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_USERAUTH_BANNER! (", ")"));
        }
        this.message = typesReader.readString("UTF-8");
        this.language = typesReader.readString();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_USERAUTH_REQUEST packet!");
        throw null;
    }

    public String getBanner() {
        return this.message;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(53);
            typesWriterI.writeString(this.message);
            typesWriterI.writeString(this.language);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
