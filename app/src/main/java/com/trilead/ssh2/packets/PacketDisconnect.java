package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketDisconnect {
    String desc;
    String lang;
    byte[] payload;
    int reason;

    public PacketDisconnect(int i, String str, String str2) {
        this.reason = i;
        this.desc = str;
        this.lang = str2;
    }

    public PacketDisconnect(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 1) {
            throw new IOException(e.i(i3, "This is not a Disconnect Packet! (", ")"));
        }
        this.reason = typesReader.readUINT32();
        this.desc = typesReader.readString();
        this.lang = typesReader.readString();
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(1);
            typesWriterI.writeUINT32(this.reason);
            typesWriterI.writeString(this.desc);
            typesWriterI.writeString(this.lang);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
