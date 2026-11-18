package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthRequestPassword {
    String password;
    byte[] payload;
    String serviceName;
    String userName;

    public PacketUserauthRequestPassword(String str, String str2, String str3) {
        this.serviceName = str;
        this.userName = str2;
        this.password = str3;
    }

    public PacketUserauthRequestPassword(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 50) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_USERAUTH_REQUEST! (", ")"));
        }
        this.userName = typesReader.readString();
        this.serviceName = typesReader.readString();
        if (!typesReader.readString().equals("password")) {
            d.AnonymousClass0.m$6("This is not a SSH_MSG_USERAUTH_REQUEST with type password!");
            throw null;
        }
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_USERAUTH_REQUEST packet!");
        throw null;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(50);
            typesWriterI.writeString(this.userName, "UTF-8");
            typesWriterI.writeString(this.serviceName);
            typesWriterI.writeString("password");
            typesWriterI.writeBoolean(false);
            typesWriterI.writeString(this.password, "UTF-8");
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
