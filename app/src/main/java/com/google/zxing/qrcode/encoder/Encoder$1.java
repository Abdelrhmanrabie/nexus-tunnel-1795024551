package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Encoder$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

    static {
        int[] iArr = new int[Mode.values().length];
        $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
        try {
            iArr[1] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            int[] iArr2 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode;
            Mode[] modeArr = Mode.$VALUES;
            iArr2[2] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            int[] iArr3 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode;
            Mode[] modeArr2 = Mode.$VALUES;
            iArr3[4] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            int[] iArr4 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode;
            Mode[] modeArr3 = Mode.$VALUES;
            iArr4[6] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
