package com.trilead.ssh2.packets;

import defpackage.d;
import defpackage.e;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDHReply {
    byte[] hostKey;
    byte[] payload;
    byte[] publicKey;
    byte[] signature;

    public PacketKexDHReply(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 31) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_KEXDH_REPLY! (", ")"));
        }
        this.hostKey = typesReader.readByteString();
        this.publicKey = typesReader.readByteString();
        this.signature = typesReader.readByteString();
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("PADDING IN SSH_MSG_KEXDH_REPLY!");
        throw null;
    }

    public byte[] getF() {
        return this.publicKey;
    }

    public byte[] getHostKey() {
        return this.hostKey;
    }

    public byte[] getSignature() {
        return this.signature;
    }
}
