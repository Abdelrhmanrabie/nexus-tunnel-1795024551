package com.trilead.ssh2.packets;

import com.trilead.ssh2.DHGexParameters;
import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexRequestOld {
    int n;
    byte[] payload;

    public PacketKexDhGexRequestOld(DHGexParameters dHGexParameters) {
        this.n = dHGexParameters.getPref_group_len();
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(30);
            typesWriterI.writeUINT32(this.n);
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
