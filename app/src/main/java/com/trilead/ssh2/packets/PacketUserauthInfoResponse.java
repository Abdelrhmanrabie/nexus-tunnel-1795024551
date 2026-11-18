package com.trilead.ssh2.packets;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthInfoResponse {
    byte[] payload;
    String[] responses;

    public PacketUserauthInfoResponse(String[] strArr) {
        this.responses = strArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(61);
            typesWriterI.writeUINT32(this.responses.length);
            int i = 0;
            while (true) {
                String[] strArr = this.responses;
                if (i >= strArr.length) {
                    break;
                }
                typesWriterI.writeString(strArr[i]);
                i++;
            }
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
