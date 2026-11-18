package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionStartShell {
    byte[] payload;
    public int recipientChannelID;
    public boolean wantReply;

    public PacketSessionStartShell(int i, boolean z) {
        this.recipientChannelID = i;
        this.wantReply = z;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("shell");
            typesWriterI.writeBoolean(this.wantReply);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
