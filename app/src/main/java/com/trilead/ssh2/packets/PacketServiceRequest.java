package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketServiceRequest {
    byte[] payload;
    String serviceName;

    public PacketServiceRequest(String str) {
        this.serviceName = str;
    }

    public PacketServiceRequest(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 5) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_SERVICE_REQUEST! (", ")"));
        }
        this.serviceName = typesReader.readString();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_SERVICE_REQUEST packet!");
        throw null;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(5);
            typesWriterI.writeString(this.serviceName);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
