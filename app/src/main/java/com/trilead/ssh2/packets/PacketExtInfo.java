package com.trilead.ssh2.packets;

import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PacketExtInfo {
    private final Map<String, String> extNameToValue;
    private byte[] payload;

    public PacketExtInfo(Map<String, String> map) {
        this.extNameToValue = Collections.unmodifiableMap(new HashMap(map));
    }

    public PacketExtInfo(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 7) {
            throw new IOException(e.i(i3, "This is not a SSH_MSG_EXT_INFO! (", ")"));
        }
        int uint32 = typesReader.readUINT32();
        HashMap map = new HashMap(uint32);
        for (int i4 = 0; i4 < uint32; i4++) {
            map.put(typesReader.readString(), typesReader.readString());
        }
        this.extNameToValue = Collections.unmodifiableMap(map);
        if (typesReader.remain() == 0) {
            return;
        }
        d.AnonymousClass0.m$6("Padding in SSH_MSG_EXT_INFO packet!");
        throw null;
    }

    public Map<String, String> getExtNameToValue() {
        return this.extNameToValue;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterI = ak.i(7);
            typesWriterI.writeUINT32(this.extNameToValue.size());
            for (Map.Entry<String, String> entry : this.extNameToValue.entrySet()) {
                typesWriterI.writeString(entry.getKey());
                typesWriterI.writeString(entry.getValue());
            }
            this.payload = typesWriterI.getBytes();
        }
        return this.payload;
    }
}
