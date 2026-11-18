package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionX11Request {
    byte[] payload;
    public int recipientChannelID;
    public boolean singleConnection;
    public boolean wantReply;
    String x11AuthenticationCookie;
    String x11AuthenticationProtocol;
    int x11ScreenNumber;

    public PacketSessionX11Request(int i, boolean z, boolean z2, String str, String str2, int i2) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.singleConnection = z2;
        this.x11AuthenticationProtocol = str;
        this.x11AuthenticationCookie = str2;
        this.x11ScreenNumber = i2;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(98);
            typesWriterI.writeUINT32(this.recipientChannelID);
            typesWriterI.writeString("x11-req");
            typesWriterI.writeBoolean(this.wantReply);
            typesWriterI.writeBoolean(this.singleConnection);
            typesWriterI.writeString(this.x11AuthenticationProtocol);
            typesWriterI.writeString(this.x11AuthenticationCookie);
            typesWriterI.writeUINT32(this.x11ScreenNumber);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
