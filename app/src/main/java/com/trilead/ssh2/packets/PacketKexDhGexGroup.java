package com.trilead.ssh2.packets;

import defpackage.d;
import defpackage.e;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexGroup {
    BigInteger g;
    BigInteger p;
    byte[] payload;

    public PacketKexDhGexGroup(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 31) {
            throw new IllegalArgumentException(e.i(i3, "This is not a SSH_MSG_KEX_DH_GEX_GROUP! (", ")"));
        }
        this.p = typesReader.readMPINT();
        this.g = typesReader.readMPINT();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("PADDING IN SSH_MSG_KEX_DH_GEX_GROUP!");
        throw null;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }
}
