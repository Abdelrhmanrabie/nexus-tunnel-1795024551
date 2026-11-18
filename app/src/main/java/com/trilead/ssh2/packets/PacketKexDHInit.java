package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDHInit {
    byte[] payload;
    byte[] publicKey;

    public PacketKexDHInit(byte[] bArr) {
        this.publicKey = bArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(30);
            byte[] bArr = this.publicKey;
            typesWriterI.writeString(bArr, 0, bArr.length);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
