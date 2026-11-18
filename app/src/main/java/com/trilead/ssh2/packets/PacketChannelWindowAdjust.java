package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelWindowAdjust {
    byte[] payload;
    public int recipientChannelID;
    public int windowChange;

    public PacketChannelWindowAdjust(int i, int i2) {
        this.recipientChannelID = i;
        this.windowChange = i2;
    }

    public PacketChannelWindowAdjust(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 93) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_CHANNEL_WINDOW_ADJUST! (", ")"));
        }
        this.recipientChannelID = typesReader.readUINT32();
        this.windowChange = typesReader.readUINT32();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_CHANNEL_WINDOW_ADJUST packet!");
        throw null;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(93);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeUINT32(this.windowChange);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
