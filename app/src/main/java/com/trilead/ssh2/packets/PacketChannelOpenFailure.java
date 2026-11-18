package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelOpenFailure {
    public String description;
    public String languageTag;
    byte[] payload;
    public int reasonCode;
    public int recipientChannelID;

    public PacketChannelOpenFailure(int i, int i2, String str, String str2) {
        this.recipientChannelID = i;
        this.reasonCode = i2;
        this.description = str;
        this.languageTag = str2;
    }

    public PacketChannelOpenFailure(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 92) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_CHANNEL_OPEN_FAILURE! (", ")"));
        }
        this.recipientChannelID = typesReader.readUINT32();
        this.reasonCode = typesReader.readUINT32();
        this.description = typesReader.readString();
        this.languageTag = typesReader.readString();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_CHANNEL_OPEN_FAILURE packet!");
        throw null;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(92);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeUINT32(this.reasonCode);
            typesWriterI.writeString(this.description);
            typesWriterI.writeString(this.languageTag);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
