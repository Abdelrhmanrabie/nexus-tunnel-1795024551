package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.e;
import java.io.IOException;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketIgnore {
    byte[] data;
    byte[] payload;

    public PacketIgnore() {
    }

    public PacketIgnore(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        int i3 = new TypesReader(bArr, i, i2).readByte();
        if (i3 != 2) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_IGNORE packet! (", ")"));
        }
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(2);
            byte[] bArr = this.data;
            if (bArr != null) {
                typesWriterI.writeString(bArr, 0, bArr.length);
            } else {
                typesWriterI.writeString(AppConfig.CUSTOM);
            }
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
        this.payload = null;
    }
}
