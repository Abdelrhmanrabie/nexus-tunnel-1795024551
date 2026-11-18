package com.trilead.ssh2.packets;

import defpackage.ak;
import java.math.BigInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexInit {
    BigInteger e;
    byte[] payload;

    public PacketKexDhGexInit(BigInteger bigInteger) {
        this.e = bigInteger;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(32);
            typesWriterI.writeMPInt(this.e);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
