package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthRequestPublicKey {
    String password;
    byte[] payload;
    byte[] pk;
    String pkAlgoName;
    String serviceName;
    byte[] sig;
    String userName;

    public PacketUserauthRequestPublicKey(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        this.serviceName = str;
        this.userName = str2;
        this.pkAlgoName = str3;
        this.pk = bArr;
        this.sig = bArr2;
    }

    public PacketUserauthRequestPublicKey(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        int i3 = new TypesReader(bArr, i, i2).readByte();
        if (i3 == 50) {
            throw new IOException("Not implemented!");
        }
        throw new IOException(e.i(i3, "This is not a SSH_MSG_USERAUTH_REQUEST! (", ")"));
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(50);
            typesWriterI.writeString(this.userName, "UTF-8");
            typesWriterI.writeString(this.serviceName);
            typesWriterI.writeString("publickey");
            typesWriterI.writeBoolean(true);
            typesWriterI.writeString(this.pkAlgoName);
            byte[] bArr = this.pk;
            typesWriterI.writeString(bArr, 0, bArr.length);
            byte[] bArr2 = this.sig;
            typesWriterI.writeString(bArr2, 0, bArr2.length);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
