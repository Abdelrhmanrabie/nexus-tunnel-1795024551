package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionSubsystemRequest {
    byte[] payload;
    public int recipientChannelID;
    public String subsystem;
    public boolean wantReply;

    public PacketSessionSubsystemRequest(int i, boolean z, String str) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.subsystem = str;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("subsystem");
            typesWriterI.writeBoolean(this.wantReply);
            typesWriterI.writeString(this.subsystem);
            byte[] bytes = typesWriterI.getBytes();
            this.payload = bytes;
            typesWriterI.getBytes(bytes);
        }
        return this.payload;
    }
}
