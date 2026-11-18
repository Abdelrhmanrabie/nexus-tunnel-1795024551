package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionPtyResize {
    public int height;
    byte[] payload;
    public int pixelHeight;
    public int pixelWidth;
    public int recipientChannelID;
    public int width;

    public PacketSessionPtyResize(int i, int i2, int i3, int i4, int i5) {
        this.recipientChannelID = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidth = i4;
        this.pixelHeight = i5;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("window-change");
            typesWriterI.writeBoolean(false);
            typesWriterI.writeUINT32(this.width);
            typesWriterI.writeUINT32(this.height);
            typesWriterI.writeUINT32(this.pixelWidth);
            typesWriterI.writeUINT32(this.pixelHeight);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
