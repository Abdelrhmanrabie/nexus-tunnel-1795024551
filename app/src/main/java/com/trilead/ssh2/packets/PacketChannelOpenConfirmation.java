package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelOpenConfirmation {
    public int initialWindowSize;
    public int maxPacketSize;
    byte[] payload;
    public int recipientChannelID;
    public int senderChannelID;

    public PacketChannelOpenConfirmation(int i, int i2, int i3, int i4) {
        this.recipientChannelID = i;
        this.senderChannelID = i2;
        this.initialWindowSize = i3;
        this.maxPacketSize = i4;
    }

    public PacketChannelOpenConfirmation(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 91) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_CHANNEL_OPEN_CONFIRMATION! (", ")"));
        }
        this.recipientChannelID = typesReader.readUINT32();
        this.senderChannelID = typesReader.readUINT32();
        this.initialWindowSize = typesReader.readUINT32();
        this.maxPacketSize = typesReader.readUINT32();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_CHANNEL_OPEN_CONFIRMATION packet!");
        throw null;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(91);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeUINT32(this.senderChannelID);
            typesWriterI.writeUINT32(this.initialWindowSize);
            typesWriterI.writeUINT32(this.maxPacketSize);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
