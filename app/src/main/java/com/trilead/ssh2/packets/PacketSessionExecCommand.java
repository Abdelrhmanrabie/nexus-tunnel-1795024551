package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionExecCommand {
    public String command;
    byte[] payload;
    public int recipientChannelID;
    public boolean wantReply;

    public PacketSessionExecCommand(int i, boolean z, String str) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.command = str;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("exec");
            typesWriterI.writeBoolean(this.wantReply);
            typesWriterI.writeString(this.command);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
