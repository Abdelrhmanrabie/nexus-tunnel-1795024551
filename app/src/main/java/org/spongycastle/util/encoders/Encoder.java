package org.spongycastle.util.encoders;

import java.io.OutputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface Encoder {
    int decode(String str, OutputStream outputStream);

    int decode(byte[] bArr, int i, int i2, OutputStream outputStream);

    int encode(byte[] bArr, int i, int i2, OutputStream outputStream);
}
