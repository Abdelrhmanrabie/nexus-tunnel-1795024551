package com.google.zxing.common;

import com.android.volley.toolbox.HurlStack;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class DecoderResult {
    public final List byteSegments;
    public final String ecLevel;
    public HurlStack other;
    public final int structuredAppendParity;
    public final int structuredAppendSequenceNumber;
    public final String text;

    public DecoderResult(byte[] bArr, String str, ArrayList arrayList, String str2, int i, int i2) {
        this.text = str;
        this.byteSegments = arrayList;
        this.ecLevel = str2;
        this.structuredAppendParity = i2;
        this.structuredAppendSequenceNumber = i;
    }
}
