package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelTrileadPing {
    byte[] payload;
    public int recipientChannelID;

    public PacketChannelTrileadPing(int i) {
        this.recipientChannelID = i;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("trilead-ping");
            typesWriterI.writeBoolean(true);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
