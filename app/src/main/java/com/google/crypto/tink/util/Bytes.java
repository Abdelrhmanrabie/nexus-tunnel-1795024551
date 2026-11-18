package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Bytes {
    public final byte[] data;

    public Bytes(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Bytes) {
            return Arrays.equals(((Bytes) obj).data, this.data);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public final String toString() {
        return "Bytes(" + Hex.encode(this.data) + ")";
    }
}
